package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONObject;

public class ColorRingJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "colorRing";
  public static final String Method_ChangeTab = "changeTab";
  public static final String Method_GetCurrentId = "getCurrentId";
  public static final String Method_Play = "play";
  public static final String Method_SetUp = "setup";
  public static final String Tag = "ColorRingJsPlugin";
  private Activity mActivity;
  private BrowserAppInterface mBrowserApp;
  
  public ColorRingJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "colorRing";
  }
  
  void changeTab(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "changeTab");
    }
    SwiftBrowserMiscHandler localSwiftBrowserMiscHandler = (SwiftBrowserMiscHandler)super.getBrowserComponent(32);
    if (localSwiftBrowserMiscHandler != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("callbackId", paramString);
      paramString = localSwiftBrowserMiscHandler.a.obtainMessage(5, localBundle);
      localSwiftBrowserMiscHandler.a.dispatchMessage(paramString);
    }
  }
  
  void getCurrentId(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "getCurrentId");
    }
    ThreadManager.a(new ColorRingJsPlugin.1(this, paramString1, paramString2), 5, null, true);
  }
  
  protected long getPluginBusiness()
  {
    return 2151677952L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"colorRing".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    int i;
    try
    {
      i = paramString1.indexOf("=");
      if ((i != -1) && (i + 1 <= paramString1.length() - 1)) {
        break label95;
      }
      throw new Exception("Invalid Url Parameters");
    }
    catch (Exception paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
    return true;
    label95:
    paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
    paramString1 = paramJsBridgeListener.getString("callback");
    long l;
    if (paramJsBridgeListener.has("id"))
    {
      l = paramJsBridgeListener.getLong("id");
      label140:
      if (!paramJsBridgeListener.has("status")) {
        break label288;
      }
      i = paramJsBridgeListener.getInt("status");
      label157:
      if (!paramJsBridgeListener.has("type")) {
        break label294;
      }
    }
    label288:
    label294:
    for (paramJsBridgeListener = paramJsBridgeListener.getString("type");; paramJsBridgeListener = "comering")
    {
      if ("getCurrentId".equals(paramString3))
      {
        getCurrentId(paramJsBridgeListener, paramString1);
        break;
      }
      if ("play".equals(paramString3))
      {
        play(l, paramJsBridgeListener, paramString1);
        break;
      }
      if ("setup".equals(paramString3))
      {
        setup(l, i, paramJsBridgeListener, paramString1);
        break;
      }
      if ("changeTab".equals(paramString3))
      {
        changeTab(paramString1);
        break;
      }
      throw new Exception("No Such Method:" + paramString3);
      l = 0L;
      break label140;
      i = 0;
      break label157;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.a();
    this.mBrowserApp = ((BrowserAppInterface)this.mRuntime.a());
  }
  
  void play(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "play, id=" + paramLong);
    }
    SwiftBrowserMiscHandler localSwiftBrowserMiscHandler = (SwiftBrowserMiscHandler)super.getBrowserComponent(32);
    if (localSwiftBrowserMiscHandler != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("id", paramLong);
      localBundle.putString("callbackId", paramString2);
      localBundle.putString("type", paramString1);
      paramString1 = localSwiftBrowserMiscHandler.a.obtainMessage(3, localBundle);
      localSwiftBrowserMiscHandler.a.dispatchMessage(paramString1);
    }
  }
  
  void setup(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "setup, id=" + paramLong);
    }
    SwiftBrowserMiscHandler localSwiftBrowserMiscHandler = (SwiftBrowserMiscHandler)super.getBrowserComponent(32);
    if (localSwiftBrowserMiscHandler != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("id", paramLong);
      localBundle.putInt("status", paramInt);
      localBundle.putString("type", paramString1);
      localBundle.putString("callbackId", paramString2);
      paramString1 = localSwiftBrowserMiscHandler.a.obtainMessage(4, localBundle);
      localSwiftBrowserMiscHandler.a.dispatchMessage(paramString1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ColorRingJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */