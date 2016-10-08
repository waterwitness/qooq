package com.tencent.mobileqq.webprocess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;
import wgu;
import wgw;

public class WebAccelerateHelper
{
  private static final String[] CFG_KEYS = { "preloadUrl" };
  public static final String CREATE_WEB_VIEW_PLUGIN_ENGINE = "createWebViewPluginEngine";
  public static final String KEY_PRELOAD_URL = "preloadUrl";
  public static final int NEED_CHECK_COOKIE = 1;
  public static final int NEED_ENABLE_WEB_AIO = 1;
  public static final int NEED_PREGET_KEY = 1;
  public static final int SW_ENABLE_WEB_AIO = 5;
  public static final int SW_HIDE_BOTTOM_BAR_IN_LANDSCAPE = 7;
  public static final int SW_PRELOAD_PT4TOKEN_SKEY = 3;
  public static final int SW_PRELOAD_TICKETS = 0;
  public static final int SW_QQBROWSER_ICON_ANIM = 4;
  public static final int SW_THUMBNAIL_WIDTH = 2;
  public static final int SW_TOTAL_NUM = 8;
  public static final int SW_VERIFY_COOKIE = 1;
  public static final int SW_WEB_CORE_DUMP_MASK = 6;
  private static final String TAG = "WebAccelerateHelper";
  private static WebAccelerateHelper instance;
  private static boolean isNeedGetWebView;
  public static boolean isWebViewCache;
  private static final Object lock = new Object();
  static volatile ArrayMap sWebViewFeatureConfigs;
  static volatile Integer[] sWebViewFeatureParams;
  public WebAccelerateHelper.TicketInfoListener mTicketInfoListener;
  private Integer[] mWebViewFeatureParamsForTool = { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(190), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(65535), Integer.valueOf(1) };
  public volatile String param;
  public View preloadBrowserView;
  private final Object sDPCLock = new Object();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    isNeedGetWebView = true;
  }
  
  public static WebAccelerateHelper getInstance()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new WebAccelerateHelper();
      }
      return instance;
    }
  }
  
  public void checkCookie(String paramString)
  {
    if ((isCheckCookie()) && (!TextUtils.isEmpty(paramString))) {
      ThreadManager.a(new wgw(this, paramString), 5, null, true);
    }
  }
  
  public void createWebView(Context paramContext)
  {
    if (isNeedGetWebView) {
      QbSdk.preInit(paramContext, new wgu(this, System.currentTimeMillis(), paramContext));
    }
  }
  
  public WebViewPluginEngine createWebViewPluginEngine(AppInterface paramAppInterface, Activity paramActivity, CustomWebView paramCustomWebView, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List paramList)
  {
    Util.a("createWebViewPluginEngine");
    if ((paramAppInterface != null) && (paramActivity == null) && (paramCustomWebView == null) && (paramList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerateHelper", 2, "preload webview engine(with no plugin list)");
      }
      paramAppInterface = new WebViewPluginEngine(paramAppInterface, paramCommonJsPluginFactory, null);
    }
    for (;;)
    {
      Util.b("createWebViewPluginEngine");
      if (paramAppInterface != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "plugin list:" + paramAppInterface.a());
        }
        return paramAppInterface;
        if ((paramAppInterface != null) && (paramActivity == null) && (paramCustomWebView == null) && (paramList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebAccelerateHelper", 2, "preload webview engine(with plugin list");
          }
          paramAppInterface = new WebViewPluginEngine(paramAppInterface, paramCommonJsPluginFactory, paramList);
          continue;
        }
        if ((paramAppInterface != null) && (paramList == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebAccelerateHelper", 2, "create webview engine(with no plugin list");
          }
          paramAppInterface = new WebViewPluginEngine(paramCustomWebView, paramActivity, paramAppInterface, paramCommonJsPluginFactory);
          continue;
        }
        if ((paramAppInterface != null) && (paramList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebAccelerateHelper", 2, "create webview engine(with plugin list");
          }
          paramAppInterface = new WebViewPluginEngine(paramCustomWebView, paramActivity, paramAppInterface, paramCommonJsPluginFactory, paramList);
        }
      }
      else
      {
        throw new IllegalArgumentException("No contructor to create webview engine,check your arguments!");
      }
      paramAppInterface = null;
    }
  }
  
  public WebViewPluginEngine createWebViewPluginEngine(AppInterface paramAppInterface, Activity paramActivity, CustomWebView paramCustomWebView, List paramList)
  {
    return createWebViewPluginEngine(paramAppInterface, paramActivity, paramCustomWebView, new WebAccelerateHelper.CommonJsPluginFactory(), paramList);
  }
  
  public String getTBSDpcParam()
  {
    if (TextUtils.isEmpty(this.param)) {}
    synchronized (this.sDPCLock)
    {
      if (TextUtils.isEmpty(this.param)) {
        this.param = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.tbs_switch.name(), "0|1");
      }
      return this.param;
    }
  }
  
  public ArrayMap getWebViewFeatureConfigs()
  {
    if (sWebViewFeatureConfigs == null) {}
    try
    {
      if (sWebViewFeatureConfigs == null)
      {
        Object localObject2 = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.WebViewConfig.name());
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "WebViewConfig:" + (String)localObject2);
        }
        ArrayMap localArrayMap = new ArrayMap(2);
        boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
        if (!bool) {
          try
          {
            localObject2 = new JSONObject((String)localObject2);
            String[] arrayOfString = CFG_KEYS;
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str = arrayOfString[i];
              localArrayMap.put(str, ((JSONObject)localObject2).optString(str));
              i += 1;
            }
            sWebViewFeatureConfigs = localArrayMap;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "WebView feature configs=" + sWebViewFeatureConfigs);
        }
      }
      return sWebViewFeatureConfigs;
    }
    finally {}
  }
  
  public Integer[] getWebViewFeatureParams()
  {
    if ((!TextUtils.isEmpty(BaseApplicationImpl.processName)) && (BaseApplicationImpl.processName.endsWith(":tool"))) {
      return this.mWebViewFeatureParamsForTool;
    }
    if (sWebViewFeatureParams == null) {}
    try
    {
      if (sWebViewFeatureParams == null)
      {
        String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.WebViewFeature.name());
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "WebViewFeature:" + str);
        }
        Integer[] arrayOfInteger = new Integer[8];
        Arrays.fill(arrayOfInteger, Integer.valueOf(-1));
        DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser());
        sWebViewFeatureParams = arrayOfInteger;
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "WebView feature params=" + Arrays.toString(sWebViewFeatureParams));
        }
      }
      return sWebViewFeatureParams;
    }
    finally {}
  }
  
  public boolean isCheckCookie()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "isCheckCookie");
    }
    return getWebViewFeatureParams()[1].intValue() == 1;
  }
  
  public boolean isEnableWebAio()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "isEnableWebAio");
    }
    getWebViewFeatureParams();
    return false;
  }
  
  public boolean isPreGetKey()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "isPreGetKey");
    }
    return getWebViewFeatureParams()[0].intValue() == 1;
  }
  
  public void onPluginRuntimeReady(WebViewPluginEngine paramWebViewPluginEngine, AppInterface paramAppInterface, Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    paramWebViewPluginEngine.a(paramAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "-->prepare plugin runtime cost:" + (System.currentTimeMillis() - l) + "(ms)");
    }
  }
  
  public void preCheckOffline(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "preCheckOffline");
    }
    Object localObject = "";
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("url");
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        paramIntent = paramIntent.getStringExtra("key_params_qq");
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = "";
        }
      }
    }
    paramIntent = SwiftBrowserOfflineHandler.a((String)localObject);
    if (paramIntent != null) {
      paramIntent.a(null, (String)localObject);
    }
  }
  
  public void preFetchResouce(Intent paramIntent)
  {
    int i = 1;
    int j = 0;
    Object localObject = "";
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("url");
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        paramIntent = paramIntent.getStringExtra("key_params_qq");
        localObject = paramIntent;
        if (paramIntent == null) {
          break label45;
        }
      }
    }
    label45:
    while (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramIntent = Uri.parse((String)localObject);
        if ((paramIntent == null) || (!paramIntent.isHierarchical())) {
          break label45;
        }
        if ("1".equals(paramIntent.getQueryParameter("x5PreFetch")))
        {
          if (!SwiftBrowserCookieMonster.a((String)localObject).a()) {
            break label253;
          }
          if (i == 0) {
            break label205;
          }
          paramIntent = new HashMap();
          paramIntent.put("User-Agent", SwiftWebViewUtils.a(SwiftWebViewUtils.b("x5prefetch_1.0"), "", false));
          WebAccelerator.prefetchResource(BaseApplicationImpl.getContext(), (String)localObject, paramIntent, false);
          QLog.i("WebAccelerateHelper", 1, "now prefetchResource " + Util.c((String)localObject, new String[0]));
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      if ("1".equals(paramIntent.getQueryParameter("x5PreConnect")))
      {
        i = 0;
        j = 1;
        continue;
        label205:
        if (j == 0) {
          break;
        }
        WebAccelerator.preConnect(BaseApplicationImpl.getContext(), (String)localObject, 1, false);
        QLog.i("WebAccelerateHelper", 1, "now preconnect " + Util.c((String)localObject, new String[0]));
        return;
      }
      label253:
      i = 0;
    }
  }
  
  public void preGetKey(Intent paramIntent, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "preGetKey");
    }
    Object localObject1 = "";
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getStringExtra("url");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = paramIntent.getStringExtra("key_params_qq");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    Object localObject2 = SwiftBrowserCookieMonster.a((String)localObject1);
    if (localObject2 != null) {
      ((SwiftBrowserCookieMonster)localObject2).a((String)localObject1, null, paramAppInterface, paramIntent);
    }
  }
  
  public void preGetKeyInPreloadService(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "PreGetKeyInfo...");
    }
    this.mTicketInfoListener = new WebAccelerateHelper.TicketInfoListener(this, null);
    ((TicketManager)paramAppRuntime.getManager(2)).registTicketManagerListener(this.mTicketInfoListener);
    SwiftBrowserCookieMonster.a(paramAppRuntime, new Intent());
  }
  
  public void preInflaterBrowserView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "preInflaterBrowserView");
    }
    try
    {
      long l = System.currentTimeMillis();
      this.preloadBrowserView = LayoutInflater.from(BaseApplicationImpl.a).inflate(2130903153, null);
      System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerateHelper", 2, "inflaterbrowserview cost = " + (System.currentTimeMillis() - l));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebAccelerateHelper", 1, "preInflaterBrowserView e = " + localException.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\webprocess\WebAccelerateHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */