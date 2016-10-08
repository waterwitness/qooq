import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

class muy
  implements View.OnClickListener
{
  muy(muw parammuw, String paramString, CheckBox paramCheckBox, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (TroopHandler)this.jdField_a_of_type_Muw.a.app.a(20);
    Object localObject;
    if (paramView != null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_JavaLangString)));
      paramView.a(Long.parseLong(this.jdField_a_of_type_Muw.a.k), (List)localObject, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      localObject = this.jdField_a_of_type_Muw.a.F;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label184;
      }
    }
    label184:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(this.jdField_a_of_type_Muw.a.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_Muw.a.k, (String)localObject, paramView, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_Muw.a.i();
      this.jdField_a_of_type_Muw.a.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\muy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */