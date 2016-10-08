package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class FirstAvailableDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;
  
  private FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> paramList)
  {
    if (paramList.isEmpty()) {}
    for (boolean bool = false;; bool = true)
    {
      Preconditions.checkArgument(bool, "List of suppliers is empty!");
      this.mDataSourceSuppliers = paramList;
      return;
    }
  }
  
  public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList)
  {
    return new FirstAvailableDataSourceSupplier(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FirstAvailableDataSourceSupplier)) {
      return false;
    }
    paramObject = (FirstAvailableDataSourceSupplier)paramObject;
    return Objects.equal(this.mDataSourceSuppliers, ((FirstAvailableDataSourceSupplier)paramObject).mDataSourceSuppliers);
  }
  
  public DataSource<T> get()
  {
    return new FirstAvailableDataSource();
  }
  
  public int hashCode()
  {
    return this.mDataSourceSuppliers.hashCode();
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString();
  }
  
  @ThreadSafe
  private class FirstAvailableDataSource
    extends AbstractDataSource<T>
  {
    private DataSource<T> mCurrentDataSource = null;
    private DataSource<T> mDataSourceWithResult = null;
    private int mIndex = 0;
    
    public FirstAvailableDataSource()
    {
      if (!startNextDataSource()) {
        setFailure(new RuntimeException("No data source supplier or supplier returned null."));
      }
    }
    
    /* Error */
    private boolean clearCurrentDataSource(DataSource<T> paramDataSource)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokevirtual 64	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:isClosed	()Z
      //   6: ifne +13 -> 19
      //   9: aload_0
      //   10: getfield 31	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:mCurrentDataSource	Lcom/facebook/datasource/DataSource;
      //   13: astore_2
      //   14: aload_1
      //   15: aload_2
      //   16: if_acmpeq +9 -> 25
      //   19: iconst_0
      //   20: istore_3
      //   21: aload_0
      //   22: monitorexit
      //   23: iload_3
      //   24: ireturn
      //   25: aload_0
      //   26: aconst_null
      //   27: putfield 31	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:mCurrentDataSource	Lcom/facebook/datasource/DataSource;
      //   30: iconst_1
      //   31: istore_3
      //   32: goto -11 -> 21
      //   35: astore_1
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_1
      //   39: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	40	0	this	FirstAvailableDataSource
      //   0	40	1	paramDataSource	DataSource<T>
      //   13	3	2	localDataSource	DataSource
      //   20	12	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	14	35	finally
      //   25	30	35	finally
    }
    
    private void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null) {
        paramDataSource.close();
      }
    }
    
    @Nullable
    private DataSource<T> getDataSourceWithResult()
    {
      try
      {
        DataSource localDataSource = this.mDataSourceWithResult;
        return localDataSource;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    @Nullable
    private Supplier<DataSource<T>> getNextSupplier()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokevirtual 64	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:isClosed	()Z
      //   6: ifne +57 -> 63
      //   9: aload_0
      //   10: getfield 29	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:mIndex	I
      //   13: aload_0
      //   14: getfield 24	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:this$0	Lcom/facebook/datasource/FirstAvailableDataSourceSupplier;
      //   17: invokestatic 83	com/facebook/datasource/FirstAvailableDataSourceSupplier:access$1	(Lcom/facebook/datasource/FirstAvailableDataSourceSupplier;)Ljava/util/List;
      //   20: invokeinterface 89 1 0
      //   25: if_icmpge +38 -> 63
      //   28: aload_0
      //   29: getfield 24	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:this$0	Lcom/facebook/datasource/FirstAvailableDataSourceSupplier;
      //   32: invokestatic 83	com/facebook/datasource/FirstAvailableDataSourceSupplier:access$1	(Lcom/facebook/datasource/FirstAvailableDataSourceSupplier;)Ljava/util/List;
      //   35: astore_1
      //   36: aload_0
      //   37: getfield 29	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:mIndex	I
      //   40: istore_2
      //   41: aload_0
      //   42: iload_2
      //   43: iconst_1
      //   44: iadd
      //   45: putfield 29	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:mIndex	I
      //   48: aload_1
      //   49: iload_2
      //   50: invokeinterface 93 2 0
      //   55: checkcast 95	com/facebook/common/internal/Supplier
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: areturn
      //   63: aconst_null
      //   64: astore_1
      //   65: goto -6 -> 59
      //   68: astore_1
      //   69: aload_0
      //   70: monitorexit
      //   71: aload_1
      //   72: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	73	0	this	FirstAvailableDataSource
      //   35	30	1	localObject1	Object
      //   68	4	1	localObject2	Object
      //   40	10	2	i	int
      // Exception table:
      //   from	to	target	type
      //   2	59	68	finally
    }
    
    private void maybeSetDataSourceWithResult(DataSource<T> paramDataSource, boolean paramBoolean)
    {
      DataSource localDataSource = null;
      try
      {
        if ((paramDataSource != this.mCurrentDataSource) || (paramDataSource == this.mDataSourceWithResult)) {
          return;
        }
        if ((this.mDataSourceWithResult == null) || (paramBoolean))
        {
          localDataSource = this.mDataSourceWithResult;
          this.mDataSourceWithResult = paramDataSource;
        }
        closeSafely(localDataSource);
        return;
      }
      finally {}
    }
    
    private void onDataSourceFailed(DataSource<T> paramDataSource)
    {
      if (!clearCurrentDataSource(paramDataSource)) {}
      do
      {
        return;
        if (paramDataSource != getDataSourceWithResult()) {
          closeSafely(paramDataSource);
        }
      } while (startNextDataSource());
      setFailure(paramDataSource.getFailureCause());
    }
    
    private void onDataSourceNewResult(DataSource<T> paramDataSource)
    {
      maybeSetDataSourceWithResult(paramDataSource, paramDataSource.isFinished());
      if (paramDataSource == getDataSourceWithResult()) {
        setResult(null, paramDataSource.isFinished());
      }
    }
    
    /* Error */
    private boolean setCurrentDataSource(DataSource<T> paramDataSource)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokevirtual 64	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:isClosed	()Z
      //   6: istore_2
      //   7: iload_2
      //   8: ifeq +9 -> 17
      //   11: iconst_0
      //   12: istore_2
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_2
      //   16: ireturn
      //   17: aload_0
      //   18: aload_1
      //   19: putfield 31	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:mCurrentDataSource	Lcom/facebook/datasource/DataSource;
      //   22: iconst_1
      //   23: istore_2
      //   24: goto -11 -> 13
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	FirstAvailableDataSource
      //   0	32	1	paramDataSource	DataSource<T>
      //   6	18	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	7	27	finally
      //   17	22	27	finally
    }
    
    private boolean startNextDataSource()
    {
      Object localObject = getNextSupplier();
      if (localObject != null) {}
      for (localObject = (DataSource)((Supplier)localObject).get(); (setCurrentDataSource((DataSource)localObject)) && (localObject != null); localObject = null)
      {
        ((DataSource)localObject).subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
        return true;
      }
      closeSafely((DataSource)localObject);
      return false;
    }
    
    public boolean close()
    {
      try
      {
        if (!super.close()) {
          return false;
        }
        DataSource localDataSource1 = this.mCurrentDataSource;
        this.mCurrentDataSource = null;
        DataSource localDataSource2 = this.mDataSourceWithResult;
        this.mDataSourceWithResult = null;
        closeSafely(localDataSource2);
        closeSafely(localDataSource1);
        return true;
      }
      finally {}
    }
    
    /* Error */
    @Nullable
    public T getResult()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 105	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:getDataSourceWithResult	()Lcom/facebook/datasource/DataSource;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnull +14 -> 22
      //   11: aload_1
      //   12: invokeinterface 143 1 0
      //   17: astore_1
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_1
      //   21: areturn
      //   22: aconst_null
      //   23: astore_1
      //   24: goto -6 -> 18
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	FirstAvailableDataSource
      //   6	18	1	localObject1	Object
      //   27	4	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	27	finally
      //   11	18	27	finally
    }
    
    /* Error */
    public boolean hasResult()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 105	com/facebook/datasource/FirstAvailableDataSourceSupplier$FirstAvailableDataSource:getDataSourceWithResult	()Lcom/facebook/datasource/DataSource;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnull +20 -> 28
      //   11: aload_1
      //   12: invokeinterface 147 1 0
      //   17: istore_2
      //   18: iload_2
      //   19: ifeq +9 -> 28
      //   22: iconst_1
      //   23: istore_2
      //   24: aload_0
      //   25: monitorexit
      //   26: iload_2
      //   27: ireturn
      //   28: iconst_0
      //   29: istore_2
      //   30: goto -6 -> 24
      //   33: astore_1
      //   34: aload_0
      //   35: monitorexit
      //   36: aload_1
      //   37: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	38	0	this	FirstAvailableDataSource
      //   6	6	1	localDataSource	DataSource
      //   33	4	1	localObject	Object
      //   17	13	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	7	33	finally
      //   11	18	33	finally
    }
    
    private class InternalDataSubscriber
      implements DataSubscriber<T>
    {
      private InternalDataSubscriber() {}
      
      public void onCancellation(DataSource<T> paramDataSource) {}
      
      public void onFailure(DataSource<T> paramDataSource)
      {
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(paramDataSource);
      }
      
      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult()) {
          FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceNewResult(paramDataSource);
        }
        while (!paramDataSource.isFinished()) {
          return;
        }
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(paramDataSource);
      }
      
      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        float f = FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.getProgress();
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.setProgress(Math.max(f, paramDataSource.getProgress()));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\datasource\FirstAvailableDataSourceSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */