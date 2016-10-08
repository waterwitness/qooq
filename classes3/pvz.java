import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import protocol.KQQConfig.GetResourceRespInfo;

public class pvz
  implements Runnable
{
  public pvz(ConfigHandler paramConfigHandler, String paramString, GetResourceRespInfo paramGetResourceRespInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */