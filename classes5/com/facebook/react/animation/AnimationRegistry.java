package com.facebook.react.animation;

import android.util.SparseArray;
import com.facebook.react.bridge.UiThreadUtil;

public class AnimationRegistry
{
  private final SparseArray<Animation> mRegistry = new SparseArray();
  
  public Animation getAnimation(int paramInt)
  {
    UiThreadUtil.assertOnUiThread();
    return (Animation)this.mRegistry.get(paramInt);
  }
  
  public void registerAnimation(Animation paramAnimation)
  {
    UiThreadUtil.assertOnUiThread();
    this.mRegistry.put(paramAnimation.getAnimationID(), paramAnimation);
  }
  
  public Animation removeAnimation(int paramInt)
  {
    UiThreadUtil.assertOnUiThread();
    Animation localAnimation = (Animation)this.mRegistry.get(paramInt);
    if (localAnimation != null) {
      this.mRegistry.delete(paramInt);
    }
    return localAnimation;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\AnimationRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */