package com.tencent.mobileqq.msf.core.c;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class n
  extends Thread
{
  long a = 0L;
  long b = 0L;
  final long c = 5000L;
  final long d = 1000L;
  
  n(String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    for (;;)
    {
      this.a = SystemClock.elapsedRealtime();
      try
      {
        sleep(5000L);
        this.b = SystemClock.elapsedRealtime();
        if (this.b - this.a > 6000L)
        {
          Iterator localIterator = m.f().entrySet().iterator();
          while (localIterator.hasNext()) {
            try
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if ((localEntry != null) && (this.b - ((Long)localEntry.getKey()).longValue() > m.g())) {
                localIterator.remove();
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          m.f().put(Long.valueOf(this.a), Long.valueOf(this.b));
          m.b(true);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MSF.C.StatReport", 2, "find deep sleep. currTime:" + this.b + ", lastTime:" + this.a + ", sleep:" + (this.b - this.a));
          continue;
        }
        m.b(false);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */