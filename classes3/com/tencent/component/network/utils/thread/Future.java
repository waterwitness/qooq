package com.tencent.component.network.utils.thread;

public abstract interface Future<T>
{
  public abstract void cancel();
  
  public abstract T get();
  
  public abstract boolean isCancelled();
  
  public abstract boolean isDone();
  
  public abstract void waitDone();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\thread\Future.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */