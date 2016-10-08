package com.weiyun.sdk.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.log.Log;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.HashMap;

public class NetworkUtils
{
  public static final String APN_NAME_WIFI = "wifi";
  public static final int CN_2G = 1;
  public static final int CN_3G = 2;
  public static final int CN_4G = 5;
  public static final int CN_ALL = -1;
  public static final int CN_NONE = 0;
  public static final int CN_PCNET = 4;
  public static final int CN_WIFI = 3;
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  private static final String TAG = "NetworkUtils";
  private static final HashMap<String, NetworkProxy> sAPNProxies = new HashMap();
  
  static
  {
    sAPNProxies.put("cmwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("3gwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("uniwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("ctwap", new NetworkProxy("10.0.0.200", 80));
  }
  
  public static String convert2IP(int paramInt)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = localStringBuffer1.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2 = localStringBuffer2.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2.append(paramInt & 0xFF).append('.').append(paramInt >>> 8 & 0xFF);
    return localStringBuffer1.toString();
  }
  
  public static String getAPN(Context paramContext)
  {
    localObject1 = null;
    NetworkInfo localNetworkInfo = getActiveNetworkInfo(paramContext);
    if (localNetworkInfo == null)
    {
      paramContext = (Context)localObject1;
      return paramContext;
    }
    Object localObject4 = null;
    localObject2 = null;
    localObject3 = null;
    localObject1 = null;
    if (localNetworkInfo.getType() == 1) {
      localObject1 = "wifi";
    }
    for (;;)
    {
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        break;
      }
      return ((String)localObject1).toLowerCase();
      Cursor localCursor;
      if (localNetworkInfo.getType() == 0) {
        if (Build.VERSION.SDK_INT <= 16)
        {
          localObject2 = null;
          localCursor = null;
          localObject1 = localObject3;
          localObject3 = localCursor;
        }
      }
      try
      {
        localCursor = paramContext.getContentResolver().query(PREFERRED_APN_URI, null, null, null, null);
        for (paramContext = (Context)localObject4; localCursor != null; paramContext = localCursor.getString(localCursor.getColumnIndex("apn")))
        {
          localObject1 = paramContext;
          localObject3 = localCursor;
          localObject2 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = paramContext;
          localObject3 = localCursor;
          localObject2 = localCursor;
        }
        localObject2 = paramContext;
        if (localCursor != null)
        {
          localCursor.close();
          localObject2 = paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          localObject2 = localObject3;
          paramContext.printStackTrace();
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            ((Cursor)localObject3).close();
            localObject2 = localObject1;
          }
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label214;
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localNetworkInfo.getExtraInfo();
      }
    }
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
      Log.e("NetworkUtils", "fail to get active network info", paramContext);
    }
    return null;
  }
  
  public static String getDns(Context paramContext)
  {
    DhcpInfo localDhcpInfo = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
    paramContext = "none";
    if (localDhcpInfo != null) {
      paramContext = convert2IP(localDhcpInfo.dns1) + "," + convert2IP(localDhcpInfo.dns2);
    }
    return paramContext;
  }
  
  public static long getHostOrderIp(int paramInt)
  {
    if (isLittleEndian())
    {
      long l = Long.parseLong(Integer.toHexString(paramInt), 16);
      return l << 24 | (0xFF00 & l) << 8 | (0xFF0000 & l) >> 8 | l >> 24;
    }
    return Long.parseLong(Integer.toHexString(paramInt), 16);
  }
  
  public static String getLocalIpAddress(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    Object localObject1 = "";
    paramContext = (Context)localObject1;
    Object localObject2;
    try
    {
      localObject2 = getWifiConfigAddress(localContext);
      paramContext = (Context)localObject1;
      if (isWifiEnable(localContext))
      {
        paramContext = (Context)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          return (String)localObject2;
        }
      }
      paramContext = (Context)localObject1;
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      paramContext = (Context)localObject1;
      localObject2 = localObject1;
      if (localEnumeration1.hasMoreElements())
      {
        paramContext = (Context)localObject1;
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        localObject2 = localObject1;
        boolean bool;
        do
        {
          do
          {
            do
            {
              localObject1 = localObject2;
              paramContext = (Context)localObject2;
              if (!localEnumeration2.hasMoreElements()) {
                break;
              }
              paramContext = (Context)localObject2;
              localObject1 = (InetAddress)localEnumeration2.nextElement();
              paramContext = (Context)localObject2;
            } while (((InetAddress)localObject1).isLoopbackAddress());
            paramContext = (Context)localObject2;
          } while (!(localObject1 instanceof Inet4Address));
          paramContext = (Context)localObject2;
          localObject1 = ((InetAddress)localObject1).getHostAddress();
          paramContext = (Context)localObject1;
          if (!isWifiApEnabled(localContext)) {
            break label162;
          }
          paramContext = (Context)localObject1;
          bool = ((String)localObject1).startsWith("192.168");
          localObject2 = localObject1;
        } while (!bool);
        label162:
        return (String)localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("NetworkUtils", "Fail to get IpAddress:" + localThrowable.toString());
      localObject2 = paramContext;
    }
    return (String)localObject2;
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    int j = getNetWorkTypeImpl(getNetworkInfo(paramContext));
    int i = j;
    if (j == 5) {
      i = 2;
    }
    return i;
  }
  
  private static int getNetWorkTypeImpl(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      Log.i("NetworkUtils", "net info is null");
    }
    int i;
    do
    {
      return 0;
      if (!paramNetworkInfo.isAvailable())
      {
        Log.i("NetworkUtils", "net is unavailable. net.type:" + paramNetworkInfo.getType() + " net.subtype:" + paramNetworkInfo.getSubtype() + " net.typename:" + paramNetworkInfo.getTypeName());
        return 0;
      }
      i = paramNetworkInfo.getType();
      int j = paramNetworkInfo.getSubtype();
      if (i == 1) {
        return 3;
      }
      if ((i == 0) || (i == 4) || (i == 5) || (i == 2) || (i == 3))
      {
        switch (j)
        {
        case 0: 
        default: 
          return 0;
        case 1: 
          return 1;
        case 7: 
          return 1;
        case 4: 
          return 1;
        case 2: 
          return 1;
        case 5: 
          return 2;
        case 6: 
          return 2;
        case 8: 
          return 2;
        case 10: 
          return 2;
        case 9: 
          return 2;
        case 3: 
          return 2;
        case 11: 
          return 1;
        case 12: 
          return 2;
        case 13: 
          return 5;
        case 14: 
          return 2;
        }
        return 2;
      }
    } while ((i != 6) && (i != 9));
    return 3;
  }
  
  @Deprecated
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    return getActiveNetworkInfo(localContext);
  }
  
  public static int getNetworkTypeForReport(Context paramContext)
  {
    int i = getNetWorkTypeImpl(getActiveNetworkInfo(paramContext));
    if (i == 3) {
      return 1;
    }
    if (i == 1) {
      return 2;
    }
    if (i == 2) {
      return 3;
    }
    if (i == 5) {
      return 4;
    }
    return 0;
  }
  
  public static int getPacketSize(Context paramContext)
  {
    int i = getNetWorkType(paramContext);
    if (i == 2) {
      return 32768;
    }
    if (i == 1) {
      return 16384;
    }
    if (i == 3) {
      return 65536;
    }
    return -1;
  }
  
  public static NetworkProxy getProxy(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {}
    String str;
    int i;
    do
    {
      return null;
      str = getProxyHost(paramContext);
      i = getProxyPort(paramContext);
    } while ((TextUtils.isEmpty(str)) || (i < 0));
    return new NetworkProxy(str, i);
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
    if (!isMobileConnected(paramContext)) {}
    do
    {
      return null;
      paramContext = getAPN(paramContext);
      paramContext = (NetworkProxy)sAPNProxies.get(paramContext);
    } while (paramContext == null);
    return paramContext.copy();
  }
  
  private static String getProxyHost(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  private static int getProxyPort(Context paramContext)
  {
    int j = -1;
    int i;
    if (Build.VERSION.SDK_INT < 11) {
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
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
      paramContext = System.getProperty("http.proxyPort");
      i = j;
      if (!TextUtils.isEmpty(paramContext)) {
        try
        {
          i = Integer.parseInt(paramContext);
        }
        catch (NumberFormatException paramContext)
        {
          paramContext.printStackTrace();
          i = j;
        }
      }
    }
  }
  
  public static String getWifiBSSID(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getWifiInfo(localContext);
    if ((paramContext != null) && (paramContext.getBSSID() != null)) {
      return paramContext.getBSSID().toLowerCase().replaceAll(":", "-");
    }
    return null;
  }
  
  public static String getWifiConfigAddress(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      WifiInfo localWifiInfo = paramContext.getConnectionInfo();
      if (localWifiInfo != null)
      {
        int j = localWifiInfo.getIpAddress();
        int i = j;
        if (j == 0) {
          i = paramContext.getDhcpInfo().ipAddress;
        }
        paramContext = longToIP(getHostOrderIp(i));
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("NetworkUtils", "fail to get wifi info", paramContext);
    }
    return "";
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.e("NetworkUtils", "fail to get wifi info", paramContext);
    }
    return null;
  }
  
  public static String getWifiMacAddress(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getWifiInfo(localContext);
    if (paramContext != null)
    {
      paramContext = paramContext.getMacAddress();
      if (paramContext != null) {
        return paramContext.toLowerCase().replaceAll(":", "-");
      }
      Log.w("NetworkUtils", "mac address is null!");
    }
    for (;;)
    {
      return null;
      Log.w("NetworkUtils", "can *NOT* get connect info when get mac address!");
    }
  }
  
  public static String getWifiName(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getWifiInfo(localContext);
    if ((paramContext != null) && (paramContext.getSSID() != null)) {
      return paramContext.getSSID();
    }
    return null;
  }
  
  public static int getWifiSignalStrength(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getWifiInfo(localContext);
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getRssi();
  }
  
  @Deprecated
  public static boolean hasInternet(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    return isNetworkConnected(localContext);
  }
  
  public static boolean isBigEndian()
  {
    return ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
  }
  
  public static boolean isCnwapConnection(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    paramContext = getActiveNetworkInfo(localContext);
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = paramContext.getExtraInfo();
    } while ((paramContext == null) || (!paramContext.toLowerCase().contains("wap")));
    return true;
  }
  
  public static boolean isLittleEndian()
  {
    return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
  }
  
  public static boolean isMobileConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = getActiveNetworkInfo(paramContext);
    } while ((paramContext == null) || (paramContext.getType() != 0));
    return true;
  }
  
  @Deprecated
  public static boolean isMobileNetwork(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    return isMobileConnected(localContext);
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = getActiveNetworkInfo(paramContext);
    } while ((paramContext == null) || (!paramContext.isConnected()));
    return true;
  }
  
  public static boolean isNetworkConnectedOrConnecting(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getAllNetworkInfo();
        if (paramContext == null) {
          continue;
        }
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramContext[i].isConnectedOrConnecting();
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Throwable paramContext)
      {
        Log.e("NetworkUtils", "fail to get network info", paramContext);
      }
    }
  }
  
  @Deprecated
  public static boolean isWIFI(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = SdkContext.getInstance().getContext();
    }
    return isWifiConnected(localContext);
  }
  
  public static boolean isWifiApEnabled(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        Method localMethod = paramContext.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]);
        if (localMethod != null)
        {
          paramContext = localMethod.invoke(paramContext, new Object[0]);
          if (paramContext != null)
          {
            boolean bool = Boolean.parseBoolean(paramContext.toString());
            return bool;
          }
        }
      }
      catch (Throwable paramContext)
      {
        Log.w("NetworkUtils", "fail to get wifi ap state", paramContext);
      }
    }
    return false;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = getActiveNetworkInfo(paramContext);
    if ((paramContext != null) && (paramContext.getType() == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isWifiEnable(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
  }
  
  public static String longToIP(long paramLong)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.insert(0, paramLong & 0xFF).insert(0, '.');
    paramLong >>>= 8;
    localStringBuilder2 = localStringBuilder2.insert(0, paramLong & 0xFF).insert(0, '.');
    paramLong >>>= 8;
    localStringBuilder2.insert(0, paramLong & 0xFF).insert(0, '.').insert(0, paramLong >>> 8 & 0xFF);
    return localStringBuilder1.toString();
  }
  
  @Deprecated
  public static void setContext(Context paramContext) {}
  
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
    
    final NetworkProxy copy()
    {
      try
      {
        NetworkProxy localNetworkProxy = (NetworkProxy)clone();
        return localNetworkProxy;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
    
    public boolean equals(Object paramObject)
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
    
    public String toString()
    {
      return this.host + ":" + this.port;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\util\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */