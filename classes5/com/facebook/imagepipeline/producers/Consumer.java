package com.facebook.imagepipeline.producers;

public abstract interface Consumer<T>
{
  public abstract void onCancellation();
  
  public abstract void onFailure(Throwable paramThrowable);
  
  public abstract void onNewResult(T paramT, boolean paramBoolean);
  
  public abstract void onProgressUpdate(float paramFloat);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\Consumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */