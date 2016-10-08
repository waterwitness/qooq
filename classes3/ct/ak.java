package ct;

import java.util.HashMap;
import java.util.Map;

public final class ak
  extends bi
{
  private static Map h;
  private static am i;
  private static ai j;
  private static Map k;
  private static Map l;
  public Map a = null;
  public am b = null;
  public ai c = null;
  private String d = "";
  private int e = 0;
  private Map f = null;
  private Map g = null;
  
  public final void a(bg parambg)
  {
    this.d = parambg.a(0, true);
    this.e = parambg.a(this.e, 1, true);
    Object localObject;
    if (h == null)
    {
      h = new HashMap();
      localObject = new al();
      h.put("", localObject);
    }
    this.a = ((Map)parambg.a(h, 2, true));
    if (i == null) {
      i = new am();
    }
    this.b = ((am)parambg.a(i, 3, false));
    if (j == null) {
      j = new ai();
    }
    this.c = ((ai)parambg.a(j, 4, false));
    if (k == null)
    {
      k = new HashMap();
      k.put("", "");
    }
    this.f = ((Map)parambg.a(k, 5, false));
    if (l == null)
    {
      l = new HashMap();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      l.put("", localObject);
    }
    this.g = ((Map)parambg.a(l, 6, false));
  }
  
  public final void a(bh parambh)
  {
    parambh.a(this.d, 0);
    parambh.a(this.e, 1);
    parambh.a(this.a, 2);
    if (this.b != null) {
      parambh.a(this.b, 3);
    }
    if (this.c != null) {
      parambh.a(this.c, 4);
    }
    if (this.f != null) {
      parambh.a(this.f, 5);
    }
    if (this.g != null) {
      parambh.a(this.g, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */