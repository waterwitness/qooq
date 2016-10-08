package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class IncreasingQualityDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;
  
  private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> paramList)
  {
    if (paramList.isEmpty()) {}
    for (boolean bool = false;; bool = true)
    {
      Preconditions.checkArgument(bool, "List of suppliers is empty!");
      this.mDataSourceSuppliers = paramList;
      return;
    }
  }
  
  public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList)
  {
    return new IncreasingQualityDataSourceSupplier(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof IncreasingQualityDataSourceSupplier)) {
      return false;
    }
    paramObject = (IncreasingQualityDataSourceSupplier)paramObject;
    return Objects.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier)paramObject).mDataSourceSuppliers);
  }
  
  public DataSource<T> get()
  {
    return new IncreasingQualityDataSource();
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
  private class IncreasingQualityDataSource
    extends AbstractDataSource<T>
  {
    @Nullable
    @GuardedBy("IncreasingQualityDataSource.this")
    private ArrayList<DataSource<T>> mDataSources;
    @GuardedBy("IncreasingQualityDataSource.this")
    private int mIndexOfDataSourceWithResult;
    
    public IncreasingQualityDataSource()
    {
      int j = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
      this.mIndexOfDataSourceWithResult = j;
      this.mDataSources = new ArrayList(j);
      int i = 0;
      for (;;)
      {
        if (i >= j) {}
        DataSource localDataSource;
        do
        {
          return;
          localDataSource = (DataSource)((Supplier)IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i)).get();
          this.mDataSources.add(localDataSource);
          localDataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.getInstance());
        } while (localDataSource.hasResult());
        i += 1;
      }
    }
    
    private void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null) {
        paramDataSource.close();
      }
    }
    
    @Nullable
    private DataSource<T> getAndClearDataSource(int paramInt)
    {
      Object localObject3 = null;
      Object localObject1 = localObject3;
      try
      {
        if (this.mDataSources != null)
        {
          localObject1 = localObject3;
          if (paramInt < this.mDataSources.size()) {
            localObject1 = (DataSource)this.mDataSources.set(paramInt, null);
          }
        }
        return (DataSource<T>)localObject1;
      }
      finally {}
    }
    
    /* Error */
    @Nullable
    private DataSource<T> getDataSource(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 49	com/facebook/datasource/IncreasingQualityDataSourceSupplier$IncreasingQualityDataSource:mDataSources	Ljava/util/ArrayList;
      //   6: ifnull +30 -> 36
      //   9: iload_1
      //   10: aload_0
      //   11: getfield 49	com/facebook/datasource/IncreasingQualityDataSourceSupplier$IncreasingQualityDataSource:mDataSources	Ljava/util/ArrayList;
      //   14: invokevirtual 101	java/util/ArrayList:size	()I
      //   17: if_icmpge +19 -> 36
      //   20: aload_0
      //   21: getfield 49	com/facebook/datasource/IncreasingQualityDataSourceSupplier$IncreasingQualityDataSource:mDataSources	Ljava/util/ArrayList;
      //   24: iload_1
      //   25: invokevirtual 109	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   28: checkcast 60	com/facebook/datasource/DataSource
      //   31: astore_2
      //   32: aload_0
      //   33: monitorexit
      //   34: aload_2
      //   35: areturn
      //   36: aconst_null
      //   37: astore_2
      //   38: goto -6 -> 32
      //   41: astore_2
      //   42: aload_0
      //   43: monitorexit
      //   44: aload_2
      //   45: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	46	0	this	IncreasingQualityDataSource
      //   0	46	1	paramInt	int
      //   31	7	2	localDataSource	DataSource
      //   41	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	32	41	finally
    }
    
    @Nullable
    private DataSource<T> getDataSourceWithResult()
    {
      try
      {
        DataSource localDataSource = getDataSource(this.mIndexOfDataSourceWithResult);
        return localDataSource;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private void maybeSetIndexOfDataSourceWithResult(int paramInt, DataSource<T> paramDataSource, boolean paramBoolean)
    {
      try
      {
        int j = this.mIndexOfDataSourceWithResult;
        int k = this.mIndexOfDataSourceWithResult;
        if ((paramDataSource != getDataSource(paramInt)) || (paramInt == this.mIndexOfDataSourceWithResult)) {
          return;
        }
        int i;
        if (getDataSourceWithResult() != null)
        {
          i = k;
          if (paramBoolean)
          {
            i = k;
            if (paramInt >= this.mIndexOfDataSourceWithResult) {}
          }
        }
        else
        {
          i = paramInt;
          this.mIndexOfDataSourceWithResult = paramInt;
        }
        paramInt = j;
        while (paramInt > i)
        {
          closeSafely(getAndClearDataSource(paramInt));
          paramInt -= 1;
        }
        return;
      }
      finally {}
    }
    
    private void onDataSourceFailed(int paramInt, DataSource<T> paramDataSource)
    {
      closeSafely(tryGetAndClearDataSource(paramInt, paramDataSource));
      if (paramInt == 0) {
        setFailure(paramDataSource.getFailureCause());
      }
    }
    
    private void onDataSourceNewResult(int paramInt, DataSource<T> paramDataSource)
    {
      maybeSetIndexOfDataSourceWithResult(paramInt, paramDataSource, paramDataSource.isFinished());
      if (paramDataSource == getDataSourceWithResult()) {
        if ((paramInt != 0) || (!paramDataSource.isFinished())) {
          break label43;
        }
      }
      label43:
      for (boolean bool = true;; bool = false)
      {
        setResult(null, bool);
        return;
      }
    }
    
    /* Error */
    @Nullable
    private DataSource<T> tryGetAndClearDataSource(int paramInt, DataSource<T> paramDataSource)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 118	com/facebook/datasource/IncreasingQualityDataSourceSupplier$IncreasingQualityDataSource:getDataSourceWithResult	()Lcom/facebook/datasource/DataSource;
      //   6: astore_3
      //   7: aload_2
      //   8: aload_3
      //   9: if_acmpne +9 -> 18
      //   12: aconst_null
      //   13: astore_3
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_3
      //   17: areturn
      //   18: aload_2
      //   19: astore_3
      //   20: aload_2
      //   21: aload_0
      //   22: iload_1
      //   23: invokespecial 113	com/facebook/datasource/IncreasingQualityDataSourceSupplier$IncreasingQualityDataSource:getDataSource	(I)Lcom/facebook/datasource/DataSource;
      //   26: if_acmpne -12 -> 14
      //   29: aload_0
      //   30: iload_1
      //   31: invokespecial 120	com/facebook/datasource/IncreasingQualityDataSourceSupplier$IncreasingQualityDataSource:getAndClearDataSource	(I)Lcom/facebook/datasource/DataSource;
      //   34: astore_3
      //   35: goto -21 -> 14
      //   38: astore_2
      //   39: aload_0
      //   40: monitorexit
      //   41: aload_2
      //   42: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	43	0	this	IncreasingQualityDataSource
      //   0	43	1	paramInt	int
      //   0	43	2	paramDataSource	DataSource<T>
      //   6	29	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	38	finally
      //   20	35	38	finally
    }
    
    public boolean close()
    {
      for (;;)
      {
        int i;
        try
        {
          if (!super.close()) {
            return false;
          }
          ArrayList localArrayList = this.mDataSources;
          this.mDataSources = null;
          if (localArrayList != null)
          {
            i = 0;
            if (i < localArrayList.size()) {}
          }
          else
          {
            return true;
          }
        }
        finally {}
        closeSafely((DataSource)((ArrayList)localObject).get(i));
        i += 1;
      }
    }
    
    /* Error */
    @Nullable
    public T getResult()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 118	com/facebook/datasource/IncreasingQualityDataSourceSupplier$IncreasingQualityDataSource:getDataSourceWithResult	()Lcom/facebook/datasource/DataSource;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnull +14 -> 22
      //   11: aload_1
      //   12: invokeinterface 150 1 0
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
      //   0	32	0	this	IncreasingQualityDataSource
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
      //   3: invokespecial 118	com/facebook/datasource/IncreasingQualityDataSourceSupplier$IncreasingQualityDataSource:getDataSourceWithResult	()Lcom/facebook/datasource/DataSource;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnull +20 -> 28
      //   11: aload_1
      //   12: invokeinterface 81 1 0
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
      //   0	38	0	this	IncreasingQualityDataSource
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
      private int mIndex;
      
      public InternalDataSubscriber(int paramInt)
      {
        this.mIndex = paramInt;
      }
      
      public void onCancellation(DataSource<T> paramDataSource) {}
      
      public void onFailure(DataSource<T> paramDataSource)
      {
        IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, paramDataSource);
      }
      
      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult()) {
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, paramDataSource);
        }
        while (!paramDataSource.isFinished()) {
          return;
        }
        IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, paramDataSource);
      }
      
      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        if (this.mIndex == 0) {
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.setProgress(paramDataSource.getProgress());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\datasource\IncreasingQualityDataSourceSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */