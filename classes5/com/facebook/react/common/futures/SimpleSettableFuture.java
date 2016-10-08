package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class SimpleSettableFuture<T>
{
  private final CountDownLatch mReadyLatch = new CountDownLatch(1);
  @Nullable
  private volatile T mResult;
  
  @Nullable
  public T get(long paramLong)
  {
    try
    {
      if (!this.mReadyLatch.await(paramLong, TimeUnit.MILLISECONDS)) {
        throw new TimeoutException();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException(localInterruptedException);
    }
    return (T)this.mResult;
  }
  
  public void set(T paramT)
  {
    if (this.mReadyLatch.getCount() == 0L) {
      throw new RuntimeException("Result has already been set!");
    }
    this.mResult = paramT;
    this.mReadyLatch.countDown();
  }
  
  public static class TimeoutException
    extends RuntimeException
  {
    public TimeoutException()
    {
      super();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\common\futures\SimpleSettableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */