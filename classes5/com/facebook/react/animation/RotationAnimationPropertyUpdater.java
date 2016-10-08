package com.facebook.react.animation;

import android.view.View;

public class RotationAnimationPropertyUpdater
  extends AbstractSingleFloatProperyUpdater
{
  public RotationAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }
  
  protected float getProperty(View paramView)
  {
    return paramView.getRotation();
  }
  
  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setRotation((float)Math.toDegrees(paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\RotationAnimationPropertyUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */