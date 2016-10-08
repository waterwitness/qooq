package com.facebook.stetho.inspector.network;

import java.io.IOException;

public abstract interface ResponseHandler
{
  public abstract void onEOF();
  
  public abstract void onError(IOException paramIOException);
  
  public abstract void onRead(int paramInt);
  
  public abstract void onReadDecoded(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\ResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */