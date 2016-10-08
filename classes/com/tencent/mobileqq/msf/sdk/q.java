package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentLinkedQueue;

class q
  extends Thread
{
  q(o paramo) {}
  
  public void run()
  {
    while (!o.f.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)o.f.poll();
      if (localToServiceMsg != null) {
        try
        {
          this.a.a(localToServiceMsg);
        }
        catch (Exception localException)
        {
          FromServiceMsg localFromServiceMsg = this.a.a(localToServiceMsg, localToServiceMsg.getServiceName() + "sendMsgToServiceFailed，" + localException.toString());
          this.a.c(localToServiceMsg, localFromServiceMsg);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */