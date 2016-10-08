package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class AppNetConnInfo
{
  public static final int MOBILE_2G = 0;
  public static final int MOBILE_3G = 1;
  public static final int MOBILE_4G = 2;
  public static final int MOBILE_NONE = -1;
  public static final int MOBILE_UNKNOWN = 3;
  public static final int NET_MOBILE = 0;
  public static final int NET_NONE = -1;
  public static final int NET_WIFI = 1;
  public static final int NET_WIFI_NEEDAUTH = 2;
  
  public static void checkNetEvent() {}
  
  public static int getConnInfo()
  {
    a.i();
    return a.c() - 1;
  }
  
  public static String getCurrentAPN()
  {
    a.i();
    return a.i;
  }
  
  public static int getMobileInfo()
  {
    a.i();
    return a.d();
  }
  
  public static NetworkInfo getRecentNetworkInfo()
  {
    a.i();
    return a.h();
  }
  
  public static String getSubtypeName()
  {
    a.i();
    return a.j;
  }
  
  public static boolean isMobileConn()
  {
    a.i();
    return a.f();
  }
  
  public static boolean isNeedWifiAuth()
  {
    a.i();
    return a.g;
  }
  
  public static boolean isNetSupport()
  {
    a.i();
    return a.b();
  }
  
  public static boolean isWifiConn()
  {
    a.i();
    return a.e();
  }
  
  public static void registerConnectionChangeReceiver(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    a.a(paramContext, paramINetInfoHandler);
  }
  
  public static void registerNetChangeReceiver(Context paramContext, INetEventHandler paramINetEventHandler)
  {
    a.a(paramContext, paramINetEventHandler);
  }
  
  public static boolean unregisterNetEventHandler(INetEventHandler paramINetEventHandler)
  {
    return a.a(paramINetEventHandler);
  }
  
  public static boolean unregisterNetInfoHandler(INetInfoHandler paramINetInfoHandler)
  {
    return a.a(paramINetInfoHandler);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\AppNetConnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */