import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class svr
  implements ValueAnimator.AnimatorUpdateListener
{
  svr(svq paramsvq, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setTranslationX(-((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\svr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */