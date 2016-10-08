package com.tencent.mobileqq.webview.build;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.AbsWebView;

public class WebViewDialogBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  protected Intent a;
  protected Activity b;
  protected Context b;
  protected AppInterface b;
  
  public WebViewDialogBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    this.a = paramIntent;
    this.jdField_b_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a() {}
  
  public final void a(AppInterface paramAppInterface)
  {
    super.c(paramAppInterface);
    d();
  }
  
  public void b(Bundle paramBundle) {}
  
  public void e() {}
  
  public final void e_()
  {
    super.B();
  }
  
  public void f() {}
  
  public void g() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\build\WebViewDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */