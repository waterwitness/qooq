package st;

import android.net.wifi.WifiManager;
import android.os.Handler;

final class z
  extends e
{
  private final WifiManager c;
  
  z(WifiManager paramWifiManager, Handler paramHandler)
  {
    super(paramHandler);
    this.c = paramWifiManager;
  }
  
  final void a()
  {
    this.c.startScan();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */