import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kxi
  implements Animation.AnimationListener
{
  public kxi(ChatHistoryForC2C paramChatHistoryForC2C, View paramView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */