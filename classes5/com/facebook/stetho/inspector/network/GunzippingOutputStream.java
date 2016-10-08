package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

class GunzippingOutputStream
  extends FilterOutputStream
{
  private static final ExecutorService sExecutor = ;
  private final Future<Void> mCopyFuture;
  
  private GunzippingOutputStream(OutputStream paramOutputStream, Future<Void> paramFuture)
    throws IOException
  {
    super(paramOutputStream);
    this.mCopyFuture = paramFuture;
  }
  
  public static GunzippingOutputStream create(OutputStream paramOutputStream)
    throws IOException
  {
    PipedInputStream localPipedInputStream = new PipedInputStream();
    return new GunzippingOutputStream(new PipedOutputStream(localPipedInputStream), sExecutor.submit(new GunzippingCallable(localPipedInputStream, paramOutputStream)));
  }
  
  private static <T> T getAndRethrow(Future<T> paramFuture)
    throws IOException
  {
    for (;;)
    {
      try
      {
        Object localObject = paramFuture.get();
        return (T)localObject;
      }
      catch (ExecutionException localExecutionException)
      {
        Throwable localThrowable = localExecutionException.getCause();
        ExceptionUtil.propagateIfInstanceOf(localThrowable, IOException.class);
        ExceptionUtil.propagate(localThrowable);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 87	java/io/FilterOutputStream:close	()V
    //   4: aload_0
    //   5: getfield 32	com/facebook/stetho/inspector/network/GunzippingOutputStream:mCopyFuture	Ljava/util/concurrent/Future;
    //   8: invokestatic 89	com/facebook/stetho/inspector/network/GunzippingOutputStream:getAndRethrow	(Ljava/util/concurrent/Future;)Ljava/lang/Object;
    //   11: pop
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 32	com/facebook/stetho/inspector/network/GunzippingOutputStream:mCopyFuture	Ljava/util/concurrent/Future;
    //   18: invokestatic 89	com/facebook/stetho/inspector/network/GunzippingOutputStream:getAndRethrow	(Ljava/util/concurrent/Future;)Ljava/lang/Object;
    //   21: pop
    //   22: aload_1
    //   23: athrow
    //   24: astore_2
    //   25: iconst_0
    //   26: ifeq -4 -> 22
    //   29: aload_2
    //   30: athrow
    //   31: astore_1
    //   32: iconst_1
    //   33: ifeq -21 -> 12
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	GunzippingOutputStream
    //   13	10	1	localObject	Object
    //   31	6	1	localIOException1	IOException
    //   24	6	2	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   0	4	13	finally
    //   14	22	24	java/io/IOException
    //   4	12	31	java/io/IOException
  }
  
  private static class GunzippingCallable
    implements Callable<Void>
  {
    private final InputStream mIn;
    private final OutputStream mOut;
    
    public GunzippingCallable(InputStream paramInputStream, OutputStream paramOutputStream)
    {
      this.mIn = paramInputStream;
      this.mOut = paramOutputStream;
    }
    
    public Void call()
      throws IOException
    {
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(this.mIn);
      try
      {
        Util.copy(localGZIPInputStream, this.mOut, new byte['Ѐ']);
        return null;
      }
      finally
      {
        localGZIPInputStream.close();
        this.mOut.close();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\GunzippingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */