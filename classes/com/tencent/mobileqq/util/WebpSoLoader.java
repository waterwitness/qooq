package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class WebpSoLoader
{
  private static final int a = 0;
  public static final String a = " WebP/0.3.1";
  public static int[] a;
  private static final int b = -1;
  public static final String b = "WebpHookEnabled";
  private static final int c = -2;
  public static final String c = "WebpHookSupported";
  private static final int jdField_d_of_type_Int = -3;
  private static final String jdField_d_of_type_JavaLangString = "WebpSoLoader";
  private static final String e = "libwebp-";
  
  public WebpSoLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a()
  {
    if ((Build.CPU_ABI.equalsIgnoreCase("x86")) || (Build.CPU_ABI2.equalsIgnoreCase("x86")) || (Build.CPU_ABI.equalsIgnoreCase("mips")) || (Build.CPU_ABI2.equalsIgnoreCase("mips"))) {}
    String str;
    do
    {
      return -2;
      str = a(BaseApplicationImpl.getContext());
      if (str == null) {
        break;
      }
    } while (Build.VERSION.SDK_INT < 8);
    if (Build.VERSION.SDK_INT < 9) {
      str = str + "libwebp-" + "22.so";
    }
    for (;;)
    {
      if (!new File(str).exists()) {
        break label243;
      }
      try
      {
        System.load(str);
        int i = nativeGetDecoderVersion();
        a = new int[4];
        a[0] = (i >> 16);
        a[1] = ((0xFF00 & i) >> 8);
        a[2] = (i & 0xFF);
        i = nativeSetup();
        return i;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        str = str + "libwebp-" + "23.so";
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 17) {
          break;
        }
        str = str + "libwebp-" + "41.so";
      }
    }
    return -1;
    label243:
    return -3;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = paramContext.getFilesDir();
    } while (paramContext == null);
    return paramContext.getParent() + "/txlib/";
  }
  
  public static void a(String paramString)
  {
    if ((a != null) && (paramString != null) && ((paramString.contains("libwebp-")) || (paramString.contains("libskia"))))
    {
      BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 4).edit().putBoolean("WebpHookSupported", false).commit();
      a = null;
      if (QLog.isColorLevel()) {
        QLog.d("WebpSoLoader", 2, String.format("Crash in libwebp support library at %s process!", new Object[] { BaseApplicationImpl.getMobileQQ().getProcessName() }));
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 8) && (Build.VERSION.SDK_INT < 17))
    {
      BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 4).edit().putBoolean("WebpHookEnabled", paramBoolean).commit();
      if (QLog.isColorLevel()) {
        if (!paramBoolean) {
          break label77;
        }
      }
    }
    label77:
    for (String str = "enable";; str = "disable")
    {
      QLog.d("WebpSoLoader", 2, String.format("Set WebpSoLoader %s", new Object[] { str }));
      return;
    }
  }
  
  public static boolean a()
  {
    SharedPreferences localSharedPreferences;
    if (a == null)
    {
      localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 4);
      if ((localSharedPreferences.getBoolean("WebpHookEnabled", true)) && (localSharedPreferences.getBoolean("WebpHookSupported", true)))
      {
        int i = a();
        if (i == 0) {
          break label133;
        }
        if (-3 == i) {
          break label116;
        }
        a = null;
        localSharedPreferences.edit().putBoolean("WebpHookSupported", false).commit();
        if (QLog.isColorLevel())
        {
          if (-1 != i) {
            break label105;
          }
          QLog.d("WebpSoLoader", 2, "WebP support library load failed!");
        }
      }
    }
    while (a != null)
    {
      return true;
      label105:
      QLog.d("WebpSoLoader", 2, "No need to load WebP support library");
      continue;
      label116:
      if (QLog.isColorLevel())
      {
        QLog.d("WebpSoLoader", 2, "WebP support library not ready");
        continue;
        label133:
        if (!localSharedPreferences.contains("WebpHookEnabled")) {
          localSharedPreferences.edit().putBoolean("WebpHookEnabled", true).commit();
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebpSoLoader", 2, "WebP support library load success!");
        }
      }
    }
    return false;
  }
  
  public static int[] a()
  {
    if (a != null) {
      return a;
    }
    int i = Build.VERSION.SDK_INT;
    if ((i >= 14) && (i <= 15)) {
      return new int[] { 0, 1, 2, 0 };
    }
    if (16 == i) {
      return new int[] { 0, 1, 2, 0 };
    }
    if (17 == i) {
      return new int[] { 0, 2, 0, 0 };
    }
    if (18 == i) {
      return new int[] { 0, 2, 1, 0 };
    }
    if (19 == i) {
      return new int[] { 0, 3, 2, 0 };
    }
    if (i > 19) {
      return new int[] { 0, 4, 1, 0 };
    }
    return null;
  }
  
  public static boolean b()
  {
    if ((Build.VERSION.SDK_INT >= 8) && (Build.VERSION.SDK_INT < 17))
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 4);
      if ((localSharedPreferences.getBoolean("WebpHookEnabled", false)) && (localSharedPreferences.getBoolean("WebpHookSupported", true))) {
        return true;
      }
    }
    return false;
  }
  
  private static native int nativeGetDecoderVersion();
  
  private static native int nativeSetup();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\util\WebpSoLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */