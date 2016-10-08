import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gzc
  implements Runnable
{
  public gzc(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.a(new Object[] { Integer.valueOf(102) });
    if (!this.a.s) {
      return;
    }
    if (this.a.E > this.a.D) {
      this.a.E = this.a.D;
    }
    if (this.a.E < 0) {
      this.a.E = 0;
    }
    VideoControlUI localVideoControlUI;
    if (this.a.m) {
      localVideoControlUI = this.a;
    }
    for (localVideoControlUI.E += 1;; localVideoControlUI.E -= 1)
    {
      this.a.a.a().postDelayed(this, this.a.F);
      return;
      localVideoControlUI = this.a;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */