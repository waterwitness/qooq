package com.tencent.mobileqq.utils.httputils;

public abstract interface IHttpCommunicatorListener
{
  @Deprecated
  public abstract void a(HttpMsg paramHttpMsg);
  
  public abstract void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2);
  
  public abstract void a(String paramString);
  
  public abstract boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt);
  
  public abstract void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\httputils\IHttpCommunicatorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */