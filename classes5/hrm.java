import android.os.Handler;
import com.tencent.biz.pubaccount.VideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class hrm
  implements TVK_SDKMgr.InstallListener
{
  public hrm(VideoPlayActivity paramVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoPlayActivity.a(this.a), 2, "initUI() TVK_SDKMgr.onInstalledFailed() failed=" + paramInt);
    }
    if (this.a.a != null) {
      this.a.a.post(new hro(this));
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoPlayActivity.a(this.a), 2, "initUI() TVK_SDKMgr.onInstalledSuccessed() ");
    }
    if (this.a.a != null) {
      this.a.a.post(new hrn(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */