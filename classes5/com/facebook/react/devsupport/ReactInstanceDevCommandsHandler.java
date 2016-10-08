package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaJSExecutor;

public abstract interface ReactInstanceDevCommandsHandler
{
  public abstract void onJSBundleLoadedFromServer();
  
  public abstract void onReloadWithJSDebugger(JavaJSExecutor paramJavaJSExecutor);
  
  public abstract void toggleElementInspector();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\devsupport\ReactInstanceDevCommandsHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */