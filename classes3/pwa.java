import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import protocol.KQQConfig.GetResourceRespInfo;

public class pwa
  implements Runnable
{
  public pwa(ConfigHandler paramConfigHandler, String paramString, GetResourceRespInfo paramGetResourceRespInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File localFile = new File(AppConstants.cm);
    try
    {
      if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, new URL(this.jdField_a_of_type_JavaLangString), localFile))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(1, true, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(1, false, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(1, false, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */