package com.tencent.component.network.module.cache.a;

import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;

final class d
  implements ThreadPool.Job<Object>
{
  d(b paramb) {}
  
  public final Object run(ThreadPool.JobContext paramJobContext)
  {
    b.a(this.a, false);
    b.a(this.a, true);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\cache\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */