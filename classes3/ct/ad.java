package ct;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ad
  implements z
{
  public boolean a = false;
  public boolean b = true;
  public String c = null;
  public int[] d = null;
  public String e = "";
  public String f = null;
  public boolean g = true;
  public boolean h = true;
  public Map i = new HashMap();
  public byte[] j = null;
  public long k = 0L;
  public int l = 32768;
  public int m = 10000;
  public int n = 3;
  public boolean o = true;
  public volatile boolean p = false;
  public String q = "";
  private List r = new ArrayList();
  
  public ad(String paramString, int[] paramArrayOfInt)
  {
    this.c = paramString;
    this.d = paramArrayOfInt;
    if ((this.d != null) && (this.d[0] != -1)) {}
    for (this.e = (this.c + ":" + this.d[0]);; this.e = this.c)
    {
      this.q = be.b(this.c);
      return;
    }
  }
  
  public final void a()
  {
    this.l = 32768;
  }
  
  public final void a(af paramaf)
  {
    this.r.add(paramaf);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    this.i.put(paramString1, paramString2);
  }
  
  public final String b()
  {
    return this.q;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */