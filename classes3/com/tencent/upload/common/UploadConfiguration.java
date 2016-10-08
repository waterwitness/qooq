package com.tencent.upload.common;

import android.content.Context;
import android.net.Proxy;
import com.tencent.upload.a.b;
import com.tencent.upload.network.b.e;
import com.tencent.upload.network.b.g;
import com.tencent.upload.network.b.h;
import com.tencent.upload.network.b.i;
import com.tencent.upload.network.b.j;
import com.tencent.upload.network.b.k;
import com.tencent.upload.network.b.l;
import com.tencent.upload.network.b.m;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.Utility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class UploadConfiguration
{
  public static final HashMap<String, Integer> UPLOAD_IP_TIMEOUT_MAP = new HashMap();
  public static final boolean USE_HTTP_PROTOCOL_FOR_OTHER_ROUTE_STRATEGY = false;
  public static final boolean USE_HTTP_PROTOCOL_FOR_PICTURE_ROUTE_STRATEGY = false;
  public static final boolean USE_REDIRECT_ROUTE_IN_HANDSHAKE_RESPONSE = false;
  private static final int[] a = { 1440, 1200, 700 };
  private static volatile long[] b;
  
  private static final boolean a(int paramInt)
  {
    if (!f.e().isAvailable()) {}
    do
    {
      do
      {
        return false;
        if (paramInt == 0) {
          return true;
        }
      } while (paramInt == 1);
      if (paramInt != 2) {
        break;
      }
    } while (f.e().isWifi());
    return true;
    return true;
  }
  
  public static final void addUploadIpTimeouts(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!isWifiSetting()) {
      return;
    }
    synchronized (UPLOAD_IP_TIMEOUT_MAP)
    {
      Integer localInteger2 = (Integer)UPLOAD_IP_TIMEOUT_MAP.get(paramString);
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      localInteger2 = Integer.valueOf(localInteger1.intValue() + 1);
      localInteger1 = localInteger2;
      if (localInteger2.intValue() < 0) {
        localInteger1 = Integer.valueOf(0);
      }
      UPLOAD_IP_TIMEOUT_MAP.put(paramString, localInteger1);
      b.b("Configuration", "put timeout ip: " + paramString + "," + localInteger1);
      return;
    }
  }
  
  public static final void checkVaildConnection(Context paramContext, Long paramLong, String paramString)
  {
    Utility.keepLongConnection(paramContext, paramLong, paramString);
  }
  
  public static final com.tencent.upload.network.b.d createRouteStrategy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new g();
    case 1: 
      return new com.tencent.upload.network.b.f();
    }
    return new e();
  }
  
  public static final com.tencent.upload.network.b.d createTestRouteStrategy(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 0: 
      return new l(paramInt2);
    case 1: 
      return new k(paramInt2);
    }
    return new j(paramInt2);
  }
  
  public static final m getBackupRoute(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 3)) {}
    label223:
    label225:
    label228:
    for (;;)
    {
      return null;
      Object localObject = f.b();
      if (localObject != null)
      {
        if (paramInt == 0) {
          localObject = ((IUploadConfig)localObject).getBackupIp1();
        }
        for (;;)
        {
          if (localObject == null) {
            break label228;
          }
          int i = getCurrentOperatorCategory();
          int j;
          if (i == 4)
          {
            j = getWifiOperatorCategory();
            b.c("Configuration", "getBackupRoute:" + paramInt + " currentOperatorCategory:" + i + " wifiOperatorCategory:" + j + " " + (String)localObject);
          }
          for (localObject = jsonToUploadRoute((String)localObject, j, 2);; localObject = jsonToUploadRoute((String)localObject, i, 2))
          {
            if (localObject == null) {
              break label223;
            }
            ((m)localObject).a(5);
            b.c("Configuration", "getBackupRoute:" + paramInt + " " + ((m)localObject).toString());
            return (m)localObject;
            if (paramInt == 1)
            {
              localObject = ((IUploadConfig)localObject).getBackupIp2();
              break;
            }
            if (paramInt != 2) {
              break label225;
            }
            localObject = ((IUploadConfig)localObject).getMobileLogBackupIp();
            break;
            b.c("Configuration", "getBackupRoute:" + paramInt + " currentOperatorCategory:" + i + " " + (String)localObject);
          }
          break;
          localObject = null;
        }
      }
    }
  }
  
  public static final int getConnectionTimeout()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getConnectTimeout() * 1000;
    }
    return 20000;
  }
  
  public static final String getCurrentApn()
  {
    return f.e().getApnName();
  }
  
  public static int getCurrentNetworkCategory()
  {
    return f.e().getCurrentNetworkCategory();
  }
  
  public static final int getCurrentOperatorCategory()
  {
    if (f.e().isMobile()) {
      return f.e().getMobileOperatorCategory();
    }
    if (f.e().isWifi()) {
      return getWifiOperatorCategory();
    }
    return 0;
  }
  
  public static final long getCurrentUin()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getCurrentUin();
    }
    return 0L;
  }
  
  public static final int getDataTimeout()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getDataTimeout() * 1000;
    }
    return 60000;
  }
  
  public static final int getDoNotFragment()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {
      return 1;
    }
    return localIUploadConfig.getDoNotFragment();
  }
  
  public static final int getDomainNameParseTimeout()
  {
    return 20000;
  }
  
  public static final String getExifTagCode(String paramString)
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {
      return null;
    }
    return localIUploadConfig.getExifTagCode(paramString);
  }
  
  public static final m getHostRoute(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 3)) {}
    for (;;)
    {
      return null;
      Object localObject = f.b();
      if (localObject != null)
      {
        String str;
        if (paramInt == 0)
        {
          str = ((IUploadConfig)localObject).getPhotoUrl1();
          localObject = str;
          if (str == null) {
            localObject = "qzfileup.qq.com";
          }
        }
        while (localObject != null)
        {
          localObject = new m((String)localObject, 80, 4);
          b.c("Configuration", "getHostRoute:" + paramInt + " " + ((m)localObject).toString());
          return (m)localObject;
          if (paramInt == 1)
          {
            str = ((IUploadConfig)localObject).getPhotoUrl2();
            localObject = str;
            if (str == null) {
              localObject = "up.upqzfile.com";
            }
          }
          else if (paramInt == 2)
          {
            str = ((IUploadConfig)localObject).getMobileLogUrl();
            localObject = str;
            if (str == null) {
              localObject = "mobilelog.upqzfile.com";
            }
          }
          else
          {
            localObject = null;
          }
        }
      }
    }
  }
  
  public static final int getMaxSegmentSize(String paramString)
  {
    int i;
    if (!isWifiSetting()) {
      i = -1;
    }
    for (;;)
    {
      return i;
      synchronized (UPLOAD_IP_TIMEOUT_MAP)
      {
        localInteger = (Integer)UPLOAD_IP_TIMEOUT_MAP.get(paramString);
        ??? = localInteger;
        if (localInteger == null) {
          ??? = Integer.valueOf(0);
        }
        b.b("Configuration", "get timeout ip: " + paramString + "," + ???);
        paramString = f.b();
        if (paramString == null) {
          return a[(???.intValue() % a.length)];
        }
      }
      Integer localInteger = null;
      try
      {
        String str = paramString.getMaxSegmentSizeArray();
        paramString = localInteger;
        if (str != null)
        {
          paramString = localInteger;
          if (str.length() > 0) {
            paramString = str.split("\\|");
          }
        }
        if ((paramString == null) || (paramString.length == 0)) {
          return a[(???.intValue() % a.length)];
        }
      }
      catch (PatternSyntaxException paramString)
      {
        for (;;)
        {
          b.d("Configuration", paramString.toString());
          paramString = localInteger;
        }
        paramString = paramString[(???.intValue() % paramString.length)];
        try
        {
          int j = Integer.parseInt(paramString);
          i = j;
          if (j < 64) {
            return 64;
          }
        }
        catch (NumberFormatException paramString)
        {
          b.d("Configuration", paramString.toString());
        }
      }
    }
    return a[(???.intValue() % a.length)];
  }
  
  public static final int getMaxSessionPacketSize()
  {
    return 2097152;
  }
  
  public static final int getNdkSendDataSize()
  {
    return 184320;
  }
  
  public static final m getOptimumRoute(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 3)) {}
    label158:
    for (;;)
    {
      return null;
      Object localObject = f.b();
      if (localObject != null)
      {
        if (paramInt == 0) {
          localObject = ((IUploadConfig)localObject).getOptimumIp1();
        }
        for (;;)
        {
          if (localObject == null) {
            break label158;
          }
          int i = getCurrentOperatorCategory();
          b.c("Configuration", "getOptimumRoute:" + paramInt + " currentOperatorCategory:" + i + (String)localObject);
          localObject = jsonToUploadRoute((String)localObject, i, 0);
          if (localObject == null) {
            break;
          }
          ((m)localObject).a(1);
          b.c("Configuration", "getOptimumRoute:" + paramInt + " " + ((m)localObject).toString());
          return (m)localObject;
          if (paramInt == 1) {
            localObject = ((IUploadConfig)localObject).getOptimumIp2();
          } else if (paramInt == 2) {
            localObject = ((IUploadConfig)localObject).getOptimumIpMobileLog();
          } else {
            localObject = null;
          }
        }
      }
    }
  }
  
  public static final int getPictureQuality(String paramString)
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {
      return 0;
    }
    return (int)localIUploadConfig.getPictureQuality(paramString);
  }
  
  public static final String getProviderName()
  {
    return f.e().getProviderName();
  }
  
  public static final String getRecentRouteApnKey()
  {
    if (f.e().isMobile()) {
      return f.e().getApnName();
    }
    if (f.e().isWifi()) {
      return f.e().getBSSID();
    }
    return null;
  }
  
  public static final long getRecentRouteExpire()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {
      return 604800000L;
    }
    return localIUploadConfig.getRecentRouteExpire();
  }
  
  public static int getResendCount()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {
      return 3;
    }
    return localIUploadConfig.getResendCount();
  }
  
  public static final int getTestRouteServer()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {
      return 0;
    }
    return localIUploadConfig.getTestServer();
  }
  
  public static final List<Integer> getUploadRoutePorts()
  {
    Object localObject1 = f.b();
    if (localObject1 == null) {
      localObject1 = Arrays.asList(new Integer[] { Integer.valueOf(80), Integer.valueOf(443), Integer.valueOf(8080), Integer.valueOf(14000) });
    }
    for (;;)
    {
      return (List<Integer>)localObject1;
      localObject1 = ((IUploadConfig)localObject1).getUploadPort();
      if (localObject1 == null) {
        return Arrays.asList(new Integer[] { Integer.valueOf(80), Integer.valueOf(443), Integer.valueOf(8080), Integer.valueOf(14000) });
      }
      String[] arrayOfString;
      try
      {
        arrayOfString = ((String)localObject1).split(",");
        if (arrayOfString == null) {
          return Arrays.asList(new Integer[] { Integer.valueOf(80), Integer.valueOf(443), Integer.valueOf(8080), Integer.valueOf(14000) });
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        b.d("Configuration", localNullPointerException.toString());
        return Arrays.asList(new Integer[] { Integer.valueOf(80), Integer.valueOf(443), Integer.valueOf(8080), Integer.valueOf(14000) });
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        b.d("Configuration", localPatternSyntaxException.toString());
        return Arrays.asList(new Integer[] { Integer.valueOf(80), Integer.valueOf(443), Integer.valueOf(8080), Integer.valueOf(14000) });
      }
      ArrayList localArrayList = new ArrayList(arrayOfString.length);
      try
      {
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          Object localObject2 = localArrayList;
          if (i >= j) {
            break;
          }
          localArrayList.add(Integer.valueOf(Integer.parseInt(arrayOfString[i])));
          i += 1;
        }
        return Arrays.asList(tmp352_343);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        b.d("Configuration", localNumberFormatException.toString());
      }
    }
  }
  
  public static final List<m> getUploadRoutes(int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= 3)) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return (List<m>)localObject;
        localArrayList = new ArrayList();
        localObject = getOptimumRoute(paramInt);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        m localm = getHostRoute(paramInt);
        if (localm != null) {
          localArrayList.add(localm);
        }
        localm = getBackupRoute(paramInt);
        if ((localm != null) && ((localObject == null) || (!((m)localObject).b().equals(localm.b())) || (!d.b(((m)localObject).b())))) {
          localArrayList.add(localm);
        }
        localObject = localArrayList;
      } while (localArrayList.size() != 0);
      if (paramInt == 0)
      {
        localArrayList.add(new m("qzfileup.qq.com", 80, 4));
        localArrayList.add(new m("qzfileup.qq.com", 80, 5));
        return localArrayList;
      }
      if (paramInt == 1)
      {
        localArrayList.add(new m("up.upqzfile.com", 80, 4));
        localArrayList.add(new m("up.upqzfilebk.com", 80, 5));
        return localArrayList;
      }
      localObject = localArrayList;
    } while (paramInt != 2);
    localArrayList.add(new m("mobilelog.upqzfile.com", 80, 4));
    localArrayList.add(new m("mobilelog.upqzfilebk.com", 80, 5));
    return localArrayList;
  }
  
  public static final long[] getUploadServerTimePair()
  {
    return b;
  }
  
  public static final int getVideoFileRetryCount()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {}
    int i;
    do
    {
      return 5;
      i = localIUploadConfig.getVideoFileRetryCount();
    } while (i < 5);
    return i;
  }
  
  public static final int getVideoPartConcurrentCount()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getVideoPartConcurrentCount();
    }
    return 2;
  }
  
  public static final int getVideoPartRetryCount()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {}
    int i;
    do
    {
      return 3;
      i = localIUploadConfig.getVideoPartRetryCount();
    } while (i < 3);
    return i;
  }
  
  public static final int getVideoPartSizeByNetworkSetting()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getVideoPartSize();
    }
    return 262144;
  }
  
  public static final int getWifiOperatorCategory()
  {
    IUploadConfig localIUploadConfig = f.b();
    if (localIUploadConfig == null) {
      return 0;
    }
    switch (localIUploadConfig.getWifiOperator())
    {
    case 4: 
    case 6: 
    case 7: 
    default: 
      return 0;
    case 3: 
      return 3;
    case 8: 
      return 1;
    }
    return 2;
  }
  
  public static final boolean isMobileSetting()
  {
    return f.e().isMobile();
  }
  
  public static final boolean isNetworkAvailable()
  {
    return f.e().isAvailable();
  }
  
  public static final boolean isWapSetting()
  {
    return f.e().isWap();
  }
  
  public static final boolean isWifiSetting()
  {
    return f.e().isWifi();
  }
  
  public static final m jsonToUploadRoute(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() <= 0)) {
      localObject = null;
    }
    do
    {
      return (m)localObject;
      try
      {
        localJSONArray = new JSONObject(paramString).getJSONArray("ips");
        j = localJSONArray.length();
        i = 0;
        paramString = null;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          JSONArray localJSONArray;
          int j;
          int i;
          JSONObject localJSONObject;
          int k;
          b.d("Configuration", paramString.toString());
          return null;
          localObject = paramString;
          if (paramInt2 == k)
          {
            localObject = paramString;
            if (paramString == null) {
              localObject = new m(localJSONObject.getString("ip"), localJSONObject.getInt("port"), 1);
            }
          }
          i += 1;
          paramString = (String)localObject;
        }
      }
      catch (NumberFormatException paramString)
      {
        b.d("Configuration", paramString.toString());
      }
      localObject = paramString;
    } while (i >= j);
    localJSONObject = localJSONArray.getJSONObject(i);
    k = Integer.parseInt(localJSONObject.getString("apn"));
    if (paramInt1 == k)
    {
      paramString = new m(localJSONObject.getString("ip"), localJSONObject.getInt("port"), 1);
      return paramString;
    }
    return null;
  }
  
  /* Error */
  public static boolean openSessionTest()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 419	java/net/URL
    //   8: dup
    //   9: ldc_w 421
    //   12: invokespecial 422	java/net/URL:<init>	(Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 426	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 428	java/net/HttpURLConnection
    //   23: astore_0
    //   24: aload_0
    //   25: sipush 4000
    //   28: invokevirtual 431	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   31: aload_0
    //   32: sipush 5000
    //   35: invokevirtual 434	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   38: aload_0
    //   39: ldc_w 436
    //   42: invokevirtual 439	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: ldc_w 441
    //   49: ldc_w 443
    //   52: invokevirtual 446	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: iconst_1
    //   57: invokevirtual 450	java/net/HttpURLConnection:setDoInput	(Z)V
    //   60: aload_0
    //   61: invokevirtual 453	java/net/HttpURLConnection:connect	()V
    //   64: aload_0
    //   65: invokevirtual 457	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   68: pop
    //   69: aload_2
    //   70: invokevirtual 460	java/net/URL:getHost	()Ljava/lang/String;
    //   73: aload_0
    //   74: invokevirtual 464	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   77: invokevirtual 460	java/net/URL:getHost	()Ljava/lang/String;
    //   80: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne +45 -> 128
    //   86: ldc 84
    //   88: new 86	java/lang/StringBuilder
    //   91: dup
    //   92: ldc_w 466
    //   95: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: invokevirtual 464	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   102: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 259	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: iconst_2
    //   112: invokestatic 468	com/tencent/upload/common/UploadConfiguration:a	(I)Z
    //   115: istore 6
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 471	java/net/HttpURLConnection:disconnect	()V
    //   125: iload 6
    //   127: ireturn
    //   128: aload_0
    //   129: invokevirtual 474	java/net/HttpURLConnection:getResponseCode	()I
    //   132: istore 5
    //   134: ldc 84
    //   136: new 86	java/lang/StringBuilder
    //   139: dup
    //   140: ldc_w 476
    //   143: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: iload 5
    //   148: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 259	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: iload 5
    //   159: sipush 200
    //   162: if_icmpeq +20 -> 182
    //   165: iconst_1
    //   166: invokestatic 468	com/tencent/upload/common/UploadConfiguration:a	(I)Z
    //   169: istore 6
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 471	java/net/HttpURLConnection:disconnect	()V
    //   179: iload 6
    //   181: ireturn
    //   182: aload_0
    //   183: invokevirtual 480	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   186: astore_3
    //   187: aload_3
    //   188: aconst_null
    //   189: invokestatic 486	com/tencent/imageservice/BitmapUtils:getOptions	()Landroid/graphics/BitmapFactory$Options;
    //   192: invokestatic 492	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   195: astore_2
    //   196: aload_2
    //   197: ifnull +42 -> 239
    //   200: iconst_0
    //   201: invokestatic 468	com/tencent/upload/common/UploadConfiguration:a	(I)Z
    //   204: istore 6
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 497	android/graphics/Bitmap:recycle	()V
    //   214: aload_3
    //   215: ifnull +7 -> 222
    //   218: aload_3
    //   219: invokevirtual 502	java/io/InputStream:close	()V
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 471	java/net/HttpURLConnection:disconnect	()V
    //   230: iload 6
    //   232: ireturn
    //   233: astore_1
    //   234: aconst_null
    //   235: astore_2
    //   236: goto -40 -> 196
    //   239: iconst_1
    //   240: invokestatic 468	com/tencent/upload/common/UploadConfiguration:a	(I)Z
    //   243: istore 6
    //   245: aload_2
    //   246: ifnull +7 -> 253
    //   249: aload_2
    //   250: invokevirtual 497	android/graphics/Bitmap:recycle	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 502	java/io/InputStream:close	()V
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 471	java/net/HttpURLConnection:disconnect	()V
    //   269: iload 6
    //   271: ireturn
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_2
    //   275: aconst_null
    //   276: astore_3
    //   277: iconst_1
    //   278: invokestatic 468	com/tencent/upload/common/UploadConfiguration:a	(I)Z
    //   281: istore 7
    //   283: aload_2
    //   284: ifnull +7 -> 291
    //   287: aload_2
    //   288: invokevirtual 497	android/graphics/Bitmap:recycle	()V
    //   291: aload_3
    //   292: ifnull +7 -> 299
    //   295: aload_3
    //   296: invokevirtual 502	java/io/InputStream:close	()V
    //   299: iload 7
    //   301: istore 6
    //   303: aload_1
    //   304: ifnull -179 -> 125
    //   307: aload_1
    //   308: invokevirtual 471	java/net/HttpURLConnection:disconnect	()V
    //   311: iload 7
    //   313: ireturn
    //   314: astore_0
    //   315: aconst_null
    //   316: astore_2
    //   317: aconst_null
    //   318: astore_3
    //   319: aload 4
    //   321: astore_1
    //   322: aload_2
    //   323: ifnull +7 -> 330
    //   326: aload_2
    //   327: invokevirtual 497	android/graphics/Bitmap:recycle	()V
    //   330: aload_3
    //   331: ifnull +7 -> 338
    //   334: aload_3
    //   335: invokevirtual 502	java/io/InputStream:close	()V
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 471	java/net/HttpURLConnection:disconnect	()V
    //   346: aload_0
    //   347: athrow
    //   348: astore_1
    //   349: goto -127 -> 222
    //   352: astore_1
    //   353: goto -92 -> 261
    //   356: astore_0
    //   357: goto -58 -> 299
    //   360: astore_2
    //   361: goto -23 -> 338
    //   364: astore_1
    //   365: aconst_null
    //   366: astore_3
    //   367: aconst_null
    //   368: astore 4
    //   370: aload_0
    //   371: astore_2
    //   372: aload_1
    //   373: astore_0
    //   374: aload_2
    //   375: astore_1
    //   376: aload 4
    //   378: astore_2
    //   379: goto -57 -> 322
    //   382: astore 4
    //   384: aconst_null
    //   385: astore_2
    //   386: aload_0
    //   387: astore_1
    //   388: aload 4
    //   390: astore_0
    //   391: goto -69 -> 322
    //   394: astore 4
    //   396: aload_0
    //   397: astore_1
    //   398: aload 4
    //   400: astore_0
    //   401: goto -79 -> 322
    //   404: astore_0
    //   405: goto -83 -> 322
    //   408: astore_1
    //   409: aconst_null
    //   410: astore_2
    //   411: aconst_null
    //   412: astore_3
    //   413: aload_0
    //   414: astore_1
    //   415: goto -138 -> 277
    //   418: astore_1
    //   419: aconst_null
    //   420: astore_2
    //   421: aload_0
    //   422: astore_1
    //   423: goto -146 -> 277
    //   426: astore_1
    //   427: aload_0
    //   428: astore_1
    //   429: goto -152 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	243	0	localHttpURLConnection	java.net.HttpURLConnection
    //   272	1	0	localThrowable1	Throwable
    //   314	33	0	localObject1	Object
    //   356	15	0	localIOException1	java.io.IOException
    //   373	28	0	localObject2	Object
    //   404	24	0	localObject3	Object
    //   4	1	1	localObject4	Object
    //   233	75	1	localException	Exception
    //   321	22	1	localObject5	Object
    //   348	1	1	localIOException2	java.io.IOException
    //   352	1	1	localIOException3	java.io.IOException
    //   364	9	1	localObject6	Object
    //   375	23	1	localObject7	Object
    //   408	1	1	localThrowable2	Throwable
    //   414	1	1	localObject8	Object
    //   418	1	1	localThrowable3	Throwable
    //   422	1	1	localObject9	Object
    //   426	1	1	localThrowable4	Throwable
    //   428	1	1	localObject10	Object
    //   15	312	2	localObject11	Object
    //   360	1	2	localIOException4	java.io.IOException
    //   371	50	2	localObject12	Object
    //   186	227	3	localInputStream	java.io.InputStream
    //   1	376	4	localObject13	Object
    //   382	7	4	localObject14	Object
    //   394	5	4	localObject15	Object
    //   132	31	5	i	int
    //   115	187	6	bool1	boolean
    //   281	31	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   187	196	233	java/lang/Exception
    //   5	24	272	java/lang/Throwable
    //   5	24	314	finally
    //   218	222	348	java/io/IOException
    //   257	261	352	java/io/IOException
    //   295	299	356	java/io/IOException
    //   334	338	360	java/io/IOException
    //   24	117	364	finally
    //   128	157	364	finally
    //   165	171	364	finally
    //   182	187	364	finally
    //   187	196	382	finally
    //   200	206	394	finally
    //   239	245	394	finally
    //   277	283	404	finally
    //   24	117	408	java/lang/Throwable
    //   128	157	408	java/lang/Throwable
    //   165	171	408	java/lang/Throwable
    //   182	187	408	java/lang/Throwable
    //   187	196	418	java/lang/Throwable
    //   200	206	426	java/lang/Throwable
    //   239	245	426	java/lang/Throwable
  }
  
  public static final void registerNetworkStateObserver(NetworkStateObserver paramNetworkStateObserver)
  {
    if (paramNetworkStateObserver == null) {
      return;
    }
    f.e().registerNetworkStateObserver(paramNetworkStateObserver);
  }
  
  public static final h saveAsRecentIp(int paramInt, String paramString, m paramm)
  {
    i locali = new i(paramInt);
    h localh2 = locali.a(paramString);
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      localh1.a(System.currentTimeMillis());
    }
    paramm = paramm.h();
    paramm.a(3);
    localh1.a(paramm);
    locali.a(paramString, localh1);
    return localh1;
  }
  
  public static final void setRouteProxy(m paramm)
  {
    if (paramm == null) {
      return;
    }
    paramm.a(Proxy.getDefaultHost(), Proxy.getDefaultPort());
  }
  
  public static final void setUploadServerTimePair(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length != 2)) {
      return;
    }
    b = paramArrayOfLong;
  }
  
  public static final class NetworkCategory
  {
    public static final int MOBILE_2G = 3;
    public static final int MOBILE_3G = 2;
    public static final int MOBILE_4G = 4;
    public static final int UNKNOWN = 0;
    public static final int WIFI = 1;
  }
  
  public static abstract class NetworkStateObserver
  {
    public abstract void onStateChanged(boolean paramBoolean);
  }
  
  public static final class OperatorCategory
  {
    public static final int CMCC = 1;
    public static final int CMCT = 3;
    public static final int UNICOM = 2;
    public static final int UNKNOW = 0;
    public static final int WIFI = 4;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\common\UploadConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */