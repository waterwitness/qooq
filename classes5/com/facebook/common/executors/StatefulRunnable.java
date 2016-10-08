package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class StatefulRunnable<T>
  implements Runnable
{
  protected static final int STATE_CANCELLED = 2;
  protected static final int STATE_CREATED = 0;
  protected static final int STATE_FAILED = 4;
  protected static final int STATE_FINISHED = 3;
  protected static final int STATE_STARTED = 1;
  protected final AtomicInteger mState = new AtomicInteger(0);
  
  public void cancel()
  {
    if (this.mState.compareAndSet(0, 2)) {
      onCancellation();
    }
  }
  
  protected void disposeResult(T paramT) {}
  
  protected abstract T getResult()
    throws Exception;
  
  protected void onCancellation() {}
  
  protected void onFailure(Exception paramException) {}
  
  protected void onSuccess(T paramT) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/facebook/common/executors/StatefulRunnable:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: iconst_0
    //   5: iconst_1
    //   6: invokevirtual 37	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 54	com/facebook/common/executors/StatefulRunnable:getResult	()Ljava/lang/Object;
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 31	com/facebook/common/executors/StatefulRunnable:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   22: iconst_3
    //   23: invokevirtual 57	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 59	com/facebook/common/executors/StatefulRunnable:onSuccess	(Ljava/lang/Object;)V
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 61	com/facebook/common/executors/StatefulRunnable:disposeResult	(Ljava/lang/Object;)V
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 31	com/facebook/common/executors/StatefulRunnable:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   42: iconst_4
    //   43: invokevirtual 57	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 63	com/facebook/common/executors/StatefulRunnable:onFailure	(Ljava/lang/Exception;)V
    //   51: return
    //   52: astore_2
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 61	com/facebook/common/executors/StatefulRunnable:disposeResult	(Ljava/lang/Object;)V
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	StatefulRunnable
    //   17	16	1	localObject1	Object
    //   37	18	1	localException	Exception
    //   52	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	18	37	java/lang/Exception
    //   26	31	52	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\executors\StatefulRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */