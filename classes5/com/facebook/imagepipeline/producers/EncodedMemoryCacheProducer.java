package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class EncodedMemoryCacheProducer
  implements Producer<EncodedImage>
{
  @VisibleForTesting
  static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
  @VisibleForTesting
  static final String VALUE_FOUND = "cached_value_found";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<EncodedImage> mInputProducer;
  private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
  
  public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<EncodedImage> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject1 = null;
    EncodedImage localEncodedImage = null;
    DelegatingConsumer local1 = null;
    String str = paramProducerContext.getId();
    ProducerListener localProducerListener = paramProducerContext.getListener();
    localProducerListener.onProducerStart(str, "EncodedMemoryCacheProducer");
    Object localObject2 = paramProducerContext.getImageRequest();
    final CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject2);
    localObject2 = this.mMemoryCache.get(localCacheKey);
    if (localObject2 != null) {
      try
      {
        localEncodedImage = new EncodedImage((CloseableReference)localObject2);
        paramProducerContext = local1;
        try
        {
          if (localProducerListener.requiresExtraMap(str)) {
            paramProducerContext = ImmutableMap.of("cached_value_found", "true");
          }
          localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramProducerContext);
          paramConsumer.onProgressUpdate(1.0F);
          paramConsumer.onNewResult(localEncodedImage, true);
          EncodedImage.closeSafely(localEncodedImage);
          return;
        }
        finally
        {
          EncodedImage.closeSafely(localEncodedImage);
        }
        if (paramProducerContext.getLowestPermittedRequestLevel().getValue() < ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
          break label229;
        }
      }
      finally
      {
        CloseableReference.closeSafely((CloseableReference)localObject2);
      }
    }
    paramProducerContext = (ProducerContext)localObject1;
    if (localProducerListener.requiresExtraMap(str)) {
      paramProducerContext = ImmutableMap.of("cached_value_found", "false");
    }
    localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramProducerContext);
    paramConsumer.onNewResult(null, true);
    CloseableReference.closeSafely((CloseableReference)localObject2);
    return;
    label229:
    local1 = new DelegatingConsumer(paramConsumer)
    {
      public void onNewResultImpl(EncodedImage paramAnonymousEncodedImage, boolean paramAnonymousBoolean)
      {
        if ((!paramAnonymousBoolean) || (paramAnonymousEncodedImage == null))
        {
          getConsumer().onNewResult(paramAnonymousEncodedImage, paramAnonymousBoolean);
          return;
        }
        Object localObject = paramAnonymousEncodedImage.getByteBufferRef();
        if (localObject != null) {
          try
          {
            CloseableReference localCloseableReference = EncodedMemoryCacheProducer.this.mMemoryCache.cache(localCacheKey, (CloseableReference)localObject);
            CloseableReference.closeSafely((CloseableReference)localObject);
            if (localCloseableReference != null) {}
            getConsumer().onNewResult(paramAnonymousEncodedImage, true);
          }
          finally
          {
            try
            {
              localObject = new EncodedImage(localCloseableReference);
              ((EncodedImage)localObject).copyMetaDataFrom(paramAnonymousEncodedImage);
              CloseableReference.closeSafely(localCloseableReference);
            }
            finally
            {
              CloseableReference.closeSafely(localCloseableReference);
            }
            try
            {
              getConsumer().onProgressUpdate(1.0F);
              getConsumer().onNewResult(localObject, true);
              EncodedImage.closeSafely((EncodedImage)localObject);
              return;
            }
            finally
            {
              EncodedImage.closeSafely((EncodedImage)localObject);
            }
            paramAnonymousEncodedImage = finally;
            CloseableReference.closeSafely((CloseableReference)localObject);
          }
        }
      }
    };
    paramConsumer = localEncodedImage;
    if (localProducerListener.requiresExtraMap(str)) {
      paramConsumer = ImmutableMap.of("cached_value_found", "false");
    }
    localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramConsumer);
    this.mInputProducer.produceResults(local1, paramProducerContext);
    CloseableReference.closeSafely((CloseableReference)localObject2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\EncodedMemoryCacheProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */