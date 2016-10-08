import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class oab
  implements CustomMenuBar.OnMenuItemClickListener
{
  public oab(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    this.a.d = new QQProgressDialog(PublicAccountChatPie.d(this.a).getContext(), this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    long l = NetConnInfoCenter.getServerTime();
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    String str1;
    if ("DO_FOLLOW".equals(paramString)) {
      if (PublicAccountChatPie.a(this.a))
      {
        PublicAccountChatPie.a(this.a);
        str1 = "";
        paramString = str1;
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null)
        {
          paramString = str1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a != null)
          {
            paramString = str1;
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a.size() > 0) {
              paramString = ((TroopInfo)this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a.get(0)).troopuin;
            }
          }
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, "" + str2, "", "");
        this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, new oac(this));
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF5", "0X8004EF5", 0, 0, Long.toString(l), "", "" + this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, PublicAccountChatPie.a(this.a));
      }
      this.a.r(2131364484);
      this.a.aK();
      return;
      if ("DO_NOT_FOLLOW".equals(paramString))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF7", "0X8004EF7", 0, 0, Long.toString(l), "", "" + this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "" + PublicAccountChatPie.a(this.a));
        }
        if (PublicAccountChatPie.a(this.a))
        {
          PublicAccountChatPie.a(this.a, str2);
          str1 = "";
          paramString = str1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null)
          {
            paramString = str1;
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a != null)
            {
              paramString = str1;
              if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a.size() > 0) {
                paramString = ((TroopInfo)this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a.get(0)).troopuin;
              }
            }
          }
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, "" + str2, "", "");
          return;
        }
        this.a.aH();
        return;
      }
    } while (!"DO_CANCEL".equals(paramString));
    this.a.r(2131364484);
    PublicAccountChatPie.a(this.a, PublicAccountManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, false, BaseApplication.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new oad(this)));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */