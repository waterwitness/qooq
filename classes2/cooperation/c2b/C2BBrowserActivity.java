package cooperation.c2b;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class C2BBrowserActivity
  extends QQBrowserActivity
{
  public static final String a = "C2BBrowserActivity";
  public static final String b = "destroynotify";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  boolean jdField_a_of_type_Boolean;
  
  public C2BBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a()
  {
    if (super.getIntent().getBooleanExtra("destroynotify", false))
    {
      Intent localIntent = new Intent("tencent.c2b.action.C2BBrowser.destory");
      localIntent.putExtras(super.getIntent());
      localIntent.setPackage(getPackageName());
      sendBroadcast(localIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2BBrowserActivity", 2, "original mPluginEngine != null destroy it.");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    }
    int i = getIntent().getIntExtra("fromType", 1);
    boolean bool = super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(new String[] { "mqqc2b" });
    paramBundle = (C2BWebPlugin)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a("mqqc2b");
    if (paramBundle != null) {
      paramBundle.a(i);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = C2BDestoryReceiver.a(this, super.getIntent());
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    C2BDestoryReceiver.a(this, this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */