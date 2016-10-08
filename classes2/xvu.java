import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XPanelContainer;

public class xvu
  implements ValueAnimator.AnimatorUpdateListener
{
  public xvu(XPanelContainer paramXPanelContainer, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    XPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_Int - i);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */