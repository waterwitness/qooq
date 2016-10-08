package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class QlinkPluginProxyService
  extends PluginProxyService
{
  private static final String a = "com.tencent.qlink.service.QlinkService";
  
  public QlinkPluginProxyService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((IPluginManager)paramQQAppInterface.getManager(26)).a(QlinkPluginProxyActivity.a());
    if ((localObject != null) && (((PluginInfo)localObject).mState == 4))
    {
      localObject = new Intent(paramQQAppInterface.a(), QlinkPluginProxyService.class);
      ((Intent)localObject).putExtra("useSkinEngine", 1);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.b = QlinkPluginProxyActivity.a();
      localPluginParams.d = "近场传输";
      localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      localPluginParams.e = "com.tencent.qlink.service.QlinkService";
      localPluginParams.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
      QLog.d("QLinkLog", 4, "Start QLink Preload");
      IPluginManager.b(paramQQAppInterface.a(), localPluginParams);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QlinkPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = QlinkPluginProxyActivity.a();
    localPluginParams.d = "近场传输";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.e = "com.tencent.qlink.service.QlinkService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    IPluginManager.b(paramAppRuntime.getApplication(), localPluginParams);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlinkPluginProxyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */