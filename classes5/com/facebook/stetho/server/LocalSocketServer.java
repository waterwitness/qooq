package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;

public class LocalSocketServer
{
  private static final int MAX_BIND_RETRIES = 2;
  private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
  private static final String WORKER_THREAD_NAME_PREFIX = "StethoWorker";
  private final String mAddress;
  private final String mFriendlyName;
  private Thread mListenerThread;
  private LocalServerSocket mServerSocket;
  private final SocketHandler mSocketHandler;
  private boolean mStopped;
  private final AtomicInteger mThreadId = new AtomicInteger();
  
  public LocalSocketServer(String paramString1, String paramString2, SocketHandler paramSocketHandler)
  {
    this.mFriendlyName = ((String)Util.throwIfNull(paramString1));
    this.mAddress = ((String)Util.throwIfNull(paramString2));
    this.mSocketHandler = paramSocketHandler;
  }
  
  @Nonnull
  private static LocalServerSocket bindToSocket(String paramString)
    throws IOException
  {
    Object localObject1 = null;
    int i = 2;
    for (;;)
    {
      try
      {
        if (LogUtil.isLoggable(3)) {
          LogUtil.d("Trying to bind to @" + paramString);
        }
        localObject2 = new LocalServerSocket(paramString);
        return (LocalServerSocket)localObject2;
      }
      catch (BindException localBindException)
      {
        LogUtil.w(localBindException, "Binding error, sleep 1000 ms...");
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localBindException;
        }
        Util.sleepUninterruptibly(1000L);
        if (i <= 0) {
          throw ((Throwable)localObject2);
        }
        i -= 1;
        localObject1 = localObject2;
      }
    }
  }
  
  private void listenOnAddress(String paramString)
    throws IOException
  {
    this.mServerSocket = bindToSocket(paramString);
    LogUtil.i("Listening on @" + paramString);
    if (Thread.interrupted()) {}
    for (;;)
    {
      LogUtil.i("Server shutdown on @" + paramString);
      return;
      try
      {
        WorkerThread localWorkerThread = new WorkerThread(this.mServerSocket.accept(), this.mSocketHandler);
        localWorkerThread.setName("StethoWorker-" + this.mFriendlyName + "-" + this.mThreadId.incrementAndGet());
        localWorkerThread.setDaemon(true);
        localWorkerThread.start();
      }
      catch (SocketException localSocketException)
      {
        if (!Thread.interrupted()) {
          LogUtil.w(localSocketException, "I/O error");
        }
      }
      catch (InterruptedIOException localInterruptedIOException) {}catch (IOException localIOException)
      {
        LogUtil.w(localIOException, "I/O error initialising connection thread");
      }
    }
  }
  
  public String getName()
  {
    return this.mFriendlyName;
  }
  
  public void run()
    throws IOException
  {
    try
    {
      if (this.mStopped) {
        return;
      }
      this.mListenerThread = Thread.currentThread();
      listenOnAddress(this.mAddress);
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      this.mStopped = true;
      if (this.mListenerThread == null) {
        return;
      }
      this.mListenerThread.interrupt();
      try
      {
        if (this.mServerSocket != null)
        {
          this.mServerSocket.close();
          return;
        }
      }
      catch (IOException localIOException) {}
      return;
    }
    finally {}
  }
  
  private static class WorkerThread
    extends Thread
  {
    private final LocalSocket mSocket;
    private final SocketHandler mSocketHandler;
    
    public WorkerThread(LocalSocket paramLocalSocket, SocketHandler paramSocketHandler)
    {
      this.mSocket = paramLocalSocket;
      this.mSocketHandler = paramSocketHandler;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	com/facebook/stetho/server/LocalSocketServer$WorkerThread:mSocketHandler	Lcom/facebook/stetho/server/SocketHandler;
      //   4: aload_0
      //   5: getfield 18	com/facebook/stetho/server/LocalSocketServer$WorkerThread:mSocket	Landroid/net/LocalSocket;
      //   8: invokeinterface 30 2 0
      //   13: aload_0
      //   14: getfield 18	com/facebook/stetho/server/LocalSocketServer$WorkerThread:mSocket	Landroid/net/LocalSocket;
      //   17: invokevirtual 35	android/net/LocalSocket:close	()V
      //   20: return
      //   21: astore_1
      //   22: ldc 37
      //   24: iconst_1
      //   25: anewarray 39	java/lang/Object
      //   28: dup
      //   29: iconst_0
      //   30: aload_1
      //   31: aastore
      //   32: invokestatic 45	com/facebook/stetho/common/LogUtil:w	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   35: aload_0
      //   36: getfield 18	com/facebook/stetho/server/LocalSocketServer$WorkerThread:mSocket	Landroid/net/LocalSocket;
      //   39: invokevirtual 35	android/net/LocalSocket:close	()V
      //   42: return
      //   43: astore_1
      //   44: return
      //   45: astore_1
      //   46: aload_0
      //   47: getfield 18	com/facebook/stetho/server/LocalSocketServer$WorkerThread:mSocket	Landroid/net/LocalSocket;
      //   50: invokevirtual 35	android/net/LocalSocket:close	()V
      //   53: aload_1
      //   54: athrow
      //   55: astore_1
      //   56: return
      //   57: astore_2
      //   58: goto -5 -> 53
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	WorkerThread
      //   21	10	1	localIOException1	IOException
      //   43	1	1	localIOException2	IOException
      //   45	9	1	localObject	Object
      //   55	1	1	localIOException3	IOException
      //   57	1	2	localIOException4	IOException
      // Exception table:
      //   from	to	target	type
      //   0	13	21	java/io/IOException
      //   35	42	43	java/io/IOException
      //   0	13	45	finally
      //   22	35	45	finally
      //   13	20	55	java/io/IOException
      //   46	53	57	java/io/IOException
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\LocalSocketServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */