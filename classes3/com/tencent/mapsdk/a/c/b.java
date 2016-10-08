package com.tencent.mapsdk.a.c;

import com.tencent.mapsdk.a.d;
import com.tencent.mapsdk.a.d.e;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;

public final class b
  extends a
{
  private int d;
  private int e;
  private LatLngBounds f;
  private int g;
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void a(e parame)
  {
    com.tencent.mapsdk.a.d.b localb = parame.c();
    if (this.e == 0)
    {
      i = localb.getHeight() - this.g * 2;
      this.e = i;
      if (this.d != 0) {
        break label91;
      }
    }
    label91:
    for (int i = localb.getWidth() - this.g * 2;; i = this.d - this.g * 2)
    {
      this.d = i;
      if ((this.e != 0) && (this.d != 0)) {
        break label107;
      }
      return;
      i = this.e - this.g * 2;
      break;
    }
    label107:
    Object localObject2 = this.f.getNortheast();
    Object localObject1 = this.f.getSouthwest();
    localObject2 = d.a((LatLng)localObject2);
    localObject1 = d.a((LatLng)localObject1);
    double d3 = ((com.tencent.mapsdk.a.b.c)localObject2).a - ((com.tencent.mapsdk.a.b.c)localObject1).a;
    double d1 = ((com.tencent.mapsdk.a.b.c)localObject2).b - ((com.tencent.mapsdk.a.b.c)localObject1).b;
    float f1;
    if (this.e * 1.0F / this.d > (float)(d3 / d1))
    {
      f1 = (float)(this.e * 156543.0339D / d3);
      parame = parame.b().a(new com.tencent.mapsdk.a.b.a(0, f1));
      double d2 = ((com.tencent.mapsdk.a.b.c)localObject1).a;
      d3 /= 2.0D;
      double d4 = ((com.tencent.mapsdk.a.b.c)localObject1).b;
      localObject1 = new com.tencent.mapsdk.a.b.c(d3 + d2, d1 / 2.0D + d4);
      if (!this.a) {
        break label321;
      }
      localb.a((com.tencent.mapsdk.a.b.c)localObject1, this.b, this.c);
    }
    for (;;)
    {
      localb.b(parame.c(), this.a, this.c);
      return;
      f1 = (float)(this.d * 156543.0339D / d1);
      break;
      label321:
      localb.a((com.tencent.mapsdk.a.b.c)localObject1);
    }
  }
  
  public final void a(LatLngBounds paramLatLngBounds)
  {
    this.f = paramLatLngBounds;
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void c(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */