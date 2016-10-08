package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.ws.WebSocket.PayloadType;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Timeout;

public final class WebSocketWriter
{
  private boolean activeWriter;
  private boolean closed;
  private final FrameSink frameSink = new FrameSink(null);
  private final boolean isClient;
  private final byte[] maskBuffer;
  private final byte[] maskKey;
  private final Random random;
  private final BufferedSink sink;
  
  public WebSocketWriter(boolean paramBoolean, BufferedSink paramBufferedSink, Random paramRandom)
  {
    if (paramBufferedSink == null) {
      throw new NullPointerException("sink == null");
    }
    if (paramRandom == null) {
      throw new NullPointerException("random == null");
    }
    this.isClient = paramBoolean;
    this.sink = paramBufferedSink;
    this.random = paramRandom;
    if (paramBoolean) {}
    for (paramBufferedSink = new byte[4];; paramBufferedSink = null)
    {
      this.maskKey = paramBufferedSink;
      paramBufferedSink = (BufferedSink)localObject;
      if (paramBoolean) {
        paramBufferedSink = new byte['ࠀ'];
      }
      this.maskBuffer = paramBufferedSink;
      return;
    }
  }
  
  private void writeAllMasked(BufferedSource paramBufferedSource, long paramLong)
    throws IOException
  {
    int i;
    for (long l = 0L;; l += i)
    {
      if (l >= paramLong) {
        return;
      }
      i = (int)Math.min(paramLong, this.maskBuffer.length);
      i = paramBufferedSource.read(this.maskBuffer, 0, i);
      if (i == -1) {
        throw new AssertionError();
      }
      WebSocketProtocol.toggleMask(this.maskBuffer, i, this.maskKey, l);
      this.sink.write(this.maskBuffer, 0, i);
    }
  }
  
  private void writeControlFrame(int paramInt, Buffer paramBuffer)
    throws IOException
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    int i = 0;
    if (paramBuffer != null)
    {
      j = (int)paramBuffer.size();
      i = j;
      if (j > 125) {
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
      }
    }
    int j = WebSocketProtocol.B0_FLAG_FIN;
    this.sink.writeByte(j | paramInt);
    if (this.isClient)
    {
      paramInt = WebSocketProtocol.B1_FLAG_MASK;
      this.sink.writeByte(i | paramInt);
      this.random.nextBytes(this.maskKey);
      this.sink.write(this.maskKey);
      if (paramBuffer != null) {
        writeAllMasked(paramBuffer, i);
      }
    }
    for (;;)
    {
      this.sink.flush();
      return;
      this.sink.writeByte(i);
      if (paramBuffer != null) {
        this.sink.writeAll(paramBuffer);
      }
    }
  }
  
  private void writeFrame(WebSocket.PayloadType paramPayloadType, Buffer paramBuffer, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    int i = 0;
    if (paramBoolean1) {
      switch (paramPayloadType)
      {
      default: 
        throw new IllegalStateException("Unknown payload type: " + paramPayloadType);
      }
    }
    for (i = 1;; i = 2)
    {
      paramPayloadType = this.sink;
      int j = i;
      if (paramBoolean2) {}
      for (;;)
      {
        try
        {
          j = i | WebSocketProtocol.B0_FLAG_FIN;
          this.sink.writeByte(j);
          i = 0;
          if (this.isClient)
          {
            i = 0x0 | WebSocketProtocol.B1_FLAG_MASK;
            this.random.nextBytes(this.maskKey);
          }
          if (paramLong <= 125L)
          {
            j = (int)paramLong;
            this.sink.writeByte(i | j);
            if (!this.isClient) {
              break label285;
            }
            this.sink.write(this.maskKey);
            writeAllMasked(paramBuffer, paramLong);
            this.sink.flush();
            return;
          }
          if (paramLong <= 65535L)
          {
            this.sink.writeByte(i | 0x7E);
            this.sink.writeShort((int)paramLong);
            continue;
          }
          this.sink.writeByte(i | 0x7F);
        }
        finally {}
        this.sink.writeLong(paramLong);
        continue;
        label285:
        this.sink.write(paramBuffer, paramLong);
      }
    }
  }
  
  public BufferedSink newMessageSink(WebSocket.PayloadType paramPayloadType)
  {
    if (paramPayloadType == null) {
      throw new NullPointerException("type == null");
    }
    if (this.activeWriter) {
      throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }
    this.activeWriter = true;
    this.frameSink.payloadType = paramPayloadType;
    this.frameSink.isFirstFrame = true;
    return Okio.buffer(this.frameSink);
  }
  
  public void sendMessage(WebSocket.PayloadType paramPayloadType, Buffer paramBuffer)
    throws IOException
  {
    if (paramPayloadType == null) {
      throw new NullPointerException("type == null");
    }
    if (paramBuffer == null) {
      throw new NullPointerException("payload == null");
    }
    if (this.activeWriter) {
      throw new IllegalStateException("A message writer is active. Did you call close()?");
    }
    writeFrame(paramPayloadType, paramBuffer, paramBuffer.size(), true, true);
  }
  
  public void writeClose(int paramInt, String arg2)
    throws IOException
  {
    Object localObject1 = null;
    if ((paramInt != 0) || (??? != null))
    {
      if ((paramInt != 0) && ((paramInt < 1000) || (paramInt >= 5000))) {
        throw new IllegalArgumentException("Code must be in range [1000,5000).");
      }
      Buffer localBuffer = new Buffer();
      localBuffer.writeShort(paramInt);
      localObject1 = localBuffer;
      if (??? != null)
      {
        localBuffer.writeUtf8(???);
        localObject1 = localBuffer;
      }
    }
    synchronized (this.sink)
    {
      writeControlFrame(8, (Buffer)localObject1);
      this.closed = true;
      return;
    }
  }
  
  public void writePing(Buffer paramBuffer)
    throws IOException
  {
    synchronized (this.sink)
    {
      writeControlFrame(9, paramBuffer);
      return;
    }
  }
  
  public void writePong(Buffer paramBuffer)
    throws IOException
  {
    synchronized (this.sink)
    {
      writeControlFrame(10, paramBuffer);
      return;
    }
  }
  
  private final class FrameSink
    implements Sink
  {
    private boolean isFirstFrame;
    private WebSocket.PayloadType payloadType;
    
    private FrameSink() {}
    
    public void close()
      throws IOException
    {
      if (WebSocketWriter.this.closed) {
        throw new IOException("closed");
      }
      synchronized (WebSocketWriter.this.sink)
      {
        WebSocketWriter.this.sink.writeByte(WebSocketProtocol.B0_FLAG_FIN);
        if (WebSocketWriter.this.isClient)
        {
          WebSocketWriter.this.sink.writeByte(WebSocketProtocol.B1_FLAG_MASK | 0x0);
          WebSocketWriter.this.random.nextBytes(WebSocketWriter.this.maskKey);
          WebSocketWriter.this.sink.write(WebSocketWriter.this.maskKey);
          WebSocketWriter.this.sink.flush();
          WebSocketWriter.this.activeWriter = false;
          return;
        }
        WebSocketWriter.this.sink.writeByte(0);
      }
    }
    
    public void flush()
      throws IOException
    {
      if (WebSocketWriter.this.closed) {
        throw new IOException("closed");
      }
      synchronized (WebSocketWriter.this.sink)
      {
        WebSocketWriter.this.sink.flush();
        return;
      }
    }
    
    public Timeout timeout()
    {
      return WebSocketWriter.this.sink.timeout();
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      WebSocketWriter.this.writeFrame(this.payloadType, paramBuffer, paramLong, this.isFirstFrame, false);
      this.isFirstFrame = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\ws\WebSocketWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */