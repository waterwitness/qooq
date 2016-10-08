import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class tuu
  implements Runnable
{
  public tuu(ProfileCardCheckUpdate paramProfileCardCheckUpdate, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate start downloadLabelConfigJson url=" + this.jdField_a_of_type_JavaLangString + ",version=" + this.b);
    }
    try
    {
      Object localObject = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a.getApplication());
      localObject = new File((String)localObject + ".tmp");
      DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaLangString, (File)localObject);
      localDownloadTask.f = "profileCardDownload";
      localDownloadTask.e = "VIP_profilecard";
      localDownloadTask.a = 1;
      localDownloadTask.l = true;
      int j = DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a);
      if (j == 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson result code=" + j);
        }
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson update label config  success version=" + this.b);
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a.getPreferences().edit().putString("profileLabelVersion", this.b).commit();
          ProfileCardCheckUpdate.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate, (File)localObject);
        }
        return;
        i = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tuu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */