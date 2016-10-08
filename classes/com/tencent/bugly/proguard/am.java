package com.tencent.bugly.proguard;

import com.tencent.bugly.crashreport.crash.jni.b;
import java.util.HashMap;
import java.util.Map;

public final class am
  extends j
  implements Cloneable
{
  private static al m;
  private static Map<String, String> n;
  public boolean a = true;
  public boolean b = true;
  public boolean c = true;
  public String d = "";
  public String e = "";
  public al f = null;
  public Map<String, String> g = null;
  public long h = 0L;
  public int i = 0;
  private String j = "";
  private String k = "";
  private int l = 0;
  
  static
  {
    if (!am.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      o = bool;
      m = new al();
      n = new HashMap();
      n.put("", "");
      return;
    }
  }
  
  public final void a(h paramh)
  {
    boolean bool = this.a;
    this.a = paramh.a(0, true);
    bool = this.b;
    this.b = paramh.a(1, true);
    bool = this.c;
    this.c = paramh.a(2, true);
    this.d = paramh.b(3, false);
    this.e = paramh.b(4, false);
    this.f = ((al)paramh.a(m, 5, false));
    this.g = ((Map)paramh.a(n, 6, false));
    this.h = paramh.a(this.h, 7, false);
    this.j = paramh.b(8, false);
    this.k = paramh.b(9, false);
    this.l = paramh.a(this.l, 10, false);
    this.i = paramh.a(this.i, 11, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    if (this.d != null) {
      parami.a(this.d, 3);
    }
    if (this.e != null) {
      parami.a(this.e, 4);
    }
    if (this.f != null) {
      parami.a(this.f, 5);
    }
    if (this.g != null) {
      parami.a(this.g, 6);
    }
    parami.a(this.h, 7);
    if (this.j != null) {
      parami.a(this.j, 8);
    }
    if (this.k != null) {
      parami.a(this.k, 9);
    }
    parami.a(this.l, 10);
    parami.a(this.i, 11);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new b(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "enable");
    paramStringBuilder.a(this.b, "enableUserInfo");
    paramStringBuilder.a(this.c, "enableQuery");
    paramStringBuilder.b(this.d, "url");
    paramStringBuilder.b(this.e, "expUrl");
    paramStringBuilder.a(this.f, "security");
    paramStringBuilder.a(this.g, "valueMap");
    paramStringBuilder.a(this.h, "strategylastUpdateTime");
    paramStringBuilder.b(this.j, "httpsUrl");
    paramStringBuilder.b(this.k, "httpsExpUrl");
    paramStringBuilder.a(this.l, "eventRecordCount");
    paramStringBuilder.a(this.i, "eventTimeInterval");
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (o) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (am)paramObject;
    } while ((!k.a(this.a, ((am)paramObject).a)) || (!k.a(this.b, ((am)paramObject).b)) || (!k.a(this.c, ((am)paramObject).c)) || (!k.a(this.d, ((am)paramObject).d)) || (!k.a(this.e, ((am)paramObject).e)) || (!k.a(this.f, ((am)paramObject).f)) || (!k.a(this.g, ((am)paramObject).g)) || (!k.a(this.h, ((am)paramObject).h)) || (!k.a(this.j, ((am)paramObject).j)) || (!k.a(this.k, ((am)paramObject).k)) || (!k.a(this.l, ((am)paramObject).l)) || (!k.a(this.i, ((am)paramObject).i)));
    return true;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */