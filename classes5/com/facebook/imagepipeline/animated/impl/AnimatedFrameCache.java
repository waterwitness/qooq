package com.facebook.imagepipeline.animated.impl;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class AnimatedFrameCache
{
  private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
  private final CountingMemoryCache.EntryStateObserver<CacheKey> mEntryStateObserver;
  @GuardedBy("this")
  private final LinkedHashSet<CacheKey> mFreeItemsPool;
  private final CacheKey mImageCacheKey;
  
  public AnimatedFrameCache(CacheKey paramCacheKey, CountingMemoryCache<CacheKey, CloseableImage> paramCountingMemoryCache)
  {
    this.mImageCacheKey = paramCacheKey;
    this.mBackingCache = paramCountingMemoryCache;
    this.mFreeItemsPool = new LinkedHashSet();
    this.mEntryStateObserver = new CountingMemoryCache.EntryStateObserver()
    {
      public void onExclusivityChanged(CacheKey paramAnonymousCacheKey, boolean paramAnonymousBoolean)
      {
        AnimatedFrameCache.this.onReusabilityChange(paramAnonymousCacheKey, paramAnonymousBoolean);
      }
    };
  }
  
  private FrameKey keyFor(int paramInt)
  {
    return new FrameKey(this.mImageCacheKey, paramInt);
  }
  
  @Nullable
  private CacheKey popFirstFreeItemKey()
  {
    CacheKey localCacheKey = null;
    try
    {
      Iterator localIterator = this.mFreeItemsPool.iterator();
      if (localIterator.hasNext())
      {
        localCacheKey = (CacheKey)localIterator.next();
        localIterator.remove();
      }
      return localCacheKey;
    }
    finally {}
  }
  
  @Nullable
  public CloseableReference<CloseableImage> cache(int paramInt, CloseableReference<CloseableImage> paramCloseableReference)
  {
    return this.mBackingCache.cache(keyFor(paramInt), paramCloseableReference, this.mEntryStateObserver);
  }
  
  @Nullable
  public CloseableReference<CloseableImage> get(int paramInt)
  {
    return this.mBackingCache.get(keyFor(paramInt));
  }
  
  @Nullable
  public CloseableReference<CloseableImage> getForReuse()
  {
    Object localObject;
    do
    {
      localObject = popFirstFreeItemKey();
      if (localObject == null) {
        return null;
      }
      localObject = this.mBackingCache.reuse(localObject);
    } while (localObject == null);
    return (CloseableReference<CloseableImage>)localObject;
  }
  
  public void onReusabilityChange(CacheKey paramCacheKey, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.mFreeItemsPool.add(paramCacheKey);
        return;
      }
      finally {}
      this.mFreeItemsPool.remove(paramCacheKey);
    }
  }
  
  @VisibleForTesting
  static class FrameKey
    implements CacheKey
  {
    private final int mFrameIndex;
    private final CacheKey mImageCacheKey;
    
    public FrameKey(CacheKey paramCacheKey, int paramInt)
    {
      this.mImageCacheKey = paramCacheKey;
      this.mFrameIndex = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof FrameKey)) {
          break;
        }
        paramObject = (FrameKey)paramObject;
      } while ((this.mImageCacheKey == ((FrameKey)paramObject).mImageCacheKey) && (this.mFrameIndex == ((FrameKey)paramObject).mFrameIndex));
      return false;
      return false;
    }
    
    public int hashCode()
    {
      return this.mImageCacheKey.hashCode() * 1013 + this.mFrameIndex;
    }
    
    public String toString()
    {
      return Objects.toStringHelper(this).add("imageCacheKey", this.mImageCacheKey).add("frameIndex", this.mFrameIndex).toString();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\impl\AnimatedFrameCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */