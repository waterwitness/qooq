import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager.QQWalletPayCompletionImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;

class uvy
  implements PublicQuickPayManager.QQWalletPayCompletionImp
{
  uvy(uvx paramuvx, StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext, StructMsgItemButton paramStructMsgItemButton, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    int j = paramBundle.getInt("retCode");
    String str = paramBundle.getString("retMsg");
    int k = paramBundle.getInt("payTime");
    paramBundle.getString("payChannelType");
    paramBundle = paramBundle.getString("orderId");
    if ((j == 0) || (j == -4) || (j == -6))
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.savePayInfo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uvx.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemButton.cP);
      StructMsgItemButton.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemButton, false);
    }
    if (j == 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, "0X80061FF", "0X80061FF", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      int i = 63525;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.msgtype;
      }
      paramBundle = PublicAccountManager.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.msgId, paramBundle, j, str, i, k, null, null);
      PublicAccountManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, "0X8006200", "0X8006200", 0, 1, j, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */