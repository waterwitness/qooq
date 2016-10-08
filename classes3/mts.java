import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mts
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public mts(TroopMemberCardActivity paramTroopMemberCardActivity, LinearLayout paramLinearLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getResources().getString(2131365069));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[1].setBackgroundResource(2130838357);
    }
    for (;;)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d("exp_joingrp", "P_CliOper");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[1].setBackgroundResource(2130838352);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */