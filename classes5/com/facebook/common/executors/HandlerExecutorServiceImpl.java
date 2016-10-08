package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class HandlerExecutorServiceImpl
  extends AbstractExecutorService
  implements HandlerExecutorService
{
  private final Handler mHandler;
  
  public HandlerExecutorServiceImpl(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    throw new UnsupportedOperationException();
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
  
  public boolean isHandlerThread()
  {
    return Thread.currentThread() == this.mHandler.getLooper().getThread();
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  protected <T> ScheduledFutureImpl<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new ScheduledFutureImpl(this.mHandler, paramRunnable, paramT);
  }
  
  protected <T> ScheduledFutureImpl<T> newTaskFor(Callable<T> paramCallable)
  {
    return new ScheduledFutureImpl(this.mHandler, paramCallable);
  }
  
  public void quit()
  {
    this.mHandler.getLooper().quit();
  }
  
  public ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    paramRunnable = newTaskFor(paramRunnable, null);
    this.mHandler.postDelayed(paramRunnable, paramTimeUnit.toMillis(paramLong));
    return paramRunnable;
  }
  
  public <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    paramCallable = newTaskFor(paramCallable);
    this.mHandler.postDelayed(paramCallable, paramTimeUnit.toMillis(paramLong));
    return paramCallable;
  }
  
  public ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public List<Runnable> shutdownNow()
  {
    throw new UnsupportedOperationException();
  }
  
  public ScheduledFuture<?> submit(Runnable paramRunnable)
  {
    return submit(paramRunnable, null);
  }
  
  public <T> ScheduledFuture<T> submit(Runnable paramRunnable, @Nullable T paramT)
  {
    if (paramRunnable == null) {
      throw new NullPointerException();
    }
    paramRunnable = newTaskFor(paramRunnable, paramT);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> ScheduledFuture<T> submit(Callable<T> paramCallable)
  {
    if (paramCallable == null) {
      throw new NullPointerException();
    }
    paramCallable = newTaskFor(paramCallable);
    execute(paramCallable);
    return paramCallable;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\executors\HandlerExecutorServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */