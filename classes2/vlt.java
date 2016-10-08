import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioNewMessageBar;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class vlt
  implements View.OnClickListener
{
  public vlt(TroopAioNewMessageBar paramTroopAioNewMessageBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    TroopAioNewMessageBar.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.d_() - 1);
    if (this.a.k == TroopAioNewMessageBar.d) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_newmsgcue", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    }
    while (this.a.k != TroopAioNewMessageBar.e) {
      return;
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_backbase", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vlt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */