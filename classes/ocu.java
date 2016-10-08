import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ModifyTroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;

class ocu
  implements View.OnClickListener
{
  ocu(oct paramoct)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a.a.a.jdField_a_of_type_AndroidContentContext, ModifyTroopMemberCardActivity.class);
    paramView.putExtra("selfSet_leftViewText", this.a.a.a.a.jdField_a_of_type_AndroidContentContext.getString(2131367975));
    paramView.putExtra("troopUin", this.a.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramView.putExtra("memberUin", this.a.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramView.putExtra("troopCode", this.a.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    this.a.a.a.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    if (this.a.a.a.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.a.a.a.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.j();
    }
    ReportController.b(this.a.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80058F8", "0X80058F8", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ocu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */