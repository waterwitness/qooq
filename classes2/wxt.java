import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;

public class wxt
  implements Runnable
{
  public wxt(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_REPLACED >> " + this.jdField_a_of_type_JavaLangString);
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    DownloadManager.a().a(13, localDownloadInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */