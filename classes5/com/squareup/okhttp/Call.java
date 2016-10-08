package com.squareup.okhttp;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;

public class Call
{
  volatile boolean canceled;
  private final OkHttpClient client;
  HttpEngine engine;
  private boolean executed;
  Request originalRequest;
  
  protected Call(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this.client = paramOkHttpClient.copyWithDefaults();
    this.originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean)
    throws IOException
  {
    return new ApplicationInterceptorChain(0, this.originalRequest, paramBoolean).proceed(this.originalRequest);
  }
  
  private String toLoggableString()
  {
    if (this.canceled) {}
    for (String str = "canceled call";; str = "call")
    {
      HttpUrl localHttpUrl = this.originalRequest.httpUrl().resolve("/...");
      return str + " to " + localHttpUrl;
    }
  }
  
  public void cancel()
  {
    this.canceled = true;
    if (this.engine != null) {
      this.engine.disconnect();
    }
  }
  
  public void enqueue(Callback paramCallback)
  {
    enqueue(paramCallback, false);
  }
  
  void enqueue(Callback paramCallback, boolean paramBoolean)
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    this.client.getDispatcher().enqueue(new AsyncCall(paramCallback, paramBoolean, null));
  }
  
  public Response execute()
    throws IOException
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    try
    {
      this.client.getDispatcher().executed(this);
      Response localResponse1 = getResponseWithInterceptorChain(false);
      if (localResponse1 == null) {
        throw new IOException("Canceled");
      }
    }
    finally
    {
      this.client.getDispatcher().finished(this);
    }
    this.client.getDispatcher().finished(this);
    return localResponse2;
  }
  
  Response getResponse(Request paramRequest, boolean paramBoolean)
    throws IOException
  {
    Object localObject2 = paramRequest.body();
    Object localObject1 = paramRequest;
    int i;
    if (localObject2 != null)
    {
      paramRequest = paramRequest.newBuilder();
      localObject1 = ((RequestBody)localObject2).contentType();
      if (localObject1 != null) {
        paramRequest.header("Content-Type", ((MediaType)localObject1).toString());
      }
      long l = ((RequestBody)localObject2).contentLength();
      if (l != -1L)
      {
        paramRequest.header("Content-Length", Long.toString(l));
        paramRequest.removeHeader("Transfer-Encoding");
        localObject1 = paramRequest.build();
      }
    }
    else
    {
      this.engine = new HttpEngine(this.client, (Request)localObject1, false, false, paramBoolean, null, null, null, null);
      i = 0;
    }
    for (;;)
    {
      if (this.canceled)
      {
        this.engine.releaseConnection();
        throw new IOException("Canceled");
        paramRequest.header("Transfer-Encoding", "chunked");
        paramRequest.removeHeader("Content-Length");
        break;
      }
      try
      {
        this.engine.sendRequest();
        this.engine.readResponse();
        paramRequest = this.engine.getResponse();
        localObject1 = this.engine.followUpRequest();
        if (localObject1 == null)
        {
          if (!paramBoolean) {
            this.engine.releaseConnection();
          }
          return paramRequest;
        }
      }
      catch (RequestException paramRequest)
      {
        throw paramRequest.getCause();
      }
      catch (RouteException paramRequest)
      {
        localObject1 = this.engine.recover(paramRequest);
        if (localObject1 != null)
        {
          this.engine = ((HttpEngine)localObject1);
          continue;
        }
        throw paramRequest.getLastConnectException();
      }
      catch (IOException paramRequest)
      {
        localObject1 = this.engine.recover(paramRequest, null);
        if (localObject1 != null)
        {
          this.engine = ((HttpEngine)localObject1);
          continue;
        }
        throw paramRequest;
      }
      i += 1;
      if (i > 20) {
        throw new ProtocolException("Too many follow-up requests: " + i);
      }
      if (!this.engine.sameConnection(((Request)localObject1).httpUrl())) {
        this.engine.releaseConnection();
      }
      localObject2 = this.engine.close();
      this.engine = new HttpEngine(this.client, (Request)localObject1, false, false, paramBoolean, (Connection)localObject2, null, null, paramRequest);
    }
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  Object tag()
  {
    return this.originalRequest.tag();
  }
  
  class ApplicationInterceptorChain
    implements Interceptor.Chain
  {
    private final boolean forWebSocket;
    private final int index;
    private final Request request;
    
    ApplicationInterceptorChain(int paramInt, Request paramRequest, boolean paramBoolean)
    {
      this.index = paramInt;
      this.request = paramRequest;
      this.forWebSocket = paramBoolean;
    }
    
    public Connection connection()
    {
      return null;
    }
    
    public Response proceed(Request paramRequest)
      throws IOException
    {
      if (this.index < Call.this.client.interceptors().size())
      {
        paramRequest = new ApplicationInterceptorChain(Call.this, this.index + 1, paramRequest, this.forWebSocket);
        return ((Interceptor)Call.this.client.interceptors().get(this.index)).intercept(paramRequest);
      }
      return Call.this.getResponse(paramRequest, this.forWebSocket);
    }
    
    public Request request()
    {
      return this.request;
    }
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final boolean forWebSocket;
    private final Callback responseCallback;
    
    private AsyncCall(Callback paramCallback, boolean paramBoolean)
    {
      super(new Object[] { Call.this.originalRequest.urlString() });
      this.responseCallback = paramCallback;
      this.forWebSocket = paramBoolean;
    }
    
    void cancel()
    {
      Call.this.cancel();
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: iload_3
      //   3: istore_2
      //   4: aload_0
      //   5: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   8: aload_0
      //   9: getfield 38	com/squareup/okhttp/Call$AsyncCall:forWebSocket	Z
      //   12: invokestatic 53	com/squareup/okhttp/Call:access$1	(Lcom/squareup/okhttp/Call;Z)Lcom/squareup/okhttp/Response;
      //   15: astore_1
      //   16: iload_3
      //   17: istore_2
      //   18: aload_0
      //   19: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   22: getfield 56	com/squareup/okhttp/Call:canceled	Z
      //   25: ifeq +45 -> 70
      //   28: iconst_1
      //   29: istore_2
      //   30: aload_0
      //   31: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   34: aload_0
      //   35: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   38: getfield 25	com/squareup/okhttp/Call:originalRequest	Lcom/squareup/okhttp/Request;
      //   41: new 49	java/io/IOException
      //   44: dup
      //   45: ldc 58
      //   47: invokespecial 61	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   50: invokeinterface 67 3 0
      //   55: aload_0
      //   56: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   59: invokestatic 71	com/squareup/okhttp/Call:access$0	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   62: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   65: aload_0
      //   66: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   69: return
      //   70: iconst_1
      //   71: istore_2
      //   72: aload_0
      //   73: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   76: aload_1
      //   77: invokeinterface 87 2 0
      //   82: goto -27 -> 55
      //   85: astore_1
      //   86: iload_2
      //   87: ifeq +50 -> 137
      //   90: getstatic 93	com/squareup/okhttp/internal/Internal:logger	Ljava/util/logging/Logger;
      //   93: getstatic 99	java/util/logging/Level:INFO	Ljava/util/logging/Level;
      //   96: new 101	java/lang/StringBuilder
      //   99: dup
      //   100: ldc 103
      //   102: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   105: aload_0
      //   106: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   109: invokestatic 108	com/squareup/okhttp/Call:access$2	(Lcom/squareup/okhttp/Call;)Ljava/lang/String;
      //   112: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   115: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   118: aload_1
      //   119: invokevirtual 121	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   122: aload_0
      //   123: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   126: invokestatic 71	com/squareup/okhttp/Call:access$0	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   129: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   132: aload_0
      //   133: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   136: return
      //   137: aload_0
      //   138: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   141: aload_0
      //   142: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   145: getfield 125	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
      //   148: invokevirtual 131	com/squareup/okhttp/internal/http/HttpEngine:getRequest	()Lcom/squareup/okhttp/Request;
      //   151: aload_1
      //   152: invokeinterface 67 3 0
      //   157: goto -35 -> 122
      //   160: astore_1
      //   161: aload_0
      //   162: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   165: invokestatic 71	com/squareup/okhttp/Call:access$0	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   168: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   171: aload_0
      //   172: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   175: aload_1
      //   176: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	177	0	this	AsyncCall
      //   15	62	1	localResponse	Response
      //   85	67	1	localIOException	IOException
      //   160	16	1	localObject	Object
      //   3	84	2	i	int
      //   1	16	3	j	int
      // Exception table:
      //   from	to	target	type
      //   4	16	85	java/io/IOException
      //   18	28	85	java/io/IOException
      //   30	55	85	java/io/IOException
      //   72	82	85	java/io/IOException
      //   4	16	160	finally
      //   18	28	160	finally
      //   30	55	160	finally
      //   72	82	160	finally
      //   90	122	160	finally
      //   137	157	160	finally
    }
    
    Call get()
    {
      return Call.this;
    }
    
    String host()
    {
      return Call.this.originalRequest.httpUrl().host();
    }
    
    Request request()
    {
      return Call.this.originalRequest;
    }
    
    Object tag()
    {
      return Call.this.originalRequest.tag();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */