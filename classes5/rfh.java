import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.dating.DismissAnimationAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rfh
  implements ValueAnimator.AnimatorUpdateListener
{
  public rfh(DismissAnimationAdapter paramDismissAnimationAdapter, ViewGroup.LayoutParams paramLayoutParams, View paramView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    float f2 = i / this.jdField_a_of_type_Int;
    float f1;
    if (f2 < 0.0F) {
      f1 = 0.0F;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(f1);
      return;
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */