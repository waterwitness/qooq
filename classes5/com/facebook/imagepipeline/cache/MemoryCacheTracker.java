package com.facebook.imagepipeline.cache;

public abstract interface MemoryCacheTracker
{
  public abstract void onCacheHit();
  
  public abstract void onCacheMiss();
  
  public abstract void onCachePut();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\MemoryCacheTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */