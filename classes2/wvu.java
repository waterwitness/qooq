import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.concurrent.ConcurrentHashMap;

public class wvu
  implements Runnable
{
  public wvu(DownloadManager paramDownloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)DownloadDBHelper.a().a());
    try
    {
      DownloadInfo localDownloadInfo = this.a.b("com.tencent.mobileqq");
      if ((localDownloadInfo != null) && (localDownloadInfo.jdField_h_of_type_Int == 0))
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
        if (localDownloadInfo.f == 0) {
          localTMAssistantDownloadTaskInfo = this.a.a(localDownloadInfo.c);
        }
        for (String str = localTMAssistantDownloadTaskInfo.mSavePath; localTMAssistantDownloadTaskInfo == null; str = localDownloadInfo.k)
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.b);
          DownloadDBHelper.a().a(localDownloadInfo.b);
          return;
          localTMAssistantDownloadTaskInfo = this.a.a(localDownloadInfo.jdField_h_of_type_JavaLangString);
        }
        if ((localTMAssistantDownloadTaskInfo.mState == 4) && (AppUtil.b(str) <= CommonDataAdapter.a().a()))
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.b);
          DownloadDBHelper.a().a(localDownloadInfo.b);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "speical clear>>>", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */