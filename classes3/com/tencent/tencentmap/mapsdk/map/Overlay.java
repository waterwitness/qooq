package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mapsdk.a.d.a;
import com.tencent.mapsdk.a.d.e;

public class Overlay
{
  protected static final float SHADOW_X_SKEW = -0.89F;
  protected static final float SHADOW_Y_SCALE = 0.5F;
  protected a contentLayer;
  protected String id = getId();
  protected boolean isVisible = true;
  protected e mapContext;
  protected MapView mapView;
  protected float zIndex = 0.0F;
  
  public boolean checkInBounds()
  {
    return false;
  }
  
  public void destroy() {}
  
  public void draw(Canvas paramCanvas)
  {
    draw(paramCanvas, this.mapView);
  }
  
  protected void draw(Canvas paramCanvas, MapView paramMapView) {}
  
  public String getId()
  {
    if (this.id == null) {
      this.id = a.a("Overlay");
    }
    return this.id;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public void init(MapView paramMapView)
  {
    this.mapView = paramMapView;
    this.mapContext = paramMapView.a();
    this.contentLayer = this.mapContext.e();
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public void onEmptyTap(GeoPoint paramGeoPoint) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onLongPress(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public void onRemoveOverlay() {}
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public void remove()
  {
    onRemoveOverlay();
    this.contentLayer.b(getId());
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    this.mapContext.b(false);
  }
  
  public void setZIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    this.contentLayer.c();
    this.mapContext.b(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\Overlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */