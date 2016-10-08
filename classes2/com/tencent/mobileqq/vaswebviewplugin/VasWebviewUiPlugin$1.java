package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class VasWebviewUiPlugin$1
  implements Runnable
{
  VasWebviewUiPlugin$1(VasWebviewUiPlugin paramVasWebviewUiPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.this$0.mRuntime.a() != null) {
      this.this$0.mRuntime.a().loadUrl(this.val$url);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("VasWebviewUiPlugin", 2, "mRuntime.getWebView() still null!!!!!");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasWebviewUiPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */