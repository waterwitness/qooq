package ct;

import java.util.HashMap;
import java.util.Map;

public final class bk
  extends bi
{
  private static byte[] k = null;
  private static Map l = null;
  public short a = 3;
  public int b = 0;
  public String c = null;
  public String d = null;
  public byte[] e;
  private byte f = 0;
  private int g = 0;
  private int h = 0;
  private Map i;
  private Map j;
  
  public final void a(bg parambg)
  {
    try
    {
      this.a = parambg.a(this.a, 1, true);
      this.f = parambg.a(this.f, 2, true);
      this.g = parambg.a(this.g, 3, true);
      this.b = parambg.a(this.b, 4, true);
      this.c = parambg.a(5, true);
      this.d = parambg.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.e = ((byte[])parambg.b(7, true));
      this.h = parambg.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)parambg.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)parambg.a(l, 10, true));
      return;
    }
    catch (Exception parambg)
    {
      parambg.printStackTrace();
      throw new RuntimeException(parambg);
    }
  }
  
  public final void a(bh parambh)
  {
    parambh.a(this.a, 1);
    parambh.a(this.f, 2);
    parambh.a(this.g, 3);
    parambh.a(this.b, 4);
    parambh.a(this.c, 5);
    parambh.a(this.d, 6);
    parambh.a(this.e, 7);
    parambh.a(this.h, 8);
    parambh.a(this.i, 9);
    parambh.a(this.j, 10);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */