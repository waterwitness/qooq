import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class wwg
  implements Runnable
{
  public wwg(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_JavaLangString);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_JavaLangString).mSavePath;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_Long = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.p != 0) {
          break label170;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        if (!this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b.equals("1101070898"))
        {
          long l = localTMAssistantDownloadTaskInfo.mTotalDataLen;
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label170:
        LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
      }
    }
    StaticAnalyz.a("300", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.m);
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
    return;
    DownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */