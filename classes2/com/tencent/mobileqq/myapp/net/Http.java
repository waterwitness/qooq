package com.tencent.mobileqq.myapp.net;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import tgy;

public class Http
{
  public static final int a = 15000;
  private static final Uri a;
  public static final String a = "POST";
  public static ThreadSafeClientConnManager a;
  public static final int b = 30000;
  public static final String b = "GET";
  public static final int c = 5120;
  public static final String c = "ctnet";
  public static final String d = "ctwap";
  public static final String e = "cmnet";
  public static final String f = "cmwap";
  public static final String g = "uninet";
  public static final String h = "uniwap";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
  }
  
  public static String a()
  {
    String str = null;
    Object localObject = BaseApplication.getContext();
    int i;
    if (localObject == null)
    {
      str = android.net.Proxy.getDefaultHost();
      i = android.net.Proxy.getDefaultPort();
    }
    for (;;)
    {
      if ((str != null) && (str.trim().length() > 0))
      {
        return str + ":" + i;
        NetworkInfo localNetworkInfo = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo != null)
        {
          if (NetworkUtil.a(localNetworkInfo))
          {
            str = android.net.Proxy.getHost((Context)localObject);
            int j = android.net.Proxy.getPort((Context)localObject);
            if ((str != null) && (str.trim().length() != 0))
            {
              i = j;
              if (j > 0) {
                continue;
              }
            }
            str = android.net.Proxy.getDefaultHost();
            j = android.net.Proxy.getDefaultPort();
            if ((str != null) && (str.trim().length() != 0))
            {
              i = j;
              if (j > 0) {
                continue;
              }
            }
            localObject = a();
            str = ((tgy)localObject).jdField_a_of_type_JavaLangString;
            i = ((tgy)localObject).jdField_a_of_type_Int;
            continue;
          }
          return null;
        }
      }
      else
      {
        return "";
      }
      i = 0;
    }
  }
  
  public static HttpURLConnection a(String paramString)
  {
    paramString = a(new URL(paramString));
    paramString.setConnectTimeout(15000);
    paramString.setReadTimeout(30000);
    return paramString;
  }
  
  public static HttpURLConnection a(URL paramURL)
  {
    InetSocketAddress localInetSocketAddress = a();
    if (localInetSocketAddress == null) {
      return (HttpURLConnection)paramURL.openConnection();
    }
    return (HttpURLConnection)paramURL.openConnection(new java.net.Proxy(Proxy.Type.HTTP, localInetSocketAddress));
  }
  
  public static InetSocketAddress a()
  {
    Object localObject2 = null;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str;
    int i;
    if (localBaseApplication == null)
    {
      str = android.net.Proxy.getDefaultHost();
      i = android.net.Proxy.getDefaultPort();
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (str.trim().length() > 0) {
          localObject1 = new InetSocketAddress(str, i);
        }
      }
      do
      {
        return (InetSocketAddress)localObject1;
        localObject1 = localObject2;
      } while (!AppNetConnInfo.isMobileConn());
      str = android.net.Proxy.getHost(localBaseApplication);
      int j = android.net.Proxy.getPort(localBaseApplication);
      if ((str != null) && (str.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        str = android.net.Proxy.getDefaultHost();
        j = android.net.Proxy.getDefaultPort();
        if ((str != null) && (str.trim().length() != 0))
        {
          i = j;
          if (j > 0) {}
        }
        else
        {
          localObject1 = a();
          str = ((tgy)localObject1).jdField_a_of_type_JavaLangString;
          i = ((tgy)localObject1).jdField_a_of_type_Int;
        }
      }
    }
  }
  
  public static HttpEntity a(String paramString1, byte[] paramArrayOfByte, String paramString2, BasicHeader[] paramArrayOfBasicHeader)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 15000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    if (paramString2.equals("POST"))
    {
      paramString1 = new HttpPost(paramString1);
      paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
      ((HttpPost)paramString1).setEntity(paramArrayOfByte);
      paramArrayOfByte = paramString1;
    }
    int j;
    int i;
    while (paramArrayOfBasicHeader != null)
    {
      j = paramArrayOfBasicHeader.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfByte.addHeader(paramArrayOfBasicHeader[i]);
        i += 1;
      }
      if (paramArrayOfByte != null) {
        paramArrayOfByte = new HttpGet(paramString1 + "?" + new String(paramArrayOfByte));
      } else {
        paramArrayOfByte = new HttpGet(paramString1);
      }
    }
    if (jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager == null)
    {
      paramString1 = new SchemeRegistry();
      paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      paramString1.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager = new ThreadSafeClientConnManager(localBasicHttpParams, paramString1);
    }
    paramString2 = new DefaultHttpClient(jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager, localBasicHttpParams);
    if (a() != null)
    {
      android.net.Proxy.getDefaultHost();
      android.net.Proxy.getDefaultPort();
      paramArrayOfBasicHeader = BaseApplication.getContext();
      if (paramArrayOfBasicHeader != null) {
        break label364;
      }
      paramString1 = android.net.Proxy.getDefaultHost();
      i = android.net.Proxy.getDefaultPort();
    }
    for (;;)
    {
      if ((paramString1 != null) && (paramString1.trim().length() != 0))
      {
        j = i;
        if (i > 0) {}
      }
      else
      {
        paramArrayOfBasicHeader = a();
        paramString1 = paramArrayOfBasicHeader.jdField_a_of_type_JavaLangString;
        j = paramArrayOfBasicHeader.jdField_a_of_type_Int;
      }
      paramString1 = new HttpHost(paramString1, j);
      paramString2.getParams().setParameter("http.route.default-proxy", paramString1);
      paramString1 = paramString2.execute(paramArrayOfByte);
      i = paramString1.getStatusLine().getStatusCode();
      if (i == 200) {
        break;
      }
      throw new HttpResponseException(i);
      label364:
      paramString1 = android.net.Proxy.getHost(paramArrayOfBasicHeader);
      j = android.net.Proxy.getPort(paramArrayOfBasicHeader);
      if ((paramString1 != null) && (paramString1.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        paramString1 = android.net.Proxy.getDefaultHost();
        i = android.net.Proxy.getDefaultPort();
      }
    }
    return paramString1.getEntity();
  }
  
  private static tgy a()
  {
    Object localObject1 = BaseApplication.getContext();
    tgy localtgy = new tgy();
    try
    {
      String str1;
      String str2;
      String str3;
      try
      {
        localObject1 = ((Context)localObject1).getContentResolver().query(jdField_a_of_type_AndroidNetUri, null, null, null, null);
        ((Cursor)localObject1).moveToFirst();
        str1 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("proxy"));
        if (str1 != null) {
          str1.toLowerCase();
        }
        str2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("port"));
        str3 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("apn"));
        if (str3 != null) {
          str3.toLowerCase();
        }
        ((Cursor)localObject1).close();
        if ((str3 != null) && (str3.startsWith("ctwap"))) {
          if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
          {
            localtgy.jdField_a_of_type_JavaLangString = str1;
            localtgy.jdField_a_of_type_Int = Integer.valueOf(str2).intValue();
          }
          else
          {
            localtgy.jdField_a_of_type_JavaLangString = "10.0.0.200";
            localtgy.jdField_a_of_type_Int = 80;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localtgy;
      }
      if ((str3 != null) && (str3.startsWith("cmwap")))
      {
        if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
        {
          localtgy.jdField_a_of_type_JavaLangString = str1;
          localtgy.jdField_a_of_type_Int = Integer.valueOf(str2).intValue();
        }
        else
        {
          localtgy.jdField_a_of_type_JavaLangString = "10.0.0.172";
          localtgy.jdField_a_of_type_Int = 80;
        }
      }
      else if ((str3 != null) && (str3.startsWith("uniwap"))) {
        if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
        {
          localtgy.jdField_a_of_type_JavaLangString = str1;
          localtgy.jdField_a_of_type_Int = Integer.valueOf(str2).intValue();
        }
        else
        {
          localtgy.jdField_a_of_type_JavaLangString = "10.0.0.172";
          localtgy.jdField_a_of_type_Int = 80;
        }
      }
      return localtgy;
    }
    finally {}
    return localtgy;
  }
  
  public static byte[] a(String paramString)
  {
    paramString = a(new URL(paramString));
    paramString.setConnectTimeout(15000);
    paramString.setReadTimeout(30000);
    return a(paramString, paramString.getInputStream());
  }
  
  public static byte[] a(String paramString1, byte[] paramArrayOfByte, String paramString2, BasicHeader[] paramArrayOfBasicHeader)
  {
    paramString1 = a(paramString1, paramArrayOfByte, paramString2, paramArrayOfBasicHeader);
    paramArrayOfByte = EntityUtils.toByteArray(paramString1);
    paramString1.consumeContent();
    return paramArrayOfByte;
  }
  
  private static byte[] a(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
  {
    paramHttpURLConnection = new byte[paramHttpURLConnection.getContentLength()];
    byte[] arrayOfByte = new byte['᐀'];
    if (paramInputStream != null)
    {
      int i = 0;
      for (;;)
      {
        int j = paramInputStream.read(arrayOfByte);
        if (j == -1) {
          break;
        }
        System.arraycopy(arrayOfByte, 0, paramHttpURLConnection, i, j);
        i += j;
      }
      paramInputStream.close();
    }
    return paramHttpURLConnection;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\myapp\net\Http.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */