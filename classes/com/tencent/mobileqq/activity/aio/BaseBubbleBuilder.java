package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.Base64;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopRankColorConfig;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.util.VersionUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import nck;
import ncl;
import ncm;
import ncn;
import nco;

public abstract class BaseBubbleBuilder
  implements View.OnClickListener, ChatItemBuilder
{
  protected static final Handler a;
  protected static final ConcurrentHashMap a;
  public static boolean a = false;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 1;
  public static final int g = 2;
  public static int k_;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new ncm(this);
  @Deprecated
  public BaseAdapter a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  public QQAppInterface a;
  protected float a_;
  private boolean d;
  private int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    k_ = 255;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(100);
      return;
    }
  }
  
  public BaseBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.a_ = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {
      bool1 = false;
    }
    try
    {
      i = a(paramChatMessage);
      paramViewHolder.jdField_a_of_type_Int = i;
      if (i != 0) {
        if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == 64536))
        {
          Object localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          paramContext = null;
          TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (localTransDiskCache != null) {
            paramContext = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);
          }
          if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend()))
          {
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
            if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
              paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
            }
            if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
            {
              paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
              paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            }
            if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
            {
              int k = paramChatMessage.vipBubbleDiyTextId;
              j = k;
              if (k <= 0) {
                j = SVIPHandler.b(paramChatMessage.vipBubbleID);
              }
              paramContext = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              boolean bool2 = paramChatMessage.isSend();
              boolean bool3 = paramChatMessage.needVipBubble();
              if (i != 2) {
                break label572;
              }
              bool1 = true;
              paramContext.a((QQAppInterface)localObject, bool2, bool3, bool1, paramViewHolder.jdField_a_of_type_AndroidViewView, FontManager.a(paramChatMessage), j);
            }
            if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
            {
              paramContext = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
              if (paramContext != null) {
                paramContext.setAlpha(k_);
              }
            }
            a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
            a(paramViewHolder, paramChatMessage);
            if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag))
            {
              jdField_a_of_type_AndroidOsHandler.post(new ncl(this, paramViewHolder, paramChatMessage));
              paramChatMessage.mAnimFlag = false;
            }
            if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
            {
              paramBaseChatItemLayout.a(paramViewHolder.jdField_a_of_type_AndroidViewView);
              a(paramViewHolder.jdField_a_of_type_AndroidViewView, paramChatMessage);
              paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131296655, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
              paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131296656, paramChatMessage);
            }
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getBubbleType error : " + localException);
        int i = 0;
        continue;
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
        continue;
        int j = SVIPHandler.a(paramChatMessage.vipBubbleID);
        if ((i == 3) || (!paramChatMessage.needVipBubble())) {
          j = 0;
        }
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
        continue;
        label572:
        bool1 = false;
        continue;
        if (paramViewHolder.jdField_a_of_type_AndroidViewView == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleBubbleBg mContent is null type = " + paramChatMessage.istroop);
          return;
        }
        paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Object localObject1;
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
      if (paramChatMessage.isMultiMsg) {
        localObject1 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      label64:
      Object localObject2;
      int i;
      if ((localObject1 == null) || (((String)localObject1).length() == 0))
      {
        localObject1 = paramChatMessage.senderuin;
        if (!AnonymousChatHelper.a(paramChatMessage)) {
          break label1408;
        }
        localObject2 = AnonymousChatHelper.a(paramChatMessage).jdField_b_of_type_JavaLangString;
        i = 1;
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          localObject1 = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
        }
        for (;;)
        {
          boolean bool1 = false;
          boolean bool3 = bool1;
          if (paramChatMessage.istroop == 1)
          {
            bool3 = bool1;
            if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramChatMessage.frienduin) != null) {
              bool3 = HotChatManager.a(paramChatMessage);
            }
          }
          boolean bool2 = false;
          bool1 = bool2;
          Object localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(166))
          {
            localObject3 = (OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
            if (!paramChatMessage.isSend()) {
              break label865;
            }
            if ((!OlympicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "GroupAIO")) || (i != 0)) {
              break label859;
            }
            bool1 = true;
            label247:
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break label964;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleNickname self TorchFlag: " + bool1);
          }
          label397:
          boolean bool4;
          label521:
          label531:
          label544:
          boolean bool5;
          label566:
          label588:
          label623:
          label669:
          int j;
          label682:
          label713:
          label859:
          label865:
          do
          {
            localObject3 = localObject2;
            if (paramChatMessage.msgtype == 62530) {
              localObject3 = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            }
            localObject2 = localObject3;
            if ((paramChatMessage instanceof MessageForStructing))
            {
              localObject2 = localObject3;
              if (TroopBindPublicAccountMgr.a(paramChatMessage)) {
                localObject2 = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
              }
            }
            Object localObject4 = TroopBusinessUtil.a(paramChatMessage);
            if (localObject4 == null) {
              break label1392;
            }
            localObject3 = ((TroopBusinessUtil.TroopBusinessMessage)localObject4).jdField_c_of_type_JavaLangString;
            localObject2 = localObject3;
            if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
              break label1392;
            }
            localObject1 = ColorStateList.valueOf(((TroopBusinessUtil.TroopBusinessMessage)localObject4).jdField_b_of_type_Int);
            localObject2 = localObject3;
            localObject3 = localObject1;
            bool4 = false;
            String str = "";
            Object localObject5 = null;
            bool2 = bool4;
            localObject4 = str;
            localObject1 = localObject5;
            if (paramChatMessage.istroop == 1)
            {
              bool2 = bool4;
              localObject4 = str;
              localObject1 = localObject5;
              if (!AnonymousChatHelper.a(paramChatMessage))
              {
                bool2 = bool4;
                localObject4 = str;
                localObject1 = localObject5;
                if (TroopMemberLbsHelper.a(paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue())
                {
                  localObject4 = TroopMemberLbsHelper.a(paramChatMessage.frienduin, paramChatMessage.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
                  if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                    break label971;
                  }
                  localObject1 = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
                  if (paramChatMessage.isSend()) {
                    break label986;
                  }
                  bool2 = true;
                }
              }
            }
            if ((localObject2 == null) && (i == 0)) {
              break label992;
            }
            bool4 = true;
            if (((i == 0) || (!AnonymousChatHelper.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
              break label998;
            }
            bool5 = true;
            paramBaseChatItemLayout.a(bool4, (CharSequence)localObject2, (ColorStateList)localObject3, bool5, bool3, bool1, bool2, (CharSequence)localObject4, (ColorStateList)localObject1);
            if (paramBaseChatItemLayout.f != null)
            {
              if (AnonymousChatHelper.a(paramChatMessage)) {
                break label1170;
              }
              paramBaseChatItemLayout.f.setOnClickListener(this);
              paramBaseChatItemLayout.f.setTag(Integer.valueOf(2131296323));
              if ((AppSetting.j) && (Build.VERSION.SDK_INT >= 14)) {
                paramBaseChatItemLayout.f.setAccessibilityDelegate(new nck(this));
              }
            }
            if (AppSetting.j)
            {
              if (paramChatMessage.istroop != 1) {
                break label1181;
              }
              i = 1;
              if (paramChatMessage.istroop != 3000) {
                break label1187;
              }
              j = 1;
              bool1 = paramChatMessage.isSend();
              if ((i != 0) || (j != 0))
              {
                if (i == 0) {
                  break label1285;
                }
                if (!bool1) {
                  break label1193;
                }
                localObject1 = "我的群名片";
                paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
              }
            }
            if ((AppSetting.j) && (paramViewHolder.jdField_b_of_type_JavaLangStringBuilder != null))
            {
              if (!paramChatMessage.isSend()) {
                break label1329;
              }
              paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append("我");
            }
            return;
            if (paramChatMessage.istroop == 1)
            {
              localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
              break;
            }
            if (3000 != paramChatMessage.istroop) {
              break label1418;
            }
            if (paramChatMessage.isSend())
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
              break;
            }
            localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
            break;
            localObject1 = (String)localObject1 + ":";
            break label64;
            bool1 = false;
            break label247;
            bool1 = bool2;
          } while (i != 0);
          if (((OlympicManager)localObject3).b("GroupAIO")) {}
          for (bool1 = OlympicTorchManager.a(paramChatMessage);; bool1 = false)
          {
            if ((bool1) && (paramChatMessage.istroop == 1))
            {
              OlympicUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006892", 1, paramChatMessage.senderuin);
              break;
            }
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (paramChatMessage.istroop == 3000)
              {
                OlympicUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006892", 2, paramChatMessage.senderuin);
                bool2 = bool1;
              }
            }
            label964:
            bool1 = bool2;
            break;
            label971:
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
            break label521;
            label986:
            bool2 = false;
            break label531;
            label992:
            bool4 = false;
            break label544;
            label998:
            bool5 = false;
            break label566;
            if (paramChatMessage.istroop == 9501)
            {
              if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.issend == 0))
              {
                localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, true);
                if (paramChatMessage.senderuin.equals(paramChatMessage.frienduin)) {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
                }
                if (localObject1 != null)
                {
                  localObject2 = localObject1;
                  if (((String)localObject1).length() != 0) {}
                }
                else
                {
                  localObject2 = paramChatMessage.senderuin;
                }
                paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, false, false, false, false, "", null);
              }
              for (;;)
              {
                localObject2 = null;
                break;
                paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null);
              }
            }
            paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
            break label588;
            label1170:
            paramBaseChatItemLayout.f.setOnClickListener(null);
            break label623;
            label1181:
            i = 0;
            break label669;
            label1187:
            j = 0;
            break label682;
            label1193:
            if ("1000000".equals(paramChatMessage.senderuin))
            {
              if (paramChatMessage.msgtype == 62530)
              {
                localObject1 = String.format(paramBaseChatItemLayout.getResources().getString(2131365253), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
                break label713;
              }
              localObject1 = "进入群应用";
              break label713;
            }
            localObject1 = (String)localObject2 + "群名片";
            break label713;
            label1285:
            if (j != 0)
            {
              if (bool1)
              {
                localObject1 = "我的资料卡";
                break label713;
              }
              localObject1 = (String)localObject2 + "资料卡";
              break label713;
              label1329:
              paramBaseChatItemLayout = (BaseChatItemLayout)localObject2;
              if (localObject2 == null) {
                paramBaseChatItemLayout = "";
              }
              if (AnonymousChatHelper.a(paramChatMessage))
              {
                paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364920)).append(paramBaseChatItemLayout);
                return;
              }
              paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(paramBaseChatItemLayout);
              return;
            }
            localObject1 = "";
            break label713;
            label1392:
            localObject3 = localObject1;
            break label397;
          }
        }
        label1408:
        i = 0;
        localObject2 = localObject1;
      }
      label1418:
      localObject1 = null;
    }
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131305401, paramContext.getString(2131367892));
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a(localQQAppInterface, localQQAppInterface.a()), paramString2, null);
      }
      return;
    }
  }
  
  public static void d()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  private void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject2;
    int j;
    Object localObject1;
    int i;
    if (localHotChatInfo != null)
    {
      localObject2 = null;
      j = 0;
      if (!paramChatMessage.senderuin.equals(localHotChatInfo.ownerUin)) {
        break label67;
      }
      localObject1 = "房主";
      i = 2130843475;
    }
    for (;;)
    {
      paramBaseChatItemLayout.a((String)localObject1, i);
      return;
      label67:
      i = j;
      localObject1 = localObject2;
      if (localHotChatInfo.adminUins != null)
      {
        i = j;
        localObject1 = localObject2;
        if (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin))
        {
          localObject1 = "管理员";
          i = 2130843474;
        }
      }
    }
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopRankColorConfig localTroopRankColorConfig = TroopRankColorConfig.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    int i;
    int j;
    for (boolean bool = true;; bool = false)
    {
      i = -1;
      if (bool) {
        i = AnonymousChatHelper.jdField_e_of_type_Int;
      }
      if (!AnonymousChatHelper.a(paramChatMessage)) {
        break;
      }
      j = localTroopRankColorConfig.jdField_e_of_type_Int;
      paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364922), AnonymousChatHelper.b(paramChatMessage), j, i);
      paramBaseChatItemLayout.c.setOnClickListener(null);
      return;
    }
    if ("1000000".equals(paramChatMessage.senderuin))
    {
      this.d = false;
      paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, i);
      return;
    }
    if ((paramChatMessage instanceof MessageForTroopTopic))
    {
      paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, i);
      return;
    }
    Object localObject = TroopBusinessUtil.a(paramChatMessage);
    if (localObject != null)
    {
      j = ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_c_of_type_Int;
      i = ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_d_of_type_Int;
      if (!bool) {
        break label499;
      }
      j = AnonymousChatHelper.jdField_e_of_type_Int;
      i = localTroopRankColorConfig.jdField_e_of_type_Int;
    }
    label499:
    for (;;)
    {
      paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_d_of_type_JavaLangString, false, i, j);
      paramBaseChatItemLayout.c.setOnClickListener(this);
      paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131296320));
      return;
      localObject = null;
      j = localTroopRankColorConfig.jdField_d_of_type_Int;
      String str;
      if ((paramChatMessage.istroop == 1) && (localTroopManager != null))
      {
        TroopInfo localTroopInfo = localTroopManager.a(paramChatMessage.frienduin);
        if ((localTroopInfo != null) && (localTroopInfo.cGroupRankSysFlag == 1) && (localTroopInfo.cGroupRankUserFlag == 1))
        {
          localObject = paramChatMessage.getExtInfoFromExtStr("uniqueTitle");
          paramChatMessage = localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin);
          str = localTroopManager.a(localTroopInfo, paramChatMessage, this.jdField_a_of_type_AndroidContentContext);
          j = localTroopManager.a(localTroopRankColorConfig, localTroopInfo, paramChatMessage, (String)localObject, bool);
          paramChatMessage = (ChatMessage)localObject;
        }
      }
      for (localObject = str;; localObject = str)
      {
        if (!android.text.TextUtils.isEmpty(paramChatMessage))
        {
          paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramChatMessage, false, j, i);
          this.d = true;
          paramBaseChatItemLayout.c.setOnClickListener(this);
          paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131296320));
          return;
        }
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, (String)localObject, false, j, i);
          this.d = true;
          paramBaseChatItemLayout.c.setOnClickListener(this);
          paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131296320));
          return;
        }
        this.d = false;
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, i);
        return;
        str = null;
        paramChatMessage = (ChatMessage)localObject;
      }
    }
  }
  
  private void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (AnonymousChatHelper.a(paramChatMessage))
    {
      this.h = 0;
      paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.h, AnonymousChatHelper.b(paramChatMessage));
      if (paramBaseChatItemLayout.d != null) {
        paramBaseChatItemLayout.d.setOnClickListener(null);
      }
    }
    do
    {
      TroopManager localTroopManager;
      do
      {
        do
        {
          return;
          if ("1000000".equals(paramChatMessage.senderuin))
          {
            this.h = 0;
            paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.h, false);
            return;
          }
          if ((paramChatMessage instanceof MessageForTroopTopic))
          {
            this.h = 0;
            paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.h, false);
            return;
          }
          if (MessageUtils.a(paramChatMessage.msgtype))
          {
            this.h = 0;
            paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.h, false);
            return;
          }
          if (TroopBusinessUtil.a(paramChatMessage) == null) {
            break;
          }
          this.h = 0;
          paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.h, false);
        } while (paramBaseChatItemLayout.d == null);
        paramBaseChatItemLayout.d.setOnClickListener(this);
        paramBaseChatItemLayout.d.setTag(Integer.valueOf(2131296321));
        return;
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      } while (localTroopManager == null);
      paramChatMessage = localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin);
    } while (paramChatMessage == null);
    this.h = paramChatMessage.mGlamourLevel;
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.h >= 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.a(paramChatMessage, bool, this.h, false);
      if (paramBaseChatItemLayout.d == null) {
        break;
      }
      paramBaseChatItemLayout.d.setOnClickListener(this);
      paramBaseChatItemLayout.d.setTag(Integer.valueOf(2131296321));
      return;
    }
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1 + ", msgseq = " + paramChatMessage.msgseq + ", shmsgseq = " + paramChatMessage.shmsgseq);
    }
    Context localContext = paramViewGroup.getContext();
    paramView = (BaseChatItemLayout)paramView;
    boolean bool = AppSetting.j;
    if (paramView == null)
    {
      paramView = new BaseChatItemLayout(localContext);
      paramView.setId(2131296417);
      paramView.setFocusableInTouchMode(true);
      paramView.setPadding(BaseChatItemLayout.w, BaseChatItemLayout.y, BaseChatItemLayout.x, 0);
      paramViewGroup = a();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
      if (!bool) {
        break label784;
      }
      paramViewGroup.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    label725:
    label757:
    label774:
    label784:
    for (;;)
    {
      if ((bool) && (paramViewGroup.jdField_b_of_type_JavaLangStringBuilder == null)) {
        paramViewGroup.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      paramViewGroup.jdField_b_of_type_Int = paramInt1;
      paramViewGroup.jdField_c_of_type_Int = paramInt2;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (bool)
      {
        paramView.setContentDescription(null);
        if (!android.text.TextUtils.isEmpty(paramViewGroup.jdField_b_of_type_JavaLangStringBuilder)) {
          paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.length(), "");
        }
        localObject1 = localObject2;
        if (paramChatMessage.mNeedTimeStamp)
        {
          localObject1 = localObject2;
          if (paramChatMessage.time <= 0L) {}
        }
      }
      try
      {
        localObject1 = TimeFormatterUtils.a(localContext, 3, paramChatMessage.time * 1000L);
        paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append((CharSequence)localObject1).append(" ");
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
        if (paramChatMessage.isSend())
        {
          i = 1;
          paramView.setHearIconPosition(i);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null)
          {
            ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
            localObject2 = localColorStateList;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
            {
              localObject2 = localColorStateList;
              if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                localObject2 = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
              }
            }
            paramView.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage.time, (ColorStateList)localObject2, (CharSequence)localObject1);
          }
          if (!TroopBindPublicAccountMgr.a(paramChatMessage)) {
            break label725;
          }
          paramView.setGrayTipsText(true, localContext.getString(2131364533), this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427368), 0);
          a(paramChatMessage, paramView);
          b(paramChatMessage, paramView);
          a(paramChatMessage, paramView, paramInt1, paramInt2);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
            if ((localObject1 == null) || (!((HotChatManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
              break label757;
            }
            d(paramChatMessage, paramView);
          }
          a(paramChatMessage, paramView, paramViewGroup);
          if (!b(paramChatMessage, paramView)) {
            break label774;
          }
          paramView.setProgressVisable(false);
          paramViewGroup.jdField_a_of_type_AndroidViewView = a(paramChatMessage, paramViewGroup, paramViewGroup.jdField_a_of_type_AndroidViewView, paramView, paramOnLongClickAndTouchListener);
          a(paramChatMessage, localContext, paramView, paramViewGroup, paramInt1, paramInt2);
          if (bool)
          {
            paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
            paramView.setContentDescription(paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.toString());
            paramView.setFocusable(true);
          }
          if ((paramChatMessage instanceof MessageForTroopTopic))
          {
            paramInt1 = AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            paramInt2 = AIOUtils.a(7.5F, localContext.getResources());
            paramView.setPadding(0, 0, 0, 0);
            paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
            ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt1, paramInt2, paramInt1, paramInt2);
          }
          paramView.requestLayout();
          return paramView;
          paramViewGroup = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str = "";
          continue;
          int i = 0;
          continue;
          paramView.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427368), 235);
          continue;
          e(paramChatMessage, paramView);
          f(paramChatMessage, paramView);
          continue;
          c(paramChatMessage, paramView);
        }
      }
    }
  }
  
  protected abstract View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  protected abstract BaseBubbleBuilder.ViewHolder a();
  
  protected abstract String a(ChatMessage paramChatMessage);
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
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
              return;
            } while (c());
            if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
              ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().g(paramChatMessage);
            }
          } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
          paramContext = (MessageForStructing)paramChatMessage;
        } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
        StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "reply");
        return;
      } while ((paramChatMessage.istroop != 1) || ((!(paramChatMessage instanceof MessageForLongMsg)) && (!(paramChatMessage instanceof MessageForText)) && (!(paramChatMessage instanceof MessageForReplyText))));
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getString(2131365202), null, this.jdField_a_of_type_AndroidContentContext.getString(2131364644), new ncn(this), null).show();
        return;
      }
      paramContext = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
    } while ((paramContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
    TroopBarUtils.a.clear();
    paramContext.a(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage, null, 4);
    paramContext = "";
    if (paramChatMessage.msgtype == 64536) {
      paramContext = "1";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "pub_talk", "Clk_bubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramContext, "", "");
      return;
      if (paramChatMessage.msgtype == 63536) {
        paramContext = "2";
      }
    }
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.k;
    int i = j;
    if (StructMsgItemLayout12.a(paramChatMessage)) {
      i = j - AIOUtils.a(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.n, i, BaseChatItemLayout.m, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.m, i, BaseChatItemLayout.n, BaseChatItemLayout.l);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {
      return;
    }
    int j = 0;
    int k = 0;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    label39:
    Object localObject2;
    int i;
    if (com.tencent.mobileqq.text.TextUtils.a(paramChatMessage.msg))
    {
      localObject1 = com.tencent.mobileqq.text.TextUtils.a(paramChatMessage.msg);
      localObject2 = localObject4;
      i = j;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject5 = paramBubbleInfo.a((String)localObject1);
        localObject2 = localObject4;
        localObject3 = localObject5;
        i = j;
        if (localObject5 != null)
        {
          localObject4 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          localObject2 = localObject4;
          localObject3 = localObject5;
          i = j;
          if (localObject4 != null)
          {
            localObject2 = localObject4;
            localObject3 = localObject5;
            i = j;
            if (((Pair)localObject4).first != null)
            {
              i = 1;
              localObject3 = localObject5;
              localObject2 = localObject4;
            }
          }
        }
      }
      j = k;
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
      {
        j = k;
        if ((paramChatMessage instanceof MessageForText))
        {
          j = k;
          if (VersionUtils.e())
          {
            localObject1 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
            j = k;
            if (localObject1 != null)
            {
              j = k;
              if (((Pair)localObject1).first != null)
              {
                j = k;
                if (paramView.getWidth() > ((BubbleInfo.CommonAttrs)((Pair)localObject1).first).a.s) {
                  j = 1;
                }
              }
            }
          }
        }
      }
      localObject1 = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      if ((localObject1 == null) || (!(paramChatMessage instanceof MessageForText))) {
        break label665;
      }
      localObject4 = ((BubbleManager)localObject1).a(paramBubbleInfo.jdField_c_of_type_Int, false);
      if ((localObject4 == null) || (((BubbleConfig)localObject4).d == null) || (((BubbleConfig)localObject4).d.t == 0) || (!VersionUtils.e())) {
        break label665;
      }
      if (!paramChatMessage.isSend()) {
        break label611;
      }
      localObject1 = paramChatMessage.selfuin;
      label312:
      Object localObject5 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject5 == null) {
        break label665;
      }
      localObject1 = ((FriendsManager)localObject5).a((String)localObject1);
      if ((localObject1 == null) || ((((BubbleConfig)localObject4).d.t != -1) && (((ExtensionInfo)localObject1).pendantId != ((BubbleConfig)localObject4).d.t))) {
        break label665;
      }
    }
    label611:
    label659:
    label665:
    for (k = 1;; k = 0)
    {
      if ((i != 0) || (j != 0) || (k != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
      }
      if (i != 0)
      {
        a("keyword_trigger", paramBubbleInfo.jdField_c_of_type_Int, (String)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), localObject2 });
      }
      if ((j != 0) || (k != 0)) {
        if (j == 0) {
          break label659;
        }
      }
      for (i = 3;; i = 5)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramBubbleInfo.jdField_c_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
        if (!paramBubbleInfo.a(paramView.getHeight())) {
          break;
        }
        paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
        if ((paramView == null) || (paramView.first == null)) {
          break;
        }
        a("wordnum_trigger", paramBubbleInfo.jdField_c_of_type_Int, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(2), Long.valueOf(paramChatMessage.uniseq), paramView });
        return;
        localObject1 = paramChatMessage.msg;
        break label39;
        if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
        {
          localObject1 = paramChatMessage.frienduin;
          break label312;
        }
        localObject1 = paramChatMessage.senderuin;
        break label312;
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {}
    do
    {
      return;
      paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    } while ((paramView == null) || (paramView.first == null));
    b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
  public void a(ChatMessage paramChatMessage)
  {
    int i;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      BaseChatPie localBaseChatPie = null;
      if (localChatFragment != null) {
        localBaseChatPie = localChatFragment.a();
      }
      if (localBaseChatPie != null) {
        localBaseChatPie.c(paramChatMessage);
      }
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label107;
      }
      i = 6;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "" + i, "", "", "");
      return;
      label107:
      if ((paramChatMessage instanceof MessageForText)) {
        i = 1;
      } else if ((paramChatMessage instanceof MessageForPic)) {
        i = 3;
      } else if ((paramChatMessage instanceof MessageForMarketFace)) {
        i = 4;
      } else if ((paramChatMessage instanceof MessageForApollo)) {
        i = 5;
      } else {
        i = 0;
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setCheckBox(paramChatMessage, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if (AIOUtils.i) {}
    Object localObject;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject != null) && (((TroopInfo)localObject).hasOrgs()));
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null) || (AnonymousChatHelper.a(paramChatMessage)) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    ExtensionInfo localExtensionInfo;
    AvatarPendantManager localAvatarPendantManager;
    if (paramChatMessage.isSend())
    {
      localObject = paramChatMessage.selfuin;
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localFriendsManager == null) {
        break label355;
      }
      localExtensionInfo = localFriendsManager.a((String)localObject, false);
      localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      if ((localExtensionInfo == null) || (!localExtensionInfo.isPendantValid())) {
        break label318;
      }
      AvatarPendantManager.b = true;
      if (!AvatarPendantUtil.a(localExtensionInfo.pendantId)) {
        break label296;
      }
      localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq);
      label192:
      if ((!localFriendsManager.b((String)localObject)) && (localExtensionInfo.isPendantExpired())) {
        AvatarPendantUtil.a((String)localObject);
      }
      if ((!localAvatarPendantManager.a(paramChatMessage.uniseq)) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)) {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      paramChatMessage.mPendantAnimatable = false;
      return;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
      {
        localObject = paramChatMessage.frienduin;
        break;
      }
      localObject = paramChatMessage.senderuin;
      break;
      label296:
      localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 1, paramChatMessage.uniseq);
      break label192;
      label318:
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      if (localExtensionInfo == null)
      {
        AvatarPendantUtil.a((String)localObject);
        continue;
        label355:
        if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if ((paramChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f())) && (paramChatMessage.isSupportReply()))
    {
      paramQQCustomMenu.a(2131305418, this.jdField_a_of_type_AndroidContentContext.getString(2131365206));
      MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
    }
  }
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 99) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramChatMessage.uniseq), paramString);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, int paramInt, MessageRecord paramMessageRecord)
  {
    if (AnonymousChatHelper.a(paramMessageRecord)) {}
    label7:
    boolean bool;
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            break label7;
            break label7;
            do
            {
              return;
            } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9);
            localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!((FriendsManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
          if (paramInt != 1) {
            break;
          }
          localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        } while ((localObject != null) && (((HotChatManager)localObject).b(paramMessageRecord.frienduin)));
        paramInt = paramMessageRecord.istroop;
      } while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000) && (paramInt != 1000) && (paramInt != 1004));
      bool = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("msgrevoke_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
      if (QLog.isColorLevel()) {
        QLog.i("msgrevoke", 2, "menuitem msgRevokeFlag=" + bool);
      }
    } while (!bool);
    paramQQCustomMenu.a(2131296353, this.jdField_a_of_type_AndroidContentContext.getString(2131368032));
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.b;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.senderuin != null) && (paramChatMessage.senderuin.equals(paramChatMessage.selfuin));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {}
    label197:
    label199:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
            if ((localChatMessage.issend == 1) || (localChatMessage.issend == 2)) {}
            for (i = 1;; i = 0)
            {
              if ("10000".equals(localChatMessage.senderuin)) {
                break label197;
              }
              localObject2 = TroopBusinessUtil.a(localChatMessage);
              if (localObject2 == null) {
                break label199;
              }
              TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TroopBusinessUtil.TroopBusinessMessage)localObject2);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, localChatMessage.frienduin, "", ((TroopBusinessUtil.TroopBusinessMessage)localObject2).jdField_c_of_type_JavaLangString, "");
              if (localChatMessage.msgtype != 63485) {
                break;
              }
              try
              {
                paramView = (MessageForQQStory)localChatMessage;
                paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.msgAction);
                QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_head", paramView, false);
                return;
              }
              catch (Exception paramView) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramView);
              return;
            }
          }
          if ((!(localChatMessage instanceof MessageForStructing)) || (!TroopBindPublicAccountMgr.a(localChatMessage))) {
            break;
          }
          localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        } while ((localObject1 == null) || (((TroopInfo)localObject1).associatePubAccount == 0L));
        localObject2 = new Intent(paramView.getContext(), AccountDetailActivity.class);
        ((Intent)localObject2).putExtra("uin", ((TroopInfo)localObject1).associatePubAccount + "");
        paramView.getContext().startActivity((Intent)localObject2);
        return;
      } while ((i == 0) && (localChatMessage.istroop == 7100));
      if (!AnonymousChatHelper.a(localChatMessage)) {
        break label921;
      }
      localObject1 = AnonymousChatHelper.a(localChatMessage);
      if ((paramView != null) && ((((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_JavaLangString != null) || (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int == 2))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "onHeadIconClick : an_id is null");
    return;
    Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(localChatMessage.frienduin);
    Object localObject3 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localObject2 != null) {
      ((TroopHandler)localObject3).a(((TroopInfo)localObject2).troopuin, (byte)0, ((TroopInfo)localObject2).dwTimeStamp, 0);
    }
    int j = 0;
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i = j;
    if (localObject2 != null)
    {
      i = j;
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject3))
      {
        if ((((TroopInfo)localObject2).Administrator == null) || (!((TroopInfo)localObject2).Administrator.contains((CharSequence)localObject3))) {
          break label742;
        }
        i = 3;
      }
    }
    localObject2 = ((AnonymousChatHelper.AnonymousExtInfo)localObject1).a();
    if ((localObject2 != null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int != 2))
    {
      localObject2 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
      localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localStringBuilder = new StringBuilder().append("http://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject2).append("&gcode=").append(localChatMessage.frienduin).append("&avatar=").append(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_Int)).append("&nick=");
      if (android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString))
      {
        localObject1 = "";
        ((Intent)localObject3).putExtra("url", (String)localObject1 + "&role=" + String.valueOf(i) + "&self=0");
        ((Activity)paramView.getContext()).startActivity((Intent)localObject3);
        if (localChatMessage.msgData != null)
        {
          AnonymousChatHelper.a().a(localChatMessage.frienduin, (String)localObject2, localChatMessage);
          if (QLog.isDevelopLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 4, "report:" + localChatMessage.msgData.toString());
          }
        }
      }
    }
    label742:
    while (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int != 2) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, localChatMessage.frienduin, "", "", "");
        return;
        if (((String)localObject3).equals(((TroopInfo)localObject2).troopowneruin))
        {
          i = 2;
          break;
        }
        i = 1;
        break;
        localObject1 = URLEncoder.encode(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString);
      }
    }
    localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localObject3 = new StringBuilder().append("http://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(localChatMessage.frienduin).append("&avatar=").append(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_Int)).append("&nick=");
    if (android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString)) {}
    for (Object localObject1 = "";; localObject1 = URLEncoder.encode(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString))
    {
      ((Intent)localObject2).putExtra("url", (String)localObject1 + "&role=" + String.valueOf(i) + "&self=1");
      ((Activity)paramView.getContext()).startActivity((Intent)localObject2);
      break;
    }
    label921:
    if ("1000000".equals(localChatMessage.senderuin))
    {
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1");
      return;
    }
    localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if ((localObject2 != null) && (((HotChatManager)localObject2).b(localChatMessage.frienduin))) {}
    for (j = 1; (j == 0) && (localChatMessage.istroop == 1); j = 0)
    {
      localObject1 = new Intent(paramView.getContext(), TroopMemberCardActivity.class);
      ((Intent)localObject1).putExtra("troopUin", localChatMessage.frienduin);
      ((Intent)localObject1).putExtra("memberUin", localChatMessage.senderuin);
      ((Intent)localObject1).putExtra("fromFlag", 0);
      ((Activity)paramView.getContext()).startActivityForResult((Intent)localObject1, 2000);
      return;
    }
    if ((j != 0) && ((i != 0) || ((localObject3 != null) && (!((FriendsManager)localObject3).b(localChatMessage.senderuin)))))
    {
      localObject1 = null;
      paramView = (View)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((HotChatManager)localObject2).a(localChatMessage.frienduin);
        paramView = (View)localObject1;
        if (localObject2 != null) {
          paramView = ((HotChatInfo)localObject2).troopCode;
        }
      }
      ProfilePerformanceReport.b();
      localObject1 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
      ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_JavaLangString = paramView;
      ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_JavaLangString = localChatMessage.frienduin;
      ((ProfileActivity.AllInOne)localObject1).g = 31;
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      paramView.putExtra("AllInOne", (Parcelable)localObject1);
      if (i != 0) {}
      for (i = 2;; i = 3)
      {
        paramView.putExtra("param_mode", i);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        return;
      }
    }
    boolean bool;
    if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004))
    {
      bool = ((FriendsManager)localObject1).b(localChatMessage.senderuin);
      localObject2 = localChatMessage.senderuin;
      label1293:
      if (localObject2 == null) {
        break label1540;
      }
      if (!((FriendsManager)localObject1).b((String)localObject2)) {
        break label2659;
      }
      bool = true;
    }
    label1340:
    label1409:
    label1458:
    label1540:
    label2552:
    label2609:
    label2629:
    label2641:
    label2650:
    label2659:
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        if (((String)localObject2).equals(((ProfileActivity.AllInOne)localObject1).h)) {
          ((ProfileActivity.AllInOne)localObject1).h = null;
        }
        ((ProfileActivity.AllInOne)localObject1).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020)) {
          break label2552;
        }
        ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_JavaLangString = localChatMessage.senderuin;
        ((ProfileActivity.AllInOne)localObject1).jdField_f_of_type_Int = 2;
        ((ProfileActivity.AllInOne)localObject1).g = 1;
        if ((localChatMessage.istroop != 1001) && (localChatMessage.istroop != 1010)) {
          break label2650;
        }
        if (localChatMessage.istroop != 1001) {
          break label2609;
        }
        ((ProfileActivity.AllInOne)localObject1).g = 10;
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
        paramView.putExtra("AllInOne", (Parcelable)localObject1);
        if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localObject2)) {
          break label2629;
        }
        paramView.putExtra("param_mode", 2);
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break label2641;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 9009);
        return;
        localObject2 = localChatMessage.frienduin;
        bool = false;
        break label1293;
        break;
        if (localChatMessage.istroop == 1008)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("need_finish", true);
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          PublicAccountUtil.a((Intent)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 2);
          return;
        }
        if (localChatMessage.istroop == 1024)
        {
          localObject1 = new Intent(paramView.getContext(), EqqAccountDetailActivity.class);
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("need_finish", true);
          ((Intent)localObject1).putExtra("uintype", 1024);
          ((Activity)paramView.getContext()).startActivityForResult((Intent)localObject1, 2000);
          return;
        }
        if (bool)
        {
          if (localChatMessage.istroop == 1) {}
          for (localObject1 = new ProfileActivity.AllInOne((String)localObject2, 20);; localObject1 = new ProfileActivity.AllInOne((String)localObject2, 1))
          {
            ((ProfileActivity.AllInOne)localObject1).h = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
            break;
          }
        }
        if (localChatMessage.istroop == 1010)
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject2, 76);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject2, 42);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject2, 70);
          ((ProfileActivity.AllInOne)localObject1).h = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
          break label1340;
        }
        if (localChatMessage.istroop == 1000)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 22);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1020)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 58);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 21);
          ((ProfileActivity.AllInOne)localObject1).h = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, localChatMessage.senderuin);
          break label1340;
        }
        if (3000 == localChatMessage.istroop)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 46);
          ((ProfileActivity.AllInOne)localObject1).h = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.frienduin, localChatMessage.senderuin);
          break label1340;
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1004)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 47);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject1).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1005)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 2);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1023)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 74);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 57);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1006)
        {
          localObject1 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 34);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 57);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1021)
        {
          localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 72);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1022)
        {
          localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 27);
          ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1340;
        }
        if (localChatMessage.istroop == 1025)
        {
          if (this.jdField_a_of_type_AndroidContentContext == null) {
            break;
          }
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
          paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          return;
        }
        localObject1 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 19);
        ((ProfileActivity.AllInOne)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1340;
        if (localChatMessage.istroop == 1)
        {
          ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_JavaLangString = localChatMessage.frienduin;
          break label1409;
        }
        if (3000 != localChatMessage.istroop) {
          break label1409;
        }
        ((ProfileActivity.AllInOne)localObject1).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break label1409;
        if (localChatMessage.istroop != 1010) {
          break label1458;
        }
        ((ProfileActivity.AllInOne)localObject1).g = 11;
        break label1458;
        paramView.putExtra("param_mode", 3);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
      ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject1);
      return;
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
    Object localObject;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      localObject = new StringBuilder().append("onClickSelectMore Error:");
      if (localFragmentActivity != null)
      {
        paramChatMessage = localFragmentActivity.toString();
        QLog.e("BaseBubbleBuilder", 1, paramChatMessage);
      }
    }
    do
    {
      return;
      paramChatMessage = "ca is null ";
      break;
      localObject = localFragmentActivity.getChatFragment().a();
      ((BaseChatPie)localObject).e(paramChatMessage);
      ((BaseChatPie)localObject).e(true);
      ApolloActionManager.a().e();
    } while (paramChatMessage == null);
    int j;
    int i;
    if (paramChatMessage.istroop == 0)
    {
      j = 1;
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label259;
      }
      i = 6;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, "" + i, "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + j, "", "", "");
      return;
      if (paramChatMessage.istroop == 3000)
      {
        j = 2;
        break;
      }
      if (paramChatMessage.istroop == 1)
      {
        j = 3;
        break;
      }
      j = 4;
      break;
      label259:
      if ((paramChatMessage instanceof MessageForText)) {
        i = 1;
      } else if ((paramChatMessage instanceof MessageForPic)) {
        i = 3;
      } else if ((paramChatMessage instanceof MessageForMarketFace)) {
        i = 4;
      } else {
        i = 0;
      }
    }
  }
  
  protected void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (AnonymousChatHelper.a(paramChatMessage))
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839798);
      paramBaseChatItemLayout.setHeaderIcon(URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a(paramChatMessage).jdField_b_of_type_Int), (Drawable)localObject1, (Drawable)localObject1));
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(null);
      return;
    }
    if (((paramChatMessage instanceof MessageForStructing)) && (TroopBindPublicAccountMgr.a(paramChatMessage)))
    {
      paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838603));
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(null);
      return;
    }
    Object localObject1 = TroopBusinessUtil.a(paramChatMessage);
    if (localObject1 != null)
    {
      paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838582);
      paramChatMessage = URLDrawable.getDrawable(((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_a_of_type_JavaLangString, paramChatMessage, paramChatMessage);
      paramChatMessage.setTag(URLDrawableDecodeHandler.a(100, 100, 6));
      paramChatMessage.setDecodeHandler(URLDrawableDecodeHandler.a);
      paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(null);
      return;
    }
    int k = paramChatMessage.istroop;
    String str;
    label199:
    Object localObject2;
    label246:
    int j;
    if (paramChatMessage.isSend())
    {
      str = paramChatMessage.selfuin;
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if ((localObject2 == null) || (!((HotChatManager)localObject2).b(paramChatMessage.frienduin))) {
        break label726;
      }
      i = 1;
      if ((localObject1 == null) || (!((FriendsManager)localObject1).b(str))) {
        break label732;
      }
      j = 1;
      label262:
      if (((k != 1010) && (k != 1001) && ((i == 0) || ((j != 0) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))) && ((k != 1022) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 4007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3019) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2019)))) || (localObject1 == null) || (((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label738;
      }
      localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, str, true);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + str);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.setHeaderIcon((Drawable)localObject1);
      if ((paramChatMessage.isSendFromLocal()) || ((k != 1) && (k != 3000))) {
        break label922;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramChatMessage.senderuin))
      {
        localObject1 = paramChatMessage.frienduin;
        str = paramChatMessage.senderuin;
        ThreadManager.b(new nco(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, (String)localObject1, str, k, this.jdField_a_of_type_AndroidViewView$OnLongClickListener));
      }
      label531:
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setTag(paramChatMessage);
      if (QLog.isColorLevel()) {
        QLog.d("BaseBubbleBuilder", 2, "AppSetting.enableTalkBack = " + AppSetting.j);
      }
      if (!AppSetting.j) {
        break;
      }
      str = "";
      localObject1 = str;
      if (paramChatMessage.istroop != 1)
      {
        localObject1 = str;
        if (paramChatMessage.istroop != 3000)
        {
          if (!paramChatMessage.isSend()) {
            break label933;
          }
          localObject1 = "我的资料卡";
        }
      }
      label628:
      if (paramChatMessage.msgtype == 62530) {
        localObject1 = String.format(paramBaseChatItemLayout.getResources().getString(2131365253), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
      }
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      return;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
      {
        str = paramChatMessage.frienduin;
        break label199;
      }
      str = paramChatMessage.senderuin;
      break label199;
      label726:
      i = 0;
      break label246;
      label732:
      j = 0;
      break label262;
      label738:
      if ((k != 9501) || (paramChatMessage.isSend())) {
        break label832;
      }
      localObject1 = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(str));
      if ((localObject1 != null) && (str.equals(String.valueOf(((DeviceInfo)localObject1).din)))) {
        localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.a().a(str));
      } else {
        localObject1 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      }
    }
    label832:
    if (k == 1006) {}
    for (int i = 11;; i = 1)
    {
      if (k == 1) {}
      for (localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str);; localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str))
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + str);
        localObject1 = localObject2;
        break;
      }
      label922:
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(null);
      break label531;
      label933:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString + "资料卡";
      break label628;
    }
  }
  
  public void b(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    if ((b()) && (MultiMsgManager.a().a())) {
      paramQQCustomMenu.a(2131305411, paramContext.getString(2131368039));
    }
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  protected boolean b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (a(paramChatMessage, paramBaseChatItemLayout))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return true;
    }
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    return false;
  }
  
  public void c() {}
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    Object localObject1 = TroopBusinessUtil.a(localChatMessage);
    if (localObject1 != null)
    {
      TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TroopBusinessUtil.TroopBusinessMessage)localObject1);
      paramView = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_c_of_type_JavaLangString;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, localChatMessage.frienduin, "", paramView, "");
      if (localChatMessage.msgtype != 63485) {}
    }
    while ((localChatMessage == null) || (localChatMessage.istroop != 1) || (!Utils.c(localChatMessage.senderuin))) {
      try
      {
        paramView = (MessageForQQStory)localChatMessage;
        paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.msgAction);
        QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_name", paramView, false);
        return;
      }
      catch (Exception paramView)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramView);
        return;
      }
    }
    localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if (localObject1 != null) {}
    for (localObject1 = ((HotChatManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString); localObject1 != null; localObject1 = null)
    {
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin, paramView.getContext(), 2, localChatMessage.frienduin);
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800638A");
      return;
    }
    localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int i;
    label293:
    Object localObject3;
    if ((localObject1 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject1).troopPrivilegeFlag, 32))) {
      if (((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        i = 0;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_name", 0, 0, ((TroopInfo)localObject1).troopuin + "", i + "", "", "");
        localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin, ((TroopInfo)localObject1).troopuin, 1, 0);
        if (paramView.getId() != 2131296320) {
          break label737;
        }
        i = 2;
        localObject1 = "Clk_label";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = Base64.encodeToString(((String)localObject3).getBytes("UTF-8"), 0);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("http://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
        ((StringBuilder)localObject3).append("gc=").append(localChatMessage.frienduin).append("&");
        ((StringBuilder)localObject3).append("uin=").append(localChatMessage.senderuin).append("&");
        ((StringBuilder)localObject3).append("nick=").append((String)localObject2).append("&");
        ((StringBuilder)localObject3).append("type=").append(i).append("&");
        ((StringBuilder)localObject3).append("from=").append("aio").append("&");
        ((StringBuilder)localObject3).append("_wv=").append("1031");
        localObject2 = ((StringBuilder)localObject3).toString();
        paramView = paramView.getContext();
        localObject3 = new Intent(paramView, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        paramView.startActivity((Intent)localObject3);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:" + (String)localObject2);
        }
        if (this.h < 2) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(this.h), "", "");
        return;
        if (((TroopInfo)localObject1).isAdmin())
        {
          i = 1;
          break label293;
        }
        i = 2;
        break label293;
        label737:
        i = 1;
        localObject1 = "Clk_name";
        continue;
      }
      catch (Exception localException)
      {
        Object localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:", localException);
        localObject2 = localObject3;
        continue;
      }
      if (this.d)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick, openLevelPKPage");
        }
        localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", "http://qinfo.clt.qq.com/qlevel/faq.html?_bid=125#gc=" + localChatMessage.frienduin + "&target=" + localChatMessage.senderuin);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        paramView.getContext().startActivity((Intent)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
      }
    }
  }
  
  public void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage));
  }
  
  protected boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131364717, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (a()) {}
    while ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {
      return;
    }
    AIOUtils.l = true;
    switch (paramView.getId())
    {
    case 2131296319: 
    case 2131296322: 
    case 2131296326: 
    default: 
      return;
    case 2131296318: 
      b(paramView);
      return;
    case 2131296327: 
      a(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\BaseBubbleBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */