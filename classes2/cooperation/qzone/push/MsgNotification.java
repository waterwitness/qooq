package cooperation.qzone.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.NotificationClickReceiver;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.model.MapParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MsgNotification
{
  public static final int a = 0;
  private static MsgNotification a;
  public static final int b = 1;
  public static final int c = 2;
  
  private MsgNotification()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.c(paramQQAppInterface.a());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("vipReminderFlag", true);
    return localIntent;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.a(), TranslucentActivity.class);
    paramQQAppInterface.addFlags(268435456);
    if (paramIntent != null) {
      paramQQAppInterface.putExtras(paramIntent);
    }
    return paramQQAppInterface;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.a(paramQQAppInterface, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramQQAppInterface.putExtra("qqid", Long.parseLong(paramString));
    paramQQAppInterface.putExtra("qzone_entry", 0);
    return paramQQAppInterface;
  }
  
  private Intent a(String paramString)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localUri = Uri.parse(paramString);
        localBundle.putString("cellid", localUri.getQueryParameter("uid"));
        localObject = localUri.getQueryParameter("subid");
        if (paramString.contains("photonum"))
        {
          localHashMap = new HashMap();
          localHashMap.put(Integer.valueOf(7), localUri.getQueryParameter("photonum"));
          if (Integer.valueOf(localUri.getQueryParameter("photonum")).intValue() <= 1) {
            continue;
          }
          str = localUri.getQueryParameter("bid");
          localObject = str;
          if (paramString.contains("bid"))
          {
            localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
            localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
            localObject = str;
          }
          localBundle.putParcelable("businessparam", new MapParcelable(localHashMap));
        }
        localBundle.putString("subid", (String)localObject);
        localBundle.putLong("targetuin", Long.parseLong(localUri.getQueryParameter("uin")));
        localBundle.putInt("appid", Integer.parseInt(localUri.getQueryParameter("appid")));
      }
      catch (Exception paramString)
      {
        Uri localUri;
        Object localObject;
        HashMap localHashMap;
        String str;
        QLog.e("MsgNotification", 1, "getQZoneDetailIntent", paramString);
        continue;
      }
      paramString = QZoneHelper.a();
      paramString.putExtras(localBundle);
      return paramString;
      str = "";
      localObject = str;
      if (paramString.contains("bid"))
      {
        localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
        localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
        localObject = str;
      }
    }
  }
  
  public static MsgNotification a()
  {
    if (a == null) {
      a = new MsgNotification();
    }
    return a;
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {
      paramQQAppInterface.r();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    String str2 = "";
    String str1 = str2;
    Uri localUri;
    if (paramString1 != null)
    {
      localUri = Uri.parse(paramString1);
      if (!TextUtils.isEmpty(localUri.getQueryParameter("from"))) {
        break label172;
      }
      str1 = str2;
      if (localUri.getPathSegments().size() <= 0) {}
    }
    label172:
    for (str1 = (String)localUri.getPathSegments().get(0);; str1 = localUri.getQueryParameter("from"))
    {
      localReportInfo.c = "2";
      localReportInfo.d = "0";
      localReportInfo.b = 1;
      localReportInfo.e = str1;
      localReportInfo.j = paramString2;
      QZoneClickReport.startReportImediately(paramQQAppInterface.getAccount(), localReportInfo);
      if (QLog.isColorLevel()) {
        QLog.d("pushReport", 2, "EXPOSE: uin: " + paramQQAppInterface.getAccount() + " schema: " + paramString1 + " pushstatkey: " + paramString2);
      }
      return;
    }
  }
  
  private Intent b(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.b(paramQQAppInterface.a());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("src_type", "app");
    localIntent.putExtra("isFromQQ", "true");
    localIntent.putExtra("page", "tab_remind");
    localIntent.putExtra("version", "1");
    return localIntent;
  }
  
  private Intent b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.a(), QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramQQAppInterface.putExtra("injectrecommend", true);
    paramQQAppInterface.setData(Uri.parse(paramString));
    return paramQQAppInterface;
  }
  
  private Intent c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.a(paramQQAppInterface, "com.qzone.web.QZoneTranslucentActivity");
    paramQQAppInterface.setAction("action_js2qzone");
    paramQQAppInterface.putExtra("cmd", "Schema");
    paramQQAppInterface.putExtra("schema", paramString);
    return paramQQAppInterface;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, boolean paramBoolean1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean2)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramInt1, paramQQAppInterface);
    Notification localNotification = new Notification(2130842440, paramString1, System.currentTimeMillis());
    localNotification.flags = 16;
    Object localObject2 = (QZoneManagerImp)paramQQAppInterface.getManager(9);
    Object localObject1;
    int i;
    switch (paramInt2)
    {
    default: 
      localObject1 = null;
      i = 0;
      paramInt1 = 1;
    }
    for (;;)
    {
      label104:
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(paramQQAppInterface.a(), NotificationClickReceiver.class);
      ((Intent)localObject2).putExtra("realIntent", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("hostuin", paramQQAppInterface.getAccount());
      ((Intent)localObject2).putExtra("pushschema", paramString2);
      ((Intent)localObject2).putExtra("pushstatkey", paramString3);
      localObject1 = PendingIntent.getBroadcast(paramQQAppInterface.a(), i, (Intent)localObject2, 134217728);
      if (paramBoolean1) {
        if ((paramInt2 == 2) || (paramInt2 == 8) || (paramInt2 == 4)) {
          localNotification.setLatestEventInfo(paramQQAppInterface.a(), BaseApplication.getContext().getString(2131368346), paramString1, (PendingIntent)localObject1);
        }
      }
      for (;;)
      {
        paramString1 = (NotificationManager)paramQQAppInterface.a().getSystemService("notification");
        if ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 300))
        {
          localObject1 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
          ((Intent)localObject1).putExtra("pushstatkey", paramString3);
          ((Intent)localObject1).putExtra("mergenum", paramInt1);
          ((Intent)localObject1).putExtra("pushtype", paramInt2);
          localNotification.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.a(), i, (Intent)localObject1, 134217728);
        }
        paramString1.notify(i, localNotification);
        if (paramQQAppInterface != null)
        {
          QZoneHelper.a(paramQQAppInterface, getClass().getSimpleName());
          if (GuardManager.a != null) {
            GuardManager.a.b(0, null);
          }
        }
        if (!paramBoolean2) {
          break;
        }
        a(paramQQAppInterface, paramString2, paramString3);
        return;
        localObject1 = b(paramQQAppInterface);
        ((Intent)localObject1).putExtra("launch_time", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("refer", "msg_notification");
        localObject1 = a(paramQQAppInterface, (Intent)localObject1);
        i = 120;
        if (localObject2 == null) {
          break label895;
        }
        paramInt1 = ((QZoneManagerImp)localObject2).a(1);
        ((QZoneManagerImp)localObject2).a(1, paramInt1);
        break label104;
        localObject1 = a(paramQQAppInterface, a(paramString2));
        i = 143;
        paramInt1 = 1;
        break label104;
        for (;;)
        {
          try
          {
            localObject2 = c(paramQQAppInterface, paramString2);
            localObject1 = localObject2;
          }
          catch (Exception localException1)
          {
            try
            {
              localObject2 = a(paramQQAppInterface, (Intent)localObject2);
              if (paramBoolean2)
              {
                localObject1 = localObject2;
                localObject3 = new QZoneClickReport.ReportInfo();
                localObject1 = localObject2;
                ((QZoneClickReport.ReportInfo)localObject3).c = String.valueOf(322);
                localObject1 = localObject2;
                ((QZoneClickReport.ReportInfo)localObject3).d = String.valueOf(2);
                localObject1 = localObject2;
                ((QZoneClickReport.ReportInfo)localObject3).e = String.valueOf(6);
                localObject1 = localObject2;
                QZoneClickReport.report(paramQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject3, true);
              }
              localObject1 = localObject2;
              Object localObject3 = new QzNotificationStruct(Uri.parse(paramString2).getQueryParameter("room"), paramString1, paramBoolean1, paramInt2, paramString2, paramString3);
              localObject1 = localObject2;
              if (CliNotifyPush.a == null)
              {
                localObject1 = localObject2;
                CliNotifyPush.a = Collections.synchronizedList(new ArrayList());
              }
              if (paramBoolean2)
              {
                localObject1 = localObject2;
                CliNotifyPush.a.add(localObject3);
              }
              localObject1 = localObject2;
              i = 141;
              paramInt1 = 1;
            }
            catch (Exception localException4)
            {
              for (;;) {}
            }
            localException1 = localException1;
            localObject1 = null;
          }
          QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_SPECIAL2 error", localException1);
        }
        if ((paramString2 != null) && (paramString2.startsWith("mqzonev2://arouse/openhomepage"))) {}
        for (;;)
        {
          try
          {
            localObject1 = a(paramQQAppInterface, Uri.parse(paramString2).getQueryParameter("uin"));
          }
          catch (Exception localException2)
          {
            try
            {
              Intent localIntent = a(paramQQAppInterface, (Intent)localObject1);
              localObject1 = localIntent;
              i = 142;
              paramInt1 = 1;
            }
            catch (Exception localException3)
            {
              for (;;) {}
            }
            localException2 = localException2;
            localObject1 = null;
          }
          QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_SCHEMA error", localException2);
          continue;
          localObject1 = a(paramQQAppInterface, c(paramQQAppInterface, paramString2));
        }
        localNotification.setLatestEventInfo(paramQQAppInterface.a(), BaseApplication.getContext().getString(2131368346) + "(" + BaseApplication.getContext().getString(2131367985) + paramInt1 + BaseApplication.getContext().getString(2131367986) + BaseApplication.getContext().getString(2131369037) + ")", paramString1, (PendingIntent)localObject1);
        continue;
        localNotification.setLatestEventInfo(paramQQAppInterface.a(), BaseApplication.getContext().getString(2131368346), paramString1, (PendingIntent)localObject1);
      }
      label895:
      paramInt1 = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\push\MsgNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */