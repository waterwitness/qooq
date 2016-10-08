package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.util.SecureHashUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class DiskStorageCache
  implements FileCache, DiskTrimmable
{
  private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30L);
  private static final long FUTURE_TIMESTAMP_THRESHOLD_MS;
  public static final int START_OF_VERSIONING = 1;
  private static final Class<?> TAG = DiskStorageCache.class;
  private static final double TRIMMING_LOWER_BOUND = 0.02D;
  private static final long UNINITIALIZED = -1L;
  private final CacheErrorLogger mCacheErrorLogger;
  private final CacheEventListener mCacheEventListener;
  @GuardedBy("mLock")
  private long mCacheSizeLastUpdateTime;
  private long mCacheSizeLimit;
  private final long mCacheSizeLimitMinimum;
  private final CacheStats mCacheStats;
  private final Clock mClock;
  private final long mDefaultCacheSizeLimit;
  private final Object mLock = new Object();
  private final long mLowDiskSpaceCacheSizeLimit;
  private final StatFsHelper mStatFsHelper;
  private final DiskStorageSupplier mStorageSupplier;
  
  static
  {
    FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2L);
  }
  
  public DiskStorageCache(DiskStorageSupplier paramDiskStorageSupplier, Params paramParams, CacheEventListener paramCacheEventListener, CacheErrorLogger paramCacheErrorLogger, @Nullable DiskTrimmableRegistry paramDiskTrimmableRegistry)
  {
    this.mLowDiskSpaceCacheSizeLimit = paramParams.mLowDiskSpaceCacheSizeLimit;
    this.mDefaultCacheSizeLimit = paramParams.mDefaultCacheSizeLimit;
    this.mCacheSizeLimit = paramParams.mDefaultCacheSizeLimit;
    this.mStatFsHelper = StatFsHelper.getInstance();
    this.mStorageSupplier = paramDiskStorageSupplier;
    this.mCacheSizeLastUpdateTime = -1L;
    this.mCacheEventListener = paramCacheEventListener;
    this.mCacheSizeLimitMinimum = paramParams.mCacheSizeLimitMinimum;
    this.mCacheErrorLogger = paramCacheErrorLogger;
    this.mCacheStats = new CacheStats();
    if (paramDiskTrimmableRegistry != null) {
      paramDiskTrimmableRegistry.registerDiskTrimmable(this);
    }
    this.mClock = com.facebook.common.time.SystemClock.get();
  }
  
  @GuardedBy("mLock")
  private void calcFileCacheSize()
  {
    long l1 = 0L;
    int k = 0;
    int m = 0;
    int j = 0;
    int i = 0;
    long l2 = -1L;
    long l4 = this.mClock.now();
    long l5 = FUTURE_TIMESTAMP_THRESHOLD_MS;
    try
    {
      Iterator localIterator = this.mStorageSupplier.get().getEntries().iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          if (m != 0) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + j + " files , with a total size of " + i + " bytes, and a maximum time delta of " + l2 + "ms", null);
          }
          this.mCacheStats.set(l1, k);
          return;
        }
        DiskStorage.Entry localEntry = (DiskStorage.Entry)localIterator.next();
        int n = k + 1;
        long l3 = l1 + localEntry.getSize();
        k = n;
        l1 = l3;
        if (localEntry.getTimestamp() > l4 + l5)
        {
          m = 1;
          j += 1;
          i = (int)(i + localEntry.getSize());
          l2 = Math.max(localEntry.getTimestamp() - l4, l2);
          k = n;
          l1 = l3;
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + localIOException.getMessage(), localIOException);
    }
  }
  
  private BinaryResource commitResource(String paramString, CacheKey paramCacheKey, BinaryResource paramBinaryResource)
    throws IOException
  {
    synchronized (this.mLock)
    {
      paramString = this.mStorageSupplier.get().commit(paramString, paramBinaryResource, paramCacheKey);
      this.mCacheStats.increment(paramString.size(), 1L);
      return paramString;
    }
  }
  
  private BinaryResource createTemporaryResource(String paramString, CacheKey paramCacheKey)
    throws IOException
  {
    maybeEvictFilesInCacheDir();
    return this.mStorageSupplier.get().createTemporary(paramString, paramCacheKey);
  }
  
  private void deleteTemporaryResource(BinaryResource paramBinaryResource)
  {
    if (!(paramBinaryResource instanceof FileBinaryResource)) {}
    do
    {
      do
      {
        return;
        paramBinaryResource = ((FileBinaryResource)paramBinaryResource).getFile();
      } while (!paramBinaryResource.exists());
      FLog.e(TAG, "Temp file still on disk: %s ", new Object[] { paramBinaryResource });
    } while (paramBinaryResource.delete());
    FLog.e(TAG, "Failed to delete temp file: %s", new Object[] { paramBinaryResource });
  }
  
  @GuardedBy("mLock")
  private void evictAboveSize(long paramLong, CacheEventListener.EvictionReason paramEvictionReason)
    throws IOException
  {
    DiskStorage localDiskStorage = this.mStorageSupplier.get();
    for (;;)
    {
      Object localObject;
      long l2;
      int i;
      long l1;
      try
      {
        localObject = getSortedEntries(localDiskStorage.getEntries());
        l2 = this.mCacheStats.getSize();
        i = 0;
        l1 = 0L;
        localObject = ((Collection)localObject).iterator();
        if (!((Iterator)localObject).hasNext())
        {
          this.mCacheStats.increment(-l1, -i);
          localDiskStorage.purgeUnexpectedResources();
          reportEviction(paramEvictionReason, i, l1);
          return;
        }
      }
      catch (IOException paramEvictionReason)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + paramEvictionReason.getMessage(), paramEvictionReason);
        throw paramEvictionReason;
      }
      DiskStorage.Entry localEntry = (DiskStorage.Entry)((Iterator)localObject).next();
      if (l1 <= l2 - paramLong)
      {
        long l3 = localDiskStorage.remove(localEntry);
        if (l3 > 0L)
        {
          i += 1;
          l1 += l3;
        }
      }
    }
  }
  
  private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> paramCollection)
  {
    paramCollection = new ArrayList(paramCollection);
    Collections.sort(paramCollection, new TimestampComparator(this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS));
    return paramCollection;
  }
  
  private void maybeEvictFilesInCacheDir()
    throws IOException
  {
    synchronized (this.mLock)
    {
      boolean bool = maybeUpdateFileCacheSize();
      updateFileCacheSizeLimit();
      long l = this.mCacheStats.getSize();
      if ((l > this.mCacheSizeLimit) && (!bool))
      {
        this.mCacheStats.reset();
        maybeUpdateFileCacheSize();
      }
      if (l > this.mCacheSizeLimit) {
        evictAboveSize(this.mCacheSizeLimit * 9L / 10L, CacheEventListener.EvictionReason.CACHE_FULL);
      }
      return;
    }
  }
  
  @GuardedBy("mLock")
  private boolean maybeUpdateFileCacheSize()
  {
    boolean bool = false;
    long l = android.os.SystemClock.elapsedRealtime();
    if ((!this.mCacheStats.isInitialized()) || (this.mCacheSizeLastUpdateTime == -1L) || (l - this.mCacheSizeLastUpdateTime > FILECACHE_SIZE_UPDATE_PERIOD_MS))
    {
      calcFileCacheSize();
      this.mCacheSizeLastUpdateTime = l;
      bool = true;
    }
    return bool;
  }
  
  private void reportEviction(CacheEventListener.EvictionReason paramEvictionReason, int paramInt, long paramLong)
  {
    this.mCacheEventListener.onEviction(paramEvictionReason, paramInt, paramLong);
  }
  
  private void trimBy(double paramDouble)
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mCacheStats.reset();
        maybeUpdateFileCacheSize();
        long l = this.mCacheStats.getSize();
        evictAboveSize(l - (l * paramDouble), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + localIOException.getMessage(), localIOException);
        }
      }
    }
  }
  
  @GuardedBy("mLock")
  private void updateFileCacheSizeLimit()
  {
    if (this.mStatFsHelper.testLowDiskSpace(StatFsHelper.StorageType.INTERNAL, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize()))
    {
      this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
      return;
    }
    this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
  }
  
  public void clearAll()
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mStorageSupplier.get().clearAll();
        this.mCacheStats.reset();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + localIOException.getMessage(), localIOException);
        }
      }
    }
  }
  
  public long clearOldEntries(long paramLong)
  {
    long l1 = 0L;
    localObject1 = this.mLock;
    long l2 = l1;
    for (;;)
    {
      try
      {
        l4 = this.mClock.now();
        l2 = l1;
        localDiskStorage = this.mStorageSupplier.get();
        l2 = l1;
        localObject3 = localDiskStorage.getEntries();
        i = 0;
        l3 = 0L;
        l2 = l1;
        localObject3 = ((Collection)localObject3).iterator();
        l2 = l1;
        if (((Iterator)localObject3).hasNext()) {
          continue;
        }
        l2 = l1;
        localDiskStorage.purgeUnexpectedResources();
        l2 = l1;
        if (i > 0)
        {
          l2 = l1;
          maybeUpdateFileCacheSize();
          l2 = l1;
          this.mCacheStats.increment(-l3, -i);
          l2 = l1;
          reportEviction(CacheEventListener.EvictionReason.CONTENT_STALE, i, l3);
          l2 = l1;
        }
      }
      catch (IOException localIOException)
      {
        long l4;
        DiskStorage localDiskStorage;
        Object localObject3;
        int i;
        long l3;
        DiskStorage.Entry localEntry;
        long l5;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + localIOException.getMessage(), localIOException);
        continue;
      }
      finally {}
      return l2;
      l2 = l1;
      localEntry = (DiskStorage.Entry)((Iterator)localObject3).next();
      l2 = l1;
      l5 = Math.max(1L, Math.abs(l4 - localEntry.getTimestamp()));
      if (l5 >= paramLong)
      {
        l2 = l1;
        l5 = localDiskStorage.remove(localEntry);
        if (l5 > 0L)
        {
          i += 1;
          l3 += l5;
        }
      }
      else
      {
        l2 = l1;
        l1 = Math.max(l1, l5);
      }
    }
  }
  
  public DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException
  {
    return this.mStorageSupplier.get().getDumpInfo();
  }
  
  public BinaryResource getResource(CacheKey paramCacheKey)
  {
    try
    {
      synchronized (this.mLock)
      {
        paramCacheKey = this.mStorageSupplier.get().getResource(getResourceId(paramCacheKey), paramCacheKey);
        if (paramCacheKey == null)
        {
          this.mCacheEventListener.onMiss();
          return paramCacheKey;
        }
        this.mCacheEventListener.onHit();
      }
      return null;
    }
    catch (IOException paramCacheKey)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", paramCacheKey);
      this.mCacheEventListener.onReadException();
    }
  }
  
  @VisibleForTesting
  String getResourceId(CacheKey paramCacheKey)
  {
    try
    {
      paramCacheKey = SecureHashUtil.makeSHA1HashBase64(paramCacheKey.toString().getBytes("UTF-8"));
      return paramCacheKey;
    }
    catch (UnsupportedEncodingException paramCacheKey)
    {
      throw new RuntimeException(paramCacheKey);
    }
  }
  
  public long getSize()
  {
    return this.mCacheStats.getSize();
  }
  
  public boolean hasKey(CacheKey paramCacheKey)
  {
    try
    {
      boolean bool = this.mStorageSupplier.get().contains(getResourceId(paramCacheKey), paramCacheKey);
      return bool;
    }
    catch (IOException paramCacheKey) {}
    return false;
  }
  
  /* Error */
  public BinaryResource insert(CacheKey paramCacheKey, com.facebook.cache.common.WriterCallback paramWriterCallback)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/facebook/cache/disk/DiskStorageCache:mCacheEventListener	Lcom/facebook/cache/common/CacheEventListener;
    //   4: invokeinterface 449 1 0
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 401	com/facebook/cache/disk/DiskStorageCache:getResourceId	(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;
    //   14: astore 4
    //   16: aload_0
    //   17: aload 4
    //   19: aload_1
    //   20: invokespecial 451	com/facebook/cache/disk/DiskStorageCache:createTemporaryResource	(Ljava/lang/String;Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/binaryresource/BinaryResource;
    //   23: astore_3
    //   24: aload_0
    //   25: getfield 106	com/facebook/cache/disk/DiskStorageCache:mStorageSupplier	Lcom/facebook/cache/disk/DiskStorageSupplier;
    //   28: invokeinterface 147 1 0
    //   33: aload 4
    //   35: aload_3
    //   36: aload_2
    //   37: aload_1
    //   38: invokeinterface 455 5 0
    //   43: aload_0
    //   44: aload 4
    //   46: aload_1
    //   47: aload_3
    //   48: invokespecial 457	com/facebook/cache/disk/DiskStorageCache:commitResource	(Ljava/lang/String;Lcom/facebook/cache/common/CacheKey;Lcom/facebook/binaryresource/BinaryResource;)Lcom/facebook/binaryresource/BinaryResource;
    //   51: astore_1
    //   52: aload_0
    //   53: aload_3
    //   54: invokespecial 459	com/facebook/cache/disk/DiskStorageCache:deleteTemporaryResource	(Lcom/facebook/binaryresource/BinaryResource;)V
    //   57: aload_1
    //   58: areturn
    //   59: astore_1
    //   60: aload_0
    //   61: aload_3
    //   62: invokespecial 459	com/facebook/cache/disk/DiskStorageCache:deleteTemporaryResource	(Lcom/facebook/binaryresource/BinaryResource;)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: getfield 110	com/facebook/cache/disk/DiskStorageCache:mCacheEventListener	Lcom/facebook/cache/common/CacheEventListener;
    //   72: invokeinterface 462 1 0
    //   77: getstatic 59	com/facebook/cache/disk/DiskStorageCache:TAG	Ljava/lang/Class;
    //   80: ldc_w 464
    //   83: aload_1
    //   84: invokestatic 468	com/facebook/common/logging/FLog:d	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	DiskStorageCache
    //   0	89	1	paramCacheKey	CacheKey
    //   0	89	2	paramWriterCallback	com.facebook.cache.common.WriterCallback
    //   23	39	3	localBinaryResource	BinaryResource
    //   14	31	4	str	String
    // Exception table:
    //   from	to	target	type
    //   24	52	59	finally
    //   16	24	67	java/io/IOException
    //   52	57	67	java/io/IOException
    //   60	67	67	java/io/IOException
  }
  
  public boolean isEnabled()
  {
    try
    {
      boolean bool = this.mStorageSupplier.get().isEnabled();
      return bool;
    }
    catch (IOException localIOException) {}
    return false;
  }
  
  public boolean probe(CacheKey paramCacheKey)
  {
    try
    {
      synchronized (this.mLock)
      {
        boolean bool = this.mStorageSupplier.get().touch(getResourceId(paramCacheKey), paramCacheKey);
        return bool;
      }
      return false;
    }
    catch (IOException paramCacheKey)
    {
      this.mCacheEventListener.onReadException();
    }
  }
  
  public void remove(CacheKey paramCacheKey)
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mStorageSupplier.get().remove(getResourceId(paramCacheKey));
        return;
      }
      catch (IOException paramCacheKey)
      {
        for (;;)
        {
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + paramCacheKey.getMessage(), paramCacheKey);
        }
      }
    }
  }
  
  public void trimToMinimum()
  {
    synchronized (this.mLock)
    {
      maybeUpdateFileCacheSize();
      long l = this.mCacheStats.getSize();
      if ((this.mCacheSizeLimitMinimum <= 0L) || (l <= 0L) || (l < this.mCacheSizeLimitMinimum)) {
        return;
      }
      double d = 1.0D - this.mCacheSizeLimitMinimum / l;
      if (d > 0.02D) {
        trimBy(d);
      }
      return;
    }
  }
  
  public void trimToNothing()
  {
    clearAll();
  }
  
  @VisibleForTesting
  static class CacheStats
  {
    private long mCount = -1L;
    private boolean mInitialized = false;
    private long mSize = -1L;
    
    public long getCount()
    {
      try
      {
        long l = this.mCount;
        return l;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public long getSize()
    {
      try
      {
        long l = this.mSize;
        return l;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void increment(long paramLong1, long paramLong2)
    {
      try
      {
        if (this.mInitialized)
        {
          this.mSize += paramLong1;
          this.mCount += paramLong2;
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public boolean isInitialized()
    {
      try
      {
        boolean bool = this.mInitialized;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void reset()
    {
      try
      {
        this.mInitialized = false;
        this.mCount = -1L;
        this.mSize = -1L;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void set(long paramLong1, long paramLong2)
    {
      try
      {
        this.mCount = paramLong2;
        this.mSize = paramLong1;
        this.mInitialized = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  public static class Params
  {
    public final long mCacheSizeLimitMinimum;
    public final long mDefaultCacheSizeLimit;
    public final long mLowDiskSpaceCacheSizeLimit;
    
    public Params(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mCacheSizeLimitMinimum = paramLong1;
      this.mLowDiskSpaceCacheSizeLimit = paramLong2;
      this.mDefaultCacheSizeLimit = paramLong3;
    }
  }
  
  private static class TimestampComparator
    implements Comparator<DiskStorage.Entry>
  {
    private final long threshold;
    
    public TimestampComparator(long paramLong)
    {
      this.threshold = paramLong;
    }
    
    public int compare(DiskStorage.Entry paramEntry1, DiskStorage.Entry paramEntry2)
    {
      long l1;
      if (paramEntry1.getTimestamp() <= this.threshold)
      {
        l1 = paramEntry1.getTimestamp();
        if (paramEntry2.getTimestamp() > this.threshold) {
          break label57;
        }
      }
      label57:
      for (long l2 = paramEntry2.getTimestamp();; l2 = 0L)
      {
        if (l1 >= l2) {
          break label63;
        }
        return -1;
        l1 = 0L;
        break;
      }
      label63:
      if (l2 > l1) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\disk\DiskStorageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */