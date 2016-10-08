package com.tencent.beacon.b.a;

import com.tencent.beacon.e.b;
import com.tencent.beacon.e.c;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends c
  implements Cloneable
{
  private static Map<Integer, byte[]> b;
  public Map<Integer, byte[]> a = null;
  
  public final void a(com.tencent.beacon.e.a parama)
  {
    if (b == null)
    {
      b = new HashMap();
      b.put(Integer.valueOf(0), new byte[] { 0 });
    }
    this.a = ((Map)parama.a(b, 0, true));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */