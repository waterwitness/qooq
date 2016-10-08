package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import nny;
import nnz;
import noa;
import nob;
import noc;
import nod;
import org.json.JSONException;
import org.json.JSONObject;

public class ReplyTextItemBuilder
  extends TextItemBuilder
{
  public static final String b = "cover";
  public static final String c = "summary";
  public static final String d = "title";
  public static final String e = "jump";
  public static final int h = 0;
  public static final int i = 1;
  protected View.OnClickListener a;
  protected nod a;
  private View.OnClickListener c;
  
  public ReplyTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Nod = new nod(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nny(this);
    this.c = new nnz(this);
  }
  
  public static final TextView a(Context paramContext)
  {
    ETTextView localETTextView = new ETTextView(paramContext);
    localETTextView.setTextColor(paramContext.getResources().getColorStateList(2131428272));
    localETTextView.setLinkTextColor(paramContext.getResources().getColorStateList(2131428271));
    ImmersiveUtils.a(localETTextView, 0.5F);
    localETTextView.setTextSize(1, 14.0F);
    localETTextView.setEditableFactory(QQTextBuilder.a);
    localETTextView.setSpannableFactory(QQText.a);
    localETTextView.setMaxWidth(BaseChatItemLayout.h);
    localETTextView.setLineSpacing(AIOUtils.a(2.0F, paramContext.getResources()), 1.0F);
    int j = BaseChatItemLayout.r;
    int k = BaseChatItemLayout.s;
    localETTextView.setPadding(j, BaseChatItemLayout.p, k, BaseChatItemLayout.q);
    return localETTextView;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt);
    int j = paramQQAppInterface.size();
    paramInt = 0;
    while (paramInt < j)
    {
      paramString = (ChatMessage)paramQQAppInterface.get(paramInt);
      if (paramString.shmsgseq == paramLong)
      {
        if (!paramString.mIsParsed) {
          paramString.parse();
        }
        return paramString;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, TextView paramTextView, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, long paramLong)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName)) {
      localObject = paramSourceMsgInfo.mAnonymousNickName;
    }
    for (;;)
    {
      if ((paramTextView instanceof ETTextView)) {
        ((ETTextView)paramTextView).setFont(0, paramLong);
      }
      String str = TimeFormatterUtils.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        break;
      }
      paramContext = paramSourceMsgInfo.mSourceMsgText;
      paramContext = (String)localObject + " " + str + "\r\n " + paramContext;
      paramTextView.setText(new QQText("“" + paramContext, 7));
      return;
      if ((paramSourceMsgInfo.mSourceMsgSenderUin == 50000000L) || (paramSourceMsgInfo.mSourceMsgSenderUin == 1000000L))
      {
        localObject = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgSeq);
        if (localObject != null)
        {
          localObject = TroopBusinessUtil.a((MessageRecord)localObject);
          if (localObject != null) {
            paramSourceMsgInfo.mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject).c;
          }
        }
        localObject = "";
      }
      else
      {
        localObject = ContactUtils.e(paramQQAppInterface, paramString, paramSourceMsgInfo.mSourceMsgSenderUin + "");
      }
    }
    paramContext = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgSeq);
    if (paramContext != null)
    {
      paramQQAppInterface = ((ChatMessage)paramContext).getSummaryMsg();
      paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
      paramSourceMsgInfo.mSourceSummaryFlag = 1;
    }
    for (;;)
    {
      paramContext = paramQQAppInterface;
      if (paramQQAppInterface != null) {
        break;
      }
      paramContext = paramSourceMsgInfo.mSourceMsgText;
      break;
      paramQQAppInterface = null;
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      paramBaseChatItemLayout = (noc)paramView.getTag();
      this.jdField_a_of_type_Nod.a(paramBaseChatItemLayout.jdField_d_of_type_Int, paramView);
    }
    paramBaseChatItemLayout = (noc)paramViewHolder;
    int k;
    int j;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "text.mSourceMsgInfo为null, text:" + localMessageForReplyText.toString());
      }
      paramViewHolder = this.jdField_a_of_type_Nod.a(0);
      if (paramViewHolder != null) {
        break label2305;
      }
      paramViewHolder = new LinearLayout((Context)localObject1);
      paramViewHolder.setOrientation(1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = a((Context)localObject1);
      paramViewHolder.addView(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView);
      paramViewHolder.setPadding(0, 0, 0, 0);
      paramView = new ETTextView((Context)localObject1);
      paramView.setTextColor(((Context)localObject1).getResources().getColorStateList(2131428272));
      paramView.setLinkTextColor(((Context)localObject1).getResources().getColorStateList(2131428271));
      paramView.setEditableFactory(QQTextBuilder.a);
      paramView.setSpannableFactory(QQText.a);
      paramView.setMaxWidth(BaseChatItemLayout.h);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      k = BaseChatItemLayout.r;
      j = BaseChatItemLayout.s;
      if (paramChatMessage.isSend())
      {
        k = BaseChatItemLayout.s;
        j = BaseChatItemLayout.r;
      }
      paramView.setPadding(k, BaseChatItemLayout.p, j, BaseChatItemLayout.q);
      paramView.setId(2131297486);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView = paramView;
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = AIOUtils.a(5.0F, ((Context)localObject1).getResources());
      paramViewHolder.addView(paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView, paramView);
      ((ETTextView)paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView).setFont(0, paramChatMessage.uniseq);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setText(localMessageForReplyText.sb);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage = paramViewHolder;
      if ((paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      }
    }
    for (paramChatMessage = paramViewHolder;; paramChatMessage = paramViewHolder)
    {
      label409:
      if (paramChatMessage != null) {
        paramChatMessage.setTag(paramBaseChatItemLayout);
      }
      return paramChatMessage;
      if ((localMessageForReplyText.mSourceMsgInfo.mType != 0) && (localMessageForReplyText.mSourceMsgInfo.mRichMsg != null)) {
        break;
      }
      paramBaseChatItemLayout.jdField_d_of_type_Int = 0;
      paramViewHolder = this.jdField_a_of_type_Nod.a(0);
      if (paramViewHolder != null) {
        break label2302;
      }
      paramViewHolder = new LinearLayout((Context)localObject1);
      paramViewHolder.setOrientation(1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = a((Context)localObject1);
      paramViewHolder.addView(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView);
      paramViewHolder.setPadding(0, 0, 0, 0);
      paramView = new ETTextView((Context)localObject1);
      paramView.setTextColor(((Context)localObject1).getResources().getColorStateList(2131428272));
      paramView.setLinkTextColor(((Context)localObject1).getResources().getColorStateList(2131428271));
      paramView.setEditableFactory(QQTextBuilder.a);
      paramView.setSpannableFactory(QQText.a);
      paramView.setMaxWidth(BaseChatItemLayout.h);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      k = BaseChatItemLayout.r;
      j = BaseChatItemLayout.s;
      if (paramChatMessage.isSend())
      {
        k = BaseChatItemLayout.s;
        j = BaseChatItemLayout.r;
      }
      paramView.setPadding(k, BaseChatItemLayout.p, j, BaseChatItemLayout.q);
      paramView.setId(2131297486);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView = paramView;
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = AIOUtils.a(5.0F, ((Context)localObject1).getResources());
      paramViewHolder.addView(paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView, paramView);
      label660:
      if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramView = ((ETTextView)paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView).a();
        if (paramView != null) {
          paramView.a = (paramChatMessage.uniseq + 1L);
        }
      }
      ((ETTextView)paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView).setFont(0, paramChatMessage.uniseq);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramChatMessage.senderuin)) && (localMessageForReplyText.mSourceMsgInfo.mLocalAtInfoDone == 0))
      {
        localMessageForReplyText.mSourceMsgInfo.mLocalAtInfoDone = 1;
        if ((localMessageForReplyText.atInfoList != null) && (localMessageForReplyText.atInfoList.size() > 0))
        {
          paramChatMessage = (MessageForText.AtTroopMemberInfo)localMessageForReplyText.atInfoList.remove(0);
          if (localMessageForReplyText.msg.length() > paramChatMessage.textLen + 1)
          {
            localMessageForReplyText.msg = localMessageForReplyText.msg.substring(paramChatMessage.textLen + 1);
            localMessageForReplyText.sb = new QQText(localMessageForReplyText.msg, 13, 32, localMessageForReplyText);
          }
        }
      }
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setText(localMessageForReplyText.sb);
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView, localMessageForReplyText.mSourceMsgInfo, localMessageForReplyText.frienduin, localMessageForReplyText.istroop, localMessageForReplyText.uniseq);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if ((paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      }
    }
    if (localMessageForReplyText.mSourceMsgInfo.mType == 1)
    {
      paramBaseChatItemLayout.jdField_d_of_type_Int = 1;
      paramView = this.jdField_a_of_type_Nod.a(localMessageForReplyText.mSourceMsgInfo.mType);
      paramViewHolder = paramView;
      if (paramView == null) {
        paramViewHolder = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903927, null);
      }
      paramBaseChatItemLayout.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewHolder);
      j = BaseChatItemLayout.r;
      k = BaseChatItemLayout.s;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.s;
        k = BaseChatItemLayout.r;
        label1124:
        paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewHolder.findViewById(2131300680));
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131298138));
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297437));
        paramBaseChatItemLayout.c = ((TextView)paramViewHolder.findViewById(2131297013));
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131299896));
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(148.0F, paramViewHolder.getResources()));
        paramBaseChatItemLayout.c.setMaxWidth(AIOUtils.a(148.0F, paramViewHolder.getResources()));
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setEditableFactory(QQTextBuilder.a);
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setSpannableFactory(QQText.a);
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(BaseChatItemLayout.h);
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.c);
        paramBaseChatItemLayout.c.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.c.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.c.setOnClickListener(this.c);
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.c);
        paramBaseChatItemLayout.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_b_of_type_AndroidViewViewGroup.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this.c);
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setPadding(j, 0, k, BaseChatItemLayout.q);
        paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setPadding(j, BaseChatItemLayout.p, k, BaseChatItemLayout.q);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(localMessageForReplyText.mSourceMsgInfo.mRichMsg);
        localObject1 = ((JSONObject)localObject2).optString("cover");
        paramView = ((JSONObject)localObject2).optString("title");
        paramOnLongClickAndTouchListener = ((JSONObject)localObject2).optString("summary");
        localObject2 = ((JSONObject)localObject2).optString("jump");
        paramBaseChatItemLayout.jdField_b_of_type_AndroidViewViewGroup.setTag(localObject2);
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setTag(localObject2);
        paramBaseChatItemLayout.c.setTag(localObject2);
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setTag(localObject2);
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
        if (HttpUtil.a((String)localObject1))
        {
          j = AIOUtils.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          k = AIOUtils.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = j;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = k;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = paramChatMessage;
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
        if ((paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
          ((AnimationTextView)paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
        }
        localObject1 = new Rect();
        k = AIOUtils.a(148.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (TextUtils.isEmpty(paramView)) {
          break label2308;
        }
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramView, 0, paramView.length(), (Rect)localObject1);
        if (((Rect)localObject1).width() <= k) {
          break label2100;
        }
        j = 2;
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setLines(2);
        if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener))
        {
          paramBaseChatItemLayout.c.getPaint().getTextBounds(paramOnLongClickAndTouchListener, 0, paramOnLongClickAndTouchListener.length(), (Rect)localObject1);
          if (((Rect)localObject1).width() <= k) {
            break label2127;
          }
          if (j != 2) {
            break label2115;
          }
          paramBaseChatItemLayout.c.setLines(1);
        }
        if (!TextUtils.isEmpty(paramView)) {
          break label2139;
        }
        paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener)) {
          break label2160;
        }
        paramBaseChatItemLayout.c.setVisibility(8);
        if (TextUtils.isEmpty(localMessageForReplyText.mSourceMsgInfo.mAnonymousNickName)) {
          break label2182;
        }
        paramView = localMessageForReplyText.mSourceMsgInfo.mAnonymousNickName;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramChatMessage.senderuin)) && (localMessageForReplyText.mSourceMsgInfo.mLocalAtInfoDone == 0))
        {
          localMessageForReplyText.mSourceMsgInfo.mLocalAtInfoDone = 1;
          if ((localMessageForReplyText.atInfoList != null) && (localMessageForReplyText.atInfoList.size() > 0))
          {
            paramChatMessage = (MessageForText.AtTroopMemberInfo)localMessageForReplyText.atInfoList.remove(0);
            if (localMessageForReplyText.msg.length() > paramChatMessage.textLen + 1)
            {
              localMessageForReplyText.msg = localMessageForReplyText.msg.substring(paramChatMessage.textLen + 1);
              localMessageForReplyText.sb = new QQText(localMessageForReplyText.msg, 13, 32, localMessageForReplyText);
            }
          }
        }
        paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setText(new QQText("回复" + paramView + ":" + localMessageForReplyText.msg, 13));
        paramChatMessage = paramViewHolder;
      }
      catch (JSONException paramView)
      {
        paramChatMessage = paramViewHolder;
      }
      if (!QLog.isColorLevel()) {
        break label409;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramView.getMessage());
      paramChatMessage = paramViewHolder;
      break label409;
      label2100:
      j = 1;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setLines(1);
      continue;
      label2115:
      paramBaseChatItemLayout.c.setLines(2);
      continue;
      label2127:
      paramBaseChatItemLayout.c.setLines(1);
      continue;
      label2139:
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      continue;
      label2160:
      paramBaseChatItemLayout.c.setText(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.c.setVisibility(0);
      continue;
      label2182:
      if (localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
      {
        paramView = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForReplyText.frienduin, localMessageForReplyText.istroop, localMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
        if (paramView != null)
        {
          paramView = TroopBusinessUtil.a(paramView);
          if (paramView != null) {
            localMessageForReplyText.mSourceMsgInfo.mAnonymousNickName = paramView.c;
          }
        }
      }
      else
      {
        paramView = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForReplyText.frienduin, localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin + "");
        continue;
        break label1124;
        paramChatMessage = paramView;
        break label409;
        label2302:
        break label660;
        label2305:
        break;
        label2308:
        j = 0;
        continue;
      }
      paramView = "";
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new noc(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      paramContext = (MessageForReplyText)paramChatMessage;
      if (paramContext.sb != null) {}
      for (paramContext = paramContext.sb.toString();; paramContext = paramContext.msg)
      {
        localBundle.putString("forward_text", paramContext);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        return;
      }
      if (((MessageForReplyText)paramChatMessage).mSourceMsgInfo.mType != 1) {
        break;
      }
    } while ((c()) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
    ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(paramChatMessage, 1);
    return;
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131367889);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131367890);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new noa(this, paramView), new nob(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (noc)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if ((localMessageForReplyText.mSourceMsgInfo.mType == 0) || (localMessageForReplyText.mSourceMsgInfo.mRichMsg == null)) {
      if (paramChatMessage.isSend())
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setPadding(m, j, l, 0);
        paramView.jdField_d_of_type_AndroidWidgetTextView.setPadding(m, 0, l, k);
      }
    }
    while (localMessageForReplyText.mSourceMsgInfo.mType != 1)
    {
      return;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setPadding(l, j, m, 0);
      paramView.jdField_d_of_type_AndroidWidgetTextView.setPadding(l, 0, m, k);
      return;
    }
    if (paramChatMessage.isSend())
    {
      paramView.jdField_d_of_type_AndroidWidgetTextView.setPadding(m, 0, l, k);
      paramView.jdField_a_of_type_AndroidViewViewGroup.setPadding(m, j, l, 0);
      return;
    }
    paramView.jdField_d_of_type_AndroidWidgetTextView.setPadding(l, 0, m, k);
    paramView.jdField_a_of_type_AndroidViewViewGroup.setPadding(l, j, m, 0);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    noc localnoc = (noc)paramViewHolder;
    paramViewHolder = (MessageForReplyText)paramChatMessage;
    if (paramViewHolder.mSourceMsgInfo.mType == 0) {
      if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramViewHolder = paramView.getColorStateList(2131428275);
          localnoc.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          localnoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          if (!paramChatMessage.isSend()) {
            break label129;
          }
          paramViewHolder = paramView.getColorStateList(2131428274);
          localnoc.jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
          localnoc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
          ImmersiveUtils.a(localnoc.jdField_a_of_type_AndroidWidgetTextView, 0.5F);
        }
      }
    }
    label129:
    label247:
    while (paramViewHolder.mSourceMsgInfo.mType != 1)
    {
      for (;;)
      {
        return;
        paramViewHolder = paramView.getColorStateList(2131428272);
        continue;
        paramViewHolder = paramView.getColorStateList(2131428273);
      }
      if (paramBubbleInfo.jdField_d_of_type_Int == 0)
      {
        localnoc.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localnoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (paramBubbleInfo.e != 0) {
          break label247;
        }
        paramViewHolder = paramView.getResources().getColorStateList(2131428273);
        localnoc.jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        localnoc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      }
      for (;;)
      {
        ImmersiveUtils.a(localnoc.jdField_a_of_type_AndroidWidgetTextView, 0.5F);
        return;
        localnoc.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_d_of_type_Int);
        localnoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_d_of_type_Int);
        break;
        localnoc.jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.e);
        localnoc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.e);
      }
    }
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131428275);
        localnoc.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label377;
        }
      }
      label377:
      for (paramViewHolder = paramView.getColorStateList(2131428274);; paramViewHolder = paramView.getColorStateList(2131428273))
      {
        localnoc.jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        ImmersiveUtils.a(localnoc.jdField_a_of_type_AndroidWidgetTextView, 0.5F);
        return;
        paramViewHolder = paramView.getColorStateList(2131428272);
        break;
      }
    }
    if (paramBubbleInfo.jdField_d_of_type_Int == 0) {
      localnoc.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.e == 0)
    {
      paramViewHolder = paramView.getResources().getColorStateList(2131428273);
      localnoc.jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      return;
      localnoc.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_d_of_type_Int);
    }
    localnoc.jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.e);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ReplyTextItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */