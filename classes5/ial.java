import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class ial
  implements TVK_SDKMgr.InstallListener
{
  public ial(VideoPluginInstall paramVideoPluginInstall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallProgress(float paramFloat)
  {
    VideoPluginInstall.a(this.a).sendEmptyMessage(2);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    VideoPluginInstall.a(this.a).sendEmptyMessage(1);
  }
  
  public void onInstalledSuccessed()
  {
    VideoPluginInstall.a(this.a).sendEmptyMessage(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */