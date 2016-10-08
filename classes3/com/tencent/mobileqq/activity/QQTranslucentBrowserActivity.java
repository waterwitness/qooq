package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class QQTranslucentBrowserActivity
  extends QQBrowserActivity
{
  public QQTranslucentBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427379);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null) {
      try
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setBackgroundColor(0);
        return i;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return i;
      }
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
    return i;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    getWindow().setBackgroundDrawableResource(2131427379);
    View localView = findViewById(2131297376);
    if (localView != null) {
      localView.setBackgroundResource(2131427379);
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQTranslucentBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */