package com.facebook.react;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.MemoryPressure;
import com.facebook.react.bridge.ReactContext;
import javax.annotation.Nullable;

public class MemoryPressureRouter
{
  private static final String ACTION_TRIM_MEMORY = "com.facebook.catalyst.ACTION_TRIM_MEMORY";
  private final ComponentCallbacks2 mCallbacks = new ComponentCallbacks2()
  {
    public void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
    
    public void onLowMemory() {}
    
    public void onTrimMemory(int paramAnonymousInt)
    {
      MemoryPressureRouter.this.trimMemory(paramAnonymousInt);
    }
  };
  @Nullable
  private CatalystInstance mCatalystInstance;
  
  MemoryPressureRouter(Context paramContext)
  {
    paramContext.getApplicationContext().registerComponentCallbacks(this.mCallbacks);
  }
  
  private void dispatchMemoryPressure(MemoryPressure paramMemoryPressure)
  {
    if (this.mCatalystInstance != null) {
      this.mCatalystInstance.handleMemoryPressure(paramMemoryPressure);
    }
  }
  
  @TargetApi(16)
  public static boolean handleDebugIntent(Activity paramActivity, String paramString)
  {
    if ("com.facebook.catalyst.ACTION_TRIM_MEMORY".equals(paramString))
    {
      simulateTrimMemory(paramActivity, 60);
      return true;
    }
    return false;
  }
  
  private static void simulateTrimMemory(Activity paramActivity, int paramInt)
  {
    paramActivity.getApplication().onTrimMemory(paramInt);
    paramActivity.onTrimMemory(paramInt);
  }
  
  private void trimMemory(int paramInt)
  {
    if (paramInt >= 80) {
      dispatchMemoryPressure(MemoryPressure.CRITICAL);
    }
    while ((paramInt < 40) && (paramInt != 15)) {
      return;
    }
    dispatchMemoryPressure(MemoryPressure.MODERATE);
  }
  
  public void destroy(Context paramContext)
  {
    paramContext.getApplicationContext().unregisterComponentCallbacks(this.mCallbacks);
  }
  
  public void onNewReactContextCreated(ReactContext paramReactContext)
  {
    this.mCatalystInstance = paramReactContext.getCatalystInstance();
  }
  
  public void onReactInstanceDestroyed()
  {
    this.mCatalystInstance = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\MemoryPressureRouter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */