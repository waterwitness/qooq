import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;

public class sud
  implements ValueAnimator.AnimatorUpdateListener
{
  public sud(HotChatPttStageControl paramHotChatPttStageControl, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((i <= 0) && (i >= -this.jdField_a_of_type_Int) && (i != this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j))
    {
      paramValueAnimator = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.getLayoutParams();
      paramValueAnimator.topMargin = i;
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.setLayoutParams(paramValueAnimator);
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j = i;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */