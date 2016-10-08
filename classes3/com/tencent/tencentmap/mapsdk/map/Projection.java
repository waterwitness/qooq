package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.mapsdk.a.d;
import com.tencent.mapsdk.a.d.b;
import com.tencent.mapsdk.a.d.c;
import com.tencent.mapsdk.a.d.e;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.VisibleRegion;

public class Projection
{
  private e a;
  private c b;
  
  public Projection(e parame)
  {
    this.a = parame;
    this.b = parame.b();
  }
  
  public double distanceBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return d.a(paramLatLng1, paramLatLng2);
  }
  
  public double distanceBetween(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    return distanceBetween(d.a(paramGeoPoint1), d.a(paramGeoPoint2));
  }
  
  public GeoPoint fromPixels(int paramInt1, int paramInt2)
  {
    return d.b(this.b.a(paramInt1, paramInt2));
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    return this.b.a(paramPoint.x, paramPoint.y);
  }
  
  public int getLatitudeSpan()
  {
    LatLngBounds localLatLngBounds = getVisibleRegion().getLatLngBounds();
    LatLng localLatLng = localLatLngBounds.getSouthwest();
    return (int)(localLatLngBounds.getNortheast().getLatitude() * 1000000.0D - localLatLng.getLatitude() * 1000000.0D);
  }
  
  public int getLongitudeSpan()
  {
    LatLngBounds localLatLngBounds = getVisibleRegion().getLatLngBounds();
    LatLng localLatLng = localLatLngBounds.getSouthwest();
    return (int)(localLatLngBounds.getNortheast().getLongitude() * 1000000.0D - localLatLng.getLongitude() * 1000000.0D);
  }
  
  public float getScalePerPixel()
  {
    return this.b.d();
  }
  
  public VisibleRegion getVisibleRegion()
  {
    int i = this.a.c().getWidth();
    int j = this.a.c().getHeight();
    LatLng localLatLng1 = fromScreenLocation(new Point(0, 0));
    LatLng localLatLng2 = fromScreenLocation(new Point(i, 0));
    LatLng localLatLng3 = fromScreenLocation(new Point(0, j));
    LatLng localLatLng4 = fromScreenLocation(new Point(i, j));
    return new VisibleRegion(localLatLng3, localLatLng4, localLatLng1, localLatLng2, LatLngBounds.builder().include(localLatLng3).include(localLatLng4).include(localLatLng1).include(localLatLng2).build());
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    return this.b.a(paramFloat);
  }
  
  public float metersToPixels(double paramDouble1, double paramDouble2)
  {
    return this.b.a(paramDouble1, paramDouble2);
  }
  
  public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    Point localPoint = paramPoint;
    if (paramPoint == null) {
      localPoint = new Point();
    }
    paramGeoPoint = this.b.a(d.a(paramGeoPoint));
    localPoint.x = ((int)paramGeoPoint.x);
    localPoint.y = ((int)paramGeoPoint.y);
    return localPoint;
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
  {
    paramLatLng = this.b.a(paramLatLng);
    return new Point((int)paramLatLng.x, (int)paramLatLng.y);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */