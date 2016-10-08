package com.tencent.util;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class VersionUtils
{
  private VersionUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 7;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean e()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean f()
  {
    return Build.VERSION.SDK_INT >= 13;
  }
  
  public static boolean g()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean h()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\VersionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */