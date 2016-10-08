import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;

public class odo
  implements View.OnClickListener
{
  public odo(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (TroopChatPie.a(this.a).getVisibility() != 8)
    {
      paramView = new Intent(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, NearbyMemberActivity.class);
      paramView.putExtra("troop_session", this.a.a());
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramView, 9001);
      String str = "1";
      Object localObject = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      paramView = str;
      if (localObject != null)
      {
        paramView = str;
        if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
        {
          localObject = ((TroopManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          paramView = str;
          if (localObject != null)
          {
            paramView = str;
            if (((TroopInfo)localObject).isAdmin()) {
              paramView = "2";
            }
          }
        }
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_nearby_mber", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView, "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */