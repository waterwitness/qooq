package cooperation.qqhotspot;

import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class WifiNetworkUtil
{
  public WifiNetworkUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null) {
      return localWifiInfo.getNetworkId();
    }
    return -1;
  }
  
  public static DhcpInfo a()
  {
    return ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getDhcpInfo();
  }
  
  public static String a()
  {
    WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null) {
      return a(localWifiInfo.getSSID());
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  private static String a(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration.allowedKeyManagement.get(1)) {
      return android.net.wifi.WifiConfiguration.KeyMgmt.strings[1];
    }
    if ((paramWifiConfiguration.allowedKeyManagement.get(2)) || (paramWifiConfiguration.allowedKeyManagement.get(3))) {
      return android.net.wifi.WifiConfiguration.KeyMgmt.strings[2];
    }
    if ((paramWifiConfiguration.wepKeys != null) && (paramWifiConfiguration.wepKeys[0] != null)) {
      return "-WEP";
    }
    return android.net.wifi.WifiConfiguration.KeyMgmt.strings[0];
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    int i;
    do
    {
      do
      {
        do
        {
          return str;
          i = paramString.length();
          str = paramString;
        } while (i <= 2);
        str = paramString;
      } while (paramString.charAt(0) != '"');
      str = paramString;
    } while (paramString.charAt(i - 1) != '"');
    return paramString.substring(1, i - 1);
  }
  
  public static void a(boolean paramBoolean)
  {
    WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    try
    {
      localWifiManager.setWifiEnabled(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    return ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).isWifiEnabled();
  }
  
  public static boolean a(WifiConfiguration paramWifiConfiguration1, WifiConfiguration paramWifiConfiguration2)
  {
    if ((paramWifiConfiguration1 == null) || (paramWifiConfiguration2 == null) || (paramWifiConfiguration1.allowedKeyManagement == null) || (paramWifiConfiguration2.allowedKeyManagement == null)) {}
    while (!a(paramWifiConfiguration1.SSID, paramWifiConfiguration2.SSID)) {
      return false;
    }
    return a(paramWifiConfiguration1).equals(a(paramWifiConfiguration2));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return null;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  public static String b()
  {
    WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null)
    {
      if (localWifiInfo.getBSSID() != null) {
        return localWifiInfo.getBSSID().toUpperCase();
      }
      return null;
    }
    return null;
  }
  
  public static boolean b()
  {
    WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
    return (localWifiInfo != null) && (-1 != localWifiInfo.getNetworkId()) && (localWifiInfo.getIpAddress() != 0);
  }
  
  public static String c()
  {
    DhcpInfo localDhcpInfo = a();
    if (localDhcpInfo != null) {
      return a(localDhcpInfo.gateway);
    }
    return null;
  }
  
  public static boolean c()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected()) && (localNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) && (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED) && (localNetworkInfo.getType() == 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\WifiNetworkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */