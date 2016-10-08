package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract interface DataSource<T>
{
  public abstract boolean close();
  
  @Nullable
  public abstract Throwable getFailureCause();
  
  public abstract float getProgress();
  
  @Nullable
  public abstract T getResult();
  
  public abstract boolean hasFailed();
  
  public abstract boolean hasResult();
  
  public abstract boolean isClosed();
  
  public abstract boolean isFinished();
  
  public abstract void subscribe(DataSubscriber<T> paramDataSubscriber, Executor paramExecutor);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\datasource\DataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */