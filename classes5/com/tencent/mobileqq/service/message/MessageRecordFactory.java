package com.tencent.mobileqq.service.message;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForDateFeed;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageForVideoVip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class MessageRecordFactory
{
  private static final String a = "MessageRecordFactory";
  
  public MessageRecordFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static MessageForBitApp a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, BitAppMsg paramBitAppMsg)
  {
    paramString1 = (MessageForBitApp)a(60527);
    paramString1.msgtype = 60527;
    paramString1.bitAppMsg = paramBitAppMsg;
    paramString1.mIsParsed = true;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramBitAppMsg.getBytes();
      return paramString1;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
    }
    return paramString1;
  }
  
  public static MessageForDevLittleVideo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDevLittleVideo localMessageForDevLittleVideo = new MessageForDevLittleVideo();
    localMessageForDevLittleVideo.msgtype = 61027;
    a(paramQQAppInterface, localMessageForDevLittleVideo, paramString1, paramString2, paramInt);
    localMessageForDevLittleVideo.longMsgCount = 1;
    localMessageForDevLittleVideo.longMsgIndex = 0;
    localMessageForDevLittleVideo.longMsgId = ((short)(int)localMessageForDevLittleVideo.shmsgseq);
    return localMessageForDevLittleVideo;
  }
  
  public static MessageForApollo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ApolloMessage paramApolloMessage)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)a(63497);
    localMessageForApollo.msgtype = 63497;
    localMessageForApollo.mApolloMessage = paramApolloMessage;
    localMessageForApollo.mIsParsed = true;
    a(paramQQAppInterface, localMessageForApollo, paramString1, paramString2, paramInt);
    try
    {
      localMessageForApollo.msg = ApolloUtil.a(localMessageForApollo);
      localMessageForApollo.msgData = MessagePkgUtils.a(paramApolloMessage);
      return localMessageForApollo;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localMessageForApollo;
  }
  
  public static MessageForArkApp a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return null;
    }
    MessageForArkApp localMessageForArkApp = new MessageForArkApp();
    localMessageForArkApp.msgtype = 60528;
    localMessageForArkApp.ark_app_message = paramArkAppMessage;
    localMessageForArkApp.msg = paramArkAppMessage.getSummery();
    a(paramQQAppInterface, localMessageForArkApp, paramString1, paramString2, paramInt);
    localMessageForArkApp.longMsgCount = 1;
    localMessageForArkApp.longMsgIndex = 0;
    localMessageForArkApp.longMsgId = ((short)(int)localMessageForArkApp.shmsgseq);
    return localMessageForArkApp;
  }
  
  public static MessageForMarketFace a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, MarkFaceMessage paramMarkFaceMessage)
  {
    MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)a(63529);
    localMessageForMarketFace.msgtype = 63529;
    localMessageForMarketFace.mMarkFaceMessage = paramMarkFaceMessage;
    localMessageForMarketFace.mIsParsed = true;
    a(paramQQAppInterface, localMessageForMarketFace, paramString1, paramString2, paramInt);
    try
    {
      localMessageForMarketFace.msgData = MessagePkgUtils.a(paramMarkFaceMessage);
      return localMessageForMarketFace;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localMessageForMarketFace;
  }
  
  public static MessageForMixedMsg a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForMixedMsg localMessageForMixedMsg = new MessageForMixedMsg();
    localMessageForMixedMsg.msgtype = 64501;
    a(paramQQAppInterface, localMessageForMixedMsg, paramString1, paramString2, paramInt);
    localMessageForMixedMsg.longMsgCount = 1;
    localMessageForMixedMsg.longMsgIndex = 0;
    localMessageForMixedMsg.longMsgId = ((short)(int)localMessageForMixedMsg.shmsgseq);
    return localMessageForMixedMsg;
  }
  
  public static MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.msgtype = 63536;
    a(paramQQAppInterface, localMessageForPic, paramString1, paramString2, paramInt);
    localMessageForPic.longMsgCount = 1;
    localMessageForPic.longMsgIndex = 0;
    localMessageForPic.longMsgId = ((short)(int)localMessageForPic.shmsgseq);
    return localMessageForPic;
  }
  
  public static MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, long paramLong1, String paramString3, long paramLong2, String paramString4)
  {
    paramString4 = new MessageForPic();
    paramString4.msgtype = 62536;
    paramString4.msg = paramString3;
    a(paramQQAppInterface, paramString4, paramString1, paramString2, paramInt);
    paramString4.longMsgCount = 1;
    paramString4.longMsgIndex = 0;
    paramString4.longMsgId = ((short)(int)paramString4.shmsgseq);
    return paramString4;
  }
  
  @Deprecated
  private static MessageForPic a(MessageForPic paramMessageForPic)
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.msgtype = 63536;
    a(localMessageForPic, paramMessageForPic);
    localMessageForPic.path = paramMessageForPic.path;
    localMessageForPic.size = 0L;
    localMessageForPic.type = 1;
    localMessageForPic.serial();
    return localMessageForPic;
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {
      return null;
    }
    int i = (int)MessageCache.a();
    int j = MobileQQService.c;
    MobileQQService.c = j + 1;
    long l = j;
    MessageForPtt localMessageForPtt = new MessageForPtt();
    localMessageForPtt.init(Long.valueOf(paramMessageForPtt.selfuin).longValue(), 0L, 0L, null, i, 63534, paramMessageForPtt.istroop, l);
    localMessageForPtt.frienduin = paramMessageForPtt.frienduin;
    localMessageForPtt.senderuin = paramMessageForPtt.senderuin;
    localMessageForPtt.msgtype = 63534;
    localMessageForPtt.isread = true;
    localMessageForPtt.issend = 1;
    localMessageForPtt.istroop = paramMessageForPtt.istroop;
    localMessageForPtt.msgseq = paramMessageForPtt.msgseq;
    localMessageForPtt.shmsgseq = paramMessageForPtt.shmsgseq;
    localMessageForPtt.msgUid = paramMessageForPtt.msgUid;
    byte[] arrayOfByte = new byte[3];
    PkgTools.a(paramMessageForPtt.url.length(), arrayOfByte, 0, 3, "utf-8");
    localMessageForPtt.url = paramMessageForPtt.url;
    localMessageForPtt.fileSize = -3L;
    localMessageForPtt.itemType = 2;
    if ((SttManager.a(paramMessageForPtt.istroop)) && (SttManager.a(paramQQAppInterface))) {}
    for (i = 1;; i = 0)
    {
      localMessageForPtt.sttAbility = i;
      localMessageForPtt.longPttVipFlag = MessageUtils.a(paramQQAppInterface, paramQQAppInterface.a());
      localMessageForPtt.voiceType = paramMessageForPtt.voiceType;
      localMessageForPtt.voiceLength = paramMessageForPtt.voiceLength;
      localMessageForPtt.serial();
      return localMessageForPtt;
    }
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForPtt localMessageForPtt = new MessageForPtt();
    localMessageForPtt.msgtype = 63534;
    a(paramQQAppInterface, localMessageForPtt, paramString1, paramString2, paramInt);
    localMessageForPtt.longMsgCount = 1;
    localMessageForPtt.longMsgIndex = 0;
    localMessageForPtt.longMsgId = ((short)(int)localMessageForPtt.shmsgseq);
    return localMessageForPtt;
  }
  
  public static MessageForQQStory a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    paramString1 = (MessageForQQStory)a(63485);
    paramString1.msgtype = 63485;
    paramString1.structingMsg = paramAbsStructMsg;
    paramString1.mIsParsed = false;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramAbsStructMsg.getBytes();
      if (paramAbsStructMsg.sourceAccoutType != 0) {
        paramString1.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
      }
      return paramString1;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
        }
      }
    }
  }
  
  public static MessageForShakeWindow a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    int i = MessageUtils.a();
    int j = (int)MessageCache.a();
    paramString1 = new MessageForShakeWindow(Long.valueOf(paramString1).longValue(), Long.valueOf(paramString2).longValue(), Long.valueOf(paramString3).longValue(), j, paramInt, paramLong);
    paramString2 = new ShakeWindowMsg();
    paramString2.shake = true;
    paramString2.onlineFlag = 1;
    paramString2.mType = 0;
    paramString2.mReserve = 0;
    paramString1.msgData = paramString2.getBytes();
    paramString1.mShakeWindowMsg = paramString2;
    paramString1.mIsParsed = true;
    paramString1.issend = 1;
    paramString1.isread = true;
    paramString1.msgUid = MessageUtils.a(i);
    paramString1.shmsgseq = MessageUtils.a(paramLong, paramInt);
    paramString1.longMsgCount = 1;
    paramString1.longMsgIndex = 0;
    paramString1.longMsgId = ((short)(int)paramLong);
    return paramString1;
  }
  
  public static MessageForShortVideo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForShortVideo localMessageForShortVideo = new MessageForShortVideo();
    localMessageForShortVideo.msgtype = 63514;
    a(paramQQAppInterface, localMessageForShortVideo, paramString1, paramString2, paramInt);
    localMessageForShortVideo.longMsgCount = 1;
    localMessageForShortVideo.longMsgIndex = 0;
    localMessageForShortVideo.longMsgId = ((short)(int)localMessageForShortVideo.shmsgseq);
    return localMessageForShortVideo;
  }
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    paramString1 = (MessageForStructing)a(63525);
    paramString1.msgtype = 63525;
    paramString1.structingMsg = paramAbsStructMsg;
    paramString1.mIsParsed = true;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramAbsStructMsg.getBytes();
      if (paramAbsStructMsg.sourceAccoutType != 0) {
        paramString1.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
      }
      return paramString1;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
        }
      }
    }
  }
  
  public static MessageForText a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, byte paramByte1, byte paramByte2, short paramShort, String paramString4)
  {
    paramString1 = (MessageForText)a(64536);
    paramString1.msgtype = 64536;
    paramString1.longMsgCount = paramByte1;
    paramString1.longMsgIndex = paramByte2;
    paramString1.longMsgId = paramShort;
    paramString1.msg = paramString4;
    try
    {
      paramString1.msgData = paramString4.getBytes("utf-8");
      a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
      paramString1.parse();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString4)
    {
      for (;;)
      {
        paramString4.printStackTrace();
      }
    }
  }
  
  public static MessageRecord a(int paramInt)
  {
    MessageRecord localMessageRecord = b(paramInt);
    Object localObject = localMessageRecord;
    if (localMessageRecord == null)
    {
      localObject = new MessageForText();
      ((MessageRecord)localObject).msgtype = paramInt;
    }
    return (MessageRecord)localObject;
  }
  
  public static MessageRecord a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3)
  {
    MessageRecord localMessageRecord = b(paramInt1);
    if (localMessageRecord != null)
    {
      localMessageRecord.msgtype = paramInt1;
      localObject = localMessageRecord;
      if (((paramInt1 != 64536) && (paramInt1 != 63530)) || (paramInt3 != 1) || ((paramInt2 & 0x1) != 1)) {
        break label278;
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label278;
        }
        paramArrayOfByte = new JSONObject(paramString);
        if ((!paramArrayOfByte.has("redbag_fold_msg")) || (!paramArrayOfByte.getString("redbag_fold_msg").equals("true"))) {
          break label278;
        }
        paramArrayOfByte = new MessageForFoldMsg();
        paramString = paramArrayOfByte;
        if (paramArrayOfByte == null)
        {
          paramString = new MessageForText();
          paramString.msgtype = paramInt1;
        }
        return paramString;
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          break label278;
        }
        QLog.e("msgFold", 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
      }
      localObject = localMessageRecord;
      if (paramArrayOfByte == null) {
        break;
      }
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length() <= 0) || (paramArrayOfByte.charAt(0) != '\026')) {
          break label303;
        }
        paramArrayOfByte = paramArrayOfByte.split("\\|");
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 2)) {
          break label303;
        }
        i = Integer.parseInt(paramArrayOfByte[2]);
        if (i == 3) {
          paramArrayOfByte = new MessageForGrayTips();
        }
      }
      catch (Exception paramArrayOfByte)
      {
        int i;
        localObject = localException1;
        continue;
        paramArrayOfByte = localException2;
        continue;
      }
      try
      {
        paramArrayOfByte.msgtype = 64535;
        localObject = paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        localObject = paramArrayOfByte;
        paramArrayOfByte = localException2;
        continue;
      }
      if ((i != 2) && (i != 8)) {
        break label303;
      }
      paramArrayOfByte = new MessageForPtt();
      try
      {
        paramArrayOfByte.msgtype = 63534;
      }
      catch (Exception localException1)
      {
        localObject = paramArrayOfByte;
        paramArrayOfByte = localException1;
      }
      paramArrayOfByte.printStackTrace();
      break;
      label278:
      paramArrayOfByte = (byte[])localObject;
    }
  }
  
  public static MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      paramMessageRecord = null;
    }
    MessageRecord localMessageRecord;
    do
    {
      return paramMessageRecord;
      localMessageRecord = a(paramMessageRecord.msgtype);
      localMessageRecord.msgtype = paramMessageRecord.msgtype;
      a(localMessageRecord, paramMessageRecord);
      if (paramMessageRecord.msgData != null) {
        localMessageRecord.msgData = paramMessageRecord.msgData;
      }
      if (paramMessageRecord.msg != null) {
        localMessageRecord.msg = paramMessageRecord.msg;
      }
      paramMessageRecord = localMessageRecord;
    } while (!(localMessageRecord instanceof ChatMessage));
    ((ChatMessage)localMessageRecord).parse();
    return localMessageRecord;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    int i = MessageUtils.a();
    int j = (int)MessageCache.a();
    int k = MobileQQService.c;
    MobileQQService.c = k + 1;
    long l = k;
    String str = paramQQAppInterface.a();
    if ((paramInt == 1000) || (paramInt == 1020) || (paramInt == 1004)) {
      if (paramString2 != null)
      {
        paramQQAppInterface = paramString2;
        if (paramString2.length() != 0) {}
      }
      else
      {
        paramQQAppInterface = paramString2;
        if (QLog.isColorLevel())
        {
          QLog.e("MessageRecordFactory", 2, "createPicMessageToShow : error groupUin:" + paramString2);
          paramQQAppInterface = paramString2;
        }
      }
    }
    for (;;)
    {
      paramMessageRecord.frienduin = paramString1;
      paramMessageRecord.istroop = paramInt;
      paramMessageRecord.selfuin = str;
      paramMessageRecord.senderuin = paramQQAppInterface;
      paramMessageRecord.isread = true;
      paramMessageRecord.time = j;
      paramMessageRecord.msgseq = l;
      paramMessageRecord.msgUid = MessageUtils.a(i);
      paramMessageRecord.shmsgseq = MessageUtils.a(l, paramInt);
      paramMessageRecord.issend = 1;
      return;
      if (paramInt == 1006)
      {
        paramQQAppInterface = ((PhoneContactManager)paramQQAppInterface.getManager(10)).a();
        if (paramQQAppInterface != null)
        {
          paramString2 = paramQQAppInterface.nationCode + paramQQAppInterface.mobileNo;
          if (paramString2 != null)
          {
            paramQQAppInterface = paramString2;
            if (paramString2.length() > 0) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("MessageRecordFactory", 2, "createPicMessageToShow : error selfPhoneNum:" + paramString2);
          }
        }
      }
      paramQQAppInterface = str;
    }
  }
  
  private static void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    paramMessageRecord1.selfuin = paramMessageRecord2.selfuin;
    paramMessageRecord1.frienduin = paramMessageRecord2.frienduin;
    paramMessageRecord1.senderuin = paramMessageRecord2.senderuin;
    paramMessageRecord1.istroop = paramMessageRecord2.istroop;
    paramMessageRecord1.longMsgCount = paramMessageRecord2.longMsgCount;
    paramMessageRecord1.longMsgId = paramMessageRecord2.longMsgId;
    paramMessageRecord1.longMsgIndex = paramMessageRecord2.longMsgIndex;
    paramMessageRecord1.isread = true;
    paramMessageRecord1.issend = 1;
    paramMessageRecord1.msgseq = paramMessageRecord2.msgseq;
    paramMessageRecord1.shmsgseq = paramMessageRecord2.shmsgseq;
    paramMessageRecord1.msgUid = paramMessageRecord2.msgUid;
    paramMessageRecord1.extStr = paramMessageRecord2.extStr;
    paramMessageRecord1.extLong = paramMessageRecord2.extLong;
    if (AnonymousChatHelper.a(paramMessageRecord2)) {
      paramMessageRecord1.vipBubbleID = paramMessageRecord2.vipBubbleID;
    }
    paramMessageRecord1.time = ((int)MessageCache.a());
  }
  
  @Deprecated
  private static MessageForPtt b(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int j = 0;
    if (paramMessageForPtt == null) {
      return null;
    }
    MessageForPtt localMessageForPtt = new MessageForPtt();
    localMessageForPtt.msgtype = 63534;
    a(localMessageForPtt, paramMessageForPtt);
    byte[] arrayOfByte = new byte[3];
    PkgTools.a(paramMessageForPtt.url.length(), arrayOfByte, 0, 3, "utf-8");
    localMessageForPtt.url = paramMessageForPtt.url;
    localMessageForPtt.fileSize = -3L;
    localMessageForPtt.itemType = 2;
    int i = j;
    if (SttManager.a(paramMessageForPtt.istroop))
    {
      i = j;
      if (SttManager.a(paramQQAppInterface)) {
        i = 1;
      }
    }
    localMessageForPtt.sttAbility = i;
    localMessageForPtt.longPttVipFlag = MessageUtils.a(paramQQAppInterface, paramQQAppInterface.a());
    localMessageForPtt.voiceType = paramMessageForPtt.voiceType;
    localMessageForPtt.voiceLength = paramMessageForPtt.voiceLength;
    localMessageForPtt.serial();
    return localMessageForPtt;
  }
  
  public static MessageForPtt b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDevPtt localMessageForDevPtt = new MessageForDevPtt();
    localMessageForDevPtt.msgtype = 61035;
    a(paramQQAppInterface, localMessageForDevPtt, paramString1, paramString2, paramInt);
    localMessageForDevPtt.longMsgCount = 1;
    localMessageForDevPtt.longMsgIndex = 0;
    localMessageForDevPtt.longMsgId = ((short)(int)localMessageForDevPtt.shmsgseq);
    return localMessageForDevPtt;
  }
  
  public static MessageForShortVideo b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForBlessPTV localMessageForBlessPTV = new MessageForBlessPTV();
    localMessageForBlessPTV.msgtype = 63514;
    a(paramQQAppInterface, localMessageForBlessPTV, paramString1, paramString2, paramInt);
    localMessageForBlessPTV.longMsgCount = 1;
    localMessageForBlessPTV.longMsgIndex = 0;
    localMessageForBlessPTV.longMsgId = ((short)(int)localMessageForBlessPTV.shmsgseq);
    return localMessageForBlessPTV;
  }
  
  private static MessageRecord b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    case -2010: 
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (MessageUtils.a(paramInt))
        {
          if (paramInt != 64534) {
            break label1312;
          }
          localObject2 = new MessageForSafeGrayTips();
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject2 != null) {
        ((MessageRecord)localObject2).msgtype = paramInt;
      }
      return (MessageRecord)localObject2;
      localObject1 = new MessageForText();
      break;
      localObject1 = new MessageForPic();
      break;
      localObject1 = new MessageForStructing();
      break;
      localObject1 = new MessageForTroopTopic();
      break;
      localObject1 = new MessageForTroopNotification();
      break;
      localObject1 = new MessageForMarketFace();
      break;
      localObject1 = new MessageForPubAccount();
      break;
      localObject1 = new MessageForPtt();
      break;
      localObject1 = new MessageForFile();
      break;
      localObject1 = new MessageForRichState();
      break;
      localObject1 = new MessageForDateFeed();
      break;
      localObject1 = new MessageForVideo();
      break;
      localObject1 = new MessageForActivity();
      break;
      localObject1 = new MessageForEnterTroop();
      break;
      localObject1 = new MessageForMixedMsg();
      break;
      localObject1 = new MessageForQzoneFeed();
      break;
      localObject1 = new MessageForSystemMsg();
      break;
      localObject1 = new MessageForMyEnterTroop();
      break;
      localObject1 = new MessageForTroopFile();
      break;
      localObject1 = new MessageForShakeWindow();
      ((MessageRecord)localObject1).msgtype = 63516;
      break;
      localObject1 = new MessageForTroopUnreadTips();
      break;
      localObject1 = new MessageForText();
      break;
      localObject1 = new MessageForShortVideo();
      break;
      localObject1 = new MessageForColorRing();
      break;
      localObject1 = new MessageForQQWalletMsg();
      break;
      localObject1 = new MessageForActivateFriends();
      break;
      localObject1 = new MessageForDeviceFile();
      break;
      localObject1 = new MessageForDevPtt();
      break;
      localObject1 = new MessageForDevShortVideo();
      break;
      localObject1 = new MessageForDevLittleVideo();
      break;
      localObject1 = new MessageForDeviceSingleStruct();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForQQWalletTips();
      break;
      localObject1 = new MessageForDeviceText();
      break;
      localObject1 = new ShareHotChatGrayTips();
      break;
      localObject1 = new MessageForDeliverGiftTips();
      break;
      localObject1 = new MessageForTroopGift();
      break;
      localObject1 = new MessageForTroopFee();
      break;
      localObject1 = new MessageForApollo();
      break;
      localObject1 = new MessageForArkApp();
      break;
      localObject1 = new MessageForReplyText();
      break;
      localObject1 = new MessageForApproval();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForTroopReward();
      break;
      localObject1 = new MessageForDingdongSchedule();
      break;
      localObject1 = new MessageForBitApp();
      break;
      localObject1 = new MessageForVideoVip();
      break;
      localObject1 = new MessageForVIPDonate();
      break;
      localObject1 = new MessageForFoldMsgGrayTips();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForPoke();
      break;
      localObject1 = new MessageForLongTextMsg();
      break;
      localObject1 = new MessageForUniteGrayTip();
      break;
      localObject1 = new MessageForQQStory();
      break;
      localObject1 = new MessageForQQStoryComment();
      break;
      label1312:
      if ((paramInt == 60536) || (paramInt == 60535) || (paramInt == 63499)) {
        localObject2 = new MessageForNewGrayTips();
      } else if (paramInt == 60534) {
        localObject2 = new MessageForIncompatibleGrayTips();
      } else if (paramInt == 63509) {
        localObject2 = new MessageForNearbyMarketGrayTips();
      } else if (paramInt == 61525) {
        localObject2 = new MessageForNearbyRecommenderTips();
      } else {
        localObject2 = new MessageForGrayTips();
      }
    }
  }
  
  public static MessageForShortVideo c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDevShortVideo localMessageForDevShortVideo = new MessageForDevShortVideo();
    localMessageForDevShortVideo.msgtype = 61033;
    a(paramQQAppInterface, localMessageForDevShortVideo, paramString1, paramString2, paramInt);
    localMessageForDevShortVideo.longMsgCount = 1;
    localMessageForDevShortVideo.longMsgIndex = 0;
    localMessageForDevShortVideo.longMsgId = ((short)(int)localMessageForDevShortVideo.shmsgseq);
    return localMessageForDevShortVideo;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\message\MessageRecordFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */