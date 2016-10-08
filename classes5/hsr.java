import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class hsr
  implements ValueAnimation.AnimationUpdateListener
{
  public hsr(VideoUIController paramVideoUIController, View paramView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.j) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.getBackground().setAlpha(paramInteger.intValue());
      this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.g = paramInteger.intValue();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.g != this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.j = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */