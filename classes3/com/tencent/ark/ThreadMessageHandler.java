package com.tencent.ark;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ThreadMessageHandler
  extends Handler
{
  private static final int DISPATCH_MESSAGE = 1;
  private static final String TAG = "ark.ThreadMessageHandler";
  private final Object mSignalObject = new Object();
  
  private static ThreadMessageHandler create()
  {
    return new ThreadMessageHandler();
  }
  
  private native boolean nativeDelegateCallback(int paramInt);
  
  private Message obtainAsyncMessage(int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain(this, 1, paramInt2, 0);
    MessageCompat.setAsynchronous(localMessage, true);
    return localMessage;
  }
  
  private boolean postDelegate(int paramInt)
  {
    return sendMessage(obtainAsyncMessage(1, paramInt));
  }
  
  private boolean postDelegateDelayed(int paramInt, long paramLong)
  {
    return sendMessageDelayed(obtainAsyncMessage(1, paramInt), paramLong);
  }
  
  private boolean sendDelegate(int paramInt)
  {
    synchronized (this.mSignalObject)
    {
      if (!sendMessage(Message.obtain(this, 1, paramInt, 0))) {
        return false;
      }
      try
      {
        this.mSignalObject.wait();
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        return false;
      }
    }
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what != 1) {
      return;
    }
    nativeDelegateCallback(???.arg1);
    synchronized (this.mSignalObject)
    {
      this.mSignalObject.notifyAll();
      return;
    }
  }
  
  private static class MessageCompat
  {
    static final MessageWrapperImpl IMPL = new LegacyMessageWrapperImpl();
    
    public static void setAsynchronous(Message paramMessage, boolean paramBoolean)
    {
      IMPL.setAsynchronous(paramMessage, paramBoolean);
    }
    
    static class LegacyMessageWrapperImpl
      implements ThreadMessageHandler.MessageCompat.MessageWrapperImpl
    {
      private Method mMessageMethodSetAsynchronous;
      
      LegacyMessageWrapperImpl()
      {
        try
        {
          this.mMessageMethodSetAsynchronous = Class.forName("android.os.Message").getMethod("setAsynchronous", new Class[] { Boolean.TYPE });
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Log.e("ark.ThreadMessageHandler", "Failed to find android.os.Message class", localClassNotFoundException);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.e("ark.ThreadMessageHandler", "Failed to load Message.setAsynchronous method", localNoSuchMethodException);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          Log.e("ark.ThreadMessageHandler", "Exception while loading Message.setAsynchronous method", localRuntimeException);
        }
      }
      
      public void setAsynchronous(Message paramMessage, boolean paramBoolean)
      {
        if (this.mMessageMethodSetAsynchronous == null) {
          return;
        }
        try
        {
          this.mMessageMethodSetAsynchronous.invoke(paramMessage, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (IllegalAccessException paramMessage)
        {
          Log.e("ark.ThreadMessageHandler", "Illegal access to async message creation, disabling.");
          this.mMessageMethodSetAsynchronous = null;
          return;
        }
        catch (IllegalArgumentException paramMessage)
        {
          Log.e("ark.ThreadMessageHandler", "Illegal argument for async message creation, disabling.");
          this.mMessageMethodSetAsynchronous = null;
          return;
        }
        catch (InvocationTargetException paramMessage)
        {
          Log.e("ark.ThreadMessageHandler", "Invocation exception during async message creation, disabling.");
          this.mMessageMethodSetAsynchronous = null;
          return;
        }
        catch (RuntimeException paramMessage)
        {
          Log.e("ark.ThreadMessageHandler", "Runtime exception during async message creation, disabling.");
          this.mMessageMethodSetAsynchronous = null;
        }
      }
    }
    
    static abstract interface MessageWrapperImpl
    {
      public abstract void setAsynchronous(Message paramMessage, boolean paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ark\ThreadMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */