package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LazySocketHandler
  implements SocketHandler
{
  @Nullable
  private SocketHandler mSocketHandler;
  private final SocketHandlerFactory mSocketHandlerFactory;
  
  public LazySocketHandler(SocketHandlerFactory paramSocketHandlerFactory)
  {
    this.mSocketHandlerFactory = paramSocketHandlerFactory;
  }
  
  @Nonnull
  private SocketHandler getSocketHandler()
  {
    try
    {
      if (this.mSocketHandler == null) {
        this.mSocketHandler = this.mSocketHandlerFactory.create();
      }
      SocketHandler localSocketHandler = this.mSocketHandler;
      return localSocketHandler;
    }
    finally {}
  }
  
  public void onAccepted(LocalSocket paramLocalSocket)
    throws IOException
  {
    getSocketHandler().onAccepted(paramLocalSocket);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\LazySocketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */