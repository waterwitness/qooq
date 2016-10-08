package cooperation.qzone.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import org.json.JSONObject;

public class QzoneMoodPlugin
  extends QzoneInternalWebViewPlugin
{
  private boolean a;
  
  public QzoneMoodPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      RemoteHandleManager.a().a();
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("signInSuccess".equals(paramString3))
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1.optBoolean("shareToWX"))
        {
          paramJsBridgeListener = paramString1.optString("image");
          paramString1 = paramString1.optString("text");
          RemoteHandleManager.a().a().a(paramString1, paramJsBridgeListener);
          this.jdField_a_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null) {
          break label147;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QzoneMoodPlugin", 1, paramJsBridgeListener.getMessage());
        return false;
      }
    }
    else if ("editMoodSuccess".equals(paramString3))
    {
      paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setResult(-1);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
        return true;
      }
    }
    label147:
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneMoodPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */