package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SocketLike
{
  private final LeakyBufferedInputStream mLeakyInput;
  private final LocalSocket mSocket;
  
  public SocketLike(LocalSocket paramLocalSocket, LeakyBufferedInputStream paramLeakyBufferedInputStream)
  {
    this.mSocket = paramLocalSocket;
    this.mLeakyInput = paramLeakyBufferedInputStream;
  }
  
  public SocketLike(SocketLike paramSocketLike, LeakyBufferedInputStream paramLeakyBufferedInputStream)
  {
    this(paramSocketLike.mSocket, paramLeakyBufferedInputStream);
  }
  
  public InputStream getInput()
    throws IOException
  {
    return this.mLeakyInput.leakBufferAndStream();
  }
  
  public OutputStream getOutput()
    throws IOException
  {
    return this.mSocket.getOutputStream();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\SocketLike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */