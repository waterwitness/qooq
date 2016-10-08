package sm;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class p
  extends JceStruct
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public int h = 0;
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public int m = 0;
  public String n = "";
  public int o = 0;
  public String p = "";
  public short q = 0;
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  
  static
  {
    if (!p.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      v = bool;
      return;
    }
  }
  
  public p()
  {
    a(this.a);
    b(this.b);
    c(this.c);
    d(this.d);
    e(this.e);
    f(this.f);
    g(this.g);
    a(this.h);
    h(this.i);
    i(this.j);
    j(this.k);
    k(this.l);
    b(this.m);
    l(this.n);
    c(this.o);
    m(this.p);
    a(this.q);
    n(this.r);
    o(this.s);
    p(this.t);
    q(this.u);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(short paramShort)
  {
    this.q = paramShort;
  }
  
  public void b(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (v) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.a, "lc");
    paramStringBuilder.display(this.b, "name");
    paramStringBuilder.display(this.c, "version");
    paramStringBuilder.display(this.d, "imei");
    paramStringBuilder.display(this.e, "imsi");
    paramStringBuilder.display(this.f, "qq");
    paramStringBuilder.display(this.g, "ip");
    paramStringBuilder.display(this.h, "type");
    paramStringBuilder.display(this.i, "osversion");
    paramStringBuilder.display(this.j, "machineuid");
    paramStringBuilder.display(this.k, "machineconf");
    paramStringBuilder.display(this.l, "phone");
    paramStringBuilder.display(this.m, "subplatform");
    paramStringBuilder.display(this.n, "channelid");
    paramStringBuilder.display(this.o, "isbuildin");
    paramStringBuilder.display(this.p, "uuid");
    paramStringBuilder.display(this.q, "lang");
    paramStringBuilder.display(this.r, "guid");
    paramStringBuilder.display(this.s, "sdk");
    paramStringBuilder.display(this.t, "sid");
    paramStringBuilder.display(this.u, "newguid");
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (p)paramObject;
    } while ((!JceUtil.equals(this.a, ((p)paramObject).a)) || (!JceUtil.equals(this.b, ((p)paramObject).b)) || (!JceUtil.equals(this.c, ((p)paramObject).c)) || (!JceUtil.equals(this.d, ((p)paramObject).d)) || (!JceUtil.equals(this.e, ((p)paramObject).e)) || (!JceUtil.equals(this.f, ((p)paramObject).f)) || (!JceUtil.equals(this.g, ((p)paramObject).g)) || (!JceUtil.equals(this.h, ((p)paramObject).h)) || (!JceUtil.equals(this.i, ((p)paramObject).i)) || (!JceUtil.equals(this.j, ((p)paramObject).j)) || (!JceUtil.equals(this.k, ((p)paramObject).k)) || (!JceUtil.equals(this.l, ((p)paramObject).l)) || (!JceUtil.equals(this.m, ((p)paramObject).m)) || (!JceUtil.equals(this.n, ((p)paramObject).n)) || (!JceUtil.equals(this.o, ((p)paramObject).o)) || (!JceUtil.equals(this.p, ((p)paramObject).p)) || (!JceUtil.equals(this.q, ((p)paramObject).q)) || (!JceUtil.equals(this.r, ((p)paramObject).r)) || (!JceUtil.equals(this.s, ((p)paramObject).s)) || (!JceUtil.equals(this.t, ((p)paramObject).t)) || (!JceUtil.equals(this.u, ((p)paramObject).u)));
    return true;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
  
  public void h(String paramString)
  {
    this.i = paramString;
  }
  
  public int hashCode()
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
  
  public void i(String paramString)
  {
    this.j = paramString;
  }
  
  public void j(String paramString)
  {
    this.k = paramString;
  }
  
  public void k(String paramString)
  {
    this.l = paramString;
  }
  
  public void l(String paramString)
  {
    this.n = paramString;
  }
  
  public void m(String paramString)
  {
    this.p = paramString;
  }
  
  public void n(String paramString)
  {
    this.r = paramString;
  }
  
  public void o(String paramString)
  {
    this.s = paramString;
  }
  
  public void p(String paramString)
  {
    this.t = paramString;
  }
  
  public void q(String paramString)
  {
    this.u = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    a(paramJceInputStream.readString(0, true));
    b(paramJceInputStream.readString(1, true));
    c(paramJceInputStream.readString(2, true));
    d(paramJceInputStream.readString(3, true));
    e(paramJceInputStream.readString(4, true));
    f(paramJceInputStream.readString(5, false));
    g(paramJceInputStream.readString(6, false));
    a(paramJceInputStream.read(this.h, 7, false));
    h(paramJceInputStream.readString(8, false));
    i(paramJceInputStream.readString(9, false));
    j(paramJceInputStream.readString(10, false));
    k(paramJceInputStream.readString(11, false));
    b(paramJceInputStream.read(this.m, 12, false));
    l(paramJceInputStream.readString(13, false));
    c(paramJceInputStream.read(this.o, 14, false));
    m(paramJceInputStream.readString(15, false));
    a(paramJceInputStream.read(this.q, 16, false));
    n(paramJceInputStream.readString(17, false));
    o(paramJceInputStream.readString(18, false));
    p(paramJceInputStream.readString(19, false));
    q(paramJceInputStream.readString(20, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 10);
    }
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 11);
    }
    paramJceOutputStream.write(this.m, 12);
    if (this.n != null) {
      paramJceOutputStream.write(this.n, 13);
    }
    paramJceOutputStream.write(this.o, 14);
    if (this.p != null) {
      paramJceOutputStream.write(this.p, 15);
    }
    paramJceOutputStream.write(this.q, 16);
    if (this.r != null) {
      paramJceOutputStream.write(this.r, 17);
    }
    if (this.s != null) {
      paramJceOutputStream.write(this.s, 18);
    }
    if (this.t != null) {
      paramJceOutputStream.write(this.t, 19);
    }
    if (this.u != null) {
      paramJceOutputStream.write(this.u, 20);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */