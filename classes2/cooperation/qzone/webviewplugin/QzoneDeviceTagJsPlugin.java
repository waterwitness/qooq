package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import mqq.os.MqqHandler;
import yra;
import yrb;

public class QzoneDeviceTagJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  public static final String a = "Qzone";
  private static final String b = QzoneBlogJsPlugin.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().a(QzoneDeviceTagJsPlugin.class).post(new yra(paramArrayOfString));
  }
  
  private static void b(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().a(QzoneDeviceTagJsPlugin.class).post(new yrb());
  }
  
  public void a()
  {
    super.a();
    RemoteHandleManager.a().b(this);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.a == null) || (this.a.mRuntime == null)) {
      return false;
    }
    if ("GetDeviceInfo".equalsIgnoreCase(paramString3))
    {
      RemoteHandleManager.a().a(this);
      b(this.a, this.a.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetUserTail".equalsIgnoreCase(paramString3))
    {
      RemoteHandleManager.a().a(this);
      a(this.a, this.a.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("data");
          if (paramBundle != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(b, 2, "call js function,bundle is empty");
        return;
        if (!"cmd.getDeviceInfos".equals(paramString)) {
          break;
        }
        paramString = paramBundle.getString("param.DeviceInfos");
      } while (TextUtils.isEmpty(paramString));
      this.a.callJs("window.QZPhoneTagJSInterface.onReceive({code:0,data:" + paramString + "})");
      return;
    } while (!"cmd.setUserTail".equals(paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneDeviceTagJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */