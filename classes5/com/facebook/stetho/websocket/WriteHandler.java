package com.facebook.stetho.websocket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
class WriteHandler
{
  private final BufferedOutputStream mBufferedOutput;
  
  public WriteHandler(OutputStream paramOutputStream)
  {
    this.mBufferedOutput = new BufferedOutputStream(paramOutputStream, 1024);
  }
  
  public void write(Frame paramFrame, WriteCallback paramWriteCallback)
  {
    try
    {
      paramFrame.writeTo(this.mBufferedOutput);
      this.mBufferedOutput.flush();
      paramWriteCallback.onSuccess();
      return;
    }
    catch (IOException paramFrame)
    {
      for (;;)
      {
        paramWriteCallback.onFailure(paramFrame);
      }
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\websocket\WriteHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */