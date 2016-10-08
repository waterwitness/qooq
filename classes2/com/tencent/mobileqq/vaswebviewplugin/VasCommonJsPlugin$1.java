package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class VasCommonJsPlugin$1
  implements Runnable
{
  VasCommonJsPlugin$1(VasCommonJsPlugin paramVasCommonJsPlugin, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasCommonJsPlugin", 2, "subthread,  isX5:" + this.val$finalIsX5 + ", isDebugSwitch: " + this.val$finalIsDebugSwitch + ", isFirstenter: " + this.val$finalIsFirstEnter);
    }
    if (((this.val$finalIsDebugSwitch) || (this.val$finalIsFirstEnter)) && (this.val$finalIsX5) && (this.this$0.mRuntime.a() != null))
    {
      Intent localIntent = new Intent(this.this$0.mRuntime.a(), SplashActivity.class);
      this.this$0.mRuntime.a().startActivity(localIntent);
      Utils.a(this.this$0.mRuntime.a(), "com.tencent.mobileqq:web");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasCommonJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */