import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class raw
  implements Runnable
{
  public raw(ConfigServlet paramConfigServlet, ConfigurationService.Config paramConfig)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime();
    boolean bool = ((HotchatSCMng)localQQAppInterface.getManager(122)).a(this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config);
    SharedPreUtils.a(localQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get(), bool);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\raw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */