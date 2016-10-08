package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class FramedConnection
  implements Closeable
{
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService executor;
  long bytesLeftInWriteWindow;
  final boolean client;
  private final Set<Integer> currentPushRequests = new LinkedHashSet();
  final FrameWriter frameWriter;
  private final IncomingStreamHandler handler;
  private final String hostName;
  private long idleStartTimeNs = System.nanoTime();
  private int lastGoodStreamId;
  private int nextPingId;
  private int nextStreamId;
  final Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private Map<Integer, Ping> pings;
  final Protocol protocol;
  private final ExecutorService pushExecutor;
  private final PushObserver pushObserver;
  final Reader readerRunnable;
  private boolean receivedInitialPeerSettings = false;
  private boolean shutdown;
  final Socket socket;
  private final Map<Integer, FramedStream> streams = new HashMap();
  long unacknowledgedBytesRead = 0L;
  final Variant variant;
  
  static
  {
    if (!FramedConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
      return;
    }
  }
  
  private FramedConnection(Builder paramBuilder)
    throws IOException
  {
    this.protocol = paramBuilder.protocol;
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.handler = paramBuilder.handler;
    int i;
    if (paramBuilder.client)
    {
      i = 1;
      this.nextStreamId = i;
      if ((paramBuilder.client) && (this.protocol == Protocol.HTTP_2)) {
        this.nextStreamId += 2;
      }
      i = j;
      if (paramBuilder.client) {
        i = 1;
      }
      this.nextPingId = i;
      if (paramBuilder.client) {
        this.okHttpSettings.set(7, 0, 16777216);
      }
      this.hostName = paramBuilder.hostName;
      if (this.protocol != Protocol.HTTP_2) {
        break label359;
      }
      this.variant = new Http2();
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] { this.hostName }), true));
      this.peerSettings.set(7, 0, 65535);
      this.peerSettings.set(5, 0, 16384);
    }
    for (;;)
    {
      this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
      this.socket = paramBuilder.socket;
      this.frameWriter = this.variant.newWriter(Okio.buffer(Okio.sink(paramBuilder.socket)), this.client);
      this.readerRunnable = new Reader(null);
      new Thread(this.readerRunnable).start();
      return;
      i = 2;
      break;
      label359:
      if (this.protocol != Protocol.SPDY_3) {
        break label388;
      }
      this.variant = new Spdy3();
      this.pushExecutor = null;
    }
    label388:
    throw new AssertionError(this.protocol);
  }
  
  /* Error */
  private void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 85	com/squareup/okhttp/internal/framed/FramedConnection:$assertionsDisabled	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 347	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 262	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 348	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 351	com/squareup/okhttp/internal/framed/FramedConnection:shutdown	(Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   28: aload_3
    //   29: astore_1
    //   30: aconst_null
    //   31: astore 4
    //   33: aconst_null
    //   34: astore 5
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 124	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   42: invokeinterface 356 1 0
    //   47: ifne +48 -> 95
    //   50: aload_0
    //   51: getfield 124	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   54: invokeinterface 360 1 0
    //   59: aload_0
    //   60: getfield 124	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   63: invokeinterface 364 1 0
    //   68: anewarray 366	com/squareup/okhttp/internal/framed/FramedStream
    //   71: invokeinterface 372 2 0
    //   76: checkcast 374	[Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   79: astore 4
    //   81: aload_0
    //   82: getfield 124	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   85: invokeinterface 377 1 0
    //   90: aload_0
    //   91: iconst_0
    //   92: invokespecial 381	com/squareup/okhttp/internal/framed/FramedConnection:setIdle	(Z)V
    //   95: aload_0
    //   96: getfield 383	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   99: ifnull +39 -> 138
    //   102: aload_0
    //   103: getfield 383	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   106: invokeinterface 360 1 0
    //   111: aload_0
    //   112: getfield 383	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   115: invokeinterface 364 1 0
    //   120: anewarray 385	com/squareup/okhttp/internal/framed/Ping
    //   123: invokeinterface 372 2 0
    //   128: checkcast 387	[Lcom/squareup/okhttp/internal/framed/Ping;
    //   131: astore 5
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 383	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: astore_3
    //   142: aload 4
    //   144: ifnull +20 -> 164
    //   147: aload 4
    //   149: arraylength
    //   150: istore 8
    //   152: iconst_0
    //   153: istore 7
    //   155: iload 7
    //   157: iload 8
    //   159: if_icmplt +58 -> 217
    //   162: aload_1
    //   163: astore_3
    //   164: aload 5
    //   166: ifnull +18 -> 184
    //   169: aload 5
    //   171: arraylength
    //   172: istore 8
    //   174: iconst_0
    //   175: istore 7
    //   177: iload 7
    //   179: iload 8
    //   181: if_icmplt +74 -> 255
    //   184: aload_0
    //   185: getfield 241	com/squareup/okhttp/internal/framed/FramedConnection:frameWriter	Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   188: invokeinterface 391 1 0
    //   193: aload_3
    //   194: astore_1
    //   195: aload_0
    //   196: getfield 223	com/squareup/okhttp/internal/framed/FramedConnection:socket	Ljava/net/Socket;
    //   199: invokevirtual 394	java/net/Socket:close	()V
    //   202: aload_1
    //   203: ifnull +85 -> 288
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: goto -179 -> 30
    //   212: astore_1
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_1
    //   216: athrow
    //   217: aload 4
    //   219: iload 7
    //   221: aaload
    //   222: astore_3
    //   223: aload_3
    //   224: aload_2
    //   225: invokevirtual 396	com/squareup/okhttp/internal/framed/FramedStream:close	(Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   228: aload_1
    //   229: astore_3
    //   230: iload 7
    //   232: iconst_1
    //   233: iadd
    //   234: istore 7
    //   236: aload_3
    //   237: astore_1
    //   238: goto -83 -> 155
    //   241: astore 6
    //   243: aload_1
    //   244: astore_3
    //   245: aload_1
    //   246: ifnull -16 -> 230
    //   249: aload 6
    //   251: astore_3
    //   252: goto -22 -> 230
    //   255: aload 5
    //   257: iload 7
    //   259: aaload
    //   260: invokevirtual 399	com/squareup/okhttp/internal/framed/Ping:cancel	()V
    //   263: iload 7
    //   265: iconst_1
    //   266: iadd
    //   267: istore 7
    //   269: goto -92 -> 177
    //   272: astore_2
    //   273: aload_3
    //   274: astore_1
    //   275: aload_3
    //   276: ifnonnull -81 -> 195
    //   279: aload_2
    //   280: astore_1
    //   281: goto -86 -> 195
    //   284: astore_1
    //   285: goto -83 -> 202
    //   288: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	FramedConnection
    //   0	289	1	paramErrorCode1	ErrorCode
    //   0	289	2	paramErrorCode2	ErrorCode
    //   22	254	3	localObject	Object
    //   31	187	4	arrayOfFramedStream	FramedStream[]
    //   34	222	5	arrayOfPing	Ping[]
    //   241	9	6	localIOException	IOException
    //   153	115	7	i	int
    //   150	32	8	j	int
    // Exception table:
    //   from	to	target	type
    //   23	28	208	java/io/IOException
    //   38	95	212	finally
    //   95	138	212	finally
    //   138	140	212	finally
    //   213	215	212	finally
    //   223	228	241	java/io/IOException
    //   184	193	272	java/io/IOException
    //   195	202	284	java/io/IOException
  }
  
  private FramedStream newStream(int paramInt, List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBoolean1)
    {
      bool1 = false;
      if (!paramBoolean2) {
        break label65;
      }
    }
    label65:
    for (paramBoolean2 = bool2;; paramBoolean2 = true)
    {
      synchronized (this.frameWriter)
      {
        try
        {
          if (!this.shutdown) {
            break label71;
          }
          throw new IOException("shutdown");
        }
        finally {}
      }
      bool1 = true;
      break;
    }
    label71:
    int i = this.nextStreamId;
    this.nextStreamId += 2;
    FramedStream localFramedStream = new FramedStream(i, this, bool1, paramBoolean2, paramList);
    if (localFramedStream.isOpen())
    {
      this.streams.put(Integer.valueOf(i), localFramedStream);
      setIdle(false);
    }
    if (paramInt == 0) {
      this.frameWriter.synStream(bool1, paramBoolean2, i, paramInt, paramList);
    }
    for (;;)
    {
      if (!paramBoolean1) {
        this.frameWriter.flush();
      }
      return localFramedStream;
      if (this.client) {
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
      }
      this.frameWriter.pushPromise(paramInt, i, paramList);
    }
  }
  
  private void pushDataLater(final int paramInt1, BufferedSource paramBufferedSource, final int paramInt2, final boolean paramBoolean)
    throws IOException
  {
    final Buffer localBuffer = new Buffer();
    paramBufferedSource.require(paramInt2);
    paramBufferedSource.read(localBuffer, paramInt2);
    if (localBuffer.size() != paramInt2) {
      throw new IOException(localBuffer.size() + " != " + paramInt2);
    }
    this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt1) })
    {
      public void execute()
      {
        try
        {
          boolean bool = FramedConnection.this.pushObserver.onData(paramInt1, localBuffer, paramInt2, paramBoolean);
          if (bool) {
            FramedConnection.this.frameWriter.rstStream(paramInt1, ErrorCode.CANCEL);
          }
          if ((bool) || (paramBoolean)) {
            synchronized (FramedConnection.this)
            {
              FramedConnection.this.currentPushRequests.remove(Integer.valueOf(paramInt1));
              return;
            }
          }
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  private void pushHeadersLater(final int paramInt, final List<Header> paramList, final boolean paramBoolean)
  {
    this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        boolean bool = FramedConnection.this.pushObserver.onHeaders(paramInt, paramList, paramBoolean);
        if (bool) {}
        try
        {
          FramedConnection.this.frameWriter.rstStream(paramInt, ErrorCode.CANCEL);
          if ((bool) || (paramBoolean)) {
            synchronized (FramedConnection.this)
            {
              FramedConnection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
              return;
            }
          }
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  private void pushRequestLater(final int paramInt, final List<Header> paramList)
  {
    try
    {
      if (this.currentPushRequests.contains(Integer.valueOf(paramInt)))
      {
        writeSynResetLater(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.currentPushRequests.add(Integer.valueOf(paramInt));
      this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) })
      {
        public void execute()
        {
          if (FramedConnection.this.pushObserver.onRequest(paramInt, paramList)) {
            try
            {
              FramedConnection.this.frameWriter.rstStream(paramInt, ErrorCode.CANCEL);
              synchronized (FramedConnection.this)
              {
                FramedConnection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
                return;
              }
              return;
            }
            catch (IOException localIOException) {}
          }
        }
      });
      return;
    }
    finally {}
  }
  
  private void pushResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        FramedConnection.this.pushObserver.onReset(paramInt, paramErrorCode);
        synchronized (FramedConnection.this)
        {
          FramedConnection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
          return;
        }
      }
    });
  }
  
  private boolean pushedStream(int paramInt)
  {
    return (this.protocol == Protocol.HTTP_2) && (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  /* Error */
  private Ping removePing(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 383	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 383	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 521 2 0
    //   22: checkcast 385	com/squareup/okhttp/internal/framed/Ping
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	FramedConnection
    //   0	40	1	paramInt	int
    //   25	7	2	localPing	Ping
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void setIdle(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l = System.nanoTime();
        this.idleStartTimeNs = l;
        return;
      }
      finally {}
      long l = Long.MAX_VALUE;
    }
  }
  
  private void writePing(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
    throws IOException
  {
    FrameWriter localFrameWriter = this.frameWriter;
    if (paramPing != null) {}
    try
    {
      paramPing.send();
      this.frameWriter.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  private void writePingLater(final boolean paramBoolean, final int paramInt1, final int paramInt2, final Ping paramPing)
  {
    executor.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[] { this.hostName, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })
    {
      public void execute()
      {
        try
        {
          FramedConnection.this.writePing(paramBoolean, paramInt1, paramInt2, paramPing);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void close()
    throws IOException
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public void flush()
    throws IOException
  {
    this.frameWriter.flush();
  }
  
  public long getIdleStartTimeNs()
  {
    try
    {
      long l = this.idleStartTimeNs;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Protocol getProtocol()
  {
    return this.protocol;
  }
  
  FramedStream getStream(int paramInt)
  {
    try
    {
      FramedStream localFramedStream = (FramedStream)this.streams.get(Integer.valueOf(paramInt));
      return localFramedStream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean isIdle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 132	com/squareup/okhttp/internal/framed/FramedConnection:idleStartTimeNs	J
    //   6: lstore_2
    //   7: lload_2
    //   8: ldc2_w 522
    //   11: lcmp
    //   12: ifeq +11 -> 23
    //   15: iconst_1
    //   16: istore 4
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 4
    //   22: ireturn
    //   23: iconst_0
    //   24: istore 4
    //   26: goto -8 -> 18
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	FramedConnection
    //   29	4	1	localObject	Object
    //   6	2	2	l	long
    //   16	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
  }
  
  public FramedStream newStream(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    return newStream(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Ping ping()
    throws IOException
  {
    Ping localPing = new Ping();
    try
    {
      if (this.shutdown) {
        throw new IOException("shutdown");
      }
    }
    finally {}
    int i = this.nextPingId;
    this.nextPingId += 2;
    if (this.pings == null) {
      this.pings = new HashMap();
    }
    this.pings.put(Integer.valueOf(i), localObject);
    writePing(false, i, 1330343787, (Ping)localObject);
    return (Ping)localObject;
  }
  
  public FramedStream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (this.client) {
      throw new IllegalStateException("Client cannot push requests.");
    }
    if (this.protocol != Protocol.HTTP_2) {
      throw new IllegalStateException("protocol != HTTP_2");
    }
    return newStream(paramInt, paramList, paramBoolean, false);
  }
  
  FramedStream removeStream(int paramInt)
  {
    try
    {
      FramedStream localFramedStream = (FramedStream)this.streams.remove(Integer.valueOf(paramInt));
      if ((localFramedStream != null) && (this.streams.isEmpty())) {
        setIdle(true);
      }
      notifyAll();
      return localFramedStream;
    }
    finally {}
  }
  
  public void sendConnectionPreface()
    throws IOException
  {
    this.frameWriter.connectionPreface();
    this.frameWriter.settings(this.okHttpSettings);
    int i = this.okHttpSettings.getInitialWindowSize(65536);
    if (i != 65536) {
      this.frameWriter.windowUpdate(0, i - 65536);
    }
  }
  
  public void shutdown(ErrorCode paramErrorCode)
    throws IOException
  {
    int i;
    synchronized (this.frameWriter) {}
  }
  
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
    throws IOException
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      this.frameWriter.data(paramBoolean, paramInt, paramBuffer, 0);
      return;
    }
    for (;;)
    {
      try
      {
        paramLong = this.bytesLeftInWriteWindow;
        if (paramLong > 0L)
        {
          int i = Math.min((int)Math.min(l, this.bytesLeftInWriteWindow), this.frameWriter.maxDataLength());
          this.bytesLeftInWriteWindow -= i;
          l -= i;
          FrameWriter localFrameWriter = this.frameWriter;
          if ((!paramBoolean) || (l != 0L)) {
            break label175;
          }
          bool = true;
          localFrameWriter.data(bool, paramInt, paramBuffer, i);
          if (l > 0L) {
            break;
          }
          return;
        }
        if (!this.streams.containsKey(Integer.valueOf(paramInt))) {
          throw new IOException("stream closed");
        }
      }
      catch (InterruptedException paramBuffer)
      {
        throw new InterruptedIOException();
      }
      finally {}
      wait();
      continue;
      label175:
      boolean bool = false;
    }
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    this.frameWriter.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    this.frameWriter.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[] { this.hostName, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        try
        {
          FramedConnection.this.writeSynReset(paramInt, paramErrorCode);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void writeWindowUpdateLater(final int paramInt, final long paramLong)
  {
    executor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[] { this.hostName, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        try
        {
          FramedConnection.this.frameWriter.windowUpdate(paramInt, paramLong);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  public static class Builder
  {
    private boolean client;
    private IncomingStreamHandler handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
    private String hostName;
    private Protocol protocol = Protocol.SPDY_3;
    private PushObserver pushObserver = PushObserver.CANCEL;
    private Socket socket;
    
    public Builder(String paramString, boolean paramBoolean, Socket paramSocket)
      throws IOException
    {
      this.hostName = paramString;
      this.client = paramBoolean;
      this.socket = paramSocket;
    }
    
    public Builder(boolean paramBoolean, Socket paramSocket)
      throws IOException
    {
      this(((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), paramBoolean, paramSocket);
    }
    
    public FramedConnection build()
      throws IOException
    {
      return new FramedConnection(this, null);
    }
    
    public Builder handler(IncomingStreamHandler paramIncomingStreamHandler)
    {
      this.handler = paramIncomingStreamHandler;
      return this;
    }
    
    public Builder protocol(Protocol paramProtocol)
    {
      this.protocol = paramProtocol;
      return this;
    }
    
    public Builder pushObserver(PushObserver paramPushObserver)
    {
      this.pushObserver = paramPushObserver;
      return this;
    }
  }
  
  class Reader
    extends NamedRunnable
    implements FrameReader.Handler
  {
    FrameReader frameReader;
    
    private Reader()
    {
      super(new Object[] { FramedConnection.this.hostName });
    }
    
    private void ackSettingsLater(final Settings paramSettings)
    {
      FramedConnection.executor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[] { FramedConnection.this.hostName })
      {
        public void execute()
        {
          try
          {
            FramedConnection.this.frameWriter.ackSettings(paramSettings);
            return;
          }
          catch (IOException localIOException) {}
        }
      });
    }
    
    public void ackSettings() {}
    
    public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
    
    public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException
    {
      if (FramedConnection.this.pushedStream(paramInt1)) {
        FramedConnection.this.pushDataLater(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
      }
      FramedStream localFramedStream;
      do
      {
        return;
        localFramedStream = FramedConnection.this.getStream(paramInt1);
        if (localFramedStream == null)
        {
          FramedConnection.this.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
          paramBufferedSource.skip(paramInt2);
          return;
        }
        localFramedStream.receiveData(paramBufferedSource, paramInt2);
      } while (!paramBoolean);
      localFramedStream.receiveFin();
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: getstatic 103	com/squareup/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   3: astore_3
      //   4: getstatic 103	com/squareup/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 21	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   18: getfield 107	com/squareup/okhttp/internal/framed/FramedConnection:variant	Lcom/squareup/okhttp/internal/framed/Variant;
      //   21: aload_0
      //   22: getfield 21	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   25: getfield 111	com/squareup/okhttp/internal/framed/FramedConnection:socket	Ljava/net/Socket;
      //   28: invokestatic 117	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
      //   31: invokestatic 121	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
      //   34: aload_0
      //   35: getfield 21	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   38: getfield 125	com/squareup/okhttp/internal/framed/FramedConnection:client	Z
      //   41: invokeinterface 131 3 0
      //   46: putfield 133	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   49: aload_3
      //   50: astore_2
      //   51: aload_3
      //   52: astore_1
      //   53: aload_0
      //   54: getfield 21	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   57: getfield 125	com/squareup/okhttp/internal/framed/FramedConnection:client	Z
      //   60: ifne +16 -> 76
      //   63: aload_3
      //   64: astore_2
      //   65: aload_3
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 133	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   71: invokeinterface 138 1 0
      //   76: aload_3
      //   77: astore_2
      //   78: aload_3
      //   79: astore_1
      //   80: aload_0
      //   81: getfield 133	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   84: aload_0
      //   85: invokeinterface 142 2 0
      //   90: ifne -14 -> 76
      //   93: aload_3
      //   94: astore_2
      //   95: aload_3
      //   96: astore_1
      //   97: getstatic 145	com/squareup/okhttp/internal/framed/ErrorCode:NO_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   100: astore_3
      //   101: aload_3
      //   102: astore_2
      //   103: aload_3
      //   104: astore_1
      //   105: getstatic 148	com/squareup/okhttp/internal/framed/ErrorCode:CANCEL	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   108: astore 5
      //   110: aload_0
      //   111: getfield 21	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   114: aload_3
      //   115: aload 5
      //   117: invokestatic 152	com/squareup/okhttp/internal/framed/FramedConnection:access$2	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   120: aload_0
      //   121: getfield 133	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   124: invokestatic 158	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   127: return
      //   128: astore_1
      //   129: aload_2
      //   130: astore_1
      //   131: getstatic 161	com/squareup/okhttp/internal/framed/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   134: astore_2
      //   135: aload_2
      //   136: astore_1
      //   137: getstatic 161	com/squareup/okhttp/internal/framed/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   140: astore_3
      //   141: aload_0
      //   142: getfield 21	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   145: aload_2
      //   146: aload_3
      //   147: invokestatic 152	com/squareup/okhttp/internal/framed/FramedConnection:access$2	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   150: aload_0
      //   151: getfield 133	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   154: invokestatic 158	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   157: return
      //   158: astore_2
      //   159: aload_0
      //   160: getfield 21	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   163: aload_1
      //   164: aload 4
      //   166: invokestatic 152	com/squareup/okhttp/internal/framed/FramedConnection:access$2	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   169: aload_0
      //   170: getfield 133	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   173: invokestatic 158	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   176: aload_2
      //   177: athrow
      //   178: astore_1
      //   179: goto -59 -> 120
      //   182: astore_1
      //   183: goto -14 -> 169
      //   186: astore_1
      //   187: goto -37 -> 150
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	190	0	this	Reader
      //   12	93	1	localErrorCode1	ErrorCode
      //   128	1	1	localIOException1	IOException
      //   130	34	1	localErrorCode2	ErrorCode
      //   178	1	1	localIOException2	IOException
      //   182	1	1	localIOException3	IOException
      //   186	1	1	localIOException4	IOException
      //   10	136	2	localErrorCode3	ErrorCode
      //   158	19	2	localObject	Object
      //   3	144	3	localErrorCode4	ErrorCode
      //   7	158	4	localErrorCode5	ErrorCode
      //   108	8	5	localErrorCode6	ErrorCode
      // Exception table:
      //   from	to	target	type
      //   13	49	128	java/io/IOException
      //   53	63	128	java/io/IOException
      //   67	76	128	java/io/IOException
      //   80	93	128	java/io/IOException
      //   97	101	128	java/io/IOException
      //   105	110	128	java/io/IOException
      //   13	49	158	finally
      //   53	63	158	finally
      //   67	76	158	finally
      //   80	93	158	finally
      //   97	101	158	finally
      //   105	110	158	finally
      //   131	135	158	finally
      //   137	141	158	finally
      //   110	120	178	java/io/IOException
      //   159	169	182	java/io/IOException
      //   141	150	186	java/io/IOException
    }
    
    public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
    {
      paramByteString.size();
      for (;;)
      {
        int i;
        synchronized (FramedConnection.this)
        {
          paramByteString = (FramedStream[])FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
          FramedConnection.this.shutdown = true;
          int j = paramByteString.length;
          i = 0;
          if (i >= j) {
            return;
          }
        }
        ??? = paramByteString[i];
        if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
        {
          ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
          FramedConnection.this.removeStream(???.getId());
        }
        i += 1;
      }
    }
    
    public void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, final List<Header> paramList, HeadersMode paramHeadersMode)
    {
      if (FramedConnection.this.pushedStream(paramInt1)) {
        FramedConnection.this.pushHeadersLater(paramInt1, paramList, paramBoolean2);
      }
      FramedStream localFramedStream;
      do
      {
        return;
        synchronized (FramedConnection.this)
        {
          if (FramedConnection.this.shutdown) {
            return;
          }
        }
        localFramedStream = FramedConnection.this.getStream(paramInt1);
        if (localFramedStream == null)
        {
          if (paramHeadersMode.failIfStreamAbsent())
          {
            FramedConnection.this.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
            return;
          }
          if (paramInt1 <= FramedConnection.this.lastGoodStreamId) {
            return;
          }
          if (paramInt1 % 2 == FramedConnection.this.nextStreamId % 2) {
            return;
          }
          paramList = new FramedStream(paramInt1, FramedConnection.this, paramBoolean1, paramBoolean2, paramList);
          FramedConnection.this.lastGoodStreamId = paramInt1;
          FramedConnection.this.streams.put(Integer.valueOf(paramInt1), paramList);
          FramedConnection.executor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[] { FramedConnection.this.hostName, Integer.valueOf(paramInt1) })
          {
            public void execute()
            {
              try
              {
                FramedConnection.this.handler.receive(paramList);
                return;
              }
              catch (IOException localIOException1)
              {
                Internal.logger.log(Level.INFO, "StreamHandler failure for " + FramedConnection.this.hostName, localIOException1);
                try
                {
                  paramList.close(ErrorCode.PROTOCOL_ERROR);
                  return;
                }
                catch (IOException localIOException2) {}
              }
            }
          });
          return;
        }
        if (paramHeadersMode.failIfStreamPresent())
        {
          localFramedStream.closeLater(ErrorCode.PROTOCOL_ERROR);
          FramedConnection.this.removeStream(paramInt1);
          return;
        }
        localFramedStream.receiveHeaders(paramList, paramHeadersMode);
      } while (!paramBoolean2);
      localFramedStream.receiveFin();
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
      {
        Ping localPing = FramedConnection.this.removePing(paramInt1);
        if (localPing != null) {
          localPing.receive();
        }
        return;
      }
      FramedConnection.this.writePingLater(true, paramInt1, paramInt2, null);
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      FramedConnection.this.pushRequestLater(paramInt2, paramList);
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      if (FramedConnection.this.pushedStream(paramInt)) {
        FramedConnection.this.pushResetLater(paramInt, paramErrorCode);
      }
      FramedStream localFramedStream;
      do
      {
        return;
        localFramedStream = FramedConnection.this.removeStream(paramInt);
      } while (localFramedStream == null);
      localFramedStream.receiveRstStream(paramErrorCode);
    }
    
    public void settings(boolean paramBoolean, Settings paramSettings)
    {
      long l2 = 0L;
      ??? = null;
      for (;;)
      {
        int i;
        long l1;
        synchronized (FramedConnection.this)
        {
          i = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
          if (paramBoolean) {
            FramedConnection.this.peerSettings.clear();
          }
          FramedConnection.this.peerSettings.merge(paramSettings);
          if (FramedConnection.this.getProtocol() == Protocol.HTTP_2) {
            ackSettingsLater(paramSettings);
          }
          int j = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
          l1 = l2;
          paramSettings = (Settings)???;
          if (j != -1)
          {
            l1 = l2;
            paramSettings = (Settings)???;
            if (j != i)
            {
              l2 = j - i;
              if (!FramedConnection.this.receivedInitialPeerSettings)
              {
                FramedConnection.this.addBytesToWriteWindow(l2);
                FramedConnection.this.receivedInitialPeerSettings = true;
              }
              l1 = l2;
              paramSettings = (Settings)???;
              if (!FramedConnection.this.streams.isEmpty())
              {
                paramSettings = (FramedStream[])FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
                l1 = l2;
              }
            }
          }
          if ((paramSettings != null) && (l1 != 0L))
          {
            j = paramSettings.length;
            i = 0;
            if (i < j) {}
          }
          else
          {
            return;
          }
        }
        synchronized (paramSettings[i])
        {
          ((FramedStream)???).addBytesToWriteWindow(l1);
          i += 1;
        }
      }
    }
    
    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (FramedConnection.this)
        {
          FramedConnection localFramedConnection = FramedConnection.this;
          localFramedConnection.bytesLeftInWriteWindow += paramLong;
          FramedConnection.this.notifyAll();
          return;
        }
      }
      ??? = FramedConnection.this.getStream(paramInt);
      if (??? != null) {
        try
        {
          ((FramedStream)???).addBytesToWriteWindow(paramLong);
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\framed\FramedConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */