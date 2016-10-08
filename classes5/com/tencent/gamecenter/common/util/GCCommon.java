package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

public class GCCommon
  extends Common
{
  private static final String F = ".GameCenterWebBuffer";
  private static final String G = f();
  public static final String a = "GameCenter";
  public static final String b = "WebPages/android";
  public static final String c = "Images/games";
  public static final String d = "Apk";
  public static final String e = "http://gamecenter.qq.com/front/release/index/index.html";
  public static final String f = "http://gamecenter.qq.com/md5";
  public static final String g = "http://gamecenter.qq.com/appfriends/get_recent";
  public static final String h = "http://gamecenter.qq.com/gamecenter/index/recent_play.html";
  public static final String i = "http://gamecenter.qq.com/report/action";
  public static final String j = "http://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s";
  public static final String k = "http://pay.qq.com/h5/index.shtml?m=buy&c=qqacct_save&pf=2201";
  public static final String l = "com.qq.AppService";
  public static final String m = "ANDROIDQQ.GAME.RECENT";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    int n = -1;
    try
    {
      int i1 = Integer.parseInt(paramString);
      n = i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GameCenter", 4, "try parse string param to int exception. value:" + paramString + ". msg - " + localNumberFormatException.getMessage());
    }
    return n;
    return -1;
  }
  
  public static long a(String paramString)
  {
    long l1 = -1L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GameCenter", 4, "try parse string param to long exception. value:" + paramString + ". msg - " + localNumberFormatException.getMessage());
    }
    return l1;
    return -1L;
  }
  
  public static String a()
  {
    return G + File.separator + ".GameCenterWebBuffer" + File.separator + "Images/games";
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
    String str = "" + ((TelephonyManager)localObject).getDeviceId();
    localObject = "" + ((TelephonyManager)localObject).getSimSerialNumber();
    return new UUID(("" + Settings.Secure.getString(paramContext.getContentResolver(), "android_id")).hashCode(), str.hashCode() << 32 | ((String)localObject).hashCode()).toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = a();
    return paramString2 + File.separator + paramString1;
  }
  
  public static String b()
  {
    return G + File.separator + ".GameCenterWebBuffer" + File.separator + "WebPages/android" + File.separator + "notupdate.txt";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return paramString1 + "_" + MD5Utils.b(paramString2) + ".apk";
  }
  
  public static String c()
  {
    return G + File.separator + "download" + File.separator + "Apk";
  }
  
  public static String d()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      return (String)localObject;
    }
    catch (SocketException localSocketException) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\gamecenter\common\util\GCCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */