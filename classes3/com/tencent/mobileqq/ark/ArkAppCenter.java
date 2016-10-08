package com.tencent.mobileqq.ark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Proxy;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.dataline.util.DatalinePlatformUtil;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ArkSoDownloadHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import qqn;
import qqo;
import qqp;
import qqq;
import qqr;

public class ArkAppCenter
  implements Manager
{
  public static final String a = "ArkApp";
  public static HashMap a;
  public static volatile boolean a = false;
  public static final String b = "arkapp_pa_nshow";
  public static volatile boolean b;
  public static final String c;
  private static boolean jdField_c_of_type_Boolean = true;
  private static boolean d;
  private static boolean e;
  private static boolean f;
  private final int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new qqn(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArkAppCGI jdField_a_of_type_ComTencentMobileqqArkArkAppCGI;
  private ArkAppEntityManagerFactory jdField_a_of_type_ComTencentMobileqqArkArkAppEntityManagerFactory;
  private ArkAppSSO jdField_a_of_type_ComTencentMobileqqArkArkAppSSO;
  private ArkLocalAppMgr jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new qqq(this);
  private final int b;
  private final int jdField_c_of_type_Int = 2;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = e();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    e = BaseApplication.getContext().getSharedPreferences("arkappmsg_entry", 4).getBoolean("arkapp_pa_nshow", e);
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if ((a(str1).booleanValue()) || (a(str2).booleanValue())) {
      jdField_b_of_type_Boolean = true;
    }
    while (!b(str1).booleanValue()) {
      return;
    }
  }
  
  public ArkAppCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI = new ArkAppCGI(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppSSO = new ArkAppSSO(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr = new ArkLocalAppMgr(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppEntityManagerFactory = new ArkAppEntityManagerFactory(paramQQAppInterface.a());
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PROXY_CHANGE");
    paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public static int a()
  {
    int i = 0;
    if (DatalinePlatformUtil.a() < 11) {
      i = Proxy.getDefaultPort();
    }
    String str;
    do
    {
      return i;
      str = System.getProperty("http.proxyPort");
    } while (TextUtils.isEmpty(str));
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    b();
    ArrayList localArrayList = new ArrayList();
    DispatchTask.a().b(new qqo(localArrayList, paramString));
    return ((Integer)localArrayList.get(0)).intValue();
  }
  
  private static Boolean a(String paramString)
  {
    if ((paramString.equalsIgnoreCase("armeabi-v7a")) || (paramString.equalsIgnoreCase("arm64-v8a"))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static String a()
  {
    return String.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
    {
      c();
      return;
    }
    d();
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        e = "1".equalsIgnoreCase(paramString);
        BaseApplication.getContext().getSharedPreferences("arkappmsg_entry", 4).edit().putBoolean("arkapp_pa_nshow", e).commit();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        c("ArkApp", "updatePANShowSwitch, value = null");
      }
      if (paramString == null) {
        continue;
      }
      c("ArkApp", "updatePANShowSwitch, value = " + paramString);
      return;
      e = false;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static boolean a()
  {
    if (jdField_b_of_type_Boolean) {}
    do
    {
      return true;
      if (!jdField_c_of_type_Boolean) {
        break;
      }
    } while (ArkSoLoader.jdField_a_of_type_Boolean);
    if (!f)
    {
      f = true;
      if ((b().booleanValue()) && (ArkSoDownloadHandler.d()))
      {
        ArkSoLoader.jdField_a_of_type_Boolean = true;
        return true;
      }
      b(true);
    }
    return false;
  }
  
  private static Boolean b()
  {
    boolean bool2 = ArkSoLoader.a("png-armeabi");
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = ArkSoLoader.a("ark-armeabi");
    }
    return Boolean.valueOf(bool1);
  }
  
  private static Boolean b(String paramString)
  {
    return Boolean.valueOf(paramString.equalsIgnoreCase("armeabi"));
  }
  
  public static String b()
  {
    return String.format("%d", new Object[] { Integer.valueOf(ark.arkGetMinPlatformVersion()) });
  }
  
  public static void b()
  {
    if ((jdField_a_of_type_Boolean) || ((!jdField_b_of_type_Boolean) && (!jdField_c_of_type_Boolean))) {
      return;
    }
    DispatchTask.a().b(new qqp());
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  private static void b(boolean paramBoolean)
  {
    Object localObject = (EarlyDownloadManager)BaseApplicationImpl.a().a().getManager(76);
    if (localObject != null)
    {
      localObject = (ArkSoDownloadHandler)((EarlyDownloadManager)localObject).a(ArkSoDownloadHandler.b());
      if (localObject != null)
      {
        if (paramBoolean) {
          ((ArkSoDownloadHandler)localObject).a();
        }
        ((ArkSoDownloadHandler)localObject).a(false);
      }
    }
  }
  
  public static boolean b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ArkApp", 4, "isPANonShow,  bRet = " + e);
    }
    return (e) || (!a());
  }
  
  public static String c()
  {
    return String.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformBuildNumber()) });
  }
  
  public static void c()
  {
    String str;
    int i;
    if (jdField_a_of_type_Boolean)
    {
      str = d();
      i = a();
      if ((!TextUtils.isEmpty(str)) && (i != 0)) {
        break label59;
      }
      ark.arkHTTPSetDefaultHttpProxy("", 0);
    }
    for (;;)
    {
      c("ArkApp", String.format("setArkHttpProxy, host=%s, port=%d", new Object[] { str, Integer.valueOf(i) }));
      return;
      label59:
      ark.arkHTTPSetDefaultHttpProxy(str, i);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public static String d()
  {
    if (DatalinePlatformUtil.a() < 11) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  public static void d()
  {
    if (jdField_a_of_type_Boolean) {
      ark.arkHTTPSetDefaultHttpProxy("", 0);
    }
  }
  
  private static String e()
  {
    Object localObject = BaseApplicationImpl.getContext();
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (localObject = AppConstants.bj;; localObject = ((Context)localObject).getCacheDir().getAbsolutePath()) {
      return (String)localObject + "/ArkApp/Storage";
    }
  }
  
  public static void e()
  {
    f();
    g();
  }
  
  private static void f()
  {
    File[] arrayOfFile = new File(jdField_c_of_type_JavaLangString).listFiles(new qqr());
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
    new File(jdField_c_of_type_JavaLangString + "/http_cache.db").deleteOnExit();
  }
  
  private static void g()
  {
    new File(jdField_c_of_type_JavaLangString + "/storage.db").delete();
  }
  
  public ArkAppCGI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI;
  }
  
  ArkAppEntityManagerFactory a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppEntityManagerFactory;
  }
  
  public ArkAppSSO a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppSSO;
  }
  
  public ArkLocalAppMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr.c();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */