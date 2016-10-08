package com.tencent.component.network.utils.thread;

import android.os.Process;

final class e
  extends Thread
{
  e(PriorityThreadFactory paramPriorityThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public final void run()
  {
    Process.setThreadPriority(PriorityThreadFactory.a(this.a));
    super.run();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\thread\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */