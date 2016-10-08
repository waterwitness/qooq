package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
public class SharedReference<T>
{
  @GuardedBy("itself")
  private static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();
  @GuardedBy("this")
  private int mRefCount;
  private final ResourceReleaser<T> mResourceReleaser;
  @GuardedBy("this")
  private T mValue;
  
  public SharedReference(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    this.mValue = Preconditions.checkNotNull(paramT);
    this.mResourceReleaser = ((ResourceReleaser)Preconditions.checkNotNull(paramResourceReleaser));
    this.mRefCount = 1;
    addLiveReference(paramT);
  }
  
  private static void addLiveReference(Object paramObject)
  {
    synchronized (sLiveObjects)
    {
      Integer localInteger = (Integer)sLiveObjects.get(paramObject);
      if (localInteger == null)
      {
        sLiveObjects.put(paramObject, Integer.valueOf(1));
        return;
      }
      sLiveObjects.put(paramObject, Integer.valueOf(localInteger.intValue() + 1));
    }
  }
  
  /* Error */
  private int decreaseRefCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 79	com/facebook/common/references/SharedReference:ensureValid	()V
    //   6: aload_0
    //   7: getfield 50	com/facebook/common/references/SharedReference:mRefCount	I
    //   10: ifle +28 -> 38
    //   13: iconst_1
    //   14: istore_3
    //   15: iload_3
    //   16: invokestatic 83	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 50	com/facebook/common/references/SharedReference:mRefCount	I
    //   24: iconst_1
    //   25: isub
    //   26: putfield 50	com/facebook/common/references/SharedReference:mRefCount	I
    //   29: aload_0
    //   30: getfield 50	com/facebook/common/references/SharedReference:mRefCount	I
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_3
    //   40: goto -25 -> 15
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	SharedReference
    //   43	4	1	localObject	Object
    //   33	4	2	i	int
    //   14	26	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	43	finally
    //   15	34	43	finally
  }
  
  private void ensureValid()
  {
    if (!isValid(this)) {
      throw new NullReferenceException();
    }
  }
  
  public static boolean isValid(SharedReference<?> paramSharedReference)
  {
    return (paramSharedReference != null) && (paramSharedReference.isValid());
  }
  
  private static void removeLiveReference(Object paramObject)
  {
    for (;;)
    {
      Integer localInteger;
      synchronized (sLiveObjects)
      {
        localInteger = (Integer)sLiveObjects.get(paramObject);
        if (localInteger == null)
        {
          FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", new Object[] { paramObject.getClass() });
          return;
        }
        if (localInteger.intValue() == 1) {
          sLiveObjects.remove(paramObject);
        }
      }
      sLiveObjects.put(paramObject, Integer.valueOf(localInteger.intValue() - 1));
    }
  }
  
  public void addReference()
  {
    try
    {
      ensureValid();
      this.mRefCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void deleteReference()
  {
    if (decreaseRefCount() == 0) {}
    try
    {
      Object localObject1 = this.mValue;
      this.mValue = null;
      this.mResourceReleaser.release(localObject1);
      removeLiveReference(localObject1);
      return;
    }
    finally {}
  }
  
  public T get()
  {
    try
    {
      Object localObject1 = this.mValue;
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public int getRefCountTestOnly()
  {
    try
    {
      int i = this.mRefCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean isValid()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/facebook/common/references/SharedReference:mRefCount	I
    //   6: istore_2
    //   7: iload_2
    //   8: ifle +9 -> 17
    //   11: iconst_1
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_3
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	SharedReference
    //   22	4	1	localObject	Object
    //   6	2	2	i	int
    //   12	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public static class NullReferenceException
    extends RuntimeException
  {
    public NullReferenceException()
    {
      super();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\references\SharedReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */