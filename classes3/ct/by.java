package ct;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationManager;
import java.util.Iterator;

public final class by
  implements GpsStatus.Listener
{
  final bl a;
  volatile boolean b = false;
  private int c = 0;
  
  public by(bl parambl)
  {
    this.a = parambl;
  }
  
  private int a()
  {
    int j = -1;
    Object localObject = this.a.g.getGpsStatus(null);
    if (localObject == null) {}
    do
    {
      return j;
      this.c = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
    } while (localObject == null);
    int i = 0;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      j = i;
      if (i > this.c) {
        break;
      }
      if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
        i += 1;
      }
    }
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (a() < 4);
      localObject = this.a.g.getLastKnownLocation("gps");
    } while (localObject == null);
    Object localObject = new cl((Location)localObject, System.currentTimeMillis(), this.c, a(), 4);
    this.a.c(localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */