package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.a.d.a.1;
import com.tencent.mapsdk.a.d.b;
import com.tencent.mapsdk.a.d.c;
import com.tencent.mapsdk.a.d.e;
import com.tencent.mapsdk.a.d.f;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;

public class TencentMap
{
  private e a;
  private com.tencent.mapsdk.a.d.a b;
  private c c;
  
  public TencentMap(e parame)
  {
    this.a = parame;
    this.b = parame.e();
    this.c = parame.b();
  }
  
  private void a(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback)
  {
    if ((!this.a.f().i()) || (paramLong <= 0L)) {
      paramCameraUpdate.a().a(false);
    }
    paramCameraUpdate.a().a(paramCancelableCallback);
    paramCameraUpdate.a().a(paramLong);
    this.a.c().a(paramCameraUpdate.a());
  }
  
  public void animateTo(LatLng paramLatLng)
  {
    a(CameraUpdateFactory.newLatLng(paramLatLng), 1000L, null);
  }
  
  public void animateTo(LatLng paramLatLng, long paramLong, CancelableCallback paramCancelableCallback)
  {
    a(CameraUpdateFactory.newLatLng(paramLatLng), paramLong, paramCancelableCallback);
  }
  
  public void animateTo(LatLng paramLatLng, final Runnable paramRunnable)
  {
    a(CameraUpdateFactory.newLatLng(paramLatLng), 1000L, new CancelableCallback()
    {
      public void onCancel()
      {
        paramRunnable.run();
      }
      
      public void onFinish()
      {
        paramRunnable.run();
      }
    });
  }
  
  public final void clearAllOverlays()
  {
    this.b.a();
  }
  
  public boolean clearCache()
  {
    return com.tencent.mapsdk.a.e.a.a().b();
  }
  
  public LatLng getMapCenter()
  {
    return this.c.b().getTarget();
  }
  
  public int getMaxZoomLevel()
  {
    return this.c.g().a();
  }
  
  public int getMinZoomLevel()
  {
    return this.c.h().a();
  }
  
  public final String getVersion()
  {
    return "1.1.2";
  }
  
  public int getZoomLevel()
  {
    return (int)this.c.b().getZoom();
  }
  
  public final boolean isAppKeyAvailable()
  {
    return e.q();
  }
  
  public final boolean isSatelliteEnabled()
  {
    return this.a.k() == 2;
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    this.a.c().a(paramCameraUpdate.a());
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2)
  {
    a(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), 1000L, null);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2, long paramLong, CancelableCallback paramCancelableCallback)
  {
    a(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), paramLong, paramCancelableCallback);
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    a(CameraUpdateFactory.newLatLngZoom(paramLatLng, getZoomLevel()), 0L, null);
  }
  
  public void setOnMapCameraChangeListener(OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    this.a.h().a(paramOnMapCameraChangeListener);
  }
  
  public void setOnMapClickListener(OnMapClickListener paramOnMapClickListener)
  {
    this.a.h().a(paramOnMapClickListener);
  }
  
  public void setOnMapLoadedListener(OnMapLoadedListener paramOnMapLoadedListener)
  {
    this.a.c().a(paramOnMapLoadedListener);
  }
  
  public void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.a.h().a(paramOnMapLongClickListener);
  }
  
  public void setSatelliteEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a(2);
      return;
    }
    this.a.a(1);
  }
  
  public void setZoom(int paramInt)
  {
    a(CameraUpdateFactory.zoomTo(paramInt), 0L, null);
  }
  
  public void stopAnimation()
  {
    this.a.d().stopAnimation();
  }
  
  public void zoomIn()
  {
    a(CameraUpdateFactory.zoomIn(), 1000L, null);
  }
  
  public void zoomInFixing(int paramInt1, int paramInt2)
  {
    a(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)), 1000L, null);
  }
  
  public void zoomOut()
  {
    a(CameraUpdateFactory.zoomOut(), 1000L, null);
  }
  
  public void zoomOutFixing(int paramInt1, int paramInt2)
  {
    a(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)), 1000L, null);
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    zoomToSpan(new LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
  }
  
  public void zoomToSpan(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    paramLatLng1 = new LatLngBounds.Builder().include(paramLatLng1).include(paramLatLng2).build();
    this.a.c().a(CameraUpdateFactory.newLatLngBounds(paramLatLng1, 10).a());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\TencentMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */