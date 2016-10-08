package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

public class AsyncTimeout
  extends Timeout
{
  private static AsyncTimeout head;
  private boolean inQueue;
  private AsyncTimeout next;
  private long timeoutAt;
  
  /* Error */
  static AsyncTimeout awaitTimeout()
    throws InterruptedException
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	okio/AsyncTimeout:head	Lokio/AsyncTimeout;
    //   6: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc 2
    //   16: invokevirtual 36	java/lang/Object:wait	()V
    //   19: aconst_null
    //   20: astore_0
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokestatic 42	java/lang/System:nanoTime	()J
    //   30: invokespecial 46	okio/AsyncTimeout:remainingNanos	(J)J
    //   33: lstore_1
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: ifle +28 -> 65
    //   40: lload_1
    //   41: ldc2_w 47
    //   44: ldiv
    //   45: lstore_3
    //   46: ldc 2
    //   48: lload_3
    //   49: lload_1
    //   50: lload_3
    //   51: ldc2_w 47
    //   54: lmul
    //   55: lsub
    //   56: l2i
    //   57: invokevirtual 51	java/lang/Object:wait	(JI)V
    //   60: aconst_null
    //   61: astore_0
    //   62: goto -41 -> 21
    //   65: getstatic 29	okio/AsyncTimeout:head	Lokio/AsyncTimeout;
    //   68: aload_0
    //   69: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   72: putfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   80: goto -59 -> 21
    //   83: astore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	67	0	localAsyncTimeout	AsyncTimeout
    //   83	5	0	localObject	Object
    //   33	17	1	l1	long
    //   45	6	3	l2	long
    // Exception table:
    //   from	to	target	type
    //   3	10	83	finally
    //   14	19	83	finally
    //   26	34	83	finally
    //   40	60	83	finally
    //   65	80	83	finally
  }
  
  /* Error */
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	okio/AsyncTimeout:head	Lokio/AsyncTimeout;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +10 -> 18
    //   11: iconst_1
    //   12: istore_2
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: aload_1
    //   19: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   22: aload_0
    //   23: if_acmpne +21 -> 44
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   31: putfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   39: iconst_0
    //   40: istore_2
    //   41: goto -28 -> 13
    //   44: aload_1
    //   45: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   48: astore_1
    //   49: goto -42 -> 7
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramAsyncTimeout	AsyncTimeout
    //   6	43	1	localAsyncTimeout	AsyncTimeout
    //   12	29	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	52	finally
    //   18	39	52	finally
    //   44	49	52	finally
  }
  
  private long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }
  
  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (head == null)
        {
          head = new AsyncTimeout();
          new Watchdog().start();
        }
        long l = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          paramAsyncTimeout.timeoutAt = (Math.min(paramLong, paramAsyncTimeout.deadlineNanoTime() - l) + l);
          paramLong = paramAsyncTimeout.remainingNanos(l);
          localAsyncTimeout = head;
          if ((localAsyncTimeout.next != null) && (paramLong >= localAsyncTimeout.next.remainingNanos(l))) {
            break label175;
          }
          paramAsyncTimeout.next = localAsyncTimeout.next;
          localAsyncTimeout.next = paramAsyncTimeout;
          if (localAsyncTimeout == head) {
            AsyncTimeout.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          paramAsyncTimeout.timeoutAt = (l + paramLong);
          continue;
        }
        if (!paramBoolean) {
          break label167;
        }
      }
      finally {}
      paramAsyncTimeout.timeoutAt = paramAsyncTimeout.deadlineNanoTime();
      continue;
      label167:
      throw new AssertionError();
      label175:
      AsyncTimeout localAsyncTimeout = localAsyncTimeout.next;
    }
  }
  
  public final void enter()
  {
    if (this.inQueue) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = timeoutNanos();
    boolean bool = hasDeadline();
    if ((l == 0L) && (!bool)) {
      return;
    }
    this.inQueue = true;
    scheduleTimeout(this, l, bool);
  }
  
  final IOException exit(IOException paramIOException)
    throws IOException
  {
    if (!exit()) {
      return paramIOException;
    }
    return newTimeoutException(paramIOException);
  }
  
  final void exit(boolean paramBoolean)
    throws IOException
  {
    if ((exit()) && (paramBoolean)) {
      throw newTimeoutException(null);
    }
  }
  
  public final boolean exit()
  {
    if (!this.inQueue) {
      return false;
    }
    this.inQueue = false;
    return cancelScheduledTimeout(this);
  }
  
  protected IOException newTimeoutException(IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public final Sink sink(final Sink paramSink)
  {
    new Sink()
    {
      public void close()
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramSink.close();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
      
      public void flush()
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramSink.flush();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
      
      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }
      
      public String toString()
      {
        return "AsyncTimeout.sink(" + paramSink + ")";
      }
      
      public void write(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramSink.write(paramAnonymousBuffer, paramAnonymousLong);
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException paramAnonymousBuffer)
        {
          throw AsyncTimeout.this.exit(paramAnonymousBuffer);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
    };
  }
  
  public final Source source(final Source paramSource)
  {
    new Source()
    {
      public void close()
        throws IOException
      {
        try
        {
          paramSource.close();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
      
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramAnonymousLong = paramSource.read(paramAnonymousBuffer, paramAnonymousLong);
          AsyncTimeout.this.exit(true);
          return paramAnonymousLong;
        }
        catch (IOException paramAnonymousBuffer)
        {
          throw AsyncTimeout.this.exit(paramAnonymousBuffer);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
      
      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }
      
      public String toString()
      {
        return "AsyncTimeout.source(" + paramSource + ")";
      }
    };
  }
  
  protected void timedOut() {}
  
  private static final class Watchdog
    extends Thread
  {
    public Watchdog()
    {
      super();
      setDaemon(true);
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          AsyncTimeout localAsyncTimeout = AsyncTimeout.awaitTimeout();
          if (localAsyncTimeout != null) {
            localAsyncTimeout.timedOut();
          }
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\okio\AsyncTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */