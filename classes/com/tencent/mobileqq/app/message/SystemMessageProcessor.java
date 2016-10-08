package com.tencent.mobileqq.app.message;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import qmk;
import qml;
import qmm;
import qmn;
import qmo;
import qmp;
import qmq;
import qmr;
import qms;
import qmt;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelDecideInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelMsgInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelUnDecideInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.ReqBody;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.RspBody;
import tencent.mobileim.structmsg.structmsg.FlagInfo;
import tencent.mobileim.structmsg.structmsg.ReqNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemMessageProcessor
  extends BaseMessageProcessor
{
  public static final String a = "getSystemMsgSender";
  private static final String c = "SystemMessageProcessor";
  public static final int e = 20;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Map jdField_a_of_type_JavaUtilMap;
  private int i;
  private int j;
  private int k;
  private final int l;
  private final int m;
  private final int n;
  
  public SystemMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.l = 2;
    this.m = 2;
    this.n = 2;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.av, 0);
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "mLocalDataList is null !");
      }
    }
    while ((localObject == null) || (((List)localObject).size() <= 0)) {
      return "";
    }
    localObject = (MessageForSystemMsg)((List)localObject).get(((List)localObject).size() - 1);
    ((MessageForSystemMsg)localObject).parse();
    return ((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get();
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "sendGroupSystemMsgToVideo-->msgType=" + paramInt + " troopUin=" + paramLong1 + " userUin=" + paramLong2);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.GroupSystemMsg");
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("relationType", 1);
    localIntent.putExtra("relationId", paramLong1);
    localIntent.putExtra("userUin", paramLong2);
    if ((paramInt == 3) || (paramInt == 15)) {
      localIntent.putExtra("needSendCmd", true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i1 = paramToServiceMsg.extraData.getInt("type");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label123;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label123;
      }
    }
    label123:
    while ((480000L != l4) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReportError type=" + i1 + ";reqSeq=" + l3 + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (paramRspSystemMsgNew != null)
    {
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, "rspSystemMsg.head.result.get()" + paramRspSystemMsgNew.head.result.get());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label133:
    do
    {
      return;
      try
      {
        paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
        try
        {
          paramRspSystemMsgNew.mergeFrom((byte[])paramObject);
        }
        catch (Exception localException1)
        {
          paramObject = paramRspSystemMsgNew;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject;
          int i3;
          int i4;
          int i1;
          int i2;
          boolean bool1;
          MessageRecord localMessageRecord;
          MessageForSystemMsg localMessageForSystemMsg;
          int i5;
          int i6;
          boolean bool2;
          paramObject = null;
          continue;
          long l1 = 0L;
          continue;
          paramToServiceMsg = "";
        }
      }
      paramRspSystemMsgNew = (structmsg.RspSystemMsgNew)paramObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb error:", localException1);
      paramRspSystemMsgNew = (structmsg.RspSystemMsgNew)paramObject;
      break;
      localObject = paramRspSystemMsgNew.friendmsgs.get();
      i3 = ((List)localObject).size();
      i4 = paramRspSystemMsgNew.unread_friend_count.get();
      paramObject = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      i1 = ((NewFriendManager)paramObject).a();
      i2 = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "processFriendSystemMsg-->requestFrom:" + i2);
      }
      if ((i4 == 0) && (i3 == 0) && (i2 == 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.av, 0);
        ((NewFriendManager)paramObject).a();
        a(4014, true, null);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder(128);
        paramToServiceMsg.append("<---handleGetFriendSystemMsgResp : decode pb MsgsSize = ").append(i3).append(" latest_friend_seq").append(paramRspSystemMsgNew.latest_friend_seq.get()).append(" latest_group_seq").append(paramRspSystemMsgNew.latest_group_seq.get()).append(" following_friend_seq").append(paramRspSystemMsgNew.following_friend_seq.get()).append(" following_group_seq").append(paramRspSystemMsgNew.following_group_seq.get()).append(" unreadCount").append(i4).append(" localunreadCount").append(i1);
        QLog.d("Q.systemmsg.", 2, paramToServiceMsg.toString());
      }
      if (!paramRspSystemMsgNew.msg_display.has()) {
        break label1180;
      }
      paramToServiceMsg = paramRspSystemMsgNew.msg_display.get();
      if (((List)localObject).size() <= 0) {
        break label1174;
      }
      l1 = ((structmsg.StructMsg)((List)localObject).get(0)).msg_time.get();
      this.i = 0;
      i2 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47") != paramRspSystemMsgNew.latest_friend_seq.get()) {
        break label592;
      }
      if ((i4 == 0) || (l1 != 0L)) {
        break label535;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SystemMessageProcessor", 2, "sentSeq == respSeq | unreadCount = " + i4 + " | newFriendLastMsgTime = 0");
    return;
    label535:
    paramFromServiceMsg = paramToServiceMsg;
    if (TextUtils.isEmpty(paramToServiceMsg)) {
      paramFromServiceMsg = a();
    }
    if ((i1 != i4) && (i4 == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.av, 0, true, true);
    }
    ((NewFriendManager)paramObject).a(new FriendSystemMessage(paramFromServiceMsg, l1));
    return;
    label592:
    i1 = i2;
    if (i4 == 0)
    {
      i1 = i2;
      if (i3 == 0) {
        i1 = 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47", paramRspSystemMsgNew.latest_friend_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47", paramRspSystemMsgNew.following_friend_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.av, 0, true, false);
    FriendSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i1 == 0)
    {
      paramRspSystemMsgNew = new ArrayList(i3);
      if (paramFromServiceMsg.getUin() == null)
      {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        i1 = 0;
        if (i4 <= 0) {
          break label1000;
        }
        bool1 = true;
        label725:
        i2 = 0;
        label728:
        if (i2 >= i3) {
          break label1047;
        }
        localMessageRecord = MessageRecordFactory.a(63486);
        localMessageRecord.msgtype = 63486;
        localMessageRecord.selfuin = paramFromServiceMsg;
        localMessageRecord.frienduin = AppConstants.av;
        localMessageRecord.senderuin = (((structmsg.StructMsg)((List)localObject).get(i2)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        localMessageRecord.time = ((structmsg.StructMsg)((List)localObject).get(i2)).msg_time.get();
        localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject).get(i2)).get());
        i5 = localMessageForSystemMsg.structMsg.msg_type.get();
        i6 = localMessageForSystemMsg.structMsg.msg.sub_type.get();
        bool2 = bool1;
        if (i2 == 0)
        {
          localMessageRecord.extStr = paramToServiceMsg;
          bool2 = bool1;
          if (i6 == 13) {
            bool2 = false;
          }
        }
        if ((i1 >= i4) || (i6 == 13)) {
          break label1006;
        }
        localMessageForSystemMsg.isread = false;
        i1 += 1;
        label949:
        if ((i5 != 1) || (SystemMsgUtils.a(i6))) {
          break label1015;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
        }
      }
      for (;;)
      {
        i2 += 1;
        bool1 = bool2;
        break label728;
        paramFromServiceMsg = paramFromServiceMsg.getUin();
        break;
        label1000:
        bool1 = false;
        break label725;
        label1006:
        localMessageForSystemMsg.isread = true;
        break label949;
        label1015:
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        ((ChatMessage)localMessageRecord).parse();
        paramRspSystemMsgNew.add(localMessageForSystemMsg);
      }
      label1047:
      if (paramRspSystemMsgNew.size() > 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramFromServiceMsg = String.valueOf(paramFromServiceMsg);
        if ((MessageHandlerUtils.a(paramRspSystemMsgNew)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))
        {
          bool2 = true;
          ((QQMessageFacade)localObject).a(paramRspSystemMsgNew, paramFromServiceMsg, bool2);
          ((NewFriendManager)paramObject).b();
          a(paramRspSystemMsgNew);
          a("handleGetSystemMsgResp", true, i4, bool1, false);
          label1123:
          ((NewFriendManager)paramObject).a(new FriendSystemMessage(paramToServiceMsg, l1));
        }
      }
    }
    for (;;)
    {
      a(4005, true, null);
      return;
      bool2 = false;
      break;
      ((NewFriendManager)paramObject).b();
      break label1123;
      ((NewFriendManager)paramObject).a();
    }
  }
  
  private void a(List paramList)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.an, 4000);
    localRecentUser.msgType = 15;
    localRecentUser.displayName = "新朋友";
    Object localObject = (MessageForSystemMsg)paramList.get(0);
    ((MessageForSystemMsg)localObject).parse();
    if (!TextUtils.isEmpty(((MessageForSystemMsg)localObject).extStr)) {}
    for (String str = ((MessageForSystemMsg)localObject).extStr;; str = ((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get())
    {
      localRecentUser.lastmsgtime = ((MessageForSystemMsg)localObject).time;
      localRecentUser.msgData = str.getBytes();
      localRecentUser.msg = str;
      localRecentUser.reParse();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("mDataList.size() ").append(paramList.size()).append(" | msg = ");
        paramList = str;
        if (TextUtils.isEmpty(str)) {
          paramList = "";
        }
        QLog.d("SystemMessageProcessor", 2, paramList);
      }
      localRecentUserProxy.a(localRecentUser);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    }
    Object localObject2;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new structmsg.RspSystemMsgNew();
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        ((structmsg.RspSystemMsgNew)localObject1).mergeFrom((byte[])paramObject);
        localObject2 = localObject1;
        localObject1 = new StringBuilder();
        if ((localObject2 != null) && (((structmsg.RspSystemMsgNew)localObject2).head.result.get() == 0)) {
          break;
        }
        ((StringBuilder)localObject1).setLength(0);
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      paramFromServiceMsg.getUin();
      continue;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgRespNew : decode pb error:", localException1);
        localObject2 = localObject1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SystemMessageProcessor", 2, "SystemMessageProcessor: listsize");
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, (structmsg.RspSystemMsgNew)localObject2);
    b(paramToServiceMsg, paramFromServiceMsg, paramObject, (structmsg.RspSystemMsgNew)localObject2);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SystemMessageProcessor", 4, "processGroupSystemMsg");
    }
    int i3 = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
    i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->requestFrom:" + i3);
    }
    String str;
    if (paramFromServiceMsg.getUin() == null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (paramRspSystemMsgNew == null) {
        break label187;
      }
      label83:
      if ((paramRspSystemMsgNew != null) && (!TextUtils.isEmpty(paramRspSystemMsgNew.grp_msg_display.get()))) {
        GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew.grp_msg_display.get());
      }
      paramObject = new StringBuilder();
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break label243;
      }
      ((StringBuilder)paramObject).setLength(0);
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, ((StringBuilder)paramObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label187:
    label243:
    do
    {
      return;
      str = paramFromServiceMsg.getUin();
      break;
      try
      {
        paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
        try
        {
          paramRspSystemMsgNew.mergeFrom((byte[])paramObject);
        }
        catch (Exception localException1)
        {
          paramObject = paramRspSystemMsgNew;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i4;
          int i5;
          int i2;
          int i6;
          int i7;
          Object localObject1;
          int i8;
          Object localObject2;
          Object localObject3;
          boolean bool;
          paramObject = null;
          continue;
          long l2 = -1L;
          continue;
          long l1 = -1L;
          continue;
          i1 = -1;
        }
      }
      paramRspSystemMsgNew = (structmsg.RspSystemMsgNew)paramObject;
      if (!QLog.isColorLevel()) {
        break label83;
      }
      QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", localException1);
      paramRspSystemMsgNew = (structmsg.RspSystemMsgNew)paramObject;
      break label83;
      paramToServiceMsg = paramRspSystemMsgNew.groupmsgs.get();
      i4 = paramToServiceMsg.size();
      i5 = paramRspSystemMsgNew.unread_group_count.get();
      i2 = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = " + i4 + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get() + " unreadCount" + i5 + " localUnreadCount" + i2);
      }
    } while (i4 == 0);
    this.i = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i5);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.aC, 9000, i5 - i2);
    paramFromServiceMsg = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.aw, 0, true, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.az, 0, true, false);
    GroupSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Collections.sort(paramToServiceMsg, new qmk(this));
    i2 = 0;
    if (i2 < i4)
    {
      paramObject = MessageRecordFactory.a(63518);
      ((MessageRecord)paramObject).msgtype = 63518;
      ((MessageRecord)paramObject).selfuin = str;
      ((MessageRecord)paramObject).frienduin = AppConstants.aw;
      i6 = ((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.group_msg_type.get();
      i7 = TroopUtils.a(i6);
      if (i7 == 1) {
        ((MessageRecord)paramObject).senderuin = (((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.action_uin.get() + "");
      }
      for (;;)
      {
        ((MessageRecord)paramObject).istroop = 0;
        localObject1 = (MessageForSystemMsg)paramObject;
        ((MessageForSystemMsg)localObject1).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramToServiceMsg.get(i2)).get());
        i7 = ((MessageForSystemMsg)localObject1).structMsg.msg_type.get();
        i8 = ((MessageForSystemMsg)localObject1).structMsg.msg.sub_type.get();
        if ((i7 != 1) || (SystemMsgUtils.a(i8))) {
          break label802;
        }
        i2 += 1;
        break;
        if (i7 == 2) {
          ((MessageRecord)paramObject).senderuin = (((structmsg.StructMsg)paramToServiceMsg.get(i2)).req_uin.get() + "");
        }
      }
      label802:
      if ((i6 == 2) && (i8 == 2) && (a(String.valueOf(((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.group_code.get()), ((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg_seq.get())) && (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.group_code.get(), String.valueOf(((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.action_uin.get()))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + i2 + ":addFriendTipsMr");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.group_code.get() + "", 1, -1L, 10004, true);
        localObject2 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
        if (localObject2 != null) {
          ((TroopHandler)localObject2).a(String.valueOf(((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.group_code.get()), Boolean.valueOf(false));
        }
      }
      if (i8 == 1) {
        ((MessageRecord)paramObject).senderuin = (((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.action_uin.get() + "");
      }
      if ((i3 == 1) && (i1 == 0))
      {
        if (i6 == 3)
        {
          localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          localObject2 = ((TroopManager)localObject3).a(((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.group_code.get() + "");
          if (localObject2 != null)
          {
            ((TroopInfo)localObject2).dwCmdUinUinFlag = 1L;
            if (((TroopInfo)localObject2).Administrator == null) {
              break label1640;
            }
            if (((TroopInfo)localObject2).Administrator.startsWith("|")) {
              ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(1);
            }
            if (((TroopInfo)localObject2).Administrator.endsWith("|")) {
              ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(0, ((TroopInfo)localObject2).Administrator.length() - 1);
            }
            label1269:
            if (!((TroopInfo)localObject2).Administrator.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
              ((TroopInfo)localObject2).Administrator = (((TroopInfo)localObject2).Administrator + "|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
            ((TroopManager)localObject3).b((TroopInfo)localObject2);
            localObject3 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if (localObject3 != null) {
              ((TroopHandler)localObject3).b(Long.parseLong(((TroopInfo)localObject2).troopuin));
            }
          }
        }
        label1640:
        do
        {
          do
          {
            if ((i6 == 13) || (i6 == 6) || (i6 == 7))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + i2 + ",msgTime:" + ((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg_time + ",msgType:" + i6 + ":delete troopMember, delete troop, clear local history");
              }
              localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              if (localObject2 != null)
              {
                localObject3 = ((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.group_code.get() + "";
                ((TroopManager)localObject2).b((String)localObject3, ((structmsg.StructMsg)paramToServiceMsg.get(i2)).req_uin.get() + "");
                if (i6 == 7)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject3, 1);
                  ((TroopManager)localObject2).a((String)localObject3);
                  DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
              }
            }
            i1 = 1;
            ((MessageRecord)paramObject).msgData = ((MessageForSystemMsg)localObject1).structMsg.toByteArray();
            paramFromServiceMsg.add(localObject1);
            break;
            ((TroopInfo)localObject2).Administrator = "";
            break label1269;
          } while (i6 != 15);
          localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          localObject3 = ((TroopManager)localObject2).a(((structmsg.StructMsg)paramToServiceMsg.get(i2)).msg.group_code.get() + "");
        } while (localObject3 == null);
        ((TroopInfo)localObject3).dwCmdUinUinFlag = 0L;
        if (((TroopInfo)localObject3).Administrator != null)
        {
          if (((TroopInfo)localObject3).Administrator.startsWith("|")) {
            ((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(1);
          }
          if (!((TroopInfo)localObject3).Administrator.endsWith("|")) {}
        }
        for (((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(0, ((TroopInfo)localObject3).Administrator.length() - 1);; ((TroopInfo)localObject3).Administrator = "")
        {
          ((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "|", "").replace("|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "").replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
          ((TroopManager)localObject2).b((TroopInfo)localObject3);
          break;
        }
      }
    }
    else
    {
      if (paramFromServiceMsg.size() > 0)
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = String.valueOf(str);
        if ((!MessageHandlerUtils.a(paramFromServiceMsg)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
          break label2386;
        }
      }
      label2386:
      for (bool = true;; bool = false)
      {
        ((QQMessageFacade)paramObject).a(paramFromServiceMsg, (String)localObject1, bool);
        a("handleGetSystemMsgResp", true, i5, false, false);
        if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
        {
          paramRspSystemMsgNew = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
          paramObject = MessageRecordFactory.a(63518);
          ((MessageRecord)paramObject).selfuin = str;
          ((MessageRecord)paramObject).frienduin = AppConstants.az;
          ((MessageRecord)paramObject).senderuin = (paramRspSystemMsgNew.req_uin.get() + "");
          ((MessageRecord)paramObject).istroop = 0;
          localObject1 = (MessageForSystemMsg)paramObject;
          ((MessageForSystemMsg)localObject1).structMsg = paramRspSystemMsgNew;
          ((MessageRecord)paramObject).msgData = ((MessageForSystemMsg)localObject1).structMsg.toByteArray();
          paramRspSystemMsgNew = new ArrayList();
          paramRspSystemMsgNew.add(paramObject);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspSystemMsgNew, String.valueOf(str), true);
          if (QLog.isColorLevel()) {
            QLog.d("Q.systemmsg.", 2, "ribbon info");
          }
        }
        paramObject = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
        paramFromServiceMsg = ((MessageForSystemMsg)paramFromServiceMsg.get(0)).getSystemMsg();
        GroupSystemMsgController.a().a(paramFromServiceMsg);
        l1 = paramFromServiceMsg.msg_time.get();
        ((RecentManagerFor3rdPart)paramObject).a(AppConstants.aC, 9000, "群通知", l1, l1);
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.sendMessage(paramFromServiceMsg.obtainMessage(1009));
        }
        paramToServiceMsg = (structmsg.StructMsg)paramToServiceMsg.get(0);
        if (paramToServiceMsg.msg.has())
        {
          if (!((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.has()) {
            break label2415;
          }
          i1 = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.get();
          if (!((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.has()) {
            break label2407;
          }
          l1 = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.get();
          if (!paramToServiceMsg.req_uin.has()) {
            break;
          }
          l2 = paramToServiceMsg.req_uin.get();
          if ((i1 != -1) && (l2 != -1L) && (l1 != -1L)) {
            a(i1, l1, l2);
          }
        }
        a(4005, true, null);
        this.jdField_a_of_type_JavaUtilMap.clear();
        return;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i1 = paramToServiceMsg.extraData.getInt("type");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3) == null) {}
    for (;;)
    {
      return;
      if (paramObject == null) {
        continue;
      }
      paramToServiceMsg = new structmsg.RspSystemMsgRead();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          continue;
        }
        int i2 = paramToServiceMsg.head.result.get();
        if (i2 == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReport type =" + i1 + ";reqSeq=" + l3 + ";resultCode=" + i2 + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgReadedReport :type = " + i1 + " decode pb:", paramFromServiceMsg);
          }
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new structmsg.RspSystemMsgAction();
      }
      catch (Exception paramObject)
      {
        int i1;
        paramFromServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgAction : decode pb:", (Throwable)paramObject);
        }
        continue;
        String str = paramFromServiceMsg.head.msg_fail.get();
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_error_key", (String)paramObject);
        bool = false;
        continue;
      }
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label300;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgAction result id=" + paramFromServiceMsg.head.result.get());
        }
        if (paramFromServiceMsg.head.result.get() != 0) {
          continue;
        }
        bool = true;
        str = paramFromServiceMsg.msg_detail.get();
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        i1 = -1;
        if (paramFromServiceMsg.remark_result.has()) {
          i1 = paramFromServiceMsg.remark_result.get();
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_key", (String)paramObject);
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", paramFromServiceMsg.head.result.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", paramFromServiceMsg.type.get());
        paramToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", paramFromServiceMsg.msg_invalid_decided.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i1);
      }
      catch (Exception paramObject)
      {
        continue;
        bool = false;
        continue;
      }
      a(4011, bool, paramToServiceMsg);
      return;
      paramFromServiceMsg.getUin();
    }
  }
  
  private void h()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
      }
      return;
    }
    finally {}
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l1);
    localReqSystemMsgRead.latest_group_seq.set(l2);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "sendSystemMsgReadedReport latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new qmn(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l2 = 0L;
    Object localObject1 = null;
    Object localObject2;
    int i1;
    structmsg.ReqSystemMsgNew localReqSystemMsgNew;
    PBUInt64Field localPBUInt64Field;
    switch (paramInt1)
    {
    default: 
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
      i1 = 0;
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---sendGetSystemMsg type=" + paramInt1 + " latest_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47") + " latest_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"));
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((String)localObject2);
      localReqSystemMsgNew = new structmsg.ReqSystemMsgNew();
      localReqSystemMsgNew.msg_num.set(20);
      localReqSystemMsgNew.checktype.set(i1);
      localPBUInt64Field = localReqSystemMsgNew.latest_friend_seq;
      if (paramBoolean)
      {
        l1 = 0L;
        label171:
        localPBUInt64Field.set(l1);
        localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
        if (!paramBoolean) {
          break label524;
        }
      }
      break;
    }
    label524:
    for (long l1 = l2;; l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"))
    {
      localPBUInt64Field.set(l1);
      if (localObject1 != null) {
        localReqSystemMsgNew.flag.set((MessageMicro)localObject1);
      }
      localReqSystemMsgNew.is_get_frd_ribbon.set(false);
      localReqSystemMsgNew.version.set(1000);
      localReqSystemMsgNew.is_get_grp_ribbon.set(false);
      localReqSystemMsgNew.friend_msg_type_flag.set(1L);
      ((ToServiceMsg)localObject2).extraData.putInt("getSystemMsgSender", paramInt2);
      ((ToServiceMsg)localObject2).putWupBuffer(localReqSystemMsgNew.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ToServiceMsg)localObject2);
      return;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
      i1 = 4;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_HiddenGrp.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_WordingDown.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetOfficialAccount.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetPayInGroup.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_GetBusiCard.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      break;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).FrdMsg_GetBusiCard.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Friend";
      i1 = 2;
      break;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Group";
      i1 = 3;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_HiddenGrp.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_WordingDown.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetOfficialAccount.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetPayInGroup.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      break;
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
      break label171;
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6, "");
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, String paramString)
  {
    long l1 = paramInt1 + paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + l1);
    }
    paramString = new structmsg.ReqSystemMsgAction();
    paramString.msg_type.set(paramInt1);
    paramString.msg_seq.set(paramLong1);
    paramString.req_uin.set(paramLong2);
    paramString.sub_type.set(paramInt2);
    paramString.src_id.set(paramInt3);
    paramString.sub_src_id.set(paramInt4);
    paramString.group_msg_type.set(paramInt5);
    paramString.action_info.set(paramSystemMsgActionInfo);
    paramString.language.set(1000);
    paramSystemMsgActionInfo = new ProtoReqManager.ProtoReq();
    paramSystemMsgActionInfo.a();
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Group";
    paramSystemMsgActionInfo.jdField_a_of_type_ArrayOfByte = paramString.toByteArray();
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsgAction.Group");
    paramString.addAttribute("_tag_LOGSTR", String.valueOf(l1));
    paramString.extraData.putInt("system_msg_action_type", paramInt6);
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangObject = paramString;
    paramSystemMsgActionInfo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new qml(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSystemMsgActionInfo);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    long l1 = paramInt1 + paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + l1);
    }
    Object localObject = new structmsg.ReqSystemMsgAction();
    ((structmsg.ReqSystemMsgAction)localObject).msg_type.set(paramInt1);
    ((structmsg.ReqSystemMsgAction)localObject).msg_seq.set(paramLong1);
    ((structmsg.ReqSystemMsgAction)localObject).req_uin.set(paramLong2);
    ((structmsg.ReqSystemMsgAction)localObject).sub_type.set(paramInt2);
    ((structmsg.ReqSystemMsgAction)localObject).src_id.set(paramInt3);
    ((structmsg.ReqSystemMsgAction)localObject).sub_src_id.set(paramInt4);
    ((structmsg.ReqSystemMsgAction)localObject).group_msg_type.set(paramInt5);
    ((structmsg.ReqSystemMsgAction)localObject).action_info.set(paramSystemMsgActionInfo);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.a();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsgAction.Friend");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l1));
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    ((ToServiceMsg)localObject).extraData.putBoolean("isUncommonlyUsedFrd", paramBoolean);
    localProtoReq.jdField_a_of_type_JavaLangObject = localObject;
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new qmm(this, paramInt6, paramInt3, paramSystemMsgActionInfo, paramStructMsg, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    case 6007: 
    default: 
      return;
    case 6002: 
      this.i = 0;
      return;
    case 6001: 
      this.j = 0;
      return;
    case 6003: 
      this.k = 0;
      return;
    case 6006: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    b(4015, false, paramToServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    default: 
      return;
    case 6002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6006: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6007: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    b(4015, false, null);
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2, long paramLong3, long paramLong4)
  {
    TroopInfo localTroopInfo;
    TroopHandler localTroopHandler;
    if ((paramInt == 85) || (paramInt == 36))
    {
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localTroopInfo = localTroopManager.a(String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte)));
      localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localTroopInfo != null) {
        break label202;
      }
      localTroopInfo = new TroopInfo();
      localTroopInfo.troopuin = String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte));
      localTroopInfo.troopcode = String.valueOf(paramLong2);
      localTroopManager.a(localTroopInfo);
      localTroopHandler.a(localTroopInfo.troopuin, (byte)1, localTroopInfo.dwTimeStamp, 0);
    }
    label202:
    for (paramArrayOfByte = localTroopInfo;; paramArrayOfByte = localTroopInfo)
    {
      localTroopHandler.a(paramArrayOfByte.troopuin, Boolean.valueOf(false));
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "handleTroopSystemMessageResp-->msgTime:" + paramLong3 + ":addFriendTipsMr");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramArrayOfByte.troopuin, 1, paramLong3, 10004, true);
      b(2001, true, null);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3)
  {
    String str = String.valueOf(paramLong2);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((paramInt1 == 188) || (paramInt1 == 189))
    {
      h();
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt3))) {}
    }
    while (paramInt1 != 190)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt3));
      str = String.valueOf(str);
      if (paramLong1 == paramLong2) {}
      for (boolean bool = true;; bool = false)
      {
        localFriendListHandler.a(str, 0, 10004, null, bool, false, paramLong3);
        return;
      }
    }
    localFriendsManager.a(str, false);
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt1, msg_comm.Msg paramMsg, int paramInt2)
  {
    String str = String.valueOf(paramLong2);
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((paramShort == 188) || (paramShort == 189))
    {
      h();
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt2))) {}
    }
    while (paramShort != 190)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt2));
      localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      localObject = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, HexUtil.a((byte[])localObject), String.valueOf(str), paramInt1);
      if (localObject != null) {}
      for (localObject = ((SystemMsg)localObject).strGameName;; localObject = "")
      {
        localFriendListHandler.a(String.valueOf(str), 0, 10004, (String)localObject, true, false, paramMsg.msg_head.msg_time.get());
        return;
      }
    }
    ((FriendsManager)localObject).a(str, false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      b(4015, false, null);
      return;
    }
    Oidb_0x5cf.RspBody localRspBody = new Oidb_0x5cf.RspBody();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i1 = MessageHandler.a(paramFromServiceMsg, paramObject, localRspBody);
    if (i1 == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("frienduin");
      i1 = paramToServiceMsg.extraData.getInt("istroop");
      long l1 = paramToServiceMsg.extraData.getLong("uniseq");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFromServiceMsg, i1, l1);
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---handleGetDelSingleSysMsg Success!");
      }
      b(4014, true, paramToServiceMsg);
      return;
    }
    if (i1 == 1)
    {
      b(4014, true, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---handleGetDelSingleSysMsg Error!");
    }
    b(4015, false, paramToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = paramString + "_" + paramLong;
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void a(structmsg.StructMsg paramStructMsg, String paramString, int paramInt, long paramLong)
  {
    Oidb_0x5cf.ReqBody localReqBody = new Oidb_0x5cf.ReqBody();
    Oidb_0x5cf.DelMsgInfo localDelMsgInfo = new Oidb_0x5cf.DelMsgInfo();
    localReqBody.uint32_version.set(1);
    localReqBody.uint32_type.set(9);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localReqBody.uint64_touin.set(Long.parseLong((String)localObject));
    localReqBody.fixed32_sequence.set((int)paramStructMsg.msg_seq.get());
    localDelMsgInfo.uint32_platform.set(2);
    if (paramStructMsg.msg.sub_type.get() < 2)
    {
      localObject = new Oidb_0x5cf.DelUnDecideInfo();
      ((Oidb_0x5cf.DelUnDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      localDelMsgInfo.rpt_msg_undecide_info.add((MessageMicro)localObject);
    }
    for (;;)
    {
      localReqBody.msg_del_msg_info.set(localDelMsgInfo);
      paramStructMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("OidbSvc.0x5cf_0", 1487, 0, localReqBody.toByteArray());
      paramStructMsg.extraData.putString("frienduin", paramString);
      paramStructMsg.extraData.putInt("istroop", paramInt);
      paramStructMsg.extraData.putLong("uniseq", paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramStructMsg);
      return;
      localObject = new Oidb_0x5cf.DelDecideInfo();
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_time.set((int)paramStructMsg.msg_time.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_req_type.set(paramStructMsg.msg.sub_type.get());
      localDelMsgInfo.rpt_msg_decide_info.add((MessageMicro)localObject);
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    paramString = paramString + "_" + (1L + paramLong);
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilMap.remove(paramString)).booleanValue();
    }
    return false;
  }
  
  public void b()
  {
    int i1 = MobileQQService.c;
    MobileQQService.c = i1 + 1;
    long l1 = i1;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new qmo(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 2, true);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    default: 
      return;
    case 6002: 
      if (this.i < 2)
      {
        this.i += 1;
        a(4);
        return;
      }
      this.i = 0;
      return;
    case 6001: 
      if (this.j < 2)
      {
        this.j += 1;
        a(2);
        return;
      }
      this.j = 0;
      return;
    case 6003: 
      if (this.k < 2)
      {
        this.k += 1;
        a(3);
        return;
      }
      this.k = 0;
      return;
    case 6006: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 6007: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "onSendSystemMsgActionError");
      }
      b(4012, false, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleGetDelSingleSysMsg Error!");
    }
    b(4015, false, paramToServiceMsg);
  }
  
  public void c()
  {
    int i1 = MobileQQService.c;
    MobileQQService.c = i1 + 1;
    long l1 = i1;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l3);
    localReqSystemMsgRead.checktype.set(3);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Group";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new qmp(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void d()
  {
    int i1 = MobileQQService.c;
    MobileQQService.c = i1 + 1;
    long l1 = i1;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsg reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    localReqSystemMsgRead.type.set(1);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new qmq(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void e()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new qmr(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqNextSystemMsg.Friend");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsgfollowing_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(20);
    localReqNextSystemMsg.following_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47"));
    localReqNextSystemMsg.checktype.set(2);
    localReqNextSystemMsg.version.set(1000);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.a();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new qms(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqNextSystemMsg.Group");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsgfollowing_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(20);
    localReqNextSystemMsg.following_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq"));
    localReqNextSystemMsg.checktype.set(3);
    localReqNextSystemMsg.version.set(1000);
    Object localObject = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject).GrpMsg_Kick_Admin.set(1);
    ((structmsg.FlagInfo)localObject).GrpMsg_WordingDown.set(1);
    ((structmsg.FlagInfo)localObject).GrpMsg_GetOfficialAccount.set(1);
    ((structmsg.FlagInfo)localObject).GrpMsg_GetPayInGroup.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_Discuss2ManyChat.set(1);
    localReqNextSystemMsg.flag.set((MessageMicro)localObject);
    localObject = new ProtoReqManager.ProtoReq();
    ((ProtoReqManager.ProtoReq)localObject).a();
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Group";
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new qmt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ProtoReqManager.ProtoReq)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\SystemMessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */