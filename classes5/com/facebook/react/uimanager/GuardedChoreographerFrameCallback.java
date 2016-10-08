package com.facebook.react.uimanager;

import android.view.Choreographer.FrameCallback;
import com.facebook.react.bridge.ReactContext;

public abstract class GuardedChoreographerFrameCallback
  implements Choreographer.FrameCallback
{
  private final ReactContext mReactContext;
  
  protected GuardedChoreographerFrameCallback(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }
  
  public final void doFrame(long paramLong)
  {
    try
    {
      doFrameGuarded(paramLong);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mReactContext.handleException(localRuntimeException);
    }
  }
  
  protected abstract void doFrameGuarded(long paramLong);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\GuardedChoreographerFrameCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */