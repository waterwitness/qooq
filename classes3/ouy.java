import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ouy
  implements ThreadExcutor.IThreadListener
{
  public ouy(PreloadManager paramPreloadManager, List paramList, Map paramMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void c()
  {
    DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
    if (PreloadManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager) != null) {
      PreloadManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager).a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ouy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */