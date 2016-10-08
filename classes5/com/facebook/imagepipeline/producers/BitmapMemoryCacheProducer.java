package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;

public class BitmapMemoryCacheProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  @VisibleForTesting
  static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
  @VisibleForTesting
  static final String VALUE_FOUND = "cached_value_found";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
  
  public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }
  
  protected String getProducerName()
  {
    return "BitmapMemoryCacheProducer";
  }
  
  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject2 = null;
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str1 = paramProducerContext.getId();
    localProducerListener.onProducerStart(str1, getProducerName());
    Object localObject1 = paramProducerContext.getImageRequest();
    Object localObject3 = this.mCacheKeyFactory.getBitmapCacheKey((ImageRequest)localObject1);
    CloseableReference localCloseableReference = this.mMemoryCache.get(localObject3);
    if (localCloseableReference != null)
    {
      boolean bool = ((CloseableImage)localCloseableReference.get()).getQualityInfo().isOfFullQuality();
      String str2;
      if (bool)
      {
        str2 = getProducerName();
        if (!localProducerListener.requiresExtraMap(str1)) {
          break label158;
        }
      }
      label158:
      for (localObject1 = ImmutableMap.of("cached_value_found", "true");; localObject1 = null)
      {
        localProducerListener.onProducerFinishWithSuccess(str1, str2, (Map)localObject1);
        paramConsumer.onProgressUpdate(1.0F);
        paramConsumer.onNewResult(localCloseableReference, bool);
        localCloseableReference.close();
        if (!bool) {
          break;
        }
        return;
      }
    }
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue())
    {
      localObject1 = getProducerName();
      if (localProducerListener.requiresExtraMap(str1)) {}
      for (paramProducerContext = ImmutableMap.of("cached_value_found", "false");; paramProducerContext = null)
      {
        localProducerListener.onProducerFinishWithSuccess(str1, (String)localObject1, paramProducerContext);
        paramConsumer.onNewResult(null, true);
        return;
      }
    }
    localObject1 = wrapConsumer(paramConsumer, (CacheKey)localObject3);
    localObject3 = getProducerName();
    paramConsumer = (Consumer<CloseableReference<CloseableImage>>)localObject2;
    if (localProducerListener.requiresExtraMap(str1)) {
      paramConsumer = ImmutableMap.of("cached_value_found", "false");
    }
    localProducerListener.onProducerFinishWithSuccess(str1, (String)localObject3, paramConsumer);
    this.mInputProducer.produceResults((Consumer)localObject1, paramProducerContext);
  }
  
  protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, final CacheKey paramCacheKey)
  {
    new DelegatingConsumer(paramConsumer)
    {
      public void onNewResultImpl(CloseableReference<CloseableImage> paramAnonymousCloseableReference, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousCloseableReference == null)
        {
          if (paramAnonymousBoolean) {
            getConsumer().onNewResult(null, true);
          }
          return;
        }
        if (((CloseableImage)paramAnonymousCloseableReference.get()).isStateful())
        {
          getConsumer().onNewResult(paramAnonymousCloseableReference, paramAnonymousBoolean);
          return;
        }
        Object localObject;
        if (!paramAnonymousBoolean)
        {
          localCloseableReference = BitmapMemoryCacheProducer.this.mMemoryCache.get(paramCacheKey);
          if (localCloseableReference != null)
          {
            try
            {
              localObject = ((CloseableImage)paramAnonymousCloseableReference.get()).getQualityInfo();
              QualityInfo localQualityInfo = ((CloseableImage)localCloseableReference.get()).getQualityInfo();
              if ((localQualityInfo.isOfFullQuality()) || (localQualityInfo.getQuality() >= ((QualityInfo)localObject).getQuality()))
              {
                getConsumer().onNewResult(localCloseableReference, false);
                return;
              }
            }
            finally
            {
              CloseableReference.closeSafely(localCloseableReference);
            }
            CloseableReference.closeSafely(localCloseableReference);
          }
        }
        CloseableReference localCloseableReference = BitmapMemoryCacheProducer.this.mMemoryCache.cache(paramCacheKey, paramAnonymousCloseableReference);
        if (paramAnonymousBoolean) {}
        try
        {
          getConsumer().onProgressUpdate(1.0F);
          localObject = getConsumer();
          if (localCloseableReference != null) {
            paramAnonymousCloseableReference = localCloseableReference;
          }
          ((Consumer)localObject).onNewResult(paramAnonymousCloseableReference, paramAnonymousBoolean);
          return;
        }
        finally
        {
          CloseableReference.closeSafely(localCloseableReference);
        }
      }
    };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\BitmapMemoryCacheProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */