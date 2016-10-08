package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class ArkAppItemBubbleBuilder
  extends BaseBubbleBuilder
{
  private static final int h = BaseChatItemLayout.k;
  private static final int i = BaseChatItemLayout.l;
  private static final int j = BaseChatItemLayout.m;
  private static final int k = BaseChatItemLayout.n;
  private Context b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArkAppItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 3;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForArkApp)paramChatMessage;
    paramChatMessage = new ArkAppMessage.Config();
    paramChatMessage.fromString(paramBaseChatItemLayout.ark_app_message.config);
    if ((paramChatMessage.autoSize != null) && (paramChatMessage.autoSize.intValue() == 1)) {}
    for (int m = 1;; m = 0)
    {
      View localView;
      ArkContainerWrapper localArkContainerWrapper;
      QQAppInterface localQQAppInterface;
      Context localContext;
      String str1;
      String str2;
      String str3;
      String str4;
      float f;
      SessionInfo localSessionInfo;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2130903165, null);
        paramView.findViewById(2131297442).setPadding(0, 0, 0, 0);
        localView = paramView.findViewById(2131297444);
        paramChatMessage = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        paramChatMessage.setMargins(5, 5, 5, 5);
        localView.setLayoutParams(paramChatMessage);
        paramChatMessage = new ArkAppItemBubbleBuilder.ViewData();
        paramChatMessage.jdField_a_of_type_AndroidViewView = localView;
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView = ((ArkUIView)paramView.findViewById(2131297443));
        paramView.setTag(paramChatMessage);
        paramChatMessage = paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView;
        paramChatMessage.setClipRadius(14.0F);
        if (paramBaseChatItemLayout.arkContainer == null) {
          paramBaseChatItemLayout.arkContainer = new ArkContainerWrapper();
        }
        localView = paramView.findViewById(2131297444);
        localArkContainerWrapper = paramBaseChatItemLayout.arkContainer;
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localContext = this.jdField_b_of_type_AndroidContentContext;
        str1 = paramBaseChatItemLayout.ark_app_message.appName;
        str2 = paramBaseChatItemLayout.ark_app_message.appView;
        str3 = paramBaseChatItemLayout.ark_app_message.appMinVersion;
        str4 = paramBaseChatItemLayout.ark_app_message.metaList;
        f = this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity;
        localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if (m == 0) {
          break label419;
        }
      }
      label419:
      for (m = BaseChatItemLayout.i;; m = BaseChatItemLayout.h)
      {
        localArkContainerWrapper.a(localQQAppInterface, localContext, str1, str2, str3, str4, f, paramBaseChatItemLayout, localSessionInfo, m);
        paramChatMessage.a(paramBaseChatItemLayout.arkContainer, localView);
        paramViewHolder = (ArkAppItemBubbleBuilder.Holder)paramViewHolder;
        paramViewHolder.a = paramBaseChatItemLayout.msg;
        paramChatMessage.setTag(paramViewHolder);
        paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
        if (localView != null)
        {
          localView.setOnTouchListener(paramOnLongClickAndTouchListener);
          localView.setOnLongClickListener(paramOnLongClickAndTouchListener);
        }
        if (jdField_b_of_type_Boolean)
        {
          if ((paramViewHolder.b != null) && (paramViewHolder.b.length() > 0)) {
            paramViewHolder.b.setLength(0);
          }
          paramViewHolder = a(paramBaseChatItemLayout);
          paramView.setContentDescription(paramViewHolder);
          paramChatMessage.setContentDescription(paramViewHolder);
        }
        return paramView;
        paramChatMessage = (ArkAppItemBubbleBuilder.ViewData)paramView.getTag();
        break;
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppItemBubbleBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if ((localMessageForArkApp.ark_app_message == null) || (localMessageForArkApp.ark_app_message.promptText == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_b_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    localStringBuilder.append(localMessageForArkApp.ark_app_message.promptText);
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
    case 2131297425: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      paramChatMessage = new Bundle();
      paramChatMessage.putInt("forward_type", 27);
      paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
      paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
      paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
      paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
      paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
      paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
      paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
      paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
      paramContext = new Intent();
      paramContext.putExtras(paramChatMessage);
      ForwardBaseOption.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramContext, 21);
      return;
      ChatActivityFacade.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(k, h, j, i);
      return;
    }
    paramView.setPadding(j, h, k, i);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
        localConfig.fromString(paramView.ark_app_message.config);
        if ((localConfig.forward != null) && (localConfig.forward.intValue() > 0))
        {
          paramView = (Boolean)ArkAppCenterCheckEvent.a(0, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
          if ((paramView != null) && (paramView.booleanValue())) {
            localQQCustomMenu.a(2131297425, this.jdField_b_of_type_AndroidContentContext.getString(2131369281));
          }
        }
      }
    }
    localQQCustomMenu.a(2131305401, this.jdField_b_of_type_AndroidContentContext.getString(2131367892));
    return localQQCustomMenu.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ArkAppItemBubbleBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */