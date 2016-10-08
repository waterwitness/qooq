package com.tencent.av.opengl.ui.animation;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GLAnimation$LeInterpolator
{
  private static final byte a = 34;
  private static byte b = 34;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(float paramFloat)
  {
    float f = Math.abs(paramFloat);
    paramFloat = f;
    if (b == 34)
    {
      if (f <= 0.4F) {
        paramFloat = (float)(3.0D * Math.pow(f, 2.0D));
      }
    }
    else {
      return paramFloat;
    }
    return (float)(1.0D - 6.0D * Math.pow(1.0F - f, 5.0D));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\ui\animation\GLAnimation$LeInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */