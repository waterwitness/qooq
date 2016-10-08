package cooperation.comic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.webview.utils.WebViewReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import yai;

public class VipComicReportUtils
{
  public static final int a = 0;
  public static TelephonyManager a;
  private static Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public static final String a = "isFromJumpActivity";
  private static ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new yai();
  private static Field jdField_a_of_type_JavaLangReflectField;
  public static AtomicInteger a;
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  public static final int b = 1;
  public static final String b = "reportLebaClick";
  public static AtomicInteger b;
  public static final int c = 2;
  public static final String c = "reportJumpActivityOnCreate";
  public static final int d = 3;
  public static final String d = "reportProcessExistFlag";
  public static final String e = "reportDownloadTime";
  public static final String f = "reportInstallTime";
  public static final String g = "reportStartPluginTime";
  public static final String h = "reportBrowserOnCreateStart";
  public static final String i = "reportBrowserOnCreateEnd";
  public static final String j = "reportSourceFrom";
  public static String k;
  public static String l;
  private static final String m = "VipComicReportUtils";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    k = "";
    l = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    b = new AtomicInteger(0);
  }
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        jdField_a_of_type_JavaLangReflectField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        jdField_a_of_type_JavaLangReflectField.setAccessible(true);
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
      if (jdField_a_of_type_JavaLangReflectField != null) {
        jdField_a_of_type_JavaLangReflectField.set(localStringBuilder, jdField_a_of_type_JavaLangThreadLocal.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  public static void a(Intent paramIntent, WebViewDirector paramWebViewDirector)
  {
    if ((paramIntent == null) || (paramWebViewDirector == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicReportUtils", 2, "Invalid parameters in reportStartSpeed.");
      }
    }
    long l1;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("isFromJumpActivity", false));
      l1 = paramIntent.getLongExtra("reportLebaClick", 0L);
    } while (l1 == jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l1);
    int i1 = paramIntent.getIntExtra("reportSourceFrom", 0);
    int n = paramIntent.getIntExtra("reportProcessExistFlag", 0);
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
      n = 2;
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      long l2 = paramIntent.getLongExtra("reportJumpActivityOnCreate", 0L);
      long l3 = paramIntent.getLongExtra("reportDownloadTime", 0L);
      long l4 = paramIntent.getLongExtra("reportInstallTime", 0L);
      long l5 = paramIntent.getLongExtra("reportStartPluginTime", 0L);
      long l6 = paramIntent.getLongExtra("reportBrowserOnCreateStart", 0L);
      long l7 = paramIntent.getLongExtra("reportBrowserOnCreateEnd", 0L);
      if (QLog.isColorLevel())
      {
        paramIntent = "" + "totalTime:" + (l7 - l1);
        paramIntent = paramIntent + "&jumpActivityCreateTime:" + (l2 - l1);
        paramIntent = paramIntent + "&installTime:" + l4;
        paramIntent = paramIntent + "&downloadTime:" + l3;
        paramIntent = paramIntent + "&startPluginTime:" + (l5 - l2);
        paramIntent = paramIntent + "&startLaunchBrowser" + (l6 - l5);
        paramIntent = paramIntent + "&launchBrowser:" + (l7 - l6);
        paramIntent = paramIntent + "&processExistFlag:" + n;
        QLog.d("VipComicReportUtils", 2, paramIntent + "&sourceFrom:" + i1);
      }
      WebViewReportUtils.a(l7 - l1, l2 - l1, l3, l4, l5 - l2, 0L, paramWebViewDirector.b, paramWebViewDirector.e, paramWebViewDirector.c, paramWebViewDirector.a, paramWebViewDirector.d, paramWebViewDirector.f, 2L, 0L, n, 0L, l6 - l5, l7 - l6 + "", Build.VERSION.RELEASE, i1 + "");
      return;
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        n = 1;
      } else if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
        n = 3;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if ((paramString1 == null) || (paramContext == null)) {
      return;
    }
    if (TextUtils.isEmpty(k)) {
      if (jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
        jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      }
    }
    try
    {
      k = jdField_a_of_type_AndroidTelephonyTelephonyManager.getDeviceId();
      if (k == null) {
        k = "";
      }
      int i1 = HttpUtil.a();
      if (i1 >= 0)
      {
        n = i1;
        if (i1 < AppConstants.b.length) {}
      }
      else
      {
        n = 0;
      }
      String str = AppConstants.b[n];
      if (TextUtils.isEmpty(l))
      {
        paramContext = paramContext.getResources().getDisplayMetrics();
        l = paramContext.widthPixels + "*" + paramContext.heightPixels;
      }
      paramContext = new String[9];
      paramContext[0] = "";
      paramContext[1] = "";
      paramContext[2] = "";
      paramContext[3] = "";
      paramContext[4] = "";
      paramContext[5] = "";
      paramContext[6] = "";
      paramContext[7] = "";
      paramContext[8] = "";
      int n = 0;
      while ((n < paramContext.length) && (n < paramVarArgs.length))
      {
        paramContext[n] = paramVarArgs[n];
        n += 1;
      }
      paramString1 = Arrays.asList(new String[] { paramString1, k, "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", "", "", "", paramString2, "", "", paramString3, paramString4, paramString5, "", "", "6.5.5", "", "", "", "", "", "android", str, l, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8] });
      if ((paramAppInterface instanceof QQAppInterface))
      {
        paramAppInterface = (QQAppInterface)paramAppInterface;
        a(paramAppInterface, "dc00145", paramString1);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        paramAppInterface = null;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    String[] arrayOfString = new String[10];
    System.arraycopy(paramVarArgs, 0, arrayOfString, 0, Math.min(10, paramVarArgs.length));
    int n = 0;
    int i1 = arrayOfString.length;
    while (n < i1)
    {
      if (arrayOfString[n] == null) {
        arrayOfString[n] = "";
      }
      n += 1;
    }
    paramString1 = Arrays.asList(new String[] { String.valueOf(System.currentTimeMillis() / 1000L), "ANDROID", Build.VERSION.RELEASE, paramString1, "6.5.5", paramString2, paramString3, paramString4, paramString5, paramString6, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4], arrayOfString[5], arrayOfString[6], arrayOfString[7], arrayOfString[8], arrayOfString[9] });
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "b_sng_qqvip_sqlite_profile_report|sqlite_profile_monitor_report", paramString1);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    a(paramAppInterface, paramAppInterface.a(), paramAppInterface.a(), paramString1, paramString2, paramString3, paramString4, paramVarArgs);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      localStringBuilder = a();
      i1 = paramList.size();
      n = 0;
      while (n < i1)
      {
        localStringBuilder.append((String)paramList.get(n));
        if (n < i1 - 1) {
          localStringBuilder.append("|");
        }
        n += 1;
      }
      paramList = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.i("VipComicReportUtils", 2, "dcId=" + paramString + ";detail=" + paramList);
      }
      DcReportUtil.a(paramQQAppInterface, paramString, paramList, false);
    }
    while (!QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      int i1;
      int n;
      return;
    }
    QLog.i("VipComicReportUtils", 2, "params is null, dcId=" + paramString + ";detail=" + "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\VipComicReportUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */