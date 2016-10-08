import android.os.Handler;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class pbn
  implements Runnable
{
  public pbn(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1, this.jdField_a_of_type_JavaLangString.lastIndexOf("?"));
    if ((new File(NewFlowCameraActivity.p + str).exists()) && (str != null) && (str.toLowerCase().endsWith(".m4a")))
    {
      NewFlowCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, NewFlowCameraActivity.p + str);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.postDelayed(new pbo(this), 500L);
      QLog.d("PTV.NewFlowCameraActivity", 2, "music exist------：" + str);
      return;
    }
    Object localObject = new pbp(this);
    if ((str != null) && (str.toLowerCase().endsWith(".m4a")))
    {
      localObject = new DownloadRequest(this.jdField_a_of_type_JavaLangString, new String[] { NewFlowCameraActivity.p + str }, false, (Downloader.DownloadListener)localObject);
      ((DownloadRequest)localObject).mode = Downloader.DownloadMode.FastMode;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.post(new pbt(this));
      DownloaderFactory.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getBaseContext()).getCommonDownloader().download((DownloadRequest)localObject, false);
      NewFlowCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, NewFlowCameraActivity.p + str);
      return;
    }
    QLog.d("PTV.NewFlowCameraActivity", 2, "error musicUrl=" + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */