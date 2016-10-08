package com.facebook.react.uimanager;

import android.content.Context;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;

public class ThemedReactContext
  extends ReactContext
{
  private final ReactApplicationContext mReactApplicationContext;
  
  public ThemedReactContext(ReactApplicationContext paramReactApplicationContext, Context paramContext)
  {
    super(paramContext);
    initializeWithInstance(paramReactApplicationContext.getCatalystInstance());
    this.mReactApplicationContext = paramReactApplicationContext;
  }
  
  public void addLifecycleEventListener(LifecycleEventListener paramLifecycleEventListener)
  {
    this.mReactApplicationContext.addLifecycleEventListener(paramLifecycleEventListener);
  }
  
  public void removeLifecycleEventListener(LifecycleEventListener paramLifecycleEventListener)
  {
    this.mReactApplicationContext.removeLifecycleEventListener(paramLifecycleEventListener);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ThemedReactContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */