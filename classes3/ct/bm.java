package ct;

import android.text.TextUtils;

public final class bm
{
  public int a;
  String b;
  String c;
  public String d;
  String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public int j;
  public int k;
  public long l;
  public String m;
  String n = "4.7.7.9.3";
  String o = "150707";
  public String p = "4.7.7.9.3";
  public boolean q = true;
  public boolean r = false;
  public boolean s = true;
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "0123456789ABCDEF";
    }
    return this.b;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0123456789ABCDEF";
    }
    return this.c;
  }
  
  public final String c()
  {
    if ((TextUtils.isEmpty(this.e)) || (this.e.contains("0000"))) {
      return "0123456789ABCDEF";
    }
    return this.e;
  }
  
  public final String d()
  {
    if (this.n == null) {
      return "None";
    }
    return this.n;
  }
  
  public final String e()
  {
    if (this.o == null) {
      return "None";
    }
    return this.o;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */