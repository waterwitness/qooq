import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class uzq
  extends DownloadListener
{
  public uzq(ThemeDownloader paramThemeDownloader, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    boolean bool = false;
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0)) {}
    Object localObject;
    for (int i = 1;; i = 0)
    {
      localObject = paramDownloadTask.a();
      if (localObject != null) {
        break;
      }
      return;
    }
    ((Bundle)localObject).putInt("getStatus", paramDownloadTask.a());
    ((Bundle)localObject).putInt("errCode", paramDownloadTask.z);
    if (i != 0)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ThemeUtil.ThemeInfo localThemeInfo = ThemeUtil.getThemeInfo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((Bundle)localObject).getString("themeId"));
        localObject = localThemeInfo;
        if (localThemeInfo == null)
        {
          localObject = localThemeInfo;
          if (this.a.jdField_a_of_type_AndroidOsBundle != null)
          {
            localObject = new ThemeUtil.ThemeInfo();
            ((ThemeUtil.ThemeInfo)localObject).size = this.a.jdField_a_of_type_AndroidOsBundle.getLong("size", 0L);
            ((ThemeUtil.ThemeInfo)localObject).themeId = this.a.jdField_a_of_type_AndroidOsBundle.getString("themeId");
            ((ThemeUtil.ThemeInfo)localObject).version = this.a.jdField_a_of_type_AndroidOsBundle.getString("version");
            if (this.a.jdField_a_of_type_AndroidOsBundle.getInt("isSound", 0) == 1) {
              bool = true;
            }
            ((ThemeUtil.ThemeInfo)localObject).isVoiceTheme = bool;
          }
        }
        if (localObject != null)
        {
          ((ThemeUtil.ThemeInfo)localObject).status = "3";
          ThemeUtil.setThemeInfo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), (ThemeUtil.ThemeInfo)localObject);
        }
      }
      this.a.a(this.a.jdField_a_of_type_AndroidOsBundle, 1, paramDownloadTask);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_AndroidOsBundle, -14, paramDownloadTask);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener.a(this.a.jdField_a_of_type_AndroidOsBundle, 1, paramDownloadTask);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ThemeDownloader", 2, "ThemeDownloader onDownloadProgress outSideListener == null;");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */