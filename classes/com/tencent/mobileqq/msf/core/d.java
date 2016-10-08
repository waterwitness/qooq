package com.tencent.mobileqq.msf.core;

import com.tencent.msf.service.protocol.serverconfig.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static final int a = 0;
  public static final int b = 1;
  public static final String c = "00000";
  public static final String d = "http";
  public static final String e = "socket";
  public byte f = 1;
  public byte g;
  public boolean h;
  public String i = "";
  public String j = "";
  public String k = "";
  public AtomicInteger l = new AtomicInteger();
  long m = 0L;
  public boolean n;
  private String o = "socket";
  private String p;
  private int q;
  private int r = 20000;
  private boolean s;
  
  public static d a(j paramj, int paramInt)
  {
    d locald = new d();
    if ((paramj.e == 2) || (paramj.e == 3))
    {
      locald.o = "http";
      locald.p = paramj.a;
      locald.q = paramj.b;
      locald.i = "";
      locald.f = 0;
      locald.g = paramj.d;
      if (paramj.f <= 20) {
        break label151;
      }
      locald.r = 20000;
      label81:
      if (paramInt != 0) {
        break label184;
      }
      locald.i = "00000";
      locald.a(true);
    }
    for (;;)
    {
      if (paramj.g == 1) {
        locald.s = true;
      }
      locald.j = paramj.h;
      locald.k = paramj.i;
      return locald;
      if ((paramj.e != 0) && (paramj.e != 1)) {
        break;
      }
      locald.o = "socket";
      break;
      label151:
      if (paramj.f < 5)
      {
        locald.r = 5000;
        break label81;
      }
      locald.r = (paramj.f * 1000);
      break label81;
      label184:
      locald.a(false);
    }
  }
  
  public static d a(String paramString)
  {
    Object localObject = paramString.toLowerCase();
    paramString = new d();
    localObject = Pattern.compile("([a-zA-Z]+)://([a-zA-Z0-9.]+)(:([0-9]+))?(#([0-9_]*))?(:([0-9]+))?(:([0-9]+))?(:([0-9]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?").matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches())
    {
      if (((Matcher)localObject).group(1) != null) {
        paramString.o = ((Matcher)localObject).group(1);
      }
      if (((Matcher)localObject).group(2) != null) {
        paramString.p = ((Matcher)localObject).group(2);
      }
      if (((Matcher)localObject).group(4) == null) {
        break label248;
      }
    }
    label248:
    for (paramString.q = Integer.parseInt(((Matcher)localObject).group(4));; paramString.q = 80)
    {
      if (((Matcher)localObject).group(6) != null) {
        paramString.i = ((Matcher)localObject).group(6);
      }
      if (((Matcher)localObject).group(8) != null) {
        paramString.f = Byte.parseByte(((Matcher)localObject).group(8));
      }
      if (((Matcher)localObject).group(10) != null) {
        paramString.g = Byte.parseByte(((Matcher)localObject).group(10));
      }
      if (((Matcher)localObject).group(12) != null) {
        paramString.r = (Integer.parseInt(((Matcher)localObject).group(12)) * 1000);
      }
      if (((Matcher)localObject).group(14) != null) {
        paramString.s = Boolean.parseBoolean(((Matcher)localObject).group(14));
      }
      if (((Matcher)localObject).group(16) != null) {
        paramString.j = ((Matcher)localObject).group(16);
      }
      if (((Matcher)localObject).group(18) != null) {
        paramString.k = ((Matcher)localObject).group(18);
      }
      paramString.a(paramString.i.equals("00000"));
      return paramString;
    }
  }
  
  public String a()
  {
    return this.p + ":" + this.q;
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean a(com.tencent.qphone.base.a parama)
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    if ((parama == com.tencent.qphone.base.a.d) || (parama == com.tencent.qphone.base.a.c)) {
      if ((this.m == 0L) || (l1 - this.m > 600000L))
      {
        this.m = l1;
        this.l.incrementAndGet();
      }
    }
    for (;;)
    {
      if (this.l.get() > 19)
      {
        this.l.set(0);
        bool = true;
      }
      return bool;
      this.l.addAndGet(com.tencent.mobileqq.msf.core.a.a.aO());
      continue;
      if (parama == com.tencent.qphone.base.a.e) {
        this.l.addAndGet(com.tencent.mobileqq.msf.core.a.a.aP());
      } else if (parama == com.tencent.qphone.base.a.B) {
        this.l.addAndGet(com.tencent.mobileqq.msf.core.a.a.aQ());
      } else if (parama == com.tencent.qphone.base.a.p) {
        this.l.addAndGet(com.tencent.mobileqq.msf.core.a.a.aR());
      } else if (parama == com.tencent.qphone.base.a.j) {
        this.l.addAndGet(com.tencent.mobileqq.msf.core.a.a.aS());
      } else if (parama == com.tencent.qphone.base.a.i) {
        this.l.addAndGet(com.tencent.mobileqq.msf.core.a.a.aT());
      }
    }
  }
  
  public String b()
  {
    return this.o;
  }
  
  public void b(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void b(String paramString)
  {
    this.o = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public String c()
  {
    return this.p;
  }
  
  public void c(String paramString)
  {
    this.p = paramString;
  }
  
  public int d()
  {
    return this.q;
  }
  
  public int e()
  {
    return this.r;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof d)) && (((d)paramObject).toString().equals(toString()));
  }
  
  public void f()
  {
    this.m = System.currentTimeMillis();
  }
  
  public boolean g()
  {
    return this.n;
  }
  
  public boolean h()
  {
    return this.s;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    return this.o + "://" + this.p + ":" + this.q + "#" + this.i + ":" + this.f + ":" + this.g + ":" + this.r / 1000 + ":" + this.s + ":" + this.j + ":" + this.k;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */