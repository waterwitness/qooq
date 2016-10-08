package com.tencent.mapsdk.a.d;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.a.e.d;
import com.tencent.tencentmap.mapsdk.map.MapView;

public final class e
{
  private static Context a;
  private static boolean l = true;
  private MapView b;
  private a c;
  private b d;
  private f e;
  private d f;
  private c g;
  private a.1 h;
  private com.tencent.mapsdk.a.f.b i;
  private com.tencent.mapsdk.a.f.a j;
  private int k = 1;
  
  public e(MapView paramMapView)
  {
    a = paramMapView.getContext().getApplicationContext();
    this.b = paramMapView;
    com.tencent.mapsdk.a.a.a();
    this.h = new a.1(this);
    this.g = new c(this);
    this.j = new com.tencent.mapsdk.a.f.a(this);
    this.i = new com.tencent.mapsdk.a.f.b(this);
    this.c = new a(this);
    this.d = new b(this);
    this.e = new f(this);
    com.tencent.mapsdk.a.e.a.a();
    this.f = new d(this);
    this.g.a();
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramMapView.addView(this.d, localLayoutParams);
    paramMapView.addView(this.j, localLayoutParams);
    paramMapView.addView(this.i, localLayoutParams);
    this.h.c(1);
    this.h.a(true);
    this.h.d(0);
  }
  
  public static Context a()
  {
    return a;
  }
  
  public static void c(boolean paramBoolean)
  {
    l = false;
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int m = 1; this.f.b() == m; m = 0) {
      return;
    }
    this.f.a(m);
    b(false);
  }
  
  public static void l() {}
  
  public static void n() {}
  
  public static void o() {}
  
  public static void p() {}
  
  public static boolean q()
  {
    return l;
  }
  
  public final void a(int paramInt)
  {
    int m = 2;
    if (paramInt == 2)
    {
      d(true);
      this.i.a(true);
    }
    for (paramInt = m;; paramInt = 1)
    {
      this.k = paramInt;
      b(false);
      return;
      d(false);
      this.i.a(false);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.setVisibility(0);
      this.j.d();
      return;
    }
    com.tencent.mapsdk.a.f.a locala = this.j;
    com.tencent.mapsdk.a.f.a.b();
    locala = this.j;
    com.tencent.mapsdk.a.f.a.c();
    this.j.setVisibility(8);
  }
  
  public final c b()
  {
    return this.g;
  }
  
  public final void b(int paramInt)
  {
    if (this.i != null)
    {
      this.i.a(paramInt);
      this.i.invalidate();
      if (this.j.getVisibility() == 0) {
        this.j.invalidate();
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.f.a(paramBoolean);
    this.b.layout();
    this.b.postInvalidate();
  }
  
  public final b c()
  {
    return this.d;
  }
  
  public final void c(int paramInt)
  {
    if ((this.j.getVisibility() == 0) && (this.j != null))
    {
      this.j.a(paramInt);
      this.j.invalidate();
    }
  }
  
  public final MapView d()
  {
    return this.b;
  }
  
  public final a e()
  {
    return this.c;
  }
  
  public final a.1 f()
  {
    return this.h;
  }
  
  public final d g()
  {
    return this.f;
  }
  
  public final f h()
  {
    return this.e;
  }
  
  public final void i()
  {
    this.j.e();
  }
  
  public final void j()
  {
    this.j.d();
  }
  
  public final int k()
  {
    return this.k;
  }
  
  public final void m()
  {
    this.j.a();
    this.i.a();
    this.c.b();
    this.b.stopAnimation();
    this.b.removeAllViews();
    this.f.a();
    System.gc();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */