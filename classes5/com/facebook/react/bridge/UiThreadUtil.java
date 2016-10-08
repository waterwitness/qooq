package com.facebook.react.bridge;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nullable;

public class UiThreadUtil
{
  @Nullable
  private static Handler sMainHandler;
  
  public static void assertNotOnUiThread()
  {
    if (!isOnUiThread()) {}
    for (boolean bool = true;; bool = false)
    {
      SoftAssertions.assertCondition(bool, "Expected not to run on UI thread!");
      return;
    }
  }
  
  public static void assertOnUiThread()
  {
    SoftAssertions.assertCondition(isOnUiThread(), "Expected to run on UI thread!");
  }
  
  public static boolean isOnUiThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    try
    {
      if (sMainHandler == null) {
        sMainHandler = new Handler(Looper.getMainLooper());
      }
      sMainHandler.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public static void runOnUiThread(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (sMainHandler == null) {
        sMainHandler = new Handler(Looper.getMainLooper());
      }
      sMainHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\UiThreadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */