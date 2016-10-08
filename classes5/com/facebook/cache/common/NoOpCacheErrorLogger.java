package com.facebook.cache.common;

import javax.annotation.Nullable;

public class NoOpCacheErrorLogger
  implements CacheErrorLogger
{
  private static NoOpCacheErrorLogger sInstance = null;
  
  public static NoOpCacheErrorLogger getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpCacheErrorLogger();
      }
      NoOpCacheErrorLogger localNoOpCacheErrorLogger = sInstance;
      return localNoOpCacheErrorLogger;
    }
    finally {}
  }
  
  public void logError(CacheErrorLogger.CacheErrorCategory paramCacheErrorCategory, Class<?> paramClass, String paramString, @Nullable Throwable paramThrowable) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\common\NoOpCacheErrorLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */