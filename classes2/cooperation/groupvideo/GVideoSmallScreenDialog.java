package cooperation.groupvideo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class GVideoSmallScreenDialog
  extends PluginProxyActivity
{
  public GVideoSmallScreenDialog()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.b = "group_video_plugin.apk";
    localPluginParams.d = "群视频";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.gvideo.com.tencent.av.smallscreen.SmallScreenDialogActivity";
    localPluginParams.jdField_a_of_type_JavaLangClass = GVideoSmallScreenDialog.class;
    paramString = paramIntent;
    if (paramIntent == null) {
      paramString = new Intent();
    }
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramString;
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localPluginParams.c = 10000;
    localPluginParams.f = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public String getPluginID()
  {
    return "group_video_plugin.apk";
  }
  
  public Class getProxyActivity(String paramString)
  {
    return GVideoSmallScreenDialog.class;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\groupvideo\GVideoSmallScreenDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */