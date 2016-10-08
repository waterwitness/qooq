import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rpj
  implements UniformDownloader.IUniformDownloaderListener
{
  public rpj(UniformDownloadActivity paramUniformDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadStart progress = " + paramInt);
    }
    this.a.runOnUiThread(new rpl(this));
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadFailed errCode = " + paramInt);
    }
    this.a.runOnUiThread(new rpp(this));
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadSucess ");
    }
    this.a.runOnUiThread(new rpk(this));
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadResume progress = " + paramInt);
    }
    this.a.runOnUiThread(new rpm(this));
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadProgress progress = " + paramInt);
    }
    this.a.runOnUiThread(new rpn(this, paramInt));
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadPause progress = " + paramInt);
    }
    this.a.runOnUiThread(new rpo(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */