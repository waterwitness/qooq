package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class JobScheduler
{
  static final String QUEUE_TIME_KEY = "queueTime";
  private final Runnable mDoJobRunnable;
  @VisibleForTesting
  @GuardedBy("this")
  EncodedImage mEncodedImage;
  private final Executor mExecutor;
  @VisibleForTesting
  @GuardedBy("this")
  boolean mIsLast;
  private final JobRunnable mJobRunnable;
  @VisibleForTesting
  @GuardedBy("this")
  long mJobStartTime;
  @VisibleForTesting
  @GuardedBy("this")
  JobState mJobState;
  @VisibleForTesting
  @GuardedBy("this")
  long mJobSubmitTime;
  private final int mMinimumJobIntervalMs;
  private final Runnable mSubmitJobRunnable;
  
  public JobScheduler(Executor paramExecutor, JobRunnable paramJobRunnable, int paramInt)
  {
    this.mExecutor = paramExecutor;
    this.mJobRunnable = paramJobRunnable;
    this.mMinimumJobIntervalMs = paramInt;
    this.mDoJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.doJob();
      }
    };
    this.mSubmitJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.submitJob();
      }
    };
    this.mEncodedImage = null;
    this.mIsLast = false;
    this.mJobState = JobState.IDLE;
    this.mJobSubmitTime = 0L;
    this.mJobStartTime = 0L;
  }
  
  /* Error */
  private void doJob()
  {
    // Byte code:
    //   0: invokestatic 114	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 92	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 94	com/facebook/imagepipeline/producers/JobScheduler:mIsLast	Z
    //   15: istore 5
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 92	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 94	com/facebook/imagepipeline/producers/JobScheduler:mIsLast	Z
    //   27: aload_0
    //   28: getstatic 67	com/facebook/imagepipeline/producers/JobScheduler$JobState:RUNNING	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   31: putfield 96	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   34: aload_0
    //   35: lload_3
    //   36: putfield 100	com/facebook/imagepipeline/producers/JobScheduler:mJobStartTime	J
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: iload 5
    //   44: invokestatic 118	com/facebook/imagepipeline/producers/JobScheduler:shouldProcess	(Lcom/facebook/imagepipeline/image/EncodedImage;Z)Z
    //   47: ifeq +15 -> 62
    //   50: aload_0
    //   51: getfield 80	com/facebook/imagepipeline/producers/JobScheduler:mJobRunnable	Lcom/facebook/imagepipeline/producers/JobScheduler$JobRunnable;
    //   54: aload_1
    //   55: iload 5
    //   57: invokeinterface 122 3 0
    //   62: aload_1
    //   63: invokestatic 128	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   66: aload_0
    //   67: invokespecial 131	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: astore_2
    //   77: aload_1
    //   78: invokestatic 128	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   81: aload_0
    //   82: invokespecial 131	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	JobScheduler
    //   10	53	1	localEncodedImage1	EncodedImage
    //   71	7	1	localEncodedImage2	EncodedImage
    //   76	10	2	localObject	Object
    //   3	33	3	l	long
    //   15	41	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	41	71	finally
    //   72	74	71	finally
    //   41	62	76	finally
  }
  
  private void enqueueJob(long paramLong)
  {
    if (paramLong > 0L)
    {
      JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    this.mSubmitJobRunnable.run();
  }
  
  /* Error */
  private void onJobFinished()
  {
    // Byte code:
    //   0: invokestatic 114	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 5
    //   5: lconst_0
    //   6: lstore_3
    //   7: iconst_0
    //   8: istore_2
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 96	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   15: getstatic 70	com/facebook/imagepipeline/producers/JobScheduler$JobState:RUNNING_AND_PENDING	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   18: if_acmpne +49 -> 67
    //   21: aload_0
    //   22: getfield 100	com/facebook/imagepipeline/producers/JobScheduler:mJobStartTime	J
    //   25: aload_0
    //   26: getfield 82	com/facebook/imagepipeline/producers/JobScheduler:mMinimumJobIntervalMs	I
    //   29: i2l
    //   30: ladd
    //   31: lload 5
    //   33: invokestatic 159	java/lang/Math:max	(JJ)J
    //   36: lstore_3
    //   37: iconst_1
    //   38: istore_2
    //   39: aload_0
    //   40: lload 5
    //   42: putfield 98	com/facebook/imagepipeline/producers/JobScheduler:mJobSubmitTime	J
    //   45: aload_0
    //   46: getstatic 64	com/facebook/imagepipeline/producers/JobScheduler$JobState:QUEUED	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   49: putfield 96	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ifeq +11 -> 66
    //   58: aload_0
    //   59: lload_3
    //   60: lload 5
    //   62: lsub
    //   63: invokespecial 161	com/facebook/imagepipeline/producers/JobScheduler:enqueueJob	(J)V
    //   66: return
    //   67: aload_0
    //   68: getstatic 57	com/facebook/imagepipeline/producers/JobScheduler$JobState:IDLE	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   71: putfield 96	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   74: goto -22 -> 52
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	JobScheduler
    //   77	4	1	localObject	Object
    //   8	47	2	i	int
    //   6	54	3	l1	long
    //   3	58	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   11	37	77	finally
    //   39	52	77	finally
    //   52	54	77	finally
    //   67	74	77	finally
    //   78	80	77	finally
  }
  
  private static boolean shouldProcess(EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    return (paramBoolean) || (EncodedImage.isValid(paramEncodedImage));
  }
  
  private void submitJob()
  {
    this.mExecutor.execute(this.mDoJobRunnable);
  }
  
  public void clearJob()
  {
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = null;
      this.mIsLast = false;
      EncodedImage.closeSafely(localEncodedImage);
      return;
    }
    finally {}
  }
  
  public long getQueuedTime()
  {
    try
    {
      long l1 = this.mJobStartTime;
      long l2 = this.mJobSubmitTime;
      return l1 - l2;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean scheduleJob()
  {
    long l3 = SystemClock.uptimeMillis();
    long l2 = 0L;
    int j = 0;
    for (;;)
    {
      try
      {
        if (!shouldProcess(this.mEncodedImage, this.mIsLast)) {
          return false;
        }
        i = j;
        l1 = l2;
        switch (this.mJobState)
        {
        case QUEUED: 
          if (i != 0) {
            enqueueJob(l1 - l3);
          }
          return true;
        }
      }
      finally {}
      long l1 = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, l3);
      int i = 1;
      this.mJobSubmitTime = l3;
      this.mJobState = JobState.QUEUED;
      continue;
      this.mJobState = JobState.RUNNING_AND_PENDING;
      i = j;
      l1 = l2;
      continue;
      i = j;
      l1 = l2;
    }
  }
  
  public boolean updateJob(EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    if (!shouldProcess(paramEncodedImage, paramBoolean)) {
      return false;
    }
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
      this.mIsLast = paramBoolean;
      EncodedImage.closeSafely(localEncodedImage);
      return true;
    }
    finally {}
  }
  
  public static abstract interface JobRunnable
  {
    public abstract void run(EncodedImage paramEncodedImage, boolean paramBoolean);
  }
  
  @VisibleForTesting
  static class JobStartExecutorSupplier
  {
    private static ScheduledExecutorService sJobStarterExecutor;
    
    static ScheduledExecutorService get()
    {
      if (sJobStarterExecutor == null) {
        sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
      }
      return sJobStarterExecutor;
    }
  }
  
  @VisibleForTesting
  static enum JobState
  {
    IDLE,  QUEUED,  RUNNING,  RUNNING_AND_PENDING;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\JobScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */