import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;

public class ljl
  implements View.OnClickListener
{
  public ljl(ForwardRecentActivity paramForwardRecentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf(AppConstants.au));
    paramView.putInt("uintype", -1);
    paramView.putBoolean("forward_report_confirm", true);
    paramView.putString("forward_report_confirm_action_name", "0X8005A13");
    paramView.putString("forward_report_confirm_reverse2", "2");
    this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.g.intValue(), paramView);
    if (this.a.jdField_a_of_type_Boolean) {
      ReportCenter.a().a(this.a.app.getAccount(), "", this.a.k, "1000", "35", "0", false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ljl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */