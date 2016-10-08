package com.tencent.common.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.SystemClassLoaderInjector;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import jkj;
import jkk;
import jkl;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class BaseApplicationImpl
  extends MobileQQ
{
  public static int a = 0;
  public static long a = 0L;
  public static MQLruCache a;
  public static BaseApplicationImpl a;
  public static StartupDirector a;
  public static String a;
  public static MqqHandler a;
  public static boolean a = false;
  public static final int b = -1;
  public static long b = 0L;
  public static String b;
  public static boolean b = false;
  public static final int c = 1;
  public static long c = 0L;
  public static String c;
  public static boolean c = false;
  public static final int d = 2;
  public static String d;
  public static boolean d = false;
  public static final int e = 3;
  public static final String e = "com.tencent.mobileqq.broadcast.qq";
  public static boolean e = true;
  public static final int f = 4;
  public static final String f = "com.tencent.process.exit";
  public static final int g = 5;
  public static final String g = "hotpatch";
  public static final int h = 6;
  public static final String h = "/data/data/com.tencent.mobileqq/files/hotpatch/";
  public static int i = 0;
  public static final String i = "sp_dex_patch";
  public static int j = 0;
  public static String j;
  public static final int k = 5;
  private static final String k = "BaseApplicationImpl";
  public static final int l = 5;
  public static final int m = 3;
  private static final int jdField_n_of_type_Int = 3;
  private Intent a;
  private String l;
  private String m;
  private String jdField_n_of_type_JavaLangString;
  private String o;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    b = "";
    c = "";
    d = "";
    jdField_a_of_type_Boolean = true;
    i = -1;
    jdField_j_of_type_JavaLangString = "";
  }
  
  public static BaseApplicationImpl a()
  {
    return jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public static String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    int i1;
    if (paramBoolean)
    {
      i1 = localTime.minute - 1;
      localStringBuilder.append(i1);
      if (paramArrayList != null) {
        break label135;
      }
    }
    label135:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      i1 = localTime.minute;
      break;
    }
  }
  
  private void a(Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      paramContext = InjectUtils.a(this, paramContext);
      QLog.d("BaseApplicationImpl", 1, processName + ", injectHackDex=" + paramContext + ", cost=" + (System.currentTimeMillis() - l1) + " ms.");
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.d("BaseApplicationImpl", 1, "injectHackDex throwable=" + paramContext.toString());
      paramContext.printStackTrace();
    }
  }
  
  private void a(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramContext = new jkk(this, paramContext, paramBoolean, paramInt1, paramInt2);
    if (paramBoolean)
    {
      ThreadManager.a(paramContext, 5, null, true);
      return;
    }
    paramContext.run();
  }
  
  public Intent a()
  {
    if ((this.l != null) && (this.m != null) && (this.n != null) && (this.o != null))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent("mqq.intent.action.PCACTIVE_TIPS");
      this.jdField_a_of_type_AndroidContentIntent.putExtra("Message", this.m);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.l);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("lButton", this.n);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("rButton", this.o);
      this.jdField_a_of_type_AndroidContentIntent.addFlags(268435456);
      return this.jdField_a_of_type_AndroidContentIntent;
    }
    return null;
  }
  
  public String a()
  {
    return this.l;
  }
  
  public AppRuntime a()
  {
    return waitAppRuntime(null);
  }
  
  public void a()
  {
    super.onCreate();
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = paramContext.getSharedPreferences("sp_dex_patch", 4);
        boolean bool1 = ((SharedPreferences)localObject1).getBoolean("enable", false);
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex enable=" + bool1 + ", isStartup=" + paramBoolean);
        if (!bool1) {
          break label891;
        }
        localObject2 = ((SharedPreferences)localObject1).getString("process", "");
        boolean bool2 = TextUtils.isEmpty((CharSequence)localObject2);
        if (!bool2)
        {
          localObject2 = ((String)localObject2).split(";");
          i2 = localObject2.length;
          i1 = 0;
          bool1 = bool2;
          if (i1 < i2)
          {
            localObject3 = localObject2[i1];
            if (!processName.equals(localObject3)) {
              break label892;
            }
            bool1 = true;
          }
          if (!bool1)
          {
            QLog.d("BaseApplicationImpl", 1, "injectPatchDex process not match.");
            return;
          }
        }
        if (!"229354".equals(((SharedPreferences)localObject1).getString("revision", "")))
        {
          QLog.d("BaseApplicationImpl", 1, "injectPatchDex revision not match.");
          return;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex throwable=" + paramContext.toString());
        paramContext.printStackTrace();
        return;
      }
      Object localObject2 = ((SharedPreferences)localObject1).getString("appVersion", "");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(ApkUtils.a(paramContext) + "." + ApkUtils.a(paramContext))))
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex app version not match.");
        return;
      }
      localObject2 = ((SharedPreferences)localObject1).getString("sysVersion", "");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).contains(String.valueOf(Build.VERSION.SDK_INT))))
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex system version not match.");
        return;
      }
      localObject2 = ((SharedPreferences)localObject1).getString("deviceInfo", "");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((!((String)localObject2).contains(Build.BRAND)) || (!((String)localObject2).contains(Build.MODEL))))
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex device not match.");
        return;
      }
      localObject2 = ((SharedPreferences)localObject1).getString("name", "");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex patch name is empty.");
        return;
      }
      Object localObject3 = "/data/data/com.tencent.mobileqq/files/hotpatch/" + (String)localObject2;
      Object localObject4 = new File((String)localObject3);
      if ((localObject4 == null) || (!((File)localObject4).exists()))
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex patch file not exist.");
        return;
      }
      long l2 = ((SharedPreferences)localObject1).getLong("size", 0L);
      if ((l2 <= 0L) || (((File)localObject4).length() != l2))
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex patch size not match.");
        return;
      }
      if (!((SharedPreferences)localObject1).getBoolean("verify", false))
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex patch verify failed.");
        return;
      }
      int i1 = ((SharedPreferences)localObject1).getInt("installFailCount", 0);
      if (i1 >= 3)
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex install fail many times.");
        return;
      }
      localObject4 = ((SharedPreferences)localObject1).getString("crashKey", "");
      int i2 = ((SharedPreferences)localObject1).getInt("patchCrashCount", 0);
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (i2 >= 5))
      {
        QLog.d("BaseApplicationImpl", 1, "injectPatchDex patch crash many times.");
        return;
      }
      if (paramBoolean)
      {
        if (((SharedPreferences)localObject1).getInt("startFailRetryRound" + processName, 0) >= 3)
        {
          QLog.d("BaseApplicationImpl", 1, "injectPatchDex start fail max rounds, will not install patch.");
          return;
        }
        if (((SharedPreferences)localObject1).getInt("startFailCount" + processName, 1) > 5)
        {
          QLog.d("BaseApplicationImpl", 1, "injectPatchDex start fail max times in one round.");
          return;
        }
      }
      l2 = System.currentTimeMillis();
      try
      {
        localObject1 = SystemClassLoaderInjector.a(this, (String)localObject3, null, false);
        if ("Success".equals(localObject1))
        {
          jdField_j_of_type_Int = 500;
          jdField_j_of_type_JavaLangString = (String)localObject2;
          e = paramBoolean;
        }
        for (;;)
        {
          QLog.d("BaseApplicationImpl", 1, "injectPatchDex result=" + (String)localObject1 + ", total cost time: " + (System.currentTimeMillis() - l1) + " ms, inject cost time: " + (System.currentTimeMillis() - l2) + " ms.");
          a(paramContext, paramBoolean, jdField_j_of_type_Int, i1);
          if (paramBoolean) {
            break;
          }
          StatisticCollector.a(paramContext).a("", "actNvwaInstall", jdField_j_of_type_Int, (String)localObject2);
          return;
          jdField_j_of_type_Int = 501;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          jdField_j_of_type_Int = 502;
          QLog.d("BaseApplicationImpl", 1, "Inject patch throwable=" + localThrowable.toString());
          localThrowable.printStackTrace();
          String str = "Inject patch failed as throwable";
        }
      }
      label891:
      return;
      label892:
      i1 += 1;
    }
  }
  
  public void a(Intent paramIntent)
  {
    try
    {
      super.sendBroadcast(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("mqq", 1, "", paramIntent);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.l = paramString1;
    this.m = paramString2;
    this.n = paramString3;
    this.o = paramString4;
  }
  
  public void addOtherTypeActivity(Activity paramActivity)
  {
    this.otherTypeActivitys.add(new WeakReference(paramActivity));
    StatisticCollector.a(this).a(paramActivity);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    String str = getProcessName();
    if ("com.tencent.mobileqq".equals(str))
    {
      i = 1;
      if (i != 1) {
        break label176;
      }
    }
    label176:
    for (long l1 = 3000L;; l1 = 0L)
    {
      QLog.init("com.tencent.mobileqq", str, "V 6.5.5.2880", l1);
      a(paramContext);
      a(paramContext, true);
      paramContext = getResources();
      if (paramContext != null)
      {
        FontSettingManager.a.setTo(paramContext.getDisplayMetrics());
        FontSettingManager.a(this, null, false);
      }
      return;
      if (str.endsWith("MSF"))
      {
        i = 4;
        break;
      }
      if (str.endsWith("qzone"))
      {
        i = 2;
        break;
      }
      if (str.endsWith("web"))
      {
        i = 3;
        break;
      }
      if (str.endsWith("nearby"))
      {
        i = 5;
        break;
      }
      if (str.endsWith("lola"))
      {
        i = 6;
        break;
      }
      i = -1;
      break;
    }
  }
  
  public AppRuntime createRuntime(String paramString)
  {
    return AppInterfaceFactory.a(this, paramString);
  }
  
  public Object getAppData(String paramString)
  {
    if (paramString == null) {}
    while (!"channel_id".equals(paramString)) {
      return null;
    }
    return "10000049";
  }
  
  public int getAppId(String paramString)
  {
    return AppSetting.a;
  }
  
  public String getBootBroadcastName(String paramString)
  {
    if (paramString.equals("com.tencent.mobileqq")) {
      return "com.tencent.mobileqq.broadcast.qq";
    }
    if (paramString.equals("com.tencent.mobileqq:video")) {
      return "com.tencent.av.ui.VChatActivity";
    }
    return "";
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public SharedPreferences getSystemSharedPreferences(String paramString, int paramInt)
  {
    return super.getSharedPreferences(paramString, paramInt);
  }
  
  public boolean isNeedMSF(String paramString)
  {
    return (!paramString.endsWith("lola")) && (!paramString.endsWith("TMAssistantDownloadSDKService"));
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    if (jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null)
    {
      if ((this.startComponentInfo == null) && (paramObject != null)) {
        this.startComponentInfo = paramObject.toString();
      }
      return jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(paramObject, paramIntent);
    }
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null) {
      jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(paramAppActivity, paramBoolean);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources();
    if (paramConfiguration != null)
    {
      FontSettingManager.a.setTo(paramConfiguration.getDisplayMetrics());
      FontSettingManager.a(this, null, true);
    }
  }
  
  public void onCreate()
  {
    if (jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {}
    do
    {
      return;
      jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = this;
      SharedPreferencesProxyManager.getInstance().init(this);
      if (i == 2)
      {
        StartupDirector.e = true;
        PerfTracer.a("App_onCreate");
      }
      if (Build.VERSION.SDK_INT >= 15) {
        registerActivityLifecycleCallbacks(new UEC());
      }
      jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector = StartupDirector.a();
    } while (!StartupDirector.e);
    PerfTracer.b("App_onCreate");
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    try
    {
      paramBroadcastReceiver = super.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
      return paramBroadcastReceiver;
    }
    catch (Exception paramBroadcastReceiver)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "", paramBroadcastReceiver);
      }
    }
    return null;
  }
  
  public void removeOtherTypeActivity(Activity paramActivity)
  {
    this.otherTypeActivitys.remove(new WeakReference(paramActivity));
    StatisticCollector.a(this).d(paramActivity);
  }
  
  public void reportPCActive(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(paramInt));
    localHashMap.put("param_uin", paramString);
    StatisticCollector.a(a()).a(paramString, "PcActiveSucc", true, 0L, 0L, localHashMap, "", true);
    jdField_a_of_type_MqqOsMqqHandler.postDelayed(new jkj(this, paramInt, paramString), 10000L);
    ReportController.b(null, "CliOper", "", "", "0X8004974", "0X8004974", 0, 0, "", "", "", "");
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    int i2 = 0;
    int i1;
    if (paramIntent == null) {
      i1 = i2;
    }
    for (;;)
    {
      if (i1 == 0) {
        a(paramIntent);
      }
      return;
      String str = paramIntent.getAction();
      i1 = i2;
      if (str != null) {
        if (!str.startsWith("com.tencent.process."))
        {
          i1 = i2;
          if (!str.equals("com.tencent.qq.syncQQMessage")) {}
        }
        else
        {
          i1 = 1;
          ThreadManager.b().post(new jkl(this, paramIntent));
        }
      }
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      JumpActivity.a(paramIntent);
      super.startActivity(paramIntent);
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    try
    {
      JumpActivity.a(paramIntent);
      super.startActivity(paramIntent, paramBundle);
      return;
    }
    catch (Exception paramIntent) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\app\BaseApplicationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */