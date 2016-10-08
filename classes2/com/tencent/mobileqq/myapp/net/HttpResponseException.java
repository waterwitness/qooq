package com.tencent.mobileqq.myapp.net;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HttpResponseException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private int stateCode;
  
  public HttpResponseException(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.stateCode = 200;
    this.stateCode = paramInt;
  }
  
  public int getStateCode()
  {
    return this.stateCode;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\myapp\net\HttpResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */