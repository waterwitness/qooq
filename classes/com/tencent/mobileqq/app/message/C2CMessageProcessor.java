package com.tencent.mobileqq.app.message;

import OnlinePushPack.DelMsgInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.VideoConstants;
import com.tencent.bitapp.BitAppManager;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.EndianUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import qlf;
import qlg;
import qli;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;

public class C2CMessageProcessor
  extends BaseMessageProcessor
{
  public static final String c = "Q.msg.C2CMessageProcessor";
  private static final int q = 33;
  HashSet jdField_a_of_type_JavaUtilHashSet;
  private Set jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  HashSet jdField_b_of_type_JavaUtilHashSet;
  private Set jdField_b_of_type_JavaUtilSet;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  
  public C2CMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.e = 1;
    this.f = 3;
    this.g = 10;
    this.h = 30;
    this.k = 1;
    this.l = 5;
    this.m = 10;
    this.n = 50;
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_b_of_type_JavaUtilHashSet = null;
  }
  
  private Pair a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    long l7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList3 = new ArrayList();
    a((List)localObject1, localArrayList3);
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    DecodeProtoPkgContext localDecodeProtoPkgContext = new DecodeProtoPkgContext(l7, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localDecodeProtoPkgContext.jdField_e_of_type_Boolean = true;
    localDecodeProtoPkgContext.a(1000, localHashMap);
    localDecodeProtoPkgContext.a(1001, localHashSet);
    long l1 = -1L;
    int i1 = 0;
    localObject1 = paramString;
    long l2 = -1L;
    int i3 = 0;
    long l4;
    int i2;
    Object localObject2;
    if (i3 < localArrayList3.size())
    {
      l4 = l2;
      l3 = l1;
      i2 = i1;
      localObject2 = localObject1;
    }
    for (;;)
    {
      Object localObject4;
      long l6;
      long l8;
      long l9;
      boolean bool;
      int i4;
      try
      {
        Object localObject3 = (msg_comm.Msg)localArrayList3.get(i3);
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        localObject4 = (msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get();
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        Object localObject5 = (im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get();
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        if (!((msg_comm.Msg)localObject3).msg_head.has())
        {
          l4 = l2;
          l3 = l1;
          i2 = i1;
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          l4 = l2;
          l3 = l1;
          i2 = i1;
          localObject2 = localObject1;
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + i3 + "] : msg doesn't has msgHead.");
          break;
        }
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        l6 = ((msg_comm.MsgHead)localObject4).to_uin.get();
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        l8 = ((msg_comm.MsgHead)localObject4).from_uin.get();
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        l9 = ((msg_comm.MsgHead)localObject4).from_uin.get();
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        l5 = ((msg_comm.MsgHead)localObject4).msg_time.get();
        if (l5 <= paramLong) {
          break label2819;
        }
        paramBoolean3 = false;
        bool = false;
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        l9 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l9, l6, paramUinPairMsg.peer_uin.get());
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        localObject1 = String.valueOf(l9);
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), 0);
        if ((l5 <= l6) && (bool))
        {
          l4 = l2;
          l3 = l1;
          i2 = i1;
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label2861;
          }
          l4 = l2;
          l3 = l1;
          i2 = i1;
          localObject2 = localObject1;
          localStringBuilder.setLength(0);
          l4 = l2;
          l3 = l1;
          i2 = i1;
          localObject2 = localObject1;
          localStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(i3).append("] : filter msg by del time delTime =").append(l6).append(", msgTime = ").append(l5);
          l4 = l2;
          l3 = l1;
          i2 = i1;
          localObject2 = localObject1;
          QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
          break label2861;
        }
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = bool;
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        localDecodeProtoPkgContext.jdField_e_of_type_Long = l9;
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        localDecodeProtoPkgContext.h = paramBoolean3;
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        localObject3 = a((msg_comm.Msg)localObject3, localDecodeProtoPkgContext).iterator();
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break label2240;
        }
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        l5 = ((MessageRecord)localObject4).vipBubbleID;
        if (l5 == -1L) {
          break label1905;
        }
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        if (MsgUtils.a(((MessageRecord)localObject4).issend))
        {
          l6 = l1;
          l4 = l5;
          l3 = l6;
          i2 = i1;
          localObject2 = localObject1;
          i4 = ((MessageRecord)localObject4).istroop;
          l4 = l5;
          l3 = l6;
          i2 = i4;
          localObject2 = localObject1;
          paramBoolean3 = a((MessageRecord)localObject4, true);
          l4 = l5;
          l3 = l6;
          i2 = i4;
          localObject2 = localObject1;
          bool = b((MessageRecord)localObject4);
          if ((!paramBoolean3) && (!bool))
          {
            l4 = l5;
            l3 = l6;
            i2 = i4;
            localObject2 = localObject1;
            if (((MessageRecord)localObject4).istroop == 1008)
            {
              l4 = l5;
              l3 = l6;
              i2 = i4;
              localObject2 = localObject1;
              if ((localObject4 instanceof MessageForStructing))
              {
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                if (StructLongMessageDownloadProcessor.b((MessageRecord)localObject4))
                {
                  l4 = l5;
                  l3 = l6;
                  i2 = i4;
                  localObject2 = localObject1;
                  localObject5 = ((MessageRecord)localObject4).getExtInfoFromExtStr("longMsg_State");
                  if (localObject5 == null) {
                    break label2182;
                  }
                  l4 = l5;
                  l3 = l6;
                  i2 = i4;
                  localObject2 = localObject1;
                  if (!"3".equals(localObject5)) {
                    break label2182;
                  }
                }
              }
            }
            l4 = l5;
            l3 = l6;
            i2 = i4;
            localObject2 = localObject1;
            localArrayList1.add(localObject4);
          }
          l4 = l5;
          l3 = l6;
          i2 = i4;
          localObject2 = localObject1;
          Object localObject6;
          if (((MessageRecord)localObject4).msgtype == 63534)
          {
            if (!paramBoolean3)
            {
              l4 = l5;
              l3 = l6;
              i2 = i4;
              localObject2 = localObject1;
              if (StreamDataManager.a(((MessageRecord)localObject4).msgUid, ((MessageRecord)localObject4).shmsgseq) != null)
              {
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                PttInfoCollector.a(true);
              }
            }
            if (paramBoolean3)
            {
              l4 = l5;
              l3 = l6;
              i2 = i4;
              localObject2 = localObject1;
              if ((localObject4 instanceof MessageForPtt))
              {
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                if (MsgProxyUtils.c(((MessageRecord)localObject4).istroop))
                {
                  l4 = l5;
                  l3 = l6;
                  i2 = i4;
                  localObject2 = localObject1;
                  localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop).iterator();
                  l4 = l5;
                  l3 = l6;
                  i2 = i4;
                  localObject2 = localObject1;
                  if (((Iterator)localObject5).hasNext())
                  {
                    l4 = l5;
                    l3 = l6;
                    i2 = i4;
                    localObject2 = localObject1;
                    localObject6 = (MessageRecord)((Iterator)localObject5).next();
                    l4 = l5;
                    l3 = l6;
                    i2 = i4;
                    localObject2 = localObject1;
                    if (!(localObject6 instanceof MessageForPtt)) {
                      continue;
                    }
                    l4 = l5;
                    l3 = l6;
                    i2 = i4;
                    localObject2 = localObject1;
                    if (((MessageRecord)localObject6).msgUid != ((MessageRecord)localObject4).msgUid) {
                      continue;
                    }
                    l4 = l5;
                    l3 = l6;
                    i2 = i4;
                    localObject2 = localObject1;
                    if (((MessageRecord)localObject6).shmsgseq != ((MessageRecord)localObject4).shmsgseq) {
                      continue;
                    }
                    l4 = l5;
                    l3 = l6;
                    i2 = i4;
                    localObject2 = localObject1;
                    a((MessageForPtt)localObject6, (MessageForPtt)localObject4);
                  }
                }
              }
            }
          }
          if (!paramBoolean3)
          {
            l4 = l5;
            l3 = l6;
            i2 = i4;
            localObject2 = localObject1;
            if (((MessageRecord)localObject4).istroop == 1008)
            {
              l4 = l5;
              l3 = l6;
              i2 = i4;
              localObject2 = localObject1;
              if ("1".equals(((MessageRecord)localObject4).getExtInfoFromExtStr("is_AdArrive_Msg")))
              {
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                localObject5 = ((MessageRecord)localObject4).getExtInfoFromExtStr("gdt_msgImp");
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                localObject6 = ((MessageRecord)localObject4).getExtInfoFromExtStr("pa_msgId");
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                String str2 = ((MessageRecord)localObject4).getExtInfoFromExtStr("gdt_view_id");
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                ArrayList localArrayList4 = new ArrayList();
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                localArrayList4.add(localObject6);
                l4 = l5;
                l3 = l6;
                i2 = i4;
                localObject2 = localObject1;
                PAReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", ((MessageRecord)localObject4).senderuin, (String)localObject5, str2, localArrayList4);
              }
            }
          }
          l2 = l5;
          l1 = l6;
          i1 = i4;
          l4 = l5;
          l3 = l6;
          i2 = i4;
          localObject2 = localObject1;
          if (!"true".equals(((MessageRecord)localObject4).getExtInfoFromExtStr("is_from_tim"))) {
            continue;
          }
          l4 = l5;
          l3 = l6;
          i2 = i4;
          localObject2 = localObject1;
          localArrayList2.add(localObject4);
          l2 = l5;
          l1 = l6;
          i1 = i4;
          continue;
        }
        l6 = l5;
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException);
        }
        l1 = l4;
        l2 = l3;
        i1 = i2;
      }
      long l5 = l2;
      continue;
      label1905:
      l4 = l2;
      l3 = l1;
      i2 = i1;
      localObject2 = localObject1;
      if (((MessageRecord)localObject4).msgtype == 63534)
      {
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        if (MsgUtils.a(((MessageRecord)localObject4).issend))
        {
          if (l2 != -1L)
          {
            l4 = l2;
            l3 = l1;
            i2 = i1;
            localObject2 = localObject1;
            ((MessageRecord)localObject4).vipBubbleID = l2;
            l5 = l2;
            l6 = l1;
          }
          else
          {
            l4 = l2;
            l3 = l1;
            i2 = i1;
            localObject2 = localObject1;
            ((MessageRecord)localObject4).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), String.valueOf(l8));
            l5 = l2;
            l6 = l1;
          }
        }
        else if (l1 != -1L)
        {
          l4 = l2;
          l3 = l1;
          i2 = i1;
          localObject2 = localObject1;
          ((MessageRecord)localObject4).vipBubbleID = l1;
          l5 = l2;
          l6 = l1;
        }
        else
        {
          l4 = l2;
          l3 = l1;
          i2 = i1;
          localObject2 = localObject1;
          ((MessageRecord)localObject4).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), String.valueOf(l8));
          l5 = l2;
          l6 = l1;
        }
      }
      else
      {
        l4 = l2;
        l3 = l1;
        i2 = i1;
        localObject2 = localObject1;
        ((MessageRecord)localObject4).vipBubbleID = 0L;
        l5 = l2;
        l6 = l1;
        continue;
        label2182:
        l4 = l5;
        l3 = l6;
        i2 = i4;
        localObject2 = localObject1;
        ((MessageRecord)localObject4).saveExtInfoToExtStr("longMsg_State", "1");
        l4 = l5;
        l3 = l6;
        i2 = i4;
        localObject2 = localObject1;
        StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localObject4);
        continue;
        label2240:
        l3 = l1;
        l1 = l2;
        l2 = l3;
        break label2840;
        if (localObject1 != null)
        {
          paramUinPairMsg = (msg_comm.UinPairMsg)localObject1;
          if (!((String)localObject1).equals("0")) {}
        }
        else
        {
          paramUinPairMsg = paramString;
        }
        if (!localHashMap.isEmpty())
        {
          paramString = localHashSet.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (Long)paramString.next();
            localHashMap.remove(localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("svenxu", 2, "Discard video request because canceled: fromUin = " + localObject1);
            }
          }
          paramString = localHashMap.keySet().iterator();
          while (paramString.hasNext())
          {
            localObject1 = (msg_comm.Msg)localHashMap.get((Long)paramString.next());
            if ((((msg_comm.Msg)localObject1).msg_body.has()) && (((im_msg_body.MsgBody)((msg_comm.Msg)localObject1).msg_body.get()).msg_content.has())) {
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l7, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject1).msg_body.get()).msg_content.get().toByteArray(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).msg_time.get());
            }
          }
        }
        if (localArrayList1.size() > 0)
        {
          if (!paramBoolean2) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramUinPairMsg), 0, localArrayList1, paramBoolean1);
          paramBoolean3 = a(localArrayList1);
          i2 = MsgProxyUtils.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
            break label2813;
          }
        }
        label2813:
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramString.a(localArrayList1, str1, paramBoolean1);
          a(localArrayList1);
          a(localArrayList1);
          a("handleGetBuddyMessageResp", true, i2, paramBoolean3, paramBoolean2);
          a(localArrayList1, paramBoolean2);
          if (i1 == 1008)
          {
            paramString = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
            if (paramString != null) {
              paramString.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          if ((localArrayList2 != null) && (localArrayList2.size() > 0) && (localArrayList2.get(0) != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "msgFromTim.size()=" + localArrayList2.size());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(2, ((MessageRecord)localArrayList2.get(0)).frienduin, ((MessageRecord)localArrayList2.get(0)).time);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : dstUin:" + paramUinPairMsg + ", pkgUinType:" + i1);
          }
          return new Pair(paramUinPairMsg, Integer.valueOf(i1));
        }
        label2819:
        paramBoolean3 = true;
        bool = true;
      }
    }
    long l3 = l2;
    l2 = l1;
    l1 = l3;
    for (;;)
    {
      label2840:
      i3 += 1;
      l3 = l2;
      l2 = l1;
      l1 = l3;
      break;
      label2861:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  private Pair a(List paramList1, List paramList2, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramList1 = paramList1.iterator();
      Object localObject;
      int i1;
      while (paramList1.hasNext())
      {
        localObject = (msg_comm.Msg)paramList1.next();
        if (!((msg_comm.Msg)localObject).msg_head.has())
        {
          paramList1.remove();
        }
        else
        {
          localObject = (msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get();
          paramLong1 = ((msg_comm.MsgHead)localObject).msg_uid.get();
          paramLong2 = (short)((msg_comm.MsgHead)localObject).msg_seq.get();
          i1 = 0;
          while (i1 < localList.size())
          {
            localObject = (MessageRecord)localList.get(i1);
            if ((((MessageRecord)localObject).msgUid == paramLong1) && (((MessageRecord)localObject).shmsgseq == paramLong2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
              }
              localArrayList.add(localObject);
              paramList1.remove();
            }
            i1 += 1;
          }
        }
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        localObject = (MessageRecord)paramList1.next();
        i1 = 0;
        while (i1 < localList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i1);
          if ((localMessageRecord.msgUid == ((MessageRecord)localObject).msgUid) && (localMessageRecord.shmsgseq == ((MessageRecord)localObject).shmsgseq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
            }
            paramList1.remove();
          }
          i1 += 1;
        }
      }
    }
    return new Pair(localArrayList, paramList2);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, msg_comm.MsgHead paramMsgHead)
  {
    Object localObject2 = paramQQAppInterface.a();
    Long localLong = Long.valueOf(Long.parseLong((String)localObject2));
    Object localObject1 = String.valueOf(paramLong1);
    String str = "" + paramMsgHead.auth_uin.get();
    paramMsgHead = paramMsgHead.auth_nick.get();
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramMsgHead)) && (str.equals(paramString1))) {}
    for (;;)
    {
      if ((localObject2 != null) && (((String)localObject2).equals(paramString1))) {
        return;
      }
      if (TextUtils.isEmpty(paramMsgHead)) {
        paramMsgHead = MessageHandlerUtils.a(paramQQAppInterface, paramString1, (String)localObject1);
      }
      for (;;)
      {
        boolean bool;
        if ((paramInt == -126) || (paramInt == 2))
        {
          paramString2 = paramMsgHead + " 已加入该群";
          localObject1 = (MessageForGrayTips)MessageRecordFactory.a(64524);
          ((MessageForGrayTips)localObject1).init(localLong.longValue(), paramLong1, paramLong1, paramString2, paramLong2, 64524, 1, paramLong3);
          ((MessageForGrayTips)localObject1).switch2HightlightMsg();
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("key_action", 5);
          ((Bundle)localObject2).putString("troop_mem_uin", paramString1);
          ((Bundle)localObject2).putBoolean("need_update_nick", false);
          ((MessageForGrayTips)localObject1).addHightlightItem(0, paramMsgHead.length(), (Bundle)localObject2);
          ((MessageForGrayTips)localObject1).isread = true;
          paramString1 = (TroopTipsMsgMgr)paramQQAppInterface.getManager(80);
          if ((a((MessageRecord)localObject1, false)) || (paramString1.a(paramLong1 + "", paramLong3))) {}
          for (bool = true;; bool = false)
          {
            if (!bool) {
              paramQQAppInterface.a().a((MessageRecord)localObject1, String.valueOf(localLong));
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.C2CMessageProcessor", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + paramString2 + "|msgFilter:" + bool);
            return;
          }
        }
        if ((paramInt != -125) && (paramInt != 3)) {
          break;
        }
        localObject1 = MessageHandlerUtils.a(paramQQAppInterface, paramString2, (String)localObject1);
        int i1;
        if ((localObject2 != null) && (((String)localObject2).equals(paramString2)))
        {
          i1 = 1;
          localObject1 = "你";
        }
        for (;;)
        {
          label461:
          MessageForGrayTips localMessageForGrayTips;
          if (i1 != 0)
          {
            localObject2 = (String)localObject1 + "邀请 ";
            str = (String)localObject2 + paramMsgHead + " 加入了本群";
            localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(64524);
            localMessageForGrayTips.init(localLong.longValue(), paramLong1, paramLong1, str, paramLong2, 64524, 1, paramLong3);
            localMessageForGrayTips.switch2HightlightMsg();
            if (i1 == 0)
            {
              Bundle localBundle = new Bundle();
              localBundle.putInt("key_action", 5);
              localBundle.putString("troop_mem_uin", paramString2);
              localBundle.putBoolean("need_update_nick", false);
              localMessageForGrayTips.addHightlightItem(0, ((String)localObject1).length(), localBundle);
            }
            paramString2 = new Bundle();
            paramString2.putInt("key_action", 5);
            paramString2.putString("troop_mem_uin", paramString1);
            paramString2.putBoolean("need_update_nick", false);
            localMessageForGrayTips.addHightlightItem(((String)localObject2).length(), ((String)localObject2).length() + paramMsgHead.length(), paramString2);
            localMessageForGrayTips.isread = true;
            paramString1 = (TroopTipsMsgMgr)paramQQAppInterface.getManager(80);
            if ((!a(localMessageForGrayTips, false)) && (!paramString1.a(paramLong1 + "", paramLong3))) {
              break label810;
            }
          }
          label810:
          for (bool = true;; bool = false)
          {
            if (!bool) {
              paramQQAppInterface.a().a(localMessageForGrayTips, String.valueOf(localLong));
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.C2CMessageProcessor", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + str + "|msgFilter:" + bool);
            return;
            localObject2 = (String)localObject1 + " 邀请 ";
            break label461;
          }
          i1 = 0;
        }
      }
      paramMsgHead = "";
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 654
    //   7: iconst_1
    //   8: invokevirtual 657	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   11: istore 23
    //   13: aload_1
    //   14: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   17: ldc_w 659
    //   20: iconst_1
    //   21: invokevirtual 657	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   24: istore 25
    //   26: aload_1
    //   27: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   30: ldc_w 661
    //   33: iconst_0
    //   34: invokevirtual 657	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   37: istore 24
    //   39: aload_2
    //   40: invokevirtual 666	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   43: ifnonnull +237 -> 280
    //   46: aload_0
    //   47: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 669	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   53: invokestatic 672	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 555	java/lang/Long:longValue	()J
    //   63: pop2
    //   64: new 674	msf/msgsvc/msg_svc$PbGetMsgResp
    //   67: dup
    //   68: invokespecial 675	msf/msgsvc/msg_svc$PbGetMsgResp:<init>	()V
    //   71: astore 5
    //   73: aload 5
    //   75: aload_3
    //   76: checkcast 677	[B
    //   79: checkcast 677	[B
    //   82: invokevirtual 681	msf/msgsvc/msg_svc$PbGetMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   85: checkcast 674	msf/msgsvc/msg_svc$PbGetMsgResp
    //   88: astore 5
    //   90: aload 5
    //   92: ifnonnull +35 -> 127
    //   95: invokestatic 687	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   98: invokestatic 692	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   101: aload_0
    //   102: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   108: ldc_w 694
    //   111: iconst_0
    //   112: lconst_0
    //   113: lconst_0
    //   114: new 122	java/util/HashMap
    //   117: dup
    //   118: invokespecial 123	java/util/HashMap:<init>	()V
    //   121: ldc_w 361
    //   124: invokevirtual 697	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   127: new 119	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   134: astore 7
    //   136: aload 5
    //   138: ifnull +25 -> 163
    //   141: aload 5
    //   143: getfield 700	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   146: invokevirtual 701	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   149: ifeq +14 -> 163
    //   152: aload 5
    //   154: getfield 700	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 209	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: ifeq +187 -> 347
    //   163: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +104 -> 270
    //   169: aload 7
    //   171: iconst_0
    //   172: invokevirtual 234	java/lang/StringBuilder:setLength	(I)V
    //   175: aload 7
    //   177: ldc_w 703
    //   180: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 706	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   187: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: ldc_w 708
    //   193: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: astore 6
    //   198: aload 5
    //   200: ifnonnull +117 -> 317
    //   203: ldc_w 710
    //   206: astore_3
    //   207: aload 6
    //   209: aload_3
    //   210: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   213: ldc_w 712
    //   216: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: astore 6
    //   221: aload 5
    //   223: ifnonnull +109 -> 332
    //   226: ldc_w 710
    //   229: astore_3
    //   230: aload 6
    //   232: aload_3
    //   233: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: ldc_w 714
    //   239: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: iload 23
    //   244: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   247: ldc_w 716
    //   250: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 25
    //   255: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: ldc 8
    //   261: iconst_2
    //   262: aload 7
    //   264: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 718	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_0
    //   271: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   274: aload_1
    //   275: aload_2
    //   276: invokevirtual 720	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   279: return
    //   280: aload_2
    //   281: invokevirtual 666	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   284: invokestatic 672	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   287: astore 5
    //   289: goto -231 -> 58
    //   292: astore 5
    //   294: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +14 -> 311
    //   300: ldc 8
    //   302: iconst_2
    //   303: ldc_w 722
    //   306: aload 5
    //   308: invokestatic 724	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: aconst_null
    //   312: astore 5
    //   314: goto -224 -> 90
    //   317: aload 5
    //   319: getfield 700	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   322: invokevirtual 209	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   325: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: astore_3
    //   329: goto -122 -> 207
    //   332: aload 5
    //   334: getfield 727	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   337: invokevirtual 423	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   340: invokestatic 732	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   343: astore_3
    //   344: goto -114 -> 230
    //   347: aconst_null
    //   348: astore_2
    //   349: aload 5
    //   351: getfield 727	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   354: invokevirtual 423	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   357: ifeq +15 -> 372
    //   360: aload 5
    //   362: getfield 727	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   365: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   368: invokevirtual 435	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   371: astore_2
    //   372: aload 5
    //   374: getfield 735	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   377: invokevirtual 97	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   380: astore 8
    //   382: aload_0
    //   383: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   386: iconst_0
    //   387: putfield 738	com/tencent/mobileqq/app/MessageHandler:cn	I
    //   390: aload 5
    //   392: getfield 742	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   395: invokevirtual 745	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   398: ifeq +1746 -> 2144
    //   401: aload 5
    //   403: getfield 742	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   406: invokevirtual 746	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   409: istore 10
    //   411: iload 10
    //   413: iconst_2
    //   414: if_icmpge +1724 -> 2138
    //   417: iconst_1
    //   418: i2b
    //   419: istore 4
    //   421: aconst_null
    //   422: astore 6
    //   424: aload 5
    //   426: getfield 749	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   429: invokevirtual 423	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   432: ifeq +16 -> 448
    //   435: aload 5
    //   437: getfield 749	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   440: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   443: invokevirtual 435	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   446: astore 6
    //   448: iconst_0
    //   449: istore 9
    //   451: aload 5
    //   453: getfield 752	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   456: invokevirtual 701	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   459: ifeq +13 -> 472
    //   462: aload 5
    //   464: getfield 752	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   467: invokevirtual 209	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   470: istore 9
    //   472: iload 9
    //   474: tableswitch	default:+26->500, 0:+913->1387, 1:+954->1428, 2:+976->1450
    //   500: iconst_0
    //   501: istore 22
    //   503: aload_0
    //   504: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   507: invokevirtual 754	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   510: ifeq +6 -> 516
    //   513: iconst_1
    //   514: istore 22
    //   516: iload 4
    //   518: ifle +24 -> 542
    //   521: aload_0
    //   522: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   525: iload 4
    //   527: aload_2
    //   528: iload 10
    //   530: iload 23
    //   532: iload 25
    //   534: iload 22
    //   536: aconst_null
    //   537: iload 9
    //   539: invokevirtual 757	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZLjava/lang/String;I)V
    //   542: invokestatic 762	java/lang/System:currentTimeMillis	()J
    //   545: pop2
    //   546: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq +154 -> 703
    //   552: aload 7
    //   554: iconst_0
    //   555: invokevirtual 234	java/lang/StringBuilder:setLength	(I)V
    //   558: aload 7
    //   560: ldc_w 703
    //   563: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_1
    //   567: invokevirtual 706	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   570: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: ldc_w 708
    //   576: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload 5
    //   581: getfield 700	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   584: invokevirtual 209	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   587: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: ldc_w 764
    //   593: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 5
    //   598: getfield 727	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   601: invokevirtual 423	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   604: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   607: ldc_w 766
    //   610: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: iload 4
    //   615: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: ldc_w 768
    //   621: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: iload 10
    //   626: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   629: ldc_w 770
    //   632: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload 23
    //   637: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   640: ldc_w 716
    //   643: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: iload 25
    //   648: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   651: ldc_w 772
    //   654: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload 8
    //   659: invokeinterface 103 1 0
    //   664: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: ldc_w 774
    //   670: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_3
    //   674: invokevirtual 779	java/lang/Object:hashCode	()I
    //   677: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: ldc_w 781
    //   683: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: iload 9
    //   688: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: ldc 8
    //   694: iconst_2
    //   695: aload 7
    //   697: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: iconst_0
    //   704: istore 10
    //   706: lconst_0
    //   707: lstore 12
    //   709: iload 10
    //   711: aload 8
    //   713: invokeinterface 103 1 0
    //   718: if_icmpge +859 -> 1577
    //   721: invokestatic 762	java/lang/System:currentTimeMillis	()J
    //   724: lstore 16
    //   726: aload 8
    //   728: iload 10
    //   730: invokeinterface 518 2 0
    //   735: checkcast 87	msf/msgcomm/msg_comm$UinPairMsg
    //   738: astore 5
    //   740: aload 5
    //   742: getfield 212	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   745: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   748: invokestatic 222	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   751: astore_2
    //   752: aload 5
    //   754: getfield 784	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   757: invokevirtual 209	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   760: i2l
    //   761: ldc2_w 785
    //   764: land
    //   765: lstore 14
    //   767: aload 5
    //   769: getfield 91	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   772: invokevirtual 97	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   775: astore_3
    //   776: aload 5
    //   778: getfield 789	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   781: invokevirtual 701	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   784: ifeq +689 -> 1473
    //   787: aload 5
    //   789: getfield 789	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   792: invokevirtual 209	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   795: ifeq +678 -> 1473
    //   798: iconst_1
    //   799: istore 22
    //   801: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   804: ifeq +77 -> 881
    //   807: aload 7
    //   809: iconst_0
    //   810: invokevirtual 234	java/lang/StringBuilder:setLength	(I)V
    //   813: aload 7
    //   815: ldc_w 791
    //   818: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload_2
    //   822: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: ldc_w 793
    //   828: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: iload 22
    //   833: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   836: ldc_w 795
    //   839: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: lload 14
    //   844: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   847: ldc_w 797
    //   850: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: astore 6
    //   855: aload_3
    //   856: ifnonnull +623 -> 1479
    //   859: ldc_w 710
    //   862: astore_1
    //   863: aload 6
    //   865: aload_1
    //   866: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: ldc 8
    //   872: iconst_2
    //   873: aload 7
    //   875: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_3
    //   882: ifnull +653 -> 1535
    //   885: aload_3
    //   886: invokeinterface 103 1 0
    //   891: ifle +644 -> 1535
    //   894: aload_3
    //   895: invokeinterface 103 1 0
    //   900: iconst_1
    //   901: if_icmple +15 -> 916
    //   904: aload_3
    //   905: new 799	qle
    //   908: dup
    //   909: aload_0
    //   910: invokespecial 802	qle:<init>	(Lcom/tencent/mobileqq/app/message/C2CMessageProcessor;)V
    //   913: invokestatic 808	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   916: aload_0
    //   917: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   920: bipush 50
    //   922: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   925: checkcast 810	com/tencent/mobileqq/app/FriendsManager
    //   928: aload_3
    //   929: iconst_0
    //   930: invokeinterface 518 2 0
    //   935: checkcast 147	msf/msgcomm/msg_comm$Msg
    //   938: getfield 151	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   941: invokevirtual 156	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   944: checkcast 153	msf/msgcomm/msg_comm$MsgHead
    //   947: getfield 201	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   950: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   953: invokevirtual 813	com/tencent/mobileqq/app/FriendsManager:a	(J)V
    //   956: aload_0
    //   957: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   960: aload_2
    //   961: iconst_0
    //   962: invokevirtual 816	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   965: astore 6
    //   967: aload 6
    //   969: monitorenter
    //   970: aload_0
    //   971: aload_2
    //   972: aload 5
    //   974: lload 14
    //   976: iload 22
    //   978: iload 23
    //   980: iload 24
    //   982: invokespecial 818	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   985: astore_2
    //   986: aload_2
    //   987: getfield 822	android/util/Pair:first	Ljava/lang/Object;
    //   990: checkcast 219	java/lang/String
    //   993: astore_1
    //   994: aload_2
    //   995: getfield 825	android/util/Pair:second	Ljava/lang/Object;
    //   998: checkcast 107	java/lang/Integer
    //   1001: invokevirtual 828	java/lang/Integer:intValue	()I
    //   1004: istore 11
    //   1006: aload 6
    //   1008: monitorexit
    //   1009: iload 22
    //   1011: ifne +171 -> 1182
    //   1014: aload_0
    //   1015: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1018: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1021: aload_1
    //   1022: invokevirtual 830	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;)J
    //   1025: lstore 18
    //   1027: aload_3
    //   1028: iconst_0
    //   1029: invokeinterface 518 2 0
    //   1034: checkcast 147	msf/msgcomm/msg_comm$Msg
    //   1037: getfield 151	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1040: invokevirtual 156	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1043: checkcast 153	msf/msgcomm/msg_comm$MsgHead
    //   1046: getfield 205	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1049: invokevirtual 209	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1052: i2l
    //   1053: lstore 20
    //   1055: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1058: ifeq +62 -> 1120
    //   1061: ldc 8
    //   1063: iconst_2
    //   1064: new 119	java/lang/StringBuilder
    //   1067: dup
    //   1068: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1071: ldc_w 832
    //   1074: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: aload_1
    //   1078: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: ldc_w 834
    //   1084: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: lload 18
    //   1089: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1092: ldc_w 836
    //   1095: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: lload 20
    //   1100: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1103: ldc_w 766
    //   1106: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: iload 4
    //   1111: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1120: lload 18
    //   1122: lconst_0
    //   1123: lcmp
    //   1124: ifeq +11 -> 1135
    //   1127: lload 20
    //   1129: lload 18
    //   1131: lcmp
    //   1132: ifge +35 -> 1167
    //   1135: aload_0
    //   1136: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1139: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1142: aload_1
    //   1143: lload 20
    //   1145: lconst_0
    //   1146: invokevirtual 839	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;JJ)V
    //   1149: iload 4
    //   1151: ifle +16 -> 1167
    //   1154: aload_0
    //   1155: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1158: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1161: aload_1
    //   1162: lload 20
    //   1164: invokevirtual 841	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;J)V
    //   1167: iload 4
    //   1169: ifne +13 -> 1182
    //   1172: aload_0
    //   1173: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1176: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1179: invokevirtual 843	com/tencent/mobileqq/service/message/MessageCache:c	()V
    //   1182: lload 12
    //   1184: invokestatic 762	java/lang/System:currentTimeMillis	()J
    //   1187: lload 16
    //   1189: lsub
    //   1190: ladd
    //   1191: lstore 12
    //   1193: iload 23
    //   1195: ifeq +379 -> 1574
    //   1198: aload_1
    //   1199: astore_2
    //   1200: iload 11
    //   1202: sipush 1006
    //   1205: if_icmpne +30 -> 1235
    //   1208: aload_0
    //   1209: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1212: bipush 10
    //   1214: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1217: checkcast 845	com/tencent/mobileqq/model/PhoneContactManager
    //   1220: aload_1
    //   1221: invokeinterface 847 2 0
    //   1226: astore_3
    //   1227: aload_1
    //   1228: astore_2
    //   1229: aload_3
    //   1230: ifnull +5 -> 1235
    //   1233: aload_3
    //   1234: astore_2
    //   1235: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1238: ifeq +51 -> 1289
    //   1241: ldc 8
    //   1243: iconst_2
    //   1244: new 119	java/lang/StringBuilder
    //   1247: dup
    //   1248: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1251: ldc_w 849
    //   1254: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: aload_2
    //   1258: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: ldc_w 851
    //   1264: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: iload 11
    //   1269: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1272: ldc_w 853
    //   1275: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: lload 14
    //   1280: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1289: new 855	android/os/Message
    //   1292: dup
    //   1293: invokespecial 856	android/os/Message:<init>	()V
    //   1296: astore_1
    //   1297: aload_1
    //   1298: iconst_1
    //   1299: putfield 859	android/os/Message:what	I
    //   1302: new 564	android/os/Bundle
    //   1305: dup
    //   1306: invokespecial 565	android/os/Bundle:<init>	()V
    //   1309: astore_3
    //   1310: aload_3
    //   1311: ldc_w 861
    //   1314: lload 14
    //   1316: invokevirtual 640	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1319: aload_3
    //   1320: ldc_w 863
    //   1323: aload_2
    //   1324: invokevirtual 576	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1327: aload_3
    //   1328: ldc_w 865
    //   1331: iload 11
    //   1333: invokevirtual 571	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1336: aload_1
    //   1337: aload_3
    //   1338: invokevirtual 869	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1341: aload_0
    //   1342: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1345: astore_3
    //   1346: iload 4
    //   1348: ifgt +209 -> 1557
    //   1351: iconst_1
    //   1352: istore 22
    //   1354: aload_3
    //   1355: aload_1
    //   1356: iload 22
    //   1358: invokevirtual 872	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   1361: iload 9
    //   1363: iconst_2
    //   1364: if_icmpne +199 -> 1563
    //   1367: aload_0
    //   1368: getfield 46	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1371: aload_2
    //   1372: invokeinterface 873 2 0
    //   1377: pop
    //   1378: iload 10
    //   1380: iconst_1
    //   1381: iadd
    //   1382: istore 10
    //   1384: goto -675 -> 709
    //   1387: aload_0
    //   1388: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1391: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1394: aload_2
    //   1395: invokevirtual 876	com/tencent/mobileqq/service/message/MessageCache:a	([B)V
    //   1398: aload_0
    //   1399: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1402: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1405: aload_2
    //   1406: invokevirtual 878	com/tencent/mobileqq/service/message/MessageCache:b	([B)V
    //   1409: aload_0
    //   1410: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1413: iconst_0
    //   1414: invokevirtual 880	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1417: aload_0
    //   1418: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1421: iconst_0
    //   1422: invokevirtual 882	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   1425: goto -925 -> 500
    //   1428: aload_0
    //   1429: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1432: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1435: aload_2
    //   1436: invokevirtual 876	com/tencent/mobileqq/service/message/MessageCache:a	([B)V
    //   1439: aload_0
    //   1440: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1443: iconst_0
    //   1444: invokevirtual 880	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1447: goto -947 -> 500
    //   1450: aload_0
    //   1451: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1454: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1457: aload 6
    //   1459: invokevirtual 878	com/tencent/mobileqq/service/message/MessageCache:b	([B)V
    //   1462: aload_0
    //   1463: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1466: iconst_0
    //   1467: invokevirtual 882	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   1470: goto -970 -> 500
    //   1473: iconst_0
    //   1474: istore 22
    //   1476: goto -675 -> 801
    //   1479: aload_3
    //   1480: invokeinterface 103 1 0
    //   1485: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1488: astore_1
    //   1489: goto -626 -> 863
    //   1492: astore_1
    //   1493: aload 6
    //   1495: monitorexit
    //   1496: aload_1
    //   1497: athrow
    //   1498: astore_1
    //   1499: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1502: ifeq +30 -> 1532
    //   1505: ldc 8
    //   1507: iconst_2
    //   1508: new 119	java/lang/StringBuilder
    //   1511: dup
    //   1512: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1515: ldc_w 884
    //   1518: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: aload_1
    //   1522: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1525: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1528: aload_1
    //   1529: invokestatic 724	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1532: goto -154 -> 1378
    //   1535: aload_0
    //   1536: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1539: invokevirtual 336	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1542: aload_2
    //   1543: iconst_0
    //   1544: invokevirtual 887	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1547: getfield 890	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1550: istore 11
    //   1552: aload_2
    //   1553: astore_1
    //   1554: goto -372 -> 1182
    //   1557: iconst_0
    //   1558: istore 22
    //   1560: goto -206 -> 1354
    //   1563: aload_0
    //   1564: getfield 44	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1567: aload_2
    //   1568: invokeinterface 873 2 0
    //   1573: pop
    //   1574: goto -196 -> 1378
    //   1577: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1580: ifeq +30 -> 1610
    //   1583: ldc 8
    //   1585: iconst_2
    //   1586: new 119	java/lang/StringBuilder
    //   1589: dup
    //   1590: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1593: ldc_w 892
    //   1596: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: lload 12
    //   1601: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1604: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1607: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1610: iload 4
    //   1612: ifgt -1333 -> 279
    //   1615: aload_0
    //   1616: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1619: invokevirtual 893	com/tencent/mobileqq/app/MessageHandler:c	()V
    //   1622: iload 23
    //   1624: ifeq +377 -> 2001
    //   1627: aload_0
    //   1628: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1631: invokevirtual 896	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/ConversationFacade;
    //   1634: invokevirtual 900	com/tencent/mobileqq/app/message/ConversationFacade:a	()Ljava/util/Set;
    //   1637: invokeinterface 413 1 0
    //   1642: astore_1
    //   1643: aload_1
    //   1644: invokeinterface 262 1 0
    //   1649: ifeq +337 -> 1986
    //   1652: aload_1
    //   1653: invokeinterface 266 1 0
    //   1658: checkcast 902	com/tencent/mobileqq/data/ConversationInfo
    //   1661: astore_2
    //   1662: aload_2
    //   1663: getfield 905	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1666: ifnull -23 -> 1643
    //   1669: iload 9
    //   1671: iconst_1
    //   1672: if_icmpne +13 -> 1685
    //   1675: aload_2
    //   1676: getfield 908	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1679: sipush 1008
    //   1682: if_icmpeq -39 -> 1643
    //   1685: iload 9
    //   1687: iconst_2
    //   1688: if_icmpne +13 -> 1701
    //   1691: aload_2
    //   1692: getfield 908	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1695: sipush 1008
    //   1698: if_icmpne -55 -> 1643
    //   1701: iload 9
    //   1703: iconst_2
    //   1704: if_icmpeq +31 -> 1735
    //   1707: aload_0
    //   1708: getfield 44	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1711: invokeinterface 909 1 0
    //   1716: ifle +19 -> 1735
    //   1719: aload_0
    //   1720: getfield 44	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1723: aload_2
    //   1724: getfield 905	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1727: invokeinterface 912 2 0
    //   1732: ifne -89 -> 1643
    //   1735: iload 9
    //   1737: iconst_2
    //   1738: if_icmpne +31 -> 1769
    //   1741: aload_0
    //   1742: getfield 46	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1745: invokeinterface 909 1 0
    //   1750: ifle +19 -> 1769
    //   1753: aload_0
    //   1754: getfield 46	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1757: aload_2
    //   1758: getfield 905	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1761: invokeinterface 912 2 0
    //   1766: ifne -123 -> 1643
    //   1769: aload_2
    //   1770: getfield 908	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1773: invokestatic 333	com/tencent/mobileqq/app/message/MsgProxyUtils:c	(I)Z
    //   1776: ifeq -133 -> 1643
    //   1779: aload_2
    //   1780: invokestatic 915	com/tencent/mobileqq/app/message/ConversationFacade:b	(Lcom/tencent/mobileqq/data/ConversationInfo;)I
    //   1783: ifle -140 -> 1643
    //   1786: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1789: ifeq +45 -> 1834
    //   1792: ldc 8
    //   1794: iconst_2
    //   1795: new 119	java/lang/StringBuilder
    //   1798: dup
    //   1799: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1802: ldc_w 917
    //   1805: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: aload_2
    //   1809: getfield 905	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1812: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: ldc_w 919
    //   1818: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1821: aload_2
    //   1822: getfield 908	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1825: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1828: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1831: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1834: aload_2
    //   1835: getfield 905	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1838: invokevirtual 585	java/lang/String:length	()I
    //   1841: iconst_4
    //   1842: if_icmple -199 -> 1643
    //   1845: aload_2
    //   1846: getfield 908	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1849: sipush 1001
    //   1852: if_icmpne +59 -> 1911
    //   1855: aload_0
    //   1856: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1859: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1862: aload_2
    //   1863: getfield 905	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1866: invokevirtual 922	com/tencent/mobileqq/service/message/MessageCache:k	(Ljava/lang/String;)[B
    //   1869: astore_3
    //   1870: aload_3
    //   1871: ifnull -228 -> 1643
    //   1874: aload_3
    //   1875: arraylength
    //   1876: ifle -233 -> 1643
    //   1879: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1882: ifeq +29 -> 1911
    //   1885: ldc 8
    //   1887: iconst_2
    //   1888: new 119	java/lang/StringBuilder
    //   1891: dup
    //   1892: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1895: ldc_w 924
    //   1898: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: aload_3
    //   1902: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1905: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1908: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1911: new 855	android/os/Message
    //   1914: dup
    //   1915: invokespecial 856	android/os/Message:<init>	()V
    //   1918: astore_3
    //   1919: aload_3
    //   1920: iconst_1
    //   1921: putfield 859	android/os/Message:what	I
    //   1924: new 564	android/os/Bundle
    //   1927: dup
    //   1928: invokespecial 565	android/os/Bundle:<init>	()V
    //   1931: astore 5
    //   1933: aload 5
    //   1935: ldc_w 861
    //   1938: ldc2_w 925
    //   1941: invokevirtual 640	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1944: aload 5
    //   1946: ldc_w 863
    //   1949: aload_2
    //   1950: getfield 905	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1953: invokevirtual 576	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1956: aload 5
    //   1958: ldc_w 865
    //   1961: aload_2
    //   1962: getfield 908	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1965: invokevirtual 571	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1968: aload_3
    //   1969: aload 5
    //   1971: invokevirtual 869	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1974: aload_0
    //   1975: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1978: aload_3
    //   1979: iconst_1
    //   1980: invokevirtual 872	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   1983: goto -340 -> 1643
    //   1986: iload 9
    //   1988: iconst_2
    //   1989: if_icmpne +92 -> 2081
    //   1992: aload_0
    //   1993: getfield 46	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1996: invokeinterface 929 1 0
    //   2001: invokestatic 934	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   2004: invokevirtual 936	com/tencent/util/MsgAutoMonitorUtil:e	()V
    //   2007: iload 9
    //   2009: tableswitch	default:+27->2036, 0:+84->2093, 1:+105->2114, 2:+117->2126
    //   2036: aload_0
    //   2037: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2040: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   2043: invokevirtual 938	com/tencent/mobileqq/service/message/MessageCache:h	()V
    //   2046: aload_0
    //   2047: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2050: invokevirtual 754	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   2053: ifeq -1774 -> 279
    //   2056: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2059: ifeq +12 -> 2071
    //   2062: ldc 8
    //   2064: iconst_2
    //   2065: ldc_w 940
    //   2068: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2071: aload_0
    //   2072: getfield 426	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2075: iconst_0
    //   2076: iconst_0
    //   2077: invokevirtual 943	com/tencent/mobileqq/app/MessageHandler:a	(ZI)V
    //   2080: return
    //   2081: aload_0
    //   2082: getfield 44	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2085: invokeinterface 929 1 0
    //   2090: goto -89 -> 2001
    //   2093: aload_0
    //   2094: sipush 4016
    //   2097: iconst_1
    //   2098: aconst_null
    //   2099: invokevirtual 651	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2102: aload_0
    //   2103: sipush 4001
    //   2106: iconst_1
    //   2107: aconst_null
    //   2108: invokevirtual 651	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2111: goto -75 -> 2036
    //   2114: aload_0
    //   2115: sipush 4001
    //   2118: iconst_1
    //   2119: aconst_null
    //   2120: invokevirtual 651	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2123: goto -87 -> 2036
    //   2126: aload_0
    //   2127: sipush 4016
    //   2130: iconst_1
    //   2131: aconst_null
    //   2132: invokevirtual 651	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2135: goto -99 -> 2036
    //   2138: iconst_0
    //   2139: istore 4
    //   2141: goto -1720 -> 421
    //   2144: iconst_2
    //   2145: istore 10
    //   2147: goto -1736 -> 411
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2150	0	this	C2CMessageProcessor
    //   0	2150	1	paramToServiceMsg	ToServiceMsg
    //   0	2150	2	paramFromServiceMsg	FromServiceMsg
    //   0	2150	3	paramObject	Object
    //   419	1721	4	b1	byte
    //   56	232	5	localObject1	Object
    //   292	15	5	localException	Exception
    //   312	1658	5	localObject2	Object
    //   134	740	7	localStringBuilder	StringBuilder
    //   380	347	8	localList	List
    //   449	1559	9	i1	int
    //   409	1737	10	i2	int
    //   1004	547	11	i3	int
    //   707	893	12	l1	long
    //   765	550	14	l2	long
    //   724	464	16	l3	long
    //   1025	105	18	l4	long
    //   1053	110	20	l5	long
    //   501	1058	22	bool1	boolean
    //   11	1612	23	bool2	boolean
    //   37	944	24	bool3	boolean
    //   24	623	25	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   73	90	292	java/lang/Exception
    //   970	1009	1492	finally
    //   1493	1496	1492	finally
    //   956	970	1498	java/lang/Exception
    //   1496	1498	1498	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    paramFromServiceMsg = new HashMap(1);
    paramFromServiceMsg.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    paramFromServiceMsg.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    paramFromServiceMsg.put("LOADTYPE", Integer.valueOf(paramToServiceMsg.extraData.getInt("loadType")));
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex");
    if ((!paramBoolean) && (i1 < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handleSearchRoamMsgInCloudTimeOutAndError retry index:" + i1);
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i1 + 1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramToServiceMsg);
      return;
    }
    a(8015, false, paramFromServiceMsg);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      long l1 = System.currentTimeMillis() / 1000L;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.istroop == 1008) {
          if ((!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_send_flag"))) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"))) && (!TextUtils.equals(localMessageRecord.frienduin, localMessageRecord.selfuin))) {
            ThreadManager.a(new qli(this, localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l1, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
          } else if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
          }
        }
      }
    }
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---C2CMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
    }
    long l1;
    Object localObject2;
    boolean bool;
    do
    {
      for (;;)
      {
        return;
        l1 = localMsgHead.c2c_cmd.get();
        long l2 = localMsgHead.from_uin.get();
        long l3 = localMsgHead.to_uin.get();
        long l4 = localMsgHead.msg_seq.get();
        long l5 = localMsgHead.msg_time.get();
        long l6 = localMsgHead.msg_uid.get();
        int i1 = localMsgHead.user_active.get();
        int i2 = localMsgHead.from_instid.get();
        Object localObject1;
        long l7;
        if (paramFromServiceMsg.getUin() == null)
        {
          localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          l7 = ((Long)localObject1).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + i1 + ",fromInstid:" + i2 + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.cq = i1;
          localObject1 = new ArrayList();
        }
        try
        {
          localObject2 = new DecodeProtoPkgContext(l7, l3, true, false, false, false);
          ((DecodeProtoPkgContext)localObject2).h = true;
          paramMsg = a(paramMsg, (PBDecodeContext)localObject2);
          MessageHandlerUtils.a(paramMsg);
          if ((paramMsg != null) && (paramMsg.size() != 0))
          {
            if (localObject1 != null) {
              a(paramMsg, (ArrayList)localObject1, true);
            }
            paramMsg = new ArrayList();
            localObject2 = new ArrayList();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              i2 = ((ArrayList)localObject1).size();
              i1 = 0;
              for (;;)
              {
                if (i1 < i2)
                {
                  localMessageRecord = (MessageRecord)((ArrayList)localObject1).get(i1);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
                  }
                  if ((localMessageRecord.frienduin == null) || (localMessageRecord.frienduin.length() <= 2))
                  {
                    i1 += 1;
                    continue;
                    localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
                  }
                }
              }
            }
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            MessageRecord localMessageRecord;
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", paramMsg);
            }
            paramMsg = null;
            continue;
            localMessageRecord.isread = true;
            localMessageRecord.issend = 2;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.time);
            ((ArrayList)localObject2).add(localMessageRecord);
            DelMsgInfo localDelMsgInfo = new DelMsgInfo();
            localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
            localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
            localDelMsgInfo.uMsgTime = localMessageRecord.time;
            paramMsg.add(localDelMsgInfo);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
          bool = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ArrayList)localObject2, String.valueOf(l7), false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
          i1 = paramFromServiceMsg.getRequestSsoSeq();
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), i1);
        }
      }
    } while (l1 == 127L);
    a("handleMsgPush_PB_SlaveMaster", true, 0, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(false, bool), false);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    String str = String.valueOf(l1);
    PkgTools.a(paramArrayOfByte, 10);
    int i1 = PkgTools.a(paramArrayOfByte, 16);
    Object localObject = null;
    if (i1 > 0) {
      localObject = PkgTools.a(paramArrayOfByte, 18, i1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.C2CMessageProcessor", 2, "----->handleHotChatAnnouncementMsg dwGroupCode = " + l1 + ", len = " + i1 + ", announcement = " + (String)localObject);
    }
    paramArrayOfByte = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if ((paramArrayOfByte != null) && (localObject != null))
    {
      localObject = ((HotChatManager)localObject).a(str);
      if (localObject != null)
      {
        if (((HotChatInfo)localObject).userCreate != 1) {
          break label157;
        }
        paramArrayOfByte.b(str);
      }
    }
    return;
    label157:
    paramArrayOfByte.a(((HotChatInfo)localObject).uuid.getBytes(), str);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramObject = new Bundle();
      localObject2 = Long.valueOf(paramToServiceMsg.extraData.getLong("lBeginTime"));
      bool1 = paramToServiceMsg.extraData.getBoolean("fetchMore");
      i3 = paramToServiceMsg.extraData.getInt("fetchNum");
      bool2 = paramToServiceMsg.extraData.getBoolean("preloadType");
      ((Bundle)paramObject).putLong("BEGTIME", ((Long)localObject2).longValue());
      ((Bundle)paramObject).putBoolean("FETCH_MORE", bool1);
      ((Bundle)paramObject).putInt("MSG_COUNT", i3);
      ((Bundle)paramObject).putString("PEER_UIN", paramToServiceMsg.extraData.getString("peerUin"));
      ((Bundle)paramObject).putBoolean("IS_PRELOAD_TYPE", bool2);
      if (paramFromServiceMsg != null)
      {
        str = String.valueOf(paramFromServiceMsg.peer_uin.get());
        i2 = paramFromServiceMsg.result.get();
        localObject3 = paramFromServiceMsg.msg.get();
        if (localObject3 == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + i2 + ", msgList is null !");
          }
          a(1004, false, paramObject);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      Object localObject2;
      boolean bool1;
      int i3;
      boolean bool2;
      String str;
      int i2;
      Object localObject3;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
      Object localObject1 = new ArrayList();
      a((List)localObject3, (List)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg begTime: " + localObject2 + ", code=" + i2 + ", msgList.size()=" + ((List)localObject1).size() + ",peerUin=" + str + ",time=" + paramFromServiceMsg.last_msgtime.get() + ",fetchMore:" + bool1 + ",fetchNum: " + i3);
      }
      int i1 = 0;
      if (((i2 != 0) && (i2 != 1)) || (i2 == 0)) {}
      for (;;)
      {
        try
        {
          if (((List)localObject1).size() > 0)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
              continue;
            }
            localObject2 = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(str);
            if (((List)localObject2).size() == 0) {
              ((List)localObject2).addAll(0, (Collection)localObject1);
            }
          }
          else
          {
            localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, paramToServiceMsg.extraData.getLong("lBeginTime"), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get(), 1, ((MessageRoamManager)localObject1).b(), ((MessageRoamManager)localObject1).b(), paramToServiceMsg.extraData.getBoolean("fetchMore"), i3, bool2);
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
          }
          i1 = 0;
          if (i1 != 0) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          }
          ((Bundle)paramObject).putInt("SVR_CODE", i2);
          if (paramFromServiceMsg.errmsg.has()) {
            ((Bundle)paramObject).putString("SVR_MSG", paramFromServiceMsg.errmsg.get());
          }
          a(1004, false, paramObject);
          return;
          if ((((List)localObject2).size() <= 0) || ((((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_uid.get() == ((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject1).get(0)).msg_head.get()).msg_uid.get()) && (((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_seq.get() == ((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject1).get(0)).msg_head.get()).msg_seq.get()))) {
            continue;
          }
          ((List)localObject2).addAll(0, (Collection)localObject1);
          continue;
        }
        catch (OutOfMemoryError paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
          }
          i1 = 0;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.put(str, localObject1);
          continue;
        }
        localObject1 = new ArrayList((Collection)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str))
        {
          ((ArrayList)localObject1).addAll((Collection)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(str));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          new Object[2][0] = Boolean.valueOf(true);
          ((Bundle)paramObject).putBoolean("NO_MSG", Boolean.TRUE.booleanValue());
          a(1004, false, paramObject);
          return;
        }
        long l1 = paramToServiceMsg.extraData.getLong("lBeginTime");
        long l2 = paramToServiceMsg.extraData.getLong("lEndTime");
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (msg_comm.Msg)((Iterator)localObject3).next();
          if (!((msg_comm.Msg)localObject4).msg_head.has())
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msg msg_head = null");
            }
          }
          else
          {
            long l3 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get()).msg_time.get();
            if ((l3 >= l1) && (l3 <= l2)) {
              ((ArrayList)localObject2).add(localObject4);
            }
          }
        }
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, Long.valueOf(str).longValue(), true);
        localObject3 = new ArrayList();
        l1 = Long.parseLong(str);
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject5 = (msg_comm.Msg)((ArrayList)localObject2).get(0);
          l1 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject5).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject5).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        ((ArrayList)localObject3).addAll((Collection)a((List)localObject2, (List)localObject4, l1, paramToServiceMsg.extraData.getLong("lBeginTime"), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        localObject4 = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), l1, true, true, false, false);
        ((DecodeProtoPkgContext)localObject4).h = true;
        Object localObject5 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          Object localObject6 = (msg_comm.Msg)((Iterator)localObject5).next();
          try
          {
            localObject6 = a((msg_comm.Msg)localObject6, (PBDecodeContext)localObject4);
            if ((localObject6 == null) || (((ArrayList)localObject6).isEmpty())) {
              continue;
            }
            ((ArrayList)localObject3).addAll((Collection)localObject6);
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
          }
        }
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
          Collections.sort((List)localObject3, new qlf(this));
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ArrayList)localObject3, false);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()));
          if ((localObject4 == null) || (((Long)((Pair)localObject4).first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
          }
          ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91)).a().b(str, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg resList size = " + ((ArrayList)localObject1).size() + ", dayList size = " + ((ArrayList)localObject2).size() + ", loopList size=" + ((ArrayList)localObject3).size());
          }
          ((Bundle)paramObject).putInt("MSG_COUNT", i3 - ((ArrayList)localObject3).size());
          a(1004, true, paramObject);
          i1 = 1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", localException1);
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
            }
          }
        }
      }
      a(1004, false, paramObject);
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.msgUid, paramMessageRecord.shmsgseq);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
    }
    paramFromServiceMsg = new msg_svc.PbGetOneDayRoamMsgResp();
    Bundle localBundle;
    long l2;
    int i1;
    long l1;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localBundle = paramToServiceMsg.extraData.getBundle("context");
      paramObject = null;
      l2 = 0L;
      if (paramFromServiceMsg == null) {
        break label691;
      }
      i1 = paramFromServiceMsg.result.get();
      Object localObject = paramFromServiceMsg.msg.get();
      paramToServiceMsg = new ArrayList();
      a((List)localObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + i1 + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + paramToServiceMsg.size() + ", context" + localBundle);
      }
      if (i1 != 0) {
        break label692;
      }
      paramObject = new ArrayList();
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramToServiceMsg, paramFromServiceMsg.peer_uin.get(), true);
        if (localObject != null) {
          ((ArrayList)paramObject).addAll((Collection)localObject);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          DecodeProtoPkgContext localDecodeProtoPkgContext;
          Iterator localIterator;
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "FileMsg filter error,", localException1);
          }
        }
      }
      l1 = paramFromServiceMsg.peer_uin.get();
      if (!paramToServiceMsg.isEmpty())
      {
        localObject = (msg_comm.Msg)paramToServiceMsg.get(0);
        l1 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localDecodeProtoPkgContext = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), l1, true, true, false, false);
      localDecodeProtoPkgContext.h = true;
      localIterator = paramToServiceMsg.iterator();
      paramToServiceMsg = null;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label479;
        }
        localObject = (msg_comm.Msg)localIterator.next();
        try
        {
          localObject = a((msg_comm.Msg)localObject, localDecodeProtoPkgContext);
          paramToServiceMsg = (ToServiceMsg)localObject;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
            }
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          ((ArrayList)paramObject).addAll(paramToServiceMsg);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
      }
    }
    label479:
    if (((ArrayList)paramObject).size() > 0)
    {
      Collections.sort((List)paramObject, new qlg(this));
      l1 = ((MessageRecord)((ArrayList)paramObject).get(0)).time;
    }
    for (paramToServiceMsg = (ToServiceMsg)paramObject;; paramToServiceMsg = null)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool1;
        label563:
        boolean bool2;
        if (localBundle != null)
        {
          localBundle.getInt("size_req", 0);
          l2 = localBundle.getLong("UIN", 0L);
          bool3 = localBundle.getBoolean("canUpdateEct", true);
          if (paramFromServiceMsg.iscomplete.get() == 0) {
            break label734;
          }
          bool1 = true;
          if ((i1 != 0) && (i1 != 1) && (i1 != 4)) {
            break label740;
          }
          bool2 = true;
          label583:
          if ((!bool2) || (!bool3)) {
            break label783;
          }
          if (!bool1) {
            break label746;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2), 0L, 0L);
          label615:
          localBundle.putBoolean("complete", bool1);
          localBundle.putBoolean("success", bool2);
          localBundle.putLong("lowTime", l1);
          paramObject = new ArrayList();
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramFromServiceMsg.peer_uin.get()), 0, paramToServiceMsg, (List)paramObject, localBundle);
          if (paramToServiceMsg != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ArrayList)paramObject, false);
          }
          label691:
          return;
          label692:
          l1 = l2;
          paramToServiceMsg = (ToServiceMsg)paramObject;
          if (i1 == 1)
          {
            l1 = l2;
            paramToServiceMsg = (ToServiceMsg)paramObject;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
              l1 = l2;
              paramToServiceMsg = (ToServiceMsg)paramObject;
              continue;
              label734:
              bool1 = false;
              break label563;
              label740:
              bool2 = false;
              break label583;
              label746:
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
              break label615;
              label783:
              if (bool3) {
                break label615;
              }
              if (bool1)
              {
                localBundle.putLong("tempEct", 0L);
                localBundle.putLong("tempRandom", 0L);
                break label615;
              }
              localBundle.putLong("tempEct", paramFromServiceMsg.last_msgtime.get());
              localBundle.putLong("tempRandom", paramFromServiceMsg.random.get());
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
      l1 = 0L;
    }
  }
  
  /* Error */
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 965
    //   7: invokevirtual 969	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 11
    //   12: new 122	java/util/HashMap
    //   15: dup
    //   16: iconst_1
    //   17: invokespecial 946	java/util/HashMap:<init>	(I)V
    //   20: astore 5
    //   22: aload 5
    //   24: ldc_w 948
    //   27: aload_1
    //   28: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 950
    //   34: invokevirtual 953	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 957	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 5
    //   43: ldc_w 959
    //   46: aload_1
    //   47: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   50: ldc_w 961
    //   53: invokevirtual 636	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   56: invokestatic 524	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokevirtual 957	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload 5
    //   65: ldc_w 963
    //   68: iload 11
    //   70: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 957	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: new 1374	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   80: dup
    //   81: invokespecial 1375	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:<init>	()V
    //   84: astore 4
    //   86: aload 4
    //   88: aload_3
    //   89: checkcast 677	[B
    //   92: checkcast 677	[B
    //   95: invokevirtual 1376	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1374	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +67 -> 172
    //   108: new 1378	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   111: dup
    //   112: invokespecial 1379	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:<init>	()V
    //   115: astore_3
    //   116: aload 4
    //   118: getfield 1382	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 423	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   124: ifeq +139 -> 263
    //   127: aload_3
    //   128: aload 4
    //   130: getfield 1382	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 435	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokevirtual 1383	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   142: checkcast 1378	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   145: astore_3
    //   146: aload_3
    //   147: ifnonnull +121 -> 268
    //   150: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +12 -> 165
    //   156: ldc 8
    //   158: iconst_2
    //   159: ldc_w 1385
    //   162: invokestatic 975	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iconst_0
    //   169: invokespecial 1387	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   172: return
    //   173: astore_3
    //   174: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 8
    //   182: iconst_2
    //   183: ldc_w 1389
    //   186: aload_3
    //   187: invokestatic 379	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: astore 4
    //   193: goto -90 -> 103
    //   196: astore_3
    //   197: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 8
    //   205: iconst_2
    //   206: ldc_w 1391
    //   209: aload_3
    //   210: invokestatic 379	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aconst_null
    //   214: astore 4
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 8
    //   228: iconst_2
    //   229: ldc_w 1393
    //   232: aload_3
    //   233: invokestatic 379	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aconst_null
    //   237: astore_3
    //   238: goto -92 -> 146
    //   241: astore_3
    //   242: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +13 -> 258
    //   248: ldc 8
    //   250: iconst_2
    //   251: ldc_w 1395
    //   254: aload_3
    //   255: invokestatic 379	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -114 -> 146
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -119 -> 146
    //   268: aload_3
    //   269: getfield 1397	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:result	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   272: invokevirtual 746	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   275: istore 12
    //   277: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +41 -> 321
    //   283: ldc 8
    //   285: iconst_2
    //   286: new 119	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 1399
    //   296: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 12
    //   301: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc_w 1401
    //   307: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload 11
    //   312: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 975	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: iload 12
    //   323: ifeq +9 -> 332
    //   326: iload 12
    //   328: iconst_1
    //   329: if_icmpne +699 -> 1028
    //   332: aload 4
    //   334: getfield 1402	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   337: invokevirtual 97	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   340: astore 6
    //   342: aload 6
    //   344: ifnonnull +19 -> 363
    //   347: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq -178 -> 172
    //   353: ldc 8
    //   355: iconst_2
    //   356: ldc_w 1404
    //   359: invokestatic 975	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: return
    //   363: new 72	java/util/ArrayList
    //   366: dup
    //   367: invokespecial 73	java/util/ArrayList:<init>	()V
    //   370: astore 7
    //   372: aload_0
    //   373: aload 6
    //   375: aload 7
    //   377: invokespecial 117	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Ljava/util/List;Ljava/util/List;)V
    //   380: aload_0
    //   381: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   384: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   387: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   390: lstore 17
    //   392: new 125	com/tencent/mobileqq/service/message/DecodeProtoPkgContext
    //   395: dup
    //   396: lload 17
    //   398: lconst_0
    //   399: iconst_1
    //   400: iconst_1
    //   401: iconst_0
    //   402: iconst_0
    //   403: invokespecial 134	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:<init>	(JJZZZZ)V
    //   406: astore 8
    //   408: aload 8
    //   410: iconst_1
    //   411: putfield 250	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:h	Z
    //   414: new 72	java/util/ArrayList
    //   417: dup
    //   418: invokespecial 73	java/util/ArrayList:<init>	()V
    //   421: astore 4
    //   423: aload 7
    //   425: invokevirtual 257	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   428: astore 9
    //   430: aload 9
    //   432: invokeinterface 262 1 0
    //   437: ifeq +253 -> 690
    //   440: aload 9
    //   442: invokeinterface 266 1 0
    //   447: checkcast 147	msf/msgcomm/msg_comm$Msg
    //   450: astore_2
    //   451: aload_2
    //   452: ifnull +23 -> 475
    //   455: aload_2
    //   456: getfield 151	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   459: invokevirtual 167	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   462: ifeq +13 -> 475
    //   465: aload_2
    //   466: getfield 160	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   469: invokevirtual 416	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   472: ifne +113 -> 585
    //   475: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq -48 -> 430
    //   481: new 119	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 1406
    //   491: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: astore 10
    //   496: aload_2
    //   497: ifnonnull +45 -> 542
    //   500: ldc_w 1408
    //   503: astore_2
    //   504: ldc 8
    //   506: iconst_2
    //   507: aload 10
    //   509: aload_2
    //   510: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: goto -89 -> 430
    //   522: astore_2
    //   523: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq -96 -> 430
    //   529: ldc 8
    //   531: iconst_2
    //   532: ldc_w 1410
    //   535: aload_2
    //   536: invokestatic 379	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   539: goto -109 -> 430
    //   542: new 119	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1412
    //   552: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_2
    //   556: getfield 151	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   559: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   562: ldc_w 1414
    //   565: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_2
    //   569: getfield 160	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   572: invokevirtual 416	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   575: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   578: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore_2
    //   582: goto -78 -> 504
    //   585: aload_2
    //   586: getfield 151	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   589: invokevirtual 156	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   592: checkcast 153	msf/msgcomm/msg_comm$MsgHead
    //   595: astore 10
    //   597: aload 10
    //   599: getfield 194	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   602: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   605: lstore 13
    //   607: aload 10
    //   609: getfield 201	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   612: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   615: lstore 15
    //   617: lload 13
    //   619: lload 17
    //   621: lcmp
    //   622: ifeq +414 -> 1036
    //   625: lload 15
    //   627: lload 17
    //   629: lcmp
    //   630: ifeq +406 -> 1036
    //   633: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq -206 -> 430
    //   639: ldc 8
    //   641: iconst_2
    //   642: ldc_w 1416
    //   645: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto -218 -> 430
    //   651: aload 8
    //   653: lload 13
    //   655: putfield 248	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:jdField_e_of_type_Long	J
    //   658: aload_0
    //   659: aload_2
    //   660: aload 8
    //   662: invokevirtual 253	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/service/message/PBDecodeContext;)Ljava/util/ArrayList;
    //   665: astore_2
    //   666: aload_2
    //   667: ifnull -237 -> 430
    //   670: aload_2
    //   671: invokevirtual 1261	java/util/ArrayList:isEmpty	()Z
    //   674: ifne -244 -> 430
    //   677: aload 4
    //   679: aload_2
    //   680: invokevirtual 1260	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   683: pop
    //   684: goto -254 -> 430
    //   687: goto -36 -> 651
    //   690: aload 4
    //   692: invokevirtual 142	java/util/ArrayList:size	()I
    //   695: ifle +16 -> 711
    //   698: aload 4
    //   700: new 1418	qlh
    //   703: dup
    //   704: aload_0
    //   705: invokespecial 1419	qlh:<init>	(Lcom/tencent/mobileqq/app/message/C2CMessageProcessor;)V
    //   708: invokestatic 808	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   711: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq +63 -> 777
    //   717: ldc 8
    //   719: iconst_2
    //   720: new 119	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 1421
    //   730: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 6
    //   735: invokeinterface 103 1 0
    //   740: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   743: ldc_w 1423
    //   746: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 7
    //   751: invokevirtual 142	java/util/ArrayList:size	()I
    //   754: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   757: ldc_w 1425
    //   760: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload 4
    //   765: invokevirtual 142	java/util/ArrayList:size	()I
    //   768: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   771: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 975	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload_3
    //   778: getfield 1428	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   781: invokevirtual 1429	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   784: ifeq +124 -> 908
    //   787: aload_3
    //   788: getfield 1428	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   791: invokevirtual 97	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   794: astore_2
    //   795: aload_2
    //   796: ifnull +117 -> 913
    //   799: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +34 -> 836
    //   805: ldc 8
    //   807: iconst_2
    //   808: new 119	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   815: ldc_w 1431
    //   818: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload_2
    //   822: invokeinterface 103 1 0
    //   827: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 975	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   836: aload 4
    //   838: invokevirtual 142	java/util/ArrayList:size	()I
    //   841: ifne +126 -> 967
    //   844: iload 12
    //   846: iconst_1
    //   847: if_icmpeq +120 -> 967
    //   850: aload_1
    //   851: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   854: ldc_w 971
    //   857: invokevirtual 969	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   860: istore 12
    //   862: iload 12
    //   864: iconst_4
    //   865: if_icmpge +66 -> 931
    //   868: aload_0
    //   869: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   872: invokevirtual 978	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   875: iload 11
    //   877: aconst_null
    //   878: aload_1
    //   879: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   882: ldc_w 950
    //   885: invokevirtual 953	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   888: aload_1
    //   889: getfield 631	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   892: ldc_w 961
    //   895: invokevirtual 636	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   898: aload_2
    //   899: iload 12
    //   901: iconst_1
    //   902: iadd
    //   903: lconst_0
    //   904: invokevirtual 1434	com/tencent/mobileqq/app/MessageHandler:a	(ILjava/util/List;Ljava/lang/String;JLjava/util/List;IJ)V
    //   907: return
    //   908: aconst_null
    //   909: astore_2
    //   910: goto -115 -> 795
    //   913: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   916: ifeq -80 -> 836
    //   919: ldc 8
    //   921: iconst_2
    //   922: ldc_w 1436
    //   925: invokestatic 975	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: goto -92 -> 836
    //   931: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   934: ifeq +12 -> 946
    //   937: ldc 8
    //   939: iconst_2
    //   940: ldc_w 1438
    //   943: invokestatic 975	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: aload 5
    //   948: ldc_w 1440
    //   951: aload_2
    //   952: invokevirtual 957	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   955: pop
    //   956: aload_0
    //   957: sipush 8015
    //   960: iconst_0
    //   961: aload 5
    //   963: invokevirtual 651	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   966: return
    //   967: aload 5
    //   969: ldc_w 1440
    //   972: aload_2
    //   973: invokevirtual 957	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   976: pop
    //   977: aload 5
    //   979: ldc_w 1442
    //   982: aload 4
    //   984: invokevirtual 957	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   987: pop
    //   988: iload 12
    //   990: iconst_1
    //   991: if_icmpne +31 -> 1022
    //   994: iconst_1
    //   995: istore 19
    //   997: aload 5
    //   999: ldc_w 1444
    //   1002: iload 19
    //   1004: invokestatic 732	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1007: invokevirtual 957	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1010: pop
    //   1011: aload_0
    //   1012: sipush 8015
    //   1015: iconst_1
    //   1016: aload 5
    //   1018: invokevirtual 651	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1021: return
    //   1022: iconst_0
    //   1023: istore 19
    //   1025: goto -28 -> 997
    //   1028: aload_0
    //   1029: aload_1
    //   1030: aload_2
    //   1031: iconst_0
    //   1032: invokespecial 1387	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   1035: return
    //   1036: lload 13
    //   1038: lload 17
    //   1040: lcmp
    //   1041: ifne -354 -> 687
    //   1044: lload 15
    //   1046: lstore 13
    //   1048: goto -397 -> 651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1051	0	this	C2CMessageProcessor
    //   0	1051	1	paramToServiceMsg	ToServiceMsg
    //   0	1051	2	paramFromServiceMsg	FromServiceMsg
    //   0	1051	3	paramObject	Object
    //   84	899	4	localObject1	Object
    //   20	997	5	localHashMap	HashMap
    //   340	394	6	localList	List
    //   370	380	7	localArrayList	ArrayList
    //   406	255	8	localDecodeProtoPkgContext	DecodeProtoPkgContext
    //   428	13	9	localIterator	Iterator
    //   494	114	10	localObject2	Object
    //   10	866	11	i1	int
    //   275	717	12	i2	int
    //   605	442	13	l1	long
    //   615	430	15	l2	long
    //   390	649	17	l3	long
    //   995	29	19	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   86	103	173	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   86	103	196	java/lang/OutOfMemoryError
    //   127	146	219	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   127	146	241	java/lang/OutOfMemoryError
    //   455	475	522	java/lang/Exception
    //   475	496	522	java/lang/Exception
    //   504	519	522	java/lang/Exception
    //   542	582	522	java/lang/Exception
    //   585	617	522	java/lang/Exception
    //   633	648	522	java/lang/Exception
    //   651	666	522	java/lang/Exception
    //   670	684	522	java/lang/Exception
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_uid_" + l1 + "_seq_" + l2;
  }
  
  public ArrayList a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    if (!(paramPBDecodeContext instanceof DecodeProtoPkgContext)) {
      return new ArrayList();
    }
    DecodeProtoPkgContext localDecodeProtoPkgContext = (DecodeProtoPkgContext)paramPBDecodeContext;
    long l4 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        paramPBDecodeContext = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
        if (paramMsg != null) {
          break label104;
        }
      }
      label104:
      for (paramMsg = " msg=null";; paramMsg = " msg.msg_head:" + paramMsg.msg_head + " msg.msg_body:" + paramMsg.msg_body.has())
      {
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramMsg);
        return localArrayList;
      }
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i8 = (short)localMsgHead.msg_seq.get();
    long l2 = localMsgHead.to_uin.get();
    long l5 = localMsgHead.from_uin.get();
    long l3 = localMsgHead.msg_time.get();
    long l6 = localMsgHead.msg_uid.get();
    int i7 = localMsgHead.msg_type.get();
    int i1 = paramMsg.msg_head.c2c_cmd.get();
    int i5;
    int i4;
    int i3;
    if (paramMsg.content_head.has())
    {
      paramPBDecodeContext = (msg_comm.ContentHead)paramMsg.content_head.get();
      i5 = paramPBDecodeContext.div_seq.get();
      i4 = paramPBDecodeContext.pkg_num.get();
      i3 = paramPBDecodeContext.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      paramPBDecodeContext = null;
      int i2;
      label410:
      Object localObject1;
      if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
      {
        paramPBDecodeContext = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), String.valueOf(l5));
        if (((Long)paramPBDecodeContext.first).longValue() != 4294967295L) {
          l1 = ((Long)paramPBDecodeContext.first).longValue();
        }
      }
      else
      {
        localDecodeProtoPkgContext.jdField_b_of_type_Long = l5;
        localDecodeProtoPkgContext.jdField_c_of_type_Long = l3;
        i2 = MessageProtoCodec.a(paramMsg);
        localDecodeProtoPkgContext.jdField_a_of_type_Int = i2;
        localDecodeProtoPkgContext.jdField_d_of_type_Long = SVIPHandler.a((int)l1, i2);
        if (l5 != localDecodeProtoPkgContext.jdField_a_of_type_Long) {
          break label1050;
        }
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = true;
        localDecodeProtoPkgContext.f = true;
        if (!QLog.isColorLevel()) {
          break label1070;
        }
        localObject1 = new StringBuilder();
        localObject3 = ((StringBuilder)localObject1).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l3).append(" shortSeq:").append(i8).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l6).append(" toUin:").append(l2).append(" senderUin:").append(l5).append(" friendUin:").append(localDecodeProtoPkgContext.jdField_e_of_type_Long).append(" isReaded:").append(localDecodeProtoPkgContext.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localDecodeProtoPkgContext.f).append(" msgType:").append(i7).append(" C2CCmd:").append(i1).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:");
        if (paramPBDecodeContext != null) {
          break label1059;
        }
        paramPBDecodeContext = "nullPair";
        label610:
        ((StringBuilder)localObject3).append(paramPBDecodeContext).append(" longMsgID:").append(i5).append(" longMsgCount:").append(i4).append(" longMsgIndex:").append(i3).append("init_direction_flag").append(0);
        QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        label670:
        paramPBDecodeContext = new ArrayList();
        if ((i7 != 140) && (i7 != 141) && ((i7 != 529) || (localMsgHead.c2c_cmd.get() != 6))) {
          break label1145;
        }
        i2 = 1;
        localObject1 = MessageProtoCodec.a(paramMsg);
        if (((TempSessionInfo)localObject1).b != -1) {
          break label1092;
        }
        i1 = 0;
        label734:
        if (i1 == 0) {
          break label1142;
        }
        i1 = ((TempSessionInfo)localObject1).jdField_c_of_type_Int;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject1, localDecodeProtoPkgContext);
        i2 = ((TempSessionInfo)localObject1).b;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "friendType:" + i2 + ", direction_flag:" + i1);
        }
      }
      for (;;)
      {
        if ((paramPBDecodeContext.size() == 0) && (i4 > 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
          }
          localObject1 = (MessageForText)MessageRecordFactory.a(64536);
          ((MessageForText)localObject1).msgtype = 64536;
          ((MessageForText)localObject1).msg = "";
          paramPBDecodeContext.add(localObject1);
        }
        l1 = -1L;
        l2 = l1;
        for (;;)
        {
          try
          {
            localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
            l3 = l1;
            if (localObject1 == null) {
              continue;
            }
            l3 = l1;
            l2 = l1;
            if (((List)localObject1).size() <= 0) {
              continue;
            }
            i6 = 0;
            l3 = l1;
            l2 = l1;
            if (i6 >= ((List)localObject1).size()) {
              continue;
            }
            l2 = l1;
            localObject3 = (im_msg_body.Elem)((List)localObject1).get(i6);
            l2 = l1;
            if (!((im_msg_body.Elem)localObject3).elem_flags2.has()) {
              continue;
            }
            l2 = l1;
            if (!((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject3).elem_flags2.get()).uint64_msg_id.has()) {
              continue;
            }
            l2 = l1;
            l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject3).elem_flags2.get()).uint64_msg_id.get();
          }
          catch (Throwable localThrowable)
          {
            boolean bool1;
            boolean bool2;
            int i9;
            Object localObject4;
            QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", localThrowable);
            l1 = l2;
            continue;
            MsgProxyUtils.a((MessageRecord)localObject4, false);
            continue;
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f().equals(localThrowable.rUin)) {
              continue;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
            continue;
            paramPBDecodeContext = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
            if ((paramPBDecodeContext == null) || (!paramPBDecodeContext.lock_display.has()) || (paramPBDecodeContext.lock_display.get() != 1)) {
              continue;
            }
            ((MessageRecord)localObject4).extLong |= 0x1;
            ((MessageRecord)localObject4).saveExtInfoToExtStr("lockDisplay", "true");
            if ((i2 != 0) || (!(localObject4 instanceof MessageForPic))) {
              continue;
            }
            ((MessageForPic)localObject4).bEnableEnc = true;
            if (i2 != 1006) {
              continue;
            }
            if (!localMsgHead.from_nick.has()) {
              continue;
            }
            ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), (short)0, localMsgHead.from_nick.get(), "");
            ((MessageRecord)localObject4).frienduin = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long));
            ((MessageRecord)localObject4).senderuin = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l5));
            if ((!TextUtils.isEmpty(((MessageRecord)localObject4).frienduin)) || (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)) {
              continue;
            }
            ((MessageRecord)localObject4).frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
            if (((MessageRecord)localObject4).frienduin != null) {
              continue;
            }
            QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), Long.valueOf(l5), Integer.valueOf(((MessageRecord)localObject4).istroop), Integer.valueOf(((MessageRecord)localObject4).msgtype) }));
            continue;
            if (!localDecodeProtoPkgContext.f) {
              continue;
            }
            ((MessageRecord)localObject4).issend = 2;
            ((MessageRecord)localObject4).isread = true;
            if (!(localObject4 instanceof MessageForPoke)) {
              continue;
            }
            if ((((MessageRecord)localObject4).isread) || (((MessageRecord)localObject4).isSend())) {
              continue;
            }
            ((MessageForPoke)localObject4).isPlayed = false;
            ((MessageForPoke)localObject4).initMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            ((MessageRecord)localObject4).vipBubbleID = localDecodeProtoPkgContext.jdField_d_of_type_Long;
            ((MessageRecord)localObject4).vipBubbleDiyTextId = localDecodeProtoPkgContext.jdField_a_of_type_Int;
            if (((MessageRecord)localObject4).istroop != 1008) {
              continue;
            }
            MessageForApollo localMessageForApollo;
            ApolloManager localApolloManager;
            try
            {
              if (localMsgHead.public_account_group_send_flag.has()) {
                ((MessageRecord)localObject4).saveExtInfoToExtStr("public_account_send_flag", String.valueOf(localMsgHead.public_account_group_send_flag.get()));
              }
              if (l1 != -1L) {
                ((MessageRecord)localObject4).saveExtInfoToExtStr("public_account_msg_id", String.valueOf(l1));
              }
              if ((localObject4 instanceof MessageForStructing))
              {
                paramPBDecodeContext = (MessageForStructing)localObject4;
                if ((paramPBDecodeContext.structingMsg != null) && (paramPBDecodeContext.structingMsg.mMsgServiceID == 500))
                {
                  if (!ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject4)) {
                    continue;
                  }
                  ((MessageRecord)localObject4).time = NetConnInfoCenter.getServerTime();
                }
                if ((paramPBDecodeContext.structingMsg != null) && (paramPBDecodeContext.structingMsg.mMsgServiceID == 76)) {
                  ((NowLiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170)).a(paramPBDecodeContext);
                }
              }
              localArrayList.add(localObject4);
              i6 = KandianMergeManager.a((MessageRecord)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((i6 == 0) || (i6 == 1))
              {
                paramPBDecodeContext = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a((MessageRecord)localObject4);
                if (paramPBDecodeContext != null) {
                  localArrayList.add(paramPBDecodeContext);
                }
              }
              if (((MessageRecord)localObject4).msgtype == 63497)
              {
                localMessageForApollo = (MessageForApollo)localObject4;
                localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
                paramPBDecodeContext = null;
                if (QLog.isColorLevel()) {
                  paramPBDecodeContext = new StringBuilder("decode apollo c2c msg: ").append(", id: ").append(localMessageForApollo.mApolloMessage.id).append(", name: ").append(new String(localMessageForApollo.mApolloMessage.name)).append(", doubleAction: ").append(localMessageForApollo.isDoubleAction());
                }
                i9 = localMessageForApollo.isSend();
                if (localMessageForApollo.mApolloMessage.peer_uin == 0L) {
                  continue;
                }
                i6 = 1;
                if (((i6 & i9) == 0) || (localMessageForApollo.mApolloMessage.peer_uin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
                  continue;
                }
                localObject2 = localApolloManager.b(localMessageForApollo.mApolloMessage.peer_uin + "");
                l2 = localMessageForApollo.mApolloMessage.peer_ts;
                i6 = localMessageForApollo.mApolloMessage.peer_status;
                if ((QLog.isColorLevel()) && (localObject2 != null)) {
                  paramPBDecodeContext.append("\n fuin: ").append(((ApolloBaseInfo)localObject2).uin).append(", msg time: ").append(((MessageRecord)localObject4).time).append(", msg ts: ").append(l2).append(", svr ts: ").append(((ApolloBaseInfo)localObject2).apolloServerTS).append(", update time: ").append(((ApolloBaseInfo)localObject2).apolloUpdateTime).append(", status: ").append(i6);
                }
                if ((localObject2 != null) && (((MessageRecord)localObject4).time > ((ApolloBaseInfo)localObject2).apolloUpdateTime) && (((ApolloBaseInfo)localObject2).apolloServerTS < l2))
                {
                  ((ApolloBaseInfo)localObject2).apolloStatus = i6;
                  ((ApolloBaseInfo)localObject2).apolloServerTS = l2;
                  ((ApolloBaseInfo)localObject2).apolloVipFlag = (localMessageForApollo.mApolloMessage.flag >> 30 & 0x1);
                  ((ApolloBaseInfo)localObject2).apolloUpdateTime = ((MessageRecord)localObject4).time;
                  localApolloManager.a((ApolloBaseInfo)localObject2);
                  if (QLog.isColorLevel()) {
                    paramPBDecodeContext.append("\n save apollo info fuin: ").append(((ApolloBaseInfo)localObject2).uin).append("-->").append(((ApolloBaseInfo)localObject2).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject2).apolloStatus).append("|").append(((ApolloBaseInfo)localObject2).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject2).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject2).apolloUpdateTime);
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.C2CMessageProcessor", 2, paramPBDecodeContext.toString());
                }
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                {
                  i6 = localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
                  VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", 0, 0, new String[] { String.valueOf(localMessageForApollo.mApolloMessage.id), Integer.toString(i6), Integer.toString(ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) });
                }
              }
              if (!localMsgHead.msg_inst_ctrl.has()) {
                continue;
              }
              paramPBDecodeContext = (im_msg_head.InstCtrl)localMsgHead.msg_inst_ctrl.get();
              if ((paramPBDecodeContext == null) || (!paramPBDecodeContext.msg_from_inst.has())) {
                continue;
              }
              paramPBDecodeContext = (im_msg_head.InstInfo)paramPBDecodeContext.msg_from_inst.get();
              if ((paramPBDecodeContext == null) || (!paramPBDecodeContext.uint32_apppid.has()) || (paramPBDecodeContext.uint32_apppid.get() != 1029)) {
                continue;
              }
              ((MessageRecord)localObject4).saveExtInfoToExtStr("is_from_tim", String.valueOf(true));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.C2CMessageProcessor", 2, "msg is from tim, shmsgseq=" + ((MessageRecord)localObject4).shmsgseq);
              continue;
              if (((MessageRecord)localObject4).msgtype == 63499) {
                continue;
              }
              ((MessageRecord)localObject4).isread = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
            }
            catch (Throwable paramPBDecodeContext)
            {
              QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", paramPBDecodeContext);
              continue;
              ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPBDecodeContext);
            }
            continue;
            int i6 = 0;
            continue;
            Object localObject2 = localApolloManager.b(localMessageForApollo.senderuin);
            l2 = localMessageForApollo.mApolloMessage.sender_ts;
            i6 = localMessageForApollo.mApolloMessage.sender_status;
            continue;
            paramPBDecodeContext = localArrayList.iterator();
            if (!paramPBDecodeContext.hasNext()) {
              continue;
            }
            localObject2 = (MessageRecord)paramPBDecodeContext.next();
            if ((localObject2 == null) || (!(localObject2 instanceof MessageForBitApp))) {
              continue;
            }
            i1 = 1;
            if (i1 == 0) {
              continue;
            }
            ((BitAppManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(143)).a(localArrayList);
            if ((i2 != 1008) || (!paramMsg.msg_body.has())) {
              continue;
            }
            paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
            if (!paramMsg.rich_text.has()) {
              continue;
            }
            paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
            if (!paramMsg.elems.has()) {
              continue;
            }
            paramMsg = paramMsg.elems.get().iterator();
            if (!paramMsg.hasNext()) {
              continue;
            }
            paramPBDecodeContext = (im_msg_body.Elem)paramMsg.next();
            if (!paramPBDecodeContext.pub_acc_info.has()) {
              continue;
            }
            i1 = paramPBDecodeContext.pub_acc_info.uint32_is_inter_num.get();
            paramMsg = paramPBDecodeContext.pub_acc_info.string_msg_template_id.get();
            if (i1 == 0) {
              continue;
            }
            paramPBDecodeContext = localArrayList.iterator();
            if (!paramPBDecodeContext.hasNext()) {
              continue;
            }
            ((MessageRecord)paramPBDecodeContext.next()).saveExtInfoToExtStr("inter_num", String.valueOf(i1));
            continue;
            paramPBDecodeContext = localArrayList.iterator();
            if (!paramPBDecodeContext.hasNext()) {
              continue;
            }
            ((MessageRecord)paramPBDecodeContext.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
            continue;
            MsgAutoMonitorUtil.a().f(System.currentTimeMillis() - l4);
            return localArrayList;
            i1 = 0;
            continue;
            continue;
            i1 = 0;
            continue;
            i1 = 0;
            continue;
          }
          i6 += 1;
        }
        l1 = ((Long)paramPBDecodeContext.second).longValue();
        break;
        label1050:
        localDecodeProtoPkgContext.f = false;
        break label410;
        label1059:
        paramPBDecodeContext = (Serializable)paramPBDecodeContext.first;
        break label610;
        label1070:
        if (localDecodeProtoPkgContext.jdField_e_of_type_Long != 0L) {
          break label670;
        }
        QLog.e("Q.msg.C2CMessageProcessor", 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
        break label670;
        label1092:
        if ((((TempSessionInfo)localObject1).b != 1000) && (((TempSessionInfo)localObject1).b != 1020))
        {
          i1 = i2;
          if (((TempSessionInfo)localObject1).b != 1004) {
            break label734;
          }
        }
        localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject1).jdField_c_of_type_Long;
        i1 = i2;
        break label734;
        label1142:
        return localArrayList;
        label1145:
        if (paramMsg.appshare_info.has())
        {
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, 0L, 0L, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
          i2 = 0;
          i1 = 0;
        }
        else
        {
          if ((MessageUtils.c(i7)) && (localMsgHead.c2c_cmd.has())) {}
          switch (i1)
          {
          default: 
            i2 = 0;
            i1 = 0;
            break;
          case 169: 
          case 241: 
          case 242: 
          case 243: 
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, i1, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean, localDecodeProtoPkgContext.jdField_a_of_type_Int);
            i2 = 0;
            i1 = 0;
            break;
          case 11: 
          case 175: 
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
            i2 = 0;
            i1 = 0;
            break;
          case 193: 
            i2 = 0;
            i1 = 0;
            break;
          case 129: 
          case 131: 
          case 133: 
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Int);
            i2 = 0;
            i1 = 0;
            continue;
            if (i7 == 208)
            {
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg);
              i2 = 0;
              i1 = 0;
            }
            else
            {
              if (i7 == 193)
              {
                if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
                {
                  MessageProtoCodec.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext);
                  i2 = 0;
                  i1 = 0;
                }
              }
              else
              {
                if (i7 == 734)
                {
                  MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext);
                  i2 = 0;
                  i1 = 0;
                  continue;
                }
                if (i7 == 562)
                {
                  MessageProtoCodec.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext);
                  i2 = 0;
                  i1 = 0;
                  continue;
                }
                if (i7 == 519)
                {
                  if ((!localDecodeProtoPkgContext.jdField_d_of_type_Boolean) && (VideoConstants.jdField_a_of_type_Boolean))
                  {
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f);
                    i2 = 0;
                    i1 = 0;
                  }
                }
                else
                {
                  if (SystemMsg.isSystemMessage(i7))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.systemmsg.", 2, "friend system msg notify");
                    }
                    i1 = 0;
                    if ((i7 == 188) || (i7 == 189)) {
                      i1 = 1;
                    }
                    if ((!localDecodeProtoPkgContext.jdField_c_of_type_Boolean) && (i1 == 0)) {
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
                    }
                    localDecodeProtoPkgContext.jdField_e_of_type_Long = 9998L;
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Boolean, i8);
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i8, l6, i7);
                    return localArrayList;
                  }
                  if (a(i7))
                  {
                    a(paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                    i2 = 0;
                    i1 = 0;
                    continue;
                  }
                  if (732 == i7)
                  {
                    a(paramPBDecodeContext, paramMsg, i8, l5, l6, i7, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                    i2 = 0;
                    i1 = 0;
                    continue;
                  }
                  if (524 == i7)
                  {
                    if ((paramPBDecodeContext == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {
                      return localArrayList;
                    }
                    localObject1 = paramMsg.msg_body.msg_content.get().toByteArray();
                    PkgTools.a((byte[])localObject1, 0);
                    if ((localObject1[4] == 25) && (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)) {
                      DiscMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, false);
                    }
                    i2 = 0;
                    i1 = 0;
                    continue;
                  }
                  if (SystemMsg.isTroopSystemMessage(i7))
                  {
                    i1 = 0;
                    if ((i7 == 85) || (i7 == 36)) {
                      i1 = 1;
                    }
                    if ((!localDecodeProtoPkgContext.jdField_c_of_type_Boolean) && (i1 == 0)) {
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
                    }
                    localDecodeProtoPkgContext.jdField_e_of_type_Long = 9998L;
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                    if (i1 == 0) {
                      GroupSystemMsgController.a().a(l5, l3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                    return localArrayList;
                  }
                  if (i7 == 528)
                  {
                    if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
                    {
                      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localDecodeProtoPkgContext.jdField_a_of_type_Long, paramMsg, localDecodeProtoPkgContext.h, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                      i2 = 0;
                      i1 = 0;
                    }
                  }
                  else
                  {
                    if (i7 == 529)
                    {
                      if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
                        break label4693;
                      }
                      i2 = 1;
                      localObject1 = MessageProtoCodec.a(paramMsg);
                      if (((TempSessionInfo)localObject1).b == -1)
                      {
                        i1 = 0;
                        label2094:
                        if (i1 == 0) {
                          break label4687;
                        }
                        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject1, localDecodeProtoPkgContext);
                        i1 = ((TempSessionInfo)localObject1).b;
                        if (i1 == 1006) {
                          QLog.e("Q.msg.C2CMessageProcessor", 1, "decodeMessage FileMsg, tempInfo has Uin [" + ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).from_phone.has() + "]");
                        }
                        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
                        l1 = localDecodeProtoPkgContext.jdField_e_of_type_Long;
                        bool1 = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
                        bool2 = localDecodeProtoPkgContext.jdField_b_of_type_Boolean;
                        if (l5 != localDecodeProtoPkgContext.jdField_a_of_type_Long) {
                          break label2314;
                        }
                      }
                      label2314:
                      for (i9 = 1;; i9 = 0)
                      {
                        MessageProtoCodec.a((MessageHandler)localObject1, paramPBDecodeContext, paramMsg, l1, bool1, bool2, i9, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean, localDecodeProtoPkgContext.jdField_a_of_type_Int);
                        i6 = 0;
                        i2 = i1;
                        i1 = i6;
                        break;
                        if ((((TempSessionInfo)localObject1).b != 1000) && (((TempSessionInfo)localObject1).b != 1020))
                        {
                          i1 = i2;
                          if (((TempSessionInfo)localObject1).b != 1004) {
                            break label2094;
                          }
                        }
                        localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject1).jdField_c_of_type_Long;
                        i1 = i2;
                        break label2094;
                      }
                    }
                    if (i7 == 38)
                    {
                      localObject1 = String.valueOf(EndianUtil.a(paramMsg.msg_body.msg_content.get().toByteArray()));
                      localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                      if ((localObject3 != null) && (((TroopManager)localObject3).a((String)localObject1) == null))
                      {
                        localObject4 = new TroopInfo();
                        ((TroopInfo)localObject4).troopuin = ((String)localObject1);
                        ((TroopInfo)localObject4).dwAdditionalFlag = 1L;
                        ((TroopManager)localObject3).b((TroopInfo)localObject4);
                      }
                      localObject3 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                      if (localObject3 != null) {
                        ((TroopHandler)localObject3).a((String)localObject1, Boolean.valueOf(true));
                      }
                      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i8, l6, i7);
                    }
                  }
                }
              }
              i2 = 0;
              i1 = 0;
            }
            break;
          }
        }
      }
      l1 = l3;
      Object localObject3 = paramPBDecodeContext.iterator();
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label4399;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        if ((localObject4 != null) && ((localDecodeProtoPkgContext.jdField_b_of_type_Long != 3338705755L) || (!PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((localDecodeProtoPkgContext.jdField_b_of_type_Long != 2171946401L) || (!ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))
        {
          if (localDecodeProtoPkgContext.jdField_b_of_type_Long == 2171946401L) {
            PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
          }
          if (((i2 != 1025) && (i2 != 1024)) || (((MessageRecord)localObject4).msgtype != 64536) || (!((MessageRecord)localObject4).msg.startsWith("default:SigT=")))
          {
            ((MessageRecord)localObject4).selfuin = String.valueOf(localDecodeProtoPkgContext.jdField_a_of_type_Long);
            ((MessageRecord)localObject4).frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
            ((MessageRecord)localObject4).senderuin = String.valueOf(localDecodeProtoPkgContext.jdField_b_of_type_Long);
            ((MessageRecord)localObject4).time = localDecodeProtoPkgContext.jdField_c_of_type_Long;
            ((MessageRecord)localObject4).shmsgseq = i8;
            ((MessageRecord)localObject4).msgUid = l6;
            ((MessageRecord)localObject4).istroop = i2;
            ((MessageRecord)localObject4).longMsgId = i5;
            ((MessageRecord)localObject4).longMsgCount = i4;
            ((MessageRecord)localObject4).longMsgIndex = i3;
            if ((1 != i1) || (!MsgProxyUtils.s(((MessageRecord)localObject4).istroop)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject4).frienduin)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).frienduin, MsgProxyUtils.a(((MessageRecord)localObject4).istroop), MsgProxyUtils.a(MsgProxyUtils.a(((MessageRecord)localObject4).istroop))))) {
              break;
            }
            MsgProxyUtils.a((MessageRecord)localObject4, true);
            if ((!MsgProxyUtils.s(i2)) || (!(localObject4 instanceof MessageForStructing))) {
              break label3065;
            }
            i6 = GiftMessageUtils.a((MessageRecord)localObject4, 1);
            if (i6 > 0) {
              ((MessageRecord)localObject4).saveExtInfoToExtStr("nearby_gift_msg", "1|" + String.valueOf(i6));
            }
            localObject1 = (MessageForStructing)localObject4;
            if (((MessageForStructing)localObject1).structingMsg.mMsgServiceID != 52) {
              break label3065;
            }
            paramPBDecodeContext = (NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(123);
            if (paramPBDecodeContext == null) {
              break label3065;
            }
            localObject1 = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localObject1);
            paramPBDecodeContext.a((NearbyFlowerMessage)localObject1, false);
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f().equals(((NearbyFlowerMessage)localObject1).sUin)) {
              break label3009;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
            if (!"4".equals(((NearbyFlowerMessage)localObject1).version)) {
              break label3065;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
            }
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i8, l6, i7);
          }
        }
      }
      label3009:
      label3065:
      label4399:
      label4687:
      label4693:
      i3 = 0;
      i4 = 0;
      i5 = 0;
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, false);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processType" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2005: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(MessageForPtt paramMessageForPtt1, MessageForPtt paramMessageForPtt2)
  {
    if ((paramMessageForPtt1.getPttStreamFlag() == 10001) && (!TextUtils.isEmpty(paramMessageForPtt2.directUrl)) && (TextUtils.isEmpty(paramMessageForPtt1.directUrl))) {}
    for (;;)
    {
      try
      {
        paramMessageForPtt1.directUrl = paramMessageForPtt2.directUrl;
        paramMessageForPtt1.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt1.frienduin, paramMessageForPtt1.istroop, paramMessageForPtt1.uniseq, paramMessageForPtt1.msgData);
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "updateStreamPttDirectUrl : " + bool);
        }
        return;
      }
      catch (Exception paramMessageForPtt1)
      {
        paramMessageForPtt1.printStackTrace();
      }
      boolean bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == 62530) || (localMessageRecord.msgtype == 60532))
      {
        PAMessage localPAMessage = XMLMessageUtils.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
  }
  
  public void a(ArrayList paramArrayList, msg_comm.Msg paramMsg, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {}
    Object localObject;
    int i1;
    do
    {
      do
      {
        byte[] arrayOfByte1;
        do
        {
          do
          {
            return;
            arrayOfByte1 = paramMsg.msg_body.msg_content.get().toByteArray();
            localObject = new byte[arrayOfByte1.length];
            PkgTools.a((byte[])localObject, 0, arrayOfByte1, 0, localObject.length);
          } while (localObject.length < 5);
          i1 = localObject[4];
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<---hotchat and opentroop push  groupCode:" + PkgTools.a(arrayOfByte1, 0) + " subType:" + i1);
          }
          if ((i1 != 12) && (i1 != 14)) {
            break;
          }
        } while (!((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a((byte[])localObject, paramInt1));
        return;
        if ((i1 != 16) && (i1 != 17)) {
          break;
        }
        if (arrayOfByte1.length > 7)
        {
          localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
          byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 7];
          PkgTools.a(arrayOfByte2, 0, arrayOfByte1, 7, arrayOfByte2.length);
          paramArrayList.add(((TroopTipsMsgMgr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, arrayOfByte2, paramInt1, paramMsg.msg_head.msg_time.get(), true, paramBoolean));
        }
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong1, paramInt1, paramLong2, paramInt2);
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.C2CMessageProcessor", 2, String.format("handle0x2dcMessage==>sendDelMsgReqToServer fromUin:%d, seq:%d, msgUid:%d, msgType:%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) }));
      return;
    } while (i1 != 3);
    a((byte[])localObject);
  }
  
  /* Error */
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 142	java/util/ArrayList:size	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: invokestatic 2152	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: aload_0
    //   16: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   22: invokestatic 2157	com/tencent/mobileqq/activity/UserguideActivity:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: ifne -14 -> 11
    //   28: invokestatic 2152	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   31: invokevirtual 2161	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   34: aload_0
    //   35: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokestatic 2166	com/tencent/mobileqq/util/NoDisturbUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   41: ifeq -30 -> 11
    //   44: aload_1
    //   45: invokevirtual 257	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_3
    //   49: aload_3
    //   50: invokeinterface 262 1 0
    //   55: ifeq +1567 -> 1622
    //   58: aload_3
    //   59: invokeinterface 266 1 0
    //   64: checkcast 268	com/tencent/mobileqq/data/MessageRecord
    //   67: astore 4
    //   69: aload 4
    //   71: getfield 282	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   74: invokestatic 1758	com/tencent/mobileqq/app/message/MsgProxyUtils:s	(I)Z
    //   77: ifeq -28 -> 49
    //   80: aload 4
    //   82: invokestatic 2168	com/tencent/mobileqq/app/message/MsgProxyUtils:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   85: ifeq -36 -> 49
    //   88: aload_0
    //   89: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: aload 4
    //   94: invokestatic 2170	com/tencent/mobileqq/app/message/MsgProxyUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   97: ifne -48 -> 49
    //   100: aload 4
    //   102: invokevirtual 1861	com/tencent/mobileqq/data/MessageRecord:isSend	()Z
    //   105: ifne -56 -> 49
    //   108: aload 4
    //   110: getfield 1084	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   113: ifne -64 -> 49
    //   116: iconst_1
    //   117: istore 10
    //   119: iload 10
    //   121: ifeq -110 -> 11
    //   124: aload_0
    //   125: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   128: bipush 50
    //   130: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   133: checkcast 810	com/tencent/mobileqq/app/FriendsManager
    //   136: aload_0
    //   137: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   140: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   143: invokevirtual 2173	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   146: astore_3
    //   147: aload_0
    //   148: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   151: invokevirtual 336	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   154: astore 6
    //   156: aload_3
    //   157: ifnonnull +556 -> 713
    //   160: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +1453 -> 1616
    //   166: ldc 8
    //   168: iconst_2
    //   169: ldc_w 2175
    //   172: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: iconst_1
    //   176: istore 11
    //   178: aload_0
    //   179: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: bipush 105
    //   184: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   187: checkcast 2177	com/tencent/mobileqq/nearby/NearbyCardManager
    //   190: invokevirtual 2178	com/tencent/mobileqq/nearby/NearbyCardManager:a	()Z
    //   193: istore 13
    //   195: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +42 -> 240
    //   201: ldc_w 2180
    //   204: iconst_2
    //   205: new 119	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 2182
    //   215: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 11
    //   220: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: ldc_w 2184
    //   226: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload 13
    //   231: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   234: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: getfield 2185	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_Boolean	Z
    //   244: ifne +285 -> 529
    //   247: invokestatic 2190	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   250: getstatic 2196	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayDateMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   253: invokevirtual 2198	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   256: invokevirtual 2200	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 4
    //   261: invokestatic 2190	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   264: getstatic 2203	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayLBSFriendMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   267: invokevirtual 2198	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   270: invokevirtual 2200	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   273: astore_3
    //   274: aload 4
    //   276: ldc_w 2205
    //   279: invokevirtual 2209	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   282: astore 4
    //   284: aload_3
    //   285: ldc_w 2205
    //   288: invokevirtual 2209	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   291: astore_3
    //   292: aload 4
    //   294: arraylength
    //   295: bipush 6
    //   297: if_icmplt +227 -> 524
    //   300: aload_3
    //   301: arraylength
    //   302: bipush 6
    //   304: if_icmplt +220 -> 524
    //   307: aload_0
    //   308: aload 4
    //   310: iconst_0
    //   311: aaload
    //   312: invokestatic 2212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   315: putfield 48	com/tencent/mobileqq/app/message/C2CMessageProcessor:e	I
    //   318: aload_0
    //   319: aload 4
    //   321: iconst_1
    //   322: aaload
    //   323: invokestatic 2212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   326: putfield 50	com/tencent/mobileqq/app/message/C2CMessageProcessor:f	I
    //   329: aload_0
    //   330: aload 4
    //   332: iconst_2
    //   333: aaload
    //   334: invokestatic 2212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   337: putfield 52	com/tencent/mobileqq/app/message/C2CMessageProcessor:g	I
    //   340: aload_0
    //   341: aload 4
    //   343: iconst_3
    //   344: aaload
    //   345: invokestatic 2212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   348: putfield 54	com/tencent/mobileqq/app/message/C2CMessageProcessor:h	I
    //   351: aload_0
    //   352: aload_3
    //   353: iconst_0
    //   354: aaload
    //   355: invokestatic 2212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   358: putfield 56	com/tencent/mobileqq/app/message/C2CMessageProcessor:k	I
    //   361: aload_0
    //   362: aload_3
    //   363: iconst_1
    //   364: aaload
    //   365: invokestatic 2212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   368: putfield 58	com/tencent/mobileqq/app/message/C2CMessageProcessor:l	I
    //   371: aload_0
    //   372: aload_3
    //   373: iconst_2
    //   374: aaload
    //   375: invokestatic 2212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   378: putfield 60	com/tencent/mobileqq/app/message/C2CMessageProcessor:m	I
    //   381: aload_0
    //   382: aload_3
    //   383: iconst_3
    //   384: aaload
    //   385: invokestatic 2212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   388: putfield 62	com/tencent/mobileqq/app/message/C2CMessageProcessor:n	I
    //   391: invokestatic 2215	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   394: ifeq +130 -> 524
    //   397: ldc_w 2217
    //   400: iconst_4
    //   401: new 119	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 2219
    //   411: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_0
    //   415: getfield 48	com/tencent/mobileqq/app/message/C2CMessageProcessor:e	I
    //   418: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: ldc_w 1975
    //   424: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: getfield 50	com/tencent/mobileqq/app/message/C2CMessageProcessor:f	I
    //   431: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: ldc_w 1975
    //   437: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_0
    //   441: getfield 52	com/tencent/mobileqq/app/message/C2CMessageProcessor:g	I
    //   444: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: ldc_w 1975
    //   450: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_0
    //   454: getfield 54	com/tencent/mobileqq/app/message/C2CMessageProcessor:h	I
    //   457: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc_w 2221
    //   463: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: getfield 56	com/tencent/mobileqq/app/message/C2CMessageProcessor:k	I
    //   470: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: ldc_w 1975
    //   476: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: getfield 58	com/tencent/mobileqq/app/message/C2CMessageProcessor:l	I
    //   483: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   486: ldc_w 1975
    //   489: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: getfield 60	com/tencent/mobileqq/app/message/C2CMessageProcessor:m	I
    //   496: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: ldc_w 1975
    //   502: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload_0
    //   506: getfield 62	com/tencent/mobileqq/app/message/C2CMessageProcessor:n	I
    //   509: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: ldc_w 1691
    //   515: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: aload_0
    //   525: iconst_1
    //   526: putfield 2185	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_Boolean	Z
    //   529: invokestatic 2152	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   532: new 119	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   539: aload_0
    //   540: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   543: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   546: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 2223
    //   552: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: iconst_0
    //   559: invokevirtual 2227	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   562: astore 7
    //   564: ldc_w 361
    //   567: astore 4
    //   569: ldc_w 361
    //   572: astore 5
    //   574: aload 4
    //   576: astore_3
    //   577: aload_0
    //   578: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   581: ifnonnull +143 -> 724
    //   584: aload_0
    //   585: monitorenter
    //   586: aload 4
    //   588: astore_3
    //   589: aload_0
    //   590: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   593: ifnonnull +129 -> 722
    //   596: aload_0
    //   597: new 39	java/util/HashSet
    //   600: dup
    //   601: invokespecial 42	java/util/HashSet:<init>	()V
    //   604: putfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   607: aload 7
    //   609: new 119	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   616: aload_0
    //   617: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   620: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   623: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc_w 2229
    //   629: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: ldc_w 361
    //   638: invokeinterface 2234 3 0
    //   643: astore 4
    //   645: aload 4
    //   647: ldc_w 2205
    //   650: invokevirtual 2209	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   653: astore 8
    //   655: aload 8
    //   657: arraylength
    //   658: istore 12
    //   660: iconst_0
    //   661: istore 10
    //   663: aload 4
    //   665: astore_3
    //   666: iload 10
    //   668: iload 12
    //   670: if_icmpge +52 -> 722
    //   673: aload 8
    //   675: iload 10
    //   677: aaload
    //   678: astore_3
    //   679: aload_3
    //   680: invokevirtual 585	java/lang/String:length	()I
    //   683: ifle +21 -> 704
    //   686: aload_3
    //   687: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   690: lconst_0
    //   691: lcmp
    //   692: ifle +12 -> 704
    //   695: aload_0
    //   696: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   699: aload_3
    //   700: invokevirtual 2235	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   703: pop
    //   704: iload 10
    //   706: iconst_1
    //   707: iadd
    //   708: istore 10
    //   710: goto -47 -> 663
    //   713: aload_3
    //   714: getfield 2240	com/tencent/mobileqq/data/Card:shGender	S
    //   717: istore 11
    //   719: goto -541 -> 178
    //   722: aload_0
    //   723: monitorexit
    //   724: aload 5
    //   726: astore 4
    //   728: aload_0
    //   729: getfield 66	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   732: ifnonnull +145 -> 877
    //   735: aload_0
    //   736: monitorenter
    //   737: aload 5
    //   739: astore 4
    //   741: aload_0
    //   742: getfield 66	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   745: ifnonnull +130 -> 875
    //   748: aload_0
    //   749: new 39	java/util/HashSet
    //   752: dup
    //   753: invokespecial 42	java/util/HashSet:<init>	()V
    //   756: putfield 66	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   759: aload 7
    //   761: new 119	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   768: aload_0
    //   769: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   772: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   775: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: ldc_w 2242
    //   781: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: ldc_w 361
    //   790: invokeinterface 2234 3 0
    //   795: astore 5
    //   797: aload 5
    //   799: ldc_w 2205
    //   802: invokevirtual 2209	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   805: astore 8
    //   807: aload 8
    //   809: arraylength
    //   810: istore 12
    //   812: iconst_0
    //   813: istore 10
    //   815: aload 5
    //   817: astore 4
    //   819: iload 10
    //   821: iload 12
    //   823: if_icmpge +52 -> 875
    //   826: aload 8
    //   828: iload 10
    //   830: aaload
    //   831: astore 4
    //   833: aload 4
    //   835: invokevirtual 585	java/lang/String:length	()I
    //   838: ifle +23 -> 861
    //   841: aload 4
    //   843: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   846: lconst_0
    //   847: lcmp
    //   848: ifle +13 -> 861
    //   851: aload_0
    //   852: getfield 66	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   855: aload 4
    //   857: invokevirtual 2235	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   860: pop
    //   861: iload 10
    //   863: iconst_1
    //   864: iadd
    //   865: istore 10
    //   867: goto -52 -> 815
    //   870: astore_1
    //   871: aload_0
    //   872: monitorexit
    //   873: aload_1
    //   874: athrow
    //   875: aload_0
    //   876: monitorexit
    //   877: aload_1
    //   878: invokevirtual 257	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   881: astore 8
    //   883: aload 4
    //   885: astore_1
    //   886: aload 8
    //   888: invokeinterface 262 1 0
    //   893: ifeq -882 -> 11
    //   896: aload 8
    //   898: invokeinterface 266 1 0
    //   903: checkcast 268	com/tencent/mobileqq/data/MessageRecord
    //   906: astore 9
    //   908: aload_1
    //   909: astore 5
    //   911: aload_0
    //   912: aload 9
    //   914: invokevirtual 2244	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   917: ifeq +627 -> 1544
    //   920: aload_1
    //   921: astore 5
    //   923: aload 6
    //   925: ifnull +619 -> 1544
    //   928: aload 9
    //   930: getfield 282	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   933: sipush 1010
    //   936: if_icmpne +335 -> 1271
    //   939: aload_3
    //   940: astore 4
    //   942: aload_0
    //   943: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   946: aload 9
    //   948: getfield 339	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   951: invokevirtual 2245	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   954: ifne +85 -> 1039
    //   957: aload_0
    //   958: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   961: aload 9
    //   963: getfield 339	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   966: invokevirtual 2235	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   969: pop
    //   970: aload_3
    //   971: invokevirtual 585	java/lang/String:length	()I
    //   974: ifne +233 -> 1207
    //   977: aload 9
    //   979: getfield 339	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   982: astore_3
    //   983: aload 7
    //   985: invokeinterface 2249 1 0
    //   990: new 119	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   997: aload_0
    //   998: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1001: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1004: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: ldc_w 2229
    //   1010: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: aload_3
    //   1017: invokeinterface 2254 3 0
    //   1022: pop
    //   1023: aload 7
    //   1025: invokeinterface 2249 1 0
    //   1030: invokeinterface 2257 1 0
    //   1035: pop
    //   1036: aload_3
    //   1037: astore 4
    //   1039: iload 11
    //   1041: ifne +207 -> 1248
    //   1044: iload 13
    //   1046: ifeq +193 -> 1239
    //   1049: aload_0
    //   1050: getfield 52	com/tencent/mobileqq/app/message/C2CMessageProcessor:g	I
    //   1053: istore 10
    //   1055: aload_0
    //   1056: aload_0
    //   1057: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1060: invokevirtual 2258	java/util/HashSet:size	()I
    //   1063: putfield 2260	com/tencent/mobileqq/app/message/C2CMessageProcessor:i	I
    //   1066: aload_0
    //   1067: getfield 2260	com/tencent/mobileqq/app/message/C2CMessageProcessor:i	I
    //   1070: iload 10
    //   1072: irem
    //   1073: ifne +113 -> 1186
    //   1076: aload_0
    //   1077: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1080: aload 9
    //   1082: iload_2
    //   1083: invokevirtual 2261	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1086: aload_0
    //   1087: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1090: invokevirtual 2262	java/util/HashSet:clear	()V
    //   1093: aload 7
    //   1095: invokeinterface 2249 1 0
    //   1100: new 119	java/lang/StringBuilder
    //   1103: dup
    //   1104: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1107: aload_0
    //   1108: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1111: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1114: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: ldc_w 2229
    //   1120: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1126: invokeinterface 2265 2 0
    //   1131: pop
    //   1132: aload 7
    //   1134: invokeinterface 2249 1 0
    //   1139: invokeinterface 2257 1 0
    //   1144: pop
    //   1145: iload 13
    //   1147: ifeq +39 -> 1186
    //   1150: aload_0
    //   1151: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1154: ldc_w 1805
    //   1157: ldc_w 361
    //   1160: ldc_w 361
    //   1163: ldc_w 2267
    //   1166: ldc_w 2267
    //   1169: iconst_0
    //   1170: iconst_0
    //   1171: ldc_w 361
    //   1174: ldc_w 361
    //   1177: ldc_w 361
    //   1180: ldc_w 361
    //   1183: invokestatic 1812	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1186: aload_1
    //   1187: astore_3
    //   1188: aload 4
    //   1190: astore_1
    //   1191: aload_1
    //   1192: astore 4
    //   1194: aload_3
    //   1195: astore_1
    //   1196: aload 4
    //   1198: astore_3
    //   1199: goto -313 -> 886
    //   1202: astore_1
    //   1203: aload_0
    //   1204: monitorexit
    //   1205: aload_1
    //   1206: athrow
    //   1207: new 119	java/lang/StringBuilder
    //   1210: dup
    //   1211: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1214: aload_3
    //   1215: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: ldc_w 1975
    //   1221: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: aload 9
    //   1226: getfield 339	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1229: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1235: astore_3
    //   1236: goto -253 -> 983
    //   1239: aload_0
    //   1240: getfield 48	com/tencent/mobileqq/app/message/C2CMessageProcessor:e	I
    //   1243: istore 10
    //   1245: goto -190 -> 1055
    //   1248: iload 13
    //   1250: ifeq +12 -> 1262
    //   1253: aload_0
    //   1254: getfield 54	com/tencent/mobileqq/app/message/C2CMessageProcessor:h	I
    //   1257: istore 10
    //   1259: goto -204 -> 1055
    //   1262: aload_0
    //   1263: getfield 50	com/tencent/mobileqq/app/message/C2CMessageProcessor:f	I
    //   1266: istore 10
    //   1268: goto -213 -> 1055
    //   1271: aload_1
    //   1272: astore 5
    //   1274: aload 9
    //   1276: getfield 282	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1279: sipush 1001
    //   1282: if_icmpne +262 -> 1544
    //   1285: aload_1
    //   1286: astore 4
    //   1288: aload_0
    //   1289: getfield 66	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1292: aload 9
    //   1294: getfield 339	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1297: invokevirtual 2245	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1300: ifne +85 -> 1385
    //   1303: aload_0
    //   1304: getfield 66	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1307: aload 9
    //   1309: getfield 339	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1312: invokevirtual 2235	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1315: pop
    //   1316: aload_1
    //   1317: invokevirtual 585	java/lang/String:length	()I
    //   1320: ifne +232 -> 1552
    //   1323: aload 9
    //   1325: getfield 339	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1328: astore_1
    //   1329: aload 7
    //   1331: invokeinterface 2249 1 0
    //   1336: new 119	java/lang/StringBuilder
    //   1339: dup
    //   1340: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1343: aload_0
    //   1344: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1347: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1350: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: ldc_w 2242
    //   1356: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1362: aload_1
    //   1363: invokeinterface 2254 3 0
    //   1368: pop
    //   1369: aload 7
    //   1371: invokeinterface 2249 1 0
    //   1376: invokeinterface 2257 1 0
    //   1381: pop
    //   1382: aload_1
    //   1383: astore 4
    //   1385: iload 11
    //   1387: ifne +206 -> 1593
    //   1390: iload 13
    //   1392: ifeq +192 -> 1584
    //   1395: aload_0
    //   1396: getfield 60	com/tencent/mobileqq/app/message/C2CMessageProcessor:m	I
    //   1399: istore 10
    //   1401: aload_0
    //   1402: aload_0
    //   1403: getfield 66	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1406: invokevirtual 2258	java/util/HashSet:size	()I
    //   1409: putfield 2269	com/tencent/mobileqq/app/message/C2CMessageProcessor:o	I
    //   1412: aload 4
    //   1414: astore 5
    //   1416: aload_0
    //   1417: getfield 2269	com/tencent/mobileqq/app/message/C2CMessageProcessor:o	I
    //   1420: iload 10
    //   1422: irem
    //   1423: ifne +121 -> 1544
    //   1426: aload_0
    //   1427: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1430: aload 9
    //   1432: iload_2
    //   1433: invokevirtual 2261	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1436: aload_0
    //   1437: getfield 66	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1440: invokevirtual 2262	java/util/HashSet:clear	()V
    //   1443: aload 7
    //   1445: invokeinterface 2249 1 0
    //   1450: new 119	java/lang/StringBuilder
    //   1453: dup
    //   1454: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1457: aload_0
    //   1458: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1461: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1464: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: ldc_w 2242
    //   1470: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: invokeinterface 2265 2 0
    //   1481: pop
    //   1482: aload 7
    //   1484: invokeinterface 2249 1 0
    //   1489: invokeinterface 2257 1 0
    //   1494: pop
    //   1495: aload 4
    //   1497: astore 5
    //   1499: iload 13
    //   1501: ifeq +43 -> 1544
    //   1504: aload_0
    //   1505: getfield 76	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1508: ldc_w 1805
    //   1511: ldc_w 361
    //   1514: ldc_w 361
    //   1517: ldc_w 2267
    //   1520: ldc_w 2267
    //   1523: iconst_0
    //   1524: iconst_0
    //   1525: ldc_w 361
    //   1528: ldc_w 361
    //   1531: ldc_w 361
    //   1534: ldc_w 361
    //   1537: invokestatic 1812	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1540: aload 4
    //   1542: astore 5
    //   1544: aload_3
    //   1545: astore_1
    //   1546: aload 5
    //   1548: astore_3
    //   1549: goto -358 -> 1191
    //   1552: new 119	java/lang/StringBuilder
    //   1555: dup
    //   1556: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1559: aload_1
    //   1560: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: ldc_w 1975
    //   1566: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload 9
    //   1571: getfield 339	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1574: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: astore_1
    //   1581: goto -252 -> 1329
    //   1584: aload_0
    //   1585: getfield 56	com/tencent/mobileqq/app/message/C2CMessageProcessor:k	I
    //   1588: istore 10
    //   1590: goto -189 -> 1401
    //   1593: iload 13
    //   1595: ifeq +12 -> 1607
    //   1598: aload_0
    //   1599: getfield 62	com/tencent/mobileqq/app/message/C2CMessageProcessor:n	I
    //   1602: istore 10
    //   1604: goto -203 -> 1401
    //   1607: aload_0
    //   1608: getfield 58	com/tencent/mobileqq/app/message/C2CMessageProcessor:l	I
    //   1611: istore 10
    //   1613: goto -212 -> 1401
    //   1616: iconst_1
    //   1617: istore 11
    //   1619: goto -1441 -> 178
    //   1622: iconst_0
    //   1623: istore 10
    //   1625: goto -1506 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1628	0	this	C2CMessageProcessor
    //   0	1628	1	paramArrayList	ArrayList
    //   0	1628	2	paramBoolean	boolean
    //   48	1501	3	localObject1	Object
    //   67	1474	4	localObject2	Object
    //   572	975	5	localObject3	Object
    //   154	770	6	localQQMessageFacade	QQMessageFacade
    //   562	921	7	localSharedPreferences	android.content.SharedPreferences
    //   653	244	8	localObject4	Object
    //   906	664	9	localMessageRecord	MessageRecord
    //   117	1507	10	i1	int
    //   176	1442	11	i2	int
    //   658	166	12	i3	int
    //   193	1401	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   589	660	870	finally
    //   679	704	870	finally
    //   722	724	870	finally
    //   871	873	870	finally
    //   741	812	1202	finally
    //   833	861	1202	finally
    //   875	877	1202	finally
    //   1203	1205	1202	finally
  }
  
  public void a(List paramList, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    long l1 = Utils.a(paramMsg, 0);
    int i1 = paramMsg[4];
    long l2 = Utils.a(paramMsg, 5);
    i1 = paramMsg[9];
    long l3 = Utils.a(paramMsg, 10);
    int i2 = paramMsg[14];
    try
    {
      new String(paramMsg, 15, i2, "GBK");
      if (!paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, String.valueOf(l2), String.valueOf(l3), l1, paramList.msg_time.get(), paramList.msg_seq.get(), paramList);
        paramMsg = new ArrayList();
        paramMsg.add(new Pair(Long.valueOf(paramList.from_uin.get()), Long.valueOf(paramList.msg_time.get())));
        ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("c2c_processor")).b(paramMsg);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new String(paramMsg, 15, i2);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 33;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 1001)) {}
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) || ((paramMessageRecord.istroop == 1001) && (paramMessageRecord.msgtype == 62535)) || (!MsgProxyUtils.c(paramMessageRecord)) || (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))) {
      return false;
    }
    return true;
  }
  
  public boolean a(ArrayList paramArrayList)
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
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((MsgProxyUtils.c(localMessageRecord)) && (!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))) || (localMessageRecord.istroop == 7100));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, true);
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("-ReportList-");
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Pair localPair = (Pair)paramArrayList.next();
      msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      localUinPairReadInfo.peer_uin.set(((Long)localPair.first).longValue());
      localUinPairReadInfo.last_read_time.set(((Long)localPair.second).intValue());
      localStringBuilder.append("-uin:").append(localPair.first).append("-ReadTime-").append(localPair.second);
      localPbC2CReadedReportReq.pair_info.add(localUinPairReadInfo);
    }
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if (paramArrayList != null) {
      localPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
    }
    localPbMsgReadedReportReq.c2c_read_report.set(localPbC2CReadedReportReq);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><S>_C2C:" + localStringBuilder.toString());
    }
    a(localPbMsgReadedReportReq);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\C2CMessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */