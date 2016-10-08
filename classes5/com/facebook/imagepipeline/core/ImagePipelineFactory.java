package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheFactory;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImplProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.GingerbreadBitmapFactory;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder;
import com.facebook.imagepipeline.platform.KitKatPurgeableDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ImagePipelineFactory
{
  private static ImagePipelineFactory sInstance = null;
  private AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
  private AnimatedDrawableFactory mAnimatedDrawableFactory;
  private AnimatedDrawableUtil mAnimatedDrawableUtil;
  private AnimatedImageFactory mAnimatedImageFactory;
  private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
  private MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final ImagePipelineConfig mConfig;
  private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
  private MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private ImageDecoder mImageDecoder;
  private ImagePipeline mImagePipeline;
  private BufferedDiskCache mMainBufferedDiskCache;
  private DiskStorageCache mMainDiskStorageCache;
  private PlatformBitmapFactory mPlatformBitmapFactory;
  private PlatformDecoder mPlatformDecoder;
  private ProducerFactory mProducerFactory;
  private ProducerSequenceFactory mProducerSequenceFactory;
  private BufferedDiskCache mSmallImageBufferedDiskCache;
  private DiskStorageCache mSmallImageDiskStorageCache;
  
  public ImagePipelineFactory(ImagePipelineConfig paramImagePipelineConfig)
  {
    this.mConfig = ((ImagePipelineConfig)Preconditions.checkNotNull(paramImagePipelineConfig));
  }
  
  public static AnimatedDrawableFactory buildAnimatedDrawableFactory(SerialExecutorService paramSerialExecutorService, final ActivityManager paramActivityManager, final AnimatedDrawableUtil paramAnimatedDrawableUtil, AnimatedDrawableBackendProvider paramAnimatedDrawableBackendProvider, ScheduledExecutorService paramScheduledExecutorService, final MonotonicClock paramMonotonicClock, Resources paramResources)
  {
    new AnimatedDrawableFactory(paramAnimatedDrawableBackendProvider, new AnimatedDrawableCachingBackendImplProvider()
    {
      public AnimatedDrawableCachingBackendImpl get(AnimatedDrawableBackend paramAnonymousAnimatedDrawableBackend, AnimatedDrawableOptions paramAnonymousAnimatedDrawableOptions)
      {
        return new AnimatedDrawableCachingBackendImpl(ImagePipelineFactory.this, paramActivityManager, paramAnimatedDrawableUtil, paramMonotonicClock, paramAnonymousAnimatedDrawableBackend, paramAnonymousAnimatedDrawableOptions);
      }
    }, paramAnimatedDrawableUtil, paramScheduledExecutorService, paramResources);
  }
  
  public static AnimatedImageFactory buildAnimatedImageFactory(AnimatedDrawableUtil paramAnimatedDrawableUtil, PlatformBitmapFactory paramPlatformBitmapFactory)
  {
    new AnimatedImageFactory(new AnimatedDrawableBackendProvider()
    {
      public AnimatedDrawableBackend get(AnimatedImageResult paramAnonymousAnimatedImageResult, Rect paramAnonymousRect)
      {
        return new AnimatedDrawableBackendImpl(ImagePipelineFactory.this, paramAnonymousAnimatedImageResult, paramAnonymousRect);
      }
    }, paramPlatformBitmapFactory);
  }
  
  public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory paramPoolFactory, PlatformDecoder paramPlatformDecoder)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ArtBitmapFactory(paramPoolFactory.getBitmapPool());
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new HoneycombBitmapFactory(new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory()), paramPlatformDecoder);
    }
    return new GingerbreadBitmapFactory();
  }
  
  public static PlatformDecoder buildPlatformDecoder(PoolFactory paramPoolFactory, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ArtDecoder(paramPoolFactory.getBitmapPool(), paramPoolFactory.getFlexByteArrayPoolMaxNumThreads());
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 19)) {
      return new GingerbreadPurgeableDecoder();
    }
    return new KitKatPurgeableDecoder(paramPoolFactory.getFlexByteArrayPool());
  }
  
  private AnimatedDrawableUtil getAnimatedDrawableUtil()
  {
    if (this.mAnimatedDrawableUtil == null) {
      this.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
    }
    return this.mAnimatedDrawableUtil;
  }
  
  private AnimatedImageFactory getAnimatedImageFactory()
  {
    if (this.mAnimatedImageFactory == null) {
      if (this.mConfig.getAnimatedImageFactory() == null) {
        break label33;
      }
    }
    label33:
    for (this.mAnimatedImageFactory = this.mConfig.getAnimatedImageFactory();; this.mAnimatedImageFactory = buildAnimatedImageFactory(getAnimatedDrawableUtil(), getPlatformBitmapFactory())) {
      return this.mAnimatedImageFactory;
    }
  }
  
  private ImageDecoder getImageDecoder()
  {
    if (this.mImageDecoder == null) {
      if (this.mConfig.getImageDecoder() == null) {
        break label33;
      }
    }
    label33:
    for (this.mImageDecoder = this.mConfig.getImageDecoder();; this.mImageDecoder = new ImageDecoder(getAnimatedImageFactory(), getPlatformDecoder(), this.mConfig.getBitmapConfig())) {
      return this.mImageDecoder;
    }
  }
  
  public static ImagePipelineFactory getInstance()
  {
    return (ImagePipelineFactory)Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
  }
  
  private BufferedDiskCache getMainBufferedDiskCache()
  {
    if (this.mMainBufferedDiskCache == null) {
      this.mMainBufferedDiskCache = new BufferedDiskCache(getMainDiskStorageCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
    }
    return this.mMainBufferedDiskCache;
  }
  
  private ProducerFactory getProducerFactory()
  {
    if (this.mProducerFactory == null) {
      this.mProducerFactory = new ProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.isDecodeFileDescriptorEnabled());
    }
    return this.mProducerFactory;
  }
  
  private ProducerSequenceFactory getProducerSequenceFactory()
  {
    if (this.mProducerSequenceFactory == null) {
      this.mProducerSequenceFactory = new ProducerSequenceFactory(getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.isDownsampleEnabled());
    }
    return this.mProducerSequenceFactory;
  }
  
  private BufferedDiskCache getSmallImageBufferedDiskCache()
  {
    if (this.mSmallImageBufferedDiskCache == null) {
      this.mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageDiskStorageCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
    }
    return this.mSmallImageBufferedDiskCache;
  }
  
  public static void initialize(Context paramContext)
  {
    initialize(ImagePipelineConfig.newBuilder(paramContext).build());
  }
  
  public static void initialize(ImagePipelineConfig paramImagePipelineConfig)
  {
    sInstance = new ImagePipelineFactory(paramImagePipelineConfig);
  }
  
  public static void shutDown()
  {
    if (sInstance != null)
    {
      sInstance.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
      sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
      sInstance = null;
    }
  }
  
  public AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider()
  {
    if (this.mAnimatedDrawableBackendProvider == null) {
      this.mAnimatedDrawableBackendProvider = new AnimatedDrawableBackendProvider()
      {
        public AnimatedDrawableBackend get(AnimatedImageResult paramAnonymousAnimatedImageResult, Rect paramAnonymousRect)
        {
          return new AnimatedDrawableBackendImpl(ImagePipelineFactory.this.getAnimatedDrawableUtil(), paramAnonymousAnimatedImageResult, paramAnonymousRect);
        }
      };
    }
    return this.mAnimatedDrawableBackendProvider;
  }
  
  public AnimatedDrawableFactory getAnimatedDrawableFactory()
  {
    if (this.mAnimatedDrawableFactory == null) {
      this.mAnimatedDrawableFactory = buildAnimatedDrawableFactory(new DefaultSerialExecutorService(this.mConfig.getExecutorSupplier().forDecode()), (ActivityManager)this.mConfig.getContext().getSystemService("activity"), getAnimatedDrawableUtil(), getAnimatedDrawableBackendProvider(), UiThreadImmediateExecutorService.getInstance(), RealtimeSinceBootClock.get(), this.mConfig.getContext().getResources());
    }
    return this.mAnimatedDrawableFactory;
  }
  
  public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache()
  {
    if (this.mBitmapCountingMemoryCache == null) {
      this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
    }
    return this.mBitmapCountingMemoryCache;
  }
  
  public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache()
  {
    if (this.mBitmapMemoryCache == null) {
      this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
    }
    return this.mBitmapMemoryCache;
  }
  
  public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache()
  {
    if (this.mEncodedCountingMemoryCache == null) {
      this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
    }
    return this.mEncodedCountingMemoryCache;
  }
  
  public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache()
  {
    if (this.mEncodedMemoryCache == null) {
      this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(getEncodedCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
    }
    return this.mEncodedMemoryCache;
  }
  
  public ImagePipeline getImagePipeline()
  {
    if (this.mImagePipeline == null) {
      this.mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory());
    }
    return this.mImagePipeline;
  }
  
  public DiskStorageCache getMainDiskStorageCache()
  {
    if (this.mMainDiskStorageCache == null) {
      this.mMainDiskStorageCache = DiskCacheFactory.newDiskStorageCache(this.mConfig.getMainDiskCacheConfig());
    }
    return this.mMainDiskStorageCache;
  }
  
  public PlatformBitmapFactory getPlatformBitmapFactory()
  {
    if (this.mPlatformBitmapFactory == null) {
      this.mPlatformBitmapFactory = buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder());
    }
    return this.mPlatformBitmapFactory;
  }
  
  public PlatformDecoder getPlatformDecoder()
  {
    if (this.mPlatformDecoder == null) {
      this.mPlatformDecoder = buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.isDecodeMemoryFileEnabled());
    }
    return this.mPlatformDecoder;
  }
  
  public DiskStorageCache getSmallImageDiskStorageCache()
  {
    if (this.mSmallImageDiskStorageCache == null) {
      this.mSmallImageDiskStorageCache = DiskCacheFactory.newDiskStorageCache(this.mConfig.getSmallImageDiskCacheConfig());
    }
    return this.mSmallImageDiskStorageCache;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\core\ImagePipelineFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */