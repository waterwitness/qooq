package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface IMsfMsgHandler
  extends IMsfHandler
{
  public abstract void onRecvResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\handler\IMsfMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */