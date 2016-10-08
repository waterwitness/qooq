import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class mjk
  implements ActionSheet.OnButtonClickListener
{
  public mjk(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      paramView = "";
      localObject = RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).getText();
      if (localObject != null)
      {
        localObject = localObject.toString();
        paramView = (View)localObject;
        if (localObject != null) {
          paramView = ((String)localObject).trim();
        }
      }
      if (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity)) {
        RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.f, paramView);
      }
      break;
    }
    for (paramView = "0X80066E2";; paramView = (View)localObject)
    {
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.app, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.finish();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.app, "CliOper", "", "", "0X8006658", "0X8006658", 0, 0, "", "", "", "");
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, true);
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.app, "CliOper", "", "", "0X8006659", "0X8006659", 0, 0, "", "", "", "");
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, false);
      break;
      localObject = "0X80066E3";
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.f, paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */