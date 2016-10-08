package com.tencent.mobileqq.msf.sdk;

import android.os.RemoteException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;

class h
  extends IMsfServiceCallbacker.Stub
{
  h(g paramg) {}
  
  public void onRecvPushResp(FromServiceMsg paramFromServiceMsg)
    throws RemoteException
  {
    g.a(this.a, paramFromServiceMsg);
  }
  
  public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
    throws RemoteException
  {
    g.a(this.a, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */