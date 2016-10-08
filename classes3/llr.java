import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class llr
  implements ValueAnimator.AnimatorUpdateListener
{
  public llr(FriendProfileCardActivity paramFriendProfileCardActivity, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(i);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */