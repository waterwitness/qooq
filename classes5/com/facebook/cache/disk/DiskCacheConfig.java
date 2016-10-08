package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;

public class DiskCacheConfig
{
  private final String mBaseDirectoryName;
  private final Supplier<File> mBaseDirectoryPathSupplier;
  private final CacheErrorLogger mCacheErrorLogger;
  private final CacheEventListener mCacheEventListener;
  private final long mDefaultSizeLimit;
  private final DiskTrimmableRegistry mDiskTrimmableRegistry;
  private final long mLowDiskSpaceSizeLimit;
  private final long mMinimumSizeLimit;
  private final int mVersion;
  
  private DiskCacheConfig(Builder paramBuilder)
  {
    this.mVersion = paramBuilder.mVersion;
    this.mBaseDirectoryName = ((String)Preconditions.checkNotNull(paramBuilder.mBaseDirectoryName));
    this.mBaseDirectoryPathSupplier = ((Supplier)Preconditions.checkNotNull(paramBuilder.mBaseDirectoryPathSupplier));
    this.mDefaultSizeLimit = paramBuilder.mMaxCacheSize;
    this.mLowDiskSpaceSizeLimit = paramBuilder.mMaxCacheSizeOnLowDiskSpace;
    this.mMinimumSizeLimit = paramBuilder.mMaxCacheSizeOnVeryLowDiskSpace;
    Object localObject;
    if (paramBuilder.mCacheErrorLogger == null)
    {
      localObject = NoOpCacheErrorLogger.getInstance();
      this.mCacheErrorLogger = ((CacheErrorLogger)localObject);
      if (paramBuilder.mCacheEventListener != null) {
        break label121;
      }
      localObject = NoOpCacheEventListener.getInstance();
      label91:
      this.mCacheEventListener = ((CacheEventListener)localObject);
      if (paramBuilder.mDiskTrimmableRegistry != null) {
        break label129;
      }
    }
    label121:
    label129:
    for (paramBuilder = NoOpDiskTrimmableRegistry.getInstance();; paramBuilder = paramBuilder.mDiskTrimmableRegistry)
    {
      this.mDiskTrimmableRegistry = paramBuilder;
      return;
      localObject = paramBuilder.mCacheErrorLogger;
      break;
      localObject = paramBuilder.mCacheEventListener;
      break label91;
    }
  }
  
  public static Builder newBuilder()
  {
    return new Builder(null);
  }
  
  public String getBaseDirectoryName()
  {
    return this.mBaseDirectoryName;
  }
  
  public Supplier<File> getBaseDirectoryPathSupplier()
  {
    return this.mBaseDirectoryPathSupplier;
  }
  
  public CacheErrorLogger getCacheErrorLogger()
  {
    return this.mCacheErrorLogger;
  }
  
  public CacheEventListener getCacheEventListener()
  {
    return this.mCacheEventListener;
  }
  
  public long getDefaultSizeLimit()
  {
    return this.mDefaultSizeLimit;
  }
  
  public DiskTrimmableRegistry getDiskTrimmableRegistry()
  {
    return this.mDiskTrimmableRegistry;
  }
  
  public long getLowDiskSpaceSizeLimit()
  {
    return this.mLowDiskSpaceSizeLimit;
  }
  
  public long getMinimumSizeLimit()
  {
    return this.mMinimumSizeLimit;
  }
  
  public int getVersion()
  {
    return this.mVersion;
  }
  
  public static class Builder
  {
    public String mBaseDirectoryName;
    public Supplier<File> mBaseDirectoryPathSupplier;
    public CacheErrorLogger mCacheErrorLogger;
    public CacheEventListener mCacheEventListener;
    public DiskTrimmableRegistry mDiskTrimmableRegistry;
    public long mMaxCacheSize;
    public long mMaxCacheSizeOnLowDiskSpace;
    public long mMaxCacheSizeOnVeryLowDiskSpace;
    public int mVersion = 1;
    
    public DiskCacheConfig build()
    {
      return new DiskCacheConfig(this, null);
    }
    
    public Builder setBaseDirectoryName(String paramString)
    {
      this.mBaseDirectoryName = paramString;
      return this;
    }
    
    public Builder setBaseDirectoryPath(File paramFile)
    {
      this.mBaseDirectoryPathSupplier = Suppliers.of(paramFile);
      return this;
    }
    
    public Builder setBaseDirectoryPathSupplier(Supplier<File> paramSupplier)
    {
      this.mBaseDirectoryPathSupplier = paramSupplier;
      return this;
    }
    
    public Builder setCacheErrorLogger(CacheErrorLogger paramCacheErrorLogger)
    {
      this.mCacheErrorLogger = paramCacheErrorLogger;
      return this;
    }
    
    public Builder setCacheEventListener(CacheEventListener paramCacheEventListener)
    {
      this.mCacheEventListener = paramCacheEventListener;
      return this;
    }
    
    public Builder setDiskTrimmableRegistry(DiskTrimmableRegistry paramDiskTrimmableRegistry)
    {
      this.mDiskTrimmableRegistry = paramDiskTrimmableRegistry;
      return this;
    }
    
    public Builder setMaxCacheSize(long paramLong)
    {
      this.mMaxCacheSize = paramLong;
      return this;
    }
    
    public Builder setMaxCacheSizeOnLowDiskSpace(long paramLong)
    {
      this.mMaxCacheSizeOnLowDiskSpace = paramLong;
      return this;
    }
    
    public Builder setMaxCacheSizeOnVeryLowDiskSpace(long paramLong)
    {
      this.mMaxCacheSizeOnVeryLowDiskSpace = paramLong;
      return this;
    }
    
    public Builder setVersion(int paramInt)
    {
      this.mVersion = paramInt;
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\disk\DiskCacheConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */