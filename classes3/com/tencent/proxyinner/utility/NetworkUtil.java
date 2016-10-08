package com.tencent.proxyinner.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil
{
  public static int getNetworkSubType(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return 30;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while (paramContext == null);
    if (!paramContext.isAvailable()) {
      return 31;
    }
    return paramContext.getSubtype();
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return 30;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while (paramContext == null);
    if (!paramContext.isAvailable()) {
      return 31;
    }
    return paramContext.getType();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\utility\NetworkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */