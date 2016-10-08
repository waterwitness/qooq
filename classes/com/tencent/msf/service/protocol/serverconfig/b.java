package com.tencent.msf.service.protocol.serverconfig;

import java.io.Serializable;

public final class b
  implements Serializable
{
  public static final int a = 1;
  public static final b b;
  public static final int c = 2;
  public static final b d;
  private static b[] f;
  private int g;
  private String h = new String();
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      f = new b[2];
      b = new b(0, 1, "CliLogCfgByTime");
      d = new b(1, 2, "CliLogCfgSetLevel");
      return;
    }
  }
  
  private b(int paramInt1, int paramInt2, String paramString)
  {
    this.h = paramString;
    this.g = paramInt2;
    f[paramInt1] = this;
  }
  
  public static b a(int paramInt)
  {
    int i = 0;
    while (i < f.length)
    {
      if (f[i].a() == paramInt) {
        return f[i];
      }
      i += 1;
    }
    if (!e) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static b a(String paramString)
  {
    int i = 0;
    while (i < f.length)
    {
      if (f[i].toString().equals(paramString)) {
        return f[i];
      }
      i += 1;
    }
    if (!e) {
      throw new AssertionError();
    }
    return null;
  }
  
  public int a()
  {
    return this.g;
  }
  
  public String toString()
  {
    return this.h;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\msf\service\protocol\serverconfig\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */