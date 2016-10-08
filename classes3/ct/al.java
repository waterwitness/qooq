package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class al
  extends bi
{
  private static ArrayList e;
  private static Map f;
  public ArrayList a = null;
  public String b = "";
  private int c = 0;
  private Map d = null;
  
  public final void a(bg parambg)
  {
    this.c = parambg.a(this.c, 0, true);
    if (e == null)
    {
      e = new ArrayList();
      e.add("");
    }
    this.a = ((ArrayList)parambg.a(e, 1, true));
    this.b = parambg.a(2, false);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)parambg.a(f, 3, false));
  }
  
  public final void a(bh parambh)
  {
    parambh.a(this.c, 0);
    parambh.a(this.a, 1);
    if (this.b != null) {
      parambh.a(this.b, 2);
    }
    if (this.d != null) {
      parambh.a(this.d, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */