package com.weiyun.sdk.job.transfer;

import android.os.SystemClock;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.context.ErrorMessages;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.UploadAddress;
import com.weiyun.sdk.job.api.StoragePlatomProto;
import com.weiyun.sdk.job.api.UploadTaskRequestRetryHandler;
import com.weiyun.sdk.report.WeiyunReport;
import com.weiyun.sdk.report.WeiyunReportObj;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.UtilsMisc;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class UploadTransfer
  implements Transfer
{
  private static final long FILE_SIZE_4G = 4294967296L;
  private static final String TAG = "UploadTransfer";
  protected final AddressFetcher.UploadAddress mAddress;
  protected final UploadJobContext mContext;
  protected final byte[] mFileHash;
  protected DefaultHttpClient mHttpClient = null;
  protected final BaseUploadJob mJob;
  private final Transfer.ProcessInfo mProcessInfo;
  protected int mRewardThreshold = 4;
  protected int mSliceSize = 0;
  protected int mSuccSliceTimes = 0;
  protected int mTimeoutTimes = 0;
  protected final byte[] mUkey;
  
  public UploadTransfer(AddressFetcher.UploadAddress paramUploadAddress, UploadJobContext paramUploadJobContext, BaseUploadJob paramBaseUploadJob)
  {
    this.mContext = paramUploadJobContext;
    this.mAddress = paramUploadAddress;
    this.mJob = paramBaseUploadJob;
    this.mUkey = UtilsMisc.hexStringToByteArray(this.mAddress.getUKey());
    this.mFileHash = UtilsMisc.hexStringToByteArray(this.mContext.getSha());
    this.mProcessInfo = new Transfer.ProcessInfo();
    try
    {
      this.mProcessInfo.url = createUrl().toString();
      this.mProcessInfo.flowId = Global.generateRandomId(new Object[] { this.mProcessInfo.url, this });
      this.mProcessInfo.startTime = SystemClock.uptimeMillis();
      return;
    }
    catch (MalformedURLException paramUploadAddress)
    {
      for (;;) {}
    }
  }
  
  private void adjustProgress(StoragePlatomProto paramStoragePlatomProto, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mJob.getId());
    localStringBuilder.append(", server's offset: ");
    localStringBuilder.append(paramStoragePlatomProto.getUploadRspNextOffset());
    localStringBuilder.append(", local's offset: ");
    localStringBuilder.append(paramLong);
    com.weiyun.sdk.log.Log.v("UploadTransfer", localStringBuilder.toString());
    if (paramLong != paramStoragePlatomProto.getUploadRspNextOffset()) {
      this.mContext.setCurSize(paramStoragePlatomProto.getUploadRspNextOffset());
    }
    for (;;)
    {
      this.mJob.notifyProgressChanged(this.mContext.getCurSize(), this.mContext.getTotalSize());
      return;
      this.mContext.setCurSize(paramLong);
    }
  }
  
  private void closeFile(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile != null) {}
    try
    {
      paramRandomAccessFile.close();
      return;
    }
    catch (IOException paramRandomAccessFile)
    {
      for (;;)
      {
        com.weiyun.sdk.log.Log.w("UploadTransfer", "close file failed!");
      }
    }
  }
  
  private void closeHttpClient()
  {
    if (this.mHttpClient != null)
    {
      this.mHttpClient.getConnectionManager().shutdown();
      this.mHttpClient = null;
    }
  }
  
  private void doInnerReport(Transfer.Result paramResult, Transfer.ProcessInfo paramProcessInfo)
  {
    if (!Global.isInit()) {
      return;
    }
    WeiyunReportObj localWeiyunReportObj = new WeiyunReportObj(2);
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
    localWeiyunReportObj.file_path = this.mContext.getSrcPath();
    localWeiyunReportObj.file_md5 = this.mContext.getMd5();
    localWeiyunReportObj.file_sha = this.mContext.getSha();
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
  
  /* Error */
  private int httpPostData(StoragePlatomProto paramStoragePlatomProto, URL paramURL, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 356	com/weiyun/sdk/job/transfer/ByteArrayPool:getInstance	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool;
    //   3: invokevirtual 360	com/weiyun/sdk/job/transfer/ByteArrayPool:createBuffer	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer;
    //   6: astore 14
    //   8: new 116	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   15: astore 15
    //   17: aconst_null
    //   18: astore 8
    //   20: iconst_0
    //   21: istore 16
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   28: iconst_0
    //   29: istore 17
    //   31: iconst_0
    //   32: istore 21
    //   34: iconst_0
    //   35: istore 20
    //   37: aconst_null
    //   38: astore 9
    //   40: iload 20
    //   42: iconst_3
    //   43: if_icmplt +14 -> 57
    //   46: iload 17
    //   48: ifeq +2038 -> 2086
    //   51: iload 21
    //   53: iconst_3
    //   54: if_icmpge +2032 -> 2086
    //   57: aload_0
    //   58: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   61: invokevirtual 363	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   64: ifne +39 -> 103
    //   67: ldc 14
    //   69: ldc_w 365
    //   72: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: sipush 55534
    //   78: istore 4
    //   80: invokestatic 356	com/weiyun/sdk/job/transfer/ByteArrayPool:getInstance	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool;
    //   83: astore_1
    //   84: iload 4
    //   86: ifne +1962 -> 2048
    //   89: iconst_1
    //   90: istore 29
    //   92: aload_1
    //   93: aload 14
    //   95: iload 29
    //   97: invokevirtual 372	com/weiyun/sdk/job/transfer/ByteArrayPool:freeBuffer	(Lcom/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer;Z)V
    //   100: iload 4
    //   102: ireturn
    //   103: iload 5
    //   105: istore 22
    //   107: iload 5
    //   109: sipush 8192
    //   112: if_icmple +48 -> 160
    //   115: iload 20
    //   117: i2d
    //   118: dstore 6
    //   120: iload 17
    //   122: istore 18
    //   124: aload 8
    //   126: astore 10
    //   128: iload 17
    //   130: istore 19
    //   132: aload 8
    //   134: astore 12
    //   136: aload 8
    //   138: astore 13
    //   140: iload 5
    //   142: ldc2_w 373
    //   145: dload 6
    //   147: invokestatic 380	java/lang/Math:pow	(DD)D
    //   150: d2i
    //   151: idiv
    //   152: sipush 8192
    //   155: invokestatic 384	java/lang/Math:max	(II)I
    //   158: istore 22
    //   160: iload 17
    //   162: istore 18
    //   164: aload 8
    //   166: astore 10
    //   168: iload 17
    //   170: istore 19
    //   172: aload 8
    //   174: astore 12
    //   176: aload 8
    //   178: astore 13
    //   180: aload_1
    //   181: aload_0
    //   182: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   185: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   188: iload 22
    //   190: aload_3
    //   191: iconst_0
    //   192: iload 4
    //   194: invokevirtual 388	com/weiyun/sdk/job/api/StoragePlatomProto:buildUploadRequestHead	(JI[BII)I
    //   197: istore 23
    //   199: iload 17
    //   201: istore 18
    //   203: aload 8
    //   205: astore 10
    //   207: iload 17
    //   209: istore 19
    //   211: aload 8
    //   213: astore 12
    //   215: aload 8
    //   217: astore 13
    //   219: aload_0
    //   220: aload_2
    //   221: invokevirtual 392	com/weiyun/sdk/job/transfer/UploadTransfer:configHttpClient	(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpPost;
    //   224: astore 11
    //   226: iload 17
    //   228: istore 18
    //   230: aload 8
    //   232: astore 10
    //   234: iload 17
    //   236: istore 19
    //   238: aload 8
    //   240: astore 12
    //   242: aload 8
    //   244: astore 13
    //   246: aload 11
    //   248: new 394	com/weiyun/sdk/job/api/SppByteArrayEntity
    //   251: dup
    //   252: aload_3
    //   253: iconst_0
    //   254: iload 22
    //   256: iload 23
    //   258: iadd
    //   259: invokespecial 397	com/weiyun/sdk/job/api/SppByteArrayEntity:<init>	([BII)V
    //   262: invokevirtual 403	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   265: iconst_0
    //   266: istore 17
    //   268: iconst_0
    //   269: istore 25
    //   271: iconst_0
    //   272: istore 24
    //   274: iconst_0
    //   275: istore 26
    //   277: iconst_0
    //   278: istore 23
    //   280: iload 17
    //   282: istore 18
    //   284: aload 8
    //   286: astore 10
    //   288: iload 24
    //   290: istore 19
    //   292: aload 8
    //   294: astore 12
    //   296: aload 8
    //   298: astore 13
    //   300: aload_0
    //   301: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   304: aload 11
    //   306: invokevirtual 407	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   309: astore 8
    //   311: aload 8
    //   313: ifnonnull +95 -> 408
    //   316: iload 17
    //   318: istore 18
    //   320: aload 8
    //   322: astore 10
    //   324: iload 24
    //   326: istore 19
    //   328: aload 8
    //   330: astore 12
    //   332: aload 8
    //   334: astore 13
    //   336: aload_0
    //   337: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   340: iload 16
    //   342: istore 17
    //   344: aload 8
    //   346: ifnull +1721 -> 2067
    //   349: iload 16
    //   351: istore 17
    //   353: aload 8
    //   355: invokeinterface 415 1 0
    //   360: ifnull +1707 -> 2067
    //   363: aload 8
    //   365: invokeinterface 415 1 0
    //   370: invokeinterface 420 1 0
    //   375: aload 8
    //   377: astore 10
    //   379: iload 21
    //   381: istore 19
    //   383: iload 23
    //   385: istore 18
    //   387: iload 20
    //   389: iconst_1
    //   390: iadd
    //   391: istore 20
    //   393: iload 18
    //   395: istore 17
    //   397: iload 19
    //   399: istore 21
    //   401: aload 10
    //   403: astore 8
    //   405: goto -365 -> 40
    //   408: iload 17
    //   410: istore 18
    //   412: aload 8
    //   414: astore 10
    //   416: iload 24
    //   418: istore 19
    //   420: aload 8
    //   422: astore 12
    //   424: aload 8
    //   426: astore 13
    //   428: aload 8
    //   430: invokeinterface 424 1 0
    //   435: invokeinterface 430 1 0
    //   440: istore 16
    //   442: iload 16
    //   444: sipush 200
    //   447: if_icmpeq +718 -> 1165
    //   450: iload 17
    //   452: istore 18
    //   454: aload 8
    //   456: astore 10
    //   458: iload 24
    //   460: istore 19
    //   462: aload 8
    //   464: astore 12
    //   466: aload 8
    //   468: astore 13
    //   470: aload 15
    //   472: iconst_0
    //   473: aload 15
    //   475: invokevirtual 433	java/lang/StringBuilder:length	()I
    //   478: invokevirtual 437	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: iload 17
    //   484: istore 18
    //   486: aload 8
    //   488: astore 10
    //   490: iload 24
    //   492: istore 19
    //   494: aload 8
    //   496: astore 12
    //   498: aload 8
    //   500: astore 13
    //   502: aload 15
    //   504: ldc_w 439
    //   507: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: iload 16
    //   512: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: ldc_w 444
    //   518: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_1
    //   522: invokevirtual 447	com/weiyun/sdk/job/api/StoragePlatomProto:getUploadRspErrCode	()I
    //   525: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: iload 17
    //   531: istore 18
    //   533: aload 8
    //   535: astore 10
    //   537: iload 24
    //   539: istore 19
    //   541: aload 8
    //   543: astore 12
    //   545: aload 8
    //   547: astore 13
    //   549: ldc 14
    //   551: aload 15
    //   553: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: iload 16
    //   561: sipush 30000
    //   564: isub
    //   565: istore 22
    //   567: iload 17
    //   569: istore 18
    //   571: aload 8
    //   573: astore 10
    //   575: iload 24
    //   577: istore 19
    //   579: aload 8
    //   581: astore 12
    //   583: aload 8
    //   585: astore 13
    //   587: aload 8
    //   589: ldc_w 449
    //   592: invokeinterface 453 2 0
    //   597: astore 11
    //   599: iload 22
    //   601: istore 16
    //   603: aload 11
    //   605: ifnull +137 -> 742
    //   608: iload 22
    //   610: istore 16
    //   612: iload 17
    //   614: istore 18
    //   616: aload 8
    //   618: astore 10
    //   620: iload 24
    //   622: istore 19
    //   624: aload 8
    //   626: astore 12
    //   628: aload 8
    //   630: astore 13
    //   632: aload 11
    //   634: arraylength
    //   635: ifle +107 -> 742
    //   638: iload 17
    //   640: istore 18
    //   642: aload 8
    //   644: astore 10
    //   646: iload 24
    //   648: istore 19
    //   650: aload 8
    //   652: astore 12
    //   654: aload 8
    //   656: astore 13
    //   658: aload 11
    //   660: iconst_0
    //   661: aaload
    //   662: invokeinterface 458 1 0
    //   667: astore 11
    //   669: iload 17
    //   671: istore 18
    //   673: aload 8
    //   675: astore 10
    //   677: iload 24
    //   679: istore 19
    //   681: aload 8
    //   683: astore 12
    //   685: aload 8
    //   687: astore 13
    //   689: ldc 14
    //   691: new 116	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 460
    //   701: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 11
    //   706: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   715: iload 17
    //   717: istore 18
    //   719: aload 8
    //   721: astore 10
    //   723: iload 24
    //   725: istore 19
    //   727: aload 8
    //   729: astore 12
    //   731: aload 8
    //   733: astore 13
    //   735: aload 11
    //   737: invokestatic 466	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   740: istore 16
    //   742: iload 17
    //   744: istore 18
    //   746: aload 8
    //   748: astore 10
    //   750: iload 24
    //   752: istore 19
    //   754: aload 8
    //   756: astore 12
    //   758: aload 8
    //   760: astore 13
    //   762: aload_0
    //   763: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   766: iload 16
    //   768: istore 17
    //   770: aload 8
    //   772: ifnull +1295 -> 2067
    //   775: iload 16
    //   777: istore 17
    //   779: aload 8
    //   781: invokeinterface 415 1 0
    //   786: ifnull +1281 -> 2067
    //   789: aload 8
    //   791: invokeinterface 415 1 0
    //   796: invokeinterface 420 1 0
    //   801: iload 23
    //   803: istore 18
    //   805: iload 21
    //   807: istore 19
    //   809: aload 8
    //   811: astore 10
    //   813: goto -426 -> 387
    //   816: astore 11
    //   818: iload 17
    //   820: istore 18
    //   822: aload 8
    //   824: astore 10
    //   826: iload 24
    //   828: istore 19
    //   830: aload 8
    //   832: astore 12
    //   834: aload 8
    //   836: astore 13
    //   838: ldc 14
    //   840: aload 11
    //   842: invokestatic 469	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   845: iload 22
    //   847: istore 16
    //   849: goto -107 -> 742
    //   852: astore 12
    //   854: aload 10
    //   856: astore 8
    //   858: iload 18
    //   860: istore 16
    //   862: aload 9
    //   864: astore 11
    //   866: aload 12
    //   868: astore 10
    //   870: aload 8
    //   872: astore 9
    //   874: aload_0
    //   875: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   878: aload 10
    //   880: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   883: aload 8
    //   885: astore 9
    //   887: aload 10
    //   889: invokestatic 475	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   892: istore 19
    //   894: aload 8
    //   896: astore 9
    //   898: ldc 14
    //   900: new 116	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   907: ldc_w 477
    //   910: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: iload 19
    //   915: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   918: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: aload 10
    //   923: invokestatic 481	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   926: aload 11
    //   928: astore 12
    //   930: iload 19
    //   932: istore 17
    //   934: iload 16
    //   936: istore 18
    //   938: aload 8
    //   940: astore 13
    //   942: aload 8
    //   944: ifnull +57 -> 1001
    //   947: aload 11
    //   949: astore 12
    //   951: iload 19
    //   953: istore 17
    //   955: iload 16
    //   957: istore 18
    //   959: aload 8
    //   961: astore 13
    //   963: aload 8
    //   965: invokeinterface 415 1 0
    //   970: ifnull +31 -> 1001
    //   973: aload 8
    //   975: invokeinterface 415 1 0
    //   980: invokeinterface 420 1 0
    //   985: aload 8
    //   987: astore 13
    //   989: iload 16
    //   991: istore 18
    //   993: iload 19
    //   995: istore 17
    //   997: aload 11
    //   999: astore 12
    //   1001: aload_0
    //   1002: iconst_0
    //   1003: putfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1006: aload_0
    //   1007: aload_0
    //   1008: getfield 49	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   1011: i2d
    //   1012: ldc2_w 482
    //   1015: dmul
    //   1016: d2i
    //   1017: putfield 49	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   1020: iload 17
    //   1022: sipush 35534
    //   1025: if_icmpne +922 -> 1947
    //   1028: aload_0
    //   1029: aload_0
    //   1030: getfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1033: iconst_1
    //   1034: iadd
    //   1035: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1038: iload 17
    //   1040: sipush 35512
    //   1043: if_icmpeq +107 -> 1150
    //   1046: iload 17
    //   1048: sipush 35535
    //   1051: if_icmpeq +99 -> 1150
    //   1054: iload 17
    //   1056: sipush 35534
    //   1059: if_icmpeq +91 -> 1150
    //   1062: iload 17
    //   1064: sipush 35526
    //   1067: if_icmpeq +83 -> 1150
    //   1070: iload 17
    //   1072: sipush 35522
    //   1075: if_icmpeq +75 -> 1150
    //   1078: iload 17
    //   1080: sipush 35521
    //   1083: if_icmpeq +67 -> 1150
    //   1086: iload 17
    //   1088: sipush 35518
    //   1091: if_icmpeq +59 -> 1150
    //   1094: iload 17
    //   1096: sipush 35513
    //   1099: if_icmpeq +51 -> 1150
    //   1102: iload 17
    //   1104: sipush 35446
    //   1107: if_icmpeq +43 -> 1150
    //   1110: iload 17
    //   1112: sipush 35511
    //   1115: if_icmpeq +35 -> 1150
    //   1118: iload 17
    //   1120: sipush 35445
    //   1123: if_icmpeq +27 -> 1150
    //   1126: aload 12
    //   1128: astore 9
    //   1130: iload 17
    //   1132: istore 16
    //   1134: iload 21
    //   1136: istore 19
    //   1138: aload 13
    //   1140: astore 10
    //   1142: iload 17
    //   1144: sipush 35509
    //   1147: if_icmpne -760 -> 387
    //   1150: aconst_null
    //   1151: invokestatic 487	com/weiyun/sdk/util/NetworkUtils:hasInternet	(Landroid/content/Context;)Z
    //   1154: ifne +801 -> 1955
    //   1157: sipush 55533
    //   1160: istore 4
    //   1162: goto -1082 -> 80
    //   1165: iload 17
    //   1167: istore 18
    //   1169: aload 8
    //   1171: astore 10
    //   1173: iload 24
    //   1175: istore 19
    //   1177: aload 8
    //   1179: astore 12
    //   1181: aload 8
    //   1183: astore 13
    //   1185: new 489	java/io/BufferedInputStream
    //   1188: dup
    //   1189: aload 8
    //   1191: invokeinterface 415 1 0
    //   1196: invokeinterface 493 1 0
    //   1201: invokespecial 496	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1204: astore 11
    //   1206: aload 8
    //   1208: astore 9
    //   1210: aload 11
    //   1212: aload 14
    //   1214: getfield 501	com/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer:backingArray	[B
    //   1217: invokevirtual 507	java/io/InputStream:read	([B)I
    //   1220: istore 17
    //   1222: iload 17
    //   1224: ifgt +110 -> 1334
    //   1227: aload 8
    //   1229: astore 9
    //   1231: ldc 14
    //   1233: ldc_w 509
    //   1236: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1239: sipush 36533
    //   1242: istore 17
    //   1244: aload 11
    //   1246: astore 9
    //   1248: iload 17
    //   1250: istore 16
    //   1252: iload 23
    //   1254: istore 18
    //   1256: iload 21
    //   1258: istore 19
    //   1260: aload 8
    //   1262: astore 10
    //   1264: aload 8
    //   1266: ifnull -879 -> 387
    //   1269: aload 11
    //   1271: astore 9
    //   1273: iload 17
    //   1275: istore 16
    //   1277: iload 23
    //   1279: istore 18
    //   1281: iload 21
    //   1283: istore 19
    //   1285: aload 8
    //   1287: astore 10
    //   1289: aload 8
    //   1291: invokeinterface 415 1 0
    //   1296: ifnull -909 -> 387
    //   1299: aload 8
    //   1301: invokeinterface 415 1 0
    //   1306: invokeinterface 420 1 0
    //   1311: aload 11
    //   1313: astore 9
    //   1315: iload 17
    //   1317: istore 16
    //   1319: iload 23
    //   1321: istore 18
    //   1323: iload 21
    //   1325: istore 19
    //   1327: aload 8
    //   1329: astore 10
    //   1331: goto -944 -> 387
    //   1334: iload 16
    //   1336: sipush 200
    //   1339: if_icmpne +178 -> 1517
    //   1342: iconst_1
    //   1343: istore 29
    //   1345: aload 8
    //   1347: astore 9
    //   1349: aload_1
    //   1350: iload 29
    //   1352: aload 14
    //   1354: getfield 501	com/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer:backingArray	[B
    //   1357: iload 17
    //   1359: invokevirtual 513	com/weiyun/sdk/job/api/StoragePlatomProto:parseUploadRsp	(Z[BI)I
    //   1362: istore 16
    //   1364: iload 16
    //   1366: ifne +185 -> 1551
    //   1369: aload 8
    //   1371: astore 9
    //   1373: aload_0
    //   1374: iconst_0
    //   1375: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1378: aload 8
    //   1380: astore 9
    //   1382: aload_0
    //   1383: iload 22
    //   1385: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1388: iload 20
    //   1390: ifne +57 -> 1447
    //   1393: aload 8
    //   1395: astore 9
    //   1397: aload_0
    //   1398: aload_0
    //   1399: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1402: iconst_1
    //   1403: iadd
    //   1404: putfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1407: aload 8
    //   1409: astore 9
    //   1411: aload_0
    //   1412: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1415: aload_0
    //   1416: getfield 49	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   1419: if_icmplt +28 -> 1447
    //   1422: aload 8
    //   1424: astore 9
    //   1426: aload_0
    //   1427: aload_0
    //   1428: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1431: sipush 8192
    //   1434: iadd
    //   1435: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1438: aload 8
    //   1440: astore 9
    //   1442: aload_0
    //   1443: iconst_0
    //   1444: putfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1447: aload 8
    //   1449: astore 9
    //   1451: aload_0
    //   1452: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1455: sipush 8192
    //   1458: if_icmpge +65 -> 1523
    //   1461: aload 8
    //   1463: astore 9
    //   1465: aload_0
    //   1466: sipush 8192
    //   1469: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1472: iconst_0
    //   1473: istore 5
    //   1475: iload 5
    //   1477: istore 4
    //   1479: aload 8
    //   1481: ifnull -1401 -> 80
    //   1484: iload 5
    //   1486: istore 4
    //   1488: aload 8
    //   1490: invokeinterface 415 1 0
    //   1495: ifnull -1415 -> 80
    //   1498: aload 8
    //   1500: invokeinterface 415 1 0
    //   1505: invokeinterface 420 1 0
    //   1510: iload 5
    //   1512: istore 4
    //   1514: goto -1434 -> 80
    //   1517: iconst_0
    //   1518: istore 29
    //   1520: goto -175 -> 1345
    //   1523: aload 8
    //   1525: astore 9
    //   1527: aload_0
    //   1528: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1531: ldc_w 514
    //   1534: if_icmple -62 -> 1472
    //   1537: aload 8
    //   1539: astore 9
    //   1541: aload_0
    //   1542: ldc_w 514
    //   1545: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1548: goto -76 -> 1472
    //   1551: ldc_w 515
    //   1554: iload 16
    //   1556: if_icmpne +145 -> 1701
    //   1559: aload 8
    //   1561: astore 9
    //   1563: aload 15
    //   1565: iconst_0
    //   1566: aload 15
    //   1568: invokevirtual 433	java/lang/StringBuilder:length	()I
    //   1571: invokevirtual 437	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: aload 8
    //   1577: astore 9
    //   1579: aload 15
    //   1581: ldc_w 517
    //   1584: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: iload 16
    //   1589: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: aload 8
    //   1595: astore 9
    //   1597: ldc 14
    //   1599: aload 15
    //   1601: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1604: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1607: iload 16
    //   1609: istore 17
    //   1611: aload 11
    //   1613: astore 9
    //   1615: iload 17
    //   1617: istore 16
    //   1619: iload 23
    //   1621: istore 18
    //   1623: iload 21
    //   1625: istore 19
    //   1627: aload 8
    //   1629: astore 10
    //   1631: aload 8
    //   1633: ifnull -1246 -> 387
    //   1636: aload 11
    //   1638: astore 9
    //   1640: iload 17
    //   1642: istore 16
    //   1644: iload 23
    //   1646: istore 18
    //   1648: iload 21
    //   1650: istore 19
    //   1652: aload 8
    //   1654: astore 10
    //   1656: aload 8
    //   1658: invokeinterface 415 1 0
    //   1663: ifnull -1276 -> 387
    //   1666: aload 8
    //   1668: invokeinterface 415 1 0
    //   1673: invokeinterface 420 1 0
    //   1678: aload 11
    //   1680: astore 9
    //   1682: iload 17
    //   1684: istore 16
    //   1686: iload 23
    //   1688: istore 18
    //   1690: iload 21
    //   1692: istore 19
    //   1694: aload 8
    //   1696: astore 10
    //   1698: goto -1311 -> 387
    //   1701: aload 8
    //   1703: astore 9
    //   1705: aload 15
    //   1707: iconst_0
    //   1708: aload 15
    //   1710: invokevirtual 433	java/lang/StringBuilder:length	()I
    //   1713: invokevirtual 437	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1716: pop
    //   1717: aload 8
    //   1719: astore 9
    //   1721: aload 15
    //   1723: ldc_w 519
    //   1726: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: iload 16
    //   1731: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1734: pop
    //   1735: aload 8
    //   1737: astore 9
    //   1739: ldc 14
    //   1741: aload 15
    //   1743: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1746: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1749: iload 16
    //   1751: istore 4
    //   1753: aload 8
    //   1755: ifnull -1675 -> 80
    //   1758: iload 16
    //   1760: istore 4
    //   1762: aload 8
    //   1764: invokeinterface 415 1 0
    //   1769: ifnull -1689 -> 80
    //   1772: aload 8
    //   1774: invokeinterface 415 1 0
    //   1779: invokeinterface 420 1 0
    //   1784: iload 16
    //   1786: istore 4
    //   1788: goto -1708 -> 80
    //   1791: astore 10
    //   1793: aload 12
    //   1795: astore 8
    //   1797: aload 9
    //   1799: astore 11
    //   1801: aload 8
    //   1803: astore 9
    //   1805: ldc 14
    //   1807: aload 10
    //   1809: invokevirtual 522	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1812: aload 10
    //   1814: invokestatic 481	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1817: aload 8
    //   1819: astore 9
    //   1821: aload_0
    //   1822: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1825: aload 10
    //   1827: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1830: sipush 55522
    //   1833: istore 16
    //   1835: aload 11
    //   1837: astore 12
    //   1839: iload 16
    //   1841: istore 17
    //   1843: iload 19
    //   1845: istore 18
    //   1847: aload 8
    //   1849: astore 13
    //   1851: aload 8
    //   1853: ifnull -852 -> 1001
    //   1856: aload 11
    //   1858: astore 12
    //   1860: iload 16
    //   1862: istore 17
    //   1864: iload 19
    //   1866: istore 18
    //   1868: aload 8
    //   1870: astore 13
    //   1872: aload 8
    //   1874: invokeinterface 415 1 0
    //   1879: ifnull -878 -> 1001
    //   1882: aload 8
    //   1884: invokeinterface 415 1 0
    //   1889: invokeinterface 420 1 0
    //   1894: aload 11
    //   1896: astore 12
    //   1898: iload 16
    //   1900: istore 17
    //   1902: iload 19
    //   1904: istore 18
    //   1906: aload 8
    //   1908: astore 13
    //   1910: goto -909 -> 1001
    //   1913: astore_1
    //   1914: aload 13
    //   1916: astore 9
    //   1918: aload 9
    //   1920: ifnull +25 -> 1945
    //   1923: aload 9
    //   1925: invokeinterface 415 1 0
    //   1930: ifnull +15 -> 1945
    //   1933: aload 9
    //   1935: invokeinterface 415 1 0
    //   1940: invokeinterface 420 1 0
    //   1945: aload_1
    //   1946: athrow
    //   1947: aload_0
    //   1948: iconst_0
    //   1949: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1952: goto -914 -> 1038
    //   1955: iconst_1
    //   1956: istore 18
    //   1958: iload 21
    //   1960: iconst_1
    //   1961: iadd
    //   1962: istore 19
    //   1964: ldc2_w 523
    //   1967: ldc2_w 373
    //   1970: iload 20
    //   1972: i2d
    //   1973: ldc2_w 525
    //   1976: invokestatic 380	java/lang/Math:pow	(DD)D
    //   1979: dadd
    //   1980: dmul
    //   1981: d2l
    //   1982: lstore 27
    //   1984: ldc 14
    //   1986: new 116	java/lang/StringBuilder
    //   1989: dup
    //   1990: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   1993: ldc_w 528
    //   1996: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1999: lload 27
    //   2001: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2004: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2007: invokestatic 531	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2010: lload 27
    //   2012: invokestatic 536	java/lang/Thread:sleep	(J)V
    //   2015: aload 12
    //   2017: astore 9
    //   2019: iload 17
    //   2021: istore 16
    //   2023: aload 13
    //   2025: astore 10
    //   2027: goto -1640 -> 387
    //   2030: astore_1
    //   2031: ldc 14
    //   2033: aload_1
    //   2034: invokevirtual 537	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   2037: aload_1
    //   2038: invokestatic 539	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2041: iload 17
    //   2043: istore 4
    //   2045: goto -1965 -> 80
    //   2048: iconst_0
    //   2049: istore 29
    //   2051: goto -1959 -> 92
    //   2054: astore_1
    //   2055: goto -137 -> 1918
    //   2058: astore 10
    //   2060: iload 26
    //   2062: istore 19
    //   2064: goto -263 -> 1801
    //   2067: iload 17
    //   2069: istore 16
    //   2071: iload 23
    //   2073: istore 18
    //   2075: iload 21
    //   2077: istore 19
    //   2079: aload 8
    //   2081: astore 10
    //   2083: goto -1696 -> 387
    //   2086: iload 16
    //   2088: istore 4
    //   2090: goto -2010 -> 80
    //   2093: astore 10
    //   2095: iload 25
    //   2097: istore 16
    //   2099: goto -1229 -> 870
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2102	0	this	UploadTransfer
    //   0	2102	1	paramStoragePlatomProto	StoragePlatomProto
    //   0	2102	2	paramURL	URL
    //   0	2102	3	paramArrayOfByte	byte[]
    //   0	2102	4	paramInt1	int
    //   0	2102	5	paramInt2	int
    //   118	28	6	d	double
    //   18	2062	8	localObject1	Object
    //   38	1980	9	localObject2	Object
    //   126	1571	10	localObject3	Object
    //   1791	35	10	localException1	Exception
    //   2025	1	10	localObject4	Object
    //   2058	1	10	localException2	Exception
    //   2081	1	10	localObject5	Object
    //   2093	1	10	localIOException1	IOException
    //   224	512	11	localObject6	Object
    //   816	25	11	localThrowable	Throwable
    //   864	1031	11	localObject7	Object
    //   134	699	12	localObject8	Object
    //   852	15	12	localIOException2	IOException
    //   928	1088	12	localObject9	Object
    //   138	1886	13	localObject10	Object
    //   6	1347	14	localByteArrayBuffer	ByteArrayPool.ByteArrayBuffer
    //   15	1727	15	localStringBuilder	StringBuilder
    //   21	2077	16	i	int
    //   29	2039	17	j	int
    //   122	1952	18	k	int
    //   130	1948	19	m	int
    //   35	1936	20	n	int
    //   32	2044	21	i1	int
    //   105	1279	22	i2	int
    //   197	1875	23	i3	int
    //   272	902	24	i4	int
    //   269	1827	25	i5	int
    //   275	1786	26	i6	int
    //   1982	29	27	l	long
    //   90	1960	29	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   587	599	816	java/lang/Throwable
    //   632	638	816	java/lang/Throwable
    //   658	669	816	java/lang/Throwable
    //   689	715	816	java/lang/Throwable
    //   735	742	816	java/lang/Throwable
    //   140	160	852	java/io/IOException
    //   180	199	852	java/io/IOException
    //   219	226	852	java/io/IOException
    //   246	265	852	java/io/IOException
    //   300	311	852	java/io/IOException
    //   336	340	852	java/io/IOException
    //   428	442	852	java/io/IOException
    //   470	482	852	java/io/IOException
    //   502	529	852	java/io/IOException
    //   549	559	852	java/io/IOException
    //   587	599	852	java/io/IOException
    //   632	638	852	java/io/IOException
    //   658	669	852	java/io/IOException
    //   689	715	852	java/io/IOException
    //   735	742	852	java/io/IOException
    //   762	766	852	java/io/IOException
    //   838	845	852	java/io/IOException
    //   1185	1206	852	java/io/IOException
    //   140	160	1791	java/lang/Exception
    //   180	199	1791	java/lang/Exception
    //   219	226	1791	java/lang/Exception
    //   246	265	1791	java/lang/Exception
    //   300	311	1791	java/lang/Exception
    //   336	340	1791	java/lang/Exception
    //   428	442	1791	java/lang/Exception
    //   470	482	1791	java/lang/Exception
    //   502	529	1791	java/lang/Exception
    //   549	559	1791	java/lang/Exception
    //   587	599	1791	java/lang/Exception
    //   632	638	1791	java/lang/Exception
    //   658	669	1791	java/lang/Exception
    //   689	715	1791	java/lang/Exception
    //   735	742	1791	java/lang/Exception
    //   762	766	1791	java/lang/Exception
    //   838	845	1791	java/lang/Exception
    //   1185	1206	1791	java/lang/Exception
    //   140	160	1913	finally
    //   180	199	1913	finally
    //   219	226	1913	finally
    //   246	265	1913	finally
    //   300	311	1913	finally
    //   336	340	1913	finally
    //   428	442	1913	finally
    //   470	482	1913	finally
    //   502	529	1913	finally
    //   549	559	1913	finally
    //   587	599	1913	finally
    //   632	638	1913	finally
    //   658	669	1913	finally
    //   689	715	1913	finally
    //   735	742	1913	finally
    //   762	766	1913	finally
    //   838	845	1913	finally
    //   1185	1206	1913	finally
    //   2010	2015	2030	java/lang/InterruptedException
    //   874	883	2054	finally
    //   887	894	2054	finally
    //   898	926	2054	finally
    //   1210	1222	2054	finally
    //   1231	1239	2054	finally
    //   1349	1364	2054	finally
    //   1373	1378	2054	finally
    //   1382	1388	2054	finally
    //   1397	1407	2054	finally
    //   1411	1422	2054	finally
    //   1426	1438	2054	finally
    //   1442	1447	2054	finally
    //   1451	1461	2054	finally
    //   1465	1472	2054	finally
    //   1527	1537	2054	finally
    //   1541	1548	2054	finally
    //   1563	1575	2054	finally
    //   1579	1593	2054	finally
    //   1597	1607	2054	finally
    //   1705	1717	2054	finally
    //   1721	1735	2054	finally
    //   1739	1749	2054	finally
    //   1805	1817	2054	finally
    //   1821	1830	2054	finally
    //   1210	1222	2058	java/lang/Exception
    //   1231	1239	2058	java/lang/Exception
    //   1349	1364	2058	java/lang/Exception
    //   1373	1378	2058	java/lang/Exception
    //   1382	1388	2058	java/lang/Exception
    //   1397	1407	2058	java/lang/Exception
    //   1411	1422	2058	java/lang/Exception
    //   1426	1438	2058	java/lang/Exception
    //   1442	1447	2058	java/lang/Exception
    //   1451	1461	2058	java/lang/Exception
    //   1465	1472	2058	java/lang/Exception
    //   1527	1537	2058	java/lang/Exception
    //   1541	1548	2058	java/lang/Exception
    //   1563	1575	2058	java/lang/Exception
    //   1579	1593	2058	java/lang/Exception
    //   1597	1607	2058	java/lang/Exception
    //   1705	1717	2058	java/lang/Exception
    //   1721	1735	2058	java/lang/Exception
    //   1739	1749	2058	java/lang/Exception
    //   1210	1222	2093	java/io/IOException
    //   1231	1239	2093	java/io/IOException
    //   1349	1364	2093	java/io/IOException
    //   1373	1378	2093	java/io/IOException
    //   1382	1388	2093	java/io/IOException
    //   1397	1407	2093	java/io/IOException
    //   1411	1422	2093	java/io/IOException
    //   1426	1438	2093	java/io/IOException
    //   1442	1447	2093	java/io/IOException
    //   1451	1461	2093	java/io/IOException
    //   1465	1472	2093	java/io/IOException
    //   1527	1537	2093	java/io/IOException
    //   1541	1548	2093	java/io/IOException
    //   1563	1575	2093	java/io/IOException
    //   1579	1593	2093	java/io/IOException
    //   1597	1607	2093	java/io/IOException
    //   1705	1717	2093	java/io/IOException
    //   1721	1735	2093	java/io/IOException
    //   1739	1749	2093	java/io/IOException
  }
  
  /* Error */
  private int processUpload()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 85	com/weiyun/sdk/job/transfer/UploadTransfer:createUrl	()Ljava/net/URL;
    //   4: astore_3
    //   5: new 165	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   13: invokevirtual 294	com/weiyun/sdk/job/UploadJobContext:getSrcPath	()Ljava/lang/String;
    //   16: ldc_w 547
    //   19: invokespecial 549	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: astore_2
    //   23: iconst_0
    //   24: istore 6
    //   26: aload_0
    //   27: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   30: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   33: ldc2_w 9
    //   36: lcmp
    //   37: ifle +145 -> 182
    //   40: new 133	com/weiyun/sdk/job/api/StoragePlatomProto
    //   43: dup
    //   44: sipush 1007
    //   47: aload_0
    //   48: getfield 76	com/weiyun/sdk/job/transfer/UploadTransfer:mFileHash	[B
    //   51: aload_0
    //   52: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   55: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   58: aload_0
    //   59: getfield 69	com/weiyun/sdk/job/transfer/UploadTransfer:mUkey	[B
    //   62: iconst_0
    //   63: i2l
    //   64: invokespecial 552	com/weiyun/sdk/job/api/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   67: astore_1
    //   68: ldc_w 553
    //   71: newarray <illegal type>
    //   73: astore 4
    //   75: aload_0
    //   76: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   79: invokevirtual 363	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   82: ifne +150 -> 232
    //   85: ldc 14
    //   87: ldc_w 365
    //   90: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: aload_2
    //   95: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   98: aload_0
    //   99: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   102: sipush 55534
    //   105: ireturn
    //   106: astore_1
    //   107: ldc 14
    //   109: new 116	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 557
    //   119: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   136: aload_1
    //   137: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   140: sipush 55530
    //   143: ireturn
    //   144: astore_1
    //   145: ldc 14
    //   147: new 116	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 564
    //   157: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_0
    //   171: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   174: aload_1
    //   175: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   178: sipush 36534
    //   181: ireturn
    //   182: new 133	com/weiyun/sdk/job/api/StoragePlatomProto
    //   185: dup
    //   186: sipush 1000
    //   189: aload_0
    //   190: getfield 76	com/weiyun/sdk/job/transfer/UploadTransfer:mFileHash	[B
    //   193: aload_0
    //   194: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   197: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   200: aload_0
    //   201: getfield 69	com/weiyun/sdk/job/transfer/UploadTransfer:mUkey	[B
    //   204: iconst_0
    //   205: i2l
    //   206: invokespecial 552	com/weiyun/sdk/job/api/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   209: astore_1
    //   210: goto -142 -> 68
    //   213: astore_1
    //   214: ldc 14
    //   216: aload_1
    //   217: invokestatic 566	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_0
    //   221: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   224: aload_1
    //   225: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   228: sipush 55535
    //   231: ireturn
    //   232: aload_0
    //   233: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   236: invokevirtual 569	com/weiyun/sdk/job/BaseUploadJob:checkFile	()Z
    //   239: ifne +32 -> 271
    //   242: ldc 14
    //   244: ldc_w 571
    //   247: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   254: invokevirtual 574	com/weiyun/sdk/job/BaseUploadJob:getLastErrorNo	()I
    //   257: istore 6
    //   259: aload_0
    //   260: aload_2
    //   261: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   264: aload_0
    //   265: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   268: iload 6
    //   270: ireturn
    //   271: aload_0
    //   272: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   275: invokevirtual 577	com/weiyun/sdk/job/BaseUploadJob:checkEnvironment	()Z
    //   278: ifne +32 -> 310
    //   281: ldc 14
    //   283: ldc_w 579
    //   286: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_0
    //   290: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   293: invokevirtual 574	com/weiyun/sdk/job/BaseUploadJob:getLastErrorNo	()I
    //   296: istore 6
    //   298: aload_0
    //   299: aload_2
    //   300: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   303: aload_0
    //   304: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   307: iload 6
    //   309: ireturn
    //   310: aload_0
    //   311: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   314: ifgt +46 -> 360
    //   317: invokestatic 584	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   320: invokevirtual 585	com/weiyun/sdk/context/SdkContext:getContext	()Landroid/content/Context;
    //   323: invokestatic 588	com/weiyun/sdk/util/NetworkUtils:getPacketSize	(Landroid/content/Context;)I
    //   326: istore 7
    //   328: iload 7
    //   330: ifge +24 -> 354
    //   333: ldc 14
    //   335: ldc_w 590
    //   338: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload_0
    //   342: aload_2
    //   343: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   346: aload_0
    //   347: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   350: sipush 55533
    //   353: ireturn
    //   354: aload_0
    //   355: iload 7
    //   357: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   360: invokestatic 108	android/os/SystemClock:uptimeMillis	()J
    //   363: lstore 9
    //   365: aload_0
    //   366: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   369: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   372: lstore 11
    //   374: aload_2
    //   375: aload_0
    //   376: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   379: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   382: invokevirtual 593	java/io/RandomAccessFile:seek	(J)V
    //   385: aload_1
    //   386: invokevirtual 596	com/weiyun/sdk/job/api/StoragePlatomProto:getHeadLength	()I
    //   389: istore 8
    //   391: aload_2
    //   392: aload 4
    //   394: iload 8
    //   396: aload_0
    //   397: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   400: invokevirtual 599	java/io/RandomAccessFile:read	([BII)I
    //   403: istore 7
    //   405: iload 7
    //   407: ifgt +42 -> 449
    //   410: aload_0
    //   411: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   414: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   417: lstore 13
    //   419: aload_0
    //   420: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   423: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   426: lstore 15
    //   428: lload 13
    //   430: lload 15
    //   432: lcmp
    //   433: ifge +16 -> 449
    //   436: aload_0
    //   437: aload_2
    //   438: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   441: aload_0
    //   442: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   445: sipush 55527
    //   448: ireturn
    //   449: iload 7
    //   451: ifgt +40 -> 491
    //   454: aload_0
    //   455: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   458: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   461: lstore 13
    //   463: aload_0
    //   464: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   467: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   470: lstore 15
    //   472: lload 13
    //   474: lload 15
    //   476: lcmp
    //   477: ifne +14 -> 491
    //   480: aload_0
    //   481: aload_2
    //   482: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   485: aload_0
    //   486: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   489: iconst_0
    //   490: ireturn
    //   491: iload 6
    //   493: iconst_1
    //   494: iadd
    //   495: istore 6
    //   497: iload 6
    //   499: i2l
    //   500: lstore 13
    //   502: aload_1
    //   503: lload 13
    //   505: invokevirtual 602	com/weiyun/sdk/job/api/StoragePlatomProto:setSeq	(J)V
    //   508: aload_0
    //   509: aload_1
    //   510: aload_3
    //   511: aload 4
    //   513: iload 8
    //   515: iload 7
    //   517: invokespecial 604	com/weiyun/sdk/job/transfer/UploadTransfer:httpPostData	(Lcom/weiyun/sdk/job/api/StoragePlatomProto;Ljava/net/URL;[BII)I
    //   520: istore 8
    //   522: iload 8
    //   524: ifeq +41 -> 565
    //   527: ldc 14
    //   529: new 116	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 606
    //   539: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: iload 8
    //   544: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 531	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload_0
    //   554: aload_2
    //   555: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   558: aload_0
    //   559: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   562: iload 8
    //   564: ireturn
    //   565: aload_0
    //   566: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   569: invokevirtual 363	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   572: ifne +24 -> 596
    //   575: ldc 14
    //   577: ldc_w 365
    //   580: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: aload_0
    //   584: aload_2
    //   585: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   588: aload_0
    //   589: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   592: sipush 55534
    //   595: ireturn
    //   596: aload_0
    //   597: aload_1
    //   598: iload 7
    //   600: invokespecial 610	com/weiyun/sdk/job/transfer/UploadTransfer:processUploadRsp	(Lcom/weiyun/sdk/job/api/StoragePlatomProto;I)V
    //   603: aload_0
    //   604: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   607: astore 5
    //   609: aload 5
    //   611: aload 5
    //   613: getfield 258	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:transferDataTimeCost	J
    //   616: invokestatic 108	android/os/SystemClock:uptimeMillis	()J
    //   619: lload 9
    //   621: lsub
    //   622: ladd
    //   623: putfield 258	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:transferDataTimeCost	J
    //   626: aload_0
    //   627: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   630: astore 5
    //   632: aload 5
    //   634: aload 5
    //   636: getfield 288	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:transferDataSize	J
    //   639: aload_0
    //   640: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   643: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   646: lload 11
    //   648: lsub
    //   649: ladd
    //   650: putfield 288	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:transferDataSize	J
    //   653: aload_0
    //   654: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   657: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   660: aload_0
    //   661: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   664: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   667: lcmp
    //   668: ifeq -188 -> 480
    //   671: aload_0
    //   672: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   675: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   678: aload_0
    //   679: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   682: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   685: lcmp
    //   686: ifle -611 -> 75
    //   689: ldc 14
    //   691: new 116	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 612
    //   701: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload_0
    //   705: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   708: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   711: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   714: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload_0
    //   721: aload_2
    //   722: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   725: aload_0
    //   726: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   729: sipush 55523
    //   732: ireturn
    //   733: astore_1
    //   734: ldc 14
    //   736: new 116	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 614
    //   746: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_1
    //   750: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload_0
    //   760: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   763: aload_1
    //   764: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   767: aload_0
    //   768: aload_2
    //   769: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   772: aload_0
    //   773: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   776: sipush 55528
    //   779: ireturn
    //   780: astore_1
    //   781: ldc 14
    //   783: aload_1
    //   784: invokevirtual 615	java/lang/Exception:toString	()Ljava/lang/String;
    //   787: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   790: aload_0
    //   791: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   794: aload_1
    //   795: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   798: aload_0
    //   799: aload_2
    //   800: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   803: aload_0
    //   804: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   807: sipush 55522
    //   810: ireturn
    //   811: astore_1
    //   812: aload_0
    //   813: aload_2
    //   814: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   817: aload_0
    //   818: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   821: aload_1
    //   822: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	this	UploadTransfer
    //   67	1	1	localStoragePlatomProto1	StoragePlatomProto
    //   106	31	1	localFileNotFoundException	java.io.FileNotFoundException
    //   144	31	1	localMalformedURLException	MalformedURLException
    //   209	1	1	localStoragePlatomProto2	StoragePlatomProto
    //   213	385	1	localIllegalArgumentException	IllegalArgumentException
    //   733	31	1	localIOException	IOException
    //   780	15	1	localException	Exception
    //   811	11	1	localObject	Object
    //   22	792	2	localRandomAccessFile	RandomAccessFile
    //   4	507	3	localURL	URL
    //   73	439	4	arrayOfByte	byte[]
    //   607	28	5	localProcessInfo	Transfer.ProcessInfo
    //   24	474	6	i	int
    //   326	273	7	j	int
    //   389	174	8	k	int
    //   363	257	9	l1	long
    //   372	275	11	l2	long
    //   417	87	13	l3	long
    //   426	49	15	l4	long
    // Exception table:
    //   from	to	target	type
    //   0	23	106	java/io/FileNotFoundException
    //   0	23	144	java/net/MalformedURLException
    //   26	68	213	java/lang/IllegalArgumentException
    //   182	210	213	java/lang/IllegalArgumentException
    //   75	93	733	java/io/IOException
    //   232	259	733	java/io/IOException
    //   271	298	733	java/io/IOException
    //   310	328	733	java/io/IOException
    //   333	341	733	java/io/IOException
    //   354	360	733	java/io/IOException
    //   360	405	733	java/io/IOException
    //   410	428	733	java/io/IOException
    //   454	472	733	java/io/IOException
    //   502	522	733	java/io/IOException
    //   527	553	733	java/io/IOException
    //   565	583	733	java/io/IOException
    //   596	671	733	java/io/IOException
    //   671	720	733	java/io/IOException
    //   75	93	780	java/lang/Exception
    //   232	259	780	java/lang/Exception
    //   271	298	780	java/lang/Exception
    //   310	328	780	java/lang/Exception
    //   333	341	780	java/lang/Exception
    //   354	360	780	java/lang/Exception
    //   360	405	780	java/lang/Exception
    //   410	428	780	java/lang/Exception
    //   454	472	780	java/lang/Exception
    //   502	522	780	java/lang/Exception
    //   527	553	780	java/lang/Exception
    //   565	583	780	java/lang/Exception
    //   596	671	780	java/lang/Exception
    //   671	720	780	java/lang/Exception
    //   75	93	811	finally
    //   232	259	811	finally
    //   271	298	811	finally
    //   310	328	811	finally
    //   333	341	811	finally
    //   354	360	811	finally
    //   360	405	811	finally
    //   410	428	811	finally
    //   454	472	811	finally
    //   502	522	811	finally
    //   527	553	811	finally
    //   565	583	811	finally
    //   596	671	811	finally
    //   671	720	811	finally
    //   734	767	811	finally
    //   781	798	811	finally
  }
  
  private void processUploadRsp(StoragePlatomProto paramStoragePlatomProto, int paramInt)
  {
    switch (paramStoragePlatomProto.getUploadRspFlag())
    {
    default: 
      return;
    case 1: 
      if (this.mContext.getCurSize() + paramInt < this.mContext.getTotalSize())
      {
        com.weiyun.sdk.log.Log.i("UploadTransfer", "some file has the same md5. file = " + this.mContext.getFileName());
        this.mContext.setContentExist(true);
        BaseUploadJob.makeFakeTransfer(this.mContext, this.mJob);
      }
      this.mContext.setCurSize(this.mContext.getTotalSize());
      this.mJob.notifyProgressChanged(this.mContext.getTotalSize(), this.mContext.getTotalSize());
      return;
    }
    adjustProgress(paramStoragePlatomProto, this.mContext.getCurSize() + paramInt);
  }
  
  protected HttpPost configHttpClient(URL paramURL)
  {
    paramURL = new HttpPost(paramURL.toString());
    paramURL.addHeader("Accept", "*/*");
    paramURL.addHeader("User-Agent", "QdiskAndroid1.1.0");
    paramURL.addHeader("Accept-Language", "zh-CN");
    paramURL.addHeader("Referer", "http://udisk.qq.com/android");
    paramURL.addHeader("Charset", "UTF-8");
    paramURL.addHeader("Proxy-Connection", "Keep-Alive");
    paramURL.addHeader("Pragma", "no-cache");
    paramURL.addHeader("Content-type", "text/octet");
    if (this.mHttpClient == null)
    {
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      localBasicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(30000));
      localBasicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(45000));
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      this.mHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      this.mHttpClient.setHttpRequestRetryHandler(createHttpRequestRetryHandler(1, true));
    }
    if (!NetworkUtils.isWIFI(SdkContext.getInstance().getContext()))
    {
      this.mHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 45000));
      this.mHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(60000 + this.mTimeoutTimes * 5000));
      return paramURL;
    }
    this.mHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 30000));
    this.mHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 45000));
    return paramURL;
  }
  
  protected DefaultHttpRequestRetryHandler createHttpRequestRetryHandler(int paramInt, boolean paramBoolean)
  {
    return new UploadTaskRequestRetryHandler(paramInt, true);
  }
  
  protected URL createUrl()
    throws MalformedURLException
  {
    return new URL("http", this.mAddress.getHost(), this.mAddress.getPort(), this.mAddress.getFile());
  }
  
  public int transfer()
  {
    int i = processUpload();
    doInnerReport(new Transfer.Result(i, ErrorMessages.getErrorString(i)), this.mProcessInfo);
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\transfer\UploadTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */