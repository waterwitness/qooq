import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanelSoundWaveView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gyf
  implements Animation.AnimationListener
{
  public gyf(QavInOutAnimation paramQavInOutAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.clearAnimation();
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.a.f);
      if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a() != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a().startAnimation(this.a.jdField_g_of_type_AndroidViewAnimationAnimation);
      }
    }
    if (this.a.jdField_a_of_type_AndroidViewView != null)
    {
      this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
      if (this.a.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        this.a.jdField_a_of_type_AndroidViewView.startAnimation(this.a.jdField_c_of_type_AndroidViewAnimationAnimation);
      }
    }
    if (this.a.b != null)
    {
      this.a.b.clearAnimation();
      if (this.a.b.getVisibility() == 0) {
        this.a.b.startAnimation(this.a.jdField_d_of_type_AndroidViewAnimationAnimation);
      }
    }
    if (this.a.jdField_c_of_type_AndroidViewView != null)
    {
      this.a.jdField_c_of_type_AndroidViewView.clearAnimation();
      if (this.a.jdField_c_of_type_AndroidViewView.getVisibility() == 0) {
        this.a.jdField_c_of_type_AndroidViewView.startAnimation(this.a.jdField_d_of_type_AndroidViewAnimationAnimation);
      }
    }
    if (this.a.jdField_d_of_type_AndroidViewView != null)
    {
      this.a.jdField_d_of_type_AndroidViewView.clearAnimation();
      if (this.a.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
        this.a.jdField_d_of_type_AndroidViewView.startAnimation(this.a.jdField_e_of_type_AndroidViewAnimationAnimation);
      }
    }
    if (this.a.jdField_e_of_type_AndroidViewView != null)
    {
      this.a.jdField_e_of_type_AndroidViewView.clearAnimation();
      if (this.a.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
        this.a.jdField_e_of_type_AndroidViewView.startAnimation(this.a.jdField_e_of_type_AndroidViewAnimationAnimation);
      }
    }
    if (this.a.jdField_g_of_type_AndroidViewView != null)
    {
      this.a.jdField_g_of_type_AndroidViewView.clearAnimation();
      if (this.a.jdField_g_of_type_AndroidViewView.getVisibility() == 0) {
        this.a.jdField_g_of_type_AndroidViewView.startAnimation(this.a.jdField_e_of_type_AndroidViewAnimationAnimation);
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null)) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().aq = true;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */