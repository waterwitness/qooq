import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class nsc
  implements TVK_SDKMgr.InstallListener
{
  Handler a;
  
  public nsc(Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramHandler;
  }
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt) {}
  
  public void onInstalledSuccessed()
  {
    if (this.a != null) {
      this.a.post(new nsd(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nsc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */