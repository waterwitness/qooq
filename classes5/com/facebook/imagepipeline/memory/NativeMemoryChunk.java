package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.soloader.SoLoaderShim;
import java.io.Closeable;

@DoNotStrip
public class NativeMemoryChunk
  implements Closeable
{
  private static final String TAG = "NativeMemoryChunk";
  private boolean mClosed;
  private final long mNativePtr;
  private final int mSize;
  
  static
  {
    SoLoaderShim.loadLibrary("memchunk");
  }
  
  @VisibleForTesting
  public NativeMemoryChunk()
  {
    this.mSize = 0;
    this.mNativePtr = 0L;
    this.mClosed = true;
  }
  
  public NativeMemoryChunk(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mSize = paramInt;
      this.mNativePtr = nativeAllocate(this.mSize);
      this.mClosed = false;
      return;
    }
  }
  
  private int adjustByteCount(int paramInt1, int paramInt2)
  {
    return Math.min(Math.max(0, this.mSize - paramInt1), paramInt2);
  }
  
  private void checkBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    if (paramInt4 >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt1 < 0) {
        break label83;
      }
      bool1 = true;
      label23:
      Preconditions.checkArgument(bool1);
      if (paramInt3 < 0) {
        break label89;
      }
      bool1 = true;
      label35:
      Preconditions.checkArgument(bool1);
      if (paramInt1 + paramInt4 > this.mSize) {
        break label95;
      }
      bool1 = true;
      label54:
      Preconditions.checkArgument(bool1);
      if (paramInt3 + paramInt4 > paramInt2) {
        break label101;
      }
    }
    label83:
    label89:
    label95:
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label23;
      bool1 = false;
      break label35;
      bool1 = false;
      break label54;
    }
  }
  
  private void doCopy(int paramInt1, NativeMemoryChunk paramNativeMemoryChunk, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    if (isClosed())
    {
      bool1 = false;
      Preconditions.checkState(bool1);
      if (!paramNativeMemoryChunk.isClosed()) {
        break label72;
      }
    }
    label72:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      Preconditions.checkState(bool1);
      checkBounds(paramInt1, paramNativeMemoryChunk.mSize, paramInt2, paramInt3);
      nativeMemcpy(paramNativeMemoryChunk.mNativePtr + paramInt2, this.mNativePtr + paramInt1, paramInt3);
      return;
      bool1 = true;
      break;
    }
  }
  
  @DoNotStrip
  private static native long nativeAllocate(int paramInt);
  
  @DoNotStrip
  private static native void nativeCopyFromByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @DoNotStrip
  private static native void nativeCopyToByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @DoNotStrip
  private static native void nativeFree(long paramLong);
  
  @DoNotStrip
  private static native void nativeMemcpy(long paramLong1, long paramLong2, int paramInt);
  
  @DoNotStrip
  private static native byte nativeReadByte(long paramLong);
  
  public void close()
  {
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        nativeFree(this.mNativePtr);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void copy(int paramInt1, NativeMemoryChunk paramNativeMemoryChunk, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 92	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: getfield 36	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   9: aload_0
    //   10: getfield 36	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   13: lcmp
    //   14: ifne +65 -> 79
    //   17: ldc 11
    //   19: new 94	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 96
    //   25: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokestatic 104	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   32: invokestatic 110	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   35: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 116
    //   40: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: invokestatic 104	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   47: invokestatic 110	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   50: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 118
    //   55: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 36	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   62: invokestatic 123	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   65: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 133	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: iconst_0
    //   76: invokestatic 46	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   79: aload_2
    //   80: getfield 36	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   83: aload_0
    //   84: getfield 36	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   87: lcmp
    //   88: ifge +35 -> 123
    //   91: aload_2
    //   92: monitorenter
    //   93: aload_0
    //   94: monitorenter
    //   95: aload_0
    //   96: iload_1
    //   97: aload_2
    //   98: iload_3
    //   99: iload 4
    //   101: invokespecial 135	com/facebook/imagepipeline/memory/NativeMemoryChunk:doCopy	(ILcom/facebook/imagepipeline/memory/NativeMemoryChunk;II)V
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_2
    //   107: monitorexit
    //   108: return
    //   109: astore 5
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 5
    //   115: athrow
    //   116: astore 5
    //   118: aload_2
    //   119: monitorexit
    //   120: aload 5
    //   122: athrow
    //   123: aload_0
    //   124: monitorenter
    //   125: aload_2
    //   126: monitorenter
    //   127: aload_0
    //   128: iload_1
    //   129: aload_2
    //   130: iload_3
    //   131: iload 4
    //   133: invokespecial 135	com/facebook/imagepipeline/memory/NativeMemoryChunk:doCopy	(ILcom/facebook/imagepipeline/memory/NativeMemoryChunk;II)V
    //   136: aload_2
    //   137: monitorexit
    //   138: aload_0
    //   139: monitorexit
    //   140: return
    //   141: astore_2
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: astore 5
    //   148: aload_2
    //   149: monitorexit
    //   150: aload 5
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	NativeMemoryChunk
    //   0	153	1	paramInt1	int
    //   0	153	2	paramNativeMemoryChunk	NativeMemoryChunk
    //   0	153	3	paramInt2	int
    //   0	153	4	paramInt3	int
    //   109	5	5	localObject1	Object
    //   116	5	5	localObject2	Object
    //   146	5	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   95	106	109	finally
    //   111	113	109	finally
    //   93	95	116	finally
    //   106	108	116	finally
    //   113	116	116	finally
    //   118	120	116	finally
    //   125	127	141	finally
    //   138	140	141	finally
    //   142	144	141	finally
    //   150	153	141	finally
    //   127	138	146	finally
    //   148	150	146	finally
  }
  
  protected void finalize()
    throws Throwable
  {
    if (isClosed()) {
      return;
    }
    Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.mNativePtr));
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public long getNativePtr()
  {
    return this.mNativePtr;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
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
    //   6: invokevirtual 68	com/facebook/imagepipeline/memory/NativeMemoryChunk:isClosed	()Z
    //   9: ifeq +55 -> 64
    //   12: iconst_0
    //   13: istore 4
    //   15: iload 4
    //   17: invokestatic 71	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   20: iload_1
    //   21: iflt +49 -> 70
    //   24: iconst_1
    //   25: istore 4
    //   27: iload 4
    //   29: invokestatic 46	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   32: iload_1
    //   33: aload_0
    //   34: getfield 34	com/facebook/imagepipeline/memory/NativeMemoryChunk:mSize	I
    //   37: if_icmpge +39 -> 76
    //   40: iload 5
    //   42: istore 4
    //   44: iload 4
    //   46: invokestatic 46	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   49: aload_0
    //   50: getfield 36	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   53: iload_1
    //   54: i2l
    //   55: ladd
    //   56: invokestatic 155	com/facebook/imagepipeline/memory/NativeMemoryChunk:nativeReadByte	(J)B
    //   59: istore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_2
    //   63: ireturn
    //   64: iconst_1
    //   65: istore 4
    //   67: goto -52 -> 15
    //   70: iconst_0
    //   71: istore 4
    //   73: goto -46 -> 27
    //   76: iconst_0
    //   77: istore 4
    //   79: goto -35 -> 44
    //   82: astore_3
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_3
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	NativeMemoryChunk
    //   0	87	1	paramInt	int
    //   59	4	2	b	byte
    //   82	4	3	localObject	Object
    //   13	65	4	bool1	boolean
    //   1	40	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	82	finally
    //   15	20	82	finally
    //   27	40	82	finally
    //   44	60	82	finally
  }
  
  /* Error */
  public int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 92	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: invokevirtual 68	com/facebook/imagepipeline/memory/NativeMemoryChunk:isClosed	()Z
    //   11: ifeq +49 -> 60
    //   14: iconst_0
    //   15: istore 5
    //   17: iload 5
    //   19: invokestatic 71	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   22: aload_0
    //   23: iload_1
    //   24: iload 4
    //   26: invokespecial 158	com/facebook/imagepipeline/memory/NativeMemoryChunk:adjustByteCount	(II)I
    //   29: istore 4
    //   31: aload_0
    //   32: iload_1
    //   33: aload_2
    //   34: arraylength
    //   35: iload_3
    //   36: iload 4
    //   38: invokespecial 73	com/facebook/imagepipeline/memory/NativeMemoryChunk:checkBounds	(IIII)V
    //   41: aload_0
    //   42: getfield 36	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   45: iload_1
    //   46: i2l
    //   47: ladd
    //   48: aload_2
    //   49: iload_3
    //   50: iload 4
    //   52: invokestatic 160	com/facebook/imagepipeline/memory/NativeMemoryChunk:nativeCopyToByteArray	(J[BII)V
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_1
    //   61: istore 5
    //   63: goto -46 -> 17
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	NativeMemoryChunk
    //   0	71	1	paramInt1	int
    //   0	71	2	paramArrayOfByte	byte[]
    //   0	71	3	paramInt2	int
    //   0	71	4	paramInt3	int
    //   15	47	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	66	finally
    //   17	55	66	finally
  }
  
  /* Error */
  public int write(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 92	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: invokevirtual 68	com/facebook/imagepipeline/memory/NativeMemoryChunk:isClosed	()Z
    //   11: ifeq +49 -> 60
    //   14: iconst_0
    //   15: istore 5
    //   17: iload 5
    //   19: invokestatic 71	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   22: aload_0
    //   23: iload_1
    //   24: iload 4
    //   26: invokespecial 158	com/facebook/imagepipeline/memory/NativeMemoryChunk:adjustByteCount	(II)I
    //   29: istore 4
    //   31: aload_0
    //   32: iload_1
    //   33: aload_2
    //   34: arraylength
    //   35: iload_3
    //   36: iload 4
    //   38: invokespecial 73	com/facebook/imagepipeline/memory/NativeMemoryChunk:checkBounds	(IIII)V
    //   41: aload_0
    //   42: getfield 36	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   45: iload_1
    //   46: i2l
    //   47: ladd
    //   48: aload_2
    //   49: iload_3
    //   50: iload 4
    //   52: invokestatic 163	com/facebook/imagepipeline/memory/NativeMemoryChunk:nativeCopyFromByteArray	(J[BII)V
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_1
    //   61: istore 5
    //   63: goto -46 -> 17
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	NativeMemoryChunk
    //   0	71	1	paramInt1	int
    //   0	71	2	paramArrayOfByte	byte[]
    //   0	71	3	paramInt2	int
    //   0	71	4	paramInt3	int
    //   15	47	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	66	finally
    //   17	55	66	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\NativeMemoryChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */