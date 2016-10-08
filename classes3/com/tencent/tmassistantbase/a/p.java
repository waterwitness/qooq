package com.tencent.tmassistantbase.a;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class p
  extends Thread
{
  p(o paramo, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if ((m.g()) && (m.t.compareAndSet(false, true))) {
      try
      {
        m.j();
        try
        {
          m.o = m.h.getPackageName();
          m.j = new LinkedBlockingQueue(15000);
          m.n = Process.myPid();
          Log.d("TMLog", "TMLog init start ");
          m.k();
          m.y.setName("logWriteThread");
          m.y.start();
          m.w.removeCallbacks(m.x);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            m.o = "unknow";
          }
        }
        int j;
        return;
      }
      catch (Exception localException2)
      {
        m.t.set(false);
        localException2.printStackTrace();
        j = m.v.get();
        Log.d("TMLog", "TMLog init post retry " + j + " times, interval " + m.u[j]);
        m.w.removeCallbacks(m.x);
        m.w.postDelayed(m.x, m.u[j] * 60000);
        j += 1;
        if (j >= m.u.length) {}
        for (;;)
        {
          m.v.set(i);
          return;
          i = j;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */