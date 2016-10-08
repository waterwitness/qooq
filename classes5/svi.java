import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class svi
  implements Animator.AnimatorListener
{
  public svi(GlowView paramGlowView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
    this.a.jdField_b_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    this.a.jdField_b_of_type_AndroidWidgetImageView.setScaleY(1.0F);
    this.a.c = null;
    this.a.jdField_b_of_type_Boolean = false;
    if (QLog.isDevelopLevel()) {
      QLog.i(GlowView.jdField_a_of_type_JavaLangString, 2, "stop anim cancel.");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_b_of_type_Boolean = false;
    this.a.c = null;
    if (QLog.isDevelopLevel()) {
      QLog.i(GlowView.jdField_a_of_type_JavaLangString, 2, "stop anim end.");
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */