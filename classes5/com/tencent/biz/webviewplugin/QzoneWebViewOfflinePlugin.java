package com.tencent.biz.webviewplugin;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.webso.WebSoCgiService;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.CgiReqInfo;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneFamousSpaceWebViewLogic;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;
import cooperation.qzone.webviewplugin.QzoneOfflinePluginJsForQQ;
import java.net.URLEncoder;
import java.util.Iterator;
import jhx;
import org.json.JSONObject;

public class QzoneWebViewOfflinePlugin
  extends WebViewPlugin
{
  private static final int jdField_a_of_type_Int = 4;
  public static final String a = "QzoneData";
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "offlineResourceIsCached";
  private static final int c = 2;
  private static final int d = 100;
  private static final int e = 0;
  private static final int f = 101;
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  public QzoneWebViewOfflinePlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "QzoneData";
  }
  
  private Object a(String paramString)
  {
    if (this.mRuntime != null) {}
    for (AppInterface localAppInterface = this.mRuntime.a();; localAppInterface = null) {
      return QzoneOfflinePluginJsForQQ.a(localAppInterface, paramString);
    }
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        localStringBuilder.append(URLEncoder.encode(str1, "UTF-8")).append("=").append(URLEncoder.encode(str2, "UTF-8"));
        localStringBuilder.append("&");
      }
      if (localStringBuilder.length() <= 0) {
        break label96;
      }
    }
    catch (Exception paramJSONObject)
    {
      return null;
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    label96:
    return localStringBuilder.toString();
  }
  
  private void a(WebSoCgiService.WebSoCgiState paramWebSoCgiState, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      switch (paramWebSoCgiState.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramWebSoCgiState.jdField_a_of_type_JavaLangString)) {
          localJSONObject.put("url", paramWebSoCgiState.jdField_a_of_type_JavaLangString);
        }
        localJSONObject.put("code", paramWebSoCgiState.jdField_c_of_type_Int);
        if (!TextUtils.isEmpty(paramWebSoCgiState.e)) {
          localJSONObject.put("msg", paramWebSoCgiState.e);
        }
        localJSONObject.put("dataIsBase64", paramWebSoCgiState.jdField_a_of_type_Boolean);
        String str;
        if (!TextUtils.isEmpty(paramWebSoCgiState.jdField_c_of_type_JavaLangString)) {
          if (paramWebSoCgiState.jdField_a_of_type_Boolean)
          {
            str = Base64Util.encodeToString(paramWebSoCgiState.jdField_c_of_type_JavaLangString.getBytes(), 0);
            label149:
            localJSONObject.put("data", str);
          }
        }
        for (;;)
        {
          if (paramWebSoCgiState.jdField_b_of_type_Int > 0) {
            localJSONObject.put("httpStatusCode", paramWebSoCgiState.jdField_b_of_type_Int);
          }
          if (!TextUtils.isEmpty(paramWebSoCgiState.jdField_b_of_type_JavaLangString)) {
            localJSONObject.put("header", new JSONObject(paramWebSoCgiState.jdField_b_of_type_JavaLangString));
          }
          if (paramWebSoCgiState.jdField_a_of_type_JavaLangObject != null) {
            localJSONObject.put("userinfo", paramWebSoCgiState.jdField_a_of_type_JavaLangObject);
          }
          callJs(paramString, new String[] { localJSONObject.toString() });
          return;
          localJSONObject.put("status", 2);
          break;
          localJSONObject.put("status", 4);
          break;
          localJSONObject.put("status", 1);
          break;
          localJSONObject.put("status", 100);
          break;
          str = paramWebSoCgiState.jdField_c_of_type_JavaLangString;
          break label149;
          localJSONObject.put("data", "");
        }
      }
      return;
    }
    catch (Exception paramWebSoCgiState) {}
  }
  
  private void a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1))
    {
      QLog.d(this.TAG, 1, "QzoneData.offlineResourceIsCached args is empty");
      return;
    }
    Object localObject;
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      paramVarArgs = ((JSONObject)localObject).optString("url");
      localObject = ((JSONObject)localObject).optString("callback");
      if ((paramVarArgs == null) || (paramVarArgs.length() == 0))
      {
        QLog.w(this.TAG, 1, "QzoneData.offlineResourceIsCached url is empty");
        return;
      }
    }
    catch (Throwable paramVarArgs)
    {
      QLog.e(this.TAG, 1, paramVarArgs, new Object[0]);
      return;
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      QLog.w(this.TAG, 1, "QzoneData.offlineResourceIsCached callback is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "QzoneData.offlineResourceIsCached url: " + paramVarArgs + ",callback: " + (String)localObject);
    }
    boolean bool = QzoneOfflineCacheHelper.a(paramVarArgs);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("url", paramVarArgs);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("hasData", i);
      callJs((String)localObject, new String[] { localJSONObject.toString() });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(this.TAG, 2, "QzoneData.offlineResourceIsCached callback :" + localJSONObject.toString());
      return;
    }
  }
  
  private void b(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1))
    {
      QLog.d(this.TAG, 1, "QzoneData.handleWnsCgi args is empty");
      return;
    }
    WebSoCgiService.CgiReqInfo localCgiReqInfo = new WebSoCgiService.CgiReqInfo();
    Object localObject;
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      localCgiReqInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("url");
      if (TextUtils.isEmpty(localCgiReqInfo.jdField_a_of_type_JavaLangString)) {
        throw new Exception("url is empty!!!");
      }
    }
    catch (Exception paramVarArgs)
    {
      QLog.e(this.TAG, 1, paramVarArgs, new Object[0]);
      localObject = new WebSoCgiService.WebSoCgiState();
      ((WebSoCgiService.WebSoCgiState)localObject).jdField_a_of_type_JavaLangString = localCgiReqInfo.jdField_a_of_type_JavaLangString;
      ((WebSoCgiService.WebSoCgiState)localObject).jdField_a_of_type_Int = 3;
      ((WebSoCgiService.WebSoCgiState)localObject).jdField_c_of_type_Int = 101;
      ((WebSoCgiService.WebSoCgiState)localObject).e = paramVarArgs.getMessage();
      a((WebSoCgiService.WebSoCgiState)localObject, localCgiReqInfo.f);
      return;
    }
    localCgiReqInfo.f = ((JSONObject)localObject).optString("callback");
    localCgiReqInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("method");
    if ((!"GET".equalsIgnoreCase(localCgiReqInfo.jdField_b_of_type_JavaLangString)) && (!"POST".equalsIgnoreCase(localCgiReqInfo.jdField_b_of_type_JavaLangString))) {
      throw new Exception("no such method support!!!");
    }
    paramVarArgs = ((JSONObject)localObject).opt("body");
    if ((paramVarArgs instanceof JSONObject)) {
      localCgiReqInfo.e = "application/x-www-form-urlencoded";
    }
    for (localCgiReqInfo.d = a((JSONObject)paramVarArgs);; localCgiReqInfo.d = paramVarArgs.toString())
    {
      paramVarArgs = ((JSONObject)localObject).opt("header");
      if ((paramVarArgs == null) || ((paramVarArgs instanceof JSONObject))) {
        break;
      }
      throw new Exception("header format error!!!");
      localCgiReqInfo.e = null;
    }
    if (paramVarArgs != null) {}
    for (paramVarArgs = paramVarArgs.toString();; paramVarArgs = null)
    {
      localCgiReqInfo.jdField_c_of_type_JavaLangString = paramVarArgs;
      localCgiReqInfo.jdField_a_of_type_Boolean = ((JSONObject)localObject).optBoolean("dataNeedBase64", false);
      localCgiReqInfo.jdField_a_of_type_Int = ((int)(((JSONObject)localObject).optDouble("timeout", 0.0D) * 1000.0D));
      localCgiReqInfo.jdField_a_of_type_JavaLangObject = ((JSONObject)localObject).opt("userinfo");
      if (this.a == null) {
        this.a = new jhx(this, Looper.getMainLooper());
      }
      if (WebSoCgiService.a().a(localCgiReqInfo, this.a)) {
        break;
      }
      paramVarArgs = new WebSoCgiService.WebSoCgiState();
      paramVarArgs.jdField_a_of_type_JavaLangString = localCgiReqInfo.jdField_a_of_type_JavaLangString;
      paramVarArgs.jdField_a_of_type_Int = 1;
      paramVarArgs.jdField_c_of_type_Int = 101;
      paramVarArgs.e = "send req fail!";
      a(paramVarArgs, localCgiReqInfo.f);
      return;
    }
  }
  
  public void a(WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    a(paramWebSoCgiState, paramWebSoCgiState.d);
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      return a(paramString);
    }
    return null;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"QzoneData".equals(paramString2)) {}
    do
    {
      return false;
      if ("offlineResourceIsCached".equalsIgnoreCase(paramString3))
      {
        a(paramVarArgs);
        return true;
      }
    } while (!"wnsCgi".equalsIgnoreCase(paramString3));
    b(paramVarArgs);
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    QzoneFamousSpaceWebViewLogic.a().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QzoneFamousSpaceWebViewLogic.a().a(null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\QzoneWebViewOfflinePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */