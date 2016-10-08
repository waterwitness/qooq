package com.tencent.mobileqq.highway.conn;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.IRequestListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HttpConnection
  implements IConnection, IProtocolCodecListener
{
  private static final String BIG_DATA_HIGHWAY_URL = "/cgi-bin/httpconn?htcmd=0x6ff0082";
  private static final int MAX_REDIRECT_NUM = 5;
  private int iErrCode;
  private int mConnId;
  private IConnectionListener mConnListener;
  private HttpURLConnection mConnection;
  private ConnManager mConnmanager;
  private EndPoint mCurrentPoint;
  private TcpProtocolDataCodec mDataCodec;
  private HandlerThread mExecutor;
  private Handler mHandler;
  private String mStrErrInfo = "";
  
  public HttpConnection(ConnManager paramConnManager, int paramInt, EndPoint paramEndPoint)
  {
    this.mConnmanager = paramConnManager;
    this.mConnId = paramInt;
    this.mCurrentPoint = paramEndPoint;
    this.mExecutor = new HandlerThread("BDH-HTTP-" + paramInt);
  }
  
  private void doSendRequest()
  {
    BdhLogUtil.LogEvent("C", "[HttpConn] doSendRequest about to peak one request.");
    HwRequest localHwRequest = this.mConnmanager.pullNextRequest(this, false, 0L, 0L, 0);
    if (localHwRequest == null) {}
    do
    {
      return;
      this.mDataCodec = new TcpProtocolDataCodec();
      this.mDataCodec.setProtocolCodecListener(this);
      BdhLogUtil.LogEvent("C", "[HttpConn] doSendRequest continue to send. ReqInfo : " + localHwRequest.toString());
      localHwRequest.endpoint = this.mCurrentPoint;
      byte[] arrayOfByte = localHwRequest.getRequestBody();
      if ((arrayOfByte == null) && (localHwRequest.hasRequestBody()))
      {
        localHwRequest.reqListener.handleError(64532, "NullBody");
        wakeupChannel();
        return;
      }
      handleHttpReqData(localHwRequest, this.mDataCodec.encodeC2SData(this.mCurrentPoint, localHwRequest, arrayOfByte), localHwRequest.mBuCmdId);
      if (this.iErrCode == 0)
      {
        wakeupChannel();
        return;
      }
      localHwRequest.reqListener.handleError(this.iErrCode, this.mStrErrInfo);
    } while (this.iErrCode != 64522);
    stopConnThread();
  }
  
  private String getBdhConnURL()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://").append(this.mCurrentPoint.host);
    if (this.mCurrentPoint.port != 80) {
      localStringBuilder.append(":").append(this.mCurrentPoint.port);
    }
    localStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0082");
    return localStringBuilder.toString();
  }
  
  private HttpURLConnection getConnection(String paramString, HashMap<String, String> paramHashMap, long paramLong, int paramInt)
    throws Throwable
  {
    BdhLogUtil.LogEvent("C", "[HttpConn] Open Connection. Try Open : " + paramString);
    String str = android.net.Proxy.getDefaultHost();
    int m = android.net.Proxy.getDefaultPort();
    int i = 0;
    paramInt = 0;
    Object localObject1 = null;
    int j;
    for (;;)
    {
      if ((paramInt != 0) || (i >= 2)) {
        break label490;
      }
      Object localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      int k = -1;
      localObject1 = null;
      if (localObject2 != null)
      {
        k = ((NetworkInfo)localObject2).getType();
        localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
      }
      localObject1 = BdhUtils.getApnType((String)localObject1);
      if ((k == 1) || (((String)localObject1).toLowerCase().equals(BdhUtils.APN_TYPE_CMWAP)))
      {
        paramInt = 0;
        j = paramInt;
        if (k == 1) {
          if (!"10.0.0.172".equals(str))
          {
            j = paramInt;
            if (!"10.0.0.200".equals(str)) {}
          }
          else
          {
            j = 1;
          }
        }
        k = 0;
        paramInt = k;
        if (str != null)
        {
          paramInt = k;
          if (m > 0) {
            paramInt = 1;
          }
        }
        if ((j != 0) || (paramInt == 0)) {
          break label403;
        }
        if ((!((String)localObject1).equals(BdhUtils.APN_TYPE_CMWAP)) && (!((String)localObject1).equals(BdhUtils.APN_TYPE_UNIWAP)) && (!((String)localObject1).equals(BdhUtils.APN_TYPE_3GWAP))) {
          break label366;
        }
        localObject1 = BdhUtils.getConnectionWithXOnlineHost(paramString, str, m);
      }
      label239:
      for (j = 1;; j = 0)
      {
        ((HttpURLConnection)localObject1).setConnectTimeout(30000);
        ((HttpURLConnection)localObject1).setReadTimeout(30000);
        ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
        ((HttpURLConnection)localObject1).setDoOutput(true);
        ((HttpURLConnection)localObject1).setFixedLengthStreamingMode((int)paramLong);
        ((HttpURLConnection)localObject1).addRequestProperty("Accept-Encoding", "identity");
        ((HttpURLConnection)localObject1).addRequestProperty("Connection", "close");
        localObject2 = paramHashMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          ((HttpURLConnection)localObject1).setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        paramInt = 1;
        break;
        label366:
        if (((String)localObject1).equals(BdhUtils.APN_TYPE_CTWAP))
        {
          localObject1 = BdhUtils.getConnectionWithDefaultProxy(paramString, str, m);
          break label239;
        }
        localObject1 = BdhUtils.getConnectionWithDefaultProxy(paramString, str, m);
        break label239;
        label403:
        localObject1 = (HttpURLConnection)new URL(paramString).openConnection(java.net.Proxy.NO_PROXY);
      }
      try
      {
        ((HttpURLConnection)localObject1).connect();
        paramInt = 1;
      }
      catch (Throwable localThrowable)
      {
        while (paramInt != 0) {
          if ((j != 0) && (paramInt != 0)) {
            paramInt = 0;
          } else if ((paramInt != 0) && (j == 0)) {
            paramInt = 0;
          } else {
            throw localThrowable;
          }
        }
        throw localThrowable;
      }
      i += 1;
    }
    label490:
    BdhLogUtil.LogEvent("C", "[HttpConn] Open Connection Succ.");
    return (HttpURLConnection)localObject1;
  }
  
  /* Error */
  private void handleHttpReqData(HwRequest paramHwRequest, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +8 -> 9
    //   4: aload_2
    //   5: arraylength
    //   6: ifgt +4 -> 10
    //   9: return
    //   10: aconst_null
    //   11: astore 15
    //   13: aconst_null
    //   14: astore 16
    //   16: aconst_null
    //   17: astore 12
    //   19: aconst_null
    //   20: astore 4
    //   22: aconst_null
    //   23: astore 11
    //   25: aconst_null
    //   26: astore 13
    //   28: aconst_null
    //   29: astore 14
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 157	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   36: iconst_0
    //   37: istore 20
    //   39: aload_0
    //   40: invokespecial 341	com/tencent/mobileqq/highway/conn/HttpConnection:getBdhConnURL	()Ljava/lang/String;
    //   43: astore 10
    //   45: new 278	java/util/HashMap
    //   48: dup
    //   49: invokespecial 342	java/util/HashMap:<init>	()V
    //   52: astore 17
    //   54: iconst_0
    //   55: istore 18
    //   57: aload 15
    //   59: astore 8
    //   61: aload 4
    //   63: astore 9
    //   65: aload 13
    //   67: astore 7
    //   69: aload 16
    //   71: astore 5
    //   73: aload 4
    //   75: astore 6
    //   77: aload_1
    //   78: getfield 133	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   81: ifnull +36 -> 117
    //   84: aload 15
    //   86: astore 8
    //   88: aload 4
    //   90: astore 9
    //   92: aload 13
    //   94: astore 7
    //   96: aload 16
    //   98: astore 5
    //   100: aload 4
    //   102: astore 6
    //   104: aload_1
    //   105: getfield 133	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   108: aload_0
    //   109: getfield 49	com/tencent/mobileqq/highway/conn/HttpConnection:mConnId	I
    //   112: invokeinterface 345 2 0
    //   117: aload 15
    //   119: astore 8
    //   121: aload 4
    //   123: astore 9
    //   125: aload 13
    //   127: astore 7
    //   129: aload 16
    //   131: astore 5
    //   133: aload 4
    //   135: astore 6
    //   137: aload_0
    //   138: aload_0
    //   139: aload 10
    //   141: aload 17
    //   143: aload_2
    //   144: arraylength
    //   145: i2l
    //   146: iload_3
    //   147: invokespecial 347	com/tencent/mobileqq/highway/conn/HttpConnection:getConnection	(Ljava/lang/String;Ljava/util/HashMap;JI)Ljava/net/HttpURLConnection;
    //   150: putfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   153: aload 15
    //   155: astore 8
    //   157: aload 4
    //   159: astore 9
    //   161: aload 13
    //   163: astore 7
    //   165: aload 16
    //   167: astore 5
    //   169: aload 4
    //   171: astore 6
    //   173: aload_0
    //   174: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   177: invokevirtual 353	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   180: astore 4
    //   182: iconst_0
    //   183: istore 19
    //   185: aload 15
    //   187: astore 8
    //   189: aload 4
    //   191: astore 9
    //   193: aload 13
    //   195: astore 7
    //   197: aload 16
    //   199: astore 5
    //   201: aload 4
    //   203: astore 6
    //   205: iload 19
    //   207: aload_2
    //   208: arraylength
    //   209: if_icmpge +78 -> 287
    //   212: aload 15
    //   214: astore 8
    //   216: aload 4
    //   218: astore 9
    //   220: aload 13
    //   222: astore 7
    //   224: aload 16
    //   226: astore 5
    //   228: aload 4
    //   230: astore 6
    //   232: aload 4
    //   234: aload_2
    //   235: iload 19
    //   237: sipush 10240
    //   240: aload_2
    //   241: arraylength
    //   242: iload 19
    //   244: isub
    //   245: invokestatic 359	java/lang/Math:min	(II)I
    //   248: invokevirtual 365	java/io/OutputStream:write	([BII)V
    //   251: aload 15
    //   253: astore 8
    //   255: aload 4
    //   257: astore 9
    //   259: aload 13
    //   261: astore 7
    //   263: aload 16
    //   265: astore 5
    //   267: aload 4
    //   269: astore 6
    //   271: aload 4
    //   273: invokevirtual 368	java/io/OutputStream:flush	()V
    //   276: iload 19
    //   278: sipush 10240
    //   281: iadd
    //   282: istore 19
    //   284: goto -99 -> 185
    //   287: aload 15
    //   289: astore 8
    //   291: aload 4
    //   293: astore 9
    //   295: aload 13
    //   297: astore 7
    //   299: aload 16
    //   301: astore 5
    //   303: aload 4
    //   305: astore 6
    //   307: aload_1
    //   308: getfield 133	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   311: ifnull +40 -> 351
    //   314: aload 15
    //   316: astore 8
    //   318: aload 4
    //   320: astore 9
    //   322: aload 13
    //   324: astore 7
    //   326: aload 16
    //   328: astore 5
    //   330: aload 4
    //   332: astore 6
    //   334: aload_1
    //   335: getfield 133	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   338: aload_0
    //   339: getfield 49	com/tencent/mobileqq/highway/conn/HttpConnection:mConnId	I
    //   342: aload_0
    //   343: invokevirtual 371	com/tencent/mobileqq/highway/conn/HttpConnection:getProtoType	()I
    //   346: invokeinterface 375 3 0
    //   351: aload 15
    //   353: astore 8
    //   355: aload 4
    //   357: astore 9
    //   359: aload 13
    //   361: astore 7
    //   363: aload 16
    //   365: astore 5
    //   367: aload 4
    //   369: astore 6
    //   371: ldc 90
    //   373: ldc_w 377
    //   376: invokestatic 98	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload 15
    //   381: astore 8
    //   383: aload 4
    //   385: astore 9
    //   387: aload 13
    //   389: astore 7
    //   391: aload 16
    //   393: astore 5
    //   395: aload 4
    //   397: astore 6
    //   399: aload_0
    //   400: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   403: invokevirtual 380	java/net/HttpURLConnection:getResponseCode	()I
    //   406: istore 19
    //   408: aload 15
    //   410: astore 8
    //   412: aload 4
    //   414: astore 9
    //   416: aload 13
    //   418: astore 7
    //   420: aload 16
    //   422: astore 5
    //   424: aload 4
    //   426: astore 6
    //   428: ldc 90
    //   430: new 55	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 382
    //   440: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: iload 19
    //   445: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 98	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: iload 19
    //   456: sipush 200
    //   459: if_icmpeq +11 -> 470
    //   462: iload 19
    //   464: sipush 206
    //   467: if_icmpne +223 -> 690
    //   470: aload 15
    //   472: astore 8
    //   474: aload 4
    //   476: astore 9
    //   478: aload 13
    //   480: astore 7
    //   482: aload 16
    //   484: astore 5
    //   486: aload 4
    //   488: astore 6
    //   490: aload_0
    //   491: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   494: invokevirtual 386	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   497: astore_1
    //   498: aload_1
    //   499: astore 8
    //   501: aload 4
    //   503: astore 9
    //   505: aload 13
    //   507: astore 7
    //   509: aload_1
    //   510: astore 5
    //   512: aload 4
    //   514: astore 6
    //   516: new 388	java/io/ByteArrayOutputStream
    //   519: dup
    //   520: invokespecial 389	java/io/ByteArrayOutputStream:<init>	()V
    //   523: astore_2
    //   524: sipush 10240
    //   527: newarray <illegal type>
    //   529: astore 5
    //   531: iconst_0
    //   532: istore_3
    //   533: iload 20
    //   535: istore 18
    //   537: aload_1
    //   538: aload 5
    //   540: iload_3
    //   541: aload 5
    //   543: arraylength
    //   544: iload_3
    //   545: isub
    //   546: invokevirtual 395	java/io/InputStream:read	([BII)I
    //   549: istore 20
    //   551: iload 20
    //   553: ifle +46 -> 599
    //   556: iload_3
    //   557: iload 20
    //   559: iadd
    //   560: istore 19
    //   562: iload 18
    //   564: iload 20
    //   566: iadd
    //   567: istore 20
    //   569: iload 19
    //   571: istore_3
    //   572: iload 20
    //   574: istore 18
    //   576: iload 19
    //   578: aload 5
    //   580: arraylength
    //   581: if_icmplt -44 -> 537
    //   584: aload_2
    //   585: aload 5
    //   587: invokevirtual 398	java/io/ByteArrayOutputStream:write	([B)V
    //   590: iconst_0
    //   591: istore_3
    //   592: iload 20
    //   594: istore 18
    //   596: goto -59 -> 537
    //   599: iload_3
    //   600: ifle +11 -> 611
    //   603: aload_2
    //   604: aload 5
    //   606: iconst_0
    //   607: iload_3
    //   608: invokevirtual 399	java/io/ByteArrayOutputStream:write	([BII)V
    //   611: aload_2
    //   612: invokevirtual 400	java/io/ByteArrayOutputStream:flush	()V
    //   615: aload_2
    //   616: invokevirtual 403	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   619: astore 5
    //   621: aload_0
    //   622: getfield 109	com/tencent/mobileqq/highway/conn/HttpConnection:mDataCodec	Lcom/tencent/mobileqq/highway/codec/TcpProtocolDataCodec;
    //   625: aload 5
    //   627: invokevirtual 407	com/tencent/mobileqq/highway/codec/TcpProtocolDataCodec:decodeS2CData	([B)Z
    //   630: pop
    //   631: ldc 90
    //   633: ldc_w 409
    //   636: invokestatic 98	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload_2
    //   640: invokevirtual 411	java/io/ByteArrayOutputStream:close	()V
    //   643: aload_2
    //   644: ifnull +7 -> 651
    //   647: aload_2
    //   648: invokevirtual 411	java/io/ByteArrayOutputStream:close	()V
    //   651: aload_1
    //   652: ifnull +7 -> 659
    //   655: aload_1
    //   656: invokevirtual 412	java/io/InputStream:close	()V
    //   659: aload 4
    //   661: ifnull +8 -> 669
    //   664: aload 4
    //   666: invokevirtual 413	java/io/OutputStream:close	()V
    //   669: aload_0
    //   670: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   673: ifnull -664 -> 9
    //   676: aload_0
    //   677: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   680: invokevirtual 416	java/net/HttpURLConnection:disconnect	()V
    //   683: return
    //   684: astore_1
    //   685: aload_1
    //   686: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   689: return
    //   690: iload 19
    //   692: sipush 302
    //   695: if_icmpeq +11 -> 706
    //   698: iload 19
    //   700: sipush 301
    //   703: if_icmpne +331 -> 1034
    //   706: iload 18
    //   708: iconst_5
    //   709: if_icmpge +155 -> 864
    //   712: aload 15
    //   714: astore 8
    //   716: aload 4
    //   718: astore 9
    //   720: aload 13
    //   722: astore 7
    //   724: aload 16
    //   726: astore 5
    //   728: aload 4
    //   730: astore 6
    //   732: aload_0
    //   733: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   736: ldc_w 421
    //   739: invokevirtual 424	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   742: astore 10
    //   744: aload 10
    //   746: ifnull +118 -> 864
    //   749: aload 15
    //   751: astore 8
    //   753: aload 4
    //   755: astore 9
    //   757: aload 13
    //   759: astore 7
    //   761: aload 16
    //   763: astore 5
    //   765: aload 4
    //   767: astore 6
    //   769: aload 10
    //   771: invokevirtual 427	java/lang/String:length	()I
    //   774: istore 19
    //   776: iload 19
    //   778: ifle +86 -> 864
    //   781: aload 4
    //   783: ifnull +20 -> 803
    //   786: aload 13
    //   788: astore 7
    //   790: aload 16
    //   792: astore 5
    //   794: aload 4
    //   796: astore 6
    //   798: aload 4
    //   800: invokevirtual 413	java/io/OutputStream:close	()V
    //   803: aload 13
    //   805: astore 7
    //   807: aload 16
    //   809: astore 5
    //   811: aload 4
    //   813: astore 6
    //   815: aload_0
    //   816: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   819: invokevirtual 416	java/net/HttpURLConnection:disconnect	()V
    //   822: aload 15
    //   824: astore 8
    //   826: aload 4
    //   828: astore 9
    //   830: aload 13
    //   832: astore 7
    //   834: aload 16
    //   836: astore 5
    //   838: aload 4
    //   840: astore 6
    //   842: aload 17
    //   844: ldc_w 429
    //   847: aload_0
    //   848: invokespecial 341	com/tencent/mobileqq/highway/conn/HttpConnection:getBdhConnURL	()Ljava/lang/String;
    //   851: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   854: pop
    //   855: iload 18
    //   857: iconst_1
    //   858: iadd
    //   859: istore 18
    //   861: goto -804 -> 57
    //   864: aload 15
    //   866: astore 8
    //   868: aload 4
    //   870: astore 9
    //   872: aload 13
    //   874: astore 7
    //   876: aload 16
    //   878: astore 5
    //   880: aload 4
    //   882: astore 6
    //   884: aload_0
    //   885: sipush 64523
    //   888: putfield 157	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   891: aload 15
    //   893: astore 8
    //   895: aload 4
    //   897: astore 9
    //   899: aload 13
    //   901: astore 7
    //   903: aload 16
    //   905: astore 5
    //   907: aload 4
    //   909: astore 6
    //   911: aload_0
    //   912: aload_0
    //   913: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   916: invokevirtual 437	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   919: invokevirtual 116	java/lang/Object:toString	()Ljava/lang/String;
    //   922: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   925: aload 14
    //   927: astore_2
    //   928: aload 12
    //   930: astore_1
    //   931: goto -288 -> 643
    //   934: astore_2
    //   935: aload 9
    //   937: astore 4
    //   939: aload 8
    //   941: astore_1
    //   942: aload_2
    //   943: astore 8
    //   945: aload 11
    //   947: astore_2
    //   948: aload_2
    //   949: astore 7
    //   951: aload_1
    //   952: astore 5
    //   954: aload 4
    //   956: astore 6
    //   958: aload_0
    //   959: sipush 64533
    //   962: putfield 157	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   965: aload_2
    //   966: astore 7
    //   968: aload_1
    //   969: astore 5
    //   971: aload 4
    //   973: astore 6
    //   975: aload_0
    //   976: aload 8
    //   978: invokevirtual 441	java/lang/Object:getClass	()Ljava/lang/Class;
    //   981: invokevirtual 446	java/lang/Class:getName	()Ljava/lang/String;
    //   984: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   987: aload_2
    //   988: ifnull +7 -> 995
    //   991: aload_2
    //   992: invokevirtual 411	java/io/ByteArrayOutputStream:close	()V
    //   995: aload_1
    //   996: ifnull +7 -> 1003
    //   999: aload_1
    //   1000: invokevirtual 412	java/io/InputStream:close	()V
    //   1003: aload 4
    //   1005: ifnull +8 -> 1013
    //   1008: aload 4
    //   1010: invokevirtual 413	java/io/OutputStream:close	()V
    //   1013: aload_0
    //   1014: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   1017: ifnull -1008 -> 9
    //   1020: aload_0
    //   1021: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   1024: invokevirtual 416	java/net/HttpURLConnection:disconnect	()V
    //   1027: return
    //   1028: astore_1
    //   1029: aload_1
    //   1030: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   1033: return
    //   1034: aload 15
    //   1036: astore 8
    //   1038: aload 4
    //   1040: astore 9
    //   1042: aload 13
    //   1044: astore 7
    //   1046: aload 16
    //   1048: astore 5
    //   1050: aload 4
    //   1052: astore 6
    //   1054: aload_0
    //   1055: sipush 64523
    //   1058: putfield 157	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   1061: aload 15
    //   1063: astore 8
    //   1065: aload 4
    //   1067: astore 9
    //   1069: aload 13
    //   1071: astore 7
    //   1073: aload 16
    //   1075: astore 5
    //   1077: aload 4
    //   1079: astore 6
    //   1081: aload_0
    //   1082: aload_0
    //   1083: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   1086: invokevirtual 437	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   1089: invokevirtual 116	java/lang/Object:toString	()Ljava/lang/String;
    //   1092: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   1095: aload 14
    //   1097: astore_2
    //   1098: aload 12
    //   1100: astore_1
    //   1101: goto -458 -> 643
    //   1104: astore_2
    //   1105: aload 6
    //   1107: astore 4
    //   1109: aload 5
    //   1111: astore_1
    //   1112: aload 7
    //   1114: ifnull +8 -> 1122
    //   1117: aload 7
    //   1119: invokevirtual 411	java/io/ByteArrayOutputStream:close	()V
    //   1122: aload_1
    //   1123: ifnull +7 -> 1130
    //   1126: aload_1
    //   1127: invokevirtual 412	java/io/InputStream:close	()V
    //   1130: aload 4
    //   1132: ifnull +8 -> 1140
    //   1135: aload 4
    //   1137: invokevirtual 413	java/io/OutputStream:close	()V
    //   1140: aload_0
    //   1141: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   1144: ifnull +10 -> 1154
    //   1147: aload_0
    //   1148: getfield 349	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   1151: invokevirtual 416	java/net/HttpURLConnection:disconnect	()V
    //   1154: aload_2
    //   1155: athrow
    //   1156: astore_1
    //   1157: aload_1
    //   1158: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   1161: goto -7 -> 1154
    //   1164: astore_2
    //   1165: goto -514 -> 651
    //   1168: astore_1
    //   1169: goto -510 -> 659
    //   1172: astore_1
    //   1173: goto -504 -> 669
    //   1176: astore_2
    //   1177: goto -182 -> 995
    //   1180: astore_1
    //   1181: goto -178 -> 1003
    //   1184: astore_1
    //   1185: goto -172 -> 1013
    //   1188: astore 5
    //   1190: goto -68 -> 1122
    //   1193: astore_1
    //   1194: goto -64 -> 1130
    //   1197: astore_1
    //   1198: goto -58 -> 1140
    //   1201: astore 5
    //   1203: aload_2
    //   1204: astore 7
    //   1206: aload 5
    //   1208: astore_2
    //   1209: goto -97 -> 1112
    //   1212: astore 8
    //   1214: goto -266 -> 948
    //   1217: astore 5
    //   1219: goto -397 -> 822
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1222	0	this	HttpConnection
    //   0	1222	1	paramHwRequest	HwRequest
    //   0	1222	2	paramArrayOfByte	byte[]
    //   0	1222	3	paramInt	int
    //   20	1116	4	localObject1	Object
    //   71	1039	5	localObject2	Object
    //   1188	1	5	localIOException	java.io.IOException
    //   1201	6	5	localObject3	Object
    //   1217	1	5	localThrowable1	Throwable
    //   75	1031	6	localObject4	Object
    //   67	1138	7	localObject5	Object
    //   59	1005	8	localObject6	Object
    //   1212	1	8	localThrowable2	Throwable
    //   63	1005	9	localObject7	Object
    //   43	727	10	str	String
    //   23	923	11	localObject8	Object
    //   17	1082	12	localObject9	Object
    //   26	1044	13	localObject10	Object
    //   29	1067	14	localObject11	Object
    //   11	1051	15	localObject12	Object
    //   14	1060	16	localObject13	Object
    //   52	791	17	localHashMap	HashMap
    //   55	805	18	i	int
    //   183	594	19	j	int
    //   37	556	20	k	int
    // Exception table:
    //   from	to	target	type
    //   647	651	684	java/lang/Exception
    //   655	659	684	java/lang/Exception
    //   664	669	684	java/lang/Exception
    //   669	683	684	java/lang/Exception
    //   77	84	934	java/lang/Throwable
    //   104	117	934	java/lang/Throwable
    //   137	153	934	java/lang/Throwable
    //   173	182	934	java/lang/Throwable
    //   205	212	934	java/lang/Throwable
    //   232	251	934	java/lang/Throwable
    //   271	276	934	java/lang/Throwable
    //   307	314	934	java/lang/Throwable
    //   334	351	934	java/lang/Throwable
    //   371	379	934	java/lang/Throwable
    //   399	408	934	java/lang/Throwable
    //   428	454	934	java/lang/Throwable
    //   490	498	934	java/lang/Throwable
    //   516	524	934	java/lang/Throwable
    //   732	744	934	java/lang/Throwable
    //   769	776	934	java/lang/Throwable
    //   842	855	934	java/lang/Throwable
    //   884	891	934	java/lang/Throwable
    //   911	925	934	java/lang/Throwable
    //   1054	1061	934	java/lang/Throwable
    //   1081	1095	934	java/lang/Throwable
    //   991	995	1028	java/lang/Exception
    //   999	1003	1028	java/lang/Exception
    //   1008	1013	1028	java/lang/Exception
    //   1013	1027	1028	java/lang/Exception
    //   77	84	1104	finally
    //   104	117	1104	finally
    //   137	153	1104	finally
    //   173	182	1104	finally
    //   205	212	1104	finally
    //   232	251	1104	finally
    //   271	276	1104	finally
    //   307	314	1104	finally
    //   334	351	1104	finally
    //   371	379	1104	finally
    //   399	408	1104	finally
    //   428	454	1104	finally
    //   490	498	1104	finally
    //   516	524	1104	finally
    //   732	744	1104	finally
    //   769	776	1104	finally
    //   798	803	1104	finally
    //   815	822	1104	finally
    //   842	855	1104	finally
    //   884	891	1104	finally
    //   911	925	1104	finally
    //   958	965	1104	finally
    //   975	987	1104	finally
    //   1054	1061	1104	finally
    //   1081	1095	1104	finally
    //   1117	1122	1156	java/lang/Exception
    //   1126	1130	1156	java/lang/Exception
    //   1135	1140	1156	java/lang/Exception
    //   1140	1154	1156	java/lang/Exception
    //   647	651	1164	java/io/IOException
    //   655	659	1168	java/io/IOException
    //   664	669	1172	java/io/IOException
    //   991	995	1176	java/io/IOException
    //   999	1003	1180	java/io/IOException
    //   1008	1013	1184	java/io/IOException
    //   1117	1122	1188	java/io/IOException
    //   1126	1130	1193	java/io/IOException
    //   1135	1140	1197	java/io/IOException
    //   524	531	1201	finally
    //   537	551	1201	finally
    //   576	590	1201	finally
    //   603	611	1201	finally
    //   611	643	1201	finally
    //   524	531	1212	java/lang/Throwable
    //   537	551	1212	java/lang/Throwable
    //   576	590	1212	java/lang/Throwable
    //   603	611	1212	java/lang/Throwable
    //   611	643	1212	java/lang/Throwable
    //   798	803	1217	java/lang/Throwable
    //   815	822	1217	java/lang/Throwable
  }
  
  private void stopConnThread()
  {
    Handler localHandler = this.mHandler;
    if ((localHandler != null) && (this.mExecutor != null) && (this.mExecutor.isAlive())) {
      localHandler.post(new Runnable()
      {
        public void run()
        {
          try
          {
            HttpConnection.this.mExecutor.quit();
            HttpConnection.access$102(HttpConnection.this, null);
            HttpConnection.access$202(HttpConnection.this, null);
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
  }
  
  public void connect()
  {
    this.mExecutor.start();
    this.mHandler = new Handler(this.mExecutor.getLooper());
    if (this.mConnListener != null)
    {
      QLog.d("BDH_LOG", 1, "C. On Http ConnectionConnected : ID:" + this.mConnId);
      this.mConnListener.onConnect(true, this.mConnId, this, this.mCurrentPoint, 0, new ConnReportInfo());
    }
    wakeupChannel();
  }
  
  public void disConnect()
  {
    if (this.mConnection != null) {}
    try
    {
      this.mConnection.disconnect();
      if (this.mConnListener != null)
      {
        QLog.d("BDH_LOG", 1, "C. On Http DisConnected : ID:" + this.mConnId);
        this.mConnListener.onDisConnect(this.mConnId, this);
      }
      stopConnThread();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public int getConnId()
  {
    return this.mConnId;
  }
  
  public EndPoint getEndPoint()
  {
    return this.mCurrentPoint;
  }
  
  public int getProtoType()
  {
    return 2;
  }
  
  public boolean isWritable()
  {
    return true;
  }
  
  public void onDecodeInvalidData(int paramInt)
  {
    this.iErrCode = 64523;
    this.mStrErrInfo = ("DecodeError[" + paramInt + "]");
    if (this.mConnListener != null) {
      this.mConnListener.onRecvInvalidData(this.mCurrentPoint);
    }
    disConnect();
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    if (this.mConnListener != null) {
      this.mConnmanager.onDecodeSucessfully(paramList);
    }
  }
  
  public void onEncodePkgError(HwRequest paramHwRequest, int paramInt) {}
  
  public void setConnectListener(IConnectionListener paramIConnectionListener)
  {
    this.mConnListener = paramIConnectionListener;
  }
  
  public void setUrgentFlag(boolean paramBoolean) {}
  
  public void wakeupChannel()
  {
    Handler localHandler = this.mHandler;
    if ((localHandler != null) && (this.mExecutor != null) && (this.mExecutor.isAlive())) {
      localHandler.post(new Runnable()
      {
        public void run()
        {
          try
          {
            HttpConnection.this.doSendRequest();
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\conn\HttpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */