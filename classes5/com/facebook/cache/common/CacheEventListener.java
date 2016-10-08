package com.facebook.cache.common;

public abstract interface CacheEventListener
{
  public abstract void onEviction(EvictionReason paramEvictionReason, int paramInt, long paramLong);
  
  public abstract void onHit();
  
  public abstract void onMiss();
  
  public abstract void onReadException();
  
  public abstract void onWriteAttempt();
  
  public abstract void onWriteException();
  
  public static enum EvictionReason
  {
    CACHE_FULL,  CONTENT_STALE,  USER_FORCED,  CACHE_MANAGER_TRIMMED;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\common\CacheEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */