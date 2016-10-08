package com.tencent.upload.network.c;

import com.tencent.upload.a.b;
import com.tencent.upload.network.base.d;

final class h
  implements Runnable
{
  h(c paramc, d paramd, int paramInt) {}
  
  public final void run()
  {
    b.d("Session", c.b(this.c) + " Connection:" + b.a(this.a) + " onError: socketStatus:" + this.b);
    int i = 30100;
    if ((this.b == 113) || (this.b == 101) || (this.b == 100)) {
      i = 35000;
    }
    for (;;)
    {
      c.a(this.c, this.a, i, "ndkNetworkError, socketStatus:" + this.b);
      return;
      if (this.b == 526) {
        i = 30300;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */