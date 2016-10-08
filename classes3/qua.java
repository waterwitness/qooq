import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.AvatarPendantManager;

public class qua
  extends AnimatorListenerAdapter
{
  public qua(BubbleNewAIOAnim paramBubbleNewAIOAnim)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a("animator set end!");
    if (this.a.c != null)
    {
      BubbleNewAIOAnim.a(this.a).removeView(this.a.c);
      this.a.c = null;
      if (this.a.d == null) {
        break label186;
      }
      BubbleNewAIOAnim.b(this.a).removeView(this.a.d);
      this.a.d = null;
    }
    for (;;)
    {
      if (this.a.e != null)
      {
        this.a.e.setVisibility(0);
        paramAnimator = (AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
        paramAnimator.a = -1L;
        paramAnimator.b();
      }
      if (this.a.jdField_b_of_type_AndroidViewView != null) {
        this.a.jdField_b_of_type_AndroidViewView.invalidate();
      }
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_b_of_type_JavaLangString = "";
      this.a.a(true);
      return;
      this.a.a("something wrong, bubble view is null!");
      break;
      label186:
      this.a.a("something wrong, pendview is null!");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a("animator set start!");
    this.a.a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */