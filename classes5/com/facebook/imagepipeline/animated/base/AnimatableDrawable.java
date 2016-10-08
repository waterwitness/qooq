package com.facebook.imagepipeline.animated.base;

import android.graphics.drawable.Animatable;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

public abstract interface AnimatableDrawable
  extends Animatable
{
  public abstract ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener();
  
  public abstract ValueAnimator createValueAnimator();
  
  public abstract ValueAnimator createValueAnimator(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatableDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */