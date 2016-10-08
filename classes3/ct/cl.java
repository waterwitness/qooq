package ct;

import android.location.Location;

public final class cl
  extends cn
{
  public final Location a;
  public final long b;
  public final int c;
  private int d;
  private int e;
  
  public cl(Location paramLocation, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLocation;
    this.b = paramLong;
    this.d = paramInt1;
    this.c = paramInt2;
    this.e = paramInt3;
  }
  
  public cl(cl paramcl)
  {
    if (paramcl.a == null) {}
    for (Location localLocation = null;; localLocation = new Location(paramcl.a))
    {
      this.a = localLocation;
      this.b = paramcl.b;
      this.d = paramcl.d;
      this.c = paramcl.c;
      this.e = paramcl.e;
      return;
    }
  }
  
  public final String toString()
  {
    return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.d + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.e + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */