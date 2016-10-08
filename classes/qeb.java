import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

public class qeb
  implements Runnable
{
  public qeb(QQAppInterface paramQQAppInterface, String paramString, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File localFile;
    if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, MsfSdkUtils.insertMtype("lingyin", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaIoFile))
    {
      localFile = new File(QQAppInterface.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getApplicationContext().getFilesDir(), this.jdField_a_of_type_JavaLangString);
      if (localFile == null) {
        break label69;
      }
    }
    label69:
    for (long l = localFile.length();; l = 0L)
    {
      QQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(l);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */