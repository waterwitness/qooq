package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import com.android.internal.util.facebook.Predicate;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingMemoryCache<K, V>
  implements MemoryCache<K, V>, MemoryTrimmable
{
  @VisibleForTesting
  static final long PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
  private final CacheTrimStrategy mCacheTrimStrategy;
  @VisibleForTesting
  @GuardedBy("this")
  final CountingLruMap<K, Entry<K, V>> mCachedEntries;
  @VisibleForTesting
  @GuardedBy("this")
  final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
  @GuardedBy("this")
  private long mLastCacheParamsCheck;
  @GuardedBy("this")
  protected MemoryCacheParams mMemoryCacheParams;
  private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
  private final ValueDescriptor<V> mValueDescriptor;
  
  public CountingMemoryCache(ValueDescriptor<V> paramValueDescriptor, CacheTrimStrategy paramCacheTrimStrategy, Supplier<MemoryCacheParams> paramSupplier)
  {
    this.mValueDescriptor = paramValueDescriptor;
    this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCacheTrimStrategy = paramCacheTrimStrategy;
    this.mMemoryCacheParamsSupplier = paramSupplier;
    this.mMemoryCacheParams = ((MemoryCacheParams)this.mMemoryCacheParamsSupplier.get());
    this.mLastCacheParamsCheck = SystemClock.elapsedRealtime();
  }
  
  /* Error */
  private boolean canCacheNewValue(V paramV)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/facebook/imagepipeline/cache/CountingMemoryCache:mValueDescriptor	Lcom/facebook/imagepipeline/cache/ValueDescriptor;
    //   6: aload_1
    //   7: invokeinterface 118 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: aload_0
    //   15: getfield 94	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParams	Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    //   18: getfield 122	com/facebook/imagepipeline/cache/MemoryCacheParams:maxCacheEntrySize	I
    //   21: if_icmpgt +49 -> 70
    //   24: aload_0
    //   25: invokevirtual 126	com/facebook/imagepipeline/cache/CountingMemoryCache:getInUseCount	()I
    //   28: aload_0
    //   29: getfield 94	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParams	Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    //   32: getfield 129	com/facebook/imagepipeline/cache/MemoryCacheParams:maxCacheEntries	I
    //   35: iconst_1
    //   36: isub
    //   37: if_icmpgt +33 -> 70
    //   40: aload_0
    //   41: invokevirtual 132	com/facebook/imagepipeline/cache/CountingMemoryCache:getInUseSizeInBytes	()I
    //   44: istore_3
    //   45: aload_0
    //   46: getfield 94	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParams	Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    //   49: getfield 135	com/facebook/imagepipeline/cache/MemoryCacheParams:maxCacheSize	I
    //   52: istore 4
    //   54: iload_3
    //   55: iload 4
    //   57: iload_2
    //   58: isub
    //   59: if_icmpgt +11 -> 70
    //   62: iconst_1
    //   63: istore 5
    //   65: aload_0
    //   66: monitorexit
    //   67: iload 5
    //   69: ireturn
    //   70: iconst_0
    //   71: istore 5
    //   73: goto -8 -> 65
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	CountingMemoryCache
    //   0	81	1	paramV	V
    //   12	47	2	i	int
    //   44	16	3	j	int
    //   52	7	4	k	int
    //   63	9	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	54	76	finally
  }
  
  /* Error */
  private void decreaseClientCount(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 143	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: getfield 146	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   11: ifle +22 -> 33
    //   14: iconst_1
    //   15: istore_2
    //   16: iload_2
    //   17: invokestatic 150	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   20: aload_1
    //   21: aload_1
    //   22: getfield 146	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   25: iconst_1
    //   26: isub
    //   27: putfield 146	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -19 -> 16
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	CountingMemoryCache
    //   0	43	1	paramEntry	Entry<K, V>
    //   15	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	38	finally
    //   16	30	38	finally
  }
  
  /* Error */
  private void increaseClientCount(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 143	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: getfield 156	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:isOrphan	Z
    //   11: ifeq +22 -> 33
    //   14: iconst_0
    //   15: istore_2
    //   16: iload_2
    //   17: invokestatic 150	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   20: aload_1
    //   21: aload_1
    //   22: getfield 146	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   25: iconst_1
    //   26: iadd
    //   27: putfield 146	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: iconst_1
    //   34: istore_2
    //   35: goto -19 -> 16
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	CountingMemoryCache
    //   0	43	1	paramEntry	Entry<K, V>
    //   15	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	38	finally
    //   16	30	38	finally
  }
  
  private void makeOrphan(Entry<K, V> paramEntry)
  {
    boolean bool = true;
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if (paramEntry.isOrphan) {
        bool = false;
      }
      Preconditions.checkState(bool);
      paramEntry.isOrphan = true;
      return;
    }
    finally {}
  }
  
  /* Error */
  private void makeOrphans(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +19 -> 22
    //   6: aload_1
    //   7: invokevirtual 166	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   10: astore_1
    //   11: aload_1
    //   12: invokeinterface 172 1 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: aload_1
    //   27: invokeinterface 175 1 0
    //   32: checkcast 18	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry
    //   35: invokespecial 177	com/facebook/imagepipeline/cache/CountingMemoryCache:makeOrphan	(Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry;)V
    //   38: goto -27 -> 11
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	CountingMemoryCache
    //   0	46	1	paramArrayList	ArrayList<Entry<K, V>>
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	41	finally
    //   11	18	41	finally
    //   25	38	41	finally
  }
  
  /* Error */
  private boolean maybeAddToExclusives(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 156	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:isOrphan	Z
    //   6: ifne +29 -> 35
    //   9: aload_1
    //   10: getfield 146	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   13: ifne +22 -> 35
    //   16: aload_0
    //   17: getfield 78	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   20: aload_1
    //   21: getfield 185	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:key	Ljava/lang/Object;
    //   24: aload_1
    //   25: invokevirtual 189	com/facebook/imagepipeline/cache/CountingLruMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: pop
    //   29: iconst_1
    //   30: istore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_2
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_2
    //   37: goto -6 -> 31
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	CountingMemoryCache
    //   0	45	1	paramEntry	Entry<K, V>
    //   30	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	29	40	finally
  }
  
  private void maybeClose(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return;
      }
      CloseableReference.closeSafely(referenceToClose((Entry)paramArrayList.next()));
    }
  }
  
  private void maybeEvictEntries()
  {
    try
    {
      ArrayList localArrayList = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
      makeOrphans(localArrayList);
      maybeClose(localArrayList);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      return;
    }
    finally {}
  }
  
  private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null)) {
      paramEntry.observer.onExclusivityChanged(paramEntry.key, true);
    }
  }
  
  private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null)) {
      paramEntry.observer.onExclusivityChanged(paramEntry.key, false);
    }
  }
  
  private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return;
      }
      maybeNotifyExclusiveEntryRemoval((Entry)paramArrayList.next());
    }
  }
  
  /* Error */
  private void maybeUpdateCacheParams()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 102	com/facebook/imagepipeline/cache/CountingMemoryCache:mLastCacheParamsCheck	J
    //   6: lstore_2
    //   7: getstatic 60	com/facebook/imagepipeline/cache/CountingMemoryCache:PARAMS_INTERCHECK_INTERVAL_MS	J
    //   10: lstore 4
    //   12: invokestatic 100	android/os/SystemClock:elapsedRealtime	()J
    //   15: lstore 6
    //   17: lload_2
    //   18: lload 4
    //   20: ladd
    //   21: lload 6
    //   23: lcmp
    //   24: ifle +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: invokestatic 100	android/os/SystemClock:elapsedRealtime	()J
    //   34: putfield 102	com/facebook/imagepipeline/cache/CountingMemoryCache:mLastCacheParamsCheck	J
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 84	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParamsSupplier	Lcom/facebook/common/internal/Supplier;
    //   42: invokeinterface 90 1 0
    //   47: checkcast 92	com/facebook/imagepipeline/cache/MemoryCacheParams
    //   50: putfield 94	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParams	Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    //   53: goto -26 -> 27
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	CountingMemoryCache
    //   56	4	1	localObject	Object
    //   6	12	2	l1	long
    //   10	9	4	l2	long
    //   15	7	6	l3	long
    // Exception table:
    //   from	to	target	type
    //   2	17	56	finally
    //   30	53	56	finally
  }
  
  private CloseableReference<V> newClientReference(final Entry<K, V> paramEntry)
  {
    try
    {
      increaseClientCount(paramEntry);
      paramEntry = CloseableReference.of(paramEntry.valueRef.get(), new ResourceReleaser()
      {
        public void release(V paramAnonymousV)
        {
          CountingMemoryCache.this.releaseClientReference(paramEntry);
        }
      });
      return paramEntry;
    }
    finally
    {
      paramEntry = finally;
      throw paramEntry;
    }
  }
  
  /* Error */
  @Nullable
  private CloseableReference<V> referenceToClose(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 143	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: getfield 156	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:isOrphan	Z
    //   11: ifeq +19 -> 30
    //   14: aload_1
    //   15: getfield 146	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   18: ifne +12 -> 30
    //   21: aload_1
    //   22: getfield 245	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:valueRef	Lcom/facebook/common/references/CloseableReference;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aconst_null
    //   31: astore_1
    //   32: goto -6 -> 26
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	CountingMemoryCache
    //   0	40	1	paramEntry	Entry<K, V>
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void releaseClientReference(Entry<K, V> paramEntry)
  {
    Preconditions.checkNotNull(paramEntry);
    for (;;)
    {
      try
      {
        decreaseClientCount(paramEntry);
        boolean bool = maybeAddToExclusives(paramEntry);
        CloseableReference localCloseableReference = referenceToClose(paramEntry);
        CloseableReference.closeSafely(localCloseableReference);
        if (bool)
        {
          maybeNotifyExclusiveEntryInsertion(paramEntry);
          maybeUpdateCacheParams();
          maybeEvictEntries();
          return;
        }
      }
      finally {}
      paramEntry = null;
    }
  }
  
  /* Error */
  @Nullable
  private ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_0
    //   4: invokestatic 267	java/lang/Math:max	(II)I
    //   7: istore_1
    //   8: iload_2
    //   9: iconst_0
    //   10: invokestatic 267	java/lang/Math:max	(II)I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 78	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   18: invokevirtual 270	com/facebook/imagepipeline/cache/CountingLruMap:getCount	()I
    //   21: iload_1
    //   22: if_icmpgt +24 -> 46
    //   25: aload_0
    //   26: getfield 78	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   29: invokevirtual 272	com/facebook/imagepipeline/cache/CountingLruMap:getSizeInBytes	()I
    //   32: istore 5
    //   34: iload 5
    //   36: iload_2
    //   37: if_icmpgt +9 -> 46
    //   40: aconst_null
    //   41: astore_3
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_3
    //   45: areturn
    //   46: new 162	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 273	java/util/ArrayList:<init>	()V
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 78	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   59: invokevirtual 270	com/facebook/imagepipeline/cache/CountingLruMap:getCount	()I
    //   62: iload_1
    //   63: if_icmpgt +17 -> 80
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 78	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   73: invokevirtual 272	com/facebook/imagepipeline/cache/CountingLruMap:getSizeInBytes	()I
    //   76: iload_2
    //   77: if_icmple -35 -> 42
    //   80: aload_0
    //   81: getfield 78	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   84: invokevirtual 276	com/facebook/imagepipeline/cache/CountingLruMap:getFirstKey	()Ljava/lang/Object;
    //   87: astore_3
    //   88: aload_0
    //   89: getfield 78	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   92: aload_3
    //   93: invokevirtual 279	com/facebook/imagepipeline/cache/CountingLruMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: aload 4
    //   99: aload_0
    //   100: getfield 80	com/facebook/imagepipeline/cache/CountingMemoryCache:mCachedEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   103: aload_3
    //   104: invokevirtual 279	com/facebook/imagepipeline/cache/CountingLruMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 18	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry
    //   110: invokevirtual 282	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: goto -59 -> 55
    //   117: astore_3
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_3
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	CountingMemoryCache
    //   0	122	1	paramInt1	int
    //   0	122	2	paramInt2	int
    //   41	63	3	localObject1	Object
    //   117	4	3	localObject2	Object
    //   53	45	4	localArrayList	ArrayList
    //   32	6	5	i	int
    // Exception table:
    //   from	to	target	type
    //   2	34	117	finally
    //   46	55	117	finally
    //   55	66	117	finally
    //   69	80	117	finally
    //   80	114	117	finally
  }
  
  private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> paramValueDescriptor)
  {
    new ValueDescriptor()
    {
      public int getSizeInBytes(CountingMemoryCache.Entry<K, V> paramAnonymousEntry)
      {
        return paramValueDescriptor.getSizeInBytes(paramAnonymousEntry.valueRef.get());
      }
    };
  }
  
  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference)
  {
    return cache(paramK, paramCloseableReference, null);
  }
  
  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference, EntryStateObserver<K> paramEntryStateObserver)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramCloseableReference);
    maybeUpdateCacheParams();
    CloseableReference localCloseableReference1 = null;
    CloseableReference localCloseableReference2 = null;
    try
    {
      Entry localEntry1 = (Entry)this.mExclusiveEntries.remove(paramK);
      Entry localEntry2 = (Entry)this.mCachedEntries.remove(paramK);
      if (localEntry2 != null)
      {
        makeOrphan(localEntry2);
        localCloseableReference1 = referenceToClose(localEntry2);
      }
      if (canCacheNewValue(paramCloseableReference.get()))
      {
        paramCloseableReference = Entry.of(paramK, paramCloseableReference, paramEntryStateObserver);
        this.mCachedEntries.put(paramK, paramCloseableReference);
        localCloseableReference2 = newClientReference(paramCloseableReference);
      }
      CloseableReference.closeSafely(localCloseableReference1);
      maybeNotifyExclusiveEntryRemoval(localEntry1);
      maybeEvictEntries();
      return localCloseableReference2;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      ArrayList localArrayList1 = this.mExclusiveEntries.clear();
      ArrayList localArrayList2 = this.mCachedEntries.clear();
      makeOrphans(localArrayList2);
      maybeClose(localArrayList2);
      maybeNotifyExclusiveEntryRemoval(localArrayList1);
      maybeUpdateCacheParams();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean contains(Predicate<K> paramPredicate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/facebook/imagepipeline/cache/CountingMemoryCache:mCachedEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   6: aload_1
    //   7: invokevirtual 311	com/facebook/imagepipeline/cache/CountingLruMap:getMatchingEntries	(Lcom/android/internal/util/facebook/Predicate;)Ljava/util/ArrayList;
    //   10: invokevirtual 314	java/util/ArrayList:isEmpty	()Z
    //   13: istore_2
    //   14: iload_2
    //   15: ifeq +9 -> 24
    //   18: iconst_0
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: iconst_1
    //   25: istore_2
    //   26: goto -6 -> 20
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	CountingMemoryCache
    //   0	34	1	paramPredicate	Predicate<K>
    //   13	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  @Nullable
  public CloseableReference<V> get(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    Object localObject = null;
    try
    {
      Entry localEntry1 = (Entry)this.mExclusiveEntries.remove(paramK);
      Entry localEntry2 = (Entry)this.mCachedEntries.get(paramK);
      paramK = (K)localObject;
      if (localEntry2 != null) {
        paramK = newClientReference(localEntry2);
      }
      maybeNotifyExclusiveEntryRemoval(localEntry1);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return paramK;
    }
    finally {}
  }
  
  public int getCount()
  {
    try
    {
      int i = this.mCachedEntries.getCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getEvictionQueueCount()
  {
    try
    {
      int i = this.mExclusiveEntries.getCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getEvictionQueueSizeInBytes()
  {
    try
    {
      int i = this.mExclusiveEntries.getSizeInBytes();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getInUseCount()
  {
    try
    {
      int i = this.mCachedEntries.getCount();
      int j = this.mExclusiveEntries.getCount();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getInUseSizeInBytes()
  {
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      int j = this.mExclusiveEntries.getSizeInBytes();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getSizeInBytes()
  {
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int removeAll(Predicate<K> paramPredicate)
  {
    try
    {
      ArrayList localArrayList = this.mExclusiveEntries.removeAll(paramPredicate);
      paramPredicate = this.mCachedEntries.removeAll(paramPredicate);
      makeOrphans(paramPredicate);
      maybeClose(paramPredicate);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return paramPredicate.size();
    }
    finally {}
  }
  
  /* Error */
  @Nullable
  public CloseableReference<V> reuse(K paramK)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 143	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aconst_null
    //   6: astore_2
    //   7: iconst_0
    //   8: istore 4
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 78	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   16: aload_1
    //   17: invokevirtual 279	com/facebook/imagepipeline/cache/CountingLruMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 18	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +43 -> 68
    //   28: aload_0
    //   29: getfield 80	com/facebook/imagepipeline/cache/CountingMemoryCache:mCachedEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   32: aload_1
    //   33: invokevirtual 279	com/facebook/imagepipeline/cache/CountingLruMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 18	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 143	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_1
    //   46: getfield 146	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   49: ifne +32 -> 81
    //   52: iconst_1
    //   53: istore 5
    //   55: iload 5
    //   57: invokestatic 150	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   60: aload_1
    //   61: getfield 245	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:valueRef	Lcom/facebook/common/references/CloseableReference;
    //   64: astore_2
    //   65: iconst_1
    //   66: istore 4
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 4
    //   72: ifeq +7 -> 79
    //   75: aload_3
    //   76: invokestatic 237	com/facebook/imagepipeline/cache/CountingMemoryCache:maybeNotifyExclusiveEntryRemoval	(Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry;)V
    //   79: aload_2
    //   80: areturn
    //   81: iconst_0
    //   82: istore 5
    //   84: goto -29 -> 55
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	CountingMemoryCache
    //   0	92	1	paramK	K
    //   6	74	2	localCloseableReference	CloseableReference
    //   23	53	3	localEntry	Entry
    //   8	63	4	i	int
    //   53	30	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   12	24	87	finally
    //   28	52	87	finally
    //   55	65	87	finally
    //   68	70	87	finally
    //   88	90	87	finally
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    double d = this.mCacheTrimStrategy.getTrimRatio(paramMemoryTrimType);
    try
    {
      paramMemoryTrimType = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, (int)(this.mCachedEntries.getSizeInBytes() * (1.0D - d)) - getInUseSizeInBytes()));
      makeOrphans(paramMemoryTrimType);
      maybeClose(paramMemoryTrimType);
      maybeNotifyExclusiveEntryRemoval(paramMemoryTrimType);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return;
    }
    finally {}
  }
  
  public static abstract interface CacheTrimStrategy
  {
    public abstract double getTrimRatio(MemoryTrimType paramMemoryTrimType);
  }
  
  @VisibleForTesting
  static class Entry<K, V>
  {
    public int clientCount;
    public boolean isOrphan;
    public final K key;
    @Nullable
    public final CountingMemoryCache.EntryStateObserver<K> observer;
    public final CloseableReference<V> valueRef;
    
    private Entry(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      this.key = Preconditions.checkNotNull(paramK);
      this.valueRef = ((CloseableReference)Preconditions.checkNotNull(CloseableReference.cloneOrNull(paramCloseableReference)));
      this.clientCount = 0;
      this.isOrphan = false;
      this.observer = paramEntryStateObserver;
    }
    
    @VisibleForTesting
    static <K, V> Entry<K, V> of(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      return new Entry(paramK, paramCloseableReference, paramEntryStateObserver);
    }
  }
  
  public static abstract interface EntryStateObserver<K>
  {
    public abstract void onExclusivityChanged(K paramK, boolean paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\CountingMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */