import com.tencent.mobileqq.activity.richmedia.PTVOperatingGuideActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

public class pct
  implements TVK_SDKMgr.InstallListener
{
  public pct(PTVOperatingGuideActivity paramPTVOperatingGuideActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    this.a.a("腾讯视频插件加载失败");
  }
  
  public void onInstalledSuccessed()
  {
    this.a.a.post(new pcu(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */