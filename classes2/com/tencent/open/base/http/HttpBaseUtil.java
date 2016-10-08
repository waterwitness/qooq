package com.tencent.open.base.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.rookery.asyncHttpClient.AsyncHttpClient.CustomSSLSocketFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;
import wue;

public class HttpBaseUtil
{
  protected static final int a = 15000;
  public static final String a;
  public static HashMap a;
  protected static boolean a = false;
  protected static final int b = 30000;
  protected static final String b = "\r\n";
  protected static final int c = 1;
  protected static final String c = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
  public static final String d = "LastModifyUseString";
  public static final String e = "downloadfile";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = HttpBaseUtil.class.getName();
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilHashMap = new HashMap(64);
  }
  
  protected static int a()
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (CommonDataAdapter.a().a() != null)
      {
        int j = Proxy.getPort(CommonDataAdapter.a().a());
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    String str;
    do
    {
      return i;
      return Proxy.getDefaultPort();
      str = System.getProperty("http.proxyPort");
    } while (TextUtils.isEmpty(str));
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return -1;
  }
  
  protected static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
        }
        i += 1;
      }
    }
    return localBundle;
  }
  
  protected static HttpBaseUtil.HttpResponseBean a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle, null);
  }
  
  public static HttpBaseUtil.HttpResponseBean a(String paramString1, String paramString2, Bundle paramBundle, HttpContext paramHttpContext)
  {
    if (!AppNetConnInfo.isNetSupport()) {
      throw new HttpBaseUtil.NetworkUnavailableException("network unavailable");
    }
    for (;;)
    {
      Object localObject1;
      HttpClient localHttpClient;
      int j;
      try
      {
        str1 = paramBundle.getString("needhttpcache");
        localObject2 = paramBundle.getString("LastModifyUseString");
        paramBundle.remove("needhttpcache");
        paramBundle.remove("LastModifyUseString");
        localObject1 = paramBundle.getString("appid_for_getting_config");
        paramBundle.remove("appid_for_getting_config");
        localHttpClient = a((String)localObject1, paramString1);
        localObject1 = null;
        i = paramString1.length();
        if (paramString2.equals("GET"))
        {
          paramBundle = a(paramBundle);
          j = paramBundle.length();
          if (paramString1.indexOf("?") == -1)
          {
            paramString2 = paramString1 + "?";
            paramString2 = paramString2 + paramBundle;
            paramBundle = paramString1 + paramBundle;
            paramString1 = new HttpGet(paramString2);
            paramString1.addHeader("Accept-Encoding", "gzip");
            paramString1.addHeader("Content-Type", "application/x-www-form-urlencoded");
            if (str1 == null) {
              break label814;
            }
            paramString1.addHeader("If-None-Match", HttpCacheService.a().a(paramBundle));
            if (localObject2 != null)
            {
              paramString1.addHeader("If-Modified-Since", "\"" + HttpCacheService.a().b(paramBundle) + "\"");
              break label814;
              if (paramString1 != null) {
                paramString1.setHeader("Cookie", b());
              }
              if (paramHttpContext != null) {
                break label790;
              }
              paramString1 = localHttpClient.execute(paramString1);
              a(paramString1);
              return new HttpBaseUtil.HttpResponseBean(paramString1, i);
            }
          }
          else
          {
            if ((paramString1.endsWith("&")) || (TextUtils.isEmpty(paramBundle))) {
              break label809;
            }
            paramString2 = paramString1 + "&";
            continue;
          }
          paramString1.addHeader("If-Modified-Since", "\"" + HttpCacheService.a().a(paramBundle) + "\"");
          LogUtility.c(jdField_a_of_type_JavaLangString, "add header. If-None-Match:" + HttpCacheService.a().a(paramBundle) + "; If-Modified-Since:" + HttpCacheService.a().a(paramBundle));
        }
      }
      catch (MalformedURLException paramString1)
      {
        throw new MalformedURLException(paramString1.getMessage());
        if (!paramString2.equals("POST")) {
          break label803;
        }
        localObject1 = new HttpPost(paramString1);
        ((HttpPost)localObject1).addHeader("Accept-Encoding", "gzip");
        ((HttpPost)localObject1).addHeader("Content-Type", "application/x-www-form-urlencoded");
        boolean bool = paramBundle.getBoolean("doAuthorize", false);
        paramBundle.remove("doAuthorize");
        if (bool)
        {
          localObject2 = new ArrayList();
          Iterator localIterator = paramBundle.keySet().iterator();
          if (localIterator.hasNext())
          {
            str2 = (String)localIterator.next();
            if ((paramBundle.get(str2) instanceof String))
            {
              ((List)localObject2).add(new BasicNameValuePair(str2, (String)paramBundle.get(str2)));
              continue;
            }
          }
        }
      }
      catch (IOException paramString1)
      {
        String str1;
        String str2;
        throw paramString1;
        if (!(paramBundle.get(str2) instanceof String[])) {
          continue;
        }
        String[] arrayOfString = (String[])paramBundle.get(str2);
        int k = arrayOfString.length;
        paramString1 = null;
        j = 0;
        if (j < k)
        {
          str1 = arrayOfString[j];
          if (TextUtils.isEmpty(paramString1))
          {
            paramString1 = str1;
            break label824;
          }
          paramString1 = paramString1 + "," + str1;
          break label824;
        }
        ((List)localObject2).add(new BasicNameValuePair(str2, paramString1));
        continue;
      }
      catch (Exception paramString1)
      {
        Object localObject2;
        throw new Exception(paramString1);
        if (!paramBundle.containsKey("method")) {
          ((List)localObject2).add(new BasicNameValuePair("method", paramString2));
        }
        ((HttpPost)localObject1).setEntity(new UrlEncodedFormEntity((List)localObject2, "UTF-8"));
        break label833;
        ((HttpPost)localObject1).setEntity(new ByteArrayEntity(a(paramBundle).getBytes()));
        break label833;
      }
      catch (OutOfMemoryError paramString1)
      {
        throw new Exception(paramString1);
      }
      label790:
      paramString1 = localHttpClient.execute(paramString1, paramHttpContext);
      continue;
      label803:
      paramString1 = (String)localObject1;
      continue;
      label809:
      paramString2 = paramString1;
      continue;
      label814:
      int i = j + i;
      continue;
      label824:
      j += 1;
      continue;
      label833:
      paramString1 = (String)localObject1;
    }
  }
  
  protected static HttpBaseUtil.NetworkProxy a(Context paramContext)
  {
    if (paramContext == null) {}
    int i;
    do
    {
      do
      {
        return null;
      } while (NetworkUtil.b(paramContext) != 0);
      paramContext = a();
      i = a();
    } while ((TextUtils.isEmpty(paramContext)) || (i < 0));
    return new HttpBaseUtil.NetworkProxy(paramContext, i);
  }
  
  public static HttpBaseUtil.Statistic a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isAvailable())) {
          throw new HttpBaseUtil.NetworkUnavailableException("network unavailable");
        }
      }
    }
    Object localObject1 = new Bundle(paramBundle);
    String str1 = ((Bundle)localObject1).getString("mineType");
    ((Bundle)localObject1).remove("mineType");
    String str2 = ((Bundle)localObject1).getString("filename");
    ((Bundle)localObject1).remove("filename");
    paramBundle = a();
    int i;
    if (paramString2.toUpperCase().equals("GET"))
    {
      paramString2 = MsfSdkUtils.insertMtype("yingyongbao", a((Bundle)localObject1));
      LogUtility.e(jdField_a_of_type_JavaLangString, "openPicUploadUrl:" + paramString2);
      i = paramString2.length();
      if (paramString1.indexOf("?") == -1)
      {
        paramContext = paramString1 + "?";
        paramContext = new HttpGet(paramContext + paramString2);
        paramContext.addHeader("Accept-Encoding", "gzip");
        i = 0 + i;
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        paramContext.setHeader("Cookie", b());
      }
      paramContext = paramBundle.execute(paramContext);
      int j = paramContext.getStatusLine().getStatusCode();
      if (j == 200)
      {
        paramString1 = a(paramContext);
        a(paramContext);
        return new HttpBaseUtil.Statistic(paramString1, i, 1);
        paramContext = paramString1 + "&";
        break;
        if (!paramString2.toUpperCase().equals("POST")) {
          break label754;
        }
        paramContext = new HttpPost(paramString1);
        paramContext.addHeader("Accept-Encoding", "gzip");
        paramString1 = new Bundle();
        Object localObject2 = ((Bundle)localObject1).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str3 = (String)((Iterator)localObject2).next();
          Object localObject3 = ((Bundle)localObject1).get(str3);
          if ((localObject3 instanceof byte[])) {
            paramString1.putByteArray(str3, (byte[])localObject3);
          }
        }
        if (!((Bundle)localObject1).containsKey("method")) {
          ((Bundle)localObject1).putString("method", paramString2);
        }
        paramContext.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
        paramContext.setHeader("Connection", "Keep-Alive");
        paramString2 = new ByteArrayOutputStream();
        paramString2.write("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
        paramString2.write(MsfSdkUtils.insertMtype("yingyongbao", a((Bundle)localObject1, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")).getBytes());
        if (!paramString1.isEmpty())
        {
          int k = paramString1.size();
          localObject1 = paramString1.keySet().iterator();
          i = -1;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            j = i + 1;
            paramString2.write(("Content-Disposition: form-data; name=\"" + (String)localObject2 + "\"; filename=\"" + str2 + "\"" + "\r\n").getBytes());
            paramString2.write(("Content-Type: " + str1 + "\r\n" + "\r\n").getBytes());
            localObject2 = paramString1.getByteArray((String)localObject2);
            if (localObject2 != null) {
              paramString2.write((byte[])localObject2);
            }
            i = j;
            if (j < k - 1)
            {
              paramString2.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
              i = j;
            }
          }
        }
        paramString2.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n".getBytes());
        paramString1 = paramString2.toByteArray();
        i = paramString1.length + 0;
        paramString2.close();
        paramContext.setEntity(new ByteArrayEntity(paramString1));
        continue;
      }
      throw new HttpBaseUtil.HttpStatusException("http status code error:" + j);
      label754:
      paramContext = null;
      i = 0;
    }
  }
  
  public static HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle, 0);
  }
  
  protected static HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    String str1 = "";
    String str6 = paramBundle.getString("needhttpcache");
    String str4 = paramBundle.getString("LastModifyUseString");
    String str7 = MsfSdkUtils.insertMtype("yingyongbao", paramString1);
    String str5 = paramBundle.getString("downloadfile");
    paramBundle.remove("downloadfile");
    paramString1 = a(str7, paramString2, paramBundle);
    paramBundle.remove("needhttpcache");
    paramBundle.remove("LastModifyUseString");
    HttpResponse localHttpResponse = paramString1.jdField_a_of_type_OrgApacheHttpHttpResponse;
    int i = paramString1.jdField_a_of_type_Int;
    int j = localHttpResponse.getStatusLine().getStatusCode();
    String str2 = null;
    long l2 = 0L;
    paramString1 = "";
    if (localHttpResponse.containsHeader("Etag")) {
      str2 = localHttpResponse.getFirstHeader("Etag").getValue();
    }
    long l1 = l2;
    Object localObject = paramString1;
    if (localHttpResponse.containsHeader("Last-Modified"))
    {
      localObject = localHttpResponse.getFirstHeader("Last-Modified");
      if (str4 != null)
      {
        localObject = ((Header)localObject).getValue();
        l1 = l2;
      }
    }
    else
    {
      str4 = null;
      if ("GET".equals(paramString2))
      {
        str4 = a(str7, paramBundle);
        LogUtility.c(jdField_a_of_type_JavaLangString, "url2=" + str4);
      }
      if (j != 200) {
        break label377;
      }
      if (str5 == null) {
        break label368;
      }
      paramString1 = str1;
      label243:
      if ((str6 == null) || (!"GET".equals(paramString2))) {
        break label555;
      }
      HttpCacheService.a().a(str4, str2, l1, paramString1, (String)localObject);
      paramInt = 1;
    }
    for (;;)
    {
      paramString1 = new HttpBaseUtil.Statistic(paramString1, i, paramInt);
      if (str5 != null) {
        paramString1.a = localHttpResponse.getEntity().getContent();
      }
      return paramString1;
      try
      {
        l1 = Long.parseLong(((Header)localObject).getValue());
        localObject = paramString1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, " Parse Last-Modified to Long Exception: " + localNumberFormatException.getMessage());
        l1 = 0L;
        String str3 = paramString1;
      }
      break;
      label368:
      paramString1 = a(localHttpResponse);
      break label243;
      label377:
      if ((j == 304) && (str2 != null))
      {
        paramString1 = str1;
        if (str4 != null) {
          paramString1 = HttpCacheService.a().c(str4);
        }
        if ((paramString1 == null) || ("".equals(paramString1)))
        {
          LogUtility.e(jdField_a_of_type_JavaLangString, "Get response from cache error. remove cache and retry. retryCount=" + paramInt);
          if (str4 != null) {
            HttpCacheService.a().a(str4);
          }
          paramBundle.putString("needhttpcache", "nothing");
          if (paramInt < 1) {
            a(str7, paramString2, paramBundle, paramInt);
          }
        }
        paramInt = 0;
      }
      else
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "request" + str7 + "http server return error, statuscode:" + j);
        throw new HttpBaseUtil.HttpStatusException("http status code error:" + j);
        label555:
        paramInt = 1;
      }
    }
  }
  
  protected static String a()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (CommonDataAdapter.a().a() != null)
      {
        String str2 = Proxy.getHost(CommonDataAdapter.a().a());
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = Proxy.getDefaultHost();
        }
        return str1;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
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
            localStringBuilder.append(URLEncoder.encode((String)localObject1)).append("=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label113:
            if (j >= localObject1.length) {
              break label177;
            }
            if (j != 0) {
              break label156;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label113;
            localStringBuilder.append("&");
            break;
            label156:
            localStringBuilder.append(",").append(URLEncoder.encode(localObject1[j]));
          }
        }
        else
        {
          label177:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1)).append("=").append(URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  protected static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((localObject instanceof String))
      {
        localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n" + (String)localObject);
        localStringBuilder.append("\r\n--" + paramString + "\r\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString.equals("false")) {
      str = "{value : false}";
    }
    paramString = str;
    if (str.equals("true")) {
      paramString = "{value : true}";
    }
    str = paramString;
    if (paramString.contains("allback(")) {
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    }
    return str;
  }
  
  protected static String a(String paramString, Bundle paramBundle)
  {
    String str = a(paramBundle);
    if (paramString.indexOf("?") == -1) {
      paramBundle = paramString + "?";
    }
    for (;;)
    {
      return paramBundle + str;
      paramBundle = paramString;
      if (!paramString.endsWith("&"))
      {
        paramBundle = paramString;
        if (!TextUtils.isEmpty(str)) {
          paramBundle = paramString + "&";
        }
      }
    }
  }
  
  /* Error */
  public static String a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: ldc_w 482
    //   8: astore 4
    //   10: aload_0
    //   11: invokeinterface 517 1 0
    //   16: astore_1
    //   17: aload_0
    //   18: ldc_w 607
    //   21: invokeinterface 494 2 0
    //   26: ifeq +49 -> 75
    //   29: aload_0
    //   30: ldc_w 607
    //   33: invokeinterface 498 2 0
    //   38: invokeinterface 503 1 0
    //   43: invokestatic 531	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   46: lstore 8
    //   48: getstatic 40	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   51: new 178	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 609
    //   61: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: lload 8
    //   66: invokevirtual 248	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 256	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_1
    //   76: invokeinterface 523 1 0
    //   81: astore_1
    //   82: aload_0
    //   83: ldc_w 611
    //   86: invokeinterface 498 2 0
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +59 -> 152
    //   96: aload_2
    //   97: invokeinterface 503 1 0
    //   102: invokevirtual 614	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   105: ldc -63
    //   107: invokevirtual 176	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   110: iconst_m1
    //   111: if_icmple +41 -> 152
    //   114: new 616	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 617	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore_2
    //   123: aload_2
    //   124: invokestatic 619	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   127: astore_3
    //   128: aload_3
    //   129: astore_0
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 622	java/io/InputStream:close	()V
    //   138: aload_0
    //   139: astore_1
    //   140: aload_2
    //   141: ifnull +9 -> 150
    //   144: aload_2
    //   145: invokevirtual 622	java/io/InputStream:close	()V
    //   148: aload_0
    //   149: astore_1
    //   150: aload_1
    //   151: areturn
    //   152: aload_1
    //   153: invokestatic 619	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   156: astore_2
    //   157: aload_2
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_2
    //   161: goto -31 -> 130
    //   164: astore_1
    //   165: getstatic 40	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: ldc_w 624
    //   171: aload_1
    //   172: invokestatic 627	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload_0
    //   176: areturn
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_1
    //   180: aload 5
    //   182: astore_2
    //   183: getstatic 40	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   186: new 178	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 629
    //   196: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_3
    //   200: invokevirtual 630	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: aload_3
    //   210: invokestatic 627	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_0
    //   214: invokeinterface 634 1 0
    //   219: astore_0
    //   220: aload_0
    //   221: arraylength
    //   222: istore 7
    //   224: iconst_0
    //   225: istore 6
    //   227: iload 6
    //   229: iload 7
    //   231: if_icmpge +63 -> 294
    //   234: aload_0
    //   235: iload 6
    //   237: aaload
    //   238: astore_3
    //   239: getstatic 40	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   242: new 178	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 636
    //   252: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_3
    //   256: invokeinterface 637 1 0
    //   261: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc_w 639
    //   267: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_3
    //   271: invokeinterface 503 1 0
    //   276: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 400	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: iload 6
    //   287: iconst_1
    //   288: iadd
    //   289: istore 6
    //   291: goto -64 -> 227
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 622	java/io/InputStream:close	()V
    //   302: aload 4
    //   304: astore_1
    //   305: aload_2
    //   306: ifnull -156 -> 150
    //   309: aload_2
    //   310: invokevirtual 622	java/io/InputStream:close	()V
    //   313: ldc_w 482
    //   316: areturn
    //   317: astore_0
    //   318: getstatic 40	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: ldc_w 624
    //   324: aload_0
    //   325: invokestatic 627	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: ldc_w 482
    //   331: areturn
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_1
    //   335: aload_3
    //   336: astore_2
    //   337: aload_1
    //   338: ifnull +7 -> 345
    //   341: aload_1
    //   342: invokevirtual 622	java/io/InputStream:close	()V
    //   345: aload_2
    //   346: ifnull +7 -> 353
    //   349: aload_2
    //   350: invokevirtual 622	java/io/InputStream:close	()V
    //   353: aload_0
    //   354: athrow
    //   355: astore_1
    //   356: getstatic 40	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: ldc_w 624
    //   362: aload_1
    //   363: invokestatic 627	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   366: goto -13 -> 353
    //   369: astore_0
    //   370: aload_3
    //   371: astore_2
    //   372: goto -35 -> 337
    //   375: astore_0
    //   376: goto -39 -> 337
    //   379: astore_0
    //   380: goto -43 -> 337
    //   383: astore_3
    //   384: aload 5
    //   386: astore_2
    //   387: goto -204 -> 183
    //   390: astore_3
    //   391: goto -208 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	paramHttpResponse	HttpResponse
    //   16	137	1	localObject1	Object
    //   164	8	1	localException1	Exception
    //   179	163	1	str1	String
    //   355	8	1	localException2	Exception
    //   91	296	2	localObject2	Object
    //   1	128	3	str2	String
    //   177	33	3	localException3	Exception
    //   238	133	3	localObject3	Object
    //   383	1	3	localException4	Exception
    //   390	1	3	localException5	Exception
    //   8	295	4	str3	String
    //   3	382	5	localObject4	Object
    //   225	65	6	i	int
    //   222	10	7	j	int
    //   46	19	8	l	long
    // Exception table:
    //   from	to	target	type
    //   134	138	164	java/lang/Exception
    //   144	148	164	java/lang/Exception
    //   17	75	177	java/lang/Exception
    //   75	82	177	java/lang/Exception
    //   298	302	317	java/lang/Exception
    //   309	313	317	java/lang/Exception
    //   17	75	332	finally
    //   75	82	332	finally
    //   341	345	355	java/lang/Exception
    //   349	353	355	java/lang/Exception
    //   82	92	369	finally
    //   96	123	369	finally
    //   152	157	369	finally
    //   123	128	375	finally
    //   183	224	379	finally
    //   239	285	379	finally
    //   82	92	383	java/lang/Exception
    //   96	123	383	java/lang/Exception
    //   152	157	383	java/lang/Exception
    //   123	128	390	java/lang/Exception
  }
  
  protected static HttpClient a()
  {
    try
    {
      Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject).load(null, null);
      localObject = new wue((KeyStore)localObject);
      ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
      HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, true);
      ConnManagerParams.setTimeout(localBasicHttpParams, 10000L);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
      new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
      localObject = new DefaultHttpClient(localBasicHttpParams);
      ((HttpClient)localObject).getParams().setParameter("http.protocol.cookie-policy", "compatibility");
      ((HttpClient)localObject).getParams().setParameter("http.protocol.single-cookie-header", Boolean.valueOf(true));
      return (HttpClient)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new DefaultHttpClient();
  }
  
  public static HttpClient a(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new AsyncHttpClient.CustomSSLSocketFactory((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        int j = OpenConfig.a(CommonDataAdapter.a().a(), paramString1).a("Common_HttpConnectionTimeout");
        LogUtility.c("OpenConfig_agent", "config 3:Common_HttpConnectionTimeout     config_value:" + j + "   appid:" + paramString1 + "     url:" + paramString2);
        int i = j;
        if (j == 0) {
          i = 15000;
        }
        LogUtility.c("OpenConfig_agent", "config 3:Common_HttpConnectionTimeout     result_value:" + i + "   appid:" + paramString1 + "     url:" + paramString2);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
        j = OpenConfig.a(CommonDataAdapter.a().a(), paramString1).a("Common_SocketConnectionTimeout");
        LogUtility.c("OpenConfig_agent", "config 4:Common_SocketConnectionTimeout   config_value:" + j + "   appid:" + paramString1 + "     url:" + paramString2);
        i = j;
        if (j == 0) {
          i = 30000;
        }
        LogUtility.c("OpenConfig_agent", "config 4:Common_SocketConnectionTimeout   result_value:" + i + "   appid:" + paramString1 + "     url:" + paramString2);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, i);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(localBasicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        paramString1 = new SchemeRegistry();
        paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        paramString1.register(new Scheme("https", (SocketFactory)localObject, 443));
        paramString1 = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, paramString1), localBasicHttpParams);
        paramString2 = a(CommonDataAdapter.a().a());
        if (paramString2 != null)
        {
          paramString2 = new HttpHost(paramString2.jdField_a_of_type_JavaLangString, paramString2.jdField_a_of_type_Int);
          paramString1.getParams().setParameter("http.route.default-proxy", paramString2);
        }
        return paramString1;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  public static JSONObject a(String paramString)
  {
    String str = paramString;
    if (paramString.equals("false")) {
      str = "{value : false}";
    }
    paramString = str;
    if (str.equals("true")) {
      paramString = "{value : true}";
    }
    str = paramString;
    if (paramString.contains("allback(")) {
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    }
    return new JSONObject(str);
  }
  
  protected static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (paramString != null)
    {
      paramJSONObject = paramString.split("&");
      int j = paramJSONObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramString = paramJSONObject[i].split("=");
          if (paramString.length == 2) {}
          try
          {
            localJSONObject.put(URLDecoder.decode(paramString[0]), URLDecoder.decode(paramString[1]));
            i += 1;
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public static void a(HttpResponse paramHttpResponse)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "----setCookie");
    if (paramHttpResponse != null) {}
    for (Object localObject1 = paramHttpResponse.getHeaders("Set-Cookie");; localObject1 = null)
    {
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "----there are no cookies");
        return;
      }
      paramHttpResponse = "";
      int i = 0;
      Object localObject2;
      while (i < localObject1.length)
      {
        localObject2 = paramHttpResponse + localObject1[i].getValue();
        paramHttpResponse = (HttpResponse)localObject2;
        if (i != localObject1.length - 1) {
          paramHttpResponse = (String)localObject2 + "; ";
        }
        i += 1;
      }
      localObject1 = paramHttpResponse.split("; ");
      int j = localObject1.length;
      i = 0;
      label139:
      String str;
      if (i < j)
      {
        paramHttpResponse = localObject1[i].trim();
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramHttpResponse.split("=")[0])) {
          jdField_a_of_type_JavaUtilHashMap.remove(paramHttpResponse.split("=")[0]);
        }
        localObject2 = jdField_a_of_type_JavaUtilHashMap;
        str = paramHttpResponse.split("=")[0];
        if (paramHttpResponse.split("=").length != 1) {
          break label230;
        }
        paramHttpResponse = "";
      }
      for (;;)
      {
        ((HashMap)localObject2).put(str, paramHttpResponse);
        i += 1;
        break label139;
        break;
        label230:
        if (paramHttpResponse.split("=").length == 2) {
          paramHttpResponse = paramHttpResponse.split("=")[1];
        } else {
          paramHttpResponse = paramHttpResponse.split("=", 2)[1];
        }
      }
    }
  }
  
  public static String b()
  {
    jdField_a_of_type_JavaUtilHashMap.put("uin", b(String.valueOf(CommonDataAdapter.a().a())));
    jdField_a_of_type_JavaUtilHashMap.put("skey", CommonDataAdapter.a().a());
    jdField_a_of_type_JavaUtilHashMap.put("qua", CommonDataAdapter.a().e());
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + "=" + (String)jdField_a_of_type_JavaUtilHashMap.get(str2) + "; ") {
      str2 = (String)localIterator.next();
    }
    return str1;
  }
  
  public static String b(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 10)
      {
        localObject = new StringBuilder("o");
        int i = paramString.length();
        while (i < 10)
        {
          ((StringBuilder)localObject).append("0");
          i += 1;
        }
        localObject = paramString;
      }
    }
    else {
      return (String)localObject;
    }
    return "o" + paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\http\HttpBaseUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */