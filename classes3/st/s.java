package st;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;

public final class s
{
  private static Context a;
  private static String b;
  private static WeakReference<b> c;
  private static WeakReference<d> d;
  private static WeakReference<c> e;
  private static boolean f = false;
  private static final a g = new a((byte)0);
  
  public static void a()
  {
    try
    {
      u.c().e();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      f = false;
    }
  }
  
  public static void a(Context paramContext, p paramp)
  {
    a = paramContext.getApplicationContext();
    try
    {
      u.c().a(paramContext, new m[] { g });
      q.b().d = paramp;
      q.b().e = b;
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    b = paramString;
  }
  
  public static boolean a(Handler paramHandler, long paramLong, b paramb, d paramd)
  {
    if (a == null) {
      return false;
    }
    if (f) {
      return true;
    }
    c = new WeakReference(paramb);
    d = new WeakReference(paramd);
    e = new WeakReference(null);
    try
    {
      paramb = u.c();
      if (paramHandler != null) {}
      for (;;)
      {
        paramb.a(paramHandler, new n.c(paramLong, 5000L));
        boolean bool = w.f;
        f = true;
        return true;
        paramHandler = new Handler(a.getMainLooper());
      }
      return false;
    }
    catch (Exception paramHandler)
    {
      paramHandler.printStackTrace();
      f = false;
    }
  }
  
  public static void b()
  {
    try
    {
      u.c().d();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  static final class a
    implements m
  {
    public final void a(o paramo)
    {
      switch (paramo.i)
      {
      }
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                    } while (s.c() == null);
                    localObject = (s.b)s.c().get();
                  } while (localObject == null);
                  paramo = (n.a)paramo;
                  ((s.b)localObject).onLocationUpdate(paramo.a, paramo.b, paramo.c, paramo.d, paramo.e);
                  return;
                } while (s.d() == null);
                localObject = (s.d)s.d().get();
              } while (localObject == null);
              paramo = (n.b)paramo;
              ((s.d)localObject).onMessage(paramo.a, paramo.b);
              return;
            } while (s.e() == null);
            localObject = (s.c)s.e().get();
          } while (localObject == null);
          ((s.c)localObject).onRefAdded(((r.e)paramo).a);
          return;
        } while (s.e() == null);
        localObject = (s.c)s.e().get();
      } while (localObject == null);
      ((s.c)localObject).onTrackProcessed(((r.g)paramo).a);
    }
  }
  
  public static abstract interface b
  {
    public abstract void onLocationUpdate(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void onRefAdded(int paramInt);
    
    public abstract void onTrackProcessed(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void onMessage(int paramInt, String paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */