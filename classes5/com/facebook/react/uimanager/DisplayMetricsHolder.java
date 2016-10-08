package com.facebook.react.uimanager;

import android.util.DisplayMetrics;

public class DisplayMetricsHolder
{
  private static DisplayMetrics sCurrentDisplayMetrics;
  
  public static DisplayMetrics getDisplayMetrics()
  {
    return sCurrentDisplayMetrics;
  }
  
  public static void setDisplayMetrics(DisplayMetrics paramDisplayMetrics)
  {
    sCurrentDisplayMetrics = paramDisplayMetrics;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\DisplayMetricsHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */