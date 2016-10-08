package com.tencent.component.network.module.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.component.network.downloader.common.a;
import java.util.ArrayList;
import java.util.List;

public class NetworkState
  extends BroadcastReceiver
{
  public static final int NETWORK_TYPE_2G = 3;
  public static final int NETWORK_TYPE_3G = 2;
  public static final int NETWORK_TYPE_4G = 6;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  private static final String a = NetworkState.class.getName();
  private static NetworkState b = null;
  private static int f = 0;
  private Context c = null;
  private String d = null;
  private boolean e = false;
  private List<NetworkStateListener> g = new ArrayList();
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      synchronized (this.g)
      {
        NetworkStateListener[] arrayOfNetworkStateListener = new NetworkStateListener[this.g.size()];
        this.g.toArray(arrayOfNetworkStateListener);
        int j = arrayOfNetworkStateListener.length;
        i = 0;
        if (i >= j) {
          return;
        }
      }
      localObject[i].onNetworkConnect(paramBoolean);
      i += 1;
    }
  }
  
  public static NetworkState g()
  {
    if (b == null) {
      b = new NetworkState();
    }
    return b;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext == null) {
        break label206;
      }
      j = paramContext.length;
      i = 0;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        int j;
        int i;
        Object localObject;
        label206:
        return true;
      }
    }
    catch (Throwable paramContext) {}
    localObject = paramContext[i];
    if ((localObject != null) && (((NetworkInfo)localObject).isConnectedOrConnecting())) {
      switch (((NetworkInfo)localObject).getType())
      {
      }
    }
    for (;;)
    {
      f = 0;
      for (;;)
      {
        i = f;
        return true;
        f = 1;
        continue;
        switch (((NetworkInfo)localObject).getSubtype())
        {
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          f = 3;
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          f = 2;
          break;
        case 13: 
          f = 6;
        }
      }
      i += 1;
      if (i < j) {
        break;
      }
      return false;
    }
    return false;
  }
  
  public void addListener(NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (this.g)
    {
      if (!this.g.contains(paramNetworkStateListener)) {
        this.g.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public int getNetworkType()
  {
    return f;
  }
  
  public String getProviderName()
  {
    Object localObject1;
    if (!this.e)
    {
      this.e = true;
      localObject1 = (TelephonyManager)this.c.getSystemService("phone");
    }
    try
    {
      localObject1 = ((TelephonyManager)localObject1).getSubscriberId();
      if ((localObject1 == null) || ("".equals(localObject1)))
      {
        this.d = "unknown";
        return this.d;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        if ((((String)localObject2).startsWith("46000")) || (((String)localObject2).startsWith("46002"))) {
          this.d = "ChinaMobile";
        } else if (((String)localObject2).startsWith("46001")) {
          this.d = "ChinaUnicom";
        } else if (((String)localObject2).startsWith("46003")) {
          this.d = "ChinaTelecom";
        } else {
          this.d = "unknown";
        }
      }
    }
  }
  
  public boolean isNetworkAvailable()
  {
    boolean bool1;
    if (this.c == null) {
      bool1 = true;
    }
    NetworkInfo localNetworkInfo;
    boolean bool2;
    do
    {
      return bool1;
      localNetworkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return false;
      }
      bool2 = localNetworkInfo.isConnected();
      bool1 = bool2;
    } while (bool2);
    a.d(a, "isNetworkEnable() : FALSE with TYPE = " + localNetworkInfo.getType());
    return bool2;
  }
  
  public boolean isNetworkConnected()
  {
    if (this.c == null) {
      return true;
    }
    return isNetworkConnected(this.c);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a.d(a, "NetworkStateReceiver ====== " + paramIntent.getAction());
    if (paramIntent.getAction() == null) {}
    while (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") != 0) {
      return;
    }
    a(isNetworkConnected(paramContext));
  }
  
  public void removeListener(NetworkStateListener paramNetworkStateListener)
  {
    synchronized (this.g)
    {
      this.g.remove(paramNetworkStateListener);
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.c = paramContext;
    paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    isNetworkConnected(paramContext);
  }
  
  public void unregisterReceiver()
  {
    this.c.unregisterReceiver(this);
  }
  
  public static abstract interface NetworkStateListener
  {
    public abstract void onNetworkConnect(boolean paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\common\NetworkState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */