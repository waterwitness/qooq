package com.facebook.react.views.webview;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.webview.events.TopLoadingErrorEvent;
import com.facebook.react.views.webview.events.TopLoadingFinishEvent;
import com.facebook.react.views.webview.events.TopLoadingStartEvent;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactWebViewManager
  extends SimpleViewManager<WebView>
{
  private static final String BLANK_URL = "about:blank";
  public static final int COMMAND_GO_BACK = 1;
  public static final int COMMAND_GO_FORWARD = 2;
  public static final int COMMAND_RELOAD = 3;
  private static final String HTML_ENCODING = "UTF-8";
  private static final String HTML_MIME_TYPE = "text/html";
  private static final String REACT_CLASS = "RCTWebView";
  private WebViewConfig mWebViewConfig;
  
  public ReactWebViewManager()
  {
    this.mWebViewConfig = new WebViewConfig()
    {
      public void configWebView(WebView paramAnonymousWebView) {}
    };
  }
  
  public ReactWebViewManager(WebViewConfig paramWebViewConfig)
  {
    this.mWebViewConfig = paramWebViewConfig;
  }
  
  @Nullable
  public static Map<String, Integer> getStaticCommandsMap()
  {
    return MapBuilder.of("goBack", Integer.valueOf(1), "goForward", Integer.valueOf(2), "reload", Integer.valueOf(3));
  }
  
  public static String getStaticName()
  {
    return "RCTWebView";
  }
  
  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, WebView paramWebView)
  {
    paramWebView.setWebViewClient(new ReactWebViewClient(null));
  }
  
  protected WebView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    ReactWebView localReactWebView = new ReactWebView(paramThemedReactContext);
    paramThemedReactContext.addLifecycleEventListener(localReactWebView);
    this.mWebViewConfig.configWebView(localReactWebView);
    return localReactWebView;
  }
  
  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return getStaticCommandsMap();
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public void onDropViewInstance(ThemedReactContext paramThemedReactContext, WebView paramWebView)
  {
    super.onDropViewInstance(paramThemedReactContext, paramWebView);
    paramThemedReactContext.removeLifecycleEventListener((ReactWebView)paramWebView);
    ((ReactWebView)paramWebView).cleanupCallbacksAndDestroy();
  }
  
  public void receiveCommand(WebView paramWebView, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramWebView.goBack();
      return;
    case 2: 
      paramWebView.goForward();
      return;
    }
    paramWebView.reload();
  }
  
  @ReactProp(name="html")
  public void setHtml(WebView paramWebView, @Nullable String paramString)
  {
    if (paramString != null)
    {
      paramWebView.loadData(paramString, "text/html", "UTF-8");
      return;
    }
    paramWebView.loadUrl("about:blank");
  }
  
  @ReactProp(name="injectedJavaScript")
  public void setInjectedJavaScript(WebView paramWebView, @Nullable String paramString)
  {
    ((ReactWebView)paramWebView).setInjectedJavaScript(paramString);
  }
  
  @ReactProp(name="javaScriptEnabledAndroid")
  public void setJavaScriptEnabled(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setJavaScriptEnabled(paramBoolean);
  }
  
  @ReactProp(name="url")
  public void setUrl(WebView paramWebView, @Nullable String paramString)
  {
    if (paramString != null)
    {
      paramWebView.loadUrl(paramString);
      return;
    }
    paramWebView.loadUrl("about:blank");
  }
  
  @ReactProp(name="userAgent")
  public void setUserAgent(WebView paramWebView, @Nullable String paramString)
  {
    if (paramString != null) {
      paramWebView.getSettings().setUserAgentString(paramString);
    }
  }
  
  private static class ReactWebView
    extends WebView
    implements LifecycleEventListener
  {
    @Nullable
    private String injectedJS;
    
    public ReactWebView(ThemedReactContext paramThemedReactContext)
    {
      super();
    }
    
    private void cleanupCallbacksAndDestroy()
    {
      setWebViewClient(null);
      destroy();
    }
    
    public void callInjectedJavaScript()
    {
      if ((getSettings().getJavaScriptEnabled()) && (this.injectedJS != null) && (!TextUtils.isEmpty(this.injectedJS))) {
        loadUrl("javascript:(function() {\n" + this.injectedJS + ";\n})();");
      }
    }
    
    public void onHostDestroy()
    {
      cleanupCallbacksAndDestroy();
    }
    
    public void onHostPause() {}
    
    public void onHostResume() {}
    
    public void setInjectedJavaScript(@Nullable String paramString)
    {
      this.injectedJS = paramString;
    }
  }
  
  private static class ReactWebViewClient
    extends WebViewClient
  {
    private boolean mLastLoadFailed = false;
    
    private WritableMap createWebViewEvent(WebView paramWebView, String paramString)
    {
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putDouble("target", paramWebView.getId());
      localWritableMap.putString("url", paramString);
      if ((!this.mLastLoadFailed) && (paramWebView.getProgress() != 100)) {}
      for (boolean bool = true;; bool = false)
      {
        localWritableMap.putBoolean("loading", bool);
        localWritableMap.putString("title", paramWebView.getTitle());
        localWritableMap.putBoolean("canGoBack", paramWebView.canGoBack());
        localWritableMap.putBoolean("canGoForward", paramWebView.canGoForward());
        return localWritableMap;
      }
    }
    
    private void emitFinishEvent(WebView paramWebView, String paramString)
    {
      ((UIManagerModule)((ReactContext)paramWebView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new TopLoadingFinishEvent(paramWebView.getId(), SystemClock.uptimeMillis(), createWebViewEvent(paramWebView, paramString)));
    }
    
    public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
    {
      super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
      ((UIManagerModule)((ReactContext)paramWebView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new TopLoadingStartEvent(paramWebView.getId(), SystemClock.uptimeMillis(), createWebViewEvent(paramWebView, paramString)));
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (!this.mLastLoadFailed)
      {
        ((ReactWebViewManager.ReactWebView)paramWebView).callInjectedJavaScript();
        emitFinishEvent(paramWebView, paramString);
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.mLastLoadFailed = false;
      ((UIManagerModule)((ReactContext)((ReactWebViewManager.ReactWebView)paramWebView).getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new TopLoadingStartEvent(paramWebView.getId(), SystemClock.uptimeMillis(), createWebViewEvent(paramWebView, paramString)));
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      this.mLastLoadFailed = true;
      emitFinishEvent(paramWebView, paramString2);
      ReactContext localReactContext = (ReactContext)((ReactWebViewManager.ReactWebView)paramWebView).getContext();
      paramString2 = createWebViewEvent(paramWebView, paramString2);
      paramString2.putDouble("code", paramInt);
      paramString2.putString("description", paramString1);
      ((UIManagerModule)localReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new TopLoadingErrorEvent(paramWebView.getId(), SystemClock.uptimeMillis(), paramString2));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\webview\ReactWebViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */