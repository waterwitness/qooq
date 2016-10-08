import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QZoneLiveJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class yqw
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public yqw(QZoneLiveJsPlugin paramQZoneLiveJsPlugin, JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    boolean bool = false;
    if (paramPluginManagerClient == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneLiveJsPlugin", 2, "context 为空，返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneLiveJsPlugin", 2, "pluginManagerClient 为空，返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      }
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
    }
    catch (JSONException paramPluginManagerClient)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("QZoneLiveJsPlugin", 2, "", paramPluginManagerClient);
      return;
      if (((PluginBaseInfo)localObject).mState != 4) {
        break label299;
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", true);
      if (!QLog.isColorLevel()) {
        break label270;
      }
      QLog.i("QZoneLiveJsPlugin", 2, "插件已安装，返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      label270:
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
      label299:
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
      if (!QLog.isColorLevel()) {
        break label368;
      }
      QLog.i("QZoneLiveJsPlugin", 2, "插件未安装,state=" + ((PluginBaseInfo)localObject).mState + "needInstall：" + this.jdField_a_of_type_Boolean + "返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      label368:
      if (!this.jdField_a_of_type_Boolean) {
        break label446;
      }
      int i = NetworkState.b();
      if (!QLog.isColorLevel()) {
        break label421;
      }
      Object localObject = new StringBuilder().append("NetworkState.NET_TYPE_WIFI == type:");
      if (1 != i) {
        break label406;
      }
      bool = true;
      label406:
      QLog.i("QZoneLiveJsPlugin", 2, bool);
      label421:
      if (1 != i) {
        break label446;
      }
      if (!QLog.isColorLevel()) {
        break label440;
      }
      QLog.i("QZoneLiveJsPlugin", 2, "开始下载");
      label440:
      paramPluginManagerClient.installPlugin("qzone_live_video_plugin.apk");
      label446:
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    }
    localObject = paramPluginManagerClient.queryPlugin("qzone_live_video_plugin.apk");
    if (localObject == null)
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneLiveJsPlugin", 2, "pluginInfo 为空，返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      }
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */