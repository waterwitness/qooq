package cooperation.qzone;

import android.content.Context;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.NetworkUtils.NetworkProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.util.NetworkState;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class QZoneHttpUtil
{
  public static final char a = ':';
  public static final int a = 200;
  public static final String a = "GET";
  public static final char b = '/';
  public static final int b = 300;
  public static final String b = "POST";
  public static final int c = 400;
  public static final String c = "gzip";
  public static final int d = 500;
  public static final String d = "http://";
  public static final int e = 1024;
  public static final String e = "Content-Encoding";
  public static final int f = 2048;
  public static final String f = "X-Online-Host";
  public static final int g = 4096;
  public static final String g = "Host";
  public static final int h = 60000;
  public static final int i = 60000;
  public static final int j = "http://".length();
  private static final int k = 20000;
  private static final int l = 45000;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static int a(String paramString, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 4
    //   12: invokestatic 75	cooperation/qzone/util/NetworkState:a	()Z
    //   15: ifeq +225 -> 240
    //   18: getstatic 80	cooperation/qzone/QZoneHttpUtil$HttpProxy:a	Lcooperation/qzone/QZoneHttpUtil$HttpProxy;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +376 -> 399
    //   26: aload_0
    //   27: invokestatic 83	cooperation/qzone/QZoneHttpUtil:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   30: astore_3
    //   31: new 85	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   38: aload_2
    //   39: invokevirtual 90	cooperation/qzone/QZoneHttpUtil$HttpProxy:toString	()Ljava/lang/String;
    //   42: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: iconst_1
    //   47: aaload
    //   48: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 98	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   59: ldc 25
    //   61: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifeq +181 -> 245
    //   67: new 104	java/net/URL
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 107	java/net/URL:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 111	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   78: checkcast 113	java/net/HttpURLConnection
    //   81: astore_0
    //   82: aload_0
    //   83: sipush 30000
    //   86: invokevirtual 117	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   89: aload_0
    //   90: sipush 15000
    //   93: invokevirtual 120	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   96: aload_0
    //   97: ldc 12
    //   99: invokevirtual 123	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   102: aload_0
    //   103: iconst_1
    //   104: invokevirtual 127	java/net/HttpURLConnection:setDoInput	(Z)V
    //   107: aload_2
    //   108: ifnull +12 -> 120
    //   111: aload_0
    //   112: ldc 33
    //   114: aload_3
    //   115: iconst_0
    //   116: aaload
    //   117: invokevirtual 131	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: invokevirtual 134	java/net/HttpURLConnection:getResponseCode	()I
    //   124: istore 8
    //   126: aload 7
    //   128: astore_2
    //   129: iload 8
    //   131: invokestatic 137	cooperation/qzone/QZoneHttpUtil:a	(I)Z
    //   134: ifeq +131 -> 265
    //   137: new 139	java/io/BufferedOutputStream
    //   140: dup
    //   141: new 141	java/io/FileOutputStream
    //   144: dup
    //   145: aload_1
    //   146: iconst_1
    //   147: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   150: invokespecial 147	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   153: astore_1
    //   154: aload_0
    //   155: invokevirtual 151	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   158: astore_2
    //   159: sipush 8192
    //   162: newarray <illegal type>
    //   164: astore_3
    //   165: aload_2
    //   166: aload_3
    //   167: iconst_0
    //   168: aload_3
    //   169: arraylength
    //   170: invokevirtual 157	java/io/InputStream:read	([BII)I
    //   173: istore 9
    //   175: iconst_m1
    //   176: iload 9
    //   178: if_icmpeq +77 -> 255
    //   181: aload_1
    //   182: aload_3
    //   183: iconst_0
    //   184: iload 9
    //   186: invokevirtual 161	java/io/BufferedOutputStream:write	([BII)V
    //   189: goto -24 -> 165
    //   192: astore_3
    //   193: aload_1
    //   194: astore 4
    //   196: aload_0
    //   197: astore_1
    //   198: aload 4
    //   200: astore_2
    //   201: ldc -93
    //   203: iconst_1
    //   204: ldc -91
    //   206: aload_3
    //   207: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: sipush 1024
    //   213: istore 9
    //   215: aload 4
    //   217: invokestatic 175	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   220: pop
    //   221: iload 9
    //   223: istore 8
    //   225: aload_0
    //   226: ifnull +11 -> 237
    //   229: aload_0
    //   230: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   233: iload 9
    //   235: istore 8
    //   237: iload 8
    //   239: ireturn
    //   240: aconst_null
    //   241: astore_2
    //   242: goto -220 -> 22
    //   245: ldc 25
    //   247: aload_0
    //   248: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   251: astore_0
    //   252: goto -185 -> 67
    //   255: aload_1
    //   256: invokevirtual 185	java/io/BufferedOutputStream:flush	()V
    //   259: aload_1
    //   260: invokevirtual 188	java/io/BufferedOutputStream:close	()V
    //   263: aload_1
    //   264: astore_2
    //   265: aload_2
    //   266: invokestatic 175	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   269: pop
    //   270: aload_0
    //   271: ifnull +125 -> 396
    //   274: aload_0
    //   275: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   278: iload 8
    //   280: ireturn
    //   281: astore_3
    //   282: aconst_null
    //   283: astore_0
    //   284: aload 5
    //   286: astore 4
    //   288: aload_0
    //   289: astore_1
    //   290: aload 4
    //   292: astore_2
    //   293: ldc -93
    //   295: iconst_1
    //   296: ldc -66
    //   298: aload_3
    //   299: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: sipush 4096
    //   305: istore 8
    //   307: aload 4
    //   309: invokestatic 175	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   312: pop
    //   313: aload_0
    //   314: ifnull -77 -> 237
    //   317: aload_0
    //   318: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   321: sipush 4096
    //   324: ireturn
    //   325: astore_0
    //   326: aconst_null
    //   327: astore_1
    //   328: aload 6
    //   330: astore_2
    //   331: aload_2
    //   332: invokestatic 175	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   335: pop
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   344: aload_0
    //   345: athrow
    //   346: astore_2
    //   347: aload_0
    //   348: astore_1
    //   349: aload_2
    //   350: astore_0
    //   351: aload 6
    //   353: astore_2
    //   354: goto -23 -> 331
    //   357: astore_3
    //   358: aload_1
    //   359: astore_2
    //   360: aload_0
    //   361: astore_1
    //   362: aload_3
    //   363: astore_0
    //   364: goto -33 -> 331
    //   367: astore_0
    //   368: goto -37 -> 331
    //   371: astore_3
    //   372: aload 5
    //   374: astore 4
    //   376: goto -88 -> 288
    //   379: astore_3
    //   380: aload_1
    //   381: astore 4
    //   383: goto -95 -> 288
    //   386: astore_3
    //   387: aconst_null
    //   388: astore_0
    //   389: goto -193 -> 196
    //   392: astore_3
    //   393: goto -197 -> 196
    //   396: iload 8
    //   398: ireturn
    //   399: aconst_null
    //   400: astore_3
    //   401: goto -346 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramString	String
    //   0	404	1	paramFile	java.io.File
    //   21	311	2	localObject1	Object
    //   346	4	2	localObject2	Object
    //   353	7	2	localObject3	Object
    //   30	153	3	localObject4	Object
    //   192	15	3	localIOException1	java.io.IOException
    //   281	18	3	localException1	Exception
    //   357	6	3	localObject5	Object
    //   371	1	3	localException2	Exception
    //   379	1	3	localException3	Exception
    //   386	1	3	localIOException2	java.io.IOException
    //   392	1	3	localIOException3	java.io.IOException
    //   400	1	3	localObject6	Object
    //   10	372	4	localObject7	Object
    //   4	369	5	localObject8	Object
    //   7	345	6	localObject9	Object
    //   1	126	7	localObject10	Object
    //   124	273	8	m	int
    //   173	61	9	n	int
    // Exception table:
    //   from	to	target	type
    //   154	165	192	java/io/IOException
    //   165	175	192	java/io/IOException
    //   181	189	192	java/io/IOException
    //   255	263	192	java/io/IOException
    //   26	55	281	java/lang/Exception
    //   55	67	281	java/lang/Exception
    //   67	82	281	java/lang/Exception
    //   245	252	281	java/lang/Exception
    //   26	55	325	finally
    //   55	67	325	finally
    //   67	82	325	finally
    //   245	252	325	finally
    //   82	107	346	finally
    //   111	120	346	finally
    //   120	126	346	finally
    //   129	154	346	finally
    //   154	165	357	finally
    //   165	175	357	finally
    //   181	189	357	finally
    //   255	263	357	finally
    //   201	210	367	finally
    //   293	302	367	finally
    //   82	107	371	java/lang/Exception
    //   111	120	371	java/lang/Exception
    //   120	126	371	java/lang/Exception
    //   129	154	371	java/lang/Exception
    //   154	165	379	java/lang/Exception
    //   165	175	379	java/lang/Exception
    //   181	189	379	java/lang/Exception
    //   255	263	379	java/lang/Exception
    //   26	55	386	java/io/IOException
    //   55	67	386	java/io/IOException
    //   67	82	386	java/io/IOException
    //   245	252	386	java/io/IOException
    //   82	107	392	java/io/IOException
    //   111	120	392	java/io/IOException
    //   120	126	392	java/io/IOException
    //   129	154	392	java/io/IOException
  }
  
  private static String a(String paramString)
  {
    String str = paramString.trim().replace(" ", "");
    int m = str.indexOf('#');
    paramString = str;
    if (m > 0) {
      paramString = str.substring(0, m);
    }
    return paramString;
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return a(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    return a(false).execute(a(paramContext, paramString, paramHttpEntity, paramRequestOptions));
  }
  
  public static HttpClient a(boolean paramBoolean)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject2, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 20000);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject2, true);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 45000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
    HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent((HttpParams)localObject2, "android-qzone");
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      if (paramBoolean) {}
      for (localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);; localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1))
      {
        localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
        ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
        return (HttpClient)localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static HttpPost a(Context paramContext, String paramString, HttpEntity paramHttpEntity, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    Object localObject = a(paramString);
    paramString = b((String)localObject);
    localObject = new HttpPost((String)localObject);
    ((HttpPost)localObject).addHeader("Host", paramString);
    ((HttpPost)localObject).addHeader("x-online-host", paramString);
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
    }
    ((HttpPost)localObject).setEntity(paramHttpEntity);
    a(paramContext, (HttpRequest)localObject, paramRequestOptions);
    return (HttpPost)localObject;
  }
  
  private static void a(Context paramContext, HttpRequest paramHttpRequest, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    boolean bool1;
    if (paramRequestOptions != null)
    {
      bool1 = paramRequestOptions.c;
      if (paramRequestOptions == null) {
        break label78;
      }
    }
    label78:
    for (boolean bool2 = paramRequestOptions.d;; bool2 = false)
    {
      if ((bool1) && (NetworkState.b()))
      {
        paramContext = NetworkUtils.getProxy(paramContext, bool2);
        if (paramContext != null)
        {
          paramContext = new HttpHost(paramContext.host, paramContext.port);
          paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramContext);
        }
      }
      return;
      bool1 = true;
      break;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 299);
  }
  
  public static String[] a(String paramString)
  {
    String[] arrayOfString = new String[2];
    if ((paramString == null) || (paramString.length() < j)) {
      return arrayOfString;
    }
    if (paramString.toLowerCase().startsWith("http://"))
    {
      int n = paramString.indexOf('/', j);
      int m = n;
      if (n <= j) {
        m = paramString.length();
      }
      arrayOfString[0] = paramString.substring(j, m);
      if (m >= paramString.length()) {
        break label100;
      }
      arrayOfString[1] = paramString.substring(m, paramString.length());
    }
    for (;;)
    {
      return arrayOfString;
      paramString = "http://".concat(paramString);
      break;
      label100:
      arrayOfString[1] = "";
    }
  }
  
  private static String b(String paramString)
  {
    return new URL(paramString).getAuthority();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneHttpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */