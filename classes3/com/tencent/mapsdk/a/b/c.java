package com.tencent.mapsdk.a.b;

public final class c
{
  public double a = Double.MIN_VALUE;
  public double b = Double.MIN_VALUE;
  
  public c(double paramDouble1, double paramDouble2)
  {
    this.b = paramDouble2;
    this.a = paramDouble1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject.hashCode() != hashCode()) {
        return false;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
    } while ((Double.doubleToLongBits(((c)paramObject).b) == Double.doubleToLongBits(this.b)) && (Double.doubleToLongBits(((c)paramObject).a) == Double.doubleToLongBits(this.a)));
    return false;
  }
  
  public final int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.b);
    long l2 = Double.doubleToLongBits(this.a);
    int i = (int)(l2 ^ l2 >>> 32);
    return (int)(l1 ^ l1 >>> 32) + (i + 31) * 31;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */