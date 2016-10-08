package com.tencent.mobileqq.msf.sdk;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class c
  implements Runnable
{
  c(b paramb, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      NetworkInfo localNetworkInfo = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
      a.f = localNetworkInfo;
      a.a(localNetworkInfo);
      a.e.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(a.k(), 2, localException.toString(), localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */