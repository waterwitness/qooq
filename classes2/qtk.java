import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qtk
  extends AnimatorListenerAdapter
{
  public qtk(SelectCoverActivity paramSelectCoverActivity, View paramView1, View paramView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qtk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */