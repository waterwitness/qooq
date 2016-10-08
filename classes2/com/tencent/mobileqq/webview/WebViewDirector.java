package com.tencent.mobileqq.webview;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.build.IWebViewBuilder;
import com.tencent.qphone.base.util.QLog;

public class WebViewDirector
{
  private static final String jdField_a_of_type_JavaLangString = "WebViewDirector";
  public long a;
  private IWebViewBuilder jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public WebViewDirector(IWebViewBuilder paramIWebViewBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder = paramIWebViewBuilder;
  }
  
  public void a(Bundle paramBundle, AppInterface paramAppInterface, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_init_webview_plugin", true))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.e_();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_get_key", true))) {
      WebAccelerateHelper.getInstance().preGetKey(paramIntent, paramAppInterface);
    }
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.a();
    long l1 = System.currentTimeMillis();
    this.b = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.b(paramBundle);
    l2 = System.currentTimeMillis();
    this.e = (l2 - l1);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.e();
    l1 = System.currentTimeMillis();
    this.c = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.f();
    l2 = System.currentTimeMillis();
    this.d = (l2 - l1);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.a(paramAppInterface);
    l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Long = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.g();
    this.f = (System.currentTimeMillis() - l1);
    if (QLog.isColorLevel()) {
      QLog.i("WebViewDirector", 2, "buildLayoutTime : " + this.b + ", buildContentTime " + this.e + ", buildTitleTime " + this.c + ", buildWebViewTime " + this.jdField_a_of_type_Long + ", buildBottomTime " + this.d + ", buildDataTime " + this.f);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\WebViewDirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */