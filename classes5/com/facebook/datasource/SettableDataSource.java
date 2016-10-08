package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;

public class SettableDataSource<T>
  extends AbstractDataSource<T>
{
  public static <T> SettableDataSource<T> create()
  {
    return new SettableDataSource();
  }
  
  public boolean setFailure(Throwable paramThrowable)
  {
    return super.setFailure((Throwable)Preconditions.checkNotNull(paramThrowable));
  }
  
  public boolean setProgress(float paramFloat)
  {
    return super.setProgress(paramFloat);
  }
  
  public boolean setResult(T paramT)
  {
    return super.setResult(Preconditions.checkNotNull(paramT), true);
  }
  
  public boolean setResult(T paramT, boolean paramBoolean)
  {
    return super.setResult(Preconditions.checkNotNull(paramT), paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\datasource\SettableDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */