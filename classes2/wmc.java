import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ExpandableEntranceLayout;

public class wmc
  implements Animation.AnimationListener
{
  public wmc(ExpandableEntranceLayout paramExpandableEntranceLayout, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ExpandableEntranceLayout.a(this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ExpandableEntranceLayout.a(this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout, -1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */