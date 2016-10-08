package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import PushNotifyPack.DisMsgReadedNotify;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import qlo;
import qlp;
import qlq;
import qmb;
import tencent.im.conf.sysmsg_0x20c_0x20.Convert2Group;
import tencent.im.conf.sysmsg_0x20c_0x20.MemberNumRemind;
import tencent.im.conf.sysmsg_0x20c_0x20.SysMsgBody;
import tencent.im.conf.sysmsg_0x20c_0x20.UploadFileRemind;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef;
import tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder;
import tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder.MessageMeta;
import tencent.im.oidb.cmd0x858.oidb_0x858.NotifyMsgBody;
import tencent.im.oidb.cmd0x858.oidb_0x858.NotifyObjmsgUpdate;
import tencent.im.oidb.cmd0x858.oidb_0x858.RedGrayTipsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class DiscMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  public static final byte a = 1;
  public static final byte b = 2;
  public static final byte c = 3;
  public static final String c = "Q.msg.DiscMsgPc";
  public static final byte d = 6;
  public static final byte e = 9;
  public static final int e = 50;
  public static final byte f = 10;
  public static final int f = 1;
  public static final byte g = 11;
  public static final int g = 2;
  public static final byte h = 15;
  public static final byte i = 24;
  public static final byte j = 25;
  public static final byte k = 7;
  public static final byte l = 22;
  public static final byte m = 32;
  public static final byte n = 34;
  private final Timer a;
  public final ConcurrentHashMap a;
  public qlq a;
  
  public DiscMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
    this.jdField_a_of_type_Qlq = new qlq(this, null);
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    Object localObject6 = paramMsgInfo.vMsg;
    long l2 = paramMsgInfo.lFromUin;
    long l1 = PkgTools.a((byte[])localObject6, 0);
    byte b1 = localObject6[4];
    Object localObject5 = new ArrayList();
    Object localObject4 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject7 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg cOpType: " + b1 + ", dwConfUin=" + l1);
    }
    Object localObject3;
    long l3;
    int i3;
    int i2;
    long l4;
    long l5;
    switch (b1)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 6: 
    case 9: 
      do
      {
        do
        {
          return null;
          paramLong = PkgTools.a((byte[])localObject6, 5);
          l2 = PkgTools.a((byte[])localObject6, 9);
          new StringBuilder().append(String.valueOf(l1)).append("_").append(String.valueOf(paramLong)).toString();
          if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 0)) {
            localObject3 = (String)paramMsgInfo.vNickName.get(0);
          }
          if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 1)) {
            localObject3 = (String)paramMsgInfo.vNickName.get(1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l2);
          }
          if (a(l2, l1, paramMsgInfo.shMsgSeq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg memberChangeMsgFilter return");
            }
            return null;
          }
          if (!String.valueOf(paramLong).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
            ((DiscussionHandler)localObject4).a(String.valueOf(paramLong), l1);
          }
          ((DiscussionHandler)localObject4).a(l1);
          i1 = ((DiscussionManager)localObject7).a(l1 + "");
        } while (((DiscussionManager)localObject7).a(String.valueOf(l1), String.valueOf(l2)));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionUpdateMsg add discussion " + l1 + " member number by 1 " + l2 + " num: " + i1);
        }
        paramMsgInfo = new DiscussionMemberInfo();
        paramMsgInfo.discussionUin = String.valueOf(l1);
        paramMsgInfo.memberUin = String.valueOf(l2);
        paramMsgInfo.flag = 0;
        localObject1 = ((FriendsManager)localObject1).c(String.valueOf(l2));
        if ((localObject1 != null) && (((Friends)localObject1).name != null)) {
          paramMsgInfo.memberName = ((Friends)localObject1).name;
        }
        ((DiscussionManager)localObject7).a(paramMsgInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg setDiscussionMemberNum memnum" + i1);
        }
        return null;
        l3 = PkgTools.a((byte[])localObject6, 5);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l3);
        }
        localObject6 = String.valueOf(l3);
        if (a(l3, l1, paramMsgInfo.shMsgSeq)) {
          return null;
        }
        localObject3 = "";
        localObject1 = localObject3;
        if (paramMsgInfo.vNickName != null)
        {
          localObject1 = localObject3;
          if (paramMsgInfo.vNickName.size() > 0) {
            localObject1 = (String)paramMsgInfo.vNickName.get(0);
          }
        }
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
          }
          localObject3 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), (String)localObject6);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368273, new Object[] { localObject3 });
        ((List)localObject5).add(localObject6);
        ((DiscussionHandler)localObject4).a(l1, (String)localObject6, (List)localObject5, 10009);
        if (((String)localObject6).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
        {
          ((DiscussionManager)localObject7).a(String.valueOf(l1), String.valueOf(l3));
          a(b1, l1, l3);
          ((DiscussionHandler)localObject4).a(String.valueOf(l1));
          return null;
        }
        ((DiscussionHandler)localObject4).a(l1);
        ((DiscussionManager)localObject7).a(String.valueOf(l1), String.valueOf(l3));
        a(paramMsgInfo, paramLong, l2, l2, (String)localObject1);
        return null;
        localObject1 = paramMsgInfo.getVNickName();
        l2 = PkgTools.a((byte[])localObject6, 5);
        i3 = PkgTools.a((byte[])localObject6, 13);
        localObject3 = new ArrayList();
        i2 = 15;
        for (i1 = 1; i1 < i3 + 1; i1 = (short)(i1 + 1))
        {
          localObject7 = (String)((ArrayList)localObject1).get(i1);
          l3 = PkgTools.a((byte[])localObject6, i2);
          i2 += 4;
          ((List)localObject5).add(String.valueOf(l3));
          ((ArrayList)localObject3).add(new Pair(String.valueOf(l3), localObject7));
          ((DiscussionHandler)localObject4).a(String.valueOf(l3), l1);
        }
        ((DiscussionHandler)localObject4).a(l1, String.valueOf(l2), (List)localObject5, 10004);
        localObject4 = new Pair(Long.valueOf(l2), ((ArrayList)localObject1).get(0));
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (((RecentUserProxy)localObject6).b(Long.toString(l1), 3000) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru alreadyintab");
          }
          a((Pair)localObject4, paramMsgInfo, (ArrayList)localObject3, paramLong, String.valueOf(l1), b1, false);
          return null;
        }
        localObject5 = ((RecentUserProxy)localObject6).a(Long.toString(l1), 3000);
        RecentUtil.a((RecentUser)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        ((RecentUser)localObject5).uin = Long.toString(l1);
        ((RecentUser)localObject5).lastmsgtime = paramMsgInfo.uRealMsgTime;
        ((RecentUser)localObject5).type = 3000;
        ((RecentUserProxy)localObject6).a((RecentUser)localObject5);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru.lastmsgtime " + paramMsgInfo.uRealMsgTime);
        }
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (SelectMemberActivity.h)
        {
          SelectMemberActivity.h = false;
          a((Pair)localObject4, paramMsgInfo, (ArrayList)localObject3, paramLong, String.valueOf(l1), b1, true);
        }
        for (;;)
        {
          return null;
          if (TextUtils.equals((CharSequence)localObject6, String.valueOf(l2)))
          {
            a((ArrayList)localObject1, ((RecentUser)localObject5).uin, (String)localObject6, (String)localObject6);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Show_discuss_tips", 0, 0, "", "", "", "");
          }
          else
          {
            a((Pair)localObject4, paramMsgInfo, (ArrayList)localObject3, paramLong, String.valueOf(l1), b1, true);
          }
        }
        l2 = PkgTools.a((byte[])localObject6, 5);
        l3 = PkgTools.a((byte[])localObject6, 9);
        PkgTools.a((byte[])localObject6, 13);
        i1 = PkgTools.a((byte[])localObject6, 17);
        localObject1 = new byte[i1];
        PkgTools.b((byte[])localObject6, 19, (byte[])localObject1, i1);
        localObject5 = new String((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:" + b1 + "dwCmdUin =" + l2 + " dwCmdTime=" + l3 + " strName=" + (String)localObject5);
        }
        if (l2 == paramLong) {}
        for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131370140, new Object[] { localObject5 });; localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131370141, new Object[] { localObject3, localObject5 }))
        {
          ((DiscussionHandler)localObject4).a(String.valueOf(l1), (String)localObject5);
          a(paramMsgInfo, paramLong, l1, l2, (String)localObject1);
          return null;
          localObject3 = "";
          localObject1 = localObject3;
          if (paramMsgInfo.vNickName != null)
          {
            localObject1 = localObject3;
            if (paramMsgInfo.vNickName.size() > 0) {
              localObject1 = (String)paramMsgInfo.vNickName.get(0);
            }
          }
          localObject3 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 6 server opeaterName empty");
            }
            localObject3 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), String.valueOf(l2));
          }
        }
      } while (PkgTools.a((byte[])localObject6, 5) == 0);
      i3 = PkgTools.a((byte[])localObject6, 7);
      localObject4 = new ArrayList();
      i1 = 9;
      i2 = 0;
      while (i2 < i3)
      {
        l3 = PkgTools.a((byte[])localObject6, i1);
        localObject3 = "";
        localObject1 = localObject3;
        if (paramMsgInfo.vNickName != null)
        {
          localObject1 = localObject3;
          if (paramMsgInfo.vNickName.size() >= i3) {
            localObject1 = (String)paramMsgInfo.vNickName.get(i2);
          }
        }
        ((ArrayList)localObject4).add(new Pair(Long.valueOf(l3), localObject1));
        i1 += 4;
        i2 += 1;
      }
      i2 = PkgTools.a((byte[])localObject6, i1);
      localObject1 = new byte[i2];
      PkgTools.b((byte[])localObject6, i1 + 2, (byte[])localObject1, i2);
      localObject1 = new String((byte[])localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +uinList.size()=" + ((ArrayList)localObject4).size());
      }
      localObject3 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (Pair)((Iterator)localObject3).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +遍历uin uin=" + ((Pair)localObject5).first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +sTips=" + (String)localObject1 + "+lUin=" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilTimer.schedule(new qlo(this, (ArrayList)localObject4, paramLong, l1, (String)localObject1, paramMsgInfo, l2), 2000L);
      return null;
    case 22: 
      l3 = PkgTools.a((byte[])localObject6, 5);
      PkgTools.a((byte[])localObject6, 9);
      l4 = PkgTools.a((byte[])localObject6, 13);
      l5 = PkgTools.a((byte[])localObject6, 17);
      if (l5 == 0L) {
        break;
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      localObject3 = "";
      localObject1 = localObject3;
      if (paramMsgInfo.vNickName != null)
      {
        localObject1 = localObject3;
        if (paramMsgInfo.vNickName.size() >= 1) {
          localObject1 = (String)paramMsgInfo.vNickName.get(0);
        }
      }
      localObject7 = new Pair(Long.valueOf(l3), localObject1);
      Object localObject8;
      Object localObject9;
      switch ((int)l4)
      {
      default: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (((RecentUserProxy)localObject1).b(Long.toString(l1), 3000) != null) {
          return null;
        }
        break;
      case 0: 
      case 1: 
      case 2: 
        i3 = PkgTools.a((byte[])localObject6, 25);
        i2 = 27;
        localObject3 = "";
        localObject1 = localObject3;
        if (i1 != 0)
        {
          localObject1 = localObject3;
          if (paramMsgInfo.vNickName != null)
          {
            localObject1 = localObject3;
            if (paramMsgInfo.vNickName.size() >= 2) {
              localObject1 = (String)paramMsgInfo.vNickName.get(1);
            }
          }
        }
        localObject8 = new Pair(Long.valueOf(l5), localObject1);
        ((DiscussionHandler)localObject4).a(l1);
        localObject9 = new ArrayList();
        if (i1 != 0) {}
        for (i1 = 1;; i1 = 0)
        {
          int i4 = i1 + 1;
          i1 = 0;
          while (i1 < i3)
          {
            String str = String.valueOf(PkgTools.a((byte[])localObject6, i2));
            localObject3 = "";
            localObject1 = localObject3;
            if (paramMsgInfo.vNickName != null)
            {
              localObject1 = localObject3;
              if (paramMsgInfo.vNickName.size() >= i3 + i4) {
                localObject1 = (String)paramMsgInfo.vNickName.get(i1 + i4);
              }
            }
            ((ArrayList)localObject9).add(new Pair(str, localObject1));
            ((List)localObject5).add(str);
            ((DiscussionHandler)localObject4).a(str, l1);
            i2 += 4;
            i1 += 1;
          }
        }
        i1 = 0;
        if (l4 == 0L) {
          i1 = 10007;
        }
        for (;;)
        {
          ((DiscussionHandler)localObject4).a(l1, String.valueOf(l3), (List)localObject5, i1);
          this.jdField_a_of_type_JavaUtilTimer.schedule(new qlp(this, l3, paramLong, (Pair)localObject7, paramMsgInfo, l1, l2, b1, l4, (Pair)localObject8, (ArrayList)localObject9), 2000L);
          break;
          if (l4 == 1L) {
            i1 = 10006;
          } else if (l4 == 2L) {
            i1 = 10008;
          }
        }
      }
      localObject3 = ((RecentUserProxy)localObject1).a(Long.toString(l1), 3000);
      ((RecentUser)localObject3).uin = Long.toString(l1);
      ((RecentUser)localObject3).lastmsgtime = paramMsgInfo.uRealMsgTime;
      ((RecentUser)localObject3).type = 3000;
      ((RecentUserProxy)localObject1).a((RecentUser)localObject3);
      return null;
      i1 = localObject6.length - 5;
      localObject1 = new byte[i1];
      PkgTools.b((byte[])localObject6, 5, (byte[])localObject1, i1);
      localObject3 = new oidb_0x858.NotifyMsgBody();
      paramMsgInfo = (MessageForQQWalletTips)MessageRecordFactory.a(63507);
      try
      {
        ((oidb_0x858.NotifyMsgBody)localObject3).mergeFrom((byte[])localObject1);
        localObject1 = (oidb_0x858.RedGrayTipsInfo)((oidb_0x858.NotifyMsgBody)localObject3).opt_msg_redtips.get();
        paramMsgInfo.senderUin = (((oidb_0x858.RedGrayTipsInfo)localObject1).uint64_sender_uin.get() + "");
        paramMsgInfo.reciverUin = (((oidb_0x858.RedGrayTipsInfo)localObject1).uint64_receiver_uin.get() + "");
        paramMsgInfo.senderContent = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_sender_rich_content.get().toStringUtf8();
        paramMsgInfo.reciverContent = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_receiver_rich_content.get().toStringUtf8();
        paramMsgInfo.authKey = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_authkey.get().toStringUtf8();
        paramMsgInfo.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), l2 + "", "", "[QQWallet Tips]", MessageCache.a(), 63507, 3000, MessageCache.a());
        paramMsgInfo.isread = true;
        paramMsgInfo.getBytes();
        return paramMsgInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramMsgInfo;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject6, 5, null, true);
      return null;
      PkgTools.a((byte[])localObject6, 5);
      PkgTools.a((byte[])localObject6, 9);
      i1 = localObject6[13];
      return null;
      l3 = PkgTools.a((byte[])localObject6, 5);
      l4 = PkgTools.a((byte[])localObject6, 9);
      i1 = PkgTools.a(localObject6[13]);
      PkgTools.a((byte[])localObject6, 14, i1);
      i1 += 14;
      i3 = PkgTools.a((byte[])localObject6, i1);
      i2 = i1 + 2;
      Object localObject2 = new HashSet();
      i1 = 0;
      while (i1 < i3)
      {
        l5 = PkgTools.a((byte[])localObject6, i2);
        i2 += 4;
        ((HashSet)localObject2).add(String.valueOf(l5));
        ((List)localObject5).add(String.valueOf(l5));
        i1 += 1;
      }
      if (((HashSet)localObject2).size() <= 0) {
        break;
      }
      localObject3 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      localObject4 = String.valueOf(l1);
      if (((HashSet)localObject2).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        if ((int)l4 < 0) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "0x7: kicked from the disc because of converting to a group，dwCmdTime=" + l4);
          }
        }
      }
      for (;;)
      {
        ((DiscussionHandler)localObject3).a(l1, String.valueOf(l3), (List)localObject5, 10005);
        return null;
        ((DiscussionHandler)localObject3).a((String)localObject4);
        a(paramMsgInfo, paramLong, l2, l2, "你已被移出多人聊天");
        continue;
        ((DiscussionHandler)localObject3).a((String)localObject4, (HashSet)localObject2);
      }
      l4 = PkgTools.a((byte[])localObject6, 5);
      l3 = PkgTools.a((byte[])localObject6, 9);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l4);
      }
      localObject7 = String.valueOf(l4);
      if (a(l4, l1, paramMsgInfo.shMsgSeq)) {
        return null;
      }
      if (((String)localObject7).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        return null;
      }
      localObject3 = "";
      localObject2 = localObject3;
      if (paramMsgInfo.vNickName != null)
      {
        localObject2 = localObject3;
        if (paramMsgInfo.vNickName.size() > 0) {
          localObject2 = (String)paramMsgInfo.vNickName.get(0);
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
        }
        localObject2 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), (String)localObject7);
      }
      for (;;)
      {
        i3 = PkgTools.a((byte[])localObject6, 13);
        i2 = 15;
        localObject8 = new HashSet();
        i1 = 0;
        while (i1 < i3)
        {
          l4 = PkgTools.a((byte[])localObject6, i2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg MSG_DISCUSSION_TYPE_KICKOUT_MEMBER uin=" + l4);
          }
          i2 += 4;
          ((HashSet)localObject8).add(String.valueOf(l4));
          ((List)localObject5).add(String.valueOf(l4));
          i1 += 1;
        }
        localObject3 = new StringBuffer();
        if (((HashSet)localObject8).size() > 0)
        {
          localObject6 = ((HashSet)localObject8).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject9 = (String)((Iterator)localObject6).next();
            ((StringBuffer)localObject3).append(ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), (String)localObject9)).append("、");
          }
        }
        if (((StringBuffer)localObject3).length() > 0) {}
        for (localObject3 = ((StringBuffer)localObject3).deleteCharAt(((StringBuffer)localObject3).toString().length() - 1).toString();; localObject3 = "")
        {
          localObject6 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
          ((DiscussionHandler)localObject6).a(l1, (String)localObject7, (List)localObject5, 10005);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368274, new Object[] { localObject3 });
          if (((HashSet)localObject8).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
          {
            if ((int)l3 < 0)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.msg.DiscMsgPc", 2, "0x7: kicked from the disc because of converting to a group，dwCmdTime=" + l3);
              return null;
            }
            ((DiscussionHandler)localObject6).a(String.valueOf(l1));
            a(paramMsgInfo, paramLong, l2, l2, "你已被移出多人聊天");
            return null;
          }
          localObject2 = (String)localObject2 + "将" + (String)localObject3;
          ((DiscussionHandler)localObject6).a(String.valueOf(l1), (HashSet)localObject8);
          ((DiscussionHandler)localObject4).a(l1);
          a(paramMsgInfo, paramLong, l2, l2, (String)localObject2);
          return null;
          i1 = (int)PkgTools.a((byte[])localObject6, 5);
          localObject2 = new byte[i1];
          PkgTools.b((byte[])localObject6, 9, (byte[])localObject2, i1);
          localObject3 = new sysmsg_0x20c_0x20.SysMsgBody();
          try
          {
            ((sysmsg_0x20c_0x20.SysMsgBody)localObject3).mergeFrom((byte[])localObject2);
            if (!((sysmsg_0x20c_0x20.SysMsgBody)localObject3).u32_cmd.has()) {
              break label4296;
            }
            switch (((sysmsg_0x20c_0x20.SysMsgBody)localObject3).u32_cmd.get())
            {
            case 2: 
              if (!((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_convert_to_group.has()) {
                break label4296;
              }
              localObject3 = (sysmsg_0x20c_0x20.Convert2Group)((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_convert_to_group.get();
              paramMsgInfo = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject3).u64_operator.get());
              localObject2 = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject3).u64_group_code.get());
              localObject3 = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject3).u64_discuss_code.get());
              if (((DiscussionManager)localObject7).jdField_a_of_type_JavaUtilMap != null)
              {
                ((DiscussionManager)localObject7).jdField_a_of_type_JavaUtilMap.put(localObject3, new String[] { localObject2, paramMsgInfo });
                ((DiscussionManager)localObject7).jdField_a_of_type_JavaUtilSet.add(localObject2);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=2): Discussion %s is converted to group %s by user %s.", new Object[] { localObject3, localObject2, paramMsgInfo }));
              }
              ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(String.valueOf(l1));
              if ((BaseActivity.sTopActivity instanceof SplashActivity)) {}
              ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(42, true, new Object[] { Integer.valueOf(2131364296), localObject3, localObject2, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f().equals(paramMsgInfo)) });
            }
          }
          catch (Exception paramMsgInfo)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc", 2, "0x20: Parsing data failed!");
            }
            return null;
          }
          if (!((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_mem_num_remind.has()) {
            break label4296;
          }
          localObject2 = (sysmsg_0x20c_0x20.MemberNumRemind)((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_mem_num_remind.get();
          i1 = ((sysmsg_0x20c_0x20.MemberNumRemind)localObject2).u32_mem_num.get();
          l1 = ((sysmsg_0x20c_0x20.MemberNumRemind)localObject2).u64_discuss_code.get();
          a(paramMsgInfo, l1, paramLong, l1, 1);
          if (!QLog.isColorLevel()) {
            break label4296;
          }
          QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=3): Discussion %d remains %d members.", new Object[] { Long.valueOf(l1), Integer.valueOf(i1) }));
          break label4296;
          if (!((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_upload_file_remind.has()) {
            break label4296;
          }
          l1 = ((sysmsg_0x20c_0x20.UploadFileRemind)((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_upload_file_remind.get()).u64_discuss_code.get();
          a(paramMsgInfo, l1, paramLong, paramLong, 2);
          if (!QLog.isColorLevel()) {
            break label4296;
          }
          QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=4): Discussion %d gets a file uploaded.", new Object[] { Long.valueOf(l1) }));
          break label4296;
          if (QLog.isColorLevel()) {
            QLog.d("GameParty", 2, "recv 0x20c_0x22 online push");
          }
          b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject6, 5, null, true);
          return null;
        }
      }
    }
    label4296:
    return null;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    paramMsgInfo = a(paramMsgInfo, paramSvcReqPushMsg.lUin);
    if ((paramMsgInfo != null) && (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgInfo, true))) {
      return paramMsgInfo;
    }
    return null;
  }
  
  private void a(byte paramByte, long paramLong1, long paramLong2)
  {
    if (paramLong2 != Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue()) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        return;
      } while (paramByte != 2);
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(AVNotifyCenter.class);
    } while (localMqqHandler == null);
    Message localMessage = localMqqHandler.obtainMessage(10003);
    localMessage.obj = Long.valueOf(paramLong1);
    localMqqHandler.sendMessage(localMessage);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(64486);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367289);
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "showUpdateToGroupTips: unknown type!");
      }
      return;
    }
    for (int i1 = 2131367287;; i1 = 2131367288)
    {
      localMessageRecord.init(paramLong2, paramLong1, paramLong3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(i1, new Object[] { str }), paramMsgInfo.uRealMsgTime, 64486, 3000, paramMsgInfo.uMsgTime);
      localMessageRecord.extStr = str;
      localMessageRecord.isread = true;
      localMessageRecord.extraflag = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
      return;
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(64532);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, paramMsgInfo.uRealMsgTime, 64532, 3000, paramMsgInfo.uMsgTime);
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + paramLong2 + " msgType: " + 64532 + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + Utils.a(paramString));
    }
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(Pair paramPair1, MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, byte paramByte, long paramLong4, Pair paramPair2)
  {
    long l1 = ((Long)paramPair1.first).longValue();
    long l2 = ((Long)paramPair2.first).longValue();
    paramPair1 = (String)paramPair1.second;
    if (TextUtils.isEmpty(paramPair1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server showName empty");
      }
      paramPair1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2), String.valueOf(l1));
    }
    for (;;)
    {
      String str = (String)paramPair2.second;
      paramPair2 = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server shareName empty");
        }
        paramPair2 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2), String.valueOf(l2));
      }
      if (paramLong4 == 0L) {
        paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368288, new Object[] { paramPair1 });
      }
      for (;;)
      {
        a(paramMsgInfo, paramLong1, paramLong2, paramLong3, paramPair1);
        return;
        if (paramLong4 == 1L) {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368290, new Object[] { paramPair1, paramPair2 });
        } else if (paramLong4 == 2L) {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371323, new Object[] { paramPair1 });
        } else {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368272, new Object[] { paramPair1 });
        }
      }
    }
  }
  
  private void a(Pair paramPair, MsgInfo paramMsgInfo, ArrayList paramArrayList, long paramLong1, String paramString, byte paramByte, long paramLong2, boolean paramBoolean)
  {
    long l1 = ((Long)paramPair.first).longValue();
    String str1 = (String)paramPair.second;
    int i4 = paramArrayList.size();
    StringBuffer localStringBuffer;
    int i2;
    label55:
    String str2;
    int i3;
    if (i4 > 50)
    {
      i1 = 50;
      localStringBuffer = new StringBuffer(i1 * 10);
      i2 = 0;
      if (i2 >= i1) {
        break label264;
      }
      paramPair = (Pair)paramArrayList.get(i2);
      str2 = (String)paramPair.first;
      if (Long.valueOf(str2).longValue() != paramLong1) {
        break label161;
      }
      i3 = 1;
      label98:
      if (i3 == 0) {
        break label167;
      }
      paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368281);
      a(paramByte, Long.valueOf(paramString).longValue(), paramLong1);
      label133:
      if (i2 != 0) {
        break label235;
      }
      localStringBuffer.append(paramPair);
    }
    for (;;)
    {
      i2 += 1;
      break label55;
      i1 = i4;
      break;
      label161:
      i3 = 0;
      break label98;
      label167:
      localObject = (String)paramPair.second;
      paramPair = (Pair)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "showWelcomeTips server name empty cOpType:" + paramByte);
      }
      paramPair = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, str2);
      break label133;
      label235:
      localStringBuffer.append("、" + paramPair);
    }
    label264:
    if (i4 > 50)
    {
      localStringBuffer.append(" 等");
      localStringBuffer.append(i4 - 1);
      localStringBuffer.append("人");
    }
    int i1 = 64532;
    if (paramBoolean) {
      i1 = 60535;
    }
    paramArrayList = new ArrayList();
    Object localObject = MessageRecordFactory.a(i1);
    paramPair = "";
    if (paramByte == 11) {
      paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368287, new Object[] { localStringBuffer.toString() });
    }
    if (paramByte == 22)
    {
      if (paramLong2 == 0L) {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368287, new Object[] { localStringBuffer.toString() });
      }
      for (;;)
      {
        ((MessageRecord)localObject).init(paramLong1, paramMsgInfo.lFromUin, paramMsgInfo.lFromUin, paramPair, paramMsgInfo.uRealMsgTime, i1, 3000, paramMsgInfo.uMsgTime);
        ((MessageRecord)localObject).isread = true;
        if ((localObject instanceof MessageForNewGrayTips)) {
          ((MessageForNewGrayTips)localObject).updateMsgData();
        }
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false)) {
          paramArrayList.add(localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "----------handleC2COnlinePushMsgResp after analysis(showWelcomeTips) friendUin: " + ((MessageRecord)localObject).frienduin + " msgType: " + i1 + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + ((MessageRecord)localObject).getLogColorContent());
        }
        if (paramArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList, String.valueOf(paramLong1));
        }
        return;
        if (paramLong2 == 1L) {
          paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368289);
        } else if (paramLong2 == 2L) {
          paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371324, new Object[] { localStringBuffer.toString() });
        }
      }
    }
    if (l1 == paramLong1)
    {
      i2 = 1;
      label660:
      if (i2 == 0) {
        break label737;
      }
      if (!QLog.isColorLevel()) {
        break label830;
      }
      paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368280);
    }
    for (;;)
    {
      paramPair = paramPair + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368272, new Object[] { localStringBuffer.toString() });
      break;
      i2 = 0;
      break label660;
      label737:
      paramPair = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "showWelcomeTips server invitorName empty cOpType:" + paramByte);
        }
        paramPair = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, String.valueOf(l1));
      }
      paramPair = paramPair + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368279);
      continue;
      label830:
      paramPair = "";
    }
  }
  
  private void a(Pair paramPair, MsgInfo paramMsgInfo, ArrayList paramArrayList, long paramLong, String paramString, byte paramByte, boolean paramBoolean)
  {
    a(paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, 0L, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i1 = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i1];
    PkgTools.b(paramArrayOfByte, paramInt, paramMessageRecord, i1);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      l1 = paramArrayOfByte.opt_uint64_conf_uin.get();
      if ((paramInt != 7) || (!paramArrayOfByte.opt_msg_recall_reminder.has())) {
        return;
      }
      localObject1 = (oidb_0x858.MessageRecallReminder)paramArrayOfByte.opt_msg_recall_reminder.get();
      l2 = ((oidb_0x858.MessageRecallReminder)localObject1).uint64_uin.get();
      paramArrayOfByte = new HashMap();
      try
      {
        paramMessageRecord = new msgrevoke_userdef.MsgInfoUserDef();
        paramMessageRecord.mergeFrom(((oidb_0x858.MessageRecallReminder)localObject1).bytes_userdef.get().toByteArray());
        paramInt = paramMessageRecord.uint32_long_message_flag.get();
        if (paramInt != 1) {
          break label206;
        }
        paramMessageRecord = ((ArrayList)paramMessageRecord.long_msg_info.get()).iterator();
        while (paramMessageRecord.hasNext())
        {
          localObject2 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramMessageRecord.next();
          paramArrayOfByte.put(Integer.valueOf(((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject2).uint32_msg_seq.get()), localObject2);
        }
        QLog.d("revokeMsg", 2, "recv 0x20c_0x19 msg, parse msgInfoUserDef error");
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      long l1;
      Object localObject1;
      long l2;
      Object localObject2;
      label206:
      paramQQAppInterface.printStackTrace();
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("Q.msg.DiscMsgPc", 2, "parse0x20c_subType0x19 Exception " + paramQQAppInterface.getStackTrace());
      return;
      paramQQAppInterface.a().a(paramMessageRecord, false);
    }
    paramMessageRecord = new ArrayList();
    localObject1 = ((ArrayList)((oidb_0x858.MessageRecallReminder)localObject1).uint32_recalled_msg_list.get()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (oidb_0x858.MessageRecallReminder.MessageMeta)((Iterator)localObject1).next();
      localObject2 = new RevokeMsgInfo();
      ((RevokeMsgInfo)localObject2).jdField_b_of_type_JavaLangString = String.valueOf(l2);
      ((RevokeMsgInfo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l1);
      ((RevokeMsgInfo)localObject2).jdField_a_of_type_Int = 3000;
      ((RevokeMsgInfo)localObject2).jdField_a_of_type_Long = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get();
      ((RevokeMsgInfo)localObject2).jdField_c_of_type_Long = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_time.get();
      if (paramInt == 1)
      {
        localObject3 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramArrayOfByte.get(Integer.valueOf(((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get()));
        ((RevokeMsgInfo)localObject2).jdField_b_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_id.get();
        ((RevokeMsgInfo)localObject2).jdField_c_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_num.get();
        ((RevokeMsgInfo)localObject2).d = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_index.get();
      }
      paramMessageRecord.add(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x20c_0x19 msg," + ((RevokeMsgInfo)localObject2).toString());
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    Object localObject = new ArrayList();
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get()));
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---initGetPullDiscussionMsg discussUin: ").append(str).append(" res.cReplyCode: ").append(paramPbGetDiscussMsgResp.result.get()).append(" lastSeq: ").append(l1);
      QLog.d("Q.msg.DiscMsgPc_At_Me_DISC", 2, localStringBuilder.toString());
    }
    if (paramArrayList != null) {
      a(paramArrayList, (ArrayList)localObject);
    }
    if ((paramPbGetDiscussMsgResp.result.get() == 104) && (((ArrayList)localObject).size() == 0))
    {
      l1 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "initGetPullDiscussionMsg reply 104 !! disUin=" + str + ", reqEndSeq=" + l1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, l1);
    }
    for (int i1 = 1;; i1 = 0)
    {
      int i2;
      boolean bool2;
      boolean bool1;
      if (((ArrayList)localObject).size() > 0)
      {
        paramToServiceMsg = ((ArrayList)localObject).iterator();
        while (paramToServiceMsg.hasNext())
        {
          paramArrayList = (MessageRecord)paramToServiceMsg.next();
          if ((paramArrayList.senderuin != null) && (paramArrayList.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
          {
            paramArrayList.isread = true;
            paramArrayList.issend = 2;
          }
        }
        Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
        paramToServiceMsg = new ArrayList();
        i2 = ((ArrayList)localObject).size() - 1;
        if (i2 >= 0)
        {
          paramArrayList = (MessageRecord)((ArrayList)localObject).get(i2);
          if (QLog.isColorLevel())
          {
            localStringBuilder.setLength(0);
            localStringBuilder.append("----------initGetPullDiscussionMsg update send message  mr.senderuin: ").append(paramArrayList.senderuin).append(" mr.msgtype: ").append(paramArrayList.msgtype).append(" mr.frienduin: ").append(paramArrayList.frienduin).append(" mr.shmsgseq: ").append(paramArrayList.shmsgseq).append(" mr.time:").append(paramArrayList.time).append(" mr.msg: ").append(paramArrayList.getLogColorContent());
            QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
          }
          if ((paramArrayList.senderuin != null) && (paramArrayList.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
          {
            paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList.frienduin, 3000, paramArrayList);
            if (paramPbGetDiscussMsgResp != null)
            {
              if (((paramArrayList instanceof MessageForText)) && ((paramPbGetDiscussMsgResp instanceof MessageForText)) && (paramArrayList.getRepeatCount() > 0))
              {
                paramPbGetDiscussMsgResp.setRepeatCount(paramArrayList.getRepeatCount());
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.DiscMsgPc", 2, "<---initGetPullDiscussionMsg_PB ===> update findMr.repeatCount=" + paramArrayList.getRepeatCount());
                }
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e()) {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramPbGetDiscussMsgResp.frienduin, paramPbGetDiscussMsgResp.istroop, paramPbGetDiscussMsgResp.uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramArrayList.frienduin, 3000, paramPbGetDiscussMsgResp.uniseq, paramArrayList.shmsgseq, paramArrayList.time);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str, paramArrayList.shmsgseq);
            }
          }
          for (;;)
          {
            i2 -= 1;
            break;
            paramToServiceMsg.add(0, paramArrayList);
          }
        }
        i2 = 0;
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str);
        if (paramToServiceMsg.size() > 0)
        {
          paramArrayList = paramToServiceMsg.iterator();
          if (paramArrayList.hasNext())
          {
            paramPbGetDiscussMsgResp = (MessageRecord)paramArrayList.next();
            if (paramPbGetDiscussMsgResp.shmsgseq > l1) {
              l1 = paramPbGetDiscussMsgResp.shmsgseq;
            }
            for (;;)
            {
              break;
            }
          }
          paramArrayList = (BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3000);
          if (paramArrayList.a(str, 3000, paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
            break label1167;
          }
          paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
          long l2 = ((Long)paramPbGetDiscussMsgResp[0]).longValue();
          int i3 = paramToServiceMsg.size();
          i2 = 0;
          while (i2 < i3)
          {
            if ((((MessageRecord)paramToServiceMsg.get(i2)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(i2)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
            {
              ((MessageRecord)paramToServiceMsg.get(i2)).isread = true;
              ((MessageRecord)paramToServiceMsg.get(i2)).issend = 2;
            }
            if (((Long)paramPbGetDiscussMsgResp[0]).longValue() >= ((MessageRecord)paramToServiceMsg.get(i2)).shmsgseq) {
              ((MessageRecord)paramToServiceMsg.get(i2)).isread = true;
            }
            i2 += 1;
          }
          bool2 = MessageHandlerUtils.a(paramToServiceMsg);
          boolean bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
          i2 = MsgProxyUtils.a(paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))
          {
            bool1 = true;
            paramPbGetDiscussMsgResp.a(paramToServiceMsg, (String)localObject, bool1, false);
            paramArrayList.c(str, 3000, l2);
            paramArrayList.a(str, paramToServiceMsg);
            bool1 = bool3;
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str, l1);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool1)) && (!MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 3000)))
        {
          bool1 = true;
          label1046:
          a("initGetPullDiscussionMsg", true, i2, bool1, false);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg);
        }
        for (;;)
        {
          if ((i1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str) == 1))
          {
            paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
            if (paramToServiceMsg != null)
            {
              l1 = ((Long)paramToServiceMsg[0]).longValue();
              ((BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3000)).c(str, 3000, l1);
            }
          }
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label1046;
          i1 = 1;
          continue;
          i1 = 1;
        }
        label1167:
        bool1 = false;
        bool2 = false;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList2 = new ArrayList();
    MessageInfo localMessageInfo = new MessageInfo();
    Object localObject1;
    Object localObject2;
    long l1;
    long l2;
    long l3;
    int i1;
    long l4;
    int i2;
    int i3;
    long l5;
    int i4;
    long l6;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB: size:" + paramArrayList.size());
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (msg_comm.Msg)localIterator.next();
        paramArrayList = (msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get();
        if (!paramArrayList.discuss_info.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB: no discussInfo.");
          }
        }
        else
        {
          localObject2 = (msg_comm.DiscussInfo)paramArrayList.discuss_info.get();
          l1 = paramArrayList.from_uin.get();
          l2 = paramArrayList.to_uin.get();
          l3 = paramArrayList.msg_seq.get();
          i1 = paramArrayList.msg_time.get();
          l4 = paramArrayList.msg_uid.get();
          i2 = paramArrayList.user_active.get();
          i3 = paramArrayList.from_instid.get();
          l5 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
          i4 = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
          l6 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
          if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
            break label1079;
          }
        }
      }
    }
    label1079:
    for (paramArrayList = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; paramArrayList = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB : fromUin:" + l1 + ",toUin:" + l2 + ",msgTime:" + i1 + ",msgSeq:" + l3 + ",msgUid:" + l4 + ",userActive:" + i2 + ",fromInstid:" + i3 + ",disUin:" + l5 + ",disType:" + i4 + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList) + ",hasAppShare:" + ((msg_comm.Msg)localObject1).appshare_info.has() + ",hasMsgBody:" + ((msg_comm.Msg)localObject1).msg_body.has());
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      PBDecodeContext localPBDecodeContext = new PBDecodeContext();
      localPBDecodeContext.jdField_e_of_type_Long = l5;
      localPBDecodeContext.d = 3000;
      localPBDecodeContext.jdField_e_of_type_Int = i4;
      if (((msg_comm.Msg)localObject1).content_head.has())
      {
        msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)((msg_comm.Msg)localObject1).content_head.get();
        i1 = localContentHead.div_seq.get();
        i2 = localContentHead.pkg_index.get();
        i3 = localContentHead.pkg_num.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB ContentHead: divSeq:" + i1 + ",pkgIndex:" + i2 + ",pkgNum:" + i3);
        }
      }
      try
      {
        a((msg_comm.Msg)localObject1, localArrayList3, localPBDecodeContext, true, localMessageInfo);
        if (localArrayList3.size() > 0) {
          a(localArrayList3, (ArrayList)localObject2, true);
        }
        if ((localObject2 == null) || (((ArrayList)localObject2).size() < 1)) {
          break;
        }
        MessageHandlerUtils.a((List)localObject2);
        localArrayList1.addAll((Collection)localObject2);
        MessageHandlerUtils.a("Q.msg.DiscMsgPc", paramString, l3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l5));
        if ((paramArrayList == null) || (paramArrayList.length <= 0)) {
          break;
        }
        localObject2 = String.valueOf(l1);
        localObject1 = HexUtil.a(paramArrayList) + ":" + (String)localObject2;
        if (localHashSet.contains(localObject1)) {
          break;
        }
        paramArrayList = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramArrayList, String.valueOf(l5), (String)localObject2, false);
        if (paramArrayList == null) {
          break;
        }
        localArrayList2.add(paramArrayList);
        localHashSet.add(localObject1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", localException);
          }
        }
      }
      if (localArrayList2.size() > 0) {
        ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(localArrayList2);
      }
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (MessageRecord)paramArrayList.next();
        if ((paramString.senderuin != null) && (paramString.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          paramString.issend = 2;
        }
        paramString.isread = true;
      }
      Collections.sort(localArrayList1, this.jdField_a_of_type_JavaUtilComparator);
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      paramArrayList = paramPbGetDiscussMsgResp.discuss_uin.toString();
      ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramArrayList + "&" + 3000, localMessageInfo);
      paramArrayList = new ArrayList();
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.putLong("beginSeq", paramPbGetDiscussMsgResp.return_begin_seq.get());
        paramToServiceMsg.putLong("endSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
        paramToServiceMsg.putBoolean("success", true);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramPbGetDiscussMsgResp.discuss_uin.get()), 3000, localArrayList1, paramArrayList, paramToServiceMsg);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
      return;
    }
  }
  
  private void a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(64520);
    long l1 = MessageCache.a();
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      int i3 = paramArrayList.size();
      if (i3 > 50) {}
      StringBuilder localStringBuilder;
      for (int i1 = 50;; i1 = i3)
      {
        localStringBuilder = new StringBuilder(i1 * 10);
        int i2 = 1;
        while (i2 < i1)
        {
          localStringBuilder.append((String)paramArrayList.get(i2));
          if (i2 != i1 - 1) {
            localStringBuilder.append("、");
          }
          i2 += 1;
        }
      }
      if (i3 > 50)
      {
        localStringBuilder.append(" 等");
        localStringBuilder.append(i3 - 1);
        localStringBuilder.append("人");
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367286, new Object[] { localStringBuilder });
      localMessageRecord.init(paramString2, paramString1, paramString3, paramArrayList + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131370168), l1, 64520, 3000, l1);
      localMessageRecord.extStr = paramArrayList;
      localMessageRecord.isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "discussionMsgRecordHandle_PB msgs is null or size <= 0");
      }
      return;
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    Iterator localIterator = paramArrayList1.iterator();
    long l1 = 0L;
    label61:
    msg_comm.Msg localMsg;
    Object localObject1;
    Object localObject2;
    long l4;
    long l2;
    long l3;
    int i1;
    long l5;
    int i2;
    int i3;
    int i4;
    long l6;
    if (localIterator.hasNext())
    {
      localMsg = (msg_comm.Msg)localIterator.next();
      localObject1 = new MessageInfo();
      paramArrayList1 = (msg_comm.MsgHead)localMsg.msg_head.get();
      if ((!paramArrayList1.discuss_info.has()) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      localObject2 = (msg_comm.DiscussInfo)paramArrayList1.discuss_info.get();
      l4 = paramArrayList1.from_uin.get();
      l2 = paramArrayList1.to_uin.get();
      l3 = paramArrayList1.msg_seq.get();
      i1 = paramArrayList1.msg_time.get();
      l5 = paramArrayList1.msg_uid.get();
      i2 = paramArrayList1.user_active.get();
      i3 = paramArrayList1.from_instid.get();
      l1 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
      i4 = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
      l6 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
      if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
        break label999;
      }
    }
    label993:
    label996:
    label999:
    for (paramArrayList1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; paramArrayList1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB : fromUin:" + l4 + ",toUin:" + l2 + ",msgTime:" + i1 + ",msgSeq:" + l3 + ",msgUid:" + l5 + ",userActive:" + i2 + ",fromInstid:" + i3 + ",disUin:" + l1 + ",disType:" + i4 + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList1) + ",hasAppShare:" + localMsg.appshare_info.has() + ",hasMsgBody:" + localMsg.msg_body.has());
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      PBDecodeContext localPBDecodeContext = new PBDecodeContext();
      localPBDecodeContext.jdField_e_of_type_Long = l1;
      localPBDecodeContext.d = 3000;
      localPBDecodeContext.jdField_e_of_type_Int = i4;
      if (localMsg.content_head.has())
      {
        msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)localMsg.content_head.get();
        i1 = localContentHead.div_seq.get();
        i2 = localContentHead.pkg_index.get();
        i3 = localContentHead.pkg_num.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB ContentHead. disUin:" + l1 + ", divSeq:" + i1 + ",pkgIndex:" + i2 + ",pkgNum:" + i3);
        }
      }
      l2 = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          a(localMsg, localArrayList2, localPBDecodeContext, true, (MessageInfo)localObject1);
          if (!QLog.isColorLevel()) {
            break label996;
          }
          l3 = System.currentTimeMillis();
          QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB decodeSinglePbMsg_Group. isUin:" + l1 + ", cost=" + (l3 - l2));
          l2 = l3;
          if (localArrayList2 != null) {
            a(localArrayList2, (ArrayList)localObject2, true);
          }
          if (QLog.isColorLevel())
          {
            l3 = System.currentTimeMillis();
            QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB msgListFilter. disUin:" + l1 + ", cost=" + (l3 - l2));
          }
          if (localObject2 == null) {
            break label993;
          }
          if (((ArrayList)localObject2).size() >= 1) {}
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", localException);
          continue;
          MessageHandlerUtils.a((List)localObject2);
          paramArrayList2.addAll((Collection)localObject2);
          if ((paramArrayList1 != null) && (paramArrayList1.length > 0))
          {
            localObject1 = String.valueOf(l4);
            String str = HexUtil.a(paramArrayList1) + ":" + (String)localObject1;
            if (!localHashSet.contains(str))
            {
              paramArrayList1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramArrayList1, String.valueOf(l1), (String)localObject1, false);
              if (paramArrayList1 != null)
              {
                localArrayList1.add(paramArrayList1);
                localHashSet.add(str);
              }
            }
          }
        }
        break label61;
        l2 = System.currentTimeMillis();
        if (localArrayList1.size() > 0) {
          ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(localArrayList1);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        l3 = System.currentTimeMillis();
        QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB saveDiscussionMemberInfoList. disUin:" + l1 + ", cost=" + (l3 - l2));
        return;
        break label61;
      }
    }
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---DiscussionMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).discuss_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    Object localObject2 = (msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject1).discuss_info.get();
    long l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l4 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    int i4 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l6 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int i5 = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i6 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l2 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
    int i7 = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
    long l7 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
    long l3;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      l3 = ((Long)localObject1).longValue();
      if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
        break label1782;
      }
    }
    label1447:
    label1620:
    label1764:
    label1782:
    for (localObject1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; localObject1 = null)
    {
      int i3;
      int i2;
      int i1;
      if (paramMsg.content_head.has())
      {
        localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
        i3 = ((msg_comm.ContentHead)localObject2).div_seq.get();
        i2 = ((msg_comm.ContentHead)localObject2).pkg_index.get();
        i1 = ((msg_comm.ContentHead)localObject2).pkg_num.get();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.cq = i5;
        int i8 = paramFromServiceMsg.getRequestSsoSeq();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), i8);
          return;
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
          break;
        }
        if (!MessageHandler.b)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2)) != 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(String.valueOf(l2), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc", 2, "handleMsgPush_PB_Dis unfinished discussionUin=" + l2);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), i8);
          }
        }
        else if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(String.valueOf(l2), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), i8);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder("<---handleMsgPush_PB_Dis ");
          paramFromServiceMsg.append(" fromUin:").append(l1).append(" toUin").append(l4).append(" msgTime:").append(i4).append(" msgSeq:").append(l5).append(" msgUid:").append(l6).append(" userActive:").append(i5).append(" fromInstid:").append(i6).append(" disUin:").append(l2).append(" disType:").append(i7).append(" disSeq:").append(l7).append(" remarkSender:").append(HexUtil.a((byte[])localObject1)).append(" divSeq:").append(i3).append(" pkgIndex:").append(i2).append(" pkgNum:").append(i1).append(" hasShare:").append(paramMsg.appshare_info.has());
          QLog.d("Q.msg.DiscMsgPc", 2, paramFromServiceMsg.toString());
        }
        ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(l2);
        ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(l1);
        paramFromServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        localObject2 = new PBDecodeContext();
        ((PBDecodeContext)localObject2).jdField_e_of_type_Long = l2;
        ((PBDecodeContext)localObject2).d = 3000;
        ((PBDecodeContext)localObject2).jdField_e_of_type_Int = i7;
        localObject2 = a(paramMsg, (PBDecodeContext)localObject2);
        Object localObject3 = new HashSet();
        ArrayList localArrayList = new ArrayList();
        paramMsg = new ArrayList();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          MessageHandlerUtils.a((List)localObject2);
          i2 = ((List)localObject2).size();
          i1 = 0;
          if (i1 < i2)
          {
            Object localObject4 = (MessageRecord)((List)localObject2).get(i1);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc", 2, "----------handleMsgPush_PB_Dis after analysis  mr.senderuin: " + ((MessageRecord)localObject4).senderuin + " mr.msgtype: " + ((MessageRecord)localObject4).msgtype + " mr.frienduin: " + ((MessageRecord)localObject4).frienduin + " mr.shmsgseq: " + ((MessageRecord)localObject4).shmsgseq + " mr.time:" + ((MessageRecord)localObject4).time + " mr.msg: " + ((MessageRecord)localObject4).getLogColorContent());
            }
            Object localObject5;
            if ((((MessageRecord)localObject4).senderuin != null) && (((MessageRecord)localObject4).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
            {
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).frienduin, 3000, (MessageRecord)localObject4);
              if (localObject5 != null)
              {
                if (((localObject4 instanceof MessageForText)) && ((localObject5 instanceof MessageForText)) && (((MessageRecord)localObject4).getRepeatCount() > 0))
                {
                  ((MessageRecord)localObject5).setRepeatCount(((MessageRecord)localObject4).getRepeatCount());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Dis ===> update findMr.repeatCount=" + ((MessageRecord)localObject5).getRepeatCount());
                  }
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject4).frienduin, 3000, ((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject4).shmsgseq, ((MessageRecord)localObject4).time);
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((MessageRecord)localObject4, (MessageRecord)localObject5);
                a((MessageRecord)localObject5);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).shmsgseq);
              }
            }
            for (;;)
            {
              i1 += 1;
              break;
              ((MessageRecord)localObject4).isread = true;
              ((MessageRecord)localObject4).issend = 2;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject4).frienduin, 3000, ((MessageRecord)localObject4).shmsgseq);
              paramMsg.add(localObject4);
              if ((i1 == 0) && (localObject1 != null) && (localObject1.length > 0))
              {
                String str = ((MessageRecord)localObject4).senderuin;
                localObject5 = HexUtil.a((byte[])localObject1) + ":" + str;
                if (!((HashSet)localObject3).contains(localObject5))
                {
                  localObject4 = paramFromServiceMsg.a((byte[])localObject1, ((MessageRecord)localObject4).frienduin, str, false);
                  if (localObject4 != null)
                  {
                    localArrayList.add(localObject4);
                    ((HashSet)localObject3).add(localObject5);
                  }
                }
              }
            }
          }
        }
        if (localArrayList.size() > 0) {
          paramFromServiceMsg.b(localArrayList);
        }
        paramFromServiceMsg = new ArrayList();
        if ((paramMsg != null) && (paramMsg.size() > 0)) {
          paramFromServiceMsg.addAll(paramMsg);
        }
        if (paramFromServiceMsg.size() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMsg);
          boolean bool2 = MessageHandlerUtils.a(paramFromServiceMsg);
          boolean bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg);
          i1 = MsgProxyUtils.a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))
          {
            bool1 = true;
            paramMsg.a(paramFromServiceMsg, String.valueOf(l3), bool1);
            paramMsg = new HashMap();
            localObject1 = paramFromServiceMsg.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1620;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if (((MessageRecord)localObject2).istroop == 3000)
            {
              if (paramMsg.containsKey(((MessageRecord)localObject2).frienduin))
              {
                localObject3 = ((MessageRecord)localObject2).frienduin;
                if (((MessageRecord)localObject2).shmsgseq > ((Long)paramMsg.get(((MessageRecord)localObject2).frienduin)).longValue()) {}
                for (l1 = ((MessageRecord)localObject2).shmsgseq;; l1 = ((Long)paramMsg.get(((MessageRecord)localObject2).frienduin)).longValue())
                {
                  paramMsg.put(localObject3, Long.valueOf(l1));
                  break label1447;
                  bool1 = false;
                  break;
                }
              }
              paramMsg.put(((MessageRecord)localObject2).frienduin, Long.valueOf(Math.max(((MessageRecord)localObject2).shmsgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(((MessageRecord)localObject2).frienduin))));
            }
          }
          localObject1 = paramMsg.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g((String)localObject2, ((Long)paramMsg.get(localObject2)).longValue());
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3)) || (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(l2), 3000))) {
            break label1764;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          a("handleMsgPush_PB_Dis", true, i1, bool1, false);
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), i8);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramFromServiceMsg);
          return;
        }
        i1 = 0;
        i2 = 0;
        i3 = 0;
      }
    }
  }
  
  /* Error */
  private boolean a(long paramLong1, long paramLong2, short paramShort)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 122	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   9: lload_1
    //   10: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13: ldc_w 1495
    //   16: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: lload_3
    //   20: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: ldc_w 1495
    //   26: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 5
    //   31: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 6
    //   39: aload_0
    //   40: getfield 97	com/tencent/mobileqq/app/message/DiscMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 966	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   46: invokevirtual 1497	com/tencent/mobileqq/service/message/MessageCache:a	()Ljava/util/ArrayList;
    //   49: aload 6
    //   51: invokevirtual 1498	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   54: ifeq +44 -> 98
    //   57: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +30 -> 90
    //   63: ldc 14
    //   65: iconst_2
    //   66: new 122	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 1500
    //   76: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 1502	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_1
    //   91: istore 7
    //   93: aload_0
    //   94: monitorexit
    //   95: iload 7
    //   97: ireturn
    //   98: aload_0
    //   99: getfield 97	com/tencent/mobileqq/app/message/DiscMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 966	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   105: aload 6
    //   107: invokevirtual 1503	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;)V
    //   110: iconst_0
    //   111: istore 7
    //   113: goto -20 -> 93
    //   116: astore 6
    //   118: aload_0
    //   119: monitorexit
    //   120: aload 6
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	DiscMessageProcessor
    //   0	123	1	paramLong1	long
    //   0	123	3	paramLong2	long
    //   0	123	5	paramShort	short
    //   37	69	6	str	String
    //   116	5	6	localObject	Object
    //   91	21	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	90	116	finally
    //   98	110	116	finally
  }
  
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i1 = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i1];
    PkgTools.b(paramArrayOfByte, paramInt, paramMessageRecord, i1);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      paramArrayOfByte.opt_uint64_conf_uin.get();
      if ((paramInt == 9) && (paramArrayOfByte.opt_msg_obj_update.has()))
      {
        paramMessageRecord = (oidb_0x858.NotifyObjmsgUpdate)paramArrayOfByte.opt_msg_obj_update.get();
        if (paramMessageRecord.bytes_ext_msg.has())
        {
          paramArrayOfByte = new SubMsgType0xaa.MsgBody();
          try
          {
            paramArrayOfByte.mergeFrom(paramMessageRecord.bytes_ext_msg.get().toByteArray());
            ((GamePartyManager)paramQQAppInterface.getManager(155)).a(paramArrayOfByte, false);
            return;
          }
          catch (Exception paramMessageRecord)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GameParty", 2, "recv 0x858_notifyobjmsgupdate, prase msgBody error");
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.DiscMsgPc", 2, "parse0x20c_subType0x22 Exception " + paramQQAppInterface.getStackTrace());
      }
    }
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    MessageInfo localMessageInfo = new MessageInfo();
    try
    {
      a(paramMsg, localArrayList1, paramPBDecodeContext, true, localMessageInfo);
      long l1 = paramMsg.msg_head.discuss_info.discuss_uin.get();
      ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(l1) + "&" + 3000, localMessageInfo);
      a(localArrayList1, localArrayList2, true);
      return localArrayList2;
    }
    catch (Exception paramMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
        }
      }
    }
  }
  
  public qmb a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
        return new qmb(a(paramMsgInfo, paramSvcReqPushMsg), false);
      }
      a(getClass().getName(), paramInt);
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue());
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      localArrayList = new ArrayList();
      a((ArrayList)paramVarArgs[1], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc", 2, "DisMsgReadedNotify lDisUin is " + paramDisMsgReadedNotify.lDisUin + ", lMemberSeq  is " + paramDisMsgReadedNotify.lMemberSeq);
    }
    String str = String.valueOf(paramDisMsgReadedNotify.lDisUin);
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l1 = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l1 < paramDisMsgReadedNotify.lMemberSeq) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, new Object[] { Long.valueOf(paramDisMsgReadedNotify.lMemberSeq), Long.valueOf(paramDisMsgReadedNotify.lDisMsgSeq) });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 3000, paramDisMsgReadedNotify.lMemberSeq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, paramDisMsgReadedNotify.lMemberSeq);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\DiscMessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */