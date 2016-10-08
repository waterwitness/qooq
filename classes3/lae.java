import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class lae
  implements Animation.AnimationListener
{
  public lae(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (paramAnimation == this.a.b)
    {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    }
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    while (paramAnimation != this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */