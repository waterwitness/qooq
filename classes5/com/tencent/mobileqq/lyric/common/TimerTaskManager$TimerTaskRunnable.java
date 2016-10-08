package com.tencent.mobileqq.lyric.common;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class TimerTaskManager$TimerTaskRunnable
  implements Runnable
{
  private boolean a;
  
  public TimerTaskManager$TimerTaskRunnable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a();
  
  public boolean a()
  {
    return !this.a;
  }
  
  public final void run()
  {
    if (this.a) {
      a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\common\TimerTaskManager$TimerTaskRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */