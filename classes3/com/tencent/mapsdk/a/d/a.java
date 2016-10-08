package com.tencent.mapsdk.a.d;

import android.graphics.Canvas;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.Overlay;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a
{
  private static int d = 0;
  private e a;
  private CopyOnWriteArrayList<Overlay> b = new CopyOnWriteArrayList();
  private a c = new a((byte)0);
  
  public a(e parame)
  {
    this.a = parame;
  }
  
  public static String a(String paramString)
  {
    d += 1;
    return paramString + d;
  }
  
  public final void a()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        ((Overlay)localIterator.next()).destroy();
        continue;
        this.a.b(false);
      }
    }
    catch (Exception localException) {}
    for (;;)
    {
      return;
      this.b.clear();
    }
  }
  
  public final void a(Canvas paramCanvas)
  {
    int i = this.b.size();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay.isVisible()) && ((i <= 20) || (localOverlay.checkInBounds()))) {
        localOverlay.draw(paramCanvas);
      }
    }
  }
  
  public final void a(Overlay paramOverlay)
  {
    b(paramOverlay.getId());
    this.b.add(paramOverlay);
    c();
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay instanceof Overlay)) {
        localOverlay.onKeyDown(paramInt, paramKeyEvent, this.a.d());
      }
    }
    return false;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay instanceof Overlay)) {
        localOverlay.onTouchEvent(paramMotionEvent, this.a.d());
      }
    }
    return false;
  }
  
  public final boolean a(GeoPoint paramGeoPoint)
  {
    boolean bool2 = false;
    Iterator localIterator = this.b.iterator();
    Overlay localOverlay;
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
      localOverlay = (Overlay)localIterator.next();
    } while ((!(localOverlay instanceof Overlay)) || (!localOverlay.onTap(paramGeoPoint, this.a.d())));
    boolean bool1 = true;
    if (!bool1)
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localOverlay = (Overlay)localIterator.next();
        if ((localOverlay instanceof Overlay)) {
          localOverlay.onEmptyTap(paramGeoPoint);
        }
      }
    }
    return bool1;
  }
  
  public final boolean a(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if (((localOverlay instanceof Overlay)) && (localOverlay.onLongPress(paramGeoPoint, paramMotionEvent, this.a.d()))) {
        return true;
      }
    }
    return false;
  }
  
  protected final void b()
  {
    a();
  }
  
  public final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay instanceof Overlay)) {
        localOverlay.onKeyUp(paramInt, paramKeyEvent, this.a.d());
      }
    }
    return false;
  }
  
  public final boolean b(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    Overlay localOverlay;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localOverlay = (Overlay)localIterator.next();
    } while ((localOverlay == null) || (!localOverlay.getId().equals(paramString)));
    for (paramString = localOverlay; paramString != null; paramString = null) {
      return this.b.remove(paramString);
    }
    return false;
  }
  
  public final void c()
  {
    Object[] arrayOfObject = this.b.toArray();
    Arrays.sort(arrayOfObject, this.c);
    this.b.clear();
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      this.b.add((Overlay)localObject);
      i += 1;
    }
  }
  
  final class a
    implements Comparator<Object>
  {
    private a() {}
    
    public final int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (Overlay)paramObject1;
      paramObject2 = (Overlay)paramObject2;
      if ((paramObject1 != null) && (paramObject2 != null)) {
        try
        {
          if (((Overlay)paramObject1).getZIndex() > ((Overlay)paramObject2).getZIndex()) {
            return 1;
          }
          float f1 = ((Overlay)paramObject1).getZIndex();
          float f2 = ((Overlay)paramObject2).getZIndex();
          if (f1 < f2) {
            return -1;
          }
        }
        catch (Exception paramObject1)
        {
          ((Exception)paramObject1).printStackTrace();
        }
      }
      return 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */