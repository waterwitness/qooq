import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.DBUtils;

public class mnh
  implements View.OnClickListener
{
  public mnh(SubAccountMessageActivity paramSubAccountMessageActivity, SubAccountManager paramSubAccountManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a() >= 2)
    {
      SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity);
      return;
    }
    paramView = new Intent(paramView.getContext(), SubAccountBindActivity.class);
    paramView.putExtra("fromWhere", this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.a);
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.startActivity(paramView);
    DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app.a(), true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app, "CliOper", "", "", "0X8004459", "0X8004459", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */