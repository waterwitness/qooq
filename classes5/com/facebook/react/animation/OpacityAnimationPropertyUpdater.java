package com.facebook.react.animation;

import android.view.View;

public class OpacityAnimationPropertyUpdater
  extends AbstractSingleFloatProperyUpdater
{
  public OpacityAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }
  
  public OpacityAnimationPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }
  
  protected float getProperty(View paramView)
  {
    return paramView.getAlpha();
  }
  
  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\OpacityAnimationPropertyUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */