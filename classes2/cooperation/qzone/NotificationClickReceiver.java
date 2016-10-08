package cooperation.qzone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NotificationClickReceiver
  extends BroadcastReceiver
{
  public static final String a = "realIntent";
  private static final String[] a = { "com.tencent.mobileqq.activity.SplashActivity", "com.tencent.mobileqq.activity.NearbyActivity", "com.tencent.mobileqq.activity.ChatActivity" };
  public static final String b = "hostuin";
  public static final String c = "pushschema";
  public static final String d = "pushstatkey";
  public static final String e = "mergenum";
  public static final String f = "pushReport";
  public static final String g = "isNeedBackToFriendFeed";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a()
  {
    List localList = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningTasks(100);
    int i;
    boolean bool2;
    int j;
    if ((localList != null) && (localList.size() > 0))
    {
      int k = localList.size();
      i = 0;
      boolean bool1 = false;
      bool2 = bool1;
      if (i >= k) {
        break label179;
      }
      String str = ((ActivityManager.RunningTaskInfo)localList.get(i)).topActivity.getClassName();
      QLog.i("pushReport", 4, "---------" + i + ":topActivity:" + str + " --baseActivity:" + ((ActivityManager.RunningTaskInfo)localList.get(i)).baseActivity.getClassName());
      String[] arrayOfString = a;
      int m = arrayOfString.length;
      j = 0;
      label139:
      if (j >= m) {
        break label208;
      }
      if (str.equals(arrayOfString[j])) {
        bool1 = true;
      }
    }
    label179:
    label208:
    for (;;)
    {
      i += 1;
      break;
      j += 1;
      break label139;
      bool2 = false;
      QLog.i("pushReport", 4, "---------isNeedToJumpFriendFeed1" + bool2);
      return bool2;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = (Intent)paramIntent.getParcelableExtra("realIntent");
    ((Intent)localObject).setExtrasClassLoader(getClass().getClassLoader());
    String str1 = ((Intent)localObject).getStringExtra("qzone_plugin_activity_name");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals("com.qzone.detail.ui.activity.QzoneDetailActivity"))) {
      ((Intent)localObject).putExtra("isNeedBackToFriendFeed", a());
    }
    paramContext.startActivity((Intent)localObject);
    try
    {
      localObject = paramIntent.getStringExtra("hostuin");
      str1 = paramIntent.getStringExtra("pushschema");
      String str2 = paramIntent.getStringExtra("pushstatkey");
      QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
      paramIntent = "";
      paramContext = paramIntent;
      Uri localUri;
      if (str1 != null)
      {
        if (str1.startsWith("mqzone://arouse/livevideo"))
        {
          paramContext = new QZoneClickReport.ReportInfo();
          paramContext.c = String.valueOf(322);
          paramContext.d = String.valueOf(3);
          paramContext.e = String.valueOf(7);
          QZoneClickReport.report((String)localObject, paramContext, true);
          CliNotifyPush.a.clear();
        }
        localUri = Uri.parse(str1);
        if (!TextUtils.isEmpty(localUri.getQueryParameter("from"))) {
          break label305;
        }
        paramContext = paramIntent;
        if (localUri.getPathSegments().size() <= 0) {}
      }
      label305:
      for (paramContext = (String)localUri.getPathSegments().get(0);; paramContext = localUri.getQueryParameter("from"))
      {
        localReportInfo.c = "3";
        localReportInfo.d = "0";
        localReportInfo.b = 1;
        localReportInfo.e = paramContext;
        localReportInfo.j = str2;
        QZoneClickReport.report((String)localObject, localReportInfo, true);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("pushReport", 2, "CLICK: uin: " + (String)localObject + " schema: " + str1 + " pushstatkey: " + str2);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("NotificationClickReceiver", 1, paramContext.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\NotificationClickReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */