import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;

public class okb
  implements View.OnClickListener
{
  public okb(ShowExternalTroopListActivity paramShowExternalTroopListActivity, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.f, 0);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.app;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.f;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_Boolean) {}
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_join", "", "person_data", "Clk_user", 0, 0, str, paramView, "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\okb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */