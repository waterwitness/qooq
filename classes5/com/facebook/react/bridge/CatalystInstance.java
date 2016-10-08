package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.CatalystQueueConfiguration;
import com.facebook.react.common.annotations.VisibleForTesting;
import java.util.Collection;

@DoNotStrip
public abstract interface CatalystInstance
{
  public abstract void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener);
  
  public abstract void destroy();
  
  public abstract void executeJSScript(String paramString);
  
  public abstract CatalystQueueConfiguration getCatalystQueueConfiguration();
  
  public abstract <T extends JavaScriptModule> T getJSModule(Class<T> paramClass);
  
  public abstract <T extends NativeModule> T getNativeModule(Class<T> paramClass);
  
  public abstract Collection<NativeModule> getNativeModules();
  
  public abstract CatalystInstanceImpl.NativeModulesReactCallback getNativeModulesReactCallback();
  
  public abstract void handleMemoryPressure(MemoryPressure paramMemoryPressure);
  
  @VisibleForTesting
  public abstract void initialize();
  
  @DoNotStrip
  public abstract void invokeCallback(int paramInt, Object[] paramArrayOfObject);
  
  public abstract boolean isDestroyed();
  
  public abstract void loadBundle(String paramString, String[] paramArrayOfString);
  
  public abstract void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener);
  
  public abstract void runJSBundle();
  
  public abstract void startProfiler(String paramString);
  
  public abstract void stopProfiler(String paramString1, String paramString2);
  
  public abstract boolean supportsProfiling();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\CatalystInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */