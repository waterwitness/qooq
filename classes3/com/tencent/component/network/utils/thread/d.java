package com.tencent.component.network.utils.thread;

final class d
  implements Runnable
{
  d(AsyncTask.d paramd, Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      this.b.run();
      return;
    }
    finally
    {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\thread\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */