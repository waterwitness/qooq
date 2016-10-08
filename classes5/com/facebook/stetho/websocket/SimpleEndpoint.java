package com.facebook.stetho.websocket;

public abstract interface SimpleEndpoint
{
  public abstract void onClose(SimpleSession paramSimpleSession, int paramInt, String paramString);
  
  public abstract void onError(SimpleSession paramSimpleSession, Throwable paramThrowable);
  
  public abstract void onMessage(SimpleSession paramSimpleSession, String paramString);
  
  public abstract void onMessage(SimpleSession paramSimpleSession, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void onOpen(SimpleSession paramSimpleSession);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\websocket\SimpleEndpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */