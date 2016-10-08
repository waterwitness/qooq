package com.tencent.mapsdk.a.d;

import android.graphics.PointF;
import com.tencent.mapsdk.a.b.a;
import com.tencent.mapsdk.a.d;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CameraPosition.Builder;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import java.util.ArrayList;

public final class c
{
  private static final com.tencent.mapsdk.a.b.b a = new com.tencent.mapsdk.a.b.b(new com.tencent.mapsdk.a.b.c(-2.003750834E7D, -2.003750834E7D), new com.tencent.mapsdk.a.b.c(2.003750834E7D, 2.003750834E7D));
  private e b;
  private b c;
  private a d;
  private a e;
  private com.tencent.mapsdk.a.b.b f;
  private double g = 0.0D;
  private double h = 0.0D;
  private int i = 0;
  
  public c(e parame)
  {
    this.b = parame;
  }
  
  private double a(double paramDouble)
  {
    return this.c.d().d() * Math.cos(0.017453292519943295D * paramDouble);
  }
  
  private double a(boolean paramBoolean)
  {
    Object localObject = i();
    localObject = new LatLngBounds(d.a(localObject[0]), d.a(localObject[1]));
    if (paramBoolean) {
      return Math.abs(((LatLngBounds)localObject).getNortheast().getLongitude() - ((LatLngBounds)localObject).getSouthwest().getLongitude());
    }
    return Math.abs(((LatLngBounds)localObject).getNortheast().getLatitude() - ((LatLngBounds)localObject).getSouthwest().getLatitude());
  }
  
  private PointF a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PointF paramPointF, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    PointF localPointF = new PointF();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 >= Math.pow(2.0D, paramInt8)) || (paramInt2 >= Math.pow(2.0D, paramInt8))) {
      paramPointF = null;
    }
    do
    {
      return paramPointF;
      localPointF.x = ((paramInt1 - paramInt3) * paramInt7 + paramPointF.x);
      localPointF.y = ((paramInt2 - paramInt4) * paramInt7 + paramPointF.y);
      if ((localPointF.x + paramInt7 <= 0.0F) || (localPointF.x >= paramInt5) || (localPointF.y + paramInt7 <= 0.0F)) {
        break;
      }
      paramPointF = localPointF;
    } while (localPointF.y < paramInt6);
    return null;
  }
  
  private com.tencent.mapsdk.a.b.c[] i()
  {
    int j = this.c.getWidth();
    return new com.tencent.mapsdk.a.b.c[] { d.a(new PointF(0.0F, this.c.getHeight()), this.c.b(), this.c.a(), this.c.d()), d.a(new PointF(j, 0.0F), this.c.b(), this.c.a(), this.c.d()) };
  }
  
  public final float a(double paramDouble1, double paramDouble2)
  {
    return (float)(paramDouble2 / a(paramDouble1));
  }
  
  public final float a(float paramFloat)
  {
    return (float)(paramFloat / a(0.0D));
  }
  
  public final PointF a(LatLng paramLatLng)
  {
    com.tencent.mapsdk.a.b.c localc = this.c.b();
    PointF localPointF = this.c.a();
    a locala = this.c.d();
    paramLatLng = d.a(paramLatLng);
    double d3 = paramLatLng.b;
    double d4 = localc.b;
    double d1 = paramLatLng.a;
    double d2 = localc.a;
    d3 = (d3 - d4) / locala.d();
    d1 = (d1 - d2) / locala.d();
    paramLatLng = new PointF();
    paramLatLng.x = ((float)(localPointF.x + d3));
    paramLatLng.y = ((float)(localPointF.y - d1));
    return paramLatLng;
  }
  
  public final a a(a parama)
  {
    a locala;
    if (parama.c() < this.e.c()) {
      locala = new a(this.e.c());
    }
    do
    {
      return locala;
      locala = parama;
    } while (parama.c() <= this.d.c());
    return new a(this.d.c());
  }
  
  public final LatLng a(int paramInt1, int paramInt2)
  {
    return d.a(d.a(new PointF(paramInt1, paramInt2), this.c.b(), this.c.a(), this.c.d()));
  }
  
  public final ArrayList<com.tencent.mapsdk.a.e.b> a(com.tencent.mapsdk.a.b.c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    if (this.b.f().e()) {
      j = 1;
    }
    double d1 = a.c(j + paramInt1);
    int i1 = (int)((paramc.b + 2.003750834E7D) / (paramInt4 * d1));
    double d2 = i1 * paramInt4;
    int i2 = (int)((2.003750834E7D - paramc.a) / (paramInt4 * d1));
    Object localObject1 = new com.tencent.mapsdk.a.b.c(2.003750834E7D - i2 * paramInt4 * d1, d2 * d1 - 2.003750834E7D);
    Object localObject2 = this.c.a();
    PointF localPointF = new PointF();
    localPointF.x = ((float)((((com.tencent.mapsdk.a.b.c)localObject1).b - paramc.b) / d1 + ((PointF)localObject2).x));
    localPointF.y = ((float)(((PointF)localObject2).y - (((com.tencent.mapsdk.a.b.c)localObject1).a - paramc.a) / d1));
    localObject1 = new com.tencent.mapsdk.a.e.b(i1, i2, paramInt1);
    ((com.tencent.mapsdk.a.e.b)localObject1).d = localPointF;
    paramc = new ArrayList();
    paramc.add(localObject1);
    int m = 1;
    j = 0;
    int n = i1 - m;
    label223:
    int i3;
    int k;
    if (n <= i1 + m)
    {
      i3 = i2 + m;
      localObject1 = a(n, i3, i1, i2, localPointF, paramInt2, paramInt3, paramInt4, paramInt1);
      k = j;
      if (localObject1 != null)
      {
        if (j != 0) {
          break label605;
        }
        j = 1;
      }
    }
    label411:
    label598:
    label605:
    for (;;)
    {
      localObject2 = new com.tencent.mapsdk.a.e.b(n, i3, paramInt1);
      ((com.tencent.mapsdk.a.e.b)localObject2).d = ((PointF)localObject1);
      paramc.add(localObject2);
      k = j;
      i3 = i2 - m;
      localObject1 = a(n, i3, i1, i2, localPointF, paramInt2, paramInt3, paramInt4, paramInt1);
      j = k;
      if (localObject1 != null)
      {
        j = k;
        if (k == 0) {
          j = 1;
        }
        localObject2 = new com.tencent.mapsdk.a.e.b(n, i3, paramInt1);
        ((com.tencent.mapsdk.a.e.b)localObject2).d = ((PointF)localObject1);
        paramc.add(localObject2);
      }
      n += 1;
      break label223;
      n = i2 + m - 1;
      k = j;
      if (n > i2 - m)
      {
        i3 = i1 + m;
        localObject1 = a(i3, n, i1, i2, localPointF, paramInt2, paramInt3, paramInt4, paramInt1);
        j = k;
        if (localObject1 != null) {
          if (k != 0) {
            break label598;
          }
        }
      }
      for (j = 1;; j = k)
      {
        localObject2 = new com.tencent.mapsdk.a.e.b(i3, n, paramInt1);
        ((com.tencent.mapsdk.a.e.b)localObject2).d = ((PointF)localObject1);
        paramc.add(localObject2);
        i3 = i1 - m;
        localObject1 = a(i3, n, i1, i2, localPointF, paramInt2, paramInt3, paramInt4, paramInt1);
        k = j;
        if (localObject1 != null)
        {
          k = j;
          if (j == 0) {
            k = 1;
          }
          localObject2 = new com.tencent.mapsdk.a.e.b(i3, n, paramInt1);
          ((com.tencent.mapsdk.a.e.b)localObject2).d = ((PointF)localObject1);
          paramc.add(localObject2);
        }
        n -= 1;
        break label411;
        if (k != 0)
        {
          m += 1;
          break;
        }
        return paramc;
      }
    }
  }
  
  public final void a()
  {
    this.f = a;
    this.d = new a(19.0D);
    this.e = new a(a.a);
    this.c = this.b.c();
  }
  
  public final void a(int paramInt)
  {
    int j = paramInt;
    if (paramInt <= a.a) {
      j = a.a;
    }
    paramInt = j;
    if (j >= this.d.c()) {
      paramInt = this.d.a();
    }
    this.e.b(paramInt);
    if (this.c.d().c() <= this.e.c()) {
      this.c.b(this.e.c(), true, null);
    }
  }
  
  public final void a(com.tencent.mapsdk.a.b.c paramc)
  {
    double d2 = 0.0D;
    if (this.f == null) {
      return;
    }
    com.tencent.mapsdk.a.b.c[] arrayOfc = i();
    com.tencent.mapsdk.a.b.c localc1 = this.f.a;
    com.tencent.mapsdk.a.b.c localc2 = this.f.b;
    if (localc1.a > arrayOfc[0].a) {}
    for (double d1 = localc1.a - arrayOfc[0].a;; d1 = 0.0D)
    {
      if (localc1.b > arrayOfc[0].b) {
        d2 = localc1.b - arrayOfc[0].b;
      }
      if (localc2.a < arrayOfc[1].a) {
        d1 = localc2.a - arrayOfc[1].a;
      }
      if (localc2.b < arrayOfc[1].b) {
        d2 = localc2.b - arrayOfc[1].b;
      }
      paramc.a = (d1 + paramc.a);
      paramc.b += d2;
      return;
    }
  }
  
  public final CameraPosition b()
  {
    LatLng localLatLng = d.a(this.c.b());
    float f1 = this.c.d().a();
    return CameraPosition.builder().target(localLatLng).zoom(f1).build();
  }
  
  protected final void b(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= 0.0D) || (paramDouble2 <= 0.0D)) {
      return;
    }
    double d1 = a(true);
    double d2 = a(false);
    if ((d1 == 0.0D) && (d2 == 0.0D))
    {
      this.g = paramDouble1;
      this.h = paramDouble2;
      return;
    }
    paramDouble1 = Math.max(paramDouble1 / d2, paramDouble2 / d1);
    a locala = this.c.d();
    locala.a(paramDouble1 * locala.b());
    a(locala);
    this.b.b(false);
  }
  
  protected final void b(int paramInt)
  {
    this.g = 0.0D;
  }
  
  public final double c()
  {
    double d1 = 1.0D;
    if (this.c.d().a() < 7) {}
    for (;;)
    {
      return d1 * this.c.d().d();
      double d2 = 1.0D - Math.abs(this.c.b().a / 2.003750834E7D);
      d1 = d2;
      if (d2 < 0.1D) {
        d1 = 0.1D;
      }
    }
  }
  
  protected final void c(int paramInt)
  {
    this.h = 0.0D;
  }
  
  public final float d()
  {
    int j = this.c.getWidth();
    return (float)(d.a(a(0, 0), a(j, 0)) / j);
  }
  
  protected final double e()
  {
    return this.g;
  }
  
  protected final double f()
  {
    return this.h;
  }
  
  public final a g()
  {
    return this.d;
  }
  
  public final a h()
  {
    return this.e;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */