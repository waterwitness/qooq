package com.facebook.datasource;

import com.facebook.common.internal.Supplier;

public class DataSources
{
  public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(Throwable paramThrowable)
  {
    new Supplier()
    {
      public DataSource<T> get()
      {
        return DataSources.immediateFailedDataSource(DataSources.this);
      }
    };
  }
  
  public static <T> DataSource<T> immediateFailedDataSource(Throwable paramThrowable)
  {
    SettableDataSource localSettableDataSource = SettableDataSource.create();
    localSettableDataSource.setFailure(paramThrowable);
    return localSettableDataSource;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\datasource\DataSources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */