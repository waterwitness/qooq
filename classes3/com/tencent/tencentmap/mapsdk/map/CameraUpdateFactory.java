package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.a.c.f;
import com.tencent.mapsdk.a.c.g;
import com.tencent.mapsdk.a.c.h;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CameraPosition.Builder;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;

public final class CameraUpdateFactory
{
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    return new CameraUpdate(com.tencent.mapsdk.a.d.a(paramCameraPosition));
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    return new CameraUpdate(com.tencent.mapsdk.a.d.a(CameraPosition.builder().target(paramLatLng).build()));
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    return new CameraUpdate(com.tencent.mapsdk.a.d.a(paramLatLngBounds, 0, 0, paramInt));
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    return new CameraUpdate(com.tencent.mapsdk.a.d.a(paramLatLngBounds, paramInt1, paramInt2, paramInt3));
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraUpdate(com.tencent.mapsdk.a.d.a(CameraPosition.builder().target(paramLatLng).zoom(paramFloat).build()));
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    com.tencent.mapsdk.a.c.d locald = new com.tencent.mapsdk.a.c.d();
    locald.a(paramFloat1);
    locald.b(paramFloat2);
    return new CameraUpdate(locald);
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    return new CameraUpdate(com.tencent.mapsdk.a.d.a(paramFloat, null));
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    return new CameraUpdate(com.tencent.mapsdk.a.d.a(paramFloat, paramPoint));
  }
  
  public static CameraUpdate zoomIn()
  {
    return new CameraUpdate(new f());
  }
  
  public static CameraUpdate zoomOut()
  {
    return new CameraUpdate(new g());
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    h localh = new h();
    localh.a(paramFloat);
    return new CameraUpdate(localh);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\CameraUpdateFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */