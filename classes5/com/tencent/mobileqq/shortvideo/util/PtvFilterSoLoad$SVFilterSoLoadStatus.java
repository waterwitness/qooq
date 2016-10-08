package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import com.tencent.mobileqq.earlydownload.xmldata.QQShortVideoConstFilterData;
import com.tencent.mobileqq.earlydownload.xmldata.QQShortVideoVarFilterData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class PtvFilterSoLoad$SVFilterSoLoadStatus
{
  public static int a = -4;
  public static final String a = "libimage_filter_common.so";
  public static final boolean a = false;
  public static int b = -4;
  public static final String b = "libimage_filter_gpu.so";
  public static int c = -4;
  public static final String c = "libpitu_tools.so";
  public static int d = -4;
  public static final String d = "libimage_filter_cpu.so";
  public static int e = -4;
  public static final String e = "libalgo_youtu_jni.so";
  public static final String f = "noeyegray.png";
  public static final String g = "nomouthgray.png";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString)
  {
    String str1 = paramString + "bakcup/";
    String str2 = str1 + "const_exist";
    String str3 = str1 + "var_exist";
    if (FileUtils.a(str2))
    {
      a(str1 + "libalgo_youtu_jni.so", paramString + "libalgo_youtu_jni.so");
      a(str1 + "libpitu_tools.so", paramString + "libpitu_tools.so");
      FileUtils.d(str2);
    }
    if (FileUtils.a(str3))
    {
      a(str1 + "libimage_filter_common.so", paramString + "libimage_filter_common.so");
      a(str1 + "libimage_filter_gpu.so", paramString + "libimage_filter_gpu.so");
      a(str1 + "libimage_filter_cpu.so", paramString + "libimage_filter_cpu.so");
      a(str1 + "noeyegray.png", paramString + "noeyegray.png");
      a(str1 + "nomouthgray.png", paramString + "nomouthgray.png");
      FileUtils.d(str3);
    }
  }
  
  public static boolean a()
  {
    a = VideoEnvironment.a("image_filter_common");
    b = VideoEnvironment.a("image_filter_gpu");
    c = VideoEnvironment.a("pitu_tools");
    d = VideoEnvironment.a("image_filter_cpu");
    e = VideoEnvironment.a("algo_youtu_jni");
    return b();
  }
  
  public static boolean a(Context arg0)
  {
    if (b()) {
      return true;
    }
    String str = PtvFilterSoLoad.a(???);
    synchronized (PtvFilterSoLoad.a())
    {
      if (a != 0) {
        a = PtvFilterSoLoad.a(str + "libimage_filter_common.so");
      }
      if (b != 0) {
        b = PtvFilterSoLoad.a(str + "libimage_filter_gpu.so");
      }
      if (c != 0) {
        c = PtvFilterSoLoad.a(str + "libpitu_tools.so");
      }
      if (d != 0) {
        d = PtvFilterSoLoad.a(str + "libimage_filter_cpu.so");
      }
      if (e != 0) {
        e = PtvFilterSoLoad.a(str + "libalgo_youtu_jni.so");
      }
      return b();
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if (!paramString1.exists()) {
      return false;
    }
    FileUtils.a(paramString1, paramString2);
    return true;
  }
  
  public static boolean b()
  {
    return (a == 0) && (b == 0) && (c == 0) && (d == 0) && (e == 0);
  }
  
  public static boolean b(Context arg0)
  {
    String str = PtvFilterSoLoad.a(???);
    synchronized (PtvFilterSoLoad.a())
    {
      a(str);
      boolean bool1 = FileUtils.a(str + "libimage_filter_common.so");
      boolean bool2 = FileUtils.a(str + "libimage_filter_gpu.so");
      boolean bool3 = FileUtils.a(str + "libpitu_tools.so");
      boolean bool4 = FileUtils.a(str + "libimage_filter_cpu.so");
      boolean bool5 = FileUtils.a(str + "libalgo_youtu_jni.so");
      if ((bool1) && (bool2) && (bool3) && (bool4) && (bool5)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean c()
  {
    boolean bool1 = PtvFilterSoLoad.a(1, 0, QQShortVideoConstFilterData.class);
    boolean bool2 = PtvFilterSoLoad.a(1, 0, QQShortVideoVarFilterData.class);
    return (bool1) && (bool2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\PtvFilterSoLoad$SVFilterSoLoadStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */