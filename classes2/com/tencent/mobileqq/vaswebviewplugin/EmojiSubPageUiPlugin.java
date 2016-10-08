package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

public class EmojiSubPageUiPlugin
  extends EmojiUiPlugin
{
  public EmojiSubPageUiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnActivityCreate()
  {
    this.mActivityType = 2;
    super.OnActivityCreate();
  }
  
  public void OnActivityPause()
  {
    super.OnActivityPause();
    this.mRuntime.a().loadUrl("javascript:var webviewEvent = document.createEvent('Events');webviewEvent.initEvent('webviewobserve');webviewEvent.name = 'stopAudio';document.dispatchEvent(webviewEvent);");
  }
  
  protected long getPluginBusiness()
  {
    return 8L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\EmojiSubPageUiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */