package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class PixelUtil
{
  public static float toDIPFromPixel(float paramFloat)
  {
    float f = paramFloat / DisplayMetricsHolder.getDisplayMetrics().density;
    if (paramFloat >= 0.0F) {}
    for (int i = 1;; i = -1) {
      return (int)(i * 0.5F + f);
    }
  }
  
  public static float toPixelFromDIP(double paramDouble)
  {
    return toPixelFromDIP((float)paramDouble);
  }
  
  public static float toPixelFromDIP(float paramFloat)
  {
    float f = DisplayMetricsHolder.getDisplayMetrics().density;
    if (paramFloat >= 0.0F) {}
    for (int i = 1;; i = -1) {
      return (int)(i * 0.5F + paramFloat * f);
    }
  }
  
  public static float toPixelFromSP(double paramDouble)
  {
    return toPixelFromSP((float)paramDouble);
  }
  
  public static float toPixelFromSP(float paramFloat)
  {
    return TypedValue.applyDimension(2, paramFloat, DisplayMetricsHolder.getDisplayMetrics());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\PixelUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */