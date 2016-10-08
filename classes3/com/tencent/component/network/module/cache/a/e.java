package com.tencent.component.network.module.cache.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.component.network.downloader.common.a;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
  implements b.b
{
  private final a a;
  private final AtomicInteger b = new AtomicInteger(0);
  private Future c;
  private long d;
  private int e;
  
  static
  {
    new Handler(Looper.getMainLooper());
  }
  
  public e(a parama)
  {
    this.a = parama;
  }
  
  public final void a(b paramb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.b.getAndIncrement() < 2) {
      return;
    }
    this.b.set(0);
    a.c("downloader", "low storage: totalSize=" + paramLong1 + ", availableSize=" + paramLong2 + ", external=" + paramBoolean);
    try
    {
      if ((this.c != null) && (!this.c.isDone())) {
        return;
      }
    }
    finally {}
    paramb = paramb.a();
    this.c = PriorityThreadPool.getDefault().submit(new f(this, paramBoolean, paramb));
  }
  
  public static abstract interface a
  {
    public abstract Collection<b> a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\cache\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */