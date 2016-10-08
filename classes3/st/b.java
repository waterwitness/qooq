package st;

import android.net.wifi.ScanResult;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b
  extends a
{
  private x c;
  
  b()
    throws Exception
  {
    super(new d[] { y.f(), q.b(), t.b(), k.f() });
  }
  
  private void c(o paramo)
  {
    if (this.c != null) {}
    try
    {
      this.c.a(new a(this, paramo, (byte)0));
      return;
    }
    catch (Exception paramo)
    {
      paramo.printStackTrace();
    }
  }
  
  k.a a(1 param1)
  {
    if (param1 == null) {
      return null;
    }
    return new k.a(Math.max(param1.a, 10000L));
  }
  
  abstract void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, long paramLong1, long paramLong2);
  
  abstract void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong);
  
  abstract void a(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  void a(Handler paramHandler, 1 param1)
    throws Exception
  {
    if (paramHandler == null) {
      try
      {
        throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
      }
      finally {}
    }
    this.c = x.a(paramHandler);
    super.a(paramHandler, param1);
  }
  
  final void a(Handler paramHandler, Handler[] paramArrayOfHandler)
  {
    paramArrayOfHandler[0] = paramHandler;
    paramArrayOfHandler[1] = null;
    paramArrayOfHandler[2] = paramHandler;
    paramArrayOfHandler[3] = paramHandler;
  }
  
  abstract void a(List<ScanResult> paramList, long paramLong1, long paramLong2);
  
  final void a(1 param1, 1[] paramArrayOf1)
  {
    paramArrayOf1[0] = param1;
    paramArrayOf1[1] = null;
    paramArrayOf1[2] = null;
    paramArrayOf1[3] = a(param1);
  }
  
  public void a(o paramo)
  {
    switch (paramo.i)
    {
    default: 
      return;
    case 101: 
      a(((y.a)paramo).a, paramo.j, paramo.k);
      return;
    case 201: 
      c(paramo);
      return;
    case 202: 
      c(paramo);
      return;
    case 301: 
      paramo = (t.e)paramo;
      a(paramo.a, paramo.b, paramo.f, paramo.c, paramo.d, paramo.e, paramo.k);
      return;
    }
    paramo = (k.b)paramo;
    a(paramo.a, paramo.b, Double.valueOf(paramo.c).intValue(), Math.round(paramo.d), Math.round(paramo.e), paramo.g, paramo.f, paramo.h, paramo.k);
  }
  
  abstract void a(v paramv, long paramLong1, long paramLong2);
  
  static final class a
    implements Runnable
  {
    private final WeakReference<b> a;
    private final o b;
    
    private a(b paramb, o paramo)
      throws Exception
    {
      if ((paramb == null) || (paramo == null)) {
        throw new Exception("CoreAssembly: HandleMsgTask: null arg");
      }
      this.a = new WeakReference(paramb);
      this.b = paramo;
    }
    
    public final void run()
    {
      b localb = (b)this.a.get();
      if (localb != null) {}
      switch (this.b.i)
      {
      default: 
        return;
      }
      q.f localf = (q.f)this.b;
      if (localf.a == 1)
      {
        localb.a(localf.b, localf.j, localf.k);
        return;
      }
      localb.a(localf.a, localf.c, localf.j, localf.k);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */