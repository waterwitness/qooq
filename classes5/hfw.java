import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.WebCgiWhiteListManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class hfw
  implements Runnable
{
  public hfw(WebCgiWhiteListManager paramWebCgiWhiteListManager, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("WebCgiWhiteListManager", 2, "CGIWhiteListCheckUpdate start downloadWhiteListConfigJson url=" + this.jdField_a_of_type_JavaLangString + ",version=" + this.b);
    }
    try
    {
      localObject = this.jdField_a_of_type_ComTencentBizWebCgiWhiteListManager.a();
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("WebCgiWhiteListManager", 2, "CGIWhiteListCheckUpdate downloadWhiteListConfigJson failed, path is null");
        return;
      }
      localObject = new File((String)localObject + ".tmp");
      DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaLangString, (File)localObject);
      localDownloadTask.l = true;
      j = DownloaderFactory.a(localDownloadTask, WebCgiWhiteListManager.a(this.jdField_a_of_type_ComTencentBizWebCgiWhiteListManager));
      if (j != 0) {
        break label317;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      int j;
      while (QLog.isColorLevel())
      {
        QLog.e("WebCgiWhiteListManager", 2, "CGIWhiteListCheckUpdate downloadWhiteListConfigJson error" + localException.getMessage());
        return;
        label317:
        i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebCgiWhiteListManager", 2, "CGIWhiteListCheckUpdate downloadWhiteListConfigJson result code=" + j);
    }
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebCgiWhiteListManager", 2, "CGIWhiteListCheckUpdate downloadWhiteListConfigJson update CGIWhiteList config  success version=" + this.b);
      }
      WebCgiWhiteListManager.a(this.jdField_a_of_type_ComTencentBizWebCgiWhiteListManager).getPreferences().edit().putString("WebviewCGIWhitelistVersion", this.b).commit();
      WebCgiWhiteListManager.a(this.jdField_a_of_type_ComTencentBizWebCgiWhiteListManager).getPreferences().edit().putString("whitelist_config_json_url", this.jdField_a_of_type_JavaLangString).commit();
      WebCgiWhiteListManager.a(this.jdField_a_of_type_ComTencentBizWebCgiWhiteListManager, (File)localObject);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */