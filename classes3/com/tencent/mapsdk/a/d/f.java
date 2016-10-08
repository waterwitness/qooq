package com.tencent.mapsdk.a.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.tencent.mapsdk.a.a.a.a;
import com.tencent.mapsdk.a.d;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.OnMapLongClickListener;

public final class f
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnKeyListener
{
  private e a;
  private b b;
  private a c;
  private GestureDetector d;
  private MotionEvent e;
  private OnMapClickListener f;
  private OnMapLongClickListener g;
  private OnMapCameraChangeListener h;
  private float i = 1.0F;
  private float j = 1.0F;
  private float k = 1.0F;
  private boolean l = false;
  private boolean m = false;
  private Scroller n;
  private int o = 0;
  private int p = 0;
  private long q;
  private float r;
  private float s;
  private float t;
  private float u;
  private long v = 0L;
  private Point w;
  
  public f(e parame)
  {
    this.a = parame;
    this.b = parame.c();
    this.c = parame.e();
    this.d = new GestureDetector(this);
    this.n = new Scroller(e.a());
    new DisplayMetrics();
    parame = e.a().getApplicationContext().getResources().getDisplayMetrics();
    this.o = (parame.widthPixels / 2);
    this.p = (parame.heightPixels / 2);
  }
  
  private static float c(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final void a()
  {
    int i1;
    int i2;
    if (this.n.computeScrollOffset())
    {
      i1 = this.n.getCurrX() - this.o;
      i2 = this.n.getCurrY() - this.p;
      this.o = this.n.getCurrX();
      this.p = this.n.getCurrY();
      this.b.scrollBy(i1, i2);
      if (this.n.isFinished())
      {
        if (this.h != null) {
          a(true);
        }
        this.a.b(false);
      }
    }
    else
    {
      return;
    }
    if ((Math.abs(i1) < 6) && (Math.abs(i2) < 6))
    {
      this.a.b(false);
      return;
    }
    this.a.b(true);
  }
  
  public final void a(OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    this.h = paramOnMapCameraChangeListener;
  }
  
  public final void a(OnMapClickListener paramOnMapClickListener)
  {
    this.f = paramOnMapClickListener;
  }
  
  public final void a(OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.g = paramOnMapLongClickListener;
  }
  
  public final void a(boolean paramBoolean)
  {
    CameraPosition localCameraPosition;
    if (this.h != null)
    {
      localCameraPosition = this.a.b().b();
      if (paramBoolean) {
        this.h.onCameraChangeFinish(localCameraPosition);
      }
    }
    else
    {
      return;
    }
    this.h.onCameraChange(localCameraPosition);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i2 = 0;
    int i1 = i2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i1 = i2;
    case 3: 
    case 4: 
    case 0: 
      for (;;)
      {
        if (i1 != 0) {
          this.v = paramMotionEvent.getEventTime();
        }
        if ((i1 == 0) && (!this.m)) {
          this.d.onTouchEvent(paramMotionEvent);
        }
        if ((paramMotionEvent.getAction() == 1) && (this.l) && (!this.m) && (this.h != null)) {
          a(true);
        }
        if (i1 != 0)
        {
          paramMotionEvent.setAction(3);
          this.d.onTouchEvent(paramMotionEvent);
        }
        this.c.a(paramMotionEvent);
        bool = true;
        return bool;
        this.a.d().stopAnimation();
        i1 = i2;
        if (this.a.f().f())
        {
          this.a.i();
          i1 = i2;
        }
      }
    case 1: 
      label163:
      this.v = paramMotionEvent.getEventTime();
      if (this.a.f().f()) {
        this.a.j();
      }
      if ((paramMotionEvent.getEventTime() - this.q < 200L) && (((Math.abs(paramMotionEvent.getX(0) - this.s) < 10.0F) && (Math.abs(paramMotionEvent.getY(0) - this.u) < 10.0F)) || ((Math.abs(paramMotionEvent.getX(0) - this.r) < 10.0F) && (Math.abs(paramMotionEvent.getY(0) - this.t) < 10.0F)))) {
        if (this.a.f().h()) {
          this.b.b(true, null);
        }
      }
      break;
    }
    for (i1 = 1;; i1 = 0)
    {
      this.q = 0L;
      this.r = 0.0F;
      this.t = 0.0F;
      this.l = false;
      this.k = 0.0F;
      break;
      i1 = i2;
      if (paramMotionEvent.getPointerCount() <= 1) {
        break;
      }
      this.q = paramMotionEvent.getEventTime();
      this.s = paramMotionEvent.getX(0);
      this.u = paramMotionEvent.getY(0);
      this.r = paramMotionEvent.getX(1);
      this.t = paramMotionEvent.getY(1);
      this.k = c(paramMotionEvent);
      i1 = i2;
      break;
      i1 = i2;
      if (paramMotionEvent.getPointerCount() != 2) {
        break;
      }
      if (this.m)
      {
        double d1 = Math.sqrt(this.j * this.i);
        localPointF = new PointF(this.b.getWidth() / 2, this.b.getHeight() / 2);
        this.b.a((d1 - 1.0D) * 1.5D + this.b.c(), localPointF, true, 200L, a.a.b, new CancelableCallback()
        {
          public final void onCancel()
          {
            f.a(f.this, false);
          }
          
          public final void onFinish()
          {
            f.a(f.this, false);
          }
        });
      }
      this.w = null;
      i1 = i2;
      break;
      i1 = i2;
      if (paramMotionEvent.getPointerCount() <= 1) {
        break;
      }
      if (!this.a.f().h()) {
        break label163;
      }
      float f1 = c(paramMotionEvent);
      i1 = i2;
      if (f1 < 10.0F) {
        break;
      }
      if (this.k < 10.0F)
      {
        this.k = f1;
        i1 = i2;
        break;
      }
      this.i = this.j;
      this.j = (f1 / this.k);
      i1 = i2;
      if (Math.abs(this.j - 1.0F) < 0.01D) {
        break;
      }
      PointF localPointF = new PointF(this.b.getWidth() / 2, this.b.getHeight() / 2);
      this.b.a(this.j, localPointF);
      a(false);
      this.k = f1;
      this.a.b(false);
      this.m = true;
      i1 = 1;
      break;
    }
  }
  
  public final void b()
  {
    this.n.abortAnimation();
  }
  
  public final void b(MotionEvent paramMotionEvent)
  {
    if (this.e != null) {
      this.e.recycle();
    }
    this.e = paramMotionEvent;
    if (this.e.getAction() == 0)
    {
      if (this.w == null) {
        this.w = new Point();
      }
      this.w.x = ((int)this.e.getX());
      this.w.y = ((int)this.e.getY());
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (!this.a.f().h()) {}
    while (this.b.d().a() >= this.a.b().g().a()) {
      return true;
    }
    this.b.a(new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()), true, null);
    return true;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    this.l = false;
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.l = false;
    if (!this.a.f().g()) {
      return true;
    }
    this.n.fling(this.o, this.p, (int)(-paramFloat1 * 0.6D), (int)(-paramFloat2 * 0.6D), -2147483647, Integer.MAX_VALUE, -2147483647, Integer.MAX_VALUE);
    this.a.b(false);
    return true;
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramKeyEvent.getAction() == 1) {
      this.c.b(paramInt, paramKeyEvent);
    }
    while (paramKeyEvent.getAction() != 0) {
      return false;
    }
    this.c.a(paramInt, paramKeyEvent);
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      this.b.scrollBy(-10, 0);
      continue;
      this.b.scrollBy(10, 0);
      continue;
      this.b.scrollBy(0, -10);
      continue;
      this.b.scrollBy(0, 10);
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    this.l = false;
    LatLng localLatLng = this.a.b().a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    this.c.a(d.b(localLatLng), paramMotionEvent);
    if (this.g != null) {
      this.g.onMapLongClick(localLatLng);
    }
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.a.f().g()) {
      this.l = false;
    }
    while ((this.m) || (paramMotionEvent2.getEventTime() - this.v < 30L)) {
      return true;
    }
    this.l = true;
    int i1 = (int)this.e.getX();
    int i2 = (int)this.e.getY();
    if (this.w == null)
    {
      this.w = new Point();
      this.w.x = i1;
      this.w.y = i2;
      return true;
    }
    int i3 = this.w.x;
    int i4 = this.w.y;
    this.b.scrollBy(i3 - i1, i4 - i2);
    this.w.x = i1;
    this.w.y = i2;
    a(false);
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.l = false;
    try
    {
      paramMotionEvent = this.a.b().a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.c.a(d.b(paramMotionEvent))) {
        return true;
      }
      if (this.f != null)
      {
        this.f.onMapClick(paramMotionEvent);
        this.a.d().setFocusable(true);
        this.a.d().setFocusableInTouchMode(true);
        this.a.d().requestFocus();
        paramMotionEvent = (InputMethodManager)e.a().getSystemService("input_method");
        if (paramMotionEvent.isActive())
        {
          paramMotionEvent.hideSoftInputFromWindow(this.a.d().getWindowToken(), 0);
          return true;
        }
      }
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */