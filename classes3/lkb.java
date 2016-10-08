import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

public class lkb
  implements ActionSheet.OnButtonClickListener
{
  public lkb(FriendProfileCardActivity paramFriendProfileCardActivity, PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean, ActionSheet paramActionSheet)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a();
      return;
      if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getApplication().getApplicationContext()))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
        String str = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a);
        label77:
        QQAppInterface localQQAppInterface;
        if (!this.jdField_a_of_type_Boolean)
        {
          paramView.a(str, bool);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.u();
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app;
          if (!this.jdField_a_of_type_Boolean) {
            break label152;
          }
          paramView = "0X800603E";
          label110:
          if (!this.jdField_a_of_type_Boolean) {
            break label158;
          }
        }
        label152:
        label158:
        for (str = "0X800603E";; str = "0X800603D")
        {
          ReportController.b(localQQAppInterface, "CliOper", "", "", paramView, str, 0, 0, "", "", "", "");
          break;
          bool = false;
          break label77;
          paramView = "0X800603D";
          break label110;
        }
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 1, "当前网络不可用", 1000).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */