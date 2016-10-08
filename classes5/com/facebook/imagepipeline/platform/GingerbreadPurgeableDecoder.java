package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;

public class GingerbreadPurgeableDecoder
  extends DalvikPurgeableDecoder
{
  private static Method sGetFileDescriptorMethod;
  
  /* Error */
  private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, @javax.annotation.Nullable byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +124 -> 125
    //   4: iconst_0
    //   5: istore 9
    //   7: new 18	android/os/MemoryFile
    //   10: dup
    //   11: aconst_null
    //   12: iload_1
    //   13: iload 9
    //   15: iadd
    //   16: invokespecial 21	android/os/MemoryFile:<init>	(Ljava/lang/String;I)V
    //   19: astore 8
    //   21: aload 8
    //   23: iconst_0
    //   24: invokevirtual 25	android/os/MemoryFile:allowPurging	(Z)Z
    //   27: pop
    //   28: aconst_null
    //   29: astore 7
    //   31: aconst_null
    //   32: astore 6
    //   34: aconst_null
    //   35: astore_3
    //   36: aconst_null
    //   37: astore 5
    //   39: new 27	com/facebook/imagepipeline/memory/PooledByteBufferInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokevirtual 33	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   47: checkcast 35	com/facebook/imagepipeline/memory/PooledByteBuffer
    //   50: invokespecial 38	com/facebook/imagepipeline/memory/PooledByteBufferInputStream:<init>	(Lcom/facebook/imagepipeline/memory/PooledByteBuffer;)V
    //   53: astore 4
    //   55: new 40	com/facebook/common/streams/LimitedInputStream
    //   58: dup
    //   59: aload 4
    //   61: iload_1
    //   62: invokespecial 43	com/facebook/common/streams/LimitedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   65: astore 7
    //   67: aload 8
    //   69: invokevirtual 47	android/os/MemoryFile:getOutputStream	()Ljava/io/OutputStream;
    //   72: astore 5
    //   74: aload 5
    //   76: astore_3
    //   77: aload 7
    //   79: aload 5
    //   81: invokestatic 53	com/facebook/common/internal/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   84: pop2
    //   85: aload_2
    //   86: ifnull +16 -> 102
    //   89: aload 5
    //   91: astore_3
    //   92: aload 8
    //   94: aload_2
    //   95: iconst_0
    //   96: iload_1
    //   97: aload_2
    //   98: arraylength
    //   99: invokevirtual 57	android/os/MemoryFile:writeBytes	([BIII)V
    //   102: aload_0
    //   103: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   106: aload 4
    //   108: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   111: aload 7
    //   113: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   116: aload 5
    //   118: iconst_1
    //   119: invokestatic 71	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   122: aload 8
    //   124: areturn
    //   125: aload_2
    //   126: arraylength
    //   127: istore 9
    //   129: goto -122 -> 7
    //   132: astore_3
    //   133: aload 7
    //   135: astore_2
    //   136: aload 6
    //   138: astore 4
    //   140: aload_0
    //   141: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   144: aload_2
    //   145: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   148: aload 4
    //   150: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   153: aload 5
    //   155: iconst_1
    //   156: invokestatic 71	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   159: aload_3
    //   160: athrow
    //   161: astore_3
    //   162: aload 4
    //   164: astore_2
    //   165: aload 6
    //   167: astore 4
    //   169: goto -29 -> 140
    //   172: astore 6
    //   174: aload 7
    //   176: astore 5
    //   178: aload 4
    //   180: astore_2
    //   181: aload 5
    //   183: astore 4
    //   185: aload_3
    //   186: astore 5
    //   188: aload 6
    //   190: astore_3
    //   191: goto -51 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramCloseableReference	CloseableReference<PooledByteBuffer>
    //   0	194	1	paramInt	int
    //   0	194	2	paramArrayOfByte	byte[]
    //   35	57	3	localObject1	Object
    //   132	28	3	localObject2	Object
    //   161	25	3	localObject3	Object
    //   190	1	3	localObject4	Object
    //   53	131	4	localObject5	Object
    //   37	150	5	localObject6	Object
    //   32	134	6	localObject7	Object
    //   172	17	6	localObject8	Object
    //   29	146	7	localLimitedInputStream	com.facebook.common.streams.LimitedInputStream
    //   19	104	8	localMemoryFile	MemoryFile
    //   5	123	9	i	int
    // Exception table:
    //   from	to	target	type
    //   39	55	132	finally
    //   55	67	161	finally
    //   67	74	172	finally
    //   77	85	172	finally
    //   92	102	172	finally
  }
  
  /* Error */
  private Method getFileDescriptorMethod()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 81	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:sGetFileDescriptorMethod	Ljava/lang/reflect/Method;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +17 -> 24
    //   10: ldc 18
    //   12: ldc 83
    //   14: iconst_0
    //   15: anewarray 85	java/lang/Class
    //   18: invokevirtual 89	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   21: putstatic 81	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:sGetFileDescriptorMethod	Ljava/lang/reflect/Method;
    //   24: getstatic 81	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:sGetFileDescriptorMethod	Ljava/lang/reflect/Method;
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 95	com/facebook/common/internal/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   37: athrow
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	GingerbreadPurgeableDecoder
    //   5	26	1	localMethod	Method
    //   32	2	1	localException	Exception
    //   38	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	24	32	java/lang/Exception
    //   2	6	38	finally
    //   10	24	38	finally
    //   24	28	38	finally
    //   33	38	38	finally
  }
  
  private FileDescriptor getMemoryFileDescriptor(MemoryFile paramMemoryFile)
  {
    try
    {
      paramMemoryFile = (FileDescriptor)getFileDescriptorMethod().invoke(paramMemoryFile, new Object[0]);
      return paramMemoryFile;
    }
    catch (Exception paramMemoryFile)
    {
      throw Throwables.propagate(paramMemoryFile);
    }
  }
  
  protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions)
  {
    return decodeFileDescriptorAsPurgeable(paramCloseableReference, ((PooledByteBuffer)paramCloseableReference.get()).size(), null, paramOptions);
  }
  
  protected Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    Object localObject = null;
    CloseableReference<PooledByteBuffer> localCloseableReference = null;
    try
    {
      paramCloseableReference = copyToMemoryFile(paramCloseableReference, paramInt, paramArrayOfByte);
      localCloseableReference = paramCloseableReference;
      localObject = paramCloseableReference;
      paramArrayOfByte = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeFileDescriptor(getMemoryFileDescriptor(paramCloseableReference), null, paramOptions), "BitmapFactory returned null");
      if (paramCloseableReference != null) {
        paramCloseableReference.close();
      }
      return paramArrayOfByte;
    }
    catch (IOException paramCloseableReference)
    {
      localObject = localCloseableReference;
      throw Throwables.propagate(paramCloseableReference);
    }
    finally
    {
      if (localObject != null) {
        ((MemoryFile)localObject).close();
      }
    }
  }
  
  protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions)
  {
    if (endsWithEOI(paramCloseableReference, paramInt)) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = EOI) {
      return decodeFileDescriptorAsPurgeable(paramCloseableReference, paramInt, arrayOfByte, paramOptions);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\platform\GingerbreadPurgeableDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */