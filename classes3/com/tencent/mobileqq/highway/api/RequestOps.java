package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.segment.RequestAck;

public abstract interface RequestOps
{
  public abstract void SubmitAckRequest(RequestAck paramRequestAck);
  
  public abstract void cancelAckRequest(RequestAck paramRequestAck);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\api\RequestOps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */