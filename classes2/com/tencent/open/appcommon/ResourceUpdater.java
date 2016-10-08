package com.tencent.open.appcommon;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ResourceUpdater
{
  protected static final int a = 0;
  public static final String a = ResourceUpdater.class.getName();
  protected static final int b = 1;
  protected static String b = "http://appsupport.qq.com/cgi-bin/appstage/check_update";
  protected static final int c = 2;
  protected static final String c = "fusion_res_inc_update_qq_";
  protected static final int d = 3;
  protected static final String d = "fusion_res_full_update_qq_";
  public static String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static InputStream a(HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramHttpResponse.getEntity();
    try
    {
      if (paramHttpResponse.containsHeader("Content-Length"))
      {
        long l = Long.parseLong(paramHttpResponse.getFirstHeader("Content-Length").getValue());
        LogUtility.c(a, "readHttpResponse content-Length = " + l);
      }
      localObject1 = ((HttpEntity)localObject1).getContent();
      Header localHeader = paramHttpResponse.getFirstHeader("Content-Encoding");
      if ((localHeader != null) && (localHeader.getValue().toLowerCase().indexOf("gzip") > -1))
      {
        LogUtility.b(a, "readHttpResponse -> GZIPInputStream");
        return new GZIPInputStream((InputStream)localObject1);
      }
      LogUtility.b(a, "readHttpResponse -> InputStream");
      return (InputStream)localObject1;
    }
    catch (Exception localException)
    {
      LogUtility.e(a, "readHttpResponse error : " + localException.toString());
      paramHttpResponse = paramHttpResponse.getAllHeaders();
      int j = paramHttpResponse.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramHttpResponse[i];
        LogUtility.e(a, "header >>> " + ((Header)localObject2).getName() + ": " + ((Header)localObject2).getValue());
        i += 1;
      }
    }
    return null;
  }
  
  protected static HttpResponse a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, Integer.valueOf(1));
  }
  
  protected static HttpResponse a(String paramString, Map paramMap, int paramInt, Integer paramInteger)
  {
    Object localObject1 = CommonDataAdapter.a().a();
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    label188:
    label364:
    label499:
    do
    {
      do
      {
        return paramString;
        localObject2 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
        if (localObject2 != null)
        {
          localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
          if ((localObject2 == null) || (!((NetworkInfo)localObject2).isAvailable())) {
            throw new HttpBaseUtil.NetworkUnavailableException("network unavailable");
          }
        }
        localObject2 = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(((HttpClient)localObject2).getParams(), 60000);
        HttpConnectionParams.setSoTimeout(((HttpClient)localObject2).getParams(), paramInt * 1000);
        Object localObject3;
        int i;
        if (APNUtil.a((Context)localObject1))
        {
          localObject3 = APNUtil.c((Context)localObject1);
          i = APNUtil.a((Context)localObject1);
          if (localObject3 != null)
          {
            localObject1 = new HttpHost((String)localObject3, i);
            ((HttpClient)localObject2).getParams().setParameter("http.route.default-proxy", localObject1);
          }
        }
        if (paramString.indexOf("?") == -1)
        {
          localObject1 = paramString + "?";
          paramString = (String)localObject1 + "sid=sid";
          if (paramMap != null) {
            break label364;
          }
          LogUtility.c(a, "httpRequest url " + paramString);
          paramString = new HttpGet(paramString);
          paramString.addHeader("Accept-Encoding", "gzip");
        }
        for (;;)
        {
          if (paramString != null) {
            paramString.setHeader("Cookie", HttpBaseUtil.b());
          }
          localObject1 = ((HttpClient)localObject2).execute(paramString);
          HttpBaseUtil.a((HttpResponse)localObject1);
          i = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
          if (302 != i)
          {
            paramString = (String)localObject1;
            if (301 != i) {
              break;
            }
          }
          if (paramInteger.intValue() <= 5) {
            break label499;
          }
          return null;
          localObject1 = paramString;
          if (paramString.endsWith("&")) {
            break label188;
          }
          localObject1 = paramString + "&";
          break label188;
          paramString = new HttpPost(paramString);
          paramString.addHeader("Accept-Encoding", "gzip");
          localObject1 = new ArrayList();
          localObject3 = paramMap.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            ((List)localObject1).add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
          }
          ((HttpPost)paramString).setEntity(new UrlEncodedFormEntity((List)localObject1, "UTF-8"));
          paramString.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        }
        localObject2 = ((HttpResponse)localObject1).getFirstHeader("Location");
        paramString = (String)localObject1;
      } while (localObject2 == null);
      paramString = (String)localObject1;
    } while (((Header)localObject2).getValue() == null);
    return a(((Header)localObject2).getValue(), paramMap, paramInt, Integer.valueOf(paramInteger.intValue() + 1));
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   6: ldc_w 343
    //   9: invokestatic 116	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: invokestatic 348	com/tencent/open/appcommon/Common:q	()Ljava/lang/String;
    //   15: astore_3
    //   16: invokestatic 351	com/tencent/open/appcommon/Common:r	()Ljava/lang/String;
    //   19: astore 4
    //   21: invokestatic 354	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   24: invokestatic 359	com/tencent/open/base/MD5Utils:c	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_2
    //   28: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   31: invokestatic 364	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_1
    //   35: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   38: new 75	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 366
    //   48: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_3
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 368
    //   58: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload 4
    //   63: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 370
    //   69: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokestatic 354	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   75: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 372
    //   81: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_2
    //   85: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 374
    //   91: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 116	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: new 376	java/io/File
    //   107: dup
    //   108: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   111: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 380	java/io/File:exists	()Z
    //   117: ifeq +632 -> 749
    //   120: aload 4
    //   122: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +513 -> 638
    //   128: aload_1
    //   129: astore_0
    //   130: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   133: new 75	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 388
    //   143: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokestatic 354	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   149: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc_w 390
    //   155: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 4
    //   160: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 374
    //   166: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_1
    //   170: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 392
    //   176: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_3
    //   180: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 394
    //   186: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 396
    //   196: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_2
    //   200: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload_0
    //   210: invokestatic 398	com/tencent/open/appcommon/Common:b	(Ljava/lang/String;)V
    //   213: aload_3
    //   214: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifne +743 -> 960
    //   220: aload_3
    //   221: aload_2
    //   222: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifne +735 -> 960
    //   228: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   231: new 75	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 403
    //   241: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokestatic 354	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   247: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 392
    //   253: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_3
    //   257: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 396
    //   263: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_2
    //   267: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: iconst_1
    //   277: istore 6
    //   279: aload_2
    //   280: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   283: ifne +14 -> 297
    //   286: iload 6
    //   288: ifne +9 -> 297
    //   291: invokestatic 405	com/tencent/open/appcommon/ResourceUpdater:b	()Z
    //   294: ifeq +649 -> 943
    //   297: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   300: new 75	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 407
    //   310: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_0
    //   314: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 409
    //   320: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_2
    //   324: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_2
    //   334: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifeq +618 -> 955
    //   340: ldc_w 411
    //   343: astore_1
    //   344: aload_0
    //   345: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifeq +3 -> 351
    //   351: new 413	android/os/Bundle
    //   354: dup
    //   355: invokespecial 414	android/os/Bundle:<init>	()V
    //   358: astore_2
    //   359: aload_2
    //   360: ldc_w 416
    //   363: aload_1
    //   364: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload_2
    //   368: ldc_w 421
    //   371: aload_0
    //   372: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_2
    //   376: ldc_w 423
    //   379: ldc_w 425
    //   382: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_2
    //   386: ldc_w 427
    //   389: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   392: invokevirtual 429	com/tencent/open/adapter/CommonDataAdapter:c	()Ljava/lang/String;
    //   395: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_2
    //   399: ldc_w 431
    //   402: new 75	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   409: ldc_w 433
    //   412: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   418: invokevirtual 435	com/tencent/open/adapter/CommonDataAdapter:d	()Ljava/lang/String;
    //   421: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload_2
    //   431: ldc_w 437
    //   434: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   437: invokevirtual 440	com/tencent/open/adapter/CommonDataAdapter:g	()Ljava/lang/String;
    //   440: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: aload_2
    //   444: ldc_w 442
    //   447: new 75	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   454: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   457: invokevirtual 445	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   460: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: ldc_w 411
    //   466: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: aload_2
    //   476: ldc_w 447
    //   479: getstatic 452	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   482: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload_2
    //   486: ldc_w 454
    //   489: invokestatic 458	com/tencent/open/business/base/MobileInfoUtil:e	()Ljava/lang/String;
    //   492: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: aload_2
    //   496: ldc_w 460
    //   499: getstatic 465	android/os/Build:MODEL	Ljava/lang/String;
    //   502: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: invokestatic 467	com/tencent/open/base/LogUtility:a	()Z
    //   508: ifeq +64 -> 572
    //   511: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   514: invokevirtual 155	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   517: astore_0
    //   518: aload_0
    //   519: ifnull +53 -> 572
    //   522: aload_0
    //   523: invokestatic 473	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   526: ldc_w 475
    //   529: ldc_w 477
    //   532: invokeinterface 483 3 0
    //   537: astore_0
    //   538: aload_2
    //   539: ldc_w 485
    //   542: aload_0
    //   543: invokevirtual 419	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: aload_0
    //   547: ldc_w 487
    //   550: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   553: ifne +13 -> 566
    //   556: aload_0
    //   557: ldc_w 489
    //   560: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   563: ifeq +9 -> 572
    //   566: ldc_w 491
    //   569: putstatic 39	com/tencent/open/appcommon/ResourceUpdater:b	Ljava/lang/String;
    //   572: new 493	java/util/concurrent/CountDownLatch
    //   575: dup
    //   576: iconst_1
    //   577: invokespecial 496	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   580: astore_0
    //   581: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   584: ldc_w 498
    //   587: invokestatic 116	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: new 500	com/tencent/open/base/http/HttpCgiAsyncTask
    //   593: dup
    //   594: ldc_w 502
    //   597: getstatic 39	com/tencent/open/appcommon/ResourceUpdater:b	Ljava/lang/String;
    //   600: invokestatic 507	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   603: ldc_w 509
    //   606: new 511	com/tencent/open/appcommon/ResourceUpdater$CheckUpdateCallback
    //   609: dup
    //   610: aload_0
    //   611: aload_1
    //   612: invokespecial 514	com/tencent/open/appcommon/ResourceUpdater$CheckUpdateCallback:<init>	(Ljava/util/concurrent/CountDownLatch;Ljava/lang/String;)V
    //   615: invokespecial 517	com/tencent/open/base/http/HttpCgiAsyncTask:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/open/base/http/HttpCgiAsyncTask$Callback;)V
    //   618: iconst_1
    //   619: anewarray 413	android/os/Bundle
    //   622: dup
    //   623: iconst_0
    //   624: aload_2
    //   625: aastore
    //   626: invokevirtual 520	com/tencent/open/base/http/HttpCgiAsyncTask:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   629: pop
    //   630: aload_0
    //   631: invokevirtual 523	java/util/concurrent/CountDownLatch:await	()V
    //   634: ldc 2
    //   636: monitorexit
    //   637: return
    //   638: aload 4
    //   640: aload_1
    //   641: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifne +322 -> 966
    //   647: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   650: invokevirtual 155	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   653: astore_0
    //   654: aload_0
    //   655: ifnull +311 -> 966
    //   658: aload_0
    //   659: ldc_w 525
    //   662: invokestatic 528	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   665: invokestatic 533	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   668: invokestatic 528	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   671: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   674: invokestatic 537	com/tencent/open/base/ZipUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: new 376	java/io/File
    //   680: dup
    //   681: invokestatic 528	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   684: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   687: astore_0
    //   688: aload_0
    //   689: invokevirtual 380	java/io/File:exists	()Z
    //   692: ifeq +8 -> 700
    //   695: aload_0
    //   696: invokestatic 540	com/tencent/open/base/FileUtils:a	(Ljava/io/File;)Z
    //   699: pop
    //   700: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   703: invokestatic 364	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   706: astore_0
    //   707: goto -577 -> 130
    //   710: astore_0
    //   711: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   714: new 75	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 542
    //   724: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload_0
    //   728: invokevirtual 126	java/lang/Exception:toString	()Ljava/lang/String;
    //   731: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   740: goto -63 -> 677
    //   743: astore_0
    //   744: ldc 2
    //   746: monitorexit
    //   747: aload_0
    //   748: athrow
    //   749: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   752: invokevirtual 155	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   755: astore 5
    //   757: aload_1
    //   758: astore_0
    //   759: aload 5
    //   761: ifnull -552 -> 209
    //   764: aload 5
    //   766: ldc_w 525
    //   769: invokestatic 528	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   772: invokestatic 533	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   775: invokestatic 528	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   778: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   781: invokestatic 537	com/tencent/open/base/ZipUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: new 376	java/io/File
    //   787: dup
    //   788: invokestatic 528	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   791: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   794: astore_0
    //   795: aload_0
    //   796: invokevirtual 380	java/io/File:exists	()Z
    //   799: ifeq +8 -> 807
    //   802: aload_0
    //   803: invokestatic 540	com/tencent/open/base/FileUtils:a	(Ljava/io/File;)Z
    //   806: pop
    //   807: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   810: invokestatic 364	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   813: astore_0
    //   814: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   817: new 75	java/lang/StringBuilder
    //   820: dup
    //   821: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   824: ldc_w 544
    //   827: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: invokestatic 354	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   833: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: ldc_w 390
    //   839: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload 4
    //   844: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: ldc_w 374
    //   850: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload_1
    //   854: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: ldc_w 392
    //   860: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload_3
    //   864: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: ldc_w 394
    //   870: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload_0
    //   874: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: ldc_w 396
    //   880: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload_2
    //   884: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   893: goto -684 -> 209
    //   896: astore_0
    //   897: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   900: new 75	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   907: ldc_w 542
    //   910: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload_0
    //   914: invokevirtual 126	java/lang/Exception:toString	()Ljava/lang/String;
    //   917: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: goto -142 -> 784
    //   929: astore_0
    //   930: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   933: ldc_w 546
    //   936: aload_0
    //   937: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   940: goto -306 -> 634
    //   943: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   946: ldc_w 551
    //   949: invokestatic 116	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   952: goto -318 -> 634
    //   955: aload_2
    //   956: astore_1
    //   957: goto -613 -> 344
    //   960: iconst_0
    //   961: istore 6
    //   963: goto -684 -> 279
    //   966: aload_1
    //   967: astore_0
    //   968: goto -838 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   129	578	0	localObject1	Object
    //   710	18	0	localException1	Exception
    //   743	5	0	localObject2	Object
    //   758	116	0	localObject3	Object
    //   896	18	0	localException2	Exception
    //   929	8	0	localInterruptedException	InterruptedException
    //   967	1	0	localObject4	Object
    //   34	933	1	localObject5	Object
    //   27	929	2	localObject6	Object
    //   15	849	3	str1	String
    //   19	824	4	str2	String
    //   755	10	5	localContext	Context
    //   277	685	6	i	int
    // Exception table:
    //   from	to	target	type
    //   668	677	710	java/lang/Exception
    //   3	128	743	finally
    //   130	209	743	finally
    //   209	276	743	finally
    //   279	286	743	finally
    //   291	297	743	finally
    //   297	340	743	finally
    //   344	351	743	finally
    //   351	518	743	finally
    //   522	566	743	finally
    //   566	572	743	finally
    //   572	630	743	finally
    //   630	634	743	finally
    //   638	654	743	finally
    //   658	668	743	finally
    //   668	677	743	finally
    //   677	700	743	finally
    //   700	707	743	finally
    //   711	740	743	finally
    //   749	757	743	finally
    //   764	775	743	finally
    //   775	784	743	finally
    //   784	807	743	finally
    //   807	893	743	finally
    //   897	926	743	finally
    //   930	940	743	finally
    //   943	952	743	finally
    //   775	784	896	java/lang/Exception
    //   630	634	929	java/lang/InterruptedException
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: iconst_0
    //   3: istore 10
    //   5: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   8: ldc_w 555
    //   11: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 376	java/io/File
    //   17: dup
    //   18: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   21: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 380	java/io/File:exists	()Z
    //   27: ifne +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   35: invokestatic 364	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_3
    //   39: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   42: new 75	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 557
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: invokestatic 354	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   68: astore_0
    //   69: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   72: new 75	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 559
    //   82: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: invokestatic 562	com/tencent/open/appcommon/Common:t	()Ljava/lang/String;
    //   98: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifne +22 -> 123
    //   104: invokestatic 562	com/tencent/open/appcommon/Common:t	()Ljava/lang/String;
    //   107: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +514 -> 624
    //   113: invokestatic 562	com/tencent/open/appcommon/Common:t	()Ljava/lang/String;
    //   116: aload_3
    //   117: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   120: ifne +504 -> 624
    //   123: new 75	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   130: invokestatic 563	com/tencent/open/appcommon/Common:e	()Ljava/lang/String;
    //   133: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: getstatic 566	java/io/File:separator	Ljava/lang/String;
    //   139: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_3
    //   143: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore_0
    //   150: iconst_1
    //   151: istore 9
    //   153: new 376	java/io/File
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: astore 6
    //   163: aload 6
    //   165: invokevirtual 380	java/io/File:exists	()Z
    //   168: ifne +9 -> 177
    //   171: aload 6
    //   173: invokevirtual 569	java/io/File:mkdirs	()Z
    //   176: pop
    //   177: new 571	java/util/HashSet
    //   180: dup
    //   181: invokespecial 572	java/util/HashSet:<init>	()V
    //   184: astore 4
    //   186: new 574	java/util/zip/ZipFile
    //   189: dup
    //   190: new 376	java/io/File
    //   193: dup
    //   194: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   197: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   200: invokespecial 577	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   203: astore 5
    //   205: aload 5
    //   207: invokevirtual 581	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   210: astore 7
    //   212: aload 7
    //   214: invokeinterface 586 1 0
    //   219: ifeq +274 -> 493
    //   222: aload 7
    //   224: invokeinterface 589 1 0
    //   229: checkcast 591	java/util/zip/ZipEntry
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 592	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   237: astore 8
    //   239: aload 8
    //   241: ldc_w 594
    //   244: invokevirtual 597	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   247: ifne -35 -> 212
    //   250: aload_0
    //   251: invokevirtual 600	java/util/zip/ZipEntry:isDirectory	()Z
    //   254: ifeq +46 -> 300
    //   257: new 376	java/io/File
    //   260: dup
    //   261: aload 6
    //   263: invokevirtual 603	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   266: aload 8
    //   268: invokespecial 604	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 380	java/io/File:exists	()Z
    //   276: ifne -64 -> 212
    //   279: aload_0
    //   280: invokevirtual 569	java/io/File:mkdirs	()Z
    //   283: pop
    //   284: goto -72 -> 212
    //   287: astore_0
    //   288: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   291: ldc_w 606
    //   294: aload_0
    //   295: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   298: iconst_0
    //   299: ireturn
    //   300: new 376	java/io/File
    //   303: dup
    //   304: aload 6
    //   306: invokevirtual 603	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   309: aload 8
    //   311: invokespecial 604	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: astore_2
    //   315: aload_2
    //   316: invokevirtual 380	java/io/File:exists	()Z
    //   319: ifeq +8 -> 327
    //   322: aload_2
    //   323: invokevirtual 609	java/io/File:delete	()Z
    //   326: pop
    //   327: aload 4
    //   329: aload 8
    //   331: invokevirtual 106	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   334: invokeinterface 610 2 0
    //   339: pop
    //   340: aload 5
    //   342: aload_0
    //   343: invokevirtual 614	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   346: astore_0
    //   347: new 616	java/io/FileOutputStream
    //   350: dup
    //   351: aload_2
    //   352: invokespecial 617	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   355: astore_2
    //   356: sipush 1024
    //   359: newarray <illegal type>
    //   361: astore 8
    //   363: aload_0
    //   364: ifnull +71 -> 435
    //   367: aload_0
    //   368: aload 8
    //   370: invokevirtual 623	java/io/InputStream:read	([B)I
    //   373: istore 11
    //   375: iload 11
    //   377: iconst_m1
    //   378: if_icmpeq +57 -> 435
    //   381: aload_2
    //   382: aload 8
    //   384: iconst_0
    //   385: iload 11
    //   387: invokevirtual 629	java/io/OutputStream:write	([BII)V
    //   390: goto -23 -> 367
    //   393: astore_3
    //   394: aload_0
    //   395: astore_1
    //   396: aload_2
    //   397: astore_0
    //   398: aload_3
    //   399: astore_2
    //   400: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   403: ldc_w 606
    //   406: aload_2
    //   407: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   410: aload_1
    //   411: ifnull +7 -> 418
    //   414: aload_1
    //   415: invokevirtual 632	java/io/InputStream:close	()V
    //   418: aload_0
    //   419: ifnull -389 -> 30
    //   422: aload_0
    //   423: invokevirtual 633	java/io/OutputStream:close	()V
    //   426: iconst_0
    //   427: ireturn
    //   428: astore_0
    //   429: aload_0
    //   430: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   433: iconst_0
    //   434: ireturn
    //   435: aload_0
    //   436: ifnull +7 -> 443
    //   439: aload_0
    //   440: invokevirtual 632	java/io/InputStream:close	()V
    //   443: aload_2
    //   444: ifnull -232 -> 212
    //   447: aload_2
    //   448: invokevirtual 633	java/io/OutputStream:close	()V
    //   451: goto -239 -> 212
    //   454: astore_0
    //   455: aload_0
    //   456: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   459: goto -247 -> 212
    //   462: astore_1
    //   463: aconst_null
    //   464: astore_2
    //   465: aconst_null
    //   466: astore_0
    //   467: aload_0
    //   468: ifnull +7 -> 475
    //   471: aload_0
    //   472: invokevirtual 632	java/io/InputStream:close	()V
    //   475: aload_2
    //   476: ifnull +7 -> 483
    //   479: aload_2
    //   480: invokevirtual 633	java/io/OutputStream:close	()V
    //   483: aload_1
    //   484: athrow
    //   485: astore_0
    //   486: aload_0
    //   487: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   490: goto -7 -> 483
    //   493: aload 6
    //   495: invokevirtual 640	java/io/File:listFiles	()[Ljava/io/File;
    //   498: astore_0
    //   499: aload_0
    //   500: ifnull +57 -> 557
    //   503: aload_0
    //   504: arraylength
    //   505: istore 11
    //   507: iload 10
    //   509: iload 11
    //   511: if_icmpge +46 -> 557
    //   514: aload_0
    //   515: iload 10
    //   517: aaload
    //   518: astore_1
    //   519: aload_1
    //   520: invokevirtual 641	java/io/File:isDirectory	()Z
    //   523: ifne +25 -> 548
    //   526: aload 4
    //   528: aload_1
    //   529: invokevirtual 642	java/io/File:getName	()Ljava/lang/String;
    //   532: invokevirtual 106	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   535: invokeinterface 644 2 0
    //   540: ifne +8 -> 548
    //   543: aload_1
    //   544: invokevirtual 609	java/io/File:delete	()Z
    //   547: pop
    //   548: iload 10
    //   550: iconst_1
    //   551: iadd
    //   552: istore 10
    //   554: goto -47 -> 507
    //   557: aload 5
    //   559: ifnull +8 -> 567
    //   562: aload 5
    //   564: invokevirtual 645	java/util/zip/ZipFile:close	()V
    //   567: iload 9
    //   569: ifeq +11 -> 580
    //   572: aload_3
    //   573: invokestatic 647	com/tencent/open/appcommon/Common:d	(Ljava/lang/String;)V
    //   576: aload_3
    //   577: invokestatic 398	com/tencent/open/appcommon/Common:b	(Ljava/lang/String;)V
    //   580: iconst_1
    //   581: ireturn
    //   582: astore_0
    //   583: goto -16 -> 567
    //   586: astore_1
    //   587: aconst_null
    //   588: astore_2
    //   589: goto -122 -> 467
    //   592: astore_1
    //   593: goto -126 -> 467
    //   596: astore_2
    //   597: aload_1
    //   598: astore_3
    //   599: aload_2
    //   600: astore_1
    //   601: aload_0
    //   602: astore_2
    //   603: aload_3
    //   604: astore_0
    //   605: goto -138 -> 467
    //   608: astore_2
    //   609: aconst_null
    //   610: astore_0
    //   611: goto -211 -> 400
    //   614: astore_2
    //   615: aconst_null
    //   616: astore_3
    //   617: aload_0
    //   618: astore_1
    //   619: aload_3
    //   620: astore_0
    //   621: goto -221 -> 400
    //   624: iconst_0
    //   625: istore 9
    //   627: goto -474 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   68	212	0	localObject1	Object
    //   287	56	0	localException1	Exception
    //   346	77	0	localObject2	Object
    //   428	12	0	localIOException1	java.io.IOException
    //   454	2	0	localIOException2	java.io.IOException
    //   466	6	0	localObject3	Object
    //   485	2	0	localIOException3	java.io.IOException
    //   498	17	0	arrayOfFile	java.io.File[]
    //   582	20	0	localIOException4	java.io.IOException
    //   604	17	0	localObject4	Object
    //   1	414	1	localObject5	Object
    //   462	22	1	localObject6	Object
    //   518	26	1	localObject7	Object
    //   586	1	1	localObject8	Object
    //   592	6	1	localObject9	Object
    //   600	19	1	localObject10	Object
    //   314	275	2	localObject11	Object
    //   596	4	2	localObject12	Object
    //   602	1	2	localIOException5	java.io.IOException
    //   608	1	2	localException2	Exception
    //   614	1	2	localException3	Exception
    //   38	105	3	str	String
    //   393	184	3	localException4	Exception
    //   598	22	3	localObject13	Object
    //   184	343	4	localHashSet	java.util.HashSet
    //   203	360	5	localZipFile	java.util.zip.ZipFile
    //   161	333	6	localFile	java.io.File
    //   210	13	7	localEnumeration	java.util.Enumeration
    //   237	146	8	localObject14	Object
    //   151	475	9	i	int
    //   3	550	10	j	int
    //   373	139	11	k	int
    // Exception table:
    //   from	to	target	type
    //   186	205	287	java/lang/Exception
    //   356	363	393	java/lang/Exception
    //   367	375	393	java/lang/Exception
    //   381	390	393	java/lang/Exception
    //   414	418	428	java/io/IOException
    //   422	426	428	java/io/IOException
    //   439	443	454	java/io/IOException
    //   447	451	454	java/io/IOException
    //   340	347	462	finally
    //   471	475	485	java/io/IOException
    //   479	483	485	java/io/IOException
    //   562	567	582	java/io/IOException
    //   347	356	586	finally
    //   356	363	592	finally
    //   367	375	592	finally
    //   381	390	592	finally
    //   400	410	596	finally
    //   340	347	608	java/lang/Exception
    //   347	356	614	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: bipush -6
    //   2: istore 5
    //   4: iconst_0
    //   5: istore 20
    //   7: iconst_0
    //   8: istore 19
    //   10: invokestatic 656	android/os/SystemClock:elapsedRealtime	()J
    //   13: lstore 15
    //   15: aload_0
    //   16: invokevirtual 659	java/lang/String:length	()I
    //   19: i2l
    //   20: lstore 17
    //   22: lconst_0
    //   23: lstore 13
    //   25: aload_0
    //   26: sipush 180
    //   29: invokestatic 661	com/tencent/open/appcommon/ResourceUpdater:a	(Ljava/lang/String;I)Lorg/apache/http/HttpResponse;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnonnull +162 -> 196
    //   37: ldc_w 663
    //   40: astore_1
    //   41: aconst_null
    //   42: astore_3
    //   43: lconst_0
    //   44: lstore 7
    //   46: iload 19
    //   48: istore 20
    //   50: lload 7
    //   52: lstore 9
    //   54: iload 5
    //   56: istore 6
    //   58: aload_1
    //   59: astore_2
    //   60: aload_3
    //   61: ifnull +667 -> 728
    //   64: aload_3
    //   65: invokevirtual 632	java/io/InputStream:close	()V
    //   68: invokestatic 668	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   71: new 75	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   78: ldc 18
    //   80: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   86: invokevirtual 435	com/tencent/open/adapter/CommonDataAdapter:d	()Ljava/lang/String;
    //   89: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: lload 15
    //   97: lload 17
    //   99: lload 7
    //   101: iload 5
    //   103: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   106: invokevirtual 445	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   109: ldc_w 670
    //   112: aload_1
    //   113: invokevirtual 673	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   116: iload 19
    //   118: ifeq +527 -> 645
    //   121: ldc_w 675
    //   124: astore_1
    //   125: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   128: new 75	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   135: aload_1
    //   136: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 677
    //   146: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: lload 15
    //   151: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   154: ldc_w 677
    //   157: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: lload 17
    //   162: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   165: ldc_w 677
    //   168: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: lload 7
    //   173: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   176: ldc_w 677
    //   179: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 5
    //   184: invokevirtual 680	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: iload 19
    //   195: ireturn
    //   196: aload_1
    //   197: invokeinterface 261 1 0
    //   202: invokeinterface 267 1 0
    //   207: istore 6
    //   209: iload 6
    //   211: sipush 200
    //   214: if_icmpne +130 -> 344
    //   217: aload_1
    //   218: invokestatic 682	com/tencent/open/appcommon/ResourceUpdater:a	(Lorg/apache/http/HttpResponse;)Ljava/io/InputStream;
    //   221: astore_1
    //   222: aload_1
    //   223: ifnull +90 -> 313
    //   226: aload_1
    //   227: astore_2
    //   228: lload 13
    //   230: lstore 9
    //   232: lload 13
    //   234: lstore 11
    //   236: aload_1
    //   237: invokestatic 563	com/tencent/open/appcommon/Common:e	()Ljava/lang/String;
    //   240: ldc_w 684
    //   243: invokestatic 687	com/tencent/open/appcommon/Common:a	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)J
    //   246: lstore 7
    //   248: aload_1
    //   249: astore_2
    //   250: lload 7
    //   252: lstore 9
    //   254: lload 7
    //   256: lstore 11
    //   258: lload 7
    //   260: lstore 13
    //   262: invokestatic 688	com/tencent/open/appcommon/ResourceUpdater:a	()Z
    //   265: ifeq +18 -> 283
    //   268: aconst_null
    //   269: astore_2
    //   270: iconst_0
    //   271: istore 5
    //   273: iconst_1
    //   274: istore 19
    //   276: aload_1
    //   277: astore_3
    //   278: aload_2
    //   279: astore_1
    //   280: goto -234 -> 46
    //   283: aload_1
    //   284: astore_2
    //   285: lload 7
    //   287: lstore 9
    //   289: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   292: ldc_w 690
    //   295: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: ldc_w 692
    //   301: astore_2
    //   302: bipush -56
    //   304: istore 5
    //   306: aload_1
    //   307: astore_3
    //   308: aload_2
    //   309: astore_1
    //   310: goto -264 -> 46
    //   313: aload_1
    //   314: astore_2
    //   315: lload 13
    //   317: lstore 9
    //   319: lload 13
    //   321: lstore 11
    //   323: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   326: ldc_w 694
    //   329: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aconst_null
    //   333: astore_2
    //   334: lconst_0
    //   335: lstore 7
    //   337: aload_1
    //   338: astore_3
    //   339: aload_2
    //   340: astore_1
    //   341: goto -295 -> 46
    //   344: aconst_null
    //   345: astore_1
    //   346: iload 6
    //   348: istore 5
    //   350: aconst_null
    //   351: astore_3
    //   352: lconst_0
    //   353: lstore 7
    //   355: goto -309 -> 46
    //   358: astore_2
    //   359: aload_2
    //   360: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   363: goto -295 -> 68
    //   366: astore 4
    //   368: aconst_null
    //   369: astore_1
    //   370: lconst_0
    //   371: lstore 7
    //   373: aconst_null
    //   374: astore_3
    //   375: aload_3
    //   376: astore_2
    //   377: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   380: ldc_w 696
    //   383: aload 4
    //   385: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   388: bipush -7
    //   390: istore 5
    //   392: lload 7
    //   394: lstore 9
    //   396: iload 5
    //   398: istore 6
    //   400: aload_1
    //   401: astore_2
    //   402: aload_3
    //   403: ifnull +325 -> 728
    //   406: aload_3
    //   407: invokevirtual 632	java/io/InputStream:close	()V
    //   410: iconst_0
    //   411: istore 19
    //   413: goto -345 -> 68
    //   416: astore_2
    //   417: aload_2
    //   418: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   421: iconst_0
    //   422: istore 19
    //   424: goto -356 -> 68
    //   427: astore 4
    //   429: aconst_null
    //   430: astore_1
    //   431: lconst_0
    //   432: lstore 7
    //   434: aconst_null
    //   435: astore_3
    //   436: aload_3
    //   437: astore_2
    //   438: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   441: ldc_w 696
    //   444: aload 4
    //   446: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   449: bipush -8
    //   451: istore 5
    //   453: lload 7
    //   455: lstore 9
    //   457: iload 5
    //   459: istore 6
    //   461: aload_1
    //   462: astore_2
    //   463: aload_3
    //   464: ifnull +264 -> 728
    //   467: aload_3
    //   468: invokevirtual 632	java/io/InputStream:close	()V
    //   471: iconst_0
    //   472: istore 19
    //   474: goto -406 -> 68
    //   477: astore_2
    //   478: aload_2
    //   479: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   482: iconst_0
    //   483: istore 19
    //   485: goto -417 -> 68
    //   488: astore_0
    //   489: aconst_null
    //   490: astore_1
    //   491: aload_1
    //   492: astore_2
    //   493: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   496: ldc_w 696
    //   499: aload_0
    //   500: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   503: aload_1
    //   504: ifnull +7 -> 511
    //   507: aload_1
    //   508: invokevirtual 632	java/io/InputStream:close	()V
    //   511: iconst_0
    //   512: ireturn
    //   513: astore_0
    //   514: aload_0
    //   515: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   518: goto -7 -> 511
    //   521: astore_3
    //   522: lconst_0
    //   523: lstore 7
    //   525: aconst_null
    //   526: astore_1
    //   527: aload_1
    //   528: astore_2
    //   529: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   532: new 75	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   539: ldc_w 698
    //   542: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload_3
    //   546: invokevirtual 701	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   549: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: aload_3
    //   556: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   559: aload_1
    //   560: astore_2
    //   561: new 75	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 703
    //   571: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_3
    //   575: invokevirtual 701	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   578: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: astore_3
    //   585: lload 7
    //   587: lstore 9
    //   589: iload 5
    //   591: istore 6
    //   593: aload_3
    //   594: astore_2
    //   595: aload_1
    //   596: ifnull +132 -> 728
    //   599: aload_1
    //   600: invokevirtual 632	java/io/InputStream:close	()V
    //   603: iconst_0
    //   604: istore 19
    //   606: aload_3
    //   607: astore_1
    //   608: goto -540 -> 68
    //   611: astore_1
    //   612: aload_1
    //   613: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   616: iconst_0
    //   617: istore 19
    //   619: aload_3
    //   620: astore_1
    //   621: goto -553 -> 68
    //   624: astore_0
    //   625: aconst_null
    //   626: astore_2
    //   627: aload_2
    //   628: ifnull +7 -> 635
    //   631: aload_2
    //   632: invokevirtual 632	java/io/InputStream:close	()V
    //   635: aload_0
    //   636: athrow
    //   637: astore_1
    //   638: aload_1
    //   639: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   642: goto -7 -> 635
    //   645: ldc_w 705
    //   648: astore_1
    //   649: goto -524 -> 125
    //   652: astore_0
    //   653: goto -26 -> 627
    //   656: astore_0
    //   657: goto -30 -> 627
    //   660: astore_3
    //   661: lload 9
    //   663: lstore 7
    //   665: goto -138 -> 527
    //   668: astore_0
    //   669: goto -178 -> 491
    //   672: astore 4
    //   674: aconst_null
    //   675: astore_2
    //   676: lload 11
    //   678: lstore 7
    //   680: aload_1
    //   681: astore_3
    //   682: aload_2
    //   683: astore_1
    //   684: goto -248 -> 436
    //   687: astore 4
    //   689: ldc_w 692
    //   692: astore_2
    //   693: aload_1
    //   694: astore_3
    //   695: aload_2
    //   696: astore_1
    //   697: goto -261 -> 436
    //   700: astore 4
    //   702: aconst_null
    //   703: astore_2
    //   704: lload 13
    //   706: lstore 7
    //   708: aload_1
    //   709: astore_3
    //   710: aload_2
    //   711: astore_1
    //   712: goto -337 -> 375
    //   715: astore 4
    //   717: ldc_w 692
    //   720: astore_2
    //   721: aload_1
    //   722: astore_3
    //   723: aload_2
    //   724: astore_1
    //   725: goto -350 -> 375
    //   728: iload 20
    //   730: istore 19
    //   732: lload 9
    //   734: lstore 7
    //   736: iload 6
    //   738: istore 5
    //   740: aload_2
    //   741: astore_1
    //   742: goto -674 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	paramString	String
    //   32	576	1	localObject1	Object
    //   611	2	1	localIOException1	java.io.IOException
    //   620	1	1	localObject2	Object
    //   637	2	1	localIOException2	java.io.IOException
    //   648	94	1	localObject3	Object
    //   59	281	2	localObject4	Object
    //   358	2	2	localIOException3	java.io.IOException
    //   376	26	2	localObject5	Object
    //   416	2	2	localIOException4	java.io.IOException
    //   437	26	2	localObject6	Object
    //   477	2	2	localIOException5	java.io.IOException
    //   492	249	2	localObject7	Object
    //   42	426	3	localObject8	Object
    //   521	54	3	localException1	Exception
    //   584	36	3	str	String
    //   660	1	3	localException2	Exception
    //   681	42	3	localObject9	Object
    //   366	18	4	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   427	18	4	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   672	1	4	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   687	1	4	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   700	1	4	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   715	1	4	localConnectTimeoutException3	org.apache.http.conn.ConnectTimeoutException
    //   2	737	5	i	int
    //   56	681	6	j	int
    //   44	691	7	l1	long
    //   52	681	9	l2	long
    //   234	443	11	l3	long
    //   23	682	13	l4	long
    //   13	137	15	l5	long
    //   20	141	17	l6	long
    //   8	723	19	bool1	boolean
    //   5	724	20	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   64	68	358	java/io/IOException
    //   25	33	366	org/apache/http/conn/ConnectTimeoutException
    //   196	209	366	org/apache/http/conn/ConnectTimeoutException
    //   217	222	366	org/apache/http/conn/ConnectTimeoutException
    //   406	410	416	java/io/IOException
    //   25	33	427	java/net/SocketTimeoutException
    //   196	209	427	java/net/SocketTimeoutException
    //   217	222	427	java/net/SocketTimeoutException
    //   467	471	477	java/io/IOException
    //   25	33	488	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   196	209	488	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   217	222	488	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   507	511	513	java/io/IOException
    //   25	33	521	java/lang/Exception
    //   196	209	521	java/lang/Exception
    //   217	222	521	java/lang/Exception
    //   599	603	611	java/io/IOException
    //   25	33	624	finally
    //   196	209	624	finally
    //   217	222	624	finally
    //   631	635	637	java/io/IOException
    //   236	248	652	finally
    //   262	268	652	finally
    //   289	298	652	finally
    //   323	332	652	finally
    //   493	503	652	finally
    //   377	388	656	finally
    //   438	449	656	finally
    //   529	559	656	finally
    //   561	585	656	finally
    //   236	248	660	java/lang/Exception
    //   262	268	660	java/lang/Exception
    //   289	298	660	java/lang/Exception
    //   323	332	660	java/lang/Exception
    //   236	248	668	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   262	268	668	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   289	298	668	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   323	332	668	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   236	248	672	java/net/SocketTimeoutException
    //   262	268	672	java/net/SocketTimeoutException
    //   323	332	672	java/net/SocketTimeoutException
    //   289	298	687	java/net/SocketTimeoutException
    //   236	248	700	org/apache/http/conn/ConnectTimeoutException
    //   262	268	700	org/apache/http/conn/ConnectTimeoutException
    //   323	332	700	org/apache/http/conn/ConnectTimeoutException
    //   289	298	715	org/apache/http/conn/ConnectTimeoutException
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 33
    //   3: iconst_0
    //   4: istore 34
    //   6: iconst_0
    //   7: istore 35
    //   9: iconst_0
    //   10: istore 36
    //   12: iconst_0
    //   13: istore 30
    //   15: invokestatic 656	android/os/SystemClock:elapsedRealtime	()J
    //   18: lstore 26
    //   20: aload_0
    //   21: invokevirtual 659	java/lang/String:length	()I
    //   24: i2l
    //   25: lstore 28
    //   27: lconst_0
    //   28: lstore 18
    //   30: iconst_0
    //   31: istore 16
    //   33: aconst_null
    //   34: astore 10
    //   36: aconst_null
    //   37: astore 8
    //   39: aconst_null
    //   40: astore_2
    //   41: aconst_null
    //   42: astore 11
    //   44: aconst_null
    //   45: astore 12
    //   47: aconst_null
    //   48: astore 13
    //   50: aconst_null
    //   51: astore 14
    //   53: aconst_null
    //   54: astore 9
    //   56: lload 18
    //   58: lstore 20
    //   60: aload_2
    //   61: astore 6
    //   63: iload 34
    //   65: istore 31
    //   67: aload 11
    //   69: astore 5
    //   71: iload 35
    //   73: istore 32
    //   75: lload 18
    //   77: lstore 22
    //   79: aload 12
    //   81: astore 4
    //   83: aload 13
    //   85: astore_3
    //   86: lload 18
    //   88: lstore 24
    //   90: aload 14
    //   92: astore 7
    //   94: aload_0
    //   95: sipush 180
    //   98: invokestatic 661	com/tencent/open/appcommon/ResourceUpdater:a	(Ljava/lang/String;I)Lorg/apache/http/HttpResponse;
    //   101: astore 15
    //   103: aload 15
    //   105: ifnonnull +180 -> 285
    //   108: ldc_w 663
    //   111: astore_2
    //   112: iconst_0
    //   113: istore 30
    //   115: lconst_0
    //   116: lstore 20
    //   118: bipush -6
    //   120: istore 17
    //   122: aload 9
    //   124: astore_3
    //   125: iload 30
    //   127: istore 31
    //   129: lload 20
    //   131: lstore 18
    //   133: iload 17
    //   135: istore 16
    //   137: aload_2
    //   138: astore_1
    //   139: aload_3
    //   140: ifnull +1937 -> 2077
    //   143: aload_3
    //   144: invokevirtual 632	java/io/InputStream:close	()V
    //   147: aload_2
    //   148: astore_1
    //   149: iload 17
    //   151: istore 16
    //   153: lload 20
    //   155: lstore 18
    //   157: invokestatic 668	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   160: new 75	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   167: ldc 14
    //   169: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   175: invokevirtual 435	com/tencent/open/adapter/CommonDataAdapter:d	()Ljava/lang/String;
    //   178: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: lload 26
    //   186: lload 28
    //   188: lload 18
    //   190: iload 16
    //   192: invokestatic 152	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   195: invokevirtual 445	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   198: ldc_w 670
    //   201: aload_1
    //   202: invokevirtual 673	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   205: iload 30
    //   207: ifeq +1828 -> 2035
    //   210: ldc_w 708
    //   213: astore_1
    //   214: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   217: new 75	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   224: aload_1
    //   225: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 677
    //   235: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: lload 26
    //   240: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   243: ldc_w 677
    //   246: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: lload 28
    //   251: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: ldc_w 677
    //   257: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: lload 18
    //   262: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: ldc_w 677
    //   268: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: iload 16
    //   273: invokevirtual 680	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: iload 30
    //   284: ireturn
    //   285: lload 18
    //   287: lstore 20
    //   289: aload_2
    //   290: astore 6
    //   292: iload 34
    //   294: istore 31
    //   296: aload 11
    //   298: astore 5
    //   300: iload 35
    //   302: istore 32
    //   304: lload 18
    //   306: lstore 22
    //   308: aload 12
    //   310: astore 4
    //   312: aload 13
    //   314: astore_3
    //   315: lload 18
    //   317: lstore 24
    //   319: aload 14
    //   321: astore 7
    //   323: aload 15
    //   325: invokeinterface 261 1 0
    //   330: invokeinterface 267 1 0
    //   335: istore 17
    //   337: iload 17
    //   339: sipush 200
    //   342: if_icmpne +1342 -> 1684
    //   345: lload 18
    //   347: lstore 20
    //   349: aload_2
    //   350: astore 6
    //   352: iload 34
    //   354: istore 31
    //   356: aload 11
    //   358: astore 5
    //   360: iload 35
    //   362: istore 32
    //   364: lload 18
    //   366: lstore 22
    //   368: aload 12
    //   370: astore 4
    //   372: aload 13
    //   374: astore_3
    //   375: lload 18
    //   377: lstore 24
    //   379: aload 14
    //   381: astore 7
    //   383: aload 15
    //   385: invokestatic 682	com/tencent/open/appcommon/ResourceUpdater:a	(Lorg/apache/http/HttpResponse;)Ljava/io/InputStream;
    //   388: astore_2
    //   389: aload_2
    //   390: ifnonnull +66 -> 456
    //   393: lload 18
    //   395: lstore 20
    //   397: aload_2
    //   398: astore 6
    //   400: iload 34
    //   402: istore 31
    //   404: aload_2
    //   405: astore 5
    //   407: iload 35
    //   409: istore 32
    //   411: lload 18
    //   413: lstore 22
    //   415: aload_2
    //   416: astore 4
    //   418: aload_2
    //   419: astore_3
    //   420: lload 18
    //   422: lstore 24
    //   424: aload_2
    //   425: astore 7
    //   427: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   430: ldc_w 710
    //   433: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: iconst_0
    //   437: istore 30
    //   439: aload_2
    //   440: ifnull -158 -> 282
    //   443: aload_2
    //   444: invokevirtual 632	java/io/InputStream:close	()V
    //   447: iconst_0
    //   448: ireturn
    //   449: astore_0
    //   450: aload_0
    //   451: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   454: iconst_0
    //   455: ireturn
    //   456: lload 18
    //   458: lstore 20
    //   460: aload_2
    //   461: astore 6
    //   463: iload 34
    //   465: istore 31
    //   467: aload_2
    //   468: astore 5
    //   470: iload 35
    //   472: istore 32
    //   474: lload 18
    //   476: lstore 22
    //   478: aload_2
    //   479: astore 4
    //   481: aload_2
    //   482: astore_3
    //   483: lload 18
    //   485: lstore 24
    //   487: aload_2
    //   488: astore 7
    //   490: new 376	java/io/File
    //   493: dup
    //   494: invokestatic 362	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   497: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   500: astore 9
    //   502: lload 18
    //   504: lstore 20
    //   506: aload_2
    //   507: astore 6
    //   509: iload 34
    //   511: istore 31
    //   513: aload_2
    //   514: astore 5
    //   516: iload 35
    //   518: istore 32
    //   520: lload 18
    //   522: lstore 22
    //   524: aload_2
    //   525: astore 4
    //   527: aload_2
    //   528: astore_3
    //   529: lload 18
    //   531: lstore 24
    //   533: aload_2
    //   534: astore 7
    //   536: aload 9
    //   538: invokevirtual 380	java/io/File:exists	()Z
    //   541: ifne +62 -> 603
    //   544: lload 18
    //   546: lstore 20
    //   548: aload_2
    //   549: astore 6
    //   551: iload 34
    //   553: istore 31
    //   555: aload_2
    //   556: astore 5
    //   558: iload 35
    //   560: istore 32
    //   562: lload 18
    //   564: lstore 22
    //   566: aload_2
    //   567: astore 4
    //   569: aload_2
    //   570: astore_3
    //   571: lload 18
    //   573: lstore 24
    //   575: aload_2
    //   576: astore 7
    //   578: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   581: ldc_w 712
    //   584: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: bipush -57
    //   589: istore 16
    //   591: iconst_0
    //   592: istore 30
    //   594: lconst_0
    //   595: lstore 20
    //   597: aload 10
    //   599: astore_1
    //   600: goto +1484 -> 2084
    //   603: lload 18
    //   605: lstore 20
    //   607: aload_2
    //   608: astore 6
    //   610: iload 34
    //   612: istore 31
    //   614: aload_2
    //   615: astore 5
    //   617: iload 35
    //   619: istore 32
    //   621: lload 18
    //   623: lstore 22
    //   625: aload_2
    //   626: astore 4
    //   628: aload_2
    //   629: astore_3
    //   630: lload 18
    //   632: lstore 24
    //   634: aload_2
    //   635: astore 7
    //   637: aload_2
    //   638: invokestatic 563	com/tencent/open/appcommon/Common:e	()Ljava/lang/String;
    //   641: ldc_w 714
    //   644: invokestatic 687	com/tencent/open/appcommon/Common:a	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)J
    //   647: lstore 18
    //   649: lload 18
    //   651: lstore 20
    //   653: aload_2
    //   654: astore 6
    //   656: iload 34
    //   658: istore 31
    //   660: aload_2
    //   661: astore 5
    //   663: iload 35
    //   665: istore 32
    //   667: lload 18
    //   669: lstore 22
    //   671: aload_2
    //   672: astore 4
    //   674: aload_2
    //   675: astore_3
    //   676: lload 18
    //   678: lstore 24
    //   680: aload_2
    //   681: astore 7
    //   683: invokestatic 716	com/tencent/open/appcommon/ResourceUpdater:c	()Z
    //   686: ifeq +902 -> 1588
    //   689: lload 18
    //   691: lstore 20
    //   693: aload_2
    //   694: astore 6
    //   696: iload 34
    //   698: istore 31
    //   700: aload_2
    //   701: astore 5
    //   703: iload 35
    //   705: istore 32
    //   707: lload 18
    //   709: lstore 22
    //   711: aload_2
    //   712: astore 4
    //   714: aload_2
    //   715: astore_3
    //   716: lload 18
    //   718: lstore 24
    //   720: aload_2
    //   721: astore 7
    //   723: invokestatic 719	com/tencent/open/appcommon/Common:o	()Ljava/lang/String;
    //   726: invokestatic 364	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   729: astore 10
    //   731: lload 18
    //   733: lstore 20
    //   735: aload_2
    //   736: astore 6
    //   738: iload 34
    //   740: istore 31
    //   742: aload_2
    //   743: astore 5
    //   745: iload 35
    //   747: istore 32
    //   749: lload 18
    //   751: lstore 22
    //   753: aload_2
    //   754: astore 4
    //   756: aload_2
    //   757: astore_3
    //   758: lload 18
    //   760: lstore 24
    //   762: aload_2
    //   763: astore 7
    //   765: aload_1
    //   766: aload 10
    //   768: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   771: ifne +222 -> 993
    //   774: lload 18
    //   776: lstore 20
    //   778: aload_2
    //   779: astore 6
    //   781: iload 34
    //   783: istore 31
    //   785: aload_2
    //   786: astore 5
    //   788: iload 35
    //   790: istore 32
    //   792: lload 18
    //   794: lstore 22
    //   796: aload_2
    //   797: astore 4
    //   799: aload_2
    //   800: astore_3
    //   801: lload 18
    //   803: lstore 24
    //   805: aload_2
    //   806: astore 7
    //   808: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   811: ldc_w 721
    //   814: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   817: lload 18
    //   819: lstore 20
    //   821: aload_2
    //   822: astore 6
    //   824: iload 34
    //   826: istore 31
    //   828: aload_2
    //   829: astore 5
    //   831: iload 35
    //   833: istore 32
    //   835: lload 18
    //   837: lstore 22
    //   839: aload_2
    //   840: astore 4
    //   842: aload_2
    //   843: astore_3
    //   844: lload 18
    //   846: lstore 24
    //   848: aload_2
    //   849: astore 7
    //   851: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   854: new 75	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   861: ldc_w 723
    //   864: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload_1
    //   868: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: ldc_w 725
    //   874: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: aload 10
    //   879: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   888: lload 18
    //   890: lstore 20
    //   892: aload_2
    //   893: astore 6
    //   895: iload 34
    //   897: istore 31
    //   899: aload_2
    //   900: astore 5
    //   902: iload 35
    //   904: istore 32
    //   906: lload 18
    //   908: lstore 22
    //   910: aload_2
    //   911: astore 4
    //   913: aload_2
    //   914: astore_3
    //   915: lload 18
    //   917: lstore 24
    //   919: aload_2
    //   920: astore 7
    //   922: aload 9
    //   924: invokevirtual 609	java/io/File:delete	()Z
    //   927: pop
    //   928: iconst_0
    //   929: istore 30
    //   931: bipush -58
    //   933: istore 16
    //   935: aload 8
    //   937: astore_1
    //   938: aload_1
    //   939: astore 6
    //   941: iload 30
    //   943: istore 33
    //   945: iload 30
    //   947: istore 31
    //   949: aload_2
    //   950: astore 5
    //   952: iload 30
    //   954: istore 32
    //   956: lload 18
    //   958: lstore 22
    //   960: aload_2
    //   961: astore 4
    //   963: aload_2
    //   964: astore_3
    //   965: aload_1
    //   966: astore 7
    //   968: iload 30
    //   970: istore 34
    //   972: new 376	java/io/File
    //   975: dup
    //   976: invokestatic 728	com/tencent/open/appcommon/Common:n	()Ljava/lang/String;
    //   979: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   982: invokevirtual 609	java/io/File:delete	()Z
    //   985: pop
    //   986: lload 18
    //   988: lstore 20
    //   990: goto +1094 -> 2084
    //   993: lload 18
    //   995: lstore 20
    //   997: aload_2
    //   998: astore 6
    //   1000: iload 34
    //   1002: istore 31
    //   1004: aload_2
    //   1005: astore 5
    //   1007: iload 35
    //   1009: istore 32
    //   1011: lload 18
    //   1013: lstore 22
    //   1015: aload_2
    //   1016: astore 4
    //   1018: aload_2
    //   1019: astore_3
    //   1020: lload 18
    //   1022: lstore 24
    //   1024: aload_2
    //   1025: astore 7
    //   1027: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1030: ldc_w 730
    //   1033: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1036: lload 18
    //   1038: lstore 20
    //   1040: aload_2
    //   1041: astore 6
    //   1043: iload 34
    //   1045: istore 31
    //   1047: aload_2
    //   1048: astore 5
    //   1050: iload 35
    //   1052: istore 32
    //   1054: lload 18
    //   1056: lstore 22
    //   1058: aload_2
    //   1059: astore 4
    //   1061: aload_2
    //   1062: astore_3
    //   1063: lload 18
    //   1065: lstore 24
    //   1067: aload_2
    //   1068: astore 7
    //   1070: aload 9
    //   1072: invokevirtual 609	java/io/File:delete	()Z
    //   1075: ifeq +457 -> 1532
    //   1078: lload 18
    //   1080: lstore 20
    //   1082: aload_2
    //   1083: astore 6
    //   1085: iload 34
    //   1087: istore 31
    //   1089: aload_2
    //   1090: astore 5
    //   1092: iload 35
    //   1094: istore 32
    //   1096: lload 18
    //   1098: lstore 22
    //   1100: aload_2
    //   1101: astore 4
    //   1103: aload_2
    //   1104: astore_3
    //   1105: lload 18
    //   1107: lstore 24
    //   1109: aload_2
    //   1110: astore 7
    //   1112: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1115: ldc_w 732
    //   1118: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1121: lload 18
    //   1123: lstore 20
    //   1125: aload_2
    //   1126: astore 6
    //   1128: iload 34
    //   1130: istore 31
    //   1132: aload_2
    //   1133: astore 5
    //   1135: iload 35
    //   1137: istore 32
    //   1139: lload 18
    //   1141: lstore 22
    //   1143: aload_2
    //   1144: astore 4
    //   1146: aload_2
    //   1147: astore_3
    //   1148: lload 18
    //   1150: lstore 24
    //   1152: aload_2
    //   1153: astore 7
    //   1155: new 376	java/io/File
    //   1158: dup
    //   1159: invokestatic 719	com/tencent/open/appcommon/Common:o	()Ljava/lang/String;
    //   1162: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   1165: astore_1
    //   1166: lload 18
    //   1168: lstore 20
    //   1170: aload_2
    //   1171: astore 6
    //   1173: iload 34
    //   1175: istore 31
    //   1177: aload_2
    //   1178: astore 5
    //   1180: iload 35
    //   1182: istore 32
    //   1184: lload 18
    //   1186: lstore 22
    //   1188: aload_2
    //   1189: astore 4
    //   1191: aload_2
    //   1192: astore_3
    //   1193: lload 18
    //   1195: lstore 24
    //   1197: aload_2
    //   1198: astore 7
    //   1200: aload_1
    //   1201: aload 9
    //   1203: invokevirtual 735	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1206: ifeq +231 -> 1437
    //   1209: lload 18
    //   1211: lstore 20
    //   1213: aload_2
    //   1214: astore 6
    //   1216: iload 34
    //   1218: istore 31
    //   1220: aload_2
    //   1221: astore 5
    //   1223: iload 35
    //   1225: istore 32
    //   1227: lload 18
    //   1229: lstore 22
    //   1231: aload_2
    //   1232: astore 4
    //   1234: aload_2
    //   1235: astore_3
    //   1236: lload 18
    //   1238: lstore 24
    //   1240: aload_2
    //   1241: astore 7
    //   1243: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1246: ldc_w 737
    //   1249: invokestatic 93	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1252: lload 18
    //   1254: lstore 20
    //   1256: aload_2
    //   1257: astore 6
    //   1259: iload 34
    //   1261: istore 31
    //   1263: aload_2
    //   1264: astore 5
    //   1266: iload 35
    //   1268: istore 32
    //   1270: lload 18
    //   1272: lstore 22
    //   1274: aload_2
    //   1275: astore 4
    //   1277: aload_2
    //   1278: astore_3
    //   1279: lload 18
    //   1281: lstore 24
    //   1283: aload_2
    //   1284: astore 7
    //   1286: invokestatic 688	com/tencent/open/appcommon/ResourceUpdater:a	()Z
    //   1289: ifeq +12 -> 1301
    //   1292: iconst_1
    //   1293: istore 30
    //   1295: aload 8
    //   1297: astore_1
    //   1298: goto -360 -> 938
    //   1301: bipush -56
    //   1303: istore 16
    //   1305: ldc_w 692
    //   1308: astore_1
    //   1309: aload_1
    //   1310: astore 6
    //   1312: iload 34
    //   1314: istore 31
    //   1316: aload_2
    //   1317: astore 5
    //   1319: iload 35
    //   1321: istore 32
    //   1323: lload 18
    //   1325: lstore 22
    //   1327: aload_2
    //   1328: astore 4
    //   1330: aload_2
    //   1331: astore_3
    //   1332: aload_1
    //   1333: astore 7
    //   1335: iload 36
    //   1337: istore 34
    //   1339: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1342: ldc_w 690
    //   1345: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1348: goto -410 -> 938
    //   1351: astore_1
    //   1352: aload 6
    //   1354: astore 4
    //   1356: iload 33
    //   1358: istore 30
    //   1360: lload 18
    //   1362: lstore 20
    //   1364: aload_2
    //   1365: astore_3
    //   1366: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1369: new 75	java/lang/StringBuilder
    //   1372: dup
    //   1373: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1376: ldc_w 739
    //   1379: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: aload_1
    //   1383: invokevirtual 740	org/apache/http/conn/ConnectTimeoutException:getMessage	()Ljava/lang/String;
    //   1386: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1392: aload_1
    //   1393: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1396: bipush -7
    //   1398: istore 17
    //   1400: iload 30
    //   1402: istore 31
    //   1404: lload 20
    //   1406: lstore 18
    //   1408: iload 17
    //   1410: istore 16
    //   1412: aload 4
    //   1414: astore_1
    //   1415: aload_2
    //   1416: ifnull +661 -> 2077
    //   1419: aload_2
    //   1420: invokevirtual 632	java/io/InputStream:close	()V
    //   1423: lload 20
    //   1425: lstore 18
    //   1427: iload 17
    //   1429: istore 16
    //   1431: aload 4
    //   1433: astore_1
    //   1434: goto -1277 -> 157
    //   1437: lload 18
    //   1439: lstore 20
    //   1441: aload_2
    //   1442: astore 6
    //   1444: iload 34
    //   1446: istore 31
    //   1448: aload_2
    //   1449: astore 5
    //   1451: iload 35
    //   1453: istore 32
    //   1455: lload 18
    //   1457: lstore 22
    //   1459: aload_2
    //   1460: astore 4
    //   1462: aload_2
    //   1463: astore_3
    //   1464: lload 18
    //   1466: lstore 24
    //   1468: aload_2
    //   1469: astore 7
    //   1471: aload_1
    //   1472: invokevirtual 609	java/io/File:delete	()Z
    //   1475: pop
    //   1476: lload 18
    //   1478: lstore 20
    //   1480: aload_2
    //   1481: astore 6
    //   1483: iload 34
    //   1485: istore 31
    //   1487: aload_2
    //   1488: astore 5
    //   1490: iload 35
    //   1492: istore 32
    //   1494: lload 18
    //   1496: lstore 22
    //   1498: aload_2
    //   1499: astore 4
    //   1501: aload_2
    //   1502: astore_3
    //   1503: lload 18
    //   1505: lstore 24
    //   1507: aload_2
    //   1508: astore 7
    //   1510: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1513: ldc_w 742
    //   1516: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1519: iconst_0
    //   1520: istore 30
    //   1522: bipush -59
    //   1524: istore 16
    //   1526: aload 8
    //   1528: astore_1
    //   1529: goto -591 -> 938
    //   1532: lload 18
    //   1534: lstore 20
    //   1536: aload_2
    //   1537: astore 6
    //   1539: iload 34
    //   1541: istore 31
    //   1543: aload_2
    //   1544: astore 5
    //   1546: iload 35
    //   1548: istore 32
    //   1550: lload 18
    //   1552: lstore 22
    //   1554: aload_2
    //   1555: astore 4
    //   1557: aload_2
    //   1558: astore_3
    //   1559: lload 18
    //   1561: lstore 24
    //   1563: aload_2
    //   1564: astore 7
    //   1566: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1569: ldc_w 744
    //   1572: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1575: iconst_0
    //   1576: istore 30
    //   1578: bipush -60
    //   1580: istore 16
    //   1582: aload 8
    //   1584: astore_1
    //   1585: goto -647 -> 938
    //   1588: lload 18
    //   1590: lstore 20
    //   1592: aload_2
    //   1593: astore 6
    //   1595: iload 34
    //   1597: istore 31
    //   1599: aload_2
    //   1600: astore 5
    //   1602: iload 35
    //   1604: istore 32
    //   1606: lload 18
    //   1608: lstore 22
    //   1610: aload_2
    //   1611: astore 4
    //   1613: aload_2
    //   1614: astore_3
    //   1615: lload 18
    //   1617: lstore 24
    //   1619: aload_2
    //   1620: astore 7
    //   1622: aload 9
    //   1624: invokevirtual 609	java/io/File:delete	()Z
    //   1627: pop
    //   1628: lload 18
    //   1630: lstore 20
    //   1632: aload_2
    //   1633: astore 6
    //   1635: iload 34
    //   1637: istore 31
    //   1639: aload_2
    //   1640: astore 5
    //   1642: iload 35
    //   1644: istore 32
    //   1646: lload 18
    //   1648: lstore 22
    //   1650: aload_2
    //   1651: astore 4
    //   1653: aload_2
    //   1654: astore_3
    //   1655: lload 18
    //   1657: lstore 24
    //   1659: aload_2
    //   1660: astore 7
    //   1662: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1665: ldc_w 746
    //   1668: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1671: iconst_0
    //   1672: istore 30
    //   1674: bipush -61
    //   1676: istore 16
    //   1678: aload 8
    //   1680: astore_1
    //   1681: goto -743 -> 938
    //   1684: aconst_null
    //   1685: astore_2
    //   1686: iconst_0
    //   1687: istore 30
    //   1689: lconst_0
    //   1690: lstore 20
    //   1692: aload 9
    //   1694: astore_3
    //   1695: goto -1570 -> 125
    //   1698: astore_1
    //   1699: aload_1
    //   1700: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   1703: lload 20
    //   1705: lstore 18
    //   1707: iload 17
    //   1709: istore 16
    //   1711: aload_2
    //   1712: astore_1
    //   1713: goto -1556 -> 157
    //   1716: astore_1
    //   1717: aload_1
    //   1718: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   1721: lload 20
    //   1723: lstore 18
    //   1725: iload 17
    //   1727: istore 16
    //   1729: aload 4
    //   1731: astore_1
    //   1732: goto -1575 -> 157
    //   1735: astore_1
    //   1736: aconst_null
    //   1737: astore_2
    //   1738: iconst_0
    //   1739: istore 30
    //   1741: aload 6
    //   1743: astore_3
    //   1744: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1747: new 75	java/lang/StringBuilder
    //   1750: dup
    //   1751: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1754: ldc_w 739
    //   1757: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: aload_1
    //   1761: invokevirtual 747	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1764: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1770: aload_1
    //   1771: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1774: bipush -8
    //   1776: istore 17
    //   1778: iload 30
    //   1780: istore 31
    //   1782: lload 20
    //   1784: lstore 18
    //   1786: iload 17
    //   1788: istore 16
    //   1790: aload_2
    //   1791: astore_1
    //   1792: aload 6
    //   1794: ifnull +283 -> 2077
    //   1797: aload 6
    //   1799: invokevirtual 632	java/io/InputStream:close	()V
    //   1802: lload 20
    //   1804: lstore 18
    //   1806: iload 17
    //   1808: istore 16
    //   1810: aload_2
    //   1811: astore_1
    //   1812: goto -1655 -> 157
    //   1815: astore_1
    //   1816: aload_1
    //   1817: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   1820: lload 20
    //   1822: lstore 18
    //   1824: iload 17
    //   1826: istore 16
    //   1828: aload_2
    //   1829: astore_1
    //   1830: goto -1673 -> 157
    //   1833: astore_0
    //   1834: aload 5
    //   1836: astore_3
    //   1837: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1840: new 75	java/lang/StringBuilder
    //   1843: dup
    //   1844: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1847: ldc_w 739
    //   1850: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: aload_0
    //   1854: invokevirtual 748	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException:getMessage	()Ljava/lang/String;
    //   1857: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1863: aload_0
    //   1864: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1867: iload 31
    //   1869: istore 30
    //   1871: aload 5
    //   1873: ifnull -1591 -> 282
    //   1876: aload 5
    //   1878: invokevirtual 632	java/io/InputStream:close	()V
    //   1881: iload 31
    //   1883: ireturn
    //   1884: astore_0
    //   1885: aload_0
    //   1886: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   1889: iload 31
    //   1891: ireturn
    //   1892: astore_1
    //   1893: iload 32
    //   1895: istore 30
    //   1897: aload 4
    //   1899: astore_3
    //   1900: getstatic 35	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1903: new 75	java/lang/StringBuilder
    //   1906: dup
    //   1907: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1910: ldc_w 739
    //   1913: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: aload_1
    //   1917: invokevirtual 701	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1920: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1926: aload_1
    //   1927: invokestatic 549	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1930: aload 4
    //   1932: astore_3
    //   1933: new 75	java/lang/StringBuilder
    //   1936: dup
    //   1937: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1940: ldc_w 703
    //   1943: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: aload_1
    //   1947: invokevirtual 701	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1950: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1956: astore_2
    //   1957: bipush -6
    //   1959: istore 17
    //   1961: iload 30
    //   1963: istore 31
    //   1965: lload 22
    //   1967: lstore 18
    //   1969: iload 17
    //   1971: istore 16
    //   1973: aload_2
    //   1974: astore_1
    //   1975: aload 4
    //   1977: ifnull +100 -> 2077
    //   1980: aload 4
    //   1982: invokevirtual 632	java/io/InputStream:close	()V
    //   1985: lload 22
    //   1987: lstore 18
    //   1989: iload 17
    //   1991: istore 16
    //   1993: aload_2
    //   1994: astore_1
    //   1995: goto -1838 -> 157
    //   1998: astore_1
    //   1999: aload_1
    //   2000: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   2003: lload 22
    //   2005: lstore 18
    //   2007: iload 17
    //   2009: istore 16
    //   2011: aload_2
    //   2012: astore_1
    //   2013: goto -1856 -> 157
    //   2016: astore_0
    //   2017: aload_3
    //   2018: ifnull +7 -> 2025
    //   2021: aload_3
    //   2022: invokevirtual 632	java/io/InputStream:close	()V
    //   2025: aload_0
    //   2026: athrow
    //   2027: astore_1
    //   2028: aload_1
    //   2029: invokevirtual 636	java/io/IOException:printStackTrace	()V
    //   2032: goto -7 -> 2025
    //   2035: ldc_w 750
    //   2038: astore_1
    //   2039: goto -1825 -> 214
    //   2042: astore_1
    //   2043: iload 34
    //   2045: istore 30
    //   2047: lload 18
    //   2049: lstore 20
    //   2051: aload_2
    //   2052: astore 6
    //   2054: aload 7
    //   2056: astore_2
    //   2057: goto -316 -> 1741
    //   2060: astore_1
    //   2061: aconst_null
    //   2062: astore 4
    //   2064: iconst_0
    //   2065: istore 30
    //   2067: lload 24
    //   2069: lstore 20
    //   2071: aload 7
    //   2073: astore_2
    //   2074: goto -710 -> 1364
    //   2077: iload 31
    //   2079: istore 30
    //   2081: goto -1924 -> 157
    //   2084: iload 16
    //   2086: istore 17
    //   2088: aload_2
    //   2089: astore_3
    //   2090: aload_1
    //   2091: astore_2
    //   2092: goto -1967 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2095	0	paramString1	String
    //   0	2095	1	paramString2	String
    //   40	2052	2	localObject1	Object
    //   85	2005	3	localObject2	Object
    //   81	1982	4	localObject3	Object
    //   69	1808	5	localObject4	Object
    //   61	1992	6	localObject5	Object
    //   92	1980	7	localObject6	Object
    //   37	1642	8	localObject7	Object
    //   54	1639	9	localFile	java.io.File
    //   34	844	10	str	String
    //   42	315	11	localObject8	Object
    //   45	324	12	localObject9	Object
    //   48	325	13	localObject10	Object
    //   51	329	14	localObject11	Object
    //   101	283	15	localHttpResponse	HttpResponse
    //   31	2054	16	i	int
    //   120	1967	17	j	int
    //   28	2020	18	l1	long
    //   58	2012	20	l2	long
    //   77	1927	22	l3	long
    //   88	1980	24	l4	long
    //   18	221	26	l5	long
    //   25	225	28	l6	long
    //   13	2067	30	bool1	boolean
    //   65	2013	31	bool2	boolean
    //   73	1821	32	bool3	boolean
    //   1	1356	33	bool4	boolean
    //   4	2040	34	bool5	boolean
    //   7	1636	35	bool6	boolean
    //   10	1326	36	bool7	boolean
    // Exception table:
    //   from	to	target	type
    //   443	447	449	java/io/IOException
    //   972	986	1351	org/apache/http/conn/ConnectTimeoutException
    //   1339	1348	1351	org/apache/http/conn/ConnectTimeoutException
    //   143	147	1698	java/io/IOException
    //   1419	1423	1716	java/io/IOException
    //   94	103	1735	java/net/SocketTimeoutException
    //   323	337	1735	java/net/SocketTimeoutException
    //   383	389	1735	java/net/SocketTimeoutException
    //   427	436	1735	java/net/SocketTimeoutException
    //   490	502	1735	java/net/SocketTimeoutException
    //   536	544	1735	java/net/SocketTimeoutException
    //   578	587	1735	java/net/SocketTimeoutException
    //   637	649	1735	java/net/SocketTimeoutException
    //   683	689	1735	java/net/SocketTimeoutException
    //   723	731	1735	java/net/SocketTimeoutException
    //   765	774	1735	java/net/SocketTimeoutException
    //   808	817	1735	java/net/SocketTimeoutException
    //   851	888	1735	java/net/SocketTimeoutException
    //   922	928	1735	java/net/SocketTimeoutException
    //   1027	1036	1735	java/net/SocketTimeoutException
    //   1070	1078	1735	java/net/SocketTimeoutException
    //   1112	1121	1735	java/net/SocketTimeoutException
    //   1155	1166	1735	java/net/SocketTimeoutException
    //   1200	1209	1735	java/net/SocketTimeoutException
    //   1243	1252	1735	java/net/SocketTimeoutException
    //   1286	1292	1735	java/net/SocketTimeoutException
    //   1471	1476	1735	java/net/SocketTimeoutException
    //   1510	1519	1735	java/net/SocketTimeoutException
    //   1566	1575	1735	java/net/SocketTimeoutException
    //   1622	1628	1735	java/net/SocketTimeoutException
    //   1662	1671	1735	java/net/SocketTimeoutException
    //   1797	1802	1815	java/io/IOException
    //   94	103	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   323	337	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   383	389	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   427	436	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   490	502	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   536	544	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   578	587	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   637	649	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   683	689	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   723	731	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   765	774	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   808	817	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   851	888	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   922	928	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   972	986	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1027	1036	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1070	1078	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1112	1121	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1155	1166	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1200	1209	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1243	1252	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1286	1292	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1339	1348	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1471	1476	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1510	1519	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1566	1575	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1622	1628	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1662	1671	1833	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1876	1881	1884	java/io/IOException
    //   94	103	1892	java/lang/Exception
    //   323	337	1892	java/lang/Exception
    //   383	389	1892	java/lang/Exception
    //   427	436	1892	java/lang/Exception
    //   490	502	1892	java/lang/Exception
    //   536	544	1892	java/lang/Exception
    //   578	587	1892	java/lang/Exception
    //   637	649	1892	java/lang/Exception
    //   683	689	1892	java/lang/Exception
    //   723	731	1892	java/lang/Exception
    //   765	774	1892	java/lang/Exception
    //   808	817	1892	java/lang/Exception
    //   851	888	1892	java/lang/Exception
    //   922	928	1892	java/lang/Exception
    //   972	986	1892	java/lang/Exception
    //   1027	1036	1892	java/lang/Exception
    //   1070	1078	1892	java/lang/Exception
    //   1112	1121	1892	java/lang/Exception
    //   1155	1166	1892	java/lang/Exception
    //   1200	1209	1892	java/lang/Exception
    //   1243	1252	1892	java/lang/Exception
    //   1286	1292	1892	java/lang/Exception
    //   1339	1348	1892	java/lang/Exception
    //   1471	1476	1892	java/lang/Exception
    //   1510	1519	1892	java/lang/Exception
    //   1566	1575	1892	java/lang/Exception
    //   1622	1628	1892	java/lang/Exception
    //   1662	1671	1892	java/lang/Exception
    //   1980	1985	1998	java/io/IOException
    //   94	103	2016	finally
    //   323	337	2016	finally
    //   383	389	2016	finally
    //   427	436	2016	finally
    //   490	502	2016	finally
    //   536	544	2016	finally
    //   578	587	2016	finally
    //   637	649	2016	finally
    //   683	689	2016	finally
    //   723	731	2016	finally
    //   765	774	2016	finally
    //   808	817	2016	finally
    //   851	888	2016	finally
    //   922	928	2016	finally
    //   972	986	2016	finally
    //   1027	1036	2016	finally
    //   1070	1078	2016	finally
    //   1112	1121	2016	finally
    //   1155	1166	2016	finally
    //   1200	1209	2016	finally
    //   1243	1252	2016	finally
    //   1286	1292	2016	finally
    //   1339	1348	2016	finally
    //   1366	1396	2016	finally
    //   1471	1476	2016	finally
    //   1510	1519	2016	finally
    //   1566	1575	2016	finally
    //   1622	1628	2016	finally
    //   1662	1671	2016	finally
    //   1744	1774	2016	finally
    //   1837	1867	2016	finally
    //   1900	1930	2016	finally
    //   1933	1957	2016	finally
    //   2021	2025	2027	java/io/IOException
    //   972	986	2042	java/net/SocketTimeoutException
    //   1339	1348	2042	java/net/SocketTimeoutException
    //   94	103	2060	org/apache/http/conn/ConnectTimeoutException
    //   323	337	2060	org/apache/http/conn/ConnectTimeoutException
    //   383	389	2060	org/apache/http/conn/ConnectTimeoutException
    //   427	436	2060	org/apache/http/conn/ConnectTimeoutException
    //   490	502	2060	org/apache/http/conn/ConnectTimeoutException
    //   536	544	2060	org/apache/http/conn/ConnectTimeoutException
    //   578	587	2060	org/apache/http/conn/ConnectTimeoutException
    //   637	649	2060	org/apache/http/conn/ConnectTimeoutException
    //   683	689	2060	org/apache/http/conn/ConnectTimeoutException
    //   723	731	2060	org/apache/http/conn/ConnectTimeoutException
    //   765	774	2060	org/apache/http/conn/ConnectTimeoutException
    //   808	817	2060	org/apache/http/conn/ConnectTimeoutException
    //   851	888	2060	org/apache/http/conn/ConnectTimeoutException
    //   922	928	2060	org/apache/http/conn/ConnectTimeoutException
    //   1027	1036	2060	org/apache/http/conn/ConnectTimeoutException
    //   1070	1078	2060	org/apache/http/conn/ConnectTimeoutException
    //   1112	1121	2060	org/apache/http/conn/ConnectTimeoutException
    //   1155	1166	2060	org/apache/http/conn/ConnectTimeoutException
    //   1200	1209	2060	org/apache/http/conn/ConnectTimeoutException
    //   1243	1252	2060	org/apache/http/conn/ConnectTimeoutException
    //   1286	1292	2060	org/apache/http/conn/ConnectTimeoutException
    //   1471	1476	2060	org/apache/http/conn/ConnectTimeoutException
    //   1510	1519	2060	org/apache/http/conn/ConnectTimeoutException
    //   1566	1575	2060	org/apache/http/conn/ConnectTimeoutException
    //   1622	1628	2060	org/apache/http/conn/ConnectTimeoutException
    //   1662	1671	2060	org/apache/http/conn/ConnectTimeoutException
  }
  
  protected static boolean b()
  {
    boolean bool = false;
    try
    {
      long[] arrayOfLong = Common.a();
      long l1 = arrayOfLong[0];
      long l2 = arrayOfLong[1];
      long l3 = System.currentTimeMillis();
      LogUtility.c(a, "lastReportTime=" + l2 + " currentTime=" + l3 + " maxAge=" + l1);
      if ((l3 > l1 * 1000L + l2) || (l3 < l2)) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  protected static boolean c()
  {
    String str1 = Common.m();
    String str2 = Common.o();
    String str3 = Common.n();
    LogUtility.c(a, "mergeFile oldfile=" + str1 + ",newfile=" + str2 + ",patchfile=" + str3);
    try
    {
      boolean bool = BspatchUtil.a(str1, str3, str2);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      LogUtility.c(a, "mergeFile error : ", localThrowable);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\ResourceUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */