package cooperation.qqpim;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QQPimPluginProxyService
  extends PluginProxyService
{
  public QQPimPluginProxyService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      Intent localIntent = new Intent(paramQQAppInterface.a(), QQPimPluginProxyService.class);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
      localPluginParams.b = "qqpim_plugin.apk";
      localPluginParams.d = "QQ同步助手插件";
      localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      localPluginParams.e = QQPimDefineList.k;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      IPluginManager.b(paramQQAppInterface.a(), localPluginParams);
    } while (!QLog.isColorLevel());
    QLog.i(QQPimDefineList.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqpim\QQPimPluginProxyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */