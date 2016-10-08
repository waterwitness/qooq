package ct;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
{
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public ArrayList h;
  public int i;
  public int j;
  public int k;
  public String l;
  public String m;
  public s n;
  public boolean o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  
  public final g a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new bj();
    bb.b();
    if (!bb.e())
    {
      this.k = -4;
      this.l = "Network fail before schedule";
      return null;
    }
    this.f = be.b(this.h.toString());
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("imei", be.a());
    ((Map)localObject2).put("reqKey", this.f);
    localObject2 = new aj(this.a, this.b, this.h, this.e, this.c, this.d, this.i, this.j, this.g, (Map)localObject2);
    ((bj)localObject1).c.c = "#halley-proxy.HalleyDispatchService";
    ((bj)localObject1).c.d = "srvDispatch";
    if ((localObject2 instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject3 = new bh();
    ((bh)localObject3).b = ((bj)localObject1).b;
    ((bh)localObject3).a(localObject2, 0);
    localObject2 = ((bh)localObject3).a;
    localObject3 = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject3, 0, localObject3.length);
    ((bj)localObject1).a.put("request", localObject3);
    localObject1 = i.a((bj)localObject1);
    ((av)localObject1).b();
    this.o = bb.e();
    this.n = ((av)localObject1).e();
    this.p = ((av)localObject1).h();
    this.q = ((av)localObject1).f();
    this.r = ((av)localObject1).i();
    this.s = ((av)localObject1).g();
    if ((((av)localObject1).c() == 0) && (((av)localObject1).a() != null))
    {
      localObject1 = ((av)localObject1).a();
      localObject2 = new ak();
      try
      {
        localObject1 = (ak)((bj)localObject1).a("response", localObject2);
        if (localObject1 == null)
        {
          this.k = -8;
          this.l = "Response is Null";
          return null;
        }
      }
      catch (Exception localException)
      {
        bc.d();
        this.k = -8;
        this.m = localException.getClass().getSimpleName();
        this.l = be.a(localException);
        return null;
      }
      localObject2 = new g();
      localObject3 = bb.a();
      long l2 = System.currentTimeMillis();
      if ((!((String)localObject3).equals("unkonwn")) && (((String)localObject3).equals(this.g)))
      {
        localObject3 = localException.a;
        if ((localObject3 != null) && (((Map)localObject3).size() > 0))
        {
          t localt = new t(this.g);
          Iterator localIterator = ((Map)localObject3).keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject4 = (String)localIterator.next();
            if (((Map)localObject3).get(localObject4) != null)
            {
              Object localObject5 = ((al)((Map)localObject3).get(localObject4)).a;
              localObject4 = new t.a((String)localObject4, l2, ((al)localException.a.get(localObject4)).b);
              localObject5 = ((ArrayList)localObject5).iterator();
              while (((Iterator)localObject5).hasNext())
              {
                String str = (String)((Iterator)localObject5).next();
                s locals = new s();
                if (locals.a(str)) {
                  ((t.a)localObject4).c.add(locals);
                }
              }
              localt.a((t.a)localObject4);
            }
          }
          ((g)localObject2).a = localt;
        }
      }
      for (;;)
      {
        if (localException.c != null) {
          ((g)localObject2).b = new d(localException.c);
        }
        if (localException.b != null) {
          ((g)localObject2).c = new c(localException.b);
        }
        this.t = ((int)(System.currentTimeMillis() - l1));
        return (g)localObject2;
        ((g)localObject2).a = null;
        this.k = -9;
        this.l = ("req apn:" + this.g + ",current apn:" + (String)localObject3);
      }
    }
    this.k = localException.c();
    this.m = localException.d();
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */