package cooperation.qzone.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneBasicJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String a = "Qzone";
  private String b;
  
  public QzoneBasicJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = QzoneBasicJsPlugin.class.getSimpleName();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    while ((!"openUrl".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.b, 2, "openUrl=" + paramVarArgs[0]);
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("url");
      this.a.mRuntime.a().loadUrl(paramJsBridgeListener);
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      QLog.e(this.b, 1, "handle openUrl", paramJsBridgeListener);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneBasicJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */