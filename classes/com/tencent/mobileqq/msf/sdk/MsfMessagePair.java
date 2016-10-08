package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MsfMessagePair
{
  public FromServiceMsg fromServiceMsg;
  public ToServiceMsg toServiceMsg;
  
  public MsfMessagePair(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.toServiceMsg = paramToServiceMsg;
    this.fromServiceMsg = paramFromServiceMsg;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\MsfMessagePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */