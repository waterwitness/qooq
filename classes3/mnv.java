import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class mnv
  implements ActionSheet.OnButtonClickListener
{
  public mnv(SubAccountSettingActivity paramSubAccountSettingActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((!this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.b()) || ((SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity) != null) && (TextUtils.isEmpty(SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity).subuin))));
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.a(2131370579);
    paramView = (SubAccountProtocManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.app.getManager(27);
    if (paramView != null) {
      paramView.a(SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity).subuin);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */