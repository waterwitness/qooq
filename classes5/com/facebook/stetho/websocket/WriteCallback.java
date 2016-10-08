package com.facebook.stetho.websocket;

import java.io.IOException;

abstract interface WriteCallback
{
  public abstract void onFailure(IOException paramIOException);
  
  public abstract void onSuccess();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\websocket\WriteCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */