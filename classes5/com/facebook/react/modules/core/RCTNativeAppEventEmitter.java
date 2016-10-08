package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import javax.annotation.Nullable;

public abstract interface RCTNativeAppEventEmitter
  extends JavaScriptModule
{
  public abstract void emit(String paramString, @Nullable Object paramObject);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\core\RCTNativeAppEventEmitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */