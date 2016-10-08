package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;

class SimpleSpringInterpolator
  implements Interpolator
{
  private static final float FACTOR = 0.5F;
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(1.0D + Math.pow(2.0D, -10.0F * paramFloat) * Math.sin((paramFloat - 0.125F) * 3.141592653589793D * 2.0D / 0.5D));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\layoutanimation\SimpleSpringInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */