package com.tencent.biz.webviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QZoneTihSettingWebPlugin
  extends WebViewPlugin
{
  public static final String a = "aciton_switch_tih_setting";
  public static final String b = "qztodayinhistory";
  public static final String c = "settihnome";
  public static final String d = QZoneTihSettingWebPlugin.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneTihSettingWebPlugin()
  {
    this.mPluginNameSpace = "qztodayinhistory";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "handleJsRequest url: " + paramString1 + "pkgName:" + paramString2 + "method:" + paramString3);
    }
    if (!paramString2.equals("qztodayinhistory")) {}
    while (!paramString3.equals("settihnome")) {
      return false;
    }
    paramJsBridgeListener = new Intent("aciton_switch_tih_setting");
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "actionString: " + paramJsBridgeListener.getAction());
    }
    BaseApplication.getContext().sendBroadcast(paramJsBridgeListener);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\QZoneTihSettingWebPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */