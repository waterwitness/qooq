package st;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

abstract class d
{
  boolean a;
  boolean b;
  private Context c;
  private Collection<WeakReference<m>> d;
  private Handler e;
  private b.1 f;
  
  private void b(Context paramContext, m... paramVarArgs)
  {
    this.c = paramContext;
    if (paramVarArgs == null) {
      this.d = null;
    }
    for (;;)
    {
      a(paramContext);
      return;
      this.d = new LinkedList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        m localm = paramVarArgs[i];
        this.d.add(new WeakReference(localm));
        i += 1;
      }
    }
  }
  
  abstract void a();
  
  abstract void a(Context paramContext);
  
  abstract void a(Context paramContext, Handler paramHandler, b.1 param1);
  
  final void a(Context paramContext, m... paramVarArgs)
    throws Exception
  {
    if (paramContext == null) {
      try
      {
        throw new Exception("Module: context cannot be null");
      }
      finally {}
    }
    d();
    b(paramContext.getApplicationContext(), paramVarArgs);
    this.a = true;
  }
  
  void a(Handler paramHandler, b.1 param1)
    throws Exception
  {
    try
    {
      e();
      this.e = paramHandler;
      this.f = param1;
      a(this.c, this.e, this.f);
      this.b = true;
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  abstract void b(Context paramContext);
  
  final void b(o paramo)
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      if (this.d != null)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          m localm = (m)((WeakReference)localIterator.next()).get();
          if (localm != null) {
            localm.a(paramo);
          }
        }
      }
    }
  }
  
  final void d()
  {
    try
    {
      if (this.a)
      {
        e();
        a();
        this.a = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void e()
  {
    try
    {
      if (this.b)
      {
        b(this.c);
        this.e = null;
        this.f = null;
        this.b = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */