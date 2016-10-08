package cooperation.weiyun;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import mqq.app.AppRuntime;

public class WeiyunProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  private static final String a = "com.weiyun.plugin.BROADCAST";
  
  public WeiyunProxyBroadcastReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setAction("com.weiyun.plugin.BROADCAST");
    paramIntent = new IPluginManager.PluginParams(0);
    paramIntent.b = "WeiyunPlugin.apk";
    paramIntent.d = paramContext.getResources().getString(2131372711);
    paramIntent.jdField_a_of_type_JavaLangString = BaseApplicationImpl.a().a().getAccount();
    paramIntent.e = paramString;
    paramIntent.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramContext, paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\weiyun\WeiyunProxyBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */