package com.facebook.react.animation;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public abstract class Animation
{
  @Nullable
  private View mAnimatedView;
  private final int mAnimationID;
  @Nullable
  private AnimationListener mAnimationListener;
  private volatile boolean mCancelled = false;
  private volatile boolean mIsFinished = false;
  private final AnimationPropertyUpdater mPropertyUpdater;
  
  public Animation(int paramInt, AnimationPropertyUpdater paramAnimationPropertyUpdater)
  {
    this.mAnimationID = paramInt;
    this.mPropertyUpdater = paramAnimationPropertyUpdater;
  }
  
  public final void cancel()
  {
    if ((this.mIsFinished) || (this.mCancelled)) {}
    do
    {
      return;
      this.mCancelled = true;
    } while (this.mAnimationListener == null);
    this.mAnimationListener.onCancel();
  }
  
  protected final void finish()
  {
    if (this.mIsFinished) {
      if (FLog.isLoggable(6)) {
        FLog.e("Exceptione", "Animation must not already be finished!");
      }
    }
    do
    {
      do
      {
        return;
        this.mIsFinished = true;
      } while (this.mCancelled);
      if (this.mAnimatedView != null) {
        this.mPropertyUpdater.onFinish(this.mAnimatedView);
      }
    } while (this.mAnimationListener == null);
    this.mAnimationListener.onFinished();
  }
  
  public int getAnimationID()
  {
    return this.mAnimationID;
  }
  
  protected final boolean onUpdate(float paramFloat)
  {
    if (this.mIsFinished)
    {
      if (FLog.isLoggable(6)) {
        FLog.e("Exception", "Animation must not already be finished!");
      }
      return true;
    }
    if (!this.mCancelled) {
      this.mPropertyUpdater.onUpdate((View)Assertions.assertNotNull(this.mAnimatedView), paramFloat);
    }
    if (!this.mCancelled) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public abstract void run();
  
  public void setAnimationListener(AnimationListener paramAnimationListener)
  {
    this.mAnimationListener = paramAnimationListener;
  }
  
  public final void start(View paramView)
  {
    this.mAnimatedView = paramView;
    this.mPropertyUpdater.prepare(paramView);
    run();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\Animation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */