package com.facebook.react.bridge.queue;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MessageQueueThreadHandler
  extends Handler
{
  private final QueueThreadExceptionHandler mExceptionHandler;
  
  public MessageQueueThreadHandler(Looper paramLooper, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    super(paramLooper);
    this.mExceptionHandler = paramQueueThreadExceptionHandler;
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    try
    {
      super.dispatchMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      this.mExceptionHandler.handleException(paramMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\queue\MessageQueueThreadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */