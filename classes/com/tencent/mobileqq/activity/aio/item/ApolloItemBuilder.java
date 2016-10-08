package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import nhn;
import nho;
import nhp;
import nhq;
import nhr;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  public static final String b = "ApolloItemBuilder";
  public static final String c = "apollo_gif";
  private long jdField_a_of_type_Long;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  protected View.OnClickListener a;
  private AnimationDrawable jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new nhq(this);
  public boolean d = true;
  private boolean e;
  private int h = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Float = 12.0F * (DeviceInfoUtil.d() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nhr(this);
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837707), 200);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837708), 100);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837709), 200);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837708), 100);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837707), 300);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837710), 100);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837711), 200);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837710), 140);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.selectDrawable(0);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
      return this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837702), 200);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837703), 100);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837704), 200);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837703), 100);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837702), 300);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837705), 100);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837706), 200);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837705), 140);
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.selectDrawable(0);
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
    return this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable;
  }
  
  private QQProgressDialog a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  public static void a(Context paramContext, View paramView, MessageForApollo paramMessageForApollo, SessionInfo paramSessionInfo)
  {
    if (paramMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = AnimationUtils.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)))
    {
      int i = ((FragmentActivity)paramContext).getChatFragment().a().f();
      paramView.putInt("extra.AIO_CURRENT_PANEL_STATE", i);
      if (i == 1)
      {
        localObject = (InputMethodManager)paramContext.getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).toggleSoftInput(1, 0);
        }
      }
    }
    paramView.putBoolean("IS_APP_SHARE_PIC", true);
    paramView.putBoolean("extra.IS_FROM_MULTI_MSG", true);
    paramView.putBoolean("extra.IS_APOLLO", true);
    paramView.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localObject = new ApolloActionData();
    ((ApolloActionData)localObject).actionId = paramMessageForApollo.mApolloMessage.id;
    paramSessionInfo = new AIOImageData();
    paramSessionInfo.f = paramMessageForApollo.uniseq;
    paramSessionInfo.jdField_a_of_type_JavaLangString = ApolloUtil.a((ApolloActionData)localObject, 0);
    localObject = ApolloItemBuilder.ApolloGifDownloader.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    PeakUtils.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.a(new nhn(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new nho(paramContext, paramInt, paramString));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if (this.e) {
      return 1;
    }
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (ApolloItemBuilder.Holder)paramChatMessage.getTag();
    if (this.e)
    {
      if (paramView.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return paramChatMessage;
    }
    paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramView.jdField_b_of_type_AndroidWidgetTextView == null)
    {
      paramOnLongClickAndTouchListener = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setSingleLine(true);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setPadding(AIOUtils.a(5.0F, paramViewGroup), 0, AIOUtils.a(5.0F, paramViewGroup), 0);
      localTextView.setBackgroundResource(2130839487);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(5, 2131296328);
      localLayoutParams.addRule(3, 2131296328);
      localLayoutParams.topMargin = AIOUtils.a(-3.0F, paramViewGroup);
      localLayoutParams.leftMargin = AIOUtils.a(12.0F, paramViewGroup);
      paramView.jdField_b_of_type_AndroidWidgetTextView = localTextView;
      paramOnLongClickAndTouchListener.addView(localTextView, localLayoutParams);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    paramView.jdField_b_of_type_AndroidWidgetTextView.setText("厘米秀");
    paramOnLongClickAndTouchListener = paramViewGroup.getDrawable(2130837733);
    paramOnLongClickAndTouchListener.setBounds(0, 0, paramOnLongClickAndTouchListener.getIntrinsicWidth(), paramOnLongClickAndTouchListener.getIntrinsicHeight());
    paramView.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramOnLongClickAndTouchListener, null, null, null);
    paramView.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, paramViewGroup), 0, AIOUtils.a(5.0F, paramViewGroup), 0);
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ApolloManager localApolloManager;
    boolean bool;
    label95:
    label101:
    int i;
    label703:
    label857:
    long l;
    if ((paramChatMessage != null) && (paramChatMessage.istroop != 0) && (paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000))
    {
      this.e = false;
      localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if (this.e)
      {
        ApolloBaseInfo localApolloBaseInfo = localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
        if (localApolloBaseInfo == null) {
          break label1164;
        }
        this.h = localApolloBaseInfo.apolloStatus;
        if (this.h != 1) {
          break label1158;
        }
        bool = true;
        this.e = bool;
      }
      paramBaseChatItemLayout.getContext();
      paramViewHolder = (ApolloItemBuilder.Holder)paramViewHolder;
      if ((paramView == null) || (paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
      {
        paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setId(2131296426);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = paramView;
      }
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if (!this.e) {
        break label1337;
      }
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        paramBaseChatItemLayout = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.setId(2131296427);
        paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
        paramOnLongClickAndTouchListener.addRule(7, 2131296426);
        paramBaseChatItemLayout.setLayoutParams(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.setScaleType(ImageView.ScaleType.CENTER);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramBaseChatItemLayout);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = paramBaseChatItemLayout;
      }
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        paramBaseChatItemLayout = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.setMaxWidth(BaseChatItemLayout.i);
        paramBaseChatItemLayout.setMinWidth(AIOUtils.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramBaseChatItemLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramBaseChatItemLayout);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = paramBaseChatItemLayout;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
      paramViewHolder.f = 0;
      if (paramViewHolder.jdField_a_of_type_AndroidTextStyleImageSpan == null)
      {
        paramBaseChatItemLayout = new ColorDrawable(0);
        paramBaseChatItemLayout.setBounds(0, 0, AIOUtils.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramViewHolder.jdField_a_of_type_AndroidTextStyleImageSpan = new ApolloItemBuilder.VerticalImageSpan(this, paramBaseChatItemLayout);
      }
      if (paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
        paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      int k = BaseChatItemLayout.r;
      int j = BaseChatItemLayout.s;
      i = BaseChatItemLayout.r;
      if (paramChatMessage.isSend())
      {
        k = BaseChatItemLayout.s;
        j = BaseChatItemLayout.r;
        i = BaseChatItemLayout.s;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, BaseChatItemLayout.p, j, BaseChatItemLayout.q);
      paramBaseChatItemLayout = (ViewGroup.MarginLayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.setMargins(k, BaseChatItemLayout.p, 0, 0);
      paramBaseChatItemLayout.width = AIOUtils.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.height = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      paramChatMessage = (MessageForApollo)paramChatMessage;
      if (paramChatMessage.mApolloMessage != null)
      {
        if ((paramChatMessage.mApolloMessage.name != null) && (paramChatMessage.mApolloMessage.name.length > 0)) {
          paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(new String(paramChatMessage.mApolloMessage.name));
        }
        if ((!paramChatMessage.isDoubleAction()) || (paramChatMessage.mApolloMessage.text == null) || (paramChatMessage.mApolloMessage.text.length <= 0)) {
          break label1172;
        }
        paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramChatMessage.mApolloMessage.text));
        if (!TextUtils.isEmpty(paramChatMessage.inputText)) {
          paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramChatMessage.inputText);
        }
        paramViewHolder.d = paramChatMessage.mApolloMessage.id;
      }
      paramView.setContentDescription("动作消息" + paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
      paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
      paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramViewHolder.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(paramChatMessage, paramViewHolder, ApolloMsgPlayController.a().a(paramChatMessage.uniseq));
      if ((paramChatMessage.isSend()) || (!ApolloManager.b.contains(Long.valueOf(paramChatMessage.uniseq)))) {
        break label1203;
      }
      ApolloManager.b.remove(Long.valueOf(paramChatMessage.uniseq));
      a(paramViewHolder, 1);
      if (!paramChatMessage.isSend())
      {
        paramBaseChatItemLayout = localApolloManager.b(paramChatMessage.senderuin);
        if (paramBaseChatItemLayout == null) {
          break label1242;
        }
        l = paramBaseChatItemLayout.apolloUpdateTime;
        label887:
        if (NetConnInfoCenter.getServerTime() - l <= 43200L) {
          break label1248;
        }
        localApolloManager.a(paramChatMessage.senderuin, 2);
      }
      label910:
      if ((paramChatMessage.mApolloMessage != null) && (paramChatMessage.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramChatMessage.mApolloMessage.peer_uin + "")))
      {
        paramBaseChatItemLayout = localApolloManager.b(paramChatMessage.mApolloMessage.peer_uin + "");
        if (paramBaseChatItemLayout == null) {
          break label1289;
        }
        l = paramBaseChatItemLayout.apolloUpdateTime;
        label1008:
        if (NetConnInfoCenter.getServerTime() - l <= 43200L) {
          break label1295;
        }
        localApolloManager.a(paramChatMessage.mApolloMessage.peer_uin + "", 2);
      }
      label1053:
      if (paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView != null) {
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      if (paramViewHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label1158:
    label1164:
    label1172:
    label1203:
    label1242:
    label1248:
    label1289:
    label1295:
    label1337:
    do
    {
      return paramView;
      this.e = ApolloManager.a(this.jdField_a_of_type_AndroidContentContext);
      if ((!this.e) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) || (ApolloManager.c("discuss") != 0)) {
        break;
      }
      this.e = false;
      break;
      bool = false;
      break label95;
      this.e = false;
      break label101;
      if (TextUtils.isEmpty(paramChatMessage.inputText)) {
        break label703;
      }
      paramViewHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramChatMessage.inputText);
      break label703;
      if (paramViewHolder.jdField_b_of_type_Int != paramViewHolder.c - 1) {
        break label857;
      }
      if (paramChatMessage.isSend()) {}
      for (i = 0;; i = 1)
      {
        a(paramViewHolder, i);
        break;
      }
      l = 0L;
      break label887;
      if ((paramBaseChatItemLayout == null) || (1 != paramBaseChatItemLayout.apolloStatus) || (paramBaseChatItemLayout.apolloServerTS == paramBaseChatItemLayout.apolloLocalTS)) {
        break label910;
      }
      localApolloManager.a(paramChatMessage.senderuin, 1);
      break label910;
      l = 0L;
      break label1008;
      if ((paramBaseChatItemLayout == null) || (1 != paramBaseChatItemLayout.apolloStatus) || (paramBaseChatItemLayout.apolloServerTS == paramBaseChatItemLayout.apolloLocalTS)) {
        break label1053;
      }
      localApolloManager.a(paramBaseChatItemLayout.uin, 1);
      break label1053;
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        paramBaseChatItemLayout = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(AIOUtils.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramOnLongClickAndTouchListener.addRule(13);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView = paramBaseChatItemLayout;
      }
      if (paramViewHolder.jdField_b_of_type_AndroidWidgetImageView == null)
      {
        paramBaseChatItemLayout = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.setImageResource(2130838321);
        paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
        paramOnLongClickAndTouchListener.addRule(13);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = paramBaseChatItemLayout;
      }
      if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForApollo)))
      {
        paramChatMessage = (MessageForApollo)paramChatMessage;
        if (paramChatMessage.mApolloMessage != null) {
          paramViewHolder.d = paramChatMessage.mApolloMessage.id;
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramViewHolder.d));
      }
      paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      a(paramViewHolder, paramView.getResources(), false);
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ApolloItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "说" + paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForApollo))) {}
    do
    {
      do
      {
        do
        {
          return;
          paramContext = (MessageForApollo)paramChatMessage;
          switch (paramInt)
          {
          default: 
            return;
          case 2131296353: 
            super.a(paramChatMessage);
          }
        } while ((paramContext == null) || (paramContext.mApolloMessage == null));
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_withdraw", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(paramContext.mApolloMessage.id) });
        return;
        ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      } while ((paramContext == null) || (paramContext.mApolloMessage == null));
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_del", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(paramContext.mApolloMessage.id) });
      return;
    } while ((paramContext == null) || (paramContext.mApolloMessage == null));
    a(paramContext.mApolloMessage.id, paramContext);
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    Object localObject = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramInt);
    String str = paramMessageForApollo.inputText;
    if ((!TextUtils.isEmpty(str)) && (str.length() > 12)) {
      str = str.substring(0, 11) + "…";
    }
    for (;;)
    {
      if ((localObject != null) && (((ApolloActionData)localObject).feeType == 1))
      {
        localObject = new ApolloFavActionData();
        if (paramMessageForApollo.isBarrageMode()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          ((ApolloFavActionData)localObject).textType = paramInt;
          ((ApolloFavActionData)localObject).text = str;
          ((ApolloFavActionData)localObject).acitonId = paramMessageForApollo.mApolloMessage.id;
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (ApolloFavActionData)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          return;
        }
      }
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
      {
        a(this.jdField_a_of_type_AndroidContentContext.getString(2131372323), 1, this.jdField_a_of_type_AndroidContentContext);
        return;
      }
      localObject = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramMessageForApollo.isBarrageMode()) {}
      for (paramMessageForApollo = "1";; paramMessageForApollo = "0")
      {
        ((VasExtensionHandler)localObject).a(paramInt, str, paramMessageForApollo, "actionAdd");
        paramMessageForApollo = a();
        if (paramMessageForApollo == null) {
          break;
        }
        paramMessageForApollo.b(2131372316);
        paramMessageForApollo.show();
        return;
      }
    }
  }
  
  protected void a(View paramView)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      Object localObject = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      ActionSheet localActionSheet;
      ApolloActionData localApolloActionData;
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.z)
      {
        ((VasExtensionHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 1, "userClick");
        localObject = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        localApolloActionData = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramView.d);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != ApolloConstant.z) || (localObject == null) || (((ApolloBaseInfo)localObject).apolloVipFlag == 1)) {
          break label351;
        }
        localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372325));
        localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372328), 1);
        paramView.f = 1;
      }
      for (;;)
      {
        label236:
        localActionSheet.d(2131367262);
        localActionSheet.a(new nhp(this, paramView, localApolloActionData, localActionSheet));
        localActionSheet.show();
        label351:
        do
        {
          return;
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.C)
          {
            ((VasExtensionHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 128, "userClick");
            break;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.A)
          {
            ((VasExtensionHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 2, "userClick");
            break;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != ApolloConstant.B) {
            break;
          }
          ClubContentUpdateHandler.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.A) && (localApolloActionData != null) && (localObject != null) && (localApolloActionData.vipLevel < ((ApolloBaseInfo)localObject).apolloVipLevel))
          {
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372330));
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372333), 1);
            paramView.f = 2;
            break label236;
          }
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.C) && (localApolloActionData != null) && (localApolloActionData.limitFree == 0))
          {
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372335));
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372336), 1);
            paramView.f = 3;
            break label236;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.B)
          {
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372337));
            paramView.f = 4;
            break label236;
          }
        } while ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)));
        localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372338), 1);
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramInt1 == 1)
    {
      if (paramInt2 != 0) {
        break label59;
      }
      if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      ApolloManager.a.remove(Long.valueOf(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
    label59:
    ApolloManager localApolloManager;
    do
    {
      return;
      if (!ApolloManager.a.contains(Long.valueOf(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
        ApolloManager.a.add(Long.valueOf(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
      }
      localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    } while ((localApolloManager != null) && (localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramView != null) && (paramMessageForApollo != null))
    {
      ApolloManager.a.remove(Long.valueOf(paramMessageForApollo.uniseq));
      if (!paramMessageForApollo.hasPlayed) {
        ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
      if (!super.a(paramMessageForApollo, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      if ((paramView instanceof BaseChatItemLayout))
      {
        paramView = a(paramMessageForApollo.isSend());
        if (paramView != null)
        {
          localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo == null) || (localHolder.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131428275);
        if (paramViewHolder != null) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        if (!paramChatMessage.isSend()) {
          break label105;
        }
      }
      label105:
      for (paramViewHolder = paramView.getColorStateList(2131428274);; paramViewHolder = paramView.getColorStateList(2131428273))
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131428272);
        break;
      }
    }
    if (paramBubbleInfo.d == 0) {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.e == 0)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131428273));
      return;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.d);
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.e);
  }
  
  public void a(ApolloItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder = (MessageForApollo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((!paramHolder.hasPlayed) || (paramInt == 2))
    {
      ApolloMsgPlayParam localApolloMsgPlayParam = new ApolloMsgPlayParam();
      localApolloMsgPlayParam.jdField_a_of_type_Int = paramHolder.istroop;
      localApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramHolder;
      localApolloMsgPlayParam.jdField_b_of_type_Int = paramInt;
      ApolloMsgPlayController.a().a(localApolloMsgPlayParam);
    }
  }
  
  public void a(ApolloItemBuilder.Holder paramHolder, Resources paramResources, boolean paramBoolean)
  {
    if ((paramHolder == null) || (paramResources == null)) {
      return;
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      try
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mGifRoundCorner = jdField_b_of_type_Float;
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130837734);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130837735);
        if (!paramBoolean) {
          break label201;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramHolder.d));
        File localFile = new File(ApolloItemBuilder.ApolloGifDownloader.a(paramHolder.d));
        if (!localFile.exists()) {
          break label207;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramHolder.d + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramHolder) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramHolder.getMessage());
      return;
      label201:
      long l = 0L;
      continue;
      label207:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramHolder.d));
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  protected void a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (ApolloManager.a.contains(Long.valueOf(paramMessageForApollo.uniseq)))
    {
      localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if ((localObject != null) && (((ApolloManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) != 2)) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean)
    {
      localObject = a(paramMessageForApollo.isSend());
      if (localObject != null)
      {
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        ((AnimationDrawable)localObject).start();
      }
      ApolloManager.a.remove(Long.valueOf(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
      if (!paramMessageForApollo.hasPlayed) {
        ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      return;
    }
    paramHolder = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
    if (paramMessageForApollo.isSend()) {}
    for (int i = 2130837707;; i = 2130837702)
    {
      paramHolder.setImageResource(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131372315));
    paramView = AIOUtils.a(paramView);
    if ((paramView != null) && (paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
      a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if ((paramView instanceof MessageForApollo))
    {
      paramView = (MessageForApollo)paramView;
      if (paramView.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(paramView.mApolloMessage.id) });
      }
    }
    return localQQCustomMenu.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131296427);
      if (!paramMessageForApollo.isSend()) {
        break label38;
      }
    }
    label38:
    for (int i = 2130837707;; i = 2130837702)
    {
      paramView.setImageResource(i);
      return;
    }
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadSuccessed");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ApolloItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */