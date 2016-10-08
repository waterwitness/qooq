import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class kmd
  implements ValueAnimation.AnimationUpdateListener
{
  public kmd(BaseChatPie paramBaseChatPie, AbsListView.LayoutParams paramLayoutParams)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$LayoutParams.height = paramInteger.intValue();
    if (BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie) != null)
    {
      BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).requestLayout();
      return;
    }
    paramValueAnimation.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */