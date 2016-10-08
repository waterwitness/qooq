package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.a.d.a.1;

public final class UiSettings
{
  public static final int LOGO_POSITION_CENTER_BOTTOM = 4;
  public static final int LOGO_POSITION_CENTER_TOP = 5;
  public static final int LOGO_POSITION_LEFT_BOTTOM = 0;
  public static final int LOGO_POSITION_LEFT_TOP = 3;
  public static final int LOGO_POSITION_RIGHT_BOTTOM = 1;
  public static final int LOGO_POSITION_RIGHT_TOP = 2;
  public static final int SCALEVIEW_POSITION_CENTER_BOTTOM = 1;
  public static final int SCALEVIEW_POSITION_LEFT_BOTTOM = 0;
  public static final int SCALEVIEW_POSITION_RIGHT_BOTTOM = 2;
  private a.1 a;
  
  public UiSettings(a.1 param1)
  {
    this.a = param1;
  }
  
  public final boolean isAnimationEnabled()
  {
    return this.a.i();
  }
  
  public final void setAnimationEnabled(boolean paramBoolean)
  {
    this.a.d(paramBoolean);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public final void setScaleControlsEnabled(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    this.a.c(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\UiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */