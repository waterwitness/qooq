package com.facebook.react.animation;

public class ImmediateAnimation
  extends Animation
{
  public ImmediateAnimation(int paramInt, AnimationPropertyUpdater paramAnimationPropertyUpdater)
  {
    super(paramInt, paramAnimationPropertyUpdater);
  }
  
  public void run()
  {
    onUpdate(1.0F);
    finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\ImmediateAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */