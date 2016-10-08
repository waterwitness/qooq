package com.tencent.mobileqq.servlet;

import QzoneCombine.PushInfo;
import QzoneCombine.SingleMsg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.model.SinglePushMsg;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import com.tencent.upload.common.UploadConfiguration;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.push.MsgNotification;
import cooperation.qzone.push.QzNotificationStruct;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import upk;
import upl;

public class CliNotifyPush
  extends MSFServlet
  implements WebEventListener
{
  private static final int A = 2013;
  private static final int B = 2014;
  public static final int a = 1;
  public static final String a = "MessageSvc.WNSQzone.Push";
  public static HashMap a;
  public static List a;
  public static volatile boolean a = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static final int b = 2;
  public static final String b = "Qzone_Get_UndealCount_FLAG";
  public static final int c = 4;
  private static final String c = "CliNotifyPush";
  public static final int d = 301;
  private static final String d = "CliNotifySvc.SvcReqPush";
  public static final int e = 8;
  private static final String e = "MessageSvc.WNSQzone";
  public static final int f = 300;
  private static final String f = "QZONE_PUSH_ST";
  public static final int g = 10000;
  private static final String g = "qzonenewservice.callqzonev2";
  public static int h = 0;
  public static int i = 0;
  private static final int j = 1;
  private static final int k = 0;
  private static final int l = 10000;
  private static final int m = 3001;
  private static final int n = 2000;
  private static final int o = 2001;
  private static final int p = 2002;
  private static final int q = 2003;
  private static final int r = 2004;
  private static final int s = 2005;
  private static final int t = 2006;
  private static final int u = 2007;
  private static final int v = 2008;
  private static final int w = 2009;
  private static final int x = 2010;
  private static final int y = 2011;
  private static final int z = 2012;
  private int C;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new upl(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new upk(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ArrayList b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "baseSdk.Msf.NotifyResp", "CliNotifySvc.SvcReqPush", "MessageSvc.WNSQzone" };
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.a().getSharedPreferences("QZONE_PUSH_ST", 0);
      paramQQAppInterface = paramQQAppInterface.getAccount();
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        if (paramQQAppInterface.length() > 0) {
          l1 = localSharedPreferences.getLong(paramQQAppInterface + "", 0L);
        }
      }
    }
    return l1;
  }
  
  private String a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      SinglePushMsg localSinglePushMsg;
      JSONObject localJSONObject;
      if (paramArrayList.hasNext())
      {
        localSinglePushMsg = (SinglePushMsg)paramArrayList.next();
        if ((localSinglePushMsg != null) && (localSinglePushMsg.jdField_a_of_type_JavaUtilMap != null)) {
          localJSONObject = new JSONObject();
        }
      }
      else
      {
        try
        {
          localJSONObject.put("addTime", localSinglePushMsg.jdField_a_of_type_Long);
          localJSONObject.put("opUin", localSinglePushMsg.jdField_b_of_type_Long);
          Iterator localIterator = localSinglePushMsg.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, localSinglePushMsg.jdField_a_of_type_JavaUtilMap.get(str));
          }
          localJSONArray.put(localJSONObject);
        }
        catch (Exception localException) {}
        return localJSONArray.toString();
      }
    }
  }
  
  private void a()
  {
    QLog.e("CliNotifyPush", 1, "show()");
    ArrayList localArrayList;
    if ((this.b != null) && (this.b.size() > 0))
    {
      localArrayList = (ArrayList)this.b.clone();
      this.b.clear();
    }
    for (;;)
    {
      Iterator localIterator;
      if (jdField_a_of_type_Boolean)
      {
        QLog.e("CliNotifyPush", 1, "call qzone timeout, show in qq");
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            b((SinglePushMsg)localIterator.next());
          }
        }
        if (localArrayList != null)
        {
          localIterator = localArrayList.iterator();
          while (localIterator.hasNext()) {
            b((SinglePushMsg)localIterator.next());
          }
        }
        this.C = 2010;
        i += 1;
      }
      for (;;)
      {
        a(this.C);
        jdField_a_of_type_Boolean = false;
        if (((this.C == 0) || (this.C == 10000)) && (localArrayList != null)) {
          a(localArrayList, (QQAppInterface)getAppRuntime());
        }
        return;
        if ((this.C == 0) || (this.C == 10000))
        {
          QLog.e("CliNotifyPush", 1, "call qzone success, show in qzone");
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              SinglePushMsg localSinglePushMsg = (SinglePushMsg)localIterator.next();
              a(localSinglePushMsg, (QQAppInterface)getAppRuntime(), 2L);
              a(localSinglePushMsg, true);
              a(localSinglePushMsg);
            }
          }
        }
        else
        {
          QLog.e("CliNotifyPush", 1, "call qzone failed, show in qq");
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              b((SinglePushMsg)localIterator.next());
            }
          }
          if (localArrayList != null)
          {
            localIterator = localArrayList.iterator();
            while (localIterator.hasNext()) {
              b((SinglePushMsg)localIterator.next());
            }
          }
        }
      }
      localArrayList = null;
    }
  }
  
  private void a(int paramInt)
  {
    QLog.e("CliNotifyPush", 1, "report resultCode:" + paramInt);
    b(paramInt);
    QZoneHelper.a((QQAppInterface)getAppRuntime(), "qzonenewservice.callqzonev2", paramInt, "CliNotifyPush", 1, System.currentTimeMillis());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("QZONE_PUSH_ST", 0).edit();
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        localEditor.putLong(paramQQAppInterface, paramLong);
      }
      localEditor.commit();
    }
  }
  
  private void a(SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "dispathQzonePushMsg()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {}
    while ((paramSinglePushMsg == null) || (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    Object localObject;
    if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) && (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("utime") != null) && (LocalMultiProcConfig.a("qzone_preget_passive_open", 0, localQQAppInterface.getLongAccountUin()) == 1))
    {
      localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("utime");
      if (!LocalMultiProcConfig.a("qzone_passive_undealtime", "", localQQAppInterface.getLongAccountUin()).equals(localObject))
      {
        paramSinglePushMsg.jdField_a_of_type_Boolean = true;
        int i1 = RemoteHandleManager.a().a().a(localQQAppInterface.getLongAccountUin());
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i1), paramSinglePushMsg);
      }
    }
    if (a(localQQAppInterface, paramSinglePushMsg))
    {
      if (jdField_a_of_type_Boolean)
      {
        if (this.b == null) {
          this.b = new ArrayList();
        }
        this.b.add(paramSinglePushMsg);
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramSinglePushMsg);
      a((ArrayList)localObject, localQQAppInterface);
      return;
    }
    b(paramSinglePushMsg);
  }
  
  public static void a(SinglePushMsg paramSinglePushMsg, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramSinglePushMsg == null) {
      return;
    }
    if (paramQQAppInterface != null) {}
    for (long l1 = Long.parseLong(paramQQAppInterface.getAccount());; l1 = 0L)
    {
      long l2 = paramLong;
      NewIntent localNewIntent;
      if (paramSinglePushMsg.jdField_a_of_type_Long != 0L)
      {
        l2 = paramLong;
        if (l1 != 0L)
        {
          localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), QZonePushAckServlet.class);
          localNewIntent.putExtra("timestamp", paramSinglePushMsg.jdField_a_of_type_Long);
          localNewIntent.putExtra("hostuin", l1);
          if (!paramSinglePushMsg.jdField_b_of_type_Boolean) {
            break label175;
          }
        }
      }
      label175:
      for (paramLong = 1L | paramLong;; paramLong = 0xFFFFFFFFFFFFFFFE & paramLong)
      {
        localNewIntent.putExtra("mark", paramSinglePushMsg.jdField_a_of_type_JavaLangString);
        localNewIntent.putExtra("flag", paramLong);
        paramQQAppInterface.startServlet(localNewIntent);
        l2 = paramLong;
        QLog.e("CliNotifyPush", 1, "sentQzoneMsfPushAck: localTimeStamp=" + paramSinglePushMsg.jdField_a_of_type_Long + " uin=" + l1 + " flag=" + l2);
        return;
      }
    }
  }
  
  private void a(SinglePushMsg paramSinglePushMsg, boolean paramBoolean)
  {
    if ((paramSinglePushMsg == null) || (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap == null)) {
      QLog.e("CliNotifyPush", 1, "showRedTouch failed sm=null");
    }
    Object localObject;
    QZoneManagerImp localQZoneManagerImp;
    do
    {
      return;
      localObject = (QQAppInterface)getAppRuntime();
      if (localObject == null)
      {
        QLog.e("CliNotifyPush", 1, "showRedTouch failed app=null");
        return;
      }
      localQZoneManagerImp = (QZoneManagerImp)((QQAppInterface)localObject).getManager(9);
    } while (localQZoneManagerImp == null);
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
        if (!QLog.isColorLevel()) {
          break label213;
        }
        QLog.d("CliNotifyPush", 2, "showRedTouch type:" + i1 + ",uin:" + paramSinglePushMsg.jdField_b_of_type_Long + ",isBackground_Pause:" + ((QQAppInterface)localObject).isBackground_Pause);
      }
      catch (Exception paramSinglePushMsg)
      {
        long l1;
        QLog.e("CliNotifyPush", 1, "showRedTouch failed");
        return;
      }
      localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent");
      int i1 = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count"));
      l1 = paramSinglePushMsg.jdField_b_of_type_Long;
      localQZoneManagerImp.a(1, i1, l1, (String)localObject, paramBoolean, true);
      return;
      label213:
      if (i1 != 1) {
        if (i1 != 300) {
          break;
        }
      }
    }
  }
  
  private void a(ArrayList paramArrayList, QQAppInterface paramQQAppInterface)
  {
    QLog.e("CliNotifyPush", 1, "callQZone()");
    Object localObject = a(paramArrayList);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("CliNotifyPush", 1, "call qzone param error");
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((SinglePushMsg)paramArrayList.next());
      }
    }
    try
    {
      jdField_a_of_type_Boolean = true;
      QLog.e("CliNotifyPush", 1, "calling qzone, the msg is: " + (String)localObject);
      UploadConfiguration.checkVaildConnection(paramQQAppInterface.a(), Long.valueOf(paramQQAppInterface.getLongAccountUin()), (String)localObject);
      localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SinglePushMsg)((Iterator)localObject).next()).a(true);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      jdField_a_of_type_Boolean = false;
      QLog.e("CliNotifyPush", 1, paramQQAppInterface, new Object[] { "call qzone param error" });
      a(2009);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((SinglePushMsg)paramArrayList.next());
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      if (jdField_a_of_type_Boolean) {
        paramQQAppInterface.a(CliNotifyPush.class).postDelayed(this.jdField_a_of_type_JavaLangRunnable, QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromPushTimeout", 20000));
      }
      a(2007);
    }
  }
  
  private void a(Map paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    try
    {
      QZoneDistributedAppCtrl.Control localControl = new QZoneDistributedAppCtrl.Control();
      localControl.jdField_a_of_type_Int = Integer.parseInt((String)paramMap.get("key_ctrl_cmd"));
      localControl.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
      QZoneDistributedAppCtrl.a(paramString).a(localControl);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 10000) {}
    do
    {
      return false;
      if ((8 == paramInt) || (4 == paramInt)) {
        return true;
      }
      if (paramInt == 2) {
        return true;
      }
    } while ((paramInt != 1) && (paramInt != 300));
    return LocalMultiProcConfig.a(paramQQAppInterface.a().getApplicationContext().getString(2131368470) + paramQQAppInterface.getAccount(), true);
  }
  
  private boolean a(SinglePushMsg paramSinglePushMsg)
  {
    boolean bool = false;
    int i1 = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    Object localObject;
    QzNotificationStruct localQzNotificationStruct;
    if (i1 == 301) {
      if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("live_roomid");
        if (localObject != null)
        {
          localQzNotificationStruct = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
          if ((localQzNotificationStruct == null) || (!((String)localObject).equals(localQzNotificationStruct.jdField_a_of_type_JavaLangString))) {
            break label229;
          }
          jdField_a_of_type_JavaUtilList.remove(localQzNotificationStruct);
          if (jdField_a_of_type_JavaUtilList.size() != 0) {
            break label171;
          }
          ((NotificationManager)localQQAppInterface.getApplication().getSystemService("notification")).cancel(141);
        }
      }
    }
    for (;;)
    {
      a(paramSinglePushMsg, localQQAppInterface, 16L);
      bool = true;
      return bool;
      label171:
      localObject = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (localObject != null)
      {
        MsgNotification.a().a(localQQAppInterface, 0, ((QzNotificationStruct)localObject).b, ((QzNotificationStruct)localObject).jdField_a_of_type_Boolean, ((QzNotificationStruct)localObject).jdField_a_of_type_Int, ((QzNotificationStruct)localObject).c, ((QzNotificationStruct)localObject).d, false);
        continue;
        label229:
        if (jdField_a_of_type_JavaUtilList.size() > 1)
        {
          i1 = 0;
          while (i1 < jdField_a_of_type_JavaUtilList.size() - 1)
          {
            localQzNotificationStruct = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(i1);
            if ((localQzNotificationStruct != null) && (((String)localObject).equals(localQzNotificationStruct.jdField_a_of_type_JavaLangString))) {
              jdField_a_of_type_JavaUtilList.remove(localQzNotificationStruct);
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("resultcode", String.valueOf(paramInt));
    localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
    StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface.getAccount(), "callqzonefrompushv2", true, 0L, 0L, localHashMap, null, true);
  }
  
  private void b(SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "showPush()");
    if ((paramSinglePushMsg.jdField_a_of_type_Boolean) && (paramSinglePushMsg.jdField_a_of_type_Int == 0)) {
      paramSinglePushMsg.jdField_a_of_type_Int += 1;
    }
    QQAppInterface localQQAppInterface;
    int i3;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      i3 = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
      QLog.e("CliNotifyPush", 1, "pushType:" + i3);
      if (i3 == 10000)
      {
        a(paramSinglePushMsg.jdField_a_of_type_JavaUtilMap, localQQAppInterface.getAccount());
        a(paramSinglePushMsg, localQQAppInterface, 16L);
        return;
      }
    } while (a(paramSinglePushMsg));
    String str1 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent");
    String str2 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
    String str3 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
    long l1 = paramSinglePushMsg.jdField_b_of_type_Long;
    if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count") != null) {}
    for (;;)
    {
      int i2;
      boolean bool;
      try
      {
        i2 = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count"));
        i1 = i2;
        if (i2 < 1) {
          i1 = 1;
        }
        if (((List)localObject).size() <= 0) {
          break label750;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          i2 = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("CtrlFlag"));
          if (QLog.isColorLevel())
          {
            QLog.i("CliNotifyPush", 2, "receive push time:" + paramSinglePushMsg.jdField_a_of_type_Long + "=unreadCount=" + i1 + "=uin=" + l1 + "=type=" + i3 + "=CtrlFlag=" + i2 + "=message=" + str1);
            if (i2 != 1) {
              continue;
            }
            bool = true;
            a(paramSinglePushMsg, bool);
            if (!localQQAppInterface.isBackground_Pause) {
              break label738;
            }
            if (a(localQQAppInterface, i3)) {
              continue;
            }
            a(paramSinglePushMsg, localQQAppInterface, 16L);
            return;
            localException1 = localException1;
            i1 = 1;
          }
        }
        catch (Exception localException2)
        {
          i2 = 0;
          continue;
          QLog.i("CliNotifyPush", 1, "receive push time:" + paramSinglePushMsg.jdField_a_of_type_Long + "=unreadCount=" + i1 + "=uin=" + l1 + "=type=" + i3 + "=CtrlFlag=" + i2);
          continue;
          bool = false;
          continue;
          if (i2 == 1)
          {
            QLog.e("CliNotifyPush", 1, "not show push, existDL = " + i2);
            a(paramSinglePushMsg, localQQAppInterface, 128L);
            return;
          }
          localObject = ((ActivityManager)localQQAppInterface.a().getSystemService("activity")).getRunningTasks(1);
          if (localObject == null) {
            break label750;
          }
        }
      }
      Object localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (("cooperation.qzone.QzoneGPUPluginProxyActivity".equals(localObject)) || ("cooperation.qzone.QzonePluginProxyActivity".equals(localObject)) || ("cooperation.qzone.QzoneFeedsPluginProxyActivity".equals(localObject))) {
        i2 = 1;
      }
      for (;;)
      {
        if (i2 != 0)
        {
          a(paramSinglePushMsg, localQQAppInterface, 64L);
          return;
          i2 = 0;
        }
        else
        {
          if (str1 != null)
          {
            bool = localQQAppInterface.f();
            if (bool) {
              break label747;
            }
            str1 = localQQAppInterface.a().getApplicationContext().getString(2131368887) + i1 + localQQAppInterface.a().getApplicationContext().getString(2131368888);
          }
          label738:
          label747:
          for (;;)
          {
            MsgNotification.a().a(localQQAppInterface, 1, str1, bool, i3, str3, str2, true);
            a(paramSinglePushMsg, localQQAppInterface, 4L);
            QLog.e("CliNotifyPush", 1, "show push: XXX");
            return;
            a(paramSinglePushMsg, localQQAppInterface, 256L);
            return;
            a(paramSinglePushMsg, localQQAppInterface, 32L);
            return;
          }
          label750:
          i2 = 0;
        }
      }
      int i1 = 1;
    }
  }
  
  public Map a(FromServiceMsg paramFromServiceMsg)
  {
    QLog.e("CliNotifyPush", 1, "decodeQzonePushMsgs()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return null;
    }
    Object localObject1 = paramFromServiceMsg.getWupBuffer();
    System.arraycopy(localObject1, 4, localObject1, 0, localObject1.length - 4);
    paramFromServiceMsg = new PushInfo();
    localObject1 = new JceInputStream((byte[])localObject1);
    ((JceInputStream)localObject1).setServerEncoding("utf-8");
    paramFromServiceMsg.readFrom((JceInputStream)localObject1);
    Object localObject2 = paramFromServiceMsg.vecMsg;
    localObject1 = new HashMap();
    long l2 = a(localQQAppInterface);
    localObject2 = ((ArrayList)localObject2).iterator();
    long l1 = l2;
    while (((Iterator)localObject2).hasNext())
    {
      SingleMsg localSingleMsg = (SingleMsg)((Iterator)localObject2).next();
      if (localSingleMsg != null)
      {
        int i1 = Integer.parseInt((String)localSingleMsg.data.get("pushtype"));
        if ((i1 == 1) || (i1 == 2) || (i1 == 4) || (i1 == 301) || (i1 == 8) || (i1 == 300) || (i1 == 10000))
        {
          if (QzoneConfig.a().a("QZoneSetting", "PushDeduplication", 1) == 1)
          {
            if (localSingleMsg.addTime <= l2)
            {
              QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
              a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
              a(2014);
            }
          }
          else if (localSingleMsg.addTime < l2)
          {
            QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
            a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
            a(2014);
            continue;
          }
          if (((Map)localObject1).containsKey(Integer.valueOf(i1)))
          {
            SinglePushMsg localSinglePushMsg = (SinglePushMsg)((Map)localObject1).get(Integer.valueOf(i1));
            if ((localSinglePushMsg != null) && (localSinglePushMsg.jdField_a_of_type_Long < localSingleMsg.addTime))
            {
              ((Map)localObject1).put(Integer.valueOf(i1), new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark));
              label541:
              if (l1 >= localSingleMsg.addTime) {
                break label738;
              }
              l1 = localSingleMsg.addTime;
            }
          }
        }
        label738:
        for (;;)
        {
          break;
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
          break label541;
          ((Map)localObject1).put(Integer.valueOf(i1), new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark));
          break label541;
          a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 256L);
        }
      }
    }
    if (l2 < l1) {
      a(localQQAppInterface, l1);
    }
    return (Map)localObject1;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "supportJumpToQzone()");
    if (QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromPushReport", 0) == 1) {
      a(2000);
    }
    try
    {
      if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.containsKey("CtrlFlag")) && (Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("CtrlFlag")) == 1))
      {
        if (QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromPushCtrlFlag2", 1) == 1)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("param_scene", 11);
          localIntent.setClassName("com.qzone", "com.tencent.wns.export.EmptyService");
          paramQQAppInterface.a().startService(localIntent);
          QLog.e("CliNotifyPush", 1, "call qzone empty, CtrlFlag = 1");
          a(2012);
          return false;
        }
        if (QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromPushCtrlFlag", 1) == 1)
        {
          QLog.e("CliNotifyPush", 1, "not call qzone, CtrlFlag = 1");
          a(2002);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, localException, new Object[0]);
      int i2 = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
      if ((i2 != 1) && (i2 != 2) && (i2 != 4) && (i2 != 301))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone, pushType = " + i2);
        a(2001);
        return false;
      }
      if (QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromPush", 0) != 1)
      {
        QLog.e("CliNotifyPush", 1, "not call qzone, CALL_QZONE_WNS_FROM_PUSH = 0");
        a(2003);
        return false;
      }
      if (h >= QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromPushFailCnt", 1000))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  mCntCallQzoneFailure = " + h);
        a(2004);
        return false;
      }
      if (i >= QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromPushTimeoutCnt", 3))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  mCntCallQzoneTimeout = " + i);
        a(2011);
        return false;
      }
      if (a(paramQQAppInterface.a(), "com.qzone"))
      {
        int i3 = QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromPushVersion", 87);
        int i4 = QzoneConfig.a().a("QZoneSetting", "CallQZoneWNSFromLivePushVersion", 89);
        int i1;
        try
        {
          paramQQAppInterface = paramQQAppInterface.a().getPackageManager().getApplicationInfo("com.qzone", 128);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.metaData == null)) {
            break label554;
          }
          i1 = paramQQAppInterface.metaData.getInt("com.qzone.versioncode");
        }
        catch (PackageManager.NameNotFoundException paramQQAppInterface)
        {
          for (;;)
          {
            paramQQAppInterface.printStackTrace();
            i1 = 0;
          }
          if (i2 == 4) {
            break label574;
          }
        }
        if (i1 < i3)
        {
          QLog.e("CliNotifyPush", 1, "not call qzone, versionCode = " + i1);
          a(2006);
          return false;
        }
        label554:
        label574:
        if ((i2 == 301) && (i1 < i4))
        {
          QLog.e("CliNotifyPush", 1, "specialpush not call qzone, versionCode = " + i1);
          a(2006);
          return false;
        }
      }
      else
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  qzone not installed");
        a(2005);
        return false;
      }
    }
    QLog.e("CliNotifyPush", 1, "call qzone");
    a(2008);
    return true;
  }
  
  public String[] getPreferSSOCommands()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    RemoteHandleManager.a().a(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.qzone.ACTION_CALL_QZONE_WNS");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface != null) {}
    try
    {
      localQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, "registerreceiver fail:" + localException);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.a().b(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface != null) {}
    try
    {
      localQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, "unregisterreceiver fail:" + localException);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify begin");
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush")) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify");
      }
      paramIntent = (byte[])paramFromServiceMsg.attributes.get("pushMsgs");
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      localSvcMsgPush.readFrom(new JceInputStream(paramIntent));
      ((MessageHandler)((QQAppInterface)getAppRuntime()).a(0)).a(null, paramFromServiceMsg, localSvcMsgPush);
    }
    for (;;)
    {
      return;
      if ((!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone")) || (!paramFromServiceMsg.isSuccess())) {
        break;
      }
      QLog.e("CliNotifyPush", 1, "get qzone push begin");
      paramIntent = a(paramFromServiceMsg);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.values().iterator();
        while (paramIntent.hasNext()) {
          a((SinglePushMsg)paramIntent.next());
        }
      }
    }
    QLog.e("CliNotifyPush", 1, "get qzone push error");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i1;
    do
    {
      return;
      paramString = paramBundle.getBundle("data");
      i1 = paramString.getInt("param.preget_seqid");
      paramString = Long.valueOf(paramString.getLong("param.preget_undealcount", -1L));
    } while (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1)) == null);
    paramBundle = (SinglePushMsg)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1));
    if (paramString.longValue() != -1L) {
      paramBundle.jdField_a_of_type_JavaUtilMap.put("count", paramString + "");
    }
    b((SinglePushMsg)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1)));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\CliNotifyPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */