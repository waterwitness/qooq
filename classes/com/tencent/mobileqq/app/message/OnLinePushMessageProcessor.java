package com.tencent.mobileqq.app.message;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.hotchat.HCSeatInfo;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.PullActiveManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qcall.PstnHandler;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.RenameGroupResp;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import qlz;
import qma;
import qmb;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.oidb.cmd0xa88.oidb_0xa88.NoticeBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DaRenNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupMemberProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.HotFriendNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModCustomFace;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupMemberProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupName;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModLongNick;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModSnsGeneralInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushReportDev;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushSearchDev;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.QQPayPush;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateOneFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.WaitingSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgParams;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.PushAddFrdNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.Medal;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.MsgBody;

public class OnLinePushMessageProcessor
  extends BaseMessageProcessor
{
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  public qma a;
  
  public OnLinePushMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Qma = new qma(this, null);
  }
  
  private int a(SubMsgType0x27.ForwardBody paramForwardBody, FriendsManager paramFriendsManager, TroopManager paramTroopManager, PstnManager paramPstnManager, ApolloManager paramApolloManager, Friends[] paramArrayOfFriends, int paramInt)
  {
    paramForwardBody = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    int m = paramInt;
    long l1;
    label1073:
    label1109:
    label1139:
    label1182:
    label1342:
    label1348:
    label1354:
    label1360:
    Object localObject1;
    label1602:
    label1627:
    label1819:
    label1960:
    label2119:
    label2379:
    label2464:
    label2640:
    label2723:
    label3224:
    label3391:
    Object localObject2;
    if (paramForwardBody.uint64_uin.has())
    {
      l1 = paramForwardBody.uint64_uin.get();
      Iterator localIterator = paramForwardBody.rpt_msg_profile_infos.get().iterator();
      int k = paramInt;
      do
      {
        for (;;)
        {
          m = k;
          if (!localIterator.hasNext()) {
            break;
          }
          paramForwardBody = (SubMsgType0x27.ProfileInfo)localIterator.next();
          if ((paramForwardBody.uint32_field.has()) && (paramForwardBody.bytes_value.has()))
          {
            boolean bool1;
            switch (paramForwardBody.uint32_field.get())
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a unknow field Uint32Field = " + paramForwardBody.uint32_field.get());
              }
              break;
            case 20002: 
              paramForwardBody = paramForwardBody.bytes_value.get();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModProfile Nick = " + paramForwardBody.toStringUtf8());
              }
              paramArrayOfFriends[k] = paramFriendsManager.a(l1 + "", paramForwardBody.toStringUtf8());
              paramTroopManager = paramFriendsManager.a(l1 + "");
              if (paramTroopManager != null)
              {
                paramTroopManager.strNick = paramForwardBody.toStringUtf8();
                paramFriendsManager.a(paramTroopManager);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramTroopManager);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
              k += 1;
              break;
            case 20015: 
              paramForwardBody = paramForwardBody.bytes_value.get();
              if ((paramForwardBody != null) && (paramForwardBody.size() == 2))
              {
                paramInt = paramForwardBody.byteAt(0);
                paramInt = (short)(paramForwardBody.byteAt(1) | paramInt << 8);
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModProfile Head = " + paramInt);
                }
                ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(Long.toString(l1));
                paramForwardBody = paramFriendsManager.a(l1 + "");
                if (paramForwardBody != null)
                {
                  paramForwardBody.nFaceID = paramInt;
                  paramFriendsManager.a(paramForwardBody);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(4, true, new Object[] { l1 + "", paramForwardBody, null });
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
                }
              }
              break;
            case 20009: 
              m = paramForwardBody.bytes_value.get().byteAt(0);
              if (m == 1) {
                paramInt = 0;
              }
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModProfile Sex = " + paramInt);
                }
                paramForwardBody = paramFriendsManager.a(l1 + "");
                if (paramForwardBody == null) {
                  break;
                }
                paramForwardBody.shGender = ((short)paramInt);
                paramFriendsManager.a(paramForwardBody);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
                break;
                if (m == 2)
                {
                  paramInt = 1;
                }
                else
                {
                  paramInt = m;
                  if (m == 0) {
                    paramInt = 2;
                  }
                }
              }
            case 20059: 
              paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get(0);
              a(paramInt);
              ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(101, true, Integer.valueOf(paramInt));
              if (QLog.isColorLevel()) {
                QLog.d("vip", 2, "bubble id = " + paramInt);
              }
              break;
            case 23105: 
              if (QLog.isColorLevel()) {
                QLog.d("vip", 2, "vip update uin=" + l1);
              }
              paramForwardBody = paramForwardBody.bytes_value.get();
              paramTroopManager = paramFriendsManager.c(Long.toString(l1));
              if (paramTroopManager != null)
              {
                paramTroopManager = (Friends)paramTroopManager.clone();
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, String.format("bit info = %02X", new Object[] { Byte.valueOf(paramForwardBody.byteAt(0)) }));
                }
                m = paramTroopManager.qqVipInfo;
                if ((paramForwardBody.byteAt(0) & 0x80) == 0)
                {
                  paramInt = 0;
                  paramTroopManager.qqVipInfo = (paramInt << 24 | 0xFFFFFF & m);
                  m = paramTroopManager.superQqInfo;
                  if ((paramForwardBody.byteAt(0) & 0x8) != 0) {
                    break label1342;
                  }
                  paramInt = 0;
                  paramTroopManager.superQqInfo = (paramInt << 24 | 0xFFFFFF & m);
                  if ((paramForwardBody.byteAt(0) & 0x40) == 0) {
                    break label1348;
                  }
                  bool1 = true;
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "is year vip =" + bool1);
                  }
                  if (!bool1) {
                    break label1354;
                  }
                  paramInt = 65536;
                  if (!paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
                    break label1360;
                  }
                  paramTroopManager.superVipInfo = (paramInt | paramTroopManager.superVipInfo & 0xFF00FFFF);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, String.format("SVIP = %08X, VIP = %08X, SuperQQ = %08X", new Object[] { Integer.valueOf(paramTroopManager.superVipInfo), Integer.valueOf(paramTroopManager.qqVipInfo), Integer.valueOf(paramTroopManager.superQqInfo) }));
                  }
                  paramFriendsManager.a(paramTroopManager);
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(100, true, null);
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(Long.toString(l1))) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "[EmoticonUpdateAuth] 23105 updateEmoticonAuth");
                  }
                  ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(0, 0);
                  break;
                  paramInt = 1;
                  break label1073;
                  paramInt = 1;
                  break label1109;
                  bool1 = false;
                  break label1139;
                  paramInt = 0;
                  break label1182;
                  if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                    paramTroopManager.qqVipInfo = (paramInt | paramTroopManager.qqVipInfo & 0xFF00FFFF);
                  } else if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                    paramTroopManager.superQqInfo = (paramInt | paramTroopManager.superQqInfo & 0xFF00FFFF);
                  }
                }
              }
              break;
            case 23106: 
              if (QLog.isColorLevel()) {
                QLog.d("vip", 2, "vip update uin=" + l1);
              }
              paramForwardBody = paramForwardBody.bytes_value.get();
              paramTroopManager = Long.toString(l1);
              localObject1 = paramFriendsManager.c(paramTroopManager);
              if (localObject1 != null)
              {
                localObject1 = (Friends)((Friends)localObject1).clone();
                bool1 = ((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
                boolean bool2 = ((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
                boolean bool3 = ((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "SVIP: " + bool1 + "; VIP: " + bool2 + "; SuperQQ: " + bool3);
                }
                int i1 = 0;
                int i = paramForwardBody.byteAt(4);
                int j = paramForwardBody.byteAt(5);
                int n;
                if ((j & 0xF0) != 0)
                {
                  m = 16;
                  n = 0;
                  paramInt = i1;
                  if (n < 4)
                  {
                    if ((j & m) != 0) {
                      paramInt = 13 - n;
                    }
                  }
                  else
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(i), Byte.valueOf(j), Integer.valueOf(paramInt) }));
                    }
                    if (!bool1) {
                      break label1819;
                    }
                    ((Friends)localObject1).superVipInfo = (paramInt & 0xFFFF | ((Friends)localObject1).superVipInfo & 0xFFFF0000);
                  }
                }
                for (;;)
                {
                  paramFriendsManager.a((Friends)localObject1);
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramTroopManager)) {
                    break;
                  }
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(100, true, null);
                  break;
                  n += 1;
                  m = (byte)(m << 1);
                  break label1602;
                  if (i != 0)
                  {
                    m = 1;
                    n = 0;
                    for (;;)
                    {
                      paramInt = i1;
                      if (n >= 8) {
                        break;
                      }
                      if ((i & m) != 0)
                      {
                        paramInt = 9 - n;
                        break;
                      }
                      n += 1;
                      m = (byte)(m << 1);
                    }
                  }
                  paramInt = 1;
                  break label1627;
                  if (bool2) {
                    ((Friends)localObject1).qqVipInfo = (paramInt & 0xFFFF | ((Friends)localObject1).qqVipInfo & 0xFFFF0000);
                  } else if (bool3) {
                    ((Friends)localObject1).superQqInfo = (paramInt & 0xFFFF | ((Friends)localObject1).superQqInfo & 0xFFFF0000);
                  }
                }
              }
              break;
            case 23107: 
              if (QLog.isColorLevel()) {
                QLog.d("vip", 2, "svip update uin=" + l1);
              }
              paramForwardBody = paramForwardBody.bytes_value.get();
              paramTroopManager = Long.toString(l1);
              localObject1 = paramFriendsManager.c(paramTroopManager);
              if (localObject1 != null)
              {
                localObject1 = (Friends)((Friends)localObject1).clone();
                if ((paramForwardBody.byteAt(5) & 0x20) != 0)
                {
                  bool1 = true;
                  m = ((Friends)localObject1).superVipInfo;
                  if (!bool1) {
                    break label2119;
                  }
                }
                for (paramInt = 1;; paramInt = 0)
                {
                  ((Friends)localObject1).superVipInfo = (paramInt << 24 | 0xFFFFFF & m);
                  paramFriendsManager.a((Friends)localObject1);
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "isSVip=" + bool1 + "friend.superVipInfo=" + ((Friends)localObject1).superVipInfo);
                  }
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramTroopManager)) {
                    break;
                  }
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(100, true, null);
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
                  }
                  ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(0, 0);
                  break;
                  bool1 = false;
                  break label1960;
                }
              }
              break;
            case 23104: 
              paramForwardBody = paramForwardBody.bytes_value.get();
              if ((paramForwardBody.byteAt(5) & 0x2) != 0)
              {
                paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
                if ((paramForwardBody.byteAt(1) & 0x2) != 0) {
                  paramInt = 2;
                }
                while (paramInt != -1)
                {
                  paramTroopManager.edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(101, true, Integer.valueOf(paramInt));
                  break;
                  if (paramTroopManager.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), -1) == 2) {
                    paramInt = 1;
                  } else {
                    paramInt = -1;
                  }
                }
              }
              break;
            case 23109: 
              paramForwardBody = paramForwardBody.bytes_value.get();
              if (((paramForwardBody.byteAt(31) & 0x20) != 0) || ((paramForwardBody.byteAt(34) & 0x10) != 0) || ((paramForwardBody.byteAt(29) & 0x10) != 0))
              {
                paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
                if (((paramForwardBody.byteAt(11) & 0x20) == 0) && ((paramForwardBody.byteAt(14) & 0x10) == 0)) {
                  break label2640;
                }
                paramInt = 4;
                if (paramInt != -1)
                {
                  paramTroopManager.edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(101, true, Integer.valueOf(paramInt));
                }
              }
              if ((paramForwardBody.byteAt(12) & 0x8) != 0)
              {
                bool1 = true;
                SttManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1);
                if ((paramForwardBody.byteAt(13) & 0x40) == 0) {
                  break label2723;
                }
              }
              for (bool1 = true; SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.toString(l1), null, "qqsetting_pcactive_key", false) != bool1; bool1 = false)
              {
                SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.valueOf(l1).toString(), null, "qqsetting_pcactive_key", bool1);
                paramForwardBody = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
                paramForwardBody.putExtra("pcActive", bool1);
                paramForwardBody.putExtra("uin", Long.valueOf(l1).toString());
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramForwardBody);
                if (!bool1) {
                  break;
                }
                SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.toString(l1), null, "pcactive_config", true);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.openMsfPCActive(Long.toString(l1), "config", true);
                QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
                break;
                if ((paramForwardBody.byteAt(9) & 0x10) != 0)
                {
                  paramInt = 3;
                  break label2379;
                }
                paramInt = paramTroopManager.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), -1);
                if ((paramInt == 4) || (paramInt == 3))
                {
                  paramInt = 1;
                  break label2379;
                }
                paramInt = -1;
                break label2379;
                bool1 = false;
                break label2464;
              }
            case 27025: 
              long l2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asLongBuffer().get();
              paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
              paramForwardBody = paramTroopManager;
              if (paramTroopManager == null)
              {
                paramForwardBody = new ExtensionInfo();
                paramForwardBody.uin = String.valueOf(l1);
              }
              paramForwardBody.pendantId = l2;
              paramForwardBody.timestamp = System.currentTimeMillis();
              paramFriendsManager.a(paramForwardBody);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + l1 + ", id=" + paramForwardBody.pendantId);
              }
              break;
            case 27201: 
              paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
              paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
              paramForwardBody = paramTroopManager;
              if (paramTroopManager == null)
              {
                paramForwardBody = new ExtensionInfo();
                paramForwardBody.uin = String.valueOf(l1);
              }
              if ((paramForwardBody.uVipFont != FontManager.a(paramInt)) || (paramForwardBody.vipFontType != FontManager.a(paramInt)))
              {
                paramForwardBody.uVipFont = FontManager.a(paramInt);
                paramForwardBody.vipFontType = FontManager.a(paramInt);
                paramForwardBody.timestamp = System.currentTimeMillis();
                paramFriendsManager.a(paramForwardBody);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + l1 + ", id=" + paramForwardBody.uVipFont + ", type = " + paramForwardBody.vipFontType);
              }
              break;
            case 27041: 
              paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
              paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
              paramForwardBody = paramTroopManager;
              if (paramTroopManager == null)
              {
                paramForwardBody = new ExtensionInfo();
                paramForwardBody.uin = String.valueOf(l1);
              }
              if (paramForwardBody.colorRingId != paramInt)
              {
                paramForwardBody.colorRingId = paramInt;
                paramForwardBody.timestamp = System.currentTimeMillis();
                paramFriendsManager.a(paramForwardBody);
                ColorRingManager.a(paramForwardBody.uin, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + l1 + ", id=" + paramForwardBody.colorRingId);
              }
              break;
            case 26012: 
            case 26013: 
            case 26014: 
            case 26015: 
            case 42005: 
            case 42006: 
            case 42007: 
            case 42008: 
            case 42011: 
            case 42012: 
              paramTroopManager = paramForwardBody.bytes_value.get();
              m = paramForwardBody.uint32_field.get();
              if ((m >= 42005) && (m <= 42012))
              {
                paramInt = ByteBuffer.wrap(paramTroopManager.toByteArray()).asShortBuffer().get();
                paramForwardBody = paramPstnManager.a(String.valueOf(l1));
                if ((paramForwardBody == null) || (paramInt == -1)) {
                  continue;
                }
                if (m != 420005) {
                  break label3391;
                }
                paramForwardBody.pstn_c2c_vip = paramInt;
              }
              for (;;)
              {
                paramPstnManager.a(paramForwardBody);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(82).a(1, true, paramForwardBody);
                paramTroopManager = new Intent("tencent.video.q2v.pstnCardInfoChanged");
                paramTroopManager.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName());
                paramTroopManager.putExtra("pstnCardInfo", paramForwardBody);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramTroopManager);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("cardpush", 2, "push a pstn attr Uint32Field = " + m + ",bit = " + paramInt);
                break;
                paramInt = ByteBuffer.wrap(paramTroopManager.toByteArray()).asIntBuffer().get();
                break label3224;
                if (m == 42006) {
                  paramForwardBody.pstn_multi_vip = paramInt;
                } else if (m == 42007) {
                  paramForwardBody.pstn_ever_c2c_vip = paramInt;
                } else if (m == 42008) {
                  paramForwardBody.pstn_ever_multi_vip = paramInt;
                } else if (m == 42011) {
                  paramForwardBody.pstn_multi_try_status = paramInt;
                } else if (m == 42012) {
                  paramForwardBody.pstn_c2c_try_status = paramInt;
                } else if (m == 26012) {
                  paramForwardBody.pstn_multi_call_time = paramInt;
                } else if (m == 26013) {
                  paramForwardBody.pstn_multi_last_guide_recharge_time = paramInt;
                } else if (m == 26014) {
                  paramForwardBody.pstn_c2c_call_time = paramInt;
                } else if (m == 26015) {
                  paramForwardBody.pstn_c2c_last_guide_recharge_time = paramInt;
                }
              }
            case 42003: 
              paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
              paramForwardBody = paramApolloManager.b(String.valueOf(l1));
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l1 + ", avip flag: " + paramInt);
              }
              if (paramForwardBody.apolloVipFlag != paramInt)
              {
                paramForwardBody.apolloVipFlag = paramInt;
                paramApolloManager.a(paramForwardBody);
              }
              break;
            case 41999: 
              paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
              paramForwardBody = paramApolloManager.b(String.valueOf(l1));
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l1 + ", avip level: " + paramInt);
              }
              if (paramForwardBody.apolloVipLevel != paramInt)
              {
                paramForwardBody.apolloVipLevel = paramInt;
                paramApolloManager.a(paramForwardBody);
              }
              break;
            }
          }
        }
        paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
        localObject1 = paramApolloManager.b(String.valueOf(l1));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l1 + ", apollo status: " + paramInt);
        }
        if (((ApolloBaseInfo)localObject1).apolloStatus != paramInt)
        {
          ((ApolloBaseInfo)localObject1).apolloStatus = paramInt;
          paramApolloManager.a((ApolloBaseInfo)localObject1);
          if ((l1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) && (1 == paramInt) && (((ApolloBaseInfo)localObject1).apolloLocalTS != ((ApolloBaseInfo)localObject1).apolloServerTS))
          {
            paramForwardBody = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
            if (paramForwardBody != null) {
              paramForwardBody.a("statusChange");
            }
          }
        }
        paramTroopManager = null;
        if (l1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
        {
          ApolloActionManager.a().e = paramInt;
          paramTroopManager = l1 + "";
          paramForwardBody = paramTroopManager;
          if (ApolloActionManager.a().a != null)
          {
            ApolloActionManager.a().a.edit().putBoolean("is_apollo_hide" + l1, false).commit();
            paramForwardBody = paramTroopManager;
          }
        }
        while (!TextUtils.isEmpty(paramForwardBody))
        {
          paramForwardBody = new Pair(paramForwardBody, Integer.valueOf(paramInt));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71).a(3, true, paramForwardBody);
          break;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          paramForwardBody = paramTroopManager;
          if (localObject2 != null)
          {
            paramForwardBody = paramTroopManager;
            if (((QQMessageFacade)localObject2).a())
            {
              paramForwardBody = paramTroopManager;
              if (!TextUtils.isEmpty(((QQMessageFacade)localObject2).a())) {
                if ((((QQMessageFacade)localObject2).a() == 0) && (((QQMessageFacade)localObject2).a().equals(((ApolloBaseInfo)localObject1).uin)))
                {
                  paramForwardBody = ((ApolloBaseInfo)localObject1).uin;
                }
                else
                {
                  paramForwardBody = paramTroopManager;
                  if (1 == ((QQMessageFacade)localObject2).a()) {
                    if ((!TextUtils.isEmpty(ApolloActionManager.a().g)) && (((ApolloBaseInfo)localObject1).uin.equals(ApolloActionManager.a().g)))
                    {
                      paramForwardBody = ((ApolloBaseInfo)localObject1).uin;
                    }
                    else
                    {
                      paramForwardBody = paramTroopManager;
                      if (!TextUtils.isEmpty(ApolloActionManager.a().f))
                      {
                        paramForwardBody = paramTroopManager;
                        if (((ApolloBaseInfo)localObject1).uin.equals(ApolloActionManager.a().f)) {
                          paramForwardBody = ((ApolloBaseInfo)localObject1).uin;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
        paramTroopManager = paramApolloManager.b(String.valueOf(l1));
      } while (paramTroopManager.apolloServerTS == paramInt);
      paramTroopManager.apolloServerTS = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", timeStamp: " + paramInt);
      }
      paramApolloManager.a(paramTroopManager);
      if (paramTroopManager.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        paramForwardBody = paramTroopManager.uin;
      }
    }
    for (;;)
    {
      localObject1 = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if ((TextUtils.isEmpty(paramForwardBody)) || (localObject1 == null)) {
        break;
      }
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(paramForwardBody)));
      ((VasExtensionHandler)localObject1).a((ArrayList)localObject2, "push");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin" + paramTroopManager.uin + ", isChatting getGetUserApolloDress...");
      break;
      paramForwardBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((paramForwardBody != null) && (paramForwardBody.a()) && (!TextUtils.isEmpty(paramForwardBody.a())))
      {
        if ((paramForwardBody.a() == 0) && (paramForwardBody.a().equals(paramTroopManager.uin)))
        {
          paramForwardBody = paramTroopManager.uin;
          continue;
        }
        if ((1 == paramForwardBody.a()) || (paramForwardBody.a() == 3000))
        {
          if ((!TextUtils.isEmpty(ApolloActionManager.a().g)) && (paramTroopManager.uin.equals(ApolloActionManager.a().g)))
          {
            paramForwardBody = paramTroopManager.uin;
            continue;
          }
          if ((!TextUtils.isEmpty(ApolloActionManager.a().f)) && (paramTroopManager.uin.equals(ApolloActionManager.a().f)))
          {
            paramForwardBody = paramTroopManager.uin;
            continue;
            if (l1 != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
              break;
            }
            paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
            if (paramInt != ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
            {
              paramForwardBody = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
              paramForwardBody.a(paramInt);
              if (paramInt == 1)
              {
                paramForwardBody = paramForwardBody.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
                if ((paramForwardBody.apolloStatus == 1) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
                {
                  paramForwardBody = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
                  if (paramForwardBody != null) {
                    paramForwardBody.a("whiteList");
                  }
                }
              }
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("CardHandler", 2, "handleGetDetalInfo apollo push white list: " + paramInt);
            break;
            return m;
          }
        }
      }
      paramForwardBody = null;
    }
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = paramMsgInfo.vMsg;
    PkgTools.a(paramMsgInfo, 0);
    int i = paramMsgInfo[4];
    PkgTools.a(paramMsgInfo, 5);
    PkgTools.a(paramMsgInfo, 9);
    PkgTools.a(paramMsgInfo, 13);
    i = paramMsgInfo[17];
    PkgTools.a(paramMsgInfo, 18);
    PkgTools.a(paramMsgInfo, 22);
    PkgTools.a(paramMsgInfo, 24);
    return null;
  }
  
  private void a(int paramInt)
  {
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    String str = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject1 = "";
    if (QLog.isColorLevel()) {
      QLog.d("reactive", 2, "addHotFriendAIOGrayTips type=" + paramInt1 + "level=" + paramInt2 + "flag=" + paramInt3 + "IsDisableInteractive=" + ((FriendsManager)localObject2).h);
    }
    if ((paramInt3 == 1) && (((FriendsManager)localObject2).h == 0)) {}
    Object localObject3;
    Object localObject4;
    switch (paramInt1)
    {
    default: 
      localObject2 = "";
      localObject3 = "";
      paramString = new UniteGrayTipParam(paramString, paramString, (String)localObject1, 0, 60516, 2097153, MessageCache.a());
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("image_resource", (String)localObject2);
      paramInt1 = ((String)localObject1).indexOf("[]");
      if (str.contains("[]"))
      {
        paramInt2 = ((String)localObject1).length() - (((String)localObject3).length() + 3 + "[]".length());
        paramInt1 = paramInt2;
        if (QLog.isColorLevel())
        {
          QLog.d("reactive", 2, "addHotFriendAIOGraynickName=" + str + "iconPos=" + paramInt2);
          paramInt1 = paramInt2;
        }
      }
      if (paramInt1 >= 0) {
        paramString.a(paramInt1, "[]".length() + paramInt1, (Bundle)localObject4);
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 11);
      ((Bundle)localObject2).putString("key_action_DATA", (String)localObject3);
      paramInt2 = ((String)localObject1).indexOf((String)localObject3);
      if (str.contains((CharSequence)localObject3))
      {
        paramInt3 = ((String)localObject1).length() - (((String)localObject3).length() + 3);
        paramInt2 = paramInt3;
        if (QLog.isColorLevel())
        {
          QLog.d("reactive", 2, "addHotFriendAIOGraynickName=" + str + "spanPos=" + paramInt3);
          paramInt2 = paramInt3;
        }
      }
      if (paramInt2 >= 0) {
        paramString.a(paramInt2, ((String)localObject3).length() + paramInt2, (Bundle)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + (String)localObject1 + "spanPos=" + paramInt2 + "iconPos=" + paramInt1 + "linkStr=" + (String)localObject3 + "grayStr=" + (String)localObject1);
      }
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
      return;
    case 1: 
      paramInt1 = ((FriendsManager)localObject2).d;
      paramInt3 = ((FriendsManager)localObject2).e;
      if (paramInt2 == 1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372683);
        localObject2 = "gray_small_zan";
      }
      for (;;)
      {
        localObject4 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372691), new Object[] { str, Integer.valueOf(paramInt1), "[]", localObject1 });
        localObject3 = localObject1;
        localObject1 = localObject4;
        break;
        if (paramInt2 != 2) {
          break label654;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372685);
        localObject2 = "gray_big_zan";
        paramInt1 = paramInt3;
      }
      QLog.e("reactive", 2, "addHotFriendAIOGrayTips praise up but level =" + paramInt2);
      return;
    case 2: 
      label654:
      paramInt1 = ((FriendsManager)localObject2).b;
      paramInt3 = ((FriendsManager)localObject2).c;
      if (paramInt2 == 1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372679);
        localObject2 = "gray_small_fire";
      }
      for (;;)
      {
        localObject4 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372692), new Object[] { str, Integer.valueOf(paramInt1), "[]", localObject1 });
        localObject3 = localObject1;
        localObject1 = localObject4;
        break;
        if (paramInt2 != 2) {
          break label805;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372681);
        localObject2 = "gray_big_fire";
        paramInt1 = paramInt3;
      }
      label805:
      QLog.e("reactive", 2, "addHotFriendAIOGrayTips chat up but level =" + paramInt2);
      return;
    }
    paramInt1 = ((FriendsManager)localObject2).f;
    paramInt3 = ((FriendsManager)localObject2).g;
    if (paramInt2 == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372687);
      localObject2 = "gray_small_ship";
    }
    for (;;)
    {
      localObject4 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372693), new Object[] { str, Integer.valueOf(paramInt1), "[]", localObject1 });
      localObject3 = localObject1;
      localObject1 = localObject4;
      break;
      if (paramInt2 != 2) {
        break label956;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372689);
      localObject2 = "gray_big_ship";
      paramInt1 = paramInt3;
    }
    label956:
    QLog.e("reactive", 2, "addHotFriendAIOGrayTips ship up but level =" + paramInt2);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleC2COnlinePushMsgResp");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.cq = paramSvcReqPushMsg.wUserActive;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnlinePush.ReqPush,notify.wUserActive:" + paramSvcReqPushMsg.wUserActive);
    }
    String str1 = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
    ArrayList localArrayList3;
    long l3;
    int n;
    ArrayList localArrayList4;
    MsgInfo localMsgInfo;
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      localArrayList3 = new ArrayList();
      l3 = paramSvcReqPushMsg.lUin;
      n = paramSvcReqPushMsg.svrip;
      localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      if (localIterator.hasNext()) {
        localMsgInfo = (MsgInfo)localIterator.next();
      }
    }
    int j;
    MessageRecord localMessageRecord;
    label504:
    int i;
    label577:
    boolean bool1;
    int k;
    for (;;)
    {
      byte[] arrayOfByte;
      long l1;
      long l2;
      long l4;
      try
      {
        new ArrayList();
        j = localMsgInfo.shMsgType;
        arrayOfByte = null;
        localMessageRecord = null;
        l1 = localMsgInfo.lFromUin;
        l2 = localMsgInfo.lFromUin;
        if (paramFromServiceMsg.getUin() != null) {
          continue;
        }
        paramToServiceMsg = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        l4 = paramToServiceMsg.longValue();
        if (l4 == l1) {}
        paramToServiceMsg = new DelMsgInfo();
        ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(localMsgInfo.lFromUin);
        paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
        paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
        paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
        paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
        localArrayList3.add(paramToServiceMsg);
        if ((42 != j) && (83 != j) && (127 != j) && (QLog.isColorLevel())) {
          MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", str1, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
        }
        if (!OnLinePushMsgTypeProcessorDispatcher.a().containsKey(Integer.valueOf(j))) {
          continue;
        }
        paramToServiceMsg = b(j, localMsgInfo, paramSvcReqPushMsg);
        if (paramToServiceMsg == null) {
          break label2475;
        }
        if (paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          localArrayList1.add(paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        }
        if (paramToServiceMsg.jdField_a_of_type_Boolean) {
          break;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        String str2;
        paramToServiceMsg.printStackTrace();
        if ((localMsgInfo.vMsg == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + HexUtil.a(localMsgInfo.vMsg));
        continue;
      }
      if (paramToServiceMsg != null)
      {
        localMessageRecord = MessageRecordFactory.a(i);
        if (j != 1006) {
          break label2260;
        }
        str2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1));
        localMessageRecord.init(String.valueOf(l3), ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2)), str2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        localMessageRecord.shmsgseq = localMsgInfo.shMsgSeq;
        localMessageRecord.isread = bool1;
        localMessageRecord.msgUid = localMsgInfo.lMsgUid;
        localMessageRecord.msgData = arrayOfByte;
        if (k > 0) {
          localMessageRecord.extraflag = k;
        }
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true)) {
          localArrayList1.add(localMessageRecord);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l2 + " msgType: " + i + " friendType: " + j + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + Utils.a(paramToServiceMsg));
        }
      }
      if (localMsgInfo.uAppShareID <= 0L) {
        break;
      }
      localArrayList4.add(AppShareIDUtil.a(localMsgInfo.uAppShareID));
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      continue;
      if (169 == j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
        }
        if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, String.valueOf(l2), String.valueOf(l1), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
          break;
        }
        localArrayList3.remove(paramToServiceMsg);
        paramToServiceMsg = new String(localMsgInfo.vMsg) + localMsgInfo.uMsgTime;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramToServiceMsg))
        {
          paramToServiceMsg = new long[1];
          paramToServiceMsg[0] = localMsgInfo.lFromUin;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
          }
          a(String.valueOf(l2), l3, paramToServiceMsg, localMsgInfo.vMsg, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq, false);
          localMsgInfo.lFromUin = paramToServiceMsg[0];
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
        break;
      }
      if (8 == j)
      {
        paramToServiceMsg = new byte[4];
        if (localMsgInfo.vMsg.length > 4) {
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
        }
        l1 = PkgTools.a(paramToServiceMsg, 0);
        if (localMsgInfo.vMsg.length >= 9)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(MessageUtils.b(paramToServiceMsg), "utf-8");
          break label2498;
        }
      }
      else
      {
        if (132 == j)
        {
          paramToServiceMsg = new byte[4];
          if (localMsgInfo.vMsg.length > 4) {
            PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
          }
          l1 = PkgTools.a(paramToServiceMsg, 0);
          paramToServiceMsg = arrayOfByte;
          if (localMsgInfo.vMsg.length < 9) {
            break label2521;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(MessageUtils.b(paramToServiceMsg), "utf-8");
          break label2521;
        }
        if (732 == j)
        {
          if (localMsgInfo.vMsg == null) {
            return;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
          i = paramToServiceMsg[4];
          if (!QLog.isColorLevel()) {
            break label2545;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + PkgTools.a(localMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + localMsgInfo.shMsgSeq);
          break label2545;
          label1350:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2562;
          }
          paramToServiceMsg = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
          arrayOfByte = new byte[localMsgInfo.vMsg.length - 7];
          PkgTools.a(arrayOfByte, 0, localMsgInfo.vMsg, 7, arrayOfByte.length);
          paramToServiceMsg = paramToServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, arrayOfByte, localMsgInfo.shMsgSeq, localMsgInfo.uRealMsgTime, false, false);
          if (paramToServiceMsg == null) {
            break label2562;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2562;
          label1441:
          if (!((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramToServiceMsg, localMsgInfo.shMsgSeq)) {
            break label2562;
          }
          return;
          label1466:
          if (i == 15)
          {
            a(paramToServiceMsg, localMsgInfo.shMsgSeq);
            return;
          }
          if (i != 6) {
            break label2602;
          }
          g(paramToServiceMsg);
          break label2562;
        }
      }
      for (;;)
      {
        label1500:
        if (localMsgInfo.vMsg.length > 7)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
          a(paramToServiceMsg, i);
        }
        label2260:
        label2465:
        label2475:
        label2498:
        label2521:
        label2545:
        label2562:
        label2602:
        do
        {
          if (i == 18)
          {
            l4 = PkgTools.a(localMsgInfo.vMsg, 0);
            i = localMsgInfo.vMsg.length;
            if (i <= 7) {
              break label2465;
            }
          }
          for (;;)
          {
            try
            {
              arrayOfByte = new byte[localMsgInfo.vMsg.length - 7];
              PkgTools.a(arrayOfByte, 0, localMsgInfo.vMsg, 7, arrayOfByte.length);
              paramToServiceMsg = new msg_comm.Msg();
            }
            catch (Exception localException3)
            {
              Object localObject1;
              int m;
              boolean bool2;
              boolean bool3;
              Object localObject2;
              paramToServiceMsg = null;
              continue;
              i = 1000;
              continue;
              i = -1;
              j = 64536;
              continue;
              paramToServiceMsg = null;
              i = 64536;
              bool1 = false;
              k = -1;
              j = 0;
              Object localObject3 = localMessageRecord;
            }
            try
            {
              paramToServiceMsg.mergeFrom(arrayOfByte);
              a(String.valueOf(l4), paramToServiceMsg);
            }
            catch (Exception localException2)
            {
              continue;
            }
            arrayOfByte.printStackTrace();
            continue;
            if (i != 19) {
              continue;
            }
            l4 = PkgTools.a(localMsgInfo.vMsg, 0);
            paramToServiceMsg = null;
            if (localMsgInfo.vMsg.length > 7) {
              paramToServiceMsg = new oidb_0xa88.NoticeBody();
            }
            try
            {
              arrayOfByte = new byte[localMsgInfo.vMsg.length - 7];
              PkgTools.a(arrayOfByte, 0, localMsgInfo.vMsg, 7, arrayOfByte.length);
              paramToServiceMsg.mergeFrom(arrayOfByte);
              a(String.valueOf(l4), paramToServiceMsg);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              continue;
            }
            if (230 == j)
            {
              paramToServiceMsg = new String(MessageUtils.b(localMsgInfo.vMsg), "utf-8");
              localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(l2 + "");
              if ((localObject1 != null) && (((Friends)localObject1).isFriend()))
              {
                i = 0;
                localObject1 = new SafeMsg.SafeMoreInfo();
                ((SafeMsg.SafeMoreInfo)localObject1).strFromMobile.set(localMsgInfo.strFromMobile);
                ((SafeMsg.SafeMoreInfo)localObject1).strFromName.set(localMsgInfo.strFromName);
                ((SafeMsg.SafeMoreInfo)localObject1).strMsgTxt.set(paramToServiceMsg);
                localObject1 = ((SafeMsg.SafeMoreInfo)localObject1).toByteArray();
                m = 64534;
                bool1 = true;
                k = -1;
                j = i;
                i = m;
                break label504;
              }
              localObject1 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(String.valueOf(l1));
              if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
                continue;
              }
              i = 1006;
              continue;
            }
            if (SystemMsg.isSystemMessage(j))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(2);
              i = 64530 - (j - 187);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, localMsgInfo.lFromUin, j, i, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
              l2 = 9998L;
              paramToServiceMsg = null;
              bool1 = false;
              k = -1;
              j = 0;
              localObject1 = localMessageRecord;
              break label504;
            }
            if (SystemMsg.isTroopSystemMessage(j))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
              if (j == 45)
              {
                paramToServiceMsg = a(localMsgInfo, l3);
                if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
                  continue;
                }
                localArrayList1.add(paramToServiceMsg);
                continue;
                GroupSystemMsgController.a().a(l1, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                paramToServiceMsg = null;
                k = i;
                bool1 = false;
                m = 0;
                i = j;
                j = m;
                localObject1 = localMessageRecord;
                break label504;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, j, localMsgInfo.vMsg, localMsgInfo.lFromUin, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
              l2 = 9998L;
              i = 32769;
              j = SystemMsg.getTroopSystemMsgType(j);
              continue;
            }
            if (528 == j)
            {
              paramToServiceMsg = b(localMsgInfo, l4);
              if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
                continue;
              }
              localArrayList1.add(paramToServiceMsg);
              continue;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
            break;
            localMessageRecord.init(l3, l2, l1, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
            break label577;
            if (localArrayList4.size() > 0) {
              a(localArrayList4);
            }
            i = paramFromServiceMsg.getRequestSsoSeq();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localArrayList3, n, i);
            if (localArrayList1.size() > 0)
            {
              bool2 = MessageHandlerUtils.a(localArrayList1);
              bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
              i = MsgProxyUtils.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))
              {
                bool1 = true;
                paramToServiceMsg.a(localArrayList1, String.valueOf(l3), bool1);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramSvcReqPushMsg.uMsgTime);
                a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
              return;
            }
            bool1 = false;
            continue;
            paramToServiceMsg = null;
          }
          paramToServiceMsg = null;
          break label2498;
          paramToServiceMsg = null;
          i = 64536;
          bool1 = false;
          k = -1;
          j = 0;
          localObject2 = localMessageRecord;
          break label504;
          j = 1000;
          i = 64536;
          bool1 = false;
          k = -1;
          localObject2 = localMessageRecord;
          break label504;
          i = 64536;
          bool1 = false;
          k = -1;
          j = 1020;
          localObject2 = localMessageRecord;
          break label504;
          return;
          if (i == 16) {
            break label1350;
          }
          if (i == 17)
          {
            break label1350;
            paramToServiceMsg = null;
            i = 64536;
            bool1 = false;
            k = -1;
            j = 0;
            localObject2 = localMessageRecord;
            break label504;
          }
          if (i == 12) {
            break label1441;
          }
          if (i != 14) {
            break label1466;
          }
          break label1441;
          if (i == 11) {
            break label1500;
          }
        } while (i != 13);
      }
    }
  }
  
  private void a(String paramString, long paramLong1, long[] paramArrayOfLong, byte[] paramArrayOfByte, long paramLong2, short paramShort, boolean paramBoolean)
  {
    paramLong1 = paramArrayOfLong[0];
    paramArrayOfByte = BuddyTransfileProcessor.a(paramArrayOfByte, paramArrayOfLong);
    if (paramArrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, String.valueOf(paramArrayOfLong[0]), paramArrayOfByte, paramLong2, paramShort, paramLong1, paramBoolean);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new cmd0x2dc.GroupVisitorJoinMsg();
    try
    {
      cmd0x2dc.GroupVisitorJoinMsg localGroupVisitorJoinMsg = (cmd0x2dc.GroupVisitorJoinMsg)((cmd0x2dc.GroupVisitorJoinMsg)localObject).mergeFrom(paramArrayOfByte);
      long l = localGroupVisitorJoinMsg.uint64_group_code.get();
      paramArrayOfByte = localGroupVisitorJoinMsg.rpt_msg_visitor_join_info.get();
      int i;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(String.valueOf(l)))
        {
          Iterator localIterator = paramArrayOfByte.iterator();
          paramArrayOfByte = "";
          while (localIterator.hasNext())
          {
            cmd0x2dc.VisitorJoinInfo localVisitorJoinInfo = (cmd0x2dc.VisitorJoinInfo)localIterator.next();
            String str = "" + localVisitorJoinInfo.uint64_visitor_uin.get();
            if (!str.equalsIgnoreCase((String)localObject))
            {
              if (localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8().equals("")) {}
              for (paramArrayOfByte = paramArrayOfByte + str + "、";; paramArrayOfByte = paramArrayOfByte + localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8() + "、") {
                break;
              }
            }
          }
          localObject = paramArrayOfByte;
          if (paramArrayOfByte.length() > 1) {
            localObject = paramArrayOfByte.substring(0, paramArrayOfByte.length() - 1);
          }
          if (!localGroupVisitorJoinMsg.uint32_op_flag.has()) {
            break label389;
          }
          i = localGroupVisitorJoinMsg.uint32_op_flag.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "handleEnterOpenTroopHotChatPushMsg. groupCode=" + l + ", name=" + (String)localObject + ", op_flag=" + i);
          }
          if (paramInt != 11) {
            break label395;
          }
          paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131371482);
        }
      }
      for (;;)
      {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramArrayOfByte, 1, false, true);
        return;
        label389:
        i = 0;
        break;
        label395:
        paramArrayOfByte = (byte[])localObject;
        if (paramInt == 13) {
          if (1 == i) {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131371493);
          } else {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131371483);
          }
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return true;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = PkgTools.a(paramArrayOfByte, 5);
      long l3 = PkgTools.a(paramArrayOfByte, 9);
      int i = PkgTools.b(paramArrayOfByte, 13);
      paramArrayOfByte = PkgTools.a(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  private MessageRecord b(MsgInfo paramMsgInfo, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 107
    //   8: iconst_2
    //   9: ldc_w 1302
    //   12: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: getfield 703	OnlinePushPack/MsgInfo:vMsg	[B
    //   19: invokestatic 1307	com/tencent/mobileqq/service/gamecenter/GameCenterPackeger:a	([B)LIMMsgBodyPack/MsgType0x210;
    //   22: astore 8
    //   24: aload 8
    //   26: ifnonnull +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +33 -> 67
    //   37: ldc 107
    //   39: iconst_2
    //   40: new 109	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 1309
    //   50: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 8
    //   55: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   58: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload 8
    //   69: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   72: ldc2_w 1315
    //   75: lcmp
    //   76: ifne +144 -> 220
    //   79: aload 8
    //   81: getfield 1320	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   84: ifnull +136 -> 220
    //   87: aload 8
    //   89: getfield 1320	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +122 -> 216
    //   97: aload_1
    //   98: getfield 1325	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   101: ifnull +115 -> 216
    //   104: aload_1
    //   105: getfield 1325	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   108: astore 4
    //   110: aload 4
    //   112: ifnull +104 -> 216
    //   115: aload 4
    //   117: invokeinterface 1246 1 0
    //   122: ifle +94 -> 216
    //   125: aload_0
    //   126: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 11
    //   131: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 1327	com/tencent/mobileqq/servlet/GameCenterManagerImp
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull +77 -> 216
    //   142: aload 4
    //   144: invokeinterface 72 1 0
    //   149: astore 4
    //   151: aload 4
    //   153: invokeinterface 77 1 0
    //   158: ifeq +58 -> 216
    //   161: aload 4
    //   163: invokeinterface 81 1 0
    //   168: checkcast 1329	IMMsgBodyPack/PluginNum
    //   171: astore 5
    //   173: aload 5
    //   175: ifnull -24 -> 151
    //   178: aload 5
    //   180: getfield 1332	IMMsgBodyPack/PluginNum:dwID	J
    //   183: lstore_2
    //   184: aload 5
    //   186: getfield 1336	IMMsgBodyPack/PluginNum:cFlag	B
    //   189: ifne +21 -> 210
    //   192: iconst_0
    //   193: istore 22
    //   195: aload_1
    //   196: lload_2
    //   197: iload 22
    //   199: aload 5
    //   201: getfield 1339	IMMsgBodyPack/PluginNum:dwNUm	J
    //   204: invokevirtual 1342	com/tencent/mobileqq/servlet/GameCenterManagerImp:a	(JZJ)V
    //   207: goto -56 -> 151
    //   210: iconst_1
    //   211: istore 22
    //   213: goto -18 -> 195
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_1
    //   219: areturn
    //   220: aload 8
    //   222: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   225: ifnull +10458 -> 10683
    //   228: aload 8
    //   230: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   233: ldc2_w 1346
    //   236: lcmp
    //   237: ifne +32 -> 269
    //   240: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +12 -> 255
    //   246: ldc 107
    //   248: iconst_2
    //   249: ldc_w 1349
    //   252: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_0
    //   256: aload 8
    //   258: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   261: invokevirtual 1351	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([B)V
    //   264: aconst_null
    //   265: astore_1
    //   266: goto -48 -> 218
    //   269: aload 8
    //   271: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   274: ldc2_w 1352
    //   277: lcmp
    //   278: ifeq +27 -> 305
    //   281: aload 8
    //   283: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   286: ldc2_w 1354
    //   289: lcmp
    //   290: ifeq +15 -> 305
    //   293: aload 8
    //   295: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   298: ldc2_w 1356
    //   301: lcmp
    //   302: ifne +49 -> 351
    //   305: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +13 -> 321
    //   311: ldc_w 1359
    //   314: iconst_2
    //   315: ldc_w 1361
    //   318: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload_0
    //   322: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   325: bipush 11
    //   327: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   330: checkcast 1363	com/tencent/mobileqq/app/PublicAccountHandler
    //   333: aload 8
    //   335: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   338: aload 8
    //   340: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   343: invokevirtual 1366	com/tencent/mobileqq/app/PublicAccountHandler:a	(J[B)V
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -130 -> 218
    //   351: aload 8
    //   353: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   356: ldc2_w 1367
    //   359: lcmp
    //   360: ifne +44 -> 404
    //   363: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +13 -> 379
    //   369: ldc_w 1370
    //   372: iconst_2
    //   373: ldc_w 1372
    //   376: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload_0
    //   380: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   383: bipush 18
    //   385: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   388: checkcast 1374	com/tencent/mobileqq/app/ShieldListHandler
    //   391: aload 8
    //   393: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   396: invokevirtual 1375	com/tencent/mobileqq/app/ShieldListHandler:a	([B)V
    //   399: aconst_null
    //   400: astore_1
    //   401: goto -183 -> 218
    //   404: aload 8
    //   406: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   409: ldc2_w 1376
    //   412: lcmp
    //   413: ifne +18 -> 431
    //   416: aload_0
    //   417: lload_2
    //   418: aload 8
    //   420: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   423: invokespecial 1379	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:b	(J[B)V
    //   426: aconst_null
    //   427: astore_1
    //   428: goto -210 -> 218
    //   431: aload 8
    //   433: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   436: ldc2_w 1380
    //   439: lcmp
    //   440: ifne +91 -> 531
    //   443: new 1383	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   446: dup
    //   447: invokespecial 1384	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:<init>	()V
    //   450: aload 8
    //   452: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   455: invokevirtual 1385	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   458: checkcast 1383	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   461: getfield 1388	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:uint32_bubble_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   464: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   467: istore 11
    //   469: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   472: ifeq +31 -> 503
    //   475: ldc_w 458
    //   478: iconst_2
    //   479: new 109	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   486: ldc_w 1390
    //   489: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: iload 11
    //   494: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aconst_null
    //   504: astore_1
    //   505: goto -287 -> 218
    //   508: astore_1
    //   509: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +14 -> 526
    //   515: ldc_w 458
    //   518: iconst_2
    //   519: ldc_w 1392
    //   522: aload_1
    //   523: invokestatic 1395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   526: aconst_null
    //   527: astore_1
    //   528: goto -310 -> 218
    //   531: aload 8
    //   533: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   536: ldc2_w 1396
    //   539: lcmp
    //   540: ifne +606 -> 1146
    //   543: new 1399	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody
    //   546: dup
    //   547: invokespecial 1400	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:<init>	()V
    //   550: astore 4
    //   552: aload 4
    //   554: aload 8
    //   556: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   559: invokevirtual 1401	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   562: pop
    //   563: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +111 -> 677
    //   569: new 109	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   576: ldc_w 1403
    //   579: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: astore 5
    //   584: aload 4
    //   586: getfield 1404	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   589: invokevirtual 54	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   592: ifeq +10181 -> 10773
    //   595: aload 4
    //   597: getfield 1404	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   600: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   603: invokestatic 433	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   606: astore_1
    //   607: aload 5
    //   609: aload_1
    //   610: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 1406
    //   616: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: astore 5
    //   621: aload 4
    //   623: getfield 1409	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   626: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   629: ifeq +436 -> 1065
    //   632: aload 4
    //   634: getfield 1409	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   637: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   640: invokestatic 1411	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   643: astore_1
    //   644: ldc_w 1413
    //   647: iconst_2
    //   648: aload 5
    //   650: aload_1
    //   651: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc_w 1415
    //   657: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 4
    //   662: getfield 1418	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   665: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   668: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload 4
    //   679: getfield 1404	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   682: invokevirtual 54	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   685: ifeq +10083 -> 10768
    //   688: aload 4
    //   690: getfield 1409	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   693: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   696: ifeq +87 -> 783
    //   699: aload 4
    //   701: getfield 1409	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   704: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   707: istore 11
    //   709: aload 4
    //   711: getfield 1404	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   714: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   717: invokestatic 433	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   720: astore_1
    //   721: aload_0
    //   722: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   725: bipush 51
    //   727: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   730: checkcast 1293	com/tencent/mobileqq/app/TroopManager
    //   733: astore 5
    //   735: aload 5
    //   737: aload_1
    //   738: invokevirtual 1421	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   741: astore 6
    //   743: aload 6
    //   745: iload 11
    //   747: i2b
    //   748: putfield 1426	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   751: aload 5
    //   753: aload 6
    //   755: invokevirtual 1429	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   758: iconst_1
    //   759: aload 6
    //   761: getfield 1426	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   764: if_icmpne +19 -> 783
    //   767: aload_0
    //   768: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   771: bipush 20
    //   773: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   776: checkcast 1431	com/tencent/mobileqq/app/TroopHandler
    //   779: aload_1
    //   780: invokevirtual 1433	com/tencent/mobileqq/app/TroopHandler:f	(Ljava/lang/String;)V
    //   783: aload 4
    //   785: getfield 1418	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   788: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   791: ifeq +31 -> 822
    //   794: aload 4
    //   796: getfield 1404	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   799: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   802: lstore_2
    //   803: aload_0
    //   804: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   807: bipush 20
    //   809: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   812: checkcast 1431	com/tencent/mobileqq/app/TroopHandler
    //   815: lload_2
    //   816: invokestatic 433	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   819: invokevirtual 1433	com/tencent/mobileqq/app/TroopHandler:f	(Ljava/lang/String;)V
    //   822: aload 4
    //   824: getfield 1436	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_officemode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   827: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   830: ifeq +9938 -> 10768
    //   833: aload 4
    //   835: getfield 1404	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   838: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   841: invokestatic 433	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   844: astore 6
    //   846: aload_0
    //   847: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   850: bipush 51
    //   852: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   855: checkcast 1293	com/tencent/mobileqq/app/TroopManager
    //   858: astore 7
    //   860: aload 7
    //   862: invokevirtual 1439	com/tencent/mobileqq/app/TroopManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   865: astore 5
    //   867: aload 5
    //   869: invokevirtual 1443	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   872: aload 7
    //   874: aload 6
    //   876: invokevirtual 1421	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   879: astore_1
    //   880: aload_1
    //   881: ifnonnull +9884 -> 10765
    //   884: new 1423	com/tencent/mobileqq/data/TroopInfo
    //   887: dup
    //   888: invokespecial 1444	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   891: astore_1
    //   892: aload_1
    //   893: aload 6
    //   895: putfield 1447	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   898: aload_1
    //   899: ifnull +153 -> 1052
    //   902: aload 4
    //   904: getfield 1436	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_officemode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   907: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   910: iconst_1
    //   911: if_icmpne +122 -> 1033
    //   914: aload_1
    //   915: getfield 1450	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   918: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   921: invokestatic 1453	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;)Z
    //   924: ifeq +109 -> 1033
    //   927: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +13 -> 943
    //   933: ldc_w 1413
    //   936: iconst_2
    //   937: ldc_w 1455
    //   940: invokestatic 696	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   943: sipush 63508
    //   946: invokestatic 960	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   949: checkcast 1457	com/tencent/mobileqq/data/MessageForGrayTips
    //   952: astore 8
    //   954: aload 8
    //   956: aload_0
    //   957: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   960: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   963: aload 6
    //   965: aload 6
    //   967: aload_0
    //   968: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   971: invokevirtual 336	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   974: ldc_w 1458
    //   977: invokevirtual 1274	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   980: invokestatic 1291	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   983: sipush 63508
    //   986: iconst_1
    //   987: aload_0
    //   988: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   991: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   994: aload 6
    //   996: iconst_1
    //   997: invokevirtual 1461	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1000: getfield 1464	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shmsgseq	J
    //   1003: lconst_1
    //   1004: ladd
    //   1005: invokevirtual 1465	com/tencent/mobileqq/data/MessageForGrayTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   1008: aload 8
    //   1010: iconst_1
    //   1011: putfield 1466	com/tencent/mobileqq/data/MessageForGrayTips:isread	Z
    //   1014: aload_0
    //   1015: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1018: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1021: aload 8
    //   1023: aload_0
    //   1024: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1027: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1030: invokevirtual 1469	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1033: aload_1
    //   1034: aload 4
    //   1036: getfield 1436	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_officemode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1039: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1042: i2l
    //   1043: putfield 1472	com/tencent/mobileqq/data/TroopInfo:dwOfficeMode	J
    //   1046: aload 7
    //   1048: aload_1
    //   1049: invokevirtual 1429	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1052: aload 5
    //   1054: invokevirtual 1474	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   1057: aload 5
    //   1059: invokevirtual 1476	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1062: goto +9706 -> 10768
    //   1065: ldc -112
    //   1067: astore_1
    //   1068: goto -424 -> 644
    //   1071: astore_1
    //   1072: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1075: ifeq +33 -> 1108
    //   1078: ldc_w 1413
    //   1081: iconst_2
    //   1082: new 109	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1089: ldc_w 1478
    //   1092: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload_1
    //   1096: invokevirtual 1479	java/lang/Exception:toString	()Ljava/lang/String;
    //   1099: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1105: invokestatic 696	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1108: aload 5
    //   1110: invokevirtual 1476	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1113: goto +9655 -> 10768
    //   1116: astore_1
    //   1117: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1120: ifeq +13 -> 1133
    //   1123: ldc_w 1413
    //   1126: iconst_2
    //   1127: ldc_w 1481
    //   1130: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1133: aconst_null
    //   1134: astore_1
    //   1135: goto -917 -> 218
    //   1138: astore_1
    //   1139: aload 5
    //   1141: invokevirtual 1476	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1144: aload_1
    //   1145: athrow
    //   1146: aload 8
    //   1148: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1151: ldc2_w 1482
    //   1154: lcmp
    //   1155: ifne +28 -> 1183
    //   1158: aload_0
    //   1159: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1162: bipush 16
    //   1164: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1167: checkcast 367	com/tencent/mobileqq/stt/SttManager
    //   1170: aload 8
    //   1172: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1175: invokevirtual 1484	com/tencent/mobileqq/stt/SttManager:a	([B)V
    //   1178: aconst_null
    //   1179: astore_1
    //   1180: goto -962 -> 218
    //   1183: aload 8
    //   1185: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1188: ldc2_w 1485
    //   1191: lcmp
    //   1192: ifne +20 -> 1212
    //   1195: aload_0
    //   1196: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1199: aload 8
    //   1201: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1204: invokestatic 1491	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   1207: aconst_null
    //   1208: astore_1
    //   1209: goto -991 -> 218
    //   1212: aload 8
    //   1214: ifnull +38 -> 1252
    //   1217: aload 8
    //   1219: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1222: ldc2_w 1492
    //   1225: lcmp
    //   1226: ifne +26 -> 1252
    //   1229: aload 8
    //   1231: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1234: ifnull +18 -> 1252
    //   1237: aload_0
    //   1238: lload_2
    //   1239: aload 8
    //   1241: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1244: invokevirtual 1494	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(J[B)V
    //   1247: aconst_null
    //   1248: astore_1
    //   1249: goto -1031 -> 218
    //   1252: aload 8
    //   1254: ifnull +37 -> 1291
    //   1257: aload 8
    //   1259: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1262: ldc2_w 1495
    //   1265: lcmp
    //   1266: ifne +25 -> 1291
    //   1269: aload 8
    //   1271: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1274: ifnull +17 -> 1291
    //   1277: aload_0
    //   1278: aload 8
    //   1280: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1283: invokevirtual 1498	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:f	([B)V
    //   1286: aconst_null
    //   1287: astore_1
    //   1288: goto -1070 -> 218
    //   1291: aload 8
    //   1293: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1296: ldc2_w 1499
    //   1299: lcmp
    //   1300: ifne +25 -> 1325
    //   1303: aload 8
    //   1305: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1308: ifnull +17 -> 1325
    //   1311: aload_0
    //   1312: aload 8
    //   1314: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1317: invokevirtual 1502	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:b	([B)V
    //   1320: aconst_null
    //   1321: astore_1
    //   1322: goto -1104 -> 218
    //   1325: aload 8
    //   1327: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1330: ldc2_w 1503
    //   1333: lcmp
    //   1334: ifne +17 -> 1351
    //   1337: aload_0
    //   1338: aload 8
    //   1340: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1343: invokevirtual 1506	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:d	([B)V
    //   1346: aconst_null
    //   1347: astore_1
    //   1348: goto -1130 -> 218
    //   1351: aload 8
    //   1353: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1356: ldc2_w 1507
    //   1359: lcmp
    //   1360: ifne +17 -> 1377
    //   1363: aload_0
    //   1364: aload 8
    //   1366: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1369: invokevirtual 1510	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:e	([B)V
    //   1372: aconst_null
    //   1373: astore_1
    //   1374: goto -1156 -> 218
    //   1377: aload 8
    //   1379: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1382: ldc2_w 1511
    //   1385: lcmp
    //   1386: ifne +25 -> 1411
    //   1389: aload 8
    //   1391: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1394: ifnull +17 -> 1411
    //   1397: aload_0
    //   1398: aload 8
    //   1400: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1403: invokevirtual 1514	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:c	([B)V
    //   1406: aconst_null
    //   1407: astore_1
    //   1408: goto -1190 -> 218
    //   1411: aload 8
    //   1413: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1416: ldc2_w 1515
    //   1419: lcmp
    //   1420: ifne +80 -> 1500
    //   1423: aload 8
    //   1425: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1428: ifnull +72 -> 1500
    //   1431: new 1518	tencent/im/s2c/msgtype0x210/submsgtype0x93/submsgtype0x93$MsgBody
    //   1434: dup
    //   1435: invokespecial 1519	tencent/im/s2c/msgtype0x210/submsgtype0x93/submsgtype0x93$MsgBody:<init>	()V
    //   1438: astore_1
    //   1439: aload_1
    //   1440: aload 8
    //   1442: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1445: invokevirtual 1520	tencent/im/s2c/msgtype0x210/submsgtype0x93/submsgtype0x93$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1448: pop
    //   1449: aload_0
    //   1450: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1453: bipush 75
    //   1455: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1458: checkcast 1522	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler
    //   1461: astore 4
    //   1463: aload 4
    //   1465: ifnull +9 -> 1474
    //   1468: aload 4
    //   1470: aload_1
    //   1471: invokevirtual 1525	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x93/submsgtype0x93$MsgBody;)V
    //   1474: aconst_null
    //   1475: astore_1
    //   1476: goto -1258 -> 218
    //   1479: astore_1
    //   1480: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1483: ifeq -9 -> 1474
    //   1486: ldc_w 458
    //   1489: iconst_2
    //   1490: ldc_w 1527
    //   1493: aload_1
    //   1494: invokestatic 1395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1497: goto -23 -> 1474
    //   1500: aload 8
    //   1502: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1505: ldc2_w 1528
    //   1508: lcmp
    //   1509: ifne +67 -> 1576
    //   1512: aload 8
    //   1514: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1517: ifnull +59 -> 1576
    //   1520: new 1531	tencent/im/s2c/msgtype0x210/submsgtype0x8f/submsgtype0x8f$MsgBody
    //   1523: dup
    //   1524: invokespecial 1532	tencent/im/s2c/msgtype0x210/submsgtype0x8f/submsgtype0x8f$MsgBody:<init>	()V
    //   1527: astore_1
    //   1528: aload_1
    //   1529: aload 8
    //   1531: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1534: invokevirtual 1533	tencent/im/s2c/msgtype0x210/submsgtype0x8f/submsgtype0x8f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1537: pop
    //   1538: aload_0
    //   1539: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1542: bipush 75
    //   1544: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1547: checkcast 1522	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler
    //   1550: astore 4
    //   1552: aload 4
    //   1554: ifnull +9 -> 1563
    //   1557: aload 4
    //   1559: aload_1
    //   1560: invokevirtual 1536	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x8f/submsgtype0x8f$MsgBody;)V
    //   1563: aconst_null
    //   1564: astore_1
    //   1565: goto -1347 -> 218
    //   1568: astore_1
    //   1569: aload_1
    //   1570: invokevirtual 1537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1573: goto -10 -> 1563
    //   1576: aload 8
    //   1578: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1581: ldc2_w 1538
    //   1584: lcmp
    //   1585: ifne +315 -> 1900
    //   1588: aload 8
    //   1590: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1593: ifnull +307 -> 1900
    //   1596: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1599: ifeq +13 -> 1612
    //   1602: ldc_w 1541
    //   1605: iconst_2
    //   1606: ldc_w 1543
    //   1609: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1612: new 1545	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock
    //   1615: dup
    //   1616: invokespecial 1546	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:<init>	()V
    //   1619: astore_1
    //   1620: aload_1
    //   1621: aload 8
    //   1623: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1626: invokevirtual 1547	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1629: pop
    //   1630: new 388	android/content/Intent
    //   1633: dup
    //   1634: invokespecial 1548	android/content/Intent:<init>	()V
    //   1637: astore 4
    //   1639: aload 4
    //   1641: ldc_w 1550
    //   1644: aload_1
    //   1645: getfield 1553	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1648: invokevirtual 1557	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1651: invokevirtual 398	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1654: pop
    //   1655: aload 4
    //   1657: ldc_w 1559
    //   1660: aload_1
    //   1661: getfield 1562	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1664: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1667: invokevirtual 403	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1670: pop
    //   1671: aload 4
    //   1673: ldc_w 1566
    //   1676: aload_1
    //   1677: getfield 1569	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1680: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1683: invokevirtual 403	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1686: pop
    //   1687: aload 4
    //   1689: ldc_w 1571
    //   1692: aload_1
    //   1693: getfield 1574	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1696: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1699: invokevirtual 403	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1702: pop
    //   1703: aload 4
    //   1705: ldc_w 1576
    //   1708: aload_1
    //   1709: getfield 1579	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1712: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1715: invokevirtual 403	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1718: pop
    //   1719: aload_1
    //   1720: getfield 1583	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_wording_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1723: invokevirtual 1586	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   1726: astore 5
    //   1728: new 659	java/util/ArrayList
    //   1731: dup
    //   1732: invokespecial 865	java/util/ArrayList:<init>	()V
    //   1735: astore 6
    //   1737: aload 5
    //   1739: ifnull +21 -> 1760
    //   1742: aload 5
    //   1744: invokeinterface 1246 1 0
    //   1749: ifle +11 -> 1760
    //   1752: aload 6
    //   1754: aload 5
    //   1756: invokevirtual 1590	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   1759: pop
    //   1760: aload 4
    //   1762: ldc_w 1592
    //   1765: aload 6
    //   1767: invokevirtual 1596	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1770: pop
    //   1771: aload_0
    //   1772: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1775: aload 4
    //   1777: invokevirtual 1599	com/tencent/mobileqq/app/QQAppInterface:setDevLockIntent	(Landroid/content/Intent;)V
    //   1780: aload_0
    //   1781: sipush 8007
    //   1784: iconst_1
    //   1785: bipush 6
    //   1787: anewarray 199	java/lang/Object
    //   1790: dup
    //   1791: iconst_0
    //   1792: aload_1
    //   1793: getfield 1553	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1796: invokevirtual 1557	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1799: invokestatic 1604	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1802: aastore
    //   1803: dup
    //   1804: iconst_1
    //   1805: aload_1
    //   1806: getfield 1562	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1809: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1812: aastore
    //   1813: dup
    //   1814: iconst_2
    //   1815: aload_1
    //   1816: getfield 1569	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1819: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1822: aastore
    //   1823: dup
    //   1824: iconst_3
    //   1825: aload_1
    //   1826: getfield 1574	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1829: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1832: aastore
    //   1833: dup
    //   1834: iconst_4
    //   1835: aload_1
    //   1836: getfield 1579	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1839: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1842: aastore
    //   1843: dup
    //   1844: iconst_5
    //   1845: aload 6
    //   1847: aastore
    //   1848: invokevirtual 1605	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1851: aconst_null
    //   1852: astore_1
    //   1853: goto -1635 -> 218
    //   1856: astore_1
    //   1857: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1860: ifeq +13 -> 1873
    //   1863: ldc_w 1541
    //   1866: iconst_2
    //   1867: ldc_w 1607
    //   1870: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1873: aload_0
    //   1874: sipush 8007
    //   1877: iconst_0
    //   1878: iconst_2
    //   1879: anewarray 199	java/lang/Object
    //   1882: dup
    //   1883: iconst_0
    //   1884: iconst_1
    //   1885: invokestatic 1604	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1888: aastore
    //   1889: dup
    //   1890: iconst_1
    //   1891: ldc -112
    //   1893: aastore
    //   1894: invokevirtual 1605	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1897: goto -46 -> 1851
    //   1900: aload 8
    //   1902: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1905: ldc2_w 1608
    //   1908: lcmp
    //   1909: ifne +330 -> 2239
    //   1912: aload 8
    //   1914: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1917: ifnull +322 -> 2239
    //   1920: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1923: ifeq +13 -> 1936
    //   1926: ldc_w 1541
    //   1929: iconst_2
    //   1930: ldc_w 1611
    //   1933: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1936: new 1613	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   1939: dup
    //   1940: invokespecial 1614	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   1943: pop
    //   1944: aconst_null
    //   1945: astore 4
    //   1947: aconst_null
    //   1948: astore 5
    //   1950: aconst_null
    //   1951: astore 6
    //   1953: aconst_null
    //   1954: astore 7
    //   1956: new 1613	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   1959: dup
    //   1960: invokespecial 1614	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   1963: astore 9
    //   1965: aload 9
    //   1967: aload 8
    //   1969: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1972: invokevirtual 1615	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1975: pop
    //   1976: aload 9
    //   1978: getfield 1618	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1981: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1984: ifeq +26 -> 2010
    //   1987: new 259	java/lang/String
    //   1990: dup
    //   1991: aload 9
    //   1993: getfield 1618	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1996: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1999: invokevirtual 209	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2002: ldc_w 1062
    //   2005: invokespecial 1065	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2008: astore 4
    //   2010: aload 9
    //   2012: getfield 1621	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2015: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2018: ifeq +26 -> 2044
    //   2021: new 259	java/lang/String
    //   2024: dup
    //   2025: aload 9
    //   2027: getfield 1621	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2030: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2033: invokevirtual 209	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2036: ldc_w 1062
    //   2039: invokespecial 1065	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2042: astore 5
    //   2044: aload 9
    //   2046: getfield 1624	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2049: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2052: ifeq +26 -> 2078
    //   2055: new 259	java/lang/String
    //   2058: dup
    //   2059: aload 9
    //   2061: getfield 1624	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2064: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2067: invokevirtual 209	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2070: ldc_w 1062
    //   2073: invokespecial 1065	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2076: astore 6
    //   2078: aload 9
    //   2080: getfield 1627	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2083: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2086: ifeq +16 -> 2102
    //   2089: aload 9
    //   2091: getfield 1627	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2094: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2097: invokevirtual 209	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2100: astore 7
    //   2102: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2105: ifeq +53 -> 2158
    //   2108: ldc_w 1541
    //   2111: iconst_2
    //   2112: new 109	java/lang/StringBuilder
    //   2115: dup
    //   2116: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2119: ldc_w 1629
    //   2122: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: aload 4
    //   2127: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: ldc_w 1631
    //   2133: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: aload 5
    //   2138: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2141: ldc_w 1633
    //   2144: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2147: aload 6
    //   2149: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2155: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2158: invokestatic 1638	com/tencent/mobileqq/equipmentlock/EquipmentLockImpl:a	()Lcom/tencent/mobileqq/equipmentlock/EquipmentLockImpl;
    //   2161: aload_0
    //   2162: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2165: aload 4
    //   2167: aload 5
    //   2169: aload 6
    //   2171: aload 7
    //   2173: invokevirtual 1641	com/tencent/mobileqq/equipmentlock/EquipmentLockImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    //   2176: aload_1
    //   2177: getfield 883	OnlinePushPack/MsgInfo:lFromUin	J
    //   2180: lstore_2
    //   2181: aload_1
    //   2182: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2185: istore 11
    //   2187: aload_1
    //   2188: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   2191: lstore 20
    //   2193: aload_1
    //   2194: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   2197: istore 12
    //   2199: aload_0
    //   2200: getfield 1214	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2203: lload_2
    //   2204: iload 11
    //   2206: lload 20
    //   2208: iload 12
    //   2210: invokestatic 1646	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   2213: aconst_null
    //   2214: astore_1
    //   2215: goto -1997 -> 218
    //   2218: astore 4
    //   2220: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2223: ifeq -47 -> 2176
    //   2226: ldc_w 1541
    //   2229: iconst_2
    //   2230: ldc_w 1648
    //   2233: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2236: goto -60 -> 2176
    //   2239: aload 8
    //   2241: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2244: ldc2_w 1649
    //   2247: lcmp
    //   2248: ifne +36 -> 2284
    //   2251: aload 8
    //   2253: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2256: ifnull +28 -> 2284
    //   2259: aload_0
    //   2260: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2263: bipush 24
    //   2265: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2268: checkcast 1652	com/tencent/mobileqq/app/SafeCenterPushHandler
    //   2271: aload 8
    //   2273: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2276: invokevirtual 1653	com/tencent/mobileqq/app/SafeCenterPushHandler:a	([B)V
    //   2279: aconst_null
    //   2280: astore_1
    //   2281: goto -2063 -> 218
    //   2284: aload 8
    //   2286: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2289: ldc2_w 1654
    //   2292: lcmp
    //   2293: ifne +224 -> 2517
    //   2296: aload 8
    //   2298: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2301: ifnull +216 -> 2517
    //   2304: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2307: ifeq +13 -> 2320
    //   2310: ldc_w 1657
    //   2313: iconst_2
    //   2314: ldc_w 1659
    //   2317: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2320: aload_0
    //   2321: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2324: iconst_4
    //   2325: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2328: checkcast 1488	com/tencent/mobileqq/app/ConfigHandler
    //   2331: astore_1
    //   2332: aload_1
    //   2333: ifnull +171 -> 2504
    //   2336: new 1661	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody
    //   2339: dup
    //   2340: invokespecial 1662	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:<init>	()V
    //   2343: astore 4
    //   2345: aload 4
    //   2347: aload 8
    //   2349: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2352: invokevirtual 1663	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2355: pop
    //   2356: aload 4
    //   2358: getfield 1667	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   2361: invokevirtual 1670	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   2364: istore 11
    //   2366: aload 4
    //   2368: getfield 1673	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:task_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2371: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2374: astore 6
    //   2376: new 659	java/util/ArrayList
    //   2379: dup
    //   2380: invokespecial 865	java/util/ArrayList:<init>	()V
    //   2383: astore 5
    //   2385: aload 6
    //   2387: ifnull +87 -> 2474
    //   2390: aload 6
    //   2392: invokeinterface 1246 1 0
    //   2397: ifle +77 -> 2474
    //   2400: aload 6
    //   2402: invokeinterface 72 1 0
    //   2407: astore 6
    //   2409: aload 6
    //   2411: invokeinterface 77 1 0
    //   2416: ifeq +58 -> 2474
    //   2419: aload 6
    //   2421: invokeinterface 81 1 0
    //   2426: checkcast 1675	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo
    //   2429: astore 7
    //   2431: new 1677	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   2434: dup
    //   2435: invokespecial 1678	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   2438: astore 8
    //   2440: aload 8
    //   2442: aload 7
    //   2444: getfield 1681	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2447: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2450: putfield 1684	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   2453: aload 5
    //   2455: aload 8
    //   2457: invokevirtual 668	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2460: pop
    //   2461: goto -52 -> 2409
    //   2464: astore 5
    //   2466: aload 5
    //   2468: invokevirtual 1537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2471: goto -115 -> 2356
    //   2474: aload 4
    //   2476: getfield 1687	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2479: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2482: lstore_2
    //   2483: iload 11
    //   2485: iconst_1
    //   2486: if_icmpne +23 -> 2509
    //   2489: iconst_0
    //   2490: istore 11
    //   2492: aload_1
    //   2493: lload_2
    //   2494: invokestatic 433	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2497: iload 11
    //   2499: aload 5
    //   2501: invokevirtual 1690	com/tencent/mobileqq/app/ConfigHandler:a	(Ljava/lang/String;ILjava/util/ArrayList;)V
    //   2504: aconst_null
    //   2505: astore_1
    //   2506: goto -2288 -> 218
    //   2509: sipush 3000
    //   2512: istore 11
    //   2514: goto -22 -> 2492
    //   2517: aload 8
    //   2519: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2522: ldc2_w 1691
    //   2525: lcmp
    //   2526: ifne +105 -> 2631
    //   2529: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2532: ifeq +13 -> 2545
    //   2535: ldc_w 1694
    //   2538: iconst_2
    //   2539: ldc_w 1696
    //   2542: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2545: aload_0
    //   2546: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2549: bipush 56
    //   2551: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2554: checkcast 1698	com/tencent/mobileqq/app/SecMsgManager
    //   2557: aload_1
    //   2558: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2561: invokevirtual 1700	com/tencent/mobileqq/app/SecMsgManager:a	(I)Z
    //   2564: ifeq +44 -> 2608
    //   2567: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2570: ifeq +33 -> 2603
    //   2573: ldc_w 458
    //   2576: iconst_2
    //   2577: new 109	java/lang/StringBuilder
    //   2580: dup
    //   2581: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2584: ldc_w 1702
    //   2587: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2590: aload_1
    //   2591: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2594: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2597: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2600: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2603: aconst_null
    //   2604: astore_1
    //   2605: goto -2387 -> 218
    //   2608: aload_0
    //   2609: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2612: bipush 40
    //   2614: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2617: checkcast 1704	com/tencent/mobileqq/app/SecMsgHandler
    //   2620: aload 8
    //   2622: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2625: invokevirtual 1705	com/tencent/mobileqq/app/SecMsgHandler:a	([B)V
    //   2628: goto -25 -> 2603
    //   2631: aload 8
    //   2633: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2636: ldc2_w 1706
    //   2639: lcmp
    //   2640: ifne +163 -> 2803
    //   2643: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2646: ifeq +44 -> 2690
    //   2649: new 109	java/lang/StringBuilder
    //   2652: dup
    //   2653: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2656: ldc_w 1709
    //   2659: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2662: astore_1
    //   2663: aload 8
    //   2665: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2668: ifnull +87 -> 2755
    //   2671: iconst_1
    //   2672: istore 22
    //   2674: ldc_w 1711
    //   2677: iconst_2
    //   2678: aload_1
    //   2679: iload 22
    //   2681: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2684: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2687: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2690: new 1713	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody
    //   2693: dup
    //   2694: invokespecial 1714	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:<init>	()V
    //   2697: astore_1
    //   2698: aload_1
    //   2699: aload 8
    //   2701: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2704: invokevirtual 1715	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2707: pop
    //   2708: aload_1
    //   2709: getfield 1718	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2712: invokevirtual 1719	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2715: ifeq +35 -> 2750
    //   2718: aload_1
    //   2719: getfield 1718	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2722: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2725: astore_1
    //   2726: aload_0
    //   2727: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2730: iconst_3
    //   2731: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2734: checkcast 1721	com/tencent/mobileqq/app/LBSHandler
    //   2737: astore 4
    //   2739: aload 4
    //   2741: ifnull +9 -> 2750
    //   2744: aload 4
    //   2746: aload_1
    //   2747: invokevirtual 1724	com/tencent/mobileqq/app/LBSHandler:a	(Ljava/util/List;)V
    //   2750: aconst_null
    //   2751: astore_1
    //   2752: goto -2534 -> 218
    //   2755: iconst_0
    //   2756: istore 22
    //   2758: goto -84 -> 2674
    //   2761: astore 4
    //   2763: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2766: ifeq -58 -> 2708
    //   2769: ldc_w 1711
    //   2772: iconst_2
    //   2773: new 109	java/lang/StringBuilder
    //   2776: dup
    //   2777: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2780: ldc_w 1726
    //   2783: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: aload 4
    //   2788: invokevirtual 1727	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   2791: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2797: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2800: goto -92 -> 2708
    //   2803: aload 8
    //   2805: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2808: ldc2_w 1728
    //   2811: lcmp
    //   2812: ifne +30 -> 2842
    //   2815: aload_0
    //   2816: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2819: bipush 21
    //   2821: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2824: checkcast 1731	com/tencent/mobileqq/app/RecommendTroopManagerImp
    //   2827: astore_1
    //   2828: aload_1
    //   2829: ifnull +8 -> 2837
    //   2832: aload_1
    //   2833: invokevirtual 1732	com/tencent/mobileqq/app/RecommendTroopManagerImp:a	()Z
    //   2836: pop
    //   2837: aconst_null
    //   2838: astore_1
    //   2839: goto -2621 -> 218
    //   2842: aload 8
    //   2844: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2847: ldc2_w 1733
    //   2850: lcmp
    //   2851: ifne +93 -> 2944
    //   2854: aload 8
    //   2856: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2859: ifnull +85 -> 2944
    //   2862: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2865: ifeq +13 -> 2878
    //   2868: ldc_w 458
    //   2871: iconst_2
    //   2872: ldc_w 1736
    //   2875: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2878: aload_0
    //   2879: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2882: ldc_w 1738
    //   2885: ldc -112
    //   2887: ldc -112
    //   2889: ldc_w 1740
    //   2892: ldc_w 1740
    //   2895: iconst_0
    //   2896: iconst_0
    //   2897: ldc -112
    //   2899: ldc -112
    //   2901: ldc -112
    //   2903: ldc -112
    //   2905: invokestatic 1745	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2908: new 1747	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody
    //   2911: dup
    //   2912: invokespecial 1748	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody:<init>	()V
    //   2915: pop
    //   2916: new 1750	com/tencent/av/service/QavWrapper
    //   2919: dup
    //   2920: invokestatic 1753	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2923: invokespecial 1756	com/tencent/av/service/QavWrapper:<init>	(Landroid/content/Context;)V
    //   2926: new 1758	qly
    //   2929: dup
    //   2930: aload_0
    //   2931: aload 8
    //   2933: invokespecial 1761	qly:<init>	(Lcom/tencent/mobileqq/app/message/OnLinePushMessageProcessor;LIMMsgBodyPack/MsgType0x210;)V
    //   2936: invokevirtual 1764	com/tencent/av/service/QavWrapper:a	(Lcom/tencent/av/service/QavWrapper$OnReadyListener;)V
    //   2939: aconst_null
    //   2940: astore_1
    //   2941: goto -2723 -> 218
    //   2944: aload 8
    //   2946: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2949: ldc2_w 1765
    //   2952: lcmp
    //   2953: ifne +44 -> 2997
    //   2956: aload 8
    //   2958: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2961: ifnull +36 -> 2997
    //   2964: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2967: ifeq +13 -> 2980
    //   2970: ldc_w 1768
    //   2973: iconst_2
    //   2974: ldc_w 1770
    //   2977: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2980: aload_0
    //   2981: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2984: aload 8
    //   2986: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2989: invokestatic 1773	com/tencent/mobileqq/activity/qwallet/QWalletPushManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   2992: aconst_null
    //   2993: astore_1
    //   2994: goto -2776 -> 218
    //   2997: aload 8
    //   2999: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3002: ldc2_w 1774
    //   3005: lcmp
    //   3006: ifne +44 -> 3050
    //   3009: aload 8
    //   3011: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3014: ifnull +36 -> 3050
    //   3017: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3020: ifeq +13 -> 3033
    //   3023: ldc_w 1768
    //   3026: iconst_2
    //   3027: ldc_w 1777
    //   3030: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3033: aload_0
    //   3034: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3037: aload 8
    //   3039: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3042: invokestatic 1779	com/tencent/mobileqq/activity/qwallet/QWalletPushManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3045: aconst_null
    //   3046: astore_1
    //   3047: goto -2829 -> 218
    //   3050: aload 8
    //   3052: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3055: ldc2_w 1780
    //   3058: lcmp
    //   3059: ifne +84 -> 3143
    //   3062: aload 8
    //   3064: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3067: ifnull +76 -> 3143
    //   3070: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3073: ifeq +13 -> 3086
    //   3076: ldc_w 1783
    //   3079: iconst_2
    //   3080: ldc_w 1785
    //   3083: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3086: aload_0
    //   3087: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3090: aload 8
    //   3092: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3095: invokestatic 1786	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3098: aload_1
    //   3099: getfield 883	OnlinePushPack/MsgInfo:lFromUin	J
    //   3102: lstore_2
    //   3103: aload_1
    //   3104: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3107: istore 11
    //   3109: aload_1
    //   3110: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3113: lstore 20
    //   3115: aload_1
    //   3116: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   3119: istore 12
    //   3121: aload_0
    //   3122: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3125: invokevirtual 1022	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   3128: lload_2
    //   3129: iload 11
    //   3131: lload 20
    //   3133: iload 12
    //   3135: invokestatic 1646	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3138: aconst_null
    //   3139: astore_1
    //   3140: goto -2922 -> 218
    //   3143: aload 8
    //   3145: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3148: ldc2_w 1787
    //   3151: lcmp
    //   3152: ifne +436 -> 3588
    //   3155: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3158: ifeq +13 -> 3171
    //   3161: ldc_w 1790
    //   3164: iconst_2
    //   3165: ldc_w 1785
    //   3168: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3171: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3174: ifeq +13 -> 3187
    //   3177: ldc_w 1792
    //   3180: iconst_2
    //   3181: ldc_w 1794
    //   3184: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3187: new 1796	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody
    //   3190: dup
    //   3191: invokespecial 1797	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:<init>	()V
    //   3194: astore 7
    //   3196: aload 7
    //   3198: aload 8
    //   3200: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3203: invokevirtual 1798	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3206: pop
    //   3207: aload 7
    //   3209: getfield 1801	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3212: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3215: lstore_2
    //   3216: aload_0
    //   3217: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3220: invokevirtual 889	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3223: astore 4
    //   3225: invokestatic 1806	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3228: lload_2
    //   3229: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3232: aconst_null
    //   3233: ldc_w 372
    //   3236: iconst_0
    //   3237: invokestatic 378	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   3240: ifne +329 -> 3569
    //   3243: lload_2
    //   3244: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3247: aload 4
    //   3249: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3252: istore 22
    //   3254: iload 22
    //   3256: ifeq +313 -> 3569
    //   3259: aconst_null
    //   3260: astore 4
    //   3262: aconst_null
    //   3263: astore 5
    //   3265: aconst_null
    //   3266: astore 9
    //   3268: aload 7
    //   3270: getfield 1809	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3273: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3276: ifeq +7483 -> 10759
    //   3279: new 259	java/lang/String
    //   3282: dup
    //   3283: aload 7
    //   3285: getfield 1809	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3288: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3291: invokevirtual 209	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3294: ldc_w 1062
    //   3297: invokespecial 1065	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3300: astore 6
    //   3302: aload 6
    //   3304: astore 4
    //   3306: aload 7
    //   3308: getfield 1812	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3311: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3314: ifeq +7439 -> 10753
    //   3317: new 259	java/lang/String
    //   3320: dup
    //   3321: aload 7
    //   3323: getfield 1812	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3326: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3329: invokevirtual 209	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3332: ldc_w 1062
    //   3335: invokespecial 1065	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3338: astore 6
    //   3340: aload 6
    //   3342: astore 5
    //   3344: aload 7
    //   3346: getfield 1815	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3349: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3352: ifeq +7395 -> 10747
    //   3355: new 259	java/lang/String
    //   3358: dup
    //   3359: aload 7
    //   3361: getfield 1815	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3364: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3367: invokevirtual 209	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3370: ldc_w 1062
    //   3373: invokespecial 1065	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3376: astore 6
    //   3378: aload 6
    //   3380: astore 7
    //   3382: aload 4
    //   3384: astore 6
    //   3386: aload 5
    //   3388: astore 8
    //   3390: invokestatic 1806	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3393: lload_2
    //   3394: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3397: aload 6
    //   3399: aload 7
    //   3401: aload 8
    //   3403: invokevirtual 1818	com/tencent/common/app/BaseApplicationImpl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3406: aload_0
    //   3407: sipush 8013
    //   3410: iconst_1
    //   3411: iconst_4
    //   3412: anewarray 199	java/lang/Object
    //   3415: dup
    //   3416: iconst_0
    //   3417: lload_2
    //   3418: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3421: aastore
    //   3422: dup
    //   3423: iconst_1
    //   3424: aload 6
    //   3426: aastore
    //   3427: dup
    //   3428: iconst_2
    //   3429: aload 7
    //   3431: aastore
    //   3432: dup
    //   3433: iconst_3
    //   3434: aload 8
    //   3436: aastore
    //   3437: invokevirtual 1605	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   3440: aload_1
    //   3441: getfield 883	OnlinePushPack/MsgInfo:lFromUin	J
    //   3444: lstore_2
    //   3445: aload_1
    //   3446: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3449: istore 11
    //   3451: aload_1
    //   3452: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3455: lstore 20
    //   3457: aload_1
    //   3458: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   3461: istore 12
    //   3463: aload_0
    //   3464: getfield 1214	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   3467: lload_2
    //   3468: iload 11
    //   3470: lload 20
    //   3472: iload 12
    //   3474: invokestatic 1646	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3477: aconst_null
    //   3478: astore_1
    //   3479: goto -3261 -> 218
    //   3482: astore 6
    //   3484: aload 5
    //   3486: astore 8
    //   3488: aload 9
    //   3490: astore 7
    //   3492: aload 4
    //   3494: astore 6
    //   3496: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3499: ifeq -109 -> 3390
    //   3502: ldc_w 1790
    //   3505: iconst_2
    //   3506: ldc_w 1820
    //   3509: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3512: aload 5
    //   3514: astore 8
    //   3516: aload 9
    //   3518: astore 7
    //   3520: aload 4
    //   3522: astore 6
    //   3524: goto -134 -> 3390
    //   3527: astore 4
    //   3529: aload 4
    //   3531: invokevirtual 1537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   3534: aload_0
    //   3535: sipush 8013
    //   3538: iconst_0
    //   3539: iconst_4
    //   3540: anewarray 199	java/lang/Object
    //   3543: dup
    //   3544: iconst_0
    //   3545: ldc -112
    //   3547: aastore
    //   3548: dup
    //   3549: iconst_1
    //   3550: ldc -112
    //   3552: aastore
    //   3553: dup
    //   3554: iconst_2
    //   3555: ldc -112
    //   3557: aastore
    //   3558: dup
    //   3559: iconst_3
    //   3560: ldc -112
    //   3562: aastore
    //   3563: invokevirtual 1605	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   3566: goto -126 -> 3440
    //   3569: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3572: ifeq -132 -> 3440
    //   3575: ldc_w 1790
    //   3578: iconst_2
    //   3579: ldc_w 1822
    //   3582: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3585: goto -145 -> 3440
    //   3588: ldc2_w 1823
    //   3591: aload 8
    //   3593: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3596: lcmp
    //   3597: ifne +31 -> 3628
    //   3600: aload_0
    //   3601: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3604: aload 8
    //   3606: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3609: invokestatic 1829	com/tencent/biz/TroopRedpoint/TroopRedTouchHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)Z
    //   3612: ifeq +7071 -> 10683
    //   3615: aload_0
    //   3616: bipush 105
    //   3618: iconst_1
    //   3619: aconst_null
    //   3620: invokevirtual 1605	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   3623: aconst_null
    //   3624: astore_1
    //   3625: goto -3407 -> 218
    //   3628: aload 8
    //   3630: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3633: ldc2_w 1830
    //   3636: lcmp
    //   3637: ifne +964 -> 4601
    //   3640: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3643: ifeq +13 -> 3656
    //   3646: ldc_w 1833
    //   3649: iconst_2
    //   3650: ldc_w 1785
    //   3653: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3656: new 1835	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody
    //   3659: dup
    //   3660: invokespecial 1836	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:<init>	()V
    //   3663: astore 4
    //   3665: aload 4
    //   3667: aload 8
    //   3669: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3672: invokevirtual 1837	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3675: pop
    //   3676: aload 4
    //   3678: getfield 1840	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3681: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3684: iconst_0
    //   3685: invokeinterface 1843 2 0
    //   3690: checkcast 1845	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody
    //   3693: astore 4
    //   3695: iconst_m1
    //   3696: istore 11
    //   3698: aload 4
    //   3700: getfield 1848	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3703: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3706: ifeq +13 -> 3719
    //   3709: aload 4
    //   3711: getfield 1848	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3714: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3717: istore 11
    //   3719: iload 11
    //   3721: sipush 2001
    //   3724: if_icmpne +259 -> 3983
    //   3727: aload 4
    //   3729: getfield 1852	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   3732: invokevirtual 1855	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:has	()Z
    //   3735: ifeq +248 -> 3983
    //   3738: aload 4
    //   3740: getfield 1852	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   3743: invokevirtual 1856	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3746: checkcast 1854	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike
    //   3749: astore 5
    //   3751: ldc -112
    //   3753: astore 4
    //   3755: lconst_0
    //   3756: lstore_2
    //   3757: iconst_0
    //   3758: istore 12
    //   3760: iconst_0
    //   3761: istore 11
    //   3763: aload 5
    //   3765: getfield 1859	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3768: invokevirtual 1860	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3771: ifeq +13 -> 3784
    //   3774: aload 5
    //   3776: getfield 1859	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3779: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3782: astore 4
    //   3784: aload 5
    //   3786: getfield 1863	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3789: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3792: ifeq +13 -> 3805
    //   3795: aload 5
    //   3797: getfield 1863	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3800: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3803: istore 11
    //   3805: aload 5
    //   3807: getfield 1866	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3810: invokevirtual 54	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   3813: ifeq +12 -> 3825
    //   3816: aload 5
    //   3818: getfield 1866	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3821: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3824: lstore_2
    //   3825: aload 5
    //   3827: getfield 1869	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3830: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3833: ifeq +13 -> 3846
    //   3836: aload 5
    //   3838: getfield 1869	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3841: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3844: istore 12
    //   3846: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3849: ifeq +63 -> 3912
    //   3852: ldc_w 1833
    //   3855: iconst_2
    //   3856: new 109	java/lang/StringBuilder
    //   3859: dup
    //   3860: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3863: ldc_w 1871
    //   3866: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3869: aload 4
    //   3871: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3874: ldc_w 1873
    //   3877: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3880: iload 12
    //   3882: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3885: ldc_w 1875
    //   3888: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3891: iload 11
    //   3893: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3896: ldc_w 1877
    //   3899: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3902: lload_2
    //   3903: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3906: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3909: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3912: aload_0
    //   3913: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3916: bipush 70
    //   3918: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3921: checkcast 1879	com/tencent/mobileqq/dating/DatingProxyManager
    //   3924: astore 4
    //   3926: aload 4
    //   3928: ifnull +13 -> 3941
    //   3931: aload 4
    //   3933: invokevirtual 1882	com/tencent/mobileqq/dating/DatingProxyManager:a	()Lcom/tencent/mobileqq/dating/widget/VoteEventMgr;
    //   3936: aload 5
    //   3938: invokevirtual 1887	com/tencent/mobileqq/dating/widget/VoteEventMgr:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;)V
    //   3941: aload_1
    //   3942: getfield 883	OnlinePushPack/MsgInfo:lFromUin	J
    //   3945: lstore_2
    //   3946: aload_1
    //   3947: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3950: istore 11
    //   3952: aload_1
    //   3953: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3956: lstore 20
    //   3958: aload_1
    //   3959: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   3962: istore 12
    //   3964: aload_0
    //   3965: getfield 1214	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   3968: lload_2
    //   3969: iload 11
    //   3971: lload 20
    //   3973: iload 12
    //   3975: invokestatic 1646	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3978: aconst_null
    //   3979: astore_1
    //   3980: goto -3762 -> 218
    //   3983: iload 11
    //   3985: sipush 2002
    //   3988: if_icmpne +453 -> 4441
    //   3991: aload 4
    //   3993: getfield 1891	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   3996: invokevirtual 1894	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:has	()Z
    //   3999: ifeq +442 -> 4441
    //   4002: aload 4
    //   4004: getfield 1891	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4007: invokevirtual 1895	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4010: checkcast 1893	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify
    //   4013: astore 5
    //   4015: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4018: ifeq +34 -> 4052
    //   4021: ldc_w 458
    //   4024: iconst_2
    //   4025: new 109	java/lang/StringBuilder
    //   4028: dup
    //   4029: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4032: ldc_w 1897
    //   4035: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4038: aload 5
    //   4040: invokevirtual 1898	java/lang/Object:toString	()Ljava/lang/String;
    //   4043: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4046: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4049: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4052: lconst_0
    //   4053: lstore_2
    //   4054: aload 5
    //   4056: getfield 1899	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4059: invokevirtual 54	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4062: ifeq +12 -> 4074
    //   4065: aload 5
    //   4067: getfield 1899	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4070: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4073: lstore_2
    //   4074: lload_2
    //   4075: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4078: astore 4
    //   4080: aload 5
    //   4082: getfield 1902	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4085: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4088: ifeq +6653 -> 10741
    //   4091: aload 5
    //   4093: getfield 1902	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4096: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4099: istore 11
    //   4101: aload 5
    //   4103: getfield 1905	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4106: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4109: ifeq +6626 -> 10735
    //   4112: aload 5
    //   4114: getfield 1905	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4117: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4120: istore 12
    //   4122: iconst_m1
    //   4123: istore 13
    //   4125: iconst_m1
    //   4126: istore 14
    //   4128: aload 5
    //   4130: getfield 1908	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4133: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4136: ifeq +13 -> 4149
    //   4139: aload 5
    //   4141: getfield 1908	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4144: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4147: istore 13
    //   4149: aload 5
    //   4151: getfield 1911	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4154: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4157: ifeq +13 -> 4170
    //   4160: aload 5
    //   4162: getfield 1911	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4165: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4168: istore 14
    //   4170: aload 5
    //   4172: getfield 1914	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_redpack_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4175: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4178: istore 15
    //   4180: aload 5
    //   4182: getfield 1917	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:str_redpack_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4185: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4188: astore 5
    //   4190: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4193: ifeq +6586 -> 10779
    //   4196: ldc_w 458
    //   4199: iconst_2
    //   4200: new 109	java/lang/StringBuilder
    //   4203: dup
    //   4204: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4207: ldc_w 1919
    //   4210: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4213: iload 15
    //   4215: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4218: ldc_w 1921
    //   4221: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4224: aload 5
    //   4226: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4229: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4232: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4235: goto +6544 -> 10779
    //   4238: aload_0
    //   4239: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4242: sipush 130
    //   4245: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4248: checkcast 1923	com/tencent/mobileqq/app/IndividualRedPacketManager
    //   4251: astore 6
    //   4253: aload 6
    //   4255: iload 13
    //   4257: iload 14
    //   4259: iconst_1
    //   4260: invokevirtual 1926	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(IIZ)V
    //   4263: aload 6
    //   4265: iload 15
    //   4267: aload 5
    //   4269: invokevirtual 1929	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(ILjava/lang/String;)V
    //   4272: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4275: ifeq +6517 -> 10792
    //   4278: ldc_w 458
    //   4281: iconst_2
    //   4282: new 109	java/lang/StringBuilder
    //   4285: dup
    //   4286: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4289: ldc_w 1931
    //   4292: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4295: aload 4
    //   4297: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4300: ldc_w 1933
    //   4303: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4306: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4309: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4312: goto +6480 -> 10792
    //   4315: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4318: ifeq +42 -> 4360
    //   4321: ldc_w 458
    //   4324: iconst_2
    //   4325: new 109	java/lang/StringBuilder
    //   4328: dup
    //   4329: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4332: ldc_w 1935
    //   4335: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4338: iload 11
    //   4340: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4343: ldc_w 1937
    //   4346: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4349: iload 12
    //   4351: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4354: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4357: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4360: aload_0
    //   4361: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4364: iconst_2
    //   4365: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4368: checkcast 1939	mqq/manager/TicketManager
    //   4371: aload 4
    //   4373: invokeinterface 1942 2 0
    //   4378: astore 5
    //   4380: aload_0
    //   4381: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4384: bipush 27
    //   4386: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4389: checkcast 1944	com/tencent/mobileqq/app/VipInfoHandler
    //   4392: aload 5
    //   4394: aload 4
    //   4396: invokevirtual 1946	com/tencent/mobileqq/app/VipInfoHandler:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4399: goto -458 -> 3941
    //   4402: astore_1
    //   4403: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4406: ifeq +30 -> 4436
    //   4409: ldc_w 1833
    //   4412: iconst_2
    //   4413: new 109	java/lang/StringBuilder
    //   4416: dup
    //   4417: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4420: ldc_w 1948
    //   4423: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4426: aload_1
    //   4427: invokevirtual 1951	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4430: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4433: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4436: aconst_null
    //   4437: astore_1
    //   4438: goto -4220 -> 218
    //   4441: iload 11
    //   4443: sipush 2003
    //   4446: if_icmpne -505 -> 3941
    //   4449: aload 4
    //   4451: getfield 1955	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4454: invokevirtual 1958	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:has	()Z
    //   4457: ifeq -516 -> 3941
    //   4460: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4463: ifeq +13 -> 4476
    //   4466: ldc_w 1960
    //   4469: iconst_2
    //   4470: ldc_w 1962
    //   4473: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4476: aload 4
    //   4478: getfield 1955	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4481: invokevirtual 1963	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4484: checkcast 1957	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound
    //   4487: astore 4
    //   4489: new 744	android/os/Bundle
    //   4492: dup
    //   4493: invokespecial 745	android/os/Bundle:<init>	()V
    //   4496: astore 5
    //   4498: aload 4
    //   4500: getfield 1966	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4503: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4506: ifeq +19 -> 4525
    //   4509: aload 5
    //   4511: ldc_w 1968
    //   4514: aload 4
    //   4516: getfield 1966	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4519: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4522: invokevirtual 775	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4525: aload 4
    //   4527: getfield 1971	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4530: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4533: ifeq +19 -> 4552
    //   4536: aload 5
    //   4538: ldc_w 1973
    //   4541: aload 4
    //   4543: getfield 1971	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4546: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4549: invokevirtual 775	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4552: aload 4
    //   4554: getfield 1976	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4557: invokevirtual 54	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4560: ifeq +19 -> 4579
    //   4563: aload 5
    //   4565: ldc_w 1978
    //   4568: aload 4
    //   4570: getfield 1976	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4573: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4576: invokevirtual 1982	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   4579: aload_0
    //   4580: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4583: bipush 51
    //   4585: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4588: checkcast 1984	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   4591: bipush 111
    //   4593: aload 5
    //   4595: invokevirtual 1987	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(ILandroid/os/Bundle;)V
    //   4598: goto -657 -> 3941
    //   4601: aload 8
    //   4603: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   4606: ldc2_w 1988
    //   4609: lcmp
    //   4610: ifne +187 -> 4797
    //   4613: new 1991	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody
    //   4616: dup
    //   4617: invokespecial 1992	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:<init>	()V
    //   4620: astore_1
    //   4621: aload_1
    //   4622: aload 8
    //   4624: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   4627: invokevirtual 1993	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4630: pop
    //   4631: aload_1
    //   4632: getfield 1996	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4635: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4638: istore 11
    //   4640: iload 11
    //   4642: sipush 1002
    //   4645: if_icmpne +59 -> 4704
    //   4648: aload_0
    //   4649: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4652: bipush 78
    //   4654: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4657: checkcast 1998	com/tencent/mobileqq/portal/PortalManager
    //   4660: astore 4
    //   4662: aload 4
    //   4664: ifnull +9 -> 4673
    //   4667: aload 4
    //   4669: aload_1
    //   4670: invokevirtual 2001	com/tencent/mobileqq/portal/PortalManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   4673: aconst_null
    //   4674: astore_1
    //   4675: goto -4457 -> 218
    //   4678: astore_1
    //   4679: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4682: ifeq +13 -> 4695
    //   4685: ldc_w 2003
    //   4688: iconst_2
    //   4689: ldc -112
    //   4691: aload_1
    //   4692: invokestatic 2005	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4695: new 2007	java/lang/RuntimeException
    //   4698: dup
    //   4699: aload_1
    //   4700: invokespecial 2010	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   4703: athrow
    //   4704: iload 11
    //   4706: bipush 49
    //   4708: if_icmpne +27 -> 4735
    //   4711: aload_0
    //   4712: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4715: aload_0
    //   4716: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4719: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   4722: aload_1
    //   4723: getfield 2013	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4726: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4729: invokestatic 2018	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   4732: goto -59 -> 4673
    //   4735: iload 11
    //   4737: bipush 46
    //   4739: if_icmpne +30 -> 4769
    //   4742: aload_0
    //   4743: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4746: aload_0
    //   4747: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4750: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   4753: aload_1
    //   4754: getfield 2013	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4757: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4760: ldc_w 2020
    //   4763: invokestatic 2023	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)V
    //   4766: goto -93 -> 4673
    //   4769: iload 11
    //   4771: sipush 1003
    //   4774: if_icmpne -101 -> 4673
    //   4777: aload_0
    //   4778: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4781: sipush 166
    //   4784: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4787: checkcast 2025	com/tencent/mobileqq/olympic/OlympicManager
    //   4790: aload_1
    //   4791: invokevirtual 2026	com/tencent/mobileqq/olympic/OlympicManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   4794: goto -121 -> 4673
    //   4797: aload 8
    //   4799: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   4802: ldc2_w 2027
    //   4805: lcmp
    //   4806: ifne +39 -> 4845
    //   4809: aload_0
    //   4810: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4813: bipush 35
    //   4815: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4818: checkcast 2030	com/tencent/mobileqq/redtouch/RedTouchManager
    //   4821: aload 8
    //   4823: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   4826: invokevirtual 2033	com/tencent/mobileqq/redtouch/RedTouchManager:a	([B)Z
    //   4829: ifeq +11 -> 4840
    //   4832: aload_0
    //   4833: bipush 113
    //   4835: iconst_1
    //   4836: aconst_null
    //   4837: invokevirtual 1605	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   4840: aconst_null
    //   4841: astore_1
    //   4842: goto -4624 -> 218
    //   4845: aload 8
    //   4847: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   4850: ldc2_w 2034
    //   4853: lcmp
    //   4854: ifne +28 -> 4882
    //   4857: aload_0
    //   4858: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4861: bipush 63
    //   4863: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4866: checkcast 2037	com/tencent/mobileqq/redtouch/NumRedPointManager
    //   4869: aload 8
    //   4871: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   4874: invokevirtual 2038	com/tencent/mobileqq/redtouch/NumRedPointManager:a	([B)V
    //   4877: aconst_null
    //   4878: astore_1
    //   4879: goto -4661 -> 218
    //   4882: aload 8
    //   4884: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   4887: ldc2_w 2039
    //   4890: lcmp
    //   4891: ifne +132 -> 5023
    //   4894: aload_0
    //   4895: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4898: bipush 84
    //   4900: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4903: checkcast 2042	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   4906: aload_1
    //   4907: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   4910: invokevirtual 2043	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(I)Z
    //   4913: ifeq +81 -> 4994
    //   4916: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4919: ifeq +33 -> 4952
    //   4922: ldc_w 458
    //   4925: iconst_2
    //   4926: new 109	java/lang/StringBuilder
    //   4929: dup
    //   4930: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4933: ldc_w 2045
    //   4936: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4939: aload_1
    //   4940: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   4943: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4946: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4949: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4952: aload_1
    //   4953: getfield 883	OnlinePushPack/MsgInfo:lFromUin	J
    //   4956: lstore_2
    //   4957: aload_1
    //   4958: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   4961: istore 11
    //   4963: aload_1
    //   4964: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   4967: lstore 20
    //   4969: aload_1
    //   4970: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   4973: istore 12
    //   4975: aload_0
    //   4976: getfield 1214	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   4979: lload_2
    //   4980: iload 11
    //   4982: lload 20
    //   4984: iload 12
    //   4986: invokestatic 1646	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   4989: aconst_null
    //   4990: astore_1
    //   4991: goto -4773 -> 218
    //   4994: aload_0
    //   4995: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4998: aload 8
    //   5000: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5003: invokestatic 2046	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)Z
    //   5006: ifeq -54 -> 4952
    //   5009: aload_0
    //   5010: ldc_w 2048
    //   5013: iconst_1
    //   5014: iconst_1
    //   5015: iconst_1
    //   5016: iconst_0
    //   5017: invokevirtual 1220	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(Ljava/lang/String;ZIZZ)V
    //   5020: goto -68 -> 4952
    //   5023: aload 8
    //   5025: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5028: ldc2_w 2049
    //   5031: lcmp
    //   5032: ifne +28 -> 5060
    //   5035: aload_0
    //   5036: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5039: bipush 47
    //   5041: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   5044: checkcast 2052	com/tencent/mobileqq/app/QPayHandler
    //   5047: aload 8
    //   5049: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5052: invokevirtual 2053	com/tencent/mobileqq/app/QPayHandler:a	([B)V
    //   5055: aconst_null
    //   5056: astore_1
    //   5057: goto -4839 -> 218
    //   5060: aload 8
    //   5062: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5065: ldc2_w 2054
    //   5068: lcmp
    //   5069: ifne +296 -> 5365
    //   5072: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5075: ifeq +71 -> 5146
    //   5078: new 109	java/lang/StringBuilder
    //   5081: dup
    //   5082: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5085: getstatic 2062	cooperation/qzone/util/QZoneLogTags:b	Ljava/lang/String;
    //   5088: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5091: getstatic 2064	cooperation/qzone/util/QZoneLogTags:e	Ljava/lang/String;
    //   5094: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5097: ldc_w 458
    //   5100: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5103: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5106: iconst_4
    //   5107: new 109	java/lang/StringBuilder
    //   5110: dup
    //   5111: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5114: ldc_w 2066
    //   5117: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5120: aload_1
    //   5121: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   5124: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5127: ldc_w 2068
    //   5130: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5133: aload_1
    //   5134: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   5137: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5140: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5143: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5146: new 2070	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody
    //   5149: dup
    //   5150: invokespecial 2071	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:<init>	()V
    //   5153: astore_1
    //   5154: aload_1
    //   5155: aload 8
    //   5157: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5160: invokevirtual 2072	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5163: pop
    //   5164: aload_1
    //   5165: getfield 2075	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5168: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5171: pop
    //   5172: aload_1
    //   5173: getfield 2078	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_undeal_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5176: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5179: istore 11
    //   5181: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5184: ifeq +56 -> 5240
    //   5187: new 109	java/lang/StringBuilder
    //   5190: dup
    //   5191: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5194: getstatic 2062	cooperation/qzone/util/QZoneLogTags:b	Ljava/lang/String;
    //   5197: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5200: getstatic 2064	cooperation/qzone/util/QZoneLogTags:e	Ljava/lang/String;
    //   5203: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5206: ldc_w 458
    //   5209: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5212: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5215: iconst_2
    //   5216: new 109	java/lang/StringBuilder
    //   5219: dup
    //   5220: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5223: ldc_w 2080
    //   5226: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5229: iload 11
    //   5231: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5234: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5237: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5240: ldc_w 2082
    //   5243: iconst_m1
    //   5244: aload_0
    //   5245: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5248: invokevirtual 595	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   5251: invokestatic 2087	cooperation/qzone/LocalMultiProcConfig:a	(Ljava/lang/String;IJ)I
    //   5254: istore 12
    //   5256: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5259: ifeq +53 -> 5312
    //   5262: ldc_w 458
    //   5265: iconst_2
    //   5266: new 109	java/lang/StringBuilder
    //   5269: dup
    //   5270: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5273: ldc_w 2089
    //   5276: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5279: aload_0
    //   5280: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5283: invokevirtual 595	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   5286: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5289: ldc_w 2091
    //   5292: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5295: ldc_w 2093
    //   5298: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5301: iload 12
    //   5303: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5306: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5309: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5312: iload 12
    //   5314: iconst_1
    //   5315: if_icmpne +35 -> 5350
    //   5318: aload_0
    //   5319: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5322: bipush 9
    //   5324: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5327: checkcast 2095	com/tencent/mobileqq/servlet/QZoneManagerImp
    //   5330: bipush 17
    //   5332: iload 11
    //   5334: i2l
    //   5335: aload_0
    //   5336: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5339: invokevirtual 595	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   5342: ldc -112
    //   5344: iconst_0
    //   5345: iconst_1
    //   5346: invokevirtual 2098	com/tencent/mobileqq/servlet/QZoneManagerImp:a	(IJJLjava/lang/String;ZZ)Z
    //   5349: pop
    //   5350: aconst_null
    //   5351: astore_1
    //   5352: goto -5134 -> 218
    //   5355: astore_1
    //   5356: aload_1
    //   5357: invokevirtual 1537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   5360: aconst_null
    //   5361: astore_1
    //   5362: goto -5144 -> 218
    //   5365: aload 8
    //   5367: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5370: ldc2_w 2099
    //   5373: lcmp
    //   5374: ifne +112 -> 5486
    //   5377: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5380: ifeq +46 -> 5426
    //   5383: ldc_w 458
    //   5386: iconst_4
    //   5387: new 109	java/lang/StringBuilder
    //   5390: dup
    //   5391: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5394: ldc_w 2102
    //   5397: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5400: aload_1
    //   5401: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   5404: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5407: ldc_w 2068
    //   5410: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5413: aload_1
    //   5414: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   5417: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5420: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5423: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5426: new 2104	tencent/im/s2c/msgtype0x210/submsgtype0x7a/submsgtype0x7a$MsgBody
    //   5429: dup
    //   5430: invokespecial 2105	tencent/im/s2c/msgtype0x210/submsgtype0x7a/submsgtype0x7a$MsgBody:<init>	()V
    //   5433: astore_1
    //   5434: aload_1
    //   5435: aload 8
    //   5437: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5440: invokevirtual 2106	tencent/im/s2c/msgtype0x210/submsgtype0x7a/submsgtype0x7a$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5443: pop
    //   5444: aload_0
    //   5445: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5448: bipush 61
    //   5450: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   5453: checkcast 2108	com/tencent/arrange/op/ArrangeHandler
    //   5456: aload_1
    //   5457: invokevirtual 2111	com/tencent/arrange/op/ArrangeHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x7a/submsgtype0x7a$MsgBody;)V
    //   5460: aconst_null
    //   5461: astore_1
    //   5462: goto -5244 -> 218
    //   5465: astore_1
    //   5466: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5469: ifeq -9 -> 5460
    //   5472: ldc_w 458
    //   5475: iconst_2
    //   5476: ldc_w 2113
    //   5479: aload_1
    //   5480: invokestatic 1395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5483: goto -23 -> 5460
    //   5486: aload 8
    //   5488: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5491: ldc2_w 2114
    //   5494: lcmp
    //   5495: ifne +138 -> 5633
    //   5498: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5501: ifeq +46 -> 5547
    //   5504: ldc_w 458
    //   5507: iconst_4
    //   5508: new 109	java/lang/StringBuilder
    //   5511: dup
    //   5512: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5515: ldc_w 2117
    //   5518: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5521: aload_1
    //   5522: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   5525: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5528: ldc_w 2068
    //   5531: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5534: aload_1
    //   5535: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   5538: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5541: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5544: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5547: new 2119	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody
    //   5550: dup
    //   5551: invokespecial 2120	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:<init>	()V
    //   5554: astore_1
    //   5555: aload_1
    //   5556: aload 8
    //   5558: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5561: invokevirtual 2121	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5564: pop
    //   5565: aload_1
    //   5566: getfield 2122	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5569: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5572: lstore_2
    //   5573: aload_0
    //   5574: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5577: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   5580: lload_2
    //   5581: invokestatic 433	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5584: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5587: ifeq +20 -> 5607
    //   5590: aload_0
    //   5591: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5594: bipush 93
    //   5596: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5599: checkcast 2124	com/tencent/mobileqq/secspy/SecSpyFileManager
    //   5602: aload_1
    //   5603: iconst_3
    //   5604: invokevirtual 2127	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;I)V
    //   5607: aconst_null
    //   5608: astore_1
    //   5609: goto -5391 -> 218
    //   5612: astore_1
    //   5613: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5616: ifeq -9 -> 5607
    //   5619: ldc_w 458
    //   5622: iconst_2
    //   5623: ldc_w 2129
    //   5626: aload_1
    //   5627: invokestatic 1395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5630: goto -23 -> 5607
    //   5633: aload 8
    //   5635: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5638: ldc2_w 2130
    //   5641: lcmp
    //   5642: ifne +170 -> 5812
    //   5645: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5648: ifeq +46 -> 5694
    //   5651: ldc_w 458
    //   5654: iconst_4
    //   5655: new 109	java/lang/StringBuilder
    //   5658: dup
    //   5659: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5662: ldc_w 2133
    //   5665: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5668: aload_1
    //   5669: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   5672: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5675: ldc_w 2068
    //   5678: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5681: aload_1
    //   5682: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   5685: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5688: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5691: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5694: new 2135	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody
    //   5697: dup
    //   5698: invokespecial 2136	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:<init>	()V
    //   5701: astore_1
    //   5702: aload_1
    //   5703: aload 8
    //   5705: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5708: invokevirtual 2137	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5711: pop
    //   5712: aload_1
    //   5713: ifnull +67 -> 5780
    //   5716: aload_1
    //   5717: getfield 2140	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:uint32_notify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5720: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5723: iconst_1
    //   5724: if_icmpne +61 -> 5785
    //   5727: iconst_1
    //   5728: istore 22
    //   5730: iload 22
    //   5732: iconst_1
    //   5733: if_icmpne +47 -> 5780
    //   5736: new 259	java/lang/String
    //   5739: dup
    //   5740: aload_1
    //   5741: getfield 2143	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:bytes_notify_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5744: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5747: invokevirtual 209	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5750: ldc_w 1062
    //   5753: invokespecial 1065	java/lang/String:<init>	([BLjava/lang/String;)V
    //   5756: astore_1
    //   5757: aload_0
    //   5758: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5761: iload 22
    //   5763: aload_1
    //   5764: invokestatic 2148	com/tencent/mobileqq/qcall/QCallFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ZLjava/lang/String;)V
    //   5767: aload_0
    //   5768: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5771: invokevirtual 2151	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   5774: iload 22
    //   5776: aload_1
    //   5777: invokevirtual 2156	com/tencent/av/gaudio/AVNotifyCenter:a	(ZLjava/lang/String;)V
    //   5780: aconst_null
    //   5781: astore_1
    //   5782: goto -5564 -> 218
    //   5785: iconst_0
    //   5786: istore 22
    //   5788: goto -58 -> 5730
    //   5791: astore_1
    //   5792: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5795: ifeq -15 -> 5780
    //   5798: ldc_w 458
    //   5801: iconst_2
    //   5802: ldc_w 2158
    //   5805: aload_1
    //   5806: invokestatic 1395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5809: goto -29 -> 5780
    //   5812: aload 8
    //   5814: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5817: ldc2_w 2159
    //   5820: lcmp
    //   5821: ifne +263 -> 6084
    //   5824: new 2162	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody
    //   5827: dup
    //   5828: invokespecial 2163	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:<init>	()V
    //   5831: astore 4
    //   5833: sipush 63507
    //   5836: invokestatic 960	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5839: checkcast 2165	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   5842: astore 5
    //   5844: aload 4
    //   5846: aload 8
    //   5848: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5851: invokevirtual 2166	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5854: pop
    //   5855: aload 5
    //   5857: new 109	java/lang/StringBuilder
    //   5860: dup
    //   5861: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5864: aload 4
    //   5866: getfield 2169	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5869: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5872: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5875: ldc -112
    //   5877: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5880: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5883: putfield 2172	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   5886: aload 5
    //   5888: new 109	java/lang/StringBuilder
    //   5891: dup
    //   5892: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5895: aload 4
    //   5897: getfield 2175	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5900: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5903: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5906: ldc -112
    //   5908: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5911: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5914: putfield 2178	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   5917: aload 5
    //   5919: aload 4
    //   5921: getfield 2181	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5924: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5927: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5930: putfield 2184	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   5933: aload 5
    //   5935: aload 4
    //   5937: getfield 2187	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5940: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5943: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5946: putfield 2190	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   5949: aload 5
    //   5951: aload 4
    //   5953: getfield 2193	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5956: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5959: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5962: putfield 2196	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   5965: aload_0
    //   5966: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5969: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   5972: astore 6
    //   5974: aload_0
    //   5975: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5978: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   5981: aload 5
    //   5983: getfield 2172	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   5986: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5989: ifeq +85 -> 6074
    //   5992: aload 5
    //   5994: getfield 2178	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   5997: astore 4
    //   5999: aload 5
    //   6001: aload 6
    //   6003: aload 4
    //   6005: ldc -112
    //   6007: ldc_w 2198
    //   6010: aload_1
    //   6011: invokevirtual 2201	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   6014: sipush 63507
    //   6017: iconst_0
    //   6018: aload_1
    //   6019: invokevirtual 2204	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   6022: i2l
    //   6023: invokevirtual 2205	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   6026: aload 5
    //   6028: iconst_1
    //   6029: putfield 2206	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   6032: aload 5
    //   6034: aload_1
    //   6035: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6038: i2l
    //   6039: putfield 2207	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   6042: aload 5
    //   6044: aload_1
    //   6045: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   6048: putfield 2208	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   6051: aload 5
    //   6053: invokevirtual 2211	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   6056: pop
    //   6057: aload 5
    //   6059: astore_1
    //   6060: goto -5842 -> 218
    //   6063: astore_1
    //   6064: aload_1
    //   6065: invokevirtual 1040	java/lang/Exception:printStackTrace	()V
    //   6068: aload 5
    //   6070: astore_1
    //   6071: goto -5853 -> 218
    //   6074: aload 5
    //   6076: getfield 2172	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   6079: astore 4
    //   6081: goto -82 -> 5999
    //   6084: aload 8
    //   6086: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6089: ldc2_w 2212
    //   6092: lcmp
    //   6093: ifne +359 -> 6452
    //   6096: new 2215	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody
    //   6099: dup
    //   6100: invokespecial 2216	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:<init>	()V
    //   6103: astore 7
    //   6105: sipush 63507
    //   6108: invokestatic 960	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6111: checkcast 2165	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   6114: astore 6
    //   6116: aload 7
    //   6118: aload 8
    //   6120: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6123: invokevirtual 2217	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6126: pop
    //   6127: iconst_0
    //   6128: istore 12
    //   6130: ldc -112
    //   6132: astore 5
    //   6134: aload 5
    //   6136: astore 4
    //   6138: iload 12
    //   6140: istore 11
    //   6142: aload 7
    //   6144: getfield 2221	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:sint32_sessiontype	Lcom/tencent/mobileqq/pb/PBSInt32Field;
    //   6147: invokevirtual 2224	com/tencent/mobileqq/pb/PBSInt32Field:get	()I
    //   6150: tableswitch	default:+4655->10805, 3:+250->6400, 4:+271->6421, 5:+30->6180, 6:+4666->10816
    //   6180: aload 6
    //   6182: new 109	java/lang/StringBuilder
    //   6185: dup
    //   6186: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6189: aload 7
    //   6191: getfield 2225	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6194: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6197: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6200: ldc -112
    //   6202: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6205: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6208: putfield 2172	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   6211: aload 6
    //   6213: new 109	java/lang/StringBuilder
    //   6216: dup
    //   6217: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6220: aload 7
    //   6222: getfield 2226	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6225: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6228: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6231: ldc -112
    //   6233: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6236: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6239: putfield 2178	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   6242: aload 6
    //   6244: aload 7
    //   6246: getfield 2227	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6249: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6252: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6255: putfield 2184	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   6258: aload 6
    //   6260: aload 7
    //   6262: getfield 2228	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6265: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6268: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6271: putfield 2190	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   6274: aload 6
    //   6276: aload 7
    //   6278: getfield 2229	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6281: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6284: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6287: putfield 2196	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   6290: aload_0
    //   6291: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6294: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   6297: astore 7
    //   6299: aload_0
    //   6300: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6303: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   6306: aload 6
    //   6308: getfield 2172	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   6311: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6314: ifeq +128 -> 6442
    //   6317: aload 6
    //   6319: getfield 2178	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   6322: astore 5
    //   6324: aload 6
    //   6326: aload 7
    //   6328: aload 5
    //   6330: aload 4
    //   6332: ldc_w 2198
    //   6335: aload_1
    //   6336: invokevirtual 2201	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   6339: sipush 63507
    //   6342: iload 11
    //   6344: aload_1
    //   6345: invokevirtual 2204	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   6348: i2l
    //   6349: invokevirtual 2205	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   6352: aload 6
    //   6354: iconst_1
    //   6355: putfield 2206	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   6358: aload 6
    //   6360: aload_1
    //   6361: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6364: i2l
    //   6365: putfield 2207	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   6368: aload 6
    //   6370: aload_1
    //   6371: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   6374: putfield 2208	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   6377: aload 6
    //   6379: invokevirtual 2211	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   6382: pop
    //   6383: aload 6
    //   6385: astore_1
    //   6386: goto -6168 -> 218
    //   6389: astore_1
    //   6390: aload_1
    //   6391: invokevirtual 1040	java/lang/Exception:printStackTrace	()V
    //   6394: aload 6
    //   6396: astore_1
    //   6397: goto -6179 -> 218
    //   6400: sipush 1000
    //   6403: istore 11
    //   6405: aload 7
    //   6407: getfield 2232	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6410: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6413: invokestatic 433	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6416: astore 4
    //   6418: goto -238 -> 6180
    //   6421: sipush 1004
    //   6424: istore 11
    //   6426: aload 7
    //   6428: getfield 2232	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6431: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6434: invokestatic 433	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6437: astore 4
    //   6439: goto -259 -> 6180
    //   6442: aload 6
    //   6444: getfield 2172	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   6447: astore 5
    //   6449: goto -125 -> 6324
    //   6452: aload 8
    //   6454: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6457: ldc2_w 2233
    //   6460: lcmp
    //   6461: ifne +306 -> 6767
    //   6464: aload_0
    //   6465: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6468: bipush 50
    //   6470: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6473: checkcast 146	com/tencent/mobileqq/app/FriendsManager
    //   6476: astore 10
    //   6478: new 2236	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody
    //   6481: dup
    //   6482: invokespecial 2237	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:<init>	()V
    //   6485: astore 9
    //   6487: sipush 63507
    //   6490: invokestatic 960	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6493: checkcast 2165	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   6496: astore 5
    //   6498: aload 9
    //   6500: aload 8
    //   6502: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6505: invokevirtual 2238	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6508: pop
    //   6509: new 109	java/lang/StringBuilder
    //   6512: dup
    //   6513: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6516: aload 9
    //   6518: getfield 2239	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6521: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6524: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6527: ldc -112
    //   6529: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6532: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6535: astore 6
    //   6537: new 109	java/lang/StringBuilder
    //   6540: dup
    //   6541: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6544: aload 9
    //   6546: getfield 2240	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6549: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6552: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6555: ldc -112
    //   6557: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6560: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6563: astore 7
    //   6565: aload_0
    //   6566: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6569: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   6572: aload 6
    //   6574: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6577: ifeq +175 -> 6752
    //   6580: aload 7
    //   6582: astore 4
    //   6584: aload 10
    //   6586: aload 4
    //   6588: invokevirtual 245	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   6591: astore 8
    //   6593: aload 8
    //   6595: ifnull +164 -> 6759
    //   6598: aload 8
    //   6600: invokevirtual 1107	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   6603: ifeq +156 -> 6759
    //   6606: iconst_0
    //   6607: istore 11
    //   6609: aload 5
    //   6611: aload 6
    //   6613: putfield 2172	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   6616: aload 5
    //   6618: aload 7
    //   6620: putfield 2178	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   6623: aload 5
    //   6625: aload 9
    //   6627: getfield 2241	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6630: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6633: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6636: putfield 2184	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   6639: aload 5
    //   6641: aload 9
    //   6643: getfield 2242	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6646: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6649: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6652: putfield 2190	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   6655: aload 5
    //   6657: aload 9
    //   6659: getfield 2243	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6662: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6665: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6668: putfield 2196	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   6671: aload 5
    //   6673: aload_0
    //   6674: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6677: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   6680: aload 4
    //   6682: ldc -112
    //   6684: ldc_w 2198
    //   6687: aload_1
    //   6688: invokevirtual 2201	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   6691: sipush 63507
    //   6694: iload 11
    //   6696: aload_1
    //   6697: invokevirtual 2204	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   6700: i2l
    //   6701: invokevirtual 2205	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   6704: aload 5
    //   6706: iconst_1
    //   6707: putfield 2206	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   6710: aload 5
    //   6712: aload_1
    //   6713: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6716: i2l
    //   6717: putfield 2207	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   6720: aload 5
    //   6722: aload_1
    //   6723: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   6726: putfield 2208	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   6729: aload 5
    //   6731: invokevirtual 2211	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   6734: pop
    //   6735: aload 5
    //   6737: astore_1
    //   6738: goto -6520 -> 218
    //   6741: astore_1
    //   6742: aload_1
    //   6743: invokevirtual 1040	java/lang/Exception:printStackTrace	()V
    //   6746: aload 5
    //   6748: astore_1
    //   6749: goto -6531 -> 218
    //   6752: aload 6
    //   6754: astore 4
    //   6756: goto -172 -> 6584
    //   6759: sipush 1001
    //   6762: istore 11
    //   6764: goto -155 -> 6609
    //   6767: aload 8
    //   6769: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6772: ldc2_w 2244
    //   6775: lcmp
    //   6776: ifne +65 -> 6841
    //   6779: aload_0
    //   6780: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6783: bipush 62
    //   6785: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   6788: checkcast 2247	com/tencent/mobileqq/app/readinjoy/ReadInJoyHandler
    //   6791: aload 8
    //   6793: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6796: invokevirtual 2248	com/tencent/mobileqq/app/readinjoy/ReadInJoyHandler:a	([B)V
    //   6799: aload_1
    //   6800: getfield 883	OnlinePushPack/MsgInfo:lFromUin	J
    //   6803: lstore_2
    //   6804: aload_1
    //   6805: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6808: istore 11
    //   6810: aload_1
    //   6811: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   6814: lstore 20
    //   6816: aload_1
    //   6817: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   6820: istore 12
    //   6822: aload_0
    //   6823: getfield 1214	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   6826: lload_2
    //   6827: iload 11
    //   6829: lload 20
    //   6831: iload 12
    //   6833: invokestatic 1646	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   6836: aconst_null
    //   6837: astore_1
    //   6838: goto -6620 -> 218
    //   6841: aload 8
    //   6843: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6846: ldc2_w 2249
    //   6849: lcmp
    //   6850: ifne +99 -> 6949
    //   6853: new 2252	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody
    //   6856: dup
    //   6857: invokespecial 2253	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:<init>	()V
    //   6860: astore_1
    //   6861: aload_1
    //   6862: aload 8
    //   6864: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6867: invokevirtual 2254	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6870: pop
    //   6871: aload_1
    //   6872: getfield 2257	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6875: invokevirtual 54	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   6878: ifeq +34 -> 6912
    //   6881: aload_1
    //   6882: getfield 2257	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6885: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6888: lconst_1
    //   6889: lcmp
    //   6890: ifne +53 -> 6943
    //   6893: iconst_1
    //   6894: istore 11
    //   6896: iload 11
    //   6898: ifeq +14 -> 6912
    //   6901: aload_0
    //   6902: getfield 1214	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   6905: invokevirtual 1143	com/tencent/mobileqq/app/MessageHandler:a	()Lcom/tencent/mobileqq/app/message/SystemMessageProcessor;
    //   6908: iconst_2
    //   6909: invokevirtual 1146	com/tencent/mobileqq/app/message/SystemMessageProcessor:a	(I)V
    //   6912: aconst_null
    //   6913: astore_1
    //   6914: goto -6696 -> 218
    //   6917: astore_1
    //   6918: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6921: ifeq +13 -> 6934
    //   6924: ldc_w 2003
    //   6927: iconst_2
    //   6928: ldc -112
    //   6930: aload_1
    //   6931: invokestatic 2005	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6934: new 2007	java/lang/RuntimeException
    //   6937: dup
    //   6938: aload_1
    //   6939: invokespecial 2010	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   6942: athrow
    //   6943: iconst_0
    //   6944: istore 11
    //   6946: goto -50 -> 6896
    //   6949: aload 8
    //   6951: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6954: ldc2_w 2258
    //   6957: lcmp
    //   6958: ifeq +15 -> 6973
    //   6961: aload 8
    //   6963: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6966: ldc2_w 2260
    //   6969: lcmp
    //   6970: ifne +72 -> 7042
    //   6973: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6976: ifeq +13 -> 6989
    //   6979: ldc_w 2263
    //   6982: iconst_2
    //   6983: ldc_w 2265
    //   6986: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6989: new 2267	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody
    //   6992: dup
    //   6993: invokespecial 2268	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:<init>	()V
    //   6996: astore_1
    //   6997: aload_1
    //   6998: aload 8
    //   7000: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7003: invokevirtual 2269	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7006: pop
    //   7007: aload_0
    //   7008: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7011: aload_1
    //   7012: lconst_0
    //   7013: iconst_0
    //   7014: invokestatic 2272	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody;JZ)V
    //   7017: aconst_null
    //   7018: astore_1
    //   7019: goto -6801 -> 218
    //   7022: astore_1
    //   7023: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7026: ifeq -9 -> 7017
    //   7029: ldc_w 2263
    //   7032: iconst_2
    //   7033: ldc_w 2274
    //   7036: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7039: goto -22 -> 7017
    //   7042: aload 8
    //   7044: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7047: ldc2_w 2275
    //   7050: lcmp
    //   7051: ifne +28 -> 7079
    //   7054: aload_0
    //   7055: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7058: bipush 51
    //   7060: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   7063: checkcast 1984	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   7066: aload 8
    //   7068: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7071: invokevirtual 2277	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	([B)V
    //   7074: aconst_null
    //   7075: astore_1
    //   7076: goto -6858 -> 218
    //   7079: aload 8
    //   7081: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7084: ldc2_w 2278
    //   7087: lcmp
    //   7088: ifne +30 -> 7118
    //   7091: iconst_2
    //   7092: invokestatic 2285	com/tencent/mqp/app/sec/d:x	()[Ljava/lang/Object;
    //   7095: aload 8
    //   7097: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7100: invokestatic 2289	com/tencent/mqp/app/sec/d:e1	(I[Ljava/lang/Object;[B)V
    //   7103: aconst_null
    //   7104: astore_1
    //   7105: goto -6887 -> 218
    //   7108: astore_1
    //   7109: aload_1
    //   7110: invokevirtual 2290	java/lang/Throwable:printStackTrace	()V
    //   7113: aconst_null
    //   7114: astore_1
    //   7115: goto -6897 -> 218
    //   7118: aload 8
    //   7120: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7123: ldc2_w 2291
    //   7126: lcmp
    //   7127: ifne +111 -> 7238
    //   7130: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7133: ifeq +13 -> 7146
    //   7136: ldc_w 458
    //   7139: iconst_4
    //   7140: ldc_w 2294
    //   7143: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7146: new 2296	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody
    //   7149: dup
    //   7150: invokespecial 2297	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:<init>	()V
    //   7153: astore_1
    //   7154: aload_1
    //   7155: aload 8
    //   7157: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7160: invokevirtual 2298	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7163: pop
    //   7164: new 388	android/content/Intent
    //   7167: dup
    //   7168: ldc_w 2300
    //   7171: invokespecial 392	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   7174: astore 4
    //   7176: aload 4
    //   7178: ldc_w 2302
    //   7181: invokevirtual 2305	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   7184: pop
    //   7185: aload 4
    //   7187: ldc_w 2307
    //   7190: aload_1
    //   7191: getfield 2310	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:string_push_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   7194: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   7197: invokevirtual 403	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7200: pop
    //   7201: aload_0
    //   7202: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7205: invokevirtual 406	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7208: aload 4
    //   7210: invokevirtual 412	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   7213: aconst_null
    //   7214: astore_1
    //   7215: goto -6997 -> 218
    //   7218: astore_1
    //   7219: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7222: ifeq -9 -> 7213
    //   7225: ldc_w 458
    //   7228: iconst_4
    //   7229: ldc_w 2312
    //   7232: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7235: goto -22 -> 7213
    //   7238: aload 8
    //   7240: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7243: ldc2_w 2313
    //   7246: lcmp
    //   7247: ifne +1237 -> 8484
    //   7250: new 2316	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody
    //   7253: dup
    //   7254: invokespecial 2317	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:<init>	()V
    //   7257: astore 4
    //   7259: aload 4
    //   7261: aload 8
    //   7263: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7266: invokevirtual 2318	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7269: pop
    //   7270: aload 4
    //   7272: getfield 2321	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   7275: invokevirtual 1860	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   7278: ifeq +775 -> 8053
    //   7281: aload 4
    //   7283: getfield 2321	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   7286: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   7289: invokevirtual 2324	java/lang/String:trim	()Ljava/lang/String;
    //   7292: astore_1
    //   7293: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7296: ifeq +30 -> 7326
    //   7299: ldc_w 2326
    //   7302: iconst_2
    //   7303: new 109	java/lang/StringBuilder
    //   7306: dup
    //   7307: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   7310: ldc_w 2328
    //   7313: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7316: aload_1
    //   7317: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7320: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7323: invokestatic 696	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7326: aload 4
    //   7328: getfield 2331	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7331: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7334: iconst_1
    //   7335: if_icmpne +724 -> 8059
    //   7338: iconst_1
    //   7339: istore 25
    //   7341: aload 4
    //   7343: getfield 2334	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_folder_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7346: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7349: iconst_1
    //   7350: if_icmpne +715 -> 8065
    //   7353: iconst_1
    //   7354: istore 26
    //   7356: aload 4
    //   7358: getfield 2337	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7361: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7364: iconst_1
    //   7365: if_icmpne +706 -> 8071
    //   7368: iconst_1
    //   7369: istore 23
    //   7371: aload 4
    //   7373: getfield 2340	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7376: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7379: iconst_1
    //   7380: if_icmpne +697 -> 8077
    //   7383: iconst_1
    //   7384: istore 22
    //   7386: aload 4
    //   7388: getfield 2343	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7391: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7394: iconst_1
    //   7395: if_icmpne +688 -> 8083
    //   7398: iconst_1
    //   7399: istore 24
    //   7401: aload 4
    //   7403: getfield 2346	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_start_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7406: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7409: istore 13
    //   7411: aload 4
    //   7413: getfield 2349	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_end_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7416: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7419: istore 14
    //   7421: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   7424: ldc2_w 2350
    //   7427: ldiv
    //   7428: l2i
    //   7429: istore 15
    //   7431: aload 4
    //   7433: getfield 2354	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_period_of_validity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7436: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7439: istore 12
    //   7441: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7444: ifeq +108 -> 7552
    //   7447: ldc_w 2326
    //   7450: iconst_2
    //   7451: new 109	java/lang/StringBuilder
    //   7454: dup
    //   7455: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   7458: ldc_w 2356
    //   7461: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7464: iload 13
    //   7466: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7469: ldc_w 2358
    //   7472: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7475: iload 14
    //   7477: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7480: ldc_w 2360
    //   7483: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7486: iload 12
    //   7488: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7491: ldc_w 2362
    //   7494: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7497: iload 26
    //   7499: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7502: ldc_w 2364
    //   7505: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7508: iload 25
    //   7510: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7513: ldc_w 2364
    //   7516: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7519: iload 23
    //   7521: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7524: ldc_w 2364
    //   7527: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7530: iload 22
    //   7532: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7535: ldc_w 2364
    //   7538: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7541: iload 24
    //   7543: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7546: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7549: invokestatic 696	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7552: iload 15
    //   7554: iload 13
    //   7556: if_icmplt -7527 -> 29
    //   7559: iload 15
    //   7561: iload 14
    //   7563: if_icmpgt -7534 -> 29
    //   7566: iload 12
    //   7568: istore 11
    //   7570: iload 12
    //   7572: ldc_w 2365
    //   7575: if_icmple +8 -> 7583
    //   7578: ldc_w 2365
    //   7581: istore 11
    //   7583: iload 25
    //   7585: ifne +18 -> 7603
    //   7588: iload 23
    //   7590: ifne +13 -> 7603
    //   7593: iload 22
    //   7595: ifne +8 -> 7603
    //   7598: iload 24
    //   7600: ifeq +3132 -> 10732
    //   7603: iconst_1
    //   7604: istore 26
    //   7606: iload 26
    //   7608: ifne +3105 -> 10713
    //   7611: iload 25
    //   7613: ifne +15 -> 7628
    //   7616: aload 4
    //   7618: getfield 2368	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7621: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7624: iconst_1
    //   7625: if_icmpne +464 -> 8089
    //   7628: iconst_1
    //   7629: istore 25
    //   7631: iload 23
    //   7633: ifne +15 -> 7648
    //   7636: aload 4
    //   7638: getfield 2371	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7641: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7644: iconst_1
    //   7645: if_icmpne +450 -> 8095
    //   7648: iconst_1
    //   7649: istore 23
    //   7651: iload 22
    //   7653: ifne +15 -> 7668
    //   7656: aload 4
    //   7658: getfield 2374	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7661: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7664: iconst_1
    //   7665: if_icmpne +436 -> 8101
    //   7668: iconst_1
    //   7669: istore 22
    //   7671: iload 24
    //   7673: ifne +15 -> 7688
    //   7676: aload 4
    //   7678: getfield 2377	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7681: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7684: iconst_1
    //   7685: if_icmpne +422 -> 8107
    //   7688: iconst_1
    //   7689: istore 24
    //   7691: iload 24
    //   7693: istore 27
    //   7695: iload 25
    //   7697: istore 28
    //   7699: iload 23
    //   7701: istore 29
    //   7703: iload 22
    //   7705: istore 30
    //   7707: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7710: ifeq +80 -> 7790
    //   7713: ldc_w 2326
    //   7716: iconst_2
    //   7717: new 109	java/lang/StringBuilder
    //   7720: dup
    //   7721: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   7724: ldc_w 2379
    //   7727: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7730: iload 25
    //   7732: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7735: ldc_w 2364
    //   7738: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7741: iload 23
    //   7743: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7746: ldc_w 2364
    //   7749: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7752: iload 22
    //   7754: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7757: ldc_w 2364
    //   7760: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7763: iload 24
    //   7765: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7768: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7771: invokestatic 696	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7774: iload 22
    //   7776: istore 30
    //   7778: iload 23
    //   7780: istore 29
    //   7782: iload 25
    //   7784: istore 28
    //   7786: iload 24
    //   7788: istore 27
    //   7790: aload_0
    //   7791: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7794: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   7797: astore 5
    //   7799: aload 5
    //   7801: astore 4
    //   7803: aload 5
    //   7805: invokestatic 629	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7808: ifeq +8 -> 7816
    //   7811: ldc_w 2381
    //   7814: astore 4
    //   7816: aload_0
    //   7817: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7820: invokevirtual 406	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7823: new 109	java/lang/StringBuilder
    //   7826: dup
    //   7827: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   7830: ldc_w 2383
    //   7833: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7836: aload 4
    //   7838: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7841: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7844: iconst_0
    //   7845: invokevirtual 2384	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7848: astore 4
    //   7850: aload 4
    //   7852: invokeinterface 350 1 0
    //   7857: astore 5
    //   7859: aload 4
    //   7861: ldc_w 2386
    //   7864: iconst_0
    //   7865: invokeinterface 2390 3 0
    //   7870: ifne +59 -> 7929
    //   7873: aload 4
    //   7875: ldc_w 2392
    //   7878: iconst_0
    //   7879: invokeinterface 2390 3 0
    //   7884: ifne +45 -> 7929
    //   7887: aload 4
    //   7889: ldc_w 2394
    //   7892: iconst_0
    //   7893: invokeinterface 2390 3 0
    //   7898: ifne +31 -> 7929
    //   7901: aload 4
    //   7903: ldc_w 2396
    //   7906: iconst_0
    //   7907: invokeinterface 2390 3 0
    //   7912: ifne +17 -> 7929
    //   7915: aload 4
    //   7917: ldc_w 2398
    //   7920: iconst_0
    //   7921: invokeinterface 2390 3 0
    //   7926: ifeq +263 -> 8189
    //   7929: aload 4
    //   7931: ldc_w 2400
    //   7934: iconst_0
    //   7935: invokeinterface 365 3 0
    //   7940: istore 12
    //   7942: aload 4
    //   7944: ldc_w 2402
    //   7947: iconst_0
    //   7948: invokeinterface 365 3 0
    //   7953: istore 16
    //   7955: aload 4
    //   7957: ldc_w 2404
    //   7960: iconst_0
    //   7961: invokeinterface 365 3 0
    //   7966: istore 17
    //   7968: aload 4
    //   7970: ldc_w 2406
    //   7973: iconst_0
    //   7974: invokeinterface 365 3 0
    //   7979: istore 18
    //   7981: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   7984: ldc2_w 2350
    //   7987: ldiv
    //   7988: l2i
    //   7989: istore 19
    //   7991: iload 19
    //   7993: ifeq +196 -> 8189
    //   7996: iload 16
    //   7998: ifeq +191 -> 8189
    //   8001: iload 17
    //   8003: ifeq +186 -> 8189
    //   8006: iload 18
    //   8008: ifeq +181 -> 8189
    //   8011: iload 19
    //   8013: iload 16
    //   8015: if_icmplt +98 -> 8113
    //   8018: iload 19
    //   8020: iload 17
    //   8022: if_icmpgt +91 -> 8113
    //   8025: iload 19
    //   8027: iload 12
    //   8029: isub
    //   8030: iload 18
    //   8032: if_icmpge +81 -> 8113
    //   8035: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8038: ifeq -8009 -> 29
    //   8041: ldc_w 2326
    //   8044: iconst_2
    //   8045: ldc_w 2408
    //   8048: invokestatic 696	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8051: aconst_null
    //   8052: areturn
    //   8053: ldc -112
    //   8055: astore_1
    //   8056: goto -763 -> 7293
    //   8059: iconst_0
    //   8060: istore 25
    //   8062: goto -721 -> 7341
    //   8065: iconst_0
    //   8066: istore 26
    //   8068: goto -712 -> 7356
    //   8071: iconst_0
    //   8072: istore 23
    //   8074: goto -703 -> 7371
    //   8077: iconst_0
    //   8078: istore 22
    //   8080: goto -694 -> 7386
    //   8083: iconst_0
    //   8084: istore 24
    //   8086: goto -685 -> 7401
    //   8089: iconst_0
    //   8090: istore 25
    //   8092: goto -461 -> 7631
    //   8095: iconst_0
    //   8096: istore 23
    //   8098: goto -447 -> 7651
    //   8101: iconst_0
    //   8102: istore 22
    //   8104: goto -433 -> 7671
    //   8107: iconst_0
    //   8108: istore 24
    //   8110: goto -419 -> 7691
    //   8113: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8116: ifeq +13 -> 8129
    //   8119: ldc_w 2326
    //   8122: iconst_2
    //   8123: ldc_w 2410
    //   8126: invokestatic 696	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8129: aload 5
    //   8131: ldc_w 2386
    //   8134: iconst_0
    //   8135: invokeinterface 623 3 0
    //   8140: pop
    //   8141: aload 5
    //   8143: ldc_w 2392
    //   8146: iconst_0
    //   8147: invokeinterface 623 3 0
    //   8152: pop
    //   8153: aload 5
    //   8155: ldc_w 2394
    //   8158: iconst_0
    //   8159: invokeinterface 623 3 0
    //   8164: pop
    //   8165: aload 5
    //   8167: ldc_w 2396
    //   8170: iconst_0
    //   8171: invokeinterface 623 3 0
    //   8176: pop
    //   8177: aload 5
    //   8179: ldc_w 2398
    //   8182: iconst_0
    //   8183: invokeinterface 623 3 0
    //   8188: pop
    //   8189: aload 5
    //   8191: ldc_w 2402
    //   8194: iload 13
    //   8196: invokeinterface 358 3 0
    //   8201: pop
    //   8202: aload 5
    //   8204: ldc_w 2404
    //   8207: iload 14
    //   8209: invokeinterface 358 3 0
    //   8214: pop
    //   8215: aload 5
    //   8217: ldc_w 2406
    //   8220: iload 11
    //   8222: invokeinterface 358 3 0
    //   8227: pop
    //   8228: aload 5
    //   8230: ldc_w 2412
    //   8233: aload_1
    //   8234: invokeinterface 2415 3 0
    //   8239: pop
    //   8240: aload 5
    //   8242: ldc_w 2400
    //   8245: iload 15
    //   8247: invokeinterface 358 3 0
    //   8252: pop
    //   8253: aload 5
    //   8255: ldc_w 2398
    //   8258: iload 26
    //   8260: invokeinterface 623 3 0
    //   8265: pop
    //   8266: aload 5
    //   8268: ldc_w 2386
    //   8271: iload 28
    //   8273: invokeinterface 623 3 0
    //   8278: pop
    //   8279: aload 5
    //   8281: ldc_w 2392
    //   8284: iload 29
    //   8286: invokeinterface 623 3 0
    //   8291: pop
    //   8292: aload 5
    //   8294: ldc_w 2394
    //   8297: iload 30
    //   8299: invokeinterface 623 3 0
    //   8304: pop
    //   8305: aload 5
    //   8307: ldc_w 2396
    //   8310: iload 27
    //   8312: invokeinterface 623 3 0
    //   8317: pop
    //   8318: aload 5
    //   8320: invokeinterface 361 1 0
    //   8325: pop
    //   8326: iload 26
    //   8328: ifeq +82 -> 8410
    //   8331: aload_0
    //   8332: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8335: bipush 87
    //   8337: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8340: checkcast 2417	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager
    //   8343: invokestatic 1291	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   8346: iload 26
    //   8348: invokevirtual 2420	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:a	(JZ)V
    //   8351: aload_0
    //   8352: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8355: bipush 68
    //   8357: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   8360: checkcast 2422	com/tencent/biz/pubaccount/ecshopassit/EcShopHandler
    //   8363: invokevirtual 2423	com/tencent/biz/pubaccount/ecshopassit/EcShopHandler:a	()V
    //   8366: aconst_null
    //   8367: astore_1
    //   8368: iload 28
    //   8370: ifeq +66 -> 8436
    //   8373: ldc_w 2425
    //   8376: astore_1
    //   8377: aload_0
    //   8378: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8381: ldc_w 2427
    //   8384: ldc -112
    //   8386: ldc -112
    //   8388: ldc_w 2429
    //   8391: aload_1
    //   8392: iconst_0
    //   8393: iconst_0
    //   8394: ldc -112
    //   8396: ldc -112
    //   8398: ldc -112
    //   8400: ldc -112
    //   8402: invokestatic 1745	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   8405: aconst_null
    //   8406: astore_1
    //   8407: goto -8189 -> 218
    //   8410: aload_0
    //   8411: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8414: ldc_w 2431
    //   8417: invokevirtual 2434	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   8420: astore_1
    //   8421: aload_1
    //   8422: ifnull -71 -> 8351
    //   8425: aload_1
    //   8426: sipush 1009
    //   8429: invokevirtual 2439	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   8432: pop
    //   8433: goto -82 -> 8351
    //   8436: iload 29
    //   8438: ifeq +10 -> 8448
    //   8441: ldc_w 2441
    //   8444: astore_1
    //   8445: goto -68 -> 8377
    //   8448: iload 30
    //   8450: ifeq +10 -> 8460
    //   8453: ldc_w 2443
    //   8456: astore_1
    //   8457: goto -80 -> 8377
    //   8460: iload 27
    //   8462: ifeq +10 -> 8472
    //   8465: ldc_w 2445
    //   8468: astore_1
    //   8469: goto -92 -> 8377
    //   8472: iload 26
    //   8474: ifeq -97 -> 8377
    //   8477: ldc_w 2447
    //   8480: astore_1
    //   8481: goto -104 -> 8377
    //   8484: aload 8
    //   8486: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8489: ldc2_w 2448
    //   8492: lcmp
    //   8493: ifne +49 -> 8542
    //   8496: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8499: ifeq +13 -> 8512
    //   8502: ldc_w 458
    //   8505: iconst_2
    //   8506: ldc_w 2451
    //   8509: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8512: aload_0
    //   8513: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8516: bipush 9
    //   8518: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   8521: checkcast 2453	cooperation/huangye/HuangyeHandler
    //   8524: astore_1
    //   8525: aload_0
    //   8526: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8529: aload 8
    //   8531: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8534: invokestatic 2454	cooperation/huangye/HuangyeHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   8537: aconst_null
    //   8538: astore_1
    //   8539: goto -8321 -> 218
    //   8542: aload 8
    //   8544: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8547: ldc2_w 2455
    //   8550: lcmp
    //   8551: ifne +59 -> 8610
    //   8554: new 2458	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody
    //   8557: dup
    //   8558: invokespecial 2459	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:<init>	()V
    //   8561: astore_1
    //   8562: aload_1
    //   8563: aload 8
    //   8565: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8568: invokevirtual 2460	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8571: pop
    //   8572: aload_1
    //   8573: getfield 2461	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8576: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8579: pop2
    //   8580: aload_1
    //   8581: getfield 2464	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8584: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8587: pop
    //   8588: aload_1
    //   8589: getfield 2468	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:msg_mod_block	Ltencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock;
    //   8592: invokevirtual 2471	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8595: checkcast 2470	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock
    //   8598: getfield 2474	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8601: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8604: pop
    //   8605: aconst_null
    //   8606: astore_1
    //   8607: goto -8389 -> 218
    //   8610: aload 8
    //   8612: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8615: ldc2_w 2475
    //   8618: lcmp
    //   8619: ifne +112 -> 8731
    //   8622: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8625: ifeq +13 -> 8638
    //   8628: ldc_w 458
    //   8631: iconst_2
    //   8632: ldc_w 2478
    //   8635: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8638: new 2480	tencent/im/s2c/msgtype0x210/submsgtype0x9d/SubMsgType0x9d$MsgBody
    //   8641: dup
    //   8642: invokespecial 2481	tencent/im/s2c/msgtype0x210/submsgtype0x9d/SubMsgType0x9d$MsgBody:<init>	()V
    //   8645: astore_1
    //   8646: aload_1
    //   8647: aload 8
    //   8649: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8652: invokevirtual 2482	tencent/im/s2c/msgtype0x210/submsgtype0x9d/SubMsgType0x9d$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8655: pop
    //   8656: aload_1
    //   8657: getfield 2483	tencent/im/s2c/msgtype0x210/submsgtype0x9d/SubMsgType0x9d$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8660: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   8663: ifeq +43 -> 8706
    //   8666: aload_1
    //   8667: getfield 2486	tencent/im/s2c/msgtype0x210/submsgtype0x9d/SubMsgType0x9d$MsgBody:lola_module_update	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   8670: invokevirtual 1719	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   8673: ifeq +33 -> 8706
    //   8676: aload_0
    //   8677: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8680: sipush 143
    //   8683: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8686: checkcast 2488	com/tencent/bitapp/BitAppManager
    //   8689: aload_1
    //   8690: getfield 2483	tencent/im/s2c/msgtype0x210/submsgtype0x9d/SubMsgType0x9d$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8693: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8696: aload_1
    //   8697: getfield 2486	tencent/im/s2c/msgtype0x210/submsgtype0x9d/SubMsgType0x9d$MsgBody:lola_module_update	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   8700: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   8703: invokevirtual 2491	com/tencent/bitapp/BitAppManager:a	(ILjava/util/List;)V
    //   8706: aconst_null
    //   8707: astore_1
    //   8708: goto -8490 -> 218
    //   8711: astore_1
    //   8712: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8715: ifeq -8686 -> 29
    //   8718: ldc_w 458
    //   8721: iconst_2
    //   8722: ldc_w 2493
    //   8725: aload_1
    //   8726: invokestatic 1395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8729: aconst_null
    //   8730: areturn
    //   8731: aload 8
    //   8733: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8736: ldc2_w 2494
    //   8739: lcmp
    //   8740: ifne +90 -> 8830
    //   8743: new 2497	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   8746: dup
    //   8747: invokespecial 2498	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   8750: astore_1
    //   8751: aload_1
    //   8752: aload 8
    //   8754: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8757: invokevirtual 2499	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8760: pop
    //   8761: aload_1
    //   8762: getfield 2502	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8765: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8768: istore 11
    //   8770: iload 11
    //   8772: ifne +29 -> 8801
    //   8775: iconst_1
    //   8776: istore 22
    //   8778: aload_0
    //   8779: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8782: sipush 137
    //   8785: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8788: checkcast 2504	com/tencent/mobileqq/activity/bless/BlessManager
    //   8791: iload 22
    //   8793: invokevirtual 2507	com/tencent/mobileqq/activity/bless/BlessManager:c	(Z)V
    //   8796: aconst_null
    //   8797: astore_1
    //   8798: goto -8580 -> 218
    //   8801: iconst_0
    //   8802: istore 22
    //   8804: goto -26 -> 8778
    //   8807: astore_1
    //   8808: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8811: ifeq +13 -> 8824
    //   8814: ldc_w 2509
    //   8817: iconst_2
    //   8818: ldc_w 2511
    //   8821: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8824: iconst_1
    //   8825: istore 22
    //   8827: goto -49 -> 8778
    //   8830: aload 8
    //   8832: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8835: ldc2_w 2512
    //   8838: lcmp
    //   8839: ifne +556 -> 9395
    //   8842: iconst_0
    //   8843: istore 22
    //   8845: aload_0
    //   8846: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8849: invokevirtual 406	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8852: ldc_w 2515
    //   8855: invokevirtual 2518	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   8858: checkcast 2520	android/app/ActivityManager
    //   8861: iconst_1
    //   8862: invokevirtual 2524	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   8865: astore_1
    //   8866: aload_1
    //   8867: ifnull +1840 -> 10707
    //   8870: aload_1
    //   8871: invokeinterface 1246 1 0
    //   8876: iconst_1
    //   8877: if_icmplt +1830 -> 10707
    //   8880: aload_1
    //   8881: iconst_0
    //   8882: invokeinterface 1843 2 0
    //   8887: checkcast 2526	android/app/ActivityManager$RunningTaskInfo
    //   8890: getfield 2530	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   8893: invokevirtual 2535	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   8896: astore_1
    //   8897: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8900: ifeq +30 -> 8930
    //   8903: ldc_w 458
    //   8906: iconst_2
    //   8907: new 109	java/lang/StringBuilder
    //   8910: dup
    //   8911: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   8914: ldc_w 2537
    //   8917: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8920: aload_1
    //   8921: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8924: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8927: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8930: ldc_w 2539
    //   8933: aload_1
    //   8934: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8937: istore 23
    //   8939: iload 23
    //   8941: istore 22
    //   8943: aload_0
    //   8944: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8947: invokevirtual 406	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8950: ldc_w 2541
    //   8953: invokevirtual 2518	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   8956: checkcast 2543	android/os/PowerManager
    //   8959: invokevirtual 2546	android/os/PowerManager:isScreenOn	()Z
    //   8962: istore 23
    //   8964: iload 23
    //   8966: ifeq +18 -> 8984
    //   8969: aload_0
    //   8970: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8973: getfield 2549	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   8976: ifeq +339 -> 9315
    //   8979: iload 22
    //   8981: ifne +334 -> 9315
    //   8984: new 2551	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody
    //   8987: dup
    //   8988: invokespecial 2552	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:<init>	()V
    //   8991: astore 6
    //   8993: aconst_null
    //   8994: astore_1
    //   8995: aconst_null
    //   8996: astore 4
    //   8998: aconst_null
    //   8999: astore 5
    //   9001: aload 6
    //   9003: aload 8
    //   9005: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9008: invokevirtual 2553	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9011: pop
    //   9012: aload 6
    //   9014: getfield 2556	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9017: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   9020: ifeq +15 -> 9035
    //   9023: aload 6
    //   9025: getfield 2556	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9028: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9031: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   9034: astore_1
    //   9035: aload 6
    //   9037: getfield 2559	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9040: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   9043: ifeq +16 -> 9059
    //   9046: aload 6
    //   9048: getfield 2559	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9051: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9054: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   9057: astore 4
    //   9059: aload 6
    //   9061: getfield 2562	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9064: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   9067: ifeq +16 -> 9083
    //   9070: aload 6
    //   9072: getfield 2562	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9075: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9078: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   9081: astore 5
    //   9083: aload_1
    //   9084: invokestatic 629	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9087: ifne +228 -> 9315
    //   9090: aload 4
    //   9092: invokestatic 629	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9095: ifne +220 -> 9315
    //   9098: aload 5
    //   9100: invokestatic 629	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9103: ifne +212 -> 9315
    //   9106: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9109: ifeq +52 -> 9161
    //   9112: ldc_w 458
    //   9115: iconst_2
    //   9116: new 109	java/lang/StringBuilder
    //   9119: dup
    //   9120: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   9123: ldc_w 2564
    //   9126: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9129: aload_1
    //   9130: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9133: ldc_w 2566
    //   9136: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9139: aload 4
    //   9141: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9144: ldc_w 2568
    //   9147: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9150: aload 5
    //   9152: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9155: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9158: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9161: new 388	android/content/Intent
    //   9164: dup
    //   9165: aload_0
    //   9166: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9169: invokevirtual 406	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9172: ldc_w 2570
    //   9175: invokespecial 2573	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9178: astore 6
    //   9180: aload 6
    //   9182: ldc_w 2575
    //   9185: aload 5
    //   9187: invokevirtual 403	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9190: pop
    //   9191: aload 6
    //   9193: ldc_w 2577
    //   9196: sipush 3001
    //   9199: invokevirtual 2580	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9202: pop
    //   9203: new 2582	com/tencent/qphone/base/remote/ToServiceMsg
    //   9206: dup
    //   9207: ldc_w 2584
    //   9210: aload_0
    //   9211: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9214: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   9217: ldc_w 2586
    //   9220: invokespecial 2589	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   9223: astore 5
    //   9225: aload 5
    //   9227: getfield 2593	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   9230: ldc_w 2595
    //   9233: iconst_3
    //   9234: anewarray 259	java/lang/String
    //   9237: dup
    //   9238: iconst_0
    //   9239: aload 4
    //   9241: aastore
    //   9242: dup
    //   9243: iconst_1
    //   9244: aload_1
    //   9245: aastore
    //   9246: dup
    //   9247: iconst_2
    //   9248: aload 4
    //   9250: aastore
    //   9251: invokevirtual 2599	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9254: aload 5
    //   9256: getfield 2593	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   9259: ldc_w 2601
    //   9262: aload 6
    //   9264: invokevirtual 2605	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   9267: aload 5
    //   9269: getfield 2593	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   9272: ldc_w 2607
    //   9275: aconst_null
    //   9276: invokevirtual 2605	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   9279: aload_0
    //   9280: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9283: aload 5
    //   9285: invokevirtual 2610	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   9288: aconst_null
    //   9289: ldc_w 2427
    //   9292: ldc -112
    //   9294: ldc -112
    //   9296: ldc_w 2612
    //   9299: ldc_w 2612
    //   9302: iconst_0
    //   9303: iconst_0
    //   9304: ldc -112
    //   9306: ldc -112
    //   9308: ldc -112
    //   9310: ldc -112
    //   9312: invokestatic 1745	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   9315: aconst_null
    //   9316: astore_1
    //   9317: goto -9099 -> 218
    //   9320: astore_1
    //   9321: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9324: ifeq +13 -> 9337
    //   9327: ldc_w 458
    //   9330: iconst_2
    //   9331: ldc_w 2614
    //   9334: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   9337: aload_1
    //   9338: invokevirtual 1040	java/lang/Exception:printStackTrace	()V
    //   9341: goto -398 -> 8943
    //   9344: astore_1
    //   9345: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9348: ifeq +13 -> 9361
    //   9351: ldc_w 458
    //   9354: iconst_2
    //   9355: ldc_w 2616
    //   9358: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   9361: aload_1
    //   9362: invokevirtual 1040	java/lang/Exception:printStackTrace	()V
    //   9365: iconst_1
    //   9366: istore 23
    //   9368: goto -404 -> 8964
    //   9371: astore_1
    //   9372: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9375: ifeq +13 -> 9388
    //   9378: ldc_w 458
    //   9381: iconst_2
    //   9382: ldc_w 2618
    //   9385: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   9388: aload_1
    //   9389: invokevirtual 1040	java/lang/Exception:printStackTrace	()V
    //   9392: goto -77 -> 9315
    //   9395: aload 8
    //   9397: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9400: ldc2_w 2619
    //   9403: lcmp
    //   9404: ifne +293 -> 9697
    //   9407: aload 8
    //   9409: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9412: ifnull +285 -> 9697
    //   9415: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9418: ifeq +13 -> 9431
    //   9421: ldc_w 458
    //   9424: iconst_2
    //   9425: ldc_w 2622
    //   9428: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9431: aload_0
    //   9432: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9435: sipush 142
    //   9438: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9441: checkcast 503	com/tencent/mobileqq/qcall/PstnManager
    //   9444: invokevirtual 2623	com/tencent/mobileqq/qcall/PstnManager:a	()I
    //   9447: iconst_1
    //   9448: if_icmpne +210 -> 9658
    //   9451: new 2625	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody
    //   9454: dup
    //   9455: invokespecial 2626	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:<init>	()V
    //   9458: astore 4
    //   9460: aload 4
    //   9462: aload 8
    //   9464: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9467: invokevirtual 2627	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9470: checkcast 2625	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody
    //   9473: astore 4
    //   9475: sipush 63491
    //   9478: invokestatic 960	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   9481: astore 5
    //   9483: aload 4
    //   9485: getfield 2630	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9488: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9491: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   9494: astore 6
    //   9496: aload 4
    //   9498: getfield 2631	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9501: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9504: invokevirtual 139	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   9507: astore 7
    //   9509: aload 4
    //   9511: getfield 2634	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_auth_key	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9514: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9517: invokestatic 2638	com/tencent/mobileqq/qcall/UinUtils:a	(I)Ljava/lang/String;
    //   9520: astore 8
    //   9522: aload 4
    //   9524: getfield 2639	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9527: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9530: istore 12
    //   9532: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9535: ifeq +1293 -> 10828
    //   9538: ldc_w 458
    //   9541: iconst_2
    //   9542: iconst_3
    //   9543: anewarray 199	java/lang/Object
    //   9546: dup
    //   9547: iconst_0
    //   9548: ldc_w 2641
    //   9551: aastore
    //   9552: dup
    //   9553: iconst_1
    //   9554: iload 12
    //   9556: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9559: aastore
    //   9560: dup
    //   9561: iconst_2
    //   9562: aload 4
    //   9564: getfield 2634	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_auth_key	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9567: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9570: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9573: aastore
    //   9574: invokestatic 2644	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   9577: goto +1251 -> 10828
    //   9580: aload 5
    //   9582: aload_0
    //   9583: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9586: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   9589: aload 8
    //   9591: aload 8
    //   9593: new 109	java/lang/StringBuilder
    //   9596: dup
    //   9597: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   9600: aload 6
    //   9602: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9605: ldc_w 2646
    //   9608: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9611: aload 7
    //   9613: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9616: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9619: lconst_0
    //   9620: sipush 63491
    //   9623: iload 11
    //   9625: aload_1
    //   9626: invokevirtual 2204	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   9629: i2l
    //   9630: invokevirtual 968	com/tencent/mobileqq/data/MessageRecord:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   9633: aload 5
    //   9635: iconst_1
    //   9636: putfield 974	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   9639: aload_0
    //   9640: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9643: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   9646: aload 5
    //   9648: aload_0
    //   9649: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9652: invokevirtual 297	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   9655: invokevirtual 1469	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   9658: aconst_null
    //   9659: astore_1
    //   9660: goto -9442 -> 218
    //   9663: iload 12
    //   9665: iconst_2
    //   9666: if_icmpne -86 -> 9580
    //   9669: sipush 3000
    //   9672: istore 11
    //   9674: goto -94 -> 9580
    //   9677: astore_1
    //   9678: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9681: ifeq -23 -> 9658
    //   9684: ldc_w 458
    //   9687: iconst_2
    //   9688: ldc_w 2648
    //   9691: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9694: goto -36 -> 9658
    //   9697: aload 8
    //   9699: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9702: ldc2_w 2494
    //   9705: lcmp
    //   9706: ifne +90 -> 9796
    //   9709: new 2497	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   9712: dup
    //   9713: invokespecial 2498	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   9716: astore_1
    //   9717: aload_1
    //   9718: aload 8
    //   9720: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9723: invokevirtual 2499	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9726: pop
    //   9727: aload_1
    //   9728: getfield 2502	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9731: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9734: istore 11
    //   9736: iload 11
    //   9738: ifne +29 -> 9767
    //   9741: iconst_1
    //   9742: istore 22
    //   9744: aload_0
    //   9745: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9748: sipush 137
    //   9751: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9754: checkcast 2504	com/tencent/mobileqq/activity/bless/BlessManager
    //   9757: iload 22
    //   9759: invokevirtual 2507	com/tencent/mobileqq/activity/bless/BlessManager:c	(Z)V
    //   9762: aconst_null
    //   9763: astore_1
    //   9764: goto -9546 -> 218
    //   9767: iconst_0
    //   9768: istore 22
    //   9770: goto -26 -> 9744
    //   9773: astore_1
    //   9774: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9777: ifeq +13 -> 9790
    //   9780: ldc_w 2509
    //   9783: iconst_2
    //   9784: ldc_w 2511
    //   9787: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   9790: iconst_1
    //   9791: istore 22
    //   9793: goto -49 -> 9744
    //   9796: aload 8
    //   9798: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9801: ldc2_w 2649
    //   9804: lcmp
    //   9805: ifne +103 -> 9908
    //   9808: new 2652	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody
    //   9811: dup
    //   9812: invokespecial 2653	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody:<init>	()V
    //   9815: astore_1
    //   9816: aload_1
    //   9817: aload 8
    //   9819: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9822: invokevirtual 2654	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9825: pop
    //   9826: aload_0
    //   9827: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9830: bipush 75
    //   9832: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   9835: checkcast 1522	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler
    //   9838: astore 4
    //   9840: aload_0
    //   9841: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9844: bipush 114
    //   9846: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9849: checkcast 2656	cooperation/dingdong/DingdongPluginManager
    //   9852: astore 5
    //   9854: aload 4
    //   9856: aload_1
    //   9857: iconst_0
    //   9858: invokevirtual 2659	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody;Z)V
    //   9861: aconst_null
    //   9862: astore_1
    //   9863: goto -9645 -> 218
    //   9866: astore 4
    //   9868: ldc_w 458
    //   9871: iconst_1
    //   9872: new 109	java/lang/StringBuilder
    //   9875: dup
    //   9876: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   9879: ldc_w 2661
    //   9882: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9885: aload 4
    //   9887: invokevirtual 1479	java/lang/Exception:toString	()Ljava/lang/String;
    //   9890: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9893: ldc_w 2663
    //   9896: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9899: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9902: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   9905: goto -79 -> 9826
    //   9908: aload 8
    //   9910: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9913: ldc2_w 2664
    //   9916: lcmp
    //   9917: ifne +85 -> 10002
    //   9920: new 2667	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody
    //   9923: dup
    //   9924: invokespecial 2668	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:<init>	()V
    //   9927: astore_1
    //   9928: aload_1
    //   9929: aload 8
    //   9931: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9934: invokevirtual 2669	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9937: pop
    //   9938: aload_0
    //   9939: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9942: bipush 75
    //   9944: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   9947: checkcast 1522	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler
    //   9950: aload_1
    //   9951: iconst_0
    //   9952: invokevirtual 2672	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody;Z)V
    //   9955: aconst_null
    //   9956: astore_1
    //   9957: goto -9739 -> 218
    //   9960: astore 4
    //   9962: ldc_w 458
    //   9965: iconst_1
    //   9966: new 109	java/lang/StringBuilder
    //   9969: dup
    //   9970: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   9973: ldc_w 2674
    //   9976: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9979: aload 4
    //   9981: invokevirtual 1479	java/lang/Exception:toString	()Ljava/lang/String;
    //   9984: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9987: ldc_w 2663
    //   9990: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9993: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9996: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   9999: goto -61 -> 9938
    //   10002: aload 8
    //   10004: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10007: ldc2_w 2675
    //   10010: lcmp
    //   10011: ifne +110 -> 10121
    //   10014: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10017: ifeq +13 -> 10030
    //   10020: ldc_w 2678
    //   10023: iconst_2
    //   10024: ldc_w 2680
    //   10027: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10030: new 2682	tencent/qht_exinfo/qht_post_exinfo
    //   10033: dup
    //   10034: invokespecial 2683	tencent/qht_exinfo/qht_post_exinfo:<init>	()V
    //   10037: astore_1
    //   10038: aload_1
    //   10039: aload 8
    //   10041: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10044: invokevirtual 2684	tencent/qht_exinfo/qht_post_exinfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10047: pop
    //   10048: aload_0
    //   10049: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10052: bipush 97
    //   10054: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10057: checkcast 2686	com/tencent/mobileqq/troop/utils/TroopTopicMgr
    //   10060: astore 4
    //   10062: aload 4
    //   10064: ifnull +29 -> 10093
    //   10067: aload 4
    //   10069: aload_1
    //   10070: getfield 2689	tencent/qht_exinfo/qht_post_exinfo:groupCode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   10073: invokevirtual 1564	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   10076: aload_1
    //   10077: getfield 2692	tencent/qht_exinfo/qht_post_exinfo:msgSeq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   10080: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   10083: aload_1
    //   10084: getfield 2695	tencent/qht_exinfo/qht_post_exinfo:pVersion	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   10087: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   10090: invokevirtual 2698	com/tencent/mobileqq/troop/utils/TroopTopicMgr:a	(Ljava/lang/String;JJ)V
    //   10093: aconst_null
    //   10094: astore_1
    //   10095: goto -9877 -> 218
    //   10098: astore_1
    //   10099: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10102: ifeq +14 -> 10116
    //   10105: ldc_w 2678
    //   10108: iconst_2
    //   10109: ldc_w 2700
    //   10112: aload_1
    //   10113: invokestatic 1395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10116: aconst_null
    //   10117: astore_1
    //   10118: goto -9900 -> 218
    //   10121: aload 8
    //   10123: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10126: ldc2_w 2701
    //   10129: lcmp
    //   10130: ifne +81 -> 10211
    //   10133: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10136: ifeq +13 -> 10149
    //   10139: ldc_w 2704
    //   10142: iconst_2
    //   10143: ldc_w 2706
    //   10146: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10149: new 2708	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody
    //   10152: dup
    //   10153: invokespecial 2709	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:<init>	()V
    //   10156: astore_1
    //   10157: aload_1
    //   10158: aload 8
    //   10160: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10163: invokevirtual 2710	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10166: pop
    //   10167: aload_0
    //   10168: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10171: bipush 20
    //   10173: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   10176: checkcast 1431	com/tencent/mobileqq/app/TroopHandler
    //   10179: aload_1
    //   10180: invokevirtual 2713	com/tencent/mobileqq/app/TroopHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody;)V
    //   10183: aconst_null
    //   10184: astore_1
    //   10185: goto -9967 -> 218
    //   10188: astore_1
    //   10189: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10192: ifeq +14 -> 10206
    //   10195: ldc_w 2704
    //   10198: iconst_2
    //   10199: ldc_w 2715
    //   10202: aload_1
    //   10203: invokestatic 2717	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10206: aconst_null
    //   10207: astore_1
    //   10208: goto -9990 -> 218
    //   10211: aload 8
    //   10213: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10216: ldc2_w 2718
    //   10219: lcmp
    //   10220: ifne +51 -> 10271
    //   10223: new 2721	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody
    //   10226: dup
    //   10227: invokespecial 2722	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:<init>	()V
    //   10230: astore_1
    //   10231: aload_1
    //   10232: aload 8
    //   10234: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10237: invokevirtual 2723	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10240: pop
    //   10241: aload_0
    //   10242: aload_1
    //   10243: invokevirtual 2726	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody;)V
    //   10246: aconst_null
    //   10247: astore_1
    //   10248: goto -10030 -> 218
    //   10251: astore_1
    //   10252: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10255: ifeq -9 -> 10246
    //   10258: ldc_w 2728
    //   10261: iconst_2
    //   10262: ldc_w 2730
    //   10265: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10268: goto -22 -> 10246
    //   10271: aload 8
    //   10273: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10276: ldc2_w 2731
    //   10279: lcmp
    //   10280: ifne +81 -> 10361
    //   10283: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10286: ifeq +13 -> 10299
    //   10289: ldc_w 2734
    //   10292: iconst_2
    //   10293: ldc_w 2736
    //   10296: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10299: new 2738	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody
    //   10302: dup
    //   10303: invokespecial 2739	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:<init>	()V
    //   10306: astore_1
    //   10307: aload_1
    //   10308: aload 8
    //   10310: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10313: invokevirtual 2740	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10316: pop
    //   10317: aload_0
    //   10318: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10321: sipush 155
    //   10324: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10327: checkcast 2742	com/tencent/mobileqq/gameparty/GamePartyManager
    //   10330: aload_1
    //   10331: iconst_0
    //   10332: invokevirtual 2745	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody;Z)V
    //   10335: aconst_null
    //   10336: astore_1
    //   10337: goto -10119 -> 218
    //   10340: astore 4
    //   10342: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10345: ifeq -28 -> 10317
    //   10348: ldc_w 2734
    //   10351: iconst_2
    //   10352: ldc_w 2747
    //   10355: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10358: goto -41 -> 10317
    //   10361: aload 8
    //   10363: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10366: ldc2_w 2748
    //   10369: lcmp
    //   10370: ifne +104 -> 10474
    //   10373: new 2751	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody
    //   10376: dup
    //   10377: invokespecial 2752	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:<init>	()V
    //   10380: astore 4
    //   10382: aload 4
    //   10384: aload 8
    //   10386: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10389: invokevirtual 2753	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10392: pop
    //   10393: aload_0
    //   10394: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10397: sipush 158
    //   10400: invokevirtual 684	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10403: checkcast 2755	com/tencent/mobileqq/app/MayknowRecommendManager
    //   10406: aload 4
    //   10408: invokevirtual 2758	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody;)V
    //   10411: aload_1
    //   10412: getfield 883	OnlinePushPack/MsgInfo:lFromUin	J
    //   10415: lstore_2
    //   10416: aload_1
    //   10417: getfield 905	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   10420: istore 11
    //   10422: aload_1
    //   10423: getfield 935	OnlinePushPack/MsgInfo:lMsgUid	J
    //   10426: lstore 20
    //   10428: aload_1
    //   10429: getfield 880	OnlinePushPack/MsgInfo:shMsgType	S
    //   10432: istore 12
    //   10434: aload_0
    //   10435: getfield 1214	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   10438: lload_2
    //   10439: iload 11
    //   10441: lload 20
    //   10443: iload 12
    //   10445: invokestatic 1646	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   10448: aconst_null
    //   10449: astore_1
    //   10450: goto -10232 -> 218
    //   10453: astore 4
    //   10455: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10458: ifeq -47 -> 10411
    //   10461: ldc_w 2728
    //   10464: iconst_2
    //   10465: ldc_w 2760
    //   10468: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10471: goto -60 -> 10411
    //   10474: aload 8
    //   10476: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10479: ldc2_w 2761
    //   10482: lcmp
    //   10483: ifne +175 -> 10658
    //   10486: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10489: ifeq +13 -> 10502
    //   10492: ldc_w 2764
    //   10495: iconst_2
    //   10496: ldc_w 2766
    //   10499: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10502: new 2768	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody
    //   10505: dup
    //   10506: invokespecial 2769	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:<init>	()V
    //   10509: astore_1
    //   10510: aload_1
    //   10511: aload 8
    //   10513: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10516: invokevirtual 2770	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10519: pop
    //   10520: aload_1
    //   10521: getfield 2771	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10524: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10527: istore 11
    //   10529: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10532: ifeq +28 -> 10560
    //   10535: ldc_w 2764
    //   10538: iconst_2
    //   10539: iconst_2
    //   10540: anewarray 199	java/lang/Object
    //   10543: dup
    //   10544: iconst_0
    //   10545: ldc_w 2773
    //   10548: aastore
    //   10549: dup
    //   10550: iconst_1
    //   10551: iload 11
    //   10553: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10556: aastore
    //   10557: invokestatic 2644	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   10560: iload 11
    //   10562: iconst_1
    //   10563: if_icmpne +280 -> 10843
    //   10566: aload_1
    //   10567: getfield 2777	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:msg_body_type	Ltencent/im/oidb/olympic/submsgtype0xb4$BodyType;
    //   10570: astore_1
    //   10571: aload_1
    //   10572: getfield 2783	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   10575: invokevirtual 2786	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:has	()Z
    //   10578: ifeq +40 -> 10618
    //   10581: aload_0
    //   10582: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10585: bipush 94
    //   10587: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   10590: checkcast 2788	com/tencent/mobileqq/olympic/OlympicHandler
    //   10593: astore 4
    //   10595: aload 4
    //   10597: ifnull +246 -> 10843
    //   10600: aload 4
    //   10602: aload_1
    //   10603: getfield 2783	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   10606: invokevirtual 2789	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10609: checkcast 2785	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo
    //   10612: invokevirtual 2792	com/tencent/mobileqq/olympic/OlympicHandler:a	(Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;)V
    //   10615: goto +228 -> 10843
    //   10618: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10621: ifeq +222 -> 10843
    //   10624: ldc_w 2764
    //   10627: iconst_2
    //   10628: ldc_w 2794
    //   10631: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10634: goto +209 -> 10843
    //   10637: astore_1
    //   10638: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10641: ifeq +202 -> 10843
    //   10644: ldc_w 2764
    //   10647: iconst_2
    //   10648: ldc_w 2796
    //   10651: aload_1
    //   10652: invokestatic 2005	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10655: goto +188 -> 10843
    //   10658: aload 8
    //   10660: getfield 1314	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10663: ldc2_w 2797
    //   10666: lcmp
    //   10667: ifne +16 -> 10683
    //   10670: aload_0
    //   10671: getfield 164	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10674: aload 8
    //   10676: getfield 1345	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10679: iconst_1
    //   10680: invokestatic 2801	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BZ)V
    //   10683: aconst_null
    //   10684: astore_1
    //   10685: goto -10467 -> 218
    //   10688: astore 4
    //   10690: goto -2118 -> 8572
    //   10693: astore_1
    //   10694: goto -3424 -> 7270
    //   10697: astore 6
    //   10699: goto -7215 -> 3484
    //   10702: astore 6
    //   10704: goto -7220 -> 3484
    //   10707: iconst_0
    //   10708: istore 22
    //   10710: goto -1767 -> 8943
    //   10713: iload 24
    //   10715: istore 27
    //   10717: iload 25
    //   10719: istore 28
    //   10721: iload 23
    //   10723: istore 29
    //   10725: iload 22
    //   10727: istore 30
    //   10729: goto -2939 -> 7790
    //   10732: goto -3126 -> 7606
    //   10735: iconst_0
    //   10736: istore 12
    //   10738: goto -6616 -> 4122
    //   10741: iconst_0
    //   10742: istore 11
    //   10744: goto -6643 -> 4101
    //   10747: aconst_null
    //   10748: astore 6
    //   10750: goto -7372 -> 3378
    //   10753: aconst_null
    //   10754: astore 5
    //   10756: goto -7412 -> 3344
    //   10759: aconst_null
    //   10760: astore 4
    //   10762: goto -7456 -> 3306
    //   10765: goto -9867 -> 898
    //   10768: aconst_null
    //   10769: astore_1
    //   10770: goto -10552 -> 218
    //   10773: ldc -112
    //   10775: astore_1
    //   10776: goto -10169 -> 607
    //   10779: iload 13
    //   10781: ifge -6543 -> 4238
    //   10784: iload 14
    //   10786: iflt -6514 -> 4272
    //   10789: goto -6551 -> 4238
    //   10792: iload 11
    //   10794: ifne -6479 -> 4315
    //   10797: iload 12
    //   10799: ifeq -6858 -> 3941
    //   10802: goto -6487 -> 4315
    //   10805: aload 5
    //   10807: astore 4
    //   10809: iload 12
    //   10811: istore 11
    //   10813: goto -4633 -> 6180
    //   10816: sipush 1001
    //   10819: istore 11
    //   10821: aload 5
    //   10823: astore 4
    //   10825: goto -4645 -> 6180
    //   10828: iconst_0
    //   10829: istore 11
    //   10831: iload 12
    //   10833: iconst_3
    //   10834: if_icmpne -1171 -> 9663
    //   10837: iconst_0
    //   10838: istore 11
    //   10840: goto -1260 -> 9580
    //   10843: aconst_null
    //   10844: astore_1
    //   10845: goto -10627 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10848	0	this	OnLinePushMessageProcessor
    //   0	10848	1	paramMsgInfo	MsgInfo
    //   0	10848	2	paramLong	long
    //   108	2058	4	localObject1	Object
    //   2218	1	4	localException1	Exception
    //   2343	402	4	localObject2	Object
    //   2761	26	4	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   3223	298	4	localObject3	Object
    //   3527	3	4	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   3663	6192	4	localObject4	Object
    //   9866	20	4	localException2	Exception
    //   9960	20	4	localException3	Exception
    //   10060	8	4	localTroopTopicMgr	com.tencent.mobileqq.troop.utils.TroopTopicMgr
    //   10340	1	4	localException4	Exception
    //   10380	27	4	localMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody
    //   10453	1	4	localException5	Exception
    //   10593	8	4	localOlympicHandler	com.tencent.mobileqq.olympic.OlympicHandler
    //   10688	1	4	localThrowable	Throwable
    //   10760	64	4	localObject5	Object
    //   171	2283	5	localObject6	Object
    //   2464	36	5	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   3263	7559	5	localObject7	Object
    //   741	2684	6	localObject8	Object
    //   3482	1	6	localException6	Exception
    //   3494	6107	6	localObject9	Object
    //   10697	1	6	localException7	Exception
    //   10702	1	6	localException8	Exception
    //   10748	1	6	localObject10	Object
    //   858	8754	7	localObject11	Object
    //   22	10653	8	localObject12	Object
    //   1963	4695	9	localObject13	Object
    //   6476	109	10	localFriendsManager	FriendsManager
    //   467	10372	11	i	int
    //   2197	8638	12	j	int
    //   4123	6657	13	k	int
    //   4126	6659	14	m	int
    //   4178	4068	15	n	int
    //   7953	63	16	i1	int
    //   7966	57	17	i2	int
    //   7979	54	18	i3	int
    //   7989	41	19	i4	int
    //   2191	8251	20	l	long
    //   193	10533	22	bool1	boolean
    //   7369	3353	23	bool2	boolean
    //   7399	3315	24	bool3	boolean
    //   7339	3379	25	bool4	boolean
    //   7354	1119	26	bool5	boolean
    //   7693	3023	27	bool6	boolean
    //   7697	3023	28	bool7	boolean
    //   7701	3023	29	bool8	boolean
    //   7705	3023	30	bool9	boolean
    // Exception table:
    //   from	to	target	type
    //   443	503	508	java/lang/Exception
    //   867	880	1071	java/lang/Exception
    //   884	898	1071	java/lang/Exception
    //   902	943	1071	java/lang/Exception
    //   943	1033	1071	java/lang/Exception
    //   1033	1052	1071	java/lang/Exception
    //   1052	1057	1071	java/lang/Exception
    //   543	607	1116	java/lang/Exception
    //   607	644	1116	java/lang/Exception
    //   644	677	1116	java/lang/Exception
    //   677	783	1116	java/lang/Exception
    //   783	822	1116	java/lang/Exception
    //   822	867	1116	java/lang/Exception
    //   1057	1062	1116	java/lang/Exception
    //   1108	1113	1116	java/lang/Exception
    //   1139	1146	1116	java/lang/Exception
    //   867	880	1138	finally
    //   884	898	1138	finally
    //   902	943	1138	finally
    //   943	1033	1138	finally
    //   1033	1052	1138	finally
    //   1052	1057	1138	finally
    //   1072	1108	1138	finally
    //   1439	1463	1479	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1468	1474	1479	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1528	1552	1568	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1557	1563	1568	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1620	1737	1856	java/lang/Exception
    //   1742	1760	1856	java/lang/Exception
    //   1760	1851	1856	java/lang/Exception
    //   1956	1976	2218	java/lang/Exception
    //   1976	2010	2218	java/lang/Exception
    //   2010	2044	2218	java/lang/Exception
    //   2044	2078	2218	java/lang/Exception
    //   2078	2102	2218	java/lang/Exception
    //   2102	2158	2218	java/lang/Exception
    //   2158	2176	2218	java/lang/Exception
    //   2345	2356	2464	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2698	2708	2761	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3268	3302	3482	java/lang/Exception
    //   3171	3187	3527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3187	3254	3527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3268	3302	3527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3306	3340	3527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3344	3378	3527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3390	3440	3527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3496	3512	3527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3569	3585	3527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3656	3695	4402	java/lang/Exception
    //   3698	3719	4402	java/lang/Exception
    //   3727	3751	4402	java/lang/Exception
    //   3763	3784	4402	java/lang/Exception
    //   3784	3805	4402	java/lang/Exception
    //   3805	3825	4402	java/lang/Exception
    //   3825	3846	4402	java/lang/Exception
    //   3846	3912	4402	java/lang/Exception
    //   3912	3926	4402	java/lang/Exception
    //   3931	3941	4402	java/lang/Exception
    //   3941	3978	4402	java/lang/Exception
    //   3991	4052	4402	java/lang/Exception
    //   4054	4074	4402	java/lang/Exception
    //   4074	4101	4402	java/lang/Exception
    //   4101	4122	4402	java/lang/Exception
    //   4128	4149	4402	java/lang/Exception
    //   4149	4170	4402	java/lang/Exception
    //   4170	4235	4402	java/lang/Exception
    //   4238	4272	4402	java/lang/Exception
    //   4272	4312	4402	java/lang/Exception
    //   4315	4360	4402	java/lang/Exception
    //   4360	4399	4402	java/lang/Exception
    //   4449	4476	4402	java/lang/Exception
    //   4476	4525	4402	java/lang/Exception
    //   4525	4552	4402	java/lang/Exception
    //   4552	4579	4402	java/lang/Exception
    //   4579	4598	4402	java/lang/Exception
    //   4621	4631	4678	java/lang/Throwable
    //   5146	5240	5355	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5240	5312	5355	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5318	5350	5355	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5434	5460	5465	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5555	5607	5612	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5702	5712	5791	java/lang/Exception
    //   5716	5727	5791	java/lang/Exception
    //   5736	5780	5791	java/lang/Exception
    //   5844	5999	6063	java/lang/Exception
    //   5999	6057	6063	java/lang/Exception
    //   6074	6081	6063	java/lang/Exception
    //   6116	6127	6389	java/lang/Exception
    //   6142	6180	6389	java/lang/Exception
    //   6180	6324	6389	java/lang/Exception
    //   6324	6383	6389	java/lang/Exception
    //   6405	6418	6389	java/lang/Exception
    //   6426	6439	6389	java/lang/Exception
    //   6442	6449	6389	java/lang/Exception
    //   6498	6580	6741	java/lang/Exception
    //   6584	6593	6741	java/lang/Exception
    //   6598	6606	6741	java/lang/Exception
    //   6609	6735	6741	java/lang/Exception
    //   6861	6871	6917	java/lang/Throwable
    //   6997	7017	7022	java/lang/Exception
    //   7091	7103	7108	java/lang/Throwable
    //   7154	7213	7218	java/lang/Exception
    //   8646	8656	8711	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   8751	8770	8807	java/lang/Exception
    //   8845	8866	9320	java/lang/Exception
    //   8870	8930	9320	java/lang/Exception
    //   8930	8939	9320	java/lang/Exception
    //   8943	8964	9344	java/lang/Exception
    //   9001	9012	9371	java/lang/Exception
    //   9012	9035	9371	java/lang/Exception
    //   9035	9059	9371	java/lang/Exception
    //   9059	9083	9371	java/lang/Exception
    //   9083	9161	9371	java/lang/Exception
    //   9161	9315	9371	java/lang/Exception
    //   9460	9577	9677	java/lang/Exception
    //   9580	9658	9677	java/lang/Exception
    //   9717	9736	9773	java/lang/Exception
    //   9816	9826	9866	java/lang/Exception
    //   9928	9938	9960	java/lang/Exception
    //   10030	10062	10098	java/lang/Exception
    //   10067	10093	10098	java/lang/Exception
    //   10149	10183	10188	java/lang/Exception
    //   10231	10246	10251	java/lang/Exception
    //   10307	10317	10340	java/lang/Exception
    //   10382	10411	10453	java/lang/Exception
    //   10510	10560	10637	java/lang/Exception
    //   10566	10595	10637	java/lang/Exception
    //   10600	10615	10637	java/lang/Exception
    //   10618	10634	10637	java/lang/Exception
    //   8562	8572	10688	java/lang/Throwable
    //   7259	7270	10693	java/lang/Throwable
    //   3306	3340	10697	java/lang/Exception
    //   3344	3378	10702	java/lang/Exception
  }
  
  private qmb b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt)).a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private void b(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject1 = new submsgtype0x31.MsgBody();
    int i;
    long l1;
    SubAccountManager localSubAccountManager;
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        long l2;
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramArrayOfByte);
            }
            paramArrayOfByte = null;
          }
          if ((!paramArrayOfByte.uint32_flag.has()) || (!paramArrayOfByte.uint64_bind_uin.has()) || (!paramArrayOfByte.uint64_uin.has()))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uinflag_null");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
          i = paramArrayOfByte.uint32_flag.get();
          l1 = paramArrayOfByte.uint32_time.get();
          l1 = paramArrayOfByte.uint64_uin.get();
          l2 = paramArrayOfByte.uint64_bind_uin.get();
          if ((l1 <= 0L) || (l2 <= 0L))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uin_error");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
        } while (!String.valueOf(paramLong).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        paramArrayOfByte = new SubAccountBackProtocData();
        paramArrayOfByte.c = String.valueOf(l1);
        paramArrayOfByte.b = String.valueOf(l2);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", "12018");
        ((HashMap)localObject1).put("fail_step", "success_" + i);
        ((HashMap)localObject1).put("fail_location", "MessageHandler");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject1, "");
        localObject1 = (SubAccountControll)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
        if (i == 1)
        {
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, paramArrayOfByte.c);
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte.c);
          paramArrayOfByte.p = 1;
          ((SubAccountControll)localObject1).a(paramArrayOfByte.c, 1);
          a(8004, true, paramArrayOfByte);
          return;
        }
      } while (i != 0);
      localObject1 = String.valueOf(l1);
      localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      paramArrayOfByte.a((String)localObject1);
      localSubAccountManager.a(paramArrayOfByte);
      Object localObject2 = paramArrayOfByte.a();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint is new,msg num=1, subUin=" + str);
          }
          i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 7000);
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, 7000, i);
          }
        }
      }
      boolean bool = false;
      localObject2 = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
      if (localObject2 != null) {
        bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      }
      if (!bool) {
        break label783;
      }
    }
    localSubAccountManager.a((String)localObject1, 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l1), new qlz(this, localSubAccountManager));
    for (;;)
    {
      paramArrayOfByte.p = 0;
      a(8004, true, paramArrayOfByte);
      return;
      label783:
      if (localSubAccountManager.a(String.valueOf(l1), 2))
      {
        i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 7000);
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((String)localObject1, 7000, i);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { AppConstants.ah, localObject1 });
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint need to verify,msg num=1, subUin=" + (String)localObject1);
        }
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void g(byte[] paramArrayOfByte)
  {
    long l = PkgTools.a(paramArrayOfByte, 0);
    String str = String.valueOf(l);
    int i = paramArrayOfByte[5];
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg cOp = " + i);
    }
    int j;
    HotChatManager localHotChatManager;
    HotChatInfo localHotChatInfo;
    if (i == 3)
    {
      j = paramArrayOfByte[10];
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j);
      }
      localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      localHotChatInfo = localHotChatManager.a(String.valueOf(l));
      if (j == 3)
      {
        int k = paramArrayOfByte[11];
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j + ", cSubOp2 = " + k);
        }
        switch (k)
        {
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                  } while (localHotChatInfo == null);
                  localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
                  HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371494), true);
                  ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
                  return;
                } while (localHotChatInfo == null);
                localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371492), true);
                ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                return;
              } while (localHotChatInfo == null);
              localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
              HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371484), true);
              ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
              return;
              if (j != 2) {
                break;
              }
            } while (localHotChatInfo == null);
            localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY);
            HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371491), false);
            ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY });
            return;
          } while (j != 1);
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        } while (paramArrayOfByte == null);
        paramArrayOfByte.a(l, false);
        return;
      } while (i != 1);
      j = paramArrayOfByte[10];
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j);
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (paramArrayOfByte == null);
    switch (j)
    {
    default: 
      return;
    case 0: 
    case 2: 
      paramArrayOfByte.a(l, true);
      return;
    case 1: 
      paramArrayOfByte.b(l, false);
      return;
    }
    paramArrayOfByte.b(l, true);
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcReqPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    try
    {
      paramArrayOfByte = (submsgtype0x44.MsgBody)new submsgtype0x44.MsgBody().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
      if (QLog.isColorLevel())
      {
        if ((paramArrayOfByte.msg_friend_msg_sync.has()) && (paramArrayOfByte.msg_friend_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
        }
        if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
        }
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
        }
      }
      if (!paramArrayOfByte.msg_friend_msg_sync.has()) {
        break label1255;
      }
    }
    int i;
    label349:
    Object localObject2;
    Object localObject1;
    if (paramArrayOfByte.msg_friend_msg_sync.get() != null) {
      if (a(paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get()))
      {
        i = 1;
        if (c(paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get()))
        {
          localObject2 = String.valueOf(paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (StringUtil.d((String)localObject2)))
          {
            localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
            j = paramArrayOfByte.msg_friend_msg_sync.uint32_sourceid.get();
            localObject2 = String.valueOf(localObject2);
            if (!((FriendListHandler)localObject1).a((String)localObject2, 0, j, null, false, false, -1L)) {
              ((FriendListHandler)localObject1).a((String)localObject2);
            }
          }
        }
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get());
        }
      }
    }
    label598:
    label1199:
    label1255:
    for (int j = i;; j = 0)
    {
      if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
        if (a(paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get()), paramArrayOfByte.msg_group_msg_sync.uint64_msg_seq.get(), true);
          i = 1;
          if (b(paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get()))
          {
            localObject1 = String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            Object localObject3 = SystemMsgUtils.a(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (StringUtil.d((String)localObject1)))
            {
              TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              if (localTroopManager.a((String)localObject1) == null)
              {
                localObject2 = new TroopInfo();
                ((TroopInfo)localObject2).troopuin = ((String)localObject1);
                ((TroopInfo)localObject2).troopcode = ((String)localObject3);
                localTroopManager.a((TroopInfo)localObject2);
                localObject3 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                ((TroopHandler)localObject3).b(((TroopInfo)localObject2).troopuin, false);
                ((TroopHandler)localObject3).a(((TroopInfo)localObject2).troopuin, (byte)1, ((TroopInfo)localObject2).dwTimeStamp, 0);
                ((TroopHandler)localObject3).a(5, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), localObject1 });
              }
              a(2001, true, null);
            }
          }
          k = i;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get());
          }
        }
      }
      for (int k = i;; k = 0)
      {
        if ((j != 0) || (k != 0))
        {
          if ((j == 0) || (k == 0)) {
            break label1199;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(4);
        }
        for (;;)
        {
          if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null))
          {
            if (a(paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get()))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.aC, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
              GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
              localObject1 = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.av, 0, true, true);
              ((NewFriendManager)localObject1).a();
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
            }
          }
          if ((paramArrayOfByte.msg_modify_msg_sync.has()) && (paramArrayOfByte.msg_modify_msg_sync.get() != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().b(2);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =" + paramArrayOfByte.msg_modify_msg_sync.get());
            }
          }
          if ((!paramArrayOfByte.msg_waiting_msg_sync.has()) || (paramArrayOfByte.msg_waiting_msg_sync.get() == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().b(2);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =" + paramArrayOfByte.msg_waiting_msg_sync.get());
          return;
          if (j != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
          } else if (k != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
          }
        }
        i = 0;
        break label598;
      }
      i = 0;
      break label349;
    }
  }
  
  protected void a(String paramString, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "handlePttHotChatPushMsg, msg, troopUin = " + paramString);
    }
    if ((paramMsg == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a("hctopic_processor").a(1001, new Object[] { paramMsg, paramString });
  }
  
  protected void a(String paramString, oidb_0xa88.NoticeBody paramNoticeBody)
  {
    if ((paramNoticeBody == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = String.valueOf(paramNoticeBody.uint64_guest_uin.get());
    int k = paramNoticeBody.uint32_service_type.get();
    int m = paramNoticeBody.uint32_seat_op.get();
    int n = paramNoticeBody.uint32_seat_id.get();
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "handlePttHotChatPushMsg", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), str });
    }
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    HotChatInfo localHotChatInfo = localHotChatManager.a(paramString);
    if ((localHotChatInfo != null) && (localHotChatInfo.ownerUin != null) && (localHotChatInfo.ownerUin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
    List localList;
    int j;
    for (int i = 1;; i = 0)
    {
      if (!paramNoticeBody.rpt_msg_seats_info.has()) {
        break label656;
      }
      localList = HCSeatInfo.convert(paramNoticeBody.rpt_msg_seats_info.get());
      if ((localList == null) || (localList.size() <= 0) || (i != 0) || (!paramNoticeBody.uint64_white_uin.has())) {
        break;
      }
      paramNoticeBody = paramNoticeBody.uint64_white_uin.get();
      if ((paramNoticeBody == null) || (paramNoticeBody.size() <= 0)) {
        break;
      }
      paramNoticeBody = paramNoticeBody.iterator();
      do
      {
        if (!paramNoticeBody.hasNext()) {
          break;
        }
      } while (((Long)paramNoticeBody.next()).longValue() != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      j = 0;
      label271:
      if (j == 0) {
        break;
      }
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "needDeal", new Object[0]);
      }
      paramNoticeBody = localList.iterator();
      while (paramNoticeBody.hasNext())
      {
        HCSeatInfo localHCSeatInfo = (HCSeatInfo)paramNoticeBody.next();
        if ((localHCSeatInfo != null) && (localHCSeatInfo.guestUin == 0L) && (localHCSeatInfo.seatFlag == 0))
        {
          localHCSeatInfo.seatFlag = 1;
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("PttShow", "needDeal", new Object[] { Integer.valueOf(localHCSeatInfo.seatID) });
          }
        }
      }
    }
    label640:
    label656:
    for (paramNoticeBody = localList;; paramNoticeBody = null)
    {
      if ((localHotChatInfo != null) && (paramNoticeBody != null))
      {
        localHotChatInfo.updateHCSeatInfoList(paramNoticeBody);
        paramNoticeBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localHotChatInfo.getStatus() == 1001) {
          break label640;
        }
        paramNoticeBody.b(localHotChatInfo);
      }
      for (;;)
      {
        paramNoticeBody.a();
        if ((k == 4) && (i == 0)) {
          localHotChatManager.a(true).b(paramString, n);
        }
        if (((k == 3) || (k == 4)) && (i == 0) && (str != null) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          localHotChatManager.a(true).a(paramString, k);
        }
        ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1045, true, new Object[] { Boolean.valueOf(true), Integer.valueOf(k), paramString, str, Integer.valueOf(0), null, Integer.valueOf(n), Integer.valueOf(m) });
        if (!QLog.isColorLevel()) {
          break;
        }
        NearbyUtils.a("PttShow", new Object[] { "handlePttHotChatPushMsg", Integer.valueOf(k), str, Integer.valueOf(n), Integer.valueOf(m) });
        return;
        paramNoticeBody.a(localHotChatInfo);
      }
      j = 1;
      break label271;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        ConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localArrayList);
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg)
  {
    byte[] arrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv msg0x210.Submsgtype0x51");
    }
    if (paramMsgType0x210.sub_msg_type.get() != 81) {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush submsgtype != 0x51");
      }
    }
    do
    {
      do
      {
        return;
        if (paramMsgType0x210.msg_content != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush msg_content is null");
      return;
      paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
      if (paramMsgType0x210 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush decode ox210Stream is null");
    return;
    new SubMsgType0x51.MsgBody();
    for (;;)
    {
      try
      {
        SubMsgType0x51.MsgBody localMsgBody = new SubMsgType0x51.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210);
        if (!localMsgBody.bytes_qrsig_url.has()) {
          break label348;
        }
        paramMsgType0x210 = new String(localMsgBody.bytes_qrsig_url.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint1.has()) {
          break label343;
        }
        paramMsg = new String(localMsgBody.bytes_hint1.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint2.has()) {
          break label338;
        }
        str = new String(localMsgBody.bytes_hint2.get().toByteArray(), "utf-8");
        if (localMsgBody.bytes_login_conf.has()) {
          arrayOfByte = localMsgBody.bytes_login_conf.get().toByteArray();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv devlock quicklogin push qrcode=" + paramMsgType0x210 + " maintip=" + paramMsg + " smalltip" + str);
        }
        EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, paramMsg, str, arrayOfByte);
        return;
      }
      catch (Exception paramMsgType0x210) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
      return;
      label338:
      String str = null;
      continue;
      label343:
      paramMsg = null;
      continue;
      label348:
      paramMsgType0x210 = null;
    }
  }
  
  public void a(SubMsgType0xa8.MsgBody paramMsgBody)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, "handlePullActivePushMsg, isNeedNotifyActivePush is false");
      }
    }
    Object localObject2;
    Object localObject1;
    int i;
    do
    {
      do
      {
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
      } while (!paramMsgBody.bytes_msg_summary.has());
      localObject2 = paramMsgBody.bytes_msg_summary.get().toStringUtf8();
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", MainFragment.a);
      ((Intent)localObject1).putExtra("fragment_id", 1);
      ((Intent)localObject1).setFlags(335544320);
      i = paramMsgBody.uint32_action_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionType: %d, brief: %s", new Object[] { Integer.valueOf(i), localObject2 }));
      }
      if (i != 1) {
        break;
      }
    } while (!paramMsgBody.uint32_action_subType.has());
    int j = paramMsgBody.uint32_action_subType.get();
    ((Intent)localObject1).putExtra("extra_pull_active_push_type", i);
    ((Intent)localObject1).putExtra("extra_pull_active_push_subtype", j);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionSubType: %d", new Object[] { Integer.valueOf(j) }));
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra(PullActiveManager.b, (String)localObject2);
      ((Intent)localObject1).putExtra("activepull_push_flag", true);
      paramMsgBody = PullActiveManager.jdField_a_of_type_JavaLangString;
      Bitmap localBitmap = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130838592);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "CMD_SHOW_NOTIFIYCATION");
      localToServiceMsg.extraData.putStringArray("cmds", new String[] { localObject2, paramMsgBody, localObject2 });
      localToServiceMsg.extraData.putParcelable("intent", (Parcelable)localObject1);
      localToServiceMsg.extraData.putParcelable("bitmap", localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localToServiceMsg);
      paramMsgBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getBaseContext();
      if (!QQUtils.a(paramMsgBody)) {
        break;
      }
      localObject2 = (PullActiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(144);
      ((PullActiveManager)localObject2).a((Intent)localObject1);
      localObject1 = (QQLSRecentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(71);
      if (SettingCloneUtil.readValue(paramMsgBody, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMsgBody.getString(2131369618), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
        }
        ((QQLSRecentManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.aW, 9653, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((PullActiveManager)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush);
      return;
      if (i == 2)
      {
        if (!paramMsgBody.bytes_extend_content.has()) {
          break;
        }
        paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
        ((Intent)localObject1).putExtra("extra_pull_active_push_type", i);
        ((Intent)localObject1).putExtra("extra_pull_active_push_url", paramMsgBody);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: url: %s", new Object[] { paramMsgBody }));
        continue;
      }
      if ((i != 3) || (!paramMsgBody.bytes_extend_content.has())) {
        break;
      }
      paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
      ((Intent)localObject1).putExtra("open_chatfragment", true);
      ((Intent)localObject1).putExtra("uin", paramMsgBody);
      ((Intent)localObject1).putExtra("uintype", 1008);
      ((Intent)localObject1).putExtra("isforceRequestDetail", true);
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: public account uin: %s", new Object[] { paramMsgBody }));
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new SubMsgType0x27.MsgBody();
    FriendsManager localFriendsManager;
    TroopManager localTroopManager;
    PublicAccountDataManager localPublicAccountDataManager;
    PstnManager localPstnManager;
    ApolloManager localApolloManager;
    int j;
    Friends[] arrayOfFriends;
    ArrayList localArrayList;
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              try
              {
                paramArrayOfByte = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
                if (paramArrayOfByte == null) {
                  break;
                }
                localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
                localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
                localPstnManager = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
                localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
                j = 0;
                paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get();
                arrayOfFriends = new Friends[paramArrayOfByte.size()];
                localArrayList = new ArrayList();
                Iterator localIterator = paramArrayOfByte.iterator();
                if (!localIterator.hasNext()) {
                  break label7565;
                }
                paramArrayOfByte = (SubMsgType0x27.ForwardBody)localIterator.next();
                if ((paramArrayOfByte.uint32_notify_type.has()) && (paramArrayOfByte.uint32_notify_type.get() == 1))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("cardpush", 2, "push a no content，如何处理？");
                  continue;
                }
                if (!paramArrayOfByte.uint32_op_type.has()) {
                  continue;
                }
              }
              catch (Exception paramArrayOfByte)
              {
                paramArrayOfByte.printStackTrace();
                return;
              }
              switch (paramArrayOfByte.uint32_op_type.get())
              {
              case 60: 
              default: 
                break;
              case 0: 
                if (paramArrayOfByte.msg_add_group.has())
                {
                  localObject1 = (SubMsgType0x27.AddGroup)paramArrayOfByte.msg_add_group.get();
                  paramArrayOfByte = new Groups();
                  if (((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.has()) {
                    paramArrayOfByte.group_id = ((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.get();
                  }
                  if (((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.has()) {
                    paramArrayOfByte.group_name = ((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.get().toStringUtf8();
                  }
                  if (((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.has()) {
                    paramArrayOfByte.seqid = ((byte)((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.get());
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a AddGroup  = id:" + paramArrayOfByte.group_id + " name : " + paramArrayOfByte.group_name + " sortid: " + paramArrayOfByte.seqid);
                  }
                  localFriendsManager.a(paramArrayOfByte);
                  localObject1 = new AddGroupResp();
                  ((AddGroupResp)localObject1).dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                  ((AddGroupResp)localObject1).dwSequence = paramArrayOfByte.seqid;
                  ((AddGroupResp)localObject1).cGroupId = ((byte)paramArrayOfByte.group_id);
                  ((AddGroupResp)localObject1).cSortId = paramArrayOfByte.seqid;
                  paramArrayOfByte = new GroupActionResp(0, "", (AddGroupResp)localObject1);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(18, true, paramArrayOfByte);
                }
                break;
              case 1: 
                if (paramArrayOfByte.msg_del_group.has())
                {
                  localObject1 = (SubMsgType0x27.DelGroup)paramArrayOfByte.msg_del_group.get();
                  if (((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.has())
                  {
                    localObject4 = localFriendsManager.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
                    if (QLog.isColorLevel()) {
                      QLog.d("cardpush", 2, "push a DelGroup  = id:" + ((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    }
                    paramArrayOfByte = new DelGroupResp();
                    paramArrayOfByte.dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                    paramArrayOfByte.dwSequence = ((Groups)localObject4).seqid;
                    paramArrayOfByte.cGroupid = ((byte)((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    localObject1 = new GroupActionResp(0, "", paramArrayOfByte);
                    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramArrayOfByte, true, (GroupActionResp)localObject1);
                  }
                }
                break;
              }
            }
          } while (!paramArrayOfByte.msg_mod_group_name.has());
          localObject1 = (SubMsgType0x27.ModGroupName)paramArrayOfByte.msg_mod_group_name.get();
        } while ((!((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.has()) || (!((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.has()));
        i = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
        localObject4 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
        paramArrayOfByte = localFriendsManager.a(String.valueOf(i));
        if (paramArrayOfByte != null) {}
        for (paramArrayOfByte.group_name = ((String)localObject4);; paramArrayOfByte.group_name = ((String)localObject4))
        {
          localFriendsManager.a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupName  = id:" + ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get() + " name:" + ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          }
          paramArrayOfByte = new RenameGroupResp();
          paramArrayOfByte.dwToUin = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          i = (byte)((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          paramArrayOfByte.sGroupName = new String(((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          paramArrayOfByte = new GroupActionResp(0, "", paramArrayOfByte);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(19, true, paramArrayOfByte);
          break;
          paramArrayOfByte = new Groups();
          paramArrayOfByte.group_id = i;
        }
      } while (!paramArrayOfByte.msg_mod_group_sort.has());
      localObject4 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
    } while (localObject4 == null);
    paramArrayOfByte = new byte[((List)localObject4).size()];
    localObject1 = new byte[((List)localObject4).size()];
    Object localObject4 = ((List)localObject4).iterator();
    int i = 0;
    label1192:
    Object localObject5;
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = (SubMsgType0x27.GroupSort)((Iterator)localObject4).next();
      if ((!((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.has())) {
        break label7612;
      }
      paramArrayOfByte[i] = ((byte)((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.get());
      localObject1[i] = ((byte)((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.get());
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.get());
      }
      i += 1;
    }
    label1392:
    label5023:
    label5494:
    label5997:
    label7565:
    label7612:
    for (;;)
    {
      break label1192;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(22, true, null);
      localFriendsManager.a(paramArrayOfByte, (byte[])localObject1);
      break;
      if (!paramArrayOfByte.msg_mod_friend_group.has()) {
        break;
      }
      paramArrayOfByte = ((SubMsgType0x27.ModFriendGroup)paramArrayOfByte.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte.iterator();
      do
      {
        if (!paramArrayOfByte.hasNext()) {
          break;
        }
        localObject1 = (SubMsgType0x27.FriendGroup)paramArrayOfByte.next();
      } while ((!((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.has()) || (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get().size() <= 0));
      long l1 = ((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.get();
      int k = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get(0)).intValue();
      if (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get().size() > 0) {}
      for (i = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get(0)).intValue();; i = 0)
      {
        localFriendsManager.a(l1 + "", k);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + k);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(9, true, new Object[] { l1 + "", Byte.valueOf((byte)k), Byte.valueOf((byte)i) });
        break label1392;
        if (!paramArrayOfByte.msg_del_friend.has()) {
          break;
        }
        paramArrayOfByte = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get().iterator();
        while (paramArrayOfByte.hasNext())
        {
          l1 = ((Long)paramArrayOfByte.next()).longValue();
          localFriendsManager.d(l1 + "");
          localPublicAccountDataManager.b(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(15, true, Long.valueOf(l1));
        }
        paramArrayOfByte = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte.b();
        break;
        Object localObject7;
        Object localObject8;
        if (paramArrayOfByte.msg_mod_friend_rings.has())
        {
          localObject1 = ((SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
            localObject5 = ((SubMsgType0x27.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject7 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject5).next();
              i = ((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get();
              if (i == 13569)
              {
                localObject6 = localTroopManager.b(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject4).uint64_uin.get()).toString());
                i = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().size();
                if (i == 0)
                {
                  if (localTroopManager.b((String)localObject6)) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22).a(18, true, new Object[] { localObject6, Integer.valueOf(1), Integer.valueOf(0), null });
                  }
                }
                else if (i >= 4)
                {
                  localObject7 = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toByteArray();
                  localObject8 = new byte[i];
                  System.arraycopy(localObject7, 0, localObject8, 0, 4);
                  if (localTroopManager.a((String)localObject6, MessageHandlerUtils.a((byte[])localObject8))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22).a(18, true, new Object[] { localObject6, Integer.valueOf(0), Integer.valueOf(0), null });
                  }
                }
              }
              else if (i == 13571)
              {
                l1 = ((SubMsgType0x27.SnsUpateBuffer)localObject4).uint64_uin.get();
                l2 = ((SubMsgType0x27.SnsUpateBuffer)localObject4).uint64_code.get();
                Long.valueOf(l1).toString();
                localObject6 = String.valueOf(Long.valueOf(l2));
                i = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().size();
                localObject7 = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toByteArray();
                if (i >= 6)
                {
                  if ((localObject7[0] != 1) || (localObject7[0] == 0)) {}
                  i = localObject7[1];
                  if (i == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                    }
                    localObject8 = new byte[4];
                    System.arraycopy(localObject7, 2, localObject8, 0, 4);
                    if (localTroopManager.b((String)localObject6, MessageHandlerUtils.a((byte[])localObject8))) {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(54, true, new Object[] { localObject6, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                    }
                  }
                  if ((i == 0) && (localTroopManager.d((String)localObject6))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(54, true, new Object[] { localObject6, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                  }
                }
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_friend_rings.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get();
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_general_infos.has())) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_sns_general_infos.get();
        localObject4 = new HashMap();
        localObject5 = paramArrayOfByte.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          paramArrayOfByte = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject5).next();
          if ((paramArrayOfByte != null) && (paramArrayOfByte.uint64_uin.has()) && (paramArrayOfByte.rpt_msg_sns_update_item.has()))
          {
            l1 = paramArrayOfByte.uint64_uin.get();
            localObject6 = String.valueOf(l1);
            localObject7 = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject7).hasNext())
            {
              localObject8 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject7).next();
              if ((localObject8 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject8).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject8).bytes_value.has()))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject8).uint32_update_sns_type.get() == 13568) {
                  QvipSpecialCareManager.a((String)localObject6, ((SubMsgType0x27.SnsUpdateItem)localObject8).bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
                localObject1 = (SpecialCareInfo)((HashMap)localObject4).get(localObject6);
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  localObject1 = localFriendsManager.a(String.valueOf(l1));
                  paramArrayOfByte = (byte[])localObject1;
                  if (localObject1 == null)
                  {
                    paramArrayOfByte = new SpecialCareInfo();
                    paramArrayOfByte.uin = String.valueOf(String.valueOf(l1));
                  }
                  ((HashMap)localObject4).put(paramArrayOfByte.uin, paramArrayOfByte);
                }
                i = ((SubMsgType0x27.SnsUpdateItem)localObject8).uint32_update_sns_type.get();
                localObject1 = ((SubMsgType0x27.SnsUpdateItem)localObject8).bytes_value.get().toStringUtf8();
                FriendListHandler.a(paramArrayOfByte, i, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + paramArrayOfByte.uin + ", itemtype=" + i + ",itemVal=" + (String)localObject1);
                }
              }
            }
          }
        }
        paramArrayOfByte = ((HashMap)localObject4).entrySet().iterator();
        localObject1 = new ArrayList();
        while (paramArrayOfByte.hasNext())
        {
          localObject4 = (SpecialCareInfo)((Map.Entry)paramArrayOfByte.next()).getValue();
          if ((localObject4 != null) && ((((SpecialCareInfo)localObject4).getStatus() != 1000) || (((SpecialCareInfo)localObject4).globalSwitch != 0))) {
            ((List)localObject1).add(localObject4);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + ((List)localObject1).size());
        }
        localFriendsManager.c((List)localObject1);
        if (((List)localObject1).size() <= 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(99, true, new Object[] { Boolean.valueOf(true), localObject1 });
        break;
        if (!paramArrayOfByte.msg_mod_friend_flag.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.SnsUpdateFlag)paramArrayOfByte.msg_mod_friend_flag.get();
        if (!paramArrayOfByte.rpt_msg_update_sns_flag.has()) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_update_sns_flag.get().iterator();
        do
        {
          do
          {
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            localObject1 = (SubMsgType0x27.SnsUpdateOneFlag)paramArrayOfByte.next();
            l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64__uin.get();
            i = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint32_flag.get();
            l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + i + " id:" + l2);
            }
          } while (l2 != 4051L);
          localObject1 = localFriendsManager.c(String.valueOf(l1));
        } while (localObject1 == null);
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((Friends)localObject1).setShieldFlag(bool);
          localFriendsManager.a((Friends)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
          break;
        }
        if (!paramArrayOfByte.msg_mod_profile.has()) {
          break;
        }
        j = a(paramArrayOfByte, localFriendsManager, localTroopManager, localPstnManager, localApolloManager, arrayOfFriends, j);
        break;
        if (!paramArrayOfByte.msg_mod_custom_face.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((!((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.has()) || (!((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.has())) {
          break;
        }
        paramArrayOfByte = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() == 0)
        {
          l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.get();
          localObject1 = Long.toString(l1);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l1);
          }
          paramArrayOfByte.c((String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, localObject1);
          break;
        }
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() != 1) {
          break;
        }
        l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_group_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l1);
        }
        paramArrayOfByte.d(Long.toString(l1));
        break;
        if (!paramArrayOfByte.msg_daren_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.DaRenNotify)paramArrayOfByte.msg_daren_notify.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        i = paramArrayOfByte.uint32_login_days.get();
        k = paramArrayOfByte.uint32_days.get();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1)))
        {
          paramArrayOfByte = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((i != paramArrayOfByte.lLoginDays) || (k != paramArrayOfByte.lQQMasterLogindays))
          {
            paramArrayOfByte.lLoginDays = i;
            paramArrayOfByte.lQQMasterLogindays = k;
            localFriendsManager.a(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
          }
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "daren notify received local data logindays=" + paramArrayOfByte.lLoginDays + ";days=" + paramArrayOfByte.lQQMasterLogindays);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cardpush", 2, "daren notify received uin=" + l1 + ";logindays=" + i + ";days=" + k);
        break;
        if (!paramArrayOfByte.msg_mod_friend_remark.has()) {
          break;
        }
        paramArrayOfByte = ((SubMsgType0x27.ModFriendRemark)paramArrayOfByte.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (SubMsgType0x27.FriendRemark)paramArrayOfByte.next();
          if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.has()) {
            if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.get() == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "备注 = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8());
              }
              localFriendsManager.b(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8());
              localObject4 = localFriendsManager.a(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "");
              if (localObject4 != null)
              {
                localObject5 = ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8();
                if (!((String)localObject5).equals(((Card)localObject4).strReMark))
                {
                  ((Card)localObject4).strReMark = ((String)localObject5);
                  localFriendsManager.a((Card)localObject4);
                }
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get()));
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(27, true, new Object[] { ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
            }
            else if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.get() == 1)
            {
              if (((SubMsgType0x27.FriendRemark)localObject1).uint64_group_code.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remarkuin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + " troopcode = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_group_code.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remark uin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_rich_long_nick.has()) {
          break;
        }
        Object localObject6 = (SubMsgType0x27.ModLongNick)paramArrayOfByte.msg_mod_rich_long_nick.get();
        localObject4 = Long.toString(((SubMsgType0x27.ModLongNick)localObject6).uint64_uin.get());
        paramArrayOfByte = ByteBuffer.wrap(((SubMsgType0x27.ModLongNick)localObject6).bytes_value.get().toByteArray());
        l1 = paramArrayOfByte.getLong();
        localObject5 = new byte[paramArrayOfByte.remaining()];
        paramArrayOfByte.get((byte[])localObject5);
        localObject1 = localFriendsManager.a((String)localObject4);
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1 == null)
        {
          paramArrayOfByte = new ExtensionInfo();
          paramArrayOfByte.uin = ((String)localObject4);
        }
        paramArrayOfByte.setRichBuffer((byte[])localObject5, l1);
        paramArrayOfByte.isAdded2C2C = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4, paramArrayOfByte.getRichStatus());
        localFriendsManager.a(paramArrayOfByte);
        paramArrayOfByte = localFriendsManager.a(((SubMsgType0x27.ModLongNick)localObject6).uint64_uin.get() + "");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.vRichSign = ((byte[])localObject5);
          paramArrayOfByte.lSignModifyTime = l1;
          localFriendsManager.a(paramArrayOfByte);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, localObject4);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(2, true, new String[] { localObject4 });
        break;
        if (!paramArrayOfByte.msg_mod_group_profile.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModGroupProfile)paramArrayOfByte.msg_mod_group_profile.get();
        if (!((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_code.has()) {
          break;
        }
        l1 = ((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_uin.get();
        long l2 = ((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_code.get();
        paramArrayOfByte = localFriendsManager.a();
        for (;;)
        {
          try
          {
            paramArrayOfByte.a();
            localObject1 = ((SubMsgType0x27.ModGroupProfile)localObject1).rpt_msg_group_profile_infos.get().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label5023;
            }
            localObject4 = (SubMsgType0x27.GroupProfileInfo)((Iterator)localObject1).next();
            if ((!((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.has()) || (!((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.has())) {
              continue;
            }
            if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8());
              }
              localObject5 = localTroopManager.a(l2 + "");
              if (localObject5 == null) {
                continue;
              }
              ((TroopInfo)localObject5).troopname = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8();
              localTroopManager.b((TroopInfo)localObject5);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(1, false, null);
              continue;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            paramArrayOfByte.b();
            break;
            if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 2)
            {
              localObject4 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get();
              if ((localObject4 == null) || (((ByteStringMicro)localObject4).size() != 2)) {
                continue;
              }
              i = ((ByteStringMicro)localObject4).byteAt(0);
              short s = (short)(((ByteStringMicro)localObject4).byteAt(1) | i << 8);
              localObject4 = localTroopManager.a(l1 + "");
              ((TroopInfo)localObject4).troopface = s;
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
              }
              localTroopManager.b((TroopInfo)localObject4);
              ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(l1 + "");
              continue;
            }
          }
          finally
          {
            paramArrayOfByte.b();
          }
          if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 3)
          {
            localObject4 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange:" + l1 + "," + l2 + "," + (String)localObject4);
            }
            localObject5 = localTroopManager.a(l2 + "");
            if (localObject5 != null)
            {
              ((TroopInfo)localObject5).troopCreditLevel = Long.valueOf((String)localObject4).longValue();
              localTroopManager.b((TroopInfo)localObject5);
              if (QLog.isColorLevel()) {
                QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange, save");
              }
            }
          }
        }
        paramArrayOfByte.c();
        paramArrayOfByte.b();
        break;
        if (!paramArrayOfByte.msg_mod_group_member_profile.has()) {
          break;
        }
        Object localObject3 = (SubMsgType0x27.ModGroupMemberProfile)paramArrayOfByte.msg_mod_group_member_profile.get();
        if ((!((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_code.has()) || (!((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_uin.has())) {
          break;
        }
        l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_uin.get();
        l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_code.get();
        long l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_uin.get();
        paramArrayOfByte = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2 + "", l3 + "");
        localObject3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).rpt_msg_group_member_profile_infos.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject3).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() != 1) {
              break label5494;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size());
            }
            QQProfileItem.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size());
            localTroopManager.a(l1 + "", l3 + "", ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8(), -100, null, null, -100, -100, -100, -100L, -100L);
            if (paramArrayOfByte != null) {
              paramArrayOfByte.name = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
            }
          }
          for (;;)
          {
            if (paramArrayOfByte == null) {
              break label5997;
            }
            DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).add(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(16, true, localObject4);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(10, true, new Object[] { localObject4, Boolean.valueOf(true) });
            break;
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 2)
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size() == 1)
              {
                byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().byteAt(0);
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b);
                }
                localTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b, -100, -100L, -100L);
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.sex = b;
                }
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 3)
            {
              localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 3--phone = " + (String)localObject4);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.tel = ((String)localObject4);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 4)
            {
              localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 4--email= " + (String)localObject4);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.email = ((String)localObject4);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 5)
            {
              localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 5--remark= " + (String)localObject4);
              }
              ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(l1 + "", l3 + "", null, -100, null, (String)localObject4, -100, -100, -100, -100L, -100L);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.memo = ((String)localObject4);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 6)
            {
              localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 6--job= " + (String)localObject4);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.job = ((String)localObject4);
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_appointment_notify.has()) {
          break;
        }
        localObject6 = (SubMsgType0x27.AppointmentNotify)paramArrayOfByte.msg_appointment_notify.get();
        if (!((SubMsgType0x27.AppointmentNotify)localObject6).uint32_notifytype.has()) {
          break;
        }
        l1 = ((SubMsgType0x27.AppointmentNotify)localObject6).uint32_notifytype.get();
        if ((l1 == 2L) || (l1 == 4L) || (l1 == 5L) || ((l1 == 6L) && (((SubMsgType0x27.AppointmentNotify)localObject6).bytes_feed_event_info.has())))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((SubMsgType0x27.AppointmentNotify)localObject6);
          break;
        }
        if (((l1 != 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject6).uint64_from_uin.has())) {
          break;
        }
        l2 = ((SubMsgType0x27.AppointmentNotify)localObject6).uint64_from_uin.get();
        localObject3 = null;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject5 = Long.toString(l2);
        if (l1 == 0L) {}
        for (paramArrayOfByte = (byte[])localObject4;; paramArrayOfByte = (byte[])localObject5)
        {
          if (((SubMsgType0x27.AppointmentNotify)localObject6).str_tips_content.has()) {
            localObject3 = ((SubMsgType0x27.AppointmentNotify)localObject6).str_tips_content.get();
          }
          localObject6 = new ArrayList();
          localObject7 = MessageRecordFactory.a(64512);
          l2 = MessageCache.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handle date push friendUin=" + (String)localObject5 + ",senderUin=" + paramArrayOfByte + ",notifytype=" + l1);
          }
          ((MessageRecord)localObject7).init((String)localObject4, (String)localObject5, paramArrayOfByte, (String)localObject3, l2, 64512, 1010, l2);
          ((MessageRecord)localObject7).isread = false;
          if (l1 == 0L)
          {
            ((MessageRecord)localObject7).issend = 1;
            ((MessageRecord)localObject7).isread = true;
          }
          ((ArrayList)localObject6).add(localObject7);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject7, ((MessageRecord)localObject7).selfuin);
          a("handleMsgType0x210SubMsgType0x27", true, (List)localObject6, false, false);
          break;
          if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject6).bytes_sig.has()))
          {
            paramArrayOfByte = ((SubMsgType0x27.AppointmentNotify)localObject6).bytes_sig.get().toByteArray();
            if (paramArrayOfByte != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().k((String)localObject5, paramArrayOfByte);
            }
          }
        }
        if (!paramArrayOfByte.bytes_redpoint_info.has()) {
          break;
        }
        ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(paramArrayOfByte.bytes_redpoint_info.get().toByteArray());
        break;
        if (!paramArrayOfByte.msg_push_search_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushSearchDev)paramArrayOfByte.msg_push_search_dev.get();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("optype", 200);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject3).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.uint32_dev_time.has()) {
          ((Bundle)localObject3).putInt("devtime", paramArrayOfByte.uint32_dev_time.get());
        }
        if (paramArrayOfByte.uint64_din.has()) {
          ((Bundle)localObject3).putLong("din", paramArrayOfByte.uint64_din.get());
        }
        if (paramArrayOfByte.str_data.has()) {
          ((Bundle)localObject3).putString("data", paramArrayOfByte.str_data.get());
        }
        ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject3);
        break;
        if (!paramArrayOfByte.msg_push_report_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushReportDev)paramArrayOfByte.msg_push_report_dev.get();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("optype", 201);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject3).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.bytes_cookie.has()) {
          ((Bundle)localObject3).putString("cookie", paramArrayOfByte.bytes_cookie.get().toStringUtf8());
        }
        if (paramArrayOfByte.uint32_report_max_num.has()) {
          ((Bundle)localObject3).putInt("count", paramArrayOfByte.uint32_report_max_num.get());
        }
        if (paramArrayOfByte.bytes_sn.has()) {
          ((Bundle)localObject3).putString("sn", paramArrayOfByte.bytes_sn.get().toStringUtf8());
        }
        ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject3);
        break;
        if (!paramArrayOfByte.msg_qq_pay_push.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.QQPayPush)paramArrayOfByte.msg_qq_pay_push.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        bool = paramArrayOfByte.bool_pay_ok.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, " === qq pay push uin: " + l1 + ", isPaySuccess | " + bool);
        }
        ((PstnHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(82)).a(l1, bool);
        break;
        if (!paramArrayOfByte.msg_hot_friend_notify.has()) {
          break;
        }
        localObject4 = (SubMsgType0x27.HotFriendNotify)paramArrayOfByte.msg_hot_friend_notify.get();
        l1 = ((SubMsgType0x27.HotFriendNotify)localObject4).uint64_dst_uin.get();
        localObject3 = localFriendsManager.a(String.valueOf(l1));
        paramArrayOfByte = (byte[])localObject3;
        if (localObject3 == null)
        {
          paramArrayOfByte = new ExtensionInfo();
          paramArrayOfByte.uin = String.valueOf(l1);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" === hotFriend uin: ").append(l1);
        if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_praise_hot_level.has())
        {
          i = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_praise_hot_level.get();
          paramArrayOfByte.praiseHotLevel = i;
          ((StringBuilder)localObject3).append(", praiseHotLevel=").append(i);
          if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_praise_flag.has())
          {
            k = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_praise_flag.get();
            ((StringBuilder)localObject3).append(", praise_flag=").append(k);
            a(1, i, k, String.valueOf(l1));
          }
        }
        if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_praise_hot_days.has())
        {
          i = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_praise_hot_days.get();
          paramArrayOfByte.praiseDays = i;
          ((StringBuilder)localObject3).append(", praiseDays=").append(i);
        }
        if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_chat_hot_level.has())
        {
          i = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_chat_hot_level.get();
          paramArrayOfByte.chatHotLevel = i;
          ((StringBuilder)localObject3).append(", chatHotLevel=").append(i);
          if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_chat_flag.has())
          {
            k = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_chat_flag.get();
            ((StringBuilder)localObject3).append(", chat_flag=").append(k);
            a(2, i, k, String.valueOf(l1));
          }
        }
        if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_chat_hot_days.has())
        {
          i = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_chat_hot_days.get();
          paramArrayOfByte.chatDays = i;
          ((StringBuilder)localObject3).append(", chatDays=").append(i);
        }
        if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_close_level.has())
        {
          i = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_close_level.get();
          paramArrayOfByte.bestIntimacyType = i;
          ((StringBuilder)localObject3).append(", closeLevel=").append(i);
          if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_close_flag.has())
          {
            k = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_close_flag.get();
            ((StringBuilder)localObject3).append(", close_flag=").append(k);
            a(3, i, k, String.valueOf(l1));
          }
        }
        if (((SubMsgType0x27.HotFriendNotify)localObject4).uint32_close_days.has())
        {
          i = ((SubMsgType0x27.HotFriendNotify)localObject4).uint32_close_days.get();
          paramArrayOfByte.bestIntimacyDays = i;
          ((StringBuilder)localObject3).append(", closeDays=").append(i);
        }
        if (QLog.isColorLevel()) {
          QLog.i("HotFriend_onLinePushMessage", 2, ((StringBuilder)localObject3).toString());
        }
        localFriendsManager.a(paramArrayOfByte);
        localArrayList.add(String.valueOf(l1));
        break;
        if (!paramArrayOfByte.msg_new_comein_user_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.NewComeinUserNotify)paramArrayOfByte.msg_new_comein_user_notify.get();
        if (paramArrayOfByte.uint32_msg_type.has()) {}
        for (i = paramArrayOfByte.uint32_msg_type.get();; i = -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "receive msg0x210submsg0x27 face2face add friend push, type:" + i);
          }
          if (i == 1)
          {
            localObject3 = (LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3);
            if (localObject3 == null) {
              break;
            }
            ((LBSHandler)localObject3).a(paramArrayOfByte);
            break;
          }
          if ((i != 2) && (i != 3)) {
            break;
          }
          localObject3 = (NearFieldTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(57);
          if (localObject3 == null) {
            break;
          }
          ((NearFieldTroopHandler)localObject3).a(i, paramArrayOfByte);
          break;
          if (!localArrayList.isEmpty()) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(107, true, localArrayList);
          }
          localFriendsManager.a(arrayOfFriends, j);
          return;
        }
      }
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.cq == 0);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    do
    {
      do
      {
        do
        {
          do
          {
            try
            {
              localMsgBody.mergeFrom(paramArrayOfByte);
              if (!localMsgBody.uint32_sub_cmd.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
                }
                return;
              }
            }
            catch (Exception paramArrayOfByte)
            {
              while (!QLog.isColorLevel()) {}
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
              return;
            }
            if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
            {
              ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramArrayOfByte);
              return;
            }
          } while (localMsgBody.uint32_sub_cmd.get() != 3);
          if ((!localMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
          }
          paramArrayOfByte = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)localMsgBody.msg_subcmd_0x3_push_body.get();
        } while ((!paramArrayOfByte.uint64_conf_uin.has()) || (!paramArrayOfByte.msg_app_tip_notify.has()));
        paramArrayOfByte.uint64_conf_uin.get();
        paramArrayOfByte = (submsgtype0x26.AppTipNotify)paramArrayOfByte.msg_app_tip_notify.get();
      } while (!paramArrayOfByte.bytes_text.has());
      paramArrayOfByte = paramArrayOfByte.bytes_text.get().toByteArray();
    } while (paramArrayOfByte.length <= 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe");
    }
    Object localObject = new SubMsgType0xbe.MsgBody();
    try
    {
      ((SubMsgType0xbe.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : msg has not uint64_group_code");
        }
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : fail to parse submsgtype0xbe.");
      return;
    }
    try
    {
      paramArrayOfByte = new JSONObject();
      if (((SubMsgType0xbe.MsgBody)localObject).uint64_uin.has()) {
        paramArrayOfByte.put("uin", ((SubMsgType0xbe.MsgBody)localObject).uint64_uin.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has()) {
        paramArrayOfByte.put("groupCode", ((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.has()) {
        paramArrayOfByte.put("notifyType", ((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.has()) {
        paramArrayOfByte.put("onlineLevel", ((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.has())
      {
        JSONArray localJSONArray = new JSONArray();
        localObject = ((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          SubMsgType0xbe.Medal localMedal = (SubMsgType0xbe.Medal)((Iterator)localObject).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", localMedal.uint32_id.get());
          localJSONObject.put("level", localMedal.uint32_level.get());
          localJSONObject.put("type", localMedal.uint32_type.get());
          localJSONObject.put("iconUrl", localMedal.str_icon_url.get());
          localJSONObject.put("flashUrl", localMedal.str_flash_url.get());
          localJSONObject.put("name", localMedal.str_name.get());
          localJSONArray.put(localJSONObject);
        }
        paramArrayOfByte.put("medalList", localJSONArray);
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte.toString());
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83");
    }
    Object localObject1 = new SubMsgType0x83.MsgBody();
    do
    {
      try
      {
        ((SubMsgType0x83.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : msg has not uint64_group_id");
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : fail to parse submsgtype0x83.");
        return;
      }
    } while (!((SubMsgType0x83.MsgBody)localObject1).rpt_msg_params.has());
    paramArrayOfByte = ((SubMsgType0x83.MsgBody)localObject1).rpt_msg_params;
    long l1 = -1L;
    if (((SubMsgType0x83.MsgBody)localObject1).uint64_seq.has()) {
      l1 = ((SubMsgType0x83.MsgBody)localObject1).uint64_seq.get();
    }
    long l2 = -1L;
    if (((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.has()) {
      l2 = ((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.get();
    }
    int i = 0;
    label141:
    if (i < paramArrayOfByte.size())
    {
      localObject1 = (SubMsgType0x83.MsgParams)paramArrayOfByte.get(i);
      if ((localObject1 != null) && (((SubMsgType0x83.MsgParams)localObject1).uint32_type.has())) {
        break label183;
      }
    }
    label183:
    int j;
    label420:
    do
    {
      for (;;)
      {
        i += 1;
        break label141;
        break;
        j = ((SubMsgType0x83.MsgParams)localObject1).uint32_type.get();
        Object localObject3;
        int k;
        if ((j >= 2001) && (j <= 3000))
        {
          if ((((SubMsgType0x83.MsgParams)localObject1).str_data.has()) && (((SubMsgType0x83.MsgParams)localObject1).uint64_from_uin.has()) && (((SubMsgType0x83.MsgParams)localObject1).uint64_to_uin.has()))
          {
            localObject3 = ((SubMsgType0x83.MsgParams)localObject1).str_data.get();
            try
            {
              k = new JSONObject((String)localObject3).getInt("count");
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, ((SubMsgType0x83.MsgParams)localObject1).uint64_from_uin.get(), ((SubMsgType0x83.MsgParams)localObject1).uint64_to_uin.get(), k, l1, l2);
            }
            catch (Exception localException1) {}
          }
        }
        else
        {
          if (j != 1005) {
            break label420;
          }
          if ((localException1.str_data.has()) && (localException1.uint64_from_uin.has()) && (localException1.uint64_to_uin.has()))
          {
            localObject3 = localException1.str_data.get();
            try
            {
              localObject3 = new JSONObject((String)localObject3);
              j = ((JSONObject)localObject3).optInt("enable");
              k = ((JSONObject)localObject3).optInt("level");
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localException1.uint32_type.get(), localException1.uint64_from_uin.get(), localException1.uint64_to_uin.get(), j, k, l1, l2);
            }
            catch (Exception localException2) {}
          }
        }
      }
    } while ((j != 1010) || (!localException2.bytes_data.has()));
    Object localObject2 = new String(localException2.bytes_data.get().toByteArray());
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (((JSONObject)localObject2).getInt("sndRank") == 0) {
          break label516;
        }
        j = 1;
        boolean bool = ((JSONObject)localObject2).getBoolean("rank_changed");
        if ((j == 0) || (!bool)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l2);
      }
      catch (Exception localException3) {}
      break;
      label516:
      j = 0;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().j(paramArrayOfByte);
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse start");
    }
    SubMsgType0xb3.PushAddFrdNotify localPushAddFrdNotify;
    MessageHandler localMessageHandler;
    long l2;
    try
    {
      paramArrayOfByte = (SubMsgType0xb3.MsgBody)new SubMsgType0xb3.MsgBody().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msgBody is null.");
        }
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse failed.", paramArrayOfByte);
          }
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte.msg_add_frd_notify.has()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msg_add_frd_notify is null.");
      return;
      localPushAddFrdNotify = (SubMsgType0xb3.PushAddFrdNotify)paramArrayOfByte.msg_add_frd_notify.get();
      localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
      l2 = localPushAddFrdNotify.uint64_fuin.get();
      if (!localPushAddFrdNotify.uint64_fuin_bubble_id.has()) {}
    }
    for (long l1 = localPushAddFrdNotify.uint64_fuin_bubble_id.get();; l1 = -1L)
    {
      paramArrayOfByte = (byte[])localObject;
      if (localPushAddFrdNotify.bytes_wording.has()) {
        paramArrayOfByte = localPushAddFrdNotify.bytes_wording.get().toStringUtf8();
      }
      localMessageHandler.a(String.valueOf(l2), l1, paramArrayOfByte, localPushAddFrdNotify.fixed32_timestamp.get());
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\OnLinePushMessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */