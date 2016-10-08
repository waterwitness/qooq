package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class ai
  extends j
  implements Cloneable
{
  private static ArrayList<ah> b;
  public ArrayList<ah> a = null;
  
  public final void a(h paramh)
  {
    if (b == null)
    {
      b = new ArrayList();
      ah localah = new ah();
      b.add(localah);
    }
    this.a = ((ArrayList)paramh.a(b, 0, true));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */