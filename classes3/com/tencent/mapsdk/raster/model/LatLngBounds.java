package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.a.d;
import java.util.Arrays;

public class LatLngBounds
{
  private LatLng a;
  private LatLng b;
  
  private LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    paramLatLng1 = new Builder().include(paramLatLng1).include(paramLatLng2);
    this.a = new LatLng(Builder.a(paramLatLng1), Builder.b(paramLatLng1));
    this.b = new LatLng(Builder.c(paramLatLng1), Builder.d(paramLatLng1));
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  private boolean a(double paramDouble)
  {
    if (this.a.getLongitude() <= this.b.getLongitude()) {
      if ((this.a.getLongitude() > paramDouble) || (paramDouble > this.b.getLongitude())) {}
    }
    while ((this.a.getLongitude() <= paramDouble) || (paramDouble <= this.b.getLongitude()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(LatLngBounds paramLatLngBounds)
  {
    if ((paramLatLngBounds == null) || (paramLatLngBounds.b == null) || (paramLatLngBounds.a == null) || (this.b == null) || (this.a == null)) {}
    double d1;
    double d2;
    double d3;
    double d4;
    double d5;
    double d6;
    double d7;
    double d8;
    double d9;
    double d10;
    double d11;
    double d12;
    double d13;
    double d14;
    double d15;
    double d16;
    do
    {
      return false;
      d1 = paramLatLngBounds.b.getLongitude();
      d2 = paramLatLngBounds.a.getLongitude();
      d3 = this.b.getLongitude();
      d4 = this.a.getLongitude();
      d5 = this.b.getLongitude();
      d6 = this.a.getLongitude();
      d7 = paramLatLngBounds.b.getLongitude();
      d8 = this.a.getLongitude();
      d9 = paramLatLngBounds.b.getLatitude();
      d10 = paramLatLngBounds.a.getLatitude();
      d11 = this.b.getLatitude();
      d12 = this.a.getLatitude();
      d13 = this.b.getLatitude();
      d14 = this.a.getLatitude();
      d15 = paramLatLngBounds.b.getLatitude();
      d16 = paramLatLngBounds.a.getLatitude();
    } while ((Math.abs(d1 + d2 - d3 - d4) >= d5 - d6 + d7 - d8) || (Math.abs(d9 + d10 - d11 - d12) >= d13 - d14 + d15 - d16));
    return true;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  private static double c(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  private static double d(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    double d = paramLatLng.getLatitude();
    if ((this.a.getLatitude() <= d) && (d <= this.b.getLatitude())) {}
    for (int i = 1; (i != 0) && (a(paramLatLng.getLongitude())); i = 0) {
      return true;
    }
    return false;
  }
  
  public boolean contains(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null) {}
    while ((!contains(paramLatLngBounds.a)) || (!contains(paramLatLngBounds.b))) {
      return false;
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LatLngBounds)) {
        return false;
      }
      paramObject = (LatLngBounds)paramObject;
    } while ((this.a.equals(((LatLngBounds)paramObject).a)) && (this.b.equals(((LatLngBounds)paramObject).b)));
    return false;
  }
  
  public LatLng getNortheast()
  {
    return this.b;
  }
  
  public LatLng getSouthwest()
  {
    return this.a;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.a, this.b });
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    double d4 = Math.min(this.a.getLatitude(), paramLatLng.getLatitude());
    double d5 = Math.max(this.b.getLatitude(), paramLatLng.getLatitude());
    double d2 = this.b.getLongitude();
    double d3 = this.a.getLongitude();
    double d1 = paramLatLng.getLongitude();
    if (!a(d1)) {
      if (c(d3, d1) >= d(d2, d1)) {}
    }
    for (;;)
    {
      return new LatLngBounds(new LatLng(d4, d1), new LatLng(d5, d2));
      d2 = d1;
      d1 = d3;
      continue;
      d1 = d3;
    }
  }
  
  public boolean intersects(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null) {}
    while ((!a(paramLatLngBounds)) && (!paramLatLngBounds.a(this))) {
      return false;
    }
    return true;
  }
  
  public final String toString()
  {
    return d.a(new String[] { d.a("southwest", this.a), d.a("northeast", this.b) });
  }
  
  public static final class Builder
  {
    private double a = Double.POSITIVE_INFINITY;
    private double b = Double.NEGATIVE_INFINITY;
    private double c = NaN.0D;
    private double d = NaN.0D;
    
    public final LatLngBounds build()
    {
      return new LatLngBounds(new LatLng(this.a, this.c), new LatLng(this.b, this.d));
    }
    
    public final Builder include(LatLng paramLatLng)
    {
      int j = 1;
      this.a = Math.min(this.a, paramLatLng.getLatitude());
      this.b = Math.max(this.b, paramLatLng.getLatitude());
      double d1 = paramLatLng.getLongitude();
      if (Double.isNaN(this.c))
      {
        this.c = d1;
        this.d = d1;
      }
      label162:
      for (;;)
      {
        return this;
        int i;
        if (this.c <= this.d) {
          if ((this.c <= d1) && (d1 <= this.d)) {
            i = j;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label162;
          }
          if (LatLngBounds.a(this.c, d1) >= LatLngBounds.b(this.d, d1)) {
            break;
          }
          this.c = d1;
          return this;
          i = 0;
          continue;
          i = j;
          if (this.c > d1)
          {
            i = j;
            if (d1 > this.d) {
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\raster\model\LatLngBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */