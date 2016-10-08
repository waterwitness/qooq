package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import java.io.IOException;

public abstract interface FileCache
  extends DiskTrimmable
{
  public abstract void clearAll();
  
  public abstract long clearOldEntries(long paramLong);
  
  public abstract DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException;
  
  public abstract BinaryResource getResource(CacheKey paramCacheKey);
  
  public abstract long getSize();
  
  public abstract boolean hasKey(CacheKey paramCacheKey);
  
  public abstract BinaryResource insert(CacheKey paramCacheKey, WriterCallback paramWriterCallback)
    throws IOException;
  
  public abstract boolean isEnabled();
  
  public abstract boolean probe(CacheKey paramCacheKey);
  
  public abstract void remove(CacheKey paramCacheKey);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\disk\FileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */