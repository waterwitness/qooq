import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nnt
  implements View.OnClickListener
{
  public nnt(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      PasswdRedBagManager localPasswdRedBagManager;
      PasswdRedBagInfo localPasswdRedBagInfo;
      do
      {
        do
        {
          return;
          paramView = ((MessageForQQWalletMsg)paramView.getTag()).mQQWalletRedPacketMsg;
          localPasswdRedBagManager = (PasswdRedBagManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
          if (!AnonymousChatHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
            break;
          }
          localPasswdRedBagManager.e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        } while (!QLog.isColorLevel());
        QLog.d(PasswdRedBagManager.a, 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        localPasswdRedBagInfo = localPasswdRedBagManager.a(paramView.redPacketId);
        if ((localPasswdRedBagInfo == null) || ((!localPasswdRedBagInfo.a) && (!localPasswdRedBagInfo.b) && (!localPasswdRedBagInfo.c))) {
          break;
        }
        localPasswdRedBagManager.c(paramView.redPacketId);
        long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localPasswdRedBagInfo, l);
        localPasswdRedBagManager.a(paramView.redPacketId, true);
      } while (!QLog.isColorLevel());
      QLog.d(PasswdRedBagManager.a, 2, "click open passwdredbag, isPasswdRedBagOpen=" + localPasswdRedBagInfo.a + ",isPasswdRedBagFinish=" + localPasswdRedBagInfo.b + ",isPasswdRedBagOverDue=" + localPasswdRedBagInfo.c);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramView.redPacketId, paramView.elem.title, "点击输入口令");
      }
      localPasswdRedBagManager.a(paramView.redPacketId, false);
    } while (!QLog.isColorLevel());
    QLog.d(PasswdRedBagManager.a, 2, "show passwdredbag tips = " + paramView.elem.title);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */