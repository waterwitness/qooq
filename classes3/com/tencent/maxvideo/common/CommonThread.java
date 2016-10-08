package com.tencent.maxvideo.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class CommonThread
  extends HandlerThread
{
  private static String TAG = "CommonThread";
  private static CommonThread instance = new CommonThread(TAG);
  private static Handler mHandler;
  private static boolean mIsStart = false;
  
  public CommonThread(String paramString)
  {
    super(paramString);
  }
  
  public static int getCommonThreadId()
  {
    try
    {
      int i = instance.getThreadId();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static Looper getCommonThreadLooper()
  {
    try
    {
      startThread();
      Looper localLooper = instance.getLooper();
      return localLooper;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void newHandler()
  {
    if (mHandler == null) {
      mHandler = new Handler(getCommonThreadLooper());
    }
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    try
    {
      newHandler();
      boolean bool = mHandler.post(paramRunnable);
      return bool;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public static boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    try
    {
      newHandler();
      boolean bool = mHandler.postDelayed(paramRunnable, paramLong);
      return bool;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public static boolean quitCommonThread()
  {
    try
    {
      boolean bool = instance.quit();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void removeCallbacks(Runnable paramRunnable)
  {
    try
    {
      newHandler();
      mHandler.removeCallbacks(paramRunnable);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  private static void startThread()
  {
    if (!mIsStart)
    {
      mIsStart = true;
      instance.start();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\maxvideo\common\CommonThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */