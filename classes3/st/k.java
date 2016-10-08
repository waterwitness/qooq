package st;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import java.util.Iterator;

final class k
  extends c
  implements GpsStatus.Listener, LocationListener
{
  private static k c;
  private LocationManager d;
  private boolean e;
  private GpsStatus f;
  private a g;
  private Looper h;
  private Context i;
  private final l j = new l();
  
  private void a(long paramLong)
  {
    this.d.requestLocationUpdates("gps", paramLong, 0.0F, this, this.h);
  }
  
  static k f()
  {
    if (c == null) {
      c = new k();
    }
    return c;
  }
  
  final void a() {}
  
  final void a(Context paramContext)
  {
    this.i = paramContext;
    this.d = ((LocationManager)paramContext.getSystemService("location"));
    if ((this.d != null) && (this.d.getProvider("gps") != null)) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      return;
    }
  }
  
  final void a(Context paramContext, Handler paramHandler, b.1 param1)
  {
    if (!this.e) {
      return;
    }
    this.g = ((a)param1);
    if (paramHandler != null) {}
    for (paramContext = paramHandler.getLooper();; paramContext = null)
    {
      this.h = paramContext;
      a(this.g.a);
      this.d.addGpsStatusListener(this);
      this.j.a = Math.max(5000L, Math.min(this.g.a + 5000L, 65000L));
      return;
    }
  }
  
  final void a(Handler paramHandler, b.1 param1)
    throws Exception
  {
    if (param1 == null) {}
    for (;;)
    {
      try
      {
        param1 = new a(30000L);
        super.a(paramHandler, param1);
        return;
      }
      finally {}
      if ((param1 instanceof a)) {
        param1 = (a)param1;
      } else {
        param1 = new a(param1.a);
      }
    }
  }
  
  final void b()
  {
    if ((!this.e) || (!this.b) || (this.g.a >= 300000L)) {
      return;
    }
    a(300000L);
  }
  
  final void b(Context paramContext)
  {
    if (!this.e) {
      return;
    }
    this.d.removeUpdates(this);
    this.d.removeGpsStatusListener(this);
  }
  
  final void c()
  {
    if ((!this.e) || (!this.b) || (this.g.a >= 300000L)) {
      return;
    }
    a(this.g.a);
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    if (paramInt == 4)
    {
      if (this.f == null) {
        this.f = this.d.getGpsStatus(null);
      }
    }
    else {
      return;
    }
    this.d.getGpsStatus(this.f);
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    boolean bool = w.f;
    if (!Settings.Secure.getString(this.i.getContentResolver(), "mock_location").equals("0")) {}
    for (int k = 1; k != 0; k = 0) {
      return;
    }
    if (this.f != null)
    {
      Iterator localIterator = this.f.getSatellites().iterator();
      k = 0;
      while (localIterator.hasNext())
      {
        if (!((GpsSatellite)localIterator.next()).usedInFix()) {
          break label158;
        }
        k += 1;
      }
    }
    for (;;)
    {
      this.j.a(paramLocation.getAccuracy(), k, paramLocation.getTime());
      b(new b(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude(), paramLocation.getAccuracy(), paramLocation.getSpeed(), k, this.j.c, this.j.b / 1000L, (byte)0));
      return;
      label158:
      break;
      k = 0;
    }
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  static final class a
    extends b.1
  {
    a(long paramLong)
    {
      super();
    }
  }
  
  static final class b
    extends o
  {
    final double a;
    final double b;
    final double c;
    final float d;
    final float e;
    final float f;
    final int g;
    final long h;
    
    private b(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, long paramLong)
    {
      super();
      this.a = paramDouble1;
      this.b = paramDouble2;
      this.c = paramDouble3;
      this.d = paramFloat1;
      this.e = paramFloat2;
      this.g = paramInt;
      this.f = paramFloat3;
      this.h = paramLong;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */