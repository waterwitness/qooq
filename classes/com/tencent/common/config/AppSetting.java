package com.tencent.common.config;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.InputStream;
import java.lang.reflect.Method;

public class AppSetting
{
  private static final String A = "N";
  private static String B;
  public static int a = 537048060;
  public static final String a = "2880";
  public static final boolean a = true;
  public static int b = 0;
  public static final String b = "130";
  public static final boolean b = false;
  public static int c = 0;
  public static final String c = "403741BF5D66F9D1";
  public static final boolean c = true;
  public static int d = 0;
  public static final String d = "229354";
  public static final boolean d = false;
  public static int e = 1000;
  public static final String e = "AQQ_2013 4.6";
  public static final boolean e = true;
  public static int f = e + 1;
  public static final String f = "2013";
  public static final boolean f = false;
  public static final String g = "6.5.5";
  public static boolean g = true;
  public static final String h = "QQ/5.2";
  public static boolean h = false;
  public static final String i = "V 6.5.5.2880";
  public static final boolean i = true;
  public static final String j = "6.5.5.2880";
  public static boolean j = false;
  public static final String k = "6.5.5.2880.2016-09-13.r229354.BaiDu";
  public static boolean k = false;
  public static final String l = "2013 6.5.5";
  public static final boolean l = false;
  public static final String m = "2013 6.5.52880";
  public static boolean m = false;
  public static final String n = "10000049";
  public static boolean n = false;
  public static String o;
  public static boolean o = false;
  public static final String p = "c2c_del_msg_oper_enable";
  public static boolean p = false;
  public static final String q = "flashlogo.png";
  public static boolean q = false;
  public static final String r = "birthdayflashlogo.png";
  public static final boolean r = true;
  public static final String s = "android";
  private static final String t = "NA_0";
  private static final String u = "000000";
  private static final String v = "ADR";
  private static final String w = "18";
  private static final String x = Build.VERSION.RELEASE;
  private static final String y = "V3";
  private static String z;
  
  static
  {
    d = 1048576;
    n = true;
    jdField_o_of_type_JavaLangString = "use_msg_reflesh_delay";
    jdField_o_of_type_Boolean = true;
    p = true;
  }
  
  private static int a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return 0;
      if (Build.VERSION.SDK_INT >= 10) {
        try
        {
          paramContext = NfcAdapter.getDefaultAdapter(paramContext);
          if (paramContext != null) {
            return 1;
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    String[] arrayOfString = "6.5.5".split("\\.");
    paramString = paramString.split("\\.");
    int i1;
    int i2;
    if (arrayOfString.length < paramString.length)
    {
      i1 = arrayOfString.length;
      i2 = 0;
    }
    for (;;)
    {
      if (i2 >= i1) {
        break label79;
      }
      int i3 = Integer.parseInt(arrayOfString[i2]);
      int i4 = Integer.parseInt(paramString[i2]);
      if (i3 > i4)
      {
        return 1;
        i1 = paramString.length;
        break;
      }
      if (i3 < i4) {
        return -1;
      }
      i2 += 1;
    }
    label79:
    return 0;
  }
  
  public static final String a()
  {
    return "403741BF5D66F9D1";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localObject1 = new Time();
    ((Time)localObject1).setToNow();
    localStringBuffer.append(((Time)localObject1).format("%Y-%m-%d %H:%M:%S") + "/");
    localStringBuffer.append("mobileQQ/");
    localObject2 = "";
    long l1 = DeviceInfoUtil.c() / 1048576L;
    int i1 = a(paramContext);
    localObject1 = localObject2;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      localObject1 = localObject2;
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      localObject1 = localObject2;
      paramContext = localTelephonyManager.getDeviceId();
      localObject1 = paramContext;
      localObject2 = a(localTelephonyManager, localConnectivityManager);
      localObject1 = localObject2;
      localObject2 = paramContext;
      paramContext = (Context)localObject1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "//";
        localObject2 = localObject1;
      }
    }
    localStringBuffer.append((String)localObject2 + "/");
    localStringBuffer.append("10000049/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    localStringBuffer.append((String)localObject1 + "/");
    localStringBuffer.append(a + "/");
    localStringBuffer.append("N/");
    localStringBuffer.append(a(Build.MODEL) + "/");
    localStringBuffer.append(a(Build.BRAND) + "/");
    localStringBuffer.append(l1 + "/");
    localStringBuffer.append(paramContext + "/");
    localStringBuffer.append(i1 + "/");
    return localStringBuffer.toString();
  }
  
  private static String a(TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager)
  {
    if ((paramTelephonyManager == null) || (paramConnectivityManager == null)) {
      return "//";
    }
    String str3 = "";
    String str5 = "";
    String str4 = "";
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    String str1 = str4;
    paramConnectivityManager = str5;
    String str2 = str3;
    if (localNetworkInfo != null)
    {
      str1 = str4;
      paramConnectivityManager = str5;
      str2 = str3;
      if (localNetworkInfo.isAvailable()) {
        switch (localNetworkInfo.getType())
        {
        case 7: 
        case 8: 
        default: 
          paramConnectivityManager = "unknown";
          str1 = "unknown";
          str2 = str3;
        }
      }
    }
    for (;;)
    {
      return paramConnectivityManager + "/" + str2 + "/" + str1;
      paramConnectivityManager = "cable";
      str1 = str4;
      str2 = str3;
      continue;
      paramConnectivityManager = "WIFI";
      str1 = str4;
      str2 = str3;
      continue;
      str2 = a(paramTelephonyManager.getNetworkOperatorName());
      switch (paramTelephonyManager.getNetworkType())
      {
      default: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
        break;
      case 13: 
        paramConnectivityManager = "4G";
        str1 = "LTE";
        break;
      case 3: 
        paramConnectivityManager = "3G";
        str1 = "UMTS";
        break;
      case 5: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_0";
        break;
      case 6: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_A";
        break;
      case 8: 
        paramConnectivityManager = "3G";
        str1 = "SDPA";
        break;
      case 9: 
        paramConnectivityManager = "3G";
        str1 = "HSUPA";
        break;
      case 10: 
        paramConnectivityManager = "3G";
        str1 = "HSPA";
        break;
      case 12: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_B";
        break;
      case 14: 
        paramConnectivityManager = "3G";
        str1 = "EHRPD";
        break;
      case 15: 
        paramConnectivityManager = "3G";
        str1 = "HSPAP";
        break;
      case 1: 
        paramConnectivityManager = "2G";
        str1 = "GPRS";
        break;
      case 2: 
        paramConnectivityManager = "2G";
        str1 = "EDGE";
        break;
      case 4: 
        paramConnectivityManager = "2G";
        str1 = "CDMA";
        break;
      case 7: 
        paramConnectivityManager = "2G";
        str1 = "1xRTT";
        break;
      case 11: 
        paramConnectivityManager = "2G";
        str1 = "IDEN";
        break;
      case 0: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
      }
    }
  }
  
  public static String a(InputStream paramInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    byte[] arrayOfByte = new byte[64];
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i1));
    }
    return localStringBuffer.toString();
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("/")) {
        str = paramString.replace("/", "_");
      }
      paramString = str;
    } while (str.length() <= 20);
    return str.substring(20);
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext.getResources().getDisplayMetrics().widthPixels;
    c = paramContext.getResources().getDisplayMetrics().heightPixels;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      int i1 = b;
      b = c;
      c = i1;
    }
    B = "" + b / 16 + c / 16;
  }
  
  public static final String b()
  {
    if (z != null) {
      return z;
    }
    Object localObject2;
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      Object localObject1 = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = (String)((Method)localObject1).invoke(null, new Object[] { "ro.product.manufacturer" });
      localObject1 = (String)localObject1 + Build.MODEL;
      if (localObject1 == null) {
        break label297;
      }
      localObject2 = ((String)localObject1).toCharArray();
      localStringBuffer = new StringBuffer(32);
      int i1 = 0;
      while (i1 < localObject2.length)
      {
        if ((localObject2[i1] > ' ') && (localObject2[i1] != '/') && (localObject2[i1] != '_') && (localObject2[i1] != '&') && (localObject2[i1] != '|') && (localObject2[i1] != '-')) {
          localStringBuffer.append(localObject2[i1]);
        }
        i1 += 1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        String str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str2 = "";
      }
    }
    if (localStringBuffer.length() > 0) {
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      localObject2 = str2;
      if (str2.length() > 20) {
        localObject2 = str2.substring(0, 20);
      }
      z = "AQQ_2013 4.6/2013 6.5.52880&NA_0/000000&ADR&" + B + "18" + "&" + (String)localObject2 + "&" + "10000049" + "&" + "403741BF5D66F9D1" + "&" + x + "&" + "V3";
      return z;
      label297:
      str2 = "ALL";
    }
  }
  
  public static String c()
  {
    return "2013 6.5.5";
  }
  
  public static final String d()
  {
    return "android 6.5.5";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\config\AppSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */