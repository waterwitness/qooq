import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class rzx
  implements UniformDownloader.IUniformDownloaderListener
{
  public rzx(UniformDownloadMgr paramUniformDownloadMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    UniformDownloadMgr.a(this.a);
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    ReportController.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_success", 0, 1, 0, "", "", "", "");
    paramBundle.getInt("_CB_SID");
    String str = paramBundle.getString("_CB_URL");
    paramBundle = paramBundle.getBundle("_CB_USERDATA");
    UniformDownloadMgr.a(this.a, str);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>insertFM and install. PH:" + paramString + " SZ:" + paramLong);
    if (this.a.a != null) {
      this.a.a.a().a(null, -1, paramString, paramLong, 16, null, paramBundle);
    }
    for (;;)
    {
      UniformDownloadUtil.a(paramString);
      UniformDownloadMgr.a(this.a);
      if ("http://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean".equals(str)) {
        ReportController.b(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", "download secure apk sucess", 0, 0, "", "", "", "");
      }
      return;
      FileManagerUtil.c(paramString);
    }
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */