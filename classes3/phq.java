import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;

public class phq
  implements View.OnFocusChangeListener
{
  public phq(SelectMemberActivity paramSelectMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.a.Z == 8) || (this.a.Z == 9) || (this.a.Z != this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())))
    {
      paramView = ((SelectMemberInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
      if (paramView != null)
      {
        paramView.a(SelectMemberActivity.a(this.a), this.a.g);
        FragmentTransaction localFragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
        if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          localFragmentTransaction.remove(this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        }
        localFragmentTransaction.add(2131297765, paramView);
        localFragmentTransaction.commitAllowingStateLoss();
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = paramView;
      }
      if ((this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 6) && (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 4)) {
        break label211;
      }
    }
    while (this.a.O == 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800543F", "0X800543F", 1, 0, "", "", "", "");
      return;
      label211:
      if ((this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 8) || (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 4)) {}
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800543F", "0X800543F", 2, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\phq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */