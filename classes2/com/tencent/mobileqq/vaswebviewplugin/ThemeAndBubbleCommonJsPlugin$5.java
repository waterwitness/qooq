package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.File;

class ThemeAndBubbleCommonJsPlugin$5
  implements Runnable
{
  ThemeAndBubbleCommonJsPlugin$5(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin, String paramString, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = HttpDownloadUtil.a(this.this$0.mRuntime.a(), this.val$joinUrl, this.val$f);
    Message localMessage = new Message();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("downResult", i);
    localMessage.setData(localBundle);
    this.this$0.handler.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeAndBubbleCommonJsPlugin$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */