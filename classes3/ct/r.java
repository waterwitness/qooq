package ct;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class r
  implements q
{
  private static r a = null;
  
  public static r a()
  {
    try
    {
      if (a == null) {
        a = new r();
      }
      r localr = a;
      return localr;
    }
    finally {}
  }
  
  public static void a(ao paramao)
  {
    HashMap localHashMap = i.a(paramao);
    localHashMap.put("B64", paramao.A);
    localHashMap.put("B79", paramao.J);
    if (!TextUtils.isEmpty(paramao.G)) {
      localHashMap.put("B73", paramao.A);
    }
    localHashMap.put("B65", paramao.u);
    localHashMap.put("B66", paramao.y);
    localHashMap.put("B75", paramao.v);
    localHashMap.put("B67", paramao.B);
    localHashMap.put("B70", paramao.F);
    localHashMap.put("B72", paramao.C);
    localHashMap.put("B74", paramao.D);
    localHashMap.put("B68", paramao.E);
    localHashMap.put("B80", paramao.K);
    localHashMap.put("B81", paramao.L);
    localHashMap.put("B77", paramao.H);
    localHashMap.put("B82", paramao.M);
    localHashMap.put("B83", paramao.l);
    localHashMap.put("B84", paramao.f);
    try
    {
      if (ar.f() == null) {
        ar.a(p.a());
      }
      au.a("B_ACSDK_SDKExt_Result", localHashMap);
      return;
    }
    catch (OutOfMemoryError paramao) {}catch (Exception paramao) {}
  }
  
  public final void a(f paramf)
  {
    bc.b();
    ao localao = new ao();
    localao.a = paramf.b;
    localao.b = paramf.c;
    localao.c = paramf.d;
    localao.d = paramf.a;
    localao.e = paramf.e;
    localao.h = paramf.i;
    if (localao.h == 1) {
      localao.g = bb.a();
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localao.i = paramf.j;
      Object localObject = paramf.h;
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label331;
      }
      localStringBuilder = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append((String)((Iterator)localObject).next());
        localStringBuilder.append(";");
      }
      localao.f = bb.a();
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localao.j = localStringBuilder.toString();
    localao.k = paramf.n;
    if (paramf.o) {}
    for (int i = 1;; i = 0)
    {
      localao.m = i;
      localao.n = paramf.k;
      localao.o = paramf.l;
      localao.p = paramf.m;
      localao.q = paramf.p;
      localao.s = paramf.r;
      localao.r = paramf.q;
      localao.t = paramf.s;
      localao.w = paramf.t;
      localao.z = paramf.f;
      new StringBuilder("AccessSchedulerFinished：").append(localao.toString());
      bc.b();
      paramf = new a(localao);
      o.a().a(paramf);
      return;
      label331:
      localao.j = "";
      break;
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      try
      {
        Thread.sleep(5000L);
        HashMap localHashMap = i.a(r.this);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        try
        {
          if (ar.f() == null) {
            ar.a(p.a());
          }
          au.a("B_ACSDK_SDK_Result", localHashMap);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          return;
        }
        catch (Exception localException) {}
        localInterruptedException = localInterruptedException;
        localInterruptedException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */