package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class ItemizedOverlay<Item extends OverlayItem>
  extends Overlay
{
  private boolean a = true;
  private Drawable b;
  private ItemizedOverlay<Item>.ItemsContainer c = null;
  private OnFocusChangeListener d = null;
  private int e = -1;
  private int f = -1;
  private Item g;
  private boolean h = false;
  private boolean i = true;
  
  public ItemizedOverlay(Context paramContext)
  {
    try
    {
      InputStream localInputStream = getClass().getResourceAsStream("/assets/" + "marker.png");
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
      localInputStream.close();
      this.b = new BitmapDrawable(paramContext.getResources(), localBitmap);
      boundCenterBottom(this.b);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public ItemizedOverlay(Drawable paramDrawable)
  {
    this.b = paramDrawable;
    if (this.b == null) {
      throw new IllegalArgumentException("the drawable can not be null!");
    }
    paramDrawable = this.b.getBounds();
    if (paramDrawable == null) {
      boundCenterBottom(this.b);
    }
    while ((paramDrawable.left != 0) || (paramDrawable.right != 0) || (paramDrawable.top != 0) || (paramDrawable.bottom != 0)) {
      return;
    }
    boundCenterBottom(this.b);
  }
  
  private static Drawable a(Drawable paramDrawable, BoundPos paramBoundPos)
  {
    int k = 0;
    if ((paramDrawable == null) || (BoundPos.Normal == paramBoundPos)) {
      return null;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    Rect localRect = paramDrawable.getBounds();
    int n = localRect.width() / 2;
    int m = -localRect.height();
    int j = m;
    if (paramBoundPos == BoundPos.Center)
    {
      j = m / 2;
      k = -j;
    }
    paramDrawable.setBounds(-n, j, n, k);
    return paramDrawable;
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean, Item paramItem, Point paramPoint)
  {
    Drawable localDrawable = paramItem.getMarker();
    paramItem = localDrawable;
    if (localDrawable == null) {
      paramItem = this.b;
    }
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(paramPoint.x, paramPoint.y);
      paramItem.setColorFilter(2130706432, PorterDuff.Mode.SRC_IN);
      paramCanvas.skew(-0.89F, 0.0F);
      paramCanvas.scale(1.0F, 0.5F);
      paramItem.draw(paramCanvas);
      paramItem.clearColorFilter();
      paramCanvas.restore();
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramPoint.x, paramPoint.y);
    paramItem.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public static Drawable boundCenter(Drawable paramDrawable)
  {
    return a(paramDrawable, BoundPos.Center);
  }
  
  public static Drawable boundCenterBottom(Drawable paramDrawable)
  {
    return a(paramDrawable, BoundPos.CenterBottom);
  }
  
  protected abstract Item createItem(int paramInt);
  
  public void draw(Canvas paramCanvas, MapView paramMapView)
  {
    int k = size();
    if (k <= 0) {}
    do
    {
      return;
      paramMapView = paramMapView.getProjection();
      int j = 0;
      while (j < k)
      {
        try
        {
          localOverlayItem = getItem(getIndexToDraw(j));
          if (localOverlayItem != null)
          {
            Point localPoint = paramMapView.toPixels(localOverlayItem.getPoint(), null);
            if (localPoint != null)
            {
              if (this.i == true) {
                a(paramCanvas, true, localOverlayItem, localPoint);
              }
              a(paramCanvas, false, localOverlayItem, localPoint);
            }
          }
        }
        catch (Exception localException)
        {
          OverlayItem localOverlayItem;
          for (;;) {}
        }
        j += 1;
      }
      localOverlayItem = getFocus();
    } while ((!this.a) || (localOverlayItem == null));
    paramMapView = paramMapView.toPixels(localOverlayItem.getPoint(), null);
    if (this.i == true) {
      a(paramCanvas, true, localOverlayItem, paramMapView);
    }
    a(paramCanvas, false, localOverlayItem, paramMapView);
  }
  
  public GeoPoint getCenter()
  {
    if (this.c == null) {
      return null;
    }
    return new GeoPoint(this.c.a, this.c.b);
  }
  
  public Item getFocus()
  {
    if (this.c == null) {}
    while (this.f == -1) {
      return null;
    }
    return this.c.getItemByPos(this.f);
  }
  
  protected int getIndexToDraw(int paramInt)
  {
    if (this.c == null) {
      return -1;
    }
    return this.c.getPosByRank(paramInt);
  }
  
  public final Item getItem(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.getItemByPos(paramInt);
  }
  
  public final int getLastFocusedIndex()
  {
    return this.e;
  }
  
  public int getLatSpanE6()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.getSpan(true);
  }
  
  public int getLonSpanE6()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.getSpan(false);
  }
  
  public boolean isShadowEnable()
  {
    return this.i;
  }
  
  public Item nextFocus(boolean paramBoolean)
  {
    if ((this.c == null) || (this.c.count() == 0)) {}
    int j;
    label100:
    do
    {
      do
      {
        return null;
        if (this.e != -1) {
          break;
        }
      } while (this.f == -1);
      return this.c.getItemByPos(0);
      if (this.f == -1) {}
      for (j = this.e;; j = this.f)
      {
        if (!paramBoolean) {
          break label100;
        }
        if ((this.c == null) || (j == this.c.count() - 1)) {
          break;
        }
        return this.c.getItemByPos(j + 1);
      }
    } while ((this.c == null) || (j == 0));
    return this.c.getItemByPos(j - 1);
  }
  
  public void onEmptyTap(GeoPoint paramGeoPoint)
  {
    super.onEmptyTap(paramGeoPoint);
  }
  
  public boolean onLongPress(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if (this.c == null) {
      return false;
    }
    this.c.HandleLongPress(paramGeoPoint, paramMapView);
    this.h = true;
    paramGeoPoint = this.g;
    return false;
  }
  
  protected boolean onTap(int paramInt)
  {
    if (this.c == null) {}
    while (paramInt == this.f) {
      return false;
    }
    setFocus(getItem(paramInt));
    return false;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    if (this.c == null) {
      return false;
    }
    return this.c.HandleTap(paramGeoPoint, paramMapView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if ((!this.h) || (this.g == null)) {}
    while (!this.g.isDragable()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 0: 
    default: 
      return false;
    case 1: 
    case 3: 
    case 4: 
      this.h = false;
      this.g = null;
      return true;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    paramMotionEvent = paramMapView.getProjection().fromPixels(j, k);
    this.g.setPoint(paramMotionEvent);
    paramMapView.invalidate();
    return true;
  }
  
  protected final void populate()
  {
    if (this.c != null) {
      this.c.release();
    }
    this.c = new ItemsContainer();
    this.e = -1;
    this.f = -1;
  }
  
  public void setDrawFocusedItem(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setFocus(Item paramItem)
  {
    if (this.c == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramItem != null) && (this.f == this.c.getIndexByItem(paramItem)));
        if ((paramItem == null) && (this.f != -1))
        {
          if (this.d != null) {
            this.d.onFocusChanged(this, paramItem);
          }
          this.f = -1;
          return;
        }
        this.f = this.c.getIndexByItem(paramItem);
      } while (this.f == -1);
      setLastFocusedIndex(this.f);
    } while (this.d == null);
    this.d.onFocusChanged(this, paramItem);
  }
  
  protected void setLastFocusedIndex(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnFocusChangeListener(OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.d = paramOnFocusChangeListener;
  }
  
  public void setShadowEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public abstract int size();
  
  static enum BoundPos
  {
    private BoundPos() {}
  }
  
  class ItemsContainer
    implements Comparator<Integer>
  {
    int a = 0;
    int b = 0;
    private ArrayList<Item> c = new ArrayList();
    private ArrayList<Integer> d = new ArrayList();
    
    public ItemsContainer()
    {
      if (this.c != null) {
        this.c.clear();
      }
      if (this.d != null) {
        this.d.clear();
      }
      int m = ItemizedOverlay.this.size();
      int i = 0;
      int j = 0;
      int k = 0;
      while (i < m)
      {
        this.d.add(Integer.valueOf(i));
        OverlayItem localOverlayItem = ItemizedOverlay.this.createItem(i);
        k += localOverlayItem.getPoint().getLatitudeE6();
        j += localOverlayItem.getPoint().getLongitudeE6();
        this.c.add(localOverlayItem);
        i += 1;
      }
      if (m > 0) {
        this.a = (k / m);
      }
      for (this.b = (j / m);; this.b = 0)
      {
        Collections.sort(this.d, this);
        return;
        this.a = 0;
      }
    }
    
    private int a(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      Projection localProjection = paramMapView.getProjection();
      Point localPoint1 = localProjection.toPixels(paramGeoPoint, null);
      int k = -1;
      double d1 = Double.MAX_VALUE;
      int j = Integer.MAX_VALUE;
      int m = count();
      int i = 0;
      int n;
      int i1;
      int i2;
      if (i < m)
      {
        paramGeoPoint = (OverlayItem)this.c.get(i);
        if (paramGeoPoint == null) {
          break label271;
        }
        Point localPoint2 = localProjection.toPixels(paramGeoPoint.getPoint(), null);
        paramMapView = paramGeoPoint.getMarker();
        Point localPoint3 = new Point(localPoint1.x - localPoint2.x, localPoint1.y - localPoint2.y);
        paramGeoPoint = paramMapView;
        if (paramMapView == null) {
          paramGeoPoint = ItemizedOverlay.a(ItemizedOverlay.this);
        }
        if (!paramGeoPoint.getBounds().contains(localPoint3.x, localPoint3.y)) {
          break label274;
        }
        paramGeoPoint = new Point(localPoint1.x - localPoint2.x, localPoint1.y - localPoint2.y);
        n = paramGeoPoint.x;
        i1 = paramGeoPoint.x;
        i2 = paramGeoPoint.y;
      }
      label271:
      label274:
      for (double d2 = paramGeoPoint.y * i2 + n * i1;; d2 = -1.0D)
      {
        if ((d2 >= 0.0D) && (d2 < d1))
        {
          j = getPosByRank(i);
          k = i;
          d1 = d2;
        }
        for (;;)
        {
          i += 1;
          break;
          if ((d2 == d1) && (getPosByRank(i) > j))
          {
            k = i;
            continue;
            return k;
          }
        }
      }
    }
    
    public boolean HandleLongPress(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      int i = a(paramGeoPoint, paramMapView);
      if (i != -1) {
        ItemizedOverlay.a(ItemizedOverlay.this, (OverlayItem)this.c.get(i));
      }
      return false;
    }
    
    public boolean HandleTap(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      boolean bool = false;
      int i = a(paramGeoPoint, paramMapView);
      if (i >= 0) {
        bool = ItemizedOverlay.this.onTap(i);
      }
      for (;;)
      {
        paramMapView.postInvalidate();
        return bool;
        ItemizedOverlay.this.setFocus(null);
      }
    }
    
    public int compare(Integer paramInteger1, Integer paramInteger2)
    {
      paramInteger1 = ((OverlayItem)this.c.get(paramInteger1.intValue())).getPoint();
      paramInteger2 = ((OverlayItem)this.c.get(paramInteger2.intValue())).getPoint();
      if ((paramInteger1 == null) || (paramInteger2 == null)) {
        return 0;
      }
      if (paramInteger1.getLatitudeE6() > paramInteger2.getLatitudeE6()) {
        return -1;
      }
      if (paramInteger1.getLatitudeE6() < paramInteger2.getLatitudeE6()) {
        return 1;
      }
      if (paramInteger1.getLongitudeE6() < paramInteger2.getLongitudeE6()) {
        return -1;
      }
      if (paramInteger1.getLongitudeE6() > paramInteger2.getLongitudeE6()) {
        return 1;
      }
      return 0;
    }
    
    public int count()
    {
      return this.c.size();
    }
    
    public int getIndexByItem(Item paramItem)
    {
      int j = count();
      if (paramItem != null)
      {
        int i = 0;
        while (i < j)
        {
          if (paramItem.equals(this.c.get(i))) {
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    
    public Item getItemByPos(int paramInt)
    {
      if (this.c == null) {}
      while ((this.c.size() <= paramInt) || (paramInt < 0)) {
        return null;
      }
      return (OverlayItem)this.c.get(paramInt);
    }
    
    public int getPosByRank(int paramInt)
    {
      if (this.d.size() <= paramInt) {
        return -1;
      }
      return ((Integer)this.d.get(paramInt)).intValue();
    }
    
    public int getSpan(boolean paramBoolean)
    {
      if (this.c.size() == 0) {
        return 0;
      }
      Iterator localIterator = this.c.iterator();
      int k = Integer.MIN_VALUE;
      int j = Integer.MAX_VALUE;
      GeoPoint localGeoPoint;
      int i;
      label60:
      int m;
      if (localIterator.hasNext())
      {
        localGeoPoint = ((OverlayItem)localIterator.next()).getPoint();
        if (paramBoolean)
        {
          i = localGeoPoint.getLatitudeE6();
          m = k;
          if (i > k) {
            m = i;
          }
          if (i >= j) {
            break label108;
          }
        }
      }
      for (;;)
      {
        j = i;
        k = m;
        break;
        i = localGeoPoint.getLongitudeE6();
        break label60;
        return k - j;
        label108:
        i = j;
      }
    }
    
    public void release()
    {
      if (this.c != null) {
        this.c.clear();
      }
      if (this.d != null) {
        this.d.clear();
      }
    }
  }
  
  public static abstract interface OnFocusChangeListener
  {
    public abstract void onFocusChanged(ItemizedOverlay<?> paramItemizedOverlay, OverlayItem paramOverlayItem);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\ItemizedOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */