package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.a.d;
import com.tencent.mapsdk.raster.model.LatLng;

public class MapController
{
  private boolean a = true;
  private MapView b;
  
  public MapController(MapView paramMapView)
  {
    this.b = paramMapView;
  }
  
  public void animateTo(LatLng paramLatLng, long paramLong, CancelableCallback paramCancelableCallback)
  {
    this.b.getMap().animateTo(paramLatLng, paramLong, paramCancelableCallback);
  }
  
  public void animateTo(GeoPoint paramGeoPoint)
  {
    this.b.getMap().animateTo(d.a(paramGeoPoint));
  }
  
  public void animateTo(GeoPoint paramGeoPoint, long paramLong, CancelableCallback paramCancelableCallback)
  {
    this.b.getMap().animateTo(d.a(paramGeoPoint), paramLong, paramCancelableCallback);
  }
  
  public void animateTo(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    this.b.getMap().animateTo(d.a(paramGeoPoint), paramRunnable);
  }
  
  public Projection getProjection()
  {
    return this.b.getProjection();
  }
  
  public boolean isAnimateEable()
  {
    return this.a;
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2)
  {
    this.b.getMap().scrollBy(paramFloat1, paramFloat2);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2, long paramLong, CancelableCallback paramCancelableCallback)
  {
    this.b.getMap().scrollBy(paramFloat1, paramFloat2, paramLong, paramCancelableCallback);
  }
  
  public void setAnimateEable(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setCenter(GeoPoint paramGeoPoint)
  {
    this.b.getMap().setCenter(d.a(paramGeoPoint));
  }
  
  public void setOnMapCameraChangeListener(OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    this.b.getMap().setOnMapCameraChangeListener(paramOnMapCameraChangeListener);
  }
  
  public void setZoom(int paramInt)
  {
    this.b.getMap().setZoom(paramInt);
  }
  
  public void stopAnimte()
  {
    this.b.stopAnimation();
  }
  
  public void zoomIn()
  {
    this.b.getMap().zoomIn();
  }
  
  public void zoomInFixing(int paramInt1, int paramInt2)
  {
    this.b.getMap().zoomInFixing(paramInt1, paramInt2);
  }
  
  public void zoomOut()
  {
    this.b.getMap().zoomOut();
  }
  
  public void zoomOutFixing(int paramInt1, int paramInt2)
  {
    this.b.getMap().zoomOutFixing(paramInt1, paramInt2);
  }
  
  public void zoomToSpan(int paramInt1, int paramInt2)
  {
    this.b.getMap().zoomToSpan(paramInt1 / 1000000.0D, paramInt2 / 1000000.0D);
  }
  
  public void zoomToSpan(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    this.b.getMap().zoomToSpan(d.a(paramGeoPoint1), d.a(paramGeoPoint2));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\MapController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */