import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.groupvideo.GVideoPluginInstallerActivity;
import cooperation.plugin.IPluginManager;

public class ybv
  implements Runnable
{
  public ybv(GVideoPluginInstallerActivity paramGVideoPluginInstallerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.a("group_video_plugin.apk", false, GVideoPluginInstallerActivity.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */