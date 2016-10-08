package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

public abstract class VasBasePlugin
  extends WebViewPlugin
{
  protected long business;
  public long onPageFinishedTime;
  public long onPageStartedTime;
  public long startOpenPageTime;
  
  public VasBasePlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.onPageStartedTime = -1L;
    this.onPageFinishedTime = -1L;
  }
  
  protected Intent getInfoIntent()
  {
    if (this.mRuntime.a() != null) {
      return this.mRuntime.a().getIntent();
    }
    return new Intent();
  }
  
  protected long getPluginBusiness()
  {
    return 0L;
  }
  
  protected void onCreate()
  {
    this.startOpenPageTime = getInfoIntent().getLongExtra("startOpenPageTime", System.currentTimeMillis());
    this.business = getInfoIntent().getLongExtra("business", 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasBasePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */