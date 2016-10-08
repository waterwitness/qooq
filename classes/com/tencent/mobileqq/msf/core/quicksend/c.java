package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;

class c
  extends Handler
{
  c(b paramb) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    int i = paramMessage.arg1;
    b.a(this.a, (ToServiceMsg)b.a(this.a).get(Integer.valueOf(i)));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\quicksend\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */