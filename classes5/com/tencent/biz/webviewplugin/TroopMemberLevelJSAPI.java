package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class TroopMemberLevelJSAPI
  extends WebViewPlugin
{
  public static final String a = "troop_member_level_JS_API";
  
  public TroopMemberLevelJSAPI()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "troop_member_level_JS_API";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"troop_member_level_JS_API".equals(paramString2)) {
      return false;
    }
    if (("setTitleBar".equals(paramString3)) && (paramVarArgs.length == 3))
    {
      paramJsBridgeListener = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
      if (paramJsBridgeListener != null) {
        paramJsBridgeListener.a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
      }
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\TroopMemberLevelJSAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */