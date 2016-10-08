package com.tribe.async.log;

public class SLog
{
  public static final String LOG_TAG = "async";
  public static final String LOG_TAG_BOSS = "async.boss";
  public static final String LOG_TAG_DISPATCH = "async.dispatch";
  private static ILog mIQLog;
  
  public static void a(String paramString1, String paramString2)
  {
    if (mIQLog != null) {
      mIQLog.a(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (mIQLog != null) {
      mIQLog.a(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (mIQLog != null) {
      mIQLog.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (mIQLog != null) {
      mIQLog.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (mIQLog != null) {
      mIQLog.d(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (mIQLog != null) {
      mIQLog.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (mIQLog != null) {
      mIQLog.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (mIQLog != null) {
      mIQLog.i(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (mIQLog != null) {
      mIQLog.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (mIQLog != null) {
      mIQLog.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void init(ILog paramILog)
  {
    mIQLog = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (mIQLog != null) {
      mIQLog.v(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (mIQLog != null) {
      mIQLog.v(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (mIQLog != null) {
      mIQLog.w(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (mIQLog != null) {
      mIQLog.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (mIQLog != null) {
      mIQLog.w(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    if (mIQLog != null) {
      mIQLog.w(paramString, paramThrowable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\log\SLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */