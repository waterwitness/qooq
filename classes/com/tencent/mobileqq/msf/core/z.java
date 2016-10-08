package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Message;

class z
  extends Handler
{
  z(y paramy) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (String)paramMessage.obj;
    this.a.s.refreshWebviewTickets(paramMessage, "SidExpiredPush");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */