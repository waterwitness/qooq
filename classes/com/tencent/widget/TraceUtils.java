package com.tencent.widget;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Method;

public class TraceUtils
{
  public static final long a = 0L;
  private static Method a;
  public static final boolean a = false;
  public static final long b = 1L;
  private static Method b;
  public static final long c = 2L;
  private static Method c;
  public static final long d = 4L;
  private static Method d;
  public static final long e = 8L;
  public static final long f = 16L;
  public static final long g = 32L;
  public static final long h = 64L;
  public static final long i = 128L;
  public static final long j = 256L;
  public static final long k = 512L;
  public static final long l = 1024L;
  public static final long m = 2048L;
  public static final long n = 4096L;
  public static final long o = 8192L;
  public static final long p = 16384L;
  public static final long q = 32768L;
  private static final long r = Long.MIN_VALUE;
  
  public TraceUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a() {}
  
  public static void a(long paramLong, String paramString, int paramInt)
  {
    if ((Build.VERSION.SDK_INT <= 17) || (c == null)) {}
    try
    {
      c = Class.forName("android.os.Trace").getMethod("asyncTraceBegin", new Class[] { Long.TYPE, String.class, Integer.TYPE });
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          c.invoke(null, new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
          return;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString) {}
  
  public static void b(long paramLong, String paramString, int paramInt)
  {
    if ((Build.VERSION.SDK_INT <= 17) || (d == null)) {}
    try
    {
      d = Class.forName("android.os.Trace").getMethod("asyncTraceEnd", new Class[] { Long.TYPE, String.class, Integer.TYPE });
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          d.invoke(null, new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
          return;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\TraceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */