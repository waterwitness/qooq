import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopPrivateSettingActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class mwi
  implements DialogInterface.OnClickListener
{
  public mwi(TroopPrivateSettingActivity paramTroopPrivateSettingActivity, BizTroopHandler paramBizTroopHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.a.troopcode, false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.app, "P_CliOper", "Grp_set", "", "Grp_data", "share_set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.b, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */