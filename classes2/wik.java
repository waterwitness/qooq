import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qphone.base.util.QLog;

public class wik
  implements Animation.AnimationListener
{
  public wik(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "showScreenshotPad->on hideAnimationEnd!");
    }
    SwiftBrowserShareMenuHandler.a(this.a).setVisibility(8);
    if ((SwiftBrowserShareMenuHandler.a(this.a) != null) && (!SwiftBrowserShareMenuHandler.a(this.a).isRecycled())) {
      SwiftBrowserShareMenuHandler.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */