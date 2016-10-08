import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pey
  implements Animation.AnimationListener
{
  public pey(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    paramAnimation = (FrameLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramAnimation.setMargins(0, 0, 0, this.a.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight());
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramAnimation);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */