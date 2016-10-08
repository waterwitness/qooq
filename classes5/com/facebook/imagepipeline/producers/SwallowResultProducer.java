package com.facebook.imagepipeline.producers;

public class SwallowResultProducer<T>
  implements Producer<Void>
{
  private final Producer<T> mInputProducer;
  
  public SwallowResultProducer(Producer<T> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer<Void> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer = new DelegatingConsumer(paramConsumer)
    {
      protected void onNewResultImpl(T paramAnonymousT, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          getConsumer().onNewResult(null, paramAnonymousBoolean);
        }
      }
    };
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\SwallowResultProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */