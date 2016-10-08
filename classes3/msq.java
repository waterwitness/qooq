import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class msq
  implements View.OnClickListener
{
  public msq(TroopMemberCardActivity paramTroopMemberCardActivity, CheckBox paramCheckBox, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new ArrayList();
    paramView.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v)));
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t), paramView, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    paramView = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M == 3)
    {
      paramView = "0";
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label161;
      }
    }
    label161:
    for (String str = "0";; str = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, paramView, str, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M != 2) {
        break;
      }
      paramView = "1";
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */