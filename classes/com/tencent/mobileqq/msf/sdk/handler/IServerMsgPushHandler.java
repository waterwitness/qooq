package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract interface IServerMsgPushHandler
  extends IMsfHandler
{
  public abstract void onConnClose(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onConnOpened(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onOpenConnAllFailed(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onReceFirstResp(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRecvServerConfigPush(FromServiceMsg paramFromServiceMsg);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\handler\IServerMsgPushHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */