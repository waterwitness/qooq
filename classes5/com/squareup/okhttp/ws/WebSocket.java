package com.squareup.okhttp.ws;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;

public abstract interface WebSocket
{
  public abstract void close(int paramInt, String paramString)
    throws IOException;
  
  public abstract BufferedSink newMessageSink(PayloadType paramPayloadType);
  
  public abstract void sendMessage(PayloadType paramPayloadType, Buffer paramBuffer)
    throws IOException;
  
  public abstract void sendPing(Buffer paramBuffer)
    throws IOException;
  
  public static enum PayloadType
  {
    TEXT,  BINARY;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\ws\WebSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */