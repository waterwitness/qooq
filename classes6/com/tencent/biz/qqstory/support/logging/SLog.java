package com.tencent.biz.qqstory.support.logging;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SLog
{
  public static final int a = 2;
  private static LoggingDelegate a = QQStoryLoggingDelegate.a();
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 5;
  public static final int e = 6;
  public static final int f = 7;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    return a.a();
  }
  
  private static String a(Class paramClass)
  {
    return paramClass.getSimpleName();
  }
  
  private static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(null, paramString, paramVarArgs);
  }
  
  public static void a(int paramInt)
  {
    a.a(paramInt);
  }
  
  public static void a(LoggingDelegate paramLoggingDelegate)
  {
    if (paramLoggingDelegate == null) {
      throw new IllegalArgumentException();
    }
    a = paramLoggingDelegate;
  }
  
  public static void a(Class paramClass, String paramString)
  {
    if (a.a(5)) {
      a.d(a(paramClass), paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a.a(2)) {
      a.a(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject)
  {
    if (a.a(3)) {
      a.b(paramString1, a(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (a.a(3)) {
      a.b(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (a.a(3)) {
      a.b(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (a.a(3)) {
      a.b(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(3)) {
      a.b(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.a(2)) {
      a.a(paramString1, a(paramString2, paramVarArgs));
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.a(3)) {
      a(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return a.a(paramInt);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a.a(3)) {
      a.b(paramString1, paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject)
  {
    if (a.a(4)) {
      a.c(paramString1, a(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (a.a(4)) {
      a.c(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (a.a(4)) {
      a.c(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (a.a(4)) {
      a.c(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(5)) {
      a.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.a(3)) {
      b(paramString1, a(paramString2, paramVarArgs));
    }
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.a(4)) {
      a.c(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a.a(4)) {
      a.c(paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(6)) {
      a.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.a(4)) {
      a.c(paramString1, a(paramString2, paramVarArgs));
    }
  }
  
  public static void c(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.a(5)) {
      a.d(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a.a(5)) {
      a.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(6)) {
      a.f(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.a(5)) {
      a.d(paramString1, a(paramString2, paramVarArgs));
    }
  }
  
  public static void d(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.a(6)) {
      a.e(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a.a(6)) {
      a.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.a(6)) {
      a.e(paramString1, a(paramString2, paramVarArgs));
    }
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.a(6)) {
      a.f(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if (a.a(6)) {
      a.e(paramString1, paramString2);
    }
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.a(6)) {
      a.f(paramString1, a(paramString2, paramVarArgs));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\support\logging\SLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */