package com.tencent.component.network.module.common;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.NetworkUtils.DNS;

public class b
{
  private static volatile b c;
  private final Context a;
  private NetworkUtils.DNS b;
  
  private b(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    b();
    paramContext = new c(this);
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.a.registerReceiver(paramContext, localIntentFilter);
  }
  
  public static b a(Context paramContext)
  {
    if (c != null) {
      return c;
    }
    try
    {
      if (c != null)
      {
        paramContext = c;
        return paramContext;
      }
    }
    finally {}
    paramContext = new b(paramContext);
    c = paramContext;
    return paramContext;
  }
  
  private void b()
  {
    try
    {
      this.b = NetworkUtils.getDNS(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final NetworkUtils.DNS a()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */