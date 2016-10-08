package com.facebook.imagepipeline.cache;

public abstract interface ImageCacheStatsTracker
{
  public abstract void onBitmapCacheHit();
  
  public abstract void onBitmapCacheMiss();
  
  public abstract void onBitmapCachePut();
  
  public abstract void onDiskCacheGetFail();
  
  public abstract void onDiskCacheHit();
  
  public abstract void onDiskCacheMiss();
  
  public abstract void onMemoryCacheHit();
  
  public abstract void onMemoryCacheMiss();
  
  public abstract void onMemoryCachePut();
  
  public abstract void onStagingAreaHit();
  
  public abstract void onStagingAreaMiss();
  
  public abstract void registerBitmapMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache);
  
  public abstract void registerEncodedMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\ImageCacheStatsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */