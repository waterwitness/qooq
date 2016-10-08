package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PooledByteStreams
{
  private static final int DEFAULT_TEMP_BUF_SIZE = 16384;
  private final ByteArrayPool mByteArrayPool;
  private final int mTempBufSize;
  
  public PooledByteStreams(ByteArrayPool paramByteArrayPool)
  {
    this(paramByteArrayPool, 16384);
  }
  
  @VisibleForTesting
  PooledByteStreams(ByteArrayPool paramByteArrayPool, int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mTempBufSize = paramInt;
      this.mByteArrayPool = paramByteArrayPool;
      return;
    }
  }
  
  /* Error */
  public long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: aload_0
    //   4: getfield 30	com/facebook/imagepipeline/memory/PooledByteStreams:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   7: aload_0
    //   8: getfield 28	com/facebook/imagepipeline/memory/PooledByteStreams:mTempBufSize	I
    //   11: invokeinterface 41 2 0
    //   16: checkcast 43	[B
    //   19: astore_3
    //   20: aload_1
    //   21: aload_3
    //   22: iconst_0
    //   23: aload_0
    //   24: getfield 28	com/facebook/imagepipeline/memory/PooledByteStreams:mTempBufSize	I
    //   27: invokevirtual 49	java/io/InputStream:read	([BII)I
    //   30: istore 4
    //   32: iload 4
    //   34: iconst_m1
    //   35: if_icmpne +16 -> 51
    //   38: aload_0
    //   39: getfield 30	com/facebook/imagepipeline/memory/PooledByteStreams:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   42: aload_3
    //   43: invokeinterface 53 2 0
    //   48: lload 5
    //   50: lreturn
    //   51: aload_2
    //   52: aload_3
    //   53: iconst_0
    //   54: iload 4
    //   56: invokevirtual 59	java/io/OutputStream:write	([BII)V
    //   59: lload 5
    //   61: iload 4
    //   63: i2l
    //   64: ladd
    //   65: lstore 5
    //   67: goto -47 -> 20
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 30	com/facebook/imagepipeline/memory/PooledByteStreams:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   75: aload_3
    //   76: invokeinterface 53 2 0
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	PooledByteStreams
    //   0	83	1	paramInputStream	InputStream
    //   0	83	2	paramOutputStream	OutputStream
    //   19	57	3	arrayOfByte	byte[]
    //   30	32	4	i	int
    //   1	65	5	l	long
    // Exception table:
    //   from	to	target	type
    //   20	32	70	finally
    //   51	59	70	finally
  }
  
  public long copy(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    boolean bool = false;
    if (paramLong > 0L) {
      bool = true;
    }
    Preconditions.checkState(bool);
    long l = 0L;
    byte[] arrayOfByte = (byte[])this.mByteArrayPool.get(this.mTempBufSize);
    for (;;)
    {
      if (l >= paramLong)
      {
        this.mByteArrayPool.release(arrayOfByte);
        return l;
      }
      try
      {
        int i = paramInputStream.read(arrayOfByte, 0, (int)Math.min(this.mTempBufSize, paramLong - l));
        if (i == -1) {
          return l;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        l += i;
      }
      finally
      {
        this.mByteArrayPool.release(arrayOfByte);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\PooledByteStreams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */