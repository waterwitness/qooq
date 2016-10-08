package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface INotifyHandler
  extends IMsfHandler
{
  public abstract void onRecvNotify(long paramLong, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterNotifyResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onUnRegisterNotifyResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\handler\INotifyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */