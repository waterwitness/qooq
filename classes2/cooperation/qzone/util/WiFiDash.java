package cooperation.qzone.util;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class WiFiDash
{
  static volatile String a = null;
  public static final String b = "";
  public static final String c = "N/A";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    Object localObject = a("N/A");
    if (localObject == "N/A") {
      return -1;
    }
    return WifiManager.calculateSignalLevel(((WifiInfo)localObject).getRssi(), 5);
  }
  
  private static Object a(Object paramObject)
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (localObject1 == null) {}
    for (;;)
    {
      return paramObject;
      try
      {
        localObject1 = ((WifiManager)localObject1).getConnectionInfo();
        if (localObject1 == null) {
          continue;
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static String a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        b();
      }
      if (("N/A".equals(a)) || ("00:00:00:00:00:00".equals(a)) || ("FF:FF:FF:FF:FF:FF".equalsIgnoreCase(a))) {
        return null;
      }
    }
    finally {}
    return a;
  }
  
  public static String b()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a("N/A");
        if (localObject1 != "N/A")
        {
          String str = ((WifiInfo)localObject1).getBSSID();
          localObject1 = str;
          if (str == null) {
            localObject1 = "N/A";
          }
          a = (String)localObject1;
          return (String)localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public static String c()
  {
    Object localObject = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (localObject == null) {
      return "[-]";
    }
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null) {
        return "[-]";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str1 = null;
      }
      String str2 = str1.getSSID();
      int i = WifiManager.calculateSignalLevel(str1.getRssi(), 5);
      String str1 = String.valueOf(str1.getLinkSpeed()) + " " + "Mbps";
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append('[').append(String.valueOf(i)).append(", ").append(str2).append(", ").append(str1).append(']');
      return localStringBuffer.toString();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\WiFiDash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */