package com.tencent.mobileqq.lyric.util;

import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import szl;
import szm;

public class LyricContext
{
  private static final Singleton a = new szl();
  private static Singleton b = new szm();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Handler a()
  {
    return (Handler)a.b(null);
  }
  
  public static TimerTaskManager a()
  {
    return (TimerTaskManager)b.b(null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\util\LyricContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */