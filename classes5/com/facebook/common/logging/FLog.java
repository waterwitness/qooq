package com.facebook.common.logging;

public class FLog
{
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  private static LoggingDelegate sHandler = ;
  
  public static void d(Class<?> paramClass, String paramString)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(getTag(paramClass), paramString);
    }
  }
  
  public static void d(Class<?> paramClass, String paramString, Object paramObject)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(getTag(paramClass), formatString(paramString, new Object[] { paramObject }));
    }
  }
  
  public static void d(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(getTag(paramClass), formatString(paramString, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void d(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(getTag(paramClass), formatString(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void d(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(getTag(paramClass), formatString(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void d(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(getTag(paramClass), paramString, paramThrowable);
    }
  }
  
  public static void d(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(getTag(paramClass), formatString(paramString, paramVarArgs));
    }
  }
  
  public static void d(Class<?> paramClass, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(getTag(paramClass), formatString(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(paramString1, formatString(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(3)) {
      sHandler.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(3)) {
      d(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void d(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(3)) {
      d(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void e(Class<?> paramClass, String paramString)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(getTag(paramClass), paramString);
    }
  }
  
  public static void e(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(getTag(paramClass), paramString, paramThrowable);
    }
  }
  
  public static void e(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(getTag(paramClass), formatString(paramString, paramVarArgs));
    }
  }
  
  public static void e(Class<?> paramClass, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(getTag(paramClass), formatString(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  private static String formatString(String paramString, Object... paramVarArgs)
  {
    return String.format(null, paramString, paramVarArgs);
  }
  
  public static int getMinimumLoggingLevel()
  {
    return sHandler.getMinimumLoggingLevel();
  }
  
  private static String getTag(Class<?> paramClass)
  {
    return paramClass.getSimpleName();
  }
  
  public static void i(Class<?> paramClass, String paramString)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(getTag(paramClass), paramString);
    }
  }
  
  public static void i(Class<?> paramClass, String paramString, Object paramObject)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(getTag(paramClass), formatString(paramString, new Object[] { paramObject }));
    }
  }
  
  public static void i(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(getTag(paramClass), formatString(paramString, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void i(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(getTag(paramClass), formatString(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void i(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(getTag(paramClass), formatString(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void i(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(getTag(paramClass), paramString, paramThrowable);
    }
  }
  
  public static void i(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(getTag(paramClass), formatString(paramString, paramVarArgs));
    }
  }
  
  public static void i(Class<?> paramClass, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (isLoggable(4)) {
      sHandler.i(getTag(paramClass), formatString(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object paramObject)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(paramString1, formatString(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void i(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void i(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void i(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void i(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(4)) {
      sHandler.i(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static boolean isLoggable(int paramInt)
  {
    return sHandler.isLoggable(paramInt);
  }
  
  public static void printStack()
  {
    StringBuilder localStringBuilder;
    StackTraceElement[] arrayOfStackTraceElement;
    int i;
    if (isLoggable(3))
    {
      localStringBuilder = new StringBuilder(200);
      arrayOfStackTraceElement = new Throwable().getStackTrace();
      i = 0;
    }
    for (;;)
    {
      if (i >= arrayOfStackTraceElement.length)
      {
        i("Stack", localStringBuilder.toString());
        return;
      }
      localStringBuilder.append("class: ").append(arrayOfStackTraceElement[i].getClassName()).append("; method: ").append(arrayOfStackTraceElement[i].getMethodName()).append("; number: ").append(arrayOfStackTraceElement[i].getLineNumber());
      localStringBuilder.append("\n");
      i += 1;
    }
  }
  
  public static void setLoggingDelegate(LoggingDelegate paramLoggingDelegate)
  {
    if (paramLoggingDelegate == null) {
      throw new IllegalArgumentException();
    }
    sHandler = paramLoggingDelegate;
  }
  
  public static void setMinimumLoggingLevel(int paramInt)
  {
    sHandler.setMinimumLoggingLevel(paramInt);
  }
  
  public static void v(Class<?> paramClass, String paramString)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(getTag(paramClass), paramString);
    }
  }
  
  public static void v(Class<?> paramClass, String paramString, Object paramObject)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(getTag(paramClass), formatString(paramString, new Object[] { paramObject }));
    }
  }
  
  public static void v(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(getTag(paramClass), formatString(paramString, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void v(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (isLoggable(2)) {
      v(paramClass, formatString(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void v(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(getTag(paramClass), formatString(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void v(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(getTag(paramClass), paramString, paramThrowable);
    }
  }
  
  public static void v(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(getTag(paramClass), formatString(paramString, paramVarArgs));
    }
  }
  
  public static void v(Class<?> paramClass, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(getTag(paramClass), formatString(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(paramString1, formatString(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void v(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(2)) {
      sHandler.v(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void w(Class<?> paramClass, String paramString)
  {
    if (sHandler.isLoggable(5)) {
      sHandler.w(getTag(paramClass), paramString);
    }
  }
  
  public static void w(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(5)) {
      sHandler.w(getTag(paramClass), paramString, paramThrowable);
    }
  }
  
  public static void w(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(5)) {
      sHandler.w(getTag(paramClass), formatString(paramString, paramVarArgs));
    }
  }
  
  public static void w(Class<?> paramClass, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (isLoggable(5)) {
      w(paramClass, formatString(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (sHandler.isLoggable(5)) {
      sHandler.w(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(5)) {
      sHandler.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(5)) {
      sHandler.w(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void w(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(5)) {
      sHandler.w(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void wtf(Class<?> paramClass, String paramString)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(getTag(paramClass), paramString);
    }
  }
  
  public static void wtf(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.wtf(getTag(paramClass), paramString, paramThrowable);
    }
  }
  
  public static void wtf(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.wtf(getTag(paramClass), formatString(paramString, paramVarArgs));
    }
  }
  
  public static void wtf(Class<?> paramClass, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.wtf(getTag(paramClass), formatString(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public static void wtf(String paramString1, String paramString2)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.e(paramString1, paramString2);
    }
  }
  
  public static void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.wtf(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void wtf(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.wtf(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void wtf(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (sHandler.isLoggable(6)) {
      sHandler.wtf(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\logging\FLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */