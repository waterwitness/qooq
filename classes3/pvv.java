import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.JumpFilterHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class pvv
  implements Runnable
{
  public pvv(ConfigHandler paramConfigHandler, String paramString, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b.getApplication().getFilesDir(), "qq_safe_jump_whitelist.zip");
    String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, str, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("JumpWhiteList", 2, "handleJumpWhiteList download: " + i);
    }
    if (i == 0)
    {
      JumpFilterHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, this.jdField_a_of_type_Long, localFile.getAbsolutePath());
      return;
    }
    JumpFilterHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b.getApplication());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */