package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebShareServlet;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.ShareApiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.qphone.base.util.QLog;
import jim;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class ShareApiPlugin
  extends VasWebviewJsPlugin
{
  protected static final String a = "ShareApiPlugin";
  public static final String b = "share";
  public String c;
  public String d;
  public String e;
  public String f;
  
  public ShareApiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.mPluginNameSpace = "share";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && ("share".equals(paramString2)))
    {
      if ((paramString3 != null) && ("setShare".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "mSetData =" + paramJsBridgeListener);
          }
          if ((paramJsBridgeListener != null) && ("share".equals(paramJsBridgeListener.optString("type"))))
          {
            this.f = paramJsBridgeListener.optString("image");
            this.d = paramJsBridgeListener.optString("title");
            this.e = paramJsBridgeListener.optString("summary");
            this.c = paramJsBridgeListener.optString("shareURL");
          }
          paramJsBridgeListener = this.mRuntime.a(this.mRuntime.a());
          if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener instanceof WebUiUtils.ShareApiInterface))) {
            break label505;
          }
          paramString1 = (WebUiUtils.ShareApiInterface)paramJsBridgeListener;
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "Share JS deal cost=" + (System.currentTimeMillis() - paramString1.a()));
          }
          if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener instanceof WebUiUtils.WebShareInterface))) {
            break label505;
          }
          paramJsBridgeListener = (WebUiUtils.WebShareInterface)paramJsBridgeListener;
          paramString2 = paramJsBridgeListener.getShare();
          if (paramString2 == null) {
            break label505;
          }
          if (paramString1.a(paramString2.a()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShareApiPlugin", 2, "is not need load share js");
            }
          }
          else if ((TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.c)) || (this.e.startsWith("http://")) || (this.e.startsWith("https://")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShareApiPlugin", 2, "Share info imperfect, request from svr");
            }
            paramString1 = new NewIntent(this.mRuntime.a().getApplication(), WebShareServlet.class);
            paramString1.putExtra("extra_cmd", "SQQzoneSvc.getUrlInfo");
            paramString1.putExtra("extra_current_uin", this.mRuntime.a().getAccount());
            paramString1.putExtra("extra_url", paramString2.a());
            paramString1.setObserver(new jim(this, paramJsBridgeListener));
            this.mRuntime.a().startServlet(paramString1);
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label505;
          }
        }
        QLog.d("ShareApiPlugin", 2, "exception =" + paramJsBridgeListener);
        break label505;
        paramString1 = new Bundle();
        paramString1.putInt("extra_url_info_from", 3);
        paramJsBridgeListener.setSummary(this.d, this.e, this.c, this.f, paramString1);
      }
    }
    else {
      return false;
    }
    label505:
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\ShareApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */