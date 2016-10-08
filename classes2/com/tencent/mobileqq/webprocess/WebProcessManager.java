package com.tencent.mobileqq.webprocess;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import wgx;
import wgy;
import wgz;
import wha;

public class WebProcessManager
  implements Manager
{
  protected static final int a = 512;
  protected static final String a = "WebProcessManager";
  public static HashMap a;
  public static final ConcurrentHashMap a;
  protected static final int b = 1024;
  public static final long b = 604800000L;
  public static final String b = "com.tencent.mobileqq:web";
  protected static boolean b = false;
  private static int c = 0;
  public static final long c = 259200000L;
  public static final String c = "com.tencent.mobileqq.webprocess.restart_web_process";
  public static final String d = "com.tencent.mobileqq.webprocess.report";
  public static final String e = "web_process_preload_file";
  public static final String f = "key_come_webview_time";
  public static final String g = "key_web_plugin_list";
  public static final String h = "key_web_plugin_click_num";
  public static final String i = "key_web_plugin_click_red_num";
  public static final String j = "key_preload_strategy";
  public static final String k = "key_preload_flag";
  public static final String l = "key_check_update_interval";
  public static final String m = "key_last_check_update_timestamp";
  public static final String n = "key_red_ram";
  public static final String o = "key_click_ram";
  public static final String p = "key_preload";
  public static final String q = "key_preload_web_process";
  public static final String r = "key_health_dns_parse";
  public static final String s = "key_vip_dns_parse";
  public static final String t = "key_ind_dns_parse";
  public static final String u = "key_gamecenter_dns_parse";
  private static final String v = "dns_profile";
  private static final String w = "health_dns_profile";
  private static final String x = "vip_dns_profile";
  private static final String y = "vip_gamecenter_profile";
  protected long a;
  protected BroadcastReceiver a;
  protected QQAppInterface a;
  protected boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c = -1;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public WebProcessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new wgz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    c();
    this.jdField_a_of_type_Long = (DeviceInfoUtil.c() / 1048576L);
  }
  
  public static long a(String paramString)
  {
    return BaseApplicationImpl.a().getSharedPreferences("health_dns_profile", SecMsgUtil.a()).getLong(paramString, -1L);
  }
  
  private static Long a(String paramString)
  {
    return Long.valueOf(BaseApplicationImpl.a().getSharedPreferences("dns_profile", 0).getLong(paramString, 0L));
  }
  
  public static void a(String paramString, long paramLong)
  {
    int i1 = SecMsgUtil.a();
    BaseApplicationImpl.a().getSharedPreferences("health_dns_profile", i1).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(List paramList, String paramString)
  {
    if (!b(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "begin to parse dns,isNeedPreparseDns = " + c);
    }
    e(paramString, System.currentTimeMillis());
    ThreadManager.a(new wha(paramList), 5, null, true);
  }
  
  public static void a(boolean paramBoolean)
  {
    BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload", false);
  }
  
  public static long b(String paramString)
  {
    return BaseApplicationImpl.a().getSharedPreferences("vip_dns_profile", SecMsgUtil.a()).getLong(paramString, -1L);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "preloadWebProcess");
    }
    try
    {
      localObject = BaseApplicationImpl.a().getSharedPreferences("CrashControl_com.tencent.mobileqq:web", 4);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("allowpreload", true)))
      {
        long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
        int i1 = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
        long l2 = System.currentTimeMillis();
        if ((l1 <= 0L) || (i1 <= 0) || (l2 <= l1) || (l2 - l1 <= i1 * 1000)) {
          break label186;
        }
        ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("from", paramInt);
    ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    ((Intent)localObject).putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "Send preload web process broadcast...");
    }
    return;
    label186:
    QLog.d("WebProcessManager", 1, "preloadWebProcess is not allowed as crash frequently.");
    b(false);
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actNoPreloadWeb", true, 0L, 0L, null, "");
  }
  
  public static void b(String paramString, long paramLong)
  {
    BaseApplicationImpl.a().getSharedPreferences("vip_dns_profile", SecMsgUtil.a()).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload_web_process", paramBoolean).commit();
  }
  
  public static boolean b()
  {
    return BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload_web_process", false);
  }
  
  public static boolean b(String paramString)
  {
    if (c == 0) {}
    long l1;
    do
    {
      return false;
      l1 = a(paramString).longValue();
    } while ((l1 != 0L) && (System.currentTimeMillis() - l1 <= 600000L));
    return true;
  }
  
  public static long c(String paramString)
  {
    return BaseApplicationImpl.a().getSharedPreferences("vip_gamecenter_profile", SecMsgUtil.a()).getLong(paramString, -1L);
  }
  
  public static void c(String paramString, long paramLong)
  {
    BaseApplicationImpl.a().getSharedPreferences("vip_gamecenter_profile", SecMsgUtil.a()).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void c(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean c()
  {
    Object localObject = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    try
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("WebProcessManager", 1, "getRunningAppProcesses crash!", localException);
        localIterator = null;
      }
      Iterator localIterator = localIterator.iterator();
      while (localIterator.hasNext()) {
        if ("com.tencent.mobileqq:web".equals(((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebProcessManager", 2, "Web process is exist");
          }
          return true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "Web process is not exist");
      }
    }
    return false;
  }
  
  private static void e(String paramString, long paramLong)
  {
    BaseApplicationImpl.a().getSharedPreferences("dns_profile", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  private static void f(String paramString, long paramLong)
  {
    int i1 = 0;
    try
    {
      int i2 = NetworkUtil.a(BaseApplicationImpl.a());
      i1 = i2;
    }
    catch (Exception localException)
    {
      String str;
      for (;;) {}
    }
    switch (i1)
    {
    default: 
      str = "";
    }
    try
    {
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("net_state", str);
        localHashMap.put("current_url", paramString);
        localHashMap.put("time_used", String.valueOf(paramLong));
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.a().a().getAccount(), "dns_parse_time", true, paramLong, 1L, localHashMap, "", false);
        return;
        str = "2G";
        continue;
        str = "3G";
        continue;
        str = "4G";
        continue;
        str = "wifi";
      }
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("WebProcessManager", 2, "report dns parse time error=" + paramString.toString());
      return;
    }
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4);
    Object localObject = SharedPreferencesHandler.a(localSharedPreferences, "key_web_plugin_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
    if ((localObject != null) && (!((Set)localObject).isEmpty()))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        jdField_a_of_type_JavaUtilHashMap.put(str, str);
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_preload_strategy", Integer.valueOf(localSharedPreferences.getInt("key_preload_strategy" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1)));
    localObject = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localSharedPreferences.getBoolean("key_preload_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false)) {}
    for (int i1 = 1;; i1 = 0)
    {
      ((ConcurrentHashMap)localObject).put("key_preload_flag", Integer.valueOf(i1));
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_red_ram", Integer.valueOf(localSharedPreferences.getInt("key_red_ram" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 512)));
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_click_ram", Integer.valueOf(localSharedPreferences.getInt("key_click_ram" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1024)));
      return;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt, WebProcessManager.WebProcessStartListener paramWebProcessStartListener)
  {
    ThreadManager.a(new wgx(this, paramInt, paramWebProcessStartListener), 5, null, false);
  }
  
  public boolean a(String paramString)
  {
    boolean bool1;
    if (jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Object localObject = SharedPreferencesHandler.a(BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4), "key_web_plugin_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      boolean bool2 = false;
      bool1 = bool2;
      if (localObject == null) {
        break label133;
      }
      bool1 = bool2;
      if (((Set)localObject).isEmpty()) {
        break label133;
      }
      localObject = ((Set)localObject).iterator();
      bool1 = false;
      if (!((Iterator)localObject).hasNext()) {
        break label139;
      }
      String str = (String)((Iterator)localObject).next();
      jdField_a_of_type_JavaUtilHashMap.put(str, str);
      if (!str.equals(paramString)) {
        break label136;
      }
      bool1 = true;
    }
    label133:
    label136:
    for (;;)
    {
      break;
      bool1 = jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
      return bool1;
    }
    label139:
    return bool1;
  }
  
  public void b()
  {
    if ((b) && (d())) {
      e();
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Boolean = true;
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.restart_web_process");
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.report");
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_a_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_Boolean = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean d()
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("key_preload_strategy");
    if ((localInteger != null) && (localInteger.intValue() == 2))
    {
      localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("key_preload_flag");
      if ((localInteger != null) && (localInteger.intValue() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "is need prload, totalMemSize = " + this.jdField_a_of_type_Long + "M");
        }
        localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("key_red_ram");
        if ((localInteger != null) && (this.jdField_a_of_type_Long > localInteger.intValue())) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else
    {
      return e();
    }
    return false;
  }
  
  public void e()
  {
    a(-1);
  }
  
  protected boolean e()
  {
    return true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "restartWebProcess");
    }
    new Handler().postDelayed(new wgy(this), 800L);
  }
  
  protected boolean f()
  {
    if (jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      return false;
    }
    try
    {
      List localList = LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localList != null) && (localList.size() > 0))
      {
        long l1;
        long l2;
        do
        {
          Iterator localIterator1 = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
          Iterator localIterator2;
          while (!localIterator2.hasNext())
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            l1 = Long.parseLong((String)localIterator1.next());
            localIterator2 = localList.iterator();
          }
          l2 = ((LebaViewItem)localIterator2.next()).a.uiResId;
        } while (l1 != l2);
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void g()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPreloadSucess");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip", "", "0X8004874", "0X8004874", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      a(false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPreloadFail");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip", "", "0X8004875", "0X8004875", 0, 1, 0, "", "", "", "");
    }
  }
  
  protected boolean g()
  {
    if (jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      return false;
    }
    try
    {
      GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localGameCenterManagerImp != null)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          int i1 = localGameCenterManagerImp.a((String)localIterator.next());
          if (i1 != -1) {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void onDestroy()
  {
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webprocess\WebProcessManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */