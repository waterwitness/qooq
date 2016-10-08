package com.facebook.react.modules.fresco;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskCacheConfig.Builder;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Supplier;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.common.soloader.SoLoaderShim.Handler;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.modules.common.ModuleDataCleaner.Cleanable;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.soloader.SoLoader;
import com.tencent.bitapp.pre.PreConst;
import java.io.File;
import java.util.HashSet;
import javax.annotation.Nullable;

public class FrescoModule
  extends ReactContextBaseJavaModule
  implements ModuleDataCleaner.Cleanable
{
  private static boolean isFrescoInit = false;
  private static Object lock = new Object();
  @Nullable
  private ImagePipelineConfig mConfig;
  
  public FrescoModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext, getDefaultConfig(paramReactApplicationContext, null, null));
  }
  
  public FrescoModule(ReactApplicationContext paramReactApplicationContext, ImagePipelineConfig paramImagePipelineConfig)
  {
    super(paramReactApplicationContext);
    this.mConfig = paramImagePipelineConfig;
  }
  
  public FrescoModule(ReactApplicationContext paramReactApplicationContext, RequestListener paramRequestListener)
  {
    this(paramReactApplicationContext, getDefaultConfig(paramReactApplicationContext, paramRequestListener, null));
  }
  
  public FrescoModule(ReactApplicationContext paramReactApplicationContext, RequestListener paramRequestListener, DiskCacheConfig paramDiskCacheConfig)
  {
    this(paramReactApplicationContext, getDefaultConfig(paramReactApplicationContext, paramRequestListener, paramDiskCacheConfig));
  }
  
  private static ImagePipelineConfig getDefaultConfig(Context paramContext, @Nullable RequestListener paramRequestListener, @Nullable DiskCacheConfig paramDiskCacheConfig)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(new SystraceRequestListener());
    if (paramRequestListener != null) {
      localHashSet.add(paramRequestListener);
    }
    paramRequestListener = OkHttpClientProvider.getOkHttpClient();
    paramContext = OkHttpImagePipelineConfigFactory.newBuilder(paramContext.getApplicationContext(), paramRequestListener);
    paramContext.setDownsampleEnabled(false).setRequestListeners(localHashSet);
    if (paramDiskCacheConfig != null) {
      paramContext.setMainDiskCacheConfig(paramDiskCacheConfig);
    }
    return paramContext.build();
  }
  
  private static DiskCacheConfig getDefaultMainDiskCacheConfig(Context paramContext)
  {
    DiskCacheConfig.newBuilder().setBaseDirectoryPathSupplier(new Supplier()
    {
      public File get()
      {
        if (("mounted".equals(Environment.getExternalStorageState())) || (!FrescoModule.isExternalStorageRemovable())) {
          return new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), PreConst.mCacheSaveFolder);
        }
        return new File(this.val$context.getApplicationContext().getCacheDir(), PreConst.mCacheSaveFolder);
      }
    }).setBaseDirectoryName("image_cache").setMaxCacheSize(41943040L).setMaxCacheSizeOnLowDiskSpace(10485760L).setMaxCacheSizeOnVeryLowDiskSpace(2097152L).build();
  }
  
  public static void initFresco(Context paramContext)
  {
    if (!isFrescoInit) {
      synchronized (lock)
      {
        Fresco.initialize(paramContext, getDefaultConfig(paramContext, null, getDefaultMainDiskCacheConfig(paramContext)));
        isFrescoInit = true;
        return;
      }
    }
  }
  
  @TargetApi(9)
  public static boolean isExternalStorageRemovable()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
  
  public static void onDestroy()
  {
    isFrescoInit = false;
  }
  
  public void clearSensitiveData()
  {
    ImagePipelineFactory localImagePipelineFactory = Fresco.getImagePipelineFactory();
    localImagePipelineFactory.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
    localImagePipelineFactory.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
    localImagePipelineFactory.getMainDiskStorageCache().clearAll();
    localImagePipelineFactory.getSmallImageDiskStorageCache().clearAll();
  }
  
  public String getName()
  {
    return "FrescoModule";
  }
  
  public void initialize()
  {
    super.initialize();
    SoLoaderShim.setHandler(new FrescoHandler());
    Context localContext = getReactApplicationContext().getApplicationContext();
    SoLoader.init(localContext, false);
    initFresco(localContext);
    this.mConfig = null;
  }
  
  public static class FrescoHandler
    implements SoLoaderShim.Handler
  {
    public void loadLibrary(String paramString)
    {
      SoLoader.loadLibrary(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\fresco\FrescoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */