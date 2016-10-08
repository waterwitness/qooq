import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;

public class vzm
  implements Runnable
{
  public vzm(AntiFraudConfigFileUtil paramAntiFraudConfigFileUtil, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!AntiFraudConfigFileUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil).containsKey(this.jdField_a_of_type_JavaLangString)) {
      AntiFraudConfigFileUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */