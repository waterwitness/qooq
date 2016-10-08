package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;
import ypy;

public class QzoneLiveVideoPluginProxyActivity
  extends PluginProxyActivity
{
  private static final String[] a = { "com.qzone.adapter.livevideo.RewardGiftActivity", "com.qzonex.module.global.FeedActionPanelActivity" };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = ypy.a("com.qzone.adapter.livevideo.QZoneLiveVideoActivity");
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject = QZonePluginUtils.a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
    }
    for (;;)
    {
      return;
      if (((String)localObject).equals("qzone_live_video_plugin_hack.apk")) {
        if (new File(QZonePluginUtils.a(paramActivity), (String)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:" + (String)localObject);
          }
          localObject = new IQZonePluginManager.PluginParams(0);
          ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString;
          ((IQZonePluginManager.PluginParams)localObject).e = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
          ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = localClass;
          ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
          ((IQZonePluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
          ((IQZonePluginManager.PluginParams)localObject).c = 10000;
          paramString = new QzoneProgressDialog(paramActivity, paramIntent);
          paramString.a("  正在加载...");
          ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = paramString;
          ((IQZonePluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qzone_live_video_plugin_hack.apk";
          ((IQZonePluginManager.PluginParams)localObject).d = "QZoneLiveVideo";
          IQZonePluginManager.a(paramActivity, (IQZonePluginManager.PluginParams)localObject);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("PluginDebug", 2, "QzoneLiveVideoPluginProxyActivity.launchPluingActivityForResult");
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("PluginDebug", 2, "launchPluginActivityForResult 加载动态包不存在");
          continue;
          if (!"qzone_live_video_plugin.apk".equals(localObject)) {
            break label375;
          }
          localObject = new IPluginManager.PluginParams(0);
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString;
          ((IPluginManager.PluginParams)localObject).e = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = localClass;
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
          ((IPluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
          ((IPluginManager.PluginParams)localObject).c = 10000;
          paramString = new QzoneProgressDialog(paramActivity, paramIntent);
          paramString.a("  正在加载...");
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = paramString;
          ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qzone_live_video_plugin.apk";
          ((IPluginManager.PluginParams)localObject).d = "QZoneLiveVideo";
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "加载原始插件");
          }
          IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
        }
      }
    }
    label375:
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
  }
  
  private static boolean b(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return ypy.a(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\QzoneLiveVideoPluginProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */