import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class srt
  implements ValueAnimator.AnimatorUpdateListener
{
  public srt(FNDefaultItemBuilder paramFNDefaultItemBuilder, ViewGroup.LayoutParams paramLayoutParams, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FNDefaultItemBuilder", 4, "onAnimationUpdate newHeight:" + i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */