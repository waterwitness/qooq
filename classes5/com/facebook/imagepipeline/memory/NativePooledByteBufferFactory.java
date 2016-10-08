package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBufferFactory
  implements PooledByteBufferFactory
{
  private final NativeMemoryChunkPool mPool;
  private final PooledByteStreams mPooledByteStreams;
  
  public NativePooledByteBufferFactory(NativeMemoryChunkPool paramNativeMemoryChunkPool, PooledByteStreams paramPooledByteStreams)
  {
    this.mPool = paramNativeMemoryChunkPool;
    this.mPooledByteStreams = paramPooledByteStreams;
  }
  
  @VisibleForTesting
  NativePooledByteBuffer newByteBuf(InputStream paramInputStream, NativePooledByteBufferOutputStream paramNativePooledByteBufferOutputStream)
    throws IOException
  {
    this.mPooledByteStreams.copy(paramInputStream, paramNativePooledByteBufferOutputStream);
    return paramNativePooledByteBufferOutputStream.toByteBuffer();
  }
  
  /* Error */
  public NativePooledByteBuffer newByteBuffer(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifle +46 -> 47
    //   4: iconst_1
    //   5: istore 4
    //   7: iload 4
    //   9: invokestatic 48	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   12: aload_0
    //   13: getfield 18	com/facebook/imagepipeline/memory/NativePooledByteBufferFactory:mPool	Lcom/facebook/imagepipeline/memory/NativeMemoryChunkPool;
    //   16: iload_1
    //   17: invokevirtual 54	com/facebook/imagepipeline/memory/NativeMemoryChunkPool:get	(I)Ljava/lang/Object;
    //   20: checkcast 56	com/facebook/imagepipeline/memory/NativeMemoryChunk
    //   23: aload_0
    //   24: getfield 18	com/facebook/imagepipeline/memory/NativePooledByteBufferFactory:mPool	Lcom/facebook/imagepipeline/memory/NativeMemoryChunkPool;
    //   27: invokestatic 62	com/facebook/common/references/CloseableReference:of	(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)Lcom/facebook/common/references/CloseableReference;
    //   30: astore_2
    //   31: new 64	com/facebook/imagepipeline/memory/NativePooledByteBuffer
    //   34: dup
    //   35: aload_2
    //   36: iload_1
    //   37: invokespecial 67	com/facebook/imagepipeline/memory/NativePooledByteBuffer:<init>	(Lcom/facebook/common/references/CloseableReference;I)V
    //   40: astore_3
    //   41: aload_2
    //   42: invokevirtual 70	com/facebook/common/references/CloseableReference:close	()V
    //   45: aload_3
    //   46: areturn
    //   47: iconst_0
    //   48: istore 4
    //   50: goto -43 -> 7
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 70	com/facebook/common/references/CloseableReference:close	()V
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	NativePooledByteBufferFactory
    //   0	60	1	paramInt	int
    //   30	25	2	localCloseableReference	com.facebook.common.references.CloseableReference
    //   40	6	3	localNativePooledByteBuffer	NativePooledByteBuffer
    //   53	6	3	localObject	Object
    //   5	44	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   31	41	53	finally
  }
  
  public NativePooledByteBuffer newByteBuffer(InputStream paramInputStream)
    throws IOException
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool);
    try
    {
      paramInputStream = newByteBuf(paramInputStream, localNativePooledByteBufferOutputStream);
      return paramInputStream;
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }
  
  public NativePooledByteBuffer newByteBuffer(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool, paramInt);
    try
    {
      paramInputStream = newByteBuf(paramInputStream, localNativePooledByteBufferOutputStream);
      return paramInputStream;
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }
  
  public NativePooledByteBuffer newByteBuffer(byte[] paramArrayOfByte)
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool, paramArrayOfByte.length);
    try
    {
      localNativePooledByteBufferOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localNativePooledByteBufferOutputStream.toByteBuffer();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw Throwables.propagate(paramArrayOfByte);
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }
  
  public NativePooledByteBufferOutputStream newOutputStream()
  {
    return new NativePooledByteBufferOutputStream(this.mPool);
  }
  
  public NativePooledByteBufferOutputStream newOutputStream(int paramInt)
  {
    return new NativePooledByteBufferOutputStream(this.mPool, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\NativePooledByteBufferFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */