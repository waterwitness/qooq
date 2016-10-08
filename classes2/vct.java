import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;

public class vct
  implements Animation.AnimationListener
{
  public vct(AbsPublishActivity paramAbsPublishActivity, Animation paramAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.b.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.c.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */