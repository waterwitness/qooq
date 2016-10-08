import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class wwc
  implements Runnable
{
  wwc(wwb paramwwb, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogUtility.b(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadStateChanged,clientKey:" + this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient + ",state:" + this.jdField_a_of_type_Int + ",url:" + this.jdField_a_of_type_JavaLangString);
    int i = DownloadManager.a(this.jdField_a_of_type_Int);
    LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "onStateChanged url: +++++loacalState=" + i + " +++++downloadInfo=" + this.jdField_a_of_type_Wwb.a.c(this.jdField_a_of_type_JavaLangString));
    DownloadInfo localDownloadInfo = this.jdField_a_of_type_Wwb.a.a(this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null)
    {
      LogUtility.d(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadSDKTaskStateChanged info == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(this.jdField_a_of_type_JavaLangString);
        if (localTMAssistantDownloadTaskInfo == null) {
          break label442;
        }
        l1 = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        l2 = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        int j = (int)((float)l1 * 100.0F / (float)l2);
        localDownloadInfo.l = j;
        LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadSDKTaskStateChanged info progress = " + j);
        switch (i)
        {
        default: 
          return;
        case -2: 
          this.jdField_a_of_type_Wwb.a.a(localDownloadInfo, l1, l2, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_Wwb.a.a(-2, localDownloadInfo, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "getDownloadTaskState>>>", localException);
        Object localObject = null;
        continue;
        this.jdField_a_of_type_Wwb.a.a(2, localDownloadInfo);
        return;
      }
      this.jdField_a_of_type_Wwb.a.a(localDownloadInfo, l1, l1 - localDownloadInfo.b, "pause");
      this.jdField_a_of_type_Wwb.a.a(3, localDownloadInfo);
      return;
      this.jdField_a_of_type_Wwb.a.a(localDownloadInfo, 0L, l2 - localDownloadInfo.b, "complete");
      this.jdField_a_of_type_Wwb.a.b(localDownloadInfo);
      return;
      this.jdField_a_of_type_Wwb.a.a(20, localDownloadInfo);
      return;
      this.jdField_a_of_type_Wwb.a.a(10, localDownloadInfo);
      return;
      label442:
      long l2 = 0L;
      long l1 = 0L;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */