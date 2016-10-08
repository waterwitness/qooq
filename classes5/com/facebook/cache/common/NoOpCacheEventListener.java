package com.facebook.cache.common;

public class NoOpCacheEventListener
  implements CacheEventListener
{
  private static NoOpCacheEventListener sInstance = null;
  
  public static NoOpCacheEventListener getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpCacheEventListener();
      }
      NoOpCacheEventListener localNoOpCacheEventListener = sInstance;
      return localNoOpCacheEventListener;
    }
    finally {}
  }
  
  public void onEviction(CacheEventListener.EvictionReason paramEvictionReason, int paramInt, long paramLong) {}
  
  public void onHit() {}
  
  public void onMiss() {}
  
  public void onReadException() {}
  
  public void onWriteAttempt() {}
  
  public void onWriteException() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\common\NoOpCacheEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */