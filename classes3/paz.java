import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleProgress;

public class paz
  implements ValueAnimator.AnimatorUpdateListener
{
  public paz(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramValueAnimator.width = ((int)(this.jdField_a_of_type_Int * f));
    paramValueAnimator.height = ((int)(this.jdField_a_of_type_Int * f));
    paramValueAnimator.addRule(13);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    paramValueAnimator.width = ((int)(this.b * f));
    paramValueAnimator.height = ((int)(f * this.b));
    paramValueAnimator.addRule(13);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams(paramValueAnimator);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\paz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */