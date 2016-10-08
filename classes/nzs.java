import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nzs
  implements ValueAnimator.AnimatorUpdateListener
{
  public nzs(PublicAccountChatPie paramPublicAccountChatPie, View paramView, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    paramValueAnimator = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    float f2 = this.jdField_a_of_type_Int;
    paramValueAnimator.height = ((int)(f1 * (this.b - this.jdField_a_of_type_Int) + f2));
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */