package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr.LocationInfo;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.MultiMsgAssist;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;

public class MessageHandlerUtils
{
  public static final String a = "Q.msg.MessageHandlerUtils";
  
  public MessageHandlerUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramQQAppInterface.getLongAccountUin();
    if (paramLong1 == l) {
      return paramLong2;
    }
    if (paramLong2 == l) {
      return paramLong1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MessageHandlerUtils", 2, "<---decodeC2CMessagePackage: neither fromUin nor toUin is selfUin.use peerUin instead.");
    }
    return paramLong3;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 4) {
      return 0L;
    }
    return ((paramArrayOfByte[0] & 0xFF) << 24) + ((paramArrayOfByte[1] & 0xFF) << 16) + ((paramArrayOfByte[2] & 0xFF) << 8) + (paramArrayOfByte[3] & 0xFF);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = paramQQAppInterface.a();
    if ((str != null) && (str.equals(paramString1))) {
      return "你";
    }
    paramString2 = ContactUtils.a(paramQQAppInterface, paramString1, paramString2, 1, 0);
    if (paramString2 == paramString1)
    {
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString1);
      if (paramQQAppInterface != null) {
        return ContactUtils.a(paramQQAppInterface);
      }
    }
    return paramString2;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject1 = null;
    int j = 0;
    int i;
    if (paramMessageRecord.msgtype == 64536)
    {
      localObject1 = MessageProtoCodec.a((MessageForText)paramMessageRecord);
      i = ((MessageForText)paramMessageRecord).msgVia;
    }
    while (localObject1 == null)
    {
      return null;
      if (paramMessageRecord.msgtype == 64487)
      {
        localObject1 = MessageProtoCodec.a((MessageForReplyText)paramMessageRecord);
        i = ((MessageForReplyText)paramMessageRecord).msgVia;
      }
      else if (paramMessageRecord.msgtype == 63536)
      {
        localObject1 = MessageProtoCodec.a((MessageForPic)paramMessageRecord);
        i = ((MessageForPic)paramMessageRecord).msgVia;
      }
      else if (paramMessageRecord.msgtype == 63534)
      {
        localObject1 = MessageProtoCodec.a((MessageForPtt)paramMessageRecord);
        i = ((MessageForPtt)paramMessageRecord).msgVia;
      }
      else if (paramMessageRecord.msgtype == 63529)
      {
        localObject1 = MessageProtoCodec.a((MessageForMarketFace)paramMessageRecord);
        i = ((MessageForMarketFace)paramMessageRecord).msgVia;
      }
      else if (paramMessageRecord.msgtype == 63497)
      {
        localObject1 = MessageProtoCodec.a((MessageForApollo)paramMessageRecord);
        i = j;
      }
      else if ((paramMessageRecord.msgtype == 63525) || (paramMessageRecord.msgtype == 63485))
      {
        localObject1 = MessageProtoCodec.a((MessageForStructing)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == 60527)
      {
        localObject1 = MessageProtoCodec.a((MessageForBitApp)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == 63526)
      {
        localObject1 = MessageProtoCodec.a((MessageForFunnyFace)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == 63516)
      {
        localObject1 = MessageProtoCodec.a((MessageForShakeWindow)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == 63514)
      {
        localObject1 = MessageProtoCodec.a((MessageForShortVideo)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == 60528)
      {
        localObject1 = MessageProtoCodec.b((ChatMessage)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == 60524)
      {
        localObject1 = MessageProtoCodec.c((MessageForPoke)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == 64485)
      {
        localObject1 = MessageProtoCodec.a((MessageForLongTextMsg)paramMessageRecord, true);
        i = j;
      }
      else
      {
        i = j;
        if (paramMessageRecord.msgtype == 64501)
        {
          localObject1 = MessageProtoCodec.a((MessageForMixedMsg)paramMessageRecord);
          i = j;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "send message, entrance: " + i);
    }
    Object localObject2;
    if (paramMessageRecord.msgtype == 64536)
    {
      localObject3 = (MessageForText)paramMessageRecord;
      if (((MessageForText)localObject3).mPasswdRedBagFlag != 0)
      {
        localObject2 = new im_msg_body.ExtraInfo();
        ((im_msg_body.ExtraInfo)localObject2).uint64_uin.set(((MessageForText)localObject3).mPasswdRedBagSender);
        ((im_msg_body.ExtraInfo)localObject2).uint32_msg_state_flag.set(((MessageForText)localObject3).mPasswdRedBagFlag);
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).extra_info.set((MessageMicro)localObject2);
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
      }
    }
    Object localObject4;
    if (AnonymousChatHelper.a(paramMessageRecord))
    {
      localObject2 = new im_msg_body.Elem();
      localObject3 = new im_msg_body.AnonymousGroupMsg();
      localObject4 = AnonymousChatHelper.a(paramMessageRecord);
      ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_flags.set(((AnonymousChatHelper.AnonymousExtInfo)localObject4).jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject4).jdField_a_of_type_JavaLangString)) {
        ((im_msg_body.AnonymousGroupMsg)localObject3).str_anon_id.set(ByteStringMicro.copyFrom(((AnonymousChatHelper.AnonymousExtInfo)localObject4).jdField_a_of_type_JavaLangString.getBytes()));
      }
      if (!TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject4).jdField_b_of_type_JavaLangString)) {
        ((im_msg_body.AnonymousGroupMsg)localObject3).str_anon_nick.set(ByteStringMicro.copyFrom(((AnonymousChatHelper.AnonymousExtInfo)localObject4).jdField_b_of_type_JavaLangString.getBytes()));
      }
      ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_head_portrait.set(((AnonymousChatHelper.AnonymousExtInfo)localObject4).jdField_b_of_type_Int);
      ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_expire_time.set(((AnonymousChatHelper.AnonymousExtInfo)localObject4).c);
      ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
      ((im_msg_body.Elem)localObject2).anon_group_msg.set((MessageMicro)localObject3);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    }
    label903:
    do
    {
      do
      {
        localObject2 = DatingUtil.a(paramMessageRecord);
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_bank", 2, "clearingElem has carry, elem:" + ((im_msg_body.Elem)localObject2).near_by_msg.uint32_type.get());
          }
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
        }
        localObject1 = MessageProtoCodec.a(paramQQAppInterface, MessageProtoCodec.b(paramMessageRecord.istroop), paramMessageRecord, (im_msg_body.RichText)localObject1, null, i);
        paramQQAppInterface = a(paramQQAppInterface, paramMessageRecord, (msg_svc.PbSendMsgReq)localObject1);
        if ((paramQQAppInterface != null) && (localObject1 != null))
        {
          paramMessageRecord = (im_msg_body.RichText)((im_msg_body.MsgBody)((msg_svc.PbSendMsgReq)localObject1).msg_body.get()).rich_text.get();
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).general_flags.set(paramQQAppInterface);
          paramMessageRecord.elems.get().add(localObject2);
        }
        return (msg_svc.PbSendMsgReq)localObject1;
      } while ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 1026));
      localObject4 = (FriendsManager)paramQQAppInterface.getManager(50);
      long l2 = 1L;
      long l1 = 1L;
      if ((!TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface).booleanValue()) && (!TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface))) {
        break;
      }
      j = 1;
      if (TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface).booleanValue())
      {
        localObject2 = TroopMemberLbsHelper.a(paramQQAppInterface);
        l2 = ((LbsInfoMgr.LocationInfo)localObject2).jdField_a_of_type_Long;
        l1 = ((LbsInfoMgr.LocationInfo)localObject2).jdField_b_of_type_Long;
      }
      if (TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface)) {
        TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface);
      }
      if (j != 0)
      {
        localObject2 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject2).uint32_longtitude.set((int)l2);
        ((im_msg_body.ElemFlags2)localObject2).uint32_latitude.set((int)l1);
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).elem_flags2.set((MessageMicro)localObject2);
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
      }
      localObject2 = ((HotChatManager)paramQQAppInterface.getManager(59)).a(paramMessageRecord.frienduin);
      localObject3 = (TroopManager)paramQQAppInterface.getManager(51);
    } while ((localObject2 == null) && (!((TroopManager)localObject3).e(paramMessageRecord.frienduin)));
    Object localObject3 = new im_msg_body.PubGroup();
    for (;;)
    {
      try
      {
        localObject2 = (String)NearbySPUtil.a(paramQQAppInterface.a(), "self_nick", String.valueOf(""));
        k = ((Integer)NearbySPUtil.a(paramQQAppInterface.a(), "self_gender", Integer.valueOf(-1))).intValue();
        j = ((Integer)NearbySPUtil.a(paramQQAppInterface.a(), "self_age", Integer.valueOf(-1))).intValue();
        if ((j >= 0) && (k >= 0)) {
          continue;
        }
        localFriends = ((FriendsManager)localObject4).c(paramQQAppInterface.a());
        if (localFriends == null) {
          continue;
        }
        j = localFriends.age;
        if (localFriends.gender != 2) {
          continue;
        }
        k = 1;
        localObject2 = localFriends.name;
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((im_msg_body.PubGroup)localObject3).bytes_nickname.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
        }
        ((im_msg_body.PubGroup)localObject3).uint32_age.set(j);
        ((im_msg_body.PubGroup)localObject3).uint32_gender.set(k);
      }
      catch (Exception localException)
      {
        Friends localFriends;
        localException.printStackTrace();
        continue;
        ((im_msg_body.RichText)localObject1).elems.add(localException);
      }
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).pub_group.set((MessageMicro)localObject3);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
      localObject2 = HotChatManager.a(paramQQAppInterface, paramMessageRecord);
      if (localObject2 == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "carry authElem:" + ((im_msg_body.Elem)localObject2).near_by_msg.uint32_identify_type.get());
      }
      if (paramMessageRecord.msgtype == 63525)
      {
        localObject3 = ((im_msg_body.RichText)localObject1).elems.get();
        ((List)localObject3).add(0, localObject2);
        ((im_msg_body.RichText)localObject1).elems.set((List)localObject3);
        break;
        j = 0;
        break label903;
        if (localFriends.gender != 1) {
          break label1441;
        }
        k = 0;
        continue;
        localObject4 = ((FriendsManager)localObject4).a(paramQQAppInterface.a());
        if (localObject4 != null)
        {
          j = ((Card)localObject4).age;
          k = ((Card)localObject4).shGender;
          localObject2 = ((Card)localObject4).strNick;
          continue;
        }
        j = 0;
        k = 2;
        continue;
        k -= 1;
        continue;
      }
      break;
      label1441:
      int k = 2;
    }
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    int i = 0;
    label69:
    boolean bool2;
    label85:
    boolean bool3;
    if (paramMessageRecord.msgtype == 64536)
    {
      localObject1 = MessageProtoCodec.a((MessageForText)paramMessageRecord);
      i = ((MessageForText)paramMessageRecord).msgVia;
      if ((localObject1 != null) && (((im_msg_body.RichText)localObject1).elems != null) && (paramArrayList != null) && (paramArrayList.size() != 0)) {
        break label239;
      }
      if (QLog.isColorLevel())
      {
        if (localObject1 != null) {
          break label215;
        }
        bool1 = true;
        if ((localObject1 == null) || (((im_msg_body.RichText)localObject1).elems != null)) {
          break label221;
        }
        bool2 = true;
        if (paramArrayList != null) {
          break label227;
        }
        bool3 = true;
        label92:
        if ((paramArrayList == null) || (paramArrayList.size() != 0)) {
          break label233;
        }
      }
    }
    label215:
    label221:
    label227:
    label233:
    for (boolean bool4 = true;; bool4 = false)
    {
      QLog.d("Q.msg.MessageHandlerUtils", 2, String.format("getPbSendReqFromBlessMsg, error: %s, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
      return null;
      if (paramMessageRecord.msgtype == 63514)
      {
        localObject1 = MessageProtoCodec.a((MessageForShortVideo)paramMessageRecord);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "getPbSendReqFromBlessMsg, error msgtype, " + paramMessageRecord.msgtype);
      }
      return null;
      bool1 = false;
      break label69;
      bool2 = false;
      break label85;
      bool3 = false;
      break label92;
    }
    label239:
    Object localObject2 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.BlessingMessage();
    ((im_msg_body.BlessingMessage)localObject3).uint32_msg_type.set(1);
    ((im_msg_body.Elem)localObject2).bless_msg.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    localObject2 = new im_msg_body.MsgBody();
    ((im_msg_body.MsgBody)localObject2).rich_text.set((MessageMicro)localObject1);
    Object localObject1 = new msg_svc.MultiMsgAssist();
    ((msg_svc.MultiMsgAssist)localObject1).msg_use.set(1);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject3 = (String)paramArrayList.next();
      msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
      msg_svc.C2C localC2C = new msg_svc.C2C();
      localC2C.to_uin.set(Long.valueOf((String)localObject3).longValue());
      localRoutingHead.c2c.set(localC2C);
      ((msg_svc.MultiMsgAssist)localObject1).repeated_routing.add(localRoutingHead);
    }
    if (paramHongbaoParams != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, String.format("getPbSendReqFromBlessMsg, hongbao param, temp_id: %d, video_len: %d, redbag_id: %s, redbag_amount: %d, has_readbag: %d, has_video: %d", new Object[] { Long.valueOf(paramHongbaoParams.jdField_a_of_type_Long), Long.valueOf(paramHongbaoParams.jdField_b_of_type_Long), paramHongbaoParams.jdField_a_of_type_ArrayOfByte, Long.valueOf(paramHongbaoParams.c), Integer.valueOf(paramHongbaoParams.jdField_a_of_type_Int), Integer.valueOf(paramHongbaoParams.jdField_b_of_type_Int) }));
      }
      ((msg_svc.MultiMsgAssist)localObject1).uint64_temp_id.set(paramHongbaoParams.jdField_a_of_type_Long);
      ((msg_svc.MultiMsgAssist)localObject1).uint64_vedio_len.set(paramHongbaoParams.jdField_b_of_type_Long);
      ((msg_svc.MultiMsgAssist)localObject1).uint32_has_readbag.set(paramHongbaoParams.jdField_a_of_type_Int);
      if (paramHongbaoParams.jdField_a_of_type_Int == 1)
      {
        if (paramHongbaoParams.jdField_a_of_type_ArrayOfByte != null) {
          ((msg_svc.MultiMsgAssist)localObject1).bytes_redbag_id.set(ByteStringMicro.copyFrom(paramHongbaoParams.jdField_a_of_type_ArrayOfByte));
        }
        ((msg_svc.MultiMsgAssist)localObject1).uint64_redbag_amount.set(paramHongbaoParams.c);
      }
      ((msg_svc.MultiMsgAssist)localObject1).uint32_has_vedio.set(paramHongbaoParams.jdField_b_of_type_Int);
    }
    int j = MessageUtils.a(paramMessageRecord.msgUid);
    int k = (short)(int)paramMessageRecord.msgseq;
    paramHongbaoParams = paramQQAppInterface.a().a();
    paramArrayList = new msg_svc.PbSendMsgReq();
    paramArrayList.msg_body.set((MessageMicro)localObject2);
    paramArrayList.msg_seq.set(k & 0xFFFF);
    paramArrayList.msg_rand.set(j);
    paramArrayList.msg_via.set(i);
    paramArrayList.multi_msg_assist.set((MessageMicro)localObject1);
    if (paramHongbaoParams != null) {
      paramArrayList.sync_cookie.set(ByteStringMicro.copyFrom(paramHongbaoParams));
    }
    if (paramArrayList != null)
    {
      i = paramArrayList.toByteArray().length;
      paramHongbaoParams = (SVIPHandler)paramQQAppInterface.a(13);
      j = paramHongbaoParams.f();
      paramQQAppInterface = (BubbleManager)paramQQAppInterface.getManager(43);
      k = paramHongbaoParams.e();
      bool1 = false;
      if (k > 0)
      {
        paramQQAppInterface = paramQQAppInterface.a(k, false);
        if ((paramQQAppInterface != null) && ((paramQQAppInterface == null) || (paramQQAppInterface.a == null))) {
          break label964;
        }
      }
    }
    label964:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "bubbleId->" + k + " needSend->" + bool1);
      }
      if ((bool1) && ((j <= 0) || ((i + 7 < j) && (j > 0))) && (paramMessageRecord.vipBubbleDiyTextId > 0) && (paramArrayList.msg_body.has()) && (((im_msg_body.MsgBody)paramArrayList.msg_body.get()).rich_text.has()))
      {
        paramQQAppInterface = (im_msg_body.RichText)((im_msg_body.MsgBody)paramArrayList.msg_body.get()).rich_text.get();
        if ((paramQQAppInterface.elems != null) && (paramQQAppInterface.elems.has()))
        {
          paramHongbaoParams = new im_msg_body.Elem();
          localObject1 = new im_msg_body.GeneralFlags();
          ((im_msg_body.GeneralFlags)localObject1).uint32_bubble_diy_text_id.set(paramMessageRecord.vipBubbleDiyTextId);
          paramHongbaoParams.general_flags.set((MessageMicro)localObject1);
          paramQQAppInterface.elems.get().add(paramHongbaoParams);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "add BubbleDiyTextId!");
          }
        }
      }
      return paramArrayList;
    }
  }
  
  private static im_msg_body.GeneralFlags a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    int i;
    int j;
    int k;
    boolean bool;
    if (paramPbSendMsgReq != null)
    {
      i = paramPbSendMsgReq.toByteArray().length;
      Object localObject = (SVIPHandler)paramQQAppInterface.a(13);
      j = ((SVIPHandler)localObject).f();
      BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(43);
      k = ((SVIPHandler)localObject).e();
      if (k <= 0) {
        break label554;
      }
      localObject = localBubbleManager.a(k, false);
      if ((localObject == null) || ((localObject != null) && (((BubbleConfig)localObject).a != null))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "bubbleId->" + k + " needSend->" + bool);
      }
      if ((bool) && ((j <= 0) || ((i + 7 < j) && (j > 0))) && (paramMessageRecord.vipBubbleDiyTextId > 0) && (paramPbSendMsgReq.msg_body.has()) && (((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.has()))
      {
        paramPbSendMsgReq = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
        if ((paramPbSendMsgReq.elems != null) && (paramPbSendMsgReq.elems.has()))
        {
          localGeneralFlags.uint32_bubble_diy_text_id.set(paramMessageRecord.vipBubbleDiyTextId);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "add BubbleDiyTextId!");
          }
        }
      }
      for (i = 1;; i = 0)
      {
        j = i;
        label336:
        long l;
        if ((paramMessageRecord instanceof MessageForFoldMsg))
        {
          j = i;
          if (PasswdRedBagManager.a(paramQQAppInterface))
          {
            paramQQAppInterface = (MessageForFoldMsg)paramMessageRecord;
            if (paramQQAppInterface.redBagId != null)
            {
              localGeneralFlags.uint64_uin.set(paramQQAppInterface.mPasswdRedBagSender);
              localGeneralFlags.bytes_rp_id.set(ByteStringMicro.copyFromUtf8(paramQQAppInterface.redBagId));
              paramPbSendMsgReq = localGeneralFlags.uint32_prp_fold;
              if (!paramQQAppInterface.foldFlagTemp) {
                break label534;
              }
              i = 1;
              paramPbSendMsgReq.set(i);
              i = 1;
            }
            j = i;
            if (QLog.isColorLevel())
            {
              l = paramQQAppInterface.mPasswdRedBagSender;
              if (!paramQQAppInterface.foldFlagTemp) {
                break label540;
              }
            }
          }
        }
        label534:
        label540:
        for (j = 1;; j = 0)
        {
          QLog.d("msgFold", 2, String.format("Send, pack foldMsg, senderUin: %d, foldFlag: %s, redBagId: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramQQAppInterface.redBagId }));
          QLog.d("msgFold", 2, String.format("Send, send foldMsg, frienduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { paramQQAppInterface.frienduin, Long.valueOf(paramQQAppInterface.msgUid), Long.valueOf(paramQQAppInterface.shmsgseq), paramQQAppInterface.getLogColorContent() }));
          j = i;
          i = j;
          if ((paramMessageRecord instanceof MessageForLongTextMsg))
          {
            paramQQAppInterface = (MessageForLongTextMsg)paramMessageRecord;
            i = j;
            if (paramQQAppInterface.structingMsg != null)
            {
              localGeneralFlags.long_text_flag.set(1);
              localGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramQQAppInterface.structingMsg.mResid));
              i = 1;
            }
          }
          if (i == 0) {
            break label546;
          }
          return localGeneralFlags;
          bool = false;
          break;
          i = 0;
          break label336;
        }
        label546:
        return null;
      }
      label554:
      bool = false;
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(paramString1, 2, "<" + paramString2 + paramLong);
      paramString3 = paramLong + "|" + paramString3 + "|" + paramString4;
      if (paramString2 != null) {
        QLog.d(paramString1, 2, paramString2 + paramString3);
      }
    }
  }
  
  public static void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 1)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (MessageUtils.a(localMessageRecord)) {
        if (((i <= 0) || (((MessageRecord)paramList.get(i - 1)).shmsgseq != localMessageRecord.shmsgseq)) && ((i >= paramList.size() - 1) || (((MessageRecord)paramList.get(i + 1)).shmsgseq != localMessageRecord.shmsgseq))) {
          break label138;
        }
      }
      label138:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          localArrayList.add(localMessageRecord);
        }
        i += 1;
        break;
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.a().b(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("------->msgFilter :msgIsTroop:").append(paramInt).append(",peerUin:").append(paramString1).append(",list size:");
      if (paramQQAppInterface != null) {
        break label183;
      }
    }
    label183:
    for (paramInt = 0;; paramInt = paramQQAppInterface.size())
    {
      QLog.d("Q.msg.MessageHandlerUtils", 2, paramInt);
      boolean bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (paramQQAppInterface.size() > 0)
        {
          paramQQAppInterface = paramQQAppInterface.iterator();
          do
          {
            bool1 = bool2;
            if (!paramQQAppInterface.hasNext()) {
              break;
            }
            paramString1 = (MessageRecord)paramQQAppInterface.next();
          } while ((Math.abs(paramString1.time - paramLong1) >= 30L) || (paramString1.shmsgseq != paramLong2) || (!paramString1.senderuin.equals(paramString2)));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "------->msgFilter-duplicated msg.");
          }
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.msg == null) && (paramMessageRecord.msgData == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
      return true;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("---------------msgFilter istroop: ").append(paramMessageRecord.istroop).append(" shmsgseq: ").append(paramMessageRecord.shmsgseq).append(" friendUin: ").append(paramMessageRecord.frienduin).append(" senderUin: ").append(paramMessageRecord.senderuin).append(" msgType: ").append(paramMessageRecord.msgtype).append(" time:").append(paramMessageRecord.time).append(" msgContent: ").append(paramMessageRecord.getLogColorContent());
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      int j;
      int i;
      if (paramQQAppInterface == null)
      {
        j = 0;
        if (j <= 15) {
          break label288;
        }
        i = j - 15;
      }
      for (;;)
      {
        if (i >= j) {
          break label303;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.get(i);
        if ((localMessageRecord != null) && (localMessageRecord.msgtype == paramMessageRecord.msgtype) && (Utils.a(localMessageRecord.msg, paramMessageRecord.msg)))
        {
          if ((QLog.isColorLevel()) && (localStringBuilder != null))
          {
            localStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
          }
          MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
          return true;
          j = paramQQAppInterface.size();
          break;
          label288:
          i = 0;
          continue;
        }
        i += 1;
      }
      label303:
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
      }
      MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
      return false;
      localStringBuilder = null;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.msg == null) && (paramMessageRecord.msgData == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
      return true;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("---------------msgFilter istroop: ").append(paramMessageRecord.istroop).append(" shmsgseq: ").append(paramMessageRecord.shmsgseq).append(" friendUin: ").append(paramMessageRecord.frienduin).append(" senderUin: ").append(paramMessageRecord.senderuin).append(" msgType: ").append(paramMessageRecord.msgtype).append(" time:").append(paramMessageRecord.time).append(" msgContent: ").append(paramMessageRecord.getLogColorContent()).append(" isNormalMsg: ").append(paramBoolean);
    }
    for (;;)
    {
      Object localObject = paramQQAppInterface.a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 1026) || (paramMessageRecord.istroop == 3000))
      {
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (MsgProxyUtils.a((MessageRecord)((Iterator)localObject).next(), paramMessageRecord, false, paramBoolean))
            {
              if ((QLog.isColorLevel()) && (localStringBuilder != null))
              {
                localStringBuilder.append(" filterType: troop msg isNormalMsg=" + paramBoolean);
                QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
              }
              MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
              return true;
            }
          }
        }
        if (paramQQAppInterface.a().f(paramMessageRecord)) {
          return true;
        }
      }
      else if (MsgProxyUtils.c(paramMessageRecord.istroop))
      {
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (MsgProxyUtils.a((MessageRecord)((Iterator)localObject).next(), paramMessageRecord, paramBoolean))
            {
              if ((QLog.isColorLevel()) && (localStringBuilder != null))
              {
                localStringBuilder.append(" filterType: " + paramMessageRecord.istroop);
                QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
              }
              MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
              return true;
            }
          }
        }
        if (paramQQAppInterface.a().f(paramMessageRecord)) {
          return true;
        }
      }
      else if (paramMessageRecord.istroop == 7220)
      {
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramQQAppInterface = ((List)localObject).iterator();
          do
          {
            if (!paramQQAppInterface.hasNext()) {
              break;
            }
          } while (!MsgProxyUtils.a((MessageRecord)paramQQAppInterface.next(), paramMessageRecord, true));
          if ((QLog.isColorLevel()) && (localStringBuilder != null))
          {
            localStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
          }
          MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
          return true;
        }
      }
      else if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramQQAppInterface = ((List)localObject).iterator();
        while (paramQQAppInterface.hasNext())
        {
          localObject = (MessageRecord)paramQQAppInterface.next();
          if ((((MessageRecord)localObject).time == paramMessageRecord.time) && (((MessageRecord)localObject).msg.equals(paramMessageRecord.msg)))
          {
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append(" filterType: other");
              QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
            }
            MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
            return true;
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
      }
      MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
      return false;
      localStringBuilder = null;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    return false;
  }
  
  public static boolean a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String[] a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return null;
    }
    String[] arrayOfString = new String[7];
    long l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    long l6 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atAppSite", 0L);
    long l5 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atMsfSite", 0L);
    long l8 = paramFromServiceMsg.extraData.getLong("timestamp_msf2net_atMsfSite", 0L);
    long l3 = paramFromServiceMsg.extraData.getLong("timestamp_net2msf_atMsfSite", 0L);
    long l4 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atMsfSite", 0L);
    long l2 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atAppSite", 0L);
    long l7 = System.currentTimeMillis();
    arrayOfString[1] = String.valueOf(l7 - l1);
    arrayOfString[2] = String.valueOf(l3 - l8);
    arrayOfString[3] = String.valueOf(l8 - l1);
    arrayOfString[4] = String.valueOf(l7 - l3);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handler");
    if (l6 != 0L)
    {
      paramToServiceMsg.append("|").append(String.valueOf(l6 - l1)).append("|app");
      l1 = l6;
    }
    for (;;)
    {
      if (l5 != 0L)
      {
        paramToServiceMsg.append("|").append(String.valueOf(l5 - l1)).append("|msf");
        l1 = l5;
      }
      for (;;)
      {
        if (l8 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l8 - l1)).append("|net");
        }
        arrayOfString[5] = paramToServiceMsg.toString();
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("net");
        if (l4 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l4 - l3)).append("|msf");
        }
        for (l1 = l4;; l1 = l3)
        {
          if (l2 != 0L)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l2 - l1)).append("|app");
            l1 = l2;
          }
          for (;;)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l7 - l1)).append("|handler");
            arrayOfString[6] = paramToServiceMsg.toString();
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("{");
            paramToServiceMsg.append("total:").append(arrayOfString[1]).append(",");
            paramToServiceMsg.append("net:").append(arrayOfString[2]).append(",");
            paramToServiceMsg.append("send:").append(arrayOfString[3]).append(",");
            paramToServiceMsg.append("recv:").append(arrayOfString[4]).append(",");
            paramToServiceMsg.append("sendDetail:").append(arrayOfString[5]).append(",");
            paramToServiceMsg.append("recvDetail:").append(arrayOfString[6]);
            paramToServiceMsg.append("}");
            arrayOfString[0] = paramToServiceMsg.toString();
            return arrayOfString;
          }
        }
      }
    }
  }
  
  public static boolean b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.msgtype == 63530) && ((localMessageRecord instanceof MessageForFoldMsg)));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\MessageHandlerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */