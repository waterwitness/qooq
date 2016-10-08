package com.weiyun.sdk.job.transfer;

import android.os.Build.VERSION;
import android.os.SystemClock;
import com.weiyun.sdk.ErrorCode;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.report.WeiyunReport;
import com.weiyun.sdk.report.WeiyunReportObj;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class BaseDownloadTransfer
  implements Transfer
{
  private static final String TAG = "BaseDownloadTransfer";
  protected final DownloadJobContext mContext;
  protected RandomAccessFile mDestFileWriter;
  protected final AddressFetcher.TransferAddress mDownloadAddress;
  protected final BaseDownloadJob mJob;
  protected long mOffset;
  private final Transfer.ProcessInfo mProcessInfo;
  protected long mSplitSize = 8388608L;
  protected long mStartTime;
  protected int mTimeoutTimes = 0;
  protected boolean mUseSplitDownload = false;
  
  public BaseDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    this.mDownloadAddress = paramTransferAddress;
    this.mContext = paramDownloadJobContext;
    this.mJob = paramBaseDownloadJob;
    this.mProcessInfo = new Transfer.ProcessInfo();
    try
    {
      this.mProcessInfo.url = createUrl().toString();
      this.mProcessInfo.flowId = Global.generateRandomId(new Object[] { this.mProcessInfo.url, this });
      this.mProcessInfo.startTime = SystemClock.uptimeMillis();
      return;
    }
    catch (MalformedURLException paramTransferAddress)
    {
      for (;;) {}
    }
  }
  
  private Transfer.Result checkJob()
  {
    if (!this.mJob.isAlive()) {
      return new Transfer.Result(55534, "取消了上传、下载过程!");
    }
    if (!this.mJob.checkEnvironment()) {
      return new Transfer.Result(this.mJob.getLastErrorNo(), "没有网络!");
    }
    return null;
  }
  
  private void doInnerReport(Transfer.Result paramResult, Transfer.ProcessInfo paramProcessInfo)
  {
    if (!Global.isInit()) {
      return;
    }
    WeiyunReportObj localWeiyunReportObj = new WeiyunReportObj(1);
    localWeiyunReportObj.network = NetworkUtils.getNetworkTypeForReport(Global.getContext());
    localWeiyunReportObj.dns_ip = paramProcessInfo.dns;
    localWeiyunReportObj.client_ip = paramProcessInfo.clientIp;
    localWeiyunReportObj.server_ip = paramProcessInfo.hostIp;
    localWeiyunReportObj.server_port = paramProcessInfo.hostPort;
    localWeiyunReportObj.flow_id = paramProcessInfo.flowId;
    localWeiyunReportObj.url = paramProcessInfo.url;
    localWeiyunReportObj.retry_times = paramProcessInfo.attemptCount;
    localWeiyunReportObj.conn_time = paramProcessInfo.connTimeCost;
    localWeiyunReportObj.recv_rsp = paramProcessInfo.recvRspTimeCost;
    localWeiyunReportObj.recv_data = paramProcessInfo.transferDataTimeCost;
    localWeiyunReportObj.total_delay = (SystemClock.uptimeMillis() - paramProcessInfo.startTime);
    localWeiyunReportObj.total_size = this.mContext.getTotalSize();
    localWeiyunReportObj.file_name = this.mContext.getFileName();
    localWeiyunReportObj.file_id = ('/' + this.mContext.getParentDirKey() + '/' + this.mContext.getFileId());
    localWeiyunReportObj.file_size = paramProcessInfo.transferDataSize;
    localWeiyunReportObj.file_path = this.mContext.getDestFilePath();
    localWeiyunReportObj.file_md5 = this.mContext.getMd5();
    localWeiyunReportObj.err_code = paramResult.mRet;
    localWeiyunReportObj.err_msg = paramResult.mErrMsg;
    if (paramProcessInfo.failException == null) {}
    for (paramResult = null;; paramResult = android.util.Log.getStackTraceString(paramProcessInfo.failException))
    {
      localWeiyunReportObj.exception = paramResult;
      if (paramProcessInfo.transferDataTimeCost > 0L) {
        localWeiyunReportObj.file_speed = (paramProcessInfo.transferDataSize / paramProcessInfo.transferDataTimeCost);
      }
      WeiyunReport.uploadReport(localWeiyunReportObj);
      return;
    }
  }
  
  private Transfer.Result handleError(boolean paramBoolean, int paramInt, Transfer.Result paramResult)
  {
    long l;
    if ((paramResult.mRet == 35534) || (paramResult.mRet == 35508) || (paramResult.mRet == 35507))
    {
      this.mTimeoutTimes += 1;
      if ((!ErrorCode.isNetworkError(paramResult.mRet)) || (!paramBoolean) || (!this.mJob.isAlive())) {
        break label206;
      }
      l = (1200.0D * Math.pow(paramInt, 0.5D));
      com.weiyun.sdk.log.Log.i("BaseDownloadTransfer", "Last transfer network error, so rollback, sleep time = " + l + ", id = " + this.mJob.getId());
    }
    for (;;)
    {
      try
      {
        Thread.sleep(l);
        if ((paramResult.mRet == 35520) && (NetworkUtils.isCnwapConnection(null)) && (isSupportSplitDownload()))
        {
          if (this.mUseSplitDownload) {
            break label274;
          }
          this.mUseSplitDownload = true;
        }
        return new Transfer.Result(0, null);
      }
      catch (InterruptedException paramResult)
      {
        com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", paramResult.getMessage(), paramResult);
        return new Transfer.Result(55534, Utils.getStackTraceAsString(paramResult));
      }
      this.mTimeoutTimes = 0;
      break;
      label206:
      if ((paramResult.mRet == 36426) || (paramResult.mRet == 36530))
      {
        com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", "file offset is wrong! offset :" + this.mContext.getCurSize());
        return cutFileToZero();
      }
      if (paramResult.mRet == 36333)
      {
        return paramResult;
        label274:
        this.mSplitSize /= 2L;
        this.mSplitSize = Math.max(this.mSplitSize, 8192L);
      }
    }
  }
  
  private void report(Transfer.Result paramResult)
  {
    switch (paramResult.mRet)
    {
    default: 
      this.mJob.reportDownloadTransferSize(3, paramResult.mRet, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
    }
    for (;;)
    {
      doInnerReport(paramResult, this.mProcessInfo);
      return;
      this.mJob.reportDownloadTransferSize(0, 0, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
      continue;
      this.mJob.reportDownloadTransferSize(1, 55534, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
    }
  }
  
  protected Transfer.Result acquireResource()
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject2 = localObject1;
    if (j < 2) {}
    try
    {
      this.mDestFileWriter = new RandomAccessFile(this.mContext.getDataFilePath(), "rwd");
      i = 0;
      localObject2 = localObject1;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localObject1 = localFileNotFoundException;
        com.weiyun.sdk.log.Log.e("BaseDownloadTransfer", "", localFileNotFoundException);
        if (Utils.checkFileExist(this.mContext.getDataDirectoryPath()))
        {
          i = 55528;
          localObject3 = localObject1;
        }
        else
        {
          if (Utils.checkDirAndCreate(this.mContext.getDataDirectoryPath())) {
            break;
          }
          i = 55528;
          localObject3 = localObject1;
        }
      }
      i = 55530;
      j += 1;
    }
    if (i != 0) {
      this.mProcessInfo.failException = ((Throwable)localObject2);
    }
    if (localObject2 == null) {}
    Object localObject3;
    for (localObject1 = null;; localObject1 = Utils.getStackTraceAsString((Throwable)localObject3))
    {
      return new Transfer.Result(i, (String)localObject1);
      break;
    }
  }
  
  protected URL createUrl()
    throws MalformedURLException
  {
    return new URL("http", this.mDownloadAddress.getHost(), this.mDownloadAddress.getPort(), this.mDownloadAddress.getFile());
  }
  
  protected Transfer.Result cutFileToZero()
  {
    this.mOffset = 0L;
    this.mContext.setCurSize(0L);
    try
    {
      this.mDestFileWriter.setLength(0L);
      return new Transfer.Result(0, null);
    }
    catch (IOException localIOException)
    {
      com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", localIOException);
      this.mProcessInfo.failException = localIOException;
      return new Transfer.Result(55528, Utils.getStackTraceAsString(localIOException));
    }
  }
  
  protected Transfer.Result doDownload()
  {
    if (!isSupportContinueInterruption())
    {
      localResult = cutFileToZero();
      if (localResult.mRet != 0) {
        return localResult;
      }
    }
    Transfer.Result localResult = doDownloadImpl();
    if ((localResult.mRet == 55534) && (this.mContext.getTotalSize() != 0L) && (this.mContext.getTotalSize() == this.mContext.getCurSize()))
    {
      com.weiyun.sdk.log.Log.i("BaseDownloadTransfer", "user canceled a finished job!");
      return new Transfer.Result(0, null);
    }
    return localResult;
  }
  
  /* Error */
  protected Transfer.Result doDownloadImpl()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 13
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 10
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore 9
    //   23: iconst_0
    //   24: istore 18
    //   26: iconst_0
    //   27: istore 17
    //   29: iload 18
    //   31: istore 15
    //   33: aload_2
    //   34: astore 6
    //   36: iload 17
    //   38: istore 16
    //   40: aload 12
    //   42: astore 7
    //   44: aload 11
    //   46: astore 5
    //   48: aload 13
    //   50: astore_1
    //   51: aload 4
    //   53: astore_3
    //   54: aload_0
    //   55: invokevirtual 58	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:createUrl	()Ljava/net/URL;
    //   58: astore 14
    //   60: iload 18
    //   62: istore 15
    //   64: aload_2
    //   65: astore 6
    //   67: iload 17
    //   69: istore 16
    //   71: aload 12
    //   73: astore 7
    //   75: aload 11
    //   77: astore 5
    //   79: aload 13
    //   81: astore_1
    //   82: aload 4
    //   84: astore_3
    //   85: aload 14
    //   87: invokevirtual 444	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 446	java/net/HttpURLConnection
    //   93: astore_2
    //   94: iload 18
    //   96: istore 15
    //   98: aload_2
    //   99: astore 6
    //   101: iload 17
    //   103: istore 16
    //   105: aload_2
    //   106: astore 7
    //   108: aload_2
    //   109: astore 5
    //   111: aload_2
    //   112: astore_1
    //   113: aload 4
    //   115: astore_3
    //   116: aload_0
    //   117: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   120: aload_2
    //   121: invokevirtual 449	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   124: invokevirtual 450	java/net/URL:getHost	()Ljava/lang/String;
    //   127: invokevirtual 454	com/weiyun/sdk/job/DownloadJobContext:setServerip	(Ljava/lang/String;)V
    //   130: iload 18
    //   132: istore 15
    //   134: aload_2
    //   135: astore 6
    //   137: iload 17
    //   139: istore 16
    //   141: aload_2
    //   142: astore 7
    //   144: aload_2
    //   145: astore 5
    //   147: aload_2
    //   148: astore_1
    //   149: aload 4
    //   151: astore_3
    //   152: aload_0
    //   153: aload_2
    //   154: invokevirtual 458	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:setHttpHeader	(Ljava/net/HttpURLConnection;)V
    //   157: iload 18
    //   159: istore 15
    //   161: aload_2
    //   162: astore 6
    //   164: iload 17
    //   166: istore 16
    //   168: aload_2
    //   169: astore 7
    //   171: aload_2
    //   172: astore 5
    //   174: aload_2
    //   175: astore_1
    //   176: aload 4
    //   178: astore_3
    //   179: aload_0
    //   180: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   183: aload 14
    //   185: invokevirtual 64	java/net/URL:toString	()Ljava/lang/String;
    //   188: putfield 67	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:url	Ljava/lang/String;
    //   191: iload 18
    //   193: istore 15
    //   195: aload_2
    //   196: astore 6
    //   198: iload 17
    //   200: istore 16
    //   202: aload_2
    //   203: astore 7
    //   205: aload_2
    //   206: astore 5
    //   208: aload_2
    //   209: astore_1
    //   210: aload 4
    //   212: astore_3
    //   213: aload_0
    //   214: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   217: aload_2
    //   218: invokevirtual 449	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   221: invokevirtual 450	java/net/URL:getHost	()Ljava/lang/String;
    //   224: putfield 148	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:hostIp	Ljava/lang/String;
    //   227: iload 18
    //   229: istore 15
    //   231: aload_2
    //   232: astore 6
    //   234: iload 17
    //   236: istore 16
    //   238: aload_2
    //   239: astore 7
    //   241: aload_2
    //   242: astore 5
    //   244: aload_2
    //   245: astore_1
    //   246: aload 4
    //   248: astore_3
    //   249: aload_0
    //   250: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   253: aload_2
    //   254: invokevirtual 449	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   257: invokevirtual 459	java/net/URL:getPort	()I
    //   260: invokestatic 464	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   263: putfield 154	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:hostPort	Ljava/lang/String;
    //   266: iload 18
    //   268: istore 15
    //   270: aload_2
    //   271: astore 6
    //   273: iload 17
    //   275: istore 16
    //   277: aload_2
    //   278: astore 7
    //   280: aload_2
    //   281: astore 5
    //   283: aload_2
    //   284: astore_1
    //   285: aload 4
    //   287: astore_3
    //   288: invokestatic 115	com/weiyun/sdk/Global:isInit	()Z
    //   291: ifeq +38 -> 329
    //   294: iload 18
    //   296: istore 15
    //   298: aload_2
    //   299: astore 6
    //   301: iload 17
    //   303: istore 16
    //   305: aload_2
    //   306: astore 7
    //   308: aload_2
    //   309: astore 5
    //   311: aload_2
    //   312: astore_1
    //   313: aload 4
    //   315: astore_3
    //   316: aload_0
    //   317: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   320: invokestatic 124	com/weiyun/sdk/Global:getContext	()Landroid/content/Context;
    //   323: invokestatic 468	com/weiyun/sdk/util/NetworkUtils:getDns	(Landroid/content/Context;)Ljava/lang/String;
    //   326: putfield 136	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:dns	Ljava/lang/String;
    //   329: iload 18
    //   331: istore 15
    //   333: aload_2
    //   334: astore 6
    //   336: iload 17
    //   338: istore 16
    //   340: aload_2
    //   341: astore 7
    //   343: aload_2
    //   344: astore 5
    //   346: aload_2
    //   347: astore_1
    //   348: aload 4
    //   350: astore_3
    //   351: invokestatic 82	android/os/SystemClock:uptimeMillis	()J
    //   354: lstore 23
    //   356: iload 18
    //   358: istore 15
    //   360: aload_2
    //   361: astore 6
    //   363: iload 17
    //   365: istore 16
    //   367: aload_2
    //   368: astore 7
    //   370: aload_2
    //   371: astore 5
    //   373: aload_2
    //   374: astore_1
    //   375: aload 4
    //   377: astore_3
    //   378: aload_0
    //   379: getfield 49	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mJob	Lcom/weiyun/sdk/job/BaseDownloadJob;
    //   382: invokevirtual 94	com/weiyun/sdk/job/BaseDownloadJob:isAlive	()Z
    //   385: ifne +103 -> 488
    //   388: iload 18
    //   390: istore 15
    //   392: aload_2
    //   393: astore 6
    //   395: iload 17
    //   397: istore 16
    //   399: aload_2
    //   400: astore 7
    //   402: aload_2
    //   403: astore 5
    //   405: aload_2
    //   406: astore_1
    //   407: aload 4
    //   409: astore_3
    //   410: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   413: dup
    //   414: sipush 55534
    //   417: ldc 98
    //   419: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   422: astore 4
    //   424: iconst_0
    //   425: ifeq +11 -> 436
    //   428: new 470	java/lang/NullPointerException
    //   431: dup
    //   432: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   435: athrow
    //   436: aload 4
    //   438: astore_1
    //   439: aload_2
    //   440: ifnull +10 -> 450
    //   443: aload_2
    //   444: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   447: aload 4
    //   449: astore_1
    //   450: aload_1
    //   451: areturn
    //   452: astore_1
    //   453: ldc 10
    //   455: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   458: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   461: aload_1
    //   462: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   465: aload_0
    //   466: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   469: aload_1
    //   470: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   473: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   476: dup
    //   477: sipush 35519
    //   480: aload_1
    //   481: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   484: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   487: areturn
    //   488: iload 18
    //   490: istore 15
    //   492: aload_2
    //   493: astore 6
    //   495: iload 17
    //   497: istore 16
    //   499: aload_2
    //   500: astore 7
    //   502: aload_2
    //   503: astore 5
    //   505: aload_2
    //   506: astore_1
    //   507: aload 4
    //   509: astore_3
    //   510: aload_2
    //   511: invokevirtual 484	java/net/HttpURLConnection:connect	()V
    //   514: iconst_1
    //   515: istore 18
    //   517: iconst_1
    //   518: istore 19
    //   520: iload 19
    //   522: istore 15
    //   524: aload_2
    //   525: astore 6
    //   527: iload 17
    //   529: istore 16
    //   531: aload_2
    //   532: astore 7
    //   534: aload_2
    //   535: astore 5
    //   537: aload_2
    //   538: astore_1
    //   539: aload 4
    //   541: astore_3
    //   542: aload_0
    //   543: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   546: invokestatic 82	android/os/SystemClock:uptimeMillis	()J
    //   549: lload 23
    //   551: lsub
    //   552: putfield 170	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:connTimeCost	J
    //   555: iload 19
    //   557: istore 15
    //   559: aload_2
    //   560: astore 6
    //   562: iload 17
    //   564: istore 16
    //   566: aload_2
    //   567: astore 7
    //   569: aload_2
    //   570: astore 5
    //   572: aload_2
    //   573: astore_1
    //   574: aload 4
    //   576: astore_3
    //   577: aload_2
    //   578: invokevirtual 487	java/net/HttpURLConnection:getResponseCode	()I
    //   581: istore 21
    //   583: iconst_1
    //   584: istore 17
    //   586: iconst_1
    //   587: istore 20
    //   589: iload 19
    //   591: istore 15
    //   593: aload_2
    //   594: astore 6
    //   596: iload 20
    //   598: istore 16
    //   600: aload_2
    //   601: astore 7
    //   603: aload_2
    //   604: astore 5
    //   606: aload_2
    //   607: astore_1
    //   608: aload 4
    //   610: astore_3
    //   611: aload_0
    //   612: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   615: invokestatic 82	android/os/SystemClock:uptimeMillis	()J
    //   618: lload 23
    //   620: lsub
    //   621: putfield 176	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:recvRspTimeCost	J
    //   624: iload 21
    //   626: sipush 200
    //   629: if_icmpeq +197 -> 826
    //   632: iload 21
    //   634: sipush 206
    //   637: if_icmpeq +189 -> 826
    //   640: iload 19
    //   642: istore 15
    //   644: aload_2
    //   645: astore 6
    //   647: iload 20
    //   649: istore 16
    //   651: aload_2
    //   652: astore 7
    //   654: aload_2
    //   655: astore 5
    //   657: aload_2
    //   658: astore_1
    //   659: aload 4
    //   661: astore_3
    //   662: aload_2
    //   663: ldc_w 489
    //   666: invokevirtual 493	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   669: astore 12
    //   671: aload 12
    //   673: ifnull +153 -> 826
    //   676: iload 19
    //   678: istore 15
    //   680: aload_2
    //   681: astore 6
    //   683: iload 20
    //   685: istore 16
    //   687: aload_2
    //   688: astore 7
    //   690: aload_2
    //   691: astore 5
    //   693: aload_2
    //   694: astore_1
    //   695: aload 4
    //   697: astore_3
    //   698: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   701: dup
    //   702: aload 12
    //   704: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   707: ldc_w 499
    //   710: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   713: astore 11
    //   715: iconst_0
    //   716: ifeq +11 -> 727
    //   719: new 470	java/lang/NullPointerException
    //   722: dup
    //   723: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   726: athrow
    //   727: aload 11
    //   729: astore_1
    //   730: aload_2
    //   731: ifnull -281 -> 450
    //   734: aload_2
    //   735: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   738: aload 11
    //   740: areturn
    //   741: astore_1
    //   742: ldc 10
    //   744: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   747: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   750: aload_1
    //   751: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   754: aload_0
    //   755: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   758: aload_1
    //   759: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   762: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   765: dup
    //   766: sipush 35519
    //   769: aload_1
    //   770: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   773: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   776: areturn
    //   777: astore_1
    //   778: iload 19
    //   780: istore 15
    //   782: aload_2
    //   783: astore 6
    //   785: iload 20
    //   787: istore 16
    //   789: aload_2
    //   790: astore 7
    //   792: aload_2
    //   793: astore 5
    //   795: aload_2
    //   796: astore_1
    //   797: aload 4
    //   799: astore_3
    //   800: ldc 10
    //   802: new 204	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   809: ldc_w 501
    //   812: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload 12
    //   817: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   826: iload 21
    //   828: sipush 200
    //   831: if_icmpeq +179 -> 1010
    //   834: iload 21
    //   836: sipush 206
    //   839: if_icmpeq +171 -> 1010
    //   842: iload 19
    //   844: istore 15
    //   846: aload_2
    //   847: astore 6
    //   849: iload 20
    //   851: istore 16
    //   853: aload_2
    //   854: astore 7
    //   856: aload_2
    //   857: astore 5
    //   859: aload_2
    //   860: astore_1
    //   861: aload 4
    //   863: astore_3
    //   864: ldc 10
    //   866: new 204	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 503
    //   876: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_0
    //   880: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   883: invokevirtual 199	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   886: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: ldc_w 505
    //   892: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: iload 21
    //   897: invokevirtual 508	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   900: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   906: iload 19
    //   908: istore 15
    //   910: aload_2
    //   911: astore 6
    //   913: iload 20
    //   915: istore 16
    //   917: aload_2
    //   918: astore 7
    //   920: aload_2
    //   921: astore 5
    //   923: aload_2
    //   924: astore_1
    //   925: aload 4
    //   927: astore_3
    //   928: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   931: dup
    //   932: iload 21
    //   934: sipush 30000
    //   937: isub
    //   938: iload 21
    //   940: invokestatic 513	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   943: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   946: astore 4
    //   948: iconst_0
    //   949: ifeq +11 -> 960
    //   952: new 470	java/lang/NullPointerException
    //   955: dup
    //   956: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   959: athrow
    //   960: aload 4
    //   962: astore_1
    //   963: aload_2
    //   964: ifnull -514 -> 450
    //   967: aload_2
    //   968: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   971: aload 4
    //   973: areturn
    //   974: astore_1
    //   975: ldc 10
    //   977: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   980: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   983: aload_1
    //   984: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   987: aload_0
    //   988: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   991: aload_1
    //   992: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   995: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   998: dup
    //   999: sipush 35519
    //   1002: aload_1
    //   1003: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1006: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1009: areturn
    //   1010: iload 19
    //   1012: istore 15
    //   1014: aload_2
    //   1015: astore 6
    //   1017: iload 20
    //   1019: istore 16
    //   1021: aload_2
    //   1022: astore 7
    //   1024: aload_2
    //   1025: astore 5
    //   1027: aload_2
    //   1028: astore_1
    //   1029: aload 4
    //   1031: astore_3
    //   1032: new 204	java/lang/StringBuilder
    //   1035: dup
    //   1036: ldc_w 515
    //   1039: invokespecial 517	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1042: aload_0
    //   1043: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1046: invokevirtual 199	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   1049: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: ldc_w 519
    //   1055: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: aload 14
    //   1060: invokevirtual 64	java/net/URL:toString	()Ljava/lang/String;
    //   1063: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: ldc_w 521
    //   1069: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: aload_0
    //   1073: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1076: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1079: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1082: ldc_w 523
    //   1085: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: aload_2
    //   1089: invokevirtual 526	java/net/HttpURLConnection:getContentLength	()I
    //   1092: invokevirtual 508	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: ldc2_w 527
    //   1099: lstore 27
    //   1101: ldc2_w 527
    //   1104: lstore 23
    //   1106: iload 19
    //   1108: istore 15
    //   1110: aload_2
    //   1111: astore 6
    //   1113: iload 20
    //   1115: istore 16
    //   1117: aload_2
    //   1118: astore 7
    //   1120: aload_2
    //   1121: astore 5
    //   1123: aload_2
    //   1124: astore_1
    //   1125: aload 4
    //   1127: astore_3
    //   1128: aload_2
    //   1129: ldc_w 530
    //   1132: invokevirtual 493	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1135: astore 11
    //   1137: lload 27
    //   1139: lstore 25
    //   1141: aload 11
    //   1143: ifnull +32 -> 1175
    //   1146: iload 19
    //   1148: istore 15
    //   1150: aload_2
    //   1151: astore 6
    //   1153: iload 20
    //   1155: istore 16
    //   1157: aload_2
    //   1158: astore 7
    //   1160: aload_2
    //   1161: astore 5
    //   1163: aload_2
    //   1164: astore_1
    //   1165: aload 4
    //   1167: astore_3
    //   1168: aload 11
    //   1170: invokestatic 536	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1173: lstore 25
    //   1175: iload 19
    //   1177: istore 15
    //   1179: aload_2
    //   1180: astore 6
    //   1182: iload 20
    //   1184: istore 16
    //   1186: aload_2
    //   1187: astore 7
    //   1189: aload_2
    //   1190: astore 5
    //   1192: aload_2
    //   1193: astore_1
    //   1194: aload 4
    //   1196: astore_3
    //   1197: aload_2
    //   1198: ldc_w 538
    //   1201: invokevirtual 493	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1204: astore 11
    //   1206: lload 23
    //   1208: lstore 27
    //   1210: aload 11
    //   1212: ifnull +71 -> 1283
    //   1215: iload 19
    //   1217: istore 15
    //   1219: aload_2
    //   1220: astore 6
    //   1222: iload 20
    //   1224: istore 16
    //   1226: aload_2
    //   1227: astore 7
    //   1229: aload_2
    //   1230: astore 5
    //   1232: aload_2
    //   1233: astore_1
    //   1234: aload 4
    //   1236: astore_3
    //   1237: aload 11
    //   1239: ldc_w 540
    //   1242: invokevirtual 543	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1245: istore 22
    //   1247: iload 19
    //   1249: istore 15
    //   1251: aload_2
    //   1252: astore 6
    //   1254: iload 20
    //   1256: istore 16
    //   1258: aload_2
    //   1259: astore 7
    //   1261: aload_2
    //   1262: astore_1
    //   1263: aload 4
    //   1265: astore_3
    //   1266: aload 11
    //   1268: iload 22
    //   1270: iconst_1
    //   1271: iadd
    //   1272: invokevirtual 546	java/lang/String:substring	(I)Ljava/lang/String;
    //   1275: invokestatic 549	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1278: invokevirtual 552	java/lang/Long:longValue	()J
    //   1281: lstore 27
    //   1283: ldc2_w 527
    //   1286: lstore 29
    //   1288: iload 21
    //   1290: sipush 200
    //   1293: if_icmpne +737 -> 2030
    //   1296: lload 25
    //   1298: lconst_0
    //   1299: lcmp
    //   1300: ifle +730 -> 2030
    //   1303: lload 25
    //   1305: lstore 23
    //   1307: lload 23
    //   1309: lconst_0
    //   1310: lcmp
    //   1311: ifle +875 -> 2186
    //   1314: iload 19
    //   1316: istore 15
    //   1318: aload_2
    //   1319: astore 6
    //   1321: iload 20
    //   1323: istore 16
    //   1325: aload_2
    //   1326: astore 7
    //   1328: aload_2
    //   1329: astore 5
    //   1331: aload_2
    //   1332: astore_1
    //   1333: aload 4
    //   1335: astore_3
    //   1336: aload_0
    //   1337: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1340: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1343: lconst_0
    //   1344: lcmp
    //   1345: ifgt +841 -> 2186
    //   1348: iload 19
    //   1350: istore 15
    //   1352: aload_2
    //   1353: astore 6
    //   1355: iload 20
    //   1357: istore 16
    //   1359: aload_2
    //   1360: astore 7
    //   1362: aload_2
    //   1363: astore 5
    //   1365: aload_2
    //   1366: astore_1
    //   1367: aload 4
    //   1369: astore_3
    //   1370: aload_0
    //   1371: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1374: lload 23
    //   1376: invokevirtual 555	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   1379: lload 25
    //   1381: lconst_0
    //   1382: lcmp
    //   1383: ifne +1559 -> 2942
    //   1386: iload 19
    //   1388: istore 15
    //   1390: aload_2
    //   1391: astore 6
    //   1393: iload 20
    //   1395: istore 16
    //   1397: aload_2
    //   1398: astore 7
    //   1400: aload_2
    //   1401: astore 5
    //   1403: aload_2
    //   1404: astore_1
    //   1405: aload 4
    //   1407: astore_3
    //   1408: ldc 10
    //   1410: new 204	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1417: ldc_w 557
    //   1420: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: aload_0
    //   1424: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1427: invokevirtual 199	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   1430: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: ldc_w 559
    //   1436: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1442: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1445: iload 19
    //   1447: istore 15
    //   1449: aload_2
    //   1450: astore 6
    //   1452: iload 20
    //   1454: istore 16
    //   1456: aload_2
    //   1457: astore 7
    //   1459: aload_2
    //   1460: astore 5
    //   1462: aload_2
    //   1463: astore_1
    //   1464: aload 4
    //   1466: astore_3
    //   1467: aload_0
    //   1468: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1471: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1474: lconst_0
    //   1475: lcmp
    //   1476: ifle +1264 -> 2740
    //   1479: iload 19
    //   1481: istore 15
    //   1483: aload_2
    //   1484: astore 6
    //   1486: iload 20
    //   1488: istore 16
    //   1490: aload_2
    //   1491: astore 7
    //   1493: aload_2
    //   1494: astore 5
    //   1496: aload_2
    //   1497: astore_1
    //   1498: aload 4
    //   1500: astore_3
    //   1501: aload_0
    //   1502: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1505: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1508: aload_0
    //   1509: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1512: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1515: lcmp
    //   1516: ifgt +1224 -> 2740
    //   1519: iload 19
    //   1521: istore 15
    //   1523: aload_2
    //   1524: astore 6
    //   1526: iload 20
    //   1528: istore 16
    //   1530: aload_2
    //   1531: astore 7
    //   1533: aload_2
    //   1534: astore 5
    //   1536: aload_2
    //   1537: astore_1
    //   1538: aload 4
    //   1540: astore_3
    //   1541: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1544: dup
    //   1545: iconst_0
    //   1546: aconst_null
    //   1547: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1550: astore 4
    //   1552: iconst_0
    //   1553: ifeq +11 -> 1564
    //   1556: new 470	java/lang/NullPointerException
    //   1559: dup
    //   1560: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   1563: athrow
    //   1564: aload 4
    //   1566: astore_1
    //   1567: aload_2
    //   1568: ifnull -1118 -> 450
    //   1571: aload_2
    //   1572: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   1575: aload 4
    //   1577: areturn
    //   1578: astore_1
    //   1579: ldc 10
    //   1581: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1584: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   1587: aload_1
    //   1588: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1591: aload_0
    //   1592: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1595: aload_1
    //   1596: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1599: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1602: dup
    //   1603: sipush 35519
    //   1606: aload_1
    //   1607: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1610: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1613: areturn
    //   1614: astore_1
    //   1615: iload 19
    //   1617: istore 15
    //   1619: aload_2
    //   1620: astore 6
    //   1622: iload 20
    //   1624: istore 16
    //   1626: aload_2
    //   1627: astore 7
    //   1629: aload_2
    //   1630: astore 5
    //   1632: aload_2
    //   1633: astore_1
    //   1634: aload 4
    //   1636: astore_3
    //   1637: ldc 10
    //   1639: new 204	java/lang/StringBuilder
    //   1642: dup
    //   1643: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1646: ldc_w 561
    //   1649: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: aload 11
    //   1654: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1657: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1660: invokestatic 563	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1663: lload 27
    //   1665: lstore 25
    //   1667: goto -492 -> 1175
    //   1670: astore 5
    //   1672: aload 9
    //   1674: astore 4
    //   1676: aload 6
    //   1678: astore_2
    //   1679: aload_2
    //   1680: astore_1
    //   1681: aload 4
    //   1683: astore_3
    //   1684: ldc 10
    //   1686: new 204	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1693: ldc_w 503
    //   1696: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: aload_0
    //   1700: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1703: invokevirtual 231	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1706: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1712: aload 5
    //   1714: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1717: aload_2
    //   1718: astore_1
    //   1719: aload 4
    //   1721: astore_3
    //   1722: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1725: dup
    //   1726: aload 5
    //   1728: invokestatic 569	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   1731: aload 5
    //   1733: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1736: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1739: astore 6
    //   1741: aload_2
    //   1742: astore_1
    //   1743: aload 4
    //   1745: astore_3
    //   1746: aload 6
    //   1748: getfield 243	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1751: sipush 35534
    //   1754: if_icmpne +1536 -> 3290
    //   1757: iload 15
    //   1759: ifne +1531 -> 3290
    //   1762: aload_2
    //   1763: astore_1
    //   1764: aload 4
    //   1766: astore_3
    //   1767: aload 6
    //   1769: sipush 35508
    //   1772: putfield 243	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1775: aload_2
    //   1776: astore_1
    //   1777: aload 4
    //   1779: astore_3
    //   1780: aload_0
    //   1781: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1784: aload 5
    //   1786: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1789: aload 4
    //   1791: ifnull +8 -> 1799
    //   1794: aload 4
    //   1796: invokevirtual 574	java/io/InputStream:close	()V
    //   1799: aload 6
    //   1801: astore_1
    //   1802: aload_2
    //   1803: ifnull -1353 -> 450
    //   1806: aload_2
    //   1807: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   1810: aload 6
    //   1812: areturn
    //   1813: astore_1
    //   1814: ldc 10
    //   1816: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1819: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   1822: aload_1
    //   1823: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1826: aload_0
    //   1827: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1830: aload_1
    //   1831: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1834: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1837: dup
    //   1838: sipush 35519
    //   1841: aload_1
    //   1842: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1845: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1848: areturn
    //   1849: astore 11
    //   1851: iload 19
    //   1853: istore 15
    //   1855: aload_2
    //   1856: astore 6
    //   1858: iload 20
    //   1860: istore 16
    //   1862: aload_2
    //   1863: astore 7
    //   1865: aload_2
    //   1866: astore 5
    //   1868: aload_2
    //   1869: astore_1
    //   1870: aload 4
    //   1872: astore_3
    //   1873: ldc 10
    //   1875: aload 11
    //   1877: invokestatic 427	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1880: lload 23
    //   1882: lstore 27
    //   1884: goto -601 -> 1283
    //   1887: astore 5
    //   1889: aload 8
    //   1891: astore 4
    //   1893: aload 7
    //   1895: astore_2
    //   1896: aload_2
    //   1897: astore_1
    //   1898: aload 4
    //   1900: astore_3
    //   1901: ldc 10
    //   1903: new 204	java/lang/StringBuilder
    //   1906: dup
    //   1907: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1910: ldc_w 503
    //   1913: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: aload_0
    //   1917: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1920: invokevirtual 231	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1923: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1929: aload 5
    //   1931: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1934: aload_2
    //   1935: astore_1
    //   1936: aload 4
    //   1938: astore_3
    //   1939: aload_0
    //   1940: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1943: aload 5
    //   1945: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1948: aload_2
    //   1949: astore_1
    //   1950: aload 4
    //   1952: astore_3
    //   1953: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1956: dup
    //   1957: sipush 55534
    //   1960: aload 5
    //   1962: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1965: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1968: astore 5
    //   1970: aload 4
    //   1972: ifnull +8 -> 1980
    //   1975: aload 4
    //   1977: invokevirtual 574	java/io/InputStream:close	()V
    //   1980: aload 5
    //   1982: astore_1
    //   1983: aload_2
    //   1984: ifnull -1534 -> 450
    //   1987: aload_2
    //   1988: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   1991: aload 5
    //   1993: areturn
    //   1994: astore_1
    //   1995: ldc 10
    //   1997: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2000: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2003: aload_1
    //   2004: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2007: aload_0
    //   2008: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2011: aload_1
    //   2012: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2015: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2018: dup
    //   2019: sipush 35519
    //   2022: aload_1
    //   2023: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2026: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2029: areturn
    //   2030: iload 21
    //   2032: sipush 206
    //   2035: if_icmpne +17 -> 2052
    //   2038: lload 27
    //   2040: lconst_0
    //   2041: lcmp
    //   2042: ifle +10 -> 2052
    //   2045: lload 27
    //   2047: lstore 23
    //   2049: goto -742 -> 1307
    //   2052: iload 19
    //   2054: istore 15
    //   2056: aload_2
    //   2057: astore 6
    //   2059: iload 20
    //   2061: istore 16
    //   2063: aload_2
    //   2064: astore 7
    //   2066: aload_2
    //   2067: astore 5
    //   2069: aload_2
    //   2070: astore_1
    //   2071: aload 4
    //   2073: astore_3
    //   2074: ldc 10
    //   2076: new 204	java/lang/StringBuilder
    //   2079: dup
    //   2080: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2083: ldc_w 576
    //   2086: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: iload 21
    //   2091: invokevirtual 508	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2094: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2097: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2100: lload 29
    //   2102: lstore 23
    //   2104: iload 19
    //   2106: istore 15
    //   2108: aload_2
    //   2109: astore 6
    //   2111: iload 20
    //   2113: istore 16
    //   2115: aload_2
    //   2116: astore 7
    //   2118: aload_2
    //   2119: astore 5
    //   2121: aload_2
    //   2122: astore_1
    //   2123: aload 4
    //   2125: astore_3
    //   2126: aload_0
    //   2127: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2130: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2133: lconst_0
    //   2134: lcmp
    //   2135: ifgt -828 -> 1307
    //   2138: lload 29
    //   2140: lstore 23
    //   2142: lload 25
    //   2144: lconst_0
    //   2145: lcmp
    //   2146: ifle -839 -> 1307
    //   2149: iload 19
    //   2151: istore 15
    //   2153: aload_2
    //   2154: astore 6
    //   2156: iload 20
    //   2158: istore 16
    //   2160: aload_2
    //   2161: astore 7
    //   2163: aload_2
    //   2164: astore 5
    //   2166: aload_2
    //   2167: astore_1
    //   2168: aload 4
    //   2170: astore_3
    //   2171: aload_0
    //   2172: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2175: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2178: lload 25
    //   2180: ladd
    //   2181: lstore 23
    //   2183: goto -876 -> 1307
    //   2186: lload 23
    //   2188: lconst_0
    //   2189: lcmp
    //   2190: ifle +453 -> 2643
    //   2193: iload 19
    //   2195: istore 15
    //   2197: aload_2
    //   2198: astore 6
    //   2200: iload 20
    //   2202: istore 16
    //   2204: aload_2
    //   2205: astore 7
    //   2207: aload_2
    //   2208: astore 5
    //   2210: aload_2
    //   2211: astore_1
    //   2212: aload 4
    //   2214: astore_3
    //   2215: aload_0
    //   2216: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2219: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2222: lload 23
    //   2224: lcmp
    //   2225: ifeq +418 -> 2643
    //   2228: iload 19
    //   2230: istore 15
    //   2232: aload_2
    //   2233: astore 6
    //   2235: iload 20
    //   2237: istore 16
    //   2239: aload_2
    //   2240: astore 7
    //   2242: aload_2
    //   2243: astore 5
    //   2245: aload_2
    //   2246: astore_1
    //   2247: aload 4
    //   2249: astore_3
    //   2250: aload_0
    //   2251: invokevirtual 431	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportContinueInterruption	()Z
    //   2254: ifeq +78 -> 2332
    //   2257: iload 19
    //   2259: istore 15
    //   2261: aload_2
    //   2262: astore 6
    //   2264: iload 20
    //   2266: istore 16
    //   2268: aload_2
    //   2269: astore 7
    //   2271: aload_2
    //   2272: astore 5
    //   2274: aload_2
    //   2275: astore_1
    //   2276: aload 4
    //   2278: astore_3
    //   2279: ldc 10
    //   2281: new 204	java/lang/StringBuilder
    //   2284: dup
    //   2285: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2288: ldc_w 578
    //   2291: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: aload_0
    //   2295: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2298: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2301: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2304: ldc_w 580
    //   2307: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: lload 25
    //   2312: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2315: ldc_w 582
    //   2318: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2321: lload 27
    //   2323: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2326: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2329: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2332: iload 19
    //   2334: istore 15
    //   2336: aload_2
    //   2337: astore 6
    //   2339: iload 20
    //   2341: istore 16
    //   2343: aload_2
    //   2344: astore 7
    //   2346: aload_2
    //   2347: astore 5
    //   2349: aload_2
    //   2350: astore_1
    //   2351: aload 4
    //   2353: astore_3
    //   2354: aload_0
    //   2355: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2358: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2361: lconst_0
    //   2362: lcmp
    //   2363: ifne +219 -> 2582
    //   2366: lload 23
    //   2368: lload 25
    //   2370: lcmp
    //   2371: ifne +211 -> 2582
    //   2374: iload 19
    //   2376: istore 15
    //   2378: aload_2
    //   2379: astore 6
    //   2381: iload 20
    //   2383: istore 16
    //   2385: aload_2
    //   2386: astore 7
    //   2388: aload_2
    //   2389: astore 5
    //   2391: aload_2
    //   2392: astore_1
    //   2393: aload 4
    //   2395: astore_3
    //   2396: aload_0
    //   2397: invokevirtual 323	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   2400: ifne +182 -> 2582
    //   2403: iload 19
    //   2405: istore 15
    //   2407: aload_2
    //   2408: astore 6
    //   2410: iload 20
    //   2412: istore 16
    //   2414: aload_2
    //   2415: astore 7
    //   2417: aload_2
    //   2418: astore 5
    //   2420: aload_2
    //   2421: astore_1
    //   2422: aload 4
    //   2424: astore_3
    //   2425: aload_0
    //   2426: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2429: lload 23
    //   2431: invokevirtual 555	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   2434: goto -1055 -> 1379
    //   2437: astore_1
    //   2438: aload 10
    //   2440: astore 4
    //   2442: aload 5
    //   2444: astore_2
    //   2445: aload_1
    //   2446: astore 5
    //   2448: aload_2
    //   2449: astore_1
    //   2450: aload 4
    //   2452: astore_3
    //   2453: ldc 10
    //   2455: new 204	java/lang/StringBuilder
    //   2458: dup
    //   2459: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2462: ldc_w 503
    //   2465: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: aload_0
    //   2469: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2472: invokevirtual 231	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   2475: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2478: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2481: aload 5
    //   2483: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2486: aload_2
    //   2487: astore_1
    //   2488: aload 4
    //   2490: astore_3
    //   2491: aload_0
    //   2492: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2495: aload 5
    //   2497: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2500: aload_2
    //   2501: astore_1
    //   2502: aload 4
    //   2504: astore_3
    //   2505: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2508: dup
    //   2509: sipush 55522
    //   2512: aload 5
    //   2514: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2517: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2520: astore 5
    //   2522: aload 4
    //   2524: ifnull +8 -> 2532
    //   2527: aload 4
    //   2529: invokevirtual 574	java/io/InputStream:close	()V
    //   2532: aload 5
    //   2534: astore_1
    //   2535: aload_2
    //   2536: ifnull -2086 -> 450
    //   2539: aload_2
    //   2540: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2543: aload 5
    //   2545: areturn
    //   2546: astore_1
    //   2547: ldc 10
    //   2549: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2552: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2555: aload_1
    //   2556: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2559: aload_0
    //   2560: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2563: aload_1
    //   2564: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2567: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2570: dup
    //   2571: sipush 35519
    //   2574: aload_1
    //   2575: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2578: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2581: areturn
    //   2582: lload 23
    //   2584: lload 27
    //   2586: lcmp
    //   2587: ifne -1208 -> 1379
    //   2590: iload 19
    //   2592: istore 15
    //   2594: aload_2
    //   2595: astore 6
    //   2597: iload 20
    //   2599: istore 16
    //   2601: aload_2
    //   2602: astore 7
    //   2604: aload_2
    //   2605: astore 5
    //   2607: aload_2
    //   2608: astore_1
    //   2609: aload 4
    //   2611: astore_3
    //   2612: aload_0
    //   2613: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2616: lload 23
    //   2618: invokevirtual 555	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   2621: goto -1242 -> 1379
    //   2624: astore_2
    //   2625: aload_3
    //   2626: ifnull +7 -> 2633
    //   2629: aload_3
    //   2630: invokevirtual 574	java/io/InputStream:close	()V
    //   2633: aload_1
    //   2634: ifnull +7 -> 2641
    //   2637: aload_1
    //   2638: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2641: aload_2
    //   2642: athrow
    //   2643: lload 23
    //   2645: lconst_0
    //   2646: lcmp
    //   2647: ifge -1268 -> 1379
    //   2650: iload 19
    //   2652: istore 15
    //   2654: aload_2
    //   2655: astore 6
    //   2657: iload 20
    //   2659: istore 16
    //   2661: aload_2
    //   2662: astore 7
    //   2664: aload_2
    //   2665: astore 5
    //   2667: aload_2
    //   2668: astore_1
    //   2669: aload 4
    //   2671: astore_3
    //   2672: ldc 10
    //   2674: new 204	java/lang/StringBuilder
    //   2677: dup
    //   2678: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2681: ldc_w 584
    //   2684: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2687: aload_0
    //   2688: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2691: invokevirtual 199	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   2694: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2697: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2700: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2703: iload 19
    //   2705: istore 15
    //   2707: aload_2
    //   2708: astore 6
    //   2710: iload 20
    //   2712: istore 16
    //   2714: aload_2
    //   2715: astore 7
    //   2717: aload_2
    //   2718: astore 5
    //   2720: aload_2
    //   2721: astore_1
    //   2722: aload 4
    //   2724: astore_3
    //   2725: ldc 10
    //   2727: aload_2
    //   2728: invokevirtual 588	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   2731: invokevirtual 589	java/lang/Object:toString	()Ljava/lang/String;
    //   2734: invokestatic 310	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2737: goto -1358 -> 1379
    //   2740: iload 21
    //   2742: sipush 206
    //   2745: if_icmpne +100 -> 2845
    //   2748: iload 19
    //   2750: istore 15
    //   2752: aload_2
    //   2753: astore 6
    //   2755: iload 20
    //   2757: istore 16
    //   2759: aload_2
    //   2760: astore 7
    //   2762: aload_2
    //   2763: astore 5
    //   2765: aload_2
    //   2766: astore_1
    //   2767: aload 4
    //   2769: astore_3
    //   2770: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2773: dup
    //   2774: sipush 36531
    //   2777: aconst_null
    //   2778: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2781: astore 4
    //   2783: iconst_0
    //   2784: ifeq +11 -> 2795
    //   2787: new 470	java/lang/NullPointerException
    //   2790: dup
    //   2791: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   2794: athrow
    //   2795: aload 4
    //   2797: astore_1
    //   2798: aload_2
    //   2799: ifnull -2349 -> 450
    //   2802: aload_2
    //   2803: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2806: aload 4
    //   2808: areturn
    //   2809: astore_1
    //   2810: ldc 10
    //   2812: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2815: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2818: aload_1
    //   2819: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2822: aload_0
    //   2823: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2826: aload_1
    //   2827: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2830: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2833: dup
    //   2834: sipush 35519
    //   2837: aload_1
    //   2838: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2841: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2844: areturn
    //   2845: iload 19
    //   2847: istore 15
    //   2849: aload_2
    //   2850: astore 6
    //   2852: iload 20
    //   2854: istore 16
    //   2856: aload_2
    //   2857: astore 7
    //   2859: aload_2
    //   2860: astore 5
    //   2862: aload_2
    //   2863: astore_1
    //   2864: aload 4
    //   2866: astore_3
    //   2867: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2870: dup
    //   2871: sipush 36535
    //   2874: aconst_null
    //   2875: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2878: astore 4
    //   2880: iconst_0
    //   2881: ifeq +11 -> 2892
    //   2884: new 470	java/lang/NullPointerException
    //   2887: dup
    //   2888: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   2891: athrow
    //   2892: aload 4
    //   2894: astore_1
    //   2895: aload_2
    //   2896: ifnull -2446 -> 450
    //   2899: aload_2
    //   2900: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2903: aload 4
    //   2905: areturn
    //   2906: astore_1
    //   2907: ldc 10
    //   2909: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2912: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2915: aload_1
    //   2916: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2919: aload_0
    //   2920: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2923: aload_1
    //   2924: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2927: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2930: dup
    //   2931: sipush 35519
    //   2934: aload_1
    //   2935: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2938: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2941: areturn
    //   2942: iload 19
    //   2944: istore 15
    //   2946: aload_2
    //   2947: astore 6
    //   2949: iload 20
    //   2951: istore 16
    //   2953: aload_2
    //   2954: astore 7
    //   2956: aload_2
    //   2957: astore 5
    //   2959: aload_2
    //   2960: astore_1
    //   2961: aload 4
    //   2963: astore_3
    //   2964: aload_0
    //   2965: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2968: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2971: lstore 23
    //   2973: iload 19
    //   2975: istore 15
    //   2977: aload_2
    //   2978: astore 6
    //   2980: iload 20
    //   2982: istore 16
    //   2984: aload_2
    //   2985: astore 7
    //   2987: aload_2
    //   2988: astore 5
    //   2990: aload_2
    //   2991: astore_1
    //   2992: aload 4
    //   2994: astore_3
    //   2995: new 591	java/io/BufferedInputStream
    //   2998: dup
    //   2999: aload_2
    //   3000: invokevirtual 595	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3003: invokespecial 598	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   3006: astore 4
    //   3008: aload_0
    //   3009: aload 4
    //   3011: invokevirtual 602	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:readHttpContent	(Ljava/io/InputStream;)I
    //   3014: istore 16
    //   3016: iload 16
    //   3018: istore 15
    //   3020: iload 16
    //   3022: sipush 55534
    //   3025: if_icmpne +34 -> 3059
    //   3028: iload 16
    //   3030: istore 15
    //   3032: aload_0
    //   3033: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   3036: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   3039: lload 23
    //   3041: lsub
    //   3042: lload 25
    //   3044: lcmp
    //   3045: ifne +14 -> 3059
    //   3048: ldc 10
    //   3050: ldc_w 604
    //   3053: invokestatic 310	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3056: iconst_0
    //   3057: istore 15
    //   3059: iload 15
    //   3061: ifne +162 -> 3223
    //   3064: aload_0
    //   3065: invokevirtual 323	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   3068: ifeq +155 -> 3223
    //   3071: aload_0
    //   3072: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   3075: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   3078: aload_0
    //   3079: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   3082: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   3085: lcmp
    //   3086: iflt +69 -> 3155
    //   3089: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3092: dup
    //   3093: iconst_0
    //   3094: aconst_null
    //   3095: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3098: astore_1
    //   3099: aload 4
    //   3101: ifnull +8 -> 3109
    //   3104: aload 4
    //   3106: invokevirtual 574	java/io/InputStream:close	()V
    //   3109: aload_2
    //   3110: ifnull +7 -> 3117
    //   3113: aload_2
    //   3114: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   3117: aload_1
    //   3118: areturn
    //   3119: astore_1
    //   3120: ldc 10
    //   3122: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3125: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   3128: aload_1
    //   3129: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3132: aload_0
    //   3133: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   3136: aload_1
    //   3137: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   3140: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3143: dup
    //   3144: sipush 35519
    //   3147: aload_1
    //   3148: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3151: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3154: areturn
    //   3155: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3158: dup
    //   3159: sipush 55516
    //   3162: aconst_null
    //   3163: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3166: astore_1
    //   3167: aload 4
    //   3169: ifnull +8 -> 3177
    //   3172: aload 4
    //   3174: invokevirtual 574	java/io/InputStream:close	()V
    //   3177: aload_2
    //   3178: ifnull +7 -> 3185
    //   3181: aload_2
    //   3182: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   3185: aload_1
    //   3186: areturn
    //   3187: astore_1
    //   3188: ldc 10
    //   3190: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3193: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   3196: aload_1
    //   3197: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3200: aload_0
    //   3201: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   3204: aload_1
    //   3205: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   3208: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3211: dup
    //   3212: sipush 35519
    //   3215: aload_1
    //   3216: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3219: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3222: areturn
    //   3223: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3226: dup
    //   3227: iload 15
    //   3229: aconst_null
    //   3230: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3233: astore_1
    //   3234: aload 4
    //   3236: ifnull +8 -> 3244
    //   3239: aload 4
    //   3241: invokevirtual 574	java/io/InputStream:close	()V
    //   3244: aload_2
    //   3245: ifnull +7 -> 3252
    //   3248: aload_2
    //   3249: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   3252: aload_1
    //   3253: areturn
    //   3254: astore_1
    //   3255: ldc 10
    //   3257: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3260: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   3263: aload_1
    //   3264: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3267: aload_0
    //   3268: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   3271: aload_1
    //   3272: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   3275: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3278: dup
    //   3279: sipush 35519
    //   3282: aload_1
    //   3283: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3286: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3289: areturn
    //   3290: aload_2
    //   3291: astore_1
    //   3292: aload 4
    //   3294: astore_3
    //   3295: aload 6
    //   3297: getfield 243	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   3300: sipush 35534
    //   3303: if_icmpne -1528 -> 1775
    //   3306: iload 16
    //   3308: ifne -1533 -> 1775
    //   3311: aload_2
    //   3312: astore_1
    //   3313: aload 4
    //   3315: astore_3
    //   3316: aload 6
    //   3318: sipush 35507
    //   3321: putfield 243	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   3324: goto -1549 -> 1775
    //   3327: astore_1
    //   3328: ldc 10
    //   3330: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3333: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   3336: aload_1
    //   3337: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3340: aload_0
    //   3341: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   3344: aload_1
    //   3345: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   3348: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3351: dup
    //   3352: sipush 35519
    //   3355: aload_1
    //   3356: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3359: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3362: areturn
    //   3363: astore 5
    //   3365: aload 4
    //   3367: astore_3
    //   3368: aload_2
    //   3369: astore_1
    //   3370: aload 5
    //   3372: astore_2
    //   3373: goto -748 -> 2625
    //   3376: astore 5
    //   3378: goto -930 -> 2448
    //   3381: astore 5
    //   3383: goto -1487 -> 1896
    //   3386: astore 5
    //   3388: iload 18
    //   3390: istore 15
    //   3392: iload 17
    //   3394: istore 16
    //   3396: goto -1717 -> 1679
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3399	0	this	BaseDownloadTransfer
    //   50	401	1	localObject1	Object
    //   452	29	1	localIOException1	IOException
    //   506	224	1	localObject2	Object
    //   741	29	1	localIOException2	IOException
    //   777	1	1	localNumberFormatException1	NumberFormatException
    //   796	167	1	localObject3	Object
    //   974	29	1	localIOException3	IOException
    //   1028	539	1	localObject4	Object
    //   1578	29	1	localIOException4	IOException
    //   1614	1	1	localNumberFormatException2	NumberFormatException
    //   1633	169	1	localObject5	Object
    //   1813	29	1	localIOException5	IOException
    //   1869	114	1	localObject6	Object
    //   1994	29	1	localIOException6	IOException
    //   2070	352	1	localObject7	Object
    //   2437	9	1	localException1	Exception
    //   2449	86	1	localObject8	Object
    //   2546	29	1	localIOException7	IOException
    //   2608	190	1	localObject9	Object
    //   2809	29	1	localIOException8	IOException
    //   2863	32	1	localObject10	Object
    //   2906	29	1	localIOException9	IOException
    //   2960	158	1	localObject11	Object
    //   3119	29	1	localIOException10	IOException
    //   3166	20	1	localResult1	Transfer.Result
    //   3187	29	1	localIOException11	IOException
    //   3233	20	1	localResult2	Transfer.Result
    //   3254	29	1	localIOException12	IOException
    //   3291	22	1	localObject12	Object
    //   3327	29	1	localIOException13	IOException
    //   3369	1	1	localObject13	Object
    //   10	2598	2	localObject14	Object
    //   2624	745	2	localObject15	Object
    //   3372	1	2	localObject16	Object
    //   53	3315	3	localObject17	Object
    //   18	3348	4	localObject18	Object
    //   46	1585	5	localObject19	Object
    //   1670	115	5	localIOException14	IOException
    //   1866	1	5	localObject20	Object
    //   1887	74	5	localInterruptedException1	InterruptedException
    //   1968	1021	5	localObject21	Object
    //   3363	8	5	localObject22	Object
    //   3376	1	5	localException2	Exception
    //   3381	1	5	localInterruptedException2	InterruptedException
    //   3386	1	5	localIOException15	IOException
    //   34	3283	6	localObject23	Object
    //   42	2944	7	localObject24	Object
    //   12	1878	8	localObject25	Object
    //   21	1652	9	localObject26	Object
    //   15	2424	10	localObject27	Object
    //   4	1649	11	localObject28	Object
    //   1849	27	11	localException3	Exception
    //   1	815	12	str	String
    //   7	73	13	localObject29	Object
    //   58	1001	14	localURL	URL
    //   31	3360	15	i	int
    //   38	3357	16	j	int
    //   27	3366	17	k	int
    //   24	3365	18	m	int
    //   518	2456	19	n	int
    //   587	2394	20	i1	int
    //   581	2165	21	i2	int
    //   1245	27	22	i3	int
    //   354	2686	23	l1	long
    //   1139	1904	25	l2	long
    //   1099	1486	27	l3	long
    //   1286	853	29	l4	long
    // Exception table:
    //   from	to	target	type
    //   428	436	452	java/io/IOException
    //   443	447	452	java/io/IOException
    //   719	727	741	java/io/IOException
    //   734	738	741	java/io/IOException
    //   698	715	777	java/lang/NumberFormatException
    //   952	960	974	java/io/IOException
    //   967	971	974	java/io/IOException
    //   1556	1564	1578	java/io/IOException
    //   1571	1575	1578	java/io/IOException
    //   1168	1175	1614	java/lang/NumberFormatException
    //   54	60	1670	java/io/IOException
    //   85	94	1670	java/io/IOException
    //   116	130	1670	java/io/IOException
    //   152	157	1670	java/io/IOException
    //   179	191	1670	java/io/IOException
    //   213	227	1670	java/io/IOException
    //   249	266	1670	java/io/IOException
    //   288	294	1670	java/io/IOException
    //   316	329	1670	java/io/IOException
    //   351	356	1670	java/io/IOException
    //   378	388	1670	java/io/IOException
    //   410	424	1670	java/io/IOException
    //   510	514	1670	java/io/IOException
    //   542	555	1670	java/io/IOException
    //   577	583	1670	java/io/IOException
    //   611	624	1670	java/io/IOException
    //   662	671	1670	java/io/IOException
    //   698	715	1670	java/io/IOException
    //   800	826	1670	java/io/IOException
    //   864	906	1670	java/io/IOException
    //   928	948	1670	java/io/IOException
    //   1032	1096	1670	java/io/IOException
    //   1128	1137	1670	java/io/IOException
    //   1168	1175	1670	java/io/IOException
    //   1197	1206	1670	java/io/IOException
    //   1237	1247	1670	java/io/IOException
    //   1266	1283	1670	java/io/IOException
    //   1336	1348	1670	java/io/IOException
    //   1370	1379	1670	java/io/IOException
    //   1408	1445	1670	java/io/IOException
    //   1467	1479	1670	java/io/IOException
    //   1501	1519	1670	java/io/IOException
    //   1541	1552	1670	java/io/IOException
    //   1637	1663	1670	java/io/IOException
    //   1873	1880	1670	java/io/IOException
    //   2074	2100	1670	java/io/IOException
    //   2126	2138	1670	java/io/IOException
    //   2171	2183	1670	java/io/IOException
    //   2215	2228	1670	java/io/IOException
    //   2250	2257	1670	java/io/IOException
    //   2279	2332	1670	java/io/IOException
    //   2354	2366	1670	java/io/IOException
    //   2396	2403	1670	java/io/IOException
    //   2425	2434	1670	java/io/IOException
    //   2612	2621	1670	java/io/IOException
    //   2672	2703	1670	java/io/IOException
    //   2725	2737	1670	java/io/IOException
    //   2770	2783	1670	java/io/IOException
    //   2867	2880	1670	java/io/IOException
    //   2964	2973	1670	java/io/IOException
    //   2995	3008	1670	java/io/IOException
    //   1794	1799	1813	java/io/IOException
    //   1806	1810	1813	java/io/IOException
    //   1266	1283	1849	java/lang/Exception
    //   54	60	1887	java/lang/InterruptedException
    //   85	94	1887	java/lang/InterruptedException
    //   116	130	1887	java/lang/InterruptedException
    //   152	157	1887	java/lang/InterruptedException
    //   179	191	1887	java/lang/InterruptedException
    //   213	227	1887	java/lang/InterruptedException
    //   249	266	1887	java/lang/InterruptedException
    //   288	294	1887	java/lang/InterruptedException
    //   316	329	1887	java/lang/InterruptedException
    //   351	356	1887	java/lang/InterruptedException
    //   378	388	1887	java/lang/InterruptedException
    //   410	424	1887	java/lang/InterruptedException
    //   510	514	1887	java/lang/InterruptedException
    //   542	555	1887	java/lang/InterruptedException
    //   577	583	1887	java/lang/InterruptedException
    //   611	624	1887	java/lang/InterruptedException
    //   662	671	1887	java/lang/InterruptedException
    //   698	715	1887	java/lang/InterruptedException
    //   800	826	1887	java/lang/InterruptedException
    //   864	906	1887	java/lang/InterruptedException
    //   928	948	1887	java/lang/InterruptedException
    //   1032	1096	1887	java/lang/InterruptedException
    //   1128	1137	1887	java/lang/InterruptedException
    //   1168	1175	1887	java/lang/InterruptedException
    //   1197	1206	1887	java/lang/InterruptedException
    //   1237	1247	1887	java/lang/InterruptedException
    //   1266	1283	1887	java/lang/InterruptedException
    //   1336	1348	1887	java/lang/InterruptedException
    //   1370	1379	1887	java/lang/InterruptedException
    //   1408	1445	1887	java/lang/InterruptedException
    //   1467	1479	1887	java/lang/InterruptedException
    //   1501	1519	1887	java/lang/InterruptedException
    //   1541	1552	1887	java/lang/InterruptedException
    //   1637	1663	1887	java/lang/InterruptedException
    //   1873	1880	1887	java/lang/InterruptedException
    //   2074	2100	1887	java/lang/InterruptedException
    //   2126	2138	1887	java/lang/InterruptedException
    //   2171	2183	1887	java/lang/InterruptedException
    //   2215	2228	1887	java/lang/InterruptedException
    //   2250	2257	1887	java/lang/InterruptedException
    //   2279	2332	1887	java/lang/InterruptedException
    //   2354	2366	1887	java/lang/InterruptedException
    //   2396	2403	1887	java/lang/InterruptedException
    //   2425	2434	1887	java/lang/InterruptedException
    //   2612	2621	1887	java/lang/InterruptedException
    //   2672	2703	1887	java/lang/InterruptedException
    //   2725	2737	1887	java/lang/InterruptedException
    //   2770	2783	1887	java/lang/InterruptedException
    //   2867	2880	1887	java/lang/InterruptedException
    //   2964	2973	1887	java/lang/InterruptedException
    //   2995	3008	1887	java/lang/InterruptedException
    //   1975	1980	1994	java/io/IOException
    //   1987	1991	1994	java/io/IOException
    //   54	60	2437	java/lang/Exception
    //   85	94	2437	java/lang/Exception
    //   116	130	2437	java/lang/Exception
    //   152	157	2437	java/lang/Exception
    //   179	191	2437	java/lang/Exception
    //   213	227	2437	java/lang/Exception
    //   249	266	2437	java/lang/Exception
    //   288	294	2437	java/lang/Exception
    //   316	329	2437	java/lang/Exception
    //   351	356	2437	java/lang/Exception
    //   378	388	2437	java/lang/Exception
    //   410	424	2437	java/lang/Exception
    //   510	514	2437	java/lang/Exception
    //   542	555	2437	java/lang/Exception
    //   577	583	2437	java/lang/Exception
    //   611	624	2437	java/lang/Exception
    //   662	671	2437	java/lang/Exception
    //   698	715	2437	java/lang/Exception
    //   800	826	2437	java/lang/Exception
    //   864	906	2437	java/lang/Exception
    //   928	948	2437	java/lang/Exception
    //   1032	1096	2437	java/lang/Exception
    //   1128	1137	2437	java/lang/Exception
    //   1168	1175	2437	java/lang/Exception
    //   1197	1206	2437	java/lang/Exception
    //   1237	1247	2437	java/lang/Exception
    //   1336	1348	2437	java/lang/Exception
    //   1370	1379	2437	java/lang/Exception
    //   1408	1445	2437	java/lang/Exception
    //   1467	1479	2437	java/lang/Exception
    //   1501	1519	2437	java/lang/Exception
    //   1541	1552	2437	java/lang/Exception
    //   1637	1663	2437	java/lang/Exception
    //   1873	1880	2437	java/lang/Exception
    //   2074	2100	2437	java/lang/Exception
    //   2126	2138	2437	java/lang/Exception
    //   2171	2183	2437	java/lang/Exception
    //   2215	2228	2437	java/lang/Exception
    //   2250	2257	2437	java/lang/Exception
    //   2279	2332	2437	java/lang/Exception
    //   2354	2366	2437	java/lang/Exception
    //   2396	2403	2437	java/lang/Exception
    //   2425	2434	2437	java/lang/Exception
    //   2612	2621	2437	java/lang/Exception
    //   2672	2703	2437	java/lang/Exception
    //   2725	2737	2437	java/lang/Exception
    //   2770	2783	2437	java/lang/Exception
    //   2867	2880	2437	java/lang/Exception
    //   2964	2973	2437	java/lang/Exception
    //   2995	3008	2437	java/lang/Exception
    //   2527	2532	2546	java/io/IOException
    //   2539	2543	2546	java/io/IOException
    //   54	60	2624	finally
    //   85	94	2624	finally
    //   116	130	2624	finally
    //   152	157	2624	finally
    //   179	191	2624	finally
    //   213	227	2624	finally
    //   249	266	2624	finally
    //   288	294	2624	finally
    //   316	329	2624	finally
    //   351	356	2624	finally
    //   378	388	2624	finally
    //   410	424	2624	finally
    //   510	514	2624	finally
    //   542	555	2624	finally
    //   577	583	2624	finally
    //   611	624	2624	finally
    //   662	671	2624	finally
    //   698	715	2624	finally
    //   800	826	2624	finally
    //   864	906	2624	finally
    //   928	948	2624	finally
    //   1032	1096	2624	finally
    //   1128	1137	2624	finally
    //   1168	1175	2624	finally
    //   1197	1206	2624	finally
    //   1237	1247	2624	finally
    //   1266	1283	2624	finally
    //   1336	1348	2624	finally
    //   1370	1379	2624	finally
    //   1408	1445	2624	finally
    //   1467	1479	2624	finally
    //   1501	1519	2624	finally
    //   1541	1552	2624	finally
    //   1637	1663	2624	finally
    //   1684	1717	2624	finally
    //   1722	1741	2624	finally
    //   1746	1757	2624	finally
    //   1767	1775	2624	finally
    //   1780	1789	2624	finally
    //   1873	1880	2624	finally
    //   1901	1934	2624	finally
    //   1939	1948	2624	finally
    //   1953	1970	2624	finally
    //   2074	2100	2624	finally
    //   2126	2138	2624	finally
    //   2171	2183	2624	finally
    //   2215	2228	2624	finally
    //   2250	2257	2624	finally
    //   2279	2332	2624	finally
    //   2354	2366	2624	finally
    //   2396	2403	2624	finally
    //   2425	2434	2624	finally
    //   2453	2486	2624	finally
    //   2491	2500	2624	finally
    //   2505	2522	2624	finally
    //   2612	2621	2624	finally
    //   2672	2703	2624	finally
    //   2725	2737	2624	finally
    //   2770	2783	2624	finally
    //   2867	2880	2624	finally
    //   2964	2973	2624	finally
    //   2995	3008	2624	finally
    //   3295	3306	2624	finally
    //   3316	3324	2624	finally
    //   2787	2795	2809	java/io/IOException
    //   2802	2806	2809	java/io/IOException
    //   2884	2892	2906	java/io/IOException
    //   2899	2903	2906	java/io/IOException
    //   3104	3109	3119	java/io/IOException
    //   3113	3117	3119	java/io/IOException
    //   3172	3177	3187	java/io/IOException
    //   3181	3185	3187	java/io/IOException
    //   3239	3244	3254	java/io/IOException
    //   3248	3252	3254	java/io/IOException
    //   2629	2633	3327	java/io/IOException
    //   2637	2641	3327	java/io/IOException
    //   3008	3016	3363	finally
    //   3032	3056	3363	finally
    //   3064	3099	3363	finally
    //   3155	3167	3363	finally
    //   3223	3234	3363	finally
    //   3008	3016	3376	java/lang/Exception
    //   3032	3056	3376	java/lang/Exception
    //   3064	3099	3376	java/lang/Exception
    //   3155	3167	3376	java/lang/Exception
    //   3223	3234	3376	java/lang/Exception
    //   3008	3016	3381	java/lang/InterruptedException
    //   3032	3056	3381	java/lang/InterruptedException
    //   3064	3099	3381	java/lang/InterruptedException
    //   3155	3167	3381	java/lang/InterruptedException
    //   3223	3234	3381	java/lang/InterruptedException
    //   3008	3016	3386	java/io/IOException
    //   3032	3056	3386	java/io/IOException
    //   3064	3099	3386	java/io/IOException
    //   3155	3167	3386	java/io/IOException
    //   3223	3234	3386	java/io/IOException
  }
  
  protected int getMaxTryTimes()
  {
    return 3;
  }
  
  protected long getSplitSize()
  {
    return this.mSplitSize;
  }
  
  protected boolean isSupportContinueInterruption()
  {
    return false;
  }
  
  protected boolean isSupportSplitDownload()
  {
    return false;
  }
  
  protected int moveToTarget()
  {
    Utils.checkDirAndCreate(this.mContext.getDestDirectoryPath());
    if (!new File(this.mContext.getDataFilePath()).renameTo(new File(this.mContext.getDestFilePath())))
    {
      if (Utils.checkFileExist(this.mContext.getDestFilePath()) == true)
      {
        String str = Utils.generateNewFilename(this.mContext.getDestFileName());
        this.mJob.renameDestFile(str);
      }
    }
    else {
      return 0;
    }
    com.weiyun.sdk.log.Log.e("BaseDownloadTransfer", "rename to target file failed. target =" + this.mContext.getDestFilePath());
    return 55528;
  }
  
  protected Transfer.Result processDownload()
  {
    Transfer.Result localResult1 = acquireResource();
    if (localResult1.mRet != 0) {
      return localResult1;
    }
    int k = 1;
    long l = this.mStartTime;
    int j = 0;
    int i = 0;
    Transfer.Result localResult2 = localResult1;
    for (;;)
    {
      try
      {
        if (i < getMaxTryTimes())
        {
          if (k == 0)
          {
            l = System.currentTimeMillis();
            doInnerReport(localResult1, this.mProcessInfo);
            this.mProcessInfo.resetLast();
            this.mProcessInfo.attemptCount = j;
          }
          localResult2 = checkJob();
          if (localResult2 != null) {
            return localResult2;
          }
          if (k == 0)
          {
            this.mJob.reportDownloadTransferSize(2, localResult1.mRet, this.mStartTime, l, this.mContext.getCurSize() - this.mOffset, localResult1.mErrMsg);
            this.mStartTime = l;
            this.mOffset = this.mContext.getCurSize();
          }
          localResult1 = doDownload();
          k = localResult1.mRet;
          if (k == 0) {
            localResult2 = localResult1;
          }
        }
        else
        {
          releaseResource();
          if (localResult2.mRet != 0) {
            return localResult2;
          }
          i = moveToTarget();
          if (i != 0) {
            break label343;
          }
          localResult1 = null;
          return new Transfer.Result(i, localResult1);
        }
        k = i;
        if (this.mOffset < this.mContext.getCurSize())
        {
          k = i;
          if (isSupportContinueInterruption())
          {
            com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", "get data " + (this.mContext.getCurSize() - this.mOffset) + ", meet error:" + localResult1.mRet);
            k = -1;
          }
        }
        boolean bool;
        if (k + 1 < getMaxTryTimes())
        {
          bool = true;
          localResult2 = handleError(bool, j, localResult1);
          i = localResult2.mRet;
          if (i != 0) {
            return localResult2;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        i = k + 1;
        j += 1;
        k = 0;
        break;
      }
      finally
      {
        releaseResource();
      }
      label343:
      String str = "读写文件失败";
    }
    return localResult2;
  }
  
  protected int readHttpContent(InputStream paramInputStream)
    throws SocketTimeoutException, IOException, InterruptedException
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      ByteArrayPool.ByteArrayBuffer localByteArrayBuffer;
      try
      {
        if (this.mDestFileWriter.getFilePointer() != this.mContext.getCurSize()) {
          this.mDestFileWriter.seek(this.mContext.getCurSize());
        }
        long l = SystemClock.uptimeMillis();
        i = -1;
        localByteArrayBuffer = ByteArrayPool.getInstance().createBuffer();
        if (!this.mJob.isAlive())
        {
          i = 55534;
          this.mProcessInfo.transferDataTimeCost = (SystemClock.uptimeMillis() - l);
          paramInputStream = ByteArrayPool.getInstance();
          if (i == 0) {
            bool = true;
          }
          paramInputStream.freeBuffer(localByteArrayBuffer, bool);
          return i;
        }
      }
      catch (IOException paramInputStream)
      {
        com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", paramInputStream);
        return 55520;
      }
      if (!this.mJob.checkEnvironment())
      {
        i = this.mJob.getLastErrorNo();
      }
      else
      {
        int j = paramInputStream.read(localByteArrayBuffer.backingArray, 0, 40960);
        if (-1 == j) {
          i = 0;
        } else {
          try
          {
            this.mDestFileWriter.write(localByteArrayBuffer.backingArray, 0, j);
            this.mContext.setCurSize(this.mContext.getCurSize() + j);
            Transfer.ProcessInfo localProcessInfo = this.mProcessInfo;
            localProcessInfo.transferDataSize += j;
            this.mJob.notifyProgressChanged(this.mContext.getCurSize(), this.mContext.getTotalSize());
            if (j > 0) {}
          }
          catch (IOException paramInputStream)
          {
            com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", paramInputStream);
            i = 55528;
          }
        }
      }
    }
  }
  
  protected void releaseResource()
  {
    try
    {
      RandomAccessFile localRandomAccessFile = this.mDestFileWriter;
      if (localRandomAccessFile != null) {
        localRandomAccessFile.close();
      }
      this.mDestFileWriter = null;
      return;
    }
    catch (IOException localIOException)
    {
      com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", localIOException);
    }
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    if (!NetworkUtils.isWIFI(null))
    {
      paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 45000);
      paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 45000);
      paramHttpURLConnection.setRequestMethod("GET");
      paramHttpURLConnection.setRequestProperty("Accept", "*/*");
      paramHttpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
      paramHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      if ((Build.VERSION.SDK == null) || (Build.VERSION.SDK_INT <= 13)) {
        break label166;
      }
      paramHttpURLConnection.setRequestProperty("Connection", "close");
      paramHttpURLConnection.setRequestProperty("Proxy-Connection", "close");
    }
    for (;;)
    {
      paramHttpURLConnection.setRequestProperty("Pragma", "no-cache");
      paramHttpURLConnection.setRequestProperty("Content-type", "text/octet");
      return;
      paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 30000);
      paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 45000);
      break;
      label166:
      paramHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
      paramHttpURLConnection.setRequestProperty("Proxy-Connection", "Keep-Alive");
    }
  }
  
  public int transfer()
  {
    this.mStartTime = System.currentTimeMillis();
    this.mOffset = this.mContext.getCurSize();
    Transfer.Result localResult = processDownload();
    report(localResult);
    return localResult.mRet;
  }
  
  protected boolean usingSplitDownload()
  {
    return this.mUseSplitDownload;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\transfer\BaseDownloadTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */