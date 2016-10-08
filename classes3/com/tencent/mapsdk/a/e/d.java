package com.tencent.mapsdk.a.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import com.tencent.mapsdk.a.b.a;
import com.tencent.mapsdk.a.d.a.1;
import com.tencent.mapsdk.a.d.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private e a;
  private com.tencent.mapsdk.a.d.c b;
  private com.tencent.mapsdk.a.d.b c;
  private ArrayList<b> d = null;
  private ArrayList<b> e = null;
  private ArrayList<b> f = null;
  private c g;
  private int h = 0;
  private PaintFlagsDrawFilter i;
  
  public d(e parame)
  {
    this.a = parame;
    this.b = parame.b();
    this.c = parame.c();
    this.g = new c(parame);
  }
  
  private static void a(ArrayList<b> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a();
    }
    paramArrayList.clear();
  }
  
  private void a(ArrayList<b> paramArrayList1, ArrayList<b> paramArrayList2, ArrayList<b> paramArrayList3)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {
      return;
    }
    int j = 0;
    b localb;
    label54:
    int k;
    label68:
    Object localObject;
    if (j < paramArrayList1.size())
    {
      localb = (b)paramArrayList1.get(j);
      if (localb != null)
      {
        if (this.h != 1) {
          break label133;
        }
        localb.e = 3;
        if ((paramArrayList2 == null) || (paramArrayList2.size() <= 0)) {
          break label224;
        }
        k = 0;
        if (k >= paramArrayList2.size()) {
          break label224;
        }
        localObject = (b)paramArrayList2.get(k);
        if (!((b)localObject).equals(localb)) {
          break label151;
        }
        localObject = ((b)localObject).f;
        paramArrayList2.remove(k);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        localb.f = ((Bitmap)localObject);
      }
      for (;;)
      {
        j += 1;
        break;
        label133:
        localb.e = this.a.f().c();
        break label54;
        label151:
        k += 1;
        break label68;
        if (paramArrayList3 != null) {
          paramArrayList3.add(localb);
        }
      }
      if (paramArrayList2 == null) {
        break;
      }
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (b)paramArrayList1.next();
        if ((paramArrayList2 != null) && (paramArrayList2.f != null)) {
          try
          {
            paramArrayList2.a();
          }
          catch (Exception paramArrayList2) {}
        }
      }
      break;
      label224:
      localObject = null;
    }
  }
  
  private boolean a(Canvas paramCanvas, ArrayList<b> paramArrayList)
  {
    double d1 = this.c.d().b();
    Object localObject1 = this.c.a();
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool3;
    if (paramArrayList != null)
    {
      bool2 = bool3;
      if (paramArrayList.size() > 0)
      {
        int m = ((b)paramArrayList.get(0)).c;
        int k = this.c.d().a();
        int j = k;
        if (this.a.f().e()) {
          j = k - 1;
        }
        d1 *= Math.pow(2.0D, j - m);
        Object localObject2;
        if (d1 != 1.0D)
        {
          localObject2 = new Matrix();
          paramCanvas.save();
          ((Matrix)localObject2).reset();
          ((Matrix)localObject2).postScale((float)d1, (float)d1, ((PointF)localObject1).x, ((PointF)localObject1).y);
          paramCanvas.concat((Matrix)localObject2);
        }
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (b)paramArrayList.next();
          localObject2 = ((b)localObject1).f;
          PointF localPointF = ((b)localObject1).d;
          if ((localObject2 != null) && (localPointF != null)) {
            try
            {
              paramCanvas.drawBitmap((Bitmap)localObject2, localPointF.x, localPointF.y, null);
            }
            catch (Exception localException)
            {
              if (((b)localObject1).f != null) {
                ((b)localObject1).f.recycle();
              }
              ((b)localObject1).f = null;
            }
          } else {
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (d1 != 1.0D)
        {
          paramCanvas.restore();
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  private ArrayList<b> b(int paramInt)
  {
    return this.b.a(this.c.b(), paramInt, this.c.getWidth(), this.c.getHeight(), this.a.f().d());
  }
  
  public final void a()
  {
    a(this.d);
    a(this.e);
    a(this.f);
    this.g.a();
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    int j = 2;
    if (this.h > 1024) {
      return;
    }
    if ((!paramBoolean) && (this.h == 0))
    {
      if ((!com.tencent.mapsdk.a.b.d) || (!com.tencent.mapsdk.a.c.a())) {
        break label510;
      }
      if (this.a.f().c() != j)
      {
        this.a.f().a(j);
        if (this.d != null) {
          this.d.clear();
        }
        if (this.e != null) {
          this.e.clear();
        }
        if (this.f != null) {
          this.f.clear();
        }
        if (!this.a.f().e()) {
          break label563;
        }
        this.a.f().b(512);
      }
    }
    label132:
    j = this.c.d().a();
    if (this.a.f().e()) {
      j -= 1;
    }
    for (;;)
    {
      int k = j - 2;
      if (k < this.a.b().h().a()) {
        k = this.a.b().h().a();
      }
      for (;;)
      {
        int m;
        ArrayList localArrayList1;
        if ((this.e != null) && (this.e.size() > 0))
        {
          m = ((b)this.e.get(0)).c;
          localArrayList1 = this.e;
        }
        for (;;)
        {
          int i2 = m - j;
          int n;
          ArrayList localArrayList2;
          if (i2 != 0)
          {
            if ((this.d == null) || (this.d.size() <= 0)) {
              break label630;
            }
            n = ((b)this.d.get(0)).c;
            localArrayList2 = this.d;
          }
          for (;;)
          {
            int i1;
            ArrayList localArrayList3;
            if ((this.f != null) && (this.f.size() > 0))
            {
              i1 = ((b)this.f.get(0)).c;
              localArrayList3 = this.f;
            }
            for (;;)
            {
              if ((j == i1) && (i1 != -1))
              {
                this.e = localArrayList3;
                label348:
                if ((k != i1) || (i1 == -1)) {
                  break label600;
                }
              }
              for (this.d = localArrayList3;; this.d = localArrayList1) {
                label510:
                label563:
                label600:
                do
                {
                  if (Math.abs(i2) == 1) {
                    this.f = localArrayList1;
                  }
                  localArrayList1 = new ArrayList();
                  if (k != j)
                  {
                    localArrayList2 = b(k);
                    a(localArrayList2, this.d, localArrayList1);
                    this.d = localArrayList2;
                  }
                  if ((this.f != null) && (this.f.size() > 0))
                  {
                    localArrayList2 = b(((b)this.f.get(0)).c);
                    a(localArrayList2, this.f, null);
                    this.f = localArrayList2;
                  }
                  localArrayList2 = b(j);
                  a(localArrayList2, this.e, localArrayList1);
                  this.e = localArrayList2;
                  this.g.a(localArrayList1);
                  this.a.c().invalidate();
                  return;
                  if ((com.tencent.mapsdk.a.b.d) && (this.c.d().a() > 6) && (!com.tencent.mapsdk.a.c.a(this.c.b().b, this.c.b().a))) {
                    break;
                  }
                  j = 1;
                  break;
                  this.a.f().b(256);
                  break label132;
                  if ((j != n) || (n == -1)) {
                    break label348;
                  }
                  this.e = localArrayList2;
                  break label348;
                } while ((k != m) || (m == -1));
              }
              localArrayList3 = null;
              i1 = -1;
            }
            label630:
            localArrayList2 = null;
            n = -1;
          }
          localArrayList1 = null;
          m = -1;
        }
      }
    }
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    boolean bool1 = false;
    a(paramCanvas, this.d);
    a(paramCanvas, this.f);
    if (this.i == null) {
      this.i = new PaintFlagsDrawFilter(0, 2);
    }
    paramCanvas.setDrawFilter(this.i);
    boolean bool2 = a(paramCanvas, this.e);
    paramCanvas.setDrawFilter(null);
    if (bool2)
    {
      if (this.f != null) {
        this.f.clear();
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public final int b()
  {
    return this.h;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */