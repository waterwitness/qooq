package com.facebook.imagepipeline.core;

import android.net.Uri;
import bolts.Continuation;
import bolts.Task;
import com.android.internal.util.facebook.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SettableDataSource;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ImagePipeline
{
  private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
  private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final CacheKeyFactory mCacheKeyFactory;
  private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private AtomicLong mIdCounter = new AtomicLong();
  private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
  private final BufferedDiskCache mMainBufferedDiskCache;
  private final ProducerSequenceFactory mProducerSequenceFactory;
  private final RequestListener mRequestListener;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public ImagePipeline(ProducerSequenceFactory paramProducerSequenceFactory, Set<RequestListener> paramSet, Supplier<Boolean> paramSupplier, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory)
  {
    this.mProducerSequenceFactory = paramProducerSequenceFactory;
    this.mRequestListener = new ForwardingRequestListener(paramSet);
    this.mIsPrefetchEnabledSupplier = paramSupplier;
    this.mBitmapMemoryCache = paramMemoryCache;
    this.mEncodedMemoryCache = paramMemoryCache1;
    this.mMainBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
  }
  
  private String generateUniqueFutureId()
  {
    return String.valueOf(this.mIdCounter.getAndIncrement());
  }
  
  private Predicate<CacheKey> predicateForUri(Uri paramUri)
  {
    new Predicate()
    {
      public boolean apply(CacheKey paramAnonymousCacheKey)
      {
        if ((paramAnonymousCacheKey instanceof BitmapMemoryCacheKey)) {
          return ((BitmapMemoryCacheKey)paramAnonymousCacheKey).getSourceUriString().equals(this.val$cacheKeySourceString);
        }
        return false;
      }
    };
  }
  
  private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> paramProducer, ImageRequest paramImageRequest, ImageRequest.RequestLevel paramRequestLevel, Object paramObject)
  {
    boolean bool = false;
    try
    {
      paramRequestLevel = ImageRequest.RequestLevel.getMax(paramImageRequest.getLowestPermittedRequestLevel(), paramRequestLevel);
      String str = generateUniqueFutureId();
      RequestListener localRequestListener = this.mRequestListener;
      if ((!paramImageRequest.getProgressiveRenderingEnabled()) && (UriUtil.isNetworkUri(paramImageRequest.getSourceUri()))) {}
      for (;;)
      {
        paramProducer = CloseableProducerToDataSourceAdapter.create(paramProducer, new SettableProducerContext(paramImageRequest, str, localRequestListener, paramObject, paramRequestLevel, false, bool, paramImageRequest.getPriority()), this.mRequestListener);
        return paramProducer;
        bool = true;
      }
      return DataSources.immediateFailedDataSource(paramProducer);
    }
    catch (Exception paramProducer) {}
  }
  
  private DataSource<Void> submitPrefetchRequest(Producer<Void> paramProducer, ImageRequest paramImageRequest, ImageRequest.RequestLevel paramRequestLevel, Object paramObject)
  {
    try
    {
      paramRequestLevel = ImageRequest.RequestLevel.getMax(paramImageRequest.getLowestPermittedRequestLevel(), paramRequestLevel);
      paramProducer = ProducerToDataSourceAdapter.create(paramProducer, new SettableProducerContext(paramImageRequest, generateUniqueFutureId(), this.mRequestListener, paramObject, paramRequestLevel, true, false, Priority.LOW), this.mRequestListener);
      return paramProducer;
    }
    catch (Exception paramProducer) {}
    return DataSources.immediateFailedDataSource(paramProducer);
  }
  
  public void clearCaches()
  {
    clearMemoryCaches();
    clearDiskCaches();
  }
  
  public void clearDiskCaches()
  {
    this.mMainBufferedDiskCache.clearAll();
    this.mSmallImageBufferedDiskCache.clearAll();
  }
  
  public void clearMemoryCaches()
  {
    Predicate local4 = new Predicate()
    {
      public boolean apply(CacheKey paramAnonymousCacheKey)
      {
        return true;
      }
    };
    this.mBitmapMemoryCache.removeAll(local4);
    this.mEncodedMemoryCache.removeAll(local4);
  }
  
  public void evictFromCache(Uri paramUri)
  {
    evictFromMemoryCache(paramUri);
    evictFromDiskCache(paramUri);
  }
  
  public void evictFromDiskCache(Uri paramUri)
  {
    evictFromDiskCache(ImageRequest.fromUri(paramUri));
  }
  
  public void evictFromDiskCache(ImageRequest paramImageRequest)
  {
    paramImageRequest = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest);
    this.mMainBufferedDiskCache.remove(paramImageRequest);
    this.mSmallImageBufferedDiskCache.remove(paramImageRequest);
  }
  
  public void evictFromMemoryCache(Uri paramUri)
  {
    Predicate localPredicate = predicateForUri(paramUri);
    this.mBitmapMemoryCache.removeAll(localPredicate);
    paramUri = new Predicate()
    {
      public boolean apply(CacheKey paramAnonymousCacheKey)
      {
        return paramAnonymousCacheKey.toString().equals(this.val$cacheKeySourceString);
      }
    };
    this.mEncodedMemoryCache.removeAll(paramUri);
  }
  
  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject)
  {
    try
    {
      paramImageRequest = submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(paramImageRequest), paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
  
  public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest paramImageRequest, Object paramObject)
  {
    Preconditions.checkNotNull(paramImageRequest.getSourceUri());
    try
    {
      Producer localProducer = this.mProducerSequenceFactory.getEncodedImageProducerSequence(paramImageRequest);
      ImageRequest localImageRequest = paramImageRequest;
      if (paramImageRequest.getResizeOptions() != null) {
        localImageRequest = ImageRequestBuilder.fromRequest(paramImageRequest).setResizeOptions(null).build();
      }
      paramImageRequest = submitFetchRequest(localProducer, localImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
  
  public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest paramImageRequest, Object paramObject)
  {
    try
    {
      paramImageRequest = submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(paramImageRequest), paramImageRequest, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, paramObject);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
  
  public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject, final boolean paramBoolean)
  {
    new Supplier()
    {
      public DataSource<CloseableReference<CloseableImage>> get()
      {
        if (paramBoolean) {
          return ImagePipeline.this.fetchImageFromBitmapCache(paramImageRequest, paramObject);
        }
        return ImagePipeline.this.fetchDecodedImage(paramImageRequest, paramObject);
      }
      
      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }
  
  public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject)
  {
    new Supplier()
    {
      public DataSource<CloseableReference<PooledByteBuffer>> get()
      {
        return ImagePipeline.this.fetchEncodedImage(paramImageRequest, paramObject);
      }
      
      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }
  
  public boolean isInBitmapMemoryCache(Uri paramUri)
  {
    paramUri = predicateForUri(paramUri);
    return this.mBitmapMemoryCache.contains(paramUri);
  }
  
  public boolean isInBitmapMemoryCache(ImageRequest paramImageRequest)
  {
    paramImageRequest = this.mCacheKeyFactory.getBitmapCacheKey(paramImageRequest);
    paramImageRequest = this.mBitmapMemoryCache.get(paramImageRequest);
    try
    {
      boolean bool = CloseableReference.isValid(paramImageRequest);
      return bool;
    }
    finally
    {
      CloseableReference.closeSafely(paramImageRequest);
    }
  }
  
  public DataSource<Boolean> isInDiskCache(Uri paramUri)
  {
    return isInDiskCache(ImageRequest.fromUri(paramUri));
  }
  
  public DataSource<Boolean> isInDiskCache(final ImageRequest paramImageRequest)
  {
    paramImageRequest = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest);
    final SettableDataSource localSettableDataSource = SettableDataSource.create();
    this.mMainBufferedDiskCache.contains(paramImageRequest).continueWithTask(new Continuation()
    {
      public Task<Boolean> then(Task<Boolean> paramAnonymousTask)
        throws Exception
      {
        if ((!paramAnonymousTask.isCancelled()) && (!paramAnonymousTask.isFaulted()) && (((Boolean)paramAnonymousTask.getResult()).booleanValue())) {
          return Task.forResult(Boolean.valueOf(true));
        }
        return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(paramImageRequest);
      }
    }).continueWith(new Continuation()
    {
      public Void then(Task<Boolean> paramAnonymousTask)
        throws Exception
      {
        SettableDataSource localSettableDataSource = localSettableDataSource;
        if ((!paramAnonymousTask.isCancelled()) && (!paramAnonymousTask.isFaulted()) && (((Boolean)paramAnonymousTask.getResult()).booleanValue())) {}
        for (boolean bool = true;; bool = false)
        {
          localSettableDataSource.setResult(Boolean.valueOf(bool));
          return null;
        }
      }
    });
    return localSettableDataSource;
  }
  
  public DataSource<Void> prefetchToBitmapCache(ImageRequest paramImageRequest, Object paramObject)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    }
    try
    {
      paramImageRequest = submitPrefetchRequest(this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(paramImageRequest), paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
  
  public DataSource<Void> prefetchToDiskCache(ImageRequest paramImageRequest, Object paramObject)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    }
    try
    {
      paramImageRequest = submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(paramImageRequest), paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\core\ImagePipeline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */