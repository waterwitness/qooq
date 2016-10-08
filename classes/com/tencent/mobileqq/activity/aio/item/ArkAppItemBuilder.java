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
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class ArkAppItemBuilder
  extends AbstractChatItemBuilder
{
  private int a;
  
  public ArkAppItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = BaseChatItemLayout.B;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForArkApp)paramMessageRecord;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903165, null);
      paramMessageRecord = new ArkAppItemBuilder.ViewData();
      paramMessageRecord.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297444);
      paramMessageRecord.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView = ((ArkUIView)paramView.findViewById(2131297443));
      paramView.setTag(paramMessageRecord);
    }
    for (;;)
    {
      if (paramLinearLayout.arkContainer == null) {
        paramLinearLayout.arkContainer = new ArkContainerWrapper();
      }
      View localView = paramMessageRecord.jdField_a_of_type_AndroidViewView;
      paramMessageRecord = paramMessageRecord.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView;
      paramMessageRecord.setClipRadius(5.0F);
      paramLinearLayout.arkContainer.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramLinearLayout.ark_app_message.appName, paramLinearLayout.ark_app_message.appView, paramLinearLayout.ark_app_message.appMinVersion, paramLinearLayout.ark_app_message.metaList, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, paramLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Int);
      paramMessageRecord.a(paramLinearLayout.arkContainer, localView);
      paramViewHolder = (ArkAppItemBuilder.Holder)paramViewHolder;
      paramViewHolder.a = paramLinearLayout.msg;
      paramMessageRecord.setTag(paramViewHolder);
      paramMessageRecord.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramMessageRecord.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if (localView != null)
      {
        localView.setOnTouchListener(paramOnLongClickAndTouchListener);
        localView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      }
      return paramView;
      paramMessageRecord = (ArkAppItemBuilder.ViewData)paramView.getTag();
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new ArkAppItemBuilder.Holder(this);
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
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      return;
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
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
            localQQCustomMenu.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
          }
        }
      }
    }
    localQQCustomMenu.a(2131305401, this.jdField_a_of_type_AndroidContentContext.getString(2131367892));
    return localQQCustomMenu.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ArkAppItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */