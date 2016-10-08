package com.tencent.mobileqq.msf.core.net.b;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class k
  extends Handler
{
  k(j paramj) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (String)paramMessage.obj;
    QLog.d("WifiDetector", 1, "WIFI detect delayed try!");
    j.a(this.a, paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */