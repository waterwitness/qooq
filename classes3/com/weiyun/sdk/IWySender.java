package com.weiyun.sdk;

public abstract interface IWySender
{
  public abstract void cancelCallback();
  
  public abstract void sendRequest(int paramInt, String paramString, byte[] paramArrayOfByte);
  
  public abstract void setCallback(IWySenderCallback paramIWySenderCallback);
  
  public static abstract interface IWySenderCallback
  {
    public abstract void onRespond(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\IWySender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */