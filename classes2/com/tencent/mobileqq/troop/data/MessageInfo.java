package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopCalendarMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopDingdongAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopGamePartyMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHasGiftMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHomeworkPraiseMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopPubAccountMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceivedFlowsersMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReplyMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.TroopHomeworkSpecialMsg;

public class MessageInfo
{
  public static final long a = -1L;
  private static final String b;
  public int a;
  public MessageNavInfo a;
  public String a;
  public MessageNavInfo b;
  public MessageNavInfo c = new MessageNavInfo();
  public MessageNavInfo d = new MessageNavInfo();
  public MessageNavInfo e = new MessageNavInfo();
  public MessageNavInfo f = new MessageNavInfo();
  public MessageNavInfo g = new MessageNavInfo();
  public MessageNavInfo h = new MessageNavInfo();
  public MessageNavInfo i = new MessageNavInfo();
  public MessageNavInfo j = new MessageNavInfo();
  public MessageNavInfo k = new MessageNavInfo();
  public MessageNavInfo l = new MessageNavInfo();
  public MessageNavInfo m = new MessageNavInfo();
  public MessageNavInfo n = new MessageNavInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = MessageInfo.class.getSimpleName();
  }
  
  public MessageInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
    this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
    a();
  }
  
  public MessageInfo(MessageInfo paramMessageInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
    this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
    if (paramMessageInfo != null)
    {
      this.c.a(paramMessageInfo.c);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      this.d.a(paramMessageInfo.d);
      this.e.a(paramMessageInfo.e);
      this.f.a(paramMessageInfo.f);
      this.g.a(paramMessageInfo.g);
      this.h.a(paramMessageInfo.h);
      this.i.a(paramMessageInfo.i);
      this.j.a(paramMessageInfo.j);
      this.k.a(paramMessageInfo.k);
      this.l.a(paramMessageInfo.l);
      this.m.a(paramMessageInfo.m);
      this.n.a(paramMessageInfo.n);
      return;
    }
    a();
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)paramQQAppInterface.getManager(36);
    if (paramBoolean) {
      switch (paramMessageInfo.a(paramQQAppInterface, paramBoolean, paramString))
      {
      case 15: 
      case 17: 
      default: 
        paramQQAppInterface = null;
      case 9: 
      case 6: 
      case 14: 
      case 8: 
      case 16: 
      case 7: 
      case 3: 
      case 4: 
      case 5: 
      case 10: 
      case 13: 
        do
        {
          do
          {
            do
            {
              do
              {
                return paramQQAppInterface;
                if ((paramObject instanceof TroopSpecialAttentionMsg))
                {
                  paramQQAppInterface = (TroopSpecialAttentionMsg)paramObject;
                  paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
                  localTroopInfoManager.a(paramString, 10, paramMessageInfo.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a, "", 0);
                  return paramQQAppInterface;
                }
                paramQQAppInterface = new TroopSpecialAttentionMsg(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
                localTroopInfoManager.a(paramString, 10, paramMessageInfo.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a, "", 0);
                return paramQQAppInterface;
                return new TroopNotificationMsg(BaseApplication.getContext());
                if (!(paramObject instanceof TroopAtMeMsg)) {
                  break;
                }
                paramObject = (TroopAtMeMsg)paramObject;
                paramQQAppInterface = (QQAppInterface)paramObject;
              } while (!((TroopAtMeMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo));
              localTroopInfoManager.a(paramString, 15, paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b, "", 0);
              return paramObject;
              paramQQAppInterface = new TroopAtMeMsg(BaseApplication.getContext());
              paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
              localTroopInfoManager.a(paramString, 15, paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b, "", 0);
              return paramQQAppInterface;
              if (paramMessageRecord == null) {
                return null;
              }
              paramBoolean = NearbyFlowerUtil.a(paramMessageRecord);
              if ((paramMessageRecord.msgtype != 63501) && (paramMessageRecord.msgtype != 63498) && (!paramBoolean)) {
                return null;
              }
              int i1;
              if (paramBoolean)
              {
                i1 = NearbyFlowerUtil.a((MessageForStructing)paramMessageRecord);
                if ((paramObject instanceof TroopReceivedFlowsersMsg))
                {
                  paramQQAppInterface = (TroopReceivedFlowsersMsg)paramObject;
                  paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.e);
                  localTroopInfoManager.a(paramString, 17, paramMessageInfo.e.b, "", i1);
                  return paramQQAppInterface;
                }
                paramQQAppInterface = new TroopReceivedFlowsersMsg(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.e);
                localTroopInfoManager.a(paramString, 17, paramMessageInfo.e.b, "", i1);
                return paramQQAppInterface;
              }
              if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
              {
                paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                i1 = 1;
                i2 = 1;
                if (!(paramObject instanceof TroopReceivedFlowsersMsg)) {
                  break label661;
                }
                paramQQAppInterface = (TroopReceivedFlowsersMsg)paramObject;
                i1 = i2;
                if (paramQQAppInterface.jdField_a_of_type_Boolean)
                {
                  i1 = i2;
                  if (!paramMessageRecord.isToAll()) {
                    i1 = 0;
                  }
                }
                i2 = i1;
                paramObject = paramQQAppInterface;
                if (!paramQQAppInterface.jdField_a_of_type_Boolean)
                {
                  paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.e);
                  localTroopInfoManager.a(paramString, 17, paramMessageInfo.e.b, "", paramMessageRecord.giftCount);
                  paramObject = paramQQAppInterface;
                }
              }
              for (int i2 = i1;; i2 = i1)
              {
                paramQQAppInterface = (QQAppInterface)paramObject;
                if (i2 == 0) {
                  break;
                }
                paramQQAppInterface = (QQAppInterface)paramObject;
                if (TextUtils.isEmpty(paramMessageRecord.remindBrief)) {
                  break;
                }
                paramQQAppInterface = paramMessageRecord.remindBrief.split("#");
                ((TroopReceivedFlowsersMsg)paramObject).jdField_a_of_type_JavaLangString = ("[" + paramQQAppInterface[0] + "]");
                return paramObject;
                ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                return null;
                paramObject = new TroopReceivedFlowsersMsg(BaseApplication.getContext(), paramMessageRecord.isToAll());
                ((TroopReceivedFlowsersMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.e);
                localTroopInfoManager.a(paramString, 17, paramMessageInfo.e.b, "", paramMessageRecord.giftCount);
              }
              if ((paramObject instanceof TroopAtAllMsg))
              {
                paramQQAppInterface = (TroopAtAllMsg)paramObject;
                paramObject = paramQQAppInterface;
                if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.c))
                {
                  localTroopInfoManager.a(paramString, 8, paramMessageInfo.c.b, "", 0);
                  paramObject = paramQQAppInterface;
                }
              }
              for (;;)
              {
                paramQQAppInterface = (QQAppInterface)paramObject;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(MessageInfo.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
                return paramObject;
                paramObject = new TroopAtAllMsg(BaseApplication.getContext());
                ((TroopAtAllMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.c);
                localTroopInfoManager.a(paramString, 8, paramMessageInfo.c.b, "", 0);
              }
              if (!(paramObject instanceof TroopHomeworkSpecialMsg)) {
                break;
              }
              paramObject = (TroopHomeworkSpecialMsg)paramObject;
              paramQQAppInterface = (QQAppInterface)paramObject;
            } while (!((TroopHomeworkSpecialMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.d));
            localTroopInfoManager.a(paramString, 4, paramMessageInfo.d.b, "", 0);
            return paramObject;
            paramQQAppInterface = new TroopHomeworkSpecialMsg(BaseApplication.getContext());
            paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.d);
            localTroopInfoManager.a(paramString, 4, paramMessageInfo.d.b, "", 0);
            return paramQQAppInterface;
            if (paramMessageRecord == null) {
              return null;
            }
            paramBoolean = NearbyFlowerUtil.a(paramMessageRecord);
            if ((paramMessageRecord.msgtype != 63501) && (paramMessageRecord.msgtype != 63498) && (!paramBoolean)) {
              return null;
            }
            if (paramBoolean)
            {
              if ((paramObject instanceof TroopHasGiftMsg))
              {
                paramQQAppInterface = (TroopHasGiftMsg)paramObject;
                paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.f);
                return paramQQAppInterface;
              }
              paramQQAppInterface = new TroopHasGiftMsg(BaseApplication.getContext());
              paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.f);
              return paramQQAppInterface;
            }
            if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
            {
              paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
              if (!(paramObject instanceof TroopHasGiftMsg)) {
                break label1181;
              }
              paramString = (TroopHasGiftMsg)paramObject;
              paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.f);
            }
            for (;;)
            {
              paramQQAppInterface = paramString;
              if (TextUtils.isEmpty(paramMessageRecord.remindBrief)) {
                break;
              }
              paramMessageInfo = paramMessageRecord.remindBrief.split("#");
              paramQQAppInterface = paramString;
              if (paramMessageInfo.length <= 1) {
                break;
              }
              paramString.jdField_a_of_type_JavaLangString = ("[" + paramMessageInfo[1] + "]");
              return paramString;
              ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
              return null;
              paramString = new TroopHasGiftMsg(BaseApplication.getContext());
              paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.f);
            }
            if ((paramObject instanceof TroopPubAccountMsg))
            {
              paramQQAppInterface = (TroopPubAccountMsg)paramObject;
              paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.g);
              return paramQQAppInterface;
            }
            paramQQAppInterface = new TroopPubAccountMsg(BaseApplication.getContext());
            paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.g);
            return paramQQAppInterface;
            if (!(paramObject instanceof TroopDingdongAtMeMsg)) {
              break;
            }
            paramObject = (TroopDingdongAtMeMsg)paramObject;
            paramQQAppInterface = (QQAppInterface)paramObject;
          } while (!((TroopDingdongAtMeMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.h));
          localTroopInfoManager.a(paramString, 11, paramMessageInfo.h.b, "", 0);
          return paramObject;
          paramQQAppInterface = new TroopDingdongAtMeMsg(BaseApplication.getContext());
          paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.h);
          localTroopInfoManager.a(paramString, 11, paramMessageInfo.h.b, "", 0);
          return paramQQAppInterface;
          if (!(paramObject instanceof TroopReplyMsg)) {
            break;
          }
          paramObject = (TroopReplyMsg)paramObject;
          paramQQAppInterface = (QQAppInterface)paramObject;
        } while (!((TroopReplyMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.i));
        localTroopInfoManager.a(paramString, 14, paramMessageInfo.i.b, "", 0);
        return paramObject;
        paramQQAppInterface = new TroopReplyMsg(BaseApplication.getContext());
        paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.i);
        localTroopInfoManager.a(paramString, 14, paramMessageInfo.i.b, "", 0);
        return paramQQAppInterface;
      case 12: 
        label661:
        label1181:
        if ((StructMsgForGeneralShare)StructMsgFactory.a(paramMessageRecord.msgData) == null)
        {
          if (!QLog.isColorLevel()) {
            break label2247;
          }
          QLog.d(jdField_b_of_type_JavaLangString, 2, "updateMsgInfo():calendarMsg getStructMsg is null");
          paramMessageRecord = "";
        }
        break;
      }
    }
    for (;;)
    {
      label1486:
      if ((paramObject instanceof TroopCalendarMsg))
      {
        paramQQAppInterface = (TroopCalendarMsg)paramObject;
        paramObject = paramQQAppInterface;
        if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.j))
        {
          localTroopInfoManager.a(paramString, 13, paramMessageInfo.j.b, "", 0);
          paramObject = paramQQAppInterface;
        }
      }
      for (;;)
      {
        paramQQAppInterface = (QQAppInterface)paramObject;
        if (TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
        ((TroopCalendarMsg)paramObject).jdField_a_of_type_JavaLangString = ("[" + paramMessageRecord + "]");
        return paramObject;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break label1486;
        paramObject = new TroopCalendarMsg(BaseApplication.getContext());
        ((TroopCalendarMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.j);
        localTroopInfoManager.a(paramString, 13, paramMessageInfo.j.b, "", 0);
      }
      paramQQAppInterface = new TroopNotificationMsg(BaseApplication.getContext());
      paramQQAppInterface.c = 1;
      return paramQQAppInterface;
      if ((paramObject instanceof TroopHomeworkPraiseMsg))
      {
        paramObject = (TroopHomeworkPraiseMsg)paramObject;
        paramQQAppInterface = (QQAppInterface)paramObject;
        if (!((TroopHomeworkPraiseMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.m)) {
          break;
        }
        localTroopInfoManager.a(paramString, 3, paramMessageInfo.m.b, "", 0);
        return paramObject;
      }
      paramQQAppInterface = new TroopHomeworkPraiseMsg(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.m);
      localTroopInfoManager.a(paramString, 3, paramMessageInfo.m.b, "", 0);
      return paramQQAppInterface;
      if ((paramObject instanceof TroopGamePartyMsg))
      {
        paramObject = (TroopGamePartyMsg)paramObject;
        paramQQAppInterface = (QQAppInterface)paramObject;
        if (!((TroopGamePartyMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.n)) {
          break;
        }
        localTroopInfoManager.a(paramString, 12, paramMessageInfo.n.b, "", 0);
        return paramObject;
      }
      paramQQAppInterface = new TroopGamePartyMsg(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.n);
      localTroopInfoManager.a(paramString, 12, paramMessageInfo.n.b, "", 0);
      return paramQQAppInterface;
      paramMessageRecord = "0";
      switch (paramMessageInfo.a())
      {
      default: 
        paramObject = null;
        paramQQAppInterface = (QQAppInterface)paramObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_b_of_type_JavaLangString + "_At_Me_DISC", 2, "MessageInfo update:" + paramMessageRecord);
        return paramObject;
      case 7: 
        if ((paramObject instanceof TroopAtAllMsg))
        {
          paramObject = (TroopAtAllMsg)paramObject;
          if (!((TroopAtAllMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.c)) {
            break label2240;
          }
          localTroopInfoManager.a(paramString + "&" + 3000, 8, paramMessageInfo.c.b, "", 0);
          paramQQAppInterface = "AT_ALL_update";
        }
      case 14: 
        for (;;)
        {
          paramMessageRecord = paramQQAppInterface;
          break;
          paramObject = new TroopAtAllMsg(BaseApplication.getContext());
          ((TroopAtAllMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.c);
          localTroopInfoManager.a(paramString + "&" + 3000, 8, paramMessageInfo.c.b, "", 0);
          paramQQAppInterface = "AT_ALL_add";
          continue;
          if ((paramObject instanceof TroopAtMeMsg))
          {
            paramQQAppInterface = (TroopAtMeMsg)paramObject;
            paramObject = paramQQAppInterface;
            if (!paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo)) {
              break;
            }
            localTroopInfoManager.a(paramString + "&" + 3000, 15, paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b, "", 0);
            paramMessageRecord = "AT_ME_update";
            paramObject = paramQQAppInterface;
            break;
          }
          paramObject = new TroopAtMeMsg(BaseApplication.getContext());
          ((TroopAtMeMsg)paramObject).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
          localTroopInfoManager.a(paramString + "&" + 3000, 15, paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b, "", 0);
          paramMessageRecord = "AT_ME_ADD";
          break;
          label2240:
          paramQQAppInterface = "0";
        }
        label2247:
        paramMessageRecord = "";
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return 14;
    }
    if (this.c.a()) {
      return 7;
    }
    return 0;
  }
  
  public int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    int i1 = 0;
    if ((paramQQAppInterface != null) && (paramBoolean))
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).b(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramBoolean = paramQQAppInterface.hasOrgs();; paramBoolean = false)
    {
      if (this.e.a()) {
        if (paramBoolean) {
          i1 = 8;
        }
      }
      do
      {
        return i1;
        return 16;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
          return 14;
        }
        if (this.h.a()) {
          return 10;
        }
        if (this.i.a()) {
          return 13;
        }
        if (this.j.a()) {
          return 12;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
          return 9;
        }
        if (this.c.a()) {
          return 7;
        }
        if (this.g.a()) {
          return 5;
        }
        if (this.d.a()) {
          return 3;
        }
        if (this.f.a()) {
          return 4;
        }
        if (this.k.a()) {
          return 18;
        }
        if (this.l.a()) {
          return 6;
        }
        if (this.m.a()) {
          return 2;
        }
      } while (!this.n.a());
      return 11;
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a;
    }
    if (this.c.a()) {
      return this.c.a;
    }
    return -1L;
  }
  
  public MessageInfo a(MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo != null)
    {
      this.c.a(paramMessageInfo.c);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      this.d.a(paramMessageInfo.d);
      this.e.a(paramMessageInfo.e);
      this.f.a(paramMessageInfo.f);
      this.g.a(paramMessageInfo.g);
      this.h.a(paramMessageInfo.h);
      this.i.a(paramMessageInfo.i);
      this.j.a(paramMessageInfo.j);
      this.k.a(paramMessageInfo.k);
      this.l.a(paramMessageInfo.l);
      this.m.a(paramMessageInfo.m);
      this.n.a(paramMessageInfo.n);
    }
    return this;
  }
  
  public void a()
  {
    this.c.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a();
    this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a();
    this.d.a();
    this.e.a();
    this.f.a();
    this.g.a();
    this.h.a();
    this.i.a();
    this.j.a();
    this.k.a();
    this.l.a();
    this.m.a();
    this.n.a();
  }
  
  public boolean a()
  {
    return (this.c.a()) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) || (this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) || (this.d.a()) || (this.e.a()) || (this.f.a()) || (this.h.a()) || (this.g.a()) || (this.i.a()) || (this.j.a()) || (this.k.a()) || (this.l.a()) || (this.m.a()) || (this.n.a());
  }
  
  public long b()
  {
    if (this.e.a()) {
      return this.e.a;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a;
    }
    if (this.h.a()) {
      return this.h.a;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return this.jdField_b_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a;
    }
    if (this.c.a()) {
      return this.c.a;
    }
    if (this.g.a()) {
      return this.g.a;
    }
    if (this.d.a()) {
      return this.d.a;
    }
    if (this.f.a()) {
      return this.f.a;
    }
    if (this.i.a()) {
      return this.i.a;
    }
    if (this.j.a()) {
      return this.j.a;
    }
    if (this.k.a()) {
      return this.k.a;
    }
    if (this.l.a()) {
      return this.l.a;
    }
    if (this.m.a()) {
      return this.m.a;
    }
    if (this.n.a()) {
      return this.n.a;
    }
    return -1L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\MessageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */