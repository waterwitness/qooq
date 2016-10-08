package com.tencent.mapsdk.a.c;

import com.tencent.mapsdk.a.d;
import com.tencent.mapsdk.a.d.b;
import com.tencent.mapsdk.a.d.e;
import com.tencent.mapsdk.raster.model.CameraPosition;

public final class c
  extends a
{
  private CameraPosition d;
  
  public final void a(e parame)
  {
    parame = parame.c();
    if (this.a) {
      parame.a(d.a(this.d.getTarget()), this.b, this.c);
    }
    for (;;)
    {
      if (this.d.getZoom() > 0.0F) {
        parame.b(this.d.getZoom(), this.a, this.c);
      }
      return;
      parame.a(d.a(this.d.getTarget()));
    }
  }
  
  public final void a(CameraPosition paramCameraPosition)
  {
    this.d = paramCameraPosition;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */