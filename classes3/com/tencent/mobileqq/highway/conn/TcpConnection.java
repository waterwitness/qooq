package com.tencent.mobileqq.highway.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.codec.HttpProtocolDataCodec;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.IRequestListener;
import com.tencent.mobileqq.highway.segment.RequestHeartBreak;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class TcpConnection
  implements IConnection, IProtocolCodecListener
{
  public static final int DEDAULT_CONN_TIMEOUT_xG = 20000;
  public static final int DEFAULT_CONN_TIMEOUT_Wi = 10000;
  public static final int DEFAULT_READ_BUF_SIZE = 32768;
  public static final int DEFAULT_READ_TIMEOUT = 30000;
  public static final int DEFAULT_SEND_BUF_SIZE = 524288;
  public static final int HEARTBREAK_DELTA = 20000;
  private static final int MAX_CONTINUE_HREAT = 2;
  private StringBuilder closeDebug = new StringBuilder("ConnTag:");
  private int connId;
  private ConnReportInfo connInfo = new ConnReportInfo();
  private IConnectionListener connListener;
  private ConnManager connManager;
  private int continueHeartBreak;
  private TcpProtocolDataCodec dataCodec;
  private AtomicBoolean isConn = new AtomicBoolean(false);
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private volatile boolean isUrgent;
  private AtomicBoolean isWritting = new AtomicBoolean(false);
  private long lastHeartBreakTime;
  private ReentrantLock lock = new ReentrantLock();
  private ConnWorker mConnHandler;
  private HandlerThread mConnThread;
  private int mConnTimeOut;
  private EndPoint mEp;
  private MsfSocketInputBuffer mInputBuffer;
  public int mLastDataSegSize;
  public long mLastDataTransTime;
  private int mNetFlowDw;
  private int mNetFlowUp;
  private OutputStream mOutputStream;
  private int mReadBufferSize;
  private ReadThread mReadThread;
  private int mReadTimeout;
  public long mRtt;
  private Handler mServletHandler;
  private Socket mSocket;
  private InetSocketAddress serverAddress;
  private AtomicBoolean shouldCloseConn = new AtomicBoolean(false);
  
  public TcpConnection(ConnManager paramConnManager, int paramInt1, EndPoint paramEndPoint, int paramInt2, int paramInt3)
  {
    if (paramEndPoint.protoType == 2) {}
    for (this.dataCodec = new HttpProtocolDataCodec();; this.dataCodec = new TcpProtocolDataCodec())
    {
      this.connManager = paramConnManager;
      this.mReadBufferSize = 32768;
      this.mReadTimeout = paramInt3;
      this.connId = paramInt1;
      this.mEp = paramEndPoint;
      this.mConnTimeOut = paramInt2;
      this.mConnThread = new HandlerThread("BDH-CONN" + paramInt1);
      this.dataCodec.setProtocolCodecListener(this);
      this.mServletHandler = new Handler(Looper.getMainLooper());
      return;
    }
  }
  
  private void closeConn(final int paramInt)
  {
    QLog.d("BDH_LOG", 1, "CCloseConn at : ConnId:" + this.connId + " Src:" + paramInt);
    this.isRunning.set(false);
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool1 = bool5;
    boolean bool3 = bool6;
    for (;;)
    {
      try
      {
        if (this.mSocket == null) {
          return;
        }
        bool1 = bool5;
        bool3 = bool6;
        if (!this.isConn.get()) {
          return;
        }
        bool1 = bool5;
        bool3 = bool6;
        if (!this.lock.tryLock(30000L, TimeUnit.MILLISECONDS)) {
          continue;
        }
        bool1 = bool5;
        bool3 = bool6;
        if (this.mInputBuffer != null)
        {
          bool1 = bool5;
          bool3 = bool6;
          localObject1 = this.mInputBuffer.instream;
          if (localObject1 != null)
          {
            bool1 = bool5;
            bool3 = bool6;
            setExclusiveStream(false, localObject1.toString());
          }
        }
        bool1 = bool5;
        bool3 = bool6;
        if (this.mOutputStream != null)
        {
          bool1 = bool5;
          bool3 = bool6;
          setExclusiveStream(false, this.mOutputStream.toString());
        }
        bool2 = bool4;
      }
      catch (InterruptedException localInterruptedException)
      {
        Object localObject1;
        final int i;
        BdhLogUtil.LogException("C", "CloseConn Error.", localInterruptedException);
        continue;
        bool1 = bool5;
        bool3 = bool6;
        this.shouldCloseConn.set(true);
        bool1 = bool2;
        continue;
      }
      catch (Exception localException1)
      {
        BdhLogUtil.LogException("C", "CloseConn Error.", localException1);
        bool1 = bool3;
        continue;
      }
      try
      {
        localObject1 = this.mConnHandler;
        if (localObject1 != null)
        {
          bool2 = bool4;
          ((ConnWorker)localObject1).notifyToQuit();
        }
        bool2 = bool4;
        this.mInputBuffer = null;
        bool2 = bool4;
        this.mOutputStream = null;
        bool2 = bool4;
      }
      finally
      {
        bool1 = bool2;
        bool3 = bool2;
        this.lock.unlock();
        bool1 = bool2;
        bool3 = bool2;
      }
      try
      {
        if (this.mSocket != null)
        {
          bool2 = bool4;
          this.mSocket.close();
        }
      }
      catch (Exception localException2) {}
    }
    bool2 = bool4;
    this.isConn.set(false);
    bool2 = bool4;
    this.mSocket = null;
    bool2 = bool4;
    this.mReadThread = null;
    bool1 = true;
    bool5 = true;
    bool3 = true;
    bool4 = true;
    bool2 = bool1;
    this.connInfo.finished = true;
    bool2 = bool1;
    this.connInfo.connLifeLong = (SystemClock.uptimeMillis() - this.connInfo.connStartTime);
    bool2 = bool1;
    paramInt = this.mNetFlowUp;
    bool2 = bool1;
    i = this.mNetFlowDw;
    bool2 = bool1;
    this.mNetFlowUp = 0;
    bool2 = bool1;
    this.mNetFlowDw = 0;
    bool2 = bool1;
    new Thread(new Runnable()
    {
      public void run()
      {
        HwServlet.reportTraffic4PicUp(TcpConnection.this.connManager.engine.app, TcpConnection.this.connInfo.serverIp, TcpConnection.this.connInfo.port, true, paramInt);
        HwServlet.reportTraffic4PicUp(TcpConnection.this.connManager.engine.app, TcpConnection.this.connInfo.serverIp, TcpConnection.this.connInfo.port, false, i);
      }
    }).start();
    bool1 = bool5;
    this.lock.unlock();
    bool1 = bool4;
    localObject1 = this.connListener;
    if (localObject1 != null) {
      ((IConnectionListener)localObject1).onDisConnect(this.connId, this);
    }
    BdhLogUtil.LogEvent("C", "CloseConn End. connId:" + this.connId + " isCloseSuccess:" + bool1);
    return;
  }
  
  private void doSendData()
  {
    for (;;)
    {
      if ((!this.isRunning.get()) || (this.isWritting.get())) {
        label20:
        return;
      }
      try
      {
        ??? = this.connManager.pullNextRequest(this, this.isUrgent, this.mLastDataTransTime, this.mRtt, this.mLastDataSegSize);
        if (??? == null)
        {
          this.isWritting.set(false);
          if (SystemClock.uptimeMillis() - this.lastHeartBreakTime <= 60000L) {
            break label20;
          }
          this.lastHeartBreakTime = SystemClock.uptimeMillis();
          ??? = this.connManager;
          i = this.connId;
          if (this.continueHeartBreak == 0)
          {
            bool = true;
            label101:
            ((ConnManager)???).onConnectionIdle(i, bool);
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        int i;
        boolean bool;
        BdhLogUtil.LogException("C", "SendThread Error.", localException2);
        synchronized (this.closeDebug)
        {
          this.closeDebug.append("By SendWorker :" + localException2.getMessage() + ";");
          closeConn(2);
          continue;
          bool = false;
          break label101;
          BdhLogUtil.LogEvent("R", "req sending: reqId = " + ((HwRequest)???).getHwSeq() + " req.timeOutCount = " + ((HwRequest)???).timeOutCount + " req.timeOut = " + ((HwRequest)???).timeOut);
          this.isWritting.set(true);
          ((HwRequest)???).endpoint = this.mEp;
          if ((??? instanceof RequestHeartBreak))
          {
            if (this.continueHeartBreak > 2)
            {
              this.connInfo.killSelf = true;
              closeConn(4);
              return;
            }
            this.continueHeartBreak += 1;
          }
          for (;;)
          {
            try
            {
              arrayOfByte = ((HwRequest)???).getRequestBody();
              if ((arrayOfByte != null) || (!((HwRequest)???).hasRequestBody())) {
                break label358;
              }
              ((HwRequest)???).reqListener.handleError(64532, "NullBody");
              this.isWritting.set(false);
            }
            catch (Exception localException1)
            {
              this.isWritting.set(false);
            }
            break;
            this.continueHeartBreak = 0;
            this.lastHeartBreakTime = 0L;
          }
          label358:
          byte[] arrayOfByte = this.dataCodec.encodeC2SData(this.mEp, localException1, arrayOfByte);
          if (arrayOfByte == null)
          {
            this.isWritting.set(false);
            continue;
          }
          if (localException1.retryCount == 0)
          {
            localObject3 = this.connInfo;
            ((ConnReportInfo)localObject3).sentRequestCount += 1;
            localObject3 = this.connInfo;
            ((ConnReportInfo)localObject3).sentDataLen += arrayOfByte.length;
            localException1.sendTime = SystemClock.uptimeMillis();
            long l1 = SystemClock.uptimeMillis();
            localObject3 = this.mOutputStream;
            if (localObject3 != null)
            {
              ((OutputStream)localObject3).write(arrayOfByte);
              ((OutputStream)localObject3).flush();
            }
            i = arrayOfByte.length;
            this.connManager.increaseDataFlowUp(i);
            long l2 = SystemClock.uptimeMillis();
            this.mNetFlowUp += i;
            localException1.reqListener.handleSendEnd(this.connId, getProtoType());
            BdhLogUtil.LogEvent("R", "SendRequest End. CostTrace  reqId: " + localException1.getHwSeq() + " SendComsume:" + localException1.sendComsume + " WriteComsume:" + (l2 - l1) + " ConnID:" + this.connId + " ReqInfo:" + localException1.dumpBaseInfo() + " ContinueHeartBreak:" + this.continueHeartBreak);
            this.isWritting.set(false);
            continue;
          }
          Object localObject3 = this.connInfo;
          ((ConnReportInfo)localObject3).sentRetryCount += 1;
        }
      }
    }
  }
  
  /* Error */
  private int openConn(EndPoint paramEndPoint)
  {
    // Byte code:
    //   0: ldc -25
    //   2: iconst_1
    //   3: new 104	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 489
    //   13: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: getfield 493	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   20: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 495
    //   26: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: getfield 498	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   33: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 500
    //   39: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   46: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 502
    //   52: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 121	com/tencent/mobileqq/highway/utils/EndPoint:protoType	I
    //   59: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 504
    //   65: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   78: invokevirtual 250	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   81: ifne +13 -> 94
    //   84: aload_0
    //   85: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: invokevirtual 250	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   91: ifeq +26 -> 117
    //   94: aload_0
    //   95: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   98: invokevirtual 250	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   101: ifeq +16 -> 117
    //   104: aload_0
    //   105: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   108: iconst_0
    //   109: invokevirtual 244	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   112: aload_0
    //   113: iconst_2
    //   114: invokespecial 217	com/tencent/mobileqq/highway/conn/TcpConnection:closeConn	(I)V
    //   117: iconst_0
    //   118: istore 17
    //   120: iconst_0
    //   121: istore 15
    //   123: iconst_0
    //   124: istore 18
    //   126: iconst_0
    //   127: istore 14
    //   129: bipush 14
    //   131: istore 4
    //   133: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   136: lstore 12
    //   138: ldc2_w 505
    //   141: lstore 10
    //   143: iload 4
    //   145: istore 6
    //   147: aload_0
    //   148: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   151: ldc2_w 251
    //   154: getstatic 258	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   157: invokevirtual 262	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   160: istore 16
    //   162: iload 4
    //   164: istore 6
    //   166: iload 16
    //   168: ifeq +910 -> 1078
    //   171: iload 17
    //   173: istore 14
    //   175: iload 4
    //   177: istore 6
    //   179: lload 10
    //   181: lstore 8
    //   183: iload 18
    //   185: istore 16
    //   187: iload 4
    //   189: istore 5
    //   191: aload_0
    //   192: new 508	java/net/InetSocketAddress
    //   195: dup
    //   196: aload_1
    //   197: getfield 493	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   200: aload_1
    //   201: getfield 498	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   204: invokespecial 511	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   207: putfield 513	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   210: iload 17
    //   212: istore 14
    //   214: iload 4
    //   216: istore 6
    //   218: lload 10
    //   220: lstore 8
    //   222: iload 18
    //   224: istore 16
    //   226: iload 4
    //   228: istore 5
    //   230: aload_0
    //   231: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   234: iconst_0
    //   235: invokevirtual 244	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   238: iload 17
    //   240: istore 14
    //   242: iload 4
    //   244: istore 6
    //   246: lload 10
    //   248: lstore 8
    //   250: iload 18
    //   252: istore 16
    //   254: iload 4
    //   256: istore 5
    //   258: aload_0
    //   259: new 280	java/net/Socket
    //   262: dup
    //   263: invokespecial 514	java/net/Socket:<init>	()V
    //   266: putfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   269: iload 17
    //   271: istore 14
    //   273: iload 4
    //   275: istore 6
    //   277: lload 10
    //   279: lstore 8
    //   281: iload 18
    //   283: istore 16
    //   285: iload 4
    //   287: istore 5
    //   289: aload_0
    //   290: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   293: iconst_1
    //   294: invokevirtual 517	java/net/Socket:setKeepAlive	(Z)V
    //   297: iload 17
    //   299: istore 14
    //   301: iload 4
    //   303: istore 6
    //   305: lload 10
    //   307: lstore 8
    //   309: iload 18
    //   311: istore 16
    //   313: iload 4
    //   315: istore 5
    //   317: aload_0
    //   318: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   321: iconst_1
    //   322: invokevirtual 520	java/net/Socket:setTcpNoDelay	(Z)V
    //   325: iload 17
    //   327: istore 14
    //   329: iload 4
    //   331: istore 6
    //   333: lload 10
    //   335: lstore 8
    //   337: iload 18
    //   339: istore 16
    //   341: iload 4
    //   343: istore 5
    //   345: aload_0
    //   346: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   349: aload_0
    //   350: getfield 132	com/tencent/mobileqq/highway/conn/TcpConnection:mReadTimeout	I
    //   353: invokevirtual 523	java/net/Socket:setSoTimeout	(I)V
    //   356: iload 17
    //   358: istore 14
    //   360: iload 4
    //   362: istore 6
    //   364: lload 10
    //   366: lstore 8
    //   368: iload 18
    //   370: istore 16
    //   372: iload 4
    //   374: istore 5
    //   376: aload_0
    //   377: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   380: ldc 27
    //   382: invokevirtual 526	java/net/Socket:setSendBufferSize	(I)V
    //   385: iload 17
    //   387: istore 14
    //   389: iload 4
    //   391: istore 6
    //   393: lload 10
    //   395: lstore 8
    //   397: iload 18
    //   399: istore 16
    //   401: iload 4
    //   403: istore 5
    //   405: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   408: lstore 10
    //   410: iload 17
    //   412: istore 14
    //   414: iload 4
    //   416: istore 6
    //   418: lload 10
    //   420: lstore 8
    //   422: iload 18
    //   424: istore 16
    //   426: iload 4
    //   428: istore 5
    //   430: aload_0
    //   431: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   434: aload_0
    //   435: getfield 513	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   438: aload_0
    //   439: getfield 138	com/tencent/mobileqq/highway/conn/TcpConnection:mConnTimeOut	I
    //   442: invokevirtual 530	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   445: iload 17
    //   447: istore 14
    //   449: iload 4
    //   451: istore 6
    //   453: lload 10
    //   455: lstore 8
    //   457: iload 18
    //   459: istore 16
    //   461: iload 4
    //   463: istore 5
    //   465: aload_0
    //   466: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   469: lload 10
    //   471: lsub
    //   472: putfield 351	com/tencent/mobileqq/highway/conn/TcpConnection:mRtt	J
    //   475: iload 17
    //   477: istore 14
    //   479: iload 4
    //   481: istore 6
    //   483: lload 10
    //   485: lstore 8
    //   487: iload 18
    //   489: istore 16
    //   491: iload 4
    //   493: istore 5
    //   495: aload_0
    //   496: aload_0
    //   497: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   500: invokevirtual 534	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   503: putfield 275	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   506: iload 17
    //   508: istore 14
    //   510: iload 4
    //   512: istore 6
    //   514: lload 10
    //   516: lstore 8
    //   518: iload 18
    //   520: istore 16
    //   522: iload 4
    //   524: istore 5
    //   526: aload_0
    //   527: new 264	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   530: dup
    //   531: aload_0
    //   532: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   535: aload_0
    //   536: getfield 130	com/tencent/mobileqq/highway/conn/TcpConnection:mReadBufferSize	I
    //   539: ldc_w 536
    //   542: iconst_m1
    //   543: invokespecial 539	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   546: putfield 203	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   549: iload 17
    //   551: istore 14
    //   553: iload 4
    //   555: istore 6
    //   557: lload 10
    //   559: lstore 8
    //   561: iload 18
    //   563: istore 16
    //   565: iload 4
    //   567: istore 5
    //   569: iconst_1
    //   570: aload_0
    //   571: getfield 203	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   574: getfield 268	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   577: invokevirtual 269	java/lang/Object:toString	()Ljava/lang/String;
    //   580: invokestatic 273	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   583: iload 17
    //   585: istore 14
    //   587: iload 4
    //   589: istore 6
    //   591: lload 10
    //   593: lstore 8
    //   595: iload 18
    //   597: istore 16
    //   599: iload 4
    //   601: istore 5
    //   603: iconst_1
    //   604: aload_0
    //   605: getfield 275	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   608: invokevirtual 269	java/lang/Object:toString	()Ljava/lang/String;
    //   611: invokestatic 273	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   614: iload 17
    //   616: istore 14
    //   618: iload 4
    //   620: istore 6
    //   622: lload 10
    //   624: lstore 8
    //   626: iload 18
    //   628: istore 16
    //   630: iload 4
    //   632: istore 5
    //   634: aload_0
    //   635: new 15	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread
    //   638: dup
    //   639: aload_0
    //   640: invokespecial 541	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;)V
    //   643: putfield 285	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   646: iload 17
    //   648: istore 14
    //   650: iload 4
    //   652: istore 6
    //   654: lload 10
    //   656: lstore 8
    //   658: iload 18
    //   660: istore 16
    //   662: iload 4
    //   664: istore 5
    //   666: aload_0
    //   667: getfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   670: iconst_1
    //   671: invokevirtual 244	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   674: iload 17
    //   676: istore 14
    //   678: iload 4
    //   680: istore 6
    //   682: lload 10
    //   684: lstore 8
    //   686: iload 18
    //   688: istore 16
    //   690: iload 4
    //   692: istore 5
    //   694: aload_0
    //   695: getfield 285	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   698: invokevirtual 542	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:start	()V
    //   701: iload 17
    //   703: istore 14
    //   705: iload 4
    //   707: istore 6
    //   709: lload 10
    //   711: lstore 8
    //   713: iload 18
    //   715: istore 16
    //   717: iload 4
    //   719: istore 5
    //   721: aload_0
    //   722: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   725: iconst_1
    //   726: invokevirtual 244	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   729: iconst_1
    //   730: istore 15
    //   732: iconst_1
    //   733: istore 18
    //   735: iconst_1
    //   736: istore 19
    //   738: iconst_1
    //   739: istore 17
    //   741: iload 15
    //   743: istore 14
    //   745: iload 4
    //   747: istore 6
    //   749: lload 10
    //   751: lstore 8
    //   753: iload 19
    //   755: istore 16
    //   757: iload 4
    //   759: istore 5
    //   761: new 104	java/lang/StringBuilder
    //   764: dup
    //   765: ldc_w 544
    //   768: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   771: astore_2
    //   772: iload 15
    //   774: istore 14
    //   776: iload 4
    //   778: istore 6
    //   780: lload 10
    //   782: lstore 8
    //   784: iload 19
    //   786: istore 16
    //   788: iload 4
    //   790: istore 5
    //   792: aload_0
    //   793: getfield 136	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   796: getfield 493	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   799: ldc_w 546
    //   802: invokevirtual 552	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   805: ifeq +131 -> 936
    //   808: iload 15
    //   810: istore 14
    //   812: iload 4
    //   814: istore 6
    //   816: lload 10
    //   818: lstore 8
    //   820: iload 19
    //   822: istore 16
    //   824: iload 4
    //   826: istore 5
    //   828: aload_0
    //   829: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   832: invokevirtual 556	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   835: astore_3
    //   836: aload_3
    //   837: ifnull +99 -> 936
    //   840: iload 15
    //   842: istore 14
    //   844: iload 4
    //   846: istore 6
    //   848: lload 10
    //   850: lstore 8
    //   852: iload 19
    //   854: istore 16
    //   856: iload 4
    //   858: istore 5
    //   860: aload_3
    //   861: instanceof 508
    //   864: ifeq +72 -> 936
    //   867: iload 15
    //   869: istore 14
    //   871: iload 4
    //   873: istore 6
    //   875: lload 10
    //   877: lstore 8
    //   879: iload 19
    //   881: istore 16
    //   883: iload 4
    //   885: istore 5
    //   887: aload_3
    //   888: checkcast 508	java/net/InetSocketAddress
    //   891: invokevirtual 560	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   894: invokevirtual 565	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   897: astore_3
    //   898: iload 15
    //   900: istore 14
    //   902: iload 4
    //   904: istore 6
    //   906: lload 10
    //   908: lstore 8
    //   910: iload 19
    //   912: istore 16
    //   914: iload 4
    //   916: istore 5
    //   918: aload_2
    //   919: ldc_w 567
    //   922: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: aload_3
    //   926: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: ldc_w 569
    //   932: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: iconst_0
    //   937: istore 6
    //   939: iconst_0
    //   940: istore 7
    //   942: iconst_0
    //   943: istore 5
    //   945: iconst_0
    //   946: istore 4
    //   948: iload 15
    //   950: istore 14
    //   952: lload 10
    //   954: lstore 8
    //   956: iload 19
    //   958: istore 16
    //   960: ldc_w 326
    //   963: new 104	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   970: ldc_w 571
    //   973: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload_1
    //   977: getfield 493	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   980: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: ldc_w 495
    //   986: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: aload_1
    //   990: getfield 498	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   993: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   996: ldc_w 500
    //   999: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload_0
    //   1003: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1006: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1009: ldc_w 573
    //   1012: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: lload 10
    //   1017: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1020: ldc_w 575
    //   1023: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload_2
    //   1027: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: ldc_w 577
    //   1036: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload_0
    //   1040: getfield 246	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   1043: invokevirtual 580	java/net/Socket:getLocalPort	()I
    //   1046: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokestatic 339	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   1055: iload 18
    //   1057: istore 15
    //   1059: iload 7
    //   1061: istore 6
    //   1063: aload_0
    //   1064: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1067: invokevirtual 316	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1070: iload 4
    //   1072: istore 6
    //   1074: iload 17
    //   1076: istore 14
    //   1078: aload_0
    //   1079: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1082: iload 14
    //   1084: putfield 583	com/tencent/mobileqq/highway/conn/ConnReportInfo:result	Z
    //   1087: aload_0
    //   1088: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1091: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   1094: aload_0
    //   1095: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1098: getfield 297	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   1101: lsub
    //   1102: putfield 586	com/tencent/mobileqq/highway/conn/ConnReportInfo:connElapseTime	J
    //   1105: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   1108: lstore 8
    //   1110: aload_0
    //   1111: getfield 318	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1114: ifnull +100 -> 1214
    //   1117: ldc -25
    //   1119: iconst_1
    //   1120: new 104	java/lang/StringBuilder
    //   1123: dup
    //   1124: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1127: ldc_w 588
    //   1130: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: aload_0
    //   1134: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1137: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1140: ldc_w 590
    //   1143: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: iload 14
    //   1148: invokevirtual 333	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1151: ldc_w 592
    //   1154: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: iload 6
    //   1159: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: ldc_w 594
    //   1165: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: lload 8
    //   1170: lload 12
    //   1172: lsub
    //   1173: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1176: ldc_w 596
    //   1179: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1188: aload_0
    //   1189: getfield 318	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1192: iload 14
    //   1194: aload_0
    //   1195: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1198: aload_0
    //   1199: aload_0
    //   1200: getfield 136	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   1203: iload 6
    //   1205: aload_0
    //   1206: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1209: invokeinterface 600 7 0
    //   1214: iload 14
    //   1216: ifeq +687 -> 1903
    //   1219: aload_0
    //   1220: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1223: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   1226: putfield 603	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeBegin	J
    //   1229: aload_0
    //   1230: getfield 195	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1233: invokevirtual 606	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:wakeupToWrite	()V
    //   1236: iload 6
    //   1238: ireturn
    //   1239: astore_2
    //   1240: iload 14
    //   1242: istore 16
    //   1244: iload 6
    //   1246: istore 5
    //   1248: aload_0
    //   1249: getfield 128	com/tencent/mobileqq/highway/conn/TcpConnection:connManager	Lcom/tencent/mobileqq/highway/conn/ConnManager;
    //   1252: invokevirtual 609	com/tencent/mobileqq/highway/conn/ConnManager:hasNet	()Z
    //   1255: istore 15
    //   1257: iload 14
    //   1259: istore 16
    //   1261: iload 6
    //   1263: istore 5
    //   1265: ldc_w 326
    //   1268: new 104	java/lang/StringBuilder
    //   1271: dup
    //   1272: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1275: ldc_w 611
    //   1278: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: aload_1
    //   1282: getfield 493	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1285: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: ldc_w 495
    //   1291: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: aload_1
    //   1295: getfield 498	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1298: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1301: ldc_w 500
    //   1304: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload_0
    //   1308: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1311: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1314: ldc_w 573
    //   1317: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: lload 8
    //   1322: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1325: ldc_w 613
    //   1328: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: iload 15
    //   1333: invokevirtual 333	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1336: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1339: aload_2
    //   1340: invokestatic 345	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1343: iload 14
    //   1345: istore 16
    //   1347: iload 6
    //   1349: istore 5
    //   1351: aload_2
    //   1352: invokevirtual 614	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1355: invokevirtual 617	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1358: astore_3
    //   1359: iload 15
    //   1361: ifne +79 -> 1440
    //   1364: iconst_3
    //   1365: istore 4
    //   1367: iload 14
    //   1369: istore 15
    //   1371: iload 4
    //   1373: istore 6
    //   1375: aload_0
    //   1376: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1379: invokevirtual 316	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1382: iload 4
    //   1384: istore 6
    //   1386: goto -308 -> 1078
    //   1389: astore_2
    //   1390: ldc_w 326
    //   1393: new 104	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1400: ldc_w 619
    //   1403: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload_1
    //   1407: getfield 493	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1410: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: ldc_w 495
    //   1416: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: aload_1
    //   1420: getfield 498	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1423: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1426: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1429: aload_2
    //   1430: invokestatic 345	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1433: iload 15
    //   1435: istore 14
    //   1437: goto -359 -> 1078
    //   1440: iload 14
    //   1442: istore 16
    //   1444: iload 6
    //   1446: istore 5
    //   1448: aload_3
    //   1449: ldc_w 621
    //   1452: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1455: iconst_m1
    //   1456: if_icmple +9 -> 1465
    //   1459: iconst_1
    //   1460: istore 4
    //   1462: goto -95 -> 1367
    //   1465: iload 14
    //   1467: istore 16
    //   1469: iload 6
    //   1471: istore 5
    //   1473: aload_3
    //   1474: ldc_w 627
    //   1477: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1480: iconst_m1
    //   1481: if_icmple +9 -> 1490
    //   1484: iconst_2
    //   1485: istore 4
    //   1487: goto -120 -> 1367
    //   1490: iload 14
    //   1492: istore 16
    //   1494: iload 6
    //   1496: istore 5
    //   1498: aload_3
    //   1499: ldc_w 629
    //   1502: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1505: iconst_m1
    //   1506: if_icmple +9 -> 1515
    //   1509: iconst_3
    //   1510: istore 4
    //   1512: goto -145 -> 1367
    //   1515: iload 14
    //   1517: istore 16
    //   1519: iload 6
    //   1521: istore 5
    //   1523: aload_3
    //   1524: ldc_w 631
    //   1527: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1530: iconst_m1
    //   1531: if_icmple +9 -> 1540
    //   1534: iconst_4
    //   1535: istore 4
    //   1537: goto -170 -> 1367
    //   1540: iload 14
    //   1542: istore 16
    //   1544: iload 6
    //   1546: istore 5
    //   1548: aload_3
    //   1549: ldc_w 633
    //   1552: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1555: iconst_m1
    //   1556: if_icmple +9 -> 1565
    //   1559: iconst_5
    //   1560: istore 4
    //   1562: goto -195 -> 1367
    //   1565: iload 14
    //   1567: istore 16
    //   1569: iload 6
    //   1571: istore 5
    //   1573: aload_3
    //   1574: ldc_w 635
    //   1577: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1580: iconst_m1
    //   1581: if_icmple +10 -> 1591
    //   1584: bipush 6
    //   1586: istore 4
    //   1588: goto -221 -> 1367
    //   1591: iload 14
    //   1593: istore 16
    //   1595: iload 6
    //   1597: istore 5
    //   1599: aload_3
    //   1600: ldc_w 637
    //   1603: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1606: iconst_m1
    //   1607: if_icmpgt +306 -> 1913
    //   1610: iload 14
    //   1612: istore 16
    //   1614: iload 6
    //   1616: istore 5
    //   1618: aload_3
    //   1619: ldc_w 639
    //   1622: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1625: iconst_m1
    //   1626: if_icmple +6 -> 1632
    //   1629: goto +284 -> 1913
    //   1632: iload 14
    //   1634: istore 16
    //   1636: iload 6
    //   1638: istore 5
    //   1640: aload_3
    //   1641: ldc_w 641
    //   1644: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1647: iconst_m1
    //   1648: if_icmple +10 -> 1658
    //   1651: bipush 8
    //   1653: istore 4
    //   1655: goto -288 -> 1367
    //   1658: iload 14
    //   1660: istore 16
    //   1662: iload 6
    //   1664: istore 5
    //   1666: aload_3
    //   1667: ldc_w 643
    //   1670: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1673: iconst_m1
    //   1674: if_icmple +10 -> 1684
    //   1677: bipush 9
    //   1679: istore 4
    //   1681: goto -314 -> 1367
    //   1684: iload 14
    //   1686: istore 16
    //   1688: iload 6
    //   1690: istore 5
    //   1692: aload_3
    //   1693: ldc_w 645
    //   1696: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1699: iconst_m1
    //   1700: if_icmple +10 -> 1710
    //   1703: bipush 10
    //   1705: istore 4
    //   1707: goto -340 -> 1367
    //   1710: iload 14
    //   1712: istore 16
    //   1714: iload 6
    //   1716: istore 5
    //   1718: aload_3
    //   1719: ldc_w 647
    //   1722: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1725: iconst_m1
    //   1726: if_icmple +10 -> 1736
    //   1729: bipush 11
    //   1731: istore 4
    //   1733: goto -366 -> 1367
    //   1736: iload 14
    //   1738: istore 16
    //   1740: iload 6
    //   1742: istore 5
    //   1744: aload_3
    //   1745: ldc_w 649
    //   1748: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1751: iconst_m1
    //   1752: if_icmple +10 -> 1762
    //   1755: bipush 12
    //   1757: istore 4
    //   1759: goto -392 -> 1367
    //   1762: iload 14
    //   1764: istore 16
    //   1766: iload 6
    //   1768: istore 5
    //   1770: aload_3
    //   1771: ldc_w 651
    //   1774: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1777: iconst_m1
    //   1778: if_icmple +10 -> 1788
    //   1781: bipush 7
    //   1783: istore 4
    //   1785: goto -418 -> 1367
    //   1788: iload 14
    //   1790: istore 16
    //   1792: iload 6
    //   1794: istore 5
    //   1796: aload_3
    //   1797: ldc_w 653
    //   1800: invokevirtual 625	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1803: iconst_m1
    //   1804: if_icmple +10 -> 1814
    //   1807: bipush 13
    //   1809: istore 4
    //   1811: goto -444 -> 1367
    //   1814: bipush 14
    //   1816: istore 6
    //   1818: iload 14
    //   1820: istore 16
    //   1822: iload 6
    //   1824: istore 5
    //   1826: aload_2
    //   1827: invokestatic 659	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1830: astore_2
    //   1831: iload 6
    //   1833: istore 4
    //   1835: iload 14
    //   1837: istore 16
    //   1839: iload 6
    //   1841: istore 5
    //   1843: aload_2
    //   1844: invokevirtual 662	java/lang/String:length	()I
    //   1847: sipush 200
    //   1850: if_icmple -483 -> 1367
    //   1853: iload 14
    //   1855: istore 16
    //   1857: iload 6
    //   1859: istore 5
    //   1861: aload_2
    //   1862: iconst_0
    //   1863: sipush 200
    //   1866: invokevirtual 666	java/lang/String:substring	(II)Ljava/lang/String;
    //   1869: pop
    //   1870: iload 6
    //   1872: istore 4
    //   1874: goto -507 -> 1367
    //   1877: astore_2
    //   1878: iload 16
    //   1880: istore 15
    //   1882: iload 5
    //   1884: istore 6
    //   1886: aload_0
    //   1887: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1890: invokevirtual 316	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1893: iload 16
    //   1895: istore 15
    //   1897: iload 5
    //   1899: istore 6
    //   1901: aload_2
    //   1902: athrow
    //   1903: aload_0
    //   1904: getfield 195	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1907: invokevirtual 278	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
    //   1910: iload 6
    //   1912: ireturn
    //   1913: bipush 7
    //   1915: istore 4
    //   1917: goto -550 -> 1367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1920	0	this	TcpConnection
    //   0	1920	1	paramEndPoint	EndPoint
    //   771	256	2	localStringBuilder	StringBuilder
    //   1239	113	2	localThrowable	Throwable
    //   1389	438	2	localInterruptedException	InterruptedException
    //   1830	32	2	str	String
    //   1877	25	2	localObject1	Object
    //   835	962	3	localObject2	Object
    //   131	1785	4	i	int
    //   189	1709	5	j	int
    //   145	1766	6	k	int
    //   940	120	7	m	int
    //   181	1140	8	l1	long
    //   141	875	10	l2	long
    //   136	1035	12	l3	long
    //   127	1727	14	bool1	boolean
    //   121	1775	15	bool2	boolean
    //   160	1734	16	bool3	boolean
    //   118	957	17	bool4	boolean
    //   124	932	18	bool5	boolean
    //   736	221	19	bool6	boolean
    // Exception table:
    //   from	to	target	type
    //   191	210	1239	java/lang/Throwable
    //   230	238	1239	java/lang/Throwable
    //   258	269	1239	java/lang/Throwable
    //   289	297	1239	java/lang/Throwable
    //   317	325	1239	java/lang/Throwable
    //   345	356	1239	java/lang/Throwable
    //   376	385	1239	java/lang/Throwable
    //   405	410	1239	java/lang/Throwable
    //   430	445	1239	java/lang/Throwable
    //   465	475	1239	java/lang/Throwable
    //   495	506	1239	java/lang/Throwable
    //   526	549	1239	java/lang/Throwable
    //   569	583	1239	java/lang/Throwable
    //   603	614	1239	java/lang/Throwable
    //   634	646	1239	java/lang/Throwable
    //   666	674	1239	java/lang/Throwable
    //   694	701	1239	java/lang/Throwable
    //   721	729	1239	java/lang/Throwable
    //   761	772	1239	java/lang/Throwable
    //   792	808	1239	java/lang/Throwable
    //   828	836	1239	java/lang/Throwable
    //   860	867	1239	java/lang/Throwable
    //   887	898	1239	java/lang/Throwable
    //   918	936	1239	java/lang/Throwable
    //   960	1055	1239	java/lang/Throwable
    //   147	162	1389	java/lang/InterruptedException
    //   1063	1070	1389	java/lang/InterruptedException
    //   1375	1382	1389	java/lang/InterruptedException
    //   1886	1893	1389	java/lang/InterruptedException
    //   1901	1903	1389	java/lang/InterruptedException
    //   191	210	1877	finally
    //   230	238	1877	finally
    //   258	269	1877	finally
    //   289	297	1877	finally
    //   317	325	1877	finally
    //   345	356	1877	finally
    //   376	385	1877	finally
    //   405	410	1877	finally
    //   430	445	1877	finally
    //   465	475	1877	finally
    //   495	506	1877	finally
    //   526	549	1877	finally
    //   569	583	1877	finally
    //   603	614	1877	finally
    //   634	646	1877	finally
    //   666	674	1877	finally
    //   694	701	1877	finally
    //   721	729	1877	finally
    //   761	772	1877	finally
    //   792	808	1877	finally
    //   828	836	1877	finally
    //   860	867	1877	finally
    //   887	898	1877	finally
    //   918	936	1877	finally
    //   960	1055	1877	finally
    //   1248	1257	1877	finally
    //   1265	1343	1877	finally
    //   1351	1359	1877	finally
    //   1448	1459	1877	finally
    //   1473	1484	1877	finally
    //   1498	1509	1877	finally
    //   1523	1534	1877	finally
    //   1548	1559	1877	finally
    //   1573	1584	1877	finally
    //   1599	1610	1877	finally
    //   1618	1629	1877	finally
    //   1640	1651	1877	finally
    //   1666	1677	1877	finally
    //   1692	1703	1877	finally
    //   1718	1729	1877	finally
    //   1744	1755	1877	finally
    //   1770	1781	1877	finally
    //   1796	1807	1877	finally
    //   1826	1831	1877	finally
    //   1843	1853	1877	finally
    //   1861	1870	1877	finally
  }
  
  public static void setExclusiveStream(boolean paramBoolean, String paramString)
  {
    synchronized (BaseApplication.exclusiveStreamList)
    {
      ArrayList localArrayList2 = BaseApplication.exclusiveStreamList;
      if (paramBoolean)
      {
        localArrayList2.add(paramString);
        return;
      }
      localArrayList2.remove(paramString);
    }
  }
  
  public void connect()
  {
    BdhLogUtil.LogEvent("C", "Connect : About to send conn request.");
    this.mConnThread.start();
    this.mConnHandler = new ConnWorker(this.mConnThread.getLooper());
    this.mConnHandler.sendEmptyMessage(1);
    this.connInfo.connStartTime = SystemClock.uptimeMillis();
    this.connInfo.serverIp = this.mEp.host;
    this.connInfo.port = this.mEp.port;
  }
  
  public void disConnect()
  {
    synchronized (this.closeDebug)
    {
      this.closeDebug.append("By : disConnect;");
      closeConn(3);
      return;
    }
  }
  
  public int getConnId()
  {
    return this.connId;
  }
  
  public EndPoint getEndPoint()
  {
    return this.mEp;
  }
  
  public int getProtoType()
  {
    return 1;
  }
  
  public boolean isWritable()
  {
    return (this.isRunning.get()) && (!this.isWritting.get());
  }
  
  public void onDecodeInvalidData(int paramInt)
  {
    QLog.d("BDH_LOG", 1, "C.  ConnId:" + this.connId + " Host:" + this.mEp.host + " Port:" + this.mEp.port + " OnDecodeInvalidData : code : " + paramInt);
    if (this.connListener != null) {
      this.connListener.onRecvInvalidData(this.mEp);
    }
    disConnect();
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    this.connInfo.recvRespCount = paramList.size();
    this.connManager.onDecodeSucessfully(paramList);
  }
  
  public void onEncodePkgError(HwRequest paramHwRequest, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    HwResponse localHwResponse = new HwResponse();
    localHwResponse.hwSeq = paramHwRequest.getHwSeq();
    localHwResponse.cmd = paramHwRequest.hwCmd;
    localHwResponse.errCode = paramInt;
    localHwResponse.recvTime = SystemClock.uptimeMillis();
    localHwResponse.shouldRetry = false;
    this.connManager.onDecodeSucessfully(localArrayList);
  }
  
  public void setConnectListener(IConnectionListener paramIConnectionListener)
  {
    this.connListener = paramIConnectionListener;
  }
  
  public void setUrgentFlag(boolean paramBoolean)
  {
    this.isUrgent = paramBoolean;
    wakeupChannel();
  }
  
  public void wakeupChannel()
  {
    ConnWorker localConnWorker = this.mConnHandler;
    if ((this.isRunning.get()) && (localConnWorker != null)) {
      localConnWorker.wakeupToWrite();
    }
  }
  
  class ConnWorker
    extends Handler
  {
    public static final int CONN = 1;
    public static final int QUIT = 3;
    public static final int SEND = 2;
    
    public ConnWorker(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {
        TcpConnection.this.openConn(TcpConnection.this.mEp);
      }
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          TcpConnection.this.doSendData();
          return;
        }
      } while (paramMessage.what != 3);
      TcpConnection.this.mConnThread.quit();
      TcpConnection.access$1102(TcpConnection.this, null);
      TcpConnection.access$1202(TcpConnection.this, null);
    }
    
    public void notifyToQuit()
    {
      if (TcpConnection.this.mConnHandler != null) {
        TcpConnection.this.mConnHandler.sendEmptyMessage(3);
      }
    }
    
    public void wakeupToWrite()
    {
      ConnWorker localConnWorker = TcpConnection.this.mConnHandler;
      if (localConnWorker != null) {
        localConnWorker.sendEmptyMessage(2);
      }
    }
  }
  
  class ReadThread
    extends Thread
  {
    ReadThread() {}
    
    public void run()
    {
      while (TcpConnection.this.isRunning.get()) {
        try
        {
          ??? = TcpConnection.this.mInputBuffer;
          if (??? == null) {
            return;
          }
          while (!((MsfSocketInputBuffer)???).isDataAvailable(30000)) {
            if (!TcpConnection.this.isRunning.get()) {
              return;
            }
          }
          if (TcpConnection.this.isRunning.get())
          {
            int i = ((MsfSocketInputBuffer)???).getBufferlen();
            ConnReportInfo localConnReportInfo = TcpConnection.this.connInfo;
            localConnReportInfo.receiveDataLen += i;
            TcpConnection.this.connManager.increaseDataFlowDw(i);
            TcpConnection.access$412(TcpConnection.this, i);
            TcpConnection.this.dataCodec.onRecvData((MsfSocketInputBuffer)???);
            ((MsfSocketInputBuffer)???).reset();
          }
        }
        catch (Exception localException)
        {
          BdhLogUtil.LogException("C", "ReadThread Error.", localException);
          synchronized (TcpConnection.this.closeDebug)
          {
            TcpConnection.this.closeDebug.append("By ReadThread : " + localException.getMessage() + ";");
            TcpConnection.this.closeConn(1);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\conn\TcpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */