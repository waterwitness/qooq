import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lzu
  implements ActionSheet.OnButtonClickListener
{
  public lzu(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, String paramString1, String paramString2, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "CliOper", "", "", "0X8005B7C", "0X8005B7C", 0, 0, "", "", "", "");
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getString(2131367256), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getTitleBarHeight());
        return;
      }
      paramView = (SecSvcHandler)this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app.a(34);
      if (paramView != null) {
        paramView.a(3, this.jdField_a_of_type_JavaLangString, this.b);
      }
      PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131368647, 1000L, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.b = false;
      return;
    case 1: 
      if (!NetworkUtil.e(paramView))
      {
        PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131368805);
        return;
      }
      paramView = new Intent(paramView, BindNumberActivity.class);
      paramView.putExtra("cmd_param_is_from_uni", true);
      paramView.putExtra("cmd_param_is_from_change_bind", true);
      paramView.putExtra("kNeedUnbind", true);
      paramView.putExtra("kUnityOther", true);
      paramView.putExtra("kSrouce", this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.o);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.startActivityForResult(paramView, 1004);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "CliOper", "", "", "0X8005B7D", "0X8005B7D", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.b = false;
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "CliOper", "", "", "0X8005B7E", "0X8005B7E", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.b = true;
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */