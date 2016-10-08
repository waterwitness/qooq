package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import cooperation.qzone.util.NetworkState;

public class NetworkUtil
{
  public NetworkUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2;
    case 1: 
    case 4: 
    case 5: 
      return 4;
    }
    return 3;
  }
  
  public static int a(Context paramContext)
  {
    int j = HttpUtil.a();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    return i;
  }
  
  public static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".").append(paramInt >> 8 & 0xFF).append(".").append(paramInt >> 16 & 0xFF).append(".").append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static String a(Context paramContext)
  {
    return NetworkState.b();
  }
  
  public static boolean a(Context paramContext)
  {
    return HwNetworkUtil.isAirplaneModeOn(paramContext);
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return HwNetworkUtil.isMobileNetworkInfo(paramNetworkInfo);
  }
  
  public static int b(Context paramContext)
  {
    int j = -1;
    int i = j;
    if (AppNetConnInfo.isNetSupport())
    {
      paramContext = AppNetConnInfo.getRecentNetworkInfo();
      i = j;
      if (paramContext != null) {
        i = paramContext.getType();
      }
    }
    return i;
  }
  
  public static boolean b(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  public static boolean c(Context paramContext)
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean d(Context paramContext)
  {
    return HwNetworkUtil.is3Gor4G(paramContext);
  }
  
  public static boolean e(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean f(Context paramContext)
  {
    return HwNetworkUtil.isNetSupport(paramContext);
  }
  
  public static boolean g(Context paramContext)
  {
    return (Build.VERSION.SDK_INT >= 13) && (b(paramContext) == 7);
  }
  
  public static boolean h(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean i(Context paramContext)
  {
    return NetworkState.c();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\NetworkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */