package com.facebook.react;

import android.content.Context;
import android.content.Intent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public abstract class ReactInstanceManager
{
  public static ReactInstanceManager mReactInstanceManager = null;
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static void initializeSoLoaderIfNecessary(Context paramContext)
  {
    SoLoader.init(paramContext, false);
  }
  
  public abstract void addReactInstanceEventListener(ReactInstanceEventListener paramReactInstanceEventListener);
  
  public abstract void attachMeasuredRootView(ReactRootView paramReactRootView);
  
  public abstract List<ViewManager> createAllViewManagers(ReactApplicationContext paramReactApplicationContext);
  
  public abstract void createReactContextInBackground();
  
  public abstract void detachRootView(ReactRootView paramReactRootView);
  
  @Nullable
  @VisibleForTesting
  public abstract ReactContext getCurrentReactContext();
  
  public abstract DevSupportManager getDevSupportManager();
  
  public abstract String getSourceUrl();
  
  public abstract boolean hasStartedCreatingInitialContext();
  
  public abstract boolean isScrollIdle();
  
  public abstract boolean isUseDeveloperSupport();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onBackPressed();
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume(DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler);
  
  public abstract void showDevOptionsDialog();
  
  public static class Builder
  {
    @Nullable
    protected Context mApplication;
    @Nullable
    protected NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    @Nullable
    protected LifecycleState mInitialLifecycleState;
    @Nullable
    protected String mJSBundleFile;
    @Nullable
    protected String mJSMainModuleName;
    protected final List<ReactPackage> mPackages = new ArrayList();
    @Nullable
    protected UIImplementationProvider mUIImplementationProvider;
    protected boolean mUseDeveloperSupport;
    
    public Builder addPackage(ReactPackage paramReactPackage)
    {
      this.mPackages.add(paramReactPackage);
      return this;
    }
    
    public ReactInstanceManager build()
    {
      boolean bool2 = false;
      if ((this.mUseDeveloperSupport) || (this.mJSBundleFile != null)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Assertions.assertCondition(bool1, "JS Bundle File has to be provided when dev support is disabled");
        if (this.mJSMainModuleName == null)
        {
          bool1 = bool2;
          if (this.mJSBundleFile == null) {}
        }
        else
        {
          bool1 = true;
        }
        Assertions.assertCondition(bool1, "Either MainModuleName or JS Bundle File needs to be provided");
        if (this.mUIImplementationProvider == null) {
          this.mUIImplementationProvider = new UIImplementationProvider();
        }
        return new ReactInstanceManagerImpl((Context)Assertions.assertNotNull(this.mApplication, "Application property has not been set with this builder"), this.mJSBundleFile, this.mJSMainModuleName, this.mPackages, this.mUseDeveloperSupport, this.mBridgeIdleDebugListener, (LifecycleState)Assertions.assertNotNull(this.mInitialLifecycleState, "Initial lifecycle state was not set"), this.mUIImplementationProvider);
      }
    }
    
    public Builder setApplication(Context paramContext)
    {
      this.mApplication = paramContext;
      return this;
    }
    
    public Builder setBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
    {
      this.mBridgeIdleDebugListener = paramNotThreadSafeBridgeIdleDebugListener;
      return this;
    }
    
    public Builder setBundleAssetName(String paramString)
    {
      if (paramString == null) {}
      for (paramString = null;; paramString = "assets://" + paramString) {
        return setJSBundleFile(paramString);
      }
    }
    
    public Builder setInitialLifecycleState(LifecycleState paramLifecycleState)
    {
      this.mInitialLifecycleState = paramLifecycleState;
      return this;
    }
    
    public Builder setJSBundleFile(String paramString)
    {
      this.mJSBundleFile = paramString;
      return this;
    }
    
    public Builder setJSMainModuleName(String paramString)
    {
      this.mJSMainModuleName = paramString;
      return this;
    }
    
    public Builder setUIImplementationProvider(@Nullable UIImplementationProvider paramUIImplementationProvider)
    {
      this.mUIImplementationProvider = paramUIImplementationProvider;
      return this;
    }
    
    public Builder setUseDeveloperSupport(boolean paramBoolean)
    {
      this.mUseDeveloperSupport = paramBoolean;
      return this;
    }
  }
  
  public static abstract interface ReactInstanceEventListener
  {
    public abstract void onReactContextInitialized(ReactContext paramReactContext);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\ReactInstanceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */