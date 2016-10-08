package com.tencent.bitapp.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public enum ThreadManager
{
  INSTANCE;
  
  public static int i = 0;
  private Builder mBuilder = null;
  private ThreadPoolExecutor mExecutorPool = null;
  
  private ThreadManager() {}
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  private void initThreadPool()
  {
    if ((this.mExecutorPool == null) || (this.mExecutorPool.isShutdown()))
    {
      if (this.mBuilder == null) {
        this.mBuilder = new Builder();
      }
      this.mExecutorPool = new ThreadPoolExecutor(this.mBuilder.getCorePoolSize(), this.mBuilder.getMaxPoolSize(), this.mBuilder.getKeepAliveTime(), TimeUnit.SECONDS, new LinkedBlockingQueue(), this.mBuilder.getThreadFactory());
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    int j = 0;
    while (j < 20)
    {
      builder().setCorePoolSize(11).build().execute(new Runnable()
      {
        public void run()
        {
          ThreadManager.i += 1;
          try
          {
            Thread.sleep(1000L);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      });
      j += 1;
    }
    try
    {
      Thread.sleep(30000L);
      INSTANCE.shutdown();
      return;
    }
    catch (InterruptedException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    initThreadPool();
    this.mExecutorPool.execute(paramRunnable);
  }
  
  public void setBuilder(Builder paramBuilder)
  {
    this.mBuilder = paramBuilder;
  }
  
  public void shutdown()
  {
    if (this.mExecutorPool != null)
    {
      this.mExecutorPool.shutdown();
      this.mExecutorPool = null;
    }
  }
  
  public static class Builder
  {
    private static final int DEFAULT_CORE_POOL_SIZE = 0;
    private static final int DEFAULT_KEEP_ALIVE_TIME = 10;
    private static final int DEFAULT_MAX_POOL_SIZE = 4;
    private int mCorePoolSize = 0;
    private int mKeepAliveTime = 10;
    private int mMaxPoolSize = 4;
    private ThreadFactory mThreadFactory = Executors.defaultThreadFactory();
    
    public ThreadManager build()
    {
      if (this.mCorePoolSize < 0) {
        this.mCorePoolSize = 0;
      }
      if (this.mMaxPoolSize <= 0) {
        this.mMaxPoolSize = 4;
      }
      if (this.mKeepAliveTime < 0) {
        this.mKeepAliveTime = 10;
      }
      if (this.mMaxPoolSize < this.mCorePoolSize) {
        this.mCorePoolSize = (this.mMaxPoolSize - 1);
      }
      ThreadManager.INSTANCE.setBuilder(this);
      return ThreadManager.INSTANCE;
    }
    
    public int getCorePoolSize()
    {
      return this.mCorePoolSize;
    }
    
    public int getKeepAliveTime()
    {
      return this.mKeepAliveTime;
    }
    
    public int getMaxPoolSize()
    {
      return this.mMaxPoolSize;
    }
    
    public ThreadFactory getThreadFactory()
    {
      return this.mThreadFactory;
    }
    
    public Builder setCorePoolSize(int paramInt)
    {
      if (paramInt > 0) {
        this.mCorePoolSize = paramInt;
      }
      return this;
    }
    
    public Builder setKeepAliveTime(int paramInt)
    {
      if (paramInt > 0) {
        this.mKeepAliveTime = paramInt;
      }
      return this;
    }
    
    public Builder setMaxPoolSize(int paramInt)
    {
      if (paramInt > 0) {
        this.mMaxPoolSize = paramInt;
      }
      return this;
    }
    
    public Builder setThreadFactory(ThreadFactory paramThreadFactory)
    {
      if (paramThreadFactory != null) {
        this.mThreadFactory = paramThreadFactory;
      }
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\thread\ThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */