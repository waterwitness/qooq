package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.protocol.module.Console.MessageLevel;
import com.facebook.stetho.inspector.protocol.module.Console.MessageSource;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class ResponseHandlingInputStream
  extends FilterInputStream
{
  private static final int BUFFER_SIZE = 1024;
  public static final String TAG = "ResponseHandlingInputStream";
  @GuardedBy("this")
  private boolean mClosed;
  @Nullable
  private final CountingOutputStream mDecompressedCounter;
  @GuardedBy("this")
  private boolean mEofSeen;
  private long mLastDecompressedCount = 0L;
  private final ChromePeerManager mNetworkPeerManager;
  private final OutputStream mOutputStream;
  private final String mRequestId;
  private final ResponseHandler mResponseHandler;
  @Nullable
  @GuardedBy("this")
  private byte[] mSkipBuffer;
  
  public ResponseHandlingInputStream(InputStream paramInputStream, String paramString, OutputStream paramOutputStream, @Nullable CountingOutputStream paramCountingOutputStream, ChromePeerManager paramChromePeerManager, ResponseHandler paramResponseHandler)
  {
    super(paramInputStream);
    this.mRequestId = paramString;
    this.mOutputStream = paramOutputStream;
    this.mDecompressedCounter = paramCountingOutputStream;
    this.mNetworkPeerManager = paramChromePeerManager;
    this.mResponseHandler = paramResponseHandler;
    this.mClosed = false;
  }
  
  private int checkEOF(int paramInt)
  {
    if (paramInt == -1) {}
    try
    {
      closeOutputStreamQuietly();
      this.mResponseHandler.onEOF();
      this.mEofSeen = true;
      return paramInt;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void closeOutputStreamQuietly()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mClosed	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +19 -> 27
    //   11: aload_0
    //   12: getfield 42	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mOutputStream	Ljava/io/OutputStream;
    //   15: invokevirtual 72	java/io/OutputStream:close	()V
    //   18: aload_0
    //   19: invokespecial 75	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:reportDecodedSizeIfApplicable	()V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 50	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mClosed	Z
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 46	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mNetworkPeerManager	Lcom/facebook/stetho/inspector/helper/ChromePeerManager;
    //   35: getstatic 81	com/facebook/stetho/inspector/protocol/module/Console$MessageLevel:ERROR	Lcom/facebook/stetho/inspector/protocol/module/Console$MessageLevel;
    //   38: getstatic 87	com/facebook/stetho/inspector/protocol/module/Console$MessageSource:NETWORK	Lcom/facebook/stetho/inspector/protocol/module/Console$MessageSource;
    //   41: new 89	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 91
    //   47: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 108	com/facebook/stetho/inspector/console/CLog:writeToConsole	(Lcom/facebook/stetho/inspector/helper/ChromePeerManager;Lcom/facebook/stetho/inspector/protocol/module/Console$MessageLevel;Lcom/facebook/stetho/inspector/protocol/module/Console$MessageSource;Ljava/lang/String;)V
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 50	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mClosed	Z
    //   65: goto -38 -> 27
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: iconst_1
    //   76: putfield 50	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mClosed	Z
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	ResponseHandlingInputStream
    //   30	21	1	localIOException	IOException
    //   68	4	1	localObject1	Object
    //   73	7	1	localObject2	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	22	30	java/io/IOException
    //   2	7	68	finally
    //   22	27	68	finally
    //   60	65	68	finally
    //   74	81	68	finally
    //   11	22	73	finally
    //   31	60	73	finally
  }
  
  @Nonnull
  private byte[] getSkipBufferLocked()
  {
    if (this.mSkipBuffer == null) {
      this.mSkipBuffer = new byte['Ѐ'];
    }
    return this.mSkipBuffer;
  }
  
  private IOException handleIOException(IOException paramIOException)
  {
    this.mResponseHandler.onError(paramIOException);
    return paramIOException;
  }
  
  private void handleIOExceptionWritingToStream(IOException paramIOException)
  {
    CLog.writeToConsole(this.mNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "Could not write response body to the stream " + paramIOException);
    closeOutputStreamQuietly();
  }
  
  private void reportDecodedSizeIfApplicable()
  {
    if (this.mDecompressedCounter != null)
    {
      long l = this.mDecompressedCounter.getCount();
      int i = (int)(l - this.mLastDecompressedCount);
      this.mResponseHandler.onReadDecoded(i);
      this.mLastDecompressedCount = l;
    }
  }
  
  /* Error */
  private void writeToOutputStream(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mClosed	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 42	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mOutputStream	Ljava/io/OutputStream;
    //   18: iload_1
    //   19: invokevirtual 137	java/io/OutputStream:write	(I)V
    //   22: aload_0
    //   23: invokespecial 75	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:reportDecodedSizeIfApplicable	()V
    //   26: goto -15 -> 11
    //   29: astore_2
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 139	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:handleIOExceptionWritingToStream	(Ljava/io/IOException;)V
    //   35: goto -24 -> 11
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ResponseHandlingInputStream
    //   0	43	1	paramInt	int
    //   29	3	2	localIOException	IOException
    //   38	4	2	localObject	Object
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   14	26	29	java/io/IOException
    //   2	7	38	finally
    //   14	26	38	finally
    //   30	35	38	finally
  }
  
  /* Error */
  private void writeToOutputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mClosed	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 42	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mOutputStream	Ljava/io/OutputStream;
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: invokevirtual 142	java/io/OutputStream:write	([BII)V
    //   26: aload_0
    //   27: invokespecial 75	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:reportDecodedSizeIfApplicable	()V
    //   30: goto -17 -> 13
    //   33: astore_1
    //   34: aload_0
    //   35: aload_1
    //   36: invokespecial 139	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:handleIOExceptionWritingToStream	(Ljava/io/IOException;)V
    //   39: goto -26 -> 13
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	ResponseHandlingInputStream
    //   0	47	1	paramArrayOfByte	byte[]
    //   0	47	2	paramInt1	int
    //   0	47	3	paramInt2	int
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   16	30	33	java/io/IOException
    //   2	8	42	finally
    //   16	30	42	finally
    //   34	39	42	finally
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: lload_3
    //   3: lstore 5
    //   5: aload_0
    //   6: getfield 65	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mEofSeen	Z
    //   9: ifne +23 -> 32
    //   12: sipush 1024
    //   15: newarray <illegal type>
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 146	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:read	([B)I
    //   23: istore_2
    //   24: iload_2
    //   25: iconst_m1
    //   26: if_icmpne +72 -> 98
    //   29: lload_3
    //   30: lstore 5
    //   32: lload 5
    //   34: lconst_0
    //   35: lcmp
    //   36: ifle +53 -> 89
    //   39: aload_0
    //   40: getfield 46	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mNetworkPeerManager	Lcom/facebook/stetho/inspector/helper/ChromePeerManager;
    //   43: getstatic 81	com/facebook/stetho/inspector/protocol/module/Console$MessageLevel:ERROR	Lcom/facebook/stetho/inspector/protocol/module/Console$MessageLevel;
    //   46: getstatic 87	com/facebook/stetho/inspector/protocol/module/Console$MessageSource:NETWORK	Lcom/facebook/stetho/inspector/protocol/module/Console$MessageSource;
    //   49: new 89	java/lang/StringBuilder
    //   52: dup
    //   53: ldc -108
    //   55: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: lload 5
    //   60: invokestatic 154	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   63: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc -97
    //   68: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc -95
    //   73: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: getfield 40	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:mRequestId	Ljava/lang/String;
    //   80: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 108	com/facebook/stetho/inspector/console/CLog:writeToConsole	(Lcom/facebook/stetho/inspector/helper/ChromePeerManager;Lcom/facebook/stetho/inspector/protocol/module/Console$MessageLevel;Lcom/facebook/stetho/inspector/protocol/module/Console$MessageSource;Ljava/lang/String;)V
    //   89: aload_0
    //   90: invokespecial 162	java/io/FilterInputStream:close	()V
    //   93: aload_0
    //   94: invokespecial 58	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:closeOutputStreamQuietly	()V
    //   97: return
    //   98: lload_3
    //   99: iload_2
    //   100: i2l
    //   101: ladd
    //   102: lstore_3
    //   103: goto -85 -> 18
    //   106: astore_1
    //   107: aload_0
    //   108: invokespecial 162	java/io/FilterInputStream:close	()V
    //   111: aload_0
    //   112: invokespecial 58	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:closeOutputStreamQuietly	()V
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ResponseHandlingInputStream
    //   17	3	1	arrayOfByte	byte[]
    //   106	10	1	localObject	Object
    //   23	77	2	i	int
    //   1	102	3	l1	long
    //   3	56	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   5	18	106	finally
    //   18	24	106	finally
    //   39	89	106	finally
  }
  
  public void mark(int paramInt) {}
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    try
    {
      int i = checkEOF(this.in.read());
      if (i != -1)
      {
        this.mResponseHandler.onRead(1);
        writeToOutputStream(i);
      }
      return i;
    }
    catch (IOException localIOException)
    {
      throw handleIOException(localIOException);
    }
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      paramInt2 = checkEOF(this.in.read(paramArrayOfByte, paramInt1, paramInt2));
      if (paramInt2 != -1)
      {
        this.mResponseHandler.onRead(paramInt2);
        writeToOutputStream(paramArrayOfByte, paramInt1, paramInt2);
      }
      return paramInt2;
    }
    catch (IOException paramArrayOfByte)
    {
      throw handleIOException(paramArrayOfByte);
    }
  }
  
  public void reset()
    throws IOException
  {
    throw new UnsupportedOperationException("Mark not supported");
  }
  
  /* Error */
  public long skip(long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 200	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:getSkipBufferLocked	()[B
    //   6: astore_3
    //   7: lconst_0
    //   8: lstore 5
    //   10: lload 5
    //   12: lload_1
    //   13: lcmp
    //   14: iflt +8 -> 22
    //   17: aload_0
    //   18: monitorexit
    //   19: lload 5
    //   21: lreturn
    //   22: aload_0
    //   23: aload_3
    //   24: iconst_0
    //   25: aload_3
    //   26: arraylength
    //   27: i2l
    //   28: lload_1
    //   29: lload 5
    //   31: lsub
    //   32: invokestatic 206	java/lang/Math:min	(JJ)J
    //   35: l2i
    //   36: invokevirtual 187	com/facebook/stetho/inspector/network/ResponseHandlingInputStream:read	([BII)I
    //   39: istore 4
    //   41: iload 4
    //   43: iconst_m1
    //   44: if_icmpeq -27 -> 17
    //   47: lload 5
    //   49: iload 4
    //   51: i2l
    //   52: ladd
    //   53: lstore 5
    //   55: goto -45 -> 10
    //   58: astore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_3
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	ResponseHandlingInputStream
    //   0	63	1	paramLong	long
    //   6	20	3	arrayOfByte	byte[]
    //   58	4	3	localObject	Object
    //   39	11	4	i	int
    //   8	46	5	l	long
    // Exception table:
    //   from	to	target	type
    //   2	7	58	finally
    //   22	41	58	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\ResponseHandlingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */