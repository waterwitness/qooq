package com.tencent.beacon.upload;

import android.content.Context;
import android.net.Proxy;
import com.tencent.beacon.a.b.d;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public abstract class f
{
  private static f a = null;
  
  public static f a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new a(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public abstract byte[] a(String paramString, byte[] paramArrayOfByte, e parame, a parama)
    throws Exception;
  
  public static final class a
    extends f
  {
    private Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    private static b a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
      throws Exception
    {
      if (paramString1 == null)
      {
        com.tencent.beacon.d.a.d("no destUrl!", new Object[0]);
        return null;
      }
      HttpClient localHttpClient;
      if (paramArrayOfByte != null) {
        try
        {
          paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
          localHttpClient = a(paramString2, paramInt);
          if (localHttpClient == null)
          {
            com.tencent.beacon.d.a.d("no httpClient!", new Object[0]);
            return null;
          }
        }
        catch (Throwable paramString1)
        {
          paramArrayOfByte = null;
        }
      }
      for (;;)
      {
        com.tencent.beacon.d.a.a(paramString1);
        com.tencent.beacon.d.a.d("execute error:%s", new Object[] { paramString1.toString() });
        if (paramArrayOfByte != null) {
          paramArrayOfByte.abort();
        }
        throw new Exception(paramString1.toString());
        paramArrayOfByte = new ByteArrayEntity("".getBytes());
        break;
        paramString2 = new HttpPost(paramString1);
        try
        {
          paramString2.setHeader("wup_version", "3.0");
          paramString2.setHeader("TYPE_COMPRESS", "2");
          paramString2.setHeader("encr_type", "rsapost");
          paramString1 = d.a();
          if (paramString1 != null) {
            paramString2.setHeader("bea_key", paramString1.n());
          }
          paramString2.setEntity(paramArrayOfByte);
          paramString1 = new BasicHttpContext();
          paramArrayOfByte = localHttpClient.execute(paramString2, paramString1);
          com.tencent.beacon.d.a.h("execute request:\n %s", new Object[] { ((HttpRequest)paramString1.getAttribute("http.request")).getRequestLine().toString() });
          paramString1 = new b(paramArrayOfByte, paramString2);
          return paramString1;
        }
        catch (Throwable paramString1)
        {
          paramArrayOfByte = paramString2;
        }
      }
    }
    
    private static HttpClient a(String paramString, int paramInt)
    {
      try
      {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 2000);
        localBasicHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
        HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
        localDefaultHttpClient.setHttpRequestRetryHandler(new HttpRequestRetryHandler()
        {
          public final boolean retryRequest(IOException paramAnonymousIOException, int paramAnonymousInt, HttpContext paramAnonymousHttpContext)
          {
            if (paramAnonymousInt >= 3) {}
            do
            {
              return false;
              if ((paramAnonymousIOException instanceof NoHttpResponseException)) {
                return true;
              }
            } while (!(paramAnonymousIOException instanceof ClientProtocolException));
            return true;
          }
        });
        if ((paramString != null) && (paramString.toLowerCase(Locale.US).contains("wap")) && (paramInt != 2))
        {
          com.tencent.beacon.d.a.a("use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
          paramString = new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort());
          localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", paramString);
          return localDefaultHttpClient;
        }
        if (paramString != null) {
          com.tencent.beacon.d.a.a("Don't use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
        localDefaultHttpClient.getParams().removeParameter("http.route.default-proxy");
        return localDefaultHttpClient;
      }
      catch (Throwable paramString)
      {
        com.tencent.beacon.d.a.a(paramString);
        com.tencent.beacon.d.a.d("httpclient error!", new Object[0]);
      }
      return null;
    }
    
    /* Error */
    private byte[] a(HttpResponse paramHttpResponse, HttpPost paramHttpPost)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aload_1
      //   4: ifnonnull +8 -> 12
      //   7: aload 5
      //   9: astore_3
      //   10: aload_3
      //   11: areturn
      //   12: aload_1
      //   13: invokeinterface 236 1 0
      //   18: invokeinterface 241 1 0
      //   23: istore 6
      //   25: iload 6
      //   27: sipush 200
      //   30: if_icmpeq +31 -> 61
      //   33: ldc -13
      //   35: iconst_2
      //   36: anewarray 25	java/lang/Object
      //   39: dup
      //   40: iconst_0
      //   41: iload 6
      //   43: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   46: aastore
      //   47: dup
      //   48: iconst_1
      //   49: aload_1
      //   50: invokeinterface 236 1 0
      //   55: aastore
      //   56: invokestatic 246	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   59: aconst_null
      //   60: areturn
      //   61: aload_1
      //   62: ldc -8
      //   64: invokeinterface 251 2 0
      //   69: ifeq +56 -> 125
      //   72: aload_1
      //   73: ldc -3
      //   75: invokeinterface 251 2 0
      //   80: ifeq +45 -> 125
      //   83: aload_1
      //   84: ldc -8
      //   86: invokeinterface 257 2 0
      //   91: invokeinterface 262 1 0
      //   96: astore_3
      //   97: aload_1
      //   98: ldc -3
      //   100: invokeinterface 257 2 0
      //   105: invokeinterface 262 1 0
      //   110: astore 4
      //   112: invokestatic 88	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
      //   115: aload_0
      //   116: getfield 15	com/tencent/beacon/upload/f$a:a	Landroid/content/Context;
      //   119: aload_3
      //   120: aload 4
      //   122: invokevirtual 265	com/tencent/beacon/a/b/d:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
      //   125: aload_1
      //   126: invokeinterface 269 1 0
      //   131: astore_1
      //   132: aload_1
      //   133: ifnonnull +15 -> 148
      //   136: ldc_w 271
      //   139: iconst_0
      //   140: anewarray 25	java/lang/Object
      //   143: invokestatic 31	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   146: aconst_null
      //   147: areturn
      //   148: new 273	java/io/BufferedInputStream
      //   151: dup
      //   152: new 275	java/io/DataInputStream
      //   155: dup
      //   156: aload_1
      //   157: invokeinterface 281 1 0
      //   162: invokespecial 284	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   165: invokespecial 285	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   168: astore_3
      //   169: aload_3
      //   170: astore_1
      //   171: new 287	java/io/ByteArrayOutputStream
      //   174: dup
      //   175: invokespecial 288	java/io/ByteArrayOutputStream:<init>	()V
      //   178: astore 4
      //   180: aload_3
      //   181: astore_1
      //   182: aload_3
      //   183: invokevirtual 291	java/io/BufferedInputStream:read	()I
      //   186: istore 6
      //   188: iload 6
      //   190: iconst_m1
      //   191: if_icmpeq +65 -> 256
      //   194: aload_3
      //   195: astore_1
      //   196: aload 4
      //   198: iload 6
      //   200: invokevirtual 295	java/io/ByteArrayOutputStream:write	(I)V
      //   203: goto -23 -> 180
      //   206: astore 4
      //   208: aload_3
      //   209: astore_1
      //   210: aload 4
      //   212: invokestatic 44	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
      //   215: aload_3
      //   216: astore_1
      //   217: ldc_w 297
      //   220: iconst_1
      //   221: anewarray 25	java/lang/Object
      //   224: dup
      //   225: iconst_0
      //   226: aload 4
      //   228: invokevirtual 50	java/lang/Throwable:toString	()Ljava/lang/String;
      //   231: aastore
      //   232: invokestatic 31	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   235: aload_3
      //   236: ifnull +7 -> 243
      //   239: aload_3
      //   240: invokevirtual 300	java/io/BufferedInputStream:close	()V
      //   243: aload 5
      //   245: astore_3
      //   246: aload_2
      //   247: ifnull -237 -> 10
      //   250: aload_2
      //   251: invokevirtual 55	org/apache/http/client/methods/HttpPost:abort	()V
      //   254: aconst_null
      //   255: areturn
      //   256: aload_3
      //   257: astore_1
      //   258: aload 4
      //   260: invokevirtual 303	java/io/ByteArrayOutputStream:flush	()V
      //   263: aload_3
      //   264: astore_1
      //   265: aload 4
      //   267: invokevirtual 306	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   270: astore 4
      //   272: aload 4
      //   274: astore_1
      //   275: aload_3
      //   276: invokevirtual 300	java/io/BufferedInputStream:close	()V
      //   279: aload_1
      //   280: astore_3
      //   281: aload_2
      //   282: ifnull -272 -> 10
      //   285: aload_2
      //   286: invokevirtual 55	org/apache/http/client/methods/HttpPost:abort	()V
      //   289: aload_1
      //   290: areturn
      //   291: astore_3
      //   292: aload_3
      //   293: invokestatic 44	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
      //   296: goto -17 -> 279
      //   299: astore_1
      //   300: aload_1
      //   301: invokestatic 44	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
      //   304: goto -61 -> 243
      //   307: astore_3
      //   308: aconst_null
      //   309: astore_1
      //   310: aload_1
      //   311: ifnull +7 -> 318
      //   314: aload_1
      //   315: invokevirtual 300	java/io/BufferedInputStream:close	()V
      //   318: aload_2
      //   319: ifnull +7 -> 326
      //   322: aload_2
      //   323: invokevirtual 55	org/apache/http/client/methods/HttpPost:abort	()V
      //   326: aload_3
      //   327: athrow
      //   328: astore_1
      //   329: aload_1
      //   330: invokestatic 44	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
      //   333: goto -15 -> 318
      //   336: astore_3
      //   337: goto -27 -> 310
      //   340: astore 4
      //   342: aconst_null
      //   343: astore_3
      //   344: goto -136 -> 208
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	347	0	this	a
      //   0	347	1	paramHttpResponse	HttpResponse
      //   0	347	2	paramHttpPost	HttpPost
      //   9	272	3	localObject1	Object
      //   291	2	3	localThrowable1	Throwable
      //   307	20	3	localObject2	Object
      //   336	1	3	localObject3	Object
      //   343	1	3	localObject4	Object
      //   110	87	4	localObject5	Object
      //   206	60	4	localThrowable2	Throwable
      //   270	3	4	arrayOfByte	byte[]
      //   340	1	4	localThrowable3	Throwable
      //   1	243	5	localObject6	Object
      //   23	176	6	i	int
      // Exception table:
      //   from	to	target	type
      //   171	180	206	java/lang/Throwable
      //   182	188	206	java/lang/Throwable
      //   196	203	206	java/lang/Throwable
      //   258	263	206	java/lang/Throwable
      //   265	272	206	java/lang/Throwable
      //   275	279	291	java/lang/Throwable
      //   239	243	299	java/lang/Throwable
      //   148	169	307	finally
      //   314	318	328	java/lang/Throwable
      //   171	180	336	finally
      //   182	188	336	finally
      //   196	203	336	finally
      //   210	215	336	finally
      //   217	235	336	finally
      //   258	263	336	finally
      //   265	272	336	finally
      //   148	169	340	java/lang/Throwable
    }
    
    public final byte[] a(String paramString, byte[] paramArrayOfByte, e parame, a parama)
      throws Exception
    {
      if (paramString == null)
      {
        com.tencent.beacon.d.a.d("no destUrl!", new Object[0]);
        return null;
      }
      Object localObject1 = null;
      if (paramArrayOfByte == null) {}
      String str1;
      int j;
      int i;
      Object localObject2;
      int k;
      int m;
      for (long l2 = 0L;; l2 = paramArrayOfByte.length)
      {
        com.tencent.beacon.d.a.h("start req: %s sz:%d", new Object[] { paramString, Long.valueOf(l2) });
        str1 = "";
        j = 0;
        i = 0;
        localObject2 = paramString;
        paramString = "";
        k = 0;
        m = k + 1;
        if ((k >= 3) || (i >= 2)) {
          break label773;
        }
        if (j == 0) {
          break;
        }
        throw new Exception("net redirect");
      }
      if (m > 1)
      {
        com.tencent.beacon.d.a.h("try time:" + m, new Object[0]);
        if ((m == 2) && (parama.c() == 2)) {
          parama.b(false);
        }
      }
      long l1;
      long l4;
      int i2;
      try
      {
        Thread.sleep(5000L);
        Object localObject4 = com.tencent.beacon.a.f.u(this.a);
        if (parame != null) {
          parame.a((String)localObject2, l2, (String)localObject4, m);
        }
        l1 = new Date().getTime();
        try
        {
          localObject4 = a((String)localObject2, paramArrayOfByte, (String)localObject4, m);
          localObject1 = localObject4;
        }
        catch (Exception localException2)
        {
          HttpEntity localHttpEntity;
          long l3;
          str2 = localException2.toString();
          if (!paramString.equals(str2)) {
            break label441;
          }
          for (str1 = str1 + m + ":same ";; str1 = str1 + m + ":" + str2 + " ")
          {
            paramString = str2;
            break;
          }
          paramString = a(str2, ((b)localObject1).b);
          if (parame == null) {
            break label514;
          }
          if (paramString != null) {
            break label516;
          }
          l1 = 0L;
          parame.a(l1, l4);
          return paramString;
        }
        l4 = new Date().getTime() - l1;
        if (localObject1 == null) {
          break label755;
        }
        localObject4 = ((b)localObject1).a;
        localHttpEntity = ((HttpResponse)localObject4).getEntity();
        l1 = 0L;
        if (localHttpEntity != null)
        {
          l3 = localHttpEntity.getContentLength();
          l1 = l3;
          if (l3 < 0L) {
            l1 = 0L;
          }
        }
        i2 = ((HttpResponse)localObject4).getStatusLine().getStatusCode();
        com.tencent.beacon.d.a.h("response code:%d ", new Object[] { Integer.valueOf(i2) });
        if (i2 != 200) {
          break label524;
        }
        if (((HttpResponse)localObject4).containsHeader("encrypt-status"))
        {
          com.tencent.beacon.d.a.d("svr encry failed: " + ((HttpResponse)localObject4).getFirstHeader("encrypt-status").getValue(), new Object[0]);
          return null;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.beacon.d.a.a(localInterruptedException);
        }
      }
      String str2;
      for (;;)
      {
        label441:
        label514:
        label516:
        l1 = paramString.length;
      }
      label524:
      if ((i2 == 301) || (i2 == 302) || (i2 == 303) || (i2 == 307))
      {
        k = 1;
        label559:
        if (k == 0) {
          break label808;
        }
        m = 1;
        localObject2 = str2.getFirstHeader("Location");
        if (localObject2 != null) {
          break label639;
        }
        com.tencent.beacon.d.a.d("redirect code:" + i2 + " Location is null! return", new Object[0]);
      }
      for (;;)
      {
        try
        {
          if (((b)localObject1).b != null) {
            ((b)localObject1).b.abort();
          }
          return null;
          k = 0;
          break label559;
          label639:
          n = i + 1;
          i1 = 0;
          str2 = ((Header)localObject2).getValue();
          com.tencent.beacon.d.a.h("redirect code:%d , to:%s", new Object[] { Integer.valueOf(i2), str2 });
          i = m;
          j = n;
          k = i1;
          localObject2 = str2;
          try
          {
            if (((b)localObject1).b != null)
            {
              ((b)localObject1).b.abort();
              localObject2 = str2;
              k = i1;
              j = n;
              i = m;
            }
          }
          catch (Exception localException1)
          {
            i = m;
            j = n;
            k = i1;
            Object localObject3 = str2;
            continue;
          }
          if (parame != null) {
            parame.a(l1, l4);
          }
          m = j;
          j = i;
          i = m;
          break;
          label755:
          if (parame != null) {
            parame.a(0L, l4);
          }
          k = m;
          break;
          label773:
          throw new Exception(str1);
        }
        catch (Exception paramString)
        {
          int n;
          int i1;
          continue;
        }
        label808:
        k = m;
        m = i;
        i = j;
        j = m;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\upload\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */