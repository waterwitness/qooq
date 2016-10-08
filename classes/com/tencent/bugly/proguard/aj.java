package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class aj
  extends j
{
  private static byte[] y;
  private static Map<String, String> z;
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = 0;
  public byte[] h = null;
  public String i = "";
  public String j = "";
  public Map<String, String> k = null;
  public String l = "";
  public long m = 0L;
  public String n = "";
  public String o = "";
  public String p = "";
  public long q = 0L;
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  private String x = "";
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    y = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    z = new HashMap();
    z.put("", "");
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, true);
    this.c = paramh.b(2, true);
    this.d = paramh.b(3, true);
    this.e = paramh.b(4, false);
    this.f = paramh.b(5, true);
    this.g = paramh.a(this.g, 6, true);
    byte[] arrayOfByte = y;
    this.h = ((byte[])paramh.c(7, true));
    this.i = paramh.b(8, false);
    this.j = paramh.b(9, false);
    this.k = ((Map)paramh.a(z, 10, false));
    this.l = paramh.b(11, false);
    this.m = paramh.a(this.m, 12, false);
    this.n = paramh.b(13, false);
    this.o = paramh.b(14, false);
    this.p = paramh.b(15, false);
    this.q = paramh.a(this.q, 16, false);
    this.r = paramh.b(17, false);
    this.s = paramh.b(18, false);
    this.t = paramh.b(19, false);
    this.u = paramh.b(20, false);
    this.v = paramh.b(21, false);
    this.w = paramh.b(22, false);
    this.x = paramh.b(23, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    parami.a(this.d, 3);
    if (this.e != null) {
      parami.a(this.e, 4);
    }
    parami.a(this.f, 5);
    parami.a(this.g, 6);
    parami.a(this.h, 7);
    if (this.i != null) {
      parami.a(this.i, 8);
    }
    if (this.j != null) {
      parami.a(this.j, 9);
    }
    if (this.k != null) {
      parami.a(this.k, 10);
    }
    if (this.l != null) {
      parami.a(this.l, 11);
    }
    parami.a(this.m, 12);
    if (this.n != null) {
      parami.a(this.n, 13);
    }
    if (this.o != null) {
      parami.a(this.o, 14);
    }
    if (this.p != null) {
      parami.a(this.p, 15);
    }
    parami.a(this.q, 16);
    if (this.r != null) {
      parami.a(this.r, 17);
    }
    if (this.s != null) {
      parami.a(this.s, 18);
    }
    if (this.t != null) {
      parami.a(this.t, 19);
    }
    if (this.u != null) {
      parami.a(this.u, 20);
    }
    if (this.v != null) {
      parami.a(this.v, 21);
    }
    if (this.w != null) {
      parami.a(this.w, 22);
    }
    if (this.x != null) {
      parami.a(this.x, 23);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */