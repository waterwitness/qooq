package com.facebook.cache.disk;

public class DiskCacheFactory
{
  public static DiskStorageCache newDiskStorageCache(DiskCacheConfig paramDiskCacheConfig)
  {
    return new DiskStorageCache(newDiskStorageSupplier(paramDiskCacheConfig), new DiskStorageCache.Params(paramDiskCacheConfig.getMinimumSizeLimit(), paramDiskCacheConfig.getLowDiskSpaceSizeLimit(), paramDiskCacheConfig.getDefaultSizeLimit()), paramDiskCacheConfig.getCacheEventListener(), paramDiskCacheConfig.getCacheErrorLogger(), paramDiskCacheConfig.getDiskTrimmableRegistry());
  }
  
  private static DiskStorageSupplier newDiskStorageSupplier(DiskCacheConfig paramDiskCacheConfig)
  {
    return new DefaultDiskStorageSupplier(paramDiskCacheConfig.getVersion(), paramDiskCacheConfig.getBaseDirectoryPathSupplier(), paramDiskCacheConfig.getBaseDirectoryName(), paramDiskCacheConfig.getCacheErrorLogger());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\disk\DiskCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */