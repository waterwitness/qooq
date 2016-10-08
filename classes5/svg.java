import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svg
  implements Animator.AnimatorListener
{
  public svg(GlowView paramGlowView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
    this.a.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    GlowView.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c = false;
    if (this.a.jdField_b_of_type_Boolean) {
      GlowView.a(this.a);
    }
    this.a.jdField_b_of_type_AndroidAnimationValueAnimator = null;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    this.a.jdField_b_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */