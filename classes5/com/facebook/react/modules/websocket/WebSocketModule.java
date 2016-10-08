package com.facebook.react.modules.websocket;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocket.PayloadType;
import com.squareup.okhttp.ws.WebSocketCall;
import com.squareup.okhttp.ws.WebSocketListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import okio.Buffer;

public class WebSocketModule
  extends ReactContextBaseJavaModule
{
  private ReactContext mReactContext;
  private Map<Integer, WebSocket> mWebSocketConnections = new HashMap();
  
  public WebSocketModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mReactContext = paramReactApplicationContext;
  }
  
  private void notifyWebSocketFailed(int paramInt, String paramString)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("id", paramInt);
    localWritableMap.putString("message", paramString);
    sendEvent("websocketFailed", localWritableMap);
  }
  
  private void sendEvent(String paramString, WritableMap paramWritableMap)
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(paramString, paramWritableMap);
  }
  
  @ReactMethod
  public void close(int paramInt1, String paramString, int paramInt2)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt2));
    if (localWebSocket == null) {
      if (FLog.isLoggable(5)) {
        FLog.w("React", "Cannot close WebSocket. Unknown WebSocket id " + paramInt2);
      }
    }
    do
    {
      return;
      try
      {
        localWebSocket.close(paramInt1, paramString);
        this.mWebSocketConnections.remove(Integer.valueOf(paramInt2));
        return;
      }
      catch (Exception paramString) {}
    } while (!FLog.isLoggable(6));
    FLog.e("React", "Could not close WebSocket connection for id " + paramInt2, paramString);
  }
  
  @ReactMethod
  public void connect(String paramString, final int paramInt)
  {
    OkHttpClient localOkHttpClient = new OkHttpClient();
    localOkHttpClient.setConnectTimeout(10L, TimeUnit.SECONDS);
    localOkHttpClient.setWriteTimeout(10L, TimeUnit.SECONDS);
    localOkHttpClient.setReadTimeout(0L, TimeUnit.MINUTES);
    WebSocketCall.create(localOkHttpClient, new Request.Builder().tag(Integer.valueOf(paramInt)).url(paramString).build()).enqueue(new WebSocketListener()
    {
      public void onClose(int paramAnonymousInt, String paramAnonymousString)
      {
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putInt("id", paramInt);
        localWritableMap.putInt("code", paramAnonymousInt);
        localWritableMap.putString("reason", paramAnonymousString);
        WebSocketModule.this.sendEvent("websocketClosed", localWritableMap);
      }
      
      public void onFailure(IOException paramAnonymousIOException, Response paramAnonymousResponse)
      {
        WebSocketModule.this.notifyWebSocketFailed(paramInt, paramAnonymousIOException.getMessage());
      }
      
      /* Error */
      public void onMessage(okio.BufferedSource paramAnonymousBufferedSource, WebSocket.PayloadType paramAnonymousPayloadType)
      {
        // Byte code:
        //   0: aload_1
        //   1: invokeinterface 73 1 0
        //   6: astore_2
        //   7: aload_1
        //   8: invokeinterface 76 1 0
        //   13: invokestatic 33	com/facebook/react/bridge/Arguments:createMap	()Lcom/facebook/react/bridge/WritableMap;
        //   16: astore_1
        //   17: aload_1
        //   18: ldc 35
        //   20: aload_0
        //   21: getfield 21	com/facebook/react/modules/websocket/WebSocketModule$1:val$id	I
        //   24: invokeinterface 40 3 0
        //   29: aload_1
        //   30: ldc 78
        //   32: aload_2
        //   33: invokeinterface 48 3 0
        //   38: aload_0
        //   39: getfield 19	com/facebook/react/modules/websocket/WebSocketModule$1:this$0	Lcom/facebook/react/modules/websocket/WebSocketModule;
        //   42: ldc 80
        //   44: aload_1
        //   45: invokestatic 54	com/facebook/react/modules/websocket/WebSocketModule:access$100	(Lcom/facebook/react/modules/websocket/WebSocketModule;Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V
        //   48: return
        //   49: astore_1
        //   50: aload_0
        //   51: getfield 19	com/facebook/react/modules/websocket/WebSocketModule$1:this$0	Lcom/facebook/react/modules/websocket/WebSocketModule;
        //   54: aload_0
        //   55: getfield 21	com/facebook/react/modules/websocket/WebSocketModule$1:val$id	I
        //   58: aload_1
        //   59: invokevirtual 62	java/io/IOException:getMessage	()Ljava/lang/String;
        //   62: invokestatic 66	com/facebook/react/modules/websocket/WebSocketModule:access$200	(Lcom/facebook/react/modules/websocket/WebSocketModule;ILjava/lang/String;)V
        //   65: return
        //   66: astore_1
        //   67: bipush 6
        //   69: invokestatic 86	com/facebook/common/logging/FLog:isLoggable	(I)Z
        //   72: ifeq -59 -> 13
        //   75: ldc 88
        //   77: new 90	java/lang/StringBuilder
        //   80: dup
        //   81: invokespecial 91	java/lang/StringBuilder:<init>	()V
        //   84: ldc 93
        //   86: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   89: aload_0
        //   90: getfield 21	com/facebook/react/modules/websocket/WebSocketModule$1:val$id	I
        //   93: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   96: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   99: aload_1
        //   100: invokestatic 107	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   103: goto -90 -> 13
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	1
        //   0	106	1	paramAnonymousBufferedSource	okio.BufferedSource
        //   0	106	2	paramAnonymousPayloadType	WebSocket.PayloadType
        // Exception table:
        //   from	to	target	type
        //   0	7	49	java/io/IOException
        //   7	13	66	java/io/IOException
      }
      
      public void onOpen(WebSocket paramAnonymousWebSocket, Response paramAnonymousResponse)
      {
        WebSocketModule.this.mWebSocketConnections.put(Integer.valueOf(paramInt), paramAnonymousWebSocket);
        paramAnonymousWebSocket = Arguments.createMap();
        paramAnonymousWebSocket.putInt("id", paramInt);
        WebSocketModule.this.sendEvent("websocketOpen", paramAnonymousWebSocket);
      }
      
      public void onPong(Buffer paramAnonymousBuffer) {}
    });
    localOkHttpClient.getDispatcher().getExecutorService().shutdown();
  }
  
  public String getName()
  {
    return "WebSocketModule";
  }
  
  @ReactMethod
  public void send(String paramString, int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null) {
      throw new RuntimeException("Cannot send a message. Unknown WebSocket id " + paramInt);
    }
    try
    {
      localWebSocket.sendMessage(WebSocket.PayloadType.TEXT, new Buffer().writeUtf8(paramString));
      return;
    }
    catch (IOException paramString)
    {
      notifyWebSocketFailed(paramInt, paramString.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\websocket\WebSocketModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */