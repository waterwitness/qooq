package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocket.PayloadType;
import com.squareup.okhttp.ws.WebSocketListener;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Random;
import java.util.concurrent.Executor;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class RealWebSocket
  implements WebSocket
{
  private static final int CLOSE_PROTOCOL_EXCEPTION = 1002;
  private final Object closeLock = new Object();
  private final WebSocketListener listener;
  private final WebSocketReader reader;
  private volatile boolean readerSentClose;
  private final WebSocketWriter writer;
  private volatile boolean writerSentClose;
  
  public RealWebSocket(boolean paramBoolean, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink, Random paramRandom, final Executor paramExecutor, final WebSocketListener paramWebSocketListener, final String paramString)
  {
    this.listener = paramWebSocketListener;
    this.writer = new WebSocketWriter(paramBoolean, paramBufferedSink, paramRandom);
    this.reader = new WebSocketReader(paramBoolean, paramBufferedSource, new WebSocketReader.FrameCallback()
    {
      public void onClose(final int paramAnonymousInt, final String paramAnonymousString)
      {
        synchronized (RealWebSocket.this.closeLock)
        {
          RealWebSocket.this.readerSentClose = true;
          if (RealWebSocket.this.writerSentClose)
          {
            bool = false;
            paramExecutor.execute(new NamedRunnable("OkHttp %s WebSocket Close Reply", new Object[] { paramString })
            {
              protected void execute()
              {
                RealWebSocket.this.peerClose(paramAnonymousInt, paramAnonymousString, bool);
              }
            });
            return;
          }
          final boolean bool = true;
        }
      }
      
      public void onMessage(BufferedSource paramAnonymousBufferedSource, WebSocket.PayloadType paramAnonymousPayloadType)
        throws IOException
      {
        paramWebSocketListener.onMessage(paramAnonymousBufferedSource, paramAnonymousPayloadType);
      }
      
      public void onPing(final Buffer paramAnonymousBuffer)
      {
        paramExecutor.execute(new NamedRunnable("OkHttp %s WebSocket Pong Reply", new Object[] { paramString })
        {
          protected void execute()
          {
            try
            {
              RealWebSocket.this.writer.writePong(paramAnonymousBuffer);
              return;
            }
            catch (IOException localIOException) {}
          }
        });
      }
      
      public void onPong(Buffer paramAnonymousBuffer)
      {
        paramWebSocketListener.onPong(paramAnonymousBuffer);
      }
    });
  }
  
  private void peerClose(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.writer.writeClose(paramInt, paramString);
      try
      {
        closeConnection();
        this.listener.onClose(paramInt, paramString);
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;) {}
      }
    }
    catch (IOException localIOException2)
    {
      for (;;) {}
    }
  }
  
  private void readerErrorClose(IOException paramIOException)
  {
    int i = 1;
    synchronized (this.closeLock)
    {
      this.readerSentClose = true;
      if (this.writerSentClose) {
        i = 0;
      }
      if ((i == 0) || (!(paramIOException instanceof ProtocolException))) {}
    }
    try
    {
      this.writer.writeClose(1002, null);
      try
      {
        closeConnection();
        this.listener.onFailure(paramIOException, null);
        return;
        paramIOException = finally;
        throw paramIOException;
      }
      catch (IOException localIOException1)
      {
        for (;;) {}
      }
    }
    catch (IOException localIOException2)
    {
      for (;;) {}
    }
  }
  
  public void close(int paramInt, String paramString)
    throws IOException
  {
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    synchronized (this.closeLock)
    {
      this.writerSentClose = true;
      boolean bool = this.readerSentClose;
      this.writer.writeClose(paramInt, paramString);
      if (bool) {
        closeConnection();
      }
      return;
    }
  }
  
  protected abstract void closeConnection()
    throws IOException;
  
  public BufferedSink newMessageSink(WebSocket.PayloadType paramPayloadType)
  {
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    return this.writer.newMessageSink(paramPayloadType);
  }
  
  public boolean readMessage()
  {
    try
    {
      this.reader.processNextFrame();
      boolean bool = this.readerSentClose;
      return !bool;
    }
    catch (IOException localIOException)
    {
      readerErrorClose(localIOException);
    }
    return false;
  }
  
  public void sendMessage(WebSocket.PayloadType paramPayloadType, Buffer paramBuffer)
    throws IOException
  {
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    this.writer.sendMessage(paramPayloadType, paramBuffer);
  }
  
  public void sendPing(Buffer paramBuffer)
    throws IOException
  {
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    this.writer.writePing(paramBuffer);
  }
  
  public void sendPong(Buffer paramBuffer)
    throws IOException
  {
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    this.writer.writePong(paramBuffer);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\ws\RealWebSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */