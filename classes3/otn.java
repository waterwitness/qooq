import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class otn
  implements ThreadExcutor.IThreadListener
{
  public otn(PreloadImgManager paramPreloadImgManager, List paramList, Map paramMap, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localDownloadTask.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager.a.a(localDownloadTask, PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager), null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */