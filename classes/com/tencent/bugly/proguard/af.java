package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class af
  extends j
  implements Cloneable
{
  private static ArrayList<String> c;
  private String a = "";
  private ArrayList<String> b = null;
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    if (c == null)
    {
      c = new ArrayList();
      c.add("");
    }
    this.b = ((ArrayList)paramh.a(c, 1, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    if (this.b != null) {
      parami.a(this.b, 1);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */