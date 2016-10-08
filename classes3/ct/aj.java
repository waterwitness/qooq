package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class aj
  extends bi
{
  private static ArrayList k;
  private static Map l;
  private String a = "";
  private String b = "";
  private ArrayList c = null;
  private String d = "";
  private String e = "";
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private String i = "";
  private Map j = null;
  
  public aj() {}
  
  public aj(String paramString1, String paramString2, ArrayList paramArrayList, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, Map paramMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramString5;
    this.j = paramMap;
  }
  
  public final void a(bg parambg)
  {
    this.a = parambg.a(0, true);
    this.b = parambg.a(1, true);
    if (k == null)
    {
      k = new ArrayList();
      k.add("");
    }
    this.c = ((ArrayList)parambg.a(k, 2, true));
    this.d = parambg.a(3, false);
    this.e = parambg.a(4, false);
    this.f = parambg.a(this.f, 5, false);
    this.g = parambg.a(this.g, 6, false);
    this.h = parambg.a(this.h, 7, false);
    this.i = parambg.a(8, false);
    if (l == null)
    {
      l = new HashMap();
      l.put("", "");
    }
    this.j = ((Map)parambg.a(l, 9, false));
  }
  
  public final void a(bh parambh)
  {
    parambh.a(this.a, 0);
    parambh.a(this.b, 1);
    parambh.a(this.c, 2);
    if (this.d != null) {
      parambh.a(this.d, 3);
    }
    if (this.e != null) {
      parambh.a(this.e, 4);
    }
    parambh.a(this.f, 5);
    parambh.a(this.g, 6);
    parambh.a(this.h, 7);
    if (this.i != null) {
      parambh.a(this.i, 8);
    }
    if (this.j != null) {
      parambh.a(this.j, 9);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */