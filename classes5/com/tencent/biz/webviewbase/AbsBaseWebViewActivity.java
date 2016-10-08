package com.tencent.biz.webviewbase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebviewPoolUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridge;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridgeUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jgh;
import jgi;
import jgj;
import jgk;
import jgl;
import jgm;
import jgn;
import jgo;
import jgp;
import jgq;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class AbsBaseWebViewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, WebViewPluginContainer, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter
{
  public static final String C = "keyAction";
  public static final String D = "actionSelectPicture";
  public static final String E = "Web_SetUserAgent";
  public static final String F = "Web_AdjustSettings";
  static final String I = "WebViewBase";
  public static final String K = "Web_qqbrowser_init_only_webview";
  private static final int jdField_a_of_type_Int = 0;
  public static final HashSet a;
  public String G = "";
  protected String H;
  public String J;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public AuthorizeConfig a;
  public FileChooserHelper a;
  private CustomWebChromeClient jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private WebAIOController jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
  public volatile AppInterface a;
  protected JsBridgeListener a;
  public volatile WebViewPluginEngine a;
  public final SwiftBrowserComponentsProvider a;
  protected final SwiftBrowserSetting a;
  public final SwiftBrowserStatistics a;
  public final SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle a;
  public final SwiftBrowserUIStyleHandler.SwiftIphoneTitleBarUI a;
  public final SwiftBrowserUIStyleHandler a;
  public final SwiftWebViewHttpBridge a;
  private WebViewClient jdField_a_of_type_ComTencentSmttSdkWebViewClient;
  public final Object a;
  private boolean jdField_a_of_type_Boolean;
  public final Handler b;
  public FrameLayout b;
  private Object jdField_b_of_type_JavaLangObject;
  private boolean jdField_b_of_type_Boolean;
  public long c;
  private boolean c;
  public long d = 5L;
  public long e;
  public long f;
  protected boolean h;
  public boolean i;
  protected volatile boolean j;
  public boolean k;
  protected boolean l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add("Meizu_M040");
    jdField_a_of_type_JavaUtilHashSet.add("YuLong_Coolpad8720Q");
    jdField_a_of_type_JavaUtilHashSet.add("YuLong_Coolpad 7269");
    jdField_a_of_type_JavaUtilHashSet.add("samsung_SM-G9006W");
  }
  
  public AbsBaseWebViewActivity()
  {
    this.jdField_c_of_type_Long = 4L;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider = a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = ((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(2));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting = ((SwiftBrowserSetting)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(-1));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics = ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(-2));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge = new SwiftWebViewHttpBridge(this, this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null) && (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
      return;
    }
    ThreadManager.a(new jgl(this), null, false);
  }
  
  private void a(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "start swiftHttp, init state:" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.b.get() + " url: " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.b.get()) {}
    int m;
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!SwiftWebViewHttpBridgeUtils.a(paramString)));
      m = SwiftWebViewHttpBridgeUtils.a(paramString);
      if ((m == 1) || (m == 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("WebViewBase", 2, new Object[] { "not support asyncMode: ", Integer.valueOf(m) });
    return;
    SwiftWebViewHttpBridge.jdField_a_of_type_Boolean = WebAccelerateHelper.isWebViewCache;
    Intent localIntent = getIntent();
    if (localIntent != null) {
      if (localIntent.getBooleanExtra("avoidLoginWeb", false)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.a(m, paramString, bool);
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.a(paramString, paramLong);
    }
  }
  
  private boolean a(String paramString)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.b(paramString));
  }
  
  private void b()
  {
    if (!this.j)
    {
      this.j = true;
      String str = getIntent().getStringExtra("url");
      if (WebSoUtils.b(str)) {
        ThreadManager.a(new jgn(this, str), null, false);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController == null) {
      this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController = a();
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController != null) {
      this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController.a(1135043, new Object[0]);
    }
  }
  
  public Activity a()
  {
    return this;
  }
  
  public View a()
  {
    return this.mContentView;
  }
  
  public final TouchWebView a(ViewGroup paramViewGroup)
  {
    Util.a("Web_qqbrowser_init_only_webview");
    Object localObject4 = getIntent();
    boolean bool = ((Intent)localObject4).getBooleanExtra("vasUsePreWebview", false);
    long l1 = System.currentTimeMillis();
    Object localObject1;
    Object localObject3;
    if (bool)
    {
      localObject1 = WebviewPoolUtils.a();
      if (localObject1 != null)
      {
        localObject3 = ((TouchWebView)localObject1).getContext();
        if ((localObject3 instanceof MutableContextWrapper))
        {
          ((MutableContextWrapper)localObject3).setBaseContext(this);
          ((TouchWebView)localObject1).clearHistory();
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new TouchWebView(this);
      }
      if (QLog.isColorLevel()) {
        QLog.d("webviewinit", 2, "TouchWebView cost = " + (System.currentTimeMillis() - l1));
      }
      ((TouchWebView)localObject3).setIntent((Intent)localObject4);
      Util.b("Web_qqbrowser_init_only_webview");
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) && (QLog.isColorLevel())) {
        QLog.w("WebViewBase", 2, "Caution! AppRuntime is null!");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a((CustomWebView)localObject3);
      ((TouchWebView)localObject3).setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
      System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = new jgh(this);
      }
      ((TouchWebView)localObject3).setWebChromeClient(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient);
      label239:
      WebSettings localWebSettings;
      if (this.jdField_a_of_type_ComTencentSmttSdkWebViewClient == null)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebViewBase", 2, "API Level >= 23");
          }
          this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new jgi(this);
        }
      }
      else
      {
        ((TouchWebView)localObject3).setWebViewClient(this.jdField_a_of_type_ComTencentSmttSdkWebViewClient);
        ((TouchWebView)localObject3).setScrollBarStyle(0);
        if ((BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 4).getBoolean("enableWebviewDebug", false)) && (Build.VERSION.SDK_INT >= 19)) {
          WebView.setWebContentsDebuggingEnabled(true);
        }
        Util.a("Web_AdjustSettings");
        localWebSettings = ((TouchWebView)localObject3).getSettings();
        Util.a("Web_SetUserAgent");
        localObject1 = localWebSettings.getUserAgentString();
        localObject4 = a();
        if (((TouchWebView)localObject3).getX5WebViewExtension() == null) {
          break label768;
        }
        bool = true;
        label324:
        localWebSettings.setUserAgentString(SwiftWebViewUtils.a((String)localObject1, (String)localObject4, bool));
        Util.b("Web_SetUserAgent");
        localWebSettings.setSavePassword(false);
        localWebSettings.setSaveFormData(false);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localObject1 = getPackageManager();
      }
      try
      {
        if (!((PackageManager)localObject1).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = ((PackageManager)localObject1).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {}
        }
        else
        {
          m = 1;
          label412:
          if (m != 0) {
            break label787;
          }
          bool = true;
          label420:
          localWebSettings.setDisplayZoomControls(bool);
          localWebSettings.setPluginsEnabled(true);
          localWebSettings.setJavaScriptEnabled(true);
          localWebSettings.setAllowContentAccess(true);
          localWebSettings.setDatabaseEnabled(true);
          localWebSettings.setDomStorageEnabled(true);
          localWebSettings.setAppCacheEnabled(true);
          String str = MobileQQ.getMobileQQ().getProcessName();
          localObject4 = "";
          localObject1 = localObject4;
          if (str != null)
          {
            m = str.lastIndexOf(':');
            localObject1 = localObject4;
            if (m > -1) {
              localObject1 = "_" + str.substring(m + 1);
            }
          }
          localWebSettings.setDatabasePath(getApplicationContext().getDir("database" + (String)localObject1, 0).getPath());
          localWebSettings.setAppCachePath(getApplicationContext().getDir("appcache" + (String)localObject1, 0).getPath());
          localWebSettings.setMediaPlaybackRequiresUserGesture(false);
          if (Build.VERSION.SDK_INT >= 11) {
            ((TouchWebView)localObject3).removeJavascriptInterface("searchBoxJavaBridge_");
          }
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          int m;
          ((TouchWebView)localObject3).requestFocus();
          ((TouchWebView)localObject3).setFocusableInTouchMode(true);
          ((TouchWebView)localObject3).setDownloadListener(new jgk(this, (TouchWebView)localObject3));
          CookieSyncManager.createInstance(getApplicationContext());
          if (((TouchWebView)localObject3).getX5WebViewExtension() != null)
          {
            this.jdField_c_of_type_Boolean = true;
            ((TouchWebView)localObject3).getX5WebViewExtension().setWebViewClientExtension(new jgp(this, (TouchWebView)localObject3));
            AIOOpenWebMonitor.b(getIntent(), "use_x5", "1");
          }
          for (;;)
          {
            ((TouchWebView)localObject3).getView().setOnTouchListener(this);
            if (this.l) {
              ((TouchWebView)localObject3).setMask(true);
            }
            Util.b("Web_AdjustSettings");
            if (paramViewGroup != null) {
              paramViewGroup.addView((View)localObject3);
            }
            return (TouchWebView)localObject3;
            localObject1 = null;
            break;
            if (QLog.isColorLevel()) {
              QLog.d("WebViewBase", 2, "API level < 23");
            }
            this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new jgj(this);
            break label239;
            label768:
            bool = false;
            break label324;
            m = 0;
            break label412;
            localRuntimeException = localRuntimeException;
            m = 0;
            break label412;
            label787:
            bool = false;
            break label420;
            AIOOpenWebMonitor.b(getIntent(), "use_x5", "2");
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
      continue;
      Object localObject2 = null;
    }
  }
  
  protected WebAIOController a()
  {
    return null;
  }
  
  public SwiftBrowserComponentsProvider a()
  {
    return new SwiftBrowserComponentsProvider(this, 63, null);
  }
  
  public WebView a()
  {
    throw new UnsupportedOperationException("must override this method getHostWebView()!");
  }
  
  protected String a()
  {
    return null;
  }
  
  public void a(Intent paramIntent)
  {
    init(paramIntent);
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int m = switchRequestCode(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", m);
    startActivity(paramIntent);
  }
  
  public void a(WebView paramWebView, int paramInt) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, String paramString) {}
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.jdField_a_of_type_Boolean)) {}
    for (int m = 1; paramBoolean; m = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d = true;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
    }
    if (paramInt1 == 0)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.rightViewText.setText(paramString2);
        this.rightViewText.setVisibility(0);
        this.rightViewText.bringToFront();
        this.rightViewImg.setImageResource(0);
        this.rightViewImg.setBackgroundColor(0);
        this.rightViewImg.setVisibility(8);
      }
      if (paramString3 != null)
      {
        paramInt1 = 0;
        if (paramString3.length() <= 0) {}
      }
      try
      {
        paramInt1 = Color.parseColor(paramString3);
        this.rightViewImg.setBackgroundColor(paramInt1);
        if ((paramString1 != null) && (m == 0))
        {
          this.rightViewImg.setOnClickListener(this);
          this.rightViewText.setOnClickListener(this);
          this.H = paramString1.trim();
          return;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramInt1 = 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
        this.H = null;
        return;
      }
    }
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    if (paramInt1 != 4)
    {
      paramBoolean = true;
      paramString3.d = paramBoolean;
      switch (paramInt1)
      {
      case 6: 
      default: 
        this.rightViewImg.setVisibility(8);
        label317:
        if (paramInt2 != 0)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView == null)
          {
            this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
            paramString3 = (RelativeLayout)findViewById(2131296798);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(7, 2131297392);
            localLayoutParams.addRule(6, 2131297392);
            localLayoutParams.setMargins(0, 0, 0, 0);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
            paramString3.addView(this.jdField_a_of_type_AndroidWidgetImageView);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          switch (paramInt2)
          {
          default: 
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            label449:
            if (!TextUtils.isEmpty(paramString2)) {
              this.rightViewImg.setContentDescription(paramString2);
            }
            if (paramOnClickListener != null) {
              this.rightViewImg.setOnClickListener(paramOnClickListener);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      return;
      paramBoolean = false;
      break;
      this.rightViewImg.setImageResource(2130840164);
      this.rightViewImg.setContentDescription(getResources().getString(2131368938));
      break label317;
      this.rightViewImg.setImageResource(2130840163);
      this.rightViewImg.setContentDescription(getResources().getString(2131368935));
      break label317;
      this.rightViewImg.setImageResource(2130838587);
      this.rightViewImg.setContentDescription(getResources().getString(2131368932));
      break label317;
      this.rightViewImg.setImageResource(2130838290);
      this.rightViewImg.setContentDescription(getResources().getString(2131368933));
      break label317;
      this.rightViewImg.setImageResource(2130840213);
      this.rightViewImg.setContentDescription(getResources().getString(2131368936));
      ((AnimationDrawable)this.rightViewImg.getDrawable()).start();
      break label317;
      this.rightViewImg.setImageResource(2130839430);
      this.rightViewImg.setContentDescription(getResources().getString(2131368937));
      break label317;
      this.rightViewImg.setImageResource(2130843170);
      this.rightViewImg.setContentDescription(getResources().getString(2131368937));
      break label317;
      this.rightViewImg.setImageResource(2130838092);
      this.rightViewImg.setContentDescription(getResources().getString(2131368934));
      break label317;
      this.rightViewImg.setImageResource(2130843226);
      this.rightViewImg.setContentDescription(getResources().getString(2131368934));
      break label317;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840077);
      break label449;
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label449;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label449;
      if ((paramString1 != null) && (m == 0))
      {
        this.rightViewImg.setOnClickListener(this);
        this.rightViewText.setOnClickListener(this);
        this.H = paramString1.trim();
      }
      else
      {
        this.H = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d = true;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(this.rightViewText.getText())) {
        this.rightViewText.setVisibility(0);
      }
      this.rightViewImg.setVisibility(0);
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(this.H))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(this.H, new String[] { "" });
        return true;
      }
    }
    return false;
  }
  
  public boolean a(long paramLong, Map paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public final TouchWebView b(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(paramViewGroup);
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public SwiftBrowserComponentsProvider b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider;
  }
  
  public void b(int paramInt)
  {
    this.leftView.setTextColor(paramInt);
    this.centerView.setTextColor(paramInt);
    this.rightViewText.setTextColor(paramInt);
    Drawable localDrawable2 = this.leftView.getBackground();
    Drawable localDrawable1 = this.rightViewImg.getDrawable();
    if (localDrawable2 != null)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable2;
        this.jdField_a_of_type_Boolean = true;
      }
      localDrawable2 = ImageUtil.a(localDrawable2, paramInt);
      if (localDrawable2 != null) {
        this.leftView.setBackgroundDrawable(localDrawable2);
      }
    }
    if (localDrawable1 != null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_Boolean = true;
      }
      localDrawable1 = ImageUtil.a(localDrawable1, paramInt);
      if (localDrawable1 != null) {
        this.rightViewImg.setImageDrawable(localDrawable1);
      }
    }
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public String c()
  {
    Intent localIntent = getIntent();
    String str2 = localIntent.getStringExtra("url");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = localIntent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    return str1;
  }
  
  public final void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null) && (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsBaseWebViewActivity", 2, "-->web engine and plugin initialized at process preload!");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, null, null);
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
      }
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject).put("data", paramIntent);
    if (a(8589934600L, (Map)localObject)) {}
    label478:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            int m = paramInt1 >> 8 & 0xFF;
            if (m <= 0) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
            {
              localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
              if (localObject != null)
              {
                if ((paramIntent != null) && (paramIntent.hasExtra("entryId")) && (((WebViewPluginEngine)localObject).a("card") == null)) {
                  ((WebViewPluginEngine)localObject).a(new String[] { "card" });
                }
                localObject = ((WebViewPluginEngine)localObject).a(m, true);
                if (localObject != null)
                {
                  ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(paramInt1 & 0xFF), paramInt2);
                  return;
                }
              }
            }
          } while (!QLog.isColorLevel());
          QLog.w("WebViewBase", 2, "Caution! activity result not handled!");
          return;
          if ((this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper == null) || (!this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper.a(paramInt1, paramInt2, paramIntent))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("WebViewBase", 2, "Activity result handled by FileChooserHelper.");
        return;
        if ((paramInt2 != -1) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
          break;
        }
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (paramIntent == null);
      localObject = paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject + "',{'r':0,'result':" + paramIntent + "});");
      for (;;)
      {
        try
        {
          if (new JSONObject(paramIntent).getInt("resultCode") != 0) {
            break label478;
          }
          this.h = bool;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WebViewBase", 2, "onActivityResult: mPayActionSucc=" + this.h);
          return;
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebViewBase", 2, "onActivityResult: mPayActionException=" + paramIntent.getMessage());
        return;
        bool = false;
      }
    } while (paramInt2 != 4660);
    setResult(4660);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "doOnCreate");
    }
    super.doOnCreate(paramBundle);
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramBundle);
    }
    if (!VipWebViewReportLog.a()) {
      VipWebViewReportLog.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    QQBrowserActivity.K += 1;
    this.l = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setTheme(2131559163);
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    WebAccelerateHelper.isWebViewCache = true;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
    this.i = false;
    paramBundle.g = false;
    this.J = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    b();
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "onDestroy");
    }
    QQBrowserActivity.K -= 1;
    Object localObject;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
      if (QQBrowserActivity.K > 0) {
        break label173;
      }
      bool = true;
    }
    for (;;)
    {
      ((WebAIOController)localObject).a(bool);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      this.i = true;
      ((SwiftBrowserStatistics)localObject).g = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.a();
      }
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
        if (localObject != null) {
          ((WebViewPluginEngine)localObject).a();
        }
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent() == null) {}
      }
      try
      {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.a("about:blank");
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
            this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
            this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
            return;
            label173:
            bool = false;
            break;
            localException1 = localException1;
            if (QLog.isColorLevel()) {
              QLog.d("WebViewBase", 2, "remove webview error");
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      a(8589934607L, null);
      continue;
      a(8589934608L, null);
      continue;
      a(8589934609L, null);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int m = -1;
    int n = 0;
    int i1;
    Object localObject;
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      i1 = paramIntent.getIntExtra("requestCode", -1);
      int i2 = i1 >> 8 & 0xFF;
      if (i2 > 0) {
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(i2, true);
            if (localObject != null) {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                break label216;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(i1 & 0xFF), m);
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.w("WebViewBase", 2, "Caution! activity result not handled!");
          }
          this.J = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        } while (!"android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()));
        m = n;
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
          m = n;
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(120, true);
            m = n;
            if (localObject != null)
            {
              m = n;
              if ((localObject instanceof BuscardJsPlugin))
              {
                ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)120, 0);
                m = 1;
              }
            }
          }
        }
      } while (m != 0);
      BuscardHelper.a(this.J, getActivity(), paramIntent);
      return;
      label216:
      m = 0;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "onPause");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) && (this.k)) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.onHideCustomView();
    }
    a(8589934597L, null);
    String str = BridgeHelper.a(getActivity(), this.J).a("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(getActivity());
    }
  }
  
  public void doOnResume()
  {
    c();
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "onResume");
    }
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).putExtra("selfuin", this.J);
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    a(2L, null);
    localObject = BridgeHelper.a(getActivity(), this.J).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(getActivity());
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if ((this.jdField_c_of_type_Long & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewBase", 2, "close on hide by wv param");
      }
      finish();
    }
  }
  
  public void e()
  {
    this.leftView.setTextColor(getResources().getColorStateList(2131428258));
    this.rightViewText.setTextColor(getResources().getColorStateList(2131428258));
    this.centerView.setTextColor(getResources().getColor(2131428260));
    if (this.rightViewImg != null)
    {
      Drawable localDrawable = this.rightViewImg.getDrawable();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      this.rightViewImg.setImageDrawable(localDrawable);
    }
    this.leftView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (getIntent().getBooleanExtra("finish_animation_up_down", false)) {
      overridePendingTransition(0, 2130968584);
    }
  }
  
  public Object getSystemService(String paramString)
  {
    if ("audio".equals(paramString))
    {
      if (this.jdField_b_of_type_JavaLangObject == null)
      {
        if ((this.jdField_c_of_type_Boolean) || (14 > Build.VERSION.SDK_INT) || (Build.VERSION.SDK_INT > 18)) {
          break label135;
        }
        if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig != null) {
          break label121;
        }
        paramString = AuthorizeConfig.a();
        this.jdField_a_of_type_ComTencentBizAuthorizeConfig = paramString;
        if (!paramString.a("enable_custom_am", Boolean.valueOf(false)).booleanValue()) {
          break label135;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebViewBase", 2, "using custom AudioManager");
        }
      }
      for (;;)
      {
        label121:
        try
        {
          if (this.jdField_b_of_type_JavaLangObject == null) {
            this.jdField_b_of_type_JavaLangObject = new jgq(getApplicationContext());
          }
          return this.jdField_b_of_type_JavaLangObject;
        }
        finally {}
        paramString = this.jdField_a_of_type_ComTencentBizAuthorizeConfig;
        break;
        label135:
        if (QLog.isColorLevel()) {
          QLog.d("WebViewBase", 2, "using system AudioManager");
        }
        this.jdField_b_of_type_JavaLangObject = super.getSystemService("audio");
      }
    }
    return super.getSystemService(paramString);
  }
  
  protected void init(Intent paramIntent)
  {
    super.init(paramIntent);
    if (this.vg != null) {
      this.vg.setOnTouchListener(new jgo(this));
    }
    removeWebViewLayerType();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.b = this.centerView;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c = this.rightViewText;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView = this.rightViewImg;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup = this.vg;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) && (this.k)) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.onHideCustomView();
    }
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.b())
      {
        finish();
        return true;
      }
      localObject = new HashMap(1);
      ((Map)localObject).put("target", Integer.valueOf(3));
    } while (a(8589934601L, (Map)localObject));
    if (((this.jdField_c_of_type_Long & 0x4) == 0L) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()))
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      return true;
    }
    Object localObject = (InputMethodManager)getSystemService("input_method");
    if ((localObject != null) && (getCurrentFocus() != null)) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) && (this.k))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.onHideCustomView();
      return true;
    }
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.rightViewImg) || (paramView == this.rightHighLView) || (paramView == this.rightViewText)) {
      a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    b();
    WebAccelerateHelper.getInstance().preGetKey(getIntent(), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    WebAccelerateHelper.getInstance().preCheckOffline(getIntent());
    WebAccelerateHelper.getInstance().preFetchResouce(getIntent());
    String str = c();
    boolean bool = WebAccelerateHelper.isWebViewCache;
    ThreadManager.a().post(new jgm(this, bool, str));
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "onCreate cache:" + bool);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      if (!bool)
      {
        if (!VipWebViewReportLog.a()) {
          VipWebViewReportLog.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        }
        a(str);
      }
      a();
    }
    paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT > 10) && (!jdField_a_of_type_JavaUtilHashSet.contains(paramBundle))) {
      getWindow().addFlags(16777216);
    }
    getWindow().setFormat(-3);
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.l = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      a(8589934604L, null);
    }
    if ((this.mSystemBarComp != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.h))
    {
      int m = getResources().getColor(2131428295);
      this.mSystemBarComp.a(m);
      this.mSystemBarComp.b(m);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.f = System.currentTimeMillis();
    }
    return false;
  }
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int m = switchRequestCode(paramWebViewPlugin, paramByte);
    if (m == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewBase", 2, "pluginStartActivityForResult not handled");
      }
      return m;
    }
    startActivityForResult(paramIntent, m);
    return m;
  }
  
  public boolean showPreview()
  {
    setImmersiveStatus();
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.init();
    }
    overridePendingTransition(0, 0);
    setContentViewNoTitle(2130903156);
    ((TextView)findViewById(2131297390)).setText(2131364471);
    return true;
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {}
    int m;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.a() == null);
      m = WebViewPluginEngine.a(paramWebViewPlugin);
      if (m != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebViewBase", 2, "switchRequestCode failed: webview index=" + 0 + ", pluginIndex=" + m);
    return -1;
    return m << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewbase\AbsBaseWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */