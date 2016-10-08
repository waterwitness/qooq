package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QzoneInterActiveVideoPlugin
  extends QzoneInternalWebViewPlugin
{
  private static final String jdField_a_of_type_JavaLangString = "QzoneInternalWebViewPlugin";
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static final String b = "com.qzone.module.browser.plugin.QzLivePlugin.liveMusicSelect";
  private static final String c = "get_live_music_song_mid";
  
  public QzoneInterActiveVideoPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!"qzlive".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if (("getLiveMusicUrl".equals(paramString3)) && (paramVarArgs.length == 1)) {
        try
        {
          jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramVarArgs[0]);
          bool1 = bool2;
          if (jdField_a_of_type_OrgJsonJSONObject != null)
          {
            paramJsBridgeListener = jdField_a_of_type_OrgJsonJSONObject.optJSONObject("data");
            paramJsBridgeListener.getString("file_mid");
            paramJsBridgeListener = paramJsBridgeListener.getString("song_mid");
            paramString1 = new Intent("com.qzone.module.browser.plugin.QzLivePlugin.liveMusicSelect");
            paramString1.putExtra("get_live_music_song_mid", paramJsBridgeListener);
            BaseApplicationImpl.a().sendBroadcast(paramString1);
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null)
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
                return true;
              }
            }
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.w("QzoneInternalWebViewPlugin", 1, "getLiveMusicUrl Exception" + paramJsBridgeListener.toString());
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneInterActiveVideoPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */