package st;

import android.location.Location;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

final class r
{
  float a;
  final d b;
  Handler c;
  private long d;
  private ArrayList<String> e = new ArrayList();
  private ArrayList<float[]> f = new ArrayList();
  private ArrayList<double[]> g = new ArrayList();
  
  public r(d paramd)
  {
    this.b = paramd;
  }
  
  private void a(o paramo)
  {
    if (this.c != null) {
      this.c.post(new d(paramo, (byte)0));
    }
  }
  
  private void a(boolean paramBoolean)
    throws Exception
  {
    for (;;)
    {
      int k;
      int i3;
      int i;
      int m;
      double[] arrayOfDouble2;
      double d2;
      double d6;
      double d7;
      label415:
      StringBuilder localStringBuilder;
      float f1;
      float f2;
      int j;
      float[] arrayOfFloat;
      double[] arrayOfDouble4;
      label770:
      int n;
      for (;;)
      {
        int i2;
        try
        {
          if ((this.f.isEmpty()) || (this.g.isEmpty())) {
            break label1216;
          }
          if (paramBoolean)
          {
            k = this.g.size();
            i3 = this.f.size();
            if (k <= 1) {
              break label1216;
            }
            i = 0;
            m = 1;
            if (m >= k) {
              break label1148;
            }
            double[] arrayOfDouble1 = (double[])this.g.get(m - 1);
            arrayOfDouble2 = (double[])this.g.get(m);
            Object localObject1 = new float[1];
            d2 = arrayOfDouble1[0];
            double d3 = arrayOfDouble1[1];
            double d4 = arrayOfDouble1[0];
            double d5 = arrayOfDouble1[1];
            if (arrayOfDouble1[1] > 179.0D) {
              break label1299;
            }
            d1 = 1.0E-5D;
            Location.distanceBetween(d2, d3, d4, d1 + d5, (float[])localObject1);
            d3 = localObject1[0];
            d2 = arrayOfDouble1[0];
            d4 = arrayOfDouble1[1];
            d5 = arrayOfDouble1[0];
            if (arrayOfDouble1[0] > 89.0D) {
              break label1306;
            }
            d1 = 1.0E-5D;
            Location.distanceBetween(d2, d4, d1 + d5, arrayOfDouble1[1], (float[])localObject1);
            d4 = localObject1[0];
            d5 = arrayOfDouble2[0];
            d6 = arrayOfDouble1[0];
            d2 = arrayOfDouble2[1] - arrayOfDouble1[1];
            if (d2 <= 180.0D) {
              break label1313;
            }
            d1 = d2 - 360.0D;
            d1 = d1 / 1.0E-5D * d3;
            d5 = (d5 - d6) / 1.0E-5D * d4;
            d6 = arrayOfDouble2[4] - arrayOfDouble1[4];
            d7 = arrayOfDouble2[5] - arrayOfDouble1[5];
            d2 = Math.sqrt((d1 * d1 + d5 * d5) / (d6 * d6 + d7 * d7));
            if ((d2 < 1.0F / w.n) || (d2 > w.n)) {
              break label1225;
            }
            d5 = Math.atan2(d5, d1) - Math.atan2(d7, d6);
            d1 = Math.cos(d5);
            d5 = Math.sin(d5);
            double[] arrayOfDouble3 = new double[4];
            arrayOfDouble3[0] = d1;
            arrayOfDouble3[1] = (-d5);
            arrayOfDouble3[2] = d5;
            arrayOfDouble3[3] = d1;
            if (d2 < 1.0D)
            {
              d1 = d2;
              d1 *= 10.0D;
              d5 = 1.0D + Math.abs(d5);
              localStringBuilder = new StringBuilder();
              f3 = 0.0F;
              paramBoolean = w.f;
              f1 = 0.0F;
              f2 = 0.0F;
              f4 = 0.0F;
              i1 = 0;
              j = 1;
              if (i >= i3) {
                break label1014;
              }
              arrayOfFloat = (float[])this.f.get(i);
              if (arrayOfFloat[2] > arrayOfDouble2[6]) {
                break label1014;
              }
              arrayOfFloat[3] = Double.valueOf(Math.max(6.0D, Math.min(Math.abs((arrayOfFloat[2] - arrayOfDouble1[6]) / d1) * d5 + arrayOfDouble1[2], Math.abs((arrayOfFloat[2] - arrayOfDouble2[6]) / d1) * d5 + arrayOfDouble2[2]))).floatValue();
              arrayOfDouble4 = new double[2];
              arrayOfDouble4[0] = (arrayOfFloat[0] - arrayOfDouble1[4]);
              arrayOfDouble4[1] = (arrayOfFloat[1] - arrayOfDouble1[5]);
              localObject1 = new double[2];
              arrayOfDouble4[0] *= d2;
              arrayOfDouble4[1] *= d2;
              arrayOfDouble4 = new double[2];
              arrayOfDouble4[0] = (localObject1[0] * arrayOfDouble3[0] + localObject1[1] * arrayOfDouble3[1]);
              arrayOfDouble4[1] = (localObject1[0] * arrayOfDouble3[2] + localObject1[1] * arrayOfDouble3[3]);
              localObject1 = new double[2];
              arrayOfDouble4[0] += 0.0D;
              arrayOfDouble4[1] += 0.0D;
              arrayOfDouble4 = new double[2];
              arrayOfDouble4[0] = (1.0E-5D * localObject1[1] / d4 + arrayOfDouble1[0]);
              arrayOfDouble4[1] = (1.0E-5D * localObject1[0] / d3 + arrayOfDouble1[1]);
              if (arrayOfDouble4[0] <= 90.0D) {
                continue;
              }
              arrayOfDouble4[0] = (180.0D - arrayOfDouble4[0]);
              break label1228;
              paramBoolean = w.f;
              localObject1 = (String)this.e.get(i);
              i2 = Math.round(arrayOfFloat[3]);
              n = i1;
              if (i2 > i1) {
                n = i2;
              }
              i1 = Math.round(arrayOfFloat[4]);
              if (localObject1 == null) {
                break label1254;
              }
              localStringBuilder.append((String)localObject1);
              d6 = arrayOfDouble4[0];
              d7 = arrayOfDouble4[1];
              if (b.1.a(d6, d7)) {
                break label952;
              }
              localObject1 = "";
              localStringBuilder.append((String)localObject1);
              break label1254;
            }
          }
          else
          {
            k = this.g.size() - 1;
            break;
          }
          d1 = 1.0D / d2;
          break label415;
          if (arrayOfDouble4[0] >= -90.0D) {
            break label1228;
          }
          arrayOfDouble4[0] = (-180.0D - arrayOfDouble4[0]);
        }
        finally {}
        if (arrayOfDouble4[1] < -180.0D)
        {
          arrayOfDouble4[1] += 360.0D;
          continue;
          label952:
          String str = "|MD," + d6 + ',' + d7 + ',' + i2 + ',' + i1 + ',' + "";
        }
      }
      label1014:
      paramBoolean = w.f;
      boolean bool = false;
      paramBoolean = bool;
      if (i1 <= w.l)
      {
        f2 = f4 - f2;
        paramBoolean = bool;
        if (f2 > 0.0F)
        {
          paramBoolean = bool;
          if ((f3 - f1) * d2 / f2 <= w.m)
          {
            q.b().a(localStringBuilder.toString());
            paramBoolean = true;
          }
        }
      }
      bool = w.f;
      a(new g(paramBoolean));
      break label1335;
      label1108:
      while ((i < i3) && (((float[])this.f.get(i))[2] <= arrayOfDouble2[6]))
      {
        i += 1;
        continue;
        label1148:
        this.e.subList(0, i).clear();
        this.e.trimToSize();
        this.f.subList(0, i).clear();
        this.f.trimToSize();
        this.g.subList(0, k - 1).clear();
        this.g.trimToSize();
        label1216:
        return;
      }
      break label1335;
      for (;;)
      {
        break label1274;
        label1225:
        break label1108;
        label1228:
        if (arrayOfDouble4[1] <= 180.0D) {
          break;
        }
        arrayOfDouble4[1] -= 360.0D;
        break label770;
        label1254:
        if (j != 0)
        {
          f2 = arrayOfFloat[5];
          f1 = arrayOfFloat[2];
          j = 0;
        }
      }
      label1274:
      float f4 = arrayOfFloat[5];
      float f3 = arrayOfFloat[2];
      i += 1;
      int i1 = n;
      continue;
      label1299:
      double d1 = -1.0E-5D;
      continue;
      label1306:
      d1 = -1.0E-5D;
      continue;
      label1313:
      d1 = d2;
      if (d2 < -180.0D)
      {
        d1 = d2 + 360.0D;
        continue;
        label1335:
        m += 1;
      }
    }
  }
  
  private void e()
  {
    try
    {
      this.g.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void f()
  {
    try
    {
      this.e.clear();
      this.f.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void a()
  {
    x.a(null).a(new c((byte)0));
  }
  
  final void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    label452:
    for (;;)
    {
      try
      {
        int j = this.g.size();
        int k = this.e.size();
        int i = 0;
        if (j <= 0)
        {
          this.g.add(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, k, paramDouble8 });
          i = 1;
          if (i != 0)
          {
            i = this.g.size();
            a(new e(i));
            if (i == 1) {
              f();
            }
          }
          return;
        }
        double[] arrayOfDouble1 = (double[])this.g.get(j - 1);
        float[] arrayOfFloat;
        if (paramDouble8 - arrayOfDouble1[8] < 30000.0D)
        {
          if (paramDouble4 < arrayOfDouble1[3]) {
            continue;
          }
          arrayOfFloat = new float[1];
          arrayOfFloat[0] = 30.0F;
          if (j > 1)
          {
            double[] arrayOfDouble2 = (double[])this.g.get(j - 2);
            Location.distanceBetween(arrayOfDouble2[0], arrayOfDouble2[1], paramDouble1, paramDouble2, arrayOfFloat);
          }
          if (arrayOfFloat[0] >= 30.0F)
          {
            double d1 = k;
            i = arrayOfDouble1.length;
            System.arraycopy(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, d1, paramDouble8 }, 0, arrayOfDouble1, 0, i);
            i = 1;
            break label452;
          }
        }
        else
        {
          arrayOfFloat = new float[1];
          Location.distanceBetween(arrayOfDouble1[0], arrayOfDouble1[1], paramDouble1, paramDouble2, arrayOfFloat);
          if (arrayOfFloat[0] < 30.0F) {
            continue;
          }
          this.g.add(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, k, paramDouble8 });
          i = 1;
          if (j >= 8)
          {
            this.g.subList(0, 1).clear();
            this.g.trimToSize();
          }
          try
          {
            a(false);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          continue;
        }
        i = 0;
      }
      finally {}
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, String paramString)
  {
    try
    {
      this.e.add(paramString);
      this.f.add(new float[] { paramFloat1, paramFloat2, paramFloat3, 0.0F, paramInt, paramFloat4 });
      if (this.e.size() > 256)
      {
        this.e.subList(0, 1).clear();
        this.e.trimToSize();
        if (this.f.size() > 256)
        {
          this.f.subList(0, 1).clear();
          this.f.trimToSize();
        }
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final boolean a(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, double paramDouble4, double paramDouble5, double paramDouble6, long paramLong)
  {
    if (paramFloat < w.o) {
      return false;
    }
    if ((paramLong - this.d < 1000L) && (paramFloat <= this.a)) {
      return false;
    }
    x.a(null).a(new b(paramDouble1, paramDouble2, paramDouble3, paramFloat, paramDouble4, paramDouble5, paramDouble6, paramLong, (byte)0));
    this.d = paramLong;
    this.a = paramFloat;
    return true;
  }
  
  final void b()
  {
    try
    {
      a(true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  final void c()
  {
    this.d = 0L;
    this.a = 0.0F;
    x.a(null).a(new f((byte)0));
  }
  
  final void d()
  {
    try
    {
      e();
      f();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final class a
    implements Runnable
  {
    private float a;
    private float b;
    private float c;
    private float d;
    private int e;
    private String f;
    
    private a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, String paramString)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramFloat4;
      this.e = paramInt;
      this.f = paramString;
    }
    
    public final void run()
    {
      r.this.a(this.a, this.b, this.c, this.d, this.e, this.f);
    }
  }
  
  final class b
    implements Runnable
  {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    
    private b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
      this.c = paramDouble3;
      this.d = paramDouble4;
      this.e = paramDouble5;
      this.f = paramDouble6;
      this.g = paramDouble7;
      this.h = paramDouble8;
    }
    
    public final void run()
    {
      r.this.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
  }
  
  final class c
    implements Runnable
  {
    private c() {}
    
    public final void run()
    {
      r.this.b();
    }
  }
  
  final class d
    implements Runnable
  {
    private final o a;
    
    private d(o paramo)
    {
      this.a = paramo;
    }
    
    public final void run()
    {
      r.this.b.b(this.a);
    }
  }
  
  static final class e
    extends o
  {
    final int a;
    
    e(int paramInt)
    {
      super();
      this.a = paramInt;
    }
  }
  
  final class f
    implements Runnable
  {
    private f() {}
    
    public final void run()
    {
      r.this.d();
    }
  }
  
  static final class g
    extends o
  {
    final boolean a;
    
    g(boolean paramBoolean)
    {
      super();
      this.a = paramBoolean;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */