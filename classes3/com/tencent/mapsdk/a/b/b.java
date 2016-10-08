package com.tencent.mapsdk.a.b;

import com.tencent.mapsdk.a.d;
import java.util.Arrays;

public final class b
{
  public c a;
  public c b;
  
  public b(c paramc1, c paramc2)
  {
    paramc1 = new a().a(paramc1).a(paramc2);
    this.a = new c(a.a(paramc1), a.b(paramc1));
    this.b = new c(a.c(paramc1), a.d(paramc1));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
    } while ((this.a.equals(((b)paramObject).a)) && (this.b.equals(((b)paramObject).b)));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.a, this.b });
  }
  
  public final String toString()
  {
    return d.a(new String[] { d.a("southwest", this.a), d.a("northeast", this.b) });
  }
  
  public static final class a
  {
    private double a = Double.MAX_VALUE;
    private double b = -1.7976931348623157E308D;
    private double c = Double.MAX_VALUE;
    private double d = -1.7976931348623157E308D;
    
    public final a a(c paramc)
    {
      this.a = Math.min(this.a, paramc.a);
      this.b = Math.max(this.b, paramc.a);
      this.d = Math.max(this.d, paramc.b);
      this.c = Math.min(this.c, paramc.b);
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */