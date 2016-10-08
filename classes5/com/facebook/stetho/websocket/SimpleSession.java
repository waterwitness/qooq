package com.facebook.stetho.websocket;

public abstract interface SimpleSession
{
  public abstract void close(int paramInt, String paramString);
  
  public abstract boolean isOpen();
  
  public abstract void sendBinary(byte[] paramArrayOfByte);
  
  public abstract void sendText(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\websocket\SimpleSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */