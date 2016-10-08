package com.facebook.react.uimanager;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;

public abstract interface AppRegistry
  extends JavaScriptModule
{
  public abstract void runApplication(String paramString, WritableMap paramWritableMap);
  
  public abstract void unmountApplicationComponentAtRootTag(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\AppRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */