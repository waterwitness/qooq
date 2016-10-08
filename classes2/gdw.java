import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.arrange.ui.EditMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gdw
  implements Animation.AnimationListener
{
  public gdw(EditMemberActivity paramEditMemberActivity, TranslateAnimation paramTranslateAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.a.show();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */