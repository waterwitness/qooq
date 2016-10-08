package com.facebook.datasource;

public abstract class BaseDataSubscriber<T>
  implements DataSubscriber<T>
{
  public void onCancellation(DataSource<T> paramDataSource) {}
  
  public void onFailure(DataSource<T> paramDataSource)
  {
    try
    {
      onFailureImpl(paramDataSource);
      return;
    }
    finally
    {
      paramDataSource.close();
    }
  }
  
  protected abstract void onFailureImpl(DataSource<T> paramDataSource);
  
  public void onNewResult(DataSource<T> paramDataSource)
  {
    try
    {
      onNewResultImpl(paramDataSource);
      return;
    }
    finally
    {
      if (paramDataSource.isFinished()) {
        paramDataSource.close();
      }
    }
  }
  
  protected abstract void onNewResultImpl(DataSource<T> paramDataSource);
  
  public void onProgressUpdate(DataSource<T> paramDataSource) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\datasource\BaseDataSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */