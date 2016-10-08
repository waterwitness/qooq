import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.concurrent.ConcurrentHashMap;

public class wwh
  implements Runnable
{
  public wwh(DownloadManager paramDownloadManager, String paramString, DownloadInfo paramDownloadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      DownloadDBHelper.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */