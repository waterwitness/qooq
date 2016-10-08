package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;

class OpacityAnimation
  extends Animation
{
  private final float mDeltaOpacity;
  private final float mStartOpacity;
  private final View mView;
  
  public OpacityAnimation(View paramView, float paramFloat1, float paramFloat2)
  {
    this.mView = paramView;
    this.mStartOpacity = paramFloat1;
    this.mDeltaOpacity = (paramFloat2 - paramFloat1);
    setAnimationListener(new OpacityAnimationListener(paramView));
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.mView.setAlpha(this.mStartOpacity + this.mDeltaOpacity * paramFloat);
  }
  
  public boolean willChangeBounds()
  {
    return false;
  }
  
  static class OpacityAnimationListener
    implements Animation.AnimationListener
  {
    private boolean mLayerTypeChanged = false;
    private final View mView;
    
    public OpacityAnimationListener(View paramView)
    {
      this.mView = paramView;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (this.mLayerTypeChanged) {
        this.mView.setLayerType(0, null);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      if ((this.mView.hasOverlappingRendering()) && (this.mView.getLayerType() == 0))
      {
        this.mLayerTypeChanged = true;
        this.mView.setLayerType(2, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\layoutanimation\OpacityAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */