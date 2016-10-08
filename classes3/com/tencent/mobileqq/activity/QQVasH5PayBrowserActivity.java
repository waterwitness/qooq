package com.tencent.mobileqq.activity;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.smtt.sdk.WebView;

public class QQVasH5PayBrowserActivity
  extends QQBrowserActivity
{
  public QQVasH5PayBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    getWebView().setVisibility(0);
    return i;
  }
  
  protected void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    QRUtils.a(1, 2131364489);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    overridePendingTransition(0, 0);
    return bool;
  }
  
  protected int f(Bundle paramBundle)
  {
    int i = super.f(paramBundle);
    if ((this.c & 0x80000) != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
      getWindow().setBackgroundDrawableResource(2131427379);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentBizUiRefreshView.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() == null) {}
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.setLayerType(1, null);
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setBackgroundColor(0);
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      a(true);
      getWebView().setVisibility(4);
      return i;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setLayerType(1, null);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.setVisibility(0);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    getWindow().setBackgroundDrawableResource(2131427379);
    findViewById(2131297376).setBackgroundResource(2131427379);
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQVasH5PayBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */