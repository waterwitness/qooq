package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.util.QLog;

class p
  implements ServiceConnection
{
  p(o paramo) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, "threadID:" + Thread.currentThread().getId() + " onServiceConnected service:" + paramComponentName);
    }
    this.a.d = IBaseService.Stub.asInterface(paramIBinder);
    this.a.d();
    o.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, " onServiceDisconnected " + paramComponentName);
    }
    this.a.d = null;
    o.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */