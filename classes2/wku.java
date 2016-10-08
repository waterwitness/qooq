import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AudioAnimationView;

public class wku
  implements Runnable
{
  private wku(AudioAnimationView paramAudioAnimationView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b();
    if (this.a.a) {
      AudioAnimationView.a(this.a).postDelayed(this, 100L);
    }
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */