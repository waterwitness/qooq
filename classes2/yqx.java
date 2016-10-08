import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QZoneLiveJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class yqx
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public yqx(QZoneLiveJsPlugin paramQZoneLiveJsPlugin, JSONObject paramJSONObject, boolean paramBoolean, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null) {
      return;
    }
    try
    {
      localPluginRecord = paramIQZonePluginManager.a("qzone_live_video_plugin_hack.apk");
      if ((localPluginRecord == null) || (localPluginRecord.e != 4)) {
        break label104;
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", true);
    }
    catch (JSONException paramIQZonePluginManager)
    {
      for (;;)
      {
        PluginRecord localPluginRecord;
        paramIQZonePluginManager.printStackTrace();
        return;
        if ((localPluginRecord != null) && ((localPluginRecord.e == 2) || (NetworkState.c())))
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
          if (this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, " needInstall:" + this.jdField_a_of_type_Boolean + ",需要安装插件");
            }
            paramIQZonePluginManager.a(localPluginRecord.g, null);
          }
        }
      }
    }
    catch (RemoteException paramIQZonePluginManager)
    {
      paramIQZonePluginManager.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZoneLiveJsPlugin", 2, " 返回结果：" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    return;
    label104:
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */