package com.tencent.mobileqq.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.utils.WebStateReporter;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import whb;
import whc;
import whd;
import whe;
import whf;
import whg;

public abstract class AbsWebView
{
  public static final String j = "AbsWebView";
  public static final String l = " WebP/0.3.0";
  public long a;
  protected ProgressBar a;
  private CustomWebChromeClient jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
  public TouchWebView a;
  OfflinePlugin jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin;
  protected AppInterface a;
  public WebViewPluginEngine a;
  public WebStateReporter a;
  public WebViewProgressBar a;
  public WebViewProgressBarController a;
  private WebViewClient jdField_a_of_type_ComTencentSmttSdkWebViewClient;
  private final Object jdField_a_of_type_JavaLangObject;
  public JSONObject a;
  public long b;
  public ArrayList b;
  public long c;
  protected Context e;
  public boolean e;
  public boolean f;
  public Activity g;
  public String k;
  public String m;
  
  public AbsWebView(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter = new WebStateReporter();
    this.jdField_a_of_type_Long = -1L;
    this.m = "";
    this.jdField_e_of_type_Boolean = true;
    this.f = true;
    this.jdField_e_of_type_AndroidContentContext = paramContext;
    this.g = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "bindAllJavaScript");
    }
    long l1 = System.currentTimeMillis();
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      a(this.jdField_b_of_type_JavaUtilArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "bindAllJavaScript time = " + (System.currentTimeMillis() - l1));
      }
      return;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 8
    //   11: iconst_2
    //   12: ldc 124
    //   14: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 126	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   21: ifnull +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: getfield 48	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   29: astore_1
    //   30: aload_1
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 126	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   36: ifnonnull +101 -> 137
    //   39: aload_0
    //   40: invokespecial 128	com/tencent/mobileqq/webview/AbsWebView:b	()V
    //   43: iconst_0
    //   44: istore 6
    //   46: iconst_0
    //   47: istore 7
    //   49: iload 7
    //   51: istore 4
    //   53: aload_0
    //   54: getfield 71	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   57: invokestatic 133	com/tencent/mobileqq/webprocess/PreloadService:a	(Lmqq/app/AppRuntime;)Z
    //   60: ifeq +53 -> 113
    //   63: iload 7
    //   65: istore 4
    //   67: getstatic 135	com/tencent/mobileqq/webprocess/PreloadService:d	Z
    //   70: ifne +43 -> 113
    //   73: iload 7
    //   75: istore 4
    //   77: getstatic 137	com/tencent/mobileqq/webprocess/PreloadService:jdField_b_of_type_Boolean	Z
    //   80: ifeq +33 -> 113
    //   83: getstatic 138	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   86: astore_2
    //   87: aload_0
    //   88: aload_2
    //   89: putfield 126	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   92: aload_2
    //   93: ifnull +52 -> 145
    //   96: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +154 -> 253
    //   102: ldc 8
    //   104: iconst_2
    //   105: ldc -116
    //   107: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: goto +143 -> 253
    //   113: iload 4
    //   115: ifeq +102 -> 217
    //   118: aload_0
    //   119: getfield 126	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   122: aload_0
    //   123: getfield 71	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   126: aload_0
    //   127: getfield 69	com/tencent/mobileqq/webview/AbsWebView:g	Landroid/app/Activity;
    //   130: aload_0
    //   131: getfield 95	com/tencent/mobileqq/webview/AbsWebView:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   134: invokevirtual 145	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Ljava/util/List;)V
    //   137: aload_1
    //   138: monitorexit
    //   139: return
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: getstatic 146	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   148: astore_2
    //   149: aload_2
    //   150: monitorenter
    //   151: getstatic 146	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   154: ldc2_w 147
    //   157: invokevirtual 152	java/lang/Object:wait	(J)V
    //   160: getstatic 138	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   163: astore_3
    //   164: aload_0
    //   165: aload_3
    //   166: putfield 126	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   169: aload_3
    //   170: ifnull +77 -> 247
    //   173: iload 5
    //   175: istore 4
    //   177: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +15 -> 195
    //   183: ldc 8
    //   185: iconst_2
    //   186: ldc -102
    //   188: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iload 5
    //   193: istore 4
    //   195: aload_2
    //   196: monitorexit
    //   197: goto -84 -> 113
    //   200: astore_3
    //   201: aload_2
    //   202: monitorexit
    //   203: aload_3
    //   204: athrow
    //   205: astore_3
    //   206: aload_3
    //   207: invokevirtual 157	java/lang/InterruptedException:printStackTrace	()V
    //   210: iload 6
    //   212: istore 4
    //   214: goto -19 -> 195
    //   217: aload_0
    //   218: invokestatic 163	com/tencent/mobileqq/webprocess/WebAccelerateHelper:getInstance	()Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper;
    //   221: aload_0
    //   222: getfield 71	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   225: aload_0
    //   226: getfield 69	com/tencent/mobileqq/webview/AbsWebView:g	Landroid/app/Activity;
    //   229: aconst_null
    //   230: aload_0
    //   231: invokevirtual 166	com/tencent/mobileqq/webview/AbsWebView:a	()Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper$CommonJsPluginFactory;
    //   234: aload_0
    //   235: getfield 95	com/tencent/mobileqq/webview/AbsWebView:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   238: invokevirtual 170	com/tencent/mobileqq/webprocess/WebAccelerateHelper:createWebViewPluginEngine	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper$CommonJsPluginFactory;Ljava/util/List;)Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   241: putfield 126	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   244: goto -107 -> 137
    //   247: iconst_0
    //   248: istore 4
    //   250: goto -55 -> 195
    //   253: iconst_1
    //   254: istore 4
    //   256: goto -143 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	AbsWebView
    //   29	113	1	localObject1	Object
    //   86	7	2	localWebViewPluginEngine1	WebViewPluginEngine
    //   140	4	2	localObject2	Object
    //   163	7	3	localWebViewPluginEngine2	WebViewPluginEngine
    //   200	4	3	localObject4	Object
    //   205	2	3	localInterruptedException	InterruptedException
    //   51	204	4	i	int
    //   1	191	5	n	int
    //   44	167	6	i1	int
    //   47	27	7	i2	int
    // Exception table:
    //   from	to	target	type
    //   32	43	140	finally
    //   53	63	140	finally
    //   67	73	140	finally
    //   77	92	140	finally
    //   96	110	140	finally
    //   118	137	140	finally
    //   137	139	140	finally
    //   141	143	140	finally
    //   145	151	140	finally
    //   203	205	140	finally
    //   217	244	140	finally
    //   151	169	200	finally
    //   177	191	200	finally
    //   195	197	200	finally
    //   201	203	200	finally
    //   206	210	200	finally
    //   151	169	205	java/lang/InterruptedException
    //   177	191	205	java/lang/InterruptedException
  }
  
  private void d(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "initWebView");
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.k, 1L, null)) {}
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings();
    paramAppInterface = localWebSettings.getUserAgentString();
    String str1 = a();
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      localWebSettings.setUserAgentString(SwiftWebViewUtils.a(paramAppInterface, str1, bool));
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      paramAppInterface = this.jdField_e_of_type_AndroidContentContext.getPackageManager();
      try
      {
        if (!paramAppInterface.hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = paramAppInterface.hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {}
        }
        else
        {
          i = 1;
          if (i != 0) {
            break label503;
          }
          bool = true;
          localWebSettings.setDisplayZoomControls(bool);
          localWebSettings.setPluginsEnabled(true);
          localWebSettings.setJavaScriptEnabled(true);
          localWebSettings.setAllowContentAccess(true);
          localWebSettings.setDatabaseEnabled(true);
          localWebSettings.setDomStorageEnabled(true);
          localWebSettings.setAppCacheEnabled(true);
          String str2 = MobileQQ.getMobileQQ().getProcessName();
          str1 = "";
          paramAppInterface = str1;
          if (str2 != null)
          {
            i = str2.lastIndexOf(':');
            paramAppInterface = str1;
            if (i > -1) {
              paramAppInterface = "_" + str2.substring(i + 1);
            }
          }
          localWebSettings.setDatabasePath(this.jdField_e_of_type_AndroidContentContext.getApplicationContext().getDir("database" + paramAppInterface, 0).getPath());
          localWebSettings.setAppCachePath(this.jdField_e_of_type_AndroidContentContext.getApplicationContext().getDir("appcache" + paramAppInterface, 0).getPath());
          if (Build.VERSION.SDK_INT >= 11) {
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
          }
        }
      }
      catch (RuntimeException paramAppInterface)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.requestFocus();
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.setFocusableInTouchMode(true);
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(new whc(this));
            CookieSyncManager.createInstance(this.jdField_e_of_type_AndroidContentContext.getApplicationContext());
            if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null)
            {
              this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().setWebViewClientExtension(new whg(this, this.jdField_a_of_type_ComTencentBizUiTouchWebView));
              if (this.jdField_e_of_type_AndroidContentContext.getSharedPreferences("WebView_X5_Report", 4).getBoolean("enableX5Report", true))
              {
                paramAppInterface = new Bundle();
                paramAppInterface.putBoolean("enabled", true);
                this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().invokeMiscMethod("webPerformanceRecordingEnabled", paramAppInterface);
              }
            }
            return;
            bool = false;
            break;
            int i = 0;
            continue;
            paramAppInterface = paramAppInterface;
            i = 0;
          }
          label503:
          bool = false;
        }
        catch (Exception paramAppInterface)
        {
          for (;;) {}
        }
      }
    }
  }
  
  private void h()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "API Level >= 23");
      }
    }
    for (this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new whd(this);; this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new whe(this))
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setWebViewClient(this.jdField_a_of_type_ComTencentSmttSdkWebViewClient);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "API level < 23");
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = new whf(this);
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setWebChromeClient(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).a("offline");
        if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)localObject);
        }
      }
    }
  }
  
  public void A()
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.reload();
  }
  
  public final void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "preInitPluginEngine");
    }
    WebViewPluginEngine localWebViewPluginEngine;
    if ((PreloadService.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) && (!PreloadService.d))
    {
      localWebViewPluginEngine = PreloadService.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = localWebViewPluginEngine;
      if (localWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "use reader preloaded web engine!");
        }
        b();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.g, this.jdField_b_of_type_JavaUtilArrayList);
        return;
      }
    }
    if ((PreloadService.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) && (!PreloadService.jdField_e_of_type_Boolean))
    {
      localWebViewPluginEngine = PreloadService.jdField_b_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = localWebViewPluginEngine;
      if (localWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "use comic preloaded web engine!");
        }
        b();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.g, this.jdField_b_of_type_JavaUtilArrayList);
        return;
      }
    }
    if (!WebAccelerateHelper.isWebViewCache)
    {
      localWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = localWebViewPluginEngine;
      if (localWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "use preloaded web engine!");
        }
        b();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.g, this.jdField_b_of_type_JavaUtilArrayList);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "WebAccelerateHelper.isWebViewCache:" + WebAccelerateHelper.isWebViewCache + ",mPluginEngine=" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
    }
    ThreadManager.a(new whb(this), null, false);
  }
  
  public void C() {}
  
  protected final void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "bindBaseJavaScript");
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new OfflinePlugin());
      this.jdField_b_of_type_JavaUtilArrayList.add(new VasWebReport());
      this.jdField_b_of_type_JavaUtilArrayList.add(new WebSoPlugin());
      this.jdField_b_of_type_JavaUtilArrayList.add(new SosoPlugin());
      this.jdField_b_of_type_JavaUtilArrayList.add(new EventApiPlugin());
      this.jdField_b_of_type_JavaUtilArrayList.add(new UiApiPlugin());
      this.jdField_b_of_type_JavaUtilArrayList.add(new QWalletPayJsPlugin());
      this.jdField_b_of_type_JavaUtilArrayList.add(new VasCommonJsPlugin());
      return;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public long a()
  {
    k();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public CustomWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  protected WebAccelerateHelper.CommonJsPluginFactory a()
  {
    return new WebAccelerateHelper.CommonJsPluginFactory();
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  protected String a()
  {
    return null;
  }
  
  public void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void a(ValueCallback paramValueCallback, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, int paramInt) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, String paramString) {}
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback) {}
  
  public void a(ArrayList paramArrayList) {}
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return true;
  }
  
  public long b()
  {
    k();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_b_of_type_Long;
    }
    return 0L;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public final void b(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnBackPressed");
    }
    String str = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnBackPressed...url=" + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.b(this.jdField_e_of_type_AndroidContentContext, paramAppInterface.getLongAccountUin(), str, false);
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public long c()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public final void c(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(1);
    if (paramIntent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(paramIntent.getStringExtra("key_service_id"));
      long l2 = paramIntent.getLongExtra("startOpenPageTime", -1L);
      long l1 = l2;
      if (-1L == l2) {
        l1 = System.currentTimeMillis();
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(l1);
    }
  }
  
  public final void c(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "buildBaseWebView");
    }
    c();
    d(paramAppInterface);
    h();
    j();
  }
  
  public View d()
  {
    return null;
  }
  
  public void d() {}
  
  public void f(boolean paramBoolean)
  {
    ProgressBar localProgressBar;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
  
  public boolean f()
  {
    k();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.f;
    }
    return false;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean g()
  {
    k();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_e_of_type_Boolean;
    }
    return false;
  }
  
  public boolean h()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public final void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnResume");
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 2L, null);
      }
    }
  }
  
  public final void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnPause");
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onPause();
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934597L, null);
      }
    }
  }
  
  public final void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.a();
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localWebViewPluginEngine != null)
      {
        localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934596L, null);
        localWebViewPluginEngine.a();
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.a("about:blank");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\AbsWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */