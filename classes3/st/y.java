package st;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import java.util.List;

final class y
  extends c
{
  private static y d;
  WifiManager c;
  private final BroadcastReceiver e = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"))
      {
        paramAnonymousContext = y.this;
        try
        {
          paramAnonymousIntent = paramAnonymousContext.c.getScanResults();
          if ((paramAnonymousIntent != null) && (!paramAnonymousIntent.isEmpty())) {
            break label54;
          }
          throw new Exception("WifiScanMsg: null or empty scan result list");
        }
        catch (Exception paramAnonymousContext)
        {
          paramAnonymousContext.printStackTrace();
        }
      }
      return;
      label54:
      paramAnonymousContext.b(new y.a(paramAnonymousIntent));
    }
  };
  private final IntentFilter f = new IntentFilter("android.net.wifi.SCAN_RESULTS");
  private z g;
  private long h = 10000L;
  
  static y f()
  {
    if (d == null) {
      d = new y();
    }
    return d;
  }
  
  private boolean g()
  {
    return this.c != null;
  }
  
  final void a() {}
  
  final void a(Context paramContext)
  {
    this.c = ((WifiManager)paramContext.getSystemService("wifi"));
  }
  
  final void a(Context paramContext, Handler paramHandler, b.1 param1)
  {
    if (!g()) {
      return;
    }
    paramContext.registerReceiver(this.e, this.f, null, paramHandler);
    this.h = param1.a;
    param1 = this.c;
    if (paramHandler != null) {}
    for (;;)
    {
      this.g = new z(param1, paramHandler);
      this.g.a(this.h, 0L);
      return;
      paramHandler = new Handler(paramContext.getMainLooper());
    }
  }
  
  final void a(Handler paramHandler, b.1 param1)
    throws Exception
  {
    if (param1 != null) {}
    for (;;)
    {
      try
      {
        super.a(paramHandler, param1);
        return;
      }
      finally {}
      param1 = new b.1(10000L);
    }
  }
  
  final void b()
  {
    if ((!g()) || (!this.b) || (this.h >= 90000L)) {
      return;
    }
    this.g.a(90000L, 0L);
  }
  
  final void b(Context paramContext)
  {
    if (!g()) {
      return;
    }
    paramContext.unregisterReceiver(this.e);
    this.g.b();
  }
  
  final void c()
  {
    if ((!g()) || (!this.b) || (this.h >= 90000L)) {
      return;
    }
    this.g.a(this.h, 0L);
  }
  
  static final class a
    extends o
  {
    final List<ScanResult> a;
    
    a(List<ScanResult> paramList)
    {
      super();
      this.a = paramList;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */