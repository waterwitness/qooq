package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class CountingMemoryCacheInspector<K, V>
{
  private final CountingMemoryCache<K, V> mCountingBitmapCache;
  
  public CountingMemoryCacheInspector(CountingMemoryCache<K, V> paramCountingMemoryCache)
  {
    this.mCountingBitmapCache = paramCountingMemoryCache;
  }
  
  public DumpInfo dumpCacheContent()
  {
    for (;;)
    {
      DumpInfoEntry localDumpInfoEntry;
      synchronized (this.mCountingBitmapCache)
      {
        DumpInfo localDumpInfo = new DumpInfo(this.mCountingBitmapCache.getSizeInBytes(), this.mCountingBitmapCache.getEvictionQueueSizeInBytes(), this.mCountingBitmapCache.mMemoryCacheParams);
        Iterator localIterator = this.mCountingBitmapCache.mCachedEntries.getMatchingEntries(null).iterator();
        if (!localIterator.hasNext()) {
          return localDumpInfo;
        }
        CountingMemoryCache.Entry localEntry = (CountingMemoryCache.Entry)((Map.Entry)localIterator.next()).getValue();
        localDumpInfoEntry = new DumpInfoEntry(localEntry.key, localEntry.valueRef);
        if (localEntry.clientCount > 0) {
          localDumpInfo.sharedEntries.add(localDumpInfoEntry);
        }
      }
      ((DumpInfo)localObject).lruEntries.add(localDumpInfoEntry);
    }
  }
  
  public static class DumpInfo<K, V>
  {
    public final List<CountingMemoryCacheInspector.DumpInfoEntry<K, V>> lruEntries;
    public final int lruSize;
    public final int maxEntriesCount;
    public final int maxEntrySize;
    public final int maxSize;
    public final List<CountingMemoryCacheInspector.DumpInfoEntry<K, V>> sharedEntries;
    public final int size;
    
    public DumpInfo(int paramInt1, int paramInt2, MemoryCacheParams paramMemoryCacheParams)
    {
      this.maxSize = paramMemoryCacheParams.maxCacheSize;
      this.maxEntriesCount = paramMemoryCacheParams.maxCacheEntries;
      this.maxEntrySize = paramMemoryCacheParams.maxCacheEntrySize;
      this.size = paramInt1;
      this.lruSize = paramInt2;
      this.lruEntries = new ArrayList();
      this.sharedEntries = new ArrayList();
    }
    
    public void release()
    {
      Iterator localIterator = this.lruEntries.iterator();
      if (!localIterator.hasNext()) {
        localIterator = this.sharedEntries.iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          return;
          ((CountingMemoryCacheInspector.DumpInfoEntry)localIterator.next()).release();
          break;
        }
        ((CountingMemoryCacheInspector.DumpInfoEntry)localIterator.next()).release();
      }
    }
  }
  
  public static class DumpInfoEntry<K, V>
  {
    public final K key;
    public final CloseableReference<V> value;
    
    public DumpInfoEntry(K paramK, CloseableReference<V> paramCloseableReference)
    {
      this.key = Preconditions.checkNotNull(paramK);
      this.value = CloseableReference.cloneOrNull(paramCloseableReference);
    }
    
    public void release()
    {
      CloseableReference.closeSafely(this.value);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\CountingMemoryCacheInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */