package st;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.List;

class n
  extends b
{
  final j c = new j();
  final r d;
  private final e e = new e((byte)0);
  private final d f = new d((byte)0);
  private final h g;
  private long h;
  private long i;
  private long j;
  private int k;
  private long l;
  private boolean m;
  private Location n;
  private int o;
  private float p;
  private float q;
  private float r;
  private int s;
  private int t;
  private long u;
  
  n()
    throws Exception
  {
    if (h.a == null) {
      h.a = new h();
    }
    this.g = h.a;
    this.m = true;
    this.d = new r(this);
  }
  
  private boolean a(long paramLong, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, int paramInt2, float paramFloat2)
  {
    boolean bool1 = false;
    paramLong /= 1000L;
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    if (this.m)
    {
      this.c.a(paramLong, paramDouble1, paramDouble2, paramFloat1, this.e.b, w.k);
      this.m = false;
      bool1 = true;
    }
    j.a locala = new j.a(paramInt1, paramLong, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramInt2, paramFloat2, 0, 0.0D, 0.0D);
    this.c.a(locala);
    boolean bool2 = w.f;
    return bool1;
  }
  
  private void c()
  {
    this.g.j = false;
    this.d.c();
    this.f.a();
    this.e.a();
    b();
    this.i = 0L;
    this.j = SystemClock.elapsedRealtime();
    this.p = 0.0F;
    this.q = 0.0F;
    this.r = 0.0F;
    this.s = 0;
    this.t = 0;
    this.k = 0;
  }
  
  final k.a a(b.1 param1)
  {
    return new k.a(0L);
  }
  
  final void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, long paramLong1, long paramLong2)
  {
    if (paramInt2 <= 0) {
      return;
    }
    Object localObject = this.e;
    if (paramInt3 >= 3)
    {
      if (paramLong2 - ((e)localObject).a <= 5000L) {
        ((e)localObject).a(true);
      }
      ((e)localObject).a = paramLong2;
    }
    int i1 = Math.round(paramFloat);
    if (!b.1.a(paramDouble1, paramDouble2)) {}
    for (localObject = "";; localObject = "&GD=" + paramDouble1 + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt3 + ',' + paramInt4 + ',' + paramInt2 + ',' + i1 + ',' + paramLong1 + ',')
    {
      this.f.a((String)localObject, paramLong2);
      if (a(paramLong2, 1, paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt4, paramInt3)) {
        this.g.a(paramDouble1, paramDouble2, paramInt2, this.p, this.q, this.r);
      }
      if (d.a(paramLong2, this.j)) {
        this.d.a(paramDouble1, paramDouble2, paramInt2, paramFloat, this.p, this.q, this.r, paramLong2);
      }
      boolean bool = w.f;
      return;
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong)
  {
    Object localObject1 = this.e;
    if (paramLong - ((e)localObject1).a > 5000L) {
      ((e)localObject1).a(false);
    }
    if (paramLong - this.j > 5000L) {
      c();
    }
    this.p = paramFloat1;
    this.q = paramFloat2;
    this.r = paramFloat4;
    this.s = paramInt;
    this.j = paramLong;
    if (paramFloat5 > 0.0F)
    {
      i1 = 1;
      this.t = i1;
      if ((this.i != 0L) || (paramLong - this.u >= 30000L))
      {
        if (i1 != 0) {
          break label327;
        }
        bool = true;
        label119:
        if ((!bool) || (!this.e.b))
        {
          y.f().a(bool);
          k.f().a(bool);
        }
      }
      localObject1 = new double[2];
      localObject2 = this.g;
      arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = paramFloat1;
      arrayOfDouble1[1] = paramFloat2;
      if (!((h)localObject2).j) {
        break label385;
      }
      localObject1[0] = ((h)localObject2).b;
      localObject1[1] = ((h)localObject2).c;
      localObject1[0] += 1.0E-5D * (arrayOfDouble1[1] - ((h)localObject2).e) / ((h)localObject2).h;
      localObject1[1] += 1.0E-5D * (arrayOfDouble1[0] - ((h)localObject2).d) / ((h)localObject2).i;
      if (localObject1[0] <= 90.0D) {
        break label333;
      }
      localObject1[0] = (180.0D - localObject1[0]);
      label289:
      if (localObject1[1] <= 180.0D) {
        break label359;
      }
      localObject1[1] -= 360.0D;
    }
    label312:
    label327:
    label333:
    label359:
    label385:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label391;
      }
      return;
      i1 = 0;
      break;
      bool = false;
      break label119;
      if (localObject1[0] >= -90.0D) {
        break label289;
      }
      localObject1[0] = (-180.0D - localObject1[0]);
      break label289;
      if (localObject1[1] >= -180.0D) {
        break label312;
      }
      localObject1[1] += 360.0D;
      break label312;
    }
    label391:
    double d1 = localObject1[0];
    double d2 = localObject1[1];
    localObject1 = this.g;
    paramFloat2 = (paramFloat4 - ((h)localObject1).f) / 10.0F;
    paramFloat4 = ((h)localObject1).g;
    paramFloat1 = 0.0F;
    localObject1 = new Location("S");
    ((Location)localObject1).setLatitude(d1);
    ((Location)localObject1).setLongitude(d2);
    if (this.n != null) {
      paramFloat1 = this.n.bearingTo((Location)localObject1);
    }
    this.n = ((Location)localObject1);
    i1 = Math.max(0, paramInt - this.o);
    this.o = paramInt;
    long l1 = paramLong / 1000L;
    d1 = Math.toRadians(d1);
    d2 = Math.toRadians(d2);
    double d3 = Math.toRadians(paramFloat1);
    localObject1 = new j.a(3, l1, d1, d2, 0.0D, paramFloat2 + paramFloat4, 0, paramFloat5, i1, paramFloat3, d3);
    this.c.a((j.a)localObject1);
    boolean bool = w.f;
    localObject1 = new double[4];
    l1 = paramLong / 1000L;
    Object localObject2 = new double[2];
    double[] arrayOfDouble1 = new double[2];
    double[] arrayOfDouble2 = new double[2];
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    j localj = this.c;
    d1 = l1 - localj.a.v;
    d2 = d1 * d1;
    double[] arrayOfDouble5 = new double[2];
    localObject2[0] = (localj.a.w[0] + localj.a.w[2] * d1);
    d3 = localj.a.w[1];
    localObject2[1] = (d1 * localj.a.w[3] + d3);
    arrayOfDouble2[0] = localj.a.w[2];
    arrayOfDouble2[1] = localj.a.w[3];
    int i2;
    if (localj.a.e)
    {
      localObject2[0] -= localj.a.f[0];
      localObject2[1] -= localj.a.f[1];
      d1 = Math.sqrt(arrayOfDouble5[0] * arrayOfDouble5[0] + arrayOfDouble5[1] * arrayOfDouble5[1]);
      d1 = d1 * d1 * localj.a.z;
      arrayOfDouble3[0][0] = (localj.a.x[0][0] + localj.a.x[2][2] * d2 + d1);
      arrayOfDouble3[0][1] = (localj.a.x[0][1] + localj.a.x[2][3] * d2);
      arrayOfDouble3[1][0] = (localj.a.x[1][0] + localj.a.x[3][2] * d2);
      arrayOfDouble5 = arrayOfDouble3[1];
      d3 = localj.a.x[1][1];
      arrayOfDouble5[1] = (d1 + (d2 * localj.a.x[3][3] + d3));
      arrayOfDouble4[0][0] = localj.a.x[2][2];
      arrayOfDouble4[0][1] = localj.a.x[2][3];
      arrayOfDouble4[1][0] = localj.a.x[3][2];
      arrayOfDouble4[1][1] = localj.a.x[3][3];
      localj.a(1, (double[])localObject2, arrayOfDouble1);
      localObject1[0] = Math.toDegrees(arrayOfDouble1[0]);
      localObject1[1] = Math.toDegrees(arrayOfDouble1[1]);
      localObject1[2] = Math.sqrt((arrayOfDouble3[0][0] + arrayOfDouble3[1][1]) / 2.0D);
      localObject1[3] = Math.sqrt(arrayOfDouble2[0] * arrayOfDouble2[0] + arrayOfDouble2[1] * arrayOfDouble2[1]);
      bool = w.f;
      d1 = localObject1[0];
      d2 = localObject1[1];
      paramInt = Double.valueOf(localObject1[2]).intValue();
      i1 = Double.valueOf(localObject1[3]).intValue();
      i2 = this.k;
      if (b.1.a(d1, d2)) {
        break label1260;
      }
    }
    label1260:
    for (localObject1 = "";; localObject1 = "&SD=" + d1 + ',' + d2 + ',' + 0 + ',' + paramInt + ',' + i2 + ',' + 0 + ',' + i1 + ',' + 0 + ',' + 0 + ',' + 0)
    {
      this.f.b((String)localObject1, paramLong);
      b(new a(d1, d2, paramInt, this.k, this.l));
      return;
      d1 = 0.0D;
      break;
    }
  }
  
  void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    b(new b(paramInt, paramString, (byte)0));
    if ((paramInt == -4) || (paramInt == -5)) {
      e();
    }
  }
  
  /* Error */
  void a(android.os.Handler paramHandler, b.1 param1)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: instanceof 12
    //   6: ifeq +44 -> 50
    //   9: aload_2
    //   10: checkcast 12	st/n$c
    //   13: astore_2
    //   14: aload_0
    //   15: aload_2
    //   16: getfield 354	st/n$c:b	J
    //   19: putfield 356	st/n:h	J
    //   22: aload_0
    //   23: invokespecial 208	st/n:c	()V
    //   26: aload_0
    //   27: getfield 82	st/n:d	Lst/r;
    //   30: aload_1
    //   31: putfield 359	st/r:c	Landroid/os/Handler;
    //   34: aload_0
    //   35: invokestatic 129	android/os/SystemClock:elapsedRealtime	()J
    //   38: putfield 210	st/n:u	J
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: invokespecial 361	st/b:a	(Landroid/os/Handler;Lst/b$1;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_2
    //   55: getfield 362	st/b$1:a	J
    //   58: lstore_3
    //   59: new 12	st/n$c
    //   62: dup
    //   63: lload_3
    //   64: ldc2_w 363
    //   67: invokespecial 367	st/n$c:<init>	(JJ)V
    //   70: astore_2
    //   71: goto -57 -> 14
    //   74: ldc2_w 153
    //   77: lstore_3
    //   78: goto -19 -> 59
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	n
    //   0	86	1	paramHandler	android.os.Handler
    //   0	86	2	param1	b.1
    //   58	20	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   2	14	81	finally
    //   14	47	81	finally
    //   54	59	81	finally
    //   59	71	81	finally
  }
  
  final void a(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    paramLong1 = b.1.a(paramLong1);
    boolean bool;
    Object localObject2;
    Object localObject1;
    q localq;
    int i1;
    long l1;
    if ((this.i == 0L) || (paramLong2 - this.i >= this.h))
    {
      bool = true;
      localObject2 = b.1.a(paramList, bool);
      localObject1 = this.f.a((String)localObject2, paramLong2, bool);
      if (!bool) {
        break label315;
      }
      localq = q.b();
      i1 = this.t;
      if (localObject1 != null)
      {
        if (!localq.b) {
          break label273;
        }
        if (!localq.f()) {
          break label268;
        }
        l1 = System.currentTimeMillis();
        long l2 = SystemClock.elapsedRealtime();
        if (localq.c != null) {
          localq.c.a(new q.e(localq, (String)localObject1, l1, l2, i1, (byte)0));
        }
      }
    }
    for (;;)
    {
      if (d.a(paramLong2, this.j))
      {
        localObject1 = null;
        if (!bool) {
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = b.1.a(paramList, false);
        }
        paramList = b.1.a((String)localObject2, paramLong1, "2");
        localObject1 = this.d;
        float f1 = this.p;
        float f2 = this.q;
        float f3 = this.r;
        float f4 = this.s;
        i1 = this.k;
        if (((r)localObject1).a != 0.0F) {
          x.a(null).a(new r.a((r)localObject1, f1, f2, f3, f4, i1, paramList, (byte)0));
        }
      }
      return;
      bool = false;
      break;
      label268:
      localq.c();
      label273:
      l1 = b.1.a(System.currentTimeMillis());
      if (localq.c != null)
      {
        localq.c.a(new q.c(localq, (String)localObject1, l1, 0, (byte)0));
        continue;
        label315:
        q.b().a(b.1.a((String)localObject1, paramLong1, "0"));
      }
    }
  }
  
  void a(v paramv, long paramLong1, long paramLong2)
  {
    this.i = paramv.g;
    this.k = paramv.c;
    this.l = paramv.h;
    if ((paramv.e.equals("W")) && (a(paramLong2, 2, paramv.a, paramv.b, 0.0D, paramv.d, paramv.i, 0.0F))) {
      this.g.a(paramv.a, paramv.b, paramv.d, this.p, this.q, this.r);
    }
    if (!t.b().c) {
      b(new a(paramv.a, paramv.b, Float.valueOf(paramv.d).intValue(), this.k, this.l));
    }
  }
  
  final void b()
  {
    this.m = true;
    this.n = null;
    this.o = 0;
  }
  
  final void e()
  {
    try
    {
      this.d.a();
      super.e();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static final class a
    extends o
  {
    final double a;
    final double b;
    final int c;
    final int d;
    final long e;
    
    a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.a = paramDouble1;
      this.b = paramDouble2;
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramLong;
    }
  }
  
  static final class b
    extends o
  {
    final int a;
    final String b;
    
    private b(int paramInt, String paramString)
    {
      super();
      this.a = paramInt;
      this.b = paramString;
    }
    
    b(int paramInt, String paramString, byte paramByte)
    {
      this(paramInt, paramString);
    }
  }
  
  static final class c
    extends b.1
  {
    final long b;
    
    c(long paramLong1, long paramLong2)
    {
      super();
      this.b = paramLong2;
    }
  }
  
  static final class d
  {
    private String a;
    private long b;
    private String c;
    private long d;
    
    static boolean a(long paramLong1, long paramLong2)
    {
      return Math.abs(paramLong1 - paramLong2) <= 10000L;
    }
    
    final String a(String paramString, long paramLong, boolean paramBoolean)
    {
      String str;
      if (paramBoolean) {
        str = paramString;
      }
      for (;;)
      {
        try
        {
          if (this.a != null)
          {
            str = paramString;
            if (a(paramLong, this.b))
            {
              str = paramString + this.a;
              this.a = null;
            }
          }
          paramString = str;
          if (this.c != null)
          {
            paramString = str;
            if (a(paramLong, this.d))
            {
              paramString = str + this.c;
              this.c = null;
            }
          }
          return paramString;
        }
        finally {}
        str = paramString;
        if (this.a != null)
        {
          str = paramString;
          if (a(paramLong, this.b))
          {
            str = paramString + b.1.c(this.a);
            this.a = null;
          }
        }
        paramString = str;
        if (this.c != null)
        {
          paramString = str;
          if (a(paramLong, this.d))
          {
            paramString = str + b.1.b(this.c);
            this.c = null;
          }
        }
      }
    }
    
    final void a()
    {
      try
      {
        this.a = null;
        this.c = null;
        this.b = 0L;
        this.d = 0L;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    final void a(String paramString, long paramLong)
    {
      try
      {
        this.a = paramString;
        this.b = paramLong;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    final void b(String paramString, long paramLong)
    {
      try
      {
        this.c = paramString;
        this.d = paramLong;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
  
  final class e
  {
    long a;
    boolean b = w.j;
    
    private e() {}
    
    final void a()
    {
      this.a = 0L;
      this.b = w.j;
    }
    
    final void a(boolean paramBoolean)
    {
      if ((this.b ^ paramBoolean)) {
        if (this.b) {
          break label69;
        }
      }
      label69:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.b = paramBoolean;
        n.this.d.a();
        n.this.d.c();
        n.this.c.a(this.b);
        n.this.b();
        paramBoolean = w.f;
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */