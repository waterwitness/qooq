package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;

public class DeviceEventManagerModule
  extends ReactContextBaseJavaModule
{
  private final Runnable mInvokeDefaultBackPressRunnable;
  
  public DeviceEventManagerModule(ReactApplicationContext paramReactApplicationContext, final DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    super(paramReactApplicationContext);
    this.mInvokeDefaultBackPressRunnable = new Runnable()
    {
      public void run()
      {
        UiThreadUtil.assertOnUiThread();
        paramDefaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
      }
    };
  }
  
  public void emitHardwareBackPressed()
  {
    ((RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("hardwareBackPress", null);
  }
  
  public String getName()
  {
    return "DeviceEventManager";
  }
  
  @ReactMethod
  public void invokeDefaultBackPressHandler()
  {
    getReactApplicationContext().runOnUiQueueThread(this.mInvokeDefaultBackPressRunnable);
  }
  
  public static abstract interface RCTDeviceEventEmitter
    extends JavaScriptModule
  {
    public abstract void emit(String paramString, @Nullable Object paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\core\DeviceEventManagerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */