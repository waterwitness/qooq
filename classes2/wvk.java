import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

public class wvk
  implements Runnable
{
  public wvk(DownloadManager paramDownloadManager, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "startDownload download file, url = " + this.jdField_a_of_type_JavaLangString + "params = " + this.jdField_a_of_type_JavaUtilMap);
    }
    do
    {
      for (;;)
      {
        try
        {
          int i;
          if (this.jdField_a_of_type_Int == 0)
          {
            i = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/vnd.android.package-archive", this.jdField_a_of_type_JavaUtilMap);
            LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "startDownloadTask downloadSDKClient result=" + i + " url=" + this.jdField_a_of_type_JavaLangString);
            if (i == 0) {
              break;
            }
            this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, i, "");
            return;
          }
          if (this.jdField_a_of_type_Int == 1)
          {
            this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
            i = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/tm.android.apkdiff", this.jdField_a_of_type_JavaUtilMap);
          }
          else
          {
            LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "startDownload download unapk file, url = " + this.jdField_a_of_type_JavaLangString + ",filename = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d);
            i = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, 0, "resource/tm.android.unknown", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e, this.jdField_a_of_type_JavaUtilMap);
            continue;
            i = 3;
          }
        }
        catch (Exception localException)
        {
          LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
        }
      }
    } while ((this.b != this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) || (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k != 20));
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(20, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */