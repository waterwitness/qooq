package com.facebook.imagepipeline.cache;

public class NoOpImageCacheStatsTracker
  implements ImageCacheStatsTracker
{
  private static NoOpImageCacheStatsTracker sInstance = null;
  
  public static NoOpImageCacheStatsTracker getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpImageCacheStatsTracker();
      }
      NoOpImageCacheStatsTracker localNoOpImageCacheStatsTracker = sInstance;
      return localNoOpImageCacheStatsTracker;
    }
    finally {}
  }
  
  public void onBitmapCacheHit() {}
  
  public void onBitmapCacheMiss() {}
  
  public void onBitmapCachePut() {}
  
  public void onDiskCacheGetFail() {}
  
  public void onDiskCacheHit() {}
  
  public void onDiskCacheMiss() {}
  
  public void onMemoryCacheHit() {}
  
  public void onMemoryCacheMiss() {}
  
  public void onMemoryCachePut() {}
  
  public void onStagingAreaHit() {}
  
  public void onStagingAreaMiss() {}
  
  public void registerBitmapMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache) {}
  
  public void registerEncodedMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\NoOpImageCacheStatsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */