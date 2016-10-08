package ct;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Map;

public final class ag
  implements Runnable
{
  private af a;
  
  public ag(af paramaf)
  {
    this.a = paramaf;
  }
  
  public final void run()
  {
    int i;
    try
    {
      if ((this.a != null) && (!this.a.x))
      {
        localObject1 = InetAddress.getByName(this.a.c);
        this.a.v = ((InetAddress)localObject1).getHostAddress();
        this.a.a = new s(this.a.v, 80);
      }
      if ((this.a.k < -9) && (!i.b("info.3g.qq.com"))) {
        this.a.k = -17;
      }
      if (this.a.k != 0) {
        break label184;
      }
      localObject1 = this.a;
      if ((((af)localObject1).a == null) || (!((af)localObject1).a.a(((af)localObject1).b))) {
        break label733;
      }
      i = 1;
    }
    catch (Exception localException1)
    {
      try
      {
        label184:
        if (!this.a.B) {
          break label732;
        }
        Object localObject3 = this.a;
        Object localObject1 = h.a();
        if (localObject1 == null) {
          break label770;
        }
        Object localObject4 = ((a)localObject1).a();
        if ((localObject4 == null) || (((an)localObject4).a == null)) {
          break label770;
        }
        Object localObject2 = (Byte)((an)localObject4).a.get(Integer.valueOf(((af)localObject3).k));
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label265;
        }
        localObject1 = Byte.valueOf((byte)((an)localObject4).b);
        label265:
        if (localObject3 == null) {
          break label277;
        }
        ((af)localObject3).t = ((Byte)localObject1).byteValue();
        label277:
        if (Math.random() * 100.0D <= ((Byte)localObject1).floatValue()) {
          break label770;
        }
        i = 0;
        label296:
        if (i == 0) {
          break label732;
        }
        localObject1 = this.a;
        localObject2 = new ao();
        ((ao)localObject2).a = p.b();
        ((ao)localObject2).b = p.c();
        ((ao)localObject2).c = p.d();
        ((ao)localObject2).d = p.f();
        ((ao)localObject2).e = p.e();
        ((ao)localObject2).h = bb.c();
        if (((ao)localObject2).h != 1) {
          break label776;
        }
        ((ao)localObject2).g = bb.a();
        for (;;)
        {
          ((ao)localObject2).i = bb.d();
          if (!bb.e()) {
            break label788;
          }
          i = 1;
          ((ao)localObject2).m = i;
          if (localObject1 != null)
          {
            ((ao)localObject2).j = ((af)localObject1).c;
            ((ao)localObject2).k = ((af)localObject1).a;
            ((ao)localObject2).n = ((af)localObject1).k;
            ((ao)localObject2).o = ((af)localObject1).r;
            ((ao)localObject2).p = ((af)localObject1).q;
            ((ao)localObject2).q = ((af)localObject1).g;
            ((ao)localObject2).r = ((af)localObject1).h;
            ((ao)localObject2).s = ((af)localObject1).i;
            ((ao)localObject2).t = ((af)localObject1).j;
            ((ao)localObject2).w = ((af)localObject1).l;
            ((ao)localObject2).x = ((af)localObject1).m;
            ((ao)localObject2).u = ((af)localObject1).n;
            ((ao)localObject2).z = ((af)localObject1).p;
            ((ao)localObject2).A = ((af)localObject1).d;
            ((ao)localObject2).v = ((af)localObject1).o;
            ((ao)localObject2).G = ((af)localObject1).f;
            ((ao)localObject2).x = ((af)localObject1).m;
            ((ao)localObject2).J = ((af)localObject1).w;
            ((ao)localObject2).I = ((af)localObject1).v;
            ((ao)localObject2).K = ((af)localObject1).C;
            ((ao)localObject2).E = ((af)localObject1).t;
            ((ao)localObject2).y = ((af)localObject1).s;
            if (!((af)localObject1).x) {
              break label794;
            }
            i = 0;
            ((ao)localObject2).B = i;
            if (!((af)localObject1).z) {
              break label800;
            }
            i = 0;
            ((ao)localObject2).C = i;
            if (!h.a) {
              break label806;
            }
            i = 1;
            ((ao)localObject2).D = i;
            if (!((af)localObject1).D) {
              break label812;
            }
            i = 1;
            ((ao)localObject2).L = i;
            if (!((af)localObject1).A) {
              break label818;
            }
            i = 1;
            ((ao)localObject2).M = i;
            ((ao)localObject2).F = ((af)localObject1).y;
            ((ao)localObject2).l = ((af)localObject1).b;
            ((ao)localObject2).H = ((af)localObject1).u;
          }
          if (r.a() != null)
          {
            r.a();
            r.a((ao)localObject2);
          }
          bc.b();
          label732:
          return;
          label733:
          i = 0;
          break;
          label739:
          ((u)localObject1).a.a((String)localObject4, (String)localObject2, ((s)localObject3).a());
          ((u)localObject1).a(true);
          bc.b();
          break label184;
          localException1 = localException1;
          break label184;
          label770:
          i = 1;
          break label296;
          label776:
          ((ao)localObject2).f = bb.a();
        }
        i = 0;
      }
      catch (Exception localException2)
      {
        return;
      }
    }
    if (i == 0)
    {
      localObject3 = this.a;
      if (localObject3 != null)
      {
        localObject1 = u.a();
        localObject2 = ((af)localObject3).c;
        localObject3 = ((af)localObject3).a;
        localObject4 = bb.a();
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!((String)localObject4).equals("unknown"))) {
          break label739;
        }
        bc.c();
      }
    }
    for (;;)
    {
      label788:
      continue;
      label794:
      i = 1;
      continue;
      label800:
      i = 1;
      continue;
      label806:
      i = 0;
      continue;
      label812:
      i = 0;
      continue;
      label818:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */