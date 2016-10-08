import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;

public class jcx
  implements View.OnClickListener
{
  public jcx(EditUniqueTitleActivity paramEditUniqueTitleActivity, AlertDialog paramAlertDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.a.getEditableText().toString();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
      return;
      long l = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.k = ((String)localObject);
      this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.jdField_h_of_type_Int = ((int)l + 2592000);
      EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.i, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.k, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.jdField_h_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.app;
      String str = this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.k)) {}
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, str, paramView, "1", "1");
        break;
      }
      this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.k = ((String)localObject);
      this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.jdField_h_of_type_Int = -1;
      EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.i, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.k, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.jdField_h_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.app;
      str = this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.k)) {}
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, str, paramView, "1", "0");
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.app, "P_CliOper", "Grp_manage", "", "mber_title", "cancle_title", 0, 0, this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.i, "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */