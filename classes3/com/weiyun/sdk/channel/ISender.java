package com.weiyun.sdk.channel;

public abstract interface ISender
{
  public abstract void releaseSender();
  
  public abstract boolean sendRequest(String paramString, byte[] paramArrayOfByte, ICallback paramICallback);
  
  public static abstract interface ICallback
  {
    public abstract void onRespond(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\channel\ISender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */