package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.SetCookiesCallback;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridgeUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import hob;
import hoc;
import hod;
import hoe;
import hof;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomWebView
  extends SuperWebView
{
  protected static SparseArray a;
  public static final String a = "webviewLoad";
  public static final String b = "WEBVIEWCHECK";
  public static final String c;
  static final String jdField_e_of_type_JavaLangString = "((0))";
  static final String f = "((1))";
  static final String g = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);";
  static String h;
  private static String i;
  protected View a;
  protected CustomWebView.OpenApiTokenInfo a;
  CustomWebView.ScrollInterface jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface;
  protected WebViewPluginEngine a;
  SwiftBrowserCookieMonster.SetCookiesCallback jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback = null;
  protected boolean a;
  public boolean b;
  protected boolean c;
  String d;
  protected boolean d;
  boolean jdField_e_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = CustomWebView.class.getSimpleName();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(8);
    jdField_a_of_type_AndroidUtilSparseArray.put(0, "recode_successed");
    jdField_a_of_type_AndroidUtilSparseArray.put(1, "recode_failed_permission_denied");
    jdField_a_of_type_AndroidUtilSparseArray.put(2, "recode_failed_token_verify_time_out");
    jdField_a_of_type_AndroidUtilSparseArray.put(3, "recode_failed_no_such_method");
    jdField_a_of_type_AndroidUtilSparseArray.put(4, "recode_failed_params_error");
    jdField_a_of_type_AndroidUtilSparseArray.put(5, "recode_failed_frequency_limit");
  }
  
  public CustomWebView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.e = true;
    this.jdField_d_of_type_JavaLangString = "";
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.e = true;
    this.jdField_d_of_type_JavaLangString = "";
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.e = true;
    this.jdField_d_of_type_JavaLangString = "";
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  private Intent a()
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      return this.jdField_a_of_type_AndroidContentIntent;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a.getIntent();
    }
    return null;
  }
  
  private boolean a()
  {
    if (this.e)
    {
      Intent localIntent = a();
      if ((localIntent != null) && (localIntent.getBooleanExtra("ignoreLoginWeb", false)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "ignore login state, set key cookie abort.");
        }
        this.e = false;
      }
    }
    return this.e;
  }
  
  private boolean a(hof paramhof)
  {
    if (!this.e) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = SwiftWebViewUtils.a(paramhof.jdField_a_of_type_JavaLangString);
      } while ((!"http".equals(localObject)) && (!"https".equals(localObject)));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback = new hob(this, paramhof);
      localObject = SwiftBrowserCookieMonster.a(paramhof.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    this.e = false;
    Intent localIntent = a();
    if ((localIntent != null) && (localIntent.getBooleanExtra("avoidLoginWeb", false)))
    {
      ((SwiftBrowserCookieMonster)localObject).c();
      return false;
    }
    this.jdField_d_of_type_JavaLangString = paramhof.jdField_a_of_type_JavaLangString;
    ((SwiftBrowserCookieMonster)localObject).a(paramhof.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback, null, localIntent);
    return true;
  }
  
  private void b()
  {
    try
    {
      if ((((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled()) && (Build.VERSION.SDK_INT < 19))
      {
        Object localObject1 = com.tencent.smtt.sdk.WebView.class.getDeclaredField("isX5Core");
        ((Field)localObject1).setAccessible(true);
        if (!((Boolean)((Field)localObject1).get(this)).booleanValue())
        {
          localObject1 = com.tencent.smtt.sdk.WebView.class.getDeclaredField("mSysWebView");
          ((Field)localObject1).setAccessible(true);
          localObject1 = ((Field)localObject1).get(this);
          Object localObject2 = android.webkit.WebView.class.getDeclaredField("mProvider");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject2).get(localObject1);
          localObject2 = Class.forName("android.webkit.WebViewClassic").getDeclaredField("mAccessibilityInjector");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localObject1);
          Field localField = Class.forName("android.webkit.AccessibilityInjector").getDeclaredField("mTextToSpeech");
          localField.setAccessible(true);
          localObject1 = localField.get(localObject2);
          if (localObject1 != null)
          {
            localField.set(localObject2, null);
            localObject2 = Class.forName("android.webkit.AccessibilityInjector.TextToSpeechWrapper").getDeclaredMethod("shutdown", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            ((Method)localObject2).invoke(localObject1, new Object[0]);
          }
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "destroy_webview", 0, 1, 0, localIllegalArgumentException.toString(), "", "", "");
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "destroy_webview", 0, 1, 0, localException.toString(), "", "", "");
        localException.printStackTrace();
      }
    }
    b(this);
  }
  
  public static void b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(i))) {
      return;
    }
    long l = System.currentTimeMillis();
    i = paramString;
    String str = paramString;
    if (paramString.length() > 512) {
      str = paramString.substring(0, 512);
    }
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    paramString = str;
    if (arrayOfStackTraceElement.length > 2) {
      paramString = str + " at " + arrayOfStackTraceElement[2].toString();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("webviewLoad", 4, "cost:" + (System.currentTimeMillis() - l) + " " + paramString);
    }
    StatisticCollector.a(null).a("webviewLoad", paramString);
  }
  
  private boolean c(Map paramMap)
  {
    String str = (String)paramMap.get("url");
    if (TextUtils.isEmpty(str))
    {
      QLog.d(jdField_c_of_type_JavaLangString, 1, "url is null, not intercept");
      return false;
    }
    if (SwiftWebViewHttpBridgeUtils.a(str) == 3)
    {
      if (SwiftWebViewHttpBridgeUtils.b(str))
      {
        paramMap.put("url", str.replace(":8080", "").replace("asyncMode=3", ""));
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "swift Http hit 503, change url: " + str);
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public CustomWebView.OpenApiTokenInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo;
  }
  
  public WebViewPluginEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(this.jdField_d_of_type_JavaLangString);
      if (localSwiftBrowserCookieMonster != null) {
        localSwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback = null;
      this.jdField_d_of_type_JavaLangString = "";
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_d_of_type_Boolean = true;
    this.e = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.a();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo = null;
    }
    setIntent(null);
    setWebChromeClient(null);
    setWebViewClient(null);
    setDownloadListener(null);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setWebViewClientExtension(null);
    }
    getView().setOnTouchListener(null);
    setMask(false);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo = new CustomWebView.OpenApiTokenInfo();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_JavaLangString = (paramInt1 + "_" + paramString1 + "_" + paramString2);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + paramInt3);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      paramString1 = paramArrayList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Long.valueOf(0L));
      }
    }
  }
  
  public void a(JsBridgeListener paramJsBridgeListener, int paramInt, String... paramVarArgs)
  {
    if ((paramJsBridgeListener == null) || (paramJsBridgeListener.jdField_a_of_type_Long == -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_c_of_type_JavaLangString, 2, "callJs4OpenApi, listener == null || listener.sn == -1");
      }
      return;
    }
    for (Object localObject = (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);; localObject = "")
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", paramInt);
        if (localObject == null) {
          continue;
        }
        localJSONObject.put("msg", localObject);
        localObject = new StringBuilder();
        int j;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!"".equals(paramVarArgs[0])))
        {
          ((StringBuilder)localObject).append(paramVarArgs[0]);
          paramInt = 1;
          j = paramVarArgs.length;
        }
        while (paramInt < j)
        {
          ((StringBuilder)localObject).append(',').append(paramVarArgs[paramInt]);
          paramInt += 1;
          continue;
          ((StringBuilder)localObject).append("{}");
        }
        localJSONObject.put("data", ((StringBuilder)localObject).toString());
        paramVarArgs = localJSONObject.toString();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "callJs4OpenApi,listener.sn" + paramJsBridgeListener.jdField_a_of_type_Long + " | result:" + paramVarArgs);
        }
        c("(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);".replace("((0))", Util.b(paramJsBridgeListener.jdField_a_of_type_Long + "")).replace("((1))", paramVarArgs));
        return;
      }
      catch (JSONException paramJsBridgeListener) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "callJs4OpenApi, JSONException");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.b) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!a()) {
          break;
        }
        localObject = new hof(this);
        ((hof)localObject).jdField_e_of_type_Int = 2;
        ((hof)localObject).jdField_a_of_type_JavaLangString = paramString;
      } while (a((hof)localObject));
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_d_of_type_Boolean = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString);
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a((Map)localObject)));
    paramString = (String)((Map)localObject).get("url");
    WebAccelerateHelper.getInstance().checkCookie(paramString);
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WEBVIEWCHECK", 2, "CustomWebView loadUrlOriginal url:" + Util.b(paramString, new String[0]));
      }
      super.loadUrl(paramString);
      return;
    }
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_c_of_type_JavaLangString, 2, QLog.getStackTraceString(new Throwable("func is empty")));
      }
      return;
    }
    Object localObject;
    if (h == null)
    {
      localObject = AuthorizeConfig.a().a("jscallback", null);
      if ((localObject == null) || (!((String)localObject).contains("((0))")) || (!((String)localObject).contains("((1))"))) {
        break label150;
      }
    }
    label150:
    for (h = (String)localObject;; h = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);")
    {
      localObject = new StringBuilder();
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || ("".equals(paramVarArgs[0]))) {
        break;
      }
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      int j = 1;
      int k = paramVarArgs.length;
      while (j < k)
      {
        ((StringBuilder)localObject).append(',').append(paramVarArgs[j]);
        j += 1;
      }
    }
    ((StringBuilder)localObject).append("void(0)");
    c(h.replace("((0))", Util.b(paramString)).replace("((1))", (CharSequence)localObject));
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      IX5WebSettingsExtension localIX5WebSettingsExtension = getSettingsExtension();
      if (localIX5WebSettingsExtension != null) {
        localIX5WebSettingsExtension.setRecordRequestEnabled(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_c_of_type_JavaLangString, 2, "webkit not support request record!");
    }
  }
  
  public boolean a(CustomWebView paramCustomWebView, int paramInt, String paramString1, String paramString2, String paramString3, JsBridgeListener paramJsBridgeListener)
  {
    if (paramCustomWebView == null) {
      return false;
    }
    if ("auth.init".equals(paramString3)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "mOpenApiInfo == null");
      }
      return false;
    }
    if ((paramInt == 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramCustomWebView.a(paramJsBridgeListener, 4, new String[] { JsBridgeListener.a(4, null, "params_error") });
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "RECODE_FAILED_PARAMS_ERROR");
      }
      return false;
    }
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.e(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "serverTime - mOpenApiInfo.expireTime:" + (l - this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_Long));
    }
    if (l > this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_Long)
    {
      paramCustomWebView.a(paramJsBridgeListener, 2, new String[] { JsBridgeListener.a(2, null, "token_verify_time_out") });
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "RECODE_FAILED_TOKEN_VERIFY_TIME_OUT");
      }
      return false;
    }
    paramString2 = paramInt + "_" + paramString1 + "_" + paramString2;
    paramString3 = "mqq." + paramString3;
    paramString1 = null;
    int j;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_JavaLangString)) || (!paramString2.equals(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_JavaLangString)))
    {
      j = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap == null) {
        break label706;
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      paramString1 = null;
      while (localIterator.hasNext())
      {
        paramString2 = (String)localIterator.next();
        paramString1 = paramString2;
        if (Pattern.compile(paramString2).matcher(paramString3).find())
        {
          paramString1 = paramString2;
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if ((j != 0) || (paramInt == 0))
      {
        paramCustomWebView.a(paramJsBridgeListener, 1, new String[] { JsBridgeListener.a(1, null, "permission_denied") });
        if (QLog.isColorLevel()) {
          QLog.e(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "permission_denied");
        }
        return false;
        j = 0;
        break;
      }
      l = ((Long)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap.get(paramString1)).longValue() + this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "expectedTime - System.currentTimeMillis():" + (l - System.currentTimeMillis()));
      }
      if (l > System.currentTimeMillis())
      {
        paramCustomWebView.a(paramJsBridgeListener, 5, new String[] { JsBridgeListener.a(5, null, "frequency_limit") });
        if (QLog.isColorLevel()) {
          QLog.e(jdField_c_of_type_JavaLangString + ".troop.openapi", 2, "frequency_limit");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      return true;
      paramInt = 0;
      continue;
      label706:
      paramInt = 0;
    }
  }
  
  public boolean a(Map paramMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(getUrl(), 8589934601L, paramMap))) {
      return false;
    }
    super.stopLoading();
    super.goBack();
    return true;
  }
  
  public boolean b(Map paramMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(getUrl(), 8589934602L, paramMap))) {
      return false;
    }
    super.stopLoading();
    super.goForward();
    return true;
  }
  
  public void c(String paramString)
  {
    if (this.b) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      try
      {
        super.loadUrl("javascript:" + paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    post(new hoe(this, paramString));
  }
  
  public void destroy()
  {
    this.b = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(this.jdField_d_of_type_JavaLangString);
      if (localSwiftBrowserCookieMonster != null) {
        localSwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback = null;
      this.jdField_d_of_type_JavaLangString = "";
    }
    if (!this.jdField_c_of_type_Boolean) {
      postDelayed(new hoc(this), 1000L);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.a();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo = null;
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (this.b) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!a()) {
          break;
        }
        localObject = new hof(this);
        ((hof)localObject).jdField_e_of_type_Int = 3;
        ((hof)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((hof)localObject).jdField_c_of_type_JavaLangString = paramString2;
        ((hof)localObject).jdField_d_of_type_JavaLangString = paramString3;
      } while (a((hof)localObject));
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_d_of_type_Boolean = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString1);
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a((Map)localObject)));
    paramString1 = (String)((Map)localObject).get("url");
    for (;;)
    {
      b(paramString1);
      super.loadData(paramString1, paramString2, paramString3);
      return;
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.b) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!a()) {
          break;
        }
        localObject = new hof(this);
        ((hof)localObject).jdField_e_of_type_Int = 4;
        ((hof)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((hof)localObject).jdField_b_of_type_JavaLangString = paramString2;
        ((hof)localObject).jdField_c_of_type_JavaLangString = paramString3;
        ((hof)localObject).jdField_d_of_type_JavaLangString = paramString4;
        ((hof)localObject).jdField_e_of_type_JavaLangString = paramString5;
      } while (a((hof)localObject));
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_d_of_type_Boolean = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString1);
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a((Map)localObject)));
    paramString1 = (String)((Map)localObject).get("url");
    for (;;)
    {
      b("[" + Util.b(paramString1, new String[0]) + "]" + paramString2);
      super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
  }
  
  public void loadUrl(String paramString)
  {
    int j = 1;
    if (this.b) {}
    HashMap localHashMap;
    do
    {
      hof localhof;
      do
      {
        do
        {
          return;
          localHashMap = new HashMap();
          localHashMap.put("url", paramString);
        } while (c(localHashMap));
        if (!a()) {
          break;
        }
        localhof = new hof(this);
        localhof.jdField_e_of_type_Int = 1;
        localhof.jdField_a_of_type_JavaLangString = paramString;
      } while (a(localhof));
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_d_of_type_Boolean = false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localHashMap)));
    paramString = (String)localHashMap.get("url");
    WebAccelerateHelper.getInstance().checkCookie(paramString);
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(paramString))) {}
      for (;;)
      {
        if ((j != 0) && ((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
          b(Util.b(paramString, new String[0]));
        }
        if (j != 0) {
          super.loadUrl(paramString);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WEBVIEWCHECK", 2, "CustomWebView loadUrl url:" + Util.b(paramString, new String[0]));
        com.tencent.mobileqq.log.VipWebViewReportLog.g = paramString;
        return;
        j = 0;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_c_of_type_Boolean = false;
    if (this.b) {
      postDelayed(new hod(this), 1000L);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Boolean = true;
    super.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Boolean = false;
    super.onResume();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setMask(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(getContext());
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1996488704);
        addView(this.jdField_a_of_type_AndroidViewView, -1);
      }
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setOnCustomScrollChangeListener(CustomWebView.ScrollInterface paramScrollInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface = paramScrollInterface;
  }
  
  public void setPluginEngine(WebViewPluginEngine paramWebViewPluginEngine)
  {
    if (paramWebViewPluginEngine != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = paramWebViewPluginEngine;
      if (paramWebViewPluginEngine != null) {
        paramWebViewPluginEngine.a(this);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\CustomWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */