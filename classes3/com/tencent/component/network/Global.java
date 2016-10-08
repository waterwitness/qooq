package com.tencent.component.network;

import android.content.Context;
import com.tencent.component.network.module.common.NetworkState;

public class Global
{
  public static final String SDK_VERSION = "${env.NumberVersion}";
  private static Context sContext;
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static void init(Context paramContext)
  {
    sContext = paramContext;
    NetworkManager.init(getContext());
    NetworkState.g().setContext(getContext());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\Global.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */