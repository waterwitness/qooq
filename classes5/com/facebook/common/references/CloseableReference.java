package com.facebook.common.references;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class CloseableReference<T>
  implements Cloneable, Closeable
{
  private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser()
  {
    public void release(Closeable paramAnonymousCloseable)
    {
      try
      {
        Closeables.close(paramAnonymousCloseable, true);
        return;
      }
      catch (IOException paramAnonymousCloseable) {}
    }
  };
  private static Class<CloseableReference> TAG = CloseableReference.class;
  @GuardedBy("this")
  private boolean mIsClosed = false;
  private final SharedReference<T> mSharedReference;
  
  private CloseableReference(SharedReference<T> paramSharedReference)
  {
    this.mSharedReference = ((SharedReference)Preconditions.checkNotNull(paramSharedReference));
    paramSharedReference.addReference();
  }
  
  private CloseableReference(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    this.mSharedReference = new SharedReference(paramT, paramResourceReleaser);
  }
  
  @Nullable
  public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      return paramCloseableReference.cloneOrNull();
    }
    return null;
  }
  
  public static <T> List<CloseableReference<T>> cloneOrNull(Collection<CloseableReference<T>> paramCollection)
  {
    if (paramCollection == null)
    {
      paramCollection = null;
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    for (;;)
    {
      paramCollection = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(cloneOrNull((CloseableReference)localIterator.next()));
    }
  }
  
  public static void closeSafely(@Nullable CloseableReference<?> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      paramCloseableReference.close();
    }
  }
  
  public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> paramIterable)
  {
    if (paramIterable != null) {
      paramIterable = paramIterable.iterator();
    }
    for (;;)
    {
      if (!paramIterable.hasNext()) {
        return;
      }
      closeSafely((CloseableReference)paramIterable.next());
    }
  }
  
  public static boolean isValid(@Nullable CloseableReference<?> paramCloseableReference)
  {
    return (paramCloseableReference != null) && (paramCloseableReference.isValid());
  }
  
  @Nullable
  public static <T extends Closeable> CloseableReference<T> of(@Nullable T paramT)
  {
    if (paramT == null) {
      return null;
    }
    return new CloseableReference(paramT, DEFAULT_CLOSEABLE_RELEASER);
  }
  
  @Nullable
  public static <T> CloseableReference<T> of(@Nullable T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    if (paramT == null) {
      return null;
    }
    return new CloseableReference(paramT, paramResourceReleaser);
  }
  
  public CloseableReference<T> clone()
  {
    try
    {
      Preconditions.checkState(isValid());
      CloseableReference localCloseableReference = new CloseableReference(this.mSharedReference);
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public CloseableReference<T> cloneOrNull()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 119	com/facebook/common/references/CloseableReference:isValid	()Z
    //   6: ifeq +19 -> 25
    //   9: new 2	com/facebook/common/references/CloseableReference
    //   12: dup
    //   13: aload_0
    //   14: getfield 49	com/facebook/common/references/CloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   17: invokespecial 133	com/facebook/common/references/CloseableReference:<init>	(Lcom/facebook/common/references/SharedReference;)V
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aconst_null
    //   26: astore_1
    //   27: goto -6 -> 21
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	CloseableReference
    //   20	7	1	localCloseableReference	CloseableReference
    //   30	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public void close()
  {
    try
    {
      if (this.mIsClosed) {
        return;
      }
      this.mIsClosed = true;
      this.mSharedReference.deleteReference();
      return;
    }
    finally {}
  }
  
  /* Error */
  protected void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/facebook/common/references/CloseableReference:mIsClosed	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_0
    //   12: invokespecial 147	java/lang/Object:finalize	()V
    //   15: return
    //   16: aload_0
    //   17: monitorexit
    //   18: getstatic 29	com/facebook/common/references/CloseableReference:TAG	Ljava/lang/Class;
    //   21: ldc -107
    //   23: iconst_3
    //   24: anewarray 5	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: invokestatic 155	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   33: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload_0
    //   40: getfield 49	com/facebook/common/references/CloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   43: invokestatic 155	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   46: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: aload_0
    //   53: getfield 49	com/facebook/common/references/CloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   56: invokevirtual 164	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
    //   59: invokevirtual 168	java/lang/Object:getClass	()Ljava/lang/Class;
    //   62: invokevirtual 174	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 180	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: invokevirtual 107	com/facebook/common/references/CloseableReference:close	()V
    //   73: aload_0
    //   74: invokespecial 147	java/lang/Object:finalize	()V
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: invokespecial 147	java/lang/Object:finalize	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	CloseableReference
    //   78	4	1	localObject1	Object
    //   83	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	78	finally
    //   16	18	78	finally
    //   79	81	78	finally
    //   0	2	83	finally
    //   18	73	83	finally
    //   81	83	83	finally
  }
  
  /* Error */
  public T get()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/facebook/common/references/CloseableReference:mIsClosed	Z
    //   6: ifeq +21 -> 27
    //   9: iconst_0
    //   10: istore_2
    //   11: iload_2
    //   12: invokestatic 131	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   15: aload_0
    //   16: getfield 49	com/facebook/common/references/CloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   19: invokevirtual 164	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: iconst_1
    //   28: istore_2
    //   29: goto -18 -> 11
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	CloseableReference
    //   22	4	1	localObject1	Object
    //   32	4	1	localObject2	Object
    //   10	19	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	32	finally
    //   11	23	32	finally
  }
  
  @VisibleForTesting
  public SharedReference<T> getUnderlyingReferenceTestOnly()
  {
    try
    {
      SharedReference localSharedReference = this.mSharedReference;
      return localSharedReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int getValueHash()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 119	com/facebook/common/references/CloseableReference:isValid	()Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 49	com/facebook/common/references/CloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   13: invokevirtual 164	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
    //   16: invokestatic 155	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_2
    //   26: goto -6 -> 20
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	CloseableReference
    //   29	4	1	localObject	Object
    //   19	7	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	20	29	finally
  }
  
  /* Error */
  public boolean isValid()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/facebook/common/references/CloseableReference:mIsClosed	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_1
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	CloseableReference
    //   22	4	1	localObject	Object
    //   6	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\references\CloseableReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */