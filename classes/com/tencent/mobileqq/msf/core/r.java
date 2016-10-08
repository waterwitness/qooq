package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.QLog;

class r
  extends Thread
{
  r(o paramo) {}
  
  public void run()
  {
    o.b(this.a, true);
    int i = 0;
    for (;;)
    {
      if (i < o.b(this.a).h)
      {
        i += 1;
        if (o.c(this.a))
        {
          if (o.b(this.a).b) {
            ((WifiManager)o.d(this.a).getSystemService("wifi")).startScan();
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "accScan, launch count=" + i);
          }
        }
      }
      try
      {
        Thread.sleep(o.b(this.a).i);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "accScan, count=" + i + ", stopped");
      }
      o.b(this.a, false);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */