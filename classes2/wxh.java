import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener;
import com.tencent.open.downloadnew.MyAppDialog;

public class wxh
  implements Runnable
{
  public wxh(MyAppApi.YYBDownloadListener paramYYBDownloadListener, DownloadInfo paramDownloadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a.isShowing())) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a.dismiss();
    }
    DownloadManager.a().c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    new Handler(Looper.getMainLooper()).postAtTime(new wxi(this), 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */