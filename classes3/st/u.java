package st;

import android.content.Context;
import android.os.Handler;

final class u
  extends n
{
  private static u e;
  
  u()
    throws Exception
  {}
  
  static u c()
    throws Exception
  {
    if (e == null) {
      e = new u();
    }
    return e;
  }
  
  final void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    super.a(paramInt, paramString, paramLong1, paramLong2);
  }
  
  final void a(Context paramContext, Handler paramHandler, b.1 param1)
  {
    if (!k.f().a) {}
    try
    {
      k.f().a(paramContext, new m[] { this });
      super.a(paramContext, paramHandler, param1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  final void a(Handler paramHandler, b.1 param1)
    throws Exception
  {
    try
    {
      super.a(paramHandler, param1);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  public final void a(o paramo)
  {
    super.a(paramo);
  }
  
  final void a(v paramv, long paramLong1, long paramLong2)
  {
    if (paramv.f == null) {
      paramv.f = new v.a();
    }
    super.a(paramv, paramLong1, paramLong2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */