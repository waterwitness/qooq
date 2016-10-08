import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class ljp
  implements View.OnClickListener
{
  public ljp(ForwardRecentActivity paramForwardRecentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int m = 2;
    int i = paramView.getId();
    if (i == 2131300895)
    {
      ForwardRecentActivity.a(this.a, 10);
      return;
    }
    if (i == 2131297183)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(false);
        com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
      }
      this.a.finish();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("call_by_forward", true);
    if (this.a.jdField_a_of_type_AndroidNetUri != null) {
      localIntent.setData(this.a.jdField_a_of_type_AndroidNetUri);
    }
    if (this.a.getIntent().getBooleanExtra("isFromShare", false))
    {
      localIntent.putExtras(this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a());
      localIntent.setAction(this.a.getIntent().getAction());
    }
    for (;;)
    {
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131297753: 
        localIntent.putExtra("onlyOneSegement", true);
        localIntent.putExtra("_key_mode", 0);
        localIntent.putExtra("key_tab_mode", 1);
        localIntent.setClass(this.a, TroopActivity.class);
        this.a.startActivityForResult(localIntent, 20000);
        ReportController.b(this.a.app, "CliOper", "", "", "0X800404C", "0X800404C", 0, 0, "", "", "", "");
        return;
        localIntent.putExtras(this.a.getIntent().getExtras());
      }
    }
    localIntent.setClass(this.a, PhoneFrameActivity.class);
    localIntent.putExtra("key_req_type", 2);
    this.a.startActivityForResult(localIntent, 20000);
    ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "1", "", "", "");
    ReportController.b(this.a.app, "CliOper", "", "", "0X800404B", "0X800404B", 0, 0, "", "", "", "");
    return;
    localIntent.putExtra("onlyOneSegement", true);
    localIntent.putExtra("_key_mode", 1);
    localIntent.putExtra("key_tab_mode", 1);
    localIntent.setClass(this.a, TroopActivity.class);
    this.a.startActivityForResult(localIntent, 20000);
    ReportController.b(this.a.app, "CliOper", "", "", "0X800404D", "0X800404D", 0, 0, "", "", "", "");
    return;
    ReportController.b(this.a.app, "CliOper", "", "", "0X800665F", "0X800665F", 0, 0, "", "", "", "");
    localIntent.setClass(this.a, ForwardFriendListActivity.class);
    this.a.startActivityForResult(localIntent, 20000);
    ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
    ReportController.b(this.a.app, "CliOper", "", "", "0X800404A", "0X800404A", 0, 0, "", "", "", "");
    return;
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf("-1010"));
    paramView.putInt("uintype", -1);
    this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.e.intValue(), paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X800404E", "0X800404E", 0, 0, "", "", "", "");
    return;
    int k = 99;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.g())
    {
      j = 1;
      i = j;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c))
      {
        i = j;
        if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)) {
          i = 1;
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b)) {
        break label1132;
      }
    }
    label1132:
    for (int j = m;; j = 1)
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.i)) {}
      for (boolean bool = true;; bool = false)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.d())
        {
          i = 1;
          k = 1;
        }
        paramView = new Intent(this.a, SelectMemberActivity.class);
        paramView.putExtra("param_type", 3000);
        paramView.putExtra("param_subtype", 0);
        paramView.putExtra("param_done_button_wording", this.a.getString(2131370179));
        paramView.putExtra("param_done_button_highlight_wording", this.a.getString(2131370180));
        paramView.putExtra("param_min", j);
        paramView.putExtra("param_max", k);
        paramView.putExtra("param_donot_need_contacts", bool);
        if (i != 0)
        {
          paramView.putExtra("param_donot_need_troop", true);
          paramView.putExtra("param_donot_need_discussion", true);
        }
        paramView.putExtra("param_entrance", 12);
        this.a.startActivityForResult(paramView, 20003);
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005A10", "0X8005A10", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006661", "0X8006661", 0, 0, "", "", "", "");
        return;
        j = 0;
        break;
        localIntent.setClass(this.a, TroopActivity.class);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d))
        {
          localIntent.putExtra("onlyOneSegement", true);
          localIntent.putExtra("_key_mode", 0);
          localIntent.putExtra("key_tab_mode", 1);
        }
        for (;;)
        {
          this.a.startActivityForResult(localIntent, 20000);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006660", "0X8006660", 0, 0, "", "", "", "");
          return;
          if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c))
          {
            localIntent.putExtra("onlyOneSegement", true);
            localIntent.putExtra("_key_mode", 1);
            localIntent.putExtra("key_tab_mode", 1);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ljp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */