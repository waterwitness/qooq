package com.tencent.mobileqq.pluginsdk.exception;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public final class ExceptionTracker
{
  public static void printCallStack(String paramString)
  {
    printCallStack(paramString, 1);
  }
  
  public static void printCallStack(String paramString, int paramInt)
  {
    int i = paramInt + 3;
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length <= i))
      {
        if (QLog.isColorLevel()) {
          QLog.d(paramString, 2, "printCallStack empty");
        }
      }
      else
      {
        paramInt = i;
        if (QLog.isColorLevel())
        {
          QLog.d(paramString, 2, "printCallStack:");
          paramInt = i;
        }
        while (paramInt < arrayOfStackTraceElement.length)
        {
          if (QLog.isColorLevel()) {
            QLog.d(paramString, 2, "" + arrayOfStackTraceElement[paramInt]);
          }
          paramInt += 1;
        }
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void trackException(String paramString1, String paramString2)
  {
    printCallStack(paramString1, 1);
    try
    {
      throw new IllegalArgumentException(paramString2);
    }
    catch (Exception paramString2)
    {
      new Handler(Looper.getMainLooper()).post(new a(paramString1, paramString2));
      throw new IllegalArgumentException(paramString2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\exception\ExceptionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */