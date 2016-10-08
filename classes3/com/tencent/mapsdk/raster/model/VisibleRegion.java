package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.a.d;
import java.util.Arrays;

public final class VisibleRegion
{
  private final LatLngBounds a;
  private final LatLng b;
  private final LatLng c;
  private final LatLng d;
  private final LatLng e;
  
  private VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.c = paramLatLng1;
    this.b = paramLatLng2;
    this.e = paramLatLng3;
    this.d = paramLatLng4;
    this.a = paramLatLngBounds;
  }
  
  public VisibleRegion(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this(1, paramLatLng1, paramLatLng2, paramLatLng3, paramLatLng4, paramLatLngBounds);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof VisibleRegion)) {
        return false;
      }
      paramObject = (VisibleRegion)paramObject;
    } while ((getNearLeft().equals(((VisibleRegion)paramObject).getNearLeft())) && (getNearRight().equals(((VisibleRegion)paramObject).getNearRight())) && (getFarLeft().equals(((VisibleRegion)paramObject).getFarLeft())) && (getFarRight().equals(((VisibleRegion)paramObject).getFarRight())) && (getLatLngBounds().equals(((VisibleRegion)paramObject).getLatLngBounds())));
    return false;
  }
  
  public final LatLng getFarLeft()
  {
    return this.e;
  }
  
  public final LatLng getFarRight()
  {
    return this.d;
  }
  
  public final LatLngBounds getLatLngBounds()
  {
    return this.a;
  }
  
  public final LatLng getNearLeft()
  {
    return this.c;
  }
  
  public final LatLng getNearRight()
  {
    return this.b;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { getNearLeft(), getNearRight(), getFarLeft(), getFarRight(), getLatLngBounds() });
  }
  
  public final String toString()
  {
    return d.a(new String[] { d.a("nearLeft", getNearLeft()), d.a("nearRight", getNearRight()), d.a("farLeft", getFarLeft()), d.a("farRight", getFarRight()), d.a("latLngBounds", getLatLngBounds()) });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\raster\model\VisibleRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */