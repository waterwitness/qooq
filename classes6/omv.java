import android.os.Bundle;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class omv
  implements Runnable
{
  public omv(AvatarPendantActivity paramAvatarPendantActivity, DownloaderInterface paramDownloaderInterface, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(AvatarPendantUtil.a) == null)
    {
      DownloadTask localDownloadTask = new DownloadTask(AvatarPendantUtil.a, this.jdField_a_of_type_JavaIoFile);
      localDownloadTask.n = false;
      Bundle localBundle = new Bundle();
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.a, localBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\omv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */