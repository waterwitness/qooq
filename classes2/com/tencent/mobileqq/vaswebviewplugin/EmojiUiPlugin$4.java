package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiUiPlugin$4
  implements Runnable
{
  EmojiUiPlugin$4(EmojiUiPlugin paramEmojiUiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.this$0.progressDialog = new QQProgressDialog(this.this$0.mRuntime.a(), ((QQBrowserActivity)this.this$0.mRuntime.a()).getTitleBarHeight());
    this.this$0.progressDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\EmojiUiPlugin$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */