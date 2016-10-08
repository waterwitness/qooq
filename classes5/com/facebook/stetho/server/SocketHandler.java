package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;

public abstract interface SocketHandler
{
  public abstract void onAccepted(LocalSocket paramLocalSocket)
    throws IOException;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\SocketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */