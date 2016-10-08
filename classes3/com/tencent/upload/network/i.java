package com.tencent.upload.network;

final class i
  implements Runnable
{
  i(c paramc) {}
  
  public final void run()
  {
    c.f(this.a);
    synchronized (c.g(this.a))
    {
      c.g(this.a).notify();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */