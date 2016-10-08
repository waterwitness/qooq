package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.modules.debug.DeveloperSettings;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import java.lang.reflect.Constructor;

public abstract class DevSupportManager
  implements NativeModuleCallExceptionHandler
{
  protected static Class<? extends DevSupportManager> sImplClass;
  protected final Context mApplicationContext;
  protected final ReactInstanceDevCommandsHandler mReactInstanceCommandsHandler;
  
  public DevSupportManager(Context paramContext, ReactInstanceDevCommandsHandler paramReactInstanceDevCommandsHandler, boolean paramBoolean)
  {
    this.mReactInstanceCommandsHandler = paramReactInstanceDevCommandsHandler;
    this.mApplicationContext = paramContext;
  }
  
  public static DevSupportManager createDevSupportManager(Context paramContext, ReactInstanceDevCommandsHandler paramReactInstanceDevCommandsHandler, boolean paramBoolean)
  {
    Object localObject = null;
    if (sImplClass != null) {}
    try
    {
      localObject = Boolean.TYPE;
      localObject = (DevSupportManager)sImplClass.getConstructor(new Class[] { Context.class, ReactInstanceDevCommandsHandler.class, localObject }).newInstance(new Object[] { paramContext, paramReactInstanceDevCommandsHandler, Boolean.valueOf(paramBoolean) });
      return (DevSupportManager)localObject;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static boolean isSupportDevMode()
  {
    return sImplClass != null;
  }
  
  public static void setDevSupportManagerImplClass(Class<? extends DevSupportManager> paramClass)
  {
    sImplClass = paramClass;
  }
  
  public abstract DeveloperSettings getDevSettings();
  
  public abstract boolean getDevSupportEnabled();
  
  public abstract String[] getDownloadedJSBundleFile();
  
  public abstract String getJSBundleURLForRemoteDebugging();
  
  public abstract JavaScriptExecutor getJavaScriptExecutor();
  
  public abstract JavaScriptExecutor getJavaScriptExecutor(JavaJSExecutor paramJavaJSExecutor);
  
  public abstract String getSourceMapUrl();
  
  public abstract String getSourceUrl();
  
  public abstract void onNewReactContextCreated(ReactContext paramReactContext);
  
  public abstract void onReactInstanceDestroyed(ReactContext paramReactContext);
  
  public abstract void recreateReactContextInBackgroundInner();
  
  public abstract void setDevSupportEnabled(boolean paramBoolean);
  
  public abstract void showDevOptionsDialog();
  
  public abstract void showNewJSError(String paramString, ReadableArray paramReadableArray, int paramInt);
  
  public abstract void updateJSError(String paramString, ReadableArray paramReadableArray, int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\devsupport\DevSupportManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */