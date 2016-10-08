package com.squareup.okhttp.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream
{
  long bytesLeftInWriteWindow;
  private final FramedConnection connection;
  private ErrorCode errorCode = null;
  private final int id;
  private final StreamTimeout readTimeout = new StreamTimeout();
  private final List<Header> requestHeaders;
  private List<Header> responseHeaders;
  final FramedDataSink sink;
  private final FramedDataSource source;
  long unacknowledgedBytesRead = 0L;
  private final StreamTimeout writeTimeout = new StreamTimeout();
  
  static
  {
    if (!FramedStream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  FramedStream(int paramInt, FramedConnection paramFramedConnection, boolean paramBoolean1, boolean paramBoolean2, List<Header> paramList)
  {
    if (paramFramedConnection == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.id = paramInt;
    this.connection = paramFramedConnection;
    this.bytesLeftInWriteWindow = paramFramedConnection.peerSettings.getInitialWindowSize(65536);
    this.source = new FramedDataSource(paramFramedConnection.okHttpSettings.getInitialWindowSize(65536), null);
    this.sink = new FramedDataSink();
    this.source.finished = paramBoolean2;
    this.sink.finished = paramBoolean1;
    this.requestHeaders = paramList;
  }
  
  private void cancelStreamIfNecessary()
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.source.finished) && (this.source.closed))
        {
          if (this.sink.finished) {
            break label112;
          }
          if (this.sink.closed)
          {
            break label112;
            bool = isOpen();
            if (i == 0) {
              break label95;
            }
            close(ErrorCode.CANCEL);
            return;
          }
        }
        i = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.connection.removeStream(this.id);
      return;
      label112:
      int i = 1;
    }
  }
  
  private void checkOutNotClosed()
    throws IOException
  {
    if (this.sink.closed) {
      throw new IOException("stream closed");
    }
    if (this.sink.finished) {
      throw new IOException("stream finished");
    }
    if (this.errorCode != null) {
      throw new IOException("stream was reset: " + this.errorCode);
    }
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    assert (!Thread.holdsLock(this));
    try
    {
      if (this.errorCode != null) {
        return false;
      }
      if ((this.source.finished) && (this.sink.finished)) {
        return false;
      }
    }
    finally {}
    this.errorCode = paramErrorCode;
    notifyAll();
    this.connection.removeStream(this.id);
    return true;
  }
  
  private void waitForIo()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InterruptedIOException();
    }
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void close(ErrorCode paramErrorCode)
    throws IOException
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynReset(this.id, paramErrorCode);
  }
  
  public void closeLater(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }
  
  public FramedConnection getConnection()
  {
    return this.connection;
  }
  
  public ErrorCode getErrorCode()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public List<Header> getRequestHeaders()
  {
    return this.requestHeaders;
  }
  
  public List<Header> getResponseHeaders()
    throws IOException
  {
    try
    {
      this.readTimeout.enter();
      try
      {
        for (;;)
        {
          Object localObject1;
          if (this.responseHeaders == null)
          {
            localObject1 = this.errorCode;
            if (localObject1 == null) {}
          }
          else
          {
            this.readTimeout.exitAndThrowIfTimedOut();
            if (this.responseHeaders == null) {
              break;
            }
            localObject1 = this.responseHeaders;
            return (List<Header>)localObject1;
          }
          waitForIo();
        }
        localObject3 = finally;
      }
      finally
      {
        this.readTimeout.exitAndThrowIfTimedOut();
      }
      throw new IOException("stream was reset: " + this.errorCode);
    }
    finally {}
  }
  
  public Sink getSink()
  {
    try
    {
      if ((this.responseHeaders == null) && (!isLocallyInitiated())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.sink;
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isLocallyInitiated()
  {
    if ((this.id & 0x1) == 1) {}
    for (int i = 1; this.connection.client == i; i = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public boolean isOpen()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 61	com/squareup/okhttp/internal/framed/FramedStream:errorCode	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 97	com/squareup/okhttp/internal/framed/FramedStream:source	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   21: invokestatic 148	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:access$2	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 97	com/squareup/okhttp/internal/framed/FramedStream:source	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   31: invokestatic 150	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:access$3	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 100	com/squareup/okhttp/internal/framed/FramedStream:sink	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   41: invokestatic 153	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:access$1	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 100	com/squareup/okhttp/internal/framed/FramedStream:sink	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   51: invokestatic 155	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:access$2	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 227	com/squareup/okhttp/internal/framed/FramedStream:responseHeaders	Ljava/util/List;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnonnull -50 -> 13
    //   66: iconst_1
    //   67: istore_2
    //   68: goto -55 -> 13
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	FramedStream
    //   8	55	1	localObject1	Object
    //   71	4	1	localObject2	Object
    //   1	67	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public Timeout readTimeout()
  {
    return this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin()
  {
    assert (!Thread.holdsLock(this));
    try
    {
      this.source.finished = true;
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveHeaders(List<Header> paramList, HeadersMode paramHeadersMode)
  {
    assert (!Thread.holdsLock(this));
    Object localObject = null;
    boolean bool = true;
    label97:
    do
    {
      for (;;)
      {
        try
        {
          if (this.responseHeaders == null)
          {
            if (paramHeadersMode.failIfHeadersAbsent())
            {
              paramList = ErrorCode.PROTOCOL_ERROR;
              if (paramList == null) {
                break;
              }
              closeLater(paramList);
              return;
            }
            this.responseHeaders = paramList;
            bool = isOpen();
            notifyAll();
            paramList = (List<Header>)localObject;
            continue;
          }
          if (!paramHeadersMode.failIfHeadersPresent()) {
            break label97;
          }
        }
        finally {}
        paramList = ErrorCode.STREAM_IN_USE;
        continue;
        paramHeadersMode = new ArrayList();
        paramHeadersMode.addAll(this.responseHeaders);
        paramHeadersMode.addAll(paramList);
        this.responseHeaders = paramHeadersMode;
        paramList = (List<Header>)localObject;
      }
    } while (bool);
    this.connection.removeStream(this.id);
  }
  
  void receiveRstStream(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public void reply(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    boolean bool = false;
    if (paramList == null) {
      try
      {
        throw new NullPointerException("responseHeaders == null");
      }
      finally {}
    }
    if (this.responseHeaders != null) {
      throw new IllegalStateException("reply already sent");
    }
    this.responseHeaders = paramList;
    if (!paramBoolean)
    {
      this.sink.finished = true;
      bool = true;
    }
    this.connection.writeSynReply(this.id, bool, paramList);
    if (bool) {
      this.connection.flush();
    }
  }
  
  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }
  
  final class FramedDataSink
    implements Sink
  {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    private boolean closed;
    private boolean finished;
    private final Buffer sendBuffer = new Buffer();
    
    static
    {
      if (!FramedStream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    FramedDataSink() {}
    
    /* Error */
    private void emitDataFrame(boolean paramBoolean)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   4: astore_2
      //   5: aload_2
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   11: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$6	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   14: invokevirtual 65	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
      //   17: aload_0
      //   18: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   21: getfield 68	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
      //   24: lconst_0
      //   25: lcmp
      //   26: ifgt +29 -> 55
      //   29: aload_0
      //   30: getfield 47	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:finished	Z
      //   33: ifne +22 -> 55
      //   36: aload_0
      //   37: getfield 52	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:closed	Z
      //   40: ifne +15 -> 55
      //   43: aload_0
      //   44: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   47: invokestatic 72	com/squareup/okhttp/internal/framed/FramedStream:access$3	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   50: astore_3
      //   51: aload_3
      //   52: ifnull +127 -> 179
      //   55: aload_0
      //   56: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   59: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$6	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   62: invokevirtual 75	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   65: aload_0
      //   66: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   69: invokestatic 78	com/squareup/okhttp/internal/framed/FramedStream:access$7	(Lcom/squareup/okhttp/internal/framed/FramedStream;)V
      //   72: aload_0
      //   73: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   76: getfield 68	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
      //   79: aload_0
      //   80: getfield 43	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
      //   83: invokevirtual 82	okio/Buffer:size	()J
      //   86: invokestatic 88	java/lang/Math:min	(JJ)J
      //   89: lstore 5
      //   91: aload_0
      //   92: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   95: astore_3
      //   96: aload_3
      //   97: aload_3
      //   98: getfield 68	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
      //   101: lload 5
      //   103: lsub
      //   104: putfield 68	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
      //   107: aload_2
      //   108: monitorexit
      //   109: aload_0
      //   110: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   113: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$6	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   116: invokevirtual 65	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
      //   119: aload_0
      //   120: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   123: invokestatic 91	com/squareup/okhttp/internal/framed/FramedStream:access$0	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   126: astore_2
      //   127: aload_0
      //   128: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   131: invokestatic 94	com/squareup/okhttp/internal/framed/FramedStream:access$1	(Lcom/squareup/okhttp/internal/framed/FramedStream;)I
      //   134: istore 4
      //   136: iload_1
      //   137: ifeq +70 -> 207
      //   140: lload 5
      //   142: aload_0
      //   143: getfield 43	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
      //   146: invokevirtual 82	okio/Buffer:size	()J
      //   149: lcmp
      //   150: ifne +57 -> 207
      //   153: iconst_1
      //   154: istore_1
      //   155: aload_2
      //   156: iload 4
      //   158: iload_1
      //   159: aload_0
      //   160: getfield 43	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
      //   163: lload 5
      //   165: invokevirtual 100	com/squareup/okhttp/internal/framed/FramedConnection:writeData	(IZLokio/Buffer;J)V
      //   168: aload_0
      //   169: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   172: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$6	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   175: invokevirtual 75	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   178: return
      //   179: aload_0
      //   180: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   183: invokestatic 103	com/squareup/okhttp/internal/framed/FramedStream:access$4	(Lcom/squareup/okhttp/internal/framed/FramedStream;)V
      //   186: goto -169 -> 17
      //   189: astore_3
      //   190: aload_0
      //   191: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   194: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$6	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   197: invokevirtual 75	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   200: aload_3
      //   201: athrow
      //   202: astore_3
      //   203: aload_2
      //   204: monitorexit
      //   205: aload_3
      //   206: athrow
      //   207: iconst_0
      //   208: istore_1
      //   209: goto -54 -> 155
      //   212: astore_2
      //   213: aload_0
      //   214: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   217: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$6	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   220: invokevirtual 75	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   223: aload_2
      //   224: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	225	0	this	FramedDataSink
      //   0	225	1	paramBoolean	boolean
      //   4	200	2	localObject1	Object
      //   212	12	2	localObject2	Object
      //   50	48	3	localObject3	Object
      //   189	12	3	localObject4	Object
      //   202	4	3	localObject5	Object
      //   134	23	4	i	int
      //   89	75	5	l	long
      // Exception table:
      //   from	to	target	type
      //   17	51	189	finally
      //   179	186	189	finally
      //   7	17	202	finally
      //   55	109	202	finally
      //   190	202	202	finally
      //   203	205	202	finally
      //   119	136	212	finally
      //   140	153	212	finally
      //   155	168	212	finally
    }
    
    public void close()
      throws IOException
    {
      assert (!Thread.holdsLock(FramedStream.this));
      for (;;)
      {
        synchronized (FramedStream.this)
        {
          if (this.closed) {
            return;
          }
          if (!FramedStream.this.sink.finished)
          {
            if (this.sendBuffer.size() <= 0L) {
              break label125;
            }
            if (this.sendBuffer.size() > 0L) {
              break label117;
            }
          }
        }
        synchronized (FramedStream.this)
        {
          this.closed = true;
          FramedStream.this.connection.flush();
          FramedStream.this.cancelStreamIfNecessary();
          return;
          localObject1 = finally;
          throw ((Throwable)localObject1);
          label117:
          emitDataFrame(true);
          continue;
          label125:
          FramedStream.this.connection.writeData(FramedStream.this.id, true, null, 0L);
        }
      }
    }
    
    public void flush()
      throws IOException
    {
      assert (!Thread.holdsLock(FramedStream.this));
      for (;;)
      {
        synchronized (FramedStream.this)
        {
          FramedStream.this.checkOutNotClosed();
          if (this.sendBuffer.size() <= 0L) {
            return;
          }
        }
        emitDataFrame(false);
        FramedStream.this.connection.flush();
      }
    }
    
    public Timeout timeout()
    {
      return FramedStream.this.writeTimeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      assert (!Thread.holdsLock(FramedStream.this));
      this.sendBuffer.write(paramBuffer, paramLong);
      for (;;)
      {
        if (this.sendBuffer.size() < 16384L) {
          return;
        }
        emitDataFrame(false);
      }
    }
  }
  
  private final class FramedDataSource
    implements Source
  {
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer = new Buffer();
    private final Buffer receiveBuffer = new Buffer();
    
    static
    {
      if (!FramedStream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    private FramedDataSource(long paramLong)
    {
      this.maxByteCount = paramLong;
    }
    
    private void checkNotClosed()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("stream closed");
      }
      if (FramedStream.this.errorCode != null) {
        throw new IOException("stream was reset: " + FramedStream.this.errorCode);
      }
    }
    
    /* Error */
    private void waitUntilReadable()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   4: invokestatic 87	com/squareup/okhttp/internal/framed/FramedStream:access$2	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   7: invokevirtual 92	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
      //   10: aload_0
      //   11: getfield 44	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:readBuffer	Lokio/Buffer;
      //   14: invokevirtual 96	okio/Buffer:size	()J
      //   17: lconst_0
      //   18: lcmp
      //   19: ifne +29 -> 48
      //   22: aload_0
      //   23: getfield 53	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:finished	Z
      //   26: ifne +22 -> 48
      //   29: aload_0
      //   30: getfield 58	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:closed	Z
      //   33: ifne +15 -> 48
      //   36: aload_0
      //   37: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   40: invokestatic 69	com/squareup/okhttp/internal/framed/FramedStream:access$3	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   43: astore_1
      //   44: aload_1
      //   45: ifnull +14 -> 59
      //   48: aload_0
      //   49: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   52: invokestatic 87	com/squareup/okhttp/internal/framed/FramedStream:access$2	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   55: invokevirtual 99	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   58: return
      //   59: aload_0
      //   60: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   63: invokestatic 103	com/squareup/okhttp/internal/framed/FramedStream:access$4	(Lcom/squareup/okhttp/internal/framed/FramedStream;)V
      //   66: goto -56 -> 10
      //   69: astore_1
      //   70: aload_0
      //   71: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   74: invokestatic 87	com/squareup/okhttp/internal/framed/FramedStream:access$2	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   77: invokevirtual 99	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   80: aload_1
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	FramedDataSource
      //   43	2	1	localErrorCode	ErrorCode
      //   69	12	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   10	44	69	finally
      //   59	66	69	finally
    }
    
    public void close()
      throws IOException
    {
      synchronized (FramedStream.this)
      {
        this.closed = true;
        this.readBuffer.clear();
        FramedStream.this.notifyAll();
        FramedStream.this.cancelStreamIfNecessary();
        return;
      }
    }
    
    public long read(Buffer arg1, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      synchronized (FramedStream.this)
      {
        waitUntilReadable();
        checkNotClosed();
        if (this.readBuffer.size() == 0L) {
          return -1L;
        }
        paramLong = this.readBuffer.read(???, Math.min(paramLong, this.readBuffer.size()));
        ??? = FramedStream.this;
        ???.unacknowledgedBytesRead += paramLong;
        if (FramedStream.this.unacknowledgedBytesRead >= FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)
        {
          FramedStream.this.connection.writeWindowUpdateLater(FramedStream.this.id, FramedStream.this.unacknowledgedBytesRead);
          FramedStream.this.unacknowledgedBytesRead = 0L;
        }
        synchronized (FramedStream.this.connection)
        {
          ??? = FramedStream.this.connection;
          ((FramedConnection)???).unacknowledgedBytesRead += paramLong;
          if (FramedStream.this.connection.unacknowledgedBytesRead >= FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)
          {
            FramedStream.this.connection.writeWindowUpdateLater(0, FramedStream.this.connection.unacknowledgedBytesRead);
            FramedStream.this.connection.unacknowledgedBytesRead = 0L;
          }
          return paramLong;
        }
      }
    }
    
    void receive(BufferedSource paramBufferedSource, long paramLong)
      throws IOException
    {
      long l = paramLong;
      int i;
      if (!$assertionsDisabled)
      {
        l = paramLong;
        if (Thread.holdsLock(FramedStream.this))
        {
          throw new AssertionError();
          boolean bool;
          synchronized (FramedStream.this)
          {
            bool = this.finished;
            if (this.readBuffer.size() + l > this.maxByteCount)
            {
              i = 1;
              if (i != 0)
              {
                paramBufferedSource.skip(l);
                FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
              }
            }
            else
            {
              i = 0;
            }
          }
          if (bool)
          {
            paramBufferedSource.skip(l);
            return;
          }
          paramLong = paramBufferedSource.read(this.receiveBuffer, l);
          if (paramLong == -1L) {
            throw new EOFException();
          }
          l -= paramLong;
        }
      }
      for (;;)
      {
        synchronized (FramedStream.this)
        {
          if (this.readBuffer.size() != 0L) {
            break label222;
          }
          i = 1;
          this.readBuffer.writeAll(this.receiveBuffer);
          if (i != 0) {
            FramedStream.this.notifyAll();
          }
        }
        if (l > 0L) {
          break;
        }
        return;
        label222:
        i = 0;
      }
    }
    
    public Timeout timeout()
    {
      return FramedStream.this.readTimeout;
    }
  }
  
  class StreamTimeout
    extends AsyncTimeout
  {
    StreamTimeout() {}
    
    public void exitAndThrowIfTimedOut()
      throws IOException
    {
      if (exit()) {
        throw newTimeoutException(null);
      }
    }
    
    protected IOException newTimeoutException(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void timedOut()
    {
      FramedStream.this.closeLater(ErrorCode.CANCEL);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\framed\FramedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */