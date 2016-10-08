package com.tencent.mobileqq.app.message;

import android.content.ContentValues;
import android.util.Pair;
import com.tencent.bitapp.BitAppManager;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MutilTransHead;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgTransmit;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class MultiMsgProxy
  extends BaseProxy
{
  public static final int a = 10000;
  static final String jdField_a_of_type_JavaLangString = "MultiMsg";
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { MessageForText.class, MessageForPic.class, MessageForMixedMsg.class, MessageForLongMsg.class, MessageForShortVideo.class, MessageForReplyText.class, MessageForTroopFile.class, MessageForQQStoryComment.class };
  public static final String b = "mr_multimessage";
  MessageRecordEntityManager jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MultiMsgProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private MessageRecordEntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (AnonymousChatHelper.a(paramChatMessage)) {
      return false;
    }
    if ((MessageForShortVideo.class.isInstance(paramChatMessage)) && (((MessageForShortVideo)paramChatMessage).busiType == 2)) {
      return false;
    }
    if ((MessageForLongTextMsg.class.isInstance(paramChatMessage)) && ((paramChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (paramChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3")))) {
      return false;
    }
    Object localObject = jdField_a_of_type_ArrayOfJavaLangClass;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].isInstance(paramChatMessage)) {
        return true;
      }
      i += 1;
    }
    if (MessageForStructing.class.isInstance(paramChatMessage))
    {
      localObject = (MessageForStructing)paramChatMessage;
      if ((((MessageForStructing)localObject).structingMsg != null) && ("viewMultiMsg".equals(((MessageForStructing)localObject).structingMsg.mMsgAction))) {
        return false;
      }
      if (paramChatMessage.msgtype != 63525) {
        return false;
      }
      if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.fwFlag == 1)) {
        return false;
      }
      return (((MessageForStructing)localObject).structingMsg == null) || (!((MessageForStructing)localObject).structingMsg.hasFlag(1));
    }
    if (MessageForBitApp.class.isInstance(paramChatMessage))
    {
      if (paramChatMessage.msgtype != 60527) {
        return false;
      }
      paramChatMessage = (MessageForBitApp)paramChatMessage;
      if ((paramChatMessage.bitAppMsg != null) && (paramChatMessage.bitAppMsg.mFlag == 1)) {
        return false;
      }
      return (paramChatMessage.bitAppMsg == null) || (!paramChatMessage.bitAppMsg.hasFlag(1));
    }
    return false;
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    return (MessageForMarketFace.class.isInstance(paramChatMessage)) || (MessageForPic.class.isInstance(paramChatMessage));
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    return (MessageForFile.class.isInstance(paramChatMessage)) || (MessageForTroopFile.class.isInstance(paramChatMessage));
  }
  
  public static boolean d(ChatMessage paramChatMessage)
  {
    return (MessageForFile.class.isInstance(paramChatMessage)) || (MessageForTroopFile.class.isInstance(paramChatMessage));
  }
  
  protected MessageRecord a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "queryLastMsg,delNum:" + paramInt);
    }
    ArrayList localArrayList = (ArrayList)a().a(MessageRecord.class, "select * from mr_multimessage limit 1 offset ?", new String[] { String.valueOf(paramInt - 1) });
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      return null;
    }
    return (MessageRecord)localArrayList.get(0);
  }
  
  protected MessageRecord a(long paramLong1, long paramLong2)
  {
    List localList = a().a(MessageRecord.class, "select * from mr_multimessage where msgseq=? and uniseq=?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
    if ((localList == null) || (localList.size() < 1)) {
      return null;
    }
    ((MessageRecord)localList.get(0)).isMultiMsg = true;
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "queryOneMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localList.get(0)).msgseq);
    }
    return (MessageRecord)localList.get(0);
  }
  
  public ArrayList a(long paramLong)
  {
    ArrayList localArrayList = (ArrayList)a().a(MessageRecord.class, "select * from mr_multimessage where msgseq=? order by _id asc", new String[] { String.valueOf(paramLong) });
    Object localObject1;
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      localObject1 = new ArrayList();
    }
    do
    {
      return (ArrayList)localObject1;
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        ((MessageRecord)localObject2).isMultiMsg = true;
        if (((MessageRecord)localObject2).msgtype == 64501)
        {
          localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((MessageRecord)((Iterator)localObject2).next()).isMultiMsg = true;
          }
        }
      }
      localObject1 = localArrayList;
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "querySevalMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localArrayList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localArrayList.get(0)).msgseq);
    return localArrayList;
  }
  
  public ArrayList a(MessageRecord paramMessageRecord, ArrayList paramArrayList, ProxyListener paramProxyListener)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramArrayList.iterator();
    while (localIterator1.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)localIterator1.next();
      if (localMessageRecord1.msgtype == 64499) {
        paramArrayList = (MessageForText)((MessageForLongMsg)localMessageRecord1).rebuildLongMsg();
      }
      while (paramArrayList == null)
      {
        return null;
        if (localMessageRecord1.msgtype == 64500) {
          paramArrayList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord1).rebuildLongMsg();
        } else if (localMessageRecord1.msgtype == 63525) {
          paramArrayList = new MessageForStructing(localMessageRecord1);
        } else if (localMessageRecord1.msgtype == 60527) {
          paramArrayList = new MessageForBitApp(localMessageRecord1);
        } else {
          paramArrayList = (MessageRecord)localMessageRecord1.deepCopyByReflect();
        }
      }
      paramArrayList.msgseq = paramMessageRecord.uniseq;
      paramArrayList.isMultiMsg = true;
      paramArrayList.extraflag = 32770;
      if (paramArrayList.msgtype == 64501)
      {
        Iterator localIterator2 = ((MessageForMixedMsg)paramArrayList).msgElemList.iterator();
        while (localIterator2.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator2.next();
          localMessageRecord2.msgseq = paramArrayList.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      localArrayList.add(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "preAddMultiMsg, MessageRecord:" + localMessageRecord1.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramArrayList.frienduin, paramArrayList.istroop, paramArrayList.getTableName(), paramArrayList, 0, paramProxyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    return localArrayList;
  }
  
  public ArrayList a(byte[] paramArrayOfByte, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageInfo paramMessageInfo)
  {
    long l4 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, start unpack, startTime:" + l4);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, data is null or data.lenght is 0");
      }
      return null;
    }
    Object localObject1 = b(paramArrayOfByte);
    if (localObject1 == null) {
      return null;
    }
    paramArrayOfByte = new ArrayList();
    Object localObject2 = new msg_transmit.PbMultiMsgTransmit();
    int i;
    Object localObject3;
    try
    {
      localObject1 = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject2).mergeFrom((byte[])localObject1);
      i = 0;
      if (i >= ((msg_transmit.PbMultiMsgTransmit)localObject1).msg.size()) {
        break label990;
      }
      localObject3 = (msg_comm.Msg)((msg_transmit.PbMultiMsgTransmit)localObject1).msg.get(i);
      if ((!((msg_comm.Msg)localObject3).msg_body.has()) || (!((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).rich_text.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, no msg_body or rich_text, msg_body.has():" + ((msg_comm.Msg)localObject3).msg_body.has());
        }
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, error: exception occurs while parsing the pb bytes", paramArrayOfByte);
      }
      return null;
    }
    Object localObject4 = (msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get();
    long l3 = ((msg_comm.MsgHead)localObject4).from_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject4).msg_seq.get();
    long l6 = ((msg_comm.MsgHead)localObject4).msg_time.get();
    long l7 = ((msg_comm.MsgHead)localObject4).msg_uid.get();
    int j = ((msg_comm.MsgHead)localObject4).msg_type.get();
    MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject2 = MessageProtoCodec.a(localMessageHandler, (msg_comm.Msg)localObject3, String.valueOf(l3), String.valueOf(l3));
    long l1;
    if (((Long)((Pair)localObject2).first).longValue() != 4294967295L)
    {
      l1 = ((Long)((Pair)localObject2).first).longValue();
      if (l1 != -1L) {
        break label1091;
      }
    }
    label468:
    label901:
    label990:
    label1091:
    for (long l2 = 0L;; l2 = l1)
    {
      localObject2 = new ArrayList();
      int k;
      if ((MessageUtils.c(j)) && (((msg_comm.MsgHead)localObject4).c2c_cmd.has()))
      {
        k = ((msg_comm.MsgHead)localObject4).c2c_cmd.get();
        if ((k == 175) || (k == 11)) {
          MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, true, false, paramMessageInfo);
        }
        if ((((msg_comm.MsgHead)localObject4).from_nick.has()) && (paramHashMap != null)) {
          paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).from_nick.get());
        }
        l1 = l3;
        k = MessageProtoCodec.a((msg_comm.Msg)localObject3);
        localObject3 = ((ArrayList)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label901;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        ((MessageRecord)localObject4).time = l6;
        ((MessageRecord)localObject4).shmsgseq = l5;
        ((MessageRecord)localObject4).msgUid = l7;
        ((MessageRecord)localObject4).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((MessageRecord)localObject4).senderuin = String.valueOf(l3);
        ((MessageRecord)localObject4).frienduin = String.valueOf(l1);
        ((MessageRecord)localObject4).vipBubbleDiyTextId = k;
        ((MessageRecord)localObject4).vipBubbleID = SVIPHandler.a((int)l2, k);
        if ((j == 82) || (j == 43))
        {
          ((MessageRecord)localObject4).istroop = 1;
          continue;
          l1 = ((Long)((Pair)localObject2).second).longValue();
          break;
          if (((j == 82) || (j == 43)) && (((msg_comm.MsgHead)localObject4).group_info.has()))
          {
            l1 = ((msg_comm.MsgHead)localObject4).group_info.group_code.get();
            ((msg_comm.MsgHead)localObject4).group_info.group_code.get();
            MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, false, false, paramMessageInfo);
            if ((((msg_comm.MsgHead)localObject4).group_info.group_card.has()) && (paramHashMap != null)) {
              paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).group_info.group_card.get().toStringUtf8());
            }
            break label468;
          }
          if (((j == 83) || (j == 42)) && (((msg_comm.MsgHead)localObject4).discuss_info.has()))
          {
            l1 = ((msg_comm.MsgHead)localObject4).discuss_info.discuss_uin.get();
            ((msg_comm.MsgHead)localObject4).discuss_info.discuss_uin.get();
            MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, false, false, paramMessageInfo);
            if ((((msg_comm.MsgHead)localObject4).discuss_info.discuss_remark.has()) && (paramHashMap != null)) {
              paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).discuss_info.discuss_remark.get().toStringUtf8());
            }
            break label468;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, illegal msgType:" + j);
          }
          return null;
        }
        if ((j == 83) || (j == 42)) {
          ((MessageRecord)localObject4).istroop = 3000;
        } else {
          ((MessageRecord)localObject4).istroop = 0;
        }
      }
      MessageHandlerUtils.a((List)localObject2);
      localObject3 = ((ArrayList)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
      } while ((localObject4 == null) || (!(localObject4 instanceof MessageForBitApp)));
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((BitAppManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(143)).a((List)localObject2);
        }
        paramArrayOfByte.addAll((Collection)localObject2);
        i += 1;
        break;
        if ((paramMessageRecord == null) && (paramArrayOfByte.size() == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "unpackPbToMultiMsg end unpack, type: longText");
          }
          return paramArrayOfByte;
        }
        if (!a(paramMessageRecord, paramArrayOfByte, null)) {
          return null;
        }
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, end unpack,endTime:" + l1 + " cost:" + (l1 - l4));
        }
        return paramArrayOfByte;
      }
    }
  }
  
  public msg_comm.MsgHead a(MessageRecord paramMessageRecord, HashMap paramHashMap, boolean paramBoolean)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    localMsgHead.from_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
    localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
    localMsgHead.msg_time.set((int)paramMessageRecord.time);
    localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
    Object localObject = new msg_comm.MutilTransHead().status;
    int i;
    if (paramBoolean)
    {
      i = 0;
      ((PBUInt32Field)localObject).set(i);
      localMsgHead.mutiltrans_head.set(new msg_comm.MutilTransHead());
      if (paramMessageRecord.istroop != 0) {
        break label224;
      }
      localMsgHead.msg_type.set(9);
      if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing))) {
        break label196;
      }
      localMsgHead.c2c_cmd.set(11);
      label153:
      if ((paramHashMap == null) || (paramHashMap.get(paramMessageRecord.senderuin) == null)) {
        break label210;
      }
      localMsgHead.from_nick.set((String)paramHashMap.get(paramMessageRecord.senderuin));
    }
    for (;;)
    {
      return localMsgHead;
      i = -1;
      break;
      label196:
      localMsgHead.c2c_cmd.set(175);
      break label153;
      label210:
      localMsgHead.from_nick.set(" ");
    }
    label224:
    if (paramMessageRecord.istroop == 3000)
    {
      localMsgHead.msg_type.set(83);
      localObject = new msg_comm.DiscussInfo();
      ((msg_comm.DiscussInfo)localObject).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if ((paramHashMap != null) && (paramHashMap.get(paramMessageRecord.senderuin) != null)) {
        ((msg_comm.DiscussInfo)localObject).discuss_remark.set(ByteStringMicro.copyFromUtf8((String)paramHashMap.get(paramMessageRecord.senderuin)));
      }
      for (;;)
      {
        localMsgHead.discuss_info.set((MessageMicro)localObject);
        break;
        ((msg_comm.DiscussInfo)localObject).discuss_remark.set(ByteStringMicro.copyFromUtf8(" "));
      }
    }
    if (paramMessageRecord.istroop == 1)
    {
      localMsgHead.msg_type.set(82);
      localObject = new msg_comm.GroupInfo();
      ((msg_comm.GroupInfo)localObject).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if ((paramHashMap != null) && (paramHashMap.get(paramMessageRecord.senderuin) != null)) {
        ((msg_comm.GroupInfo)localObject).group_card.set(ByteStringMicro.copyFromUtf8((String)paramHashMap.get(paramMessageRecord.senderuin)));
      }
      for (;;)
      {
        localMsgHead.group_info.set((MessageMicro)localObject);
        break;
        ((msg_comm.GroupInfo)localObject).group_card.set(ByteStringMicro.copyFromUtf8(" "));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "MultiMsg:getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
    }
    return null;
  }
  
  public im_msg_body.MsgBody a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    if ((paramMessageRecord.msgtype == 64536) || (paramMessageRecord.msgtype == 55536)) {
      localObject1 = MessageProtoCodec.a((MessageForText)paramMessageRecord);
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((im_msg_body.RichText)localObject1).elems.isEmpty()))
      {
        Object localObject2 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject2).uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
        paramMessageRecord = new im_msg_body.Elem();
        paramMessageRecord.elem_flags2.set((MessageMicro)localObject2);
        ((im_msg_body.RichText)localObject1).elems.add(paramMessageRecord);
        paramMessageRecord = new im_msg_body.MsgBody();
        paramMessageRecord.rich_text.set((MessageMicro)localObject1);
        do
        {
          return paramMessageRecord;
          if (paramMessageRecord.msgtype == 64487)
          {
            localObject1 = MessageProtoCodec.a((MessageForReplyText)paramMessageRecord);
            break;
          }
          if (paramMessageRecord.msgtype != 63531) {
            break label171;
          }
          localObject2 = MessageProtoCodec.a((MessageForFile)paramMessageRecord);
          localObject1 = new im_msg_body.MsgBody();
          paramMessageRecord = (MessageRecord)localObject1;
        } while (localObject2 == null);
        ((im_msg_body.MsgBody)localObject1).rich_text.set((MessageMicro)localObject2);
        return (im_msg_body.MsgBody)localObject1;
        label171:
        if (paramMessageRecord.msgtype == 63484)
        {
          localObject1 = MessageProtoCodec.a((MessageForQQStoryComment)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == 63536)
        {
          localObject1 = MessageProtoCodec.a((MessageForPic)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == 63525)
        {
          localObject1 = MessageProtoCodec.a((MessageForStructing)paramMessageRecord);
          if (localObject1 == null) {
            return null;
          }
          localObject2 = (MessageForStructing)paramMessageRecord;
          try
          {
            if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare)) && (((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement() != null))
            {
              localObject2 = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement().a.richText;
              if (localObject2 == null) {
                return null;
              }
              ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject2).elems.get(0));
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg", 2, " packMultiMsg.structMsg.exception...");
              }
            }
          }
        }
        if (paramMessageRecord.msgtype == 60527)
        {
          localObject1 = MessageProtoCodec.a((MessageForBitApp)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == 64501)
        {
          localObject1 = new im_msg_body.RichText();
          int k = ((MessageForMixedMsg)paramMessageRecord).msgElemList.size();
          int i = 0;
          while (i < k)
          {
            Object localObject3 = (MessageRecord)((MessageForMixedMsg)paramMessageRecord).msgElemList.get(i);
            if ((localObject3 instanceof MessageForText))
            {
              localObject3 = MessageProtoCodec.a((MessageForText)localObject3);
              if (localObject3 == null) {
                return null;
              }
              int j = 0;
              while (j < ((im_msg_body.RichText)localObject3).elems.size())
              {
                ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject3).elems.get(j));
                j += 1;
              }
            }
            if ((localObject3 instanceof MessageForRichText))
            {
              localObject3 = ((MessageForPic)localObject3).richText;
              if (localObject3 == null) {
                return null;
              }
              ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject3).elems.get(0));
            }
            i += 1;
          }
          continue;
        }
        if (paramMessageRecord.msgtype == 64485) {
          localObject1 = MessageProtoCodec.a((MessageForLongTextMsg)paramMessageRecord, false);
        }
      }
      else
      {
        return null;
      }
      localObject1 = null;
    }
  }
  
  protected void a() {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt1, "mr_multimessage", paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramLong) }, 2, null);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, "mr_multimessage", "selfuin=?", new String[] { paramString2 }, 2, null);
  }
  
  protected boolean a(MessageRecord paramMessageRecord, List paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if (paramMessageRecord.senderuin.equals(localMessageRecord1.senderuin))
      {
        localMessageRecord1.issend = 1;
        localMessageRecord1.selfuin = localMessageRecord1.senderuin;
      }
      localMessageRecord1.msgseq = paramMessageRecord.uniseq;
      localMessageRecord1.isMultiMsg = true;
      if (localMessageRecord1.msgtype == 64501)
      {
        Iterator localIterator = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          localMessageRecord2.msgseq = localMessageRecord1.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localMessageRecord1.toString();
        QLog.d("MultiMsg", 2, "AddMultiMsg,time:" + localMessageRecord1.time + " senderuin:" + localMessageRecord1.senderuin + " istroop:" + localMessageRecord1.istroop + " shmsgseq:" + localMessageRecord1.shmsgseq + " msgseq:" + localMessageRecord1.msgseq + " msgData:" + localMessageRecord1.msgData);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(localMessageRecord1.frienduin, localMessageRecord1.istroop, localMessageRecord1.getTableName(), localMessageRecord1, 0, paramProxyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    return true;
  }
  
  protected boolean a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "checkMultiMsg, mr == null");
        }
        return false;
      }
      if (((localMessageRecord.istroop == 3000) || (localMessageRecord.istroop == 1)) && (localMessageRecord.shmsgseq <= 0L))
      {
        if (localMessageRecord.shmsgseq < 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "checkMultiMsg, shmsgseq < 0");
          }
          return false;
        }
        if (!MsgProxyUtils.a(localMessageRecord))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "checkMultiMsg, shmsgseq=0 and msgtype:" + localMessageRecord.msgtype);
          }
          return false;
        }
      }
      if ((MsgProxyUtils.m(localMessageRecord.msgtype)) && (!MsgProxyUtils.a(localMessageRecord.frienduin, localMessageRecord.istroop)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "checkMultiMsg, msgtype:" + localMessageRecord.msgtype + " frienduin:" + localMessageRecord.frienduin + " istroop:" + localMessageRecord.istroop);
        }
        return false;
      }
    }
    return true;
  }
  
  public boolean a(List paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramProxyListener = (MessageRecord)paramList.next();
      if (paramProxyListener.getStatus() == 1000) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 3, null);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 4, null);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    return true;
  }
  
  public byte[] a(MessageRecord paramMessageRecord)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "packPbFromLongTextMsg, start pack, startTime:" + l1);
    }
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put(paramMessageRecord.senderuin, localObject1);
    localObject1 = new msg_comm.Msg();
    localObject2 = a(paramMessageRecord, (HashMap)localObject2, true);
    im_msg_body.MsgBody localMsgBody = a(paramMessageRecord);
    if ((localObject2 != null) && (localMsgBody != null))
    {
      ((msg_comm.Msg)localObject1).msg_head.set((MessageMicro)localObject2);
      ((msg_comm.Msg)localObject1).msg_body.set(localMsgBody);
      localPbMultiMsgTransmit.msg.add((MessageMicro)localObject1);
    }
    for (;;)
    {
      paramMessageRecord = a(localPbMultiMsgTransmit.toByteArray());
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "packPbFromLongTextMsg, end pack, endTime:" + l2 + " cost:" + (l2 - l1));
      }
      return paramMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "packPbFromLongTextMsg, error:msg_head or msg_body is null,uniseq:" + paramMessageRecord.uniseq);
      }
    }
  }
  
  public byte[] a(MessageRecord paramMessageRecord, ArrayList paramArrayList, HashMap paramHashMap, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "packPbToMultiMsg, start pack, startTime:" + l1);
    }
    paramMessageRecord = null;
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      paramArrayList = new msg_comm.Msg();
      msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap, paramBoolean);
      im_msg_body.MsgBody localMsgBody = a(localMessageRecord);
      if ((localMsgHead != null) && (localMsgBody != null))
      {
        paramArrayList.msg_head.set(localMsgHead);
        paramArrayList.msg_body.set(localMsgBody);
        localPbMultiMsgTransmit.msg.add(paramArrayList);
      }
      else
      {
        paramArrayList = paramMessageRecord;
        if (paramMessageRecord == null) {
          paramArrayList = new StringBuilder("packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:");
        }
        paramArrayList.append(localMessageRecord.uniseq).append("|");
        paramMessageRecord = paramArrayList;
      }
    }
    if ((paramMessageRecord != null) && (QLog.isColorLevel())) {
      QLog.d("MultiMsg", 2, paramMessageRecord.toString());
    }
    paramMessageRecord = a(localPbMultiMsgTransmit.toByteArray());
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "packPbToMultiMsg, end pack,endTime:" + l2 + " cost:" + (l2 - l1));
    }
    return paramMessageRecord;
  }
  
  /* Error */
  public byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 10
    //   8: iconst_2
    //   9: new 158	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 748
    //   19: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: arraylength
    //   24: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 750	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 753	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: astore_3
    //   42: new 755	java/io/ByteArrayOutputStream
    //   45: dup
    //   46: invokespecial 756	java/io/ByteArrayOutputStream:<init>	()V
    //   49: astore 4
    //   51: sipush 1024
    //   54: newarray <illegal type>
    //   56: astore_1
    //   57: new 758	java/util/zip/GZIPOutputStream
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 761	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_2
    //   67: aload_3
    //   68: aload_1
    //   69: iconst_0
    //   70: sipush 1024
    //   73: invokevirtual 765	java/io/ByteArrayInputStream:read	([BII)I
    //   76: istore 5
    //   78: iload 5
    //   80: iconst_m1
    //   81: if_icmpeq +65 -> 146
    //   84: aload_2
    //   85: aload_1
    //   86: iconst_0
    //   87: iload 5
    //   89: invokevirtual 769	java/util/zip/GZIPOutputStream:write	([BII)V
    //   92: goto -25 -> 67
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +32 -> 133
    //   104: ldc 10
    //   106: iconst_2
    //   107: new 158	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 771
    //   117: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_2
    //   121: invokevirtual 774	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 4
    //   135: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   138: aload_3
    //   139: invokevirtual 778	java/io/ByteArrayInputStream:close	()V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_2
    //   145: areturn
    //   146: aload_2
    //   147: invokevirtual 781	java/util/zip/GZIPOutputStream:flush	()V
    //   150: aload_2
    //   151: invokevirtual 782	java/util/zip/GZIPOutputStream:close	()V
    //   154: aload 4
    //   156: invokevirtual 783	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   159: astore_1
    //   160: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +30 -> 193
    //   166: ldc 10
    //   168: iconst_2
    //   169: new 158	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 785
    //   179: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: arraylength
    //   184: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 4
    //   195: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   198: aload_3
    //   199: invokevirtual 778	java/io/ByteArrayInputStream:close	()V
    //   202: aload_1
    //   203: areturn
    //   204: astore_3
    //   205: aload_1
    //   206: astore_2
    //   207: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -66 -> 144
    //   213: ldc 10
    //   215: iconst_2
    //   216: new 158	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 787
    //   226: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_3
    //   230: invokevirtual 788	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload_1
    //   243: areturn
    //   244: astore_3
    //   245: aload_1
    //   246: astore_2
    //   247: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq -106 -> 144
    //   253: ldc 10
    //   255: iconst_2
    //   256: new 158	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 787
    //   266: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_3
    //   270: invokevirtual 788	java/io/IOException:getMessage	()Ljava/lang/String;
    //   273: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_1
    //   283: areturn
    //   284: astore_2
    //   285: aconst_null
    //   286: astore_1
    //   287: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +32 -> 322
    //   293: ldc 10
    //   295: iconst_2
    //   296: new 158	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   303: ldc_w 790
    //   306: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_2
    //   310: invokevirtual 791	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: aload 4
    //   324: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   327: aload_3
    //   328: invokevirtual 778	java/io/ByteArrayInputStream:close	()V
    //   331: aload_1
    //   332: areturn
    //   333: astore_3
    //   334: aload_1
    //   335: astore_2
    //   336: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq -195 -> 144
    //   342: ldc 10
    //   344: iconst_2
    //   345: new 158	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 787
    //   355: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_3
    //   359: invokevirtual 788	java/io/IOException:getMessage	()Ljava/lang/String;
    //   362: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload_1
    //   372: areturn
    //   373: astore_1
    //   374: aload 4
    //   376: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   379: aload_3
    //   380: invokevirtual 778	java/io/ByteArrayInputStream:close	()V
    //   383: aload_1
    //   384: athrow
    //   385: astore_2
    //   386: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq -6 -> 383
    //   392: ldc 10
    //   394: iconst_2
    //   395: new 158	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 787
    //   405: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_2
    //   409: invokevirtual 788	java/io/IOException:getMessage	()Ljava/lang/String;
    //   412: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: goto -38 -> 383
    //   424: astore_2
    //   425: goto -138 -> 287
    //   428: astore_2
    //   429: goto -331 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	MultiMsgProxy
    //   0	432	1	paramArrayOfByte	byte[]
    //   66	19	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   95	26	2	localException1	Exception
    //   143	104	2	arrayOfByte1	byte[]
    //   284	26	2	localOutOfMemoryError1	OutOfMemoryError
    //   335	1	2	arrayOfByte2	byte[]
    //   385	24	2	localIOException1	java.io.IOException
    //   424	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   428	1	2	localException2	Exception
    //   41	158	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   204	26	3	localIOException2	java.io.IOException
    //   244	84	3	localIOException3	java.io.IOException
    //   333	47	3	localIOException4	java.io.IOException
    //   49	326	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   76	12	5	i	int
    // Exception table:
    //   from	to	target	type
    //   51	67	95	java/lang/Exception
    //   67	78	95	java/lang/Exception
    //   84	92	95	java/lang/Exception
    //   146	160	95	java/lang/Exception
    //   193	202	204	java/io/IOException
    //   133	142	244	java/io/IOException
    //   51	67	284	java/lang/OutOfMemoryError
    //   67	78	284	java/lang/OutOfMemoryError
    //   84	92	284	java/lang/OutOfMemoryError
    //   146	160	284	java/lang/OutOfMemoryError
    //   322	331	333	java/io/IOException
    //   51	67	373	finally
    //   67	78	373	finally
    //   84	92	373	finally
    //   98	133	373	finally
    //   146	160	373	finally
    //   160	193	373	finally
    //   287	322	373	finally
    //   374	383	385	java/io/IOException
    //   160	193	424	java/lang/OutOfMemoryError
    //   160	193	428	java/lang/Exception
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a();
    }
  }
  
  /* Error */
  public byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 10
    //   8: iconst_2
    //   9: new 158	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 795
    //   19: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: arraylength
    //   24: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 750	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 753	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: astore_3
    //   42: new 755	java/io/ByteArrayOutputStream
    //   45: dup
    //   46: invokespecial 756	java/io/ByteArrayOutputStream:<init>	()V
    //   49: astore 4
    //   51: sipush 1024
    //   54: newarray <illegal type>
    //   56: astore_1
    //   57: new 797	java/util/zip/GZIPInputStream
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 800	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore_2
    //   66: aload_2
    //   67: aload_1
    //   68: iconst_0
    //   69: sipush 1024
    //   72: invokevirtual 801	java/util/zip/GZIPInputStream:read	([BII)I
    //   75: istore 5
    //   77: iload 5
    //   79: iconst_m1
    //   80: if_icmpeq +66 -> 146
    //   83: aload 4
    //   85: aload_1
    //   86: iconst_0
    //   87: iload 5
    //   89: invokevirtual 802	java/io/ByteArrayOutputStream:write	([BII)V
    //   92: goto -26 -> 66
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +32 -> 133
    //   104: ldc 10
    //   106: iconst_2
    //   107: new 158	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 804
    //   117: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_2
    //   121: invokevirtual 774	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 4
    //   135: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   138: aload_3
    //   139: invokevirtual 778	java/io/ByteArrayInputStream:close	()V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_2
    //   145: areturn
    //   146: aload_2
    //   147: invokevirtual 805	java/util/zip/GZIPInputStream:close	()V
    //   150: aload 4
    //   152: invokevirtual 783	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   155: astore_1
    //   156: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +30 -> 189
    //   162: ldc 10
    //   164: iconst_2
    //   165: new 158	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 807
    //   175: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_1
    //   179: arraylength
    //   180: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 4
    //   191: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   194: aload_3
    //   195: invokevirtual 778	java/io/ByteArrayInputStream:close	()V
    //   198: aload_1
    //   199: areturn
    //   200: astore_3
    //   201: aload_1
    //   202: astore_2
    //   203: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq -62 -> 144
    //   209: ldc 10
    //   211: iconst_2
    //   212: new 158	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 809
    //   222: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_3
    //   226: invokevirtual 788	java/io/IOException:getMessage	()Ljava/lang/String;
    //   229: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_1
    //   239: areturn
    //   240: astore_3
    //   241: aload_1
    //   242: astore_2
    //   243: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -102 -> 144
    //   249: ldc 10
    //   251: iconst_2
    //   252: new 158	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 809
    //   262: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_3
    //   266: invokevirtual 788	java/io/IOException:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_1
    //   279: areturn
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +32 -> 318
    //   289: ldc 10
    //   291: iconst_2
    //   292: new 158	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 804
    //   302: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_2
    //   306: invokevirtual 791	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   309: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 4
    //   320: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   323: aload_3
    //   324: invokevirtual 778	java/io/ByteArrayInputStream:close	()V
    //   327: aload_1
    //   328: areturn
    //   329: astore_3
    //   330: aload_1
    //   331: astore_2
    //   332: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -191 -> 144
    //   338: ldc 10
    //   340: iconst_2
    //   341: new 158	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 809
    //   351: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_3
    //   355: invokevirtual 788	java/io/IOException:getMessage	()Ljava/lang/String;
    //   358: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload_1
    //   368: areturn
    //   369: astore_1
    //   370: aload 4
    //   372: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   375: aload_3
    //   376: invokevirtual 778	java/io/ByteArrayInputStream:close	()V
    //   379: aload_1
    //   380: athrow
    //   381: astore_2
    //   382: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq -6 -> 379
    //   388: ldc 10
    //   390: iconst_2
    //   391: new 158	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   398: ldc_w 809
    //   401: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_2
    //   405: invokevirtual 788	java/io/IOException:getMessage	()Ljava/lang/String;
    //   408: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: goto -38 -> 379
    //   420: astore_2
    //   421: goto -138 -> 283
    //   424: astore_2
    //   425: goto -327 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	MultiMsgProxy
    //   0	428	1	paramArrayOfByte	byte[]
    //   65	2	2	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   95	26	2	localException1	Exception
    //   143	100	2	arrayOfByte1	byte[]
    //   280	26	2	localOutOfMemoryError1	OutOfMemoryError
    //   331	1	2	arrayOfByte2	byte[]
    //   381	24	2	localIOException1	java.io.IOException
    //   420	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   424	1	2	localException2	Exception
    //   41	154	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   200	26	3	localIOException2	java.io.IOException
    //   240	84	3	localIOException3	java.io.IOException
    //   329	47	3	localIOException4	java.io.IOException
    //   49	322	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   75	13	5	i	int
    // Exception table:
    //   from	to	target	type
    //   51	66	95	java/lang/Exception
    //   66	77	95	java/lang/Exception
    //   83	92	95	java/lang/Exception
    //   146	156	95	java/lang/Exception
    //   189	198	200	java/io/IOException
    //   133	142	240	java/io/IOException
    //   51	66	280	java/lang/OutOfMemoryError
    //   66	77	280	java/lang/OutOfMemoryError
    //   83	92	280	java/lang/OutOfMemoryError
    //   146	156	280	java/lang/OutOfMemoryError
    //   318	327	329	java/io/IOException
    //   51	66	369	finally
    //   66	77	369	finally
    //   83	92	369	finally
    //   98	133	369	finally
    //   146	156	369	finally
    //   156	189	369	finally
    //   283	318	369	finally
    //   370	379	381	java/io/IOException
    //   156	189	420	java/lang/OutOfMemoryError
    //   156	189	424	java/lang/Exception
  }
  
  public void c()
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {}
    int i;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return;
        i = localSQLiteDatabase.a("mr_multimessage");
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "checkMsgCounts, count:" + i);
        }
      } while (i <= 10000);
      i = Math.max(i - 10000, 200);
      localMessageRecord = a(i);
    } while (localMessageRecord == null);
    String str = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { "mr_multimessage", "mr_multimessage", Integer.valueOf(i) });
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "checkMsgCounts, delNum:" + i + "mr.msgseq:" + localMessageRecord.msgseq);
    }
    try
    {
      localSQLiteDatabase.a(str);
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgseq);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\MultiMsgProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */