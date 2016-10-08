package com.tencent.upload.network;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.b.d;
import java.util.LinkedList;

final class g
  implements Runnable
{
  g(c paramc, d paramd) {}
  
  public final void run()
  {
    c.f(this.b);
    do
    {
      synchronized (c.g(this.b))
      {
        c.a(this.b, this.a);
        c.g(this.b).notify();
        if (c.c(this.b).size() == 0) {
          return;
        }
      }
    } while (!UploadConfiguration.isNetworkAvailable());
    c.e(this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */