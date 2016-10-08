import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class onj
  implements ValueAnimator.AnimatorUpdateListener
{
  private int jdField_a_of_type_Int;
  private IntEvaluator jdField_a_of_type_AndroidAnimationIntEvaluator;
  
  public onj(AvatarPendantActivity paramAvatarPendantActivity, List paramList1, List paramList2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidAnimationIntEvaluator = new IntEvaluator();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      paramValueAnimator = (View)this.jdField_a_of_type_JavaUtilList.get(i);
      onr localonr = (onr)this.b.get(i);
      ViewGroup.LayoutParams localLayoutParams = paramValueAnimator.getLayoutParams();
      if (localonr.jdField_a_of_type_Int != localonr.b)
      {
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)paramValueAnimator.getLayoutParams();
        localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localonr.jdField_a_of_type_Int), Integer.valueOf(localonr.b)).intValue();
        paramValueAnimator.setLayoutParams(localLayoutParams1);
      }
      if (localonr.c != localonr.d) {
        localLayoutParams.height = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localonr.c), Integer.valueOf(localonr.d)).intValue();
      }
      if (localonr.e != localonr.f) {
        localLayoutParams.width = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localonr.e), Integer.valueOf(localonr.f)).intValue();
      }
      paramValueAnimator.setLayoutParams(localLayoutParams);
      paramValueAnimator.requestLayout();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */