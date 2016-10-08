package com.tencent.mapsdk.a.a;

import android.graphics.PointF;
import com.tencent.mapsdk.a.d.b;
import com.tencent.mapsdk.a.d.e;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

public final class c
  extends a
{
  private PointF d;
  private double e;
  private double f;
  
  public c(e parame, double paramDouble, PointF paramPointF, long paramLong, CancelableCallback paramCancelableCallback)
  {
    super(parame, paramLong, paramCancelableCallback);
    this.e = paramDouble;
    this.d = paramPointF;
  }
  
  protected final void a(float paramFloat)
  {
    this.b.a(this.f * paramFloat, this.d, false, null);
  }
  
  protected final void c()
  {
    double d1 = this.b.c();
    this.f = (this.e - d1);
  }
  
  protected final void d()
  {
    this.b.a(this.e, this.d, false, 0L, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */