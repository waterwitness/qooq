package com.tencent.mobileqq.vaswebviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

class IndividuationUIPlugin$1
  implements View.OnClickListener
{
  IndividuationUIPlugin$1(IndividuationUIPlugin paramIndividuationUIPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.activity, IndividuationUrlHelper.a(this.this$0.activity, "myIndividuation", ""), -1L, null, true, -1);
    ReportController.b(null, "CliOper", "", "", "Trends_tab", "Clk_mine_web", 0, 0, "", "", "", "");
    if (this.this$0.rtm == null) {
      this.this$0.rtm = new RedTouchManager(this.this$0.mRuntime.a());
    }
    this.this$0.myIndividuationRedTouch.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\IndividuationUIPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */