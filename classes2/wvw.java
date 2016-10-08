import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.DownloaderGetCodeClient;

public class wvw
  implements Runnable
{
  public wvw(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      LogUtility.c(DownloadManager.a, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d + " begin getApkCode ......");
      DownloaderGetCodeClient.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */