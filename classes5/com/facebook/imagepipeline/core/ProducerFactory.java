package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.NullProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;

public class ProducerFactory
{
  private AssetManager mAssetManager;
  private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final ByteArrayPool mByteArrayPool;
  private final CacheKeyFactory mCacheKeyFactory;
  private ContentResolver mContentResolver;
  private final boolean mDecodeFileDescriptorEnabled;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final boolean mDownsampleEnabled;
  private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private final ExecutorSupplier mExecutorSupplier;
  private final ImageDecoder mImageDecoder;
  private final PlatformBitmapFactory mPlatformBitmapFactory;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final ProgressiveJpegConfig mProgressiveJpegConfig;
  private final boolean mResizeAndRotateEnabledForNetwork;
  private Resources mResources;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public ProducerFactory(Context paramContext, ByteArrayPool paramByteArrayPool, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, ExecutorSupplier paramExecutorSupplier, PooledByteBufferFactory paramPooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, PlatformBitmapFactory paramPlatformBitmapFactory, boolean paramBoolean3)
  {
    this.mContentResolver = paramContext.getApplicationContext().getContentResolver();
    this.mResources = paramContext.getApplicationContext().getResources();
    this.mAssetManager = paramContext.getApplicationContext().getAssets();
    this.mByteArrayPool = paramByteArrayPool;
    this.mImageDecoder = paramImageDecoder;
    this.mProgressiveJpegConfig = paramProgressiveJpegConfig;
    this.mDownsampleEnabled = paramBoolean1;
    this.mResizeAndRotateEnabledForNetwork = paramBoolean2;
    this.mExecutorSupplier = paramExecutorSupplier;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mBitmapMemoryCache = paramMemoryCache;
    this.mEncodedMemoryCache = paramMemoryCache1;
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mPlatformBitmapFactory = paramPlatformBitmapFactory;
    this.mDecodeFileDescriptorEnabled = paramBoolean3;
  }
  
  public static AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer(Producer<EncodedImage> paramProducer)
  {
    return new AddImageTransformMetaDataProducer(paramProducer);
  }
  
  public static BranchOnSeparateImagesProducer newBranchOnSeparateImagesProducer(Producer<EncodedImage> paramProducer1, Producer<EncodedImage> paramProducer2)
  {
    return new BranchOnSeparateImagesProducer(paramProducer1, paramProducer2);
  }
  
  public static <T> NullProducer<T> newNullProducer()
  {
    return new NullProducer();
  }
  
  public static <T> SwallowResultProducer<T> newSwallowResultProducer(Producer<T> paramProducer)
  {
    return new SwallowResultProducer(paramProducer);
  }
  
  public <T> ThreadHandoffProducer<T> newBackgroundThreadHandoffProducer(Producer<T> paramProducer)
  {
    return new ThreadHandoffProducer(this.mExecutorSupplier.forLightweightBackgroundTasks(), paramProducer);
  }
  
  public BitmapMemoryCacheGetProducer newBitmapMemoryCacheGetProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheGetProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public BitmapMemoryCacheKeyMultiplexProducer newBitmapMemoryCacheKeyMultiplexProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheKeyMultiplexProducer(this.mCacheKeyFactory, paramProducer);
  }
  
  public BitmapMemoryCacheProducer newBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public LocalContentUriFetchProducer newContentUriFetchProducer()
  {
    return new LocalContentUriFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver, this.mDecodeFileDescriptorEnabled);
  }
  
  public DataFetchProducer newDataFetchProducer()
  {
    return new DataFetchProducer(this.mPooledByteBufferFactory, this.mDecodeFileDescriptorEnabled);
  }
  
  public DecodeProducer newDecodeProducer(Producer<EncodedImage> paramProducer)
  {
    return new DecodeProducer(this.mByteArrayPool, this.mExecutorSupplier.forDecode(), this.mImageDecoder, this.mProgressiveJpegConfig, this.mDownsampleEnabled, this.mResizeAndRotateEnabledForNetwork, paramProducer);
  }
  
  public DiskCacheProducer newDiskCacheProducer(Producer<EncodedImage> paramProducer)
  {
    return new DiskCacheProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public EncodedCacheKeyMultiplexProducer newEncodedCacheKeyMultiplexProducer(Producer<EncodedImage> paramProducer)
  {
    return new EncodedCacheKeyMultiplexProducer(this.mCacheKeyFactory, paramProducer);
  }
  
  public EncodedMemoryCacheProducer newEncodedMemoryCacheProducer(Producer<EncodedImage> paramProducer)
  {
    return new EncodedMemoryCacheProducer(this.mEncodedMemoryCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public LocalAssetFetchProducer newLocalAssetFetchProducer()
  {
    return new LocalAssetFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mAssetManager, this.mDecodeFileDescriptorEnabled);
  }
  
  public LocalExifThumbnailProducer newLocalExifThumbnailProducer()
  {
    return new LocalExifThumbnailProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
  }
  
  public LocalFileFetchProducer newLocalFileFetchProducer()
  {
    return new LocalFileFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mDecodeFileDescriptorEnabled);
  }
  
  public LocalResourceFetchProducer newLocalResourceFetchProducer()
  {
    return new LocalResourceFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mResources, this.mDecodeFileDescriptorEnabled);
  }
  
  public LocalVideoThumbnailProducer newLocalVideoThumbnailProducer()
  {
    return new LocalVideoThumbnailProducer(this.mExecutorSupplier.forLocalStorageRead());
  }
  
  public NetworkFetchProducer newNetworkFetchProducer(NetworkFetcher paramNetworkFetcher)
  {
    return new NetworkFetchProducer(this.mPooledByteBufferFactory, this.mByteArrayPool, paramNetworkFetcher);
  }
  
  public PostprocessedBitmapMemoryCacheProducer newPostprocessorBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new PostprocessedBitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public PostprocessorProducer newPostprocessorProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new PostprocessorProducer(paramProducer, this.mPlatformBitmapFactory, this.mExecutorSupplier.forBackgroundTasks());
  }
  
  public ResizeAndRotateProducer newResizeAndRotateProducer(Producer<EncodedImage> paramProducer)
  {
    return new ResizeAndRotateProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, paramProducer);
  }
  
  public <T> ThrottlingProducer<T> newThrottlingProducer(int paramInt, Producer<T> paramProducer)
  {
    return new ThrottlingProducer(paramInt, this.mExecutorSupplier.forLightweightBackgroundTasks(), paramProducer);
  }
  
  public WebpTranscodeProducer newWebpTranscodeProducer(Producer<EncodedImage> paramProducer)
  {
    return new WebpTranscodeProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, paramProducer);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\core\ProducerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */