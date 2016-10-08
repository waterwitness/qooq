package com.tencent.component.network.utils.thread;

public abstract interface FutureListener<T>
{
  public abstract void onFutureBegin(Future<T> paramFuture);
  
  public abstract void onFutureDone(Future<T> paramFuture);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\thread\FutureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */