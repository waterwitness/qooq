package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;

public class ServerManager
{
  private static final String THREAD_PREFIX = "StethoListener";
  private final LocalSocketServer mServer;
  private volatile boolean mStarted;
  
  public ServerManager(LocalSocketServer paramLocalSocketServer)
  {
    this.mServer = paramLocalSocketServer;
  }
  
  private void startServer(final LocalSocketServer paramLocalSocketServer)
  {
    new Thread("StethoListener-" + paramLocalSocketServer.getName())
    {
      public void run()
      {
        try
        {
          paramLocalSocketServer.run();
          return;
        }
        catch (IOException localIOException)
        {
          LogUtil.e(localIOException, "Could not start Stetho server: %s", new Object[] { paramLocalSocketServer.getName() });
        }
      }
    }.start();
  }
  
  public void start()
  {
    if (this.mStarted) {
      throw new IllegalStateException("Already started");
    }
    this.mStarted = true;
    startServer(this.mServer);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\ServerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */