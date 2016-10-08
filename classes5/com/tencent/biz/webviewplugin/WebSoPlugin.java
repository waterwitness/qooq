package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import java.util.Arrays;
import java.util.Map;
import jis;
import jit;
import jiu;
import org.json.JSONObject;

public class WebSoPlugin
  extends WebViewPlugin
{
  public static final String a = "QzoneData";
  public static final String b = "WebSo";
  private static final String e = "WebSoPlugin";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  public String d;
  private String f;
  private String g;
  
  public WebSoPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = "";
    this.c = "";
    this.d = "";
    this.jdField_a_of_type_AndroidOsHandler = new jis(this, Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new jit(this, Looper.getMainLooper());
    this.mPluginNameSpace = "WebSo";
  }
  
  private void a(int paramInt)
  {
    if (TextUtils.isEmpty(this.c)) {}
    JSONObject localJSONObject1;
    CustomWebView localCustomWebView;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(this.d));
      localJSONObject1 = new JSONObject();
      localCustomWebView = null;
      if (this.mRuntime != null) {
        localCustomWebView = this.mRuntime.a();
      }
    } while (localCustomWebView == null);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.d = "";
      return;
      JSONObject localJSONObject2;
      long l;
      try
      {
        localJSONObject2 = new JSONObject(this.d);
        l = System.currentTimeMillis() - localJSONObject2.optLong("local_refresh_time", 0L);
        if (l <= 30000L) {
          break label198;
        }
        if (QLog.isColorLevel()) {
          QLog.w("WebSoPlugin", 1, "receive js call too late, " + l / 1000.0D + "s");
        }
        this.d = "";
        this.c = "";
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("WebSoPlugin", 1, localException, new Object[] { "dispatchDiffData to website error!" });
      }
      continue;
      label198:
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "receive js call in time: " + l / 1000.0D + "s");
      }
      if (l > 0L) {
        localJSONObject1.put("local_refresh_time", l);
      }
      localJSONObject2.remove("local_refresh_time");
      localJSONObject1.put("result", localJSONObject2.toString());
      localJSONObject1.put("code", 200);
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "now call localRefresh data: , " + localJSONObject1.toString());
      }
      localException.a(this.c, new String[] { localJSONObject1.toString() });
      continue;
      localJSONObject1.put("code", 304);
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "now call localRefresh data: , " + localJSONObject1.toString());
      }
      localException.a(this.c, new String[] { localJSONObject1.toString() });
    }
  }
  
  private void a(Bundle paramBundle)
  {
    CustomWebView localCustomWebView = null;
    if (this.mRuntime != null) {
      localCustomWebView = this.mRuntime.a();
    }
    if (localCustomWebView == null) {}
    do
    {
      return;
      localObject = localCustomWebView.getUrl();
    } while (paramBundle == null);
    String str2 = paramBundle.getString("url");
    int j = paramBundle.getInt("req_state", 0);
    int k = paramBundle.getInt("result_code", 0);
    boolean bool2 = paramBundle.getBoolean("is_local_data");
    String str1 = paramBundle.getString("wns_proxy_http_data");
    boolean bool3 = TextUtils.isEmpty(str1);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("about:blank".equals(localObject))) {}
    boolean bool4;
    for (int i = 1;; i = 0)
    {
      bool4 = paramBundle.getBoolean("key_wns_cache_hit", false);
      if (k != 10503) {
        break;
      }
      QLog.e("WebSoPlugin", 1, "QZoneWebViewPlugin onReceive 503, now it reload url! " + Util.c(str2, new String[0]));
      localCustomWebView.a(str2);
      return;
    }
    Object localObject = new StringBuilder().append("QZoneWebViewPlugin onReceive  htmlBody(");
    boolean bool1;
    if (!bool3)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(")").append(" currentUrl(");
      if (i != 0) {
        break label332;
      }
      bool1 = true;
      label212:
      QLog.d("WebSoPlugin", 1, bool1 + ")" + " cache hit(" + bool4 + ") hasLoadCache(" + this.jdField_b_of_type_Boolean + ") load Url: " + Util.c(str2, new String[0]));
      if ((this.jdField_b_of_type_Boolean) || (bool3) || (i == 0)) {
        break label348;
      }
      if (j == 2) {}
      this.jdField_b_of_type_Boolean = true;
      if (!bool2) {
        break label338;
      }
    }
    label332:
    label338:
    for (paramBundle = WebSoUtils.a(str2, str1);; paramBundle = WebSoUtils.b(str2, str1))
    {
      localCustomWebView.loadDataWithBaseURL(str2, paramBundle, "text/html", "utf-8", str2);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label212;
    }
    label348:
    if (bool4)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "webso return 304, so hit local cache!");
      }
      this.d = "304";
      a(304);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "webso success load local data, now load new data ! " + this.jdField_b_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = true;
    }
    if ((bool3) && (i != 0))
    {
      localCustomWebView.loadUrl(str2);
      return;
    }
    if ((!bool3) && (i != 0))
    {
      if (bool2) {}
      for (paramBundle = WebSoUtils.a(str2, str1);; paramBundle = WebSoUtils.b(str2, str1))
      {
        localCustomWebView.loadDataWithBaseURL(str2, paramBundle, "text/html", "utf-8", str2);
        return;
      }
    }
    if ((!bool3) && (i == 0)) {
      if (paramBundle.getBoolean("need_force_refresh", false)) {
        if (bool2) {
          break label576;
        }
      }
    }
    label576:
    for (paramBundle = WebSoUtils.b(str2, str1);; paramBundle = str1)
    {
      localCustomWebView.loadDataWithBaseURL(str2, paramBundle, "text/html", "utf-8", str2);
      return;
      if (!paramBundle.getBoolean("need_local_refresh", false)) {
        break;
      }
      this.d = paramBundle.getString("key_html_changed_data");
      a(200);
      return;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  private boolean a(String paramString, long paramLong, Map paramMap)
  {
    this.jdField_b_of_type_Boolean = false;
    if ((paramLong != 32L) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramMap = this.mRuntime.a();
        } while ((paramMap == null) || (paramMap.isFinishing()) || (paramMap.getIntent() == null));
        paramMap = this.mRuntime.a();
      } while (paramMap == null);
      paramMap = paramMap.getUrl();
      if ((!TextUtils.isEmpty(paramMap)) && (!"about:blank".equals(paramMap)))
      {
        QLog.e("WebSoPlugin", 1, "now onHandleEventBeforeLoaded current url is not null! so return! " + Util.c(paramMap, new String[0]));
        return false;
      }
      a(paramString);
    } while ((!WebSoUtils.b(paramString)) || (WebSoUtils.d(paramString)));
    WebSoService.a().a(paramString, this.jdField_b_of_type_AndroidOsHandler);
    return true;
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (Build.VERSION.SDK_INT > 10)) {
      paramCustomWebView.setLayerType(1, null);
    }
  }
  
  void a(String paramString)
  {
    ThreadManager.a(new jiu(this, paramString), 5, null, false);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 32L) {
      return a(paramString, paramLong, paramMap);
    }
    if (paramLong == 8589934594L)
    {
      if ((TextUtils.isEmpty(paramString)) || ("about:bank".equals(paramString))) {
        return false;
      }
      if (!WebSoUtils.b(paramString)) {
        return false;
      }
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView == null) {
        return false;
      }
      paramString = localCustomWebView.copyBackForwardList();
      if ((paramString == null) || (paramString.getSize() == 0))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (localCustomWebView != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("WebSoPlugin", 2, "now clear webview history!");
            }
            localCustomWebView.clearHistory();
          }
          this.jdField_a_of_type_Boolean = false;
        }
        return false;
      }
      int i;
      if (QLog.isColorLevel())
      {
        i = paramString.getSize() - 1;
        while (i >= 0)
        {
          paramMap = paramString.getItemAtIndex(i);
          if (paramMap != null) {
            QLog.i("WebSoPlugin", 2, " EVENT_LOAD_FINISH --- history: " + i + " " + paramMap.getUrl());
          }
          i -= 1;
        }
      }
      if (paramString.getSize() >= 2)
      {
        String str1 = "";
        String str2 = "";
        i = paramString.getSize() - 1;
        WebHistoryItem localWebHistoryItem1 = paramString.getItemAtIndex(i);
        WebHistoryItem localWebHistoryItem2 = paramString.getItemAtIndex(i - 1);
        paramMap = str2;
        paramString = str1;
        if (localWebHistoryItem1 != null)
        {
          paramMap = str2;
          paramString = str1;
          if (localWebHistoryItem2 != null)
          {
            paramString = localWebHistoryItem1.getUrl();
            paramMap = localWebHistoryItem2.getUrl();
          }
        }
        if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WebSoPlugin", 2, "current url equals with precious url, need clear history!");
          }
          this.jdField_a_of_type_Boolean = true;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebSoPlugin", 2, "now clear webview history!");
        }
        localCustomWebView.clearHistory();
        this.jdField_a_of_type_Boolean = false;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (paramLong != 8589934601L);
          if ((TextUtils.isEmpty(paramString)) || ("about:bank".equals(paramString))) {
            return false;
          }
          if (!WebSoUtils.b(paramString)) {
            return false;
          }
          paramString = this.mRuntime.a();
          if (paramString == null) {
            return false;
          }
          paramString = paramString.copyBackForwardList();
          if (paramString == null) {
            return false;
          }
        } while (paramString.getSize() != 2);
        paramMap = paramString.getItemAtIndex(paramString.getSize() - 1).getUrl();
      } while (!paramString.getItemAtIndex(paramString.getSize() - 2).getUrl().equals(paramMap));
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "current url equals with precious url, need close activity!");
      }
    } while (this.mRuntime.a() == null);
    this.mRuntime.a().finish();
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if ((paramString2 != null) && ("QzoneData".equals(paramString2)) && (paramString3 != null) && ("offlineHttpProxy".equals(paramString3)) && (paramVarArgs.length == 1)) {}
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      if ((paramJsBridgeListener.has("proxyUrl")) && (paramJsBridgeListener.has("isCheckCache")))
      {
        this.f = paramJsBridgeListener.optString("proxyUrl");
        if ((paramJsBridgeListener.getBoolean("isCheckCache")) && (!TextUtils.isEmpty(WebSoUtils.c(this.f)))) {
          return true;
        }
        this.g = paramJsBridgeListener.getString("callback");
        WebSoService.a().a(this.f, this.jdField_a_of_type_AndroidOsHandler);
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSoPlugin", 2, "exception =" + paramJsBridgeListener);
        }
      }
      a(200);
      return true;
    }
    if ((paramString2 != null) && ("WebSo".equals(paramString2)))
    {
      bool1 = bool2;
      if (!"getWebsoDiffData".equals(paramString3)) {
        break label345;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebSoPlugin", 2, "WebSo get webso js api, data: " + Arrays.toString(paramVarArgs));
      }
      bool1 = bool2;
      if (this.mRuntime.a() == null) {
        break label345;
      }
      bool1 = bool2;
      if (paramVarArgs.length <= 0) {
        break label345;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
        bool1 = bool2;
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          break label345;
        }
        this.c = paramJsBridgeListener;
        bool1 = bool2;
        if (TextUtils.isEmpty(this.d)) {
          break label345;
        }
        if (this.d.equals("304"))
        {
          a(304);
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    boolean bool1 = false;
    label345:
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\WebSoPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */