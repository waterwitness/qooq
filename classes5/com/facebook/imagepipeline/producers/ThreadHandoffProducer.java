package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.concurrent.Executor;

public class ThreadHandoffProducer<T>
  implements Producer<T>
{
  @VisibleForTesting
  protected static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
  private final Executor mExecutor;
  private final Producer<T> mInputProducer;
  
  public ThreadHandoffProducer(Executor paramExecutor, Producer<T> paramProducer)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
  }
  
  public void produceResults(final Consumer<T> paramConsumer, final ProducerContext paramProducerContext)
  {
    final ProducerListener localProducerListener = paramProducerContext.getListener();
    final String str = paramProducerContext.getId();
    paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener, "BackgroundThreadHandoffProducer", str)
    {
      protected void disposeResult(T paramAnonymousT) {}
      
      protected T getResult()
        throws Exception
      {
        return null;
      }
      
      protected void onSuccess(T paramAnonymousT)
      {
        localProducerListener.onProducerFinishWithSuccess(str, "BackgroundThreadHandoffProducer", null);
        ThreadHandoffProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramConsumer.cancel();
      }
    });
    this.mExecutor.execute(paramConsumer);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\ThreadHandoffProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */