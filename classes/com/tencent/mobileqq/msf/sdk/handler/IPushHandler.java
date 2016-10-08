package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface IPushHandler
  extends IMsfHandler
{
  public abstract void onOverloadPushNotify(String paramString);
  
  public abstract void onProxyIpChanged(String paramString);
  
  public abstract void onRecvCmdPush(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterCmdPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onResetCmdPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onTicketChanged();
  
  public abstract void onUnRegisterPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\handler\IPushHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */