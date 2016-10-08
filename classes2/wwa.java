import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.io.File;

public class wwa
  implements Runnable
{
  public wwa(DownloadManager paramDownloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Context localContext = CommonDataAdapter.a().a();
    boolean bool = localContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false);
    SimpleAccount localSimpleAccount = BaseApplicationImpl.a().getFirstSimpleAccount();
    String str = "";
    if (localSimpleAccount != null) {
      str = localSimpleAccount.getUin();
    }
    if (!bool)
    {
      LogUtility.c(DownloadManager.a, "getUpdateApp will do full report");
      AppReport.a(localContext, null, null, str, true);
    }
    while (!new File(localContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists()) {
      return;
    }
    LogUtility.c(DownloadManager.a, "getUpdateApp will do incremental report");
    AppReport.a(localContext, null, 0, null, null, str);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */