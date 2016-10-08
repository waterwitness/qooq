package com.facebook.react;

import com.facebook.react.bridge.BridgeProfiling;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.JSTimersExecution;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.modules.core.Timing;
import com.facebook.react.modules.debug.AnimationsDebugModule;
import com.facebook.react.modules.debug.DeveloperSettings;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.AppRegistry;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.debug.DebugComponentOwnershipModule;
import com.facebook.react.uimanager.debug.DebugComponentOwnershipModule.RCTDebugComponentOwnership;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CoreModulesPackage
  implements ReactPackage
{
  private final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
  private final ReactInstanceManager mReactInstanceManager;
  private final UIImplementationProvider mUIImplementationProvider;
  
  CoreModulesPackage(ReactInstanceManager paramReactInstanceManager, DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler, UIImplementationProvider paramUIImplementationProvider)
  {
    this.mReactInstanceManager = paramReactInstanceManager;
    this.mHardwareBackBtnHandler = paramDefaultHardwareBackBtnHandler;
    this.mUIImplementationProvider = paramUIImplementationProvider;
  }
  
  public List<Class<? extends JavaScriptModule>> createJSModules()
  {
    return Arrays.asList(new Class[] { DeviceEventManagerModule.RCTDeviceEventEmitter.class, JSTimersExecution.class, RCTEventEmitter.class, RCTNativeAppEventEmitter.class, AppRegistry.class, BridgeProfiling.class, DebugComponentOwnershipModule.RCTDebugComponentOwnership.class });
  }
  
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    ExceptionsManagerModule localExceptionsManagerModule = null;
    Systrace.beginSection(0L, "createUIManagerModule");
    for (;;)
    {
      try
      {
        localObject = this.mReactInstanceManager.createAllViewManagers(paramReactApplicationContext);
        UIManagerModule localUIManagerModule = new UIManagerModule(paramReactApplicationContext, (List)localObject, this.mUIImplementationProvider.createUIImplementation(paramReactApplicationContext, (List)localObject));
        Systrace.endSection(0L);
        if (this.mReactInstanceManager.isUseDeveloperSupport())
        {
          localObject = this.mReactInstanceManager.getDevSupportManager().getDevSettings();
          AnimationsDebugModule localAnimationsDebugModule = new AnimationsDebugModule(paramReactApplicationContext, (DeveloperSettings)localObject);
          AndroidInfoModule localAndroidInfoModule = new AndroidInfoModule();
          DeviceEventManagerModule localDeviceEventManagerModule = new DeviceEventManagerModule(paramReactApplicationContext, this.mHardwareBackBtnHandler);
          localObject = localExceptionsManagerModule;
          if (this.mReactInstanceManager.isUseDeveloperSupport()) {
            localObject = this.mReactInstanceManager.getDevSupportManager();
          }
          localExceptionsManagerModule = new ExceptionsManagerModule((DevSupportManager)localObject);
          Timing localTiming = new Timing(paramReactApplicationContext);
          String str = this.mReactInstanceManager.getSourceUrl();
          if (!this.mReactInstanceManager.isUseDeveloperSupport()) {
            break label241;
          }
          localObject = this.mReactInstanceManager.getDevSupportManager().getSourceMapUrl();
          return Arrays.asList(new NativeModule[] { localAnimationsDebugModule, localAndroidInfoModule, localDeviceEventManagerModule, localExceptionsManagerModule, localTiming, new SourceCodeModule(str, (String)localObject), localUIManagerModule, new DebugComponentOwnershipModule(paramReactApplicationContext) });
        }
      }
      finally
      {
        Systrace.endSection(0L);
      }
      Object localObject = null;
      continue;
      label241:
      localObject = "";
    }
  }
  
  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return new ArrayList(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\CoreModulesPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */