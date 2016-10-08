package com.tencent.mobileqq.service.message;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopFileDataManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.GroupPostElemInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.Notification;
import com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.WorkflowChangeNotification;
import com.trunk.Qworkflow.Qworkflow.WorkflowState;
import cooperation.dingdong.DingdongPluginManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.VideoFile;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONObject;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype1;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype5;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.ArkAppElem;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.DeliverGiftMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.GroupPostElem;
import tencent.im.msg.im_msg_body.GroupPubAccountInfo;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.LolaMsg;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MarketTrans;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletMsg;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TipsInfo;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.im_msg_body.VideoFile;
import tencent.im.msg.im_msg_body.WorkflowNotifyMsg;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import upc;
import upd;

public class MessagePBElemDecoder
{
  private static final String jdField_a_of_type_JavaLangString = "DecodeMsg";
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public MessagePBElemDecoder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.a().a());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public static MessageForQQWalletMsg a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 != null)
      {
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)MessageRecordFactory.a(63511);
        localMessageForQQWalletMsg.msgtype = 63511;
        localMessageForQQWalletMsg.messageType = paramString1.getInt("msgType");
        localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = a(paramString1, paramString2);
        if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
          return null;
        }
        localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
        localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
        return localMessageForQQWalletMsg;
      }
    }
    catch (Exception paramString1)
    {
      return null;
    }
    return null;
  }
  
  public static MessageForVIPDonate a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DecodeMsg", 1, "content is empty ");
      localObject = null;
      return (MessageForVIPDonate)localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "createVIPDonateMsg: msg = " + paramString);
    }
    for (;;)
    {
      JSONObject localJSONObject;
      VIPDonateMsg localVIPDonateMsg;
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject == null) {
          break label394;
        }
        MessageForVIPDonate localMessageForVIPDonate = (MessageForVIPDonate)MessageRecordFactory.a(63489);
        localMessageForVIPDonate.msgtype = 63489;
        localVIPDonateMsg = new VIPDonateMsg();
        if (localJSONObject.has("title"))
        {
          localObject = localJSONObject.getString("title");
          localVIPDonateMsg.title = ((String)localObject);
          if (!localJSONObject.has("footer")) {
            break label313;
          }
          localObject = localJSONObject.getString("footer");
          localVIPDonateMsg.footer = ((String)localObject);
          if (!paramBoolean) {
            break label328;
          }
          if (!localJSONObject.has("sendsubtitle")) {
            break label318;
          }
          localObject = localJSONObject.getString("sendsubtitle");
          localVIPDonateMsg.subTitle = ((String)localObject);
          if (!localJSONObject.has("sendurl")) {
            break label323;
          }
          localObject = localJSONObject.getString("sendurl");
          localVIPDonateMsg.jumpUrl = ((String)localObject);
          if (!localJSONObject.has("brief")) {
            break label389;
          }
          localObject = localJSONObject.getString("brief");
          localVIPDonateMsg.brief = ((String)localObject);
          localMessageForVIPDonate.donateMsg = localVIPDonateMsg;
          localMessageForVIPDonate.msg = localMessageForVIPDonate.getSummaryMsg();
          localMessageForVIPDonate.msgData = MessagePkgUtils.a(localVIPDonateMsg);
          localObject = localMessageForVIPDonate;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("vipdonateMsgparse", 2, "donateMsg = " + localMessageForVIPDonate.donateMsg);
          return localMessageForVIPDonate;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("DecodeMsg", 1, "vipdonate json error :json = " + paramString);
        return null;
      }
      String str = null;
      continue;
      label313:
      str = null;
      continue;
      label318:
      str = null;
      continue;
      label323:
      str = null;
      continue;
      label328:
      if (localJSONObject.has("recvsubtitle"))
      {
        str = localJSONObject.getString("recvsubtitle");
        label346:
        localVIPDonateMsg.subTitle = str;
        if (!localJSONObject.has("recvbrief")) {
          break label384;
        }
      }
      label384:
      for (str = localJSONObject.getString("recvbrief");; str = null)
      {
        localVIPDonateMsg.jumpUrl = str;
        break;
        str = null;
        break label346;
      }
      label389:
      str = null;
    }
    label394:
    return null;
  }
  
  private static PAMessage a(String paramString)
  {
    paramString = PAMessageUtil.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static QQWalletRedPacketMsg a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      try
      {
        im_msg_body.QQWalletAioBody localQQWalletAioBody = new im_msg_body.QQWalletAioBody();
        localQQWalletAioBody.sint32_channelid.set(paramJSONObject.getInt("channelid"));
        localQQWalletAioBody.sint32_templateid.set(paramJSONObject.getInt("templateid"));
        localQQWalletAioBody.uint32_resend.set(paramJSONObject.getInt("resend"));
        localQQWalletAioBody.sint32_redtype.set(paramJSONObject.getInt("redtype"));
        localQQWalletAioBody.sint32_envelopeid.set(-1);
        paramString = new QQWalletRedPacketMsg(localQQWalletAioBody, paramString);
        paramString.redPacketId = paramJSONObject.getString("billno");
        paramString.authkey = paramJSONObject.getString("authkey");
        if (paramString.redPacketId.equals("")) {
          return null;
        }
        paramString.elem = a(paramJSONObject);
        paramJSONObject = paramString.elem;
        if (paramJSONObject != null) {
          return paramString;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  public static QQWalletTransferMsgElem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        QQWalletTransferMsgElem localQQWalletTransferMsgElem = new QQWalletTransferMsgElem();
        paramJSONObject = paramJSONObject.getJSONObject("receiver");
        if (paramJSONObject == null) {
          return null;
        }
        localQQWalletTransferMsgElem.nativeAndroid = paramJSONObject.getString("nativeAndroid");
        if (!localQQWalletTransferMsgElem.nativeAndroid.equals(""))
        {
          localQQWalletTransferMsgElem.background = paramJSONObject.getInt("background");
          localQQWalletTransferMsgElem.icon = paramJSONObject.getInt("icon");
          localQQWalletTransferMsgElem.title = paramJSONObject.getString("title");
          localQQWalletTransferMsgElem.subTitle = paramJSONObject.getString("subtitle");
          localQQWalletTransferMsgElem.content = paramJSONObject.getString("content");
          localQQWalletTransferMsgElem.linkUrl = paramJSONObject.getString("linkurl");
          localQQWalletTransferMsgElem.blackStripe = paramJSONObject.getString("blackstripe");
          localQQWalletTransferMsgElem.notice = paramJSONObject.getString("notice");
          localQQWalletTransferMsgElem.titleColor = paramJSONObject.getInt("titleColor");
          localQQWalletTransferMsgElem.subtitleColor = paramJSONObject.getInt("subtitleColor");
          localQQWalletTransferMsgElem.actionsPriority = paramJSONObject.getString("actionsPriority");
          localQQWalletTransferMsgElem.jumpUrl = paramJSONObject.getString("jumpUrl");
          localQQWalletTransferMsgElem.iconUrl = paramJSONObject.getString("iconurl");
          localQQWalletTransferMsgElem.contentColor = -1;
          localQQWalletTransferMsgElem.contentBgColor = -1;
          localQQWalletTransferMsgElem.aioImageLeft = "";
          localQQWalletTransferMsgElem.aioImageRight = "";
          localQQWalletTransferMsgElem.cftImage = "";
          return localQQWalletTransferMsgElem;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  private Boolean a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
        if ((localElem.market_trans.has()) || (localElem.rich_msg.has())) {
          return Boolean.valueOf(true);
        }
      }
    }
    return Boolean.valueOf(false);
  }
  
  protected static Boolean a(im_msg_body.Elem paramElem)
  {
    if ((paramElem.text.has()) || (paramElem.face.has()) || (paramElem.small_emoji.has()) || (paramElem.online_image.has()) || (paramElem.bankcode_ctrl_info.has())) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  private String a(List paramList1, List paramList2, boolean paramBoolean)
  {
    String str = null;
    Object localObject = paramList1.iterator();
    paramList1 = null;
    if (((Iterator)localObject).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject).next();
      if (!localElem.text.has()) {
        break label160;
      }
      paramList1 = (im_msg_body.Text)localElem.text.get();
    }
    label160:
    for (;;)
    {
      break;
      localObject = str;
      if (paramList1 != null)
      {
        localObject = str;
        if (paramList1.str.has())
        {
          paramList1 = paramList1.str.get().toStringUtf8();
          localObject = paramList1;
          if (paramBoolean)
          {
            str = MessageUtils.a(paramList1, false);
            localObject = paramList1;
            if (str.length() > 0)
            {
              localObject = (MessageForText)MessageRecordFactory.a(64536);
              ((MessageForText)localObject).msgtype = 64536;
              ((MessageForText)localObject).msg = str;
              paramList2.add(localObject);
              localObject = paramList1;
            }
          }
        }
      }
      return (String)localObject;
    }
  }
  
  private void a(im_msg_body.Elem paramElem, List paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo)
  {
    paramElem = (im_msg_body.CrmElem)paramElem.crm_elem.get();
    if (paramElem != null)
    {
      i = paramElem.uint32_qidian_flag.get();
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("has uint32_qidian_flag:").append(i).append(";");
      }
      if (i == 1)
      {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("crmelem_qidian_flag", i + "");
        paramElem = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a();
        paramList = String.valueOf(paramMsg.msg_head.from_uin.get());
        if (!paramElem.equals(paramList))
        {
          paramElem = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(164);
          if (!paramElem.a.containsKey(paramList)) {
            paramElem.a(new BmqqAccountType(paramList, 1));
          }
        }
        if ((paramTempSessionInfo != null) && (paramTempSessionInfo.b == 1024)) {
          paramTempSessionInfo.b = 1025;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
    }
    paramStringBuilder.append("has crmElem, but crmElem is null");
  }
  
  private void a(im_msg_body.Elem paramElem, im_msg_body.NotOnlineImage paramNotOnlineImage, List paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    BaseApplication.getContext().getString(2131370482);
    boolean bool;
    if (paramNotOnlineImage != null) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("flash", 2, "parsePBMsgElems_OfflineMsg hasComFlashPic=" + bool);
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:NotOnlineImage;\n hasComFlashPic=" + bool);
      }
      if (paramNotOnlineImage == null)
      {
        QLog.d("flash", 2, "offlineImg null");
        return;
        if (paramElem != null)
        {
          paramNotOnlineImage = (im_msg_body.NotOnlineImage)paramElem.not_online_image.get();
          bool = false;
        }
      }
      else
      {
        int j;
        int i;
        if (paramNotOnlineImage != null)
        {
          j = paramNotOnlineImage.file_len.get();
          i = paramNotOnlineImage.img_type.get();
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] file_len=" + j);
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] imgType=" + i);
          }
          paramNotOnlineImage.flag.get().toByteArray();
          String str1 = paramNotOnlineImage.str_thumb_url.get();
          String str2 = paramNotOnlineImage.str_400_url.get();
          int i1 = paramNotOnlineImage.uint32_thumb_width.get();
          int i2 = paramNotOnlineImage.uint32_thumb_height.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] ThumbWidth=" + i1 + ",ThumbHeight=" + i2);
          }
          if (paramNotOnlineImage.uint32_file_id.has()) {}
          for (int k = paramNotOnlineImage.uint32_file_id.get();; k = 0)
          {
            String str3 = paramNotOnlineImage.str_big_url.get();
            String str4 = paramNotOnlineImage.str_orig_url.get();
            int i3 = paramNotOnlineImage.pic_width.get();
            int i4 = paramNotOnlineImage.pic_height.get();
            int m = paramNotOnlineImage.uint32_show_len.get();
            int n = paramNotOnlineImage.uint32_download_len.get();
            if (QLog.isDevelopLevel()) {
              QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + m + ", downloadLen " + n + ", fileLen " + j);
            }
            int i5 = paramNotOnlineImage.original.get();
            if (paramNotOnlineImage.res_id.has()) {
              paramElem = paramNotOnlineImage.res_id.get().toStringUtf8();
            }
            for (;;)
            {
              Object localObject1;
              if ((paramElem != null) && (!paramElem.equals("")))
              {
                localObject1 = "";
                paramMsg = (msg_comm.Msg)localObject1;
                if (paramNotOnlineImage.pic_md5.has())
                {
                  localObject2 = paramNotOnlineImage.pic_md5.get().toByteArray();
                  paramMsg = (msg_comm.Msg)localObject1;
                  if (localObject2 != null)
                  {
                    paramMsg = (msg_comm.Msg)localObject1;
                    if (localObject2.length > 0) {
                      paramMsg = HexUtil.a((byte[])localObject2);
                    }
                  }
                }
                Object localObject2 = TransfileUtile.a(paramElem, j, 1, false, paramElem, paramMsg, "picplatform", str1, str2, str3, str4, i5, 0);
                localObject1 = new RichMsg.PicRec();
                ((RichMsg.PicRec)localObject1).localPath.set(paramElem);
                ((RichMsg.PicRec)localObject1).size.set(j);
                ((RichMsg.PicRec)localObject1).type.set(1);
                ((RichMsg.PicRec)localObject1).isRead.set(false);
                ((RichMsg.PicRec)localObject1).uuid.set(paramElem);
                ((RichMsg.PicRec)localObject1).md5.set(paramMsg);
                ((RichMsg.PicRec)localObject1).serverStorageSource.set("picplatform");
                ((RichMsg.PicRec)localObject1).thumbMsgUrl.set(str1);
                ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.set(str2);
                ((RichMsg.PicRec)localObject1).uint32_thumb_width.set(i1);
                ((RichMsg.PicRec)localObject1).uint32_thumb_height.set(i2);
                ((RichMsg.PicRec)localObject1).uint32_width.set(i3);
                ((RichMsg.PicRec)localObject1).uint32_height.set(i4);
                if (paramNotOnlineImage.uint32_file_id.has()) {
                  ((RichMsg.PicRec)localObject1).groupFileID.set(k);
                }
                ((RichMsg.PicRec)localObject1).bigMsgUrl.set(str3);
                ((RichMsg.PicRec)localObject1).rawMsgUrl.set(str4);
                ((RichMsg.PicRec)localObject1).fileSizeFlag.set(i5);
                ((RichMsg.PicRec)localObject1).uiOperatorFlag.set(0);
                ((RichMsg.PicRec)localObject1).version.set(5);
                ((RichMsg.PicRec)localObject1).isReport.set(0);
                if (QLog.isColorLevel()) {
                  paramStringBuilder.append("content:").append((String)localObject2).append("\n");
                }
                if (i5 != 1) {
                  break label1164;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, "[NotOnlineImage] showLen =" + m + ",downloadLen = " + n + ",raw photo msg,clear progressjpg info!");
                }
                k = 0;
                j = 0;
              }
              for (;;)
              {
                ((RichMsg.PicRec)localObject1).uint32_show_len.set(k);
                ((RichMsg.PicRec)localObject1).uint32_download_len.set(j);
                ((RichMsg.PicRec)localObject1).uint32_image_type.set(i);
                paramElem = (MessageForPic)MessageRecordFactory.a(63536);
                if (bool) {
                  FlashPicHelper.a(paramElem, false);
                }
                paramElem.msgtype = 63536;
                paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
                paramElem.parse();
                paramList.add(paramElem);
                return;
                if (!paramNotOnlineImage.download_path.has()) {
                  break label1175;
                }
                paramElem = paramNotOnlineImage.download_path.get().toStringUtf8();
                break;
                if (QLog.isColorLevel()) {
                  paramStringBuilder.append("serverPath is null or empty string : " + paramElem);
                }
                paramElem = (msg_comm.MsgHead)paramMsg.msg_head.get();
                long l1 = paramElem.msg_seq.get();
                long l2 = paramElem.msg_uid.get();
                long l3 = paramElem.msg_time.get();
                long l4 = paramElem.from_uin.get();
                long l5 = paramElem.to_uin.get();
                paramElem = new HashMap();
                paramElem.put("param_FailCode", String.valueOf(10002));
                paramElem.put("fromUin", String.valueOf(l4));
                paramElem.put("toUin", String.valueOf(l5));
                paramElem.put("msgSeq", String.valueOf(l1));
                paramElem.put("msgUid", String.valueOf(l2));
                paramElem.put("msgtime", String.valueOf(l3));
                paramNotOnlineImage = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a();
                StatisticCollector.a(BaseApplication.getContext()).a(paramNotOnlineImage, "actMessageEvent", false, 0L, 0L, paramElem, "");
                return;
                label1164:
                j = n;
                k = m;
              }
              label1175:
              paramElem = null;
            }
          }
          i = 0;
          j = 0;
        }
      }
      paramNotOnlineImage = null;
      bool = false;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte1 = new byte['Ѐ'];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte1, 0, localInflater.inflate(arrayOfByte1));
      }
      try
      {
        byte[] arrayOfByte2;
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localInflater.end();
          return paramArrayOfByte;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte2;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public Pair a(List paramList, StringBuilder paramStringBuilder)
  {
    Object localObject3 = null;
    Object localObject2 = paramList.iterator();
    paramList = null;
    Object localObject1 = null;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (((im_msg_body.Elem)localObject4).src_msg.has()) {
        localObject1 = (im_msg_body.SourceMsg)((im_msg_body.Elem)localObject4).src_msg.get();
      }
      if (!((im_msg_body.Elem)localObject4).group_post_elem.has()) {
        break label466;
      }
      paramList = (im_msg_body.GroupPostElem)((im_msg_body.Elem)localObject4).group_post_elem.get();
    }
    label466:
    for (;;)
    {
      break;
      if ((localObject1 != null) && (((im_msg_body.SourceMsg)localObject1).elems.has()))
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:SrcMsg;\n");
        }
        localObject4 = ((im_msg_body.SourceMsg)localObject1).elems.get();
        localObject2 = new MessageForReplyText.SourceMsgInfo();
        ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq = ((Integer)((im_msg_body.SourceMsg)localObject1).uint32_orig_seqs.get(0)).intValue();
        ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgText = a((List)localObject4);
        ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgTime = ((im_msg_body.SourceMsg)localObject1).uint32_time.get();
        ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSenderUin = ((im_msg_body.SourceMsg)localObject1).uint64_sender_uin.get();
        ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceSummaryFlag = ((im_msg_body.SourceMsg)localObject1).uint32_flag.get();
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject4).next();
          if (localElem.anon_group_msg.has()) {
            ((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName = ((im_msg_body.AnonymousGroupMsg)localElem.anon_group_msg.get()).str_anon_nick.get().toStringUtf8();
          }
        }
        if (((im_msg_body.SourceMsg)localObject1).uint32_type.has()) {
          ((MessageForReplyText.SourceMsgInfo)localObject2).mType = ((im_msg_body.SourceMsg)localObject1).uint32_type.get();
        }
        if (((im_msg_body.SourceMsg)localObject1).bytes_richMsg.has())
        {
          ((MessageForReplyText.SourceMsgInfo)localObject2).mRichMsg = ((im_msg_body.SourceMsg)localObject1).bytes_richMsg.get().toStringUtf8();
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        localObject2 = localObject3;
        if (paramList != null)
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:GroupPostElem;\n");
          }
          int i = paramList.uint32_trans_type.get();
          paramList = paramList.bytes_trans_msg.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "group_post_elem transType = " + i + ", transMsg = " + paramList);
          }
          localObject2 = localObject3;
          if (i == 1)
          {
            localObject2 = localObject3;
            if (!TextUtils.isEmpty(paramList)) {
              localObject2 = new TroopTopicMgr.GroupPostElemInfo(i, paramList);
            }
          }
        }
        return new Pair(localObject1, localObject2);
        ((MessageForReplyText.SourceMsgInfo)localObject2).mType = 0;
        localObject1 = localObject2;
        continue;
        localObject1 = null;
      }
    }
  }
  
  public MarkFaceMessage a(im_msg_body.Elem paramElem, List paramList, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    im_msg_body.MarketFace localMarketFace = (im_msg_body.MarketFace)paramElem.market_face.get();
    if (localMarketFace != null)
    {
      paramElem = new MarkFaceMessage();
      paramElem.cFaceInfo = localMarketFace.uint32_face_info.get();
      paramElem.index = 0L;
      paramElem.cSubType = localMarketFace.uint32_sub_type.get();
      paramElem.dwMSGItemType = localMarketFace.uint32_item_type.get();
      paramElem.dwTabID = localMarketFace.uint32_tab_id.get();
      paramElem.sbfKey = localMarketFace.bytes_key.get().toByteArray();
      paramElem.sbufID = localMarketFace.bytes_face_id.get().toByteArray();
      paramElem.mediaType = localMarketFace.uint32_media_type.get();
      paramElem.imageWidth = localMarketFace.uint32_image_width.get();
      paramElem.imageHeight = localMarketFace.uint32_image_height.get();
      paramElem.mobileparam = localMarketFace.bytes_mobileparam.get().toByteArray();
      if (localMarketFace.bytes_ext_info.has()) {
        paramElem.resvAttr = localMarketFace.bytes_ext_info.get().toByteArray();
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append(" mediaType = ").append(paramElem.mediaType).append("\n");
      }
      if (localMarketFace.bytes_face_name.has())
      {
        paramStringBuilder = localMarketFace.bytes_face_name.get().toStringUtf8();
        if ((TextUtils.isEmpty(paramStringBuilder)) || (paramStringBuilder.length() <= 1) || (paramStringBuilder.charAt(0) != '[') || (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ']')) {
          break label399;
        }
        paramElem.faceName = paramStringBuilder.substring(1, paramStringBuilder.length() - 1);
      }
      for (;;)
      {
        paramStringBuilder = (MessageForMarketFace)MessageRecordFactory.a(63529);
        paramStringBuilder.msgtype = 63529;
        paramStringBuilder.msg = "it is marketface";
        paramStringBuilder.mMarkFaceMessage = paramElem;
        if ((paramElem.mobileparam != null) && (paramElem.mobileparam.length > 0)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
        }
        try
        {
          paramStringBuilder.msgData = MessagePkgUtils.a(paramElem);
          paramList.add(paramStringBuilder);
          return paramElem;
          label399:
          paramElem.faceName = paramStringBuilder;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return null;
  }
  
  public String a(List paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    StringBuilder localStringBuilder2 = new StringBuilder("<---decodePbElems:");
    int k = paramList.size();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < k)
    {
      localObject = (im_msg_body.Elem)paramList.get(j);
      if (((im_msg_body.Elem)localObject).text.has()) {
        if (i != 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (QLog.isColorLevel()) {
        localStringBuilder2.append("elemType:Text;\n");
      }
      localStringBuilder1.length();
      localObject = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
      if (((im_msg_body.Text)localObject).str.has()) {
        localStringBuilder1.append(MessageUtils.a(((im_msg_body.Text)localObject).str.get().toStringUtf8(), false));
      }
      continue;
      if (((im_msg_body.Elem)localObject).face.has())
      {
        if (QLog.isColorLevel()) {
          localStringBuilder2.append("elemType:Face;\n");
        }
        if (((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.has())
        {
          int m = ((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.get();
          if (m < MessageUtils.b.length)
          {
            m = MessageUtils.b[m];
            if (m >= 0)
            {
              localStringBuilder1.append('\024');
              localStringBuilder1.append((char)m);
            }
          }
        }
      }
      else if (((im_msg_body.Elem)localObject).small_emoji.has())
      {
        if (QLog.isColorLevel()) {
          localStringBuilder2.append("elemType:small_emoji;\n");
        }
        if (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.has())
        {
          localObject = EmosmUtils.a((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16, ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.get() & 0xFFFF);
          localStringBuilder1.append('\024');
          localStringBuilder1.append(localObject[3]);
          localStringBuilder1.append(localObject[2]);
          localStringBuilder1.append(localObject[1]);
          localStringBuilder1.append(localObject[0]);
          i = 1;
          continue;
          return localStringBuilder1.toString();
        }
      }
    }
  }
  
  public StringBuilder a(StringBuilder paramStringBuilder1, List paramList1, List paramList2, StringBuilder paramStringBuilder2, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = null;
    paramList2 = null;
    if (paramStringBuilder1 != null) {}
    long l;
    int i;
    for (StringBuilder localStringBuilder = new StringBuilder(paramStringBuilder1);; localStringBuilder = new StringBuilder(""))
    {
      l = paramMsg.msg_head.msg_seq.get();
      i = 0;
      Iterator localIterator = paramList1.iterator();
      paramStringBuilder1 = localAtTroopMemberInfo;
      paramList1 = paramList2;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label991;
        }
        paramList2 = (im_msg_body.Elem)localIterator.next();
        if (!paramList2.text.has()) {
          break label549;
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder2.append("elemType:Text;\n");
        }
        if (i == 0) {
          break;
        }
        i = 0;
      }
    }
    paramList2 = (im_msg_body.Text)paramList2.text.get();
    int i1 = localStringBuilder.length();
    if (paramList2.str.has()) {
      localStringBuilder.append(MessageUtils.a(paramList2.str.get().toStringUtf8(), false));
    }
    label196:
    int m;
    int k;
    int j;
    if (paramList2.attr_6_buf.has())
    {
      paramList2 = paramList2.attr_6_buf.get();
      if (paramList2 != null)
      {
        paramMsg = paramList2.toByteArray();
        if ((paramMessageInfo != null) && (paramMessageInfo.jdField_a_of_type_Int == 3000) && (paramArrayList2 != null) && (paramMsg != null) && (paramMsg.length != 0))
        {
          m = PkgTools.a(paramMsg, 0);
          k = 2;
          j = 0;
          label242:
          if ((j < m) && (k < 2048))
          {
            paramList2 = new MessageForText.AtTroopMemberInfo();
            if (paramList2.readFrom(paramMsg, k)) {
              break label411;
            }
          }
        }
        if ((paramMessageInfo == null) || ((!paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(l)) && (!paramMessageInfo.c.a(l))) || (paramMsg == null) || (paramMsg.length == 0)) {
          break label1125;
        }
        int i2 = PkgTools.a(paramMsg, 0);
        j = 2;
        k = 0;
        paramList2 = paramStringBuilder1;
        label334:
        paramStringBuilder1 = paramList2;
        if (k < i2)
        {
          paramStringBuilder1 = paramList2;
          if (j < 2048)
          {
            localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
            paramStringBuilder1 = paramList2;
            if (k == 0)
            {
              paramStringBuilder1 = paramList2;
              if (paramList2 == null) {
                paramStringBuilder1 = localAtTroopMemberInfo;
              }
            }
            if (localAtTroopMemberInfo.readFrom(paramMsg, j)) {
              break label449;
            }
          }
        }
      }
    }
    label411:
    label449:
    label549:
    label991:
    label1029:
    label1106:
    label1125:
    for (;;)
    {
      paramList2 = paramList1;
      paramList1 = paramStringBuilder1;
      paramStringBuilder1 = paramList2;
      for (;;)
      {
        paramList2 = paramList1;
        paramList1 = paramStringBuilder1;
        paramStringBuilder1 = paramList2;
        break;
        paramMsg = null;
        break label196;
        k += paramList2.length();
        paramList2.startPos = ((short)(paramList2.startPos + i1));
        j = (short)(j + 1);
        paramArrayList2.add(paramList2);
        break label242;
        m = j + localAtTroopMemberInfo.length();
        localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + i1));
        int n = (short)(k + 1);
        if (localAtTroopMemberInfo.isIncludingAll()) {
          paramMessageInfo.c.a = l;
        }
        paramList2 = paramStringBuilder1;
        k = n;
        j = m;
        if (!localAtTroopMemberInfo.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getLongAccountUin())) {
          break label334;
        }
        paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a = l;
        paramList2 = paramStringBuilder1;
        k = n;
        j = m;
        break label334;
        if (paramList2.face.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:Face;\n");
          }
          if (((im_msg_body.Face)paramList2.face.get()).index.has())
          {
            j = ((im_msg_body.Face)paramList2.face.get()).index.get();
            if (j < MessageUtils.b.length)
            {
              j = MessageUtils.b[j];
              if (j >= 0)
              {
                localStringBuilder.append('\024');
                localStringBuilder.append((char)j);
              }
            }
            paramList2 = paramStringBuilder1;
            paramStringBuilder1 = paramList1;
            paramList1 = paramList2;
          }
        }
        else if (paramList2.small_emoji.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:small_emoji;\n");
          }
          if (((im_msg_body.SmallEmoji)paramList2.small_emoji.get()).packIdSum.has())
          {
            paramList2 = EmosmUtils.a((((im_msg_body.SmallEmoji)paramList2.small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16, ((im_msg_body.SmallEmoji)paramList2.small_emoji.get()).packIdSum.get() & 0xFFFF);
            localStringBuilder.append('\024');
            localStringBuilder.append(paramList2[3]);
            localStringBuilder.append(paramList2[2]);
            localStringBuilder.append(paramList2[1]);
            localStringBuilder.append(paramList2[0]);
            i = 1;
            paramList2 = paramStringBuilder1;
            paramStringBuilder1 = paramList1;
            paramList1 = paramList2;
          }
        }
        else
        {
          if (paramList2.online_image.has())
          {
            if (QLog.isColorLevel()) {
              paramStringBuilder2.append("elemType:OnlineImage;\n");
            }
            localStringBuilder.append(BaseApplication.getContext().getString(2131370482));
            paramList2 = paramStringBuilder1;
            paramStringBuilder1 = paramList1;
            paramList1 = paramList2;
            continue;
          }
          if (paramList2.bankcode_ctrl_info.has())
          {
            if (QLog.isColorLevel()) {
              paramStringBuilder2.append("elemType: bankcode_ctrlinfo;\n");
            }
            paramList2 = paramList2.bankcode_ctrl_info.get().toByteArray();
            j = paramList2[0];
            k = paramList2[(paramList2.length - 1)];
            if ((j != 40) || (k != 41))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              paramStringBuilder2.append("elemType: bankcode_ctrlinfo buffer error;\n");
              break;
            }
            if (ByteBuffer.wrap(paramList2, 2, 2).getShort() != 29786) {
              break;
            }
            j = ByteBuffer.wrap(paramList2, 4, 2).getShort();
            if (j <= 0) {
              break;
            }
            paramList1 = new byte[j];
            System.arraycopy(paramList2, 6, paramList1, 0, j);
            paramList2 = paramStringBuilder1;
            paramStringBuilder1 = paramList1;
            paramList1 = paramList2;
            continue;
            if ((paramArrayList1 != null) && ((paramStringBuilder1 != null) || (paramList1 != null)))
            {
              if (!paramArrayList1.isEmpty()) {
                break label1029;
              }
              paramArrayList1.add(paramStringBuilder1);
              paramArrayList1.add(paramList1);
            }
            while ((paramArrayList1.size() != 2) || ((paramArrayList1.get(0) != null) && (paramArrayList1.get(1) != null))) {
              return localStringBuilder;
            }
            if (paramArrayList1.get(0) == null) {
              if (paramArrayList1.get(1) != null) {
                break label1106;
              }
            }
            for (;;)
            {
              paramArrayList1.clear();
              paramArrayList1.add(paramStringBuilder1);
              paramArrayList1.add(paramList1);
              return localStringBuilder;
              paramStringBuilder1 = paramArrayList1.get(0);
              break;
              paramList1 = paramArrayList1.get(1);
            }
          }
        }
        paramList2 = paramStringBuilder1;
        paramStringBuilder1 = paramList1;
        paramList1 = paramList2;
      }
    }
  }
  
  public StringBuilder a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, ArrayList paramArrayList)
  {
    return a(null, paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, paramArrayList, null);
  }
  
  public void a(ArrayList paramArrayList, List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo)
  {
    if (paramArrayList.contains("lifeOnline")) {
      a(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
    }
    paramArrayList = paramList1.iterator();
    while (paramArrayList.hasNext())
    {
      paramList1 = (im_msg_body.Elem)paramArrayList.next();
      if ((paramList1.near_by_msg.has()) && (paramList1.near_by_msg.uint32_identify_type.has()) && (paramList1.near_by_msg.uint32_identify_type.get() == 1))
      {
        ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("identify_flag", "true");
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType: near_by_msg has identify;\n");
        }
      }
      if ((paramList1.general_flags.has()) && (((im_msg_body.GeneralFlags)paramList1.general_flags.get()).uint32_olympic_torch.has()))
      {
        int i = paramList1.general_flags.uint32_olympic_torch.get();
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("has olympicTorch:").append(i).append(";");
        }
        if (i > 0) {
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("olympic_torch_flg", i + "");
        }
      }
      if (paramList1.crm_elem.has()) {
        a(paramList1, paramList2, paramStringBuilder, paramMsg, paramTempSessionInfo);
      }
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    Object localObject = null;
    Iterator localIterator = paramList1.iterator();
    int i = 0;
    paramList1 = (List)localObject;
    if (localIterator.hasNext())
    {
      localObject = (im_msg_body.Elem)localIterator.next();
      if (((im_msg_body.Elem)localObject).video_file.has()) {
        paramList1 = (im_msg_body.VideoFile)((im_msg_body.Elem)localObject).video_file.get();
      }
      if ((!((im_msg_body.Elem)localObject).bless_msg.has()) || (((im_msg_body.Elem)localObject).bless_msg.uint32_msg_type.get() != 1)) {
        break label579;
      }
      i = 1;
    }
    label579:
    for (;;)
    {
      break;
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:video_file;\n");
      }
      localObject = new RichMsg.VideoFile();
      ((RichMsg.VideoFile)localObject).setHasFlag(true);
      ((RichMsg.VideoFile)localObject).bytes_file_name.set(paramList1.bytes_file_name.get());
      ((RichMsg.VideoFile)localObject).bytes_file_md5.set(paramList1.bytes_file_md5.get());
      ((RichMsg.VideoFile)localObject).bytes_file_uuid.set(paramList1.bytes_file_uuid.get());
      ((RichMsg.VideoFile)localObject).uint32_file_format.set(paramList1.uint32_file_format.get());
      ((RichMsg.VideoFile)localObject).uint32_file_size.set(paramList1.uint32_file_size.get());
      ((RichMsg.VideoFile)localObject).uint32_file_time.set(paramList1.uint32_file_time.get());
      ((RichMsg.VideoFile)localObject).uint32_thumb_width.set(paramList1.uint32_thumb_width.get());
      ((RichMsg.VideoFile)localObject).uint32_thumb_height.set(paramList1.uint32_thumb_height.get());
      ((RichMsg.VideoFile)localObject).uint32_file_status.set(2008);
      ((RichMsg.VideoFile)localObject).uint32_file_progress.set(0);
      ((RichMsg.VideoFile)localObject).bytes_thumb_file_md5.set(paramList1.bytes_thumb_file_md5.get());
      ((RichMsg.VideoFile)localObject).bytes_source.set(paramList1.bytes_source.get());
      ((RichMsg.VideoFile)localObject).uint32_thumb_file_size.set(paramList1.uint32_thumb_file_size.get());
      ((RichMsg.VideoFile)localObject).uint32_busi_type.set(paramList1.uint32_busi_type.get());
      ((RichMsg.VideoFile)localObject).uin32_from_chat_type.set(paramList1.uint32_from_chat_type.get());
      ((RichMsg.VideoFile)localObject).uin32_to_chat_type.set(paramList1.uint32_to_chat_type.get());
      ((RichMsg.VideoFile)localObject).bool_support_progressive.set(paramList1.bool_support_progressive.get());
      ((RichMsg.VideoFile)localObject).uint32_file_width.set(paramList1.uint32_file_width.get());
      ((RichMsg.VideoFile)localObject).uint32_file_height.set(paramList1.uint32_file_height.get());
      ((RichMsg.VideoFile)localObject).uint32_sub_busi_type.set(paramList1.uint32_sub_busi_type.get());
      ((RichMsg.VideoFile)localObject).uint32_video_attr.set(paramList1.uint32_video_attr.get());
      paramList1 = (MessageForShortVideo)MessageRecordFactory.a(63514);
      paramList1.msgtype = 63514;
      paramList1.msgData = ((RichMsg.VideoFile)localObject).toByteArray();
      if (((RichMsg.VideoFile)localObject).uint32_busi_type.get() == 2) {}
      for (paramList1.msg = "[视频对讲]";; paramList1.msg = "[视频]")
      {
        paramList1.parse();
        paramList2.add(paramList1);
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true");
          }
          paramList1.isBlessMsg = true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        paramStringBuilder.append("ShortVideo.msg: ").append(paramList1.toString() + "\n" + paramList1.toLogString()).append("\n");
        return;
      }
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Iterator localIterator = paramList1.iterator();
    paramList1 = null;
    String str = null;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (im_msg_body.Elem)localIterator.next();
      if (!((im_msg_body.Elem)localObject).deliver_gift_msg.has()) {}
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (((im_msg_body.Elem)localObject).pub_group.has()) {
          str = ((im_msg_body.Elem)localObject).pub_group.bytes_nickname.get().toStringUtf8();
        }
        if (!((im_msg_body.Elem)localObject).text.has()) {
          break label1266;
        }
        localObject = ((im_msg_body.Text)((im_msg_body.Elem)localObject).text.get()).str.get().toStringUtf8();
        if ((localObject == null) || (!((String)localObject).startsWith("@"))) {
          break label1266;
        }
        paramList1 = ((String)localObject).substring(1);
      }
      label1222:
      label1266:
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:GiftMsg;\n");
        }
        int i = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_animation_package_id.get();
        int j = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_stmessage_exflag.get();
        if ((i == 0) && ((j < 1000) || (j > 2000)))
        {
          paramStringBuilder = (MessageForDeliverGiftTips)MessageRecordFactory.a(63501);
          paramStringBuilder.msgtype = 63501;
          paramStringBuilder.senderName = str;
          paramStringBuilder.grayTipContent = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_gray_tip_content.get().toStringUtf8();
          paramStringBuilder.animationPackageId = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_animation_package_id.get();
          paramStringBuilder.animationPackageUrl = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_animation_package_url_a.get().toStringUtf8();
          paramStringBuilder.remindBrief = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_remind_brief.get().toStringUtf8();
          paramStringBuilder.giftId = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_gift_id.get();
          paramStringBuilder.giftCount = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_gift_count.get();
          paramStringBuilder.animationBrief = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_animation_brief.get().toStringUtf8();
          paramStringBuilder.senderUin = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint64_sender_uin.get();
          paramStringBuilder.receiverUin = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint64_receiver_uin.get();
          paramStringBuilder.rcvName = paramList1;
          paramList1 = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(80);
          if (paramList1 != null)
          {
            paramStringBuilder.grayTipsEntity = new TroopTipsEntity();
            paramStringBuilder.grayTipsEntity.isSupportImage = true;
            paramStringBuilder.grayTipsEntity.troopUin = String.valueOf(paramMsg.msg_head.group_info.group_code.get());
            paramStringBuilder.grayTipsEntity.optContent = paramStringBuilder.grayTipContent;
            paramList1.a(paramStringBuilder.grayTipsEntity);
            paramStringBuilder.msg = paramStringBuilder.grayTipsEntity.optContent;
            if ((paramStringBuilder instanceof MessageForTroopGift))
            {
              paramList1 = (MessageForTroopGift)paramStringBuilder;
              paramList1.bagId = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_to_all_gift_id.get().toStringUtf8();
              paramList1.title = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_stmessage_title.get().toStringUtf8();
              paramList1.subtitle = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_stmessage_subtitle.get().toStringUtf8();
              paramList1.message = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_stmessage_message.get().toStringUtf8();
              paramList1.giftPicId = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_stmessage_giftpicid.get();
              paramList1.comefrom = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_stmessage_comefrom.get().toStringUtf8();
              paramList1.exflag = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_stmessage_exflag.get();
            }
            if ((!paramStringBuilder.isToAll()) && (paramStringBuilder.msg.startsWith("[")))
            {
              i = paramStringBuilder.msg.indexOf("]");
              if ((i != -1) && (i < paramStringBuilder.msg.length())) {
                paramStringBuilder.summary = paramStringBuilder.msg.substring(i + 1);
              }
            }
            if (TextUtils.isEmpty(paramStringBuilder.summary)) {
              paramStringBuilder.summary = paramStringBuilder.msg;
            }
            if (paramStringBuilder.grayTipsEntity.highlightNum != 0) {
              TroopTipsMsgMgr.a(paramStringBuilder, paramStringBuilder.grayTipsEntity.highlightItems);
            }
            if ((paramStringBuilder instanceof MessageForTroopGift)) {
              ((MessageForTroopGift)paramStringBuilder).prewrite();
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a() == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().equals(paramStringBuilder.receiverUin + ""))) {
              break label1222;
            }
            if (paramStringBuilder.remindBrief != null) {
              paramStringBuilder.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramStringBuilder.remindBrief.split("#")[0]);
            }
          }
        }
        for (;;)
        {
          paramList2.add(paramStringBuilder);
          if ((paramStringBuilder instanceof MessageForTroopGift))
          {
            paramList1 = (MessageForTroopGift)paramStringBuilder;
            paramList1.bagId = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_to_all_gift_id.get().toStringUtf8();
            paramList1.title = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_stmessage_title.get().toStringUtf8();
            paramList1.subtitle = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_stmessage_subtitle.get().toStringUtf8();
            paramList1.message = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_stmessage_message.get().toStringUtf8();
            paramList1.giftPicId = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_stmessage_giftpicid.get();
            paramList1.comefrom = ((im_msg_body.Elem)localObject).deliver_gift_msg.bytes_stmessage_comefrom.get().toStringUtf8();
            paramList1.exflag = ((im_msg_body.Elem)localObject).deliver_gift_msg.uint32_stmessage_exflag.get();
            ((MessageForTroopGift)paramStringBuilder).prewrite();
          }
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "MessageProtoCodec.decodePBMsgElems  decode send gift gray tips" + paramStringBuilder.msg);
          }
          if ((paramStringBuilder.summary != null) && (paramStringBuilder.rcvName != null) && (paramStringBuilder.rcvName.length() > 0))
          {
            paramList1 = Pattern.compile("(送.*给" + paramStringBuilder.rcvName.substring(0, 1) + ")").matcher(paramStringBuilder.summary);
            if (paramList1.find())
            {
              paramList1 = paramList1.group();
              i = paramStringBuilder.summary.indexOf(paramList1);
              j = paramStringBuilder.summary.lastIndexOf(paramList1);
              if ((i > 0) && (j == i)) {
                paramStringBuilder.senderName = paramStringBuilder.summary.substring(0, i);
              }
            }
          }
          paramList1 = new Intent("tencent.video.q2v.VideoSendGift");
          paramList1.putExtra("data", ((im_msg_body.Elem)localObject).deliver_gift_msg.toByteArray());
          paramList1.putExtra("troopUin", paramStringBuilder.grayTipsEntity.troopUin);
          paramList1.putExtra("shmsgSeq", paramMsg.msg_head.msg_seq.get());
          paramList1.putExtra("senderName", paramStringBuilder.senderName);
          paramList1.putExtra("rcvName", paramStringBuilder.rcvName);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramList1);
          return;
          paramStringBuilder = (MessageForTroopGift)MessageRecordFactory.a(63498);
          paramStringBuilder.msgtype = 63498;
          break;
          if ((paramStringBuilder.remindBrief != null) && (paramStringBuilder.remindBrief.split("#").length > 1)) {
            paramStringBuilder.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramStringBuilder.remindBrief.split("#")[1]);
          }
        }
      }
      localObject = null;
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    paramStringBuilder = paramList1.iterator();
    Object localObject2;
    do
    {
      if (!paramStringBuilder.hasNext()) {
        break;
      }
      localObject2 = (im_msg_body.Elem)paramStringBuilder.next();
    } while (!((im_msg_body.Elem)localObject2).life_online.has());
    for (;;)
    {
      if (localObject2 == null) {
        return;
      }
      long l1;
      label111:
      long l2;
      label139:
      long l3;
      label166:
      long l4;
      label193:
      int i1;
      int i2;
      int i3;
      String str1;
      String str2;
      label268:
      boolean bool;
      label303:
      int m;
      label342:
      int n;
      label381:
      int i4;
      int i5;
      int i;
      label467:
      int j;
      label506:
      int k;
      label545:
      label574:
      label604:
      Object localObject1;
      label634:
      Object localObject3;
      if ((((im_msg_body.Elem)localObject2).life_online.has()) && (((im_msg_body.Elem)localObject2).life_online.uint32_ack.has()) && (((im_msg_body.Elem)localObject2).life_online.uint32_ack.get() == 1))
      {
        if (((im_msg_body.Elem)localObject2).life_online.uint64_unique_id.has())
        {
          l1 = ((im_msg_body.Elem)localObject2).life_online.uint64_unique_id.get();
          if (!((im_msg_body.Elem)localObject2).life_online.uint32_op.has()) {
            break label1054;
          }
          l2 = ((im_msg_body.Elem)localObject2).life_online.uint32_op.get();
          if (!paramMsg.msg_head.from_uin.has()) {
            break label1060;
          }
          l3 = paramMsg.msg_head.from_uin.get();
          if (!paramMsg.msg_head.to_uin.has()) {
            break label1066;
          }
          l4 = paramMsg.msg_head.to_uin.get();
          PublicAccountManager.a().a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, l1, l2, l3, l4, 1, null);
        }
      }
      else
      {
        i1 = 0;
        i2 = 0;
        i3 = 0;
        paramMessageInfo = "";
        str1 = "";
        str2 = "";
        if (!((im_msg_body.Elem)localObject2).life_online.uint64_unique_id.has()) {
          break label1072;
        }
        l1 = ((im_msg_body.Elem)localObject2).life_online.uint64_unique_id.get();
        if (!((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.has()) {
          break label1084;
        }
        if ((((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get() & 1L) != 1L) {
          break label1078;
        }
        bool = true;
        if (!((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.has()) {
          break label1096;
        }
        if ((((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get() & 0x4) != 4L) {
          break label1090;
        }
        m = 1;
        if (!((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.has()) {
          break label1108;
        }
        if ((((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get() & 0x40) != 64L) {
          break label1102;
        }
        n = 1;
        i4 = (int)((((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get() & 0x180) >> 7);
        i5 = (int)((((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get() & 0x600) >> 9);
        if (m == 0) {
          break label1170;
        }
        if (!((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.has()) {
          break label1120;
        }
        if ((((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get() & 0x8) != 8L) {
          break label1114;
        }
        i = 1;
        if (!((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.has()) {
          break label1132;
        }
        if ((((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get() & 0x10) != 16L) {
          break label1126;
        }
        j = 1;
        if (!((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.has()) {
          break label1144;
        }
        if ((((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get() & 0x20) != 32L) {
          break label1138;
        }
        k = 1;
        if (!((im_msg_body.Elem)localObject2).life_online.gdt_imp_data.has()) {
          break label1150;
        }
        paramStringBuilder = ((im_msg_body.Elem)localObject2).life_online.gdt_imp_data.get().toStringUtf8();
        if (!((im_msg_body.Elem)localObject2).life_online.gdt_cli_data.has()) {
          break label1156;
        }
        paramMessageInfo = ((im_msg_body.Elem)localObject2).life_online.gdt_cli_data.get().toStringUtf8();
        if (!((im_msg_body.Elem)localObject2).life_online.view_id.has()) {
          break label1163;
        }
        localObject1 = ((im_msg_body.Elem)localObject2).life_online.view_id.get().toStringUtf8();
        localObject2 = paramStringBuilder;
        if (paramStringBuilder.length() > 100) {
          localObject2 = paramStringBuilder.substring(0, 100);
        }
        if (paramMessageInfo.length() <= 100) {
          break label1421;
        }
        paramStringBuilder = paramMessageInfo.substring(0, 100);
        localObject3 = localObject2;
      }
      for (;;)
      {
        label678:
        if (!paramList2.isEmpty())
        {
          paramMessageInfo = (MessageRecord)paramList2.get(0);
          paramMessageInfo.extLong |= 0x1;
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("pa_msgHasRead", "false");
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("pa_msgId", String.valueOf(l1));
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("pa_should_report", String.valueOf(bool));
          if (m != 0)
          {
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("isAdMsg", "1");
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("ad_msgHasRead", "false");
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("gdt_msgClick", paramStringBuilder);
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("gdt_msgImp", (String)localObject3);
            paramMessageInfo = (MessageRecord)paramList2.get(0);
            if (i == 0) {
              break label1291;
            }
            paramStringBuilder = "1";
            label871:
            paramMessageInfo.saveExtInfoToExtStr("gdt_singleAd", paramStringBuilder);
            paramMessageInfo = (MessageRecord)paramList2.get(0);
            if (j == 0) {
              break label1298;
            }
            paramStringBuilder = "1";
            label901:
            paramMessageInfo.saveExtInfoToExtStr("gdt_mulAd", paramStringBuilder);
            paramMessageInfo = (MessageRecord)paramList2.get(0);
            if (k == 0) {
              break label1305;
            }
            paramStringBuilder = "1";
            label931:
            paramMessageInfo.saveExtInfoToExtStr("gdt_followAd", paramStringBuilder);
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("is_AdArrive_Msg", "1");
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("gdt_view_id", (String)localObject1);
          }
        }
        if ((n != 0) && (!paramList2.isEmpty()))
        {
          paramList1 = paramList1.iterator();
          i = 0;
          label1001:
          if (paramList1.hasNext())
          {
            paramStringBuilder = (im_msg_body.Elem)paramList1.next();
            if (!paramStringBuilder.pub_acc_info.uint32_is_inter_num.has()) {
              break label1418;
            }
            i = paramStringBuilder.pub_acc_info.uint32_is_inter_num.get();
          }
        }
        label1054:
        label1060:
        label1066:
        label1072:
        label1078:
        label1084:
        label1090:
        label1096:
        label1102:
        label1108:
        label1114:
        label1120:
        label1126:
        label1132:
        label1138:
        label1144:
        label1150:
        label1156:
        label1163:
        label1170:
        label1291:
        label1298:
        label1305:
        label1418:
        for (;;)
        {
          break label1001;
          l1 = 0L;
          break label111;
          l2 = 0L;
          break label139;
          l3 = 0L;
          break label166;
          l4 = 0L;
          break label193;
          l1 = 0L;
          break label268;
          bool = false;
          break label303;
          bool = false;
          break label303;
          m = 0;
          break label342;
          m = 0;
          break label342;
          n = 0;
          break label381;
          n = 0;
          break label381;
          i = 0;
          break label467;
          i = 0;
          break label467;
          j = 0;
          break label506;
          j = 0;
          break label506;
          k = 0;
          break label545;
          k = 0;
          break label545;
          paramStringBuilder = "";
          break label574;
          paramMessageInfo = "";
          break label604;
          localObject1 = "";
          break label634;
          j = i2;
          k = i3;
          localObject3 = str1;
          paramStringBuilder = paramMessageInfo;
          localObject1 = str2;
          i = i1;
          if (!QLog.isColorLevel()) {
            break label678;
          }
          localObject1 = new StringBuilder().append("isAdArriveMsg is false, uint64_bitmap value is: ");
          if (((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.has()) {}
          for (paramStringBuilder = Long.valueOf(((im_msg_body.Elem)localObject2).life_online.uint64_bitmap.get());; paramStringBuilder = "null")
          {
            QLog.d("DecodeMsg", 2, paramStringBuilder);
            j = i2;
            k = i3;
            localObject3 = str1;
            paramStringBuilder = paramMessageInfo;
            localObject1 = str2;
            i = i1;
            break;
          }
          paramStringBuilder = "0";
          break label871;
          paramStringBuilder = "0";
          break label901;
          paramStringBuilder = "0";
          break label931;
          paramList1 = (MessageRecord)paramList2.get(0);
          paramList1.saveExtInfoToExtStr("welcome_msg", "true");
          if ((i == 1) && (((paramList1 instanceof MessageForText)) || ((paramList1 instanceof MessageForLongMsg)))) {
            ThreadManager.b(new upc(this, paramMsg));
          }
          if (paramList2.isEmpty()) {
            break;
          }
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("public_account_msg_unread_flag", String.valueOf(i4));
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("public_account_msg_extra_info_type", String.valueOf(i5));
          return;
        }
        label1421:
        localObject3 = localObject2;
        paramStringBuilder = paramMessageInfo;
      }
      localObject2 = null;
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, boolean paramBoolean)
  {
    int i = 0;
    im_msg_body.Elem localElem = null;
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    Iterator localIterator = paramList1.iterator();
    paramList1 = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.market_face.has())
      {
        if (!localArrayList.isEmpty())
        {
          b(localArrayList, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, paramBoolean);
          localArrayList.clear();
        }
        paramList1 = a(localElem, paramList2, paramStringBuilder);
        i = 1;
      }
      for (;;)
      {
        break;
        if ((i != 0) && (localElem.text.has()) && (paramList1 != null))
        {
          paramList1.faceName = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
          if ((paramList1.faceName.charAt(0) == '[') && (paramList1.faceName.charAt(paramList1.faceName.length() - 1) == ']')) {
            paramList1.faceName = paramList1.faceName.substring(1, paramList1.faceName.length() - 1);
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("filter the text expalin:").append(((im_msg_body.Text)localElem.text.get()).str.get()).append("\n");
          }
          i = 0;
          break;
        }
        localArrayList.add(localElem);
      }
    }
    if (!localArrayList.isEmpty())
    {
      b(localArrayList, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, paramBoolean);
      localArrayList.clear();
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    Iterator localIterator = paramList1.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)localIterator.next();
    } while (!paramList1.hc_flash_pic.has());
    for (;;)
    {
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:FlashPic;\n");
      }
      a(paramList1, null, paramList2, paramStringBuilder, paramMsg, paramBoolean);
      return;
      paramList1 = null;
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    Object localObject = paramList1.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList1.shake_window.has());
    for (;;)
    {
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:ShakeWindow;\n");
      }
      paramList1 = (im_msg_body.ShakeWindow)paramList1.shake_window.get();
      localObject = (MessageForShakeWindow)MessageRecordFactory.a(63516);
      ((MessageForShakeWindow)localObject).msgtype = 63516;
      ((MessageForShakeWindow)localObject).msg = "[Shake Window]";
      ShakeWindowMsg localShakeWindowMsg = new ShakeWindowMsg();
      localShakeWindowMsg.mType = paramList1.uint32_type.get();
      localShakeWindowMsg.mReserve = paramList1.uint32_reserve.get();
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        localShakeWindowMsg.onlineFlag = i;
        localShakeWindowMsg.shake = true;
        ((MessageForShakeWindow)localObject).msgData = localShakeWindowMsg.getBytes();
        if (((MessageForShakeWindow)localObject).msgData != null) {
          break label189;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
        return;
      }
      label189:
      paramList2.add(localObject);
      return;
      paramList1 = null;
    }
  }
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (paramElem != null) {}
    for (boolean bool1 = paramElem.hc_flash_pic.has();; bool1 = false)
    {
      if (paramCustomFace != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:CustomFace: isC2C:").append(paramBoolean).append(";\n");
        }
        StringBuilder localStringBuilder = new StringBuilder("");
        long l1;
        long l2;
        if (paramBoolean)
        {
          localStringBuilder.append(BaseApplication.getContext().getString(2131370482));
          paramElem = (msg_comm.MsgHead)paramMsg.msg_head.get();
          l1 = paramElem.msg_seq.get();
          l2 = paramElem.msg_uid.get();
          long l3 = paramElem.msg_time.get();
          long l4 = paramElem.from_uin.get();
          long l5 = paramElem.to_uin.get();
          paramElem = new HashMap();
          paramElem.put("param_FailCode", String.valueOf(10001));
          paramElem.put("fromUin", String.valueOf(l4));
          paramElem.put("toUin", String.valueOf(l5));
          paramElem.put("msgSeq", String.valueOf(l1));
          paramElem.put("msgUid", String.valueOf(l2));
          paramElem.put("msgtime", String.valueOf(l3));
          paramCustomFace = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a();
          StatisticCollector.a(BaseApplication.getContext()).a(paramCustomFace, "actMessageEvent", false, 0L, 0L, paramElem, "");
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace isC2C");
          }
          return;
        }
        if ((localStringBuilder.length() > 0) && (!bool1) && (!bool2))
        {
          paramMsg = (MessageForText)MessageRecordFactory.a(64536);
          paramMsg.msgtype = 64536;
          paramMsg.msg = localStringBuilder.toString();
          paramList.add(paramMsg);
          localStringBuilder.delete(0, localStringBuilder.length());
        }
        if (paramCustomFace != null) {}
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace hasComFlashPic=" + bool2);
          }
          if (paramCustomFace == null)
          {
            QLog.d("DecodeMsg", 2, "parsePBMsgElems_CustomFace customface is null");
            return;
            if (paramElem != null)
            {
              if (bool1)
              {
                paramCustomFace = (im_msg_body.CustomFace)paramElem.hc_flash_pic.get();
                continue;
              }
              paramCustomFace = (im_msg_body.CustomFace)paramElem.custom_face.get();
            }
          }
          else
          {
            paramElem = paramCustomFace.str_file_path.get();
            paramCustomFace.str_shortcut.get();
            paramMsg = paramCustomFace.str_big_url.get();
            String str1 = paramCustomFace.str_orig_url.get();
            String str2 = paramCustomFace.str_thumb_url.get();
            String str3 = paramCustomFace.str_400_url.get();
            int m = paramCustomFace.uint32_thumb_width.get();
            int n = paramCustomFace.uint32_thumb_height.get();
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "[CustomFace] ThumbWidth=" + m + ",ThumbHeight=" + n + "downURLBigThum400=" + str3);
            }
            int j = paramCustomFace.uint32_show_len.get();
            int i = paramCustomFace.uint32_download_len.get();
            l1 = paramCustomFace.uint32_file_id.get();
            l2 = paramCustomFace.uint32_file_type.get();
            l2 = paramCustomFace.uint32_server_ip.get();
            l2 = paramCustomFace.uint32_server_port.get();
            l2 = paramCustomFace.uint32_useful.get();
            l2 = paramCustomFace.uint32_size.get() & 0xFFFFFFFF;
            int k = paramCustomFace.image_type.get();
            if (QLog.isColorLevel())
            {
              QLog.d("DecodeMsg", 2, "[CustomFace] uint32_size=" + l2);
              QLog.d("DecodeMsg", 2, "[CustomFace] imgType=" + k);
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + j + ", downloadLen " + i + ", fileLen " + l2);
            }
            Object localObject1 = paramCustomFace.bytes_md5.get().toByteArray();
            Object localObject2 = paramCustomFace.bytes_signature.get().toByteArray();
            paramCustomFace.bytes_buffer.get().toByteArray();
            byte[] arrayOfByte = paramCustomFace.bytes_flag.get().toByteArray();
            int i1 = (int)(paramCustomFace.uint32_width.get() & 0xFFFFFFFF);
            int i2 = (int)(paramCustomFace.uint32_height.get() & 0xFFFFFFFF);
            localObject1 = HexUtil.a((byte[])localObject1);
            HexUtil.a((byte[])localObject2);
            HexUtil.a(arrayOfByte);
            int i3 = paramCustomFace.uint32_origin.get();
            localObject2 = TranDbRecord.PicDbRecord.a(paramElem, 0L, 1, false, paramElem, (String)localObject1, "picplatform", str2, str3, paramMsg, str1, i3, 0);
            paramCustomFace = new RichMsg.PicRec();
            paramCustomFace.localPath.set(paramElem);
            paramCustomFace.size.set(l2);
            paramCustomFace.type.set(1);
            paramCustomFace.isRead.set(false);
            paramCustomFace.uuid.set(paramElem);
            paramCustomFace.groupFileID.set(l1 & 0xFFFFFFFF);
            if (localObject1 != null) {
              paramCustomFace.md5.set((String)localObject1);
            }
            paramCustomFace.serverStorageSource.set("picplatform");
            paramCustomFace.thumbMsgUrl.set(str2);
            paramCustomFace.bigthumbMsgUrl.set(str3);
            paramCustomFace.uint32_thumb_width.set(m);
            paramCustomFace.uint32_thumb_height.set(n);
            paramCustomFace.uint32_width.set(i1);
            paramCustomFace.uint32_height.set(i2);
            paramCustomFace.bigMsgUrl.set(paramMsg);
            paramCustomFace.rawMsgUrl.set(str1);
            paramCustomFace.fileSizeFlag.set(0);
            paramCustomFace.uiOperatorFlag.set(0);
            paramCustomFace.version.set(5);
            paramCustomFace.isReport.set(0);
            paramCustomFace.fileSizeFlag.set(i3);
            if (i3 == 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("DecodeMsg", 2, "[customFace] showLen =" + j + ",downloadLen = " + i + ",raw photo msg,clear progressjpg info!");
              }
              j = 0;
              i = 0;
            }
            for (;;)
            {
              paramCustomFace.uint32_show_len.set(j);
              paramCustomFace.uint32_download_len.set(i);
              paramCustomFace.enableEnc.set(true);
              paramCustomFace.uint32_image_type.set(k);
              if (QLog.isColorLevel()) {
                paramStringBuilder.append("protocolStr:").append((String)localObject2).append("\n");
              }
              paramElem = (MessageForPic)MessageRecordFactory.a(63536);
              if (bool1) {
                HotChatHelper.a(paramElem, false);
              }
              if (bool2) {
                FlashPicHelper.a(paramElem, false);
              }
              paramElem.msgtype = 63536;
              paramElem.msgData = paramCustomFace.toByteArray();
              paramElem.parse();
              paramList.add(paramElem);
              localStringBuilder.delete(0, localStringBuilder.length());
              return;
            }
          }
          paramCustomFace = null;
        }
      }
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!localElem.market_trans.has()) {
        break label328;
      }
      localObject1 = (im_msg_body.MarketTrans)localElem.market_trans.get();
    }
    label328:
    for (;;)
    {
      break;
      if (localObject1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:MarketTrans;\n");
      }
      int i = ((im_msg_body.MarketTrans)localObject1).int32_flag.get();
      localObject1 = StructMsgFactory.a(((im_msg_body.MarketTrans)localObject1).bytes_xml.get().toByteArray(), i);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("c2cMsgContent.data:null;\n");
        }
        a(paramList1, paramList2, true);
        return;
      }
      paramStringBuilder = paramList1.iterator();
      while (paramStringBuilder.hasNext())
      {
        localObject2 = (im_msg_body.Elem)paramStringBuilder.next();
        if ((((im_msg_body.Elem)localObject2).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.has())) {
          ((AbsStructMsg)localObject1).msgId = ((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.get();
        }
      }
      paramList1 = a(paramList1, paramList2, false);
      if (paramList1 != null) {
        ((AbsStructMsg)localObject1).mCompatibleText = paramList1;
      }
      paramList1 = (MessageForStructing)MessageRecordFactory.a(63525);
      paramList1.msgtype = 63525;
      paramList1.msg = "MarketTrans";
      paramList1.structingMsg = ((AbsStructMsg)localObject1);
      paramList1.msgData = paramList1.structingMsg.getBytes();
      paramList2.add(paramList1);
      return;
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Object localObject = null;
    Iterator localIterator = paramList1.iterator();
    do
    {
      paramList1 = (List)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)localIterator.next();
    } while (!paramList1.group_file.has());
    paramList1 = (im_msg_body.GroupFile)paramList1.group_file.get();
    if (paramList1 == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GroupFile;\n");
      }
      long l1 = 0L;
      paramStringBuilder = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (paramStringBuilder.discuss_info.has()) {
        l1 = ((msg_comm.DiscussInfo)paramStringBuilder.discuss_info.get()).discuss_uin.get();
      }
      long l4 = paramStringBuilder.from_uin.get();
      long l6 = paramStringBuilder.msg_time.get();
      long l7 = paramStringBuilder.msg_seq.get();
      long l5 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getLongAccountUin();
      if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, 3000, String.valueOf(l1), String.valueOf(l4), l6, l7)) {
        continue;
      }
      paramStringBuilder = "";
      try
      {
        localObject = new String(paramList1.bytes_filename.get().toByteArray(), "UTF-8");
        paramStringBuilder = (StringBuilder)localObject;
        long l3 = 0L;
        l2 = l3;
        if (paramMsg.msg_body.has())
        {
          paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
          l2 = l3;
          if (paramMsg.rich_text.attr.has()) {
            l2 = MessageUtils.a(((im_msg_body.Attr)paramMsg.rich_text.attr.get()).random.get());
          }
        }
        paramMsg = (MessageForFile)MessageRecordFactory.a(63531);
        paramMsg.msgtype = 63531;
        k = 0;
        m = 0;
        j = m;
        i = k;
        if (paramList1.bytes_pb_reserve.has()) {
          localObject = new hummer_resv_21.ResvAttr();
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        try
        {
          long l2;
          int k;
          int m;
          ((hummer_resv_21.ResvAttr)localObject).mergeFrom(paramList1.bytes_pb_reserve.get().toByteArray());
          int j = m;
          int i = k;
          if (((hummer_resv_21.ResvAttr)localObject).file_image_info.has())
          {
            i = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_height.get();
            j = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_width.get();
            paramMsg.saveExtInfoToExtStr("file_pic_width", String.valueOf(j));
            paramMsg.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(i));
          }
          paramMsg.uniseq = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().a(paramMsg.uniseq, l1, l4, l7, l2, l6, paramList1, j, i);
          l1 = paramList1.uint64_file_size.get();
          if (l4 == l5)
          {
            bool = true;
            paramMsg.msg = TransfileUtile.a(paramStringBuilder, l1, 0, bool);
            paramMsg.doParse();
            paramList2.add(paramMsg);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("DecodeMsg", 2, "GroupDiscFile.msg: " + paramList1.bytes_filename.get() + ";");
            return;
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            continue;
            boolean bool = false;
          }
        }
      }
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject4 = null;
    Iterator localIterator = paramList1.iterator();
    Object localObject1 = null;
    Object localObject3 = null;
    if (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.ark_app.has()) {
        localObject3 = (im_msg_body.ArkAppElem)localElem.ark_app.get();
      }
      if (!localElem.light_app.has()) {
        break label543;
      }
      localObject1 = (im_msg_body.LightAppElem)localElem.light_app.get();
    }
    label543:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:ArkApp/LightApp;\n");
      }
      if (!ArkAppCenter.a())
      {
        QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isDeviceSupportArkMsg is false, ignore msg.");
        if (a(paramList1).booleanValue())
        {
          d(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
          return;
        }
        paramList1 = (MessageForText)MessageRecordFactory.a(64536);
        paramList1.msgtype = 64536;
        paramList1.msg = BaseApplication.getContext().getString(2131370375);
        paramList2.add(paramList1);
        return;
      }
      if (ArkAppCenter.b())
      {
        QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isPANonShow is true, ignore msg.");
        return;
      }
      if (localObject3 != null)
      {
        if (!((im_msg_body.ArkAppElem)localObject3).bytes_data.has())
        {
          QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data not exist.");
          return;
        }
        localObject1 = ((im_msg_body.ArkAppElem)localObject3).bytes_data.get().toByteArray();
      }
      for (;;)
      {
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data is empty.");
          return;
          if (localObject1 != null)
          {
            if (!((im_msg_body.LightAppElem)localObject1).bytes_data.has())
            {
              QLog.i("ArkApp", 1, "decode msg, light_app.bytes_data not exist.");
              return;
            }
            localObject1 = ((im_msg_body.LightAppElem)localObject1).bytes_data.get().toByteArray();
          }
        }
        else
        {
          localObject1 = StructMsgUtils.a((byte[])localObject1, -1);
          if ((localObject1 != null) && (localObject1.length > 0)) {}
          for (;;)
          {
            try
            {
              localObject1 = new String((byte[])localObject1, "UTF-8");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              QLog.i("ArkApp", 1, "decode msg, ark data is empty.");
              return;
            }
            catch (Exception localException)
            {
              QLog.i("ArkApp", 1, "decode msg, raw data cannot convert to string.");
              localObject2 = localObject4;
              continue;
            }
            QLog.i("ArkApp", 1, "decode msg, raw data is empty.");
            localObject2 = localObject4;
          }
          localObject4 = a(paramList1, paramList2, false);
          localObject3 = (MessageForArkApp)MessageRecordFactory.a(60528);
          ((MessageForArkApp)localObject3).msgtype = 60528;
          if (localObject4 != null) {
            ((MessageForArkApp)localObject3).compatibleMsg = ((String)localObject4);
          }
          localObject4 = new ArkAppMessage();
          ((ArkAppMessage)localObject4).fromAppXml((String)localObject2);
          ((MessageForArkApp)localObject3).msgData = ((ArkAppMessage)localObject4).toBytes();
          ((MessageForArkApp)localObject3).parse();
          if ((!TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appName)) && (!TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appView))) {
            paramList2.add(localObject3);
          }
          for (int i = 1; i == 0; i = 0)
          {
            d(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
            return;
            QLog.i("ArkApp", 1, "decode msg, ark message is not valid..");
          }
          break;
        }
        Object localObject2 = null;
      }
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("");
    String str = null;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = new ArrayList(2);
    Iterator localIterator = paramList1.iterator();
    int i = 0;
    im_msg_body.Elem localElem;
    Object localObject3;
    MessageForText localMessageForText;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.custom_face.has())
      {
        localObject3 = localObject2;
        if (((StringBuilder)localObject1).length() > 0)
        {
          localMessageForText = (MessageForText)MessageRecordFactory.a(64536);
          localMessageForText.msgtype = 64536;
          localMessageForText.msg = ((StringBuilder)localObject1).toString();
          localMessageForText.atInfoList = ((ArrayList)localObject2);
          localObject3 = new ArrayList(2);
          localArrayList1.add(localMessageForText);
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
        }
        a(localElem, null, localArrayList1, paramStringBuilder, paramMsg, paramBoolean);
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      break;
      if (localElem.not_online_image.has())
      {
        localObject3 = localObject2;
        if (((StringBuilder)localObject1).length() > 0)
        {
          localMessageForText = (MessageForText)MessageRecordFactory.a(64536);
          localMessageForText.msgtype = 64536;
          localMessageForText.msg = ((StringBuilder)localObject1).toString();
          localMessageForText.atInfoList = ((ArrayList)localObject2);
          localObject3 = new ArrayList(2);
          localArrayList1.add(localMessageForText);
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
        }
        a(localElem, null, localArrayList1, paramStringBuilder, paramMsg);
        localObject2 = localObject3;
      }
      else if (a(localElem).booleanValue())
      {
        if (i != 0)
        {
          i = 0;
          break;
        }
        if (localElem.small_emoji.has()) {
          i = 1;
        }
        localObject3 = new ArrayList();
        ((List)localObject3).add(localElem);
        localObject1 = a((StringBuilder)localObject1, (List)localObject3, localArrayList1, paramStringBuilder, paramMsg, paramMessageInfo, localArrayList2, (ArrayList)localObject2);
        continue;
        if (((StringBuilder)localObject1).length() > 0)
        {
          localObject3 = (MessageForText)MessageRecordFactory.a(64536);
          ((MessageForText)localObject3).msgtype = 64536;
          ((MessageForText)localObject3).msg = ((StringBuilder)localObject1).toString();
          ((MessageForText)localObject3).atInfoList = ((ArrayList)localObject2);
          if (paramMessageInfo != null) {
            AtTroopMemberSpan.a(paramMessageInfo.jdField_a_of_type_Int, (ArrayList)localObject2, (ChatMessage)localObject3);
          }
          localArrayList1.add(localObject3);
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
        }
        if ((localArrayList2 != null) && (localArrayList2.size() == 2)) {
          if (localArrayList2.get(0) != null)
          {
            localObject1 = (MessageForText.AtTroopMemberInfo)localArrayList2.get(0);
            if (localArrayList2.get(1) != null)
            {
              localObject3 = (byte[])localArrayList2.get(1);
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
        for (;;)
        {
          paramStringBuilder = a(paramList1, paramStringBuilder);
          paramList1 = (MessageForReplyText.SourceMsgInfo)paramStringBuilder.first;
          localObject3 = (TroopTopicMgr.GroupPostElemInfo)paramStringBuilder.second;
          if (paramList1 != null) {
            paramStringBuilder = (MessageForReplyText)MessageRecordFactory.a(64487);
          }
          try
          {
            str = HexUtil.a(MessagePkgUtils.a(paramList1));
            paramStringBuilder.mSourceMsgInfo = paramList1;
            paramStringBuilder.saveExtInfoToExtStr("sens_msg_source_msg_info", str);
            if (localObject3 != null)
            {
              paramList1 = HexUtil.a(MessagePkgUtils.a((Serializable)localObject3));
              paramStringBuilder.mGroupPostElemInfo = ((TroopTopicMgr.GroupPostElemInfo)localObject3);
              paramStringBuilder.saveExtInfoToExtStr("sens_msg_source_msg_troop_topic_info", paramList1);
            }
            paramStringBuilder.extLong |= 0x1;
          }
          catch (Exception paramList1)
          {
            for (;;)
            {
              int j;
              long l;
              if (QLog.isColorLevel())
              {
                QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramList1.getMessage());
                continue;
                paramList1 = paramStringBuilder;
                if (QLog.isColorLevel())
                {
                  QLog.w("zivonchen", 2, "replytext 内容为空，有回复消息，但第一个消息体不是文本消息");
                  paramList1 = paramStringBuilder;
                  continue;
                  paramList1 = paramStringBuilder;
                  if (QLog.isColorLevel())
                  {
                    QLog.w("zivonchen", 2, "");
                    paramList1 = paramStringBuilder;
                    continue;
                    if (paramStringBuilder.msgtype == 63536)
                    {
                      j += 1;
                      continue;
                      continue;
                      paramList1 = (List)localObject1;
                      continue;
                      paramStringBuilder.add(localObject3);
                      continue;
                      if (paramStringBuilder.size() > 0)
                      {
                        if (j != 0) {
                          localObject1 = null;
                        }
                        paramList1 = MessageProtoCodec.a(paramStringBuilder, (byte[])localObject1, paramMessageInfo);
                        paramList2.add(paramList1);
                        ((MessageForMixedMsg)paramList1).mAtInfo = ((MessageForText.AtTroopMemberInfo)localObject2);
                        paramStringBuilder.clear();
                      }
                      for (;;)
                      {
                        return;
                        if (localObject1 == null)
                        {
                          paramList2.addAll(localArrayList1);
                          return;
                        }
                        paramList1 = localArrayList1.iterator();
                        while (paramList1.hasNext())
                        {
                          paramStringBuilder = (MessageRecord)paramList1.next();
                          if (((paramStringBuilder instanceof MessageForText)) && (j == 0)) {
                            paramStringBuilder.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a((byte[])localObject1));
                          }
                          paramList2.add(paramStringBuilder);
                        }
                      }
                      j = 0;
                    }
                    else
                    {
                      continue;
                      i = 0;
                    }
                  }
                }
              }
            }
          }
          paramList1 = paramStringBuilder;
          if (TextUtils.isEmpty(paramStringBuilder.mSourceMsgInfo.mAnonymousNickName))
          {
            paramList1 = paramStringBuilder;
            if (localObject2 != null)
            {
              if (localArrayList1.size() <= 0) {
                break label1195;
              }
              paramList1 = (MessageRecord)localArrayList1.get(0);
              if (!(paramList1 instanceof MessageForText)) {
                break label1172;
              }
              localObject3 = (MessageForReplyText)MessageRecordFactory.a(64487);
              MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject3, paramList1);
              MessageRecord.copyMessageRecordStatusField((MessageRecord)localObject3, paramList1);
              ((MessageForReplyText)localObject3).atInfoList = paramStringBuilder.atInfoList;
              ((MessageForReplyText)localObject3).msg = paramList1.msg;
              ((MessageForReplyText)localObject3).mGroupPostElemInfo = paramStringBuilder.mGroupPostElemInfo;
              ((MessageForReplyText)localObject3).mSourceMsgInfo = paramStringBuilder.mSourceMsgInfo;
              ((MessageForReplyText)localObject3).msgtype = 64487;
              if ((!TextUtils.isEmpty(((MessageForReplyText)localObject3).msg)) && (((MessageForReplyText)localObject3).msg.length() >= ((MessageForText.AtTroopMemberInfo)localObject2).textLen + 1))
              {
                ((MessageForReplyText)localObject3).msg = ((MessageForReplyText)localObject3).msg.substring(((MessageForText.AtTroopMemberInfo)localObject2).textLen + 1);
                if (((MessageForText.AtTroopMemberInfo)localObject2).isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getLongAccountUin())) {
                  paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a = -1L;
                }
              }
              localArrayList1.remove(0);
              localArrayList1.add(0, localObject3);
              paramList1 = null;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "sb.length == 0");
          }
          if (paramList1 != null) {
            localArrayList1.add(paramList1);
          }
          if (localArrayList1.size() > 1)
          {
            paramList1 = localArrayList1.iterator();
            j = 0;
            i = 0;
            if (paramList1.hasNext())
            {
              paramStringBuilder = (MessageRecord)paramList1.next();
              if (((paramStringBuilder.msgtype == 64536) || (paramStringBuilder.msgtype == 64487)) && (i == 0))
              {
                i = 1;
                j += 1;
                if (j < 2) {
                  break label1236;
                }
                i = 1;
                if (!paramMsg.msg_head.from_uin.has()) {
                  break label1384;
                }
                l = paramMsg.msg_head.from_uin.get();
                if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(), Long.toString(l))) {
                  break label1384;
                }
                j = 1;
                if (i == 0) {
                  break label1307;
                }
                paramStringBuilder = new ArrayList();
                paramMsg = localArrayList1.iterator();
                for (;;)
                {
                  if (!paramMsg.hasNext()) {
                    break label1257;
                  }
                  localObject3 = (MessageRecord)paramMsg.next();
                  if ((((MessageRecord)localObject3).msgtype == 64536) || (((MessageRecord)localObject3).msgtype == 64487) || (((MessageRecord)localObject3).msgtype == 63536)) {
                    break label1245;
                  }
                  if (paramStringBuilder.size() > 0)
                  {
                    if (j == 0) {
                      break;
                    }
                    paramList1 = null;
                    paramList2.add(MessageProtoCodec.a(paramStringBuilder, paramList1, paramMessageInfo));
                    paramStringBuilder.clear();
                  }
                  paramList2.add(localObject3);
                }
              }
            }
          }
          label1172:
          label1195:
          label1236:
          label1245:
          label1257:
          label1307:
          label1384:
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          localObject1 = null;
          break;
          localObject1 = null;
          localObject2 = str;
        }
      }
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList1 = paramList1.iterator();
    Object localObject;
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)paramList1.next();
    } while (!((im_msg_body.Elem)localObject).common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null) {}
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "decodePBMsgElems_FlashPicCommen isC2C=" + paramBoolean);
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("ELEM_FlashPicCommen;\n");
          }
          localObject = new hummer_commelem.MsgElemInfo_servtype3();
          try
          {
            ((hummer_commelem.MsgElemInfo_servtype3)localObject).mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
            if (!paramBoolean)
            {
              if (!((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.has()) {
                continue;
              }
              a(null, (im_msg_body.CustomFace)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.get(), paramList2, paramStringBuilder, paramMsg, paramBoolean);
            }
          }
          catch (InvalidProtocolBufferMicroException paramList1)
          {
            paramList1.printStackTrace();
            return;
          }
        }
      } while (!((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.has());
      a(null, (im_msg_body.NotOnlineImage)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.get(), paramList2, paramStringBuilder, paramMsg);
      return;
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    JSONObject localJSONObject = null;
    paramList1 = paramList1.iterator();
    Object localObject;
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)paramList1.next();
    } while (!((im_msg_body.Elem)localObject).apollo_msg.has());
    for (paramList1 = (im_msg_body.ApolloActMsg)((im_msg_body.Elem)localObject).apollo_msg.get();; paramList1 = null)
    {
      if (paramList1 == null) {}
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:Apollo...\n");
          }
        } while (paramList1 == null);
        try
        {
          localObject = new ApolloMessage();
          ((ApolloMessage)localObject).id = paramList1.uint32_action_id.get();
          ((ApolloMessage)localObject).name = paramList1.bytes_action_name.get().toByteArray();
          if ((!paramBoolean) && (paramList1.bytes_action_text.has())) {
            ((ApolloMessage)localObject).text = paramList1.bytes_action_text.get().toByteArray();
          }
          paramStringBuilder = localJSONObject;
          if (paramList1.input_text.has())
          {
            localJSONObject = new JSONObject();
            paramStringBuilder = new String(paramList1.input_text.get().toByteArray());
            localJSONObject.put("inputText", paramStringBuilder);
            ((ApolloMessage)localObject).extStr = localJSONObject.toString();
          }
          ((ApolloMessage)localObject).flag = paramList1.uint32_flag.get();
          ((ApolloMessage)localObject).peer_uin = Utils.a(paramList1.uint32_peer_uin.get());
          ((ApolloMessage)localObject).sender_ts = Utils.a(paramList1.uint32_sender_ts.get());
          ((ApolloMessage)localObject).peer_ts = Utils.a(paramList1.uint32_peer_ts.get());
          ((ApolloMessage)localObject).sender_status = paramList1.int32_sender_status.get();
          ((ApolloMessage)localObject).peer_status = paramList1.int32_peer_status.get();
          paramList1 = (MessageForApollo)MessageRecordFactory.a(63497);
          paramList1.msgtype = 63497;
          paramList1.mApolloMessage = ((ApolloMessage)localObject);
          paramList1.msgData = MessagePkgUtils.a((Serializable)localObject);
          paramList1.inputText = paramStringBuilder;
          paramList2.add(paramList1);
          return;
        }
        catch (Throwable paramList1) {}
      } while (!QLog.isColorLevel());
      QLog.e("DecodeMsg", 2, "decode apollo msg failed", paramList1);
      return;
    }
  }
  
  public void c(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    MessageForIncompatibleGrayTips localMessageForIncompatibleGrayTips = null;
    Iterator localIterator = paramList1.iterator();
    do
    {
      paramList1 = localMessageForIncompatibleGrayTips;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)localIterator.next();
    } while (!paramList1.tips_info.has());
    paramList1 = (im_msg_body.TipsInfo)paramList1.tips_info.get();
    if (paramList1 == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:TipsInfo;\n");
      }
      localMessageForIncompatibleGrayTips = (MessageForIncompatibleGrayTips)MessageRecordFactory.a(60534);
      if (localMessageForIncompatibleGrayTips.parseTextXML(paramList1.text.get()).booleanValue())
      {
        paramList2.add(localMessageForIncompatibleGrayTips);
        return;
      }
    } while (!QLog.isColorLevel());
    paramStringBuilder.append("TipsInfo parse failed;\n");
  }
  
  public void c(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    DingdongPluginManager localDingdongPluginManager = null;
    Object localObject = paramList1.iterator();
    do
    {
      paramList1 = localDingdongPluginManager;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList1.msg_workflow_notify.has());
    paramList1 = (im_msg_body.WorkflowNotifyMsg)paramList1.msg_workflow_notify.get();
    if (paramList1 == null) {}
    for (;;)
    {
      return;
      long l1 = paramMsg.msg_head.from_uin.get();
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("elemType: dingdong_msg;\n");
        QLog.i("Approval", 1, "recv Dingdong Msg from[" + l1 + "]");
      }
      try
      {
        localObject = new Qworkflow.Notification();
        ((Qworkflow.Notification)localObject).mergeFrom(paramList1.bytes_ext_msg.get().toByteArray());
        if (((Qworkflow.Notification)localObject).msg_workflow_change.has()) {}
        for (paramList1 = (Qworkflow.WorkflowChangeNotification)((Qworkflow.Notification)localObject).msg_workflow_change.get();; paramList1 = null)
        {
          l1 = ((Qworkflow.Notification)localObject).msg_appid.uint64_appid.get();
          localDingdongPluginManager = (DingdongPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(114);
          if (l1 == 1800000001L)
          {
            paramMsg = paramList1.bytes_workflow_id.get().toStringUtf8();
            i = paramList1.uint32_sub_type.get();
            long l2 = paramList1.uint64_author_uin.get();
            j = paramList1.enum_change_type.get();
            if (QLog.isColorLevel())
            {
              int k = paramList1.uint32_main_type.get();
              localObject = paramList1.bytes_title.get().toStringUtf8();
              String str = paramList1.msg_summary.bytes_content.get().toStringUtf8();
              int m = paramList1.enum_change_type.get();
              int n = paramList1.msg_current_state.uint32_state_num.get();
              paramStringBuilder.append("appid[").append(l1).append("]");
              paramStringBuilder.append("workId[").append(paramMsg).append("]");
              paramStringBuilder.append("mainType[").append(k).append("]");
              paramStringBuilder.append("subType[").append(i).append("]");
              paramStringBuilder.append("creator[").append(l2).append("]");
              paramStringBuilder.append("title[").append((String)localObject).append("]");
              paramStringBuilder.append("summary[").append(str).append("]");
              paramStringBuilder.append("notifyType[").append(m).append("]");
              paramStringBuilder.append("status[").append(n).append("]").append("\n");
            }
            if ((j >= 4) && (j <= 8))
            {
              paramStringBuilder = (MessageForApproval)MessageRecordFactory.a(63496);
              paramStringBuilder.msgtype = 63496;
              paramStringBuilder.msgData = paramList1.toByteArray();
              paramStringBuilder.parse();
              paramList2.add(paramStringBuilder);
              if (j == 7) {
                localDingdongPluginManager.a(paramMsg);
              }
            }
            for (;;)
            {
              localDingdongPluginManager.a(paramMsg, i, l2);
              return;
              if (j == 8)
              {
                localDingdongPluginManager.b(paramMsg);
                continue;
                if ((j == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().equalsIgnoreCase(String.valueOf(l2))))
                {
                  paramStringBuilder = (MessageForGrayTips)MessageRecordFactory.a(63495);
                  paramStringBuilder.saveExtInfoToExtStr("approval_workid", paramMsg);
                  paramStringBuilder.saveExtInfoToExtStr("approval_subtype", String.valueOf(i));
                  paramStringBuilder.msgtype = 63495;
                  paramStringBuilder.isread = true;
                  paramStringBuilder.issend = 0;
                  paramStringBuilder.msgData = paramList1.toByteArray();
                  paramList2.add(paramStringBuilder);
                }
                else if (j == 1)
                {
                  localDingdongPluginManager.c(paramMsg);
                }
              }
            }
          }
          if ((l1 != 1800000002L) || (!((Qworkflow.Notification)localObject).msg_schedule_change.has())) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("DingdongScheduleMessage", 2, "A Schedule message");
          }
          ThreadManager.a(new upd(this), 5, null, true);
          int i = ((Qworkflow.Notification)localObject).msg_schedule_change.uint32_main_type.get();
          int j = ((Qworkflow.Notification)localObject).msg_schedule_change.uint32_sub_type.get();
          if ((i != 100) || (j != 1)) {
            break;
          }
          paramList1 = (MessageForDingdongSchedule)MessageRecordFactory.a(60526);
          paramList1.msgData = ((Qworkflow.ScheduleChangeNotification)((Qworkflow.Notification)localObject).msg_schedule_change.get()).toByteArray();
          paramList1.parse();
          paramList1.scheduleC2CdataReport();
          ((DingdongPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(114)).a(paramList1, paramMsg.msg_head.msg_time.get());
          if (!paramList1.canShowInAIO()) {
            break;
          }
          paramList2.add(paramList1);
          return;
        }
        return;
      }
      catch (Exception paramList1) {}
    }
  }
  
  public void c(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = paramList1.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
    } while (!((im_msg_body.Elem)localObject2).qqwallet_msg.has());
    for (localObject1 = (im_msg_body.QQWalletMsg)((im_msg_body.Elem)localObject2).qqwallet_msg.get();; localObject1 = null)
    {
      if (localObject1 == null) {}
      label121:
      label255:
      int i;
      label355:
      label535:
      label541:
      label642:
      label678:
      do
      {
        do
        {
          int k;
          int n;
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                paramStringBuilder.append("elemType:QQWalletMsg;\n");
              }
            } while (!((im_msg_body.QQWalletMsg)localObject1).aio_body.has());
            k = 0;
            n = ((im_msg_body.QQWalletMsg)localObject1).aio_body.sint32_msgtype.get();
          } while (n > 3000);
          int j;
          boolean bool;
          long l;
          if (n > 2000)
          {
            j = k;
            if (j != 0) {
              break label812;
            }
            localObject2 = (MessageForQQWalletMsg)MessageRecordFactory.a(63511);
            ((MessageForQQWalletMsg)localObject2).msgtype = 63511;
            ((MessageForQQWalletMsg)localObject2).messageType = ((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get()).sint32_msgtype.get();
            if (!((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get()).sint32_redtype.has()) {
              break label642;
            }
            ((MessageForQQWalletMsg)localObject2).mQQWalletTransferMsg = null;
            ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg = new QQWalletRedPacketMsg(((im_msg_body.QQWalletMsg)localObject1).aio_body, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a());
            if ((((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg != null) && ((n == 4) || (n == 5)))
            {
              if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.msgFrom != 1) {
                break label535;
              }
              bool = true;
              ((MessageForQQWalletMsg)localObject2).isBlessMsg = bool;
              if (QLog.isColorLevel()) {
                QLog.d("BlessManagerHB", 2, "decode msgFrom=" + ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.msgFrom);
              }
            }
            if (n == 6)
            {
              i = paramMsg.msg_head.msg_type.get();
              if ((i != 82) && (i != 43)) {
                break label541;
              }
              i = 1;
              l = paramMsg.msg_head.group_info.group_code.get();
              ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(124)).a((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get(), i, l, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_time.get());
            }
          }
          for (;;)
          {
            ((MessageForQQWalletMsg)localObject2).msg = ((MessageForQQWalletMsg)localObject2).getMsgSummary();
            ((MessageForQQWalletMsg)localObject2).msgData = ((MessageForQQWalletMsg)localObject2).getBytes();
            if ((localObject2 != null) && (!((MessageForQQWalletMsg)localObject2).isMsgEmpty())) {
              break label678;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            paramStringBuilder.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
            return;
            j = k;
            if (n > 1000) {
              break label121;
            }
            int m = 0;
            localObject2 = MessageForQQWalletMsg.mMsgType;
            int i1 = localObject2.length;
            j = 0;
            for (;;)
            {
              i = m;
              if (j < i1)
              {
                if (localObject2[j] == n) {
                  i = 1;
                }
              }
              else
              {
                j = k;
                if (i != 0) {
                  break;
                }
                j = 1;
                break;
              }
              j += 1;
            }
            bool = false;
            break label255;
            if ((i == 83) || (i == 42))
            {
              i = 2;
              l = paramMsg.msg_head.discuss_info.discuss_uin.get();
              break label355;
            }
            i = 3;
            if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {}
            for (l = paramMsg.msg_head.from_uin.get();; l = paramMsg.msg_head.to_uin.get()) {
              break;
            }
            ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg = null;
            ((MessageForQQWalletMsg)localObject2).mQQWalletTransferMsg = new QQWalletTransferMsg(((im_msg_body.QQWalletMsg)localObject1).aio_body, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a());
          }
          if (((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.has()) {}
          for (i = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.get(); i >= 3; i = 10)
          {
            paramList2.add(localObject2);
            return;
          }
          if (i < 2) {
            break;
          }
          d(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
        } while (!paramList2.isEmpty());
        paramList2.add(localObject2);
        return;
      } while (i < 1);
      d(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
      if (paramList2.isEmpty())
      {
        h(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
        return;
      }
      paramList2.add(localObject2);
      return;
      label812:
      h(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
      return;
    }
  }
  
  public void d(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    paramList1 = paramList1.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramList1.next();
    } while (!localElem.common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)localElem.common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:TroopReward;\n");
      }
      paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype1();
      for (;;)
      {
        try
        {
          paramStringBuilder.mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
          if (((!paramStringBuilder.uint32_pic_type.has()) || (paramStringBuilder.uint32_pic_type.get() != 1)) && ((!paramStringBuilder.uint32_reward_type_ext.has()) || (paramStringBuilder.uint32_reward_type_ext.get() != 2))) {
            break;
          }
          paramList1 = (MessageForTroopReward)MessageRecordFactory.a(63488);
          paramList1.msgtype = 63488;
          paramList1.rewardId = paramStringBuilder.bytes_reward_id.get().toStringUtf8();
          paramList1.rewardCreateTime = paramStringBuilder.uint32_create_timestamp.get();
          paramList1.rewardContent = paramStringBuilder.bytes_content.get().toStringUtf8();
          if (paramStringBuilder.uint32_pic_type.has())
          {
            paramList1.rewardType = paramStringBuilder.uint32_pic_type.get();
            paramList1.rewardMoney = paramStringBuilder.uint32_reward_money.get();
            paramList1.rewardUrl = paramStringBuilder.bytes_url.get().toStringUtf8();
            paramList1.videoSize = paramStringBuilder.uint32_size.get();
            paramList1.videoDuration = paramStringBuilder.uint32_video_duration.get();
            paramList1.rewardSeq = paramStringBuilder.uint64_seq.get();
            paramList1.updateTime = paramList1.rewardCreateTime;
            paramList1.prewrite();
            paramList2.add(paramList1);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList1)
        {
          paramList1.printStackTrace();
          return;
        }
        if (paramStringBuilder.uint32_reward_type_ext.has()) {
          paramList1.rewardType = paramStringBuilder.uint32_reward_type_ext.get();
        }
      }
    }
  }
  
  public void d(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!localElem.trans_elem_info.has()) {
        break label1355;
      }
      localObject1 = (im_msg_body.TransElem)localElem.trans_elem_info.get();
    }
    label721:
    label723:
    label1347:
    label1355:
    for (;;)
    {
      break;
      if (localObject1 == null) {}
      int i;
      int j;
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("elemType:TransElemInfo;\n");
            }
            i = ((im_msg_body.TransElem)localObject1).elem_type.get();
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("transElemType:").append(i).append(";\n");
            }
            localObject2 = ((im_msg_body.TransElem)localObject1).elem_value.get().toByteArray();
            if ((localObject2 == null) || (localObject2.length == 0))
            {
              paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
              return;
            }
            switch (i)
            {
            default: 
              return;
            case 3: 
              paramList1 = BaseApplication.getContext().getString(2131370482);
              paramStringBuilder = (MessageForText)MessageRecordFactory.a(64536);
              paramStringBuilder.msgtype = 64536;
              paramStringBuilder.msg = paramList1;
              paramList2.add(paramStringBuilder);
              return;
            }
          } while (localObject2[0] != 1);
          i = PkgTools.a((byte[])localObject2, 1);
          j = localObject2[3];
          localObject1 = new byte[i - 1];
          PkgTools.a((byte[])localObject1, 0, (byte[])localObject2, 4, i - 1);
          paramStringBuilder = (StringBuilder)localObject1;
          if (j == 1) {
            paramStringBuilder = a((byte[])localObject1);
          }
          if (paramStringBuilder == null) {
            break label1347;
          }
          for (;;)
          {
            Object localObject3;
            try
            {
              if (paramStringBuilder.length <= 0) {
                break label1347;
              }
              paramStringBuilder = new String(paramStringBuilder, "utf-8");
            }
            catch (Exception localException2)
            {
              long l;
              paramList1 = "";
              paramStringBuilder = null;
              continue;
            }
            try
            {
              localObject1 = a(paramStringBuilder);
              if (localObject1 == null) {
                continue;
              }
              try
              {
                paramList1 = paramList1.iterator();
                if (!paramList1.hasNext()) {
                  continue;
                }
                localObject2 = (im_msg_body.Elem)paramList1.next();
                if ((((im_msg_body.Elem)localObject2).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.has()))
                {
                  ((PAMessage)localObject1).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.get();
                  continue;
                  ((Exception)localObject1).printStackTrace();
                }
              }
              catch (Exception localException4)
              {
                paramList1 = (List)localObject1;
                localObject1 = localException4;
                localObject3 = paramStringBuilder;
                paramStringBuilder = paramList1;
                paramList1 = (List)localObject3;
              }
            }
            catch (Exception localException3)
            {
              localObject3 = null;
              paramList1 = paramStringBuilder;
              paramStringBuilder = (StringBuilder)localObject3;
              continue;
              paramList1 = null;
            }
          }
          if (!paramMsg.msg_head.from_uin.has()) {
            break;
          }
          l = paramMsg.msg_head.from_uin.get();
        } while (PAWeatherItemBuilder.a(l + ""));
      } while (paramStringBuilder == null);
      paramMsg = (MessageForPubAccount)MessageRecordFactory.a(62530);
      paramMsg.msgtype = 62530;
      paramMsg.msg = paramList1.toString();
      paramMsg.mPAMessage = paramStringBuilder;
      for (;;)
      {
        try
        {
          paramMsg.msgData = PAMessageUtil.a(paramStringBuilder);
          paramList2.add(paramMsg);
          return;
          paramList1 = paramStringBuilder;
          paramStringBuilder = (StringBuilder)localObject1;
        }
        catch (Exception paramList1)
        {
          paramList1.printStackTrace();
          continue;
        }
        int k = ((im_msg_body.TransElem)localObject1).elem_value.get().size();
        j = 0;
        i = 0;
        for (;;)
        {
          if (k <= 3) {
            break label721;
          }
          int m = j + 1;
          if (j > 100) {
            break;
          }
          int n = localObject3[i];
          int i1 = PkgTools.a((byte[])localObject3, i + 1);
          j = k - (i1 + 3);
          k = i1 + 3 + i;
          if (n != 1)
          {
            i = k;
            k = j;
            j = m;
          }
          else
          {
            paramList1 = new byte[i1];
            PkgTools.a(paramList1, 0, (byte[])localObject3, i + 3, i1);
            paramStringBuilder = new obj_msg.ObjMsg();
            try
            {
              paramList1 = (obj_msg.ObjMsg)paramStringBuilder.mergeFrom(paramList1);
              if (paramList1.uint32_msg_type.get() == 6L) {
                break label723;
              }
              i = k;
              k = j;
              j = m;
            }
            catch (Exception paramList1)
            {
              i = k;
              k = j;
              j = m;
            }
          }
        }
        break;
        paramStringBuilder = new TroopFileData();
        paramStringBuilder.fileUrl = new String(((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
        paramStringBuilder.bisID = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
        paramStringBuilder.fileName = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.str_file_name.get();
        paramStringBuilder.lfileSize = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.uint64_file_size.get();
        paramStringBuilder.lastTime = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.int64_dead_time.get();
        paramStringBuilder.sha1 = new String(((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
        paramStringBuilder.uuid = UUID.nameUUIDFromBytes(paramStringBuilder.fileUrl.getBytes()).toString();
        if (((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.bytes_ext.has()) {
          localObject1 = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          paramStringBuilder.width = ((JSONObject)localObject1).optInt("width");
          paramStringBuilder.height = ((JSONObject)localObject1).optInt("height");
          paramStringBuilder.dspFileName = new String(paramList1.bytes_title.get().toByteArray());
          paramStringBuilder.dspFileSize = new String(((ByteStringMicro)paramList1.rpt_bytes_abstact.get(0)).toByteArray());
          TroopFileDataManager.a(paramMsg.msg_head.group_info.group_code.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, paramStringBuilder.fileUrl, paramStringBuilder);
          localObject1 = new StringBuilder("decodePBMshElems==>").append(paramStringBuilder.toString());
          paramList1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, paramMsg.msg_head.group_info.group_code.get()).a(paramStringBuilder.fileUrl);
          if (paramList1 != null)
          {
            paramList1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().a(paramList1.d);
            if (paramList1 != null) {
              paramList1.lastTime = paramStringBuilder.lastTime;
            }
            localObject3 = (MessageForTroopFile)MessageRecordFactory.a(63519);
            ((MessageForTroopFile)localObject3).msgtype = 63519;
            ((MessageForTroopFile)localObject3).msg = "[群文件]";
          }
        }
        catch (Exception localException1)
        {
          try
          {
            ((MessageForTroopFile)localObject3).msgData = MessagePkgUtils.a(paramStringBuilder);
            ((MessageForTroopFile)localObject3).parse();
            paramList2.add(localObject3);
            if (paramList1 != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().a(paramMsg.msg_head.group_info.group_code.get() + "", 1, paramList1.structMsgSeq, ((MessageForTroopFile)localObject3).msgData);
              ((StringBuilder)localObject1).append("|updateMsgContentByUniseq, msgSeq:").append(paramList1.structMsgSeq);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("DecodeMsg", 2, ((StringBuilder)localObject1).toString());
            return;
            localException1 = localException1;
            localException1.printStackTrace();
          }
          catch (Exception paramStringBuilder)
          {
            for (;;)
            {
              paramStringBuilder.printStackTrace();
            }
          }
        }
        paramList1 = "";
        paramStringBuilder = null;
      }
    }
  }
  
  public void d(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject2 = null;
    Object localObject4 = paramList1.iterator();
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject5;
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = (im_msg_body.Elem)((Iterator)localObject4).next();
      if (!((im_msg_body.Elem)localObject5).rich_msg.has()) {
        break label2574;
      }
      localObject1 = (im_msg_body.RichMsg)((im_msg_body.Elem)localObject5).rich_msg.get();
    }
    label242:
    label1431:
    label1458:
    label1502:
    label1573:
    label1579:
    label1585:
    label2096:
    label2267:
    label2542:
    label2554:
    label2561:
    label2574:
    for (;;)
    {
      if (((im_msg_body.Elem)localObject5).general_flags.has()) {
        localObject3 = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject5).general_flags.get();
      }
      for (;;)
      {
        if (((im_msg_body.Elem)localObject5).text.has()) {
          localObject2 = (im_msg_body.Text)((im_msg_body.Elem)localObject5).text.get();
        }
        for (;;)
        {
          break;
          if (localObject1 == null) {
            return;
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:RichMsg;\n");
          }
          int j = 0;
          int i = j;
          if (localObject3 != null)
          {
            i = j;
            if (((im_msg_body.GeneralFlags)localObject3).long_text_flag.get() == 1)
            {
              j = 1;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, longTextFlag: true");
                i = j;
              }
            }
          }
          localObject4 = null;
          if (((im_msg_body.RichMsg)localObject1).bytes_template_1.has()) {
            localObject4 = ((im_msg_body.RichMsg)localObject1).bytes_template_1.get().toByteArray();
          }
          long l1;
          MessageForStructing localMessageForStructing;
          int m;
          long l2;
          if (paramMsg.msg_head.from_uin.has())
          {
            l1 = paramMsg.msg_head.from_uin.get();
            localMessageForStructing = new MessageForStructing();
            localMessageForStructing.msgtype = 63525;
            long l3 = paramMsg.msg_head.to_uin.get();
            m = paramMsg.msg_head.msg_type.get();
            if (m != 82)
            {
              l2 = l3;
              if (m != 43) {}
            }
            else
            {
              l2 = l3;
              if (paramMsg.msg_head.group_info != null)
              {
                l2 = l3;
                if (paramMsg.msg_head.group_info.group_code.has()) {
                  l2 = paramMsg.msg_head.group_info.group_code.get();
                }
              }
            }
            localObject1 = ((im_msg_body.RichMsg)localObject1).bytes_msg_resid.get();
            if (localObject1 == null) {
              break label2561;
            }
          }
          for (localObject5 = ((ByteStringMicro)localObject1).toStringUtf8();; localObject5 = "")
          {
            Object localObject6;
            if (!StringUtil.b((String)localObject5))
            {
              localObject1 = "";
              localObject6 = paramList1.iterator();
              do
              {
                localObject3 = localObject1;
                if (!((Iterator)localObject6).hasNext()) {
                  break;
                }
                localObject3 = (im_msg_body.Elem)((Iterator)localObject6).next();
              } while (!((im_msg_body.Elem)localObject3).pub_acc_info.has());
              if (((im_msg_body.Elem)localObject3).pub_acc_info.string_long_msg_url.get() != null) {
                localObject1 = ((im_msg_body.Elem)localObject3).pub_acc_info.string_long_msg_url.get();
              }
              localObject6 = ((im_msg_body.Elem)localObject3).pub_acc_info.bytes_download_key.get();
              localObject3 = localObject1;
              if (localObject6 == null) {
                break label2554;
              }
              localObject6 = StructLongMessageDownloadProcessor.a(((ByteStringMicro)localObject6).toByteArray());
              localObject3 = localObject1;
            }
            for (localObject1 = localObject6;; localObject1 = "")
            {
              if ((!StringUtil.b((String)localObject3)) && (!StringUtil.b((String)localObject1)) && (!StringUtil.b((String)localObject5)))
              {
                localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_url", (String)localObject3);
                localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_download_key", (String)localObject1);
                localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", (String)localObject5);
              }
              for (j = 1;; j = 0)
              {
                if (j != 0) {
                  localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)StructMsgFactory.a());
                }
                for (;;)
                {
                  if (localMessageForStructing.structingMsg != null)
                  {
                    if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
                    {
                      localObject1 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mWarningTips;
                      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                        localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject1);
                      }
                      if (((StructMsgForGeneralShare)localMessageForStructing.structingMsg).isPayMessage()) {
                        localMessageForStructing.saveExtInfoToExtStr("pa_pay_message", "1");
                      }
                      localObject1 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mPARedPacket;
                      if (!TextUtils.isEmpty((CharSequence)localObject1))
                      {
                        localObject1 = a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a());
                        if (localObject1 != null)
                        {
                          paramList2.add(localObject1);
                          return;
                          l1 = 0L;
                          break label242;
                          localMessageForStructing.structingMsg = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, m, l2, (byte[])localObject4, -1);
                          if (!QLog.isColorLevel()) {
                            continue;
                          }
                          QLog.d("StructMsg", 2, "StructMsg = " + localMessageForStructing.structingMsg);
                          continue;
                        }
                      }
                      if (localMessageForStructing.structingMsg.mMsgServiceID == 74)
                      {
                        localObject1 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mVipDonateStr;
                        if (!TextUtils.isEmpty((CharSequence)localObject1))
                        {
                          boolean bool = false;
                          if (String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
                            bool = true;
                          }
                          localObject1 = a((String)localObject1, bool);
                          if (localObject1 != null)
                          {
                            paramList2.add(localObject1);
                            return;
                          }
                        }
                      }
                    }
                    int k = 0;
                    j = k;
                    if (paramMsg.msg_head.c2c_tmp_msg_head.service_type.has())
                    {
                      int n = paramMsg.msg_head.c2c_tmp_msg_head.service_type.get();
                      if ((n != 129) && (n != 140))
                      {
                        j = k;
                        if (n != 142) {}
                      }
                      else
                      {
                        j = 1;
                      }
                    }
                    if ((j != 0) || (localMessageForStructing.structingMsg.sourceAccoutType != 0))
                    {
                      localMessageForStructing.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
                      if ((TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgBrief)) || (localMessageForStructing.structingMsg.mEmptyMsgBriefModified)) {
                        localMessageForStructing.structingMsg.mMsgBrief = "你有新消息";
                      }
                    }
                    localObject1 = paramList1.iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject3 = (im_msg_body.Elem)((Iterator)localObject1).next();
                      if ((((im_msg_body.Elem)localObject3).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject3).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject3).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject3).life_online.get()).uint64_unique_id.has())) {
                        localMessageForStructing.structingMsg.msgId = ((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject3).life_online.get()).uint64_unique_id.get();
                      }
                    }
                    if (localMessageForStructing.structingMsg.mMsgServiceID == 37) {
                      break;
                    }
                    if (localMessageForStructing.structingMsg.mMsgServiceID == 499)
                    {
                      paramList1 = (MessageForTroopFee)MessageRecordFactory.a(63500);
                      paramStringBuilder = MessageForTroopFee.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, m, l2, (byte[])localObject4, -1);
                      if (paramStringBuilder != null) {
                        paramList1.copyFrom(paramStringBuilder);
                      }
                      paramList1.msgtype = 63500;
                      paramList1.msg = paramList1.getSummaryMsg();
                      paramList1.msgData = paramList1.getBytes();
                      paramList2.add(paramList1);
                      localMessageForStructing.structingMsg = null;
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(".troop.troop_fee", 2, "Troop Fee has decode suceess" + paramList1.getSummaryMsg());
                      return;
                    }
                    if (localMessageForStructing.structingMsg.mMsgServiceID != 52) {
                      break label1585;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d(NearbyFlowerManager.class.getSimpleName(), 2, "Received flower message");
                    }
                    localObject1 = NearbyFlowerMessage.getFlowerMsgVersion(localMessageForStructing);
                    if (("1".equals(localObject1)) || ("2".equals(localObject1)) || ("3".equals(localObject1)))
                    {
                      localObject1 = (msg_comm.GroupInfo)paramMsg.msg_head.group_info.get();
                      if (localObject1 == null) {
                        break label2542;
                      }
                    }
                  }
                }
                for (l1 = ((msg_comm.GroupInfo)localObject1).group_code.get();; l1 = 0L)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i(NearbyFlowerManager.class.getSimpleName(), 2, "decodePBMsgElems, groupCode:" + l1);
                  }
                  if (l1 <= 0L)
                  {
                    if (!paramMsg.msg_head.from_uin.has()) {
                      break label1573;
                    }
                    l1 = paramMsg.msg_head.from_uin.get();
                    if (!paramMsg.msg_head.to_uin.has()) {
                      break label1579;
                    }
                    l2 = paramMsg.msg_head.to_uin.get();
                    paramList2.add(((NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(123)).a(Long.toString(l1), Long.toString(l2), localMessageForStructing.istroop, localMessageForStructing.structingMsg));
                    break label2096;
                  }
                  for (;;)
                  {
                    localMessageForStructing.structingMsg.mCompatibleText = a(paramList1, paramList2, false);
                    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
                    localMessageForStructing.msg = "richMsg";
                    if (localMessageForStructing.structingMsg != null) {
                      break label2267;
                    }
                    if (QLog.isColorLevel()) {
                      paramStringBuilder.append("c2cMsgContent.data:null;\n");
                    }
                    h(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
                    return;
                    l1 = 0L;
                    break label1431;
                    l2 = 0L;
                    break label1458;
                    if ((localMessageForStructing.structingMsg.mMsgServiceID == 70) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                    {
                      paramList1 = (MessageForTroopTopic)MessageRecordFactory.a(63492);
                      paramList1.msgtype = 63492;
                      paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                      paramList1.structingMsg = paramStringBuilder;
                      paramList1.bid = paramStringBuilder.bid;
                      paramList1.pid = paramStringBuilder.pid;
                      paramList1.pVersion = paramStringBuilder.pVersion;
                      paramList1.prewrite();
                      paramList1.msg = paramList1.getSummaryMsg();
                      paramList2.add(paramList1);
                      localMessageForStructing.structingMsg = null;
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(".troop.troop_topic", 2, "MessageForTroopTopic has decode suceess" + paramList1.getSummaryMsg());
                      return;
                    }
                    if ((localMessageForStructing.structingMsg.mMsgServiceID == 80) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                    {
                      if (QQStoryManager.d())
                      {
                        paramList1 = (MessageForQQStory)MessageRecordFactory.a(63485);
                        paramList1.msgtype = 63485;
                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject2 != null) && (((im_msg_body.Text)localObject2).str.has())) {
                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject2).str.get().toStringUtf8();
                        }
                        paramList1.structingMsg = paramStringBuilder;
                        paramList1.doPrewrite();
                        if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                        {
                          paramList1.doParse();
                          paramStringBuilder.mCompatibleText = MessageForQQStory.buildCompatibleText(paramList1.authorName, paramList1.brief, paramList1.srcName);
                          paramList1.doPrewrite();
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                          }
                        }
                        paramList2.add(paramList1);
                        localMessageForStructing.structingMsg = null;
                        return;
                      }
                      localMessageForStructing.structingMsg = null;
                      if (localObject2 != null)
                      {
                        ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8("你的Android系统低于4.1版本，该条消息无法展示"));
                        return;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.qqstory.share", 2, "recv storyMsg, isSDKAPISupportStory==false, txtMsg==null");
                      }
                    }
                    else if (localMessageForStructing.structingMsg.mMsgServiceID == 500)
                    {
                      if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
                      {
                        PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing, 11);
                        ((AbsShareMsg)localMessageForStructing.structingMsg).clearItems();
                        localMessageForStructing.extInt = 1;
                        localMessageForStructing.extLong = 1;
                        if (QLog.isColorLevel()) {
                          QLog.d("DecodeMsg", 2, "decode structMsg form XIN_KANDIAN, items = " + ((AbsShareMsg)localMessageForStructing.structingMsg).getStructMsgItemLists().size());
                        }
                      }
                    }
                    else if (localMessageForStructing.structingMsg.mMsgServiceID == 43)
                    {
                      localObject1 = paramList1.iterator();
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
                        if ((!((im_msg_body.Elem)localObject2).group_pub_acc_info.has()) || (!((im_msg_body.Elem)localObject2).group_pub_acc_info.uint64_pub_account.has())) {
                          break label1502;
                        }
                        l1 = ((im_msg_body.Elem)localObject2).group_pub_acc_info.uint64_pub_account.get();
                        localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(51);
                        if (paramMsg.msg_head.group_info.has())
                        {
                          l2 = paramMsg.msg_head.group_info.group_code.get();
                          localObject2 = ((TroopManager)localObject1).a(String.valueOf(l2));
                          if (localObject2 != null)
                          {
                            ((TroopInfo)localObject2).associatePubAccount = l1;
                            ((TroopManager)localObject1).b((TroopInfo)localObject2);
                            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(20).a(79, true, new Object[] { Long.valueOf(l2) });
                          }
                        }
                      }
                    }
                  }
                  if (i != 0)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg need to pull longtextmsg!");
                    }
                    try
                    {
                      if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
                      {
                        paramList1 = (ChatMessage)MessageRecordFactory.a(64485);
                        paramList1.saveExtInfoToExtStr("long_text_recv_state", "3");
                        paramList1.saveExtInfoToExtStr("long_text_msg_resid", localMessageForStructing.structingMsg.mResid);
                        paramStringBuilder = ((AbsShareMsg)localMessageForStructing.structingMsg).getStructMsgItemLists();
                        if (paramStringBuilder != null)
                        {
                          paramStringBuilder = paramStringBuilder.iterator();
                          for (;;)
                          {
                            if (paramStringBuilder.hasNext())
                            {
                              paramMsg = (AbsStructMsgElement)paramStringBuilder.next();
                              if ((paramMsg instanceof AbsStructMsgItem))
                              {
                                paramMsg = ((AbsStructMsgItem)paramMsg).a;
                                if (paramMsg != null)
                                {
                                  paramMsg = paramMsg.iterator();
                                  if (paramMsg.hasNext())
                                  {
                                    paramMessageInfo = (AbsStructMsgElement)paramMsg.next();
                                    if (!(paramMessageInfo instanceof StructMsgItemTitle)) {
                                      break;
                                    }
                                    paramList1.msg = ((StructMsgItemTitle)paramMessageInfo).b();
                                    if (QLog.isDevelopLevel())
                                    {
                                      QLog.d("DecodeMsg", 2, "longtextmsg getMsg from structMsg msg:" + paramList1.msg);
                                      continue;
                                      paramList2.add(localMessageForStructing);
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    catch (Exception paramList1)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "failed to pull longtextmsg exception!", paramList1);
                      }
                    }
                  }
                  for (;;)
                  {
                    return;
                    paramList2.add(paramList1);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "absShareMsg is null");
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
  
  public void e(List paramList1, List paramList2, StringBuilder paramStringBuilder) {}
  
  public void e(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!((im_msg_body.Elem)localObject3).lola_msg.has()) {
        break label464;
      }
      localObject1 = (im_msg_body.LolaMsg)((im_msg_body.Elem)localObject3).lola_msg.get();
    }
    label464:
    for (;;)
    {
      break;
      if (localObject1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:BitAppMsg;\n");
      }
      localObject3 = a(paramList1, paramList2, true);
      MessageForBitApp localMessageForBitApp = (MessageForBitApp)MessageRecordFactory.a(60527);
      localMessageForBitApp.msgtype = 60527;
      localMessageForBitApp.bitAppMsg = new BitAppMsg();
      localMessageForBitApp.msg = "bitApp";
      Object localObject4 = ((im_msg_body.LolaMsg)localObject1).bytes_msg_resid.get();
      localObject2 = "";
      if (localObject4 != null) {
        localObject2 = ((ByteStringMicro)localObject4).toStringUtf8();
      }
      if (!StringUtil.b((String)localObject2))
      {
        localObject4 = ((im_msg_body.LolaMsg)localObject1).bytes_long_msg_url.get();
        localObject1 = ((im_msg_body.LolaMsg)localObject1).bytes_download_key.get();
        if ((localObject4 != null) && (localObject1 != null))
        {
          localObject4 = ((ByteStringMicro)localObject4).toStringUtf8();
          localObject1 = StructLongMessageDownloadProcessor.a(((ByteStringMicro)localObject1).toByteArray());
          if ((!StringUtil.b((String)localObject4)) && (!StringUtil.b((String)localObject1)))
          {
            localMessageForBitApp.saveExtInfoToExtStr("pub_long_msg_url", (String)localObject4);
            localMessageForBitApp.saveExtInfoToExtStr("pub_long_msg_download_key", (String)localObject1);
            localMessageForBitApp.saveExtInfoToExtStr("pub_long_msg_resid", (String)localObject2);
          }
        }
      }
      localObject1 = paramList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
        if ((((im_msg_body.Elem)localObject2).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.has())) {
          localMessageForBitApp.bitAppMsg.setMsgId(((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.get());
        }
      }
      if (localMessageForBitApp.bitAppMsg != null)
      {
        if (localObject3 != null) {
          localMessageForBitApp.bitAppMsg.mCompatibleText = ((String)localObject3);
        }
        localMessageForBitApp.msgData = localMessageForBitApp.bitAppMsg.getBytes();
      }
      if (localMessageForBitApp.bitAppMsg == null) {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("c2cMsgContent.data:null;\n");
        }
      }
      for (;;)
      {
        a(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
        return;
        paramList2.add(localMessageForBitApp);
      }
    }
  }
  
  public void f(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    paramList1 = paramList1.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramList1.next();
    } while (!localElem.common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)localElem.common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:QQStoryComment;\n");
      }
      paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype5();
      try
      {
        paramStringBuilder.mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
        paramList1 = (MessageForQQStoryComment)MessageRecordFactory.a(63484);
        paramList1.vid = paramStringBuilder.vid.get().toStringUtf8();
        paramList1.comment = paramStringBuilder.comment_content.get().toStringUtf8();
        paramList1.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
        paramList1.title = paramStringBuilder.title.get().toStringUtf8();
        paramList1.summary = paramStringBuilder.summary.get().toStringUtf8();
        paramList1.createTime = paramStringBuilder.createTime.get();
        paramList1.author = paramStringBuilder.author.get();
        paramList1.prewrite();
        paramList2.add(paramList1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
    }
  }
  
  public void f(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if ((!((im_msg_body.Elem)localObject4).group_pub_acc_info.has()) || (!((im_msg_body.Elem)localObject4).group_pub_acc_info.uint64_pub_account.has())) {
        break label690;
      }
      localObject1 = (im_msg_body.GroupPubAccountInfo)((im_msg_body.Elem)localObject4).group_pub_acc_info.get();
    }
    label141:
    label690:
    for (;;)
    {
      break;
      if (localObject1 == null) {
        return;
      }
      long l1 = ((im_msg_body.GroupPubAccountInfo)localObject1).uint64_pub_account.get();
      localObject1 = null;
      int i = 0;
      MessageForPubAccount localMessageForPubAccount = (MessageForPubAccount)MessageRecordFactory.a(62530);
      localMessageForPubAccount.msgtype = 62530;
      localMessageForPubAccount.associatePubAccUin = l1;
      StringBuilder localStringBuilder = new StringBuilder("");
      Iterator localIterator = paramList1.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (im_msg_body.Elem)localIterator.next();
        if ((((im_msg_body.Elem)localObject2).text.has()) && (((im_msg_body.Elem)localObject2).text.str.has()))
        {
          localMessageForPubAccount.msg = localStringBuilder.toString();
          localObject1 = new PAMessage();
          ((PAMessage)localObject1).msg = localStringBuilder.toString();
          localMessageForPubAccount.msgData = PAMessageUtil.a((PAMessage)localObject1);
        }
      }
      for (;;)
      {
        break label141;
        if (((im_msg_body.Elem)localObject2).trans_elem_info.has())
        {
          localObject2 = (im_msg_body.TransElem)((im_msg_body.Elem)localObject2).trans_elem_info.get();
          int j = ((im_msg_body.TransElem)localObject2).elem_type.get();
          localObject2 = ((im_msg_body.TransElem)localObject2).elem_value.get().toByteArray();
          if (j != 16)
          {
            paramStringBuilder.append("PubAccount Message type is not 16.\n");
            break label141;
          }
          if ((localObject2 == null) || (localObject2.length == 0))
          {
            paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
            break label141;
          }
          if (localObject2[0] == 1)
          {
            i = PkgTools.a((byte[])localObject2, 1);
            j = localObject2[3];
            localObject4 = new byte[i - 1];
            PkgTools.a((byte[])localObject4, 0, (byte[])localObject2, 4, i - 1);
            localObject2 = localObject4;
            if (j == 1) {
              localObject2 = a((byte[])localObject4);
            }
            if (localObject2 != null) {}
            for (;;)
            {
              try
              {
                if (localObject2.length > 0)
                {
                  localObject2 = new String((byte[])localObject2, "utf-8");
                  localStringBuilder.append((String)localObject2);
                  localObject2 = a((String)localObject2);
                  localObject1 = localObject2;
                  i = 1;
                }
              }
              catch (Exception localException)
              {
                paramStringBuilder.append("PubAccount Message parse decodeContext.mPamag exception.\n");
              }
            }
            Object localObject3;
            if (localObject1 != null)
            {
              localObject3 = paramList1.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (im_msg_body.Elem)((Iterator)localObject3).next();
                if ((((im_msg_body.Elem)localObject4).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject4).elem_flags2.get()).uint64_msg_id.has())) {
                  ((PAMessage)localObject1).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject4).elem_flags2.get()).uint64_msg_id.get();
                }
              }
              localMessageForPubAccount.mPAMessage = ((PAMessage)localObject1);
              localMessageForPubAccount.msgData = PAMessageUtil.a((PAMessage)localObject1);
            }
            if (i != 0)
            {
              localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(51);
              if (paramMsg.msg_head.group_info.has())
              {
                long l2 = paramMsg.msg_head.group_info.group_code.get();
                localObject3 = ((TroopManager)localObject1).a(String.valueOf(l2));
                if (localObject3 != null)
                {
                  ((TroopInfo)localObject3).associatePubAccount = l1;
                  ((TroopManager)localObject1).b((TroopInfo)localObject3);
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(20).a(79, true, new Object[] { Long.valueOf(l2) });
                }
              }
            }
            paramList2.add(localMessageForPubAccount);
            if (i != 0) {
              break;
            }
            d(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
            return;
          }
        }
      }
    }
  }
  
  public void g(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
    }
    paramList1 = new MessageForPoke();
    paramList1.msgtype = 60524;
    paramList2.add(paramList1);
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "decodePbElems, common_elem type 2, poke msg");
    }
  }
  
  public void g(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = a(paramList1, paramStringBuilder);
    Object localObject2 = (MessageForReplyText.SourceMsgInfo)((Pair)localObject1).first;
    TroopTopicMgr.GroupPostElemInfo localGroupPostElemInfo = (TroopTopicMgr.GroupPostElemInfo)((Pair)localObject1).second;
    localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = a(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, localArrayList);
    if ((localArrayList != null) && (localArrayList.size() == 2)) {
      if (localArrayList.get(0) != null)
      {
        paramList1 = (MessageForText.AtTroopMemberInfo)localArrayList.get(0);
        if (localArrayList.get(1) != null)
        {
          paramMsg = (byte[])localArrayList.get(1);
          paramStringBuilder = paramList1;
          paramList1 = paramMsg;
        }
      }
    }
    for (;;)
    {
      if ((((StringBuilder)localObject3).length() > 0) && (localObject2 != null))
      {
        paramMsg = (ChatMessage)MessageRecordFactory.a(64487);
        paramMsg.msg = ((StringBuilder)localObject3).toString();
        localObject1 = (MessageForReplyText)paramMsg;
      }
      try
      {
        localObject3 = HexUtil.a(MessagePkgUtils.a((Serializable)localObject2));
        ((MessageForReplyText)localObject1).mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)localObject2);
        ((MessageForReplyText)localObject1).saveExtInfoToExtStr("sens_msg_source_msg_info", (String)localObject3);
        if (localGroupPostElemInfo != null)
        {
          localObject2 = HexUtil.a(MessagePkgUtils.a(localGroupPostElemInfo));
          ((MessageForReplyText)localObject1).mGroupPostElemInfo = localGroupPostElemInfo;
          ((MessageForReplyText)localObject1).saveExtInfoToExtStr("sens_msg_source_msg_troop_topic_info", (String)localObject2);
        }
        ((MessageForReplyText)localObject1).extLong |= 0x1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + localException.getMessage());
          }
        }
      }
      if ((TextUtils.isEmpty(((MessageForReplyText)localObject1).mSourceMsgInfo.mAnonymousNickName)) && (paramStringBuilder != null) && (!TextUtils.isEmpty(((MessageForReplyText)localObject1).msg)) && (((MessageForReplyText)localObject1).msg.length() > paramStringBuilder.textLen + 1))
      {
        ((MessageForReplyText)localObject1).msg = ((MessageForReplyText)localObject1).msg.substring(paramStringBuilder.textLen + 1);
        if (paramStringBuilder.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getLongAccountUin())) {
          paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a = -1L;
        }
      }
      if (paramList1 != null) {
        paramMsg.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a(paramList1));
      }
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "reply msgRand = " + MessageUtils.a(paramMsg.msgUid) + ", msgUid = " + paramMsg.msgUid);
      }
      paramList2.add(paramMsg);
      return;
      paramMsg = null;
      paramStringBuilder = paramList1;
      paramList1 = paramMsg;
      continue;
      paramList1 = null;
      break;
      paramList1 = null;
      paramStringBuilder = (StringBuilder)localObject1;
    }
  }
  
  public void h(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = null;
    int j = 0;
    int i = 0;
    Object localObject2 = paramList1.iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!((im_msg_body.Elem)localObject3).general_flags.has()) {
        break label759;
      }
      localObject1 = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject3).general_flags.get();
      label63:
      if ((!((im_msg_body.Elem)localObject3).bless_msg.has()) || (((im_msg_body.Elem)localObject3).bless_msg.uint32_msg_type.get() != 1)) {
        break label765;
      }
      j = 1;
    }
    label665:
    label751:
    label759:
    label765:
    for (;;)
    {
      if ((((im_msg_body.Elem)localObject3).elem_flags2.has()) && (((im_msg_body.Elem)localObject3).elem_flags2.uint32_msg_rpt_cnt.has())) {
        i = ((im_msg_body.Elem)localObject3).elem_flags2.uint32_msg_rpt_cnt.get();
      }
      for (;;)
      {
        break;
        localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList(2);
        localObject3 = a(null, paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, (ArrayList)localObject2, localArrayList);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 2) && (((ArrayList)localObject2).get(1) != null)) {}
        for (paramStringBuilder = (byte[])((ArrayList)localObject2).get(1);; paramStringBuilder = null)
        {
          if (((StringBuilder)localObject3).length() == 0) {
            return;
          }
          long l2 = 0L;
          boolean bool2 = false;
          localObject2 = null;
          boolean bool1 = bool2;
          paramList1 = (List)localObject2;
          long l1 = l2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            paramList1 = (List)localObject2;
            l1 = l2;
            if (((im_msg_body.GeneralFlags)localObject1).uint64_uin.has())
            {
              l1 = ((im_msg_body.GeneralFlags)localObject1).uint64_uin.get();
              if (((im_msg_body.GeneralFlags)localObject1).uint32_prp_fold.get() != 1) {
                break label665;
              }
              bool1 = true;
              paramList1 = ((im_msg_body.GeneralFlags)localObject1).bytes_rp_id.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, redBagSender: %s, foldFlag: %s, redBagId: %s, foldSwitch: %s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool1), paramList1, Boolean.valueOf(PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) }));
              }
              if (!String.valueOf(paramMsg.msg_head.from_uin.get()).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
                break label751;
              }
              bool1 = false;
            }
          }
          for (;;)
          {
            int m = 0;
            int k = m;
            if (localObject1 != null) {
              if (((im_msg_body.GeneralFlags)localObject1).long_text_flag.get() != 2)
              {
                k = m;
                if (((im_msg_body.GeneralFlags)localObject1).long_text_flag.get() != 1) {}
              }
              else
              {
                m = 1;
                k = m;
                if (QLog.isColorLevel())
                {
                  QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, longTextFlag: true");
                  k = m;
                }
              }
            }
            if ((paramList1 != null) && (PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b)))
            {
              paramMessageInfo = new MessageForFoldMsg();
              ((MessageForFoldMsg)paramMessageInfo).init(bool1, paramList1, l1, true);
              paramList1 = paramMessageInfo;
            }
            for (;;)
            {
              paramList1.msg = ((StringBuilder)localObject3).toString();
              m = 0;
              k = m;
              if (paramMsg.msg_head.from_uin.has())
              {
                l1 = paramMsg.msg_head.from_uin.get();
                k = m;
                if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(), Long.toString(l1))) {
                  k = 1;
                }
              }
              if ((paramStringBuilder != null) && (k == 0)) {
                paramList1.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a(paramStringBuilder));
              }
              if (j != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true");
                }
                paramList1.isBlessMsg = true;
              }
              if (i > 0)
              {
                paramList1.setRepeatCount(i);
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, "MessageForText ====> repeatCount = " + paramList1.getRepeatCount());
                }
              }
              paramList2.add(paramList1);
              return;
              bool1 = false;
              break;
              if (k != 0)
              {
                paramList1 = (ChatMessage)MessageRecordFactory.a(64485);
                paramList1.saveExtInfoToExtStr("long_text_recv_state", "1");
                paramList1.removeExtInfoToExtStr("long_text_msg_resid");
              }
              else
              {
                localObject1 = (ChatMessage)MessageRecordFactory.a(64536);
                paramList1 = (List)localObject1;
                if (paramMessageInfo != null)
                {
                  paramList1 = (List)localObject1;
                  if (localArrayList != null)
                  {
                    AtTroopMemberSpan.a(paramMessageInfo.jdField_a_of_type_Int, localArrayList, (ChatMessage)localObject1);
                    paramList1 = (List)localObject1;
                  }
                }
              }
            }
          }
        }
        break label63;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\message\MessagePBElemDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */