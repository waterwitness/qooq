package com.facebook.common.executors;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

public class ScheduledFutureImpl<V>
  implements RunnableFuture<V>, ScheduledFuture<V>
{
  private final Handler mHandler;
  private final FutureTask<V> mListenableFuture;
  
  public ScheduledFutureImpl(Handler paramHandler, Runnable paramRunnable, @Nullable V paramV)
  {
    this.mHandler = paramHandler;
    this.mListenableFuture = new FutureTask(paramRunnable, paramV);
  }
  
  public ScheduledFutureImpl(Handler paramHandler, Callable<V> paramCallable)
  {
    this.mHandler = paramHandler;
    this.mListenableFuture = new FutureTask(paramCallable);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return this.mListenableFuture.cancel(paramBoolean);
  }
  
  public int compareTo(Delayed paramDelayed)
  {
    throw new UnsupportedOperationException();
  }
  
  public V get()
    throws InterruptedException, ExecutionException
  {
    return (V)this.mListenableFuture.get();
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (V)this.mListenableFuture.get(paramLong, paramTimeUnit);
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isCancelled()
  {
    return this.mListenableFuture.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.mListenableFuture.isDone();
  }
  
  public void run()
  {
    this.mListenableFuture.run();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\executors\ScheduledFutureImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */