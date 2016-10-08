package ct;

import java.util.HashMap;
import java.util.Map;

public final class an
  extends bi
{
  private static Map c;
  public Map a = null;
  public int b = 0;
  
  public final void a(bg parambg)
  {
    if (c == null)
    {
      c = new HashMap();
      c.put(Integer.valueOf(0), Byte.valueOf((byte)0));
    }
    this.a = ((Map)parambg.a(c, 0, true));
    this.b = parambg.a(this.b, 1, true);
  }
  
  public final void a(bh parambh)
  {
    parambh.a(this.a, 0);
    parambh.a(this.b, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */