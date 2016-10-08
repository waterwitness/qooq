import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;

public class oea
  implements View.OnClickListener
{
  public oea(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopBindPublicAccountMgr localTroopBindPublicAccountMgr = (TroopBindPublicAccountMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    if ((paramView != null) && (localTroopBindPublicAccountMgr != null))
    {
      paramView = paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((paramView != null) && (paramView.associatePubAccount > 0L))
      {
        paramView = String.format("http://buluo.qq.com/mobile/pub_history/main.html?puin=%1$s&_wv=1027", new Object[] { Long.valueOf(paramView.associatePubAccount) });
        Intent localIntent = new Intent(this.a.a(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramView);
        this.a.a().startActivity(localIntent);
        if (localTroopBindPublicAccountMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {}
        for (paramView = "Clk_red";; paramView = "Clk_unred")
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", paramView, 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          localTroopBindPublicAccountMgr.e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.f(false);
          }
          return;
        }
      }
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, TroopChatPie.a(this.a), TroopChatPie.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.a.L);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */