package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

public abstract interface RCTEventEmitter
  extends JavaScriptModule
{
  public abstract void receiveEvent(int paramInt, String paramString, @Nullable WritableMap paramWritableMap);
  
  public abstract void receiveTouches(String paramString, WritableArray paramWritableArray1, WritableArray paramWritableArray2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\events\RCTEventEmitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */