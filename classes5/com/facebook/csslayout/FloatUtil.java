package com.facebook.csslayout;

public class FloatUtil
{
  private static final float EPSILON = 1.0E-5F;
  
  public static boolean floatsEqual(float paramFloat1, float paramFloat2)
  {
    if ((Float.isNaN(paramFloat1)) || (Float.isNaN(paramFloat2))) {
      if ((!Float.isNaN(paramFloat1)) || (!Float.isNaN(paramFloat2))) {}
    }
    while (Math.abs(paramFloat2 - paramFloat1) < 1.0E-5F)
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\csslayout\FloatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */