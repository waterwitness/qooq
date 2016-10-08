package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBuffer
  implements PooledByteBuffer
{
  @VisibleForTesting
  @GuardedBy("this")
  CloseableReference<NativeMemoryChunk> mBufRef;
  private final int mSize;
  
  public NativePooledByteBuffer(CloseableReference<NativeMemoryChunk> paramCloseableReference, int paramInt)
  {
    Preconditions.checkNotNull(paramCloseableReference);
    if ((paramInt >= 0) && (paramInt <= ((NativeMemoryChunk)paramCloseableReference.get()).getSize())) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mBufRef = paramCloseableReference.clone();
      this.mSize = paramInt;
      return;
    }
  }
  
  public void close()
  {
    try
    {
      CloseableReference.closeSafely(this.mBufRef);
      this.mBufRef = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void ensureValid()
  {
    try
    {
      if (isClosed()) {
        throw new PooledByteBuffer.ClosedException();
      }
    }
    finally {}
  }
  
  public long getNativePtr()
  {
    try
    {
      ensureValid();
      long l = ((NativeMemoryChunk)this.mBufRef.get()).getNativePtr();
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mBufRef	Lcom/facebook/common/references/CloseableReference;
    //   6: invokestatic 77	com/facebook/common/references/CloseableReference:isValid	(Lcom/facebook/common/references/CloseableReference;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +9 -> 20
    //   14: iconst_0
    //   15: istore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_2
    //   19: ireturn
    //   20: iconst_1
    //   21: istore_2
    //   22: goto -6 -> 16
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	NativePooledByteBuffer
    //   25	4	1	localObject	Object
    //   9	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	10	25	finally
  }
  
  /* Error */
  public byte read(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 71	com/facebook/imagepipeline/memory/NativePooledByteBuffer:ensureValid	()V
    //   9: iload_1
    //   10: iflt +47 -> 57
    //   13: iconst_1
    //   14: istore 4
    //   16: iload 4
    //   18: invokestatic 43	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   21: iload_1
    //   22: aload_0
    //   23: getfield 51	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mSize	I
    //   26: if_icmpge +37 -> 63
    //   29: iload 5
    //   31: istore 4
    //   33: iload 4
    //   35: invokestatic 43	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   38: aload_0
    //   39: getfield 49	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mBufRef	Lcom/facebook/common/references/CloseableReference;
    //   42: invokevirtual 33	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   45: checkcast 35	com/facebook/imagepipeline/memory/NativeMemoryChunk
    //   48: iload_1
    //   49: invokevirtual 81	com/facebook/imagepipeline/memory/NativeMemoryChunk:read	(I)B
    //   52: istore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_2
    //   56: ireturn
    //   57: iconst_0
    //   58: istore 4
    //   60: goto -44 -> 16
    //   63: iconst_0
    //   64: istore 4
    //   66: goto -33 -> 33
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	NativePooledByteBuffer
    //   0	74	1	paramInt	int
    //   52	4	2	b	byte
    //   69	4	3	localObject	Object
    //   14	51	4	bool1	boolean
    //   1	29	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	9	69	finally
    //   16	29	69	finally
    //   33	53	69	finally
  }
  
  /* Error */
  public void read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 71	com/facebook/imagepipeline/memory/NativePooledByteBuffer:ensureValid	()V
    //   6: iload_1
    //   7: iload 4
    //   9: iadd
    //   10: aload_0
    //   11: getfield 51	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mSize	I
    //   14: if_icmpgt +33 -> 47
    //   17: iconst_1
    //   18: istore 5
    //   20: iload 5
    //   22: invokestatic 43	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   25: aload_0
    //   26: getfield 49	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mBufRef	Lcom/facebook/common/references/CloseableReference;
    //   29: invokevirtual 33	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   32: checkcast 35	com/facebook/imagepipeline/memory/NativeMemoryChunk
    //   35: iload_1
    //   36: aload_2
    //   37: iload_3
    //   38: iload 4
    //   40: invokevirtual 85	com/facebook/imagepipeline/memory/NativeMemoryChunk:read	(I[BII)I
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: iconst_0
    //   48: istore 5
    //   50: goto -30 -> 20
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	NativePooledByteBuffer
    //   0	58	1	paramInt1	int
    //   0	58	2	paramArrayOfByte	byte[]
    //   0	58	3	paramInt2	int
    //   0	58	4	paramInt3	int
    //   18	31	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	53	finally
    //   20	44	53	finally
  }
  
  public int size()
  {
    try
    {
      ensureValid();
      int i = this.mSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\NativePooledByteBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */