import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class vln
  implements Runnable
{
  public vln(TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((!this.a.b()) || (!this.a.jdField_a_of_type_Boolean)) {
      return;
    }
    this.a.jdField_b_of_type_Boolean = true;
    boolean bool2 = false;
    boolean bool3 = false;
    Object localObject1 = (TroopInfoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      this.a.jdField_e_of_type_Int = ((TroopInfoManager)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject2;
    long l1;
    int i;
    for (;;)
    {
      localObject2 = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject2 != null)
      {
        localObject2 = ((TroopManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
          this.a.jdField_e_of_type_Boolean = true;
        }
      }
      this.a.jdField_a_of_type_JavaUtilList = ((TroopInfoManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_e_of_type_Int);
      if (!this.a.c()) {
        break;
      }
      this.a.jdField_d_of_type_Long = ((TroopInfoManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (this.a.jdField_d_of_type_Long != -1L) {
        Collections.sort(this.a.jdField_a_of_type_JavaUtilList, new vlo(this));
      }
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {
        this.a.jdField_c_of_type_Long = ((Long)this.a.jdField_a_of_type_JavaUtilList.get(0)).longValue();
      }
      if (this.a.jdField_e_of_type_Boolean)
      {
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (localObject1 != null)
        {
          l1 = ((QQMessageFacade.Message)localObject1).shmsgseq;
          long l2 = this.a.jdField_c_of_type_Long;
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", l1 - l2 + "");
        }
      }
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {
        break label634;
      }
      localObject1 = (ChatMessage)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s());
      if (localObject1 == null) {
        break label634;
      }
      i = this.a.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        if (((ChatMessage)localObject1).shmsgseq <= ((Long)this.a.jdField_a_of_type_JavaUtilList.get(i)).longValue()) {
          this.a.jdField_a_of_type_JavaUtilList.remove(i);
        }
        i -= 1;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        this.a.jdField_e_of_type_Int = ((TroopInfoManager)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
      }
    }
    label634:
    MessageRecord localMessageRecord2;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      this.a.jdField_c_of_type_Long = ((TroopInfoManager)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = TroopAioMsgNavigateBar.jdField_a_of_type_Long;
      localMessageRecord2 = (MessageRecord)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s());
      if (localMessageRecord2 == null) {
        break label3008;
      }
      l1 = localMessageRecord2.shmsgseq;
    }
    label1319:
    label1400:
    label1569:
    label1659:
    label2980:
    label2991:
    label2994:
    label3008:
    for (;;)
    {
      Object localObject5 = "";
      MessageRecord localMessageRecord1 = null;
      Object localObject4 = "";
      boolean bool1;
      Object localObject3;
      if (this.a.jdField_e_of_type_Int == 1)
      {
        localObject2 = String.format(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364626), new Object[] { Integer.valueOf(this.a.jdField_d_of_type_Int) });
        localObject1 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
        bool1 = true;
        localObject3 = localObject4;
        bool2 = bool1;
        if (this.a.c())
        {
          bool2 = bool1;
          if (this.a.jdField_a_of_type_JavaUtilList.isEmpty()) {
            bool2 = false;
          }
        }
        this.a.g = bool2;
        this.a.jdField_c_of_type_JavaLangString = ((String)localObject2);
        this.a.jdField_a_of_type_JavaLangObject = localObject1;
        this.a.jdField_d_of_type_JavaLangString = ((String)localObject3);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break;
        }
        this.a.jdField_c_of_type_Long = ((TroopInfoManager)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        break;
      }
      if (this.a.jdField_e_of_type_Int == 15)
      {
        localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
        if ((localObject3 == null) || (((MessageRecord)localObject3).shmsgseq >= l1)) {
          break label2994;
        }
        localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364631);
        localObject1 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
        localObject3 = ((MessageRecord)localObject3).senderuin;
        bool1 = true;
      }
      for (;;)
      {
        break;
        if (this.a.jdField_e_of_type_Int == 8)
        {
          localMessageRecord2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
          localObject1 = localMessageRecord1;
          localObject2 = localObject5;
          localObject3 = localObject4;
          bool1 = bool3;
          if (localMessageRecord2 == null) {
            break;
          }
          localObject1 = localMessageRecord1;
          localObject2 = localObject5;
          localObject3 = localObject4;
          bool1 = bool3;
          if (localMessageRecord2.shmsgseq >= l1) {
            break;
          }
          localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364632);
          localObject1 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
          localObject3 = localMessageRecord2.senderuin;
          bool1 = true;
          break;
        }
        if (this.a.jdField_e_of_type_Int == 10)
        {
          localObject5 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
          localMessageRecord1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
          if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getResources();
            if (this.a.jdField_a_of_type_JavaUtilList.size() > 99)
            {
              localObject1 = "99+";
              localObject1 = ((Resources)localObject2).getString(2131369585, new Object[] { localObject1 });
              if (!this.a.jdField_e_of_type_Boolean) {
                break label2991;
              }
              if (this.a.jdField_a_of_type_JavaUtilList.size() != 1) {
                break label1569;
              }
              ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            }
          }
        }
        for (;;)
        {
          if (MessageForQQWalletMsg.isRedPacketMsg(localMessageRecord1))
          {
            localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131372046);
            ((TroopAioAgent.Message)localObject5).jdField_a_of_type_Boolean = true;
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (localMessageRecord1 != null) {
              localObject3 = localMessageRecord1.senderuin;
            }
            if (QLog.isColorLevel())
            {
              localObject1 = TroopAioMsgNavigateBar.jdField_a_of_type_JavaLangString + ".troop.special_msg.special_attention";
              localObject4 = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
              if (localMessageRecord1 == null) {
                break label1659;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              QLog.d((String)localObject1, 2, bool1);
              bool1 = bool2;
              if (localMessageRecord2 != null)
              {
                bool1 = bool2;
                if (this.a.jdField_c_of_type_Long < localMessageRecord2.shmsgseq) {
                  bool1 = true;
                }
              }
              localObject1 = localObject5;
              break;
              localObject1 = Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size());
              break label1319;
              ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaUtilList.size() + "", "", "");
              break label1400;
              localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131369584);
              break label1400;
            }
            if (this.a.jdField_e_of_type_Int == 4)
            {
              localMessageRecord2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
              localObject1 = localMessageRecord1;
              localObject2 = localObject5;
              localObject3 = localObject4;
              bool1 = bool3;
              if (localMessageRecord2 == null) {
                break;
              }
              localObject1 = localMessageRecord1;
              localObject2 = localObject5;
              localObject3 = localObject4;
              bool1 = bool3;
              if (localMessageRecord2.shmsgseq >= l1) {
                break;
              }
              localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365129);
              localObject1 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
              localObject3 = localMessageRecord2.senderuin;
              bool1 = true;
              break;
            }
            if (this.a.jdField_e_of_type_Int == 17)
            {
              localMessageRecord2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
              localObject1 = localMessageRecord1;
              localObject2 = localObject5;
              localObject3 = localObject4;
              bool1 = bool3;
              if (localMessageRecord2 == null) {
                break;
              }
              localObject1 = localMessageRecord1;
              localObject2 = localObject5;
              localObject3 = localObject4;
              bool1 = bool3;
              if (localMessageRecord2.shmsgseq >= l1) {
                break;
              }
              if ((localMessageRecord2 instanceof MessageForDeliverGiftTips))
              {
                localObject2 = (MessageForDeliverGiftTips)localMessageRecord2;
                localObject1 = localObject5;
                if (!TextUtils.isEmpty(((MessageForDeliverGiftTips)localObject2).remindBrief))
                {
                  localObject1 = ((MessageForDeliverGiftTips)localObject2).remindBrief.split("#");
                  localObject1 = localObject1[0] + "";
                }
                if (!((MessageForDeliverGiftTips)localObject2).isToAll()) {
                  break label2980;
                }
                i = 1;
              }
            }
            for (;;)
            {
              localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
              if (i != 0) {
                ((TroopAioAgent.Message)localObject2).jdField_b_of_type_Boolean = true;
              }
              localObject4 = localMessageRecord2.senderuin;
              bool1 = true;
              ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              localObject3 = localObject4;
              break;
              localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364636);
              i = 0;
              continue;
              if (this.a.jdField_e_of_type_Int == 11)
              {
                localMessageRecord2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject1 = localMessageRecord1;
                localObject2 = localObject5;
                localObject3 = localObject4;
                bool1 = bool3;
                if (localMessageRecord2 == null) {
                  break;
                }
                localObject1 = localMessageRecord1;
                localObject2 = localObject5;
                localObject3 = localObject4;
                bool1 = bool3;
                if (localMessageRecord2.shmsgseq >= l1) {
                  break;
                }
                localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364640);
                localObject1 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = localMessageRecord2.senderuin;
                bool1 = true;
                break;
              }
              if (this.a.jdField_e_of_type_Int == 13)
              {
                localMessageRecord2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject1 = localMessageRecord1;
                localObject2 = localObject5;
                localObject3 = localObject4;
                bool1 = bool3;
                if (localMessageRecord2 == null) {
                  break;
                }
                localObject1 = localMessageRecord1;
                localObject2 = localObject5;
                localObject3 = localObject4;
                bool1 = bool3;
                if (localMessageRecord2.shmsgseq >= l1) {
                  break;
                }
                if ((StructMsgForGeneralShare)StructMsgFactory.a(localMessageRecord2.msgData) == null) {
                  if (QLog.isColorLevel()) {
                    QLog.d(TroopAioMsgNavigateBar.jdField_a_of_type_JavaLangString, 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
                  }
                }
                for (localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365260);; localObject1 = StructMsgForGeneralShare.remindBrief)
                {
                  localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject4 = localMessageRecord2.senderuin;
                  bool1 = true;
                  this.a.jdField_b_of_type_JavaLangString = StructMsgForGeneralShare.eventType;
                  ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, "", "");
                  localObject3 = localObject1;
                  localObject1 = localObject2;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  break;
                }
              }
              if (this.a.jdField_e_of_type_Int == 14)
              {
                localMessageRecord2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject1 = localMessageRecord1;
                localObject2 = localObject5;
                localObject3 = localObject4;
                bool1 = bool3;
                if (localMessageRecord2 == null) {
                  break;
                }
                localObject1 = localMessageRecord1;
                localObject2 = localObject5;
                localObject3 = localObject4;
                bool1 = bool3;
                if (localMessageRecord2.shmsgseq >= l1) {
                  break;
                }
                localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365210);
                localObject1 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, localMessageRecord2.shmsgseq, this.a.jdField_d_of_type_Int);
                localObject3 = localMessageRecord2.senderuin;
                bool1 = true;
                MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
                break;
              }
              if (this.a.jdField_e_of_type_Int == 3)
              {
                localMessageRecord2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject1 = localMessageRecord1;
                localObject2 = localObject5;
                localObject3 = localObject4;
                bool1 = bool3;
                if (localMessageRecord2 == null) {
                  break;
                }
                localObject1 = localMessageRecord1;
                localObject2 = localObject5;
                localObject3 = localObject4;
                bool1 = bool3;
                if (localMessageRecord2.shmsgseq >= l1) {
                  break;
                }
                localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131364638);
                localObject1 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = "";
                bool1 = true;
                break;
              }
              localObject1 = localMessageRecord1;
              localObject2 = localObject5;
              localObject3 = localObject4;
              bool1 = bool3;
              if (this.a.jdField_e_of_type_Int != 12) {
                break;
              }
              localMessageRecord2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
              localObject1 = localMessageRecord1;
              localObject2 = localObject5;
              localObject3 = localObject4;
              bool1 = bool3;
              if (localMessageRecord2 == null) {
                break;
              }
              localObject1 = localMessageRecord1;
              localObject2 = localObject5;
              localObject3 = localObject4;
              bool1 = bool3;
              if (localMessageRecord2.shmsgseq >= l1) {
                break;
              }
              localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131372525);
              localObject1 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
              localObject3 = localMessageRecord2.senderuin;
              bool1 = true;
              break;
              i = 0;
            }
            localObject2 = localObject1;
          }
        }
        localObject1 = null;
        localObject2 = "";
        bool1 = false;
        localObject3 = "";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */