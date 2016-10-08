package cooperation.weiyun;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class AlbumBackupLaunchProxyActivity
  extends PluginProxyActivity
{
  public static final String a = "isvip";
  
  public AlbumBackupLaunchProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(536870912);
    localIntent.putExtra("userQqResources", 1);
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("isvip", WeiyunVipHelper.a());
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "WeiyunPlugin.apk";
    localPluginParams.d = paramActivity.getResources().getString(2131372711);
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.weiyun.plugin.albumbackup.activity.AlbumBackupLaunchActivity";
    localPluginParams.jdField_a_of_type_JavaLangClass = AlbumBackupLaunchProxyActivity.class;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public String getPluginID()
  {
    return "WeiyunPlugin.apk";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\weiyun\AlbumBackupLaunchProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */