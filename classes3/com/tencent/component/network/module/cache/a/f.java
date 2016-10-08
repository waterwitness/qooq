package com.tencent.component.network.module.cache.a;

import android.content.Context;
import com.tencent.component.network.downloader.common.a;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

final class f
  implements ThreadPool.Job<Object>
{
  f(e parame, boolean paramBoolean, Context paramContext) {}
  
  public final Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = e.a(this.a).a();
    int i;
    int j;
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      i = 0;
      j = 0;
      if (paramJobContext.hasNext()) {
        break label75;
      }
      if (i > 0) {
        break label184;
      }
    }
    label75:
    label184:
    for (float f = Float.MAX_VALUE;; f = j / i)
    {
      if (f < 0.1F) {
        e.a(this.a, this.c);
      }
      return null;
      b localb = (b)paramJobContext.next();
      int k = localb.b(this.b);
      int m = localb.a(this.b);
      e locale = this.a;
      int n = e.a(k, m);
      localb.a(this.b, n);
      if (a.b()) {
        a.b("downloader", "clear cache service:" + localb + ": remain=" + n);
      }
      j += m;
      i += k;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\cache\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */