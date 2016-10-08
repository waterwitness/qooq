import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mtq
  implements Runnable
{
  mtq(mtp parammtp, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.isResume()) {
      return;
    }
    this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[1], this.jdField_a_of_type_JavaLangString, true);
      this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[1].setContentDescription(this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131364648) + this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[1], this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131365081), true);
    this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[1].setContentDescription(this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131364648) + this.jdField_a_of_type_Mtp.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131365081));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */