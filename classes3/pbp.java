import android.os.Handler;
import android.widget.ProgressBar;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class pbp
  implements Downloader.DownloadListener
{
  pbp(pbn parampbn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDownloadCanceled(String paramString)
  {
    this.a.a.a.post(new pbq(this));
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    this.a.a.a.post(new pbr(this));
    QLog.d("PTV.NewFlowCameraActivity", 2, "onDownloadFailed");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    QLog.d("PTV.NewFlowCameraActivity", 2, "onDownloadProgress = totalSize=" + paramLong + "  progress=" + paramFloat);
    NewFlowCameraActivity.a(this.a.a).setProgress((int)(100.0F * paramFloat));
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    this.a.a.a.post(new pbs(this));
    QLog.d("PTV.NewFlowCameraActivity", 2, "onDownloadSucceed：" + NewFlowCameraActivity.a(this.a.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */