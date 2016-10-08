package com.tencent.component.network.utils.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool
{
  protected static final int DEFAULT_POOL_SIZE = 4;
  public static final JobContext JOB_CONTEXT_STUB = new JobContextStub((byte)0);
  protected static final int KEEP_ALIVE_TIME = 10;
  public static final int MODE_CPU = 1;
  public static final int MODE_NETWORK = 2;
  public static final int MODE_NONE = 0;
  ResourceCounter a = new ResourceCounter(2);
  ResourceCounter b = new ResourceCounter(2);
  private final Executor c;
  
  public ThreadPool()
  {
    this("thread-pool", 4);
  }
  
  public ThreadPool(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt, new LinkedBlockingQueue());
  }
  
  public ThreadPool(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    if (paramInt1 <= 0) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt2 <= paramInt1) {
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        this.c = new ThreadPoolExecutor(paramInt1, paramInt2, 10L, TimeUnit.SECONDS, paramBlockingQueue, new PriorityThreadFactory(paramString, 10));
        return;
      }
    }
  }
  
  public ThreadPool(Executor paramExecutor)
  {
    if (paramExecutor != null) {}
    for (;;)
    {
      this.c = paramExecutor;
      return;
      paramExecutor = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PriorityThreadFactory("thread_pool", 10));
    }
  }
  
  public <T> Future<T> submit(Job<T> paramJob)
  {
    return submit(paramJob, null);
  }
  
  public <T> Future<T> submit(Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    paramJob = new Worker(paramJob, paramFutureListener);
    this.c.execute(paramJob);
    return paramJob;
  }
  
  public static abstract interface CancelListener
  {
    public abstract void onCancel();
  }
  
  public static abstract interface Job<T>
  {
    public abstract T run(ThreadPool.JobContext paramJobContext);
  }
  
  public static abstract interface JobContext
  {
    public abstract boolean isCancelled();
    
    public abstract void setCancelListener(ThreadPool.CancelListener paramCancelListener);
    
    public abstract boolean setMode(int paramInt);
  }
  
  static class JobContextStub
    implements ThreadPool.JobContext
  {
    public boolean isCancelled()
    {
      return false;
    }
    
    public void setCancelListener(ThreadPool.CancelListener paramCancelListener) {}
    
    public boolean setMode(int paramInt)
    {
      return true;
    }
  }
  
  static class ResourceCounter
  {
    public int value;
    
    public ResourceCounter(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  class Worker<T>
    implements Future<T>, ThreadPool.JobContext, Comparable<Worker>, Runnable
  {
    private final ThreadPool.Job<T> a;
    private final FutureListener<T> b;
    private ThreadPool.CancelListener c;
    private ThreadPool.ResourceCounter d;
    private volatile boolean e;
    private boolean f;
    private T g;
    private int h;
    
    public Worker(FutureListener<T> paramFutureListener)
    {
      this.a = paramFutureListener;
      FutureListener localFutureListener;
      this.b = localFutureListener;
    }
    
    private ThreadPool.ResourceCounter a(int paramInt)
    {
      if (paramInt == 1) {
        return ThreadPool.this.a;
      }
      if (paramInt == 2) {
        return ThreadPool.this.b;
      }
      return null;
    }
    
    /* Error */
    private boolean a(ThreadPool.ResourceCounter paramResourceCounter)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 60	com/tencent/component/network/utils/thread/ThreadPool$Worker:e	Z
      //   6: ifeq +12 -> 18
      //   9: aload_0
      //   10: aconst_null
      //   11: putfield 62	com/tencent/component/network/utils/thread/ThreadPool$Worker:d	Lcom/tencent/component/network/utils/thread/ThreadPool$ResourceCounter;
      //   14: aload_0
      //   15: monitorexit
      //   16: iconst_0
      //   17: ireturn
      //   18: aload_0
      //   19: aload_1
      //   20: putfield 62	com/tencent/component/network/utils/thread/ThreadPool$Worker:d	Lcom/tencent/component/network/utils/thread/ThreadPool$ResourceCounter;
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: monitorenter
      //   27: aload_1
      //   28: getfield 67	com/tencent/component/network/utils/thread/ThreadPool$ResourceCounter:value	I
      //   31: ifle +31 -> 62
      //   34: aload_1
      //   35: aload_1
      //   36: getfield 67	com/tencent/component/network/utils/thread/ThreadPool$ResourceCounter:value	I
      //   39: iconst_1
      //   40: isub
      //   41: putfield 67	com/tencent/component/network/utils/thread/ThreadPool$ResourceCounter:value	I
      //   44: aload_1
      //   45: monitorexit
      //   46: aload_0
      //   47: monitorenter
      //   48: aload_0
      //   49: aconst_null
      //   50: putfield 62	com/tencent/component/network/utils/thread/ThreadPool$Worker:d	Lcom/tencent/component/network/utils/thread/ThreadPool$ResourceCounter;
      //   53: aload_0
      //   54: monitorexit
      //   55: iconst_1
      //   56: ireturn
      //   57: astore_1
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_1
      //   61: athrow
      //   62: aload_1
      //   63: invokevirtual 70	java/lang/Object:wait	()V
      //   66: aload_1
      //   67: monitorexit
      //   68: goto -68 -> 0
      //   71: astore_2
      //   72: aload_1
      //   73: monitorexit
      //   74: aload_2
      //   75: athrow
      //   76: astore_1
      //   77: aload_0
      //   78: monitorexit
      //   79: aload_1
      //   80: athrow
      //   81: astore_2
      //   82: goto -16 -> 66
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	85	0	this	Worker
      //   0	85	1	paramResourceCounter	ThreadPool.ResourceCounter
      //   71	4	2	localObject	Object
      //   81	1	2	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   2	16	57	finally
      //   18	25	57	finally
      //   27	46	71	finally
      //   62	66	71	finally
      //   66	68	71	finally
      //   48	55	76	finally
      //   62	66	81	java/lang/InterruptedException
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 60	com/tencent/component/network/utils/thread/ThreadPool$Worker:e	Z
      //   6: istore_3
      //   7: iload_3
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 60	com/tencent/component/network/utils/thread/ThreadPool$Worker:e	Z
      //   19: aload_0
      //   20: getfield 62	com/tencent/component/network/utils/thread/ThreadPool$Worker:d	Lcom/tencent/component/network/utils/thread/ThreadPool$ResourceCounter;
      //   23: ifnull +19 -> 42
      //   26: aload_0
      //   27: getfield 62	com/tencent/component/network/utils/thread/ThreadPool$Worker:d	Lcom/tencent/component/network/utils/thread/ThreadPool$ResourceCounter;
      //   30: astore_1
      //   31: aload_1
      //   32: monitorenter
      //   33: aload_0
      //   34: getfield 62	com/tencent/component/network/utils/thread/ThreadPool$Worker:d	Lcom/tencent/component/network/utils/thread/ThreadPool$ResourceCounter;
      //   37: invokevirtual 74	java/lang/Object:notifyAll	()V
      //   40: aload_1
      //   41: monitorexit
      //   42: aload_0
      //   43: getfield 76	com/tencent/component/network/utils/thread/ThreadPool$Worker:c	Lcom/tencent/component/network/utils/thread/ThreadPool$CancelListener;
      //   46: ifnull -35 -> 11
      //   49: aload_0
      //   50: getfield 76	com/tencent/component/network/utils/thread/ThreadPool$Worker:c	Lcom/tencent/component/network/utils/thread/ThreadPool$CancelListener;
      //   53: invokeinterface 81 1 0
      //   58: goto -47 -> 11
      //   61: astore_1
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_1
      //   65: athrow
      //   66: astore_2
      //   67: aload_1
      //   68: monitorexit
      //   69: aload_2
      //   70: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	71	0	this	Worker
      //   61	7	1	localObject1	Object
      //   66	4	2	localObject2	Object
      //   6	2	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	7	61	finally
      //   14	33	61	finally
      //   42	58	61	finally
      //   67	71	61	finally
      //   33	42	66	finally
    }
    
    public int compareTo(Worker paramWorker)
    {
      return ((Comparable)this.a).compareTo(paramWorker.a);
    }
    
    /* Error */
    public T get()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 94	com/tencent/component/network/utils/thread/ThreadPool$Worker:f	Z
      //   6: ifeq +12 -> 18
      //   9: aload_0
      //   10: getfield 96	com/tencent/component/network/utils/thread/ThreadPool$Worker:g	Ljava/lang/Object;
      //   13: astore_1
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_1
      //   17: areturn
      //   18: aload_0
      //   19: invokevirtual 70	java/lang/Object:wait	()V
      //   22: goto -20 -> 2
      //   25: astore_1
      //   26: ldc 97
      //   28: ldc 99
      //   30: aload_1
      //   31: invokestatic 104	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   34: goto -32 -> 2
      //   37: astore_1
      //   38: aload_0
      //   39: monitorexit
      //   40: aload_1
      //   41: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	42	0	this	Worker
      //   13	4	1	localObject1	Object
      //   25	6	1	localException	Exception
      //   37	4	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   18	22	25	java/lang/Exception
      //   2	14	37	finally
      //   18	22	37	finally
      //   26	34	37	finally
    }
    
    public boolean isCancelled()
    {
      return this.e;
    }
    
    public boolean isDone()
    {
      try
      {
        boolean bool = this.f;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 47	com/tencent/component/network/utils/thread/ThreadPool$Worker:b	Lcom/tencent/component/network/utils/thread/FutureListener;
      //   4: ifnull +13 -> 17
      //   7: aload_0
      //   8: getfield 47	com/tencent/component/network/utils/thread/ThreadPool$Worker:b	Lcom/tencent/component/network/utils/thread/FutureListener;
      //   11: aload_0
      //   12: invokeinterface 117 2 0
      //   17: aconst_null
      //   18: astore_2
      //   19: aload_2
      //   20: astore_1
      //   21: aload_0
      //   22: iconst_1
      //   23: invokevirtual 121	com/tencent/component/network/utils/thread/ThreadPool$Worker:setMode	(I)Z
      //   26: ifeq +14 -> 40
      //   29: aload_0
      //   30: getfield 45	com/tencent/component/network/utils/thread/ThreadPool$Worker:a	Lcom/tencent/component/network/utils/thread/ThreadPool$Job;
      //   33: aload_0
      //   34: invokeinterface 126 2 0
      //   39: astore_1
      //   40: aload_0
      //   41: monitorenter
      //   42: aload_0
      //   43: iconst_0
      //   44: invokevirtual 121	com/tencent/component/network/utils/thread/ThreadPool$Worker:setMode	(I)Z
      //   47: pop
      //   48: aload_0
      //   49: aload_1
      //   50: putfield 96	com/tencent/component/network/utils/thread/ThreadPool$Worker:g	Ljava/lang/Object;
      //   53: aload_0
      //   54: iconst_1
      //   55: putfield 94	com/tencent/component/network/utils/thread/ThreadPool$Worker:f	Z
      //   58: aload_0
      //   59: invokevirtual 74	java/lang/Object:notifyAll	()V
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: getfield 47	com/tencent/component/network/utils/thread/ThreadPool$Worker:b	Lcom/tencent/component/network/utils/thread/FutureListener;
      //   68: ifnull +13 -> 81
      //   71: aload_0
      //   72: getfield 47	com/tencent/component/network/utils/thread/ThreadPool$Worker:b	Lcom/tencent/component/network/utils/thread/FutureListener;
      //   75: aload_0
      //   76: invokeinterface 129 2 0
      //   81: return
      //   82: astore_1
      //   83: ldc 97
      //   85: ldc -125
      //   87: aload_1
      //   88: invokestatic 104	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   91: aload_2
      //   92: astore_1
      //   93: goto -53 -> 40
      //   96: astore_1
      //   97: aload_0
      //   98: monitorexit
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	Worker
      //   20	30	1	localObject1	Object
      //   82	6	1	localThrowable	Throwable
      //   92	1	1	localObject2	Object
      //   96	4	1	localObject3	Object
      //   18	74	2	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   29	40	82	java/lang/Throwable
      //   42	64	96	finally
    }
    
    public void setCancelListener(ThreadPool.CancelListener paramCancelListener)
    {
      try
      {
        this.c = paramCancelListener;
        if ((this.e) && (this.c != null)) {
          this.c.onCancel();
        }
        return;
      }
      finally
      {
        paramCancelListener = finally;
        throw paramCancelListener;
      }
    }
    
    public boolean setMode(int paramInt)
    {
      ThreadPool.ResourceCounter localResourceCounter = a(this.h);
      if (localResourceCounter != null) {}
      try
      {
        localResourceCounter.value += 1;
        localResourceCounter.notifyAll();
        this.h = 0;
        localResourceCounter = a(paramInt);
        if (localResourceCounter == null) {
          break label66;
        }
        if (!a(localResourceCounter)) {
          return false;
        }
      }
      finally {}
      this.h = paramInt;
      label66:
      return true;
    }
    
    public void waitDone()
    {
      get();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\thread\ThreadPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */