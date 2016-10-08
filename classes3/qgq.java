import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeUnzipListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class qgq
  implements ThemeDownloader.ThemeDownloadListener
{
  public qgq(ThemeHandler paramThemeHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle, int paramInt, DownloadTask paramDownloadTask) {}
  
  public void a(Bundle paramBundle, int paramInt, DownloadTask paramDownloadTask, ThemeDownloader paramThemeDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeHandler", 2, "mThemeDownloadListener onDownloadCallback stateCode:" + paramInt);
    }
    if (paramInt == 3) {
      this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener.a(paramBundle, paramInt, paramThemeDownloader);
    }
    for (;;)
    {
      this.a.a(null);
      return;
      if (paramInt == 1) {
        paramThemeDownloader.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), paramBundle, this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener);
      } else if (paramInt == 2) {
        paramThemeDownloader.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), paramBundle, this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener);
      } else {
        QLog.e("Theme.ThemeHandler", 2, "mThemeDownloadListener onDownloadCallback Error stateCode:" + paramInt);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */