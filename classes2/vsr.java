import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class vsr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public vsr(MediaControllerX paramMediaControllerX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    if (MediaControllerX.a(this.a) != null) {
      MediaControllerX.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    MediaControllerX.a(this.a);
    if ((MediaControllerX.a(this.a)) && (MediaControllerX.a(this.a) != null) && (MediaControllerX.a(this.a).getHeight() != 0)) {
      MediaControllerX.a(this.a).updateViewLayout(MediaControllerX.a(this.a), MediaControllerX.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */