package com.facebook.stetho.server;

import java.io.IOException;

public abstract interface SocketLikeHandler
{
  public abstract void onAccepted(SocketLike paramSocketLike)
    throws IOException;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\SocketLikeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */