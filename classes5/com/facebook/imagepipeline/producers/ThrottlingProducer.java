package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public class ThrottlingProducer<T>
  implements Producer<T>
{
  @VisibleForTesting
  static final String PRODUCER_NAME = "ThrottlingProducer";
  private final Executor mExecutor;
  private final Producer<T> mInputProducer;
  private final int mMaxSimultaneousRequests;
  @GuardedBy("this")
  private int mNumCurrentRequests;
  @GuardedBy("this")
  private final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> mPendingRequests;
  
  public ThrottlingProducer(int paramInt, Executor paramExecutor, Producer<T> paramProducer)
  {
    this.mMaxSimultaneousRequests = paramInt;
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mPendingRequests = new ConcurrentLinkedQueue();
    this.mNumCurrentRequests = 0;
  }
  
  /* Error */
  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 76 1 0
    //   6: aload_2
    //   7: invokeinterface 80 1 0
    //   12: ldc 16
    //   14: invokeinterface 86 3 0
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 57	com/facebook/imagepipeline/producers/ThrottlingProducer:mNumCurrentRequests	I
    //   25: aload_0
    //   26: getfield 38	com/facebook/imagepipeline/producers/ThrottlingProducer:mMaxSimultaneousRequests	I
    //   29: if_icmplt +31 -> 60
    //   32: aload_0
    //   33: getfield 55	com/facebook/imagepipeline/producers/ThrottlingProducer:mPendingRequests	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 92	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   41: invokevirtual 96	java/util/concurrent/ConcurrentLinkedQueue:add	(Ljava/lang/Object;)Z
    //   44: pop
    //   45: iconst_1
    //   46: istore_3
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_3
    //   50: ifne +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: aload_2
    //   56: invokevirtual 99	com/facebook/imagepipeline/producers/ThrottlingProducer:produceResultsInternal	(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
    //   59: return
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 57	com/facebook/imagepipeline/producers/ThrottlingProducer:mNumCurrentRequests	I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield 57	com/facebook/imagepipeline/producers/ThrottlingProducer:mNumCurrentRequests	I
    //   70: iconst_0
    //   71: istore_3
    //   72: goto -25 -> 47
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ThrottlingProducer
    //   0	80	1	paramConsumer	Consumer<T>
    //   0	80	2	paramProducerContext	ProducerContext
    //   46	26	3	i	int
    // Exception table:
    //   from	to	target	type
    //   21	45	75	finally
    //   47	49	75	finally
    //   60	70	75	finally
    //   76	78	75	finally
  }
  
  void produceResultsInternal(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getListener().onProducerFinishWithSuccess(paramProducerContext.getId(), "ThrottlingProducer", null);
    this.mInputProducer.produceResults(new ThrottlerConsumer(paramConsumer, null), paramProducerContext);
  }
  
  private class ThrottlerConsumer
    extends DelegatingConsumer<T, T>
  {
    private ThrottlerConsumer()
    {
      super();
    }
    
    private void onRequestFinished()
    {
      synchronized (ThrottlingProducer.this)
      {
        final Pair localPair = (Pair)ThrottlingProducer.this.mPendingRequests.poll();
        if (localPair == null)
        {
          ThrottlingProducer localThrottlingProducer2 = ThrottlingProducer.this;
          localThrottlingProducer2.mNumCurrentRequests -= 1;
        }
        if (localPair != null) {
          ThrottlingProducer.this.mExecutor.execute(new Runnable()
          {
            public void run()
            {
              ThrottlingProducer.this.produceResultsInternal((Consumer)localPair.first, (ProducerContext)localPair.second);
            }
          });
        }
        return;
      }
    }
    
    protected void onCancellationImpl()
    {
      getConsumer().onCancellation();
      onRequestFinished();
    }
    
    protected void onFailureImpl(Throwable paramThrowable)
    {
      getConsumer().onFailure(paramThrowable);
      onRequestFinished();
    }
    
    protected void onNewResultImpl(T paramT, boolean paramBoolean)
    {
      getConsumer().onNewResult(paramT, paramBoolean);
      if (paramBoolean) {
        onRequestFinished();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\ThrottlingProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */