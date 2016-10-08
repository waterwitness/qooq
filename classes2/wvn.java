import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class wvn
  implements Runnable
{
  public wvn(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo)
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
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_JavaLangString).mSavePath;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_Long = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        if ((!"com.tencent.mobileqq".equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d)) || (!this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b())) {
          break label262;
        }
        LogUtility.c(DownloadManager.a, "QQ Download complete begin write code ......");
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.p = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.p != 0)
        {
          LogUtility.c(DownloadManager.a, "QQ apk write code fail......");
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int = -2;
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.p, null);
          return;
        }
        LogUtility.c(DownloadManager.a, "QQ apk code suc......");
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        long l = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label262:
        LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
      }
    }
    StaticAnalyz.a("300", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.m);
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      return;
      LogUtility.c(DownloadManager.a, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d + " Download complete begin write code ......");
      DownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */