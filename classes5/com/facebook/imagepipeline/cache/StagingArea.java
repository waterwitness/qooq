package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class StagingArea
{
  private static final Class<?> TAG = StagingArea.class;
  @GuardedBy("this")
  private Map<CacheKey, EncodedImage> mMap = new HashMap();
  
  public static StagingArea getInstance()
  {
    return new StagingArea();
  }
  
  private void logStats()
  {
    try
    {
      FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void clearAll()
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList(this.mMap.values());
        this.mMap.clear();
        i = 0;
        if (i >= localArrayList.size()) {
          return;
        }
      }
      finally {}
      EncodedImage localEncodedImage = (EncodedImage)((List)localObject).get(i);
      if (localEncodedImage != null) {
        localEncodedImage.close();
      }
      i += 1;
    }
  }
  
  /* Error */
  public EncodedImage get(CacheKey paramCacheKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 82	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 84 2 0
    //   17: checkcast 72	com/facebook/imagepipeline/image/EncodedImage
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: ifnull +95 -> 119
    //   27: aload_3
    //   28: monitorenter
    //   29: aload_3
    //   30: invokestatic 88	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    //   33: ifne +63 -> 96
    //   36: aload_0
    //   37: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   40: aload_1
    //   41: invokeinterface 91 2 0
    //   46: pop
    //   47: getstatic 17	com/facebook/imagepipeline/cache/StagingArea:TAG	Ljava/lang/Class;
    //   50: ldc 93
    //   52: iconst_3
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_3
    //   59: invokestatic 99	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   62: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_1
    //   69: invokeinterface 105 1 0
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: aload_1
    //   78: invokestatic 99	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   81: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokestatic 109	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_3
    //   89: monitorexit
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: areturn
    //   96: aload_3
    //   97: invokestatic 113	com/facebook/imagepipeline/image/EncodedImage:cloneOrNull	(Lcom/facebook/imagepipeline/image/EncodedImage;)Lcom/facebook/imagepipeline/image/EncodedImage;
    //   100: astore_2
    //   101: aload_3
    //   102: monitorexit
    //   103: goto +16 -> 119
    //   106: aload_3
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -10 -> 106
    //   119: aload_2
    //   120: astore_1
    //   121: goto -29 -> 92
    //   124: astore_1
    //   125: goto -19 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	StagingArea
    //   0	128	1	paramCacheKey	CacheKey
    //   22	98	2	localEncodedImage1	EncodedImage
    //   20	87	3	localEncodedImage2	EncodedImage
    // Exception table:
    //   from	to	target	type
    //   2	21	110	finally
    //   27	29	110	finally
    //   108	110	110	finally
    //   101	103	115	finally
    //   106	108	115	finally
    //   29	90	124	finally
    //   96	101	124	finally
  }
  
  public void put(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
      EncodedImage.closeSafely((EncodedImage)this.mMap.put(paramCacheKey, EncodedImage.cloneOrNull(paramEncodedImage)));
      logStats();
      return;
    }
    finally
    {
      paramCacheKey = finally;
      throw paramCacheKey;
    }
  }
  
  public boolean remove(CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    try
    {
      paramCacheKey = (EncodedImage)this.mMap.remove(paramCacheKey);
      if (paramCacheKey == null) {
        return false;
      }
    }
    finally {}
    try
    {
      boolean bool = paramCacheKey.isValid();
      return bool;
    }
    finally
    {
      paramCacheKey.close();
    }
  }
  
  /* Error */
  public boolean remove(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: invokestatic 82	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_2
    //   11: invokestatic 82	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: pop
    //   15: aload_2
    //   16: invokestatic 88	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    //   19: invokestatic 119	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   22: aload_0
    //   23: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   26: aload_1
    //   27: invokeinterface 84 2 0
    //   32: checkcast 72	com/facebook/imagepipeline/image/EncodedImage
    //   35: astore_3
    //   36: aload_3
    //   37: ifnonnull +8 -> 45
    //   40: aload_0
    //   41: monitorexit
    //   42: iload 7
    //   44: ireturn
    //   45: aload_3
    //   46: invokevirtual 137	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
    //   49: astore 4
    //   51: aload_2
    //   52: invokevirtual 137	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
    //   55: astore_2
    //   56: aload 4
    //   58: ifnull +27 -> 85
    //   61: aload_2
    //   62: ifnull +23 -> 85
    //   65: aload 4
    //   67: invokevirtual 142	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   70: astore 5
    //   72: aload_2
    //   73: invokevirtual 142	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   76: astore 6
    //   78: aload 5
    //   80: aload 6
    //   82: if_acmpeq +24 -> 106
    //   85: aload_2
    //   86: invokestatic 145	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   89: aload 4
    //   91: invokestatic 145	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   94: aload_3
    //   95: invokestatic 126	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   98: goto -58 -> 40
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: aload_0
    //   107: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   110: aload_1
    //   111: invokeinterface 91 2 0
    //   116: pop
    //   117: aload_2
    //   118: invokestatic 145	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   121: aload 4
    //   123: invokestatic 145	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   126: aload_3
    //   127: invokestatic 126	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   130: aload_0
    //   131: invokespecial 128	com/facebook/imagepipeline/cache/StagingArea:logStats	()V
    //   134: iconst_1
    //   135: istore 7
    //   137: goto -97 -> 40
    //   140: astore_1
    //   141: aload_2
    //   142: invokestatic 145	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   145: aload 4
    //   147: invokestatic 145	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   150: aload_3
    //   151: invokestatic 126	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   154: aload_1
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	StagingArea
    //   0	156	1	paramCacheKey	CacheKey
    //   0	156	2	paramEncodedImage	EncodedImage
    //   35	116	3	localEncodedImage	EncodedImage
    //   49	97	4	localCloseableReference	com.facebook.common.references.CloseableReference
    //   70	9	5	localObject1	Object
    //   76	5	6	localObject2	Object
    //   1	135	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	36	101	finally
    //   45	56	101	finally
    //   85	98	101	finally
    //   117	134	101	finally
    //   141	156	101	finally
    //   65	78	140	finally
    //   106	117	140	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\StagingArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */