package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.ProtectedWebView;
import java.io.File;
import mqq.app.AppRuntime;
import uiq;
import uir;

public class MovieDetailActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "k_same_tuin";
  private static final String jdField_b_of_type_JavaLangString = "Q.richstatus.";
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private JsBridge jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge;
  private StatusJsHandler jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler;
  private ProtectedWebView jdField_a_of_type_ComTencentWidgetProtectedWebView;
  private View jdField_b_of_type_AndroidViewView;
  private String c;
  private String d;
  
  public MovieDetailActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack())
    {
      a();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.goBack();
      return true;
      return false;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static boolean a(BaseActivity paramBaseActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    StatusManager localStatusManager = (StatusManager)paramBaseActivity.getAppRuntime().getManager(14);
    if (localStatusManager == null) {
      return false;
    }
    return localStatusManager.a(paramBaseActivity, paramString1, paramInt1, paramInt2, paramString2);
  }
  
  private void b()
  {
    Object localObject = (RelativeLayout)findViewById(2131305255);
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView = new ProtectedWebView(BaseApplicationImpl.a);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentWidgetProtectedWebView, 0, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setScrollBarStyle(0);
    localObject = this.jdField_a_of_type_ComTencentWidgetProtectedWebView.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setUserAgentString(((WebSettings)localObject).getUserAgentString() + " " + "QQ/5.2");
    ((WebSettings)localObject).setDatabaseEnabled(true);
    ((WebSettings)localObject).setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
    ((WebSettings)localObject).setDomStorageEnabled(true);
    ((WebSettings)localObject).setGeolocationEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebViewClient(new uir(this, null));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebChromeClient(new uiq(this, null));
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge = new JsBridge();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler = new StatusJsHandler(this, this.jdField_a_of_type_ComTencentWidgetProtectedWebView, null);
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler, "statusJsHandler");
    this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131305256));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131305257));
    this.b = findViewById(2131299498);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.b.setVisibility(0);
    }
  }
  
  private void c()
  {
    this.c = getIntent().getStringExtra("key_params_qq");
    this.d = getIntent().getStringExtra("k_same_tuin");
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.loadUrl(this.c);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack())
    {
      this.leftView.setText(2131367975);
      return;
    }
    this.leftView.setText(getIntent().getStringExtra("leftViewText"));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130905090);
    b();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
      try
      {
        this.jdField_a_of_type_ComTencentWidgetProtectedWebView.clearView();
        try
        {
          this.jdField_a_of_type_ComTencentWidgetProtectedWebView.destroy();
          return;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
  
  public boolean onBackEvent()
  {
    if (a()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 4) || (paramKeyEvent.getAction() == 0)) && (a())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richstatus\MovieDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */