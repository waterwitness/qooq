package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.util.Collections;
import java.util.List;

public final class dd
{
  public static boolean a = false;
  
  public static boolean a(WifiManager paramWifiManager)
  {
    if (paramWifiManager != null) {
      try
      {
        boolean bool = paramWifiManager.startScan();
        return bool;
      }
      catch (Exception paramWifiManager)
      {
        a = true;
      }
    }
    return false;
  }
  
  public static boolean a(bl parambl)
  {
    parambl = parambl.f;
    return (parambl != null) && (parambl.isWifiEnabled());
  }
  
  public static List<ScanResult> b(WifiManager paramWifiManager)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramWifiManager != null) {}
    try
    {
      localObject1 = paramWifiManager.getScanResults();
      paramWifiManager = (WifiManager)localObject1;
      if (localObject1 == null) {
        paramWifiManager = Collections.emptyList();
      }
      return paramWifiManager;
    }
    catch (Exception paramWifiManager)
    {
      for (;;)
      {
        a = true;
        localObject1 = localObject2;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public static boolean b(bl parambl)
  {
    parambl = parambl.f;
    boolean bool1 = false;
    boolean bool2;
    if (parambl != null)
    {
      bool2 = parambl.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = parambl.isScanAlwaysAvailable();
      }
      return bool1;
    }
    catch (Error parambl)
    {
      return bool2;
    }
    catch (Exception parambl) {}
    return bool2;
  }
  
  public static String c(bl parambl)
  {
    parambl = parambl.f;
    if (parambl != null)
    {
      parambl = parambl.getConnectionInfo();
      if (parambl != null) {}
      for (parambl = parambl.getMacAddress(); parambl != null; parambl = "") {
        return parambl;
      }
      return "";
    }
    return "";
  }
  
  public static String d(bl parambl)
  {
    Object localObject = parambl.a;
    if (localObject == null) {
      return "{}";
    }
    try
    {
      parambl = (WifiManager)((Context)localObject).getSystemService("wifi");
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if ((parambl != null) && (localObject != null))
      {
        parambl = parambl.getConnectionInfo();
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((parambl != null) && (localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          localObject = parambl.getBSSID();
          if ((localObject == null) || (((String)localObject).equals("000000000000")) || (((String)localObject).equals("00-00-00-00-00-00")) || (((String)localObject).equals("00:00:00:00:00:00"))) {
            break label225;
          }
          int i = parambl.getRssi();
          if ((i < -100) || (i > -20)) {
            break label228;
          }
          parambl = parambl.getSSID().replace("\"", "").replace("|", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append("\"mac\":\"");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("\",\"rssi\":");
          localStringBuilder.append(i);
          localStringBuilder.append(",\"ssid\":\"");
          localStringBuilder.append(parambl);
          localStringBuilder.append("\"}");
          parambl = localStringBuilder.toString();
          return parambl;
        }
        return "{}";
      }
    }
    catch (Exception parambl)
    {
      return "{}";
    }
    return "{}";
    label225:
    return "{}";
    label228:
    return "{}";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */