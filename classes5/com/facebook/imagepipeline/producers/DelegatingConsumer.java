package com.facebook.imagepipeline.producers;

public abstract class DelegatingConsumer<I, O>
  extends BaseConsumer<I>
{
  private final Consumer<O> mConsumer;
  
  public DelegatingConsumer(Consumer<O> paramConsumer)
  {
    this.mConsumer = paramConsumer;
  }
  
  public Consumer<O> getConsumer()
  {
    return this.mConsumer;
  }
  
  protected void onCancellationImpl()
  {
    this.mConsumer.onCancellation();
  }
  
  protected void onFailureImpl(Throwable paramThrowable)
  {
    this.mConsumer.onFailure(paramThrowable);
  }
  
  protected void onProgressUpdateImpl(float paramFloat)
  {
    this.mConsumer.onProgressUpdate(paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\DelegatingConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */