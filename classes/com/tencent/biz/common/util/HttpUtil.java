package com.tencent.biz.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.rookery.asyncHttpClient.AsyncHttpClient.CustomSSLSocketFactory;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtil
{
  public static final int a = 15000;
  public static final String a;
  private static boolean a = false;
  public static final int b = 30000;
  public static final String b = "GET";
  private static final int c = 17;
  public static final String c = "POST";
  public static final String d = "http://cgi.connect.qq.com/qqconnectopen/upload_share_image";
  public static final String e = "1";
  private static final String f = "http://openmobile.qq.com/api/url_change";
  private static final String g = "http://openmobile.qq.com/api/shortUrl";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = HttpUtil.class.getSimpleName();
  }
  
  public static int a()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 3: 
      return 2;
    case 1: 
      return 3;
    }
    return 4;
  }
  
  private static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    do
    {
      return i;
      return Proxy.getDefaultPort();
      paramContext = System.getProperty("http.proxyPort");
    } while (b(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext) {}
    return -1;
  }
  
  public static HttpUtil.NetworkProxy a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return null;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return null;
    }
    if (NetworkUtil.a((NetworkInfo)localObject))
    {
      localObject = a(paramContext);
      int i = a(paramContext);
      if ((!b((String)localObject)) && (i >= 0)) {
        return new HttpUtil.NetworkProxy((String)localObject, i, null);
      }
    }
    return null;
  }
  
  /* Error */
  public static ByteArrayOutputStream a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 139 1 0
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_1
    //   10: aconst_null
    //   11: astore_3
    //   12: aconst_null
    //   13: astore_2
    //   14: aload 4
    //   16: invokeinterface 145 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: astore_2
    //   26: aload 4
    //   28: astore_1
    //   29: aload 4
    //   31: astore_3
    //   32: new 147	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: invokespecial 148	java/io/ByteArrayOutputStream:<init>	()V
    //   39: astore 5
    //   41: aload 4
    //   43: astore_2
    //   44: aload 4
    //   46: astore_1
    //   47: aload 4
    //   49: astore_3
    //   50: aload_0
    //   51: ldc -106
    //   53: invokeinterface 154 2 0
    //   58: astore 6
    //   60: aload 4
    //   62: astore_0
    //   63: aload 6
    //   65: ifnull +52 -> 117
    //   68: aload 4
    //   70: astore_0
    //   71: aload 4
    //   73: astore_2
    //   74: aload 4
    //   76: astore_1
    //   77: aload 4
    //   79: astore_3
    //   80: aload 6
    //   82: invokeinterface 159 1 0
    //   87: invokevirtual 164	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   90: ldc -90
    //   92: invokevirtual 170	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +22 -> 117
    //   98: aload 4
    //   100: astore_2
    //   101: aload 4
    //   103: astore_1
    //   104: aload 4
    //   106: astore_3
    //   107: new 172	java/util/zip/GZIPInputStream
    //   110: dup
    //   111: aload 4
    //   113: invokespecial 175	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   116: astore_0
    //   117: aload_0
    //   118: astore_2
    //   119: aload_0
    //   120: astore_1
    //   121: aload_0
    //   122: astore_3
    //   123: sipush 512
    //   126: newarray <illegal type>
    //   128: astore 4
    //   130: aload_0
    //   131: astore_2
    //   132: aload_0
    //   133: astore_1
    //   134: aload_0
    //   135: astore_3
    //   136: aload_0
    //   137: aload 4
    //   139: invokevirtual 181	java/io/InputStream:read	([B)I
    //   142: istore 7
    //   144: iload 7
    //   146: iconst_m1
    //   147: if_icmpeq +38 -> 185
    //   150: aload_0
    //   151: astore_2
    //   152: aload_0
    //   153: astore_1
    //   154: aload_0
    //   155: astore_3
    //   156: aload 5
    //   158: aload 4
    //   160: iconst_0
    //   161: iload 7
    //   163: invokevirtual 185	java/io/ByteArrayOutputStream:write	([BII)V
    //   166: goto -36 -> 130
    //   169: astore_0
    //   170: aload_2
    //   171: astore_1
    //   172: aload_0
    //   173: athrow
    //   174: astore_0
    //   175: aload_1
    //   176: ifnull +7 -> 183
    //   179: aload_1
    //   180: invokevirtual 188	java/io/InputStream:close	()V
    //   183: aload_0
    //   184: athrow
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 188	java/io/InputStream:close	()V
    //   193: aload 5
    //   195: areturn
    //   196: astore_0
    //   197: aload_3
    //   198: astore_1
    //   199: new 131	java/io/IOException
    //   202: dup
    //   203: invokespecial 189	java/io/IOException:<init>	()V
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramHttpResponse	HttpResponse
    //   9	190	1	localObject1	Object
    //   13	158	2	localObject2	Object
    //   11	187	3	localObject3	Object
    //   6	153	4	localObject4	Object
    //   39	155	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   58	23	6	localHeader	org.apache.http.Header
    //   142	20	7	i	int
    // Exception table:
    //   from	to	target	type
    //   14	23	169	java/io/IOException
    //   32	41	169	java/io/IOException
    //   50	60	169	java/io/IOException
    //   80	98	169	java/io/IOException
    //   107	117	169	java/io/IOException
    //   123	130	169	java/io/IOException
    //   136	144	169	java/io/IOException
    //   156	166	169	java/io/IOException
    //   14	23	174	finally
    //   32	41	174	finally
    //   50	60	174	finally
    //   80	98	174	finally
    //   107	117	174	finally
    //   123	130	174	finally
    //   136	144	174	finally
    //   156	166	174	finally
    //   172	174	174	finally
    //   199	207	174	finally
    //   14	23	196	java/lang/Exception
    //   32	41	196	java/lang/Exception
    //   50	60	196	java/lang/Exception
    //   80	98	196	java/lang/Exception
    //   107	117	196	java/lang/Exception
    //   123	130	196	java/lang/Exception
    //   136	144	196	java/lang/Exception
    //   156	166	196	java/lang/Exception
  }
  
  public static String a()
  {
    switch ()
    {
    default: 
      return null;
    case -1: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "WIFI";
    case 2: 
      return "G2";
    case 3: 
      return "G3";
    case 4: 
      return "G4";
    }
    return "CABLE";
  }
  
  private static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        paramContext = str;
        if (b(str)) {
          paramContext = Proxy.getDefaultHost();
        }
        return paramContext;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  protected static final String a(Context paramContext, String paramString1, String paramString2, int paramInt, JSONArray paramJSONArray)
  {
    Bundle localBundle = new Bundle();
    String str = ((TicketManager)BaseApplicationImpl.a().a().getManager(2)).getPskey(paramString1, "openmobile.qq.com");
    if (!TextUtils.isEmpty(str)) {
      localBundle.putString("cookie", "p_uin=" + paramString1 + ";p_skey=" + str);
    }
    for (;;)
    {
      localBundle.putString("Referer", "http://openmobile.qq.com/");
      paramString1 = new Bundle();
      paramString1.putString("type", String.valueOf(paramInt));
      paramString1.putString("value", paramJSONArray.toString());
      paramString1.putString("mType", "qb_share");
      try
      {
        paramContext = a(paramContext, "http://openmobile.qq.com/api/url_change", "POST", paramString1, localBundle);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        QLog.d("zivonchen", 4, paramContext.getMessage());
      }
      localBundle.putString("cookie", "uin=" + paramString1 + ";skey=" + paramString2);
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(QRUtils.v))
        {
          str1 = QRUtils.a(paramContext, str2);
          if (str1 == null) {
            break label187;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label187:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext);
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[]))) {
        if ((localObject2 instanceof String[]))
        {
          int j;
          if (i != 0)
          {
            i = 0;
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label127:
            if (j >= localObject1.length) {
              break label205;
            }
            if (j != 0) {
              break label171;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label127;
            localStringBuilder.append("&");
            break;
            label171:
            localStringBuilder.append(URLEncoder.encode("," + localObject1[j]));
          }
        }
        else
        {
          label205:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=" + URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&", "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
  }
  
  /* Error */
  public static final String a(String paramString1, String paramString2, String paramString3, Map paramMap1, Map paramMap2, Map paramMap3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +17 -> 21
    //   7: aload_2
    //   8: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +7 -> 25
    //   21: aconst_null
    //   22: astore_0
    //   23: aload_0
    //   24: areturn
    //   25: aconst_null
    //   26: astore 6
    //   28: new 425	java/net/URL
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 426	java/net/URL:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 430	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   39: checkcast 432	java/net/HttpURLConnection
    //   42: astore 7
    //   44: aload 7
    //   46: sipush 5000
    //   49: invokevirtual 436	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   52: aload 7
    //   54: sipush 30000
    //   57: invokevirtual 439	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   60: aload 7
    //   62: iconst_1
    //   63: invokevirtual 443	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   66: aload 7
    //   68: iconst_1
    //   69: invokevirtual 446	java/net/HttpURLConnection:setDoInput	(Z)V
    //   72: aload 7
    //   74: iconst_0
    //   75: invokevirtual 449	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   78: aload 7
    //   80: ldc 18
    //   82: invokevirtual 452	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   85: aload 7
    //   87: ldc_w 454
    //   90: ldc_w 456
    //   93: invokevirtual 459	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload 7
    //   98: ldc_w 461
    //   101: new 248	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 463
    //   108: invokespecial 464	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: ldc_w 466
    //   114: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: getstatic 469	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   120: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 466
    //   126: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: getstatic 474	android/os/Build:DEVICE	Ljava/lang/String;
    //   132: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 466
    //   138: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: getstatic 477	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   144: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 466
    //   150: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 479
    //   156: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 459	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 7
    //   167: ldc_w 481
    //   170: new 248	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 483
    //   180: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 485
    //   186: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokevirtual 459	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 5
    //   197: astore 6
    //   199: aload 5
    //   201: ifnonnull +12 -> 213
    //   204: new 487	java/util/HashMap
    //   207: dup
    //   208: invokespecial 488	java/util/HashMap:<init>	()V
    //   211: astore 6
    //   213: aload_0
    //   214: ldc 21
    //   216: invokevirtual 491	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   219: ifeq +76 -> 295
    //   222: invokestatic 222	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   225: invokevirtual 225	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   228: iconst_2
    //   229: invokevirtual 231	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   232: checkcast 233	mqq/manager/TicketManager
    //   235: aload_1
    //   236: ldc_w 493
    //   239: invokeinterface 239 3 0
    //   244: astore 5
    //   246: aload 5
    //   248: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +44 -> 295
    //   254: aload 6
    //   256: ldc_w 495
    //   259: new 248	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   266: ldc -5
    //   268: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_1
    //   272: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc_w 257
    //   278: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload 5
    //   283: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokeinterface 501 3 0
    //   294: pop
    //   295: aload 6
    //   297: ldc_w 495
    //   300: invokeinterface 504 2 0
    //   305: ifne +44 -> 349
    //   308: aload 6
    //   310: ldc_w 495
    //   313: new 248	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 288
    //   323: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 290
    //   333: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_2
    //   337: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokeinterface 501 3 0
    //   348: pop
    //   349: aload 6
    //   351: invokeinterface 507 1 0
    //   356: invokeinterface 366 1 0
    //   361: astore_2
    //   362: aload_2
    //   363: invokeinterface 371 1 0
    //   368: ifeq +87 -> 455
    //   371: aload_2
    //   372: invokeinterface 375 1 0
    //   377: checkcast 509	java/util/Map$Entry
    //   380: astore_1
    //   381: aload 7
    //   383: aload_1
    //   384: invokeinterface 512 1 0
    //   389: checkcast 161	java/lang/String
    //   392: aload_1
    //   393: invokeinterface 514 1 0
    //   398: checkcast 161	java/lang/String
    //   401: invokevirtual 459	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: goto -42 -> 362
    //   407: astore_1
    //   408: aload 7
    //   410: astore_2
    //   411: aconst_null
    //   412: astore_1
    //   413: aload_2
    //   414: astore 6
    //   416: ldc_w 516
    //   419: iconst_2
    //   420: new 248	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 518
    //   430: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_0
    //   434: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 300	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: aload_1
    //   444: astore_0
    //   445: aload_2
    //   446: ifnull -423 -> 23
    //   449: aload_2
    //   450: invokevirtual 521	java/net/HttpURLConnection:disconnect	()V
    //   453: aload_1
    //   454: areturn
    //   455: new 523	java/io/DataOutputStream
    //   458: dup
    //   459: aload 7
    //   461: invokevirtual 527	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   464: invokespecial 530	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   467: astore_2
    //   468: aload_3
    //   469: ifnull +168 -> 637
    //   472: new 532	java/lang/StringBuffer
    //   475: dup
    //   476: invokespecial 533	java/lang/StringBuffer:<init>	()V
    //   479: astore_1
    //   480: aload_3
    //   481: invokeinterface 507 1 0
    //   486: invokeinterface 366 1 0
    //   491: astore_3
    //   492: aload_3
    //   493: invokeinterface 371 1 0
    //   498: ifeq +128 -> 626
    //   501: aload_3
    //   502: invokeinterface 375 1 0
    //   507: checkcast 509	java/util/Map$Entry
    //   510: astore 6
    //   512: aload 6
    //   514: invokeinterface 512 1 0
    //   519: checkcast 161	java/lang/String
    //   522: astore 5
    //   524: aload 6
    //   526: invokeinterface 514 1 0
    //   531: checkcast 161	java/lang/String
    //   534: astore 6
    //   536: aload 6
    //   538: ifnull -46 -> 492
    //   541: aload_1
    //   542: ldc_w 535
    //   545: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   548: ldc_w 540
    //   551: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   554: ldc_w 485
    //   557: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   560: ldc_w 535
    //   563: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   566: pop
    //   567: aload_1
    //   568: new 248	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 542
    //   578: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 5
    //   583: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 544
    //   589: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   598: pop
    //   599: aload_1
    //   600: aload 6
    //   602: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   605: pop
    //   606: goto -114 -> 492
    //   609: astore_0
    //   610: aload 7
    //   612: astore 6
    //   614: aload 6
    //   616: ifnull +8 -> 624
    //   619: aload 6
    //   621: invokevirtual 521	java/net/HttpURLConnection:disconnect	()V
    //   624: aload_0
    //   625: athrow
    //   626: aload_2
    //   627: aload_1
    //   628: invokevirtual 545	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   631: invokevirtual 549	java/lang/String:getBytes	()[B
    //   634: invokevirtual 554	java/io/OutputStream:write	([B)V
    //   637: aload 4
    //   639: ifnull +385 -> 1024
    //   642: aload 4
    //   644: invokeinterface 507 1 0
    //   649: invokeinterface 366 1 0
    //   654: astore_3
    //   655: aload_3
    //   656: invokeinterface 371 1 0
    //   661: ifeq +363 -> 1024
    //   664: aload_3
    //   665: invokeinterface 375 1 0
    //   670: checkcast 509	java/util/Map$Entry
    //   673: astore_1
    //   674: aload_1
    //   675: invokeinterface 512 1 0
    //   680: checkcast 161	java/lang/String
    //   683: astore 5
    //   685: aload_1
    //   686: invokeinterface 514 1 0
    //   691: checkcast 161	java/lang/String
    //   694: astore_1
    //   695: aload_1
    //   696: ifnull -41 -> 655
    //   699: new 556	java/io/File
    //   702: dup
    //   703: aload_1
    //   704: invokespecial 557	java/io/File:<init>	(Ljava/lang/String;)V
    //   707: astore 4
    //   709: aload 4
    //   711: invokevirtual 560	java/io/File:getName	()Ljava/lang/String;
    //   714: astore 6
    //   716: aload 6
    //   718: ldc_w 562
    //   721: invokevirtual 565	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   724: ifeq +3 -> 727
    //   727: ldc_w 567
    //   730: astore_1
    //   731: ldc_w 567
    //   734: ifnull +427 -> 1161
    //   737: ldc_w 567
    //   740: ldc_w 356
    //   743: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   746: ifeq +6 -> 752
    //   749: goto +412 -> 1161
    //   752: new 532	java/lang/StringBuffer
    //   755: dup
    //   756: invokespecial 533	java/lang/StringBuffer:<init>	()V
    //   759: astore 8
    //   761: aload 8
    //   763: ldc_w 535
    //   766: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   769: ldc_w 540
    //   772: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   775: ldc_w 485
    //   778: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   781: ldc_w 535
    //   784: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   787: pop
    //   788: aload 8
    //   790: new 248	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   797: ldc_w 542
    //   800: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload 5
    //   805: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 569
    //   811: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload 6
    //   816: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: ldc_w 571
    //   822: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   831: pop
    //   832: aload 8
    //   834: new 248	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   841: ldc_w 573
    //   844: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload_1
    //   848: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: ldc_w 575
    //   854: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   863: pop
    //   864: aload_2
    //   865: aload 8
    //   867: invokevirtual 545	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   870: invokevirtual 549	java/lang/String:getBytes	()[B
    //   873: invokevirtual 554	java/io/OutputStream:write	([B)V
    //   876: new 577	java/io/DataInputStream
    //   879: dup
    //   880: new 579	java/io/FileInputStream
    //   883: dup
    //   884: aload 4
    //   886: invokespecial 582	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   889: invokespecial 583	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   892: astore 5
    //   894: sipush 1024
    //   897: newarray <illegal type>
    //   899: astore_1
    //   900: aload 5
    //   902: aload_1
    //   903: invokevirtual 584	java/io/DataInputStream:read	([B)I
    //   906: istore 9
    //   908: iload 9
    //   910: iconst_m1
    //   911: if_icmpeq +97 -> 1008
    //   914: aload_2
    //   915: aload_1
    //   916: iconst_0
    //   917: iload 9
    //   919: invokevirtual 585	java/io/OutputStream:write	([BII)V
    //   922: goto -22 -> 900
    //   925: astore_1
    //   926: getstatic 45	com/tencent/biz/common/util/HttpUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   929: iconst_2
    //   930: new 248	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   937: ldc_w 587
    //   940: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: aload 4
    //   945: invokevirtual 591	java/io/File:length	()J
    //   948: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   951: ldc_w 596
    //   954: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: aload 4
    //   959: invokevirtual 599	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   962: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 601	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   971: aload_2
    //   972: invokevirtual 604	java/io/OutputStream:flush	()V
    //   975: aload_2
    //   976: invokevirtual 605	java/io/OutputStream:close	()V
    //   979: aload 7
    //   981: invokevirtual 521	java/net/HttpURLConnection:disconnect	()V
    //   984: aconst_null
    //   985: astore 6
    //   987: aconst_null
    //   988: astore_1
    //   989: aload 5
    //   991: invokevirtual 606	java/io/DataInputStream:close	()V
    //   994: aload_1
    //   995: astore_0
    //   996: iconst_0
    //   997: ifeq -974 -> 23
    //   1000: new 608	java/lang/NullPointerException
    //   1003: dup
    //   1004: invokespecial 609	java/lang/NullPointerException:<init>	()V
    //   1007: athrow
    //   1008: aload 5
    //   1010: invokevirtual 606	java/io/DataInputStream:close	()V
    //   1013: goto -358 -> 655
    //   1016: astore_1
    //   1017: aload 5
    //   1019: invokevirtual 606	java/io/DataInputStream:close	()V
    //   1022: aload_1
    //   1023: athrow
    //   1024: aload_2
    //   1025: new 248	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   1032: ldc_w 611
    //   1035: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: ldc_w 485
    //   1041: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: ldc_w 613
    //   1047: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokevirtual 549	java/lang/String:getBytes	()[B
    //   1056: invokevirtual 554	java/io/OutputStream:write	([B)V
    //   1059: aload_2
    //   1060: invokevirtual 604	java/io/OutputStream:flush	()V
    //   1063: aload_2
    //   1064: invokevirtual 605	java/io/OutputStream:close	()V
    //   1067: new 532	java/lang/StringBuffer
    //   1070: dup
    //   1071: invokespecial 533	java/lang/StringBuffer:<init>	()V
    //   1074: astore_3
    //   1075: new 615	java/io/BufferedReader
    //   1078: dup
    //   1079: new 617	java/io/InputStreamReader
    //   1082: dup
    //   1083: aload 7
    //   1085: invokevirtual 620	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1088: invokespecial 621	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1091: invokespecial 624	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1094: astore_2
    //   1095: aload_2
    //   1096: invokevirtual 627	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1099: astore_1
    //   1100: aload_1
    //   1101: ifnull +18 -> 1119
    //   1104: aload_3
    //   1105: aload_1
    //   1106: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1109: ldc_w 629
    //   1112: invokevirtual 538	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1115: pop
    //   1116: goto -21 -> 1095
    //   1119: aload_3
    //   1120: invokevirtual 545	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1123: astore_1
    //   1124: aload_2
    //   1125: invokevirtual 630	java/io/BufferedReader:close	()V
    //   1128: aload 7
    //   1130: ifnull +29 -> 1159
    //   1133: aload 7
    //   1135: invokevirtual 521	java/net/HttpURLConnection:disconnect	()V
    //   1138: aload_1
    //   1139: areturn
    //   1140: astore_0
    //   1141: goto -527 -> 614
    //   1144: aconst_null
    //   1145: astore_2
    //   1146: astore_1
    //   1147: aconst_null
    //   1148: astore_1
    //   1149: goto -736 -> 413
    //   1152: astore_2
    //   1153: aload 7
    //   1155: astore_2
    //   1156: goto -743 -> 413
    //   1159: aload_1
    //   1160: areturn
    //   1161: ldc_w 632
    //   1164: astore_1
    //   1165: goto -413 -> 752
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1168	0	paramString1	String
    //   0	1168	1	paramString2	String
    //   0	1168	2	paramString3	String
    //   0	1168	3	paramMap1	Map
    //   0	1168	4	paramMap2	Map
    //   0	1168	5	paramMap3	Map
    //   26	960	6	localObject	Object
    //   42	1112	7	localHttpURLConnection	java.net.HttpURLConnection
    //   759	107	8	localStringBuffer	StringBuffer
    //   906	12	9	i	int
    // Exception table:
    //   from	to	target	type
    //   44	195	407	java/lang/Exception
    //   204	213	407	java/lang/Exception
    //   213	295	407	java/lang/Exception
    //   295	349	407	java/lang/Exception
    //   349	362	407	java/lang/Exception
    //   362	404	407	java/lang/Exception
    //   455	468	407	java/lang/Exception
    //   472	492	407	java/lang/Exception
    //   492	536	407	java/lang/Exception
    //   541	606	407	java/lang/Exception
    //   626	637	407	java/lang/Exception
    //   642	655	407	java/lang/Exception
    //   655	695	407	java/lang/Exception
    //   699	727	407	java/lang/Exception
    //   737	749	407	java/lang/Exception
    //   752	900	407	java/lang/Exception
    //   1008	1013	407	java/lang/Exception
    //   1017	1024	407	java/lang/Exception
    //   1024	1095	407	java/lang/Exception
    //   1095	1100	407	java/lang/Exception
    //   1104	1116	407	java/lang/Exception
    //   1119	1124	407	java/lang/Exception
    //   44	195	609	finally
    //   204	213	609	finally
    //   213	295	609	finally
    //   295	349	609	finally
    //   349	362	609	finally
    //   362	404	609	finally
    //   455	468	609	finally
    //   472	492	609	finally
    //   492	536	609	finally
    //   541	606	609	finally
    //   626	637	609	finally
    //   642	655	609	finally
    //   655	695	609	finally
    //   699	727	609	finally
    //   737	749	609	finally
    //   752	900	609	finally
    //   1008	1013	609	finally
    //   1017	1024	609	finally
    //   1024	1095	609	finally
    //   1095	1100	609	finally
    //   1104	1116	609	finally
    //   1119	1124	609	finally
    //   1124	1128	609	finally
    //   900	908	925	java/lang/OutOfMemoryError
    //   914	922	925	java/lang/OutOfMemoryError
    //   900	908	1016	finally
    //   914	922	1016	finally
    //   926	984	1016	finally
    //   28	44	1140	finally
    //   416	443	1140	finally
    //   989	994	1140	finally
    //   28	44	1144	java/lang/Exception
    //   989	994	1144	java/lang/Exception
    //   1124	1128	1152	java/lang/Exception
  }
  
  public static String a(Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str3);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      if (i != 0)
      {
        localStringBuilder.append(str3 + "=" + URLEncoder.encode(str1, "utf-8"));
        i = 0;
      }
      for (;;)
      {
        break;
        if (str1 != null) {
          localStringBuilder.append("&" + str3 + "=" + URLEncoder.encode(str1, "utf-8"));
        } else {
          localStringBuilder.append("&" + str3 + "=");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(HttpResponse paramHttpResponse)
  {
    return new String(a(paramHttpResponse).toByteArray());
  }
  
  public static final HashMap a(Context paramContext, String paramString1, String paramString2, int paramInt, HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      paramContext = new HashMap();
    }
    for (;;)
    {
      return paramContext;
      HashMap localHashMap = new HashMap(paramHashMap);
      JSONArray localJSONArray = new JSONArray();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramHashMap.get(str1);
        if (!TextUtils.isEmpty(str2))
        {
          localJSONArray.put(str2);
          localArrayList.add(str1);
        }
      }
      paramContext = a(paramContext, paramString1, paramString2, paramInt, localJSONArray);
      if (paramContext != null) {}
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext.getInt("retcode") == 0)
        {
          paramContext = paramContext.getJSONObject("result");
          if (paramContext == null) {
            return localHashMap;
          }
          paramString2 = paramContext.getJSONArray("list");
          if (paramString2 == null) {
            return localHashMap;
          }
          if (paramString2.length() == localArrayList.size())
          {
            paramString1 = new HashMap();
            paramInt = 0;
            for (;;)
            {
              paramContext = paramString1;
              if (paramInt >= paramString2.length()) {
                break;
              }
              paramString1.put(localArrayList.get(paramInt), paramString2.getString(paramInt));
              paramInt += 1;
            }
          }
          QLog.e("sdk_share", 4, "!!!!urlArray.length() != srcKeyArray.size()");
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          QLog.d("sdk_share", 4, paramContext.getMessage());
        }
      }
    }
    return localHashMap;
  }
  
  public static final HashMap a(HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap(paramHashMap);
    Object localObject1 = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      String str2 = (String)paramHashMap.get(str1);
      if (!TextUtils.isEmpty(str2))
      {
        ((JSONArray)localObject1).put(str2);
        localArrayList.add(str1);
      }
    }
    paramHashMap = new Bundle();
    paramHashMap.putString("Referer", "http://openmobile.qq.com/");
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("value", ((JSONArray)localObject1).toString());
    ((Bundle)localObject2).putString("mType", "qb_share");
    localObject1 = null;
    try
    {
      paramHashMap = a(BaseApplication.getContext(), MsfSdkUtils.insertMtype("AppDepart", "http://openmobile.qq.com/api/shortUrl"), "POST", (Bundle)localObject2, paramHashMap);
      if (TextUtils.isEmpty(paramHashMap)) {
        return localHashMap;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        paramHashMap = (HashMap)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, localIOException.getMessage());
          paramHashMap = (HashMap)localObject1;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        paramHashMap = (HashMap)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError.getMessage());
          paramHashMap = (HashMap)localObject1;
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramHashMap = new JSONObject(paramHashMap);
        i = paramHashMap.getInt("retcode");
        if (i != 0)
        {
          if (!QLog.isColorLevel()) {
            break label453;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl error retcode:" + i);
          break label453;
        }
        paramHashMap = paramHashMap.getJSONObject("result");
        if (paramHashMap == null)
        {
          if (!QLog.isColorLevel()) {
            break label455;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl error result");
          break label455;
        }
        paramHashMap = paramHashMap.getJSONArray("list");
        if (paramHashMap == null)
        {
          if (!QLog.isColorLevel()) {
            break label457;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl error result");
          break label457;
        }
        if (paramHashMap.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramHashMap.length())
          {
            localObject1 = paramHashMap.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label459;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label459;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl error result size");
        }
      }
      catch (JSONException paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl parse response error");
        continue;
      }
      return localHashMap;
      label453:
      return localHashMap;
      label455:
      return localHashMap;
      label457:
      return localHashMap;
      label459:
      i += 1;
    }
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, 15000, 30000);
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      QRUtils.a(paramContext, QRUtils.v);
    }
    if (paramContext == null) {
      return null;
    }
    HttpClient localHttpClient = a(paramContext, paramInt1, paramInt2);
    if (localHttpClient == null) {
      return null;
    }
    QLog.d("QRHttpUtil", 2, paramString1);
    paramContext = paramString1;
    if (paramString1.contains("#")) {
      paramContext = paramString1.substring(0, paramString1.indexOf('#'));
    }
    paramString1 = paramContext.replace(" ", "");
    if ("GET".equals(paramString3))
    {
      paramString3 = a(paramBundle1);
      paramContext = paramString1;
      if (paramString3 != null)
      {
        paramContext = paramString1;
        if (paramString3.length() > 0)
        {
          paramBundle1 = new StringBuilder().append(paramString1);
          if (!paramString1.contains("?")) {
            break label240;
          }
          paramContext = "&";
        }
      }
      for (;;)
      {
        paramContext = paramContext + paramString3;
        try
        {
          paramContext = new HttpGet(paramContext);
          paramContext.addHeader("Accept-Encoding", "gzip");
          if (paramBundle2 != null)
          {
            paramString1 = paramBundle2.keySet().iterator();
            while (paramString1.hasNext())
            {
              paramString3 = (String)paramString1.next();
              paramBundle1 = paramBundle2.get(paramString3);
              if ((paramBundle1 instanceof String))
              {
                paramContext.addHeader(paramString3, (String)paramBundle1);
                continue;
                label240:
                paramContext = "?";
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext.getParams().setParameter("http.virtual-host", new HttpHost(paramString2));
      }
      try
      {
        paramContext = localHttpClient.execute(paramContext);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail IOException", paramContext);
        return null;
      }
      catch (OutOfMemoryError paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label449;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail OutOfMemoryError");
        return null;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label469;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail Exception", paramContext);
      }
      paramContext = new HttpPost(paramString1);
      paramContext.addHeader("Accept-Encoding", "gzip");
      paramString1 = a(paramBundle1);
      paramContext.setHeader("Content-Type", "application/x-www-form-urlencoded");
      paramString1 = paramString1.getBytes();
      if (paramBundle2 != null)
      {
        paramString3 = paramBundle2.keySet().iterator();
        while (paramString3.hasNext())
        {
          paramBundle1 = (String)paramString3.next();
          Object localObject = paramBundle2.get(paramBundle1);
          if ((localObject instanceof String)) {
            paramContext.addHeader(paramBundle1, (String)localObject);
          }
        }
      }
      paramContext.setEntity(new ByteArrayEntity(paramString1));
    }
    label449:
    label469:
    return null;
  }
  
  private static HttpClient a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (paramContext == null)
    {
      paramContext = (Context)localObject1;
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject1).load(null, null);
        localObject1 = new AsyncHttpClient.CustomSSLSocketFactory((KeyStore)localObject1);
        ((SSLSocketFactory)localObject1).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        Object localObject2 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, paramInt1);
        HttpConnectionParams.setSoTimeout((HttpParams)localObject2, paramInt2);
        HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset((HttpParams)localObject2, "UTF-8");
        HttpProtocolParams.setUserAgent((HttpParams)localObject2, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject1, 443));
        localObject1 = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject2, localSchemeRegistry), (HttpParams)localObject2);
        localObject2 = a(paramContext);
        paramContext = (Context)localObject1;
        if (localObject2 == null) {
          break;
        }
        paramContext = new HttpHost(((HttpUtil.NetworkProxy)localObject2).jdField_a_of_type_JavaLangString, ((HttpUtil.NetworkProxy)localObject2).jdField_a_of_type_Int);
        ((HttpClient)localObject1).getParams().setParameter("http.route.default-proxy", paramContext);
        return (HttpClient)localObject1;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "isConnect(), context == null");
      }
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          paramContext = paramContext.getState();
          NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
          if (paramContext == localState) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d("HttpUtil", 2, paramContext.toString());
    }
    return false;
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  public static byte[] a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(QRUtils.v))
        {
          str1 = QRUtils.a(paramContext, str2);
          if (str1 == null) {
            break label199;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label199:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext).toByteArray();
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
  }
  
  private static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new String[27];
    localObject[0] = "li";
    localObject[1] = "del";
    localObject[2] = "ins";
    localObject[3] = "fieldset";
    localObject[4] = "legend";
    localObject[5] = "tr";
    localObject[6] = "th";
    localObject[7] = "caption";
    localObject[8] = "thead";
    localObject[9] = "tbody";
    localObject[10] = "tfoot";
    localObject[11] = "p";
    localObject[12] = "h[1-6]";
    localObject[13] = "dl";
    localObject[14] = "dt";
    localObject[15] = "dd";
    localObject[16] = "ol";
    localObject[17] = "ul";
    localObject[18] = "dir";
    localObject[19] = "address";
    localObject[20] = "blockquote";
    localObject[21] = "center";
    localObject[22] = "hr";
    localObject[23] = "pre";
    localObject[24] = "form";
    localObject[25] = "textarea";
    localObject[26] = "table";
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      Matcher localMatcher = Pattern.compile("<(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll(" ");
      }
      localMatcher = Pattern.compile("</?(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll("\n");
      }
      i += 1;
    }
    localObject = Pattern.compile("<br>").matcher(paramString);
    if (((Matcher)localObject).find()) {
      paramString = ((Matcher)localObject).replaceAll("\n");
    }
    return paramString.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&nbsp;", " ").replace("<br>", " ").replace("<br/>", " ").replace("<br />", " ").replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"").replace("&#92;", "\\").replace("&#39;", "'");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\biz\common\util\HttpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */