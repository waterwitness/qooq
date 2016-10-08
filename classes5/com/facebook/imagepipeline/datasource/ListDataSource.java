package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.GuardedBy;

public class ListDataSource<T>
  extends AbstractDataSource<List<CloseableReference<T>>>
{
  private final DataSource<CloseableReference<T>>[] mDataSources;
  @GuardedBy("this")
  private int mFinishedDataSources;
  
  protected ListDataSource(DataSource<CloseableReference<T>>[] paramArrayOfDataSource)
  {
    this.mDataSources = paramArrayOfDataSource;
    this.mFinishedDataSources = 0;
  }
  
  public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... paramVarArgs)
  {
    int i = 0;
    Preconditions.checkNotNull(paramVarArgs);
    boolean bool;
    ListDataSource localListDataSource;
    int j;
    if (paramVarArgs.length > 0)
    {
      bool = true;
      Preconditions.checkState(bool);
      localListDataSource = new ListDataSource(paramVarArgs);
      j = paramVarArgs.length;
    }
    for (;;)
    {
      if (i >= j)
      {
        return localListDataSource;
        bool = false;
        break;
      }
      DataSource<CloseableReference<T>> localDataSource = paramVarArgs[i];
      if (localDataSource != null)
      {
        localListDataSource.getClass();
        localDataSource.subscribe(new InternalDataSubscriber(localListDataSource, null), CallerThreadExecutor.getInstance());
      }
      i += 1;
    }
  }
  
  /* Error */
  private boolean increaseAndCheckIfLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/facebook/imagepipeline/datasource/ListDataSource:mFinishedDataSources	I
    //   6: iconst_1
    //   7: iadd
    //   8: istore_2
    //   9: aload_0
    //   10: iload_2
    //   11: putfield 25	com/facebook/imagepipeline/datasource/ListDataSource:mFinishedDataSources	I
    //   14: aload_0
    //   15: getfield 23	com/facebook/imagepipeline/datasource/ListDataSource:mDataSources	[Lcom/facebook/datasource/DataSource;
    //   18: arraylength
    //   19: istore_3
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmpne +11 -> 33
    //   25: iconst_1
    //   26: istore 4
    //   28: aload_0
    //   29: monitorexit
    //   30: iload 4
    //   32: ireturn
    //   33: iconst_0
    //   34: istore 4
    //   36: goto -8 -> 28
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ListDataSource
    //   39	4	1	localObject	Object
    //   8	15	2	i	int
    //   19	4	3	j	int
    //   26	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	39	finally
  }
  
  private void onDataSourceCancelled()
  {
    setFailure(new CancellationException());
  }
  
  private void onDataSourceFailed(DataSource<CloseableReference<T>> paramDataSource)
  {
    setFailure(paramDataSource.getFailureCause());
  }
  
  private void onDataSourceFinished()
  {
    if (increaseAndCheckIfLast()) {
      setResult(null, true);
    }
  }
  
  private void onDataSourceProgress()
  {
    float f = 0.0F;
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        setProgress(f / this.mDataSources.length);
        return;
      }
      f += arrayOfDataSource[i].getProgress();
      i += 1;
    }
  }
  
  public boolean close()
  {
    int i = 0;
    if (!super.close()) {
      return false;
    }
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    for (;;)
    {
      if (i >= j) {
        return true;
      }
      arrayOfDataSource[i].close();
      i += 1;
    }
  }
  
  /* Error */
  @javax.annotation.Nullable
  public List<CloseableReference<T>> getResult()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 124	com/facebook/imagepipeline/datasource/ListDataSource:hasResult	()Z
    //   6: istore 6
    //   8: iload 6
    //   10: ifne +9 -> 19
    //   13: aconst_null
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: new 126	java/util/ArrayList
    //   22: dup
    //   23: aload_0
    //   24: getfield 23	com/facebook/imagepipeline/datasource/ListDataSource:mDataSources	[Lcom/facebook/datasource/DataSource;
    //   27: arraylength
    //   28: invokespecial 129	java/util/ArrayList:<init>	(I)V
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 23	com/facebook/imagepipeline/datasource/ListDataSource:mDataSources	[Lcom/facebook/datasource/DataSource;
    //   36: astore_3
    //   37: aload_3
    //   38: arraylength
    //   39: istore 5
    //   41: iconst_0
    //   42: istore 4
    //   44: aload_2
    //   45: astore_1
    //   46: iload 4
    //   48: iload 5
    //   50: if_icmpge -35 -> 15
    //   53: aload_2
    //   54: aload_3
    //   55: iload 4
    //   57: aaload
    //   58: invokeinterface 131 1 0
    //   63: checkcast 133	com/facebook/common/references/CloseableReference
    //   66: invokeinterface 139 2 0
    //   71: pop
    //   72: iload 4
    //   74: iconst_1
    //   75: iadd
    //   76: istore 4
    //   78: goto -34 -> 44
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ListDataSource
    //   14	32	1	localObject1	Object
    //   81	4	1	localObject2	Object
    //   31	23	2	localArrayList	java.util.ArrayList
    //   36	19	3	arrayOfDataSource	DataSource[]
    //   42	35	4	i	int
    //   39	12	5	j	int
    //   6	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	81	finally
    //   19	41	81	finally
    //   53	72	81	finally
  }
  
  /* Error */
  public boolean hasResult()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 144	com/facebook/imagepipeline/datasource/ListDataSource:isClosed	()Z
    //   6: ifne +27 -> 33
    //   9: aload_0
    //   10: getfield 25	com/facebook/imagepipeline/datasource/ListDataSource:mFinishedDataSources	I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 23	com/facebook/imagepipeline/datasource/ListDataSource:mDataSources	[Lcom/facebook/datasource/DataSource;
    //   18: arraylength
    //   19: istore_3
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmpne +11 -> 33
    //   25: iconst_1
    //   26: istore 4
    //   28: aload_0
    //   29: monitorexit
    //   30: iload 4
    //   32: ireturn
    //   33: iconst_0
    //   34: istore 4
    //   36: goto -8 -> 28
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ListDataSource
    //   39	4	1	localObject	Object
    //   13	10	2	i	int
    //   19	4	3	j	int
    //   26	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	39	finally
  }
  
  private class InternalDataSubscriber
    implements DataSubscriber<CloseableReference<T>>
  {
    @GuardedBy("InternalDataSubscriber.this")
    boolean mFinished = false;
    
    private InternalDataSubscriber() {}
    
    /* Error */
    private boolean tryFinish()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 26	com/facebook/imagepipeline/datasource/ListDataSource$InternalDataSubscriber:mFinished	Z
      //   8: istore_3
      //   9: iload_3
      //   10: ifeq +9 -> 19
      //   13: iconst_0
      //   14: istore_2
      //   15: aload_0
      //   16: monitorexit
      //   17: iload_2
      //   18: ireturn
      //   19: aload_0
      //   20: iconst_1
      //   21: putfield 26	com/facebook/imagepipeline/datasource/ListDataSource$InternalDataSubscriber:mFinished	Z
      //   24: goto -9 -> 15
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	InternalDataSubscriber
      //   27	4	1	localObject	Object
      //   1	17	2	bool1	boolean
      //   8	2	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	9	27	finally
      //   19	24	27	finally
    }
    
    public void onCancellation(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceCancelled();
    }
    
    public void onFailure(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceFailed(paramDataSource);
    }
    
    public void onNewResult(DataSource<CloseableReference<T>> paramDataSource)
    {
      if ((paramDataSource.isFinished()) && (tryFinish())) {
        ListDataSource.this.onDataSourceFinished();
      }
    }
    
    public void onProgressUpdate(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceProgress();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\datasource\ListDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */