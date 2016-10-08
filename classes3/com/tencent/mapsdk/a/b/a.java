package com.tencent.mapsdk.a.b;

public final class a
{
  public static int a = 3;
  private static double b = Math.log(2.0D);
  private int c;
  private double d;
  private double e;
  
  public a(double paramDouble)
  {
    this.e = paramDouble;
    this.c = ((int)paramDouble);
    f();
  }
  
  public a(int paramInt, double paramDouble)
  {
    this.c = paramInt;
    this.d = paramDouble;
    e();
  }
  
  public static double c(double paramDouble)
  {
    return 156543.0339D / Math.pow(2.0D, paramDouble);
  }
  
  private void e()
  {
    this.e = (Math.log(this.d) / b + this.c);
  }
  
  private void f()
  {
    this.c = ((int)this.e);
    this.d = Math.pow(2.0D, this.e - this.c);
  }
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(double paramDouble)
  {
    this.d = paramDouble;
    e();
  }
  
  public final double b()
  {
    return this.d;
  }
  
  public final void b(double paramDouble)
  {
    this.e = paramDouble;
    f();
  }
  
  public final double c()
  {
    return this.e;
  }
  
  public final double d()
  {
    return c(this.e);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */