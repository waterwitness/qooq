import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.av.ui.BeautySettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gyu
  implements Animation.AnimationListener
{
  public gyu(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
    this.a.c.clearAnimation();
    this.a.b.clearAnimation();
    this.a.e.clearAnimation();
    this.a.n(BeautySettingUi.a(this.a.jdField_a_of_type_ComTencentAvVideoController, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */