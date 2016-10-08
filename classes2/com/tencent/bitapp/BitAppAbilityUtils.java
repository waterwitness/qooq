package com.tencent.bitapp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.pre.PreConst;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.kingkong.Common.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.Native;

public class BitAppAbilityUtils
{
  public static final int a = 1;
  private static boolean a = false;
  public static final int b = 2;
  public static final int c = 3;
  private static int d;
  
  public BitAppAbilityUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a()
  {
    long l1 = DeviceInfoUtil.c();
    int i = DeviceInfoUtil.b();
    long l2 = DeviceInfoUtil.a();
    if (QLog.isColorLevel()) {
      QLog.i("Device", 2, "getSystemTotalMemory: " + l1 + " | cpuNumber: " + i + " | cpuFrequency: " + l2 + " | sdkversion: " + Build.VERSION.SDK_INT);
    }
    if ((l1 >>> 20 > 1390L) && (i > 3) && (l2 > 1433L)) {
      return 3;
    }
    if ((l1 >>> 20 > 1390L) && (i > 1) && (l2 > 961L)) {
      return 2;
    }
    return 1;
  }
  
  public static void a()
  {
    if (a()) {
      if ((RNPreDownloadFacade.a()) && (BitAppInstanceManager.getInstance() != null)) {
        BitAppInstanceManager.getInstance().onPause();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("bitapp_performance", 2, "Don't supoort bitapp msg");
  }
  
  public static boolean a()
  {
    if (d == 0) {
      d = a();
    }
    return (d >= 2) && (Build.VERSION.SDK_INT >= 16) && (f());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      int j = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      bool1 = bool2;
      if (j < i) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static void b()
  {
    if (a())
    {
      if ((PreConst.isTestPerformance) && (QLog.isColorLevel())) {
        QLog.i("bitapp_performance", 2, "ChatPie onResume");
      }
      if ((RNPreDownloadFacade.a()) && (BitAppInstanceManager.getInstance() != null)) {
        BitAppInstanceManager.getInstance().onResume(new BitAppAbilityUtils.EmptyDefaultHardwareBackBtnHandler());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("bitapp_performance", 2, "Don't supoort bitapp msg");
  }
  
  public static boolean b()
  {
    boolean bool = false;
    if (!a)
    {
      if (LocalMultiProcConfig.a("react_native_crash_count", 0) >= QzoneConfig.a().a("QZoneSetting", "RNMessageMaxCrashTimes", 2)) {
        bool = true;
      }
      a = bool;
    }
    return a;
  }
  
  public static void c()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Exception().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        localStringBuilder.append(localStackTraceElement.getClassName()).append(".").append(localStackTraceElement.getFileName()).append("(").append(localStackTraceElement.getMethodName()).append(")").append(localStackTraceElement.getLineNumber());
        Common.Log.b("lamo", localStringBuilder.toString());
        localStringBuilder.setLength(0);
        i += 1;
      }
    }
  }
  
  public static boolean c()
  {
    return QzoneConfig.a().a("QZoneSetting", "SwitchReact", 0) == 1;
  }
  
  public static boolean d()
  {
    return (!b()) && (c()) && (a());
  }
  
  public static boolean e()
  {
    return (Build.VERSION.SDK_INT >= 16) && (f());
  }
  
  private static boolean f()
  {
    int i = Native.a();
    if (QLog.isColorLevel()) {
      QLog.i("bitapp_performance", 2, "isSupportAbi abi: " + i);
    }
    return (i == 0) || (i == 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppAbilityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */