import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import mqq.app.MobileQQ;

public class mnc
  implements ActionSheet.OnButtonClickListener
{
  public mnc(SubAccountMessageActivity paramSubAccountMessageActivity, boolean paramBoolean, ActionSheet paramActionSheet)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    switch (i)
    {
    default: 
      return;
    case 0: 
      Class localClass = SubLoginActivity.class;
      Intent localIntent = new Intent();
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app.getApplication().getAllAccounts();
      paramView = localClass;
      if (localList != null)
      {
        paramView = localClass;
        if (localList.size() > 2) {
          paramView = SubAccountBindActivity.class;
        }
      }
      localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, paramView);
      localIntent.putExtra("fromWhere", this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.a);
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app, "CliOper", "", "", "0X800445A", "0X800445A", 0, 0, "", "", "", "");
      return;
    case 1: 
      SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, true, false);
      return;
    }
    SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, false, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */