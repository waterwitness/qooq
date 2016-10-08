package com.tencent.open;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.util.Logger;

public class OpenLog
{
  private static Logger a;
  
  public OpenLog()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static Logger a()
  {
    try
    {
      if (a == null)
      {
        a = new Logger();
        a.a("OpenLog");
        a.a(4);
      }
      Logger localLogger = a;
      return localLogger;
    }
    finally {}
  }
  
  public static Logger a(String paramString1, int paramInt, String paramString2)
  {
    return a().d(paramString1, paramInt, paramString2);
  }
  
  public static void a()
  {
    a().b();
  }
  
  public static Logger b(String paramString1, int paramInt, String paramString2)
  {
    return a().c(paramString1, paramInt, paramString2);
  }
  
  public static void b()
  {
    a().a();
  }
  
  public static Logger c(String paramString1, int paramInt, String paramString2)
  {
    return a().b(paramString1, paramInt, paramString2);
  }
  
  public static Logger d(String paramString1, int paramInt, String paramString2)
  {
    return a().a(paramString1, paramInt, paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\OpenLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */