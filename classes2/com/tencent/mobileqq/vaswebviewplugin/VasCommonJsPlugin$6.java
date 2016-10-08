package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.WebView;

final class VasCommonJsPlugin$6
  implements Runnable
{
  VasCommonJsPlugin$6(WebView paramWebView, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.val$webView != null) {}
    try
    {
      this.val$webView.loadUrl("javascript:" + this.val$script);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasCommonJsPlugin$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */