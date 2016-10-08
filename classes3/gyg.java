import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gyg
  implements Animation.AnimationListener
{
  public gyg(QavInOutAnimation paramQavInOutAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationEnd");
    }
    try
    {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().aq = false;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().ar = false;
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(4);
      }
      if (this.a.jdField_a_of_type_AndroidViewView != null) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      if (this.a.b != null) {
        this.a.b.setVisibility(4);
      }
      if (this.a.c != null) {
        this.a.c.setVisibility(4);
      }
      if (this.a.d != null) {
        this.a.d.setVisibility(4);
      }
      if (this.a.e != null) {
        this.a.e.setVisibility(4);
      }
      if (this.a.g != null) {
        this.a.g.setVisibility(4);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener.b();
      }
      return;
    }
    catch (Exception paramAnimation)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QavInOutAnimation", 2, "QavOutAnimationListener onAnimationEnd Exception :" + paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationStart");
    }
    try
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener.a();
      }
      return;
    }
    catch (Exception paramAnimation)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QavInOutAnimation", 2, "QavOutAnimationListener onAnimationStart Exception :" + paramAnimation);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */