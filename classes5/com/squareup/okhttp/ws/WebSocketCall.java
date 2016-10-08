package com.squareup.okhttp.ws;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.ws.RealWebSocket;
import java.io.IOException;
import java.net.ProtocolException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public final class WebSocketCall
{
  private final Call call;
  private final String key;
  private final Random random;
  private final Request request;
  
  WebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this(paramOkHttpClient, paramRequest, new SecureRandom());
  }
  
  WebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest, Random paramRandom)
  {
    if (!"GET".equals(paramRequest.method())) {
      throw new IllegalArgumentException("Request must be GET: " + paramRequest.method());
    }
    this.random = paramRandom;
    byte[] arrayOfByte = new byte[16];
    paramRandom.nextBytes(arrayOfByte);
    this.key = ByteString.of(arrayOfByte).base64();
    paramOkHttpClient = paramOkHttpClient.clone();
    paramOkHttpClient.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
    paramRequest = paramRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
    this.request = paramRequest;
    this.call = paramOkHttpClient.newCall(paramRequest);
  }
  
  public static WebSocketCall create(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    return new WebSocketCall(paramOkHttpClient, paramRequest);
  }
  
  private void createWebSocket(Response paramResponse, WebSocketListener paramWebSocketListener)
    throws IOException
  {
    if (paramResponse.code() != 101)
    {
      Internal.instance.callEngineReleaseConnection(this.call);
      throw new ProtocolException("Expected HTTP 101 response but was '" + paramResponse.code() + " " + paramResponse.message() + "'");
    }
    Object localObject1 = paramResponse.header("Connection");
    if (!"Upgrade".equalsIgnoreCase((String)localObject1)) {
      throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + (String)localObject1 + "'");
    }
    localObject1 = paramResponse.header("Upgrade");
    if (!"websocket".equalsIgnoreCase((String)localObject1)) {
      throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + (String)localObject1 + "'");
    }
    localObject1 = paramResponse.header("Sec-WebSocket-Accept");
    Object localObject2 = Util.shaBase64(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    if (!((String)localObject2).equals(localObject1)) {
      throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + (String)localObject2 + "' but was '" + (String)localObject1 + "'");
    }
    localObject1 = Internal.instance.callEngineGetConnection(this.call);
    if (!Internal.instance.clearOwner((Connection)localObject1)) {
      throw new IllegalStateException("Unable to take ownership of connection.");
    }
    localObject2 = ConnectionWebSocket.create(paramResponse, (Connection)localObject1, Internal.instance.connectionRawSource((Connection)localObject1), Internal.instance.connectionRawSink((Connection)localObject1), this.random, paramWebSocketListener);
    Internal.instance.connectionSetOwner((Connection)localObject1, localObject2);
    paramWebSocketListener.onOpen((WebSocket)localObject2, paramResponse);
    while (((RealWebSocket)localObject2).readMessage()) {}
  }
  
  public void cancel()
  {
    this.call.cancel();
  }
  
  public void enqueue(final WebSocketListener paramWebSocketListener)
  {
    paramWebSocketListener = new Callback()
    {
      public void onFailure(Request paramAnonymousRequest, IOException paramAnonymousIOException)
      {
        paramWebSocketListener.onFailure(paramAnonymousIOException, null);
      }
      
      public void onResponse(Response paramAnonymousResponse)
        throws IOException
      {
        try
        {
          WebSocketCall.this.createWebSocket(paramAnonymousResponse, paramWebSocketListener);
          return;
        }
        catch (IOException localIOException)
        {
          paramWebSocketListener.onFailure(localIOException, paramAnonymousResponse);
        }
      }
    };
    Internal.instance.callEnqueue(this.call, paramWebSocketListener, true);
  }
  
  private static class ConnectionWebSocket
    extends RealWebSocket
  {
    private final Connection connection;
    
    private ConnectionWebSocket(Connection paramConnection, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink, Random paramRandom, Executor paramExecutor, WebSocketListener paramWebSocketListener, String paramString)
    {
      super(paramBufferedSource, paramBufferedSink, paramRandom, paramExecutor, paramWebSocketListener, paramString);
      this.connection = paramConnection;
    }
    
    static RealWebSocket create(Response paramResponse, Connection paramConnection, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink, Random paramRandom, WebSocketListener paramWebSocketListener)
    {
      paramResponse = paramResponse.request().urlString();
      ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), Util.threadFactory(String.format("OkHttp %s WebSocket", new Object[] { paramResponse }), true));
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
      return new ConnectionWebSocket(paramConnection, paramBufferedSource, paramBufferedSink, paramRandom, localThreadPoolExecutor, paramWebSocketListener, paramResponse);
    }
    
    protected void closeConnection()
      throws IOException
    {
      Internal.instance.closeIfOwnedBy(this.connection, this);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\ws\WebSocketCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */