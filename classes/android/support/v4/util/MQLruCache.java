package android.support.v4.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MQLruCache<K, O>
{
  public static final byte HIGH = 2;
  public static final byte LOW = 0;
  private static final byte MAX_QUEUE = 3;
  public static final byte NORMAL = 1;
  private static final int RISE_PRIORITY_COUNT = 128;
  private int LARGE_SIZE = -1;
  private final HashSet<K> largeSizeItem = new HashSet();
  private int[] maxSizes = null;
  private AsyncLruCache<K, MQLruCache<K, O>.CacheItem>[] mqCaches = null;
  private ArrayList<Pair<K, MQLruCache<K, O>.CacheItem>>[] oldValues = null;
  
  public MQLruCache(final int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.mqCaches = new AsyncLruCache[3];
    this.oldValues = new ArrayList[3];
    this.maxSizes = new int[3];
    this.maxSizes[0] = (paramInt * 5 / 10);
    this.maxSizes[1] = (paramInt * 4 / 10);
    this.maxSizes[2] = (paramInt * 1 / 10);
    paramInt = 0;
    while (paramInt < 3)
    {
      this.oldValues[paramInt] = new ArrayList();
      this.mqCaches[paramInt = new AsyncLruCache(this.maxSizes[paramInt])
      {
        protected void entryRemoved(boolean paramAnonymousBoolean, K paramAnonymousK, MQLruCache<K, O>.CacheItem paramAnonymousMQLruCache1, MQLruCache<K, O>.CacheItem paramAnonymousMQLruCache2)
        {
          if ((paramAnonymousBoolean) && (paramInt > 0)) {
            MQLruCache.this.oldValues[paramInt].add(Pair.create(paramAnonymousK, paramAnonymousMQLruCache1));
          }
          if ((MQLruCache.this.largeSizeItem.size() > 0) && (MQLruCache.this.largeSizeItem.contains(paramAnonymousK))) {
            MQLruCache.this.largeSizeItem.remove(paramAnonymousK);
          }
        }
        
        protected int sizeOf(K paramAnonymousK, MQLruCache<K, O>.CacheItem paramAnonymousMQLruCache)
        {
          int i = MQLruCache.this.sizeOfObj(paramAnonymousK, paramAnonymousMQLruCache.value);
          if ((MQLruCache.this.LARGE_SIZE > 0) && (i >= MQLruCache.this.LARGE_SIZE) && (!MQLruCache.this.largeSizeItem.contains(paramAnonymousK)))
          {
            MQLruCache.this.largeSizeItem.add(paramAnonymousK);
            MQLruCache.this.warningLargeItem(paramAnonymousK, i);
          }
          return i;
        }
      };
      paramInt += 1;
    }
  }
  
  private final O put(K paramK, MQLruCache<K, O>.CacheItem paramMQLruCache)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = paramMQLruCache.priority;
        i = 0;
        if ((i >= 3) || ((i != j) && ((CacheItem)this.mqCaches[i].remove(paramK) != null)))
        {
          this.mqCaches[j].put(paramK, paramMQLruCache);
          i = j;
          if ((i > 0) && (this.oldValues[i].size() > 0))
          {
            j = 0;
            if (j < this.oldValues[i].size())
            {
              paramK = (Pair)this.oldValues[i].get(j);
              CacheItem localCacheItem = (CacheItem)paramK.second;
              localCacheItem.priority = ((byte)(localCacheItem.priority - 1));
              ((CacheItem)paramK.second).hitCount = 0;
              this.mqCaches[((CacheItem)paramK.second).priority].put(paramK.first, paramK.second);
              j += 1;
              continue;
            }
            this.oldValues[i].clear();
            i = (byte)(i - 1);
            continue;
          }
          paramK = paramMQLruCache.value;
          return paramK;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public final int cacheCount()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].cacheCount();
        j += k;
        i += 1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    return j;
  }
  
  public final void evictAll()
  {
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        this.mqCaches[i].evictAll();
        this.oldValues[i].clear();
        i += 1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  /* Error */
  public final O get(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: iload 4
    //   11: iconst_2
    //   12: if_icmpgt +91 -> 103
    //   15: aload_0
    //   16: getfield 41	android/support/v4/util/MQLruCache:mqCaches	[Landroid/support/v4/util/AsyncLruCache;
    //   19: iload 4
    //   21: aaload
    //   22: aload_1
    //   23: invokevirtual 122	android/support/v4/util/AsyncLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 9	android/support/v4/util/MQLruCache$CacheItem
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +85 -> 116
    //   34: aload_2
    //   35: aload_2
    //   36: getfield 103	android/support/v4/util/MQLruCache$CacheItem:hitCount	I
    //   39: iconst_1
    //   40: iadd
    //   41: putfield 103	android/support/v4/util/MQLruCache$CacheItem:hitCount	I
    //   44: aload_2
    //   45: astore_3
    //   46: aload_2
    //   47: getfield 103	android/support/v4/util/MQLruCache$CacheItem:hitCount	I
    //   50: sipush 128
    //   53: if_icmplt +50 -> 103
    //   56: aload_2
    //   57: astore_3
    //   58: aload_2
    //   59: getfield 79	android/support/v4/util/MQLruCache$CacheItem:priority	B
    //   62: iconst_2
    //   63: if_icmpge +40 -> 103
    //   66: aload_0
    //   67: getfield 41	android/support/v4/util/MQLruCache:mqCaches	[Landroid/support/v4/util/AsyncLruCache;
    //   70: iload 4
    //   72: aaload
    //   73: aload_1
    //   74: invokevirtual 83	android/support/v4/util/AsyncLruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_2
    //   79: aload_2
    //   80: getfield 79	android/support/v4/util/MQLruCache$CacheItem:priority	B
    //   83: iconst_1
    //   84: iadd
    //   85: i2b
    //   86: putfield 79	android/support/v4/util/MQLruCache$CacheItem:priority	B
    //   89: aload_2
    //   90: iconst_0
    //   91: putfield 103	android/support/v4/util/MQLruCache$CacheItem:hitCount	I
    //   94: aload_0
    //   95: aload_1
    //   96: aload_2
    //   97: invokespecial 124	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Landroid/support/v4/util/MQLruCache$CacheItem;)Ljava/lang/Object;
    //   100: pop
    //   101: aload_2
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +21 -> 125
    //   107: aload_3
    //   108: getfield 112	android/support/v4/util/MQLruCache$CacheItem:value	Ljava/lang/Object;
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: areturn
    //   116: iload 4
    //   118: iconst_1
    //   119: iadd
    //   120: istore 4
    //   122: goto -115 -> 7
    //   125: aconst_null
    //   126: astore_1
    //   127: goto -15 -> 112
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	MQLruCache
    //   0	135	1	paramK	K
    //   6	96	2	localCacheItem1	CacheItem
    //   8	100	3	localCacheItem2	CacheItem
    //   3	118	4	i	int
    // Exception table:
    //   from	to	target	type
    //   15	30	130	finally
    //   34	44	130	finally
    //   46	56	130	finally
    //   58	101	130	finally
    //   107	112	130	finally
  }
  
  public ArrayList<K> getLargeCache()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.largeSizeItem.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localIterator.next());
      }
    }
    finally {}
    return localArrayList1;
  }
  
  public final int hitCount()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].hitCount();
        j += k;
        i += 1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    return j;
  }
  
  public final int maxSize()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].maxSize();
        j += k;
        i += 1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    return j;
  }
  
  public final int missCount()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].missCount();
        j += k;
        i += 1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    return j;
  }
  
  public final O put(K paramK, O paramO)
  {
    return (O)put(paramK, new CacheItem(paramO, (byte)1));
  }
  
  public final O put(K paramK, O paramO, byte paramByte)
  {
    byte b;
    if (paramByte >= 0)
    {
      b = paramByte;
      if (paramByte <= 2) {}
    }
    else
    {
      b = 0;
    }
    return (O)put(paramK, new CacheItem(paramO, b));
  }
  
  /* Error */
  public void releaseLargeCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	android/support/v4/util/MQLruCache:largeSizeItem	Ljava/util/HashSet;
    //   6: invokevirtual 162	java/util/HashSet:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: invokevirtual 164	android/support/v4/util/MQLruCache:getLargeCache	()Ljava/util/ArrayList;
    //   21: astore_1
    //   22: iconst_0
    //   23: istore_2
    //   24: iload_2
    //   25: aload_1
    //   26: invokevirtual 90	java/util/ArrayList:size	()I
    //   29: if_icmpge +20 -> 49
    //   32: aload_0
    //   33: aload_1
    //   34: iload_2
    //   35: invokevirtual 94	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   38: invokevirtual 165	android/support/v4/util/MQLruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: iload_2
    //   43: iconst_1
    //   44: iadd
    //   45: istore_2
    //   46: goto -22 -> 24
    //   49: aload_0
    //   50: getfield 52	android/support/v4/util/MQLruCache:largeSizeItem	Ljava/util/HashSet;
    //   53: invokevirtual 166	java/util/HashSet:clear	()V
    //   56: goto -42 -> 14
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	MQLruCache
    //   21	13	1	localArrayList	ArrayList
    //   59	4	1	localObject	Object
    //   9	37	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	59	finally
    //   17	22	59	finally
    //   24	42	59	finally
    //   49	56	59	finally
  }
  
  /* Error */
  public final O remove(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_3
    //   6: iload_3
    //   7: iconst_3
    //   8: if_icmpge +21 -> 29
    //   11: aload_0
    //   12: getfield 41	android/support/v4/util/MQLruCache:mqCaches	[Landroid/support/v4/util/AsyncLruCache;
    //   15: iload_3
    //   16: aaload
    //   17: aload_1
    //   18: invokevirtual 83	android/support/v4/util/AsyncLruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 9	android/support/v4/util/MQLruCache$CacheItem
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +16 -> 42
    //   29: aload_2
    //   30: ifnull +19 -> 49
    //   33: aload_2
    //   34: getfield 112	android/support/v4/util/MQLruCache$CacheItem:value	Ljava/lang/Object;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: iload_3
    //   43: iconst_1
    //   44: iadd
    //   45: istore_3
    //   46: goto -40 -> 6
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -13 -> 38
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	MQLruCache
    //   0	59	1	paramK	K
    //   3	31	2	localCacheItem	CacheItem
    //   5	41	3	i	int
    // Exception table:
    //   from	to	target	type
    //   11	25	54	finally
    //   33	38	54	finally
  }
  
  public void setLargeSize(int paramInt)
  {
    this.LARGE_SIZE = paramInt;
    if (this.LARGE_SIZE <= 0) {
      this.largeSizeItem.clear();
    }
  }
  
  public final int size()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].size();
        j += k;
        i += 1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    return j;
  }
  
  protected int sizeOfObj(K paramK, O paramO)
  {
    return 1;
  }
  
  public final Map<K, O> snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      Object localObject = new LinkedHashMap();
      int i = 0;
      while (i < 3)
      {
        ((Map)localObject).putAll(this.mqCaches[i].snapshot());
        i += 1;
      }
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localLinkedHashMap.put(localEntry.getKey(), ((CacheItem)localEntry.getValue()).value);
      }
    }
    finally {}
    return localMap;
  }
  
  public final void trimToSize(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        i = size();
        if (i <= paramInt) {
          return;
        }
        i -= paramInt;
        paramInt = 0;
        j = this.mqCaches[paramInt].size();
        if (j >= i)
        {
          this.mqCaches[paramInt].trimToSize(j - i);
          this.oldValues[0].clear();
          this.oldValues[1].clear();
          this.oldValues[2].clear();
          continue;
        }
        this.mqCaches[paramInt].trimToSize(0);
      }
      finally {}
      i -= j;
      int j = paramInt + 1;
      if (i > 0)
      {
        paramInt = j;
        if (j < 3) {}
      }
    }
  }
  
  public void warningLargeItem(K paramK, int paramInt) {}
  
  private class CacheItem
  {
    public int hitCount = 0;
    public byte priority = 1;
    public O value;
    
    public CacheItem(byte paramByte)
    {
      this.value = paramByte;
      byte b;
      this.priority = b;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\android\support\v4\util\MQLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */