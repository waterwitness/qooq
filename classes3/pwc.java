import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;

public class pwc
  implements Runnable
{
  public pwc(ConfigHandler paramConfigHandler, GetResourceRespInfo paramGetResourceRespInfo, String paramString, long paramLong)
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
    do
    {
      return;
      File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b.getApplication().getFilesDir(), "eggs_config.zip");
      String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
      int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, str, localFile);
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions download: " + i);
      }
      if (i == 0)
      {
        AioAnimationConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, this.jdField_a_of_type_Long, localFile.getAbsolutePath());
        return;
      }
    } while (AioAnimationConfigHelper.a().a() != null);
    AioAnimationConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b.getApplication());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */