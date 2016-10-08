package com.facebook.react.bridge;

import android.app.Activity;
import javax.annotation.Nullable;

public abstract class ReactContextBaseJavaModule
  extends BaseJavaModule
{
  private final ReactApplicationContext mReactApplicationContext;
  
  public ReactContextBaseJavaModule(ReactApplicationContext paramReactApplicationContext)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
  }
  
  @Nullable
  protected final Activity getCurrentActivity()
  {
    return null;
  }
  
  protected final ReactApplicationContext getReactApplicationContext()
  {
    return this.mReactApplicationContext;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\ReactContextBaseJavaModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */