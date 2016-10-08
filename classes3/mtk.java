import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class mtk
  implements Animation.AnimationListener
{
  public mtk(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = true;
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("onAnimationStart, [");
      if (paramAnimation != this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
        break label104;
      }
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(",");
      if (paramAnimation != this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation) {
        break label109;
      }
    }
    label104:
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, bool1 + "]");
      if (this.a.jdField_b_of_type_AndroidWidgetTextView != null) {
        break label114;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "mTitleBar is null");
      }
      return;
      bool1 = false;
      break;
    }
    label114:
    if (paramAnimation == this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation)
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onAnimationStart, [");
      if (paramAnimation == this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)
      {
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append(",");
        if (paramAnimation != this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation) {
          break label109;
        }
        bool1 = bool2;
        label60:
        QLog.i("Q.profilecard.FrdProfileCard", 4, bool1 + "]");
      }
    }
    else
    {
      if (this.a.jdField_b_of_type_AndroidWidgetTextView != null) {
        break label114;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "mTitleBar is null");
      }
    }
    label109:
    label114:
    while (paramAnimation != this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)
    {
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label60;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */