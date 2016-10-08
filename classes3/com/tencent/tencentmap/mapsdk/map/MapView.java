package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ListView;
import com.tencent.mapsdk.a.d;
import com.tencent.mapsdk.a.d.a;
import com.tencent.mapsdk.a.d.b;
import com.tencent.mapsdk.a.d.c;
import com.tencent.mapsdk.a.d.e;
import com.tencent.mapsdk.a.d.f;
import com.tencent.mapsdk.raster.model.LatLng;

public class MapView
  extends ViewGroup
{
  private e a;
  private f b;
  private Projection c;
  private TencentMap d;
  private UiSettings e;
  @Deprecated
  private MapController f;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    int i = paramInt3 & 0x7;
    paramInt3 &= 0x70;
    float f1;
    if (i == 5)
    {
      f1 = paramFloat1 - paramInt1;
      if (paramInt3 != 80) {
        break label89;
      }
      paramFloat1 = paramFloat2 - paramInt2;
    }
    for (;;)
    {
      paramInt3 = Math.round(f1);
      i = Math.round(paramFloat1);
      paramView.layout(paramInt3, i, paramInt3 + paramInt1, i + paramInt2);
      return;
      f1 = paramFloat1;
      if (i != 1) {
        break;
      }
      f1 = paramFloat1 - paramInt1 / 2;
      break;
      label89:
      paramFloat1 = paramFloat2;
      if (paramInt3 == 16) {
        paramFloat1 = paramFloat2 - paramInt2 / 2;
      }
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramView instanceof ListView))
    {
      View localView = (View)paramView.getParent();
      if (localView != null)
      {
        paramArrayOfInt[0] = localView.getWidth();
        paramArrayOfInt[1] = localView.getHeight();
      }
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramView.measure(0, 0);
    }
    if (paramInt1 == -2) {
      paramArrayOfInt[0] = paramView.getMeasuredWidth();
    }
    while (paramInt2 == -2)
    {
      paramArrayOfInt[1] = paramView.getMeasuredHeight();
      return;
      if (paramInt1 == -1) {
        paramArrayOfInt[0] = getMeasuredWidth();
      } else {
        paramArrayOfInt[0] = paramInt1;
      }
    }
    if (paramInt2 == -1)
    {
      paramArrayOfInt[1] = getMeasuredHeight();
      return;
    }
    paramArrayOfInt[1] = paramInt2;
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams)
  {
    int[] arrayOfInt = new int[2];
    a(paramView, paramLayoutParams.width, paramLayoutParams.height, arrayOfInt);
    a(paramView, arrayOfInt[0], arrayOfInt[1], LayoutParams.a(paramLayoutParams), LayoutParams.b(paramLayoutParams), LayoutParams.c(paramLayoutParams));
  }
  
  private void b()
  {
    Context localContext = getContext();
    this.a = new e(this);
    this.b = this.a.h();
    setOnKeyListener(this.b);
    this.c = new Projection(this.a);
    this.e = new UiSettings(this.a.f());
    this.d = new TencentMap(this.a);
    this.f = new MapController(this);
    if ((localContext instanceof MapActivity)) {
      ((MapActivity)localContext).setMapView(this);
    }
    setBackgroundColor(-657936);
  }
  
  private void c()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView != null) {
        layout(localView);
      }
      i += 1;
    }
  }
  
  protected final e a()
  {
    return this.a;
  }
  
  public final boolean addOverlay(Overlay paramOverlay)
  {
    if (paramOverlay == null) {
      return false;
    }
    paramOverlay.init(this);
    this.a.e().a(paramOverlay);
    return true;
  }
  
  public final void clearAllOverlays()
  {
    this.d.clearAllOverlays();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.b.a();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    setClickable(false);
    this.b.b(MotionEvent.obtain(paramMotionEvent));
    getParent().requestDisallowInterceptTouchEvent(true);
    if ((super.dispatchTouchEvent(paramMotionEvent)) || (this.b.a(paramMotionEvent))) {
      bool = true;
    }
    return bool;
  }
  
  public MapController getController()
  {
    return this.f;
  }
  
  public int getLatitudeSpan()
  {
    return this.c.getLatitudeSpan();
  }
  
  public int getLongitudeSpan()
  {
    return this.c.getLongitudeSpan();
  }
  
  public TencentMap getMap()
  {
    return this.d;
  }
  
  public GeoPoint getMapCenter()
  {
    return d.b(this.d.getMapCenter());
  }
  
  public int getMaxZoomLevel()
  {
    return this.d.getMaxZoomLevel();
  }
  
  public int getMinZoomLevel()
  {
    return this.d.getMinZoomLevel();
  }
  
  public Projection getProjection()
  {
    return this.c;
  }
  
  public UiSettings getUiSettings()
  {
    return this.e;
  }
  
  public final String getVersion()
  {
    return this.d.getVersion();
  }
  
  public int getZoomLevel()
  {
    return this.d.getZoomLevel();
  }
  
  public final boolean isAppKeyAvailable()
  {
    return this.d.isAppKeyAvailable();
  }
  
  public boolean isSatellite()
  {
    return this.d.isSatelliteEnabled();
  }
  
  public void layout()
  {
    c();
  }
  
  public void layout(View paramView)
  {
    LayoutParams localLayoutParams;
    if (this == paramView.getParent())
    {
      if (!(paramView.getLayoutParams() instanceof LayoutParams)) {
        break label143;
      }
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams.mode != 0) {
        break label136;
      }
      int[] arrayOfInt = new int[2];
      a(paramView, localLayoutParams.width, localLayoutParams.height, arrayOfInt);
      if (localLayoutParams.getPoint() != null)
      {
        PointF localPointF = this.a.b().a(localLayoutParams.getPoint());
        if (localPointF != null)
        {
          localPointF.x += LayoutParams.a(localLayoutParams);
          localPointF.y += LayoutParams.b(localLayoutParams);
          a(paramView, arrayOfInt[0], arrayOfInt[1], localPointF.x, localPointF.y, LayoutParams.c(localLayoutParams));
        }
      }
    }
    return;
    label136:
    a(paramView, localLayoutParams);
    return;
    label143:
    a(paramView, new LayoutParams(paramView.getLayoutParams()));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    paramBundle = this.a;
    e.l();
  }
  
  public void onDestroy()
  {
    this.a.m();
  }
  
  public void onDestroyView() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c();
  }
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    e locale = this.a;
    e.p();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    e locale = this.a;
    e.o();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle = this.a;
    e.n();
  }
  
  public void onStop() {}
  
  public void refreshMap()
  {
    postInvalidate();
  }
  
  public final void removeOverlay(Overlay paramOverlay)
  {
    paramOverlay.remove();
  }
  
  public void setCleanCachOnPause(boolean paramBoolean) {}
  
  public void setGoogleMapEnable(boolean paramBoolean)
  {
    com.tencent.mapsdk.a.b.d = paramBoolean;
  }
  
  public void setSatellite(boolean paramBoolean)
  {
    this.d.setSatelliteEnabled(paramBoolean);
  }
  
  public void stopAnimation()
  {
    clearAnimation();
    this.a.c().clearAnimation();
    this.b.b();
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public static final int BOTTOM = 80;
    public static final int BOTTOM_CENTER = 81;
    public static final int CENTER = 17;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 16;
    public static final int LEFT = 3;
    public static final int MODE_MAP = 0;
    public static final int MODE_VIEW = 1;
    public static final int RIGHT = 5;
    public static final int TOP = 48;
    public static final int TOP_LEFT = 51;
    private int a = 51;
    private LatLng b = null;
    private int c = 0;
    private int d = 0;
    public int mode = 1;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, LatLng paramLatLng, int paramInt3)
    {
      this(paramInt1, paramInt2, paramLatLng, 0, 0, paramInt3);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, LatLng paramLatLng, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt2);
      this.mode = 0;
      setPoint(paramLatLng);
      this.c = paramInt3;
      this.d = paramInt4;
      this.a = paramInt5;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3)
    {
      this(paramInt1, paramInt2, paramGeoPoint, 0, 0, paramInt3);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3, int paramInt4, int paramInt5)
    {
      this(paramInt1, paramInt2, d.a(paramGeoPoint), paramInt3, paramInt4, paramInt5);
    }
    
    protected LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LatLng getPoint()
    {
      return this.b;
    }
    
    public void setPoint(LatLng paramLatLng)
    {
      this.b = paramLatLng;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */