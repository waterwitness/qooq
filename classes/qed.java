import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;

public class qed
  implements Runnable
{
  public qed(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g();
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h()) && (bool2) && (!bool1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.k()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m()) && (QQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Object localObject = SkinEngine.getInstances().getSkinRootPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new StringBuilder((String)localObject);
        ((StringBuilder)localObject).append(File.separatorChar).append("voice").append(File.separatorChar).append("tab").append(this.jdField_a_of_type_Int).append(".mp3");
        File localFile = new File(((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("playThemeVoice", 2, "Uri:" + ((StringBuilder)localObject).toString());
        }
        if (localFile.exists()) {
          AudioUtil.a(Uri.fromFile(localFile), false, false);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */