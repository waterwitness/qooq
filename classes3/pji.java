import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

public class pji
  implements TVK_SDKMgr.InstallListener
{
  public pji(ShortVideoPlayActivity paramShortVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ShortVideoPlayActivity.a(this.a, false);
    ShortVideoPlayActivity.b(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.b(this.a));
    this.a.a("腾讯视频插件加载失败");
    ShortVideoPlayActivity.c(this.a, 3000);
    ShortVideoPlayActivity.d(this.a, paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    ShortVideoPlayActivity.a(this.a, true);
    ShortVideoPlayActivity.b(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.b(this.a));
    this.a.a.post(new pjj(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */