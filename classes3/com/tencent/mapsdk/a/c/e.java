package com.tencent.mapsdk.a.c;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.mapsdk.a.d.b;

public final class e
  extends a
{
  private float d;
  private Point e;
  
  public final void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void a(Point paramPoint)
  {
    this.e = paramPoint;
  }
  
  public final void a(com.tencent.mapsdk.a.d.e parame)
  {
    if (this.e != null)
    {
      PointF localPointF = new PointF(this.e.x, this.e.y);
      parame.c().a(this.d, localPointF, this.a, this.c);
      return;
    }
    parame.c().a(this.d, this.a, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */