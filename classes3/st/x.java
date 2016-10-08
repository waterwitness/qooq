package st;

import android.os.Handler;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class x
{
  private static x a;
  private static final SparseArray<x> b = new SparseArray();
  private final ExecutorService c;
  private final Handler d;
  
  private x(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (this.c = null;; this.c = Executors.newSingleThreadExecutor())
    {
      this.d = paramHandler;
      return;
    }
  }
  
  static x a(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      int i = paramHandler.getLooper().hashCode();
      x localx2 = (x)b.get(i);
      x localx1 = localx2;
      if (localx2 == null)
      {
        localx1 = new x(paramHandler);
        b.put(i, localx1);
      }
      return localx1;
    }
    if (a == null) {
      a = new x(null);
    }
    return a;
  }
  
  final void a(Runnable paramRunnable)
  {
    if (this.d != null)
    {
      this.d.post(paramRunnable);
      return;
    }
    this.c.execute(paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */