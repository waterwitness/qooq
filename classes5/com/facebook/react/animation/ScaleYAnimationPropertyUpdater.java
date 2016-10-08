package com.facebook.react.animation;

import android.view.View;

public class ScaleYAnimationPropertyUpdater
  extends AbstractSingleFloatProperyUpdater
{
  public ScaleYAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }
  
  public ScaleYAnimationPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }
  
  protected float getProperty(View paramView)
  {
    return paramView.getScaleY();
  }
  
  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\ScaleYAnimationPropertyUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */