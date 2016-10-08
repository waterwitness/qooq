package com.tencent.bitapp.bundle;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.fresco.FrescoModule.FrescoHandler;
import com.facebook.soloader.SoLoader;
import com.tencent.bitapp.Const;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.report.RNReport;
import com.tencent.bitapp.statemachine.IState;
import com.tencent.bitapp.thread.ThreadManager;
import com.tencent.bitapp.utils.FileUtils;
import com.tencent.bitapp.utils.Md5Utils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

public class BundleFacade
{
  private static final String TAG = BundleFacade.class.getSimpleName();
  
  private static void downloadRemoteImage(Uri paramUri)
  {
    getImagePipeline().prefetchToDiskCache(ImageRequestBuilder.newBuilderWithSource(paramUri).build(), null);
  }
  
  private static void getBundle(final BundleStruct paramBundleStruct, WeakReference<IBundleListener> paramWeakReference, final boolean paramBoolean)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "getBundle for struct: " + paramBundleStruct + " | wListener: " + paramWeakReference);
    }
    ThreadManager.INSTANCE.execute(new Runnable()
    {
      public void run()
      {
        Object localObject1 = null;
        if (BundleFacade.this != null) {
          localObject1 = (IBundleListener)BundleFacade.this.get();
        }
        if (FLog.isLoggable(3)) {
          FLog.i(BundleFacade.TAG, "getBundle listener : " + localObject1);
        }
        if (paramBundleStruct == null)
        {
          if (localObject1 != null) {
            ((IBundleListener)localObject1).onLoadFail("", 2);
          }
          while (!FLog.isLoggable(3)) {
            return;
          }
          FLog.i(BundleFacade.TAG, "getBundle listener is null, do nothing");
          return;
        }
        String str = paramBundleStruct.getKey();
        if (ContextUtils.INSTANCE.getApplicationContext() == null)
        {
          if (FLog.isLoggable(3)) {
            FLog.i(BundleFacade.TAG, "Should set context");
          }
          if (localObject1 != null) {
            ((IBundleListener)localObject1).onLoadFail(str, 3);
          }
          for (;;)
          {
            RNReport.reportStageStepEnd(str, 2, 20, 3);
            RNReport.reportStageEnd(str, 2, 3, 20);
            return;
            if (FLog.isLoggable(3)) {
              FLog.i(BundleFacade.TAG, "getBundle for key: " + str + " | listener is null, do nothing");
            }
          }
        }
        if (DevSupportManager.isSupportDevMode())
        {
          BundleFacade.getDevModeBundle(paramBundleStruct, (IBundleListener)localObject1);
          return;
        }
        if ((Const.isDebug) && (!TextUtils.isEmpty(paramBundleStruct.localFile)))
        {
          BundleFacade.getLocalBundle(paramBundleStruct, (IBundleListener)localObject1);
          return;
        }
        if ((!paramBoolean) && (BundleCache.getInstance().isExistInCache(str)))
        {
          localObject2 = (Bundle)BundleCache.getInstance().get(str, new Object[0]);
          if (localObject1 != null) {
            ((IBundleListener)localObject1).onLoadSuccess(str, (Bundle)localObject2);
          }
          for (;;)
          {
            RNReport.reportStageStepEnd(str, 2, 20, 0);
            RNReport.reportStageEnd(str, 2, 0, 20);
            return;
            if (FLog.isLoggable(3)) {
              FLog.i(BundleFacade.TAG, "getBundle for key: " + str + " | listener is null, do nothing");
            }
          }
        }
        RNReport.reportStageStepEnd(str, 2, 20, 6);
        RNReport.reportStageStepStart(str, 2, 21);
        Object localObject2 = (BundleStateMachine)BundleStateMachineCache.getInstance().get(str, new Object[0]);
        if (FLog.isLoggable(3)) {
          FLog.i(BundleFacade.TAG, str + " bundleStateMachine is " + localObject2);
        }
        ((BundleStateMachine)localObject2).addListener((IBundleListener)localObject1);
        localObject1 = ((BundleStateMachine)localObject2).getCurrentState();
        if ((localObject1 != null) && (Const.isDebug)) {
          FLog.i(BundleFacade.TAG, "state: " + ((IState)localObject1).getName());
        }
        if ((localObject1 != null) && ((localObject1.equals(((BundleStateMachine)localObject2).mInitState)) || (localObject1.equals(((BundleStateMachine)localObject2).mLoadFail)) || (localObject1.equals(((BundleStateMachine)localObject2).mLoadSuccess)))) {
          ((BundleStateMachine)localObject2).setBundleStruct(paramBundleStruct);
        }
        localObject1 = ((BundleStateMachine)localObject2).mBundleStruct;
        boolean bool = paramBoolean;
        if ((localObject1 != null) && (paramBundleStruct != null) && (((BundleStruct)localObject1).module_version < paramBundleStruct.module_version)) {
          ((BundleStateMachine)localObject2).setBundleStruct(paramBundleStruct);
        }
        if ((bool) && (!((BundleStateMachine)localObject2).mIsUpdate)) {
          ((BundleStateMachine)localObject2).setUpdate(bool);
        }
        ((BundleStateMachine)localObject2).sendMessage(((BundleStateMachine)localObject2).obtainMessage(1));
      }
    });
  }
  
  private static void getDevModeBundle(BundleStruct paramBundleStruct, IBundleListener paramIBundleListener)
  {
    String str = String.valueOf(paramBundleStruct.module_id);
    Bundle localBundle = (Bundle)BundleCache.getInstance().get(str, new Object[0]);
    Object localObject = localBundle;
    if (localBundle == null)
    {
      localObject = Md5Utils.getMd5(new File(paramBundleStruct.localFile));
      localObject = new Bundle(str, paramBundleStruct.localFile, (String)localObject, true);
      BundleCache.getInstance().put(str, localObject);
    }
    if (paramIBundleListener != null) {
      paramIBundleListener.onLoadSuccess(str, (Bundle)localObject);
    }
    for (;;)
    {
      RNReport.reportStageStepEnd(str, 2, 20, 0);
      RNReport.reportStageEnd(str, 2, 0, 20);
      return;
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "getDevModeBundle for key: " + str + " | listener is null, do nothing");
      }
    }
  }
  
  private static ImagePipeline getImagePipeline()
  {
    FrescoModule.initFresco(ContextUtils.INSTANCE.getApplicationContext());
    return Fresco.getImagePipeline();
  }
  
  private static void getLocalBundle(BundleStruct paramBundleStruct, IBundleListener paramIBundleListener)
  {
    String str = String.valueOf(paramBundleStruct.module_id);
    Object localObject;
    if (FileUtils.isFileExist(paramBundleStruct.localFile))
    {
      localObject = (Bundle)BundleCache.getInstance().get(str, new Object[0]);
      if (localObject != null) {
        if (paramIBundleListener != null) {
          paramIBundleListener.onLoadSuccess(str, (Bundle)localObject);
        }
      }
    }
    for (;;)
    {
      RNReport.reportStageStepEnd(str, 2, 20, 0);
      RNReport.reportStageEnd(str, 2, 0, 20);
      return;
      if (FLog.isLoggable(3))
      {
        FLog.i(TAG, "getLocalBundle for key: " + str + " | listener is null, do nothing");
        continue;
        localObject = Md5Utils.getMd5(new File(paramBundleStruct.localFile));
        paramBundleStruct = new Bundle(str, paramBundleStruct.localFile, (String)localObject, true);
        BundleCache.getInstance().put(str, paramBundleStruct);
        if (paramIBundleListener != null)
        {
          paramIBundleListener.onLoadSuccess(str, paramBundleStruct);
        }
        else if (FLog.isLoggable(3))
        {
          FLog.i(TAG, "getLocalBundle for key: " + str + " | listener is null, do nothing");
          continue;
          if (paramIBundleListener != null) {
            paramIBundleListener.onLoadFail(str, 4);
          } else if (FLog.isLoggable(3)) {
            FLog.i(TAG, "getLocalBundle for key: " + str + " | listener is null, do nothing");
          }
        }
      }
    }
  }
  
  private static boolean isImage(String paramString)
  {
    paramString = paramString.toLowerCase();
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".gif")) || (paramString.endsWith(".jpe")) || (paramString.endsWith(".dib")) || (paramString.endsWith(".jfif")) || (paramString.endsWith(".tif")) || (paramString.endsWith(".tiff")) || (paramString.endsWith(".ico"));
  }
  
  public static void loadBaseBundle()
  {
    BundleStruct localBundleStruct = new BundleStruct();
    localBundleStruct.module_id = 1;
    localBundleStruct.module_version = 1;
    loadBundle(localBundleStruct, new WeakReference(new BundleListener()
    {
      public void onLoadSuccess(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        super.onLoadSuccess(paramAnonymousString, paramAnonymousBundle);
        if (BitAppInstanceManager.getInstance() != null) {
          BitAppInstanceManager.getInstance().loadBundle(paramAnonymousBundle, null, false);
        }
      }
    }));
  }
  
  public static void loadBundle(BundleStruct paramBundleStruct, WeakReference<IBundleListener> paramWeakReference)
  {
    if (FLog.isLoggable(3))
    {
      FLog.i(TAG, "loadBundle struct: " + paramBundleStruct);
      FLog.printStack();
    }
    if (paramBundleStruct != null)
    {
      localObject = paramBundleStruct.getKey();
      RNReport.reportStageStart((String)localObject, 2);
      RNReport.reportStageStepStart((String)localObject, 2, 20);
      localObject = BundleStructCache.INSTANCE.get(paramBundleStruct.module_id);
      i = -1;
      if (localObject != null) {
        i = ((BundleStruct)localObject).module_version;
      }
      j = paramBundleStruct.module_version;
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "loadBundle newModuleVersion: " + j + " | cacheModuleVersion: " + i);
      }
      if (j > i)
      {
        bool = true;
        setBundleStruct(paramBundleStruct, true);
        getBundle(paramBundleStruct, paramWeakReference, bool);
      }
    }
    while (!FLog.isLoggable(3)) {
      for (;;)
      {
        Object localObject;
        int i;
        int j;
        return;
        boolean bool = false;
      }
    }
    FLog.i(TAG, "loadBundle input struct is null");
  }
  
  public static void preloadNetImage(Context paramContext, List<String> paramList)
  {
    if ((paramList != null) && (paramContext != null))
    {
      j = paramList.size();
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "preloadImage len: " + j);
      }
      SoLoader.init(paramContext.getApplicationContext(), false);
      SoLoaderShim.setHandler(new FrescoModule.FrescoHandler());
      i = 0;
      if (i < j) {}
    }
    while (!FLog.isLoggable(3)) {
      for (;;)
      {
        int j;
        int i;
        return;
        preloadNetImage((String)paramList.get(i));
        i += 1;
      }
    }
    FLog.i(TAG, "preloadImage urls is null");
  }
  
  private static void preloadNetImage(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "preloadImage source: " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!isImage(paramString))) {
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "preloadImage source: " + paramString + " is empty or isn't image");
      }
    }
    do
    {
      do
      {
        return;
        try
        {
          Uri localUri = Uri.parse(paramString);
          if (localUri.getScheme() == null) {
            break;
          }
          downloadRemoteImage(localUri);
          return;
        }
        catch (Exception localException) {}
      } while (!FLog.isLoggable(3));
      FLog.i(TAG, "preloadImage source: " + paramString + " exception: " + localException.getMessage());
      return;
    } while (!FLog.isLoggable(3));
    FLog.i(TAG, "preloadImage source: " + paramString + " isn't remote image");
  }
  
  public static void setBundleStruct(BundleStruct paramBundleStruct, boolean paramBoolean)
  {
    Object localObject;
    if (paramBundleStruct != null)
    {
      localObject = BundleStructCache.INSTANCE.get(paramBundleStruct.module_id);
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "updateBundle old[" + ((BundleStruct)localObject).toString() + "] struct, new struct [" + paramBundleStruct + "]");
      }
      int i = -1;
      if (localObject != null) {
        i = ((BundleStruct)localObject).module_version;
      }
      int j = paramBundleStruct.module_version;
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "setBundleStruct newModuleVersion: " + j + " | cacheModuleVersion: " + i);
      }
      if (j <= i) {
        break label201;
      }
      if (!paramBundleStruct.equals(localObject))
      {
        if (!paramBoolean) {
          break label185;
        }
        paramBoolean = paramBundleStruct.decrypt;
        localObject = paramBundleStruct.download_url;
        str = paramBundleStruct.pwd;
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((!paramBoolean) || (!TextUtils.isEmpty(str)))) {
          BundleStructCache.INSTANCE.add(paramBundleStruct);
        }
      }
    }
    label185:
    label201:
    while (!FLog.isLoggable(3))
    {
      String str;
      return;
      ((BundleStruct)localObject).module_state = paramBundleStruct.module_state;
      BundleStructCache.INSTANCE.add((BundleStruct)localObject);
      return;
    }
    FLog.i(TAG, "newModuleVersion < cacheModuleVersion, so no need set");
  }
  
  public static void updateBundle(BundleStruct paramBundleStruct)
  {
    if (FLog.isLoggable(3))
    {
      FLog.i(TAG, "updateBundle struct: " + paramBundleStruct);
      FLog.printStack();
    }
    if (paramBundleStruct != null)
    {
      localBundleStruct = BundleStructCache.INSTANCE.get(paramBundleStruct.module_id);
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "updateBundle old[" + localBundleStruct.toString() + "] struct, new struct [" + paramBundleStruct + "]");
      }
      if (paramBundleStruct.module_state == 2) {
        if (!paramBundleStruct.equals(localBundleStruct)) {
          BundleStructCache.INSTANCE.add(paramBundleStruct);
        }
      }
    }
    while (!FLog.isLoggable(3))
    {
      do
      {
        BundleStruct localBundleStruct;
        do
        {
          return;
        } while (!FLog.isLoggable(3));
        FLog.i(TAG, "updateBundle old struct same as new struct");
        return;
        int i = -1;
        if (localBundleStruct != null) {
          i = localBundleStruct.module_version;
        }
        int j = paramBundleStruct.module_version;
        if (FLog.isLoggable(3)) {
          FLog.i(TAG, "updateBundle newModuleVersion: " + j + " | cacheModuleVersion: " + i);
        }
        if (j > i)
        {
          if (!paramBundleStruct.equals(localBundleStruct)) {
            BundleStructCache.INSTANCE.add(paramBundleStruct);
          }
          getBundle(paramBundleStruct, null, true);
          return;
        }
      } while (!FLog.isLoggable(3));
      FLog.i(TAG, "newModuleVersion < cacheModuleVersion, so no need update");
      return;
    }
    FLog.i(TAG, "loadBundle input struct is null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\BundleFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */