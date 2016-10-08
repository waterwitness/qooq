package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QZoneLiveVideoPluginProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static final String a = "QZoneLiveVideoPluginProxyBroadcastReceiver";
  
  public QZoneLiveVideoPluginProxyBroadcastReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject = QZonePluginUtils.a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
    }
    do
    {
      return;
      if (!((String)localObject).equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
    } while (!new File(QZonePluginUtils.a(paramContext), (String)localObject).exists());
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "sendBroadcast 加载动态包:hackPluginID:" + (String)localObject);
    }
    IQZonePluginManager.PluginParams localPluginParams = new IQZonePluginManager.PluginParams(0);
    localPluginParams.b = "qzone_live_video_plugin_hack.apk";
    localPluginParams.d = "QZoneLiveVideo";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.b = ((String)localObject);
    localPluginParams.d = "QZoneLiveVideo";
    IQZonePluginManager.b(paramContext, localPluginParams);
    return;
    if (((String)localObject).equals("qzone_live_video_plugin.apk"))
    {
      localObject = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject).b = "qzone_live_video_plugin.apk";
      ((IPluginManager.PluginParams)localObject).d = "QZoneLiveVideo";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((IPluginManager.PluginParams)localObject).e = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((IPluginManager.PluginParams)localObject).b = "qzone_live_video_plugin.apk";
      ((IPluginManager.PluginParams)localObject).d = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      IPluginManager.a(paramContext, (IPluginManager.PluginParams)localObject);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\QZoneLiveVideoPluginProxyBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */