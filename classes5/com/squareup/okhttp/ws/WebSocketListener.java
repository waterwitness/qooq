package com.squareup.okhttp.ws;

import com.squareup.okhttp.Response;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;

public abstract interface WebSocketListener
{
  public abstract void onClose(int paramInt, String paramString);
  
  public abstract void onFailure(IOException paramIOException, Response paramResponse);
  
  public abstract void onMessage(BufferedSource paramBufferedSource, WebSocket.PayloadType paramPayloadType)
    throws IOException;
  
  public abstract void onOpen(WebSocket paramWebSocket, Response paramResponse);
  
  public abstract void onPong(Buffer paramBuffer);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\ws\WebSocketListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */