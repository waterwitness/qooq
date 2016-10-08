package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.ws.WebSocket.PayloadType;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class WebSocketReader
{
  private boolean closed;
  private long frameBytesRead;
  private final FrameCallback frameCallback;
  private long frameLength;
  private final Source framedMessageSource = new FramedMessageSource(null);
  private final boolean isClient;
  private boolean isControlFrame;
  private boolean isFinalFrame;
  private boolean isMasked;
  private final byte[] maskBuffer = new byte['ࠀ'];
  private final byte[] maskKey = new byte[4];
  private boolean messageClosed;
  private int opcode;
  private final BufferedSource source;
  
  public WebSocketReader(boolean paramBoolean, BufferedSource paramBufferedSource, FrameCallback paramFrameCallback)
  {
    if (paramBufferedSource == null) {
      throw new NullPointerException("source == null");
    }
    if (paramFrameCallback == null) {
      throw new NullPointerException("frameCallback == null");
    }
    this.isClient = paramBoolean;
    this.source = paramBufferedSource;
    this.frameCallback = paramFrameCallback;
  }
  
  private void readControlFrame()
    throws IOException
  {
    Buffer localBuffer = null;
    if (this.frameBytesRead < this.frameLength)
    {
      localBuffer = new Buffer();
      if (!this.isClient) {
        break label190;
      }
      this.source.readFully(localBuffer, this.frameLength);
    }
    for (;;)
    {
      switch (this.opcode)
      {
      default: 
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        label190:
        do
        {
          i = (int)Math.min(this.frameLength - this.frameBytesRead, this.maskBuffer.length);
          i = this.source.read(this.maskBuffer, 0, i);
          if (i == -1) {
            throw new EOFException();
          }
          WebSocketProtocol.toggleMask(this.maskBuffer, i, this.maskKey, this.frameBytesRead);
          localBuffer.write(this.maskBuffer, 0, i);
          this.frameBytesRead += i;
        } while (this.frameBytesRead < this.frameLength);
      }
    }
    this.frameCallback.onPing(localBuffer);
    return;
    this.frameCallback.onPong(localBuffer);
    return;
    int i = 0;
    String str = "";
    if (localBuffer != null)
    {
      if (localBuffer.size() < 2L) {
        throw new ProtocolException("Close payload must be at least two bytes.");
      }
      i = localBuffer.readShort();
      if ((i < 1000) || (i >= 5000)) {
        throw new ProtocolException("Code must be in range [1000,5000): " + i);
      }
      str = localBuffer.readUtf8();
    }
    this.frameCallback.onClose(i, str);
    this.closed = true;
  }
  
  private void readHeader()
    throws IOException
  {
    boolean bool2 = true;
    if (this.closed) {
      throw new IOException("closed");
    }
    int k = this.source.readByte() & 0xFF;
    this.opcode = (WebSocketProtocol.B0_MASK_OPCODE & k);
    if ((WebSocketProtocol.B0_FLAG_FIN & k) != 0)
    {
      bool1 = true;
      this.isFinalFrame = bool1;
      if ((WebSocketProtocol.OPCODE_FLAG_CONTROL & k) == 0) {
        break label107;
      }
    }
    label107:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.isControlFrame = bool1;
      if ((!this.isControlFrame) || (this.isFinalFrame)) {
        break label113;
      }
      throw new ProtocolException("Control frames must be final.");
      bool1 = false;
      break;
    }
    label113:
    int j;
    if ((WebSocketProtocol.B0_FLAG_RSV1 & k) != 0)
    {
      i = 1;
      if ((WebSocketProtocol.B0_FLAG_RSV2 & k) == 0) {
        break label170;
      }
      j = 1;
      label133:
      if ((WebSocketProtocol.B0_FLAG_RSV3 & k) == 0) {
        break label175;
      }
    }
    label170:
    label175:
    for (k = 1;; k = 0)
    {
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label180;
      }
      throw new ProtocolException("Reserved flags are unsupported.");
      i = 0;
      break;
      j = 0;
      break label133;
    }
    label180:
    int i = this.source.readByte() & 0xFF;
    if ((WebSocketProtocol.B1_FLAG_MASK & i) != 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.isMasked = bool1;
      if (this.isMasked != this.isClient) {
        break;
      }
      throw new ProtocolException("Client-sent frames must be masked. Server sent must not.");
    }
    this.frameLength = (WebSocketProtocol.B1_MASK_LENGTH & i);
    if (this.frameLength == 126L) {
      this.frameLength = (this.source.readShort() & 0xFFFF);
    }
    do
    {
      do
      {
        this.frameBytesRead = 0L;
        if ((!this.isControlFrame) || (this.frameLength <= 125L)) {
          break;
        }
        throw new ProtocolException("Control frame must be less than 125B.");
      } while (this.frameLength != 127L);
      this.frameLength = this.source.readLong();
    } while (this.frameLength >= 0L);
    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    if (this.isMasked) {
      this.source.readFully(this.maskKey);
    }
  }
  
  private void readMessageFrame()
    throws IOException
  {
    switch (this.opcode)
    {
    default: 
      throw new ProtocolException("Unknown opcode: " + Integer.toHexString(this.opcode));
    }
    for (WebSocket.PayloadType localPayloadType = WebSocket.PayloadType.TEXT;; localPayloadType = WebSocket.PayloadType.BINARY)
    {
      this.messageClosed = false;
      this.frameCallback.onMessage(Okio.buffer(this.framedMessageSource), localPayloadType);
      if (this.messageClosed) {
        break;
      }
      throw new IllegalStateException("Listener failed to call close on message payload.");
    }
  }
  
  private void readUntilNonControlFrame()
    throws IOException
  {
    for (;;)
    {
      if (this.closed) {}
      do
      {
        return;
        readHeader();
      } while (!this.isControlFrame);
      readControlFrame();
    }
  }
  
  public void processNextFrame()
    throws IOException
  {
    readHeader();
    if (this.isControlFrame)
    {
      readControlFrame();
      return;
    }
    readMessageFrame();
  }
  
  public static abstract interface FrameCallback
  {
    public abstract void onClose(int paramInt, String paramString);
    
    public abstract void onMessage(BufferedSource paramBufferedSource, WebSocket.PayloadType paramPayloadType)
      throws IOException;
    
    public abstract void onPing(Buffer paramBuffer);
    
    public abstract void onPong(Buffer paramBuffer);
  }
  
  private final class FramedMessageSource
    implements Source
  {
    private FramedMessageSource() {}
    
    public void close()
      throws IOException
    {
      if (WebSocketReader.this.messageClosed) {}
      for (;;)
      {
        return;
        WebSocketReader.this.messageClosed = true;
        if (!WebSocketReader.this.closed)
        {
          WebSocketReader.this.source.skip(WebSocketReader.this.frameLength - WebSocketReader.this.frameBytesRead);
          while (!WebSocketReader.this.isFinalFrame)
          {
            WebSocketReader.this.readUntilNonControlFrame();
            WebSocketReader.this.source.skip(WebSocketReader.this.frameLength);
          }
        }
      }
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (WebSocketReader.this.closed) {
        throw new IOException("closed");
      }
      if (WebSocketReader.this.messageClosed) {
        throw new IllegalStateException("closed");
      }
      if (WebSocketReader.this.frameBytesRead == WebSocketReader.this.frameLength)
      {
        if (WebSocketReader.this.isFinalFrame) {
          return -1L;
        }
        WebSocketReader.this.readUntilNonControlFrame();
        if (WebSocketReader.this.opcode != 0) {
          throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(WebSocketReader.this.opcode));
        }
        if ((WebSocketReader.this.isFinalFrame) && (WebSocketReader.this.frameLength == 0L)) {
          return -1L;
        }
      }
      paramLong = Math.min(paramLong, WebSocketReader.this.frameLength - WebSocketReader.this.frameBytesRead);
      if (WebSocketReader.this.isMasked)
      {
        paramLong = Math.min(paramLong, WebSocketReader.this.maskBuffer.length);
        paramLong = WebSocketReader.this.source.read(WebSocketReader.this.maskBuffer, 0, (int)paramLong);
        if (paramLong == -1L) {
          throw new EOFException();
        }
        WebSocketProtocol.toggleMask(WebSocketReader.this.maskBuffer, paramLong, WebSocketReader.this.maskKey, WebSocketReader.this.frameBytesRead);
        paramBuffer.write(WebSocketReader.this.maskBuffer, 0, (int)paramLong);
      }
      long l;
      do
      {
        paramBuffer = WebSocketReader.this;
        paramBuffer.frameBytesRead += paramLong;
        return paramLong;
        l = WebSocketReader.this.source.read(paramBuffer, paramLong);
        paramLong = l;
      } while (l != -1L);
      throw new EOFException();
    }
    
    public Timeout timeout()
    {
      return WebSocketReader.this.source.timeout();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\ws\WebSocketReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */