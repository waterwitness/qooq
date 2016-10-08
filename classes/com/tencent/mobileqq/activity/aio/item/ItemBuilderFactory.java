package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.bitapp.BitAppMsgItemBuilder;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
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
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ItemBuilderFactory
{
  private static final int A = 20;
  private static final int B = 21;
  private static final int C = 22;
  private static final int D = 23;
  private static final int E = 24;
  private static final int F = 25;
  private static final int G = 26;
  private static final int H = 27;
  private static final int I = 28;
  private static final int J = 29;
  private static final int K = 30;
  private static final int L = 31;
  private static final int M = 32;
  private static final int N = 33;
  private static final int O = 34;
  private static final int P = 35;
  private static final int Q = 36;
  private static final int R = 37;
  private static final int S = 38;
  private static final int T = 39;
  private static final int U = 40;
  private static final int V = 41;
  private static final int W = 42;
  private static final int X = 43;
  private static final int Y = 44;
  private static final int Z = 45;
  public static final int a = 61;
  private static final int aa = 46;
  private static final int ab = 47;
  private static final int ac = 48;
  private static final int ad = 49;
  private static final int ae = 50;
  private static final int af = 51;
  private static final int ag = 100;
  private static final int ah = 52;
  private static final int ai = 53;
  private static final int aj = 54;
  private static final int ak = 55;
  private static final int al = 56;
  private static final int am = 57;
  private static final int an = 58;
  private static final int ao = 59;
  private static final int ap = 60;
  private static final int aq = 64;
  private static final int ar = 66;
  public static final int b = 62;
  public static final int c = 63;
  public static final int d = 65;
  public static final int e = 66;
  public static final int f = 67;
  public static final int g = 43;
  private static final int h = 0;
  private static final int i = 1;
  private static final int j = 2;
  private static final int k = 3;
  private static final int l = 4;
  private static final int m = 5;
  private static final int n = 6;
  private static final int o = 7;
  private static final int p = 8;
  private static final int q = 9;
  private static final int r = 10;
  private static final int s = 11;
  private static final int t = 12;
  private static final int u = 13;
  private static final int v = 15;
  private static final int w = 16;
  private static final int x = 17;
  private static final int y = 18;
  private static final int z = 19;
  private Context jdField_a_of_type_AndroidContentContext;
  BitAppMsgItemBuilder jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder;
  DevLittleVideoItemBuilder jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder;
  DevShortVideoItemBuilder jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder;
  DevicePttItemBuilder jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  ActivityChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder;
  ApolloItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder;
  AppSharePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder;
  ApprovalMsgBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemApprovalMsgBuilder;
  ArkAppItemBubbleBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder;
  ArkAppItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder;
  DeviceFileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder;
  DevicePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder;
  DeviceSingleStructBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder;
  DeviceTextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder;
  DingdongScheduleItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDingdongScheduleItemBuilder;
  EnterTroopChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder;
  FileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder;
  FilePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder;
  FlashPicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder;
  FoldMsgGrayTipsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFoldMsgGrayTipsItemBuilder;
  GrayTipsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder;
  LocationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder;
  LongMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder;
  LongTextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLongTextItemBuilder;
  MarketFaceItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder;
  MixedMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder;
  MyEnterTroopChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder;
  PAMultiItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder;
  PASingleItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder;
  PATextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder;
  PAWeatherItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPAWeatherItemBuilder;
  PicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder;
  PokeItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder;
  PttItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder;
  QQStoryCommentItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder;
  QQStoryItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder;
  QQWalletMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder;
  QzoneFeedItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder;
  ReplyTextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder;
  RichStatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder;
  ShakeItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder;
  ShortVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder;
  ShortVideoPTVItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder;
  ShortVideoRealItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder;
  StructTroopNotificationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder;
  StructingMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder;
  TextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder;
  TextTranslationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder;
  ThumbItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder;
  TroopFeeMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFeeMsgItemBuilder;
  TroopFileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder;
  TroopGiftMsgItemBuilder.TroopGiftMsgItemRecieverBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder;
  TroopGiftMsgItemBuilder.TroopGiftMsgItemSenderBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder;
  TroopRewardItemBuilder.TroopRewardItemReceiveBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder$TroopRewardItemReceiveBuilder;
  TroopRewardItemBuilder.TroopRewardItemSendBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder$TroopRewardItemSendBuilder;
  TroopUnreadTipsChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder;
  VIPDonateMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemVIPDonateMsgItemBuilder;
  VideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder;
  VideoVipItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  UniteGrayTipItemBuilder jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder;
  
  public ItemBuilderFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    int i2 = 15;
    int i1;
    if ((paramChatMessage instanceof MessageForText)) {
      if ((paramChatMessage instanceof MessageForLongTextMsg)) {
        i1 = 62;
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
                    return i1;
                    if (((MessageForText)paramChatMessage).locationUrl != null) {
                      return 10;
                    }
                    if ((paramChatMessage.vipBubbleID != 100000L) || (paramChatMessage.isSend())) {
                      break;
                    }
                    return 9;
                    if ((paramChatMessage instanceof MessageForTroopGift))
                    {
                      if (paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
                        return 48;
                      }
                      return 49;
                    }
                    i1 = i2;
                  } while ((paramChatMessage instanceof MessageForGrayTips));
                  i1 = i2;
                } while ((paramChatMessage instanceof MessageForNewGrayTips));
                i1 = i2;
              } while ((paramChatMessage instanceof MessageForSafeGrayTips));
              i1 = i2;
            } while ((paramChatMessage instanceof MessageForIncompatibleGrayTips));
            i1 = i2;
          } while ((paramChatMessage instanceof MessageForNearbyMarketGrayTips));
          if ((paramChatMessage instanceof MessageForPic))
          {
            if (((MessageForPic)paramChatMessage).isMixed) {
              return 24;
            }
            if (HotChatHelper.a(paramChatMessage)) {
              return 42;
            }
            if (FlashPicHelper.a(paramChatMessage)) {
              return 64;
            }
            return 1;
          }
          if ((paramChatMessage instanceof MessageForDevPtt)) {
            return 33;
          }
          if ((paramChatMessage instanceof MessageForPtt)) {
            return 2;
          }
          if ((paramChatMessage instanceof MessageForFile))
          {
            if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage) == 0) {
              return 60;
            }
            paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
            if ((paramChatMessage != null) && (paramChatMessage.cloudType != 0) && (FileManagerUtil.a(paramChatMessage.fileName) == 0)) {
              return 60;
            }
            return 3;
          }
          if ((paramChatMessage instanceof MessageForVideo)) {
            return 11;
          }
          if ((paramChatMessage instanceof MessageForMarketFace)) {
            return 12;
          }
          if ((paramChatMessage instanceof MessageForRichState)) {
            return 13;
          }
          if ((paramChatMessage instanceof MessageForPubAccount))
          {
            paramChatMessage = ((MessageForPubAccount)paramChatMessage).mPAMessage;
            if ((paramChatMessage != null) && (paramChatMessage.items != null) && (paramChatMessage.items.size() != 0))
            {
              if (((PAMessage.Item)paramChatMessage.items.get(0)).cover != null)
              {
                if (paramChatMessage.items.size() == 1) {
                  return 6;
                }
                if (paramChatMessage.items.size() < 2) {
                  break;
                }
                return 7;
              }
              return 8;
            }
            return 0;
          }
          if ((paramChatMessage instanceof MessageForQQStory)) {
            return 65;
          }
          if ((paramChatMessage instanceof MessageForTroopNotification)) {
            return 28;
          }
          if ((paramChatMessage instanceof MessageForTroopTopic)) {
            return 52;
          }
          if ((paramChatMessage instanceof MessageForStructing)) {
            return 5;
          }
          if ((paramChatMessage instanceof MessageForBitApp)) {
            return 51;
          }
          if ((paramChatMessage instanceof MessageForFunnyFace)) {
            return 19;
          }
          if (((paramChatMessage instanceof MessageForLongMsg)) && (paramChatMessage.msgtype != 64500)) {
            return 17;
          }
          if (((paramChatMessage instanceof MessageForMixedMsg)) || ((paramChatMessage != null) && (paramChatMessage.msgtype == 64500))) {
            return 18;
          }
          if ((paramChatMessage instanceof MessageForQzoneFeed)) {
            return 21;
          }
          if ((paramChatMessage instanceof MessageForActivity)) {
            return 16;
          }
          if ((paramChatMessage instanceof MessageForEnterTroop)) {
            return 22;
          }
          if ((paramChatMessage instanceof MessageForMyEnterTroop)) {
            return 23;
          }
          if ((paramChatMessage instanceof MessageForTroopFile)) {
            return 25;
          }
          if ((paramChatMessage instanceof MessageForShakeWindow)) {
            return 26;
          }
          if ((paramChatMessage instanceof MessageForTroopUnreadTips)) {
            return 27;
          }
          if ((paramChatMessage instanceof MessageForDevShortVideo)) {
            return 35;
          }
          if ((paramChatMessage instanceof MessageForDevLittleVideo)) {
            return 45;
          }
          if ((paramChatMessage instanceof MessageForShortVideo))
          {
            switch (((MessageForShortVideo)paramChatMessage).busiType)
            {
            default: 
              return 29;
            case 0: 
              return 29;
            case 1: 
              return 38;
            case 2: 
              return 46;
            case 1007: 
              return 40;
            }
            return 41;
          }
          if ((paramChatMessage instanceof MessageForColorRing)) {
            return 31;
          }
          if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
            return 32;
          }
          if ((paramChatMessage instanceof MessageForTroopFee)) {
            return 44;
          }
          if ((paramChatMessage instanceof MessageForDeviceFile))
          {
            paramChatMessage = (MessageForDeviceFile)paramChatMessage;
            if (paramChatMessage.nFileMsgType == 2) {
              return 36;
            }
            if (paramChatMessage.nFileMsgType != 1) {
              break;
            }
            return 37;
          }
          if ((paramChatMessage instanceof MessageForDeviceSingleStruct)) {
            return 34;
          }
          i1 = i2;
        } while ((paramChatMessage instanceof MessageForQQWalletTips));
        if ((paramChatMessage instanceof MessageForDeviceText)) {
          return 39;
        }
        i1 = i2;
      } while ((paramChatMessage instanceof ShareHotChatGrayTips));
      i1 = i2;
    } while ((paramChatMessage instanceof MessageForDeliverGiftTips));
    if ((paramChatMessage instanceof MessageForArkApp)) {
      return 47;
    }
    if ((paramChatMessage instanceof MessageForApollo)) {
      return 55;
    }
    if ((paramChatMessage instanceof MessageForReplyText)) {
      return 50;
    }
    if ((paramChatMessage instanceof MessageForApproval)) {
      return 100;
    }
    if ((paramChatMessage instanceof MessageForTroopReward))
    {
      if (paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        return 58;
      }
      return 59;
    }
    if ((paramChatMessage instanceof MessageForDingdongSchedule)) {
      return 54;
    }
    if ((paramChatMessage instanceof MessageForVideoVip)) {
      return 53;
    }
    if ((paramChatMessage instanceof MessageForVIPDonate)) {
      return 57;
    }
    if ((paramChatMessage instanceof MessageForFoldMsgGrayTips)) {
      return 56;
    }
    if ((paramChatMessage instanceof MessageForPoke)) {
      return 61;
    }
    if ((paramChatMessage instanceof MessageForUniteGrayTip)) {
      return 63;
    }
    if ((paramChatMessage instanceof MessageForQQStoryComment)) {
      return 66;
    }
    return 0;
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    switch (a(paramChatMessage))
    {
    case 4: 
    case 14: 
    case 19: 
    case 20: 
    case 30: 
    case 43: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    case 96: 
    case 97: 
    case 98: 
    case 99: 
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder = new TextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder;
    case 60: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder = new FilePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder;
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder = new FileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder = new PicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder;
    case 24: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder = new AppSharePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder = new PttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder;
    case 33: 
      if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder = new DevicePttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePttItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder;
    case 15: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder = new GrayTipsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder;
    case 6: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder = new PASingleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder;
    case 7: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder = new PAMultiItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder;
    case 8: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder = new PATextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder;
    case 5: 
    case 52: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder = new StructingMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder;
    case 51: 
      if (this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder = new BitAppMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder;
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder = new LocationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder;
    case 11: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder = new VideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder;
    case 13: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder = new RichStatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        paramChatMessage = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
        if (paramChatMessage != null) {
          paramChatMessage.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder);
        }
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder;
    case 9: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder = new TextTranslationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder;
    case 12: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder = new MarketFaceItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder;
    case 16: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder = new ActivityChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder;
    case 22: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder = new EnterTroopChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder;
    case 23: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder = new MyEnterTroopChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder;
    case 17: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder = new LongMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder;
    case 18: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder = new MixedMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder;
    case 21: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder = new QzoneFeedItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder;
    case 25: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder = new TroopFileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder;
    case 26: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder = new ShakeItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder;
    case 61: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder = new PokeItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder;
    case 27: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder = new TroopUnreadTipsChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder;
    case 28: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder = new StructTroopNotificationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder;
    case 29: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder = new ShortVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder;
    case 38: 
    case 40: 
    case 41: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder = new ShortVideoRealItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder;
    case 46: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder = new ShortVideoPTVItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder;
    case 31: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder = new ThumbItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder;
    case 32: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder = new QQWalletMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder;
    case 44: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFeeMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFeeMsgItemBuilder = new TroopFeeMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFeeMsgItemBuilder;
    case 48: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder = new TroopGiftMsgItemBuilder.TroopGiftMsgItemSenderBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder;
    case 49: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder = new TroopGiftMsgItemBuilder.TroopGiftMsgItemRecieverBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder;
    case 35: 
      if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder = new DevShortVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder;
    case 45: 
      if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder = new DevLittleVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder;
    case 34: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder = new DeviceSingleStructBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceSingleItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder;
    case 36: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder = new DevicePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePicItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder;
    case 37: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder = new DeviceFileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceFileItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder;
    case 39: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder = new DeviceTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder;
    case 42: 
    case 64: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder = new FlashPicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder;
    case 55: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder = new ApolloItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder;
    case 47: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder = new ArkAppItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder = new ArkAppItemBubbleBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder;
    case 50: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder = new ReplyTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder;
    case 100: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApprovalMsgBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApprovalMsgBuilder = new ApprovalMsgBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApprovalMsgBuilder;
    case 58: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder$TroopRewardItemSendBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder$TroopRewardItemSendBuilder = new TroopRewardItemBuilder.TroopRewardItemSendBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder$TroopRewardItemSendBuilder;
    case 59: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder$TroopRewardItemReceiveBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder$TroopRewardItemReceiveBuilder = new TroopRewardItemBuilder.TroopRewardItemReceiveBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder$TroopRewardItemReceiveBuilder;
    case 53: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder = new VideoVipItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder;
    case 54: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDingdongScheduleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDingdongScheduleItemBuilder = new DingdongScheduleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDingdongScheduleItemBuilder;
    case 57: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVIPDonateMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVIPDonateMsgItemBuilder = new VIPDonateMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVIPDonateMsgItemBuilder;
    case 56: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFoldMsgGrayTipsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFoldMsgGrayTipsItemBuilder = new FoldMsgGrayTipsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFoldMsgGrayTipsItemBuilder;
    case 62: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongTextItemBuilder = new LongTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongTextItemBuilder;
    case 63: 
      if (this.jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder = new UniteGrayTipItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder;
    case 65: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder = new QQStoryItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder = new QQStoryCommentItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.e();
    }
    if (this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder != null) {
      this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder.e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ItemBuilderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */