package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class WebViewPlugin$PluginRuntime
{
  private WeakReference a;
  private WeakReference b;
  private WeakReference c;
  private WeakReference d;
  
  public WebViewPlugin$PluginRuntime(Activity paramActivity, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = new WeakReference(paramActivity);
    this.b = new WeakReference(paramAppInterface);
    if ((paramActivity instanceof WebUiBaseInterface)) {
      this.d = new WeakReference((WebUiBaseInterface)paramActivity);
    }
  }
  
  public Activity a()
  {
    return (Activity)this.c.get();
  }
  
  public CustomWebView a()
  {
    if (this.a != null) {
      return (CustomWebView)this.a.get();
    }
    return null;
  }
  
  public AppInterface a()
  {
    return (AppInterface)this.b.get();
  }
  
  public WebUiBaseInterface a(Activity paramActivity)
  {
    if (this.d != null) {
      return (WebUiBaseInterface)this.d.get();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\WebViewPlugin$PluginRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */