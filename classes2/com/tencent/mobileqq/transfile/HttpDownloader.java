package com.tencent.mobileqq.transfile;

import android.view.animation.AnimationUtils;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.HttpContext;
import vbc;

public class HttpDownloader
  extends AbsDownloader
{
  private static final int jdField_a_of_type_Int = 4096;
  private static HttpDownloader.QQHttpClient jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader$QQHttpClient = a();
  public static final String d = "mobileqq_report_flag";
  public static final String e = "mobileqq_direct_url";
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HttpDownloader() {}
  
  public HttpDownloader(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private static HttpDownloader.QQHttpClient a()
  {
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
      localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      ((SchemeRegistry)localObject).register(new Scheme("https", localSSLSocketFactory, 443));
      localObject = new HttpDownloader.QQHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), (SchemeRegistry)localObject), null);
      ((HttpDownloader.QQHttpClient)localObject).setRedirectHandler(new vbc());
      return (HttpDownloader.QQHttpClient)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawable_", 2, "createHttpClient():Can't support https on this devices.", localException);
        }
      }
    }
  }
  
  private void a(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler)
  {
    paramInputStream = new BufferedInputStream(paramInputStream, 4096);
    try
    {
      byte[] arrayOfByte = new byte['က'];
      long l1 = 0L;
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        long l2 = l1 + i;
        l1 = l2;
        if (AnimationUtils.currentAnimationTimeMillis() - 0L > 100L)
        {
          paramURLDrawableHandler.publishProgress((int)((float)l2 / (float)paramLong * 9500.0F));
          l1 = l2;
        }
      }
    }
    finally
    {
      paramInputStream.close();
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, HttpContext paramHttpContext, boolean paramBoolean2, int paramInt, IOException paramIOException)
  {
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localObject2;
    if (paramHttpContext != null)
    {
      paramHttpContext = paramHttpContext.getAttribute("mobileqq_direct_url");
      localObject1 = localObject2;
      if (paramHttpContext != null)
      {
        localObject1 = localObject2;
        if ((paramHttpContext instanceof List))
        {
          paramHttpContext = (List)paramHttpContext;
          localObject1 = localObject2;
          if (paramHttpContext.size() > 0) {
            localObject1 = (String)paramHttpContext.get(0);
          }
        }
      }
    }
    int k;
    int i;
    int j;
    if (!paramBoolean1)
    {
      k = paramInt * 10000;
      if (paramInt == 200) {
        if (!SystemUtil.a())
        {
          i = 1;
          j = 1;
          paramInt = i;
          paramHttpContext = str;
          if (paramIOException != null)
          {
            str = paramIOException.getMessage();
            paramInt = i;
            paramHttpContext = str;
            if (j == 0)
            {
              if (!(paramIOException instanceof SocketException)) {
                break label316;
              }
              if (!(paramIOException instanceof ConnectException)) {
                break label261;
              }
              paramInt = i + 10;
              paramHttpContext = str;
            }
          }
          label161:
          if (k < 0) {
            break label646;
          }
          paramInt += k;
        }
      }
    }
    for (;;)
    {
      paramIOException = new HashMap();
      paramIOException.put("param_Url", paramString);
      paramIOException.put("param_FailCode", String.valueOf(paramInt));
      paramIOException.put("param_ErrDesc", paramHttpContext);
      paramIOException.put("param_FirstDirect", localObject1);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "StructMsgPicDown", paramBoolean1, 0L, 0L, paramIOException, null);
      return;
      if (SystemUtil.a() < 8L)
      {
        i = 2;
        j = 1;
        break;
        label261:
        if ((paramIOException instanceof NoRouteToHostException))
        {
          paramInt = i + 11;
          paramHttpContext = str;
          break label161;
        }
        if ((paramIOException instanceof PortUnreachableException))
        {
          paramInt = i + 12;
          paramHttpContext = str;
          break label161;
        }
        paramInt = i + 13;
        paramHttpContext = str;
        break label161;
        label316:
        if ((paramIOException instanceof InterruptedIOException))
        {
          if ((paramIOException instanceof SocketTimeoutException))
          {
            if (paramBoolean2)
            {
              paramInt = i + 100;
              paramHttpContext = str;
              break label161;
            }
            paramInt = i + 101;
            paramHttpContext = str;
            break label161;
          }
          paramInt = i + 102;
          paramHttpContext = str;
          break label161;
        }
        if ((paramIOException instanceof IOException))
        {
          if ((paramIOException instanceof MalformedURLException))
          {
            paramInt = i + 200;
            paramHttpContext = str;
            break label161;
          }
          if ((paramIOException instanceof UnknownHostException))
          {
            paramInt = i + 201;
            paramHttpContext = str;
            break label161;
          }
          if ((paramIOException instanceof EOFException))
          {
            paramInt = i + 202;
            paramHttpContext = str;
            break label161;
          }
          if (str.contains("unreachable)"))
          {
            paramInt = i + 300;
            paramHttpContext = str;
            break label161;
          }
          if (str.contains("Connection refused"))
          {
            paramInt = i + 301;
            paramHttpContext = str;
            break label161;
          }
          if (str.contains("No route to host"))
          {
            if (str.contains("SocketException"))
            {
              paramInt = i + 302;
              paramHttpContext = str;
              break label161;
            }
            paramInt = i + 303;
            paramHttpContext = str;
            break label161;
          }
          if (str.contains("unexpected end of stream"))
          {
            paramInt = i + 304;
            paramHttpContext = str;
            break label161;
          }
          if (str.contains("Connection timed out"))
          {
            paramInt = i + 305;
            paramHttpContext = str;
            break label161;
          }
          if (str.contains("unaccpet content type"))
          {
            paramInt = i + 306;
            paramHttpContext = str;
            break label161;
          }
          paramInt = i + 307;
          paramHttpContext = str;
          break label161;
        }
        paramInt = i + 400;
        paramHttpContext = str;
        break label161;
        label646:
        paramInt = k - paramInt;
        continue;
      }
      i = 0;
      j = 0;
      break;
      paramHttpContext = null;
      paramInt = 0;
    }
  }
  
  /* Error */
  public java.io.File a(OutputStream paramOutputStream, com.tencent.image.DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 253	com/tencent/image/DownloadParams:needCheckNetType	Z
    //   4: ifeq +14 -> 18
    //   7: invokestatic 199	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokestatic 258	com/tencent/mobileqq/transfile/URLDrawableHelper:a	(Landroid/content/Context;)Z
    //   13: ifeq +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: iconst_0
    //   19: istore 14
    //   21: aload_2
    //   22: getfield 262	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 267	java/net/URL:getHost	()Ljava/lang/String;
    //   32: pop
    //   33: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +34 -> 70
    //   39: getstatic 270	com/tencent/mobileqq/transfile/HttpDownloader:b_	Ljava/lang/String;
    //   42: iconst_2
    //   43: new 272	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 275
    //   53: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 4
    //   58: invokevirtual 282	java/net/URL:toString	()Ljava/lang/String;
    //   61: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: getfield 35	com/tencent/mobileqq/transfile/HttpDownloader:jdField_a_of_type_Boolean	Z
    //   74: ifeq +773 -> 847
    //   77: ldc 44
    //   79: aload 4
    //   81: invokevirtual 289	java/net/URL:getProtocol	()Ljava/lang/String;
    //   84: invokevirtual 293	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +760 -> 847
    //   90: aload 4
    //   92: invokevirtual 267	java/net/URL:getHost	()Ljava/lang/String;
    //   95: astore 5
    //   97: aload 5
    //   99: invokestatic 299	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   102: ifne +745 -> 847
    //   105: invokestatic 304	com/tencent/mobileqq/transfile/dns/InnerDns:a	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   108: aload 5
    //   110: sipush 1010
    //   113: invokevirtual 307	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   116: astore 6
    //   118: aload 5
    //   120: aload 6
    //   122: invokevirtual 293	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +722 -> 847
    //   128: aload 6
    //   130: invokestatic 299	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   133: ifne +714 -> 847
    //   136: aload 4
    //   138: invokevirtual 282	java/net/URL:toString	()Ljava/lang/String;
    //   141: aload 6
    //   143: invokestatic 310	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: astore 5
    //   148: new 264	java/net/URL
    //   151: dup
    //   152: aload 5
    //   154: invokespecial 313	java/net/URL:<init>	(Ljava/lang/String;)V
    //   157: astore 4
    //   159: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +691 -> 853
    //   165: getstatic 270	com/tencent/mobileqq/transfile/HttpDownloader:b_	Ljava/lang/String;
    //   168: iconst_2
    //   169: new 272	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 315
    //   179: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 5
    //   184: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: goto +660 -> 853
    //   196: aload 4
    //   198: invokevirtual 282	java/net/URL:toString	()Ljava/lang/String;
    //   201: astore 8
    //   203: iconst_m1
    //   204: istore 11
    //   206: new 317	org/apache/http/client/methods/HttpGet
    //   209: dup
    //   210: aload 4
    //   212: invokevirtual 321	java/net/URL:toURI	()Ljava/net/URI;
    //   215: invokespecial 324	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   218: astore 6
    //   220: aload_2
    //   221: getfield 328	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   224: ifnull +151 -> 375
    //   227: getstatic 28	com/tencent/mobileqq/transfile/HttpDownloader:jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader$QQHttpClient	Lcom/tencent/mobileqq/transfile/HttpDownloader$QQHttpClient;
    //   230: invokevirtual 332	com/tencent/mobileqq/transfile/HttpDownloader$QQHttpClient:getCookieSpecs	()Lorg/apache/http/cookie/CookieSpecRegistry;
    //   233: ldc_w 334
    //   236: invokevirtual 340	org/apache/http/cookie/CookieSpecRegistry:getCookieSpec	(Ljava/lang/String;)Lorg/apache/http/cookie/CookieSpec;
    //   239: aload_2
    //   240: getfield 328	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   243: invokeinterface 346 1 0
    //   248: invokeinterface 352 2 0
    //   253: invokeinterface 356 1 0
    //   258: astore 5
    //   260: aload 5
    //   262: invokeinterface 361 1 0
    //   267: ifeq +108 -> 375
    //   270: aload 6
    //   272: aload 5
    //   274: invokeinterface 365 1 0
    //   279: checkcast 367	org/apache/http/Header
    //   282: invokevirtual 371	org/apache/http/client/methods/HttpGet:addHeader	(Lorg/apache/http/Header;)V
    //   285: goto -25 -> 260
    //   288: astore_1
    //   289: aload_0
    //   290: aconst_null
    //   291: aload_1
    //   292: invokevirtual 372	java/net/URISyntaxException:toString	()Ljava/lang/String;
    //   295: aload_3
    //   296: invokevirtual 375	com/tencent/mobileqq/transfile/HttpDownloader:a	(Lorg/apache/http/HttpResponse;Ljava/lang/String;Lcom/tencent/image/URLDrawableHandler;)V
    //   299: new 377	java/lang/IllegalArgumentException
    //   302: dup
    //   303: new 272	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 379
    //   313: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_2
    //   317: getfield 262	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   320: invokevirtual 282	java/net/URL:toString	()Ljava/lang/String;
    //   323: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokespecial 380	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   332: athrow
    //   333: astore 5
    //   335: new 317	org/apache/http/client/methods/HttpGet
    //   338: dup
    //   339: new 382	java/net/URI
    //   342: dup
    //   343: aload 4
    //   345: invokevirtual 289	java/net/URL:getProtocol	()Ljava/lang/String;
    //   348: aload 4
    //   350: invokevirtual 267	java/net/URL:getHost	()Ljava/lang/String;
    //   353: aload 4
    //   355: invokevirtual 385	java/net/URL:getPath	()Ljava/lang/String;
    //   358: aload 4
    //   360: invokevirtual 388	java/net/URL:getQuery	()Ljava/lang/String;
    //   363: aconst_null
    //   364: invokespecial 391	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   367: invokespecial 324	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   370: astore 6
    //   372: goto -152 -> 220
    //   375: aload_2
    //   376: getfield 395	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   379: ifnull +51 -> 430
    //   382: aload_2
    //   383: getfield 395	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   386: arraylength
    //   387: ifle +43 -> 430
    //   390: aload_2
    //   391: getfield 395	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   394: astore 5
    //   396: aload 5
    //   398: arraylength
    //   399: istore 12
    //   401: iconst_0
    //   402: istore 9
    //   404: iload 9
    //   406: iload 12
    //   408: if_icmpge +22 -> 430
    //   411: aload 6
    //   413: aload 5
    //   415: iload 9
    //   417: aaload
    //   418: invokevirtual 371	org/apache/http/client/methods/HttpGet:addHeader	(Lorg/apache/http/Header;)V
    //   421: iload 9
    //   423: iconst_1
    //   424: iadd
    //   425: istore 9
    //   427: goto -23 -> 404
    //   430: iload 10
    //   432: ifeq +18 -> 450
    //   435: aload 6
    //   437: ldc_w 397
    //   440: aload_2
    //   441: getfield 262	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   444: invokevirtual 267	java/net/URL:getHost	()Ljava/lang/String;
    //   447: invokevirtual 400	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload_3
    //   451: invokeinterface 403 1 0
    //   456: getstatic 28	com/tencent/mobileqq/transfile/HttpDownloader:jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader$QQHttpClient	Lcom/tencent/mobileqq/transfile/HttpDownloader$QQHttpClient;
    //   459: invokevirtual 407	com/tencent/mobileqq/transfile/HttpDownloader$QQHttpClient:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   462: astore 5
    //   464: iload 11
    //   466: istore 9
    //   468: iload 14
    //   470: istore 13
    //   472: aload 5
    //   474: ldc 12
    //   476: aload_2
    //   477: getfield 410	com/tencent/image/DownloadParams:reportFlag	I
    //   480: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   483: invokeinterface 419 3 0
    //   488: iload 11
    //   490: istore 9
    //   492: iload 14
    //   494: istore 13
    //   496: getstatic 28	com/tencent/mobileqq/transfile/HttpDownloader:jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader$QQHttpClient	Lcom/tencent/mobileqq/transfile/HttpDownloader$QQHttpClient;
    //   499: aload 6
    //   501: aload 5
    //   503: invokevirtual 423	com/tencent/mobileqq/transfile/HttpDownloader$QQHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   506: astore 7
    //   508: iconst_1
    //   509: istore 14
    //   511: iload 11
    //   513: istore 9
    //   515: iload 14
    //   517: istore 13
    //   519: aload 7
    //   521: invokeinterface 429 1 0
    //   526: invokeinterface 434 1 0
    //   531: istore 11
    //   533: iload 11
    //   535: sipush 200
    //   538: if_icmpeq +167 -> 705
    //   541: iload 10
    //   543: ifeq +32 -> 575
    //   546: iload 11
    //   548: istore 9
    //   550: iload 14
    //   552: istore 13
    //   554: invokestatic 304	com/tencent/mobileqq/transfile/dns/InnerDns:a	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   557: aload_2
    //   558: getfield 262	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   561: invokevirtual 267	java/net/URL:getHost	()Ljava/lang/String;
    //   564: aload 4
    //   566: invokevirtual 267	java/net/URL:getHost	()Ljava/lang/String;
    //   569: sipush 1010
    //   572: invokevirtual 437	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   575: iload 11
    //   577: istore 9
    //   579: iload 14
    //   581: istore 13
    //   583: aload_3
    //   584: iload 11
    //   586: invokeinterface 440 2 0
    //   591: iload 11
    //   593: istore 9
    //   595: iload 14
    //   597: istore 13
    //   599: new 166	java/io/IOException
    //   602: dup
    //   603: new 272	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   610: aload_2
    //   611: getfield 262	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   614: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   617: ldc_w 445
    //   620: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: iload 11
    //   625: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: ldc_w 450
    //   631: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 7
    //   636: invokeinterface 429 1 0
    //   641: invokeinterface 453 1 0
    //   646: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokespecial 454	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   655: athrow
    //   656: astore 7
    //   658: aload 5
    //   660: astore 4
    //   662: aconst_null
    //   663: astore_1
    //   664: aload 7
    //   666: astore 5
    //   668: aload_1
    //   669: ifnonnull +25 -> 694
    //   672: aload_2
    //   673: getfield 410	com/tencent/image/DownloadParams:reportFlag	I
    //   676: ifle +18 -> 694
    //   679: aload_0
    //   680: iconst_0
    //   681: aload 8
    //   683: aload 4
    //   685: iload 13
    //   687: iload 9
    //   689: aload 5
    //   691: invokespecial 456	com/tencent/mobileqq/transfile/HttpDownloader:a	(ZLjava/lang/String;Lorg/apache/http/protocol/HttpContext;ZILjava/io/IOException;)V
    //   694: aload 5
    //   696: athrow
    //   697: astore_1
    //   698: aload 6
    //   700: invokevirtual 459	org/apache/http/client/methods/HttpGet:abort	()V
    //   703: aload_1
    //   704: athrow
    //   705: iload 11
    //   707: istore 9
    //   709: iload 14
    //   711: istore 13
    //   713: aload_0
    //   714: aload 7
    //   716: aconst_null
    //   717: aload_3
    //   718: invokevirtual 375	com/tencent/mobileqq/transfile/HttpDownloader:a	(Lorg/apache/http/HttpResponse;Ljava/lang/String;Lcom/tencent/image/URLDrawableHandler;)V
    //   721: iload 11
    //   723: istore 9
    //   725: iload 14
    //   727: istore 13
    //   729: aload 7
    //   731: invokeinterface 463 1 0
    //   736: astore 4
    //   738: iload 11
    //   740: istore 9
    //   742: iload 14
    //   744: istore 13
    //   746: aload_0
    //   747: aload 4
    //   749: invokeinterface 469 1 0
    //   754: aload 4
    //   756: invokeinterface 472 1 0
    //   761: aload_1
    //   762: aload_3
    //   763: invokespecial 474	com/tencent/mobileqq/transfile/HttpDownloader:a	(Ljava/io/InputStream;JLjava/io/OutputStream;Lcom/tencent/image/URLDrawableHandler;)V
    //   766: aload_2
    //   767: getfield 410	com/tencent/image/DownloadParams:reportFlag	I
    //   770: ifle +16 -> 786
    //   773: aload_0
    //   774: iconst_1
    //   775: aload 8
    //   777: aload 5
    //   779: iconst_1
    //   780: iload 11
    //   782: aconst_null
    //   783: invokespecial 456	com/tencent/mobileqq/transfile/HttpDownloader:a	(ZLjava/lang/String;Lorg/apache/http/protocol/HttpContext;ZILjava/io/IOException;)V
    //   786: aload_3
    //   787: aload 4
    //   789: invokeinterface 472 1 0
    //   794: invokeinterface 478 3 0
    //   799: aload 6
    //   801: invokevirtual 459	org/apache/http/client/methods/HttpGet:abort	()V
    //   804: aconst_null
    //   805: areturn
    //   806: astore 5
    //   808: iconst_m1
    //   809: istore 9
    //   811: iconst_0
    //   812: istore 13
    //   814: aconst_null
    //   815: astore 4
    //   817: aconst_null
    //   818: astore_1
    //   819: goto -151 -> 668
    //   822: astore 7
    //   824: iload 11
    //   826: istore 9
    //   828: iconst_1
    //   829: istore 13
    //   831: aload 5
    //   833: astore 4
    //   835: iconst_1
    //   836: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   839: astore_1
    //   840: aload 7
    //   842: astore 5
    //   844: goto -176 -> 668
    //   847: iconst_0
    //   848: istore 10
    //   850: goto -654 -> 196
    //   853: iconst_1
    //   854: istore 10
    //   856: goto -660 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	859	0	this	HttpDownloader
    //   0	859	1	paramOutputStream	OutputStream
    //   0	859	2	paramDownloadParams	com.tencent.image.DownloadParams
    //   0	859	3	paramURLDrawableHandler	URLDrawableHandler
    //   25	809	4	localObject1	Object
    //   95	178	5	localObject2	Object
    //   333	1	5	localURISyntaxException	java.net.URISyntaxException
    //   394	384	5	localObject3	Object
    //   806	26	5	localIOException1	IOException
    //   842	1	5	localObject4	Object
    //   116	684	6	localObject5	Object
    //   506	129	7	localHttpResponse	HttpResponse
    //   656	74	7	localIOException2	IOException
    //   822	19	7	localIOException3	IOException
    //   201	575	8	str	String
    //   402	425	9	i	int
    //   430	425	10	j	int
    //   204	621	11	k	int
    //   399	10	12	m	int
    //   470	360	13	bool1	boolean
    //   19	724	14	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   21	70	288	java/net/URISyntaxException
    //   70	193	288	java/net/URISyntaxException
    //   196	203	288	java/net/URISyntaxException
    //   220	260	288	java/net/URISyntaxException
    //   260	285	288	java/net/URISyntaxException
    //   335	372	288	java/net/URISyntaxException
    //   375	401	288	java/net/URISyntaxException
    //   411	421	288	java/net/URISyntaxException
    //   435	450	288	java/net/URISyntaxException
    //   698	705	288	java/net/URISyntaxException
    //   799	804	288	java/net/URISyntaxException
    //   206	220	333	java/net/URISyntaxException
    //   472	488	656	java/io/IOException
    //   496	508	656	java/io/IOException
    //   519	533	656	java/io/IOException
    //   554	575	656	java/io/IOException
    //   583	591	656	java/io/IOException
    //   599	656	656	java/io/IOException
    //   713	721	656	java/io/IOException
    //   729	738	656	java/io/IOException
    //   746	766	656	java/io/IOException
    //   450	464	697	finally
    //   472	488	697	finally
    //   496	508	697	finally
    //   519	533	697	finally
    //   554	575	697	finally
    //   583	591	697	finally
    //   599	656	697	finally
    //   672	694	697	finally
    //   694	697	697	finally
    //   713	721	697	finally
    //   729	738	697	finally
    //   746	766	697	finally
    //   766	786	697	finally
    //   786	799	697	finally
    //   450	464	806	java/io/IOException
    //   766	786	822	java/io/IOException
    //   786	799	822	java/io/IOException
  }
  
  protected void a(HttpResponse paramHttpResponse, String paramString, URLDrawableHandler paramURLDrawableHandler) {}
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\HttpDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */