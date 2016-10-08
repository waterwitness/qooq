package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebTitleBarInterface)))
    {
      this.this$0.progressDialog = new QQProgressDialog(this.this$0.mRuntime.a(), ((WebUiUtils.WebTitleBarInterface)localWebUiBaseInterface).getTitleBarHeight());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\EmojiJsPlugin$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */