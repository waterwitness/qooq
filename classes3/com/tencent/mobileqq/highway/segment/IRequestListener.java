package com.tencent.mobileqq.highway.segment;

public abstract interface IRequestListener
{
  public abstract void handleConnClosed();
  
  public abstract void handleError(int paramInt, String paramString);
  
  public abstract void handleResponse(HwResponse paramHwResponse);
  
  public abstract void handleSendBegin(int paramInt);
  
  public abstract void handleSendEnd(int paramInt1, int paramInt2);
  
  public abstract void handleSendTimeOut();
  
  public abstract void handleWriteTimeout();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\segment\IRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */