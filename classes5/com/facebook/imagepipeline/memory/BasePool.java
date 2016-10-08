package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

public abstract class BasePool<V>
  implements Pool<V>
{
  private final Class<?> TAG = getClass();
  private boolean mAllowNewBuckets;
  @VisibleForTesting
  final SparseArray<Bucket<V>> mBuckets;
  @VisibleForTesting
  @GuardedBy("this")
  final Counter mFree;
  @VisibleForTesting
  final Set<V> mInUseValues;
  final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  final PoolParams mPoolParams;
  private final PoolStatsTracker mPoolStatsTracker;
  @VisibleForTesting
  @GuardedBy("this")
  final Counter mUsed;
  
  public BasePool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)Preconditions.checkNotNull(paramMemoryTrimmableRegistry));
    this.mPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
    this.mPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
    this.mBuckets = new SparseArray();
    initBuckets(new SparseIntArray(0));
    this.mInUseValues = Sets.newIdentityHashSet();
    this.mFree = new Counter();
    this.mUsed = new Counter();
  }
  
  /* Error */
  private void ensurePoolSizeInvariant()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 108	com/facebook/imagepipeline/memory/BasePool:isMaxSizeSoftCapExceeded	()Z
    //   6: ifeq +22 -> 28
    //   9: aload_0
    //   10: getfield 100	com/facebook/imagepipeline/memory/BasePool:mFree	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   13: getfield 112	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   16: ifeq +12 -> 28
    //   19: iconst_0
    //   20: istore_2
    //   21: iload_2
    //   22: invokestatic 116	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: iconst_1
    //   29: istore_2
    //   30: goto -9 -> 21
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	BasePool
    //   33	4	1	localObject	Object
    //   20	10	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	33	finally
    //   21	25	33	finally
  }
  
  /* Error */
  private void initBuckets(SparseIntArray paramSparseIntArray)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 63	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   11: invokevirtual 119	android/util/SparseArray:clear	()V
    //   14: aload_0
    //   15: getfield 71	com/facebook/imagepipeline/memory/BasePool:mPoolParams	Lcom/facebook/imagepipeline/memory/PoolParams;
    //   18: getfield 123	com/facebook/imagepipeline/memory/PoolParams:bucketSizes	Landroid/util/SparseIntArray;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +77 -> 100
    //   26: iconst_0
    //   27: istore_3
    //   28: iload_3
    //   29: aload_2
    //   30: invokevirtual 127	android/util/SparseIntArray:size	()I
    //   33: if_icmplt +11 -> 44
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 129	com/facebook/imagepipeline/memory/BasePool:mAllowNewBuckets	Z
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_2
    //   45: iload_3
    //   46: invokevirtual 133	android/util/SparseIntArray:keyAt	(I)I
    //   49: istore 4
    //   51: aload_2
    //   52: iload_3
    //   53: invokevirtual 136	android/util/SparseIntArray:valueAt	(I)I
    //   56: istore 5
    //   58: aload_1
    //   59: iload 4
    //   61: iconst_0
    //   62: invokevirtual 140	android/util/SparseIntArray:get	(II)I
    //   65: istore 6
    //   67: aload_0
    //   68: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   71: iload 4
    //   73: new 142	com/facebook/imagepipeline/memory/Bucket
    //   76: dup
    //   77: aload_0
    //   78: iload 4
    //   80: invokevirtual 145	com/facebook/imagepipeline/memory/BasePool:getSizeInBytes	(I)I
    //   83: iload 5
    //   85: iload 6
    //   87: invokespecial 148	com/facebook/imagepipeline/memory/Bucket:<init>	(III)V
    //   90: invokevirtual 152	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   93: iload_3
    //   94: iconst_1
    //   95: iadd
    //   96: istore_3
    //   97: goto -69 -> 28
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield 129	com/facebook/imagepipeline/memory/BasePool:mAllowNewBuckets	Z
    //   105: goto -64 -> 41
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	BasePool
    //   0	113	1	paramSparseIntArray	SparseIntArray
    //   21	31	2	localSparseIntArray	SparseIntArray
    //   27	70	3	i	int
    //   49	30	4	j	int
    //   56	28	5	k	int
    //   65	21	6	m	int
    // Exception table:
    //   from	to	target	type
    //   2	22	108	finally
    //   28	41	108	finally
    //   44	93	108	finally
    //   100	105	108	finally
  }
  
  @SuppressLint({"InvalidAccessToGuardedField"})
  private void logStats()
  {
    if (FLog.isLoggable(2)) {
      FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
    }
  }
  
  protected abstract V alloc(int paramInt);
  
  @VisibleForTesting
  boolean canAllocate(int paramInt)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        int i = this.mPoolParams.maxSizeHardCap;
        if (paramInt > i - this.mUsed.mNumBytes)
        {
          this.mPoolStatsTracker.onHardCapReached();
          return bool;
        }
        int j = this.mPoolParams.maxSizeSoftCap;
        if (paramInt > j - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
          trimToSize(j - paramInt);
        }
        if (paramInt > i - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
          this.mPoolStatsTracker.onHardCapReached();
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  @VisibleForTesting
  protected abstract void free(V paramV);
  
  public V get(int paramInt)
  {
    ensurePoolSizeInvariant();
    paramInt = getBucketedSize(paramInt);
    Object localObject5;
    try
    {
      Bucket localBucket1 = getBucket(paramInt);
      if (localBucket1 != null)
      {
        localObject5 = localBucket1.get();
        if (localObject5 != null)
        {
          Preconditions.checkState(this.mInUseValues.add(localObject5));
          paramInt = getBucketedSizeForValue(localObject5);
          i = getSizeInBytes(paramInt);
          this.mUsed.increment(i);
          this.mFree.decrement(i);
          this.mPoolStatsTracker.onValueReuse(i);
          logStats();
          if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject5)), Integer.valueOf(paramInt));
          }
          return (V)localObject5;
        }
      }
      i = getSizeInBytes(paramInt);
      if (!canAllocate(i)) {
        throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, i);
      }
    }
    finally {}
    this.mUsed.increment(i);
    if (localObject1 != null) {
      ((Bucket)localObject1).incrementInUseCount();
    }
    Object localObject2 = null;
    try
    {
      localObject5 = alloc(paramInt);
      localObject2 = localObject5;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          this.mUsed.decrement(i);
          Bucket localBucket2 = getBucket(paramInt);
          if (localBucket2 == null) {
            break label302;
          }
          localBucket2.decrementInUseCount();
          Throwables.propagateIfPossible(localThrowable);
        }
        finally {}
      }
    }
    try
    {
      Preconditions.checkState(this.mInUseValues.add(localObject2));
      trimToSoftCap();
      this.mPoolStatsTracker.onAlloc(i);
      logStats();
      if (FLog.isLoggable(2)) {
        FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject2)), Integer.valueOf(paramInt));
      }
      return (V)localObject2;
    }
    finally {}
  }
  
  /* Error */
  @VisibleForTesting
  Bucket<V> getBucket(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual 270	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 142	com/facebook/imagepipeline/memory/Bucket
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +12 -> 27
    //   18: aload_0
    //   19: getfield 129	com/facebook/imagepipeline/memory/BasePool:mAllowNewBuckets	Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +7 -> 31
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: areturn
    //   31: iconst_2
    //   32: invokestatic 161	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   35: ifeq +17 -> 52
    //   38: aload_0
    //   39: getfield 57	com/facebook/imagepipeline/memory/BasePool:TAG	Ljava/lang/Class;
    //   42: ldc_w 272
    //   45: iload_1
    //   46: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokestatic 275	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   52: aload_0
    //   53: iload_1
    //   54: invokevirtual 278	com/facebook/imagepipeline/memory/BasePool:newBucket	(I)Lcom/facebook/imagepipeline/memory/Bucket;
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   62: iload_1
    //   63: aload_2
    //   64: invokevirtual 152	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   67: goto -40 -> 27
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	BasePool
    //   0	75	1	paramInt	int
    //   13	51	2	localBucket	Bucket
    //   70	4	2	localObject	Object
    //   22	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	70	finally
    //   18	23	70	finally
    //   31	52	70	finally
    //   52	67	70	finally
  }
  
  protected abstract int getBucketedSize(int paramInt);
  
  protected abstract int getBucketedSizeForValue(V paramV);
  
  protected abstract int getSizeInBytes(int paramInt);
  
  /* Error */
  public java.util.Map<String, Integer> getStats()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 283	java/util/HashMap
    //   5: dup
    //   6: invokespecial 284	java/util/HashMap:<init>	()V
    //   9: astore_1
    //   10: iconst_0
    //   11: istore_3
    //   12: iload_3
    //   13: aload_0
    //   14: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   17: invokevirtual 285	android/util/SparseArray:size	()I
    //   20: if_icmplt +127 -> 147
    //   23: aload_1
    //   24: ldc_w 287
    //   27: aload_0
    //   28: getfield 71	com/facebook/imagepipeline/memory/BasePool:mPoolParams	Lcom/facebook/imagepipeline/memory/PoolParams;
    //   31: getfield 189	com/facebook/imagepipeline/memory/PoolParams:maxSizeSoftCap	I
    //   34: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokeinterface 292 3 0
    //   42: pop
    //   43: aload_1
    //   44: ldc_w 294
    //   47: aload_0
    //   48: getfield 71	com/facebook/imagepipeline/memory/BasePool:mPoolParams	Lcom/facebook/imagepipeline/memory/PoolParams;
    //   51: getfield 183	com/facebook/imagepipeline/memory/PoolParams:maxSizeHardCap	I
    //   54: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: invokeinterface 292 3 0
    //   62: pop
    //   63: aload_1
    //   64: ldc_w 296
    //   67: aload_0
    //   68: getfield 102	com/facebook/imagepipeline/memory/BasePool:mUsed	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   71: getfield 166	com/facebook/imagepipeline/memory/BasePool$Counter:mCount	I
    //   74: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: invokeinterface 292 3 0
    //   82: pop
    //   83: aload_1
    //   84: ldc_w 298
    //   87: aload_0
    //   88: getfield 102	com/facebook/imagepipeline/memory/BasePool:mUsed	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   91: getfield 112	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   94: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokeinterface 292 3 0
    //   102: pop
    //   103: aload_1
    //   104: ldc_w 300
    //   107: aload_0
    //   108: getfield 100	com/facebook/imagepipeline/memory/BasePool:mFree	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   111: getfield 166	com/facebook/imagepipeline/memory/BasePool$Counter:mCount	I
    //   114: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokeinterface 292 3 0
    //   122: pop
    //   123: aload_1
    //   124: ldc_w 302
    //   127: aload_0
    //   128: getfield 100	com/facebook/imagepipeline/memory/BasePool:mFree	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   131: getfield 112	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   134: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: invokeinterface 292 3 0
    //   142: pop
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: areturn
    //   147: aload_0
    //   148: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   151: iload_3
    //   152: invokevirtual 303	android/util/SparseArray:keyAt	(I)I
    //   155: istore 4
    //   157: aload_0
    //   158: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   161: iload_3
    //   162: invokevirtual 305	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   165: checkcast 142	com/facebook/imagepipeline/memory/Bucket
    //   168: astore_2
    //   169: aload_1
    //   170: new 307	java/lang/StringBuilder
    //   173: dup
    //   174: ldc_w 309
    //   177: invokespecial 312	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: iload 4
    //   183: invokevirtual 145	com/facebook/imagepipeline/memory/BasePool:getSizeInBytes	(I)I
    //   186: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aload_2
    //   193: invokevirtual 323	com/facebook/imagepipeline/memory/Bucket:getInUseCount	()I
    //   196: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: invokeinterface 292 3 0
    //   204: pop
    //   205: iload_3
    //   206: iconst_1
    //   207: iadd
    //   208: istore_3
    //   209: goto -197 -> 12
    //   212: astore_1
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	BasePool
    //   9	161	1	localHashMap	java.util.HashMap
    //   212	4	1	localObject	Object
    //   168	25	2	localBucket	Bucket
    //   11	198	3	i	int
    //   155	27	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	10	212	finally
    //   12	143	212	finally
    //   147	205	212	finally
  }
  
  protected void initialize()
  {
    this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
    this.mPoolStatsTracker.setBasePool(this);
  }
  
  /* Error */
  @VisibleForTesting
  boolean isMaxSizeSoftCapExceeded()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 102	com/facebook/imagepipeline/memory/BasePool:mUsed	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   6: getfield 112	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   9: aload_0
    //   10: getfield 100	com/facebook/imagepipeline/memory/BasePool:mFree	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   13: getfield 112	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   16: iadd
    //   17: aload_0
    //   18: getfield 71	com/facebook/imagepipeline/memory/BasePool:mPoolParams	Lcom/facebook/imagepipeline/memory/PoolParams;
    //   21: getfield 189	com/facebook/imagepipeline/memory/PoolParams:maxSizeSoftCap	I
    //   24: if_icmple +22 -> 46
    //   27: iconst_1
    //   28: istore_2
    //   29: iload_2
    //   30: ifeq +12 -> 42
    //   33: aload_0
    //   34: getfield 75	com/facebook/imagepipeline/memory/BasePool:mPoolStatsTracker	Lcom/facebook/imagepipeline/memory/PoolStatsTracker;
    //   37: invokeinterface 336 1 0
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_2
    //   45: ireturn
    //   46: iconst_0
    //   47: istore_2
    //   48: goto -19 -> 29
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	BasePool
    //   51	4	1	localObject	Object
    //   28	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	51	finally
    //   33	42	51	finally
  }
  
  protected boolean isReusable(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    return true;
  }
  
  Bucket<V> newBucket(int paramInt)
  {
    return new Bucket(getSizeInBytes(paramInt), Integer.MAX_VALUE, 0);
  }
  
  protected void onParamsChanged() {}
  
  public void release(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    int i = getBucketedSizeForValue(paramV);
    int j = getSizeInBytes(i);
    for (;;)
    {
      try
      {
        Bucket localBucket = getBucket(i);
        if (!this.mInUseValues.remove(paramV))
        {
          FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[] { Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i) });
          free(paramV);
          this.mPoolStatsTracker.onFree(j);
          logStats();
          return;
        }
        if ((localBucket == null) || (localBucket.isMaxLengthExceeded()) || (isMaxSizeSoftCapExceeded()) || (!isReusable(paramV)))
        {
          if (localBucket != null) {
            localBucket.decrementInUseCount();
          }
          if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
          }
          free(paramV);
          this.mUsed.decrement(j);
          this.mPoolStatsTracker.onFree(j);
          continue;
        }
        localBucket.release(paramV);
      }
      finally {}
      this.mFree.increment(j);
      this.mUsed.decrement(j);
      this.mPoolStatsTracker.onValueRelease(j);
      if (FLog.isLoggable(2)) {
        FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
      }
    }
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    trimToNothing();
  }
  
  @VisibleForTesting
  void trimToNothing()
  {
    ArrayList localArrayList = new ArrayList(this.mBuckets.size());
    Object localObject2 = new SparseIntArray();
    int i = 0;
    Object localObject3;
    try
    {
      for (;;)
      {
        if (i >= this.mBuckets.size())
        {
          initBuckets((SparseIntArray)localObject2);
          this.mFree.reset();
          logStats();
          onParamsChanged();
          i = 0;
          if (i < localArrayList.size()) {
            break;
          }
          return;
        }
        localObject3 = (Bucket)this.mBuckets.valueAt(i);
        if (((Bucket)localObject3).getFreeListSize() > 0) {
          localArrayList.add(localObject3);
        }
        ((SparseIntArray)localObject2).put(this.mBuckets.keyAt(i), ((Bucket)localObject3).getInUseCount());
        i += 1;
      }
      localObject2 = (Bucket)((List)localObject1).get(i);
    }
    finally {}
    for (;;)
    {
      localObject3 = ((Bucket)localObject2).pop();
      if (localObject3 == null)
      {
        i += 1;
        break;
      }
      free(localObject3);
    }
  }
  
  @VisibleForTesting
  void trimToSize(int paramInt)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = Math.min(this.mUsed.mNumBytes + this.mFree.mNumBytes - paramInt, this.mFree.mNumBytes);
        if (j <= 0) {
          return;
        }
        if (FLog.isLoggable(2)) {
          FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(j));
        }
        logStats();
        i = 0;
        if (i >= this.mBuckets.size())
        {
          logStats();
          if (!FLog.isLoggable(2)) {
            continue;
          }
          FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
          continue;
        }
        if (j <= 0) {
          continue;
        }
      }
      finally {}
      Bucket localBucket = (Bucket)this.mBuckets.valueAt(i);
      while (j > 0)
      {
        Object localObject2 = localBucket.pop();
        if (localObject2 == null) {
          break;
        }
        free(localObject2);
        j -= localBucket.mItemSize;
        this.mFree.decrement(localBucket.mItemSize);
      }
      i += 1;
    }
  }
  
  @VisibleForTesting
  void trimToSoftCap()
  {
    try
    {
      if (isMaxSizeSoftCapExceeded()) {
        trimToSize(this.mPoolParams.maxSizeSoftCap);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @VisibleForTesting
  @NotThreadSafe
  static class Counter
  {
    private static final String TAG = "com.facebook.imagepipeline.common.BasePool.Counter";
    int mCount;
    int mNumBytes;
    
    public void decrement(int paramInt)
    {
      if ((this.mNumBytes >= paramInt) && (this.mCount > 0))
      {
        this.mCount -= 1;
        this.mNumBytes -= paramInt;
        return;
      }
      FLog.wtf("com.facebook.imagepipeline.common.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount) });
    }
    
    public void increment(int paramInt)
    {
      this.mCount += 1;
      this.mNumBytes += paramInt;
    }
    
    public void reset()
    {
      this.mCount = 0;
      this.mNumBytes = 0;
    }
  }
  
  public static class InvalidSizeException
    extends RuntimeException
  {
    public InvalidSizeException(Object paramObject)
    {
      super();
    }
  }
  
  public static class InvalidValueException
    extends RuntimeException
  {
    public InvalidValueException(Object paramObject)
    {
      super();
    }
  }
  
  public static class PoolSizeViolationException
    extends RuntimeException
  {
    public PoolSizeViolationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
  }
  
  public static class SizeTooLargeException
    extends BasePool.InvalidSizeException
  {
    public SizeTooLargeException(Object paramObject)
    {
      super();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\BasePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */