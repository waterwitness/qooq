package com.tencent.mobileqq.highway.transaction;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.netprobe.ProbeCallback;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.highway.netprobe.ProbeItem.ProbeResult;
import com.tencent.mobileqq.highway.netprobe.ProbeResponse;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.DataHole;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.QueryHoleRsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Transaction
  implements ProbeCallback
{
  public static final long C2C_FileSize_Limit = 19922944L;
  public static final int HOLE_MASK_FIN = 3;
  public static final int HOLE_MASK_HOLD = 4;
  public static final int HOLE_MASK_INIT = 0;
  public static final int HOLE_MASK_SENT = 2;
  public static final int HOLE_MASK_WAIT = 1;
  public static final int HOLE_SIZE_PER_HOLE = 4096;
  private static final int MAX_QUERY_HOLE_RSP_SIZE = 5;
  public byte[] MD5;
  public Tracker TRACKER;
  private AtomicBoolean TimerStarted = new AtomicBoolean(false);
  public volatile boolean bQueryForFIN;
  public byte[] bitmap;
  public int cacheIp;
  private ITransactionCallback cb;
  public byte[] extendInfo;
  public String filePath;
  public AtomicBoolean hasSwitch2BackupChannel = new AtomicBoolean(false);
  public AtomicBoolean isFinish = new AtomicBoolean(false);
  public boolean isOpenUpEnable;
  public AtomicBoolean isSuccess = new AtomicBoolean(false);
  public CSDataHighwayHead.LoginSigHead loginSigHead;
  public byte[] mBuExtendinfo;
  public int mBuzCmdId;
  private int mErrorCode = -1;
  private AtomicBoolean mIsPause = new AtomicBoolean(false);
  private HashMap<String, String> mReport = new HashMap();
  public TransTimeOutMonitor mTimeOutMonitor;
  public TransReport mTransReport = new TransReport();
  private TransactionWorker mTransWorker;
  private int offset;
  public String peerUin;
  public int preSendDots;
  private RandomAccessFile raf;
  public byte[] ticket;
  public int totalLength;
  int transationId = -1;
  private int transferedSize;
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback)
  {
    this.peerUin = paramString1;
    this.filePath = paramString2;
    this.offset = paramInt2;
    this.mBuzCmdId = paramInt1;
    this.MD5 = paramArrayOfByte2;
    this.ticket = paramArrayOfByte1;
    this.cb = paramITransactionCallback;
    if (this.offset < 0) {
      this.offset = 0;
    }
    this.isOpenUpEnable = false;
  }
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback, int paramInt3, byte[] paramArrayOfByte3, CSDataHighwayHead.LoginSigHead paramLoginSigHead)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramITransactionCallback);
    this.isOpenUpEnable = true;
    this.preSendDots = paramInt3;
    this.extendInfo = paramArrayOfByte3;
    this.loginSigHead = paramLoginSigHead;
  }
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback, byte[] paramArrayOfByte3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramITransactionCallback);
    this.extendInfo = paramArrayOfByte3;
  }
  
  private void extendTimeExceedLimit()
  {
    TransTimeOutMonitor localTransTimeOutMonitor = this.mTimeOutMonitor;
    if (localTransTimeOutMonitor.needExtendTimeExceedLimit())
    {
      BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " ExtendTimeExceedLimit.");
      localTransTimeOutMonitor.isKilled = true;
      if (this.mTransWorker != null)
      {
        this.mTimeOutMonitor = new TransTimeOutMonitor();
        this.mTransWorker.startTransRunnable(localTransTimeOutMonitor, this.mTimeOutMonitor);
      }
    }
  }
  
  private void finishAndDetachFromWorker(boolean paramBoolean)
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish. IsSuccess:" + paramBoolean);
    if (this.mTransWorker != null)
    {
      this.mTransWorker.onTransactionFinish(paramBoolean, this);
      this.mTransWorker = null;
    }
    try
    {
      if (this.raf != null)
      {
        this.raf.close();
        this.raf = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish Error: IsSuccess:" + paramBoolean, localIOException);
    }
  }
  
  private boolean isPause()
  {
    return this.mIsPause.get();
  }
  
  private void startTimeoutTimer()
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "startTimeoutTimer.");
    Object localObject = this.cb;
    if (localObject != null) {
      ((ITransactionCallback)localObject).onTransStart();
    }
    if (this.mTransWorker != null)
    {
      localObject = this.mTimeOutMonitor;
      ((TransTimeOutMonitor)localObject).isKilled = true;
      this.mTimeOutMonitor = new TransTimeOutMonitor();
      this.mTransWorker.startTransRunnable((Runnable)localObject, this.mTimeOutMonitor);
    }
  }
  
  private void stopTimeoutTimer()
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " StopTimeoutTime.");
    this.TimerStarted.set(false);
    if (this.mTimeOutMonitor != null) {
      this.mTimeOutMonitor.isKilled = true;
    }
    if (this.mTransWorker != null) {
      this.mTransWorker.stopTransRunnable(this.mTimeOutMonitor);
    }
  }
  
  private HashMap<String, String> updateAndGetReporter()
  {
    this.mTransReport.ipConnCost = this.mTransWorker.getIpConnectCost();
    this.mTransReport.dataFlow = this.mTransWorker.getReportDataFlow();
    this.mTransReport.ipAddr = this.mTransWorker.getLastUsedIp();
    this.mTransReport.port = this.mTransWorker.getLastUsedPort();
    this.mTransReport.mTransferedSize = this.transferedSize;
    return this.mTransReport.getReportInfo();
  }
  
  public void cancelTransaction()
  {
    if (!this.isFinish.compareAndSet(false, true)) {
      return;
    }
    this.TRACKER.logStep("CANCL", "");
    stopTimeoutTimer();
    finishAndDetachFromWorker(false);
  }
  
  public void continueTrans()
  {
    QLog.d("BDH_LOG", 1, "T \tT_ID:" + getTransationId() + "\tcontinueTrans.");
    if (this.isFinish.get()) {
      return;
    }
    int j = this.totalLength / 4096;
    int i = j;
    if (this.totalLength % 4096 != 0) {
      i = j + 1;
    }
    j = this.preSendDots;
    while (j < i)
    {
      if (this.bitmap[j] == 4) {
        this.bitmap[j] = 0;
      }
      j += 1;
    }
    this.mTransWorker.notifyToSend();
  }
  
  public int getBuzType()
  {
    if (this.mBuzCmdId == 12) {
      return 1;
    }
    if ((this.mBuzCmdId == 1) || (this.mBuzCmdId == 4)) {
      return 0;
    }
    return 0;
  }
  
  /* Error */
  public byte[] getData(DataTransInfo paramDataTransInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 88	com/tencent/mobileqq/highway/transaction/Transaction:isFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 217	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifeq +14 -> 23
    //   12: aload_1
    //   13: iconst_0
    //   14: putfield 322	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: iconst_0
    //   24: istore 5
    //   26: aload_1
    //   27: getfield 325	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   30: istore 4
    //   32: aload_1
    //   33: getfield 325	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   36: newarray <illegal type>
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 202	com/tencent/mobileqq/highway/transaction/Transaction:raf	Ljava/io/RandomAccessFile;
    //   43: aload_1
    //   44: getfield 326	com/tencent/mobileqq/highway/transaction/DataTransInfo:offset	I
    //   47: i2l
    //   48: invokevirtual 330	java/io/RandomAccessFile:seek	(J)V
    //   51: aload_3
    //   52: astore_2
    //   53: iload 5
    //   55: aload_1
    //   56: getfield 325	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   59: if_icmpge -40 -> 19
    //   62: aload_0
    //   63: getfield 202	com/tencent/mobileqq/highway/transaction/Transaction:raf	Ljava/io/RandomAccessFile;
    //   66: aload_3
    //   67: iload 5
    //   69: iload 4
    //   71: invokevirtual 334	java/io/RandomAccessFile:read	([BII)I
    //   74: istore 6
    //   76: iload 6
    //   78: iconst_m1
    //   79: if_icmpne +15 -> 94
    //   82: aload_1
    //   83: sipush 9303
    //   86: putfield 322	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   89: aconst_null
    //   90: astore_2
    //   91: goto -72 -> 19
    //   94: iload 5
    //   96: iload 6
    //   98: iadd
    //   99: istore 5
    //   101: iload 4
    //   103: iload 6
    //   105: isub
    //   106: istore 4
    //   108: goto -57 -> 51
    //   111: astore_2
    //   112: ldc -112
    //   114: new 146	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   121: ldc -107
    //   123: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 116	com/tencent/mobileqq/highway/transaction/Transaction:mBuzCmdId	I
    //   130: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc -98
    //   135: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: invokevirtual 162	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   142: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc_w 336
    //   148: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload_2
    //   155: invokestatic 213	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_1
    //   159: aload_2
    //   160: invokestatic 342	com/tencent/mobileqq/highway/utils/BdhUtils:analysisIOProblem	(Ljava/io/IOException;)I
    //   163: putfield 322	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   166: aconst_null
    //   167: astore_2
    //   168: goto -149 -> 19
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	Transaction
    //   0	176	1	paramDataTransInfo	DataTransInfo
    //   18	73	2	localObject1	Object
    //   111	49	2	localIOException	IOException
    //   167	1	2	localObject2	Object
    //   38	29	3	arrayOfByte	byte[]
    //   30	77	4	i	int
    //   24	76	5	j	int
    //   74	32	6	k	int
    // Exception table:
    //   from	to	target	type
    //   26	51	111	java/io/IOException
    //   53	76	111	java/io/IOException
    //   82	89	111	java/io/IOException
    //   2	17	171	finally
    //   26	51	171	finally
    //   53	76	171	finally
    //   82	89	171	finally
    //   112	166	171	finally
  }
  
  public int getTransationId()
  {
    return this.transationId;
  }
  
  int initSegmentList(TransactionWorker paramTransactionWorker, boolean paramBoolean)
  {
    QLog.d("BDH_LOG", 1, "T T_ID:" + getTransationId() + "\tinitSegmentList : " + "\tisOpenUpEnable : " + this.isOpenUpEnable);
    this.mTransReport.mIsPreConnExist = paramBoolean;
    File localFile = new File(this.filePath);
    this.mTransWorker = paramTransactionWorker;
    if (localFile.exists())
    {
      if (!localFile.canRead()) {
        return 9070;
      }
      this.totalLength = ((int)localFile.length());
      if (this.totalLength > 19922944L) {
        return 9063;
      }
      if (this.totalLength <= 0) {
        return 9071;
      }
      int i;
      int k;
      for (;;)
      {
        try
        {
          this.raf = new RandomAccessFile(localFile, "r");
          j = this.totalLength / 4096;
          i = j;
          if (this.totalLength % 4096 != 0) {
            i = j + 1;
          }
          k = this.offset / 4096;
          this.bitmap = new byte[i];
          if (!this.isOpenUpEnable) {
            break;
          }
          j = 0;
          if (j >= i) {
            break label296;
          }
          if (j < this.preSendDots)
          {
            this.bitmap[j] = 0;
            j += 1;
          }
          else
          {
            this.bitmap[j] = 4;
          }
        }
        catch (FileNotFoundException paramTransactionWorker)
        {
          return 9042;
        }
      }
      int j = 0;
      if (j < i)
      {
        if (j < k) {
          this.bitmap[j] = 3;
        }
        for (;;)
        {
          j += 1;
          break;
          this.bitmap[j] = 0;
        }
      }
      label296:
      this.TRACKER = new Tracker(this.transationId, this.totalLength);
      this.mTimeOutMonitor = new TransTimeOutMonitor();
      this.TRACKER.logStep("INITI", "DotsNum:" + i + " StartHole:" + k);
      return 0;
    }
    return 9042;
  }
  
  public void onProbeFinish(ProbeResponse paramProbeResponse)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    Iterator localIterator1 = paramProbeResponse.mProbeItemResults.keySet().iterator();
    while (localIterator1.hasNext())
    {
      paramProbeResponse = (ProbeItem)localIterator1.next();
      if ("ProbeChain".equals(paramProbeResponse.getProbeName()))
      {
        Iterator localIterator2 = ((ProbeChain)paramProbeResponse).chain.iterator();
        label68:
        ProbeItem localProbeItem;
        StringBuilder localStringBuilder2;
        while (localIterator2.hasNext())
        {
          localProbeItem = (ProbeItem)localIterator2.next();
          if (localProbeItem.mResult != null)
          {
            localStringBuilder2 = localStringBuilder1.append(localProbeItem.getProbeName()).append("[");
            if (!localProbeItem.mResult.success) {
              break label169;
            }
          }
        }
        label169:
        for (paramProbeResponse = "1";; paramProbeResponse = "0")
        {
          localStringBuilder2.append(paramProbeResponse).append("]").append("[").append(localProbeItem.mResult.errCode).append("];");
          break label68;
          break;
        }
      }
    }
    paramProbeResponse = (String)this.mReport.get("rep_bdhTrans");
    if (paramProbeResponse != null)
    {
      paramProbeResponse = paramProbeResponse + localStringBuilder1;
      this.mReport.put("rep_bdhTrans", paramProbeResponse);
    }
    if (this.cb != null) {
      this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
    }
  }
  
  public void onProbeProgress(String paramString) {}
  
  public void onQuertHoleError(byte[] paramArrayOfByte)
  {
    if (this.isFinish.get()) {
      return;
    }
    BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " QueryDebug Query OnQuertHoleError : CopyBitmap:" + Arrays.toString(paramArrayOfByte) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
    int i = 0;
    while (i < this.bitmap.length)
    {
      if ((this.bitmap[i] != 3) && (paramArrayOfByte[i] == 2)) {
        this.bitmap[i] = 0;
      }
      i += 1;
    }
    this.TRACKER.logStep("QUERY", "QueryHoleError Bitmap:" + Arrays.toString(this.bitmap));
    this.mTransWorker.notifyToSend();
  }
  
  public void onQueryHoleResp(CSDataHighwayHead.QueryHoleRsp paramQueryHoleRsp, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (this.isFinish.get()) {
      return;
    }
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + " \tT_ID:" + getTransationId() + "\tQueryHoleResp。");
    int i = paramQueryHoleRsp.uint32_result.get();
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    BdhUtils.copyData(arrayOfByte, 0, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (i != 0)
    {
      onQuertHoleError(paramArrayOfByte);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Holes:");
    paramQueryHoleRsp = paramQueryHoleRsp.rpt_data_hole.get();
    i = 0;
    if ((paramQueryHoleRsp != null) && (!paramQueryHoleRsp.isEmpty()))
    {
      Iterator localIterator = paramQueryHoleRsp.iterator();
      if (localIterator.hasNext())
      {
        CSDataHighwayHead.DataHole localDataHole = (CSDataHighwayHead.DataHole)localIterator.next();
        int n = (int)localDataHole.uint64_begin.get();
        int i1 = (int)localDataHole.uint64_end.get();
        int k = n / 4096;
        int m = (i1 - 1) / 4096;
        j = i;
        if (m > i) {
          j = m;
        }
        localStringBuilder.append("Holes Start:").append(k).append(" End:").append(m);
        BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : holes : " + " HoleStart:" + n + " HoleEnd:" + i1 + " BitmapS:" + k + " BitmapE:" + m);
        for (;;)
        {
          i = j;
          if (k > m) {
            break;
          }
          if (paramArrayOfByte[k] == 2) {
            paramArrayOfByte[k] = 0;
          }
          k += 1;
        }
      }
      int j = i;
      if (i >= paramArrayOfByte.length) {
        j = paramArrayOfByte.length - 1;
      }
      if (paramQueryHoleRsp.size() >= 5) {
        while (j < paramArrayOfByte.length)
        {
          paramArrayOfByte[j] = 0;
          j += 1;
        }
      }
      i = 0;
      if (i < paramArrayOfByte.length)
      {
        if ((arrayOfByte[i] == 2) && (paramArrayOfByte[i] == 0) && ((this.bQueryForFIN) || (this.bitmap[i] != 3))) {
          this.bitmap[i] = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramArrayOfByte[i] == 2) {
            this.bitmap[i] = 3;
          }
        }
      }
    }
    else
    {
      localStringBuilder.append("null");
    }
    this.TRACKER.logStep("QUERY", "QueryHoleResp " + localStringBuilder.toString());
    BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : Merged :" + " CopyBitmap:" + Arrays.toString(paramArrayOfByte) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
    this.mTransWorker.notifyToSend();
  }
  
  public void onSwitchToBackupChannel()
  {
    stopTimeoutTimer();
    if (this.hasSwitch2BackupChannel.get()) {}
    do
    {
      return;
      this.hasSwitch2BackupChannel.set(true);
    } while (this.cb == null);
    this.cb.onSwitch2BackupChannel();
  }
  
  public void onTransFailed(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    if (!this.isFinish.compareAndSet(false, true)) {}
    label118:
    label481:
    label531:
    label564:
    do
    {
      return;
      BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnTransFailed : ERR_C:" + paramInt1 + " ERR_H:" + paramInt2 + " ERR_B:" + paramInt3);
      stopTimeoutTimer();
      this.mTransReport.updateRetryInfo(paramInt4);
      this.mBuExtendinfo = paramArrayOfByte;
      this.mErrorCode = paramInt1;
      if (paramInt3 != 0)
      {
        this.mErrorCode = paramInt3;
        if (this.mTransWorker != null)
        {
          this.mTransReport.bHasNet = this.mTransWorker.updateAndCheckNet();
          this.mTransReport.isConnected = this.mTransWorker.isNetworkConnected();
          this.mTransReport.connErrCode = this.mTransWorker.getConnErroCode();
          this.mTransReport.setFailReason(this.mErrorCode, paramString);
          if ((this.mErrorCode == 64534) || (this.mErrorCode == 64531))
          {
            this.mTransWorker.dumpEngineInfo();
            paramString = this.TRACKER.dumpTrackerInfo();
            this.TRACKER.logStep("QUERY", "TransFailed  Bitmap:" + Arrays.toString(this.bitmap));
            QLog.d("T", 1, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " TRACEKERINFO:" + paramString);
            if (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode)) {
              this.mErrorCode = 9004;
            }
          }
          if ((this.mBuzCmdId != 1) && (this.mBuzCmdId != 2) && (this.mBuzCmdId != 4)) {
            break label531;
          }
          if ((this.mTransReport.bHasNet) && (!BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))) {
            break label481;
          }
          this.mErrorCode = 9004;
        }
      }
      for (;;)
      {
        this.mReport = updateAndGetReporter();
        if ((!this.mTransReport.bHasNet) || ((paramInt1 != 64534) && (paramInt1 != 64531) && (paramInt1 != 64533) && (paramInt1 != 64522))) {
          break label564;
        }
        boolean bool = this.mTransWorker.startNetDetection(this);
        finishAndDetachFromWorker(false);
        if ((bool) || (this.cb == null)) {
          break;
        }
        this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
        return;
        if (paramInt2 == 0) {
          break label118;
        }
        this.mErrorCode = paramInt2;
        break label118;
        if ((this.mErrorCode <= 0) && ((!this.mTransReport.bHasNet) || (!this.mTransReport.isConnected) || (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))))
        {
          this.mErrorCode = 9004;
          continue;
          if ((!this.mTransReport.bHasNet) || (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))) {
            this.mErrorCode = 9004;
          }
        }
      }
      finishAndDetachFromWorker(false);
    } while (this.cb == null);
    this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
  }
  
  public void onTransProgress(DataTransInfo paramDataTransInfo)
  {
    if (this.isFinish.get()) {}
    do
    {
      do
      {
        int m;
        int n;
        do
        {
          return;
          extendTimeExceedLimit();
          this.mTransReport.updateRetryInfo(paramDataTransInfo.retryTimes);
          if (paramDataTransInfo != null)
          {
            localObject = this.mTransReport;
            ((TransReport)localObject).timeCost_Send = ((int)(((TransReport)localObject).timeCost_Send + (paramDataTransInfo.timeCost_req - paramDataTransInfo.timeCost_hw - paramDataTransInfo.timeCost_cache)));
            localObject = this.mTransReport;
            ((TransReport)localObject).timeCost_Ht = ((int)(((TransReport)localObject).timeCost_Ht + paramDataTransInfo.timeCost_hw));
            localObject = this.mTransReport;
            ((TransReport)localObject).timeCost_Cache = ((int)(((TransReport)localObject).timeCost_Cache + paramDataTransInfo.timeCost_cache));
          }
          m = paramDataTransInfo.bitmapS;
          n = paramDataTransInfo.bitmapE;
        } while (n >= this.bitmap.length);
        i = m;
        while (i <= n)
        {
          this.bitmap[i] = 3;
          i += 1;
        }
        int j = 0;
        i = 0;
        while (i < this.bitmap.length)
        {
          int k = j;
          if (this.bitmap[i] == 3) {
            k = j + 1;
          }
          i += 1;
          j = k;
        }
        this.transferedSize = (j * 4096);
        if (this.bitmap[(this.bitmap.length - 1)] == 3) {
          this.transferedSize -= this.bitmap.length * 4096 - this.totalLength;
        }
        if (this.transferedSize >= this.totalLength)
        {
          BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "NotifySegmentProgress Error : Finish flag is lost.");
          this.mTransReport.bFINLost = true;
        }
        if (this.cb != null)
        {
          BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentProgress" + " Total:" + this.totalLength + " TransSize:" + this.transferedSize + " allHoles:" + this.bitmap.length + " [" + m + ":" + n + "]");
          this.cb.onUpdateProgress(this.transferedSize);
        }
        this.TRACKER.logStep("PRGRS", "TransProgress Start:" + m + " End:" + n);
      } while ((!this.mTransReport.bFINLost) || (this.bQueryForFIN));
      this.bQueryForFIN = true;
      paramDataTransInfo = this.mTransWorker;
    } while (paramDataTransInfo == null);
    Object localObject = new byte[this.bitmap.length];
    int i = 0;
    while (i <= this.bitmap.length - 1)
    {
      localObject[i] = 2;
      i += 1;
    }
    paramDataTransInfo.queryTransaction(this, (byte[])localObject);
    this.TRACKER.logStep("QUERY", "FinFlagLost  Bitmap:" + Arrays.toString(this.bitmap));
  }
  
  public void onTransSuccess(DataTransInfo paramDataTransInfo, byte[] paramArrayOfByte)
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentSuccess");
    if (!this.isFinish.compareAndSet(false, true)) {}
    do
    {
      return;
      this.isSuccess.set(true);
      stopTimeoutTimer();
      if (paramDataTransInfo != null) {
        this.mTransReport.updateRetryInfo(paramDataTransInfo.retryTimes);
      }
      if (paramDataTransInfo != null)
      {
        TransReport localTransReport = this.mTransReport;
        localTransReport.timeCost_Send = ((int)(localTransReport.timeCost_Send + (paramDataTransInfo.timeCost_req - paramDataTransInfo.timeCost_hw - paramDataTransInfo.timeCost_cache)));
        localTransReport = this.mTransReport;
        localTransReport.timeCost_Ht = ((int)(localTransReport.timeCost_Ht + paramDataTransInfo.timeCost_hw));
        localTransReport = this.mTransReport;
        localTransReport.timeCost_Cache = ((int)(localTransReport.timeCost_Cache + paramDataTransInfo.timeCost_cache));
      }
      paramDataTransInfo = updateAndGetReporter();
      finishAndDetachFromWorker(true);
      this.mBuExtendinfo = paramArrayOfByte;
      this.transferedSize = this.totalLength;
    } while (this.cb == null);
    this.cb.onSuccess(this.mBuExtendinfo, paramDataTransInfo);
  }
  
  DataTransInfo peekNextSegment(HwNetSegConf paramHwNetSegConf)
  {
    int j = (int)paramHwNetSegConf.segSize;
    if ((this.isFinish.get()) || (isPause())) {
      paramHwNetSegConf = null;
    }
    DataTransInfo localDataTransInfo;
    label189:
    label387:
    do
    {
      int i;
      int i1;
      int k;
      int m;
      do
      {
        do
        {
          return paramHwNetSegConf;
          if ((this.mTransReport.confSegSize == 0L) && (paramHwNetSegConf != null))
          {
            this.mTransReport.confSegSize = ((int)paramHwNetSegConf.segSize);
            this.mTransReport.confSegNum = ((int)paramHwNetSegConf.segNum);
            this.mTransReport.confConnNum = ((int)paramHwNetSegConf.curConnNum);
          }
          i = j / 4096;
          int n = i;
          if (j % 4096 > 0) {
            n = i + 1;
          }
          localDataTransInfo = null;
          j = -1;
          i1 = -1;
          i = 0;
          k = i1;
          m = j;
          if (i < this.bitmap.length)
          {
            if (this.bitmap[i] != 0) {
              break;
            }
            k = j;
            if (j == -1) {
              k = i;
            }
            if (i != this.bitmap.length - 1)
            {
              m = k;
              if (n != i + 1 - k) {
                break label387;
              }
            }
            m = k;
            k = i;
          }
          paramHwNetSegConf = localDataTransInfo;
        } while (m == -1);
        paramHwNetSegConf = localDataTransInfo;
      } while (k == -1);
      paramHwNetSegConf = this.mTransReport;
      paramHwNetSegConf.sliceNum += 1;
      localDataTransInfo = new DataTransInfo(this);
      localDataTransInfo.fileSize = this.totalLength;
      localDataTransInfo.offset = (m * 4096);
      localDataTransInfo.bitmapS = m;
      localDataTransInfo.bitmapE = k;
      if (k == this.bitmap.length - 1) {}
      for (localDataTransInfo.length = ((k - m) * 4096 + (this.totalLength - (this.bitmap.length - 1) * 4096));; localDataTransInfo.length = ((k - m + 1) * 4096))
      {
        i = m;
        while (i <= k)
        {
          this.bitmap[i] = 1;
          i += 1;
        }
        if ((this.isOpenUpEnable) && (this.bitmap[i] == 4))
        {
          k = i1;
          if (j != -1) {
            k = i - 1;
          }
          stopTimeoutTimer();
          m = j;
          break label189;
        }
        m = j;
        if (j != -1)
        {
          k = i;
          m = j;
          break label189;
        }
        i += 1;
        j = m;
        break;
      }
      this.TRACKER.logStep("SLICE", "Start:" + m + " End:" + k + " Length:" + localDataTransInfo.length);
      paramHwNetSegConf = localDataTransInfo;
    } while (!this.TimerStarted.compareAndSet(false, true));
    startTimeoutTimer();
    return localDataTransInfo;
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.mIsPause.set(paramBoolean);
    if (isPause()) {
      stopTimeoutTimer();
    }
  }
  
  public static abstract interface HwBuzType
  {
    public static final int COMMON = 0;
    public static final int PIC = 0;
    public static final int PIC_SUBBUZ_COMMON = 1;
    public static final int PIC_SUBBUZ_OPENUP = 4;
    public static final int SHORT_VIDEO = 1;
    public static final int SHORT_VIDEO_SUBBUZ = 12;
  }
  
  class TransTimeOutMonitor
    implements Runnable
  {
    public volatile boolean isKilled;
    public long mStartTime = SystemClock.uptimeMillis();
    
    public TransTimeOutMonitor() {}
    
    public boolean needExtendTimeExceedLimit()
    {
      return SystemClock.uptimeMillis() - this.mStartTime >= 60000L;
    }
    
    public void run()
    {
      if (!this.isKilled) {
        Transaction.this.onTransFailed(64534, "TransTimeOut", 64534, 64534, 0, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\transaction\Transaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */