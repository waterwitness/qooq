package com.tencent.biz.qqstory.channel;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class NetworkRequest
{
  public IProtocolListener a;
  
  public NetworkRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract BaseResponse a(byte[] paramArrayOfByte);
  
  public IProtocolListener a()
  {
    return this.a;
  }
  
  public abstract String a();
  
  public void a(IProtocolListener paramIProtocolListener)
  {
    this.a = paramIProtocolListener;
  }
  
  protected abstract byte[] a();
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\channel\NetworkRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */