package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import yqt;
import yqu;

public class QZoneGiftFullScreenJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  public static final String a = "Qzone";
  public static final String b = "http://h5.qzone.qq.com/gift/detail?_wv=2097155&_bid=2188&uin={uin}&ugcid={ugcid}";
  private static final String c = QZoneGiftFullScreenJsPlugin.class.getSimpleName();
  private QzoneGiftFullScreenViewController a;
  private String d = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    String str;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      str = "";
    }
    do
    {
      for (;;)
      {
        try
        {
          paramPluginRuntime = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = paramPluginRuntime.getString("giftid");
          paramPluginRuntime.printStackTrace();
        }
        catch (JSONException paramPluginRuntime)
        {
          try
          {
            paramPluginRuntime = paramPluginRuntime.getString("callback");
            if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(paramPluginRuntime))) {
              break;
            }
            return;
          }
          catch (JSONException paramPluginRuntime)
          {
            for (;;)
            {
              continue;
              int i = 0;
            }
          }
          paramPluginRuntime = paramPluginRuntime;
          paramWebViewPlugin = "";
        }
        paramPluginRuntime = str;
      }
      paramWebViewPlugin = new File(QzoneGiftFullScreenActionManager.a(paramWebViewPlugin) + MagicfaceResLoader.a());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null);
    paramWebViewPlugin = "window." + paramPluginRuntime + "(" + "{checkGift:" + i + "}" + ")";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramWebViewPlugin);
  }
  
  private void b(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().a(QzoneDeviceTagJsPlugin.class).post(new yqt(this, paramArrayOfString));
  }
  
  private void c(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    String str;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      str = "";
    }
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            paramPluginRuntime = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = paramPluginRuntime.getString("giftid");
            paramPluginRuntime.printStackTrace();
          }
          catch (JSONException paramPluginRuntime)
          {
            try
            {
              paramPluginRuntime = paramPluginRuntime.getString("callback");
              if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(paramPluginRuntime))) {
                break;
              }
              return;
            }
            catch (JSONException paramPluginRuntime)
            {
              for (;;) {}
            }
            paramPluginRuntime = paramPluginRuntime;
            paramWebViewPlugin = "";
          }
          paramPluginRuntime = str;
        }
        paramArrayOfString = new File(QzoneGiftFullScreenActionManager.a(paramWebViewPlugin));
      } while ((!paramArrayOfString.exists()) || (!paramArrayOfString.isDirectory()));
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController = new QzoneGiftFullScreenViewController(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
    } while (!QzoneGiftFullScreenViewController.a());
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.a(paramWebViewPlugin, new yqu(this, paramPluginRuntime));
  }
  
  public void a()
  {
    super.a();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ("checkGift".equalsIgnoreCase(paramString3))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("downloadGift".equalsIgnoreCase(paramString3))
    {
      RemoteHandleManager.a().a(this);
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("playGift".equalsIgnoreCase(paramString3))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934601L)
    {
      String str = QzoneConfig.a().a("H5Url", "GiftDetailPage", "http://h5.qzone.qq.com/gift/detail?_wv=2097155&_bid=2188&uin={uin}&ugcid={ugcid}");
      if (!TextUtils.isEmpty(str))
      {
        int i = str.indexOf("?");
        if (i != -1)
        {
          str = str.substring(0, i);
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str)) && (this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController != null)) {
            this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.b();
          }
        }
      }
    }
    return super.a(paramString, paramLong, paramMap);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    for (;;)
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(c, 2, "call js function,bundle is empty");
        }
      }
      else if ("cmd.downloadGift".equals(paramString))
      {
        int i = paramBundle.getInt("Gift_DownloadProgress_FullScreen");
        paramString = "-1";
        if (i > 0) {
          if (i >= 100) {
            break label169;
          }
        }
        label169:
        for (paramString = String.format("%.1f", new Object[] { Double.valueOf(i * 0.01D) }); (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (!TextUtils.isEmpty(this.d)); paramString = "1")
        {
          paramString = "window." + this.d + "(" + "{downloadGift:" + paramString + "}" + ")";
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString);
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QZoneGiftFullScreenJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */