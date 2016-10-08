import android.graphics.Bitmap;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class pzk
  implements Runnable
{
  public pzk(LebaHelper paramLebaHelper, URL paramURL, File paramFile, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_JavaIoFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaHelper", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "suc--------");
        }
        Bitmap localBitmap = LebaHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaIoFile);
        List localList;
        int i;
        if (localBitmap != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "notify UI++++++++");
          }
          localList = this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.d;
          i = 0;
        }
        try
        {
          while (i < this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.d.size())
          {
            ((DownloadIconsListener)this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.d.get(i)).a(this.jdField_a_of_type_JavaLangString, localBitmap);
            i += 1;
          }
          LebaHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
          return;
        }
        finally {}
      }
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_JavaLangString);
      LebaHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
      return;
    }
    LebaHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */