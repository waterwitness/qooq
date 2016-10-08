package com.tencent.mobileqq.msf.core.c;

import com.tencent.qphone.base.util.QLog;

class k
  extends Thread
{
  long a = 0L;
  
  public k(long paramLong, boolean paramBoolean)
  {
    this.a = paramLong;
  }
  
  public void run()
  {
    
    try
    {
      i.a(0, this.a);
      i.a(1, this.a);
      i.b(this.b);
      i.c(this.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MSF.C.NetworkTraffic", 1, "makeReportRDMData error " + localException, localException);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */