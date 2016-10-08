package com.facebook.react.animation;

import android.view.View;

public abstract class AbstractSingleFloatProperyUpdater
  implements AnimationPropertyUpdater
{
  private boolean mFromSource;
  private float mFromValue;
  private float mToValue;
  
  protected AbstractSingleFloatProperyUpdater(float paramFloat)
  {
    this.mToValue = paramFloat;
    this.mFromSource = true;
  }
  
  protected AbstractSingleFloatProperyUpdater(float paramFloat1, float paramFloat2)
  {
    this(paramFloat2);
    this.mFromValue = paramFloat1;
    this.mFromSource = false;
  }
  
  protected abstract float getProperty(View paramView);
  
  public void onFinish(View paramView)
  {
    setProperty(paramView, this.mToValue);
  }
  
  public final void onUpdate(View paramView, float paramFloat)
  {
    setProperty(paramView, this.mFromValue + (this.mToValue - this.mFromValue) * paramFloat);
  }
  
  public final void prepare(View paramView)
  {
    if (this.mFromSource) {
      this.mFromValue = getProperty(paramView);
    }
  }
  
  protected abstract void setProperty(View paramView, float paramFloat);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\AbstractSingleFloatProperyUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */