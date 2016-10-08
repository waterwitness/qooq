import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;

public class wxu
  implements Runnable
{
  public wxu(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_ADDED >> " + this.jdField_a_of_type_JavaLangString);
    DownloadInfo localDownloadInfo = DownloadDBHelper.a().a(this.b);
    if (localDownloadInfo != null)
    {
      LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_ADDED info != null>> " + localDownloadInfo.toString() + " " + localDownloadInfo.b + " " + localDownloadInfo.d);
      DownloadManager.a().d(localDownloadInfo);
    }
    for (;;)
    {
      DownloadManager.a().a(6, localDownloadInfo);
      return;
      localDownloadInfo = new DownloadInfo("", this.b);
      LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_ADDED info == null>> " + localDownloadInfo.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */