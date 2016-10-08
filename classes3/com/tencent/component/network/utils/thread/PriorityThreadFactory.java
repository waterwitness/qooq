package com.tencent.component.network.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
  implements ThreadFactory
{
  public static final String FLAG_THREAD_NAME_SPLIT = " sub:";
  private final int a;
  private final AtomicInteger b = new AtomicInteger();
  private final String c;
  
  public PriorityThreadFactory(String paramString, int paramInt)
  {
    this.c = paramString;
    this.a = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new e(this, paramRunnable, this.c + '-' + this.b.getAndIncrement() + " sub:");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\thread\PriorityThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */