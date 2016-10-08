package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.CameraPosition;

public abstract interface OnMapCameraChangeListener
{
  public abstract void onCameraChange(CameraPosition paramCameraPosition);
  
  public abstract void onCameraChangeFinish(CameraPosition paramCameraPosition);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\OnMapCameraChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */