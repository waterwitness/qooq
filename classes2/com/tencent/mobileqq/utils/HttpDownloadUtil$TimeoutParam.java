package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HttpDownloadUtil$TimeoutParam
{
  public static int a = 40000;
  public static int b = 30000;
  public static int c = 20000;
  public static int d = 20000;
  public static int e = 15000;
  public static int f = 10000;
  public static int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return a;
    case 1: 
    case 4: 
    case 5: 
      return c;
    }
    return b;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return d + g;
    case 1: 
    case 4: 
    case 5: 
      return f + g;
    }
    return e + g;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\HttpDownloadUtil$TimeoutParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */