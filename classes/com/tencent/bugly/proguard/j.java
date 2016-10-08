package com.tencent.bugly.proguard;

import java.io.Serializable;

public abstract class j
  implements Serializable
{
  public abstract void a(h paramh);
  
  public abstract void a(i parami);
  
  public abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  public final byte[] a()
  {
    i locali = new i();
    a(locali);
    return locali.b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */