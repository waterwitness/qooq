import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class nnq
  implements View.OnClickListener
{
  public nnq(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (QQWalletMsgItemBuilder.a(this.a)) {}
    label502:
    label798:
    label850:
    label1033:
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if (this.a.a(this.a.jdField_a_of_type_Long, l))
      {
        this.a.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)((nnv)AIOUtils.a(paramView)).a;
        Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (localMessageForQQWalletMsg != null)
        {
          boolean bool = QQWalletMsgItemBuilder.a(this.a, localMessageForQQWalletMsg);
          QQWalletTransferMsgElem localQQWalletTransferMsgElem;
          Object localObject3;
          Object localObject2;
          if ((!bool) && (localMessageForQQWalletMsg.mQQWalletTransferMsg != null))
          {
            localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletTransferMsg.templateId, "", "", "");
            localObject3 = null;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
          for (;;)
          {
            if (localQQWalletTransferMsgElem == null) {
              break label1033;
            }
            int i;
            if (TextUtils.isEmpty(localQQWalletTransferMsgElem.actionsPriority))
            {
              QQWalletMsgItemBuilder.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.linkUrl);
              return;
              if ((bool) && (localMessageForQQWalletMsg.mQQWalletTransferMsg != null))
              {
                localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
                localObject2 = (TextView)paramView.findViewById(2131303186);
                ((TextView)localObject2).setVisibility(0);
                ((TextView)localObject2).setText("已拆开");
                paramView.findViewById(2131303189).setVisibility(8);
                localMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg();
                localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
                localMessageForQQWalletMsg.msgtype = 63511;
                localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey = "";
                localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId = "";
                localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype = 0;
                localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId = 0;
                localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
                localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
                localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
                this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
                localObject2 = localObject1;
                localObject1 = null;
                continue;
              }
              if ((bool) && (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null))
              {
                if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
                {
                  i = 1;
                  localObject2 = localObject1;
                  if (i != 0)
                  {
                    localObject2 = localObject1;
                    if (!localMessageForQQWalletMsg.isSend()) {
                      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                    }
                  }
                  localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
                  localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
                  localMessageForQQWalletMsg.msgtype = 63511;
                  localMessageForQQWalletMsg.mQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
                  localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
                  localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
                  this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
                  if ((QQWalletMsgItemBuilder.a(this.a) == null) || (!QQWalletMsgItemBuilder.a(this.a).c()) || (localMessageForQQWalletMsg.customizeBg == null)) {
                    break label798;
                  }
                }
                for (i = 1;; i = 0)
                {
                  if ((i == 0) && ((localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype == 1) || ((localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype == 2) && (!localMessageForQQWalletMsg.isSend()))))
                  {
                    localObject3 = (TextView)paramView.findViewById(2131303186);
                    ((TextView)localObject3).setVisibility(0);
                    ((TextView)localObject3).setText("已拆开");
                    paramView.findViewById(2131303189).setVisibility(8);
                  }
                  ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId, "", "", "");
                  break;
                  i = 0;
                  break label502;
                }
              }
            }
            else
            {
              localObject3 = localQQWalletTransferMsgElem.actionsPriority.split("\\|");
              int j = 0;
              i = 0;
              while (j < localObject3.length)
              {
                if (!TextUtils.isEmpty(localObject3[j])) {
                  break label850;
                }
                j += 1;
              }
              break;
              try
              {
                k = Integer.valueOf(localObject3[j]).intValue();
                if (k == 1)
                {
                  if (QQWalletMsgItemBuilder.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.linkUrl)) {
                    break;
                  }
                  i = -1;
                }
              }
              catch (Exception localException)
              {
                int k;
                do
                {
                  do
                  {
                    for (;;)
                    {
                      if (QLog.isDevelopLevel()) {
                        localException.printStackTrace();
                      }
                      k = i;
                      if (QLog.isColorLevel())
                      {
                        QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject3[j] + " to Interger,", localException);
                        k = i;
                      }
                    }
                    if (k != 2) {
                      break;
                    }
                  } while (!QQWalletMsgItemBuilder.b(this.a, paramView.getContext(), localQQWalletTransferMsgElem.jumpUrl));
                  return;
                } while ((k != 3) || (!QQWalletMsgItemBuilder.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.nativeAndroid, (String)localObject1, (String)localObject2, localMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)));
                return;
              }
            }
            localObject2 = localObject1;
            localObject1 = null;
            localQQWalletTransferMsgElem = null;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */