import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class wwe
  implements Runnable
{
  public wwe(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c) != null) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c).mSavePath;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.p = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.p != 0)
    {
      LogUtility.a(DownloadManager.a, "onDownloadError ###重新写码失败..........");
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int = -2;
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l = 100;
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.p, null);
      return;
    }
    LogUtility.a(DownloadManager.a, "onDownloadError ###重新写码成功..........");
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l = 100;
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */