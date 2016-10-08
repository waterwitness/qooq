import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.GetResourceRespInfo;

public class pwd
  implements Runnable
{
  public pwd(ConfigHandler paramConfigHandler, GetResourceRespInfo paramGetResourceRespInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    while (AioAnimationConfigHelper.a().a() != null) {
      return;
    }
    AioAnimationConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b.getApplication());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */