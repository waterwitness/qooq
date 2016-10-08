package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.qphone.base.util.QLog;

final class g
  extends Handler
{
  g(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((f.c() > 0L) && (SystemClock.elapsedRealtime() - f.c() < a.p()));
    f.a(SystemClock.elapsedRealtime());
    QLog.d(f.a, 1, "clean and compress log");
    f.d();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */