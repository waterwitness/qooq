import android.os.Handler;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class hsb
  implements TVK_SDKMgr.InstallListener
{
  public hsb(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.post(new hsd(this));
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (this.a.a != null) {
      this.a.a.post(new hsc(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */