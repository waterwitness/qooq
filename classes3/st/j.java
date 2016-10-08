package st;

import java.lang.reflect.Array;

final class j
{
  final b a = new b((byte)0);
  private double[] b = new double[4];
  private final b c = new b((byte)0);
  
  private void a(double paramDouble, boolean paramBoolean)
  {
    double d4 = paramDouble - this.a.v;
    double d5 = d4 * d4;
    if (paramBoolean)
    {
      this.a.x[2][2] = this.a.r;
      this.a.x[2][3] = 0L;
      this.a.x[3][2] = 0L;
      this.a.x[3][3] = this.a.r;
    }
    while (d4 > 0.5D)
    {
      double d2 = 1.0D;
      double d1 = 0.0D;
      for (;;)
      {
        if (d1 < d4)
        {
          d2 *= this.a.A;
          d1 += 1.0D;
          continue;
          d1 = 1.0D;
          double d3 = d1;
          if (d4 > 0.5D)
          {
            d2 = 0.0D;
            for (;;)
            {
              d3 = d1;
              if (d2 >= d4) {
                break;
              }
              d3 = this.a.a;
              d2 = 1.0D + d2;
              d1 = d3 * d1;
            }
          }
          double[] arrayOfDouble = this.a.x[2];
          arrayOfDouble[2] *= d3;
          arrayOfDouble = this.a.x[2];
          arrayOfDouble[3] *= d3;
          arrayOfDouble = this.a.x[3];
          arrayOfDouble[2] *= d3;
          arrayOfDouble = this.a.x[3];
          arrayOfDouble[3] = (d3 * arrayOfDouble[3]);
          break;
        }
      }
      b.a(this.a, d2);
    }
    this.a.w[0] += this.a.w[2] * d4;
    this.a.w[1] += this.a.w[3] * d4;
    if (this.a.B)
    {
      this.a.x[0][0] += this.a.x[2][2] * d5;
      this.a.x[0][1] += this.a.x[2][3] * d5;
      this.a.x[1][0] += this.a.x[3][2] * d5;
      this.a.x[1][1] += this.a.x[3][3] * d5;
    }
    for (;;)
    {
      this.a.v = paramDouble;
      return;
      this.a.x[0][0] = (this.a.x[0][0] + (this.a.x[0][2] + this.a.x[2][0]) * d4 + this.a.x[2][2] * d5);
      this.a.x[1][1] = (this.a.x[1][1] + (this.a.x[1][3] + this.a.x[3][1]) * d4 + this.a.x[3][3] * d5);
      this.a.x[0][2] += this.a.x[2][2] * d4;
      this.a.x[2][0] += this.a.x[2][2] * d4;
      this.a.x[1][3] += this.a.x[3][3] * d4;
      this.a.x[3][1] += this.a.x[3][3] * d4;
    }
  }
  
  private void a(double[] paramArrayOfDouble)
  {
    double d3;
    double d1;
    double d4;
    int i;
    if ((this.a.t) && (this.a.e))
    {
      Object localObject = new double[2];
      double[] arrayOfDouble = new double[2];
      double d5 = this.a.G;
      localObject[0] = (this.a.w[0] - this.a.f[0]);
      localObject[1] = (this.a.w[1] - this.a.f[1]);
      paramArrayOfDouble[0] -= this.a.f[0];
      paramArrayOfDouble[1] -= this.a.f[1];
      double d2 = Math.sqrt(localObject[0] * localObject[0] + localObject[1] * localObject[1]);
      d3 = Math.sqrt(arrayOfDouble[0] * arrayOfDouble[0] + arrayOfDouble[1] * arrayOfDouble[1]);
      if ((d2 > this.a.m) && (d3 > this.a.m))
      {
        d1 = Math.atan2(localObject[1], localObject[0]);
        d4 = Math.atan2(arrayOfDouble[1], arrayOfDouble[0]) - d1;
        if (d4 <= 3.141592653589793D) {
          break label370;
        }
        d1 = d4 - 6.283185307179586D;
        localObject = this.a;
        ((b)localObject).y = (d5 * d1 + ((b)localObject).y);
        if (d1 * d1 <= 4.0D * this.a.z) {
          break label392;
        }
        i = 1;
        label278:
        d4 = Math.sqrt(this.a.x[0][0] + this.a.x[1][1]);
        if (d2 >= d3) {
          break label398;
        }
        d1 = d2;
        label317:
        d1 = d4 / d1;
        if (i == 0) {
          break label404;
        }
      }
    }
    label370:
    label392:
    label398:
    label404:
    for (this.a.z = (d1 * d1);; this.a.z = (1.0D / (1.0D / (d1 * d1) + 1.0D / this.a.z)))
    {
      this.a.f[0] = paramArrayOfDouble[0];
      this.a.f[1] = paramArrayOfDouble[1];
      this.a.e = true;
      return;
      d1 = d4;
      if (d4 >= -3.141592653589793D) {
        break;
      }
      d1 = d4 + 6.283185307179586D;
      break;
      i = 0;
      break label278;
      d1 = d3;
      break label317;
    }
  }
  
  private static void a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d = 1.0D / (paramArrayOfDouble1[0] * paramArrayOfDouble1[3] - paramArrayOfDouble1[1] * paramArrayOfDouble1[2]);
    paramArrayOfDouble2[0] = (paramArrayOfDouble1[3] * d);
    paramArrayOfDouble2[3] = (paramArrayOfDouble1[0] * d);
    paramArrayOfDouble2[1] = (-paramArrayOfDouble1[1] * d);
    paramArrayOfDouble2[2] = (d * -paramArrayOfDouble1[2]);
  }
  
  private static boolean a(double[][] paramArrayOfDouble1, double[][] paramArrayOfDouble2)
  {
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
    arrayOfDouble[0][0] = (paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[1][0] = (-paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[2][0] = (paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[3][0] = (-paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[0][1] = (-paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[1][1] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[2][1] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[3][1] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[0][2] = (paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[1][2] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[2][2] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[3][2] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[0][3] = (-paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[1][3] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[2][3] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][1] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[3][3] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][1] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][1]);
    double d = paramArrayOfDouble1[0][0] * arrayOfDouble[0][0] + paramArrayOfDouble1[0][1] * arrayOfDouble[1][0] + paramArrayOfDouble1[0][2] * arrayOfDouble[2][0] + paramArrayOfDouble1[0][3] * arrayOfDouble[3][0];
    if (d == 0.0D) {
      return false;
    }
    d = 1.0D / d;
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      while (j < 4)
      {
        arrayOfDouble[i][j] *= d;
        j += 1;
      }
      i += 1;
    }
    return true;
  }
  
  private void b(double paramDouble, boolean paramBoolean)
  {
    double d4 = paramDouble - this.c.v;
    double d5 = d4 * d4;
    if (paramBoolean)
    {
      this.c.x[2][2] = this.c.r;
      this.c.x[2][3] = 0L;
      this.c.x[3][2] = 0L;
      this.c.x[3][3] = this.c.r;
    }
    while (d4 > 0.5D)
    {
      double d2 = 1.0D;
      double d1 = 0.0D;
      for (;;)
      {
        if (d1 < d4)
        {
          d2 *= this.c.A;
          d1 += 1.0D;
          continue;
          d1 = 1.0D;
          double d3 = d1;
          if (d4 > 0.5D)
          {
            d2 = 0.0D;
            for (;;)
            {
              d3 = d1;
              if (d2 >= d4) {
                break;
              }
              d3 = this.c.a;
              d2 = 1.0D + d2;
              d1 = d3 * d1;
            }
          }
          double[] arrayOfDouble = this.c.x[2];
          arrayOfDouble[2] *= d3;
          arrayOfDouble = this.c.x[2];
          arrayOfDouble[3] *= d3;
          arrayOfDouble = this.c.x[3];
          arrayOfDouble[2] *= d3;
          arrayOfDouble = this.c.x[3];
          arrayOfDouble[3] = (d3 * arrayOfDouble[3]);
          break;
        }
      }
      b.a(this.c, d2);
    }
    this.c.w[0] += this.c.w[2] * d4;
    this.c.w[1] += this.c.w[3] * d4;
    if (this.c.B)
    {
      this.c.x[0][0] += this.c.x[2][2] * d5;
      this.c.x[0][1] += this.c.x[2][3] * d5;
      this.c.x[1][0] += this.c.x[3][2] * d5;
      this.c.x[1][1] += this.c.x[3][3] * d5;
    }
    for (;;)
    {
      this.c.v = paramDouble;
      return;
      this.c.x[0][0] = (this.c.x[0][0] + (this.c.x[0][2] + this.c.x[2][0]) * d4 + this.c.x[2][2] * d5);
      this.c.x[1][1] = (this.c.x[1][1] + (this.c.x[1][3] + this.c.x[3][1]) * d4 + this.c.x[3][3] * d5);
      this.c.x[0][2] += this.c.x[2][2] * d4;
      this.c.x[2][0] += this.c.x[2][2] * d4;
      this.c.x[1][3] += this.c.x[3][3] * d4;
      this.c.x[3][1] += this.c.x[3][3] * d4;
    }
  }
  
  final void a(int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramArrayOfDouble2[0] = ((paramArrayOfDouble1[1] - this.a.s[1]) * 6378137.0D * Math.cos(this.a.s[0]));
      paramArrayOfDouble2[1] = ((paramArrayOfDouble1[0] - this.a.s[0]) * 6378137.0D);
      return;
    }
    paramArrayOfDouble2[0] = (paramArrayOfDouble1[1] / 6378137.0D + this.a.s[0]);
    paramArrayOfDouble2[1] = (paramArrayOfDouble1[0] / (Math.cos(this.a.s[0]) * 6378137.0D) + this.a.s[1]);
  }
  
  protected final void a(long paramLong, double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d1 = paramLong;
    double d2 = paramFloat * paramFloat;
    double[] arrayOfDouble1 = new double[2];
    double[] tmp19_17 = arrayOfDouble1;
    tmp19_17[0] = 0.0D;
    double[] tmp23_19 = tmp19_17;
    tmp23_19[1] = 0.0D;
    tmp23_19;
    if (paramBoolean1) {}
    for (int i = 3;; i = 5)
    {
      double[] arrayOfDouble2 = new double[2];
      arrayOfDouble2[0] = paramDouble1;
      arrayOfDouble2[1] = paramDouble2;
      this.a.B = true;
      this.a.I[0] = 3.0D;
      this.a.I[1] = 1.2D;
      this.a.G = 0.5D;
      this.a.a = 1.2D;
      this.a.g = 4.0D;
      this.a.h = 0;
      this.a.j = true;
      this.a.i = i;
      this.a.b = false;
      this.a.e = false;
      this.a.p = 40.0D;
      this.a.q = 0.15707963267948966D;
      this.a.r = 1.0D;
      this.a.H[0] = 400.0D;
      this.a.H[1] = 1.0D;
      this.a.t = paramBoolean2;
      this.a.u = false;
      this.a.k = true;
      this.a.l = 0.3333333333333333D;
      this.a.m = 5.0D;
      this.a.n = 0.5D;
      this.a.o = 1.0D;
      this.a.C = 0.5D;
      this.a.D = 1.0D;
      this.a.E = 0;
      this.a.F = 2;
      this.a.J = false;
      this.a.s[0] = arrayOfDouble2[0];
      this.a.s[1] = arrayOfDouble2[1];
      arrayOfDouble2 = new double[2];
      a(0, new double[] { paramDouble1, paramDouble2 }, arrayOfDouble2);
      this.a.v = d1;
      this.a.w[0] = arrayOfDouble2[0];
      this.a.w[1] = arrayOfDouble2[1];
      this.a.w[2] = arrayOfDouble1[0];
      this.a.w[3] = arrayOfDouble1[1];
      this.a.y = 0.0D;
      this.a.z = 1.0D;
      this.a.A = 1.005D;
      this.a.x[0][0] = tmp19_17;
      this.a.x[0][1] = 0L;
      this.a.x[0][2] = 0L;
      this.a.x[0][3] = 0L;
      this.a.x[1][0] = 0L;
      this.a.x[1][1] = tmp19_17;
      this.a.x[1][2] = 0L;
      this.a.x[1][3] = 0L;
      this.a.x[2][0] = 0L;
      this.a.x[2][1] = 0L;
      this.a.x[2][2] = 4607182418800017408L;
      this.a.x[2][3] = 0L;
      this.a.x[3][0] = 0L;
      this.a.x[3][1] = 0L;
      this.a.x[3][2] = 0L;
      this.a.x[3][3] = 4607182418800017408L;
      a(paramBoolean1);
      return;
    }
  }
  
  protected final void a(a parama)
  {
    if (parama.f <= 0.0D) {}
    Object localObject2;
    Object localObject1;
    double d2;
    Object localObject3;
    label1101:
    label1155:
    label1163:
    label1171:
    int j;
    label1221:
    label1252:
    label1693:
    label1821:
    label1891:
    label2056:
    label2058:
    label2070:
    label2141:
    label2348:
    label2484:
    label2890:
    label3126:
    label3148:
    label3176:
    label3920:
    label4097:
    label4196:
    label4268:
    label4270:
    label4338:
    do
    {
      double d1;
      double[] arrayOfDouble1;
      for (;;)
      {
        return;
        if (this.a.b)
        {
          d1 = parama.b - this.a.d;
          if (d1 < -10.0D) {
            continue;
          }
          if (d1 <= 0.0D) {
            parama.b = (this.a.d + 0.5D);
          }
        }
        arrayOfDouble1 = new double[2];
        a(0, new double[] { parama.c, parama.d }, arrayOfDouble1);
        parama.e[0] = arrayOfDouble1[0];
        parama.e[1] = arrayOfDouble1[1];
        if (this.a.B)
        {
          double d5;
          if ((parama.a != 3) || (this.a.b))
          {
            if (parama.a != 3) {
              break label1171;
            }
            d5 = parama.b - this.a.d;
            if (d5 > 0.0D)
            {
              localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
              localObject1 = new double[2];
              d4 = arrayOfDouble1[0] - this.a.c[0];
              d3 = arrayOfDouble1[1] - this.a.c[1];
              d1 = d3;
              d2 = d4;
              if (this.a.t)
              {
                d2 = d4 * Math.cos(this.a.y) - Math.sin(this.a.y) * d3;
                d1 = Math.sin(this.a.y);
                d1 = d3 * Math.cos(this.a.y) + d1 * d2;
              }
              d4 = Math.sqrt(d2 * d2 + d1 * d1);
              d3 = d4 / this.a.p;
              d3 *= d3;
              if (d3 <= 0.0625D) {
                break label1155;
              }
              d4 *= this.a.q;
              d4 *= d4;
              if (d4 <= 0.0625D) {
                break label1163;
              }
            }
          }
          for (;;)
          {
            d3 = (d3 + d4) / d5;
            d4 = this.a.x[2][2];
            double d6 = this.a.x[2][3];
            double d7 = this.a.x[3][2];
            double d8 = this.a.x[3][3];
            localObject3 = this.b;
            a(new double[] { d4, d6, d7, d8 }, (double[])localObject3);
            localObject2[0][0] = this.b[0];
            localObject2[0][1] = this.b[1];
            localObject2[1][0] = this.b[2];
            localObject2[1][1] = this.b[3];
            d4 = d2 / d5 - this.a.w[2];
            d6 = d1 / d5 - this.a.w[3];
            d7 = localObject2[0][0];
            d8 = localObject2[0][1];
            if (Math.sqrt(d4 * d6 * localObject2[1][0] + (d4 * d4 * d7 + d4 * d6 * d8) + d6 * d6 * localObject2[1][1]) > 2.0D)
            {
              this.a.x[2][2] = this.a.r;
              this.a.x[2][3] = 0L;
              this.a.x[3][2] = 0L;
              this.a.x[3][3] = this.a.r;
              localObject2[0][0] = (1.0D / this.a.r);
              localObject2[0][1] = 0L;
              localObject2[1][0] = 0L;
              localObject2[1][1] = (1.0D / this.a.r);
            }
            localObject1[0] = (localObject2[0][0] * this.a.w[2] + localObject2[0][1] * this.a.w[3]);
            localObject1[1] = (localObject2[1][0] * this.a.w[2] + localObject2[1][1] * this.a.w[3]);
            localObject3 = localObject2[0];
            localObject3[0] += 1.0D / d3;
            localObject3 = localObject2[1];
            localObject3[1] += 1.0D / d3;
            d4 = localObject1[0];
            localObject1[0] = (d2 / (d5 * d3) + d4);
            d2 = localObject1[1];
            localObject1[1] = (d1 / (d5 * d3) + d2);
            d1 = localObject2[0][0];
            d2 = localObject2[0][1];
            d3 = localObject2[1][0];
            d4 = localObject2[1][1];
            localObject2 = this.b;
            a(new double[] { d1, d2, d3, d4 }, (double[])localObject2);
            this.a.x[2][2] = this.b[0];
            this.a.x[2][3] = this.b[1];
            this.a.x[3][2] = this.b[2];
            this.a.x[3][3] = this.b[3];
            this.a.w[2] = (this.a.x[2][2] * localObject1[0] + this.a.x[2][3] * localObject1[1]);
            this.a.w[3] = (this.a.x[3][2] * localObject1[0] + this.a.x[3][3] * localObject1[1]);
            a(parama.b, false);
            if (parama.a != 3) {
              break label2484;
            }
            this.a.c[0] = arrayOfDouble1[0];
            this.a.c[1] = arrayOfDouble1[1];
            this.a.d = parama.b;
            this.a.b = true;
            return;
            d3 = 0.0625D;
            break;
            d4 = 0.0625D;
          }
          localObject2 = new double[2];
          localObject1 = new double[2];
          a(parama.b, false);
          if (this.a.k)
          {
            if (!this.a.e)
            {
              i = 1;
              j = 1;
              d2 = 0.0D;
              d1 = 0.0D;
              if (i == 0) {
                break label2056;
              }
              if (this.a.e)
              {
                if (d2 >= d1) {
                  break label2058;
                }
                d3 = this.a.n;
                d1 = d3 + d1 / d2 * (1.0D - d3);
                arrayOfDouble1[0] = (this.a.f[0] + localObject1[0] * d1);
                d2 = this.a.f[1];
                arrayOfDouble1[1] = (d1 * localObject1[1] + d2);
              }
              if (j == 0) {
                break label2070;
              }
              a(arrayOfDouble1);
            }
            for (;;)
            {
              this.a.w[0] = arrayOfDouble1[0];
              this.a.w[1] = arrayOfDouble1[1];
              this.a.x[0][0] = (parama.f * parama.f);
              this.a.x[0][1] = 0L;
              this.a.x[1][0] = 0L;
              this.a.x[1][1] = (parama.f * parama.f);
              break;
              localObject2[0] = (this.a.w[0] - this.a.f[0]);
              localObject2[1] = (this.a.w[1] - this.a.f[1]);
              arrayOfDouble1[0] -= this.a.f[0];
              arrayOfDouble1[1] -= this.a.f[1];
              d2 = Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
              d1 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
              if ((d1 > this.a.m) && (d2 > this.a.m))
              {
                d3 = d1 / d2;
                d4 = d1 - d2;
                d5 = Math.sqrt(this.a.x[0][0] + this.a.x[1][1]);
                if (d2 > 3.0D * this.a.m)
                {
                  d3 = d4;
                  if (d4 < 0.0D) {
                    d3 = -d4;
                  }
                  d5 = d3 / d5;
                  d3 = Math.atan2(localObject2[1], localObject2[0]);
                  d4 = Math.atan2(localObject1[1], localObject1[0]) - d3;
                  if (d4 > 3.141592653589793D)
                  {
                    d3 = d4 - 6.283185307179586D;
                    d4 = d3;
                    if (d3 < 0.0D) {
                      d4 = -d3;
                    }
                    d3 = d4 / Math.sqrt(this.a.z);
                    d4 = Math.sqrt(d3 * d3 + d5 * d5);
                    if (d4 >= this.a.g) {
                      break label1821;
                    }
                    this.a.E = 0;
                    d3 = d4;
                  }
                  for (;;)
                  {
                    if (d3 <= this.a.g) {
                      break label1891;
                    }
                    j = 0;
                    i = 0;
                    d3 = d1;
                    d1 = d2;
                    d2 = d3;
                    break;
                    d3 = d4;
                    if (d4 >= -3.141592653589793D) {
                      break label1693;
                    }
                    d3 = d4 + 6.283185307179586D;
                    break label1693;
                    d3 = d4;
                    if (d5 < this.a.g)
                    {
                      localObject2 = this.a;
                      i = ((b)localObject2).E + 1;
                      ((b)localObject2).E = i;
                      d3 = d4;
                      if (i >= this.a.F)
                      {
                        this.a.E = 0;
                        d3 = d5;
                      }
                    }
                  }
                  j = 1;
                  i = 1;
                  d3 = d1;
                  d1 = d2;
                  d2 = d3;
                  break label1221;
                }
                if ((d3 < this.a.l) || (1.0D / d3 < this.a.l))
                {
                  j = 0;
                  i = 0;
                  d3 = d1;
                  d1 = d2;
                  d2 = d3;
                  break label1221;
                }
                j = 0;
                i = 1;
                d3 = d1;
                d1 = d2;
                d2 = d3;
                break label1221;
              }
              if (((d1 < this.a.m) && (parama.a == 2)) || ((d1 < this.a.m * 0.5D) && (parama.a == 1)))
              {
                j = 0;
                i = 0;
                d3 = d1;
                d1 = d2;
                d2 = d3;
                break label1221;
              }
              j = 0;
              i = 1;
              d3 = d1;
              d1 = d2;
              d2 = d3;
              break label1221;
              break;
              d3 = this.a.o;
              break label1252;
              this.a.f[0] = arrayOfDouble1[0];
              this.a.f[1] = arrayOfDouble1[1];
            }
          }
          b.a(this.c, this.a);
          b(parama.b, false);
          if (this.c.j) {
            if (!this.a.e)
            {
              d1 = 0.0D;
              if (d1 <= this.a.g) {
                break label3176;
              }
              b.a(this.c, this.a);
              b(parama.b, true);
              if (!this.a.j) {
                break label2890;
              }
              d3 = this.a.f[0] - this.c.w[0];
              d4 = this.a.f[1] - this.c.w[1];
              d1 = this.a.f[0] - arrayOfDouble1[0];
              d2 = this.a.f[1] - arrayOfDouble1[1];
              d3 = Math.sqrt(d3 * d3 + d4 * d4);
              d1 = Math.sqrt(d1 * d1 + d2 * d2);
              d2 = Math.sqrt(this.c.x[0][0] * this.c.x[0][0] + this.c.x[1][1] * this.c.x[1][1]);
              d1 = Math.abs(d3 - d1) / d2;
              if (d1 <= this.c.g) {
                break label3148;
              }
              if (this.a.h >= this.a.i) {
                break label3126;
              }
              this.a.h += 1;
            }
          }
          for (;;)
          {
            this.a.w[0] = arrayOfDouble1[0];
            this.a.w[1] = arrayOfDouble1[1];
            this.a.x[0][0] = (parama.f * parama.f);
            this.a.x[0][1] = 0L;
            this.a.x[1][0] = 0L;
            this.a.x[1][1] = (parama.f * parama.f);
            break label1101;
            break;
            d3 = this.a.f[0] - this.c.w[0];
            d4 = this.a.f[1] - this.c.w[1];
            d1 = this.a.f[0] - arrayOfDouble1[0];
            d2 = this.a.f[1] - arrayOfDouble1[1];
            d3 = Math.sqrt(d3 * d3 + d4 * d4);
            d1 = Math.sqrt(d1 * d1 + d2 * d2);
            d2 = Math.sqrt(this.a.x[0][0] * this.a.x[0][0] + this.a.x[1][1] * this.a.x[1][1]);
            d1 = Math.abs(d3 - d1) / d2;
            break label2141;
            d1 = arrayOfDouble1[0] - this.c.w[0];
            d2 = arrayOfDouble1[1] - this.c.w[1];
            localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
            d3 = 1.0D / (this.c.x[0][0] * this.c.x[1][1] - this.c.x[0][1] * this.c.x[1][0]);
            localObject1[0][0] = (this.c.x[1][1] * d3);
            localObject1[1][1] = (this.c.x[0][0] * d3);
            localObject1[0][1] = (-this.c.x[0][1] * d3);
            localObject1[1][0] = (d3 * -this.c.x[1][0]);
            d3 = localObject1[0][0];
            d1 = Math.sqrt(d1 * 2.0D * d2 * localObject1[1][0] + d1 * d1 * d3 + d2 * d2 * localObject1[1][1]);
            break label2141;
            d1 = arrayOfDouble1[0] - this.c.w[0];
            d2 = arrayOfDouble1[1] - this.c.w[1];
            localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
            d3 = 1.0D / (this.c.x[0][0] * this.c.x[1][1] - this.c.x[0][1] * this.c.x[1][0]);
            localObject1[0][0] = (this.c.x[1][1] * d3);
            localObject1[1][1] = (this.c.x[0][0] * d3);
            localObject1[0][1] = (-this.c.x[0][1] * d3);
            localObject1[1][0] = (d3 * -this.c.x[1][0]);
            d3 = localObject1[0][0];
            d1 = Math.sqrt(d1 * 2.0D * d2 * localObject1[1][0] + d1 * d1 * d3 + d2 * d2 * localObject1[1][1]);
            break label2348;
            b.a(this.a, this.c);
            this.a.h = 0;
            continue;
            b.a(this.a, this.c);
            this.a.h = 0;
            a(arrayOfDouble1);
            continue;
            b.a(this.a, this.c);
            this.a.h = 0;
            a(arrayOfDouble1);
          }
        }
        if (parama.a != 3)
        {
          localObject2 = new double[2];
          localObject1 = new double[2];
          arrayOfDouble1 = new double[2];
          a(parama.b, false);
          if (!this.a.e)
          {
            j = 1;
            i = 0;
            this.a.h = 0;
          }
          while (j != 0)
          {
            if (i != 0) {
              break label3920;
            }
            this.a.w[0] = parama.e[0];
            this.a.w[1] = parama.e[1];
            this.a.w[2] = 0.0D;
            this.a.w[3] = 0.0D;
            this.a.x[0][0] = (parama.f * parama.f);
            this.a.x[0][1] = 0L;
            this.a.x[0][2] = 0L;
            this.a.x[0][3] = 0L;
            this.a.x[1][0] = 0L;
            this.a.x[1][1] = this.a.x[0][0];
            this.a.x[1][2] = 0L;
            this.a.x[1][2] = 0L;
            this.a.x[2][0] = 0L;
            this.a.x[2][1] = 0L;
            this.a.x[2][2] = this.a.r;
            this.a.x[2][3] = 0L;
            this.a.x[3][0] = 0L;
            this.a.x[3][1] = 0L;
            this.a.x[3][2] = 0L;
            this.a.x[3][3] = this.a.r;
            this.a.f[0] = parama.e[0];
            this.a.f[1] = parama.e[1];
            this.a.e = true;
            return;
            localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
            localObject2[0] = (parama.e[0] - this.a.w[0]);
            localObject2[1] = (parama.e[1] - this.a.w[1]);
            d1 = this.a.x[0][0];
            d2 = this.a.x[0][1];
            d3 = this.a.x[1][0];
            d4 = this.a.x[1][1];
            double[] arrayOfDouble2 = this.b;
            a(new double[] { d1, d2, d3, d4 }, arrayOfDouble2);
            localObject3[0][0] = this.b[0];
            localObject3[0][1] = this.b[1];
            localObject3[1][0] = this.b[2];
            localObject3[1][1] = this.b[3];
            if (Math.sqrt(localObject2[0] * localObject2[0] * localObject3[0][0] + 2.0D * localObject2[0] * localObject2[1] * localObject3[1][0] + localObject2[1] * localObject2[1] * localObject3[1][1]) > this.a.g)
            {
              localObject2 = this.a;
              i = ((b)localObject2).h + 1;
              ((b)localObject2).h = i;
              if (i >= this.a.i)
              {
                j = 1;
                i = 0;
                this.a.h = 0;
              }
              else
              {
                j = 0;
                i = 0;
              }
            }
            else
            {
              this.a.h = 0;
              j = 1;
              i = 1;
            }
          }
        }
      }
      localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
      localObject2 = new double[2];
      localObject1[0] = (this.a.w[0] - this.a.f[0]);
      localObject1[1] = (this.a.w[1] - this.a.f[1]);
      arrayOfDouble1[0] = (parama.e[0] - this.a.f[0]);
      arrayOfDouble1[1] = (parama.e[1] - this.a.f[1]);
      double d3 = Math.sqrt(arrayOfDouble1[0] * arrayOfDouble1[0] + arrayOfDouble1[1] * arrayOfDouble1[1]);
      double d4 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
      if (d3 < d4)
      {
        d1 = this.a.C;
        if (!a(this.a.x, (double[][])localObject3)) {
          break label4268;
        }
        d2 = 1.0D / (parama.f * parama.f);
        localObject1 = new double[4];
        if (!this.a.J) {
          break label4270;
        }
        d1 += d4 / d3 * (1.0D - d1);
        localObject2[0] = (this.a.f[0] + arrayOfDouble1[0] * d1);
        d3 = this.a.f[1];
        localObject2[1] = (d1 * arrayOfDouble1[1] + d3);
        i = 0;
      }
      for (;;)
      {
        if (i >= 4) {
          break label4338;
        }
        localObject1[i] = 0.0D;
        j = 0;
        for (;;)
        {
          if (j < 4)
          {
            localObject1[i] += localObject3[i][j] * this.a.w[j];
            j += 1;
            continue;
            d1 = this.a.D;
            break label4097;
            break;
            localObject2[0] = (this.a.w[0] * (1.0D - d1) + parama.e[0] * d1);
            d3 = this.a.w[1];
            localObject2[1] = (d1 * parama.e[1] + d3 * (1.0D - d1));
            break label4196;
          }
        }
        i += 1;
      }
      parama = localObject3[0];
      parama[0] += d2;
      parama = localObject3[1];
      parama[1] += d2;
    } while (!a((double[][])localObject3, this.a.x));
    localObject1[0] += localObject2[0] * d2;
    localObject1[1] += localObject2[1] * d2;
    int i = 0;
    while (i < 4)
    {
      this.a.w[i] = 0.0D;
      j = 0;
      while (j < 4)
      {
        parama = this.a.w;
        parama[i] += this.a.x[i][j] * localObject1[j];
        j += 1;
      }
      i += 1;
    }
    this.a.f[0] = localObject2[0];
    this.a.f[1] = localObject2[1];
  }
  
  protected final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (this.a.B != paramBoolean)
      {
        this.a.B = paramBoolean;
        if (!paramBoolean) {
          break;
        }
        this.a.a = this.a.I[1];
        this.a.r = this.a.H[1];
        a(this.a.v, true);
      }
      return;
    }
    this.a.a = this.a.I[0];
    this.a.r = this.a.H[0];
    a(this.a.v, true);
  }
  
  public static final class a
  {
    int a;
    double b;
    double c;
    double d;
    double[] e = new double[2];
    double f;
    private double g;
    private int h;
    private double i;
    private int j;
    private double k;
    private double l;
    
    protected a(int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt2, double paramDouble6, int paramInt3, double paramDouble7, double paramDouble8)
    {
      this.a = paramInt1;
      this.b = paramDouble1;
      this.c = paramDouble2;
      this.d = paramDouble3;
      this.g = paramDouble4;
      this.f = paramDouble5;
      this.h = paramInt2;
      this.i = paramDouble6;
      this.j = paramInt3;
      this.k = paramDouble7;
      this.l = paramDouble8;
    }
    
    public final String toString()
    {
      return String.valueOf(this.a) + ',' + this.b + ',' + this.c + ',' + this.d + ',' + this.g + ',' + this.f + ',' + this.h + ',' + this.i + ',' + 0.0D + ',' + this.j + ',' + this.k + ',' + this.l;
    }
  }
  
  static final class b
  {
    double A;
    boolean B;
    double C;
    double D;
    int E;
    int F;
    double G;
    double[] H = new double[2];
    double[] I = new double[2];
    boolean J;
    private boolean K;
    double a;
    boolean b;
    double[] c = new double[2];
    double d;
    boolean e;
    double[] f = new double[2];
    double g;
    int h;
    int i;
    boolean j;
    boolean k;
    double l;
    double m;
    double n;
    double o;
    double p;
    double q;
    double r;
    double[] s = new double[2];
    boolean t;
    boolean u;
    double v;
    double[] w = new double[4];
    double[][] x = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
    double y;
    double z;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */