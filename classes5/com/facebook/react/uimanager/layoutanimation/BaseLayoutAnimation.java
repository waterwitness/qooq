package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

abstract class BaseLayoutAnimation
  extends AbstractLayoutAnimation
{
  Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1;
    float f2;
    if (isReverse())
    {
      f1 = 1.0F;
      if (!isReverse()) {
        break label96;
      }
      f2 = 0.0F;
    }
    for (;;)
    {
      if (this.mAnimatedProperty != null) {
        switch (this.mAnimatedProperty)
        {
        default: 
          throw new IllegalViewOperationException("Missing animation for property : " + this.mAnimatedProperty);
          f1 = 0.0F;
          break;
          f2 = 1.0F;
          break;
        case ???: 
          return new OpacityAnimation(paramView, f1, f2);
        case ???: 
          label96:
          return new ScaleAnimation(f1, f2, f1, f2, 2, 0.5F, 2, 0.5F);
        }
      }
    }
    throw new IllegalViewOperationException("Missing animated property from animation config");
  }
  
  abstract boolean isReverse();
  
  boolean isValid()
  {
    return (this.mDurationMs > 0) && (this.mAnimatedProperty != null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\layoutanimation\BaseLayoutAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */