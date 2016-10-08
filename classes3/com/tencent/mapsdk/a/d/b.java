package com.tencent.mapsdk.a.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mapsdk.a.a.a.a;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.OnMapLoadedListener;

public final class b
  extends View
{
  private e a;
  private c b;
  private boolean c = false;
  private boolean d = false;
  private com.tencent.mapsdk.a.b.a e;
  private com.tencent.mapsdk.a.b.c f = null;
  private PointF g = null;
  private OnMapLoadedListener h;
  private final Handler i = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
      } while (b.a(b.this) == null);
      b.a(b.this).onMapLoaded();
    }
  };
  private com.tencent.mapsdk.a.a.c j;
  private com.tencent.mapsdk.a.a.b k;
  
  public b(e parame)
  {
    super(e.a());
    this.a = parame;
    this.b = parame.b();
    this.e = new com.tencent.mapsdk.a.b.a(10.0D);
    if ((parame.f().a() >= 3) && (parame.f().b() > 1.0F)) {
      this.e.a(1.3D);
    }
    this.f = com.tencent.mapsdk.a.d.a(new LatLng(39.91669D, 116.39716D));
    this.g = new PointF(getWidth() / 2, getHeight() / 2);
  }
  
  private com.tencent.mapsdk.a.b.c a(int paramInt1, int paramInt2)
  {
    double d1 = this.f.b;
    double d2 = paramInt1;
    double d3 = this.e.d();
    return new com.tencent.mapsdk.a.b.c(this.f.a - paramInt2 * this.e.d(), d1 + d2 * d3);
  }
  
  private void a(com.tencent.mapsdk.a.b.a parama, PointF paramPointF)
  {
    double d1 = getWidth() / 2;
    double d2 = getHeight() / 2;
    double d3 = this.f.b;
    double d4 = paramPointF.x;
    double d5 = this.e.d();
    double d6 = paramPointF.x;
    double d7 = parama.d();
    double d8 = this.f.a;
    double d9 = paramPointF.y;
    double d10 = this.e.d();
    double d11 = paramPointF.y;
    double d12 = parama.d();
    this.f.b = (d3 + ((d4 - d1) * d5 + (d1 - d6) * d7));
    this.f.a = (d8 - ((d9 - d2) * d10 + (d2 - d11) * d12));
    this.g.x = ((int)d1);
    this.g.y = ((int)d2);
    this.e.b(parama.c());
    this.b.a(this.f);
    this.a.b(false);
  }
  
  private void b(double paramDouble, PointF paramPointF, boolean paramBoolean, long paramLong, CancelableCallback paramCancelableCallback)
  {
    a(paramDouble, paramPointF, paramBoolean, paramLong, a.a.c, paramCancelableCallback);
  }
  
  private PointF e()
  {
    return new PointF(getWidth() / 2, getHeight() / 2);
  }
  
  public final PointF a()
  {
    return this.g;
  }
  
  public final void a(double paramDouble, PointF paramPointF)
  {
    double d1 = this.e.b();
    a(this.b.a(new com.tencent.mapsdk.a.b.a(this.e.a(), d1 * paramDouble)), paramPointF);
  }
  
  public final void a(double paramDouble, PointF paramPointF, boolean paramBoolean, long paramLong, a.a parama, CancelableCallback paramCancelableCallback)
  {
    if (paramBoolean)
    {
      if (this.j != null) {
        this.j.b();
      }
      this.j = new com.tencent.mapsdk.a.a.c(this.a, paramDouble, paramPointF, paramLong, paramCancelableCallback);
      this.j.a(parama);
      this.j.a();
    }
    do
    {
      return;
      a(this.b.a(new com.tencent.mapsdk.a.b.a(paramDouble)), paramPointF);
    } while (paramCancelableCallback == null);
    paramCancelableCallback.onFinish();
  }
  
  public final void a(double paramDouble, PointF paramPointF, boolean paramBoolean, long paramLong, CancelableCallback paramCancelableCallback)
  {
    b(paramDouble, paramPointF, false, 0L, null);
  }
  
  public final void a(double paramDouble, PointF paramPointF, boolean paramBoolean, CancelableCallback paramCancelableCallback)
  {
    b(this.e.c() + paramDouble, paramPointF, paramBoolean, 500L, paramCancelableCallback);
  }
  
  public final void a(double paramDouble, boolean paramBoolean, CancelableCallback paramCancelableCallback)
  {
    b(this.e.c() + paramDouble, e(), paramBoolean, 500L, paramCancelableCallback);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, CancelableCallback paramCancelableCallback)
  {
    a(a(paramInt1, paramInt2), paramLong, paramCancelableCallback);
  }
  
  public final void a(PointF paramPointF, boolean paramBoolean, CancelableCallback paramCancelableCallback)
  {
    b(this.e.c() + 1.0D, paramPointF, true, 500L, null);
  }
  
  public final void a(com.tencent.mapsdk.a.b.c paramc)
  {
    this.f = paramc;
    this.b.a(this.f);
    this.a.b(true);
  }
  
  public final void a(com.tencent.mapsdk.a.b.c paramc, long paramLong, CancelableCallback paramCancelableCallback)
  {
    if (this.k != null) {
      this.k.b();
    }
    this.k = new com.tencent.mapsdk.a.a.b(this.a, paramc, paramLong, paramCancelableCallback);
    this.k.a();
  }
  
  public final void a(com.tencent.mapsdk.a.c.a parama)
  {
    parama.a(this.a);
  }
  
  public final void a(OnMapLoadedListener paramOnMapLoadedListener)
  {
    this.h = paramOnMapLoadedListener;
  }
  
  public final void a(boolean paramBoolean, CancelableCallback paramCancelableCallback)
  {
    b(this.e.c() + 1.0D, e(), paramBoolean, 500L, paramCancelableCallback);
  }
  
  public final com.tencent.mapsdk.a.b.c b()
  {
    return this.f;
  }
  
  public final void b(double paramDouble, boolean paramBoolean, CancelableCallback paramCancelableCallback)
  {
    b(paramDouble, e(), paramBoolean, 500L, paramCancelableCallback);
  }
  
  public final void b(boolean paramBoolean, CancelableCallback paramCancelableCallback)
  {
    b(this.e.c() - 1.0D, e(), paramBoolean, 500L, paramCancelableCallback);
  }
  
  public final double c()
  {
    return this.e.c();
  }
  
  public final void clearAnimation()
  {
    super.clearAnimation();
    if (this.k != null) {
      this.k.b();
    }
    if (this.j != null) {
      this.j.b();
    }
  }
  
  public final com.tencent.mapsdk.a.b.a d()
  {
    return this.e;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    boolean bool = this.a.g().a(paramCanvas);
    this.a.e().a(paramCanvas);
    if (!e.q())
    {
      Paint localPaint = new Paint();
      localPaint.setColor(-65536);
      localPaint.setTextSize(50.0F);
      Rect localRect = new Rect();
      int m = getWidth();
      int n = getHeight();
      localPaint.getTextBounds("鉴权失败，请到腾讯", 0, "鉴权失败，请到腾讯".length(), localRect);
      paramCanvas.drawText("鉴权失败，请到腾讯", m / 2 - localRect.width() / 2, n / 2 - localRect.height(), localPaint);
      localPaint.getTextBounds("地图官网申请密钥", 0, "地图官网申请密钥".length(), localRect);
      paramCanvas.drawText("地图官网申请密钥", m / 2 - localRect.width() / 2, n / 2 + 2, localPaint);
    }
    if ((!this.d) && (bool))
    {
      this.i.sendEmptyMessage(11);
      this.d = true;
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.b.e() != 0.0D) && (this.b.f() != 0.0D))
    {
      this.b.b(this.b.e(), this.b.f());
      this.b.b(0);
      this.b.c(0);
    }
    this.g = new PointF(getWidth() / 2, getHeight() / 2);
    paramInt1 = 3;
    paramInt2 = Math.max(getWidth(), getHeight());
    while (256.0D * Math.pow(2.0D, paramInt1) < paramInt2) {
      paramInt1 += 1;
    }
    com.tencent.mapsdk.a.b.a.a = paramInt1;
    if (this.b.h().a() < com.tencent.mapsdk.a.b.a.a) {
      this.b.a(com.tencent.mapsdk.a.b.a.a);
    }
    this.a.b(false);
  }
  
  public final void scrollBy(int paramInt1, int paramInt2)
  {
    a(a(paramInt1, paramInt2));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */