package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class am
  extends bi
{
  private static Map c;
  public Map a = null;
  public long b = 0L;
  
  public final void a(bg parambg)
  {
    if (c == null)
    {
      c = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("");
      c.put(Integer.valueOf(0), localArrayList);
    }
    this.a = ((Map)parambg.a(c, 0, false));
    this.b = parambg.a(this.b, 1, false);
  }
  
  public final void a(bh parambh)
  {
    if (this.a != null) {
      parambh.a(this.a, 0);
    }
    parambh.a(this.b, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */