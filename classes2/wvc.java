import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.ArrayList;
import java.util.List;

public final class wvc
  implements Runnable
{
  public wvc(String paramString, DownloadQueryListener paramDownloadQueryListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogUtility.a(DownloadApi.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = DownloadManager.a().c(this.jdField_a_of_type_JavaLangString);
      LogUtility.a(DownloadApi.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener != null) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.b(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        LogUtility.c(DownloadApi.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener == null);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.a(-1, localException.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */