package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.appcommon.AppClient;

public class OpenAppDetailPlugin
  extends WebViewPlugin
{
  public static final String a = "openToAppDetail";
  
  public OpenAppDetailPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "openToAppDetail";
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.mRuntime.a().a());
    localBundle.putString("sid", this.mRuntime.a().getIntent().getStringExtra("vkey"));
    localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ");
    if ((paramString2 != null) && (paramString2.equals("true"))) {
      localBundle.putBoolean("autoDownload", true);
    }
    if (paramString3 != null) {
      localBundle.putString("packageName", paramString3);
    }
    AppClient.a(this.mRuntime.a(), paramString1, 2470, localBundle);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"openToAppDetail".equals(paramString2)) {}
    do
    {
      do
      {
        return false;
      } while (!"openAppDetailPage".equals(paramString3));
      if (paramVarArgs.length == 2)
      {
        a(paramVarArgs[0], paramVarArgs[1]);
        return true;
      }
    } while (paramVarArgs.length != 3);
    a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\OpenAppDetailPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */