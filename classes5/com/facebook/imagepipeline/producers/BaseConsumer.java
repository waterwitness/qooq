package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class BaseConsumer<T>
  implements Consumer<T>
{
  private boolean mIsFinished = false;
  
  /* Error */
  public void onCancellation()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/facebook/imagepipeline/producers/BaseConsumer:mIsFinished	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 16	com/facebook/imagepipeline/producers/BaseConsumer:mIsFinished	Z
    //   19: aload_0
    //   20: invokevirtual 23	com/facebook/imagepipeline/producers/BaseConsumer:onCancellationImpl	()V
    //   23: goto -12 -> 11
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 27	com/facebook/imagepipeline/producers/BaseConsumer:onUnhandledException	(Ljava/lang/Exception;)V
    //   32: goto -21 -> 11
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	BaseConsumer
    //   26	3	1	localException	Exception
    //   35	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	23	26	java/lang/Exception
    //   2	7	35	finally
    //   14	19	35	finally
    //   19	23	35	finally
    //   27	32	35	finally
  }
  
  protected abstract void onCancellationImpl();
  
  /* Error */
  public void onFailure(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/facebook/imagepipeline/producers/BaseConsumer:mIsFinished	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 16	com/facebook/imagepipeline/producers/BaseConsumer:mIsFinished	Z
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 32	com/facebook/imagepipeline/producers/BaseConsumer:onFailureImpl	(Ljava/lang/Throwable;)V
    //   24: goto -13 -> 11
    //   27: astore_1
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 27	com/facebook/imagepipeline/producers/BaseConsumer:onUnhandledException	(Ljava/lang/Exception;)V
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	BaseConsumer
    //   0	41	1	paramThrowable	Throwable
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	24	27	java/lang/Exception
    //   2	7	36	finally
    //   14	19	36	finally
    //   19	24	36	finally
    //   28	33	36	finally
  }
  
  protected abstract void onFailureImpl(Throwable paramThrowable);
  
  /* Error */
  public void onNewResult(@javax.annotation.Nullable T paramT, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/facebook/imagepipeline/producers/BaseConsumer:mIsFinished	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iload_2
    //   16: putfield 16	com/facebook/imagepipeline/producers/BaseConsumer:mIsFinished	Z
    //   19: aload_0
    //   20: aload_1
    //   21: iload_2
    //   22: invokevirtual 38	com/facebook/imagepipeline/producers/BaseConsumer:onNewResultImpl	(Ljava/lang/Object;Z)V
    //   25: goto -14 -> 11
    //   28: astore_1
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 27	com/facebook/imagepipeline/producers/BaseConsumer:onUnhandledException	(Ljava/lang/Exception;)V
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	BaseConsumer
    //   0	42	1	paramT	T
    //   0	42	2	paramBoolean	boolean
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	25	28	java/lang/Exception
    //   2	7	37	finally
    //   14	19	37	finally
    //   19	25	37	finally
    //   29	34	37	finally
  }
  
  protected abstract void onNewResultImpl(T paramT, boolean paramBoolean);
  
  /* Error */
  public void onProgressUpdate(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/facebook/imagepipeline/producers/BaseConsumer:mIsFinished	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: fload_1
    //   16: invokevirtual 46	com/facebook/imagepipeline/producers/BaseConsumer:onProgressUpdateImpl	(F)V
    //   19: goto -8 -> 11
    //   22: astore_2
    //   23: aload_0
    //   24: aload_2
    //   25: invokevirtual 27	com/facebook/imagepipeline/producers/BaseConsumer:onUnhandledException	(Ljava/lang/Exception;)V
    //   28: goto -17 -> 11
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	BaseConsumer
    //   0	36	1	paramFloat	float
    //   22	3	2	localException	Exception
    //   31	4	2	localObject	Object
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   14	19	22	java/lang/Exception
    //   2	7	31	finally
    //   14	19	31	finally
    //   23	28	31	finally
  }
  
  protected void onProgressUpdateImpl(float paramFloat) {}
  
  protected void onUnhandledException(Exception paramException)
  {
    FLog.wtf(getClass(), "unhandled exception", paramException);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\BaseConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */