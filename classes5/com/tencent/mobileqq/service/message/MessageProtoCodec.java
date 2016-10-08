package com.tencent.mobileqq.service.message;

import IMMsgBodyPack.SlaveMasterMsg;
import OnlinePushPack.MsgInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.arrange.op.ArrangeHandler;
import com.tencent.av.SharpReport_OffLine;
import com.tencent.av.VideoController;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.hd_video_2.CmdS2CInviteReqBody;
import com.tencent.av.hd_video_2.MsgBody;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.bitapp.BitAppManager;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QPayHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyHandler;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Bomb;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ActionMsgUtil.AppShareCookie;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.qlink.QlinkServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.PttRec;
import mqq.app.AccountNotMatchException;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import msf.msgcomm.msg_comm.PluginInfo;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.AuthTmp;
import msf.msgsvc.msg_svc.BsnsTmp;
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.Dis;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.Grp;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.NearByAssistantTmp;
import msf.msgsvc.msg_svc.NearByDatingTmp;
import msf.msgsvc.msg_svc.PbDeleteMsgReq;
import msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PubGroupTmp;
import msf.msgsvc.msg_svc.PublicPlat;
import msf.msgsvc.msg_svc.QQQueryBusinessTmp;
import msf.msgsvc.msg_svc.RichStatusTmp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import msf.msgsvc.msg_svc.TransMsg;
import msf.msgsvc.msg_svc.WPATmp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.head.ContentHead;
import tencent.im.cs.head.Head;
import tencent.im.cs.head.MsgHead;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.BitAppMsg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.FunFace;
import tencent.im.msg.im_msg_body.FunFace.Bomb;
import tencent.im.msg.im_msg_body.FunFace.Turntable;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msgrevoke.msgrevoke_userdef.UinTypeUserDef;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.MsgInfo;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.PushLostDevFound;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VipInfoNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x7a.submsgtype0x7a.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9d.SubMsgType0x9d.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.DealInviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.InviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.UninviteInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.FailNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.ProgressNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;
import upf;
import upg;
import uph;

public class MessageProtoCodec
{
  public static final int a = 30;
  public static final long a = 4294967295L;
  private static final String jdField_a_of_type_JavaLangString = "Q.msg.MessageHandler";
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new HashMap();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 7: 
    case 9: 
    case 13: 
    default: 
      return 0;
    case 3: 
      return 1000;
    case 6: 
      return 1005;
    case 8: 
      return 1008;
    case 10: 
      return 1006;
    case 5: 
      return 1004;
    case 11: 
      return 1009;
    case 12: 
      return 1001;
    case 4: 
      return 3000;
    case 2: 
      return 1;
    case 14: 
      return 1020;
    case 16: 
      return 1021;
    case 17: 
      return 1022;
    case 18: 
      return 1023;
    case 15: 
      return 1024;
    case 19: 
      return 1010;
    case 20: 
      return 7100;
    case 21: 
      return 1026;
    }
    return 7400;
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    int i;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      im_msg_body.Elem localElem;
      do
      {
        if (!paramMsg.hasNext()) {
          break;
        }
        localElem = (im_msg_body.Elem)paramMsg.next();
      } while ((!localElem.general_flags.has()) || (!((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_diy_text_id.has()));
      j = ((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_diy_text_id.get();
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_BubbleDiyTextID->" + j);
    return j;
    return 0;
  }
  
  private static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList paramArrayList)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k = 0;
    Object localObject1;
    if (k < paramString.length())
    {
      localObject1 = null;
      if (paramArrayList == null) {
        break label894;
      }
      label33:
      if (i >= paramArrayList.size()) {
        break label889;
      }
      localObject1 = (MessageForText.AtTroopMemberInfo)paramArrayList.get(i);
      if ((localObject1 == null) || (!((MessageForText.AtTroopMemberInfo)localObject1).isValid())) {}
    }
    label433:
    label877:
    label884:
    label889:
    label894:
    for (;;)
    {
      int m;
      Object localObject2;
      if ((localObject1 != null) && (((MessageForText.AtTroopMemberInfo)localObject1).startPos <= k))
      {
        m = j;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          m = j + 1;
        }
        localObject2 = a(paramRichText, paramString.substring(((MessageForText.AtTroopMemberInfo)localObject1).startPos, ((MessageForText.AtTroopMemberInfo)localObject1).startPos + ((MessageForText.AtTroopMemberInfo)localObject1).textLen));
        ((MessageForText.AtTroopMemberInfo)localObject1).startPos = 0;
        a((MessageForText.AtTroopMemberInfo)localObject1, (im_msg_body.Elem)localObject2);
        localStringBuilder.delete(0, localStringBuilder.length());
        j = m + 1;
        m = ((MessageForText.AtTroopMemberInfo)localObject1).textLen;
        i += 1;
        k += m - 1;
        k += 1;
        break;
        i += 1;
        break label33;
      }
      int n;
      if ((paramString.charAt(k) == '\024') && (k + 1 < paramString.length()))
      {
        n = j;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          n = j + 1;
        }
        j = paramString.charAt(k + 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + j + ",max len:" + MessageUtils.a.length);
        }
        if ((j >= 0) && (j < MessageUtils.a.length))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + MessageUtils.a[j]);
          }
          localObject1 = new im_msg_body.Face();
          ((im_msg_body.Face)localObject1).index.set(MessageUtils.a[j]);
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).face.set((MessageMicro)localObject1);
          paramRichText.elems.add((MessageMicro)localObject2);
          j = n + 1;
          m = k + 1;
        }
        do
        {
          k = m;
          break;
          m = k;
          j = n;
        } while (k + 4 >= paramString.length());
        localObject1 = new char[4];
        localObject1[3] = paramString.charAt(k + 1);
        localObject1[2] = paramString.charAt(k + 2);
        localObject1[1] = paramString.charAt(k + 3);
        localObject1[0] = paramString.charAt(k + 4);
        j = 0;
        if (j < 4)
        {
          if (localObject1[j] == 'ú') {
            localObject1[j] = 10;
          }
          for (;;)
          {
            j += 1;
            break;
            if (localObject1[j] == 'þ') {
              localObject1[j] = 13;
            }
          }
        }
        localObject2 = EmosmUtils.a((char[])localObject1);
        localObject1 = BaseApplicationImpl.getContext();
        if (Build.VERSION.SDK_INT > 10) {
          j = 4;
        }
      }
      for (localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", j).getString("uin", "");; str = null) {
        for (;;)
        {
          try
          {
            localObject1 = (AppInterface)BaseApplicationImpl.a().getAppRuntime((String)localObject1);
            if (localObject1 == null) {
              break label877;
            }
            localObject1 = (EmoticonManager)((AppInterface)localObject1).getManager(13);
            if (localObject1 == null) {
              break label884;
            }
            localObject1 = ((EmoticonManager)localObject1).a(Integer.toString(localObject2[0]), Integer.toString(localObject2[1]));
            if (localObject1 == null) {
              break label877;
            }
            localObject1 = ((Emoticon)localObject1).character;
            j = localObject2[0];
            m = localObject2[1];
            localObject2 = new im_msg_body.SmallEmoji();
            ((im_msg_body.SmallEmoji)localObject2).packIdSum.set((j << 16) + m);
            im_msg_body.Elem localElem = new im_msg_body.Elem();
            localElem.small_emoji.set((MessageMicro)localObject2);
            paramRichText.elems.add(localElem);
            localObject2 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
            paramRichText.elems.add((MessageMicro)localObject1);
            j = n + 1 + 1;
            m = k + 4;
            break label433;
            j = 0;
          }
          catch (AccountNotMatchException localAccountNotMatchException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "[AccountNotMatchException]," + localAccountNotMatchException.getMessage());
            }
            str = null;
            continue;
          }
          localStringBuilder.append(paramString.charAt(k));
          break;
          i = j;
          if (localStringBuilder.length() > 0)
          {
            a(paramRichText, localStringBuilder.toString());
            i = j + 1;
          }
          return i;
          str = "[小表情]";
        }
      }
      String str = null;
    }
  }
  
  public static long a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys");
    }
    long l2;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
      l2 = 0L;
      return l2;
    }
    long l3 = Long.valueOf(paramMessageHandler.b.a()).longValue();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
    for (long l1 = PkgTools.a(arrayOfByte, 0);; l1 = 0L)
    {
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (localObject != null)
      {
        localObject = ((msg_comm.MsgHead)localObject).group_name.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysnick", 2, "TroopCode:" + l1 + "TroopName:" + (String)localObject);
        }
        paramMessageHandler.c("" + l1, (String)localObject);
      }
      l2 = l1;
      if (paramBoolean1) {
        break;
      }
      l2 = l1;
      if (paramBoolean2) {
        break;
      }
      l2 = l1;
      if (paramBoolean3) {
        break;
      }
      paramMessageHandler.a().a(l3, i, arrayOfByte, l4, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get());
      return l1;
    }
  }
  
  public static long a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    do
    {
      do
      {
        return l1;
        paramMsg = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
      } while (!paramMsg.bytes_reserve.has());
      paramMsg = paramMsg.bytes_reserve.get().toByteArray();
    } while ((paramMsg == null) || (paramMsg.length <= 1));
    int i = paramMsg[0];
    i = 1;
    while (i < paramMsg.length - 1)
    {
      int j = paramMsg[i];
      int k = i + 1;
      i = PkgTools.a(paramMsg, k);
      k += 2;
      long l2 = l1;
      if (j == 3)
      {
        byte[] arrayOfByte = new byte[i];
        PkgTools.a(arrayOfByte, 0, paramMsg, k, i);
        long l3 = PkgTools.a(arrayOfByte, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->decodeC2CMsgPkg_msgTime PTT_ROAM : TimeStamp in d0 :" + l1);
        }
        l2 = l1;
        if (l3 > 0L) {
          l2 = l3;
        }
      }
      i = k + i;
      l1 = l2;
    }
    return l1;
  }
  
  public static Pair a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, String paramString1, String paramString2)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return new Pair(Long.valueOf(0L), Long.valueOf(0L));
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    Object localObject;
    long l1;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      label151:
      if (l1 == 4294967295L) {}
      for (long l2 = paramMessageHandler.b.a().a(paramString1, paramString2);; l2 = -1L)
      {
        return new Pair(Long.valueOf(l1), Long.valueOf(l2));
        if (!((im_msg_body.Elem)localObject).secret_file.has()) {
          break;
        }
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((!((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) || (!((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_color_text_id.has())) {
          break;
        }
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
        break label151;
      }
      l1 = -1L;
    }
  }
  
  public static MessageRecord a(List paramList, byte[] paramArrayOfByte, MessageInfo paramMessageInfo)
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    JSONObject localJSONObject = new JSONObject();
    paramList = paramList.iterator();
    int j = 0;
    int i = 1;
    while (paramList.hasNext())
    {
      Object localObject1 = (MessageRecord)paramList.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      int m;
      int k;
      if (((MessageRecord)localObject1).msgtype == 64536)
      {
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).msg))
        {
          localElem.textMsg.set(((MessageRecord)localObject1).msg);
          m = j;
          k = i;
        }
      }
      else {
        for (;;)
        {
          Object localObject2;
          try
          {
            if (((MessageRecord)localObject1).atInfoList != null)
            {
              m = j;
              k = i;
              if (((MessageRecord)localObject1).atInfoList.size() > 0)
              {
                localObject2 = new JSONArray();
                localObject1 = ((MessageRecord)localObject1).atInfoList.iterator();
                k = 0;
                if (((Iterator)localObject1).hasNext())
                {
                  ((JSONArray)localObject2).put(k, ((MessageForText.AtTroopMemberInfo)((Iterator)localObject1).next()).toJsonObject());
                  k += 1;
                  continue;
                }
                localJSONObject.put("" + i, localObject2);
                k = i + 1;
                m = 1;
              }
            }
            i = m;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            QLog.e("Q.msg.MessageHandler", 1, "disc mixMsg create atInfos error:", localJSONException);
            k = i;
            i = j;
            j = k;
            continue;
          }
          localMsg.elems.get().add(localElem);
          k = j;
          j = i;
          i = k;
          break;
          if (localJSONException.msgtype == 63536)
          {
            localObject2 = new RichMsg.PicRec();
            try
            {
              RichMsg.PicRec localPicRec = (RichMsg.PicRec)((RichMsg.PicRec)localObject2).mergeFrom(localJSONException.msgData);
              localElem.picMsg.set(localPicRec);
              k = i;
              i = j;
              j = k;
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              for (;;)
              {
                localInvalidProtocolBufferMicroException.printStackTrace();
              }
            }
          }
          else if (localInvalidProtocolBufferMicroException.msgtype == 64487)
          {
            try
            {
              MessageForReplyText localMessageForReplyText = (MessageForReplyText)localInvalidProtocolBufferMicroException;
              localObject2 = MessagePkgUtils.a(localMessageForReplyText.mSourceMsgInfo);
              localElem.sourceMsgInfo.set(HexUtil.a((byte[])localObject2));
              if (!TextUtils.isEmpty(localMessageForReplyText.msg)) {
                localElem.textMsg.set(localMessageForReplyText.msg);
              }
              k = i;
              i = j;
              j = k;
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
              }
            }
          }
          else
          {
            k = i;
            i = j;
            j = k;
          }
        }
      }
    }
    paramList = (MessageForMixedMsg)MessageRecordFactory.a(64501);
    paramList.msgtype = 64501;
    paramList.msgData = localMsg.toByteArray();
    if ((paramMessageInfo != null) && (paramMessageInfo.jdField_a_of_type_Int == 3000)) {
      paramList.frienduin = paramMessageInfo.jdField_a_of_type_JavaLangString;
    }
    if (j != 0) {
      paramList.saveExtInfoToExtStr("disc_at_info_list", localJSONObject.toString());
    }
    if (paramArrayOfByte != null) {
      paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a(paramArrayOfByte));
    }
    paramList.parse();
    return paramList;
  }
  
  private static PAMessage a(String paramString)
  {
    paramString = PAMessageUtil.b(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static MessageDecContent a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, int paramInt)
  {
    im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    Long localLong1 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    Long localLong2 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    Object localObject = localLong1.toString();
    String str = paramMessageHandler.b.a();
    if (i == 129)
    {
      paramMsg = (msg_comm.Msg)localObject;
      if (((String)localObject).equals(String.valueOf(localLong2)))
      {
        paramMsg = (msg_comm.Msg)localObject;
        if (((String)localObject).equals(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
          }
          return null;
        }
      }
    }
    else
    {
      if (!str.equals(String.valueOf(localLong1))) {
        break label238;
      }
      paramMsg = String.valueOf(localLong2);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return null;
      label238:
      paramMsg = String.valueOf(localLong1);
      break;
      if (str.equalsIgnoreCase(String.valueOf(localLong1)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
        }
        return null;
      }
      if (paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "recv roam online msg, return null!");
        }
        return null;
      }
      localObject = paramMessageHandler.b.a().a(localMsgBody.msg_content.get().toByteArray());
      if (localObject != null)
      {
        if (!paramMessageHandler.b.a().a((OnlineFileSessionInfo)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
          }
          return null;
        }
        if (!((OnlineFileSessionInfo)localObject).jdField_c_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
          }
          return null;
        }
        paramMessageHandler.b.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2, paramInt);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
        }
        return null;
        localObject = paramMessageHandler.b.a().a(localMsgBody.msg_content.get().toByteArray());
        if (localObject != null)
        {
          if (!paramMessageHandler.b.a().a((OnlineFileSessionInfo)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
            }
            return null;
          }
          paramMessageHandler.b.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2, paramInt);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
          }
          return null;
          localObject = paramMessageHandler.b.a().b(localMsgBody.msg_content.get().toByteArray());
          if (localObject == null) {
            break label640;
          }
          if (!paramMessageHandler.b.a().a((OnlineFileSessionInfo)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
            }
            return null;
          }
          paramMessageHandler.b.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2, paramInt);
        }
      }
    }
    label640:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
    }
    return null;
  }
  
  public static TempSessionInfo a(msg_comm.Msg paramMsg)
  {
    TempSessionInfo localTempSessionInfo = new TempSessionInfo();
    int i = -1;
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    int j;
    int k;
    if (!localC2CTmpMsgHead.c2c_type.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "It doesn't has a c2cType.");
      }
      localTempSessionInfo.jdField_c_of_type_Int = localC2CTmpMsgHead.direction_flag.get();
      j = localC2CTmpMsgHead.c2c_type.get();
      k = localC2CTmpMsgHead.service_type.get();
      switch (k)
      {
      default: 
        label232:
        localTempSessionInfo.jdField_b_of_type_Int = i;
        localTempSessionInfo.jdField_b_of_type_Long = -1L;
        localTempSessionInfo.jdField_c_of_type_Long = -1L;
        switch (k)
        {
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
        paramMsg.append(" c2cType:").append(j).append(" serviceType:").append(k).append("direction_flag:").append(localTempSessionInfo.jdField_c_of_type_Int).append(" info:").append(localTempSessionInfo.toString());
        QLog.d("Q.msg.MessageHandler", 2, paramMsg.toString());
      }
      return localTempSessionInfo;
      if ((localC2CTmpMsgHead.service_type.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "Invalid service type, the pb data has no service type.");
      break;
      i = 1000;
      break label232;
      i = 1004;
      break label232;
      i = 1024;
      if ((!BmqqSegmentUtil.c(String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!BmqqSegmentUtil.c(String.valueOf(paramMsg.msg_head.to_uin.get())))) {
        break label232;
      }
      i = 1025;
      break label232;
      i = 1005;
      break label232;
      i = 1008;
      break label232;
      i = 1006;
      break label232;
      i = 1009;
      break label232;
      i = 1001;
      break label232;
      i = 1020;
      break label232;
      i = 1021;
      break label232;
      i = 1022;
      break label232;
      i = 1023;
      break label232;
      i = 1010;
      break label232;
      i = 7100;
      break label232;
      i = 7400;
      break label232;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_c_of_type_Long = localC2CTmpMsgHead.group_uin.get();
      continue;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_c_of_type_Long = localC2CTmpMsgHead.group_code.get();
      continue;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_c_of_type_Long = localC2CTmpMsgHead.group_uin.get();
    }
  }
  
  public static msg_svc.PbSendMsgReq a(MessageHandler paramMessageHandler, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransMsgContext paramTransMsgContext, long paramLong, int paramInt3)
  {
    if (paramTransMsgContext == null) {
      paramMessageHandler = null;
    }
    do
    {
      return paramMessageHandler;
      int i = (short)(int)paramLong;
      int j = 0xFFFF & i;
      long l = paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createTempSessionSendMsgReq: routingType:13,toUin:" + paramString + ",msgUid:" + (0x200000000000000 | l << 16 | 0xA6) + ",msgSeq:" + paramLong + ",uint32Seq:" + j + ",shortSeq:" + i + ",randomNum:" + paramInt3 + ",msgContext:" + paramTransMsgContext);
      }
      paramMessageHandler = paramMessageHandler.b.a();
      msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
      Object localObject = new msg_svc.Trans0x211();
      ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
      ((msg_svc.Trans0x211)localObject).to_uin.set(Long.valueOf(paramString).longValue());
      if (paramArrayOfByte != null) {
        ((msg_svc.Trans0x211)localObject).sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      ((msg_svc.Trans0x211)localObject).c2c_type.set(paramInt1);
      ((msg_svc.Trans0x211)localObject).service_type.set(paramInt2);
      localRoutingHead.trans_0x211.set((MessageMicro)localObject);
      paramArrayOfByte = new msg_comm.ContentHead();
      paramArrayOfByte.pkg_num.set(1);
      paramArrayOfByte.div_seq.set(i);
      paramArrayOfByte.pkg_index.set(0);
      localObject = new im_msg_body.MsgBody();
      ((im_msg_body.MsgBody)localObject).msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set(paramArrayOfByte);
      paramString.msg_body.set((MessageMicro)localObject);
      paramString.msg_seq.set(j);
      paramString.msg_rand.set(paramInt3);
      paramArrayOfByte = paramMessageHandler.a();
      paramMessageHandler = paramString;
    } while (paramArrayOfByte == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    return paramString;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, msg_comm.AppShareInfo paramAppShareInfo, int paramInt2)
  {
    if ((paramInt1 == 9) || (paramInt1 == 13) || (paramMessageRecord == null)) {
      return null;
    }
    long l = paramMessageRecord.msgUid;
    int k = (short)(int)paramMessageRecord.msgseq;
    int m = MessageUtils.a(l);
    MessageCache localMessageCache = paramQQAppInterface.a();
    msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
    int j = 0;
    int i = j;
    switch (paramInt1)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      return null;
      paramQQAppInterface = new msg_svc.C2C();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.c2c.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.Grp();
      paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.grp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.Grp();
      paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.grp.set(paramQQAppInterface);
      i = 1;
      continue;
      if ((!TextUtils.isEmpty(paramMessageRecord.senderuin)) && (Long.valueOf(paramMessageRecord.senderuin).longValue() != 0L) && (!TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.selfuin)) && (TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.frienduin))) {}
      paramQQAppInterface = new msg_svc.GrpTmp();
      if (TextUtils.isEmpty(paramMessageRecord.senderuin))
      {
        paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.selfuin).longValue());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "createSendRichTextMsgReq, senderuin error, senderuin: " + paramMessageRecord.senderuin + " frienduin: " + paramMessageRecord.frienduin + " msgtype: " + paramMessageRecord.msgtype);
        }
      }
      for (;;)
      {
        paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        localRoutingHead.grp_tmp.set(paramQQAppInterface);
        i = 1;
        break;
        paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      }
      paramQQAppInterface = new msg_svc.Dis();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.dis.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.DisTmp();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.dis_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.b(paramMessageRecord.frienduin);
      Object localObject = new msg_svc.WPATmp();
      ((msg_svc.WPATmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      byte[] arrayOfByte;
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + HexUtil.a(arrayOfByte) + ",length:" + arrayOfByte.length);
        }
        ((msg_svc.WPATmp)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.wpa_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.c(paramMessageRecord.frienduin);
      localObject = new msg_svc.QQQueryBusinessTmp();
      ((msg_svc.QQQueryBusinessTmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + HexUtil.a(arrayOfByte) + ",length:" + arrayOfByte.length);
        }
        ((msg_svc.QQQueryBusinessTmp)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.qq_querybusiness_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      localObject = localMessageCache.d(paramMessageRecord.frienduin);
      paramQQAppInterface = new msg_svc.BusinessWPATmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "conversation------>sig:" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      for (;;)
      {
        localRoutingHead.business_wpa_tmp.set(paramQQAppInterface);
        i = 1;
        break;
        localObject = localMessageCache.e(paramMessageRecord.frienduin);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "conversation------>sigt:" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
          }
          paramQQAppInterface.sigt.set(ByteStringMicro.copyFrom((byte[])localObject));
        }
      }
      paramQQAppInterface = new msg_svc.AddressListTmp();
      paramQQAppInterface.from_phone.set(paramMessageRecord.senderuin);
      paramQQAppInterface.to_phone.set(paramMessageRecord.frienduin);
      localObject = localMessageCache.f(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.address_list.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.a(paramMessageRecord.frienduin);
      localObject = new msg_svc.PublicPlat();
      ((msg_svc.PublicPlat)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        ((msg_svc.PublicPlat)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.public_plat.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.RichStatusTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.j(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.rich_status_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      localObject = new msg_svc.AccostTmp();
      ((msg_svc.AccostTmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1001);
      ((msg_svc.AccostTmp)localObject).reply.set(paramQQAppInterface.hasReply);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "LBSFriend------>reply=" + paramQQAppInterface.hasReply);
      }
      paramQQAppInterface = localMessageCache.k(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "发送附近人临时会消息 有keyLBSFriend------>" + HexUtil.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.AccostTmp)localObject).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      localRoutingHead.accost_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.PubGroupTmp();
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.pub_group_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.BsnsTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.g(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "circleGroup------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.bsns_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.AuthTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.i(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "friendValidation------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.auth_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      localObject = new msg_svc.NearByDatingTmp();
      ((msg_svc.NearByDatingTmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1010);
      ((msg_svc.NearByDatingTmp)localObject).reply.set(paramQQAppInterface.hasReply);
      paramQQAppInterface = localMessageCache.n(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_dating", 4, "发送附近人约会临时会话消息 有keyNearbyDating------>" + HexUtil.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.NearByDatingTmp)localObject).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      localRoutingHead.nearby_dating_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.NearByAssistantTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.m(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_assistant", 4, "发送附近人助手临时会话消息 有NearbyAssistantKey------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.nearby_assistant_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(144);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.l(paramMessageRecord.frienduin);
      if (localObject != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.comm_tmp.set(paramQQAppInterface);
      i = 1;
    }
    paramQQAppInterface = new msg_comm.ContentHead();
    paramQQAppInterface.pkg_num.set(paramMessageRecord.longMsgCount);
    paramQQAppInterface.div_seq.set(paramMessageRecord.longMsgId);
    paramQQAppInterface.pkg_index.set(paramMessageRecord.longMsgIndex);
    paramMessageRecord = new im_msg_body.MsgBody();
    paramMessageRecord.rich_text.set(paramRichText);
    paramRichText = new msg_svc.PbSendMsgReq();
    paramRichText.routing_head.set(localRoutingHead);
    paramRichText.content_head.set(paramQQAppInterface);
    paramRichText.msg_body.set(paramMessageRecord);
    paramRichText.msg_seq.set(k & 0xFFFF);
    paramRichText.msg_rand.set(m);
    if ((paramInt1 != 2) && (paramInt1 != 4) && (paramInt1 != 21))
    {
      paramQQAppInterface = localMessageCache.a();
      if (paramQQAppInterface != null) {
        paramRichText.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
    }
    if (paramAppShareInfo != null) {
      paramRichText.app_share.set(paramAppShareInfo);
    }
    paramRichText.msg_via.set(paramInt2);
    return paramRichText;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong, int paramInt2)
  {
    if (paramTransMsgContext == null) {
      paramQQAppInterface = null;
    }
    label334:
    do
    {
      return paramQQAppInterface;
      int j = (short)(int)paramLong;
      int k = 0xFFFF & j;
      long l;
      msg_svc.RoutingHead localRoutingHead;
      if ((paramInt1 == 9) || (paramInt1 == 13))
      {
        l = 0x200000000000000 | paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length << 16 | 0xA6;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createPbSendMsgReq: routingType:" + paramInt1 + ",toUin:" + paramString + ",msgUid:" + l + ",msgSeq:" + paramLong + ",uint32Seq:" + k + ",shortSeq:" + j + ",randomNum:" + paramInt2 + ",msgContext:" + paramTransMsgContext);
        }
        paramQQAppInterface = paramQQAppInterface.a();
        localRoutingHead = new msg_svc.RoutingHead();
        int i = 0;
        switch (paramInt1)
        {
        default: 
          paramInt1 = i;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label334;
        }
        return null;
        l = 0x100000000000000 | paramInt2;
        break;
        localObject = new msg_svc.TransMsg();
        ((msg_svc.TransMsg)localObject).c2c_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
        ((msg_svc.TransMsg)localObject).to_uin.set(Long.valueOf(paramString).longValue());
        localRoutingHead.trans_msg.set((MessageMicro)localObject);
        paramInt1 = 1;
        continue;
        localObject = new msg_svc.Trans0x211();
        ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
        paramString = paramString.replace("+", "");
        ((msg_svc.Trans0x211)localObject).to_uin.set(CharacterUtil.a(paramString));
        localRoutingHead.trans_0x211.set((MessageMicro)localObject);
        paramInt1 = 1;
      }
      Object localObject = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject).pkg_num.set(1);
      ((msg_comm.ContentHead)localObject).div_seq.set(j);
      ((msg_comm.ContentHead)localObject).pkg_index.set(0);
      im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
      localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set((MessageMicro)localObject);
      paramString.msg_body.set(localMsgBody);
      paramString.msg_seq.set(k);
      paramString.msg_rand.set(paramInt2);
      paramTransMsgContext = paramQQAppInterface.a();
      paramQQAppInterface = paramString;
    } while (paramTransMsgContext == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramTransMsgContext));
    return paramString;
  }
  
  private static im_msg_body.Elem a(im_msg_body.RichText paramRichText, String paramString)
  {
    im_msg_body.Text localText = new im_msg_body.Text();
    localText.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.Elem();
    paramString.text.set(localText);
    paramRichText.elems.add(paramString);
    return paramString;
  }
  
  public static im_msg_body.RichText a(MessageForBitApp paramMessageForBitApp)
  {
    if ((paramMessageForBitApp == null) || (paramMessageForBitApp.bitAppMsg == null)) {}
    do
    {
      return null;
      new im_msg_body.RichText();
      localObject = paramMessageForBitApp.bitAppMsg.getEncodeXml();
    } while (localObject == null);
    paramMessageForBitApp = new im_msg_body.BitAppMsg();
    paramMessageForBitApp.bytes_buf.set(ByteStringMicro.copyFrom((byte[])localObject));
    Object localObject = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.bitapp_msg.set(paramMessageForBitApp);
    ((im_msg_body.RichText)localObject).elems.add(localElem);
    return (im_msg_body.RichText)localObject;
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForRichText))) {
      return ((MessageForRichText)paramChatMessage).richText;
    }
    return null;
  }
  
  public static im_msg_body.RichText a(FunnyFaceMessage paramFunnyFaceMessage)
  {
    im_msg_body.FunFace localFunFace = new im_msg_body.FunFace();
    Object localObject;
    if (paramFunnyFaceMessage.faceId == 1)
    {
      localObject = new im_msg_body.FunFace.Turntable();
      Iterator localIterator = paramFunnyFaceMessage.turntable.uinList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((im_msg_body.FunFace.Turntable)localObject).rpt_uint64_uin_list.add(Long.valueOf(str));
      }
      ((im_msg_body.FunFace.Turntable)localObject).uint64_hit_uin.set(Long.valueOf(paramFunnyFaceMessage.turntable.hitUin).longValue());
      localFunFace.msg_turntable.set((MessageMicro)localObject);
    }
    for (;;)
    {
      paramFunnyFaceMessage = new im_msg_body.RichText();
      localObject = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject).fun_face.set(localFunFace);
      paramFunnyFaceMessage.elems.add((MessageMicro)localObject);
      return paramFunnyFaceMessage;
      if (paramFunnyFaceMessage.faceId == 2)
      {
        localObject = new im_msg_body.FunFace.Bomb();
        ((im_msg_body.FunFace.Bomb)localObject).bool_burst.set(paramFunnyFaceMessage.bomb.isBurst);
        localFunFace.msg_bomb.set((MessageMicro)localObject);
      }
    }
  }
  
  public static im_msg_body.RichText a(MarkFaceMessage paramMarkFaceMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = new im_msg_body.MarketFace();
    if (paramMarkFaceMessage.sbufID != null) {
      ((im_msg_body.MarketFace)localObject).bytes_face_id.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbufID));
    }
    if ((paramBoolean) && (paramString != null)) {
      ((im_msg_body.MarketFace)localObject).bytes_face_name.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    if (paramMarkFaceMessage.sbfKey != null) {
      ((im_msg_body.MarketFace)localObject).bytes_key.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbfKey));
    }
    ((im_msg_body.MarketFace)localObject).uint32_face_info.set(paramMarkFaceMessage.cFaceInfo);
    ((im_msg_body.MarketFace)localObject).uint32_item_type.set(paramMarkFaceMessage.dwMSGItemType);
    ((im_msg_body.MarketFace)localObject).uint32_sub_type.set(paramMarkFaceMessage.cSubType);
    ((im_msg_body.MarketFace)localObject).uint32_tab_id.set(paramMarkFaceMessage.dwTabID);
    ((im_msg_body.MarketFace)localObject).uint32_media_type.set(paramMarkFaceMessage.mediaType);
    ((im_msg_body.MarketFace)localObject).uint32_image_width.set(paramMarkFaceMessage.imageWidth);
    ((im_msg_body.MarketFace)localObject).uint32_image_height.set(paramMarkFaceMessage.imageHeight);
    if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_mobileparam.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.mobileparam));
    }
    if ((paramMarkFaceMessage.resvAttr != null) && (paramMarkFaceMessage.resvAttr.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_ext_info.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.resvAttr));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "encodeMarketFace : mf epid = " + ((im_msg_body.MarketFace)localObject).uint32_tab_id.get() + " csubtype = " + ((im_msg_body.MarketFace)localObject).uint32_sub_type.get() + ";mediaType = " + ((im_msg_body.MarketFace)localObject).uint32_media_type.get());
    }
    paramMarkFaceMessage = new im_msg_body.Text();
    paramMarkFaceMessage.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.market_face.set((MessageMicro)localObject);
    paramString.elems.add(localElem);
    localObject = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject).text.set(paramMarkFaceMessage);
    paramString.elems.add((MessageMicro)localObject);
    return paramString;
  }
  
  public static im_msg_body.RichText a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      return null;
    }
    return b(paramMessageForApollo);
  }
  
  public static im_msg_body.RichText a(MessageForFile paramMessageForFile)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.a().a();
    if ((paramMessageForFile == null) || (localObject == null) || (paramMessageForFile.uniseq == -1L)) {
      return null;
    }
    localObject = ((QQAppInterface)localObject).a().a(paramMessageForFile.uniseq, paramMessageForFile.senderuin, paramMessageForFile.istroop);
    if (localObject == null) {
      return null;
    }
    paramMessageForFile = new im_msg_body.NotOnlineFile();
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).strFileMd5)) {
      paramMessageForFile.bytes_file_md5.set(ByteStringMicro.copyFromUtf8(((FileManagerEntity)localObject).strFileMd5));
    }
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).fileName)) {
      paramMessageForFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((FileManagerEntity)localObject).fileName));
    }
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) {
      paramMessageForFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(((FileManagerEntity)localObject).Uuid));
    }
    paramMessageForFile.uint64_file_size.set(((FileManagerEntity)localObject).fileSize);
    paramMessageForFile.uint32_upload_time.set((int)(((FileManagerEntity)localObject).srvTime / 1000L));
    localObject = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject).not_online_file.set(paramMessageForFile);
    return (im_msg_body.RichText)localObject;
  }
  
  public static im_msg_body.RichText a(MessageForFunnyFace paramMessageForFunnyFace)
  {
    if ((paramMessageForFunnyFace == null) || (paramMessageForFunnyFace.mFunnyFaceMessage == null)) {
      return null;
    }
    return a(paramMessageForFunnyFace.mFunnyFaceMessage);
  }
  
  public static im_msg_body.RichText a(MessageForLongTextMsg paramMessageForLongTextMsg, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramMessageForLongTextMsg == null) {
      localObject1 = localObject2;
    }
    do
    {
      do
      {
        do
        {
          return (im_msg_body.RichText)localObject1;
          if (!paramBoolean) {
            break;
          }
          localObject1 = localObject2;
        } while (paramMessageForLongTextMsg.structingMsg == null);
        localObject3 = paramMessageForLongTextMsg.structingMsg.getXmlBytes();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject1).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject3));
      ((im_msg_body.RichMsg)localObject1).uint32_service_id.set(paramMessageForLongTextMsg.structingMsg.mMsgServiceID);
      localObject2 = new im_msg_body.RichText();
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(paramMessageForLongTextMsg.structingMsg.mCompatibleText));
    Object localObject1 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForLongTextMsg.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    return (im_msg_body.RichText)localObject2;
    paramMessageForLongTextMsg = a(paramMessageForLongTextMsg.msg, paramMessageForLongTextMsg.atInfoList);
    localObject1 = new im_msg_body.GeneralFlags();
    ((im_msg_body.GeneralFlags)localObject1).long_text_flag.set(2);
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).general_flags.set((MessageMicro)localObject1);
    paramMessageForLongTextMsg.elems.add((MessageMicro)localObject2);
    return paramMessageForLongTextMsg;
  }
  
  public static im_msg_body.RichText a(MessageForMarketFace paramMessageForMarketFace)
  {
    if ((paramMessageForMarketFace == null) || (paramMessageForMarketFace.mMarkFaceMessage == null)) {
      return null;
    }
    if (TextUtils.isEmpty(paramMessageForMarketFace.mMarkFaceMessage.faceName)) {}
    for (String str = "[原创表情]";; str = "[" + paramMessageForMarketFace.mMarkFaceMessage.faceName + "]")
    {
      boolean bool = true;
      if (paramMessageForMarketFace.istroop == 3000) {
        bool = false;
      }
      return a(paramMessageForMarketFace.mMarkFaceMessage, str, bool);
    }
  }
  
  public static im_msg_body.RichText a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (paramMessageForMixedMsg == null) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int k = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    while (i < k)
    {
      Object localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      if ((localObject instanceof MessageForText))
      {
        localObject = a((MessageForText)localObject);
        if (localObject == null) {
          return null;
        }
        int j = 0;
        while (j < ((im_msg_body.RichText)localObject).elems.size())
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
          j += 1;
        }
      }
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject == null) {
          return null;
        }
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
      }
      i += 1;
    }
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForQQStoryComment paramMessageForQQStoryComment)
  {
    return a(paramMessageForQQStoryComment.msg, null);
  }
  
  public static im_msg_body.RichText a(MessageForReplyText paramMessageForReplyText)
  {
    localRichText = a(paramMessageForReplyText.msg, paramMessageForReplyText.atInfoList);
    paramMessageForReplyText = paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_source_msg_info");
    if (!TextUtils.isEmpty(paramMessageForReplyText)) {
      try
      {
        Object localObject1 = (MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.a(paramMessageForReplyText));
        if (localObject1 != null)
        {
          paramMessageForReplyText = new im_msg_body.SourceMsg();
          paramMessageForReplyText.uint32_orig_seqs.add(Integer.valueOf((int)((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSeq));
          Object localObject2 = a(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgText, null);
          paramMessageForReplyText.elems.set(((im_msg_body.RichText)localObject2).elems.get());
          if (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject1).mAnonymousNickName))
          {
            localObject2 = new im_msg_body.AnonymousGroupMsg();
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.set(ByteStringMicro.copyFromUtf8(((MessageForReplyText.SourceMsgInfo)localObject1).mAnonymousNickName));
            im_msg_body.Elem localElem = new im_msg_body.Elem();
            localElem.anon_group_msg.set((MessageMicro)localObject2);
            paramMessageForReplyText.elems.add(localElem);
          }
          paramMessageForReplyText.uint64_sender_uin.set(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSenderUin);
          paramMessageForReplyText.uint32_time.set(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgTime);
          paramMessageForReplyText.uint32_flag.set(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceSummaryFlag);
          paramMessageForReplyText.uint32_type.set(((MessageForReplyText.SourceMsgInfo)localObject1).mType);
          if (((MessageForReplyText.SourceMsgInfo)localObject1).mRichMsg != null) {
            paramMessageForReplyText.bytes_richMsg.set(ByteStringMicro.copyFromUtf8(((MessageForReplyText.SourceMsgInfo)localObject1).mRichMsg));
          }
          for (;;)
          {
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).src_msg.set(paramMessageForReplyText);
            localRichText.elems.add((MessageMicro)localObject1);
            return localRichText;
            paramMessageForReplyText.uint32_type.set(0);
          }
        }
        return localRichText;
      }
      catch (Exception paramMessageForReplyText)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.", 2, "getSourceMsgInfo exception:" + paramMessageForReplyText.getMessage());
        }
      }
    }
  }
  
  public static im_msg_body.RichText a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if ((paramMessageForShakeWindow == null) || (paramMessageForShakeWindow.mShakeWindowMsg == null)) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.ShakeWindow localShakeWindow = new im_msg_body.ShakeWindow();
    localShakeWindow.uint32_type.set(paramMessageForShakeWindow.mShakeWindowMsg.mType);
    paramMessageForShakeWindow = new im_msg_body.Elem();
    paramMessageForShakeWindow.shake_window.set(localShakeWindow);
    localRichText.elems.add(paramMessageForShakeWindow);
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForStructing paramMessageForStructing)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageForStructing != null)
    {
      if (paramMessageForStructing.structingMsg != null) {
        break label19;
      }
      localObject1 = localObject2;
    }
    label19:
    label216:
    do
    {
      do
      {
        return (im_msg_body.RichText)localObject1;
        if (paramMessageForStructing.richText != null) {
          return paramMessageForStructing.richText;
        }
        localObject3 = paramMessageForStructing.structingMsg.getXmlBytes();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject1).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject3));
      ((im_msg_body.RichMsg)localObject1).uint32_service_id.set(paramMessageForStructing.structingMsg.mMsgServiceID);
      if ((paramMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        localObject2 = ((AbsShareMsg)paramMessageForStructing.structingMsg).getStructMsgItemLists();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label216;
            }
            localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
            if ((localObject3 instanceof AbsStructMsgItem))
            {
              localObject3 = ((AbsStructMsgItem)localObject3).a;
              if (localObject3 != null)
              {
                localObject3 = ((List)localObject3).iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject3).next();
                  if (!(localAbsStructMsgElement instanceof StructMsgItemVideo)) {
                    break;
                  }
                  if (((StructMsgItemVideo)localAbsStructMsgElement).a()) {
                    ((im_msg_body.RichMsg)localObject1).uint32_flags.set(4);
                  } else {
                    ((im_msg_body.RichMsg)localObject1).uint32_flags.set(2);
                  }
                }
              }
            }
          }
        }
      }
      localObject2 = new im_msg_body.RichText();
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
      if (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText)) {
        paramMessageForStructing.structingMsg.mCompatibleText = paramMessageForStructing.structingMsg.mMsgUrl;
      }
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText));
    localObject1 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForStructing.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    return (im_msg_body.RichText)localObject2;
  }
  
  public static im_msg_body.RichText a(MessageForText paramMessageForText)
  {
    return a(paramMessageForText.msg, paramMessageForText.atInfoList);
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList paramArrayList)
  {
    im_msg_body.RichText localRichText2 = new im_msg_body.RichText();
    im_msg_body.RichText localRichText1 = localRichText2;
    if (a(localRichText2, paramString, paramArrayList) <= 0) {
      localRichText1 = null;
    }
    return localRichText1;
  }
  
  private static void a(long paramLong1, long paramLong2, int paramInt)
  {
    SharpReport_OffLine localSharpReport_OffLine = SharpReport_OffLine.a();
    localSharpReport_OffLine.a(0L, paramLong1, paramLong2);
    localSharpReport_OffLine.a(paramInt, 2, paramLong2);
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.b.a(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.b.a());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.b.a(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    int j;
    label1608:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            msg_comm.MsgType0x210 localMsgType0x210 = new msg_comm.MsgType0x210();
            try
            {
              localMsgType0x210 = (msg_comm.MsgType0x210)localMsgType0x210.mergeFrom(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray());
              if (localMsgType0x210 == null)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", localException1);
                }
                localObject1 = null;
              }
              if ((!((msg_comm.MsgType0x210)localObject1).sub_msg_type.has()) || (!((msg_comm.MsgType0x210)localObject1).msg_content.has()))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + ((msg_comm.MsgType0x210)localObject1).sub_msg_type.has() + ",hasMsgContent:" + ((msg_comm.MsgType0x210)localObject1).msg_content.has());
                }
              }
              else
              {
                i = ((msg_comm.MsgType0x210)localObject1).sub_msg_type.get();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:" + i);
                }
                switch (i)
                {
                }
              }
            }
          }
          return;
          a(paramMessageHandler, paramMsg, paramBoolean1);
          return;
          ((ShieldListHandler)paramMessageHandler.b.a(18)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          a(paramMessageHandler, (msg_comm.MsgType0x210)localObject1);
          return;
          ((SttManager)paramMessageHandler.b.getManager(16)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          ((PublicAccountHandler)paramMessageHandler.b.a(11)).a(i, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopgetnews..troop.notification_center", 2, "decodeC2CMsgPkg_MsgType0x210, receive troop news push");
          }
          ((TroopHandler)paramMessageHandler.b.a(20)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
          }
          Object localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          a(paramMessageHandler.b, (byte[])localObject1);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "processMsg0x210Sub0xb1");
          }
          localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          a(paramMessageHandler.b, (byte[])localObject1, false);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x51");
          }
          paramMessageHandler.a((msg_comm.MsgType0x210)localObject1, paramMsg);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Push_PCActive_Notice_Decode", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
          }
          byte[] arrayOfByte = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          localObject1 = null;
          localObject3 = null;
          localObject4 = null;
          try
          {
            Object localObject5 = new SubMsgType0x6b.MsgBody();
            ((SubMsgType0x6b.MsgBody)localObject5).mergeFrom(arrayOfByte);
            paramLong = ((SubMsgType0x6b.MsgBody)localObject5).uint64_to_uin.get();
            if (!SettingCloneUtil.readValue(BaseApplicationImpl.a(), Long.toString(paramLong), null, "qqsetting_pcactive_key", false))
            {
              if (((SubMsgType0x6b.MsgBody)localObject5).bytes_tips_content.has()) {
                localObject1 = new String(((SubMsgType0x6b.MsgBody)localObject5).bytes_tips_content.get().toByteArray(), "utf-8");
              }
              if (((SubMsgType0x6b.MsgBody)localObject5).bytes_yes_text.has()) {
                localObject3 = new String(((SubMsgType0x6b.MsgBody)localObject5).bytes_yes_text.get().toByteArray(), "utf-8");
              }
              if (((SubMsgType0x6b.MsgBody)localObject5).bytes_no_text.has()) {
                localObject4 = new String(((SubMsgType0x6b.MsgBody)localObject5).bytes_no_text.get().toByteArray(), "utf-8");
              }
              BaseApplicationImpl.a().a(Long.toString(paramLong), (String)localObject1, (String)localObject4, (String)localObject3);
              localObject5 = new Intent("mqq.intent.action.PCACTIVE_TIPS");
              ((Intent)localObject5).putExtra("uin", Long.toString(paramLong));
              ((Intent)localObject5).putExtra("Message", (String)localObject1);
              ((Intent)localObject5).putExtra("lButton", (String)localObject4);
              ((Intent)localObject5).putExtra("rButton", (String)localObject3);
              if (NotifyPCActiveActivity.a == null) {
                BaseApplicationImpl.a().startActivity((Intent)localObject5);
              }
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice_Decode", 2, "failed to get msg0x210.SubMsgType0x6b");
              }
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice_Decode", 2, "failed to parse msg0x210.SubMsgType0x6b");
              }
            }
          }
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush recv msg0x210.Submsgtype0x6f");
          }
          if (localUnsupportedEncodingException.msg_content != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content is null");
        return;
        localObject2 = localUnsupportedEncodingException.msg_content.get().toByteArray();
        if (localObject2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content.toByteArray is null");
      return;
      try
      {
        localObject3 = new SubMsgType0x6f.MsgBody();
        ((SubMsgType0x6f.MsgBody)localObject3).mergeFrom((byte[])localObject2);
        localObject2 = (SubMsgType0x6f.ForwardBody)((SubMsgType0x6f.MsgBody)localObject3).rpt_msg_mod_infos.get().get(0);
        i = -1;
        if (((SubMsgType0x6f.ForwardBody)localObject2).uint32_op_type.has()) {
          i = ((SubMsgType0x6f.ForwardBody)localObject2).uint32_op_type.get();
        }
        if ((i != 2001) || (!((SubMsgType0x6f.ForwardBody)localObject2).msg_mcard_notification_like.has())) {
          break;
        }
        localObject3 = (SubMsgType0x6f.MCardNotificationLike)((SubMsgType0x6f.ForwardBody)localObject2).msg_mcard_notification_like.get();
        localObject2 = "";
        paramLong = 0L;
        j = 0;
        i = 0;
        if (((SubMsgType0x6f.MCardNotificationLike)localObject3).str_wording.has()) {
          localObject2 = ((SubMsgType0x6f.MCardNotificationLike)localObject3).str_wording.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject3).uint32_counter_new.has()) {
          i = ((SubMsgType0x6f.MCardNotificationLike)localObject3).uint32_counter_new.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject3).uint64_from_uin.has()) {
          paramLong = ((SubMsgType0x6f.MCardNotificationLike)localObject3).uint64_from_uin.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject3).uint32_counter_total.has()) {
          j = ((SubMsgType0x6f.MCardNotificationLike)localObject3).uint32_counter_total.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + (String)localObject2 + " totalCount: " + j + " newCount: " + i + " fromUin: " + paramLong);
        }
        localObject2 = (DatingProxyManager)paramMessageHandler.b.getManager(70);
        if (localObject2 != null) {
          ((DatingProxyManager)localObject2).a().a((SubMsgType0x6f.MCardNotificationLike)localObject3);
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMessageHandler) {}
    } while (!QLog.isColorLevel());
    QLog.d("TurnBrand", 2, "failed to get msg0x210.SubMsgType0x6f", paramMessageHandler);
    return;
    if ((i == 2002) && (((SubMsgType0x6f.ForwardBody)localObject2).vip_info_notify.has()))
    {
      localObject3 = (SubMsgType0x6f.VipInfoNotify)((SubMsgType0x6f.ForwardBody)localObject2).vip_info_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "vip info notify: " + localObject3.toString());
      }
      paramLong = 0L;
      i = 0;
      if (((SubMsgType0x6f.VipInfoNotify)localObject3).uint64_uin.has()) {
        paramLong = ((SubMsgType0x6f.VipInfoNotify)localObject3).uint64_uin.get();
      }
      localObject2 = Long.toString(paramLong);
      if (((SubMsgType0x6f.VipInfoNotify)localObject3).uint32_vip_identify.has()) {
        i = ((SubMsgType0x6f.VipInfoNotify)localObject3).uint32_vip_identify.get();
      }
      if (!((SubMsgType0x6f.VipInfoNotify)localObject3).uint32_vip_level.has()) {
        break label3531;
      }
      j = ((SubMsgType0x6f.VipInfoNotify)localObject3).uint32_vip_level.get();
      label1813:
      if (!QLog.isColorLevel()) {
        break label3537;
      }
      QLog.d("Q.msg.MessageHandler", 2, "UIN " + (String)localObject2 + " vip info changed.");
      break label3537;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "need pull vip info from svr. vipIdentiy=" + i + "; vipLevel=" + j);
      }
      localObject3 = ((TicketManager)paramMessageHandler.b.getManager(2)).getSkey((String)localObject2);
      ((VipInfoHandler)paramMessageHandler.b.a(27)).a((String)localObject3, (String)localObject2);
      break label1608;
      if ((i != 2003) || (!((SubMsgType0x6f.ForwardBody)localObject2).msg_push_lost_dev_found.has())) {
        break label1608;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QFindBLE", 2, "offlinePush receive ...");
      }
      localObject2 = (SubMsgType0x6f.PushLostDevFound)((SubMsgType0x6f.ForwardBody)localObject2).msg_push_lost_dev_found.get();
      localObject3 = new Bundle();
      if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_msg_type.has()) {
        ((Bundle)localObject3).putInt("msgtype", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_msg_type.get());
      }
      if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_dev_time.has()) {
        ((Bundle)localObject3).putInt("devtime", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_dev_time.get());
      }
      if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint64_din.has()) {
        ((Bundle)localObject3).putLong("din", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint64_din.get());
      }
      ((SmartDeviceProxyMgr)paramMessageHandler.b.a(51)).a(111, (Bundle)localObject3);
      break label1608;
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrand", 2, "decode recv msg0x210.Submsgtype0x6e");
      }
      localObject2 = (RecommendTroopManagerImp)paramMessageHandler.b.getManager(21);
      if (localObject2 != null) {
        ((RecommendTroopManagerImp)localObject2).a();
      }
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 group recmd msg");
      }
      localObject3 = new submsgtype0x67.MsgBody();
      try
      {
        ((submsgtype0x67.MsgBody)localObject3).mergeFrom(((msg_comm.MsgType0x210)localObject2).msg_content.get().toByteArray());
        if (((submsgtype0x67.MsgBody)localObject3).rpt_msg_grpinfo.has())
        {
          localObject2 = ((submsgtype0x67.MsgBody)localObject3).rpt_msg_grpinfo.get();
          localObject3 = (LBSHandler)paramMessageHandler.b.a(3);
          if (localObject3 != null) {
            ((LBSHandler)localObject3).a((List)localObject2);
          }
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 mergeFrom exception: " + localException2.toString());
          }
        }
      }
      ((QPayHandler)paramMessageHandler.b.a(47)).a(true);
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (a(paramMessageHandler.b, localException2.msg_content.get().toByteArray())) {
        paramMessageHandler.a().a("handleActivateFriendsPush2", true, 1, true, false);
      }
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      paramMsg.msg_head.from_uin.get();
      i = paramMsg.msg_head.msg_seq.get();
      paramMsg.msg_head.msg_uid.get();
      j = paramMsg.msg_head.msg_type.get();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0x7a push message, seq = " + i + ", submsgtype:" + j);
      }
      paramMsg = new submsgtype0x7a.MsgBody();
      try
      {
        paramMsg.mergeFrom(localException2.msg_content.get().toByteArray());
        ((ArrangeHandler)paramMessageHandler.b.a(61)).a(paramMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "parse 0x7a push msg error", paramMessageHandler);
      return;
      paramMsg.msg_head.from_uin.get();
      i = paramMsg.msg_head.msg_seq.get();
      paramMsg.msg_head.msg_uid.get();
      j = paramMsg.msg_head.msg_type.get();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0x7c push message, seq = " + i + ", submsgtype:" + j);
      }
      paramMsg = new submsgtype0x7c.MsgBody();
      try
      {
        paramMsg.mergeFrom(localException2.msg_content.get().toByteArray());
        paramLong = paramMsg.uint64_uin.get();
        if (!paramMessageHandler.b.a().equals(String.valueOf(paramLong))) {
          break;
        }
        ((SecSpyFileManager)paramMessageHandler.b.getManager(93)).a(paramMsg, 1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "parse 0x7c push msg error", paramMessageHandler);
      return;
      ((ReadInJoyHandler)paramMessageHandler.b.a(62)).a(localException2.msg_content.get().toByteArray());
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (paramBoolean2) {
        break;
      }
      paramMsg = new Submsgtype0x8a.ReqBody();
      try
      {
        paramMsg.mergeFrom(localException2.msg_content.get().toByteArray());
        a(paramMessageHandler.b, paramMsg, 0L, false);
        return;
      }
      catch (Exception paramMessageHandler) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b offline msg, prase reqBody error");
      return;
      paramMsg = new submsgtype0x8f.MsgBody();
      try
      {
        paramMsg.mergeFrom(localException2.msg_content.get().toByteArray());
        paramMessageHandler = (DingdongPluginBizHandler)paramMessageHandler.b.a(75);
        if (paramMessageHandler == null) {
          break;
        }
        paramMessageHandler.a(paramMsg);
        return;
      }
      catch (Exception paramMessageHandler)
      {
        QLog.e("Dingdong", 2, "handleMsgType0x210SubMsgType0x8f : fail to parse 0x211_0x8f.");
        return;
      }
      localObject3 = new SubMsgType0x9b.MsgBody();
      DingdongPluginBizHandler localDingdongPluginBizHandler;
      try
      {
        ((SubMsgType0x9b.MsgBody)localObject3).mergeFrom(localException2.msg_content.get().toByteArray());
        localDingdongPluginBizHandler = (DingdongPluginBizHandler)paramMessageHandler.b.a(75);
        localObject4 = (DingdongPluginManager)paramMessageHandler.b.getManager(114);
        if (localDingdongPluginBizHandler != null) {
          localDingdongPluginBizHandler.a((SubMsgType0x9b.MsgBody)localObject3, true);
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramMessageHandler)
      {
        paramMessageHandler.printStackTrace();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0x9d receive 0x9d push message");
      }
      paramMsg = new SubMsgType0x9d.MsgBody();
      try
      {
        paramMsg.mergeFrom(localDingdongPluginBizHandler.msg_content.get().toByteArray());
        if ((!paramMsg.uint32_sub_cmd.has()) || (!paramMsg.lola_module_update.has())) {
          break;
        }
        ((BitAppManager)paramMessageHandler.b.getManager(143)).a(paramMsg.uint32_sub_cmd.get(), paramMsg.lola_module_update.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0x9d: parse msg error", paramMessageHandler);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xaa receive 0xaa push message");
      }
      localObject3 = new SubMsgType0xaa.MsgBody();
      try
      {
        ((SubMsgType0xaa.MsgBody)localObject3).mergeFrom(localDingdongPluginBizHandler.msg_content.get().toByteArray());
        ((GamePartyManager)paramMessageHandler.b.getManager(155)).a((SubMsgType0xaa.MsgBody)localObject3, true);
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xaa, prase msgBody error");
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xae receive 0xae push message");
      }
      localObject3 = new SubMsgType0xae.MsgBody();
      try
      {
        ((SubMsgType0xae.MsgBody)localObject3).mergeFrom(localException3.msg_content.get().toByteArray());
        ((MayknowRecommendManager)paramMessageHandler.b.getManager(158)).a((SubMsgType0xae.MsgBody)localObject3);
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "recv 0x210_0xae, prase msgBody error");
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xb3 receive 0xaa push message");
      }
      ((OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor")).f(localException4.msg_content.get().toByteArray());
      return;
      label3531:
      j = 0;
      break label1813;
      label3537:
      if (i == 0) {
        if (j == 0) {
          break label1608;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, SlaveMasterMsg paramSlaveMasterMsg)
  {
    Object localObject1 = new SubMsgType0x4.MsgBody();
    try
    {
      localObject2 = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject1).mergeFrom(paramSlaveMasterMsg.vOrigMsg);
      if (!((SubMsgType0x4.MsgBody)localObject2).msg_not_online_file.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
      return;
    }
    im_msg_body.NotOnlineFile localNotOnlineFile = (im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject2).msg_not_online_file.get();
    localObject1 = null;
    if (((SubMsgType0x4.MsgBody)localObject2).file_image_info.has()) {
      localObject1 = (hummer_resv_21.FileImgInfo)((SubMsgType0x4.MsgBody)localObject2).file_image_info.get();
    }
    Object localObject2 = new ArrayList();
    msg_comm.Msg localMsg = new msg_comm.Msg();
    localMsg.msg_head.msg_uid.set(paramMsgInfo.lMsgUid);
    localMsg.msg_head.msg_time.set(paramMsgInfo.uRealMsgTime);
    localMsg.msg_head.from_uin.set(paramSlaveMasterMsg.lFromUin);
    localMsg.msg_head.msg_seq.set((int)paramSlaveMasterMsg.uSeq);
    paramMessageHandler.b.a().a(paramMessageHandler, (List)localObject2, localMsg, localNotOnlineFile, String.valueOf(paramSlaveMasterMsg.lToUin), true, false, -100L, -1, (hummer_resv_21.FileImgInfo)localObject1);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, int paramInt1, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("<---decodeC2CMsgPkg_OfflineFile : ");
    localStringBuilder.append(" c2cCmd:").append(paramInt1).append(";friendUin:").append(paramLong1).append(";isReaded:").append(paramBoolean1).append(";isPullRoam:").append(paramBoolean2).append(";isSelfSender:").append(paramBoolean3).append(";\n");
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + paramMsg.msg_body.has() + "hasRichT:" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      }
    }
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
        localObject2 = (im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject1).not_online_file.get();
        if (((im_msg_body.RichText)localObject1).not_online_file.has()) {
          break;
        }
        localStringBuilder.append("hasNotOnlineFile:").append(((im_msg_body.RichText)localObject1).not_online_file.has()).append(";hasUUID:").append(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.has());
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      return;
      if ((paramInt1 != 169) && (paramInt1 != 243)) {
        break;
      }
    } while (paramBoolean4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: c2cCmd[" + paramInt1 + "]");
    }
    paramMessageHandler.b.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject2, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2, paramInt2, null);
    return;
    paramMsg = new String(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8() + l1);
    Object localObject1 = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8();
    localStringBuilder.append("     NotOnLineFile info : serverPath:").append((String)localObject1).append(";fileKey :").append(paramMsg).append(";");
    if (!paramMessageHandler.a().a(paramMsg))
    {
      paramMsg = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
      localStringBuilder.append("strFileName:").append(paramMsg).append(";");
      paramLong1 = ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.get();
      if ((paramInt1 == 241) || (MessageUtils.a(paramMsg, paramInt1)))
      {
        paramMessageHandler = new RichMsg.PicRec();
        paramMessageHandler.localPath.set((String)localObject1);
        paramMessageHandler.size.set(paramLong1);
        paramMessageHandler.type.set(1);
        paramMessageHandler.isRead.set(false);
        paramMessageHandler.uuid.set((String)localObject1);
        paramMessageHandler.serverStorageSource.set("ftn");
        paramMessageHandler.version.set(5);
        paramMessageHandler.isReport.set(0);
        paramMsg = (MessageForPic)MessageRecordFactory.a(63536);
        paramMsg.msgtype = 63536;
        paramMsg.msgData = paramMessageHandler.toByteArray();
        paramMsg.parse();
        paramList.add(paramMsg);
        paramMessageHandler = null;
      }
    }
    for (;;)
    {
      localStringBuilder.append("protocolStr:").append(paramMessageHandler).append(";");
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label1099;
        }
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
        return;
        if ((paramInt1 != 242) && (!MessageUtils.b(paramMsg, paramInt1))) {
          break label1101;
        }
        if ((paramMsg != null) && (!paramMsg.equals("")))
        {
          if (!paramMsg.contains("_")) {}
          for (paramMsg = paramMsg.substring(0, paramMsg.length() - 4);; paramMsg = paramMsg.substring(paramMsg.lastIndexOf("_") + 1, paramMsg.length() - 4))
          {
            paramMsg = l2 + paramMsg;
            localStringBuilder.append("c2cCmd:0xf2;key:").append(paramMsg).append(";");
            if (paramBoolean4) {
              break label882;
            }
            if (!StreamDataManager.e(paramMsg)) {
              break;
            }
            localStringBuilder.append("DuplicateKey:").append(paramMsg).append(";");
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
            }
            StreamDataManager.d(paramMsg);
            return;
          }
          StreamDataManager.c(paramMsg);
        }
        for (;;)
        {
          label882:
          paramMsg = TransfileUtile.a((String)localObject1, paramLong1, 2, false, (String)localObject1, null, "ftn");
          localObject2 = new RichMsg.PttRec();
          ((RichMsg.PttRec)localObject2).localPath.set((String)localObject1);
          ((RichMsg.PttRec)localObject2).size.set(paramLong1);
          ((RichMsg.PttRec)localObject2).type.set(2);
          ((RichMsg.PttRec)localObject2).uuid.set((String)localObject1);
          ((RichMsg.PttRec)localObject2).isRead.set(false);
          ((RichMsg.PttRec)localObject2).serverStorageSource.set("ftn");
          ((RichMsg.PttRec)localObject2).isReport.set(0);
          ((RichMsg.PttRec)localObject2).version.set(5);
          paramLong1 = System.currentTimeMillis() / 1000L;
          ((RichMsg.PttRec)localObject2).msgRecTime.set(paramLong1);
          ((RichMsg.PttRec)localObject2).msgTime.set(l1);
          localObject1 = (MessageForPtt)MessageRecordFactory.a(63534);
          ((MessageForPtt)localObject1).msgtype = 63534;
          ((MessageForPtt)localObject1).msgData = ((RichMsg.PttRec)localObject2).toByteArray();
          ((MessageForPtt)localObject1).parse();
          paramList.add(localObject1);
          PttInfoCollector.a(paramMessageHandler.b, 1, false, 4);
          paramMessageHandler = paramMsg;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "offline ptt no filename");
          }
        }
        localStringBuilder.append("rcv a repeated offline file push msg");
      }
      label1099:
      break;
      label1101:
      paramMessageHandler = null;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg)
  {
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    im_msg_body.Ptt localPtt;
    do
    {
      return;
      localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      localPtt = (im_msg_body.Ptt)((im_msg_body.RichText)localObject1).ptt.get();
      if ((((im_msg_body.RichText)localObject1).ptt.has()) && (localPtt.uint32_file_type.has()) && ((localPtt.uint32_file_type.get() == 4) || (localPtt.uint32_file_type.get() == 6)) && (localPtt.bytes_file_uuid.has())) {
        break;
      }
    } while (!QLog.isColorLevel());
    paramMessageHandler = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
    if (localPtt == null) {
      paramMessageHandler.append(" ptt is null.");
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
      return;
      paramMessageHandler.append(" HasileType:").append(localPtt.uint32_file_type.has()).append(" fileType:").append(localPtt.uint32_file_type.get()).append(" hasUUID:").append(localPtt.bytes_file_uuid.has());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : " + localPtt.uint32_file_type.get());
    }
    int m;
    long l1;
    int i3;
    int i;
    int i4;
    int j;
    int i5;
    int k;
    int n;
    int i1;
    int i2;
    long l2;
    label398:
    Object localObject2;
    if (SttManager.a(paramMessageHandler.b))
    {
      m = 1;
      l1 = -1L;
      i3 = 0;
      i = 0;
      i4 = 0;
      j = 0;
      i5 = 0;
      k = 0;
      n = i5;
      i1 = i4;
      i2 = i3;
      l2 = l1;
      if (!localPtt.bytes_reserve.has()) {
        break label771;
      }
      localObject1 = localPtt.bytes_reserve.get().toByteArray();
      n = i5;
      i1 = i4;
      i2 = i3;
      l2 = l1;
      if (localObject1 == null) {
        break label771;
      }
      n = i5;
      i1 = i4;
      i2 = i3;
      l2 = l1;
      if (localObject1.length <= 1) {
        break label771;
      }
      n = localObject1[0];
      i3 = 1;
      n = k;
      i1 = j;
      i2 = i;
      l2 = l1;
      if (i3 >= localObject1.length - 1) {
        break label771;
      }
      i5 = localObject1[i3];
      n = i3 + 1;
      i3 = PkgTools.a((byte[])localObject1, n);
      i4 = n + 2;
      if (i5 != 3) {
        break label588;
      }
      localObject2 = new byte[i3];
      PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, i4, i3);
      l2 = PkgTools.a((byte[])localObject2, 0);
      if (l2 > 0L) {
        l1 = l2;
      }
      n = k;
      i1 = j;
      i2 = i;
      l2 = l1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : TimeStamp in d0 :" + l1);
        l2 = l1;
        i2 = i;
        i1 = j;
        n = k;
      }
    }
    for (;;)
    {
      i3 = i4 + i3;
      k = n;
      j = i1;
      i = i2;
      l1 = l2;
      break label398;
      m = 0;
      break;
      label588:
      Object localObject3;
      if (i5 == 9)
      {
        localObject2 = new byte[i3];
        PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, i4, i3);
        i1 = RecordParams.b(Utils.a(PkgTools.a((byte[])localObject2, 0)));
        n = k;
        i2 = i;
        l2 = l1;
      }
      else if (i5 == 8)
      {
        localObject2 = new byte[i3];
        PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, i4, i3);
        i2 = (int)PkgTools.a((byte[])localObject2, 0);
        n = k;
        i1 = j;
        l2 = l1;
      }
      else
      {
        n = k;
        i1 = j;
        i2 = i;
        l2 = l1;
        if (i5 == 10)
        {
          localObject2 = new byte[i3];
          PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, i4, i3);
          localObject3 = new ptt_reserve.ReserveStruct();
        }
      }
      try
      {
        ((ptt_reserve.ReserveStruct)localObject3).mergeFrom((byte[])localObject2);
        n = ((ptt_reserve.ReserveStruct)localObject3).uint32_change_voice.get();
        i1 = j;
        i2 = i;
        l2 = l1;
      }
      catch (Exception localException)
      {
        label771:
        n = k;
        i1 = j;
        i2 = i;
        l2 = l1;
      }
    }
    if (localPtt.bytes_down_para.has())
    {
      localObject1 = localPtt.bytes_down_para.get();
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();; localObject1 = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = 1;
        ReportController.b(paramMessageHandler.b, "CliOper", "", "", "0X80060E4", "0X80060E4", i, 0, "", "", "", "6.5.5");
        localObject3 = localPtt.bytes_file_uuid.get().toStringUtf8();
        localObject2 = localPtt.bytes_file_name.get().toStringUtf8();
        if (((String)localObject2).contains("_")) {
          break label1270;
        }
      }
      label1270:
      for (localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 4);; localObject2 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("_") + 1, ((String)localObject2).length() - 4))
      {
        localObject2 = l3 + "_" + (String)localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：" + (String)localObject2 + " fileUuid:" + (String)localObject3);
        }
        localObject2 = new RichMsg.PttRec();
        ((RichMsg.PttRec)localObject2).localPath.set((String)localObject3);
        ((RichMsg.PttRec)localObject2).size.set(localPtt.uint32_file_size.get());
        ((RichMsg.PttRec)localObject2).type.set(2);
        ((RichMsg.PttRec)localObject2).uuid.set((String)localObject3);
        ((RichMsg.PttRec)localObject2).isRead.set(false);
        ((RichMsg.PttRec)localObject2).serverStorageSource.set("pttcenter");
        ((RichMsg.PttRec)localObject2).isReport.set(0);
        ((RichMsg.PttRec)localObject2).version.set(5);
        ((RichMsg.PttRec)localObject2).pttFlag.set(m);
        l1 = System.currentTimeMillis() / 1000L;
        long l4 = paramMsg.msg_head.msg_time.get();
        ((RichMsg.PttRec)localObject2).msgRecTime.set(l1);
        ((RichMsg.PttRec)localObject2).msgTime.set(l4);
        ((RichMsg.PttRec)localObject2).voiceType.set(i2);
        ((RichMsg.PttRec)localObject2).voiceLength.set(i1);
        ((RichMsg.PttRec)localObject2).voiceChangeFlag.set(n);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "<---decodeC2CMsgPkg_PTT voiceType：" + i2 + " voiceLengh:" + i1);
        }
        i = MessageUtils.a(paramMessageHandler.b, String.valueOf(l3));
        ((RichMsg.PttRec)localObject2).longPttVipFlag.set(i);
        ((RichMsg.PttRec)localObject2).directUrl.set((String)localObject1);
        paramMessageHandler = MessageRecordFactory.a(63534);
        paramMessageHandler.msgtype = 63534;
        paramMessageHandler.msgData = ((RichMsg.PttRec)localObject2).toByteArray();
        paramMessageHandler.time = l2;
        ((MessageForPtt)paramMessageHandler).parse();
        paramList.add(paramMessageHandler);
        return;
        i = 2;
        break;
      }
      break;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    msg_comm.AppShareInfo localAppShareInfo = (msg_comm.AppShareInfo)paramMsg.appshare_info.get();
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramMsg.appshare_info.has())
    {
      l1 = localAppShareInfo.appshare_id.get() & 0xFFFFFFFF;
      localObject1 = (msg_comm.PluginInfo)localAppShareInfo.appshare_resource.get();
      if ((!localAppShareInfo.appshare_resource.has()) || (localObject1 == null) || (paramBoolean)) {
        break label1890;
      }
      localObject1 = AppShareIDUtil.a((msg_comm.PluginInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared appShareID:" + ((AppShareID)localObject1).toString());
      }
      localObject2 = (AppShareID)paramMessageHandler.a().a(AppShareID.class, "strPkgName=?", new String[] { ((AppShareID)localObject1).strPkgName });
      if (localObject2 == null)
      {
        paramMessageHandler.a().a((Entity)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Persist DB appid = " + ((AppShareID)localObject1).strPkgName);
        }
        paramMessageHandler.b.a().a(((AppShareID)localObject1).strPkgName, (AppShareID)localObject1);
      }
    }
    label301:
    label526:
    label569:
    label773:
    label1455:
    label1528:
    label1878:
    label1887:
    label1890:
    for (int i = 1;; i = 0)
    {
      Object localObject3;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
      {
        localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
        paramMsg = null;
        localObject2 = BaseApplication.getContext().getString(2131370483);
        Iterator localIterator = ((List)localObject1).iterator();
        paramBoolean = false;
        localObject3 = null;
        bool1 = false;
        if (localIterator.hasNext())
        {
          localObject1 = (im_msg_body.Elem)localIterator.next();
          bool2 = ((im_msg_body.Elem)localObject1).text.has();
          bool3 = ((im_msg_body.Elem)localObject1).not_online_image.has();
          if (!bool3) {
            break label1887;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        if (bool2) {
          bool1 = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared hasText:" + bool2 + ",hasNotOnlineImage:" + bool3);
          }
          int j;
          Object localObject4;
          if (bool3)
          {
            localObject1 = (im_msg_body.NotOnlineImage)((im_msg_body.Elem)localObject1).not_online_image.get();
            j = ((im_msg_body.NotOnlineImage)localObject1).file_len.get();
            if (!((im_msg_body.NotOnlineImage)localObject1).download_path.has()) {
              break label1878;
            }
            localObject4 = ((im_msg_body.NotOnlineImage)localObject1).download_path.get().toStringUtf8();
            localObject1 = localObject4;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: serverPath:" + (String)localObject4);
            }
          }
          for (localObject1 = localObject4;; localObject1 = null)
          {
            if (localObject1 != null)
            {
              localObject3 = new RichMsg.PicRec();
              localObject4 = ((RichMsg.PicRec)localObject3).localPath;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                ((RichMsg.PicRec)localObject3).size.set(j);
                ((RichMsg.PicRec)localObject3).type.set(1);
                localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                if (localObject1 == null) {
                  break label773;
                }
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                localObject2 = TransfileUtile.a((String)localObject1, j, 1, false, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2);
                }
              }
            }
            for (localObject1 = localObject3;; localObject1 = localObject3)
            {
              localObject3 = localObject1;
              for (;;)
              {
                break label301;
                if ((((AppShareID)localObject1).uiNewVer != ((AppShareID)localObject2).uiNewVer) || (Math.abs(((AppShareID)localObject2).updateTime - ((AppShareID)localObject1).updateTime) > 86400000L))
                {
                  paramMessageHandler.a().b((Entity)localObject2);
                  paramMessageHandler.a().a((Entity)localObject1);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Update DB appid = " + ((AppShareID)localObject1).strPkgName);
                  break;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Not need update DB appid = " + ((AppShareID)localObject1).strPkgName);
                break;
                localObject2 = "";
                break label526;
                localObject2 = "";
                break label569;
                if (bool2)
                {
                  localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
                  paramMsg = ((im_msg_body.Text)localObject1).str.get().toStringUtf8();
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared actionUrl:" + paramMsg + ",hasLink:" + ((im_msg_body.Text)localObject1).link.has() + ",str:" + ((im_msg_body.Text)localObject1).str.has() + ",strC:" + ((im_msg_body.Text)localObject1).str.get().toStringUtf8());
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : bytes:" + ((im_msg_body.Text)localObject1).str.get().size() + ",cont:" + ((im_msg_body.Text)localObject1).str.get() + ",content:" + Arrays.toString(((im_msg_body.Text)localObject1).str.get().toByteArray()));
                  }
                }
                else if (((im_msg_body.Elem)localObject1).custom_face.has())
                {
                  Object localObject6 = (im_msg_body.CustomFace)((im_msg_body.Elem)localObject1).custom_face.get();
                  localObject1 = ((im_msg_body.CustomFace)localObject6).str_file_path.get();
                  localObject2 = ((im_msg_body.CustomFace)localObject6).str_shortcut.get();
                  localObject3 = ((im_msg_body.CustomFace)localObject6).str_big_url.get();
                  localObject4 = ((im_msg_body.CustomFace)localObject6).str_orig_url.get();
                  String str = ((im_msg_body.CustomFace)localObject6).str_thumb_url.get();
                  ((im_msg_body.CustomFace)localObject6).str_400_url.get();
                  long l2 = ((im_msg_body.CustomFace)localObject6).uint32_file_id.get();
                  long l3 = ((im_msg_body.CustomFace)localObject6).uint32_file_type.get();
                  long l4 = ((im_msg_body.CustomFace)localObject6).uint32_server_ip.get();
                  long l5 = ((im_msg_body.CustomFace)localObject6).uint32_server_port.get();
                  long l6 = ((im_msg_body.CustomFace)localObject6).uint32_useful.get();
                  Object localObject7 = ((im_msg_body.CustomFace)localObject6).bytes_md5.get().toByteArray();
                  Object localObject5 = ((im_msg_body.CustomFace)localObject6).bytes_signature.get().toByteArray();
                  ((im_msg_body.CustomFace)localObject6).bytes_buffer.get().toByteArray();
                  localObject6 = ((im_msg_body.CustomFace)localObject6).bytes_flag.get().toByteArray();
                  localObject7 = HexUtil.a((byte[])localObject7);
                  localObject5 = HexUtil.a((byte[])localObject5);
                  localObject6 = HexUtil.a((byte[])localObject6);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgElems: decode CustomFace, dump customFace info: filePath:" + (String)localObject1 + ", shortCut:" + (String)localObject2 + ", fileID:" + (l2 & 0xFFFFFFFF) + ", fileType:" + (l3 & 0xFFFFFFFF) + ", serverIP:" + (l4 & 0xFFFFFFFF) + ", serverPort" + (l5 & 0xFFFFFFFF) + ", useful" + (l6 & 0xFFFFFFFF) + ",md5:" + (String)localObject7 + ",signature:" + (String)localObject5 + ",flag:" + (String)localObject6 + ",downURLBig:" + (String)localObject3 + ",downURLOri:" + (String)localObject4 + ",downURLThum:" + str);
                  }
                  localObject1 = "http://quntu.3g.qq.com/cgi/svr/chatimg/get?pic=" + (String)localObject1 + "&gid=" + paramLong1 + "&time=" + paramLong2 + "&msfid=" + paramMessageHandler.b.a();
                  localObject3 = new RichMsg.PicRec();
                  localObject4 = ((RichMsg.PicRec)localObject3).localPath;
                  if (localObject1 != null)
                  {
                    localObject2 = localObject1;
                    ((PBStringField)localObject4).set((String)localObject2);
                    ((RichMsg.PicRec)localObject3).size.set(0L);
                    ((RichMsg.PicRec)localObject3).type.set(1);
                    localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                    if (localObject1 == null) {
                      break label1528;
                    }
                  }
                  for (localObject2 = localObject1;; localObject2 = "")
                  {
                    ((PBStringField)localObject4).set((String)localObject2);
                    localObject2 = TransfileUtile.a((String)localObject1, 0L, 1, false, (String)localObject1);
                    paramBoolean = true;
                    break;
                    localObject2 = "";
                    break label1455;
                  }
                  if ((paramBoolean) && (!bool1))
                  {
                    paramMsg = (MessageForPic)MessageRecordFactory.a(63536);
                    paramMsg.msgtype = 63536;
                    paramMsg.msgData = ((RichMsg.PicRec)localObject3).toByteArray();
                    paramMsg.msg = ((String)localObject2);
                    paramMsg.parse();
                    paramList.add(paramMsg);
                  }
                  for (;;)
                  {
                    if (i == 0) {
                      paramMessageHandler.a(Long.valueOf(l1));
                    }
                    do
                    {
                      return;
                      if ((!paramBoolean) && (bool1))
                      {
                        paramMessageHandler = (MessageForText)MessageRecordFactory.a(64536);
                        paramMessageHandler.msgtype = 64536;
                        paramMessageHandler.msg = paramMsg;
                        paramList.add(paramMessageHandler);
                        return;
                      }
                    } while (paramMsg == null);
                    localObject1 = paramMsg.trim();
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: hasPicCnt:" + paramBoolean + ",hasTextCnt:" + bool1);
                    }
                    paramMessageHandler.d(String.valueOf(AppShareIDUtil.b(l1)));
                    paramMsg = ActionMsgUtil.a(localAppShareInfo.appshare_cookie.get().toByteArray());
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2 + ",opType:" + paramMsg.jdField_b_of_type_Int);
                    }
                    localObject1 = ActionMsgUtil.a((String)localObject2, (String)localObject1, l1, paramMsg.jdField_a_of_type_JavaLangString);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : content:" + (String)localObject2 + ",encodeMsg:" + (String)localObject1);
                    }
                    localObject2 = MessageRecordFactory.a(paramMsg.jdField_b_of_type_Int);
                    ((MessageRecord)localObject2).msgtype = paramMsg.jdField_b_of_type_Int;
                    ((MessageRecord)localObject2).msg = ((String)localObject1);
                    paramList.add(localObject2);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    label48:
    Object localObject;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()))
    {
      return;
    }
    else
    {
      while (!paramMsg.content_head.has()) {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMessagePackage: msg doesn't has the contentHead.");
          return;
        }
      }
      localObject = (msg_comm.ContentHead)paramMsg.content_head.get();
      if ((!((msg_comm.ContentHead)localObject).auto_reply.has()) || (((msg_comm.ContentHead)localObject).auto_reply.get() != 1)) {
        break label347;
      }
    }
    label347:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("<---decodeC2CMsgPkg_Buddy:elems size:").append(((List)localObject).size()).append(" isAutoReply:").append(paramBoolean2);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      if (!paramBoolean2) {
        break label353;
      }
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label48;
      }
      paramMessageHandler = BaseApplication.getContext().getString(2131369330);
      paramMsg = ((List)localObject).iterator();
      if (!paramMsg.hasNext()) {
        break label48;
      }
      localObject = (im_msg_body.Elem)paramMsg.next();
      if (!((im_msg_body.Elem)localObject).text.has()) {
        break;
      }
      paramMsg = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
      if (paramBoolean1) {
        break label48;
      }
      paramMessageHandler = paramMessageHandler + " " + paramMsg.str.get().toStringUtf8();
      paramMsg = MessageRecordFactory.a(55536);
      paramMsg.msgtype = 55536;
      paramMsg.msg = paramMessageHandler;
      paramList.add(paramMsg);
      return;
    }
    label353:
    a(paramMessageHandler, paramList, paramMsg, true, paramBoolean1, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
    }
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    label461:
    label477:
    label527:
    label572:
    label634:
    label751:
    label801:
    label943:
    long l1;
    do
    {
      Object localObject2;
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject2 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "]");
              }
              switch (i)
              {
              case 5: 
              case 6: 
              case 10: 
              case 11: 
              case 12: 
              case 14: 
              case 15: 
              case 16: 
              default: 
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "] is not implemented");
                return;
              }
            }
            catch (Exception paramMessageHandler) {}
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", paramMessageHandler);
              return;
              paramList = new SubMsgType0x3.MsgBody();
              int j;
              for (;;)
              {
                try
                {
                  paramList.mergeFrom((byte[])localObject2);
                  if (!paramList.msg_fail_notify.has()) {
                    break label572;
                  }
                  i = 0;
                  paramList = (SubMsgType0x3.FailNotify)paramList.msg_fail_notify.get();
                  if (!paramList.uint32_sessionid.has()) {
                    break label461;
                  }
                  j = paramList.uint32_sessionid.get();
                  if (!paramList.uint32_retCode.has()) {
                    break label477;
                  }
                  paramInt = paramList.uint32_retCode.get();
                  if (!paramList.bytes_reason.has()) {
                    break label527;
                  }
                  paramList = new String(paramList.bytes_reason.get().toStringUtf8());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[" + j + "], retCode[" + paramInt + "], reason[" + paramList + "]");
                  }
                  paramMessageHandler.b.a().a(String.valueOf(paramLong1), j, paramInt, paramList);
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", paramMessageHandler);
                return;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failNotify has not sessionId");
                return;
                paramInt = i;
                if (QLog.isColorLevel())
                {
                  QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], failNotify has not RetCode");
                  paramInt = i;
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], failNotify has not reason");
                  }
                  paramList = "";
                }
              }
              if (paramList.msg_progress_notify.has())
              {
                i = 0;
                paramList = (SubMsgType0x3.ProgressNotify)paramList.msg_progress_notify.get();
                if (paramList.uint32_sessionid.has())
                {
                  j = paramList.uint32_sessionid.get();
                  if (!paramList.uint32_progress.has()) {
                    break label751;
                  }
                  paramInt = paramList.uint32_progress.get();
                  if (!paramList.uint32_average_speed.has()) {
                    break label801;
                  }
                }
                for (i = paramList.uint32_average_speed.get();; i = 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[" + j + "], progress[" + paramInt + "], speed[" + i + "]");
                  }
                  paramMessageHandler.b.a().a(String.valueOf(paramLong1), j, paramInt, i);
                  return;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
                  return;
                  paramInt = i;
                  if (!QLog.isColorLevel()) {
                    break label634;
                  }
                  QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], progressNotify has not Progress");
                  paramInt = i;
                  break label634;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], progressNotify has not AverageSpeed");
                  }
                }
              }
              if (QLog.isColorLevel())
              {
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
                }
                localObject1 = new SubMsgType0x4.MsgBody();
                SubMsgType0x4.MsgBody localMsgBody;
                try
                {
                  localMsgBody = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject1).mergeFrom((byte[])localObject2);
                  if (localMsgBody.msg_not_online_file.has()) {
                    break label943;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (QLog.isColorLevel())
                {
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
                  return;
                  localObject2 = (im_msg_body.NotOnlineFile)localMsgBody.msg_not_online_file.get();
                  localObject1 = null;
                  if (localMsgBody.file_image_info.has()) {
                    localObject1 = (hummer_resv_21.FileImgInfo)localMsgBody.file_image_info.get();
                  }
                  if (paramBoolean4)
                  {
                    paramMessageHandler = new MessageRecord();
                    paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
                    l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
                    paramMessageHandler.msg = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
                    paramMessageHandler.senderuin = Long.toString(l1);
                    paramMessageHandler.msgtype = 63531;
                    paramMessageHandler.frienduin = Long.toString(paramLong1);
                    paramMessageHandler.time = paramLong2;
                    if (localObject1 != null)
                    {
                      paramMessageHandler.saveExtInfoToExtStr("file_pic_width", String.valueOf(((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get()));
                      paramMessageHandler.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get()));
                    }
                    paramList.add(paramMessageHandler);
                    return;
                  }
                  paramMessageHandler.b.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject2, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2, paramInt, (hummer_resv_21.FileImgInfo)localObject1);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<dataline> message come: cmd[0x211, 0x7]");
                  }
                  paramList = new SubMsgType0x7.MsgBody();
                  try
                  {
                    paramList = (SubMsgType0x7.MsgBody)paramList.mergeFrom((byte[])localObject2);
                    if (!paramBoolean4)
                    {
                      ((DataLineHandler)paramMessageHandler.b.a(8)).a(paramMsg, paramList);
                      return;
                    }
                  }
                  catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
        return;
        paramLong1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        paramInt = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        paramList = null;
        if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
          localObject1 = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).toByteArray();
        }
        try
        {
          paramMsg = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).sig.get().toByteArray();
          paramList = (List)localObject1;
          if (paramMsg != null)
          {
            FMDataCache.a(String.valueOf(paramLong1), paramMsg);
            paramList = (List)localObject1;
          }
        }
        catch (Exception paramList)
        {
          for (;;)
          {
            long l2;
            paramList = (List)localObject1;
          }
        }
        paramMessageHandler.b.a().a(paramLong1, paramInt, paramLong2, l1, paramList, (byte[])localObject2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<dataline printer> message come: cmd[0x211, 0x9]");
        }
        paramList = new C2CType0x211_SubC2CType0x9.MsgBody();
        try
        {
          paramList = (C2CType0x211_SubC2CType0x9.MsgBody)paramList.mergeFrom((byte[])localObject2);
          ((DataLineHandler)paramMessageHandler.b.a(8)).a(paramMsg, paramList);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x9] failed", paramMessageHandler);
      return;
      paramLong1 = paramMsg.msg_head.from_uin.get();
      paramLong2 = paramMsg.msg_head.to_uin.get();
      paramInt = paramMsg.msg_head.msg_seq.get();
      l1 = paramMsg.msg_head.msg_uid.get();
      i = paramMsg.msg_head.msg_type.get();
      l2 = paramMsg.msg_head.msg_time.get();
      ((SmartDeviceProxyMgr)paramMessageHandler.b.a(51)).a(paramLong1, paramLong2, paramInt, l1, i, "im_push.msg_push", (byte[])localObject2);
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "device msg push, receive 0x11,0xd msg, fromuin2:" + paramLong1 + ",touin:" + paramLong2 + ", msg seq:" + paramInt + ",msg_uid:" + l1 + ",msg_time:" + l2 + ",msgtype:" + i);
  }
  
  /* Error */
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 356	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   4: invokevirtual 359	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7: checkcast 358	msf/msgcomm/msg_comm$MsgHead
    //   10: astore 5
    //   12: aload 5
    //   14: getfield 688	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   17: invokevirtual 2826	msf/msgcomm/msg_comm$C2CTmpMsgHead:has	()Z
    //   20: ifeq +32 -> 52
    //   23: aload_2
    //   24: getfield 39	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   27: invokevirtual 45	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   30: ifeq +22 -> 52
    //   33: aload_2
    //   34: getfield 39	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   37: invokevirtual 49	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: checkcast 41	tencent/im/msg/im_msg_body$MsgBody
    //   43: getfield 53	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   46: invokevirtual 56	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   49: ifne +4 -> 53
    //   52: return
    //   53: aload 5
    //   55: getfield 688	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   58: invokevirtual 691	msf/msgcomm/msg_comm$C2CTmpMsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   61: checkcast 690	msf/msgcomm/msg_comm$C2CTmpMsgHead
    //   64: astore 5
    //   66: aload 5
    //   68: getfield 694	msf/msgcomm/msg_comm$C2CTmpMsgHead:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: istore 7
    //   76: aload 5
    //   78: getfield 704	msf/msgcomm/msg_comm$C2CTmpMsgHead:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   84: istore 8
    //   86: aload 4
    //   88: getfield 2875	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:d	Z
    //   91: ifne +128 -> 219
    //   94: aload_3
    //   95: getfield 706	com/tencent/mobileqq/service/message/TempSessionInfo:jdField_b_of_type_Int	I
    //   98: sipush 1006
    //   101: if_icmpne +118 -> 219
    //   104: aload 5
    //   106: getfield 2876	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   109: invokevirtual 390	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   112: astore 6
    //   114: aload 5
    //   116: getfield 2876	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   119: invokevirtual 1892	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   122: ifeq +19 -> 141
    //   125: aload 6
    //   127: ifnull +14 -> 141
    //   130: aload 6
    //   132: ldc_w 2878
    //   135: invokevirtual 627	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +43 -> 181
    //   141: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq -92 -> 52
    //   147: ldc 13
    //   149: iconst_2
    //   150: new 108	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 2880
    //   160: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 5
    //   165: getfield 2876	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   168: invokevirtual 390	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   171: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: return
    //   181: aload_0
    //   182: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: aload 5
    //   187: getfield 2876	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   190: invokevirtual 390	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   193: new 108	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   200: aload 4
    //   202: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   205: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: ldc -23
    //   210: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 2887	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 4
    //   221: getfield 2875	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:d	Z
    //   224: ifne +1398 -> 1622
    //   227: aload 5
    //   229: getfield 2828	msf/msgcomm/msg_comm$C2CTmpMsgHead:sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 318	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   235: ifeq +1387 -> 1622
    //   238: aload 5
    //   240: getfield 2828	msf/msgcomm/msg_comm$C2CTmpMsgHead:sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   243: invokevirtual 373	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   246: invokevirtual 377	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   249: astore 6
    //   251: aload 6
    //   253: astore 5
    //   255: invokestatic 1031	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   258: ifeq +49 -> 307
    //   261: ldc 13
    //   263: iconst_4
    //   264: new 108	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 2889
    //   274: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 6
    //   279: invokestatic 576	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   282: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 918
    //   288: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 6
    //   293: arraylength
    //   294: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 6
    //   305: astore 5
    //   307: aload 5
    //   309: ifnull +123 -> 432
    //   312: aload_3
    //   313: getfield 706	com/tencent/mobileqq/service/message/TempSessionInfo:jdField_b_of_type_Int	I
    //   316: lookupswitch	default:+116->432, 1001:+603->919, 1005:+325->641, 1006:+464->780, 1008:+522->838, 1009:+580->896, 1010:+672->988, 1021:+626->942, 1022:+649->965, 1023:+383->699, 1024:+441->757, 1025:+441->757, 7100:+695->1011, 7400:+718->1034
    //   432: iconst_0
    //   433: istore 8
    //   435: iload 8
    //   437: istore 7
    //   439: aload_2
    //   440: getfield 2696	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   443: invokevirtual 2697	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   446: ifeq +49 -> 495
    //   449: iload 8
    //   451: istore 7
    //   453: aload_2
    //   454: getfield 2696	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   457: invokevirtual 2700	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   460: checkcast 795	msf/msgcomm/msg_comm$ContentHead
    //   463: getfield 2703	msf/msgcomm/msg_comm$ContentHead:auto_reply	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   466: invokevirtual 98	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   469: ifeq +26 -> 495
    //   472: aload_2
    //   473: getfield 2696	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   476: invokevirtual 2700	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   479: checkcast 795	msf/msgcomm/msg_comm$ContentHead
    //   482: getfield 2703	msf/msgcomm/msg_comm$ContentHead:auto_reply	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   485: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   488: iconst_1
    //   489: if_icmpne +568 -> 1057
    //   492: iconst_1
    //   493: istore 7
    //   495: aload_2
    //   496: getfield 39	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   499: invokevirtual 49	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   502: checkcast 41	tencent/im/msg/im_msg_body$MsgBody
    //   505: getfield 53	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   508: invokevirtual 57	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   511: checkcast 55	tencent/im/msg/im_msg_body$RichText
    //   514: getfield 61	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   517: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   520: astore 5
    //   522: iload 7
    //   524: ifeq +539 -> 1063
    //   527: aload 5
    //   529: ifnull -477 -> 52
    //   532: aload 5
    //   534: invokeinterface 1513 1 0
    //   539: ifle -487 -> 52
    //   542: aload 5
    //   544: iconst_0
    //   545: invokeinterface 1514 2 0
    //   550: checkcast 83	tencent/im/msg/im_msg_body$Elem
    //   553: getfield 300	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   556: invokevirtual 2550	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   559: checkcast 280	tencent/im/msg/im_msg_body$Text
    //   562: astore_0
    //   563: aload 4
    //   565: getfield 2891	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:jdField_b_of_type_Boolean	Z
    //   568: ifne -516 -> 52
    //   571: new 108	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   578: invokestatic 2499	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   581: ldc_w 2710
    //   584: invokevirtual 2502	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   587: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 2712
    //   593: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_0
    //   597: getfield 285	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   600: invokevirtual 373	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   603: invokevirtual 2246	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   606: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: astore_0
    //   613: sipush 55536
    //   616: invokestatic 583	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   619: astore_2
    //   620: aload_2
    //   621: sipush 55536
    //   624: putfield 495	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   627: aload_2
    //   628: aload_0
    //   629: putfield 498	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   632: aload_1
    //   633: aload_2
    //   634: invokeinterface 533 2 0
    //   639: pop
    //   640: return
    //   641: aload 5
    //   643: arraylength
    //   644: iconst_2
    //   645: iadd
    //   646: newarray <illegal type>
    //   648: astore 6
    //   650: aload 6
    //   652: iconst_0
    //   653: iload 7
    //   655: i2b
    //   656: bastore
    //   657: aload 6
    //   659: iconst_1
    //   660: iload 8
    //   662: i2b
    //   663: bastore
    //   664: aload 6
    //   666: iconst_2
    //   667: aload 5
    //   669: iconst_0
    //   670: aload 5
    //   672: arraylength
    //   673: invokestatic 434	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   676: aload_0
    //   677: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   680: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   683: aload 4
    //   685: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   688: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   691: aload 6
    //   693: invokevirtual 2892	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;[B)V
    //   696: goto -264 -> 432
    //   699: aload 5
    //   701: arraylength
    //   702: iconst_2
    //   703: iadd
    //   704: newarray <illegal type>
    //   706: astore 6
    //   708: aload 6
    //   710: iconst_0
    //   711: iload 7
    //   713: i2b
    //   714: bastore
    //   715: aload 6
    //   717: iconst_1
    //   718: iload 8
    //   720: i2b
    //   721: bastore
    //   722: aload 6
    //   724: iconst_2
    //   725: aload 5
    //   727: iconst_0
    //   728: aload 5
    //   730: arraylength
    //   731: invokestatic 434	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   734: aload_0
    //   735: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   738: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   741: aload 4
    //   743: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   746: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   749: aload 6
    //   751: invokevirtual 2894	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;[B)V
    //   754: goto -322 -> 432
    //   757: aload_0
    //   758: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   761: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   764: aload 4
    //   766: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   769: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   772: aload 5
    //   774: invokevirtual 2896	com/tencent/mobileqq/service/message/MessageCache:c	(Ljava/lang/String;[B)V
    //   777: goto -345 -> 432
    //   780: aload 5
    //   782: arraylength
    //   783: iconst_2
    //   784: iadd
    //   785: newarray <illegal type>
    //   787: astore 6
    //   789: aload 6
    //   791: iconst_0
    //   792: iload 7
    //   794: i2b
    //   795: bastore
    //   796: aload 6
    //   798: iconst_1
    //   799: iload 8
    //   801: i2b
    //   802: bastore
    //   803: aload 6
    //   805: iconst_2
    //   806: aload 5
    //   808: iconst_0
    //   809: aload 5
    //   811: arraylength
    //   812: invokestatic 434	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   815: aload_0
    //   816: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   819: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   822: aload 4
    //   824: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   827: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   830: aload 6
    //   832: invokevirtual 2898	com/tencent/mobileqq/service/message/MessageCache:e	(Ljava/lang/String;[B)V
    //   835: goto -403 -> 432
    //   838: aload 5
    //   840: arraylength
    //   841: iconst_2
    //   842: iadd
    //   843: newarray <illegal type>
    //   845: astore 6
    //   847: aload 6
    //   849: iconst_0
    //   850: iload 7
    //   852: i2b
    //   853: bastore
    //   854: aload 6
    //   856: iconst_1
    //   857: iload 8
    //   859: i2b
    //   860: bastore
    //   861: aload 6
    //   863: iconst_2
    //   864: aload 5
    //   866: iconst_0
    //   867: aload 5
    //   869: arraylength
    //   870: invokestatic 434	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   873: aload_0
    //   874: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   877: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   880: aload 4
    //   882: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   885: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   888: aload 6
    //   890: invokevirtual 2900	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;[B)V
    //   893: goto -461 -> 432
    //   896: aload_0
    //   897: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   900: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   903: aload 4
    //   905: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   908: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   911: aload 5
    //   913: invokevirtual 2902	com/tencent/mobileqq/service/message/MessageCache:g	(Ljava/lang/String;[B)V
    //   916: goto -484 -> 432
    //   919: aload_0
    //   920: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   923: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   926: aload 4
    //   928: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   931: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   934: aload 5
    //   936: invokevirtual 2905	com/tencent/mobileqq/service/message/MessageCache:h	(Ljava/lang/String;[B)V
    //   939: goto -507 -> 432
    //   942: aload_0
    //   943: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   946: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   949: aload 4
    //   951: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   954: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   957: aload 5
    //   959: invokevirtual 2907	com/tencent/mobileqq/service/message/MessageCache:l	(Ljava/lang/String;[B)V
    //   962: goto -530 -> 432
    //   965: aload_0
    //   966: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   969: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   972: aload 4
    //   974: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   977: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   980: aload 5
    //   982: invokevirtual 2909	com/tencent/mobileqq/service/message/MessageCache:n	(Ljava/lang/String;[B)V
    //   985: goto -553 -> 432
    //   988: aload_0
    //   989: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   992: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   995: aload 4
    //   997: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1000: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1003: aload 5
    //   1005: invokevirtual 2911	com/tencent/mobileqq/service/message/MessageCache:k	(Ljava/lang/String;[B)V
    //   1008: goto -576 -> 432
    //   1011: aload_0
    //   1012: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1015: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1018: aload 4
    //   1020: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1023: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1026: aload 5
    //   1028: invokevirtual 2913	com/tencent/mobileqq/service/message/MessageCache:j	(Ljava/lang/String;[B)V
    //   1031: goto -599 -> 432
    //   1034: aload_0
    //   1035: getfield 338	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1038: invokevirtual 765	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1041: aload 4
    //   1043: getfield 2882	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1046: invokestatic 665	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1049: aload 5
    //   1051: invokevirtual 2915	com/tencent/mobileqq/service/message/MessageCache:i	(Ljava/lang/String;[B)V
    //   1054: goto -622 -> 432
    //   1057: iconst_0
    //   1058: istore 7
    //   1060: goto -565 -> 495
    //   1063: aload_3
    //   1064: ifnull -1012 -> 52
    //   1067: aload_2
    //   1068: getfield 356	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1071: invokevirtual 359	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1074: checkcast 358	msf/msgcomm/msg_comm$MsgHead
    //   1077: getfield 370	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1080: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1083: sipush 529
    //   1086: if_icmpne +512 -> 1598
    //   1089: aload_2
    //   1090: getfield 356	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1093: invokevirtual 359	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1096: checkcast 358	msf/msgcomm/msg_comm$MsgHead
    //   1099: getfield 617	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1102: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1105: bipush 6
    //   1107: if_icmpne +491 -> 1598
    //   1110: aload_2
    //   1111: getfield 39	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   1114: invokevirtual 49	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1117: checkcast 41	tencent/im/msg/im_msg_body$MsgBody
    //   1120: getfield 317	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1123: invokevirtual 373	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1126: invokevirtual 377	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1129: astore_0
    //   1130: new 2917	tencent/im/msg/im_msg_body$TmpPtt
    //   1133: dup
    //   1134: invokespecial 2918	tencent/im/msg/im_msg_body$TmpPtt:<init>	()V
    //   1137: astore_3
    //   1138: aload_3
    //   1139: aload_0
    //   1140: invokevirtual 2919	tencent/im/msg/im_msg_body$TmpPtt:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1143: checkcast 2917	tencent/im/msg/im_msg_body$TmpPtt
    //   1146: astore_0
    //   1147: aload_0
    //   1148: ifnull -1096 -> 52
    //   1151: aload_0
    //   1152: getfield 2920	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1155: invokevirtual 98	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1158: ifeq -1106 -> 52
    //   1161: aload_0
    //   1162: getfield 2920	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1165: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1168: iconst_4
    //   1169: if_icmpne -1117 -> 52
    //   1172: aload_0
    //   1173: getfield 2921	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1176: invokevirtual 318	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1179: ifeq -1127 -> 52
    //   1182: aload_0
    //   1183: getfield 2921	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1186: invokevirtual 373	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1189: invokevirtual 2246	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1192: astore 4
    //   1194: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1197: ifeq +30 -> 1227
    //   1200: ldc 13
    //   1202: iconst_2
    //   1203: new 108	java/lang/StringBuilder
    //   1206: dup
    //   1207: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   1210: ldc_w 2923
    //   1213: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: aload 4
    //   1218: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: new 2324	localpb/richMsg/RichMsg$PttRec
    //   1230: dup
    //   1231: invokespecial 2325	localpb/richMsg/RichMsg$PttRec:<init>	()V
    //   1234: astore_3
    //   1235: aload_3
    //   1236: getfield 2326	localpb/richMsg/RichMsg$PttRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1239: aload_0
    //   1240: getfield 2921	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1243: invokevirtual 373	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1246: invokevirtual 2246	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1249: invokevirtual 510	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1252: aload_3
    //   1253: getfield 2327	localpb/richMsg/RichMsg$PttRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1256: aload_0
    //   1257: getfield 2924	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1260: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1263: i2l
    //   1264: invokevirtual 779	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1267: aload_3
    //   1268: getfield 2328	localpb/richMsg/RichMsg$PttRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1271: iconst_2
    //   1272: invokevirtual 194	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1275: aload_3
    //   1276: getfield 2329	localpb/richMsg/RichMsg$PttRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1279: aload 4
    //   1281: invokevirtual 510	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1284: aload_3
    //   1285: getfield 2330	localpb/richMsg/RichMsg$PttRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1288: iconst_0
    //   1289: invokevirtual 1023	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   1292: aload_3
    //   1293: getfield 2331	localpb/richMsg/RichMsg$PttRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1296: ldc_w 2420
    //   1299: invokevirtual 510	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1302: aload_3
    //   1303: getfield 2332	localpb/richMsg/RichMsg$PttRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1306: iconst_0
    //   1307: invokevirtual 2286	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1310: aload_3
    //   1311: getfield 2333	localpb/richMsg/RichMsg$PttRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1314: iconst_5
    //   1315: invokevirtual 2286	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1318: aload_3
    //   1319: getfield 2423	localpb/richMsg/RichMsg$PttRec:pttFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1322: iconst_0
    //   1323: invokevirtual 2286	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1326: iconst_0
    //   1327: istore 8
    //   1329: iload 8
    //   1331: istore 7
    //   1333: aload_0
    //   1334: getfield 2927	tencent/im/msg/im_msg_body$TmpPtt:uint32_user_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1337: invokevirtual 98	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1340: ifeq +32 -> 1372
    //   1343: aload_0
    //   1344: getfield 2927	tencent/im/msg/im_msg_body$TmpPtt:uint32_user_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1347: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1350: istore 9
    //   1352: iload 9
    //   1354: iconst_1
    //   1355: if_icmpeq +13 -> 1368
    //   1358: iload 8
    //   1360: istore 7
    //   1362: iload 9
    //   1364: iconst_2
    //   1365: if_icmpne +7 -> 1372
    //   1368: iload 9
    //   1370: istore 7
    //   1372: iconst_0
    //   1373: istore 9
    //   1375: iload 9
    //   1377: istore 8
    //   1379: aload_0
    //   1380: getfield 2930	tencent/im/msg/im_msg_body$TmpPtt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1383: invokevirtual 318	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1386: ifeq +38 -> 1424
    //   1389: new 2391	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct
    //   1392: dup
    //   1393: invokespecial 2392	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:<init>	()V
    //   1396: astore 4
    //   1398: aload 4
    //   1400: aload_0
    //   1401: getfield 2930	tencent/im/msg/im_msg_body$TmpPtt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1404: invokevirtual 373	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1407: invokevirtual 377	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1410: invokevirtual 2393	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1413: pop
    //   1414: aload 4
    //   1416: getfield 2396	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:uint32_change_voice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1419: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1422: istore 8
    //   1424: aload_3
    //   1425: getfield 2444	localpb/richMsg/RichMsg$PttRec:longPttVipFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1428: iload 7
    //   1430: invokevirtual 2286	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1433: invokestatic 2338	java/lang/System:currentTimeMillis	()J
    //   1436: ldc2_w 1429
    //   1439: ldiv
    //   1440: lstore 10
    //   1442: aload_2
    //   1443: getfield 356	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1446: getfield 409	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1449: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1452: i2l
    //   1453: lstore 12
    //   1455: aload_3
    //   1456: getfield 2341	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1459: lload 10
    //   1461: invokevirtual 779	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1464: aload_3
    //   1465: getfield 2344	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1468: lload 12
    //   1470: invokevirtual 779	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1473: aload_3
    //   1474: getfield 2432	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1477: iload 8
    //   1479: invokevirtual 194	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1482: aload_3
    //   1483: getfield 2933	localpb/richMsg/RichMsg$PttRec:busiType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1486: aload_0
    //   1487: getfield 2936	tencent/im/msg/im_msg_body$TmpPtt:uint32_busi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1490: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1493: invokevirtual 194	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1496: sipush 63534
    //   1499: invokestatic 583	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1502: astore_2
    //   1503: aload_2
    //   1504: sipush 63534
    //   1507: putfield 495	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   1510: aload_2
    //   1511: aload_3
    //   1512: invokevirtual 2348	localpb/richMsg/RichMsg$PttRec:toByteArray	()[B
    //   1515: putfield 545	com/tencent/mobileqq/data/MessageRecord:msgData	[B
    //   1518: aload_2
    //   1519: checkcast 2346	com/tencent/mobileqq/data/MessageForPtt
    //   1522: invokevirtual 2350	com/tencent/mobileqq/data/MessageForPtt:parse	()V
    //   1525: aload_0
    //   1526: getfield 2939	tencent/im/msg/im_msg_body$TmpPtt:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1529: invokevirtual 1899	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1532: ifeq +47 -> 1579
    //   1535: aload_0
    //   1536: getfield 2939	tencent/im/msg/im_msg_body$TmpPtt:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1539: invokevirtual 367	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1542: lconst_0
    //   1543: lcmp
    //   1544: ifeq +35 -> 1579
    //   1547: aload_2
    //   1548: ldc_w 2941
    //   1551: new 108	java/lang/StringBuilder
    //   1554: dup
    //   1555: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   1558: aload_0
    //   1559: getfield 2939	tencent/im/msg/im_msg_body$TmpPtt:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1562: invokevirtual 367	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1565: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1568: ldc -23
    //   1570: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: invokevirtual 2807	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1579: aload_1
    //   1580: aload_2
    //   1581: invokeinterface 533 2 0
    //   1586: pop
    //   1587: return
    //   1588: astore_0
    //   1589: aload_0
    //   1590: invokevirtual 557	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1593: aconst_null
    //   1594: astore_0
    //   1595: goto -448 -> 1147
    //   1598: aload_0
    //   1599: aload_1
    //   1600: aload_2
    //   1601: iconst_1
    //   1602: aload 4
    //   1604: getfield 2891	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:jdField_b_of_type_Boolean	Z
    //   1607: aconst_null
    //   1608: aload_3
    //   1609: invokestatic 2944	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;Ljava/util/List;Lmsf/msgcomm/msg_comm$Msg;ZZLcom/tencent/mobileqq/troop/data/MessageInfo;Lcom/tencent/mobileqq/service/message/TempSessionInfo;)V
    //   1612: return
    //   1613: astore 4
    //   1615: iload 9
    //   1617: istore 8
    //   1619: goto -195 -> 1424
    //   1622: aconst_null
    //   1623: astore 5
    //   1625: goto -1318 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1628	0	paramMessageHandler	MessageHandler
    //   0	1628	1	paramList	List
    //   0	1628	2	paramMsg	msg_comm.Msg
    //   0	1628	3	paramTempSessionInfo	TempSessionInfo
    //   0	1628	4	paramDecodeProtoPkgContext	DecodeProtoPkgContext
    //   10	1614	5	localObject1	Object
    //   112	777	6	localObject2	Object
    //   74	1355	7	i	int
    //   84	1534	8	j	int
    //   1350	266	9	k	int
    //   1440	20	10	l1	long
    //   1453	16	12	l2	long
    // Exception table:
    //   from	to	target	type
    //   1138	1147	1588	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1398	1424	1613	java/lang/Exception
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo)
  {
    a(paramMessageHandler, paramList, paramMsg, paramBoolean1, paramBoolean2, paramMessageInfo, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo)
  {
    List localList = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("<---decodePBMsgElems: elems: ");
      if (localList != null) {
        break label86;
      }
    }
    label86:
    for (paramMessageHandler = null;; paramMessageHandler = Integer.valueOf(localList.size()))
    {
      QLog.d("Q.msg.MessageHandler", 2, paramMessageHandler);
      if ((localList != null) && (localList.size() > 0)) {
        break;
      }
      return;
    }
    paramMessageHandler = new StringBuilder("<---decodePBMsgElems:");
    Object localObject = MessagePBDecoderConfig.a(localList);
    int i = MessagePBDecoderConfig.a((ArrayList)localObject);
    if (QLog.isColorLevel()) {
      paramMessageHandler.append("decodeElemType:").append(i).append(" ElemStrs:").append(((ArrayList)localObject).toString()).append("\n");
    }
    MessagePBElemDecoder localMessagePBElemDecoder = new MessagePBElemDecoder();
    if (QLog.isColorLevel()) {
      QLog.d("flash", 2, "decodePBMsgElems decodeElemType=" + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (paramList.isEmpty()) {
        localMessagePBElemDecoder.d(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      }
      if (paramList.isEmpty()) {
        localMessagePBElemDecoder.h(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      }
      if (MessagePBDecoderConfig.a((ArrayList)localObject)) {
        localMessagePBElemDecoder.a((ArrayList)localObject, localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo, paramTempSessionInfo);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
      return;
      localMessagePBElemDecoder.a(localList, paramList, paramMessageHandler, paramBoolean2);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, paramMessageHandler, paramMsg);
      continue;
      localMessagePBElemDecoder.e(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, paramMessageHandler, paramBoolean1);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, paramMessageHandler, paramMsg);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, paramMessageHandler);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, paramMessageHandler);
      continue;
      localMessagePBElemDecoder.c(localList, paramList, paramMessageHandler);
      continue;
      localMessagePBElemDecoder.c(localList, paramList, paramMessageHandler, paramMsg);
      continue;
      localMessagePBElemDecoder.f(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.d(localList, paramList, paramMessageHandler, paramMsg);
      continue;
      localMessagePBElemDecoder.c(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.d(localList, paramList, paramMessageHandler);
      continue;
      localMessagePBElemDecoder.g(localList, paramList, paramMessageHandler);
      continue;
      localMessagePBElemDecoder.d(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo, paramBoolean1);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo, paramBoolean1);
      continue;
      localMessagePBElemDecoder.g(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.h(localList, paramList, paramMessageHandler, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, paramMessageHandler, paramMsg, paramBoolean1);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, paramMessageHandler, paramMsg, paramBoolean1);
      continue;
      localMessagePBElemDecoder.e(localList, paramList, paramMessageHandler);
      continue;
      localMessagePBElemDecoder.f(localList, paramList, paramMessageHandler);
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_SharpVideo return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    long l1;
    long l4;
    long l2;
    byte[] arrayOfByte2;
    int i;
    for (;;)
    {
      return;
      l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
      l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
      ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
      Object localObject = l4 + "-" + l3;
      if (QLog.isColorLevel()) {
        QLog.d("shanezhaiSHARP", 2, "<---decodeC2CMsgPkg_SharpVideo :  key:" + (String)localObject);
      }
      if (paramMessageHandler.b.a().a(l2, (String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("shanezhaiSHARP", 2, "msg has been pulled");
        }
      }
      else
      {
        l3 = MessageCache.a();
        l4 = Long.valueOf(paramMessageHandler.b.a()).longValue();
        byte[] arrayOfByte1 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
        long l5 = l3 - l1;
        arrayOfByte2 = new byte[4];
        byte[] arrayOfByte3 = new byte[4];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 4);
        System.arraycopy(arrayOfByte1, 4, arrayOfByte3, 0, 4);
        i = VideoController.a(arrayOfByte2, 4);
        int j = arrayOfByte1.length - 8 - i;
        if (j >= 0)
        {
          arrayOfByte2 = new byte[j];
          System.arraycopy(arrayOfByte1, i + 8, arrayOfByte2, 0, j);
          bool = AbstractNetChannel.a(arrayOfByte2);
          if (((!paramDecodeProtoPkgContext.jdField_a_of_type_Boolean) && (!paramDecodeProtoPkgContext.f)) || ((paramDecodeProtoPkgContext.jdField_a_of_type_Long != paramDecodeProtoPkgContext.jdField_b_of_type_Long) || ((paramDecodeProtoPkgContext.jdField_a_of_type_Long == paramDecodeProtoPkgContext.jdField_b_of_type_Long) && (!bool))))
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_SharpVideo return null:,isReaded:" + paramDecodeProtoPkgContext.jdField_a_of_type_Boolean + "syncOther:" + paramDecodeProtoPkgContext.f + ",isSharpRequest" + bool);
            }
          }
          else
          {
            if (bool)
            {
              paramMessageHandler.b.a().a(l2, (String)localObject, l3);
              a(l4, l2, 215);
            }
            if ((!VcSystemInfo.e()) || (!VcSystemInfo.f()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("shanezhaiSHARP", 2, "Discard video message cause device not support");
              }
              if (bool) {
                a(l4, l2, 212);
              }
            }
            else
            {
              if (l5 < 60L) {
                break label773;
              }
              if (bool)
              {
                paramDecodeProtoPkgContext = String.valueOf(l2);
                localObject = new hd_video_2.MsgBody();
              }
              try
              {
                ((hd_video_2.MsgBody)localObject).mergeFrom(arrayOfByte2);
                i = ((hd_video_2.MsgBody)localObject).msg_invite_body.uint32_new_business_flag.get();
                if (-1 == i)
                {
                  VideoMsgTools.a(paramMessageHandler.b, 0, 6, true, paramDecodeProtoPkgContext, String.valueOf(l4), false, null, false, new Object[] { paramMsg });
                  a(l4, l2, 208);
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("shanezhaiSHARP", 2, "Discard video message because of time out " + l5 + " s");
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                  i = -1;
                }
              }
            }
          }
        }
      }
    }
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      VideoMsgTools.a(paramMessageHandler.b, 0, 6, bool, paramDecodeProtoPkgContext, String.valueOf(l2), false, null, false, new Object[] { paramMsg });
      break;
    }
    label773:
    if (bool) {
      a(l4, l2, 211);
    }
    if (QLog.isColorLevel()) {
      QLog.d("shanezhaiSHARP", 2, "===========handleSharpVideoMessageResp 1234========");
    }
    paramMessageHandler.a(l4, arrayOfByte2, l2, (int)l1, bool);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List paramList)
  {
    Object localObject3 = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    String str = ((im_msg_body.Ptt)localObject3).bytes_file_name.get().toStringUtf8();
    int j;
    int m;
    int n;
    boolean bool;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    Object localObject2;
    int k;
    label197:
    int i;
    label218:
    long l1;
    Object localObject1;
    label295:
    Object localObject4;
    if (str.endsWith(".amr")) {
      if (SttManager.a(paramMessageHandler.b))
      {
        j = 1;
        m = b(paramMsg);
        n = ((im_msg_body.Ptt)localObject3).uint32_file_type.get();
        bool = ((im_msg_body.Ptt)localObject3).bool_valid.get();
        l2 = ((im_msg_body.Ptt)localObject3).uint64_src_uin.get();
        l3 = ((im_msg_body.Ptt)localObject3).uint32_file_size.get();
        l4 = ((im_msg_body.Ptt)localObject3).uint32_file_id.get() & 0xFFFFFFFF;
        l5 = ((im_msg_body.Ptt)localObject3).uint32_server_ip.get();
        l6 = ((im_msg_body.Ptt)localObject3).uint32_server_port.get();
        localObject2 = ((im_msg_body.Ptt)localObject3).bytes_file_uuid.get().toByteArray();
        paramMessageHandler = ((im_msg_body.Ptt)localObject3).bytes_file_md5.get().toByteArray();
        if (!((im_msg_body.Ptt)localObject3).uint32_format.has()) {
          break label934;
        }
        k = ((im_msg_body.Ptt)localObject3).uint32_format.get();
        if (!((im_msg_body.Ptt)localObject3).uint32_time.has()) {
          break label940;
        }
        i = ((im_msg_body.Ptt)localObject3).uint32_time.get();
        l1 = RecordParams.b(i);
        if (!((im_msg_body.Ptt)localObject3).bytes_down_para.has()) {
          break label1402;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPD", 2, "receive ptt msg , bytes_down_para has ! " + ((im_msg_body.Ptt)localObject3).bytes_down_para.get());
        }
        localObject1 = ((im_msg_body.Ptt)localObject3).bytes_down_para.get();
        if (localObject1 == null) {
          break label1402;
        }
        localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("SPD", 2, "receive ptt msg , url : " + (String)localObject1 + " srcuin " + l2 + "filename" + str);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "<---decodeGrpDisMsgPkg_PTT voiceType：" + k + " voiceLengh:" + l1);
        }
        localObject4 = HexUtil.a((byte[])localObject2);
        localObject2 = HexUtil.a(paramMessageHandler);
        if (!((im_msg_body.Ptt)localObject3).bytes_group_file_key.has()) {
          break label1397;
        }
        paramMessageHandler = ((im_msg_body.Ptt)localObject3).bytes_group_file_key.get().toByteArray();
      }
    }
    for (;;)
    {
      try
      {
        paramMessageHandler = new String(paramMessageHandler, "utf-8");
        if (localObject2 != null) {
          break label1394;
        }
        localObject2 = "";
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
          localStringBuilder.append(" pttType:").append(n).append(" isValid:").append(bool).append(" srcUin:").append(l2).append(" fileSize:").append(l3 & 0xFFFFFFFF).append(" fileID").append(l4).append(" serverIP:").append(l5 & 0xFFFFFFFF).append(" serverPort:").append(l6 & 0xFFFFFFFF).append(" fileName:").append(str).append(" uuidStr:").append((String)localObject4).append(" md5Str:").append((String)localObject2).append(" GrpFileKey:").append(paramMessageHandler);
          QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
        }
        if (((im_msg_body.Ptt)localObject3).bytes_pb_reserve.has()) {
          localObject4 = new ptt_reserve.ReserveStruct();
        }
      }
      catch (UnsupportedEncodingException paramMessageHandler)
      {
        try
        {
          ((ptt_reserve.ReserveStruct)localObject4).mergeFrom(((im_msg_body.Ptt)localObject3).bytes_pb_reserve.get().toByteArray());
          i = ((ptt_reserve.ReserveStruct)localObject4).uint32_change_voice.get();
          TransfileUtile.a(str, 0L, 2, false, str);
          localObject3 = new RichMsg.PttRec();
          ((RichMsg.PttRec)localObject3).localPath.set(str);
          ((RichMsg.PttRec)localObject3).size.set(0L);
          ((RichMsg.PttRec)localObject3).type.set(2);
          ((RichMsg.PttRec)localObject3).uuid.set(str);
          ((RichMsg.PttRec)localObject3).isRead.set(false);
          ((RichMsg.PttRec)localObject3).md5.set((String)localObject2);
          ((RichMsg.PttRec)localObject3).isReport.set(0);
          ((RichMsg.PttRec)localObject3).version.set(5);
          ((RichMsg.PttRec)localObject3).groupFileID.set(l4);
          ((RichMsg.PttRec)localObject3).pttFlag.set(j);
          ((RichMsg.PttRec)localObject3).longPttVipFlag.set(m);
          if (paramMessageHandler != null) {
            ((RichMsg.PttRec)localObject3).group_file_key.set(paramMessageHandler);
          }
          l2 = System.currentTimeMillis() / 1000L;
          l3 = paramMsg.msg_head.msg_time.get();
          ((RichMsg.PttRec)localObject3).msgRecTime.set(l2);
          ((RichMsg.PttRec)localObject3).msgTime.set(l3);
          ((RichMsg.PttRec)localObject3).voiceType.set(k);
          ((RichMsg.PttRec)localObject3).voiceLength.set(Utils.a(l1));
          ((RichMsg.PttRec)localObject3).voiceChangeFlag.set(i);
          ((RichMsg.PttRec)localObject3).directUrl.set((String)localObject1);
          paramMessageHandler = MessageRecordFactory.a(63534);
          paramMessageHandler.msgtype = 63534;
          paramMessageHandler.msgData = ((RichMsg.PttRec)localObject3).toByteArray();
          ((MessageForPtt)paramMessageHandler).parse();
          paramList.add(paramMessageHandler);
          if (paramMessageHandler == null)
          {
            return;
            j = 0;
            break;
            label934:
            k = 0;
            break label197;
            label940:
            i = 0;
            break label218;
            paramMessageHandler = paramMessageHandler;
            paramMessageHandler = null;
          }
        }
        catch (Exception localException)
        {
          i = 0;
          continue;
          localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          localObject2 = new StringBuilder();
          if ((localObject1 == null) || (((List)localObject1).size() <= 0))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            ((StringBuilder)localObject2).append("elems:null || elems.size() <= 0");
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
            return;
          }
          if (QLog.isColorLevel()) {
            ((StringBuilder)localObject2).append("elemsSize").append(((List)localObject1).size()).append("\n");
          }
          i = 0;
          if (i < ((List)localObject1).size())
          {
            paramMsg = (im_msg_body.Elem)((List)localObject1).get(i);
            if (paramMsg.near_by_msg.has())
            {
              if (QLog.isColorLevel()) {
                ((StringBuilder)localObject2).append("elemType: near_by_msg;");
              }
              paramMsg = paramMsg.near_by_msg;
              if ((paramMsg.uint32_identify_type.has()) && (paramMsg.uint32_identify_type.get() == 1))
              {
                paramMessageHandler.saveExtInfoToExtStr("identify_flag", "true");
                if (QLog.isColorLevel()) {
                  ((StringBuilder)localObject2).append("has identify;");
                }
              }
              i += 1;
              continue;
            }
            if (paramMsg.pub_group.has())
            {
              paramMsg = (im_msg_body.PubGroup)paramMsg.pub_group.get();
              if (paramMsg == null) {
                continue;
              }
              j = paramMsg.uint32_gender.get();
              paramList = paramMsg.bytes_nickname.get().toStringUtf8();
              paramMessageHandler.saveExtInfoToExtStr("hotchat_gender", String.valueOf(j));
              paramMsg = paramList;
              if (paramList == null) {
                paramMsg = "";
              }
              paramMessageHandler.saveExtInfoToExtStr("hotchat_nick", paramMsg);
              if (!QLog.isColorLevel()) {
                continue;
              }
              ((StringBuilder)localObject2).append("has pub_group;");
              continue;
            }
            if ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).uint32_olympic_torch.has())) {
              continue;
            }
            j = paramMsg.general_flags.uint32_olympic_torch.get();
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject2).append("has olympicTorch:").append(j).append(";");
            }
            if (j <= 0) {
              continue;
            }
            paramMessageHandler.saveExtInfoToExtStr("olympic_torch_flg", j + "");
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
          return;
        }
      }
      i = 0;
      continue;
      label1394:
      continue;
      label1397:
      paramMessageHandler = null;
      continue;
      label1402:
      localObject1 = "";
      break label295;
      paramMessageHandler = null;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline: return isReaded4DataLine:" + paramBoolean);
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new upf(paramMessageHandler, paramMsg));
      return;
    }
    ((DataLineHandler)paramMessageHandler.b.a(8)).a(paramMsg);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    MessageCache.a();
    Long.valueOf(paramMessageHandler.b.a()).longValue();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("shanezhai", 2, "recv MultiVideo offline msg !msgTime is:" + l1);
    }
    paramMessageHandler.b.a().a(arrayOfByte, paramMsg);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_AddFriend return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
    }
    String str;
    do
    {
      do
      {
        return;
        long l1 = Long.valueOf(paramMessageHandler.b.a()).longValue();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
        if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
          paramMessageHandler.a().a(l1, l2, s, 64530 - (s - 187), paramMsg, paramInt);
        }
        localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      } while (localObject == null);
      paramMsg = "" + ((msg_comm.MsgHead)localObject).auth_uin.get();
      str = ((msg_comm.MsgHead)localObject).auth_nick.get();
      Object localObject = ((msg_comm.MsgHead)localObject).auth_remark.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys auUin:" + paramMsg + "aunick:" + str + "auRemark:" + (String)localObject);
      }
      if ((!TextUtils.isEmpty(paramMsg)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysremark", 2, "FriendSys saveremark");
        }
        paramMessageHandler.b(paramMsg, (String)localObject);
      }
    } while ((TextUtils.isEmpty(paramMsg)) || (TextUtils.isEmpty(str)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys savenick");
    }
    paramMessageHandler.a(paramMsg, str);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    paramMessageHandler = paramMsgType0x210.msg_content.get().toByteArray();
    paramMsgType0x210 = new Submsgtype0x35.MsgBody();
    try
    {
      int i = ((Submsgtype0x35.MsgBody)paramMsgType0x210.mergeFrom(paramMessageHandler)).uint32_bubble_timestamp.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 bubble push timestamp=" + i);
      }
      return;
    }
    catch (Exception paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x35.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Submsgtype0x8a.ReqBody paramReqBody, long paramLong, boolean paramBoolean)
  {
    int i = 0;
    long l = 0L;
    Object localObject1 = (ArrayList)paramReqBody.msg_info.get();
    Object localObject2 = new msgrevoke_userdef.UinTypeUserDef();
    Object localObject3;
    try
    {
      ((msgrevoke_userdef.UinTypeUserDef)localObject2).mergeFrom(paramReqBody.bytes_reserved.get().toByteArray());
      int j = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint32_from_uin_type.get();
      if (j == 1)
      {
        i = 1000;
        l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
      }
      for (;;)
      {
        localObject2 = new ArrayList();
        paramReqBody = ((ArrayList)localObject1).iterator();
        while (paramReqBody.hasNext())
        {
          localObject1 = (Submsgtype0x8a.MsgInfo)paramReqBody.next();
          localObject3 = new RevokeMsgInfo();
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Int = i;
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_from_uin.get());
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_to_uin.get());
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_JavaLangString = String.valueOf(l);
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Long = ((short)((Submsgtype0x8a.MsgInfo)localObject1).uint32_msg_seq.get());
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_uid.get();
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_time.get();
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_div_seq.get();
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_num.get();
          ((RevokeMsgInfo)localObject3).d = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_index.get();
          ((ArrayList)localObject2).add(localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg," + ((RevokeMsgInfo)localObject3).toString());
          }
        }
        if (j == 2)
        {
          i = 1004;
          l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg, prase uintypeUserdef error");
      }
    }
    label765:
    for (;;)
    {
      if (!paramBoolean)
      {
        paramQQAppInterface.a().a((ArrayList)localObject2, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b subaccount msg");
      }
      if (!((ArrayList)localObject2).isEmpty())
      {
        String str1 = Long.toString(paramLong);
        String str2 = paramQQAppInterface.a();
        SubAccountManager localSubAccountManager = (SubAccountManager)paramQQAppInterface.getManager(60);
        if (localSubAccountManager != null)
        {
          List localList = localSubAccountManager.a(str1);
          paramReqBody = null;
          localObject1 = null;
          Iterator localIterator1 = ((ArrayList)localObject2).iterator();
          if (localIterator1.hasNext())
          {
            localObject2 = (RevokeMsgInfo)localIterator1.next();
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext())
            {
              localObject3 = (SubAccountMessage)localIterator2.next();
              if ((((RevokeMsgInfo)localObject2).jdField_a_of_type_Long == ((SubAccountMessage)localObject3).shmsgseq) && (((RevokeMsgInfo)localObject2).jdField_b_of_type_Long == ((SubAccountMessage)localObject3).msgUid))
              {
                localObject1 = localObject3;
                paramReqBody = (Submsgtype0x8a.ReqBody)localObject2;
              }
            }
          }
          for (;;)
          {
            break;
            if (paramReqBody == null) {
              break label765;
            }
            localObject2 = (SubAccountMessage)((SubAccountMessage)localObject1).deepCopyByReflect();
            ((SubAccountMessage)localObject2).msg = "对方".concat(BaseApplicationImpl.a().getString(2131372240));
            ((SubAccountMessage)localObject2).unreadNum = Math.max(0, ((SubAccountMessage)localObject1).unreadNum - 1);
            ((SubAccountMessage)localObject2).time = paramReqBody.jdField_c_of_type_Long;
            ((SubAccountMessage)localObject2).needNotify = paramQQAppInterface.isBackground_Pause;
            ((SubAccountMessage)localObject2).mTimeString = TimeFormatterUtils.a(((SubAccountMessage)localObject2).time * 1000L, true, SubAccountControll.jdField_c_of_type_JavaLangString);
            ((SubAccountMessage)localObject2).mEmoRecentMsg = new QQText(((SubAccountMessage)localObject2).msg, 0);
            if (localSubAccountManager != null) {
              localSubAccountManager.a((SubAccountMessage)localObject2);
            }
            SubAccountControll.a(paramQQAppInterface, str1, 6);
            paramReqBody = ((SubAccountMessage)localObject2).convertToMessageRecord();
            paramReqBody.istroop = 7000;
            paramReqBody.frienduin = str1;
            paramQQAppInterface.a().c(paramReqBody.frienduin, paramReqBody.istroop, -1);
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramReqBody);
            paramQQAppInterface.a().a((ArrayList)localObject1, str2, false, false, true);
            paramQQAppInterface.D();
            paramReqBody = new SubAccountBackProtocData();
            paramReqBody.jdField_b_of_type_JavaLangString = str2;
            paramReqBody.jdField_c_of_type_JavaLangString = str1;
            paramReqBody.jdField_c_of_type_Boolean = true;
            paramReqBody.d = true;
            paramReqBody.p = 0;
            paramQQAppInterface.a().a().a(8003, true, paramReqBody);
            return;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = new Submsgtype0x4e.MsgBody();
    for (;;)
    {
      int i;
      long l1;
      long l2;
      long l3;
      String str;
      int j;
      try
      {
        paramArrayOfByte = (Submsgtype0x4e.MsgBody)((Submsgtype0x4e.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        i = paramArrayOfByte.uint32_appid.get();
        l1 = paramArrayOfByte.uint64_group_id.get();
        l2 = paramArrayOfByte.uint64_group_code.get();
        if (paramArrayOfByte.msg_group_bulletin.has())
        {
          l3 = (int)MessageCache.a();
          localObject = paramArrayOfByte.msg_group_bulletin.rpt_msg_content.get();
          new ArrayList();
          paramArrayOfByte = paramQQAppInterface.a().createEntityManager();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          Submsgtype0x4e.GroupBulletin.Content localContent = (Submsgtype0x4e.GroupBulletin.Content)((Iterator)localObject).next();
          l3 = localContent.uint64_uin.get();
          str = localContent.bytes_feedid.get().toStringUtf8();
          j = localContent.uint32_time.get();
          if (TroopNotificationHelper.b(str))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopNotificationHelper", 2, "notice is loading");
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x4e.");
        }
      }
      if ((TroopNotificationCache)paramArrayOfByte.a(TroopNotificationCache.class, "troopUin=? and feedsId=?", new String[] { String.valueOf(l2), str }) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "notice has exist!");
        }
      }
      else {
        TroopNotificationHelper.a(paramQQAppInterface, i, l1, l2, l3, str, j, "OidbSvc.0x852_35", (short)23, false, false);
      }
    }
    paramArrayOfByte.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    submsgtype0xb1.MsgBody localMsgBody = new submsgtype0xb1.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = 2000L;
      if (!paramBoolean) {
        l1 = 10000L;
      }
      ThreadManager.c().postDelayed(new upg(paramQQAppInterface, localMsgBody, paramBoolean), l1);
      long l2;
      if (localMsgBody.deal_info.has())
      {
        l1 = localMsgBody.deal_info.uint64_group_code.get();
        l2 = localMsgBody.deal_info.uint64_uin.get();
        paramArrayOfByte = localMsgBody.deal_info.str_id.get();
        int i = localMsgBody.deal_info.uint32_deal_result.get();
        if (paramQQAppInterface.a().equals(l2 + ""))
        {
          Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box_by_invite_id");
          localIntent.putExtra("groupId", l1);
          localIntent.putExtra("inviteId", paramArrayOfByte);
          paramQQAppInterface.a().sendBroadcast(localIntent);
        }
        if (i == 0) {
          paramQQAppInterface.a().a(l1, l2, paramArrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "recv 0x210_0xb1, msgBody.deal_info.has()==》troopUin：" + l1 + ", memUin:" + l2 + ", invitedId:" + paramArrayOfByte + ", dealResult:" + i);
        }
      }
      if (localMsgBody.univite_info.has())
      {
        l1 = localMsgBody.univite_info.uint64_group_code.get();
        l2 = localMsgBody.univite_info.uint64_uin.get();
        paramArrayOfByte = localMsgBody.univite_info.str_id.get();
        paramQQAppInterface.a().b(l1, l2, paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "recv 0x210_0xb1, msgBody.univite_info.has()==》troopUin：" + l1 + ", memUin:" + l2 + ", invitedId:" + paramArrayOfByte + ", dealResult:" + paramArrayOfByte);
        }
        if (!paramBoolean) {
          a.put(paramArrayOfByte, Long.valueOf(System.currentTimeMillis() / 1000L));
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.MessageHandler", 2, "recv 0x210_0xb1, prase msgBody error");
    }
  }
  
  private static void a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      byte[] arrayOfByte = new byte[13];
      PkgTools.a(arrayOfByte, 0, (short)1);
      paramAtTroopMemberInfo.writeTo(arrayOfByte, 2);
      paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject2 = paramQQAppInterface.a().b(AppConstants.aJ, 0);
    Object localObject1 = new SubMsgType0x76.MsgBody();
    int j;
    int i;
    try
    {
      ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      j = ((SubMsgType0x76.MsgBody)localObject1).uint32_msg_type.get();
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder().append("receive push, msg type = ").append(j).append(", local msg count = ");
        if (localObject2 != null)
        {
          i = ((List)localObject2).size();
          QLog.d("ActivateFriends.Processor", 2, i);
        }
      }
      else
      {
        if (localObject2 == null) {
          break label238;
        }
        paramArrayOfByte = ((List)localObject2).iterator();
        for (;;)
        {
          label105:
          if (paramArrayOfByte.hasNext())
          {
            localObject2 = (MessageRecord)paramArrayOfByte.next();
            if ((localObject2 instanceof MessageForActivateFriends))
            {
              localObject2 = (MessageForActivateFriends)localObject2;
              if ((((MessageForActivateFriends)localObject2).getMsgBody() != null) && (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() != j)) {
                continue;
              }
              paramQQAppInterface.a().b(AppConstants.aJ, 0, ((MessageForActivateFriends)localObject2).uniseq);
              continue;
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends", 2, "parse push got error.", paramQQAppInterface);
      }
    }
    label238:
    ActivateFriendsManager localActivateFriendsManager;
    label386:
    do
    {
      i = -1;
      break;
      if (!QLog.isColorLevel()) {
        break label105;
      }
      QLog.e("ActivateFriends.Processor", 2, "local data is error." + localObject2);
      break label105;
      paramArrayOfByte = MessageRecordFactory.a(60533);
      paramArrayOfByte.selfuin = paramQQAppInterface.a();
      paramArrayOfByte.frienduin = AppConstants.aJ;
      paramArrayOfByte.istroop = 9002;
      paramArrayOfByte.senderuin = "";
      localObject2 = (FriendsManager)paramQQAppInterface.getManager(50);
      localActivateFriendsManager = (ActivateFriendsManager)paramQQAppInterface.getManager(84);
      if ((j != 1) || (localActivateFriendsManager.jdField_a_of_type_Boolean)) {
        break label448;
      }
      if (((SubMsgType0x76.MsgBody)localObject1).msg_geographic_notify.rpt_msg_one_friend.get().size() <= 0) {
        break label429;
      }
      localObject2 = (MessageForActivateFriends)paramArrayOfByte;
      ((MessageForActivateFriends)localObject2).msg = ActivateFriendsManager.a(paramQQAppInterface.a(), (SubMsgType0x76.MsgBody)localObject1);
      ((MessageForActivateFriends)localObject2).msgBody = ((SubMsgType0x76.MsgBody)localObject1);
      ((MessageForActivateFriends)localObject2).msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
      break label531;
      ReportController.b(paramQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject2, localActivateFriendsManager.d, 0, "", "", "", "");
    } while (paramArrayOfByte == null);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramArrayOfByte);
    paramQQAppInterface.a().a((ArrayList)localObject1, paramQQAppInterface.a(), paramQQAppInterface.isBackground_Stop);
    localActivateFriendsManager.a(j);
    return true;
    label429:
    if (QLog.isColorLevel())
    {
      QLog.d("ActivateFriends", 2, "Geo friend list size = 0");
      break label566;
      label448:
      if (j != 2) {
        break label579;
      }
      if (((SubMsgType0x76.MsgBody)localObject1).msg_birthday_notify.rpt_msg_one_friend.get().size() > 0)
      {
        localObject2 = (MessageForActivateFriends)paramArrayOfByte;
        ((MessageForActivateFriends)localObject2).msgBody = ((SubMsgType0x76.MsgBody)localObject1);
        ((MessageForActivateFriends)localObject2).msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
        ((MessageForActivateFriends)localObject2).msg = ActivateFriendsManager.a(paramQQAppInterface.a(), (SubMsgType0x76.MsgBody)localObject1);
        break label571;
      }
      if (!QLog.isColorLevel()) {
        break label574;
      }
      QLog.d("ActivateFriends", 2, "Birth friend list size = 0");
      break label574;
    }
    label531:
    label566:
    label571:
    label574:
    label579:
    label584:
    label589:
    for (;;)
    {
      localObject2 = "0X8004E04";
      break;
      if ((j == 1) || (j == 2)) {
        if (j != 1) {
          break label584;
        }
      }
      for (localObject1 = "0X8004E03";; localObject1 = "0X8004E04")
      {
        if (j != 1) {
          break label589;
        }
        localObject2 = "0X8004E03";
        break;
        paramArrayOfByte = null;
        break label531;
        for (;;)
        {
          break;
          paramArrayOfByte = null;
        }
        paramArrayOfByte = null;
        break label531;
        break label386;
      }
    }
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 1000: 
      return 3;
    case 1005: 
      return 6;
    case 1008: 
      return 8;
    case 1006: 
      return 10;
    case 1004: 
      return 5;
    case 1009: 
      return 11;
    case 3000: 
      return 4;
    case 1: 
      return 2;
    case 1001: 
      return 12;
    case 1020: 
      return 14;
    case 1021: 
      return 16;
    case 1022: 
      return 17;
    case 1023: 
      return 18;
    case 1024: 
    case 1025: 
      return 15;
    case 1010: 
      return 19;
    case 7100: 
      return 20;
    case 7400: 
      return 22;
    }
    return 21;
  }
  
  public static int b(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return 0;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.has()))
      {
        int i = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.get();
        if (i == 1) {
          return 1;
        }
        if (i == 2) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  public static im_msg_body.RichText b(ChatMessage paramChatMessage)
  {
    im_msg_body.RichText localRichText = null;
    Object localObject1;
    if (paramChatMessage == null) {
      localObject1 = localRichText;
    }
    for (;;)
    {
      return (im_msg_body.RichText)localObject1;
      localObject1 = localRichText;
      if (!(paramChatMessage instanceof MessageForArkApp)) {
        continue;
      }
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      localObject1 = localRichText;
      if (paramChatMessage == null) {
        continue;
      }
      localObject1 = localRichText;
      if (paramChatMessage.ark_app_message == null) {
        continue;
      }
      Object localObject2 = paramChatMessage.ark_app_message.toPbData();
      localObject1 = localRichText;
      if (localObject2 == null) {
        continue;
      }
      localObject1 = localRichText;
      if (localObject2.length == 0) {
        continue;
      }
      localObject2 = StructMsgUtils.b((byte[])localObject2);
      localObject1 = localRichText;
      if (localObject2 == null) {
        continue;
      }
      localObject1 = localRichText;
      if (localObject2.length == 0) {
        continue;
      }
      localObject1 = new ByteArrayOutputStream();
      try
      {
        ((ByteArrayOutputStream)localObject1).write(1);
        ((ByteArrayOutputStream)localObject1).write((byte[])localObject2);
        localRichText = new im_msg_body.RichText();
        localObject2 = new im_msg_body.LightAppElem();
        ((im_msg_body.LightAppElem)localObject2).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject1).toByteArray()));
        localObject1 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject1).light_app.set((MessageMicro)localObject2);
        localRichText.elems.add((MessageMicro)localObject1);
        if (paramChatMessage.ark_app_message.compatibleText != null) {
          paramChatMessage = paramChatMessage.ark_app_message.compatibleText;
        }
        for (;;)
        {
          localObject1 = localRichText;
          if (paramChatMessage == null) {
            break;
          }
          localObject1 = localRichText;
          if (paramChatMessage.length() <= 0) {
            break;
          }
          localObject1 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(paramChatMessage));
          paramChatMessage = new im_msg_body.Elem();
          paramChatMessage.text.set((MessageMicro)localObject1);
          localRichText.elems.add(paramChatMessage);
          return localRichText;
          paramChatMessage = paramChatMessage.getSummery();
          if ((paramChatMessage == null) || (paramChatMessage.length() == 0)) {
            paramChatMessage = BaseApplication.getContext().getString(2131370364);
          } else {
            paramChatMessage = String.format(BaseApplication.getContext().getString(2131370365), new Object[] { paramChatMessage });
          }
        }
        return null;
      }
      catch (Exception paramChatMessage) {}
    }
  }
  
  public static im_msg_body.RichText b(MessageForApollo paramMessageForApollo)
  {
    Object localObject1 = new im_msg_body.ApolloActMsg();
    Object localObject2 = paramMessageForApollo.mApolloMessage;
    ((im_msg_body.ApolloActMsg)localObject1).uint32_action_id.set(((ApolloMessage)localObject2).id);
    ((im_msg_body.ApolloActMsg)localObject1).uint32_flag.set(((ApolloMessage)localObject2).flag);
    ((im_msg_body.ApolloActMsg)localObject1).uint32_peer_uin.set(Utils.a(((ApolloMessage)localObject2).peer_uin));
    ((im_msg_body.ApolloActMsg)localObject1).uint32_sender_ts.set(Utils.a(((ApolloMessage)localObject2).sender_ts));
    ((im_msg_body.ApolloActMsg)localObject1).uint32_peer_ts.set(Utils.a(((ApolloMessage)localObject2).peer_ts));
    ((im_msg_body.ApolloActMsg)localObject1).int32_sender_status.set(((ApolloMessage)localObject2).sender_status);
    ((im_msg_body.ApolloActMsg)localObject1).int32_peer_status.set(((ApolloMessage)localObject2).peer_status);
    if (((ApolloMessage)localObject2).name != null) {
      ((im_msg_body.ApolloActMsg)localObject1).bytes_action_name.set(ByteStringMicro.copyFrom(((ApolloMessage)localObject2).name));
    }
    if (((ApolloMessage)localObject2).text != null) {
      ((im_msg_body.ApolloActMsg)localObject1).bytes_action_text.set(ByteStringMicro.copyFrom(((ApolloMessage)localObject2).text));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
      ((im_msg_body.ApolloActMsg)localObject1).input_text.set(ByteStringMicro.copyFrom(paramMessageForApollo.inputText.getBytes()));
    }
    im_msg_body.Text localText = new im_msg_body.Text();
    paramMessageForApollo = "[动作消息]";
    if (((ApolloMessage)localObject2).name != null) {
      paramMessageForApollo = "[动作消息]" + new String(((ApolloMessage)localObject2).name);
    }
    localText.str.set(ByteStringMicro.copyFromUtf8(paramMessageForApollo));
    paramMessageForApollo = new im_msg_body.RichText();
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).apollo_msg.set((MessageMicro)localObject1);
    paramMessageForApollo.elems.add((MessageMicro)localObject2);
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).text.set(localText);
    paramMessageForApollo.elems.add((MessageMicro)localObject1);
    return paramMessageForApollo;
  }
  
  public static void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_QCall return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    do
    {
      for (;;)
      {
        return;
        long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
        Object localObject1 = l4 + "-" + l3;
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall :  key:" + (String)localObject1);
        }
        if (paramMessageHandler.b.a().a(l2, (String)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("decodeC2CMsgPkg_QCall", 2, "msg has been pulled");
          }
        }
        else
        {
          l3 = MessageCache.a();
          l4 = Long.valueOf(paramMessageHandler.b.a()).longValue();
          paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          localObject1 = new byte[4];
          Object localObject2 = new byte[4];
          System.arraycopy(paramMsg, 0, localObject1, 0, 4);
          System.arraycopy(paramMsg, 4, localObject2, 0, 4);
          int i = VideoController.a((byte[])localObject1, 4);
          int j = VideoController.a((byte[])localObject2, 4);
          if ((i <= 0) || (j <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("decodeC2CMsgPkg_QCall", 2, "invalid head length:" + i + " or body length:" + j);
            }
          }
          else
          {
            localObject1 = null;
            try
            {
              localObject2 = new head.Head();
              byte[] arrayOfByte = new byte[i];
              System.arraycopy(paramMsg, 8, arrayOfByte, 0, i);
              ((head.Head)localObject2).mergeFrom(arrayOfByte);
              int k = ((head.Head)localObject2).msg_msg_head.msg_content_head.uint32_type.get();
              int m = ((head.Head)localObject2).msg_msg_head.msg_content_head.uint32_subtype.get();
              if ((k == 562) && (m == 17))
              {
                localObject2 = new im_msg_body.MsgBody();
                arrayOfByte = new byte[j];
                System.arraycopy(paramMsg, i + 8, arrayOfByte, 0, j);
                ((im_msg_body.MsgBody)localObject2).mergeFrom(arrayOfByte);
                paramMsg = ((im_msg_body.MsgBody)localObject2).msg_content.get().toByteArray();
                if (paramMsg == null)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("decodeC2CMsgPkg_QCall", 2, "msg sharp content null, return;");
                }
              }
              else
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("decodeC2CMsgPkg_QCall", 2, "error msgType:" + k + ", or subType:" + m);
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                paramMsg = (msg_comm.Msg)localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.d("decodeC2CMsgPkg_QCall", 2, "error when process qcall offline msg", localException);
                  paramMsg = (msg_comm.Msg)localObject1;
                }
              }
              boolean bool = AbstractNetChannel.a(paramMsg);
              if (((!paramDecodeProtoPkgContext.jdField_a_of_type_Boolean) && (!paramDecodeProtoPkgContext.f)) || ((paramDecodeProtoPkgContext.jdField_a_of_type_Long != paramDecodeProtoPkgContext.jdField_b_of_type_Long) || ((paramDecodeProtoPkgContext.jdField_a_of_type_Long == paramDecodeProtoPkgContext.jdField_b_of_type_Long) && (!bool))))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall return null:,isReaded:" + paramDecodeProtoPkgContext.jdField_a_of_type_Boolean + "syncOther:" + paramDecodeProtoPkgContext.f + ",isSharpRequest" + bool);
                }
              }
              else
              {
                paramDecodeProtoPkgContext = CharacterUtil.a(l2);
                localObject1 = CharacterUtil.a(l4);
                try
                {
                  new QavWrapper(BaseApplicationImpl.getContext()).a(new uph(paramMsg, l3 - l1, (String)localObject1, paramDecodeProtoPkgContext, paramMessageHandler, l4, l2, l1, bool));
                  return;
                }
                catch (Exception paramMessageHandler) {}
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("decodeC2CMsgPkg_QCall", 2, "exception when process qcall offline msg", paramMessageHandler);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, submsgtype0xb1.InviteInfo paramInviteInfo, boolean paramBoolean)
  {
    submsgtype0xb1.InviteInfo localInviteInfo;
    long l1;
    if (paramInviteInfo.has())
    {
      localInviteInfo = (submsgtype0xb1.InviteInfo)paramInviteInfo.get();
      l1 = System.currentTimeMillis() / 1000L;
      if (l1 - localInviteInfo.uint32_expire_time.get() <= 900L) {
        break label109;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "邀请过期了=》troopUin:" + localInviteInfo.uint64_group_code.get() + "|uint32_expire_time:" + localInviteInfo.uint32_expire_time.get() + ", currentTime:" + l1);
      }
    }
    label109:
    Object localObject;
    do
    {
      do
      {
        long l2;
        do
        {
          return;
          if ((paramBoolean) || (!a.containsKey(localInviteInfo.str_id.get()))) {
            break;
          }
          l2 = ((Long)a.get(localInviteInfo.str_id.get())).longValue();
          if (l1 - l2 >= 10L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "离线-上线的时候收到邀请的前10s内先收到了取消的邀请=》troopUin:" + localInviteInfo.uint64_group_code.get() + "|receiveUnInviteTime:" + l2 + ", currentTime:" + l1);
        return;
        paramBoolean = paramQQAppInterface.a().c(localInviteInfo.uint64_group_code.get());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "msgBody.invite_info.has()==》troopUin:" + localInviteInfo.uint64_group_code.get() + "|uint32_expire_time:" + localInviteInfo.uint32_expire_time.get() + ", currentTime:" + l1 + ", hasGroupVideo:" + paramBoolean);
        }
        localObject = (TroopManager)paramQQAppInterface.getManager(51);
      } while ((!paramBoolean) || (((TroopManager)localObject).c(localInviteInfo.uint64_group_code.get() + "", localInviteInfo.uint64_uin.get() + "")));
      paramBoolean = false;
      if (paramQQAppInterface.a().a() > 0L) {
        paramBoolean = true;
      }
      if (((TroopManager)localObject).b() != 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "只允许同时存在两个邀请框");
    return;
    if (((TroopManager)localObject).b() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "hasGroupInviting");
      }
      paramInviteInfo = new Intent(paramQQAppInterface.a().getApplicationContext(), MultiIncomingCallsActivity.class);
      paramInviteInfo.putExtra("uinType", 1);
      paramInviteInfo.putExtra("peerUin", String.valueOf(localInviteInfo.uint64_uin.get()));
    }
    for (;;)
    {
      ((TroopManager)localObject).c(String.valueOf(localInviteInfo.uint64_group_code.get()), String.valueOf(localInviteInfo.uint64_uin.get()));
      if (((KeyguardManager)paramQQAppInterface.a().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.video.v2q.ReceiveRequest");
        ((Intent)localObject).putExtra("revVideoRequest", true);
        ((Intent)localObject).setPackage(paramQQAppInterface.a().getPackageName());
        paramQQAppInterface.a().sendBroadcast((Intent)localObject);
      }
      paramInviteInfo.addFlags(268435456);
      paramInviteInfo.putExtra("relationType", 1);
      paramInviteInfo.putExtra("discussId", localInviteInfo.uint64_group_code.get());
      paramInviteInfo.putExtra("friendUin", localInviteInfo.uint64_uin.get());
      paramInviteInfo.putExtra("inviteId", localInviteInfo.str_id.get());
      paramInviteInfo.putExtra("hasGVideoJoined", paramBoolean);
      paramInviteInfo.putExtra("memberType", TroopMemberUtil.a(paramQQAppInterface, paramQQAppInterface.a(), localInviteInfo.uint64_group_code.get() + ""));
      paramQQAppInterface.a().startActivity(paramInviteInfo);
      return;
      paramInviteInfo = new Intent(paramQQAppInterface.a().getApplicationContext(), GaInviteDialogActivity.class);
    }
  }
  
  public static im_msg_body.RichText c(ChatMessage paramChatMessage)
  {
    Object localObject1 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(2);
    paramChatMessage = new im_msg_body.Elem();
    paramChatMessage.common_elem.set((MessageMicro)localObject1);
    Object localObject2 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8("[戳一戳]请使用最新版手机QQ体验新功能。"));
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
    localObject2 = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
    }
    return (im_msg_body.RichText)localObject2;
  }
  
  public static void c(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) || (paramDecodeProtoPkgContext.jdField_a_of_type_Boolean) || (paramDecodeProtoPkgContext.f)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Video return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramDecodeProtoPkgContext.jdField_a_of_type_Boolean + "syncOther:" + paramDecodeProtoPkgContext.f);
      }
    }
    long l1;
    long l2;
    long l3;
    Object localObject;
    label510:
    do
    {
      int i;
      HashMap localHashMap;
      do
      {
        do
        {
          long l4;
          do
          {
            do
            {
              return;
              l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
              l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
              long l5 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
              l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
              long l6 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
              l3 = Long.valueOf(paramMessageHandler.b.a()).longValue();
              localObject = l2 + "-" + l6 + "-" + l5 + "-" + l4;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Video :  key:" + (String)localObject);
              }
              localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              l4 = MessageCache.a() - l1;
              i = AbstractNetChannel.a((byte[])localObject);
              if ((VcSystemInfo.e()) && (VcSystemInfo.f())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("svenxu", 2, "Discard video message cause device not support");
            return;
            if (l4 < 60L) {
              break;
            }
          } while ((i == 1) && (!QLog.isColorLevel()));
          QLog.d("svenxu", 2, "Discard video message because of time out " + l4 + " s");
          return;
          localHashMap = (HashMap)paramDecodeProtoPkgContext.a(1000);
          paramDecodeProtoPkgContext = (HashSet)paramDecodeProtoPkgContext.a(1001);
          if (i != 1) {
            break label510;
          }
          if (VcSystemInfo.e()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("shanezhaiSHARP", 2, "discard video push message because the sdk is lower");
        return;
      } while (localHashMap == null);
      localHashMap.put(Long.valueOf(l2), paramMsg);
      return;
      if (i != 3) {
        break;
      }
    } while (!VcSystemInfo.e());
    if (paramDecodeProtoPkgContext != null) {
      paramDecodeProtoPkgContext.add(Long.valueOf(l2));
    }
    paramMessageHandler.a(l3, (byte[])localObject, l2, (int)l1);
    return;
    paramMessageHandler.a(l3, (byte[])localObject, l2, (int)l1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\message\MessageProtoCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */