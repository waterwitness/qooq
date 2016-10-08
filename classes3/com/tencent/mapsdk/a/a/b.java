package com.tencent.mapsdk.a.a;

import com.tencent.mapsdk.a.b.c;
import com.tencent.mapsdk.a.d.e;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

public final class b
  extends a
{
  private c d;
  private c e;
  private double f;
  private double g;
  
  public b(e parame, c paramc, long paramLong, CancelableCallback paramCancelableCallback)
  {
    super(parame, paramLong, paramCancelableCallback);
    this.e = paramc;
  }
  
  protected final void a(float paramFloat)
  {
    double d1 = this.f;
    double d2 = paramFloat;
    double d3 = this.g;
    double d4 = paramFloat;
    this.d.b = (d1 * d2 + this.d.b);
    this.d.a += d3 * d4;
    this.b.a(this.d);
  }
  
  protected final void c()
  {
    this.d = this.b.b();
    this.f = (this.e.b - this.d.b);
    this.g = (this.e.a - this.d.a);
  }
  
  protected final void d()
  {
    this.b.a(this.e);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */