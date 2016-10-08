package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import nnm;
import nnn;
import nno;

public class QQStoryItemBuilder
  extends BaseBubbleBuilder
{
  public View.OnClickListener a;
  protected float[] a;
  protected final float b;
  public Context b;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  
  public QQStoryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Float = 14.0F;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nnm(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 14.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f };
    this.h = Color.parseColor("#e1e1e5");
    this.i = Color.parseColor("#00000000");
    this.l = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 100.0F);
    this.m = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.j = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 124.0F);
    this.k = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 200.0F);
    this.n = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, JumpAction paramJumpAction, boolean paramBoolean)
  {
    int i1 = -1;
    int i2 = -1;
    String str1 = "";
    String str2 = "";
    if (paramInt == 0) {
      i1 = 1;
    }
    for (;;)
    {
      paramInt = i2;
      if (paramJumpAction != null) {}
      try
      {
        str1 = paramJumpAction.a("unionid");
        str2 = paramJumpAction.a("storyid");
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        try
        {
          paramInt = Integer.valueOf(paramJumpAction.a("contentType")).intValue();
          if (paramBoolean) {}
          for (paramJumpAction = "1";; paramJumpAction = "2")
          {
            ReportController.b(paramQQAppInterface, "dc00899", "grp_story", "", "share_obj", paramString, i1, paramInt, str1, str2, paramJumpAction, "");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.qqstory.share", 2, "reportClickEvent: opName=" + paramString + ", fromType=" + i1 + ", result=" + paramInt + ", extra1=" + str1 + ", extra2=" + str2 + ", extra3=" + paramJumpAction);
            return;
          }
          paramQQAppInterface = paramQQAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramQQAppInterface);
            return;
          }
        }
        catch (Exception paramJumpAction)
        {
          for (;;)
          {
            paramInt = i2;
          }
        }
      }
      if (paramInt == 1) {
        i1 = 2;
      } else if (paramInt == 3000) {
        i1 = 3;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramChatMessage = (MessageForQQStory)paramChatMessage;
    paramChatMessage.parse();
    paramViewGroup = (QQStoryItemBuilder.QQStoryMsgHolder)paramView.getTag();
    boolean bool = paramChatMessage.isSend();
    if (paramViewGroup.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(paramViewGroup, paramView, bool);
    }
    paramOnLongClickAndTouchListener = (FrameLayout.LayoutParams)paramViewGroup.b.getLayoutParams();
    if (bool) {}
    for (paramOnLongClickAndTouchListener.leftMargin = BaseChatItemLayout.n;; paramOnLongClickAndTouchListener.leftMargin = (DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10.0F) + BaseChatItemLayout.m))
    {
      paramViewGroup.b.setLayoutParams(paramOnLongClickAndTouchListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage.brief);
      paramViewGroup.b.setText(paramChatMessage.srcName);
      paramOnLongClickAndTouchListener = new GradientDrawable();
      paramOnLongClickAndTouchListener.setShape(0);
      paramOnLongClickAndTouchListener.setColor(paramChatMessage.briefBgColor);
      paramOnLongClickAndTouchListener.setCornerRadii(this.jdField_a_of_type_ArrayOfFloat);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramOnLongClickAndTouchListener);
      try
      {
        paramOnLongClickAndTouchListener = new ColorDrawable(this.h);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramOnLongClickAndTouchListener);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = paramOnLongClickAndTouchListener;
        localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
        localURLDrawableOptions.mRequestWidth = this.j;
        localURLDrawableOptions.mRequestHeight = this.k;
        paramOnLongClickAndTouchListener = URLDrawable.getDrawable(paramChatMessage.coverImgUrl, localURLDrawableOptions);
        if (paramOnLongClickAndTouchListener.getStatus() == 2) {
          paramOnLongClickAndTouchListener.restartDownload();
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramOnLongClickAndTouchListener);
      }
      catch (Exception paramOnLongClickAndTouchListener)
      {
        for (;;)
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          label360:
          label387:
          label408:
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.share", 2, "getView exp:" + paramOnLongClickAndTouchListener.toString());
          }
        }
      }
      for (;;)
      {
        try
        {
          paramOnLongClickAndTouchListener = new ColorDrawable(this.i);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramOnLongClickAndTouchListener);
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = paramOnLongClickAndTouchListener;
          localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
          localURLDrawableOptions.mRequestWidth = this.l;
          localURLDrawableOptions.mRequestHeight = this.m;
          paramOnLongClickAndTouchListener = URLDrawable.getDrawable(paramChatMessage.logoImgUrl, localURLDrawableOptions);
          if (paramOnLongClickAndTouchListener.getStatus() == 2) {
            paramOnLongClickAndTouchListener.restartDownload();
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramOnLongClickAndTouchListener);
        }
        catch (Exception paramViewGroup)
        {
          if (!QLog.isColorLevel()) {
            break label360;
          }
          QLog.w("Q.qqstory.share", 2, "getView exp:" + paramViewGroup.toString());
          break label360;
          bool = false;
          break label387;
        }
        try
        {
          paramViewGroup = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramChatMessage.msgAction);
          if (TroopBusinessUtil.a(paramChatMessage) != null) {
            continue;
          }
          bool = true;
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "exp", paramViewGroup, bool);
        }
        catch (Exception paramChatMessage)
        {
          if (!QLog.isColorLevel()) {
            break label408;
          }
          QLog.w("Q.qqstory.share", 2, "getView report exp:", paramChatMessage);
        }
      }
      return paramView;
    }
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (QQStoryItemBuilder.QQStoryMsgHolder)paramViewHolder;
    boolean bool = paramChatMessage.isSend();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2130903179, paramBaseChatItemLayout, false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131296328));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297541));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297540));
      paramViewHolder.d = ((ImageView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297539));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.j, this.k);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(14.0F);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(true);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, 0);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramView.setShape(0);
      float f = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 14.0F);
      paramView.setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      paramView.setGradientType(0);
      paramViewHolder.d.setBackgroundDrawable(paramView);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      int i1 = this.j;
      int i2 = BaseChatItemLayout.n;
      int i3 = BaseChatItemLayout.m;
      int i4 = this.k;
      int i5 = BaseChatItemLayout.k;
      int i6 = this.n;
      paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.width = (i3 + (i1 + i2));
      paramView.height = (i6 + (i4 + i5));
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b != bool)
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b = bool;
      if (VersionUtils.e()) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.j, this.k);
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    if (!bool)
    {
      paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramView.leftMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10.0F);
      paramView.rightMargin = 0;
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.leftMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10 + 10.0F);
      paramView.rightMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)paramViewHolder.d.getLayoutParams();
      paramView.leftMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10.0F);
      paramView.rightMargin = 0;
      paramViewHolder.d.setLayoutParams(paramView);
      return paramChatMessage;
    }
    paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramView.leftMargin = 0;
    paramView.rightMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10.0F);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
    paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramView.leftMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10);
    paramView.rightMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10 + 10.0F);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    paramView = (RelativeLayout.LayoutParams)paramViewHolder.d.getLayoutParams();
    paramView.leftMargin = 0;
    paramView.rightMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10.0F);
    paramViewHolder.d.setLayoutParams(paramView);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QQStoryItemBuilder.QQStoryMsgHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return ((MessageForQQStory)paramChatMessage).getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForQQStory localMessageForQQStory = (MessageForQQStory)paramChatMessage;
    boolean bool;
    if (TroopBusinessUtil.a(paramChatMessage) == null) {
      bool = true;
    }
    JumpAction localJumpAction2;
    try
    {
      for (;;)
      {
        JumpAction localJumpAction1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
        switch (paramInt)
        {
        default: 
          super.a(paramInt, paramContext, paramChatMessage);
          return;
          bool = false;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "onMenuItemClicked exp:", localException);
        }
        localJumpAction2 = null;
      }
      ChatActivityFacade.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "delete", localJumpAction2, bool);
      return;
    }
    paramContext = new Bundle();
    if ((localMessageForQQStory.structingMsg.source_puin != null) && (!"".equals(localMessageForQQStory.structingMsg.source_puin))) {
      paramContext.putString("source_puin", localMessageForQQStory.structingMsg.source_puin);
    }
    paramContext.putInt("forward_type", 28);
    localMessageForQQStory.structingMsg.mCommentText = null;
    paramContext.putInt("structmsg_service_id", localMessageForQQStory.structingMsg.mMsgServiceID);
    paramContext.putByteArray("stuctmsg_bytes", localMessageForQQStory.structingMsg.getBytes());
    paramContext.putLong("structmsg_uniseq", localMessageForQQStory.uniseq);
    paramContext.putInt("accostType", localMessageForQQStory.structingMsg.sourceAccoutType);
    paramChatMessage = new Intent();
    paramChatMessage.putExtras(paramContext);
    ForwardBaseOption.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "forward", localJumpAction2, bool);
    return;
    super.a(paramChatMessage);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "withdraw", localJumpAction2, bool);
    return;
    super.a(paramInt, paramContext, paramChatMessage);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "reply", localJumpAction2, bool);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    Object localObject = AIOUtils.a(paramView);
    if (!QQStoryItemBuilder.QQStoryMsgHolder.class.isInstance(localObject)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = this.jdField_b_of_type_AndroidContentContext;
      localObject = ((QQStoryItemBuilder.QQStoryMsgHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      str1 = paramView.getString(2131367889);
      str2 = paramView.getString(2131367890);
    } while (!((ChatMessage)localObject).isSendFromLocal());
    DialogUtil.a(paramView, 230, str1, str2, new nnn(this, paramView, (ChatMessage)localObject), new nno(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.n, BaseChatItemLayout.k, BaseChatItemLayout.m, this.n);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.m, BaseChatItemLayout.k, BaseChatItemLayout.n, this.n);
  }
  
  protected void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject).setBackgroundResource(2130839487);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131427407));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, localLayoutParams);
    paramQQStoryMsgHolder.b = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131296328);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131296328);
    paramViewGroup.addView(paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    boolean bool;
    if (TroopBusinessUtil.a(paramView) == null) {
      bool = true;
    }
    for (;;)
    {
      localQQCustomMenu.a(2131297425, this.jdField_b_of_type_AndroidContentContext.getString(2131369281));
      a(paramView, localQQCustomMenu);
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
      }
      try
      {
        paramView = (MessageForQQStory)paramView;
        paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramView.msgAction);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "press", paramView, bool);
        return localQQCustomMenu.a();
        bool = false;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.share", 2, "getMenuItem exp:", paramView);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\QQStoryItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */