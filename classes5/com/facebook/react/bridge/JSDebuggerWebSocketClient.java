package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocket.PayloadType;
import com.squareup.okhttp.ws.WebSocketCall;
import com.squareup.okhttp.ws.WebSocketListener;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import okio.Buffer;

public class JSDebuggerWebSocketClient
  implements WebSocketListener
{
  private static final String TAG = "JSDebuggerWebSocketClient";
  private static final JsonFactory mJsonFactory = new JsonFactory();
  private final ConcurrentHashMap<Integer, JSDebuggerCallback> mCallbacks = new ConcurrentHashMap();
  @Nullable
  private JSDebuggerCallback mConnectCallback;
  @Nullable
  private OkHttpClient mHttpClient;
  private final AtomicInteger mRequestID = new AtomicInteger();
  @Nullable
  private WebSocket mWebSocket;
  
  private void abort(String paramString, Throwable paramThrowable)
  {
    if (FLog.isLoggable(6)) {
      FLog.e("JSDebuggerWebSocketClient", "Error occurred, shutting down websocket connection: " + paramString, paramThrowable);
    }
    closeQuietly();
    if (this.mConnectCallback != null)
    {
      this.mConnectCallback.onFailure(paramThrowable);
      this.mConnectCallback = null;
    }
    paramString = this.mCallbacks.values().iterator();
    while (paramString.hasNext()) {
      ((JSDebuggerCallback)paramString.next()).onFailure(paramThrowable);
    }
    this.mCallbacks.clear();
  }
  
  private String endMessageObject(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeEndObject();
    paramJsonGenerator.flush();
    return ((StringWriter)paramJsonGenerator.getOutputTarget()).getBuffer().toString();
  }
  
  private void sendMessage(int paramInt, String paramString)
  {
    if (this.mWebSocket == null)
    {
      triggerRequestFailure(paramInt, new IllegalStateException("WebSocket connection no longer valid"));
      return;
    }
    Buffer localBuffer = new Buffer();
    localBuffer.writeUtf8(paramString);
    try
    {
      this.mWebSocket.sendMessage(WebSocket.PayloadType.TEXT, localBuffer);
      return;
    }
    catch (IOException paramString)
    {
      triggerRequestFailure(paramInt, paramString);
    }
  }
  
  private JsonGenerator startMessageObject(int paramInt)
    throws IOException
  {
    JsonGenerator localJsonGenerator = mJsonFactory.createGenerator(new StringWriter());
    localJsonGenerator.writeStartObject();
    localJsonGenerator.writeNumberField("id", paramInt);
    return localJsonGenerator;
  }
  
  private void triggerRequestFailure(int paramInt, Throwable paramThrowable)
  {
    JSDebuggerCallback localJSDebuggerCallback = (JSDebuggerCallback)this.mCallbacks.get(Integer.valueOf(paramInt));
    if (localJSDebuggerCallback != null)
    {
      this.mCallbacks.remove(Integer.valueOf(paramInt));
      localJSDebuggerCallback.onFailure(paramThrowable);
    }
  }
  
  private void triggerRequestSuccess(int paramInt, @Nullable String paramString)
  {
    JSDebuggerCallback localJSDebuggerCallback = (JSDebuggerCallback)this.mCallbacks.get(Integer.valueOf(paramInt));
    if (localJSDebuggerCallback != null)
    {
      this.mCallbacks.remove(Integer.valueOf(paramInt));
      localJSDebuggerCallback.onSuccess(paramString);
    }
  }
  
  public void closeQuietly()
  {
    if (this.mWebSocket != null) {}
    try
    {
      this.mWebSocket.close(1000, "End of session");
      this.mWebSocket = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public void connect(String paramString, JSDebuggerCallback paramJSDebuggerCallback)
  {
    if (this.mHttpClient != null) {
      throw new IllegalStateException("JSDebuggerWebSocketClient is already initialized.");
    }
    this.mConnectCallback = paramJSDebuggerCallback;
    this.mHttpClient = new OkHttpClient();
    this.mHttpClient.setConnectTimeout(10L, TimeUnit.SECONDS);
    this.mHttpClient.setWriteTimeout(10L, TimeUnit.SECONDS);
    this.mHttpClient.setReadTimeout(0L, TimeUnit.MINUTES);
    paramString = new Request.Builder().url(paramString).build();
    WebSocketCall.create(this.mHttpClient, paramString).enqueue(this);
  }
  
  public void executeApplicationScript(String paramString, HashMap<String, String> paramHashMap, JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    try
    {
      paramJSDebuggerCallback = startMessageObject(i);
      paramJSDebuggerCallback.writeStringField("method", "executeApplicationScript");
      paramJSDebuggerCallback.writeStringField("url", paramString);
      paramJSDebuggerCallback.writeObjectFieldStart("inject");
      paramString = paramHashMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramJSDebuggerCallback.writeObjectField(str, paramHashMap.get(str));
      }
      paramJSDebuggerCallback.writeEndObject();
    }
    catch (IOException paramString)
    {
      triggerRequestFailure(i, paramString);
      return;
    }
    sendMessage(i, endMessageObject(paramJSDebuggerCallback));
  }
  
  public void executeJSCall(String paramString1, String paramString2, JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    try
    {
      paramJSDebuggerCallback = startMessageObject(i);
      paramJSDebuggerCallback.writeStringField("method", paramString1);
      paramJSDebuggerCallback.writeFieldName("arguments");
      paramJSDebuggerCallback.writeRawValue(paramString2);
      sendMessage(i, endMessageObject(paramJSDebuggerCallback));
      return;
    }
    catch (IOException paramString1)
    {
      triggerRequestFailure(i, paramString1);
    }
  }
  
  public void onClose(int paramInt, String paramString)
  {
    this.mWebSocket = null;
  }
  
  public void onFailure(IOException paramIOException, Response paramResponse)
  {
    abort("Websocket exception", paramIOException);
  }
  
  /* Error */
  public void onMessage(okio.BufferedSource paramBufferedSource, WebSocket.PayloadType paramPayloadType)
    throws IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: getstatic 158	com/squareup/okhttp/ws/WebSocket$PayloadType:TEXT	Lcom/squareup/okhttp/ws/WebSocket$PayloadType;
    //   4: if_acmpeq +36 -> 40
    //   7: iconst_5
    //   8: invokestatic 56	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   11: ifeq +28 -> 39
    //   14: ldc 13
    //   16: new 58	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 320
    //   26: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 326	com/facebook/common/logging/FLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: return
    //   40: aload_1
    //   41: invokeinterface 331 1 0
    //   46: astore_3
    //   47: aload_1
    //   48: invokeinterface 333 1 0
    //   53: aconst_null
    //   54: astore_2
    //   55: aconst_null
    //   56: astore_1
    //   57: new 31	com/fasterxml/jackson/core/JsonFactory
    //   60: dup
    //   61: invokespecial 34	com/fasterxml/jackson/core/JsonFactory:<init>	()V
    //   64: aload_3
    //   65: invokevirtual 337	com/fasterxml/jackson/core/JsonFactory:createParser	(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;
    //   68: astore 4
    //   70: aconst_null
    //   71: astore_3
    //   72: aload_1
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 343	com/fasterxml/jackson/core/JsonParser:nextToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   79: getstatic 349	com/fasterxml/jackson/core/JsonToken:END_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   82: if_acmpeq +92 -> 174
    //   85: aload_1
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 352	com/fasterxml/jackson/core/JsonParser:getCurrentName	()Ljava/lang/String;
    //   92: astore 5
    //   94: aload_1
    //   95: astore_2
    //   96: ldc_w 354
    //   99: aload 5
    //   101: invokevirtual 358	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: ifeq +38 -> 142
    //   107: aload_1
    //   108: astore_2
    //   109: aload 4
    //   111: invokevirtual 343	com/fasterxml/jackson/core/JsonParser:nextToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   114: pop
    //   115: aload_1
    //   116: astore_2
    //   117: aload 4
    //   119: invokevirtual 361	com/fasterxml/jackson/core/JsonParser:getIntValue	()I
    //   122: istore 6
    //   124: iload 6
    //   126: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: astore_1
    //   130: goto -58 -> 72
    //   133: astore_2
    //   134: aload_1
    //   135: invokeinterface 333 1 0
    //   140: aload_2
    //   141: athrow
    //   142: aload_1
    //   143: astore_2
    //   144: ldc_w 363
    //   147: aload 5
    //   149: invokevirtual 358	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifeq -80 -> 72
    //   155: aload_1
    //   156: astore_2
    //   157: aload 4
    //   159: invokevirtual 343	com/fasterxml/jackson/core/JsonParser:nextToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   162: pop
    //   163: aload_1
    //   164: astore_2
    //   165: aload 4
    //   167: invokevirtual 366	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   170: astore_3
    //   171: goto -99 -> 72
    //   174: aload_1
    //   175: ifnull -136 -> 39
    //   178: aload_1
    //   179: astore_2
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual 369	java/lang/Integer:intValue	()I
    //   185: aload_3
    //   186: invokespecial 371	com/facebook/react/bridge/JSDebuggerWebSocketClient:triggerRequestSuccess	(ILjava/lang/String;)V
    //   189: return
    //   190: astore_1
    //   191: aload_2
    //   192: ifnull +13 -> 205
    //   195: aload_0
    //   196: aload_2
    //   197: invokevirtual 369	java/lang/Integer:intValue	()I
    //   200: aload_1
    //   201: invokespecial 145	com/facebook/react/bridge/JSDebuggerWebSocketClient:triggerRequestFailure	(ILjava/lang/Throwable;)V
    //   204: return
    //   205: aload_0
    //   206: ldc_w 373
    //   209: aload_1
    //   210: invokespecial 316	com/facebook/react/bridge/JSDebuggerWebSocketClient:abort	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	JSDebuggerWebSocketClient
    //   0	214	1	paramBufferedSource	okio.BufferedSource
    //   0	214	2	paramPayloadType	WebSocket.PayloadType
    //   46	140	3	str1	String
    //   68	98	4	localJsonParser	com.fasterxml.jackson.core.JsonParser
    //   92	56	5	str2	String
    //   122	3	6	i	int
    // Exception table:
    //   from	to	target	type
    //   40	47	133	finally
    //   57	70	190	java/io/IOException
    //   74	85	190	java/io/IOException
    //   87	94	190	java/io/IOException
    //   96	107	190	java/io/IOException
    //   109	115	190	java/io/IOException
    //   117	124	190	java/io/IOException
    //   144	155	190	java/io/IOException
    //   157	163	190	java/io/IOException
    //   165	171	190	java/io/IOException
    //   180	189	190	java/io/IOException
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.mWebSocket = paramWebSocket;
    ((JSDebuggerCallback)Assertions.assertNotNull(this.mConnectCallback)).onSuccess(null);
    this.mConnectCallback = null;
  }
  
  public void onPong(Buffer paramBuffer) {}
  
  public void prepareJSRuntime(JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    try
    {
      paramJSDebuggerCallback = startMessageObject(i);
      paramJSDebuggerCallback.writeStringField("method", "prepareJSRuntime");
      sendMessage(i, endMessageObject(paramJSDebuggerCallback));
      return;
    }
    catch (IOException paramJSDebuggerCallback)
    {
      triggerRequestFailure(i, paramJSDebuggerCallback);
    }
  }
  
  public static abstract interface JSDebuggerCallback
  {
    public abstract void onFailure(Throwable paramThrowable);
    
    public abstract void onSuccess(@Nullable String paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\JSDebuggerWebSocketClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */