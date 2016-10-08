import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;

public class sue
  implements Animator.AnimatorListener
{
  public sue(HotChatPttStageControl paramHotChatPttStageControl, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a(true);
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.setBackgroundResource(2130843537);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j = (-this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */