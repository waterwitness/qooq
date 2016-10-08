package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class ak
  extends j
{
  private static byte[] i;
  private static Map<String, String> j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public String d = "";
  public long e = 0L;
  public String f = "";
  public String g = "";
  public Map<String, String> h = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    i = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    j = new HashMap();
    j.put("", "");
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.a(this.b, 1, true);
    byte[] arrayOfByte = i;
    this.c = ((byte[])paramh.c(2, false));
    this.d = paramh.b(3, false);
    this.e = paramh.a(this.e, 4, false);
    this.f = paramh.b(5, false);
    this.g = paramh.b(6, false);
    this.h = ((Map)paramh.a(j, 7, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    if (this.c != null) {
      parami.a(this.c, 2);
    }
    if (this.d != null) {
      parami.a(this.d, 3);
    }
    parami.a(this.e, 4);
    if (this.f != null) {
      parami.a(this.f, 5);
    }
    if (this.g != null) {
      parami.a(this.g, 6);
    }
    if (this.h != null) {
      parami.a(this.h, 7);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */