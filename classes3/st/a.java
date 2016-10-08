package st;

import android.content.Context;
import android.os.Handler;

abstract class a
  extends d
  implements m
{
  private final d[] c;
  private final Handler[] d;
  private final b.1[] e;
  
  a(d... paramVarArgs)
    throws Exception
  {
    this.c = paramVarArgs;
    this.d = new Handler[this.c.length];
    this.e = new b.1[this.d.length];
  }
  
  final void a()
  {
    d[] arrayOfd = this.c;
    int j = arrayOfd.length;
    int i = 0;
    while (i < j)
    {
      arrayOfd[i].d();
      i += 1;
    }
  }
  
  final void a(Context paramContext)
  {
    d[] arrayOfd = this.c;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        d locald = arrayOfd[i];
        try
        {
          locald.a(paramContext, new m[] { this });
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  void a(Context paramContext, Handler paramHandler, b.1 param1)
  {
    a(paramHandler, this.d);
    a(param1, this.e);
    int i = 0;
    for (;;)
    {
      if (i < this.c.length) {
        try
        {
          this.c[i].a(this.d[i], this.e[i]);
          i += 1;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  abstract void a(Handler paramHandler, Handler[] paramArrayOfHandler);
  
  abstract void a(b.1 param1, b.1[] paramArrayOf1);
  
  final void b(Context paramContext)
  {
    paramContext = this.c;
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      paramContext[i].e();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */