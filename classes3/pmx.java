import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pmx
  implements Animation.AnimationListener
{
  public pmx(QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest, View paramView1, View paramView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QQAVFunnyFaceInvest.a(this.jdField_a_of_type_ComTencentMobileqqActivityWelcomeguideQQAVFunnyFaceInvest)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityWelcomeguideQQAVFunnyFaceInvest.b.postDelayed(new pmy(this), 800L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */