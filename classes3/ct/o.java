package ct;

import android.util.SparseArray;
import java.util.concurrent.ScheduledExecutorService;

public abstract class o
{
  private static o a;
  
  public static o a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      o localo = a;
      return localo;
    }
    finally {}
  }
  
  public abstract void a(Runnable paramRunnable);
  
  static final class a
    extends o
  {
    private ScheduledExecutorService a = null;
    
    public a()
    {
      new SparseArray();
    }
    
    public final void a(Runnable paramRunnable)
    {
      try
      {
        this.a.execute(paramRunnable);
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */