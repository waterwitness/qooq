package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.tencent.bitapp.pre.binder.MessageQueueThread;

@DoNotStrip
public class MessageQueueThreadImpl
  implements MessageQueueThread
{
  private final String mAssertionErrorMessage;
  private final MessageQueueThreadHandler mHandler;
  private volatile boolean mIsFinished = false;
  private final Looper mLooper;
  private final String mName;
  
  private MessageQueueThreadImpl(String paramString, Looper paramLooper, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    this.mName = paramString;
    this.mLooper = paramLooper;
    this.mHandler = new MessageQueueThreadHandler(paramLooper, paramQueueThreadExceptionHandler);
    this.mAssertionErrorMessage = ("Expected to be called from the '" + getName() + "' thread!");
  }
  
  public static MessageQueueThreadImpl create(MessageQueueThreadSpec paramMessageQueueThreadSpec, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    switch (paramMessageQueueThreadSpec.getThreadType())
    {
    default: 
      throw new RuntimeException("Unknown thread type: " + paramMessageQueueThreadSpec.getThreadType());
    case ???: 
      return createForMainThread(paramMessageQueueThreadSpec.getName(), paramQueueThreadExceptionHandler);
    }
    return startNewBackgroundThread(paramMessageQueueThreadSpec.getName(), paramQueueThreadExceptionHandler);
  }
  
  private static MessageQueueThreadImpl createForMainThread(String paramString, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    return new MessageQueueThreadImpl(paramString, Looper.getMainLooper(), paramQueueThreadExceptionHandler);
  }
  
  private static MessageQueueThreadImpl startNewBackgroundThread(String paramString, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    SimpleSettableFuture localSimpleSettableFuture = new SimpleSettableFuture();
    new Thread(new Runnable()
    {
      public void run()
      {
        Looper.prepare();
        this.val$simpleSettableFuture.set(Looper.myLooper());
        Looper.loop();
      }
    }, "mqt_" + paramString).start();
    return new MessageQueueThreadImpl(paramString, (Looper)localSimpleSettableFuture.get(5000L), paramQueueThreadExceptionHandler);
  }
  
  public void assertIsOnThread() {}
  
  public Looper getLooper()
  {
    return this.mLooper;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean isOnThread()
  {
    return this.mLooper.getThread() == Thread.currentThread();
  }
  
  public void quitSynchronous()
  {
    this.mIsFinished = true;
    this.mLooper.quit();
    if (this.mLooper.getThread() != Thread.currentThread()) {}
    try
    {
      this.mLooper.getThread().join();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException("Got interrupted waiting to join thread " + this.mName);
    }
  }
  
  @DoNotStrip
  public void runOnQueue(Runnable paramRunnable)
  {
    if (this.mIsFinished)
    {
      if (FLog.isLoggable(5)) {
        FLog.w("React", "Tried to enqueue runnable on already finished thread: '" + getName() + "... dropping Runnable.");
      }
      return;
    }
    this.mHandler.post(paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\queue\MessageQueueThreadImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */