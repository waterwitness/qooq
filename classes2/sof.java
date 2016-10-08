import android.view.View;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class sof
  implements ActionSheet.OnButtonClickListener
{
  public sof(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
    case 0: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a()) {
        QQToast.a(BaseApplication.getContext(), 0, this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131371561), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      }
      while (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(4);
        break;
        NearPeopleFilterActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters, 100);
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8004441", "0X8004441", 0, 0, "", "", "", "");
      }
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    if (paramView == null) {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
    }
    for (;;)
    {
      paramInt = 0;
      if (paramView != null)
      {
        if (paramView.godFlag == 1) {
          paramInt = 1;
        }
      }
      else
      {
        label214:
        if (paramInt == 0) {
          break label285;
        }
        this.a.a(paramView);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(5);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8004444", "0X8004444", 1, 0, "", "", "", "");
        break;
        paramInt = 0;
        break label214;
        label285:
        if ((NetworkUtil.e(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
        {
          MineFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
        }
        else
        {
          QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131367481), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */