package com.tencent.upload.network.b;

import java.io.Serializable;

public final class m
  implements Serializable
{
  private String a;
  private int b;
  private String c;
  private int d;
  private int e;
  private int f;
  
  public m(String paramString, int paramInt1, int paramInt2)
  {
    this(paramString, paramInt1, null, 0, 1, paramInt2);
  }
  
  public m(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramString2;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  public final int a()
  {
    return this.f;
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.c = paramString;
    this.d = paramInt;
  }
  
  public final boolean a(m paramm)
  {
    if (paramm == null) {}
    while ((!this.a.equals(paramm.a)) || (this.b != paramm.b)) {
      return false;
    }
    return true;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public final void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final String d()
  {
    return this.c;
  }
  
  public final int e()
  {
    return this.d;
  }
  
  public final int f()
  {
    return this.e;
  }
  
  public final void g()
  {
    this.c = null;
    this.d = 0;
  }
  
  public final m h()
  {
    return new m(this.a, this.b, this.c, this.d, this.e, this.f);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("(ip:");
    String str;
    if (this.a == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append(", port:").append(this.b).append(", pIp:");
      if (this.c != null) {
        break label185;
      }
      str = "null";
      label53:
      localStringBuilder = localStringBuilder.append(str).append(", pPort:").append(this.d).append(", ");
      switch (this.e)
      {
      default: 
        str = "unknown ProtocolCategory";
        label107:
        localStringBuilder = localStringBuilder.append(str).append(", ");
        switch (this.f)
        {
        default: 
          str = "unknown";
        }
        break;
      }
    }
    for (;;)
    {
      return str + ")";
      str = this.a;
      break;
      label185:
      str = this.c;
      break label53;
      str = "tcp";
      break label107;
      str = "http";
      break label107;
      str = "optimum";
      continue;
      str = "redirect";
      continue;
      str = "recent";
      continue;
      str = "host";
      continue;
      str = "backup";
      continue;
      str = "cdn";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */