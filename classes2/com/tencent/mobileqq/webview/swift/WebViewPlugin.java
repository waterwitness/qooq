package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import whl;

public class WebViewPlugin
{
  public static final String KEY_ERROR_CODE = "errorCode";
  public static final String KEY_PERFORMANCE = "performanceData";
  public static final String KEY_REQUEST = "requestData";
  public static final String KEY_RESPONSE = "responseData";
  public static final String KEY_TARGET = "target";
  public static final String KEY_URL = "url";
  public static final int RECODE_FAILED_FREQUENCY_LIMIT = 5;
  public static final int RECODE_FAILED_NATIVE_ERROR = -100;
  public static final int RECODE_FAILED_NO_SUCH_METHOD = 3;
  public static final int RECODE_FAILED_PARAMS_ERROR = 4;
  public static final int RECODE_FAILED_PERMISSION_DENIED = 1;
  public static final int RECODE_FAILED_TOKEN_VERIFY_TIME_OUT = 2;
  public static final int RECODE_SUCCESSED = 0;
  public static final int TARGET_LEFT_VIEW = 1;
  public static final int TARGET_NAV_BACK = 2;
  public static final int TARGET_SYS_BACK = 3;
  protected final String TAG;
  private AtomicBoolean inited;
  protected boolean isDestroy;
  protected HashMap mOpenApiListeners;
  public String mPluginNameSpace;
  public WebViewPlugin.PluginRuntime mRuntime;
  public long pluginEventFlag;
  
  public WebViewPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.TAG = getClass().getSimpleName();
    this.mPluginNameSpace = "";
    this.inited = new AtomicBoolean(false);
  }
  
  protected void addOpenApiListenerIfNeeded(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a))
    {
      if (this.mOpenApiListeners == null) {
        this.mOpenApiListeners = new HashMap();
      }
      this.mOpenApiListeners.put(paramString, paramJsBridgeListener);
    }
  }
  
  @Deprecated
  public void callJs(String paramString)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.a(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.c(paramString);
        return;
      }
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.a(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.a(paramString, paramVarArgs);
        return;
      }
    }
  }
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String paramString)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.a(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.a(paramJsBridgeListener, paramInt, new String[] { paramString });
        return;
      }
    }
  }
  
  protected void callJs4OpenApiIfNeeded(String paramString, int paramInt, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mOpenApiListeners != null)
    {
      bool1 = bool2;
      if (this.mOpenApiListeners.containsKey(paramString))
      {
        callJs4OpenApi((JsBridgeListener)this.mOpenApiListeners.remove(paramString), paramInt, JsBridgeListener.a(paramInt, paramObject, null));
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.openapi", 2, "callJs4OpenApiIfNeeded, methodName:" + paramString + "| callJs4OpenApi:" + bool1);
    }
  }
  
  protected void callJs4OpenApiIfNeeded(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mOpenApiListeners != null)
    {
      bool1 = bool2;
      if (this.mOpenApiListeners.containsKey(paramString1))
      {
        callJs4OpenApi((JsBridgeListener)this.mOpenApiListeners.remove(paramString1), paramInt, JsBridgeListener.a(paramInt, null, paramString2));
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.openapi", 2, "callJs4OpenApiIfNeeded, methodName:" + paramString1 + "| callJs4OpenApi:" + bool1);
    }
  }
  
  public void dispatchJsEvent(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    callJs("window.mqq && mqq.execEventCallback && mqq.execEventCallback(" + Util.b(paramString) + "," + String.valueOf(paramJSONObject1) + "," + String.valueOf(paramJSONObject2) + ");");
  }
  
  public final Object getBrowserComponent(int paramInt)
  {
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter))) {
      return ((SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)this.mRuntime.a()).b().a(paramInt);
    }
    return null;
  }
  
  public int getRequestCode(byte paramByte)
  {
    if (this.mRuntime != null) {}
    for (Activity localActivity = this.mRuntime.a(); (localActivity instanceof WebViewPluginContainer); localActivity = null) {
      return ((WebViewPluginContainer)localActivity).switchRequestCode(this, paramByte);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
    }
    return -1;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return false;
  }
  
  final void initRuntime(Activity paramActivity, AppInterface paramAppInterface)
  {
    if (this.inited.compareAndSet(false, true)) {
      this.mRuntime = new WebViewPlugin.PluginRuntime(paramActivity, paramAppInterface);
    }
  }
  
  public void onActivityReady() {}
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt) {}
  
  public void onAppRuntimeReady(AppInterface paramAppInterface) {}
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    this.isDestroy = true;
    if (this.mOpenApiListeners != null) {
      this.mOpenApiListeners.clear();
    }
  }
  
  public void onPostPluginAsyncTask() {}
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (this.mRuntime != null)) {
      WebViewPlugin.PluginRuntime.a(this.mRuntime, new WeakReference(paramCustomWebView));
    }
  }
  
  protected void postPluginAsyncTask(Runnable paramRunnable)
  {
    ThreadManager.a(paramRunnable, 5, new whl(this), false);
  }
  
  public WebViewPlugin setHandler(Handler paramHandler)
  {
    return this;
  }
  
  public void setWebUiInterface(WebUiBaseInterface paramWebUiBaseInterface) {}
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    Activity localActivity;
    if (this.mRuntime != null)
    {
      localActivity = this.mRuntime.a();
      if (!(localActivity instanceof WebViewPluginContainer)) {
        break label41;
      }
      ((WebViewPluginContainer)localActivity).pluginStartActivityForResult(this, paramIntent, paramByte);
    }
    label41:
    while (!QLog.isDevelopLevel())
    {
      return;
      localActivity = null;
      break;
    }
    QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\WebViewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */