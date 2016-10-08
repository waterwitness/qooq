import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ozl
  implements ValueAnimator.AnimatorUpdateListener
{
  public ozl(FlowCameraActivity2 paramFlowCameraActivity2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.g.setPadding(0, 0, 0, paramValueAnimator.intValue());
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.e.setPadding(0, this.jdField_a_of_type_Int - paramValueAnimator.intValue(), 0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */