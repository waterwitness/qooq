package com.tencent.bugly.proguard;

public final class al
  extends j
  implements Cloneable
{
  public String a = "";
  private String b = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, true);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */