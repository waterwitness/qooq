import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CharJumpAnimView;

public class wkz
  implements Runnable
{
  public wkz(CharJumpAnimView paramCharJumpAnimView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (CharJumpAnimView.a(this.a) == 0L)
    {
      if (CharJumpAnimView.a(this.a) != null) {
        CharJumpAnimView.a(this.a).onAnimationStart(null);
      }
      CharJumpAnimView.a(this.a, System.currentTimeMillis());
    }
    this.a.a(CharJumpAnimView.a(this.a), 3500L);
    this.a.invalidate();
    if (this.a.a())
    {
      this.a.postDelayed(this, 20L);
      return;
    }
    if (CharJumpAnimView.a(this.a) != null) {
      CharJumpAnimView.a(this.a).onAnimationEnd(null);
    }
    CharJumpAnimView.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wkz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */