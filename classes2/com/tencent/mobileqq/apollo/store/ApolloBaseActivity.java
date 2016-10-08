package com.tencent.mobileqq.apollo.store;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebStatisticsInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;
import prd;

public class ApolloBaseActivity
  extends AbsBaseWebViewActivity
  implements WebUiUtils.WebStatisticsInterface, WebUiUtils.WebUiMethodInterface, WebUiUtils.WebviewReportSpeedInterface
{
  public static final String a = "extra_key_click_time";
  private static int jdField_b_of_type_Int = 0;
  public static final String b = "ApolloBaseActivity";
  private int jdField_a_of_type_Int;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  protected TouchWebView a;
  private OfflinePlugin jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin;
  private boolean jdField_a_of_type_Boolean;
  protected long b;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  private boolean c;
  protected long g;
  private long h;
  private long i;
  private long j;
  
  public ApolloBaseActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a()
  {
    if (this.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Boolean = true;
      try
      {
        k = NetworkUtil.a(getApplicationContext());
        switch (k)
        {
        default: 
          CharSequence localCharSequence = null;
          k = jdField_b_of_type_Int;
          if (TextUtils.isEmpty(localCharSequence)) {
            continue;
          }
          if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
            this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("apollo_WebView_Report_Step", 0);
          }
          ThreadManager.a(new prd(this, localCharSequence, k), 5, null, false);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int k = 0;
          continue;
          String str = "2G";
          continue;
          str = "3G";
          continue;
          str = "4G";
          continue;
          str = "wifi";
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.h;
  }
  
  public JSONObject a()
  {
    return null;
  }
  
  public void a(long paramLong)
  {
    this.i = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBaseActivity", 2, "mClickTime->" + this.j + "mCurrentStepTime->" + this.i + " mCurrentStep->" + this.jdField_a_of_type_Int);
    }
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.h = System.currentTimeMillis();
    }
    if (!"about:blank".equalsIgnoreCase(paramString))
    {
      this.jdField_a_of_type_Int = 2;
      this.i = System.currentTimeMillis();
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBaseActivity", 2, "mCurrentUrl->" + this.jdField_c_of_type_JavaLangString);
      }
    }
    return super.a(paramWebView, paramString);
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.jdField_a_of_type_Int == 2))
    {
      this.jdField_a_of_type_Int = 8;
      this.i = System.currentTimeMillis();
    }
  }
  
  public void b_(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public long c()
  {
    return this.j;
  }
  
  public long d()
  {
    return this.g;
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null))
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
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.f;
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    a();
    jdField_b_of_type_Int -= 1;
  }
  
  public long e()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public boolean e()
  {
    return true;
  }
  
  public long f()
  {
    return 0L;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public long g()
  {
    return 0L;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public String getCurrentUrl()
  {
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    }
    return (String)localObject2;
  }
  
  public CustomWebView getWebView()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public long h()
  {
    return 0L;
  }
  
  public void hideQQBrowserButton() {}
  
  public long i()
  {
    return 0L;
  }
  
  public boolean isActivityResume()
  {
    return this.mIsResume;
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public long j()
  {
    return 0L;
  }
  
  public long k()
  {
    return 0L;
  }
  
  public long l()
  {
    return 0L;
  }
  
  public long m()
  {
    return 0L;
  }
  
  public long n()
  {
    return 0L;
  }
  
  protected boolean onBackEvent()
  {
    a();
    return super.onBackEvent();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (WebAccelerateHelper.isWebViewCache) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Int = 1;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Long = l;
    this.i = l;
    this.j = getIntent().getLongExtra("extra_key_click_time", this.jdField_a_of_type_Long);
    super.onCreate(paramBundle);
    jdField_b_of_type_Int += 1;
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (Build.VERSION.SDK_INT >= 14) && (SwiftBrowserShareMenuHandler.a.length >= 1))
    {
      int k = SwiftBrowserShareMenuHandler.a[1];
      paramBundle = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings();
      if (paramBundle != null) {
        paramBundle.setTextZoom(k);
      }
    }
  }
  
  public void setBottomBarVisible(boolean paramBoolean) {}
  
  public void showActionSheet() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */