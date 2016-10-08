package com.facebook.react.bridge;

import android.os.Handler;
import android.os.Looper;
import com.facebook.infer.annotation.Assertions;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public class WebsocketJavaScriptExecutor
  implements JavaJSExecutor
{
  private static final int CONNECT_RETRY_COUNT = 3;
  private static final long CONNECT_TIMEOUT_MS = 5000L;
  private final HashMap<String, String> mInjectedObjects = new HashMap();
  @Nullable
  private JSDebuggerWebSocketClient mWebSocketClient;
  
  private void connectInternal(String paramString, final JSExecutorConnectCallback paramJSExecutorConnectCallback)
  {
    final JSDebuggerWebSocketClient localJSDebuggerWebSocketClient = new JSDebuggerWebSocketClient();
    final Handler localHandler = new Handler(Looper.getMainLooper());
    localJSDebuggerWebSocketClient.connect(paramString, new JSDebuggerWebSocketClient.JSDebuggerCallback()
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        paramJSExecutorConnectCallback.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(@Nullable String paramAnonymousString)
      {
        localJSDebuggerWebSocketClient.prepareJSRuntime(new JSDebuggerWebSocketClient.JSDebuggerCallback()
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            WebsocketJavaScriptExecutor.2.this.val$timeoutHandler.removeCallbacksAndMessages(null);
            WebsocketJavaScriptExecutor.2.this.val$callback.onFailure(paramAnonymous2Throwable);
          }
          
          public void onSuccess(@Nullable String paramAnonymous2String)
          {
            WebsocketJavaScriptExecutor.2.this.val$timeoutHandler.removeCallbacksAndMessages(null);
            WebsocketJavaScriptExecutor.access$102(WebsocketJavaScriptExecutor.this, WebsocketJavaScriptExecutor.2.this.val$client);
            WebsocketJavaScriptExecutor.2.this.val$callback.onSuccess();
          }
        });
      }
    });
    localHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        localJSDebuggerWebSocketClient.closeQuietly();
        paramJSExecutorConnectCallback.onFailure(new WebsocketJavaScriptExecutor.WebsocketExecutorTimeoutException("Timeout while connecting to remote debugger"));
      }
    }, 5000L);
  }
  
  public void close()
  {
    if (this.mWebSocketClient != null) {
      this.mWebSocketClient.closeQuietly();
    }
  }
  
  public void connect(final String paramString, final JSExecutorConnectCallback paramJSExecutorConnectCallback)
  {
    connectInternal(paramString, new JSExecutorConnectCallback()
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        if (this.val$retryCount.decrementAndGet() <= 0)
        {
          paramJSExecutorConnectCallback.onFailure(paramAnonymousThrowable);
          return;
        }
        WebsocketJavaScriptExecutor.this.connectInternal(paramString, this);
      }
      
      public void onSuccess()
      {
        paramJSExecutorConnectCallback.onSuccess();
      }
    });
  }
  
  public void executeApplicationScript(String paramString1, String paramString2)
    throws JavaJSExecutor.ProxyExecutorException
  {
    paramString1 = new JSExecutorCallbackFuture(null);
    ((JSDebuggerWebSocketClient)Assertions.assertNotNull(this.mWebSocketClient)).executeApplicationScript(paramString2, this.mInjectedObjects, paramString1);
    try
    {
      paramString1.get();
      return;
    }
    catch (Throwable paramString1)
    {
      throw new JavaJSExecutor.ProxyExecutorException(paramString1);
    }
  }
  
  @Nullable
  public String executeJSCall(String paramString1, String paramString2)
    throws JavaJSExecutor.ProxyExecutorException
  {
    JSExecutorCallbackFuture localJSExecutorCallbackFuture = new JSExecutorCallbackFuture(null);
    ((JSDebuggerWebSocketClient)Assertions.assertNotNull(this.mWebSocketClient)).executeJSCall(paramString1, paramString2, localJSExecutorCallbackFuture);
    try
    {
      paramString1 = localJSExecutorCallbackFuture.get();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw new JavaJSExecutor.ProxyExecutorException(paramString1);
    }
  }
  
  public void setGlobalVariable(String paramString1, String paramString2)
  {
    this.mInjectedObjects.put(paramString1, paramString2);
  }
  
  private static class JSExecutorCallbackFuture
    implements JSDebuggerWebSocketClient.JSDebuggerCallback
  {
    @Nullable
    private Throwable mCause;
    @Nullable
    private String mResponse;
    private final Semaphore mSemaphore = new Semaphore(0);
    
    @Nullable
    public String get()
      throws Throwable
    {
      this.mSemaphore.acquire();
      if (this.mCause != null) {
        throw this.mCause;
      }
      return this.mResponse;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      this.mCause = paramThrowable;
      this.mSemaphore.release();
    }
    
    public void onSuccess(@Nullable String paramString)
    {
      this.mResponse = paramString;
      this.mSemaphore.release();
    }
  }
  
  public static abstract interface JSExecutorConnectCallback
  {
    public abstract void onFailure(Throwable paramThrowable);
    
    public abstract void onSuccess();
  }
  
  public static class WebsocketExecutorTimeoutException
    extends Exception
  {
    public WebsocketExecutorTimeoutException(String paramString)
    {
      super();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\WebsocketJavaScriptExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */