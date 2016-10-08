package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingLruMap<K, V>
{
  @GuardedBy("this")
  private final LinkedHashMap<K, V> mMap = new LinkedHashMap();
  @GuardedBy("this")
  private int mSizeInBytes = 0;
  private final ValueDescriptor<V> mValueDescriptor;
  
  public CountingLruMap(ValueDescriptor<V> paramValueDescriptor)
  {
    this.mValueDescriptor = paramValueDescriptor;
  }
  
  private int getValueSizeInBytes(V paramV)
  {
    if (paramV == null) {
      return 0;
    }
    return this.mValueDescriptor.getSizeInBytes(paramV);
  }
  
  public ArrayList<V> clear()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      this.mMap.clear();
      this.mSizeInBytes = 0;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean contains(K paramK)
  {
    try
    {
      boolean bool = this.mMap.containsKey(paramK);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  @Nullable
  public V get(K paramK)
  {
    try
    {
      paramK = this.mMap.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public int getCount()
  {
    try
    {
      int i = this.mMap.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  @Nullable
  public K getFirstKey()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/facebook/imagepipeline/cache/CountingLruMap:mMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 80	java/util/LinkedHashMap:isEmpty	()Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +9 -> 20
    //   14: aconst_null
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 27	com/facebook/imagepipeline/cache/CountingLruMap:mMap	Ljava/util/LinkedHashMap;
    //   24: invokevirtual 84	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   27: invokeinterface 90 1 0
    //   32: invokeinterface 95 1 0
    //   37: astore_1
    //   38: goto -22 -> 16
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	CountingLruMap
    //   15	23	1	localObject1	Object
    //   41	4	1	localObject2	Object
    //   9	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	10	41	finally
    //   20	38	41	finally
  }
  
  @VisibleForTesting
  ArrayList<K> getKeys()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.keySet());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public ArrayList<java.util.Map.Entry<K, V>> getMatchingEntries(@Nullable com.android.internal.util.facebook.Predicate<K> paramPredicate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 46	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 103	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 27	com/facebook/imagepipeline/cache/CountingLruMap:mMap	Ljava/util/LinkedHashMap;
    //   14: invokevirtual 106	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   17: invokeinterface 90 1 0
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 109 1 0
    //   29: istore 5
    //   31: iload 5
    //   33: ifne +7 -> 40
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: aload_3
    //   41: invokeinterface 95 1 0
    //   46: checkcast 111	java/util/Map$Entry
    //   49: astore 4
    //   51: aload_1
    //   52: ifnull +19 -> 71
    //   55: aload_1
    //   56: aload 4
    //   58: invokeinterface 114 1 0
    //   63: invokeinterface 119 2 0
    //   68: ifeq -45 -> 23
    //   71: aload_2
    //   72: aload 4
    //   74: invokevirtual 122	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: goto -55 -> 23
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	CountingLruMap
    //   0	86	1	paramPredicate	com.android.internal.util.facebook.Predicate<K>
    //   9	63	2	localArrayList	ArrayList
    //   22	19	3	localIterator	java.util.Iterator
    //   49	24	4	localEntry	java.util.Map.Entry
    //   29	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	81	finally
    //   23	31	81	finally
    //   40	51	81	finally
    //   55	71	81	finally
    //   71	78	81	finally
  }
  
  public int getSizeInBytes()
  {
    try
    {
      int i = this.mSizeInBytes;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @VisibleForTesting
  ArrayList<V> getValues()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public V put(K paramK, V paramV)
  {
    try
    {
      Object localObject = this.mMap.remove(paramK);
      this.mSizeInBytes -= getValueSizeInBytes(localObject);
      this.mMap.put(paramK, paramV);
      this.mSizeInBytes += getValueSizeInBytes(paramV);
      return (V)localObject;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  @Nullable
  public V remove(K paramK)
  {
    try
    {
      paramK = this.mMap.remove(paramK);
      this.mSizeInBytes -= getValueSizeInBytes(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  /* Error */
  public ArrayList<V> removeAll(@Nullable com.android.internal.util.facebook.Predicate<K> paramPredicate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 46	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 103	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 27	com/facebook/imagepipeline/cache/CountingLruMap:mMap	Ljava/util/LinkedHashMap;
    //   14: invokevirtual 106	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   17: invokeinterface 90 1 0
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 109 1 0
    //   29: istore 5
    //   31: iload 5
    //   33: ifne +7 -> 40
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: aload_3
    //   41: invokeinterface 95 1 0
    //   46: checkcast 111	java/util/Map$Entry
    //   49: astore 4
    //   51: aload_1
    //   52: ifnull +19 -> 71
    //   55: aload_1
    //   56: aload 4
    //   58: invokeinterface 114 1 0
    //   63: invokeinterface 119 2 0
    //   68: ifeq -45 -> 23
    //   71: aload_2
    //   72: aload 4
    //   74: invokeinterface 139 1 0
    //   79: invokevirtual 122	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 29	com/facebook/imagepipeline/cache/CountingLruMap:mSizeInBytes	I
    //   88: aload_0
    //   89: aload 4
    //   91: invokeinterface 139 1 0
    //   96: invokespecial 132	com/facebook/imagepipeline/cache/CountingLruMap:getValueSizeInBytes	(Ljava/lang/Object;)I
    //   99: isub
    //   100: putfield 29	com/facebook/imagepipeline/cache/CountingLruMap:mSizeInBytes	I
    //   103: aload_3
    //   104: invokeinterface 141 1 0
    //   109: goto -86 -> 23
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	CountingLruMap
    //   0	117	1	paramPredicate	com.android.internal.util.facebook.Predicate<K>
    //   9	63	2	localArrayList	ArrayList
    //   22	82	3	localIterator	java.util.Iterator
    //   49	41	4	localEntry	java.util.Map.Entry
    //   29	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	112	finally
    //   23	31	112	finally
    //   40	51	112	finally
    //   55	71	112	finally
    //   71	109	112	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\CountingLruMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */