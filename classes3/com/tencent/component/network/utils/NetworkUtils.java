package com.tencent.component.network.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.network.downloader.common.a;
import java.util.HashMap;

public class NetworkUtils
{
  public static final String APN_NAME_WIFI = "wifi";
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  private static final HashMap<String, NetworkProxy> b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put("cmwap", new NetworkProxy("10.0.0.172", 80));
    b.put("3gwap", new NetworkProxy("10.0.0.172", 80));
    b.put("uniwap", new NetworkProxy("10.0.0.172", 80));
    b.put("ctwap", new NetworkProxy("10.0.0.200", 80));
  }
  
  private static int a()
  {
    if (PlatformUtil.version() < 11) {}
    for (int i = Proxy.getDefaultPort();; i = -1) {
      for (;;)
      {
        int j;
        if (i >= 0)
        {
          j = i;
          if (i <= 65535) {}
        }
        else
        {
          j = -1;
        }
        return j;
        String str = System.getProperty("http.proxyPort");
        if (!a(str)) {
          try
          {
            i = Integer.parseInt(str);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
  }
  
  private static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuffer.append(paramInt >>> 24);
    return localStringBuffer.toString();
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  /* Error */
  public static String getAPN(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 123	com/tencent/component/network/utils/NetworkUtils:getActiveNetworkInfo	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload 4
    //   17: invokevirtual 128	android/net/NetworkInfo:getType	()I
    //   20: iconst_1
    //   21: if_icmpne +19 -> 40
    //   24: ldc 14
    //   26: astore_0
    //   27: aload_0
    //   28: astore_1
    //   29: aload_0
    //   30: ifnull +8 -> 38
    //   33: aload_0
    //   34: invokevirtual 131	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: aload 4
    //   42: invokevirtual 128	android/net/NetworkInfo:getType	()I
    //   45: ifne +169 -> 214
    //   48: invokestatic 67	com/tencent/component/network/utils/PlatformUtil:version	()I
    //   51: bipush 17
    //   53: if_icmpge +156 -> 209
    //   56: aload_0
    //   57: invokevirtual 137	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: getstatic 31	com/tencent/component/network/utils/NetworkUtils:a	Landroid/net/Uri;
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 143	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore_0
    //   71: aload_0
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_2
    //   76: ifnull +16 -> 92
    //   79: aload_2
    //   80: invokeinterface 149 1 0
    //   85: istore 5
    //   87: iload 5
    //   89: ifne +35 -> 124
    //   92: aload_0
    //   93: astore_1
    //   94: aload_2
    //   95: ifnull +11 -> 106
    //   98: aload_2
    //   99: invokeinterface 152 1 0
    //   104: aload_0
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: aload_1
    //   109: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifeq -85 -> 27
    //   115: aload 4
    //   117: invokevirtual 161	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   120: astore_0
    //   121: goto -94 -> 27
    //   124: aload_2
    //   125: aload_2
    //   126: ldc -93
    //   128: invokeinterface 166 2 0
    //   133: invokeinterface 169 2 0
    //   138: astore_1
    //   139: aload_1
    //   140: astore_0
    //   141: goto -66 -> 75
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_3
    //   147: aload_2
    //   148: astore_0
    //   149: aload_3
    //   150: astore_2
    //   151: aload_1
    //   152: invokevirtual 170	java/lang/Throwable:printStackTrace	()V
    //   155: aload_2
    //   156: astore_1
    //   157: aload_0
    //   158: ifnull -52 -> 106
    //   161: aload_0
    //   162: invokeinterface 152 1 0
    //   167: aload_2
    //   168: astore_1
    //   169: goto -63 -> 106
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_2
    //   176: ifnull +9 -> 185
    //   179: aload_2
    //   180: invokeinterface 152 1 0
    //   185: aload_0
    //   186: athrow
    //   187: astore_0
    //   188: goto -13 -> 175
    //   191: astore_1
    //   192: aload_0
    //   193: astore_2
    //   194: aload_1
    //   195: astore_0
    //   196: goto -21 -> 175
    //   199: astore_1
    //   200: aload_2
    //   201: astore_3
    //   202: aload_0
    //   203: astore_2
    //   204: aload_3
    //   205: astore_0
    //   206: goto -55 -> 151
    //   209: aconst_null
    //   210: astore_1
    //   211: goto -105 -> 106
    //   214: aconst_null
    //   215: astore_0
    //   216: goto -189 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramContext	Context
    //   28	112	1	localObject1	Object
    //   144	8	1	localThrowable1	Throwable
    //   156	13	1	localObject2	Object
    //   191	4	1	localObject3	Object
    //   199	1	1	localThrowable2	Throwable
    //   210	1	1	localObject4	Object
    //   1	203	2	localObject5	Object
    //   146	59	3	localObject6	Object
    //   6	110	4	localNetworkInfo	NetworkInfo
    //   85	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   56	71	144	java/lang/Throwable
    //   56	71	172	finally
    //   79	87	187	finally
    //   124	139	187	finally
    //   151	155	191	finally
    //   79	87	199	java/lang/Throwable
    //   124	139	199	java/lang/Throwable
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      a.b("NetworkUtil", "fail to get active network info", paramContext);
    }
    return null;
  }
  
  public static DNS getDNS(Context paramContext)
  {
    DNS localDNS = new DNS();
    if ((paramContext != null) && (isWifiConnected(paramContext)))
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
      if (paramContext != null)
      {
        localDNS.primary = a(paramContext.dns1);
        localDNS.secondary = a(paramContext.dns2);
      }
    }
    if ((localDNS.primary == null) && (localDNS.secondary == null))
    {
      localDNS.primary = d.a("net.dns1");
      localDNS.secondary = d.a("net.dns2");
    }
    return localDNS;
  }
  
  public static NetworkProxy getProxy(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {
      return null;
    }
    if (PlatformUtil.version() < 11) {}
    for (paramContext = Proxy.getDefaultHost();; paramContext = System.getProperty("http.proxyHost"))
    {
      int i = a();
      if ((a(paramContext)) || (i < 0)) {
        break;
      }
      return new NetworkProxy(paramContext, i);
    }
    return null;
  }
  
  public static NetworkProxy getProxy(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return getProxy(paramContext);
    }
    return getProxyByAPN(paramContext);
  }
  
  public static NetworkProxy getProxyByAPN(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {
      return null;
    }
    paramContext = getAPN(paramContext);
    paramContext = (NetworkProxy)b.get(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.a();
  }
  
  public static boolean isMobileConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = getActiveNetworkInfo(paramContext);
    } while ((paramContext == null) || ((paramContext.getType() != 0) && (paramContext.getType() + 50 != 0)));
    return true;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while (URLUtil.isFileUrl(paramString));
    return URLUtil.isNetworkUrl(paramString);
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = getActiveNetworkInfo(paramContext);
    } while ((paramContext == null) || (paramContext.getType() != 1));
    return true;
  }
  
  public static final class DNS
  {
    public String primary;
    public String secondary;
    
    public final String toString()
    {
      return this.primary + "," + this.secondary;
    }
  }
  
  public static class NetworkProxy
    implements Cloneable
  {
    public final String host;
    public final int port;
    
    NetworkProxy(String paramString, int paramInt)
    {
      this.host = paramString;
      this.port = paramInt;
    }
    
    final NetworkProxy a()
    {
      try
      {
        NetworkProxy localNetworkProxy = (NetworkProxy)clone();
        return localNetworkProxy;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
      }
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof NetworkProxy))) {
          break;
        }
        paramObject = (NetworkProxy)paramObject;
      } while ((TextUtils.equals(this.host, ((NetworkProxy)paramObject).host)) && (this.port == ((NetworkProxy)paramObject).port));
      return false;
    }
    
    public final String toString()
    {
      return this.host + ":" + this.port;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */