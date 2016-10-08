package com.tencent.beacon.a.a;

import java.io.Serializable;

public final class b
  implements Serializable
{
  public long a;
  public String b;
  public int c;
  public boolean d;
  public boolean e;
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while ((getClass() != paramObject.getClass()) || (!(paramObject instanceof b)));
      paramObject = (b)paramObject;
    } while ((((b)paramObject).b == null) || (!((b)paramObject).b.equals(this.b)));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */