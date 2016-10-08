package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DefaultExecutorSupplier
  implements ExecutorSupplier
{
  private static final int NUM_IO_BOUND_THREADS = 2;
  private static final int NUM_LIGHTWEIGHT_BACKGROUND_THREADS = 1;
  private final Executor mBackgroundExecutor;
  private final Executor mDecodeExecutor;
  private final Executor mIoBoundExecutor;
  private final Executor mLightWeightBackgroundExecutor;
  
  public DefaultExecutorSupplier(int paramInt)
  {
    PriorityThreadFactory localPriorityThreadFactory = new PriorityThreadFactory(10);
    this.mIoBoundExecutor = Executors.newFixedThreadPool(2);
    this.mDecodeExecutor = Executors.newFixedThreadPool(paramInt, localPriorityThreadFactory);
    this.mBackgroundExecutor = Executors.newFixedThreadPool(paramInt, localPriorityThreadFactory);
    this.mLightWeightBackgroundExecutor = Executors.newFixedThreadPool(1, localPriorityThreadFactory);
  }
  
  public Executor forBackgroundTasks()
  {
    return this.mBackgroundExecutor;
  }
  
  public Executor forDecode()
  {
    return this.mDecodeExecutor;
  }
  
  public Executor forLightweightBackgroundTasks()
  {
    return this.mLightWeightBackgroundExecutor;
  }
  
  public Executor forLocalStorageRead()
  {
    return this.mIoBoundExecutor;
  }
  
  public Executor forLocalStorageWrite()
  {
    return this.mIoBoundExecutor;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\core\DefaultExecutorSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */