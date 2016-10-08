package com.tencent.mapsdk.raster.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class LatLng
  implements Cloneable
{
  private static DecimalFormat a = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
  private final double b;
  private final double c;
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {}
    for (this.b = a(paramDouble2);; this.b = a(((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D))
    {
      this.c = a(Math.max(-90.0D, Math.min(90.0D, paramDouble1)));
      return;
    }
  }
  
  private static double a(double paramDouble)
  {
    return Double.parseDouble(a.format(paramDouble));
  }
  
  public final LatLng clone()
  {
    return new LatLng(this.c, this.b);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LatLng)) {
        return false;
      }
      paramObject = (LatLng)paramObject;
    } while ((Double.doubleToLongBits(this.c) == Double.doubleToLongBits(((LatLng)paramObject).c)) && (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(((LatLng)paramObject).b)));
    return false;
  }
  
  public final double getLatitude()
  {
    return this.c;
  }
  
  public final double getLongitude()
  {
    return this.b;
  }
  
  public final int hashCode()
  {
    long l = Double.doubleToLongBits(this.c);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.b);
    return (i + 31) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    return "lat/lng: (" + this.c + "," + this.b + ")";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\raster\model\LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */