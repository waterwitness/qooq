import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;
import java.util.Queue;

public class vte
  implements Animator.AnimatorListener
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  public vte(MessageSubtitleView paramMessageSubtitleView, boolean paramBoolean, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int == MessageSubtitleView.g) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.b();
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.a.isEmpty()) {
        MessageSubtitleView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */