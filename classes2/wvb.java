import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.ArrayList;
import java.util.List;

public final class wvb
  implements Runnable
{
  public wvb(List paramList, DownloadQueryListener paramDownloadQueryListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogUtility.a(DownloadApi.a, "getQueryDownloadAction enter");
    DownloadManager.a().a();
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i < j)
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          if (DownloadManager.a().a(localDownloadInfo))
          {
            LogUtility.a(DownloadApi.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener != null) {
            this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.b(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c(DownloadApi.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.a(-1, localException.getMessage());
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */