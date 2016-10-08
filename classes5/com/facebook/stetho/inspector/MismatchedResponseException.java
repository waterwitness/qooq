package com.facebook.stetho.inspector;

public class MismatchedResponseException
  extends MessageHandlingException
{
  public long mRequestId;
  
  public MismatchedResponseException(long paramLong)
  {
    super("Response for request id " + paramLong + ", but no such request is pending");
    this.mRequestId = paramLong;
  }
  
  public long getRequestId()
  {
    return this.mRequestId;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\MismatchedResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */