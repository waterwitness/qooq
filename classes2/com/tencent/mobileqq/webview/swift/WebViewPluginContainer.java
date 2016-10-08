package com.tencent.mobileqq.webview.swift;

import android.content.Intent;

public abstract interface WebViewPluginContainer
{
  public abstract int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte);
  
  public abstract int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\WebViewPluginContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */