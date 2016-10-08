package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QZoneLiveVideoPluginProxyService
  extends PluginProxyService
{
  public QZoneLiveVideoPluginProxyService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject1 = QZonePluginUtils.a();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
    }
    do
    {
      return;
      if (!((String)localObject1).equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
      localObject2 = new File(QZonePluginUtils.a(paramContext), (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "bindService 加载动态包:hackPluginID:" + (String)localObject1);
      }
    } while (!((File)localObject2).exists());
    Object localObject2 = new IQZonePluginManager.PluginParams(0);
    ((IQZonePluginManager.PluginParams)localObject2).b = "qzone_live_video_plugin_hack.apk";
    ((IQZonePluginManager.PluginParams)localObject2).d = "QZoneLiveVideo";
    ((IQZonePluginManager.PluginParams)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((IQZonePluginManager.PluginParams)localObject2).e = "com.qzone.adapter.livevideo.LiveVideoPreloadPluginService";
    ((IQZonePluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidContentIntent = paramIntent;
    ((IQZonePluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    ((IQZonePluginManager.PluginParams)localObject2).b = ((String)localObject1);
    ((IQZonePluginManager.PluginParams)localObject2).d = "QZoneLiveVideo";
    IQZonePluginManager.a(paramContext, (IQZonePluginManager.PluginParams)localObject2);
    return;
    if (((String)localObject1).equals("qzone_live_video_plugin.apk"))
    {
      localObject1 = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject1).b = "qzone_live_video_plugin.apk";
      ((IPluginManager.PluginParams)localObject1).d = "QZoneLiveVideo";
      ((IPluginManager.PluginParams)localObject1).jdField_a_of_type_JavaLangString = paramString;
      ((IPluginManager.PluginParams)localObject1).e = "com.qzone.adapter.livevideo.LiveVideoPreloadPluginService";
      ((IPluginManager.PluginParams)localObject1).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((IPluginManager.PluginParams)localObject1).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      ((IPluginManager.PluginParams)localObject1).b = "qzone_live_video_plugin.apk";
      ((IPluginManager.PluginParams)localObject1).d = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      IPluginManager.b(paramContext, (IPluginManager.PluginParams)localObject1);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\QZoneLiveVideoPluginProxyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */