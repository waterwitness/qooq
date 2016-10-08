import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qyz
  implements Runnable
{
  public qyz(ConditionSearchFriendActivity paramConditionSearchFriendActivity, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity.a.getHeight();
    ConditionSearchFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity, this.jdField_a_of_type_Int - (this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity.d.getBottom() - i) + this.b);
    int j = this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity.getResources().getDisplayMetrics().heightPixels;
    int k = this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity.getResources().getDisplayMetrics().widthPixels;
    if (QLog.isColorLevel()) {
      QLog.d("meassure", 2, "(" + k + "," + j + ")" + "value: " + ConditionSearchFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity) + " itemTop:" + this.jdField_a_of_type_Int + "  pvTop:" + (this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity.d.getBottom() - i) + "  itemHeight:" + this.b + " RootBottom:" + this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity.d.getBottom() + " pvHeight:" + i);
    }
    if ((ConditionSearchFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity) <= 0) || (this.jdField_a_of_type_Int == -1) || (this.b == -1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity.e.scrollBy(0, ConditionSearchFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchConditionSearchFriendActivity));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */