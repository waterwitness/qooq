package com.tencent.bitapp.manager;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager.Builder;
import com.facebook.react.ReactInstanceManagerImpl;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.fresco.FrescoModule.FrescoHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.tencent.bitapp.Const;
import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.bundle.BundleCache;
import com.tencent.bitapp.bundle.BundleStateMachineCache;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.module.ModuleCache;
import com.tencent.bitapp.module.ModuleDependency;
import com.tencent.bitapp.module.ModuleStateMachineCache;
import com.tencent.bitapp.nativemodule.BitAppNativeModulePackage;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.pre.binder.client.IJava2jniClient;
import com.tencent.bitapp.pre.binder.client.Java2jniClientFactory;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import com.tencent.bitapp.report.RNReport;
import com.tencent.bitapp.thread.ThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BitAppInstanceManager
  extends ReactInstanceManagerImpl
{
  private static final String TAG = BitAppInstanceManager.class.getSimpleName();
  private static volatile boolean isInitContextOk;
  public static String mAppInterfaceName = null;
  private static BitAppInstanceManager mInst;
  private static ReactContextInitAsyncTask mReactContextInitAsyncTask = null;
  private static IPackageFactory sPackageFactory;
  private List<String> allBundles = new ArrayList();
  private Set<String> mBundleLoaded = new HashSet();
  
  static
  {
    isInitContextOk = false;
    mInst = null;
    sPackageFactory = null;
  }
  
  private BitAppInstanceManager(Context paramContext, String paramString1, String paramString2, List<ReactPackage> paramList, boolean paramBoolean, NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener, LifecycleState paramLifecycleState)
  {
    super(paramContext, paramString1, paramString2, paramList, paramBoolean, paramNotThreadSafeBridgeIdleDebugListener, paramLifecycleState, new UIImplementationProvider());
  }
  
  private List<String> addBundles(String[] paramArrayOfString)
  {
    ArrayList localArrayList;
    int i;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      localArrayList = new ArrayList(j);
      i = 0;
      if (i < j) {}
    }
    for (paramArrayOfString = localArrayList;; paramArrayOfString = new ArrayList(0))
    {
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "addBundles list: " + paramArrayOfString.toString());
      }
      return paramArrayOfString;
      String str = paramArrayOfString[i];
      if ((!TextUtils.isEmpty(str)) && (this.allBundles.indexOf(str) < 0))
      {
        this.allBundles.add(str);
        localArrayList.add(str);
      }
      i += 1;
      break;
    }
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static BitAppInstanceManager getInstance()
  {
    label164:
    for (;;)
    {
      try
      {
        if (mInst == null)
        {
          Context localContext = ContextUtils.INSTANCE.getApplicationContext();
          if (FLog.isLoggable(3)) {
            FLog.i(TAG, "Create BitAppInstanceManager context: " + localContext);
          }
          if (localContext == null)
          {
            localObject1 = null;
            return (BitAppInstanceManager)localObject1;
          }
          ReactInstanceManager.Builder localBuilder = builder().setApplication(localContext);
          if (sPackageFactory != null)
          {
            localObject1 = sPackageFactory.createPackage();
            mInst = ((Builder)localBuilder.addPackage((ReactPackage)localObject1).setUseDeveloperSupport(DevSupportManager.isSupportDevMode()).setInitialLifecycleState(LifecycleState.RESUMED)).build();
            initializeSoLoaderIfNecessary(localContext);
            SoLoaderShim.setHandler(new FrescoModule.FrescoHandler());
            com.facebook.react.ReactInstanceManager.mReactInstanceManager = mInst;
            if (!FLog.isLoggable(3)) {
              break label164;
            }
            FLog.setMinimumLoggingLevel(3);
            isInitContextOk = false;
          }
        }
        else
        {
          localObject1 = mInst;
          continue;
        }
        Object localObject1 = new BitAppNativeModulePackage();
        continue;
        FLog.setMinimumLoggingLevel(6);
      }
      finally {}
    }
  }
  
  private void loadBundleContextRready(final ReactContext paramReactContext, final Bundle paramBundle, final LoadBundleCallBack paramLoadBundleCallBack, final boolean paramBoolean)
  {
    if (mInst != null) {
      new Thread(new Runnable()
      {
        public void run()
        {
          if (FLog.isLoggable(3)) {
            FLog.i(BitAppInstanceManager.TAG, "loadBundle isForceReload: " + paramBoolean);
          }
          String str = paramBundle.getKey();
          if (paramReactContext == null) {
            if (FLog.isLoggable(6)) {
              FLog.e("Exception", "context should not be null");
            }
          }
          label293:
          label309:
          for (;;)
          {
            return;
            Object localObject;
            if (paramBoolean)
            {
              localObject = BitAppInstanceManager.this.allBundles.iterator();
              if (!((Iterator)localObject).hasNext()) {
                BitAppInstanceManager.this.mBundleLoaded.remove(str);
              }
            }
            else
            {
              if ((!paramBoolean) && (BitAppInstanceManager.this.mBundleLoaded.contains(str))) {
                break label293;
              }
              localObject = BitAppInstanceManager.this.addBundles(paramBundle.getBundles());
              if (Const.isTestPerformance) {
                FLog.i("bitapp_performance", "Begin load bundle list: " + localObject.toString());
              }
              String[] arrayOfString = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
              paramReactContext.loadBundle(str, arrayOfString);
              if (Const.isTestPerformance) {
                FLog.i("bitapp_performance", "End load bundle list: " + localObject.toString());
              }
              BitAppInstanceManager.this.mBundleLoaded.add(str);
            }
            for (;;)
            {
              if (paramLoadBundleCallBack == null) {
                break label309;
              }
              UiThreadUtil.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  this.val$loadBundleCallBack.callBack();
                }
              });
              return;
              if (Bundle.isBase((String)((Iterator)localObject).next())) {
                break;
              }
              ((Iterator)localObject).remove();
              break;
              if (FLog.isLoggable(3)) {
                FLog.i(BitAppInstanceManager.TAG, "loadBundle no need load");
              }
            }
          }
        }
      }).start();
    }
  }
  
  public static void setPackageFactroy(IPackageFactory paramIPackageFactory)
  {
    sPackageFactory = paramIPackageFactory;
  }
  
  public static void setPackageFactroy(IPackageFactory paramIPackageFactory, String paramString)
  {
    sPackageFactory = paramIPackageFactory;
    mAppInterfaceName = paramString;
  }
  
  public void executeJSScript(String paramString)
  {
    ReactContext localReactContext = getCurrentReactContext();
    if (localReactContext != null) {
      localReactContext.executeJSScript(paramString);
    }
  }
  
  public boolean isException()
  {
    ReactContext localReactContext;
    if (isInitContextOk) {
      localReactContext = getCurrentReactContext();
    }
    return (localReactContext == null) || (!localReactContext.hasActiveCatalystInstance());
  }
  
  public boolean isInitContextOk()
  {
    ReactContext localReactContext = getCurrentReactContext();
    return (isInitContextOk) && (localReactContext != null);
  }
  
  public boolean isLoaded(String paramString)
  {
    return this.mBundleLoaded.contains(paramString);
  }
  
  public void loadBundle(final Bundle paramBundle, final LoadBundleCallBack paramLoadBundleCallBack, final boolean paramBoolean)
  {
    if (paramBundle == null) {
      if (FLog.isLoggable(6)) {
        FLog.e("Exception", "bundle should not be null");
      }
    }
    do
    {
      return;
      if (!isUseDeveloperSupport()) {
        break;
      }
    } while (paramLoadBundleCallBack == null);
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        paramLoadBundleCallBack.callBack();
      }
    });
    return;
    if (mReactContextInitAsyncTask == null) {
      RNReport.reportStageStart("key_create_context", 7);
    }
    Object localObject2;
    synchronized (mInst)
    {
      if (mReactContextInitAsyncTask == null)
      {
        mReactContextInitAsyncTask = new ReactContextInitAsyncTask(null);
        localObject2 = new InitReactContextListener()
        {
          public void callBack(ReactApplicationContext paramAnonymousReactApplicationContext)
          {
            BitAppInstanceManager.this.loadBundleContextRready(paramAnonymousReactApplicationContext, paramBundle, paramLoadBundleCallBack, paramBoolean);
          }
        };
        mReactContextInitAsyncTask.addListener((InitReactContextListener)localObject2);
        mReactContextInitAsyncTask.execute(new Bundle[] { paramBundle });
      }
      ??? = getCurrentReactContext();
      localObject2 = new InitReactContextListener()
      {
        public void callBack(ReactApplicationContext paramAnonymousReactApplicationContext)
        {
          BitAppInstanceManager.this.loadBundleContextRready(paramAnonymousReactApplicationContext, paramBundle, paramLoadBundleCallBack, paramBoolean);
        }
      };
      if ((isInitContextOk) && (??? != null))
      {
        loadBundleContextRready((ReactContext)???, paramBundle, paramLoadBundleCallBack, paramBoolean);
        return;
      }
    }
    mReactContextInitAsyncTask.addListener((InitReactContextListener)localObject2);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "BitappInstanceManager onDestroy");
    }
    mAppInterfaceName = null;
    mReactContextInitAsyncTask = null;
    this.mBundleLoaded.clear();
    this.allBundles.clear();
    FrescoModule.onDestroy();
    UIManagerModule.onDestroy();
    try
    {
      Fresco.getImagePipeline().clearMemoryCaches();
      ModuleDependency.INSTANCE.clear();
      BundleStructCache.INSTANCE.clear();
      BundleCache.getInstance().clear();
      BundleStateMachineCache.getInstance().clear();
      ModuleCache.getInstance().clear();
      ModuleStateMachineCache.getInstance().clear();
      tearDownReactContext(getCurrentReactContext());
      mInst = null;
      com.facebook.react.ReactInstanceManager.mReactInstanceManager = null;
      ThreadManager.INSTANCE.shutdown();
      Fresco.shutDown();
      SimpleDraweeView.shutDown();
      SoLoaderShim.shutDown();
      BitmapUtil.onDestroy();
      OkHttpClientProvider.onDestroy();
      if (Java2jniClientFactory.isCreated())
      {
        if (FLog.isLoggable(3)) {
          FLog.i(TAG, "BitappInstanceManager onDestroy java2jniclient destory");
        }
        Java2jniClientFactory.getJava2jniClient().reactBridgeDestory();
        Java2jniClientFactory.destory();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (FLog.isLoggable(3))
        {
          FLog.i(TAG, "onDestroy fresco can't init, " + localException.getMessage());
          continue;
          if (FLog.isLoggable(3)) {
            FLog.i(TAG, "BitappInstanceManager onDestroy but not create java2jniclient");
          }
        }
      }
    }
  }
  
  public void recreateReactContextInBackground(JavaScriptExecutor paramJavaScriptExecutor, JSBundleLoader paramJSBundleLoader)
  {
    RNReport.reportStageStart("key_create_context", 7);
    super.recreateReactContextInBackground(paramJavaScriptExecutor, paramJSBundleLoader);
  }
  
  public void setupReactContext(ReactApplicationContext paramReactApplicationContext)
  {
    super.setupReactContext(paramReactApplicationContext);
    RNReport.reportStageEnd("key_create_context", 7, 0, 0);
  }
  
  public void unloadBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (FLog.isLoggable(6)) {
        FLog.e("Exception", "bundle should not be null");
      }
    }
    ReactContext localReactContext;
    do
    {
      return;
      paramBundle = paramBundle.getKey();
      localReactContext = getCurrentReactContext();
    } while ((localReactContext == null) || (!this.mBundleLoaded.contains(paramBundle)));
    localReactContext.executeJSScript("require('react-native/Libraries/react-native/react-native.js').AppRegistry.unregisterComponent('" + paramBundle + "');unload('react-native/Examples/js/" + paramBundle + ".js');");
    this.mBundleLoaded.remove(paramBundle);
  }
  
  public static class Builder
    extends ReactInstanceManager.Builder
  {
    public BitAppInstanceManager build()
    {
      return new BitAppInstanceManager((Context)Assertions.assertNotNull(this.mApplication, "Application property has not been set with this builder"), this.mJSBundleFile, this.mJSMainModuleName, this.mPackages, this.mUseDeveloperSupport, this.mBridgeIdleDebugListener, (LifecycleState)Assertions.assertNotNull(this.mInitialLifecycleState, "Initial lifecycle state was not set"), null);
    }
  }
  
  public static abstract interface InitReactContextListener
  {
    public abstract void callBack(ReactApplicationContext paramReactApplicationContext);
  }
  
  public static abstract interface LoadBundleCallBack
  {
    public abstract void callBack();
  }
  
  private final class ReactContextInitAsyncTask
    extends AsyncTask<Bundle, Void, ReactApplicationContext>
  {
    private ArrayList<BitAppInstanceManager.InitReactContextListener> mListener = new ArrayList();
    
    private ReactContextInitAsyncTask() {}
    
    public void addListener(BitAppInstanceManager.InitReactContextListener paramInitReactContextListener)
    {
      this.mListener.add(paramInitReactContextListener);
    }
    
    protected ReactApplicationContext doInBackground(Bundle... paramVarArgs)
    {
      Object localObject = null;
      if (BitAppInstanceManager.mInst != null)
      {
        if (Const.isTestPerformance) {
          FLog.i("bitapp_performance", "Begin to create react context");
        }
        localObject = paramVarArgs[0];
        paramVarArgs = ((Bundle)localObject).getFile();
        localObject = BitAppInstanceManager.this.addBundles(((Bundle)localObject).getBundles());
        localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
        paramVarArgs = BitAppInstanceManager.mInst.createContext(null, JSBundleLoader.createCachedBundleFromNetworkLoader(paramVarArgs, (String[])localObject));
        localObject = paramVarArgs;
        if (Const.isTestPerformance)
        {
          FLog.i("bitapp_performance", "End create react context");
          localObject = paramVarArgs;
        }
      }
      return (ReactApplicationContext)localObject;
    }
    
    protected void onPostExecute(final ReactApplicationContext paramReactApplicationContext)
    {
      super.onPostExecute(paramReactApplicationContext);
      UiThreadUtil.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Iterator localIterator;
          if ((BitAppInstanceManager.mInst != null) && (paramReactApplicationContext != null))
          {
            BitAppInstanceManager.mInst.setupReactContext(paramReactApplicationContext);
            if (Const.isTestPerformance) {
              FLog.i("bitapp_performance", "End setup react context");
            }
            BitAppInstanceManager.isInitContextOk = true;
            localIterator = BitAppInstanceManager.ReactContextInitAsyncTask.this.mListener.iterator();
          }
          for (;;)
          {
            if (!localIterator.hasNext())
            {
              BitAppInstanceManager.ReactContextInitAsyncTask.this.mListener.clear();
              return;
            }
            ((BitAppInstanceManager.InitReactContextListener)localIterator.next()).callBack(paramReactApplicationContext);
          }
        }
      });
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\manager\BitAppInstanceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */