package com.tencent.tmassistantbase.a;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class q
  extends Thread
{
  public void run()
  {
    try
    {
      for (;;)
      {
        String str = (String)m.j.take();
        if (str != null) {
          m.b(str);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.d("TMLog", "write log file error." + localInterruptedException);
      }
    }
    catch (Throwable localThrowable1)
    {
      if (((localThrowable1 instanceof IOException)) && (localThrowable1.getMessage().contains("ENOSPC")))
      {
        if (m.s.compareAndSet(false, true)) {
          localThrowable1.printStackTrace();
        }
        return;
      }
      m.s.compareAndSet(true, false);
      localThrowable1.printStackTrace();
      try
      {
        m.k();
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */