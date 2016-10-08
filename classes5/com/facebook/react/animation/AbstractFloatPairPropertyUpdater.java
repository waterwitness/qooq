package com.facebook.react.animation;

import android.view.View;

public abstract class AbstractFloatPairPropertyUpdater
  implements AnimationPropertyUpdater
{
  private boolean mFromSource;
  private final float[] mFromValues = new float[2];
  private final float[] mToValues = new float[2];
  private final float[] mUpdateValues = new float[2];
  
  protected AbstractFloatPairPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    this.mToValues[0] = paramFloat1;
    this.mToValues[1] = paramFloat2;
    this.mFromSource = true;
  }
  
  protected AbstractFloatPairPropertyUpdater(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(paramFloat3, paramFloat4);
    this.mFromValues[0] = paramFloat1;
    this.mFromValues[1] = paramFloat2;
    this.mFromSource = false;
  }
  
  protected abstract void getProperty(View paramView, float[] paramArrayOfFloat);
  
  public void onFinish(View paramView)
  {
    setProperty(paramView, this.mToValues);
  }
  
  public void onUpdate(View paramView, float paramFloat)
  {
    this.mUpdateValues[0] = (this.mFromValues[0] + (this.mToValues[0] - this.mFromValues[0]) * paramFloat);
    this.mUpdateValues[1] = (this.mFromValues[1] + (this.mToValues[1] - this.mFromValues[1]) * paramFloat);
    setProperty(paramView, this.mUpdateValues);
  }
  
  public void prepare(View paramView)
  {
    if (this.mFromSource) {
      getProperty(paramView, this.mFromValues);
    }
  }
  
  protected abstract void setProperty(View paramView, float[] paramArrayOfFloat);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\AbstractFloatPairPropertyUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */