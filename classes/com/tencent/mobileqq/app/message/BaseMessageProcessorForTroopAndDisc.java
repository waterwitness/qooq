package com.tencent.mobileqq.app.message;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.bitapp.BitAppManager;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr.LocationInfo;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemAsyncMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import qla;
import qlb;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;

public class BaseMessageProcessorForTroopAndDisc
  extends BaseMessageProcessor
{
  public static final String a = "Q.msg.BaseMessageProcessorForTroopAndDisc";
  protected Comparator a;
  
  public BaseMessageProcessorForTroopAndDisc(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilComparator = new qlb(this);
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord != null) && (paramMessageRecord.mMsgServiceID == 60)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForStructing)) && (!TextUtils.equals(paramMessageRecord.selfuin, paramMessageRecord.senderuin)))
    {
      Object localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((61 == ((AbsStructMsg)localObject).mMsgServiceID) && ((localObject instanceof AbsShareMsg)))
      {
        localObject = ((AbsShareMsg)localObject).getStructMsgItemLists();
        if ((localObject != null) && (3 == ((List)localObject).size()))
        {
          localObject = (AbsStructMsgElement)((List)localObject).get(2);
          if ((localObject instanceof StructMsgItemLayout6))
          {
            localObject = (StructMsgItemLayout6)localObject;
            if ((((StructMsgItemLayout6)localObject).a != null) && (1 == ((StructMsgItemLayout6)localObject).a.size()))
            {
              localObject = (AbsStructMsgElement)((StructMsgItemLayout6)localObject).a.get(0);
              if (((localObject instanceof StructMsgItemAsyncMsg)) && (((StructMsgItemAsyncMsg)localObject).r.contains(paramMessageRecord.selfuin))) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForArkApp)) && ("com.tencent.qqopen.teamup".equals(((MessageForArkApp)paramMessageRecord).ark_app_message.appName));
  }
  
  protected TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    long l6;
    Object localObject5;
    long l7;
    long l2;
    long l4;
    long l8;
    Object localObject1;
    int m;
    int k;
    int j;
    long l1;
    label233:
    label284:
    Object localObject4;
    byte b1;
    MessageRecord localMessageRecord;
    byte b2;
    int i;
    label860:
    long l5;
    int n;
    for (;;)
    {
      MessageInfo localMessageInfo;
      try
      {
        l6 = System.currentTimeMillis();
        if ((paramPBDecodeContext == null) || (paramMsg == null) || (paramArrayList == null)) {
          break label5504;
        }
        localObject5 = (msg_comm.MsgHead)paramMsg.msg_head.get();
        l7 = ((msg_comm.MsgHead)localObject5).from_uin.get();
        ((msg_comm.MsgHead)localObject5).to_uin.get();
        l2 = ((msg_comm.MsgHead)localObject5).msg_seq.get();
        l4 = ((msg_comm.MsgHead)localObject5).msg_time.get();
        l8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (paramPBDecodeContext.d == 1026)
        {
          l2 = Utils.a(((msg_comm.MsgHead)localObject5).msg_seq.get());
          l4 = Utils.a(((msg_comm.MsgHead)localObject5).msg_time.get());
        }
        if (!paramMsg.content_head.has()) {
          break label5492;
        }
        localObject1 = (msg_comm.ContentHead)paramMsg.content_head.get();
        m = ((msg_comm.ContentHead)localObject1).div_seq.get();
        k = ((msg_comm.ContentHead)localObject1).pkg_num.get();
        j = ((msg_comm.ContentHead)localObject1).pkg_index.get();
        localObject1 = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(l7), String.valueOf(l7));
        if (((Long)((Pair)localObject1).first).longValue() != 4294967295L)
        {
          l1 = ((Long)((Pair)localObject1).first).longValue();
          break label5506;
          localObject2 = new ArrayList();
          localMessageInfo = new MessageInfo();
          if (paramMsg.appshare_info.has())
          {
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, paramMsg, paramPBDecodeContext.jdField_e_of_type_Long, l4, false);
            localObject1 = null;
            l1 = 0L;
            if ((((List)localObject2).size() == 0) && (k > 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
              }
              localObject4 = (MessageForText)MessageRecordFactory.a(64536);
              ((MessageForText)localObject4).msgtype = 64536;
              ((MessageForText)localObject4).msg = "";
              ((List)localObject2).add(localObject4);
            }
            b1 = 0;
            Iterator localIterator = ((List)localObject2).iterator();
            if (!localIterator.hasNext()) {
              break label3426;
            }
            localMessageRecord = (MessageRecord)localIterator.next();
            localMessageRecord.time = l4;
            localMessageRecord.msgseq = l4;
            localMessageRecord.shmsgseq = l2;
            localMessageRecord.msgUid = l1;
            localMessageRecord.selfuin = str;
            localMessageRecord.istroop = paramPBDecodeContext.d;
            localMessageRecord.senderuin = String.valueOf(l7);
            localMessageRecord.frienduin = String.valueOf(paramPBDecodeContext.jdField_e_of_type_Long);
            localMessageRecord.longMsgId = m;
            localMessageRecord.longMsgCount = k;
            localMessageRecord.longMsgIndex = j;
            if (((localMessageRecord instanceof MessageForFoldMsg)) && (QLog.isColorLevel())) {
              QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, frienduin: %s, senduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { localMessageRecord.frienduin, localMessageRecord.senderuin, Long.valueOf(localMessageRecord.msgUid), Long.valueOf(localMessageRecord.shmsgseq), localMessageRecord.getLogColorContent() }));
            }
            if (paramPBDecodeContext.jdField_e_of_type_Int == 127)
            {
              localMessageRecord.msg = "PTT_URL";
              localMessageRecord.msgtype = 63530;
              localMessageRecord.isread = true;
            }
            if (localMessageRecord.msgtype == 64501) {
              ((ChatMessage)localMessageRecord).parse();
            }
            b2 = b1;
            if (((msg_comm.MsgHead)localObject5).msg_flag.has())
            {
              if ((((msg_comm.MsgHead)localObject5).msg_flag.get() & 1L) == 1L)
              {
                b2 = 1;
                localMessageInfo.b.a(l2, localMessageRecord.uniseq);
                b1 = b2;
                if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "receive the TroopMsg from TroopSpecialAttention!");
                  b1 = b2;
                }
              }
              b2 = b1;
              if (a(localMessageRecord))
              {
                localMessageInfo.d.a(l2, localMessageRecord.uniseq);
                b2 = b1;
              }
            }
            if (b(localMessageRecord)) {
              localMessageInfo.h.a(l2, localMessageRecord.uniseq);
            }
            if (c(localMessageRecord)) {
              localMessageInfo.n.a(l2, localMessageRecord.uniseq);
            }
            if (localMessageRecord.msgtype == 64487)
            {
              localObject2 = (MessageForReplyText)localMessageRecord;
              if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(((MessageForReplyText)localObject2).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
                localMessageInfo.i.a(l2, localMessageRecord.uniseq);
              }
            }
            if (localMessageRecord.msgtype == 64501)
            {
              localObject2 = (MessageForMixedMsg)localMessageRecord;
              i = 0;
              if (i < ((MessageForMixedMsg)localObject2).msgElemList.size())
              {
                localObject4 = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(i);
                if (!(localObject4 instanceof MessageForReplyText)) {
                  break label5524;
                }
                localObject2 = (MessageForReplyText)localObject4;
                if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(((MessageForReplyText)localObject2).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
                  localMessageInfo.i.a(l2, localMessageRecord.uniseq);
                }
              }
            }
            if (localMessageRecord.msgtype == 63492)
            {
              localObject2 = (MessageForTroopTopic)localMessageRecord;
              ((TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97)).a(TroopTopicDetailInfo.copyFrom((MessageForTroopTopic)localObject2));
            }
            if ((localMessageRecord.msgtype == 63501) || (localMessageRecord.msgtype == 63498))
            {
              localObject2 = (MessageForDeliverGiftTips)localMessageRecord;
              localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              if (!TextUtils.isEmpty((CharSequence)localObject4))
              {
                if ((!((String)localObject4).equals(((MessageForDeliverGiftTips)localObject2).receiverUin + "")) && (!((MessageForDeliverGiftTips)localObject2).isToAll())) {
                  continue;
                }
                localMessageInfo.e.a(l2, localMessageRecord.uniseq);
              }
              localObject4 = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
              if (localObject4 != null) {
                ((TroopGiftManager)localObject4).a((MessageForDeliverGiftTips)localObject2);
              }
            }
            if (NearbyFlowerUtil.a(localMessageRecord))
            {
              localObject2 = (NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(123);
              if (localObject2 != null)
              {
                localObject4 = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localMessageRecord);
                ((NearbyFlowerManager)localObject2).a((NearbyFlowerMessage)localObject4, false);
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
                {
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(((NearbyFlowerMessage)localObject4).rUin)) {
                    break label2692;
                  }
                  localMessageInfo.e.a(l2, localMessageRecord.uniseq);
                }
              }
            }
            if ((localMessageRecord instanceof MessageForStructing))
            {
              localObject2 = StructMsgFactory.a(localMessageRecord.msgData);
              if ((localObject2 instanceof StructMsgForGeneralShare))
              {
                localObject2 = (StructMsgForGeneralShare)localObject2;
                if ((localObject2 != null) && (((StructMsgForGeneralShare)localObject2).mMsgServiceID == 75))
                {
                  localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                  l5 = localMessageRecord.uniseq;
                  localObject2 = localMessageRecord.frienduin;
                  localObject6 = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  localObject4 = ((BaseMessageManager.AddMessageContext)localObject6).jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
                  localObject6 = ((BaseMessageManager.AddMessageContext)localObject6).jdField_a_of_type_JavaUtilMap;
                  localObject4 = ((RecentUserProxy)localObject4).a((String)localObject2, 1);
                  TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.frienduin, StructMsgForGeneralShare.eventId, localMessageRecord.shmsgseq, new qla(this, false, localMessageInfo, l2, l5, (RecentUser)localObject4, (String)localObject2, localMessageRecord, (Map)localObject6));
                }
              }
            }
            if (TroopBindPublicAccountMgr.a(localMessageRecord)) {
              localMessageInfo.g.a(l2, localMessageRecord.uniseq);
            }
            if (localMessageRecord.msgtype == 63497)
            {
              localObject4 = (MessageForApollo)localMessageRecord;
              localObject6 = new ArrayList(2);
              localObject7 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
              localObject2 = null;
              if (QLog.isColorLevel()) {
                localObject2 = new StringBuilder("decode apollo troop msg: ").append(", id: ").append(((MessageForApollo)localObject4).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject4).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject4).isDoubleAction()).append(", time: ").append(localMessageRecord.time).append("\nsender: ").append(localMessageRecord.senderuin);
              }
              ApolloBaseInfo localApolloBaseInfo;
              if (!localMessageRecord.isSend())
              {
                localApolloBaseInfo = ((ApolloManager)localObject7).b(((MessageForApollo)localObject4).senderuin);
                if (QLog.isColorLevel()) {
                  ((StringBuilder)localObject2).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime);
                }
                if ((localMessageRecord.time > localApolloBaseInfo.apolloUpdateTime) && ((localApolloBaseInfo.apolloServerTS < ((MessageForApollo)localObject4).mApolloMessage.sender_ts) || (localApolloBaseInfo.apolloStatus != ((MessageForApollo)localObject4).mApolloMessage.sender_status) || (localApolloBaseInfo.apolloVipFlag != (((MessageForApollo)localObject4).mApolloMessage.flag >> 30 & 0x1))))
                {
                  localApolloBaseInfo.apolloStatus = ((MessageForApollo)localObject4).mApolloMessage.sender_status;
                  localApolloBaseInfo.apolloServerTS = ((MessageForApollo)localObject4).mApolloMessage.sender_ts;
                  localApolloBaseInfo.apolloVipFlag = (((MessageForApollo)localObject4).mApolloMessage.flag >> 30 & 0x1);
                  localApolloBaseInfo.apolloUpdateTime = localMessageRecord.time;
                  ((ArrayList)localObject6).add(localApolloBaseInfo);
                  if (QLog.isColorLevel()) {
                    ((StringBuilder)localObject2).append("\n save apollo info: ").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime);
                  }
                }
              }
              if ((((MessageForApollo)localObject4).isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), ((MessageForApollo)localObject4).mApolloMessage.peer_uin + "")))
              {
                localApolloBaseInfo = ((ApolloManager)localObject7).b(((MessageForApollo)localObject4).mApolloMessage.peer_uin + "");
                if (QLog.isColorLevel()) {
                  ((StringBuilder)localObject2).append("\n peer: ").append(localApolloBaseInfo.uin).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime);
                }
                if ((localMessageRecord.time > localApolloBaseInfo.apolloUpdateTime) && ((localApolloBaseInfo.apolloServerTS < ((MessageForApollo)localObject4).mApolloMessage.peer_ts) || (localApolloBaseInfo.apolloStatus != ((MessageForApollo)localObject4).mApolloMessage.peer_status) || (localApolloBaseInfo.apolloVipFlag != (((MessageForApollo)localObject4).mApolloMessage.flag >> 31 & 0x1))))
                {
                  localApolloBaseInfo.apolloStatus = ((MessageForApollo)localObject4).mApolloMessage.peer_status;
                  localApolloBaseInfo.apolloServerTS = ((MessageForApollo)localObject4).mApolloMessage.peer_ts;
                  localApolloBaseInfo.apolloVipFlag = (((MessageForApollo)localObject4).mApolloMessage.flag >> 31 & 0x1);
                  localApolloBaseInfo.apolloUpdateTime = localMessageRecord.time;
                  ((ArrayList)localObject6).add(localApolloBaseInfo);
                  if (QLog.isColorLevel()) {
                    ((StringBuilder)localObject2).append("\n save apollo info ").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime);
                  }
                }
              }
              if (((ArrayList)localObject6).size() > 0) {
                ((ApolloManager)localObject7).c((List)localObject6);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, ((StringBuilder)localObject2).toString());
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                n = ((ApolloManager)localObject7).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                if (localMessageRecord.istroop != 1) {
                  break label5533;
                }
                i = 1;
                label2216:
                VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "rev_action", i, 0, new String[] { String.valueOf(((MessageForApollo)localObject4).mApolloMessage.id), Integer.toString(n), Integer.toString(ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) });
              }
            }
            if (paramMessageInfo != null)
            {
              if (localMessageInfo.c.a != -1L) {
                localMessageInfo.c.b = localMessageRecord.uniseq;
              }
              if (localMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a != -1L) {
                localMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b = localMessageRecord.uniseq;
              }
              if ((l2 > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramPBDecodeContext.jdField_e_of_type_Long), paramPBDecodeContext.d)) && (localMessageInfo.a()))
              {
                paramMessageInfo.a(localMessageInfo);
                localMessageRecord.mMessageInfo = localMessageInfo;
              }
            }
            if (((paramPBDecodeContext.d != 1) && (paramPBDecodeContext.d != 1026) && (paramPBDecodeContext.d != 3000)) || (localObject1 == null) || (TextUtils.equals(localMessageRecord.selfuin, localMessageRecord.senderuin))) {
              break label2930;
            }
            i = 0;
            localObject2 = ((List)localObject1).iterator();
            label2444:
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (!((im_msg_body.Elem)((Iterator)localObject2).next()).anon_group_msg.has()) {
              break label5467;
            }
            i = 1;
            break label5521;
          }
        }
        else
        {
          l1 = ((Long)((Pair)localObject1).second).longValue();
          break label5506;
        }
        if (!paramMsg.msg_body.has()) {
          break label5476;
        }
        localObject1 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
        if (!((im_msg_body.MsgBody)localObject1).rich_text.has()) {
          break label5476;
        }
        localObject4 = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject1).rich_text.get();
        if (!((im_msg_body.RichText)localObject4).attr.has()) {
          break label5470;
        }
        l1 = MessageUtils.a(((im_msg_body.Attr)((im_msg_body.RichText)localObject4).attr.get()).random.get());
        label2574:
        localObject1 = ((im_msg_body.RichText)localObject4).elems.get();
        if (((im_msg_body.RichText)localObject4).ptt.has())
        {
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, (List)localObject2);
          continue;
        }
        localMessageInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramPBDecodeContext.jdField_e_of_type_Long);
        localMessageInfo.jdField_a_of_type_Int = paramPBDecodeContext.d;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, paramMsg, false, false, localMessageInfo);
        continue;
        if (((MessageForDeliverGiftTips)localObject2).animationPackageId <= 0) {
          continue;
        }
        localMessageInfo.f.a(l2, localMessageRecord.uniseq);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(((NearbyFlowerMessage)localObject4).sUin)) {
          continue;
        }
      }
      catch (Throwable paramMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis failure : ", paramMsg);
        }
        return null;
      }
      label2692:
      localMessageInfo.f.a(l2, localMessageRecord.uniseq);
    }
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if ((i == 0) && (((im_msg_body.Elem)localObject4).extra_info.has()))
      {
        localObject4 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject4).extra_info.get();
        if (((im_msg_body.ExtraInfo)localObject4).uint32_msg_tail_id.has())
        {
          n = ((im_msg_body.ExtraInfo)localObject4).uint32_msg_tail_id.get();
          if (n > 0)
          {
            localObject4 = MessageRecordFactory.a(64534);
            if (localObject4 != null)
            {
              localObject6 = Integer.toString(n);
              localObject7 = new SafeMsg.SafeMoreInfo();
              ((SafeMsg.SafeMoreInfo)localObject7).strMsgTxt.set((String)localObject6);
              ((MessageRecord)localObject4).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, (String)localObject6, localMessageRecord.time, 64534, localMessageRecord.istroop, localMessageRecord.msgseq);
              ((MessageRecord)localObject4).isread = true;
              ((MessageRecord)localObject4).shmsgseq = localMessageRecord.shmsgseq;
              ((MessageRecord)localObject4).msgData = ((SafeMsg.SafeMoreInfo)localObject7).toByteArray();
              paramArrayList.add(localObject4);
            }
          }
        }
      }
    }
    label2930:
    if (((paramPBDecodeContext.d == 1) || (paramPBDecodeContext.d == 1026)) && (localObject1 != null)) {
      localObject4 = ((List)localObject1).iterator();
    }
    label3211:
    do
    {
      int i1;
      if (((Iterator)localObject4).hasNext())
      {
        localObject2 = (im_msg_body.Elem)((Iterator)localObject4).next();
        if (!((im_msg_body.Elem)localObject2).anon_group_msg.has()) {
          break label3211;
        }
        localObject2 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject2).anon_group_msg.get();
        i = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_flags.get();
        localObject7 = ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_id.get().toByteArray();
        localObject6 = ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.get().toByteArray();
        n = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_head_portrait.get();
        i1 = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_expire_time.get();
        localObject4 = "";
        localObject2 = localObject4;
        if (localObject7 == null) {}
      }
      try
      {
        localObject2 = new String((byte[])localObject7, "ISO-8859-1");
        if (localObject6 == null)
        {
          localObject4 = "";
          localMessageRecord.saveExtInfoToExtStr("anonymous", AnonymousChatHelper.a(i, (String)localObject2, (String)localObject4, n, i1));
          localMessageRecord.extLong |= 0x3;
          if (QLog.isColorLevel()) {
            QLog.d("anonymous_decode", 2, "anonymous_flags = " + i);
          }
          paramArrayList.add(localMessageRecord);
          b1 = b2;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          localObject3 = localObject4;
          continue;
          localObject4 = new String((byte[])localObject6);
        }
      }
      if (((im_msg_body.Elem)localObject3).extra_info.has())
      {
        localObject6 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject3).extra_info.get();
        localObject7 = ((im_msg_body.ExtraInfo)localObject6).bytes_sender_title.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject7)) {
          localMessageRecord.saveExtInfoToExtStr("uniqueTitle", (String)localObject7);
        }
        i = ((im_msg_body.ExtraInfo)localObject6).uint32_flags.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc.troop.special_msg", 2, "dwFlags:" + i);
        }
      }
    } while (!((im_msg_body.Elem)localObject3).group_business_msg.has());
    Object localObject6 = TroopBusinessUtil.TroopBusinessMessage.a(((im_msg_body.Elem)localObject3).group_business_msg);
    TroopBusinessUtil.a(localMessageRecord, (TroopBusinessUtil.TroopBusinessMessage)localObject6);
    Object localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localMessageRecord.frienduin == null) {}
    for (Object localObject3 = "";; localObject3 = localMessageRecord.frienduin)
    {
      ReportController.b((QQAppInterface)localObject7, "P_CliOper", "Grp_AIO", "", "five_m", "revice_msg", 0, 0, (String)localObject3, localMessageRecord.msgtype + "", ((TroopBusinessUtil.TroopBusinessMessage)localObject6).c, "");
      break;
    }
    label3426:
    paramMessageInfo = paramArrayList.iterator();
    label3470:
    double d1;
    label3553:
    boolean bool2;
    boolean bool1;
    label3664:
    boolean bool3;
    boolean bool4;
    label3724:
    label3751:
    label3806:
    label4092:
    label4251:
    double d2;
    for (;;)
    {
      if (paramMessageInfo.hasNext())
      {
        localObject3 = (MessageRecord)paramMessageInfo.next();
        if ((localObject3 != null) && ((localObject3 instanceof MessageForBitApp)))
        {
          i = 1;
          if (i != 0) {
            ((BitAppManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(143)).a(paramArrayList);
          }
          j = 0;
          k = 0;
          i = -100;
          if ((paramPBDecodeContext.d == 1) || (paramPBDecodeContext.d == 1026))
          {
            d1 = -100.0D;
            localObject3 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject5).group_info.get();
            if (localObject3 != null)
            {
              l1 = ((msg_comm.GroupInfo)localObject3).group_code.get();
              if (localObject1 != null)
              {
                localObject1 = ((List)localObject1).iterator();
                bool2 = false;
                bool1 = false;
                d1 = -100.0D;
                j = k;
                for (;;)
                {
                  if (((Iterator)localObject1).hasNext())
                  {
                    paramMessageInfo = (im_msg_body.Elem)((Iterator)localObject1).next();
                    if (paramMessageInfo.general_flags.has())
                    {
                      if (!paramMessageInfo.general_flags.uint32_group_type.has()) {}
                    }
                    else {
                      switch (paramMessageInfo.general_flags.uint32_group_type.get())
                      {
                      case 1: 
                        bool2 = bool3;
                        bool1 = bool4;
                        if (QLog.isColorLevel())
                        {
                          QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive general_flags.uint32_group_type, isPubGroupVisitor = " + bool3 + ", isHotChatMsg = " + bool4);
                          bool1 = bool4;
                          bool2 = bool3;
                        }
                        if (paramMessageInfo.general_flags.uint32_glamour_level.has())
                        {
                          i = paramMessageInfo.general_flags.uint32_glamour_level.get();
                          if ((paramPBDecodeContext.d == 1) && (paramMessageInfo.general_flags.uint64_group_rank_seq.has()))
                          {
                            localObject4 = String.valueOf(l1);
                            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c())) {
                              break label5604;
                            }
                            bool3 = true;
                            if (bool3)
                            {
                              localObject5 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a((String)localObject4);
                              if (localObject5 == null) {
                                break label5550;
                              }
                              l4 = paramMessageInfo.general_flags.uint64_group_rank_seq.get();
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + (String)localObject4 + ", serverRankSeq=" + l4 + ", localRankSeq=" + ((TroopInfo)localObject5).dwGroupLevelSeq + ", isSyncMsgFinish=" + bool3);
                              }
                              if (l4 <= ((TroopInfo)localObject5).dwGroupLevelSeq) {
                                break label5550;
                              }
                              ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).c((String)localObject4, false);
                              break label5550;
                              if (!paramMessageInfo.general_flags.uint32_to_uin_flag.has()) {
                                break label5539;
                              }
                              if (paramMessageInfo.general_flags.uint32_to_uin_flag.get() != 2) {
                                break label5588;
                              }
                              bool2 = true;
                              break label5577;
                            }
                            if (!QLog.isColorLevel()) {
                              break label5550;
                            }
                            QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + (String)localObject4 + ", isSyncMsgFinish=" + bool3);
                            break label5550;
                            if (paramMessageInfo.pub_group.has())
                            {
                              if (!QLog.isColorLevel()) {
                                break label5398;
                              }
                              if (((im_msg_body.PubGroup)paramMessageInfo.pub_group.get()).bytes_nickname.has())
                              {
                                paramMessageInfo = ((im_msg_body.PubGroup)paramMessageInfo.pub_group.get()).bytes_nickname.get().toStringUtf8();
                                QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive  pub_group,bytes_nickname = " + paramMessageInfo);
                                bool3 = bool1;
                                j = 1;
                                bool1 = bool2;
                                bool2 = bool3;
                                break label5562;
                              }
                            }
                            else if ((paramMessageInfo.elem_flags2.has()) && (((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_longtitude.has()) && (((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_latitude.has()))
                            {
                              if (l8 == l7) {
                                continue;
                              }
                              k = ((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_longtitude.get();
                              m = ((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_latitude.get();
                              if ((k == 1) && (m == 1))
                              {
                                d1 = -1001.0D;
                                d2 = d1;
                                if (k != 0)
                                {
                                  d2 = d1;
                                  if (m != 0)
                                  {
                                    d2 = d1;
                                    if (k != 1)
                                    {
                                      d2 = d1;
                                      if (m != 1) {
                                        d2 = TroopMemberLbsHelper.a(m, k, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                                      }
                                    }
                                  }
                                }
                                paramMessageInfo = TroopMemberLbsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                                if ((paramMessageInfo.b == 0L) || (paramMessageInfo.a == 0L)) {
                                  TroopMemberLbsHelper.a(String.valueOf(l1), String.valueOf(l7), m, k, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                                }
                                l5 = 0L;
                                l4 = 0L;
                                if (paramMessageInfo != null)
                                {
                                  l5 = paramMessageInfo.a;
                                  l4 = paramMessageInfo.b;
                                }
                                if (!QLog.isColorLevel()) {
                                  break label5610;
                                }
                                QLog.d("Q.troopMemberDistance", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l1 + ", memberUin=" + l7 + ", memberLoction=[" + k + "," + m + "], selfLocation=[" + l5 + "," + l4 + "]" + ", dis=" + d2);
                                break label5610;
                                label4490:
                                localObject1 = String.valueOf(l1);
                                localObject4 = String.valueOf(l7);
                                paramPBDecodeContext = ((msg_comm.GroupInfo)localObject3).group_card.get().toByteArray();
                                k = ((msg_comm.GroupInfo)localObject3).group_level.get();
                                try
                                {
                                  paramPBDecodeContext = new String(paramPBDecodeContext, "utf-8");
                                  m = ((msg_comm.GroupInfo)localObject3).group_card_type.get();
                                  if (bool3) {
                                    ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(l1);
                                  }
                                  if (!bool1) {
                                    break label5640;
                                  }
                                  paramMessageInfo = paramArrayList.iterator();
                                  while (paramMessageInfo.hasNext()) {
                                    ((MessageRecord)paramMessageInfo.next()).isOpenTroopMessage = true;
                                  }
                                }
                                catch (UnsupportedEncodingException paramPBDecodeContext)
                                {
                                  for (;;)
                                  {
                                    paramPBDecodeContext.printStackTrace();
                                    paramPBDecodeContext = null;
                                  }
                                  paramMessageInfo = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                                  if (paramMessageInfo == null) {
                                    break label5640;
                                  }
                                }
                                if (paramMessageInfo.e((String)localObject1)) {
                                  break label5640;
                                }
                                paramMessageInfo = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                                if (paramMessageInfo == null) {
                                  break label5640;
                                }
                                paramMessageInfo.f((String)localObject1, false);
                                break label5640;
                                label4677:
                                if (i != -100)
                                {
                                  paramMessageInfo = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                                  if (paramMessageInfo != null) {
                                    paramMessageInfo.a((String)localObject1, (String)localObject4, i);
                                  }
                                }
                                if (paramBoolean) {
                                  paramMessageInfo = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                                }
                                switch (m)
                                {
                                case 1: 
                                  paramMessageInfo.a((String)localObject1, (String)localObject4, paramPBDecodeContext, k, null, null, 0, 1, 100, l2, b1, 0L, d1);
                                  break label5656;
                                  if ((localObject4 == null) || (((String)localObject4).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
                                    break label5686;
                                  }
                                  paramMessageInfo = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
                                  if (paramMessageInfo.b((String)localObject1)) {
                                    break label5686;
                                  }
                                  if (paramMessageInfo.c((String)localObject1))
                                  {
                                    j = paramArrayList.size();
                                    i = 0;
                                    k = j - 1;
                                    if (k >= 0)
                                    {
                                      localObject3 = (MessageRecord)paramArrayList.get(k);
                                      j = i;
                                      if (!TroopBindPublicAccountMgr.a((MessageRecord)localObject3)) {
                                        break label5679;
                                      }
                                      if ((TextUtils.isEmpty(((MessageRecord)localObject3).msg)) && (((MessageRecord)localObject3).msgData == null))
                                      {
                                        break label5661;
                                        paramMessageInfo.a((String)localObject1, (String)localObject4, paramPBDecodeContext, k, null, null, 0, 1, 100, l2, b1, 0L, d1);
                                      }
                                    }
                                  }
                                  break;
                                case 2: 
                                  label4760:
                                  label4789:
                                  paramMessageInfo.a((String)localObject1, (String)localObject4, "", k, paramPBDecodeContext, null, 0, 1, 100, l2, b1, 0L, d1);
                                  break label5656;
                                  paramMessageInfo = new TroopMemberInfo();
                                  paramMessageInfo.troopuin = ((String)localObject1);
                                  paramMessageInfo.memberuin = ((String)localObject4);
                                  switch (m)
                                  {
                                  case 1: 
                                    paramMessageInfo.troopnick = paramPBDecodeContext;
                                  case 2: 
                                    for (;;)
                                    {
                                      label5016:
                                      paramMessageInfo.level = k;
                                      paramMessageInfo.sex = 1;
                                      paramMessageInfo.age = 0;
                                      paramMessageInfo.distance = 100;
                                      paramMessageInfo.msgseq = l2;
                                      if (b1 != 1) {
                                        break label5673;
                                      }
                                      paramBoolean = true;
                                      label5064:
                                      paramMessageInfo.isTroopFollowed = paramBoolean;
                                      paramMessageInfo.distanceToSelf = d1;
                                      paramMessageInfo.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
                                      paramPBDecodeContext = paramMessageInfo;
                                      break;
                                      paramMessageInfo.troopnick = paramPBDecodeContext;
                                      continue;
                                      paramMessageInfo.troopnick = "";
                                      paramMessageInfo.friendnick = paramPBDecodeContext;
                                    }
                                    j = i;
                                    if (i == 0)
                                    {
                                      paramMessageInfo.a((String)localObject1, ((MessageRecord)localObject3).uniseq);
                                      j = 1;
                                    }
                                    if (QLog.isColorLevel()) {
                                      QLog.d("TroopBindPublicAccountMgr.redDot", 2, "decodePBAccountMSg:" + (String)localObject1 + "," + ((MessageRecord)localObject3).uniseq + "," + ((MessageRecord)localObject3).shmsgseq);
                                    }
                                    paramMessageInfo.c((String)localObject1);
                                    break label5679;
                                    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject1) != 3) {
                                      break label5686;
                                    }
                                    if (QLog.isColorLevel()) {
                                      QLog.d(".troop.closeRcvMsgTmp", 2, "Shield troop recv msg:" + (String)localObject1);
                                    }
                                    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, 0);
                                    break label5686;
                                  }
                                  break;
                                }
                              }
                            }
                          }
                        }
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label5290:
    label5398:
    label5467:
    label5470:
    label5476:
    label5492:
    label5504:
    label5506:
    label5521:
    label5524:
    label5533:
    label5539:
    label5550:
    label5562:
    label5577:
    label5588:
    label5604:
    label5610:
    label5640:
    label5656:
    label5661:
    label5673:
    label5679:
    label5686:
    for (;;)
    {
      i = MessageProtoCodec.a(paramMsg);
      paramMsg = paramArrayList.iterator();
      while (paramMsg.hasNext())
      {
        paramArrayList = (MessageRecord)paramMsg.next();
        paramArrayList.vipBubbleDiyTextId = i;
        Object localObject8;
        paramArrayList.vipBubbleID = SVIPHandler.a((int)localObject8, i);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramArrayList.time);
      }
      MsgAutoMonitorUtil.a().g(System.currentTimeMillis() - l6);
      return paramPBDecodeContext;
      do
      {
        paramPBDecodeContext = null;
        break label4789;
        break label4251;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        break label5562;
        paramMessageInfo = null;
        break label4092;
        bool3 = bool1;
        j = 1;
        bool1 = bool2;
        bool2 = bool3;
        break label5562;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        break label5562;
        break label3751;
        break label3724;
        bool1 = false;
        bool3 = false;
        i = -100;
        break label4490;
        l1 = 0L;
        break label3553;
        paramPBDecodeContext = null;
        break label5290;
        i = 0;
        break label3470;
        break label5521;
        l1 = 0L;
        break label2574;
        localObject1 = null;
        l1 = 0L;
        break label284;
        do
        {
          l3 = l1;
          break label233;
          j = 0;
          k = 0;
          m = 0;
          break;
          return null;
        } while (l1 != -1L);
        long l3 = 0L;
        break label233;
        break label2444;
        i += 1;
        break label860;
        i = 2;
        break label2216;
        bool3 = bool2;
        bool4 = bool1;
        break label3664;
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
        for (;;)
        {
          bool3 = bool2;
          bool2 = bool1;
          bool1 = bool3;
          break;
          for (;;)
          {
            bool3 = bool2;
            bool4 = bool1;
            break;
            bool2 = false;
          }
          bool4 = true;
          bool3 = bool2;
          break label3664;
          bool3 = false;
          break label3806;
          d1 = d2;
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
        }
        bool3 = bool1;
        bool1 = bool2;
        break label4490;
        if (j == 0) {
          break label4677;
        }
      } while (!bool3);
      break label4677;
      break label4760;
      paramPBDecodeContext = null;
      break label4789;
      for (;;)
      {
        k -= 1;
        break;
        break label5016;
        paramBoolean = false;
        break label5064;
        i = j;
      }
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_seq_" + l;
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  protected void a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "handle push . notifySendMessageSuccessful" + paramMessageRecord.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      a(6003, true, paramMessageRecord.frienduin);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord.msgseq);
      if (MsgProxyUtils.o(paramMessageRecord.msgtype))
      {
        paramMessageRecord = new MessageObserver.StatictisInfo();
        paramMessageRecord.c = 1000;
        paramMessageRecord.d = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(5006, true, new Object[] { paramMessageRecord });
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\BaseMessageProcessorForTroopAndDisc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */