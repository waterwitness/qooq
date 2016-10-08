package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
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
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongMsgItemTitleImageView;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.DingdongPluginHelper;
import mqq.app.MobileQQ;
import niz;

public class DingdongScheduleItemBuilder
  extends BaseBubbleBuilder
{
  private static final String b = "DingdongScheduleItemBuilder";
  
  public DingdongScheduleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void d(View paramView)
  {
    DingdongPluginHelper.a("0X800652B", 1);
    MessageForDingdongSchedule localMessageForDingdongSchedule = (MessageForDingdongSchedule)AIOUtils.a(paramView);
    if (localMessageForDingdongSchedule != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("schedule_feed_id", localMessageForDingdongSchedule.getSummaryData().id);
      DingdongPluginHelper.a((Activity)paramView.getContext(), "com.dingdong.business.Schedule.Activity.ScheduleDetailActivity", localIntent, -1);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (niz)paramChatMessage.getTag();
    paramView.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.h;
    if (b) {}
    try
    {
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.jdField_c_of_type_AndroidWidgetTextView.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.jdField_d_of_type_AndroidWidgetTextView.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131372411));
      paramChatMessage.setContentDescription(paramView.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramChatMessage;
    }
    catch (Exception paramView)
    {
      QLog.e("DingdongScheduleItemBuilder", 1, "getView. error:" + paramView.toString() + ".");
    }
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForDingdongSchedule localMessageForDingdongSchedule = (MessageForDingdongSchedule)paramChatMessage;
    niz localniz = (niz)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903168, null);
      localniz.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131296360));
      localniz.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297469));
      localniz.e = ((TextView)paramViewHolder.findViewById(2131297472));
      localniz.f = ((TextView)paramViewHolder.findViewById(2131297473));
      localniz.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView = ((DingdongMsgItemTitleImageView)paramViewHolder.findViewById(2131297433));
      localniz.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewHolder.findViewById(2131297468));
      localniz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297466));
      localniz.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297467));
      localniz.jdField_b_of_type_AndroidViewView = paramViewHolder.findViewById(2131297470);
      localniz.jdField_c_of_type_AndroidViewView = paramViewHolder.findViewById(2131297474);
      localniz.jdField_d_of_type_AndroidViewView = paramViewHolder.findViewById(2131297471);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnClickListener(this);
    }
    paramView = (LinearLayout.LayoutParams)localniz.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramOnLongClickAndTouchListener = (RelativeLayout.LayoutParams)localniz.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    label260:
    label372:
    label451:
    label475:
    int j;
    if (paramChatMessage.isSend())
    {
      i = 2130837942;
      paramView.leftMargin = 0;
      paramView.rightMargin = ((int)(this.a_ * 6.0F));
      paramOnLongClickAndTouchListener.leftMargin = ((int)(16.0F * this.a_));
      paramChatMessage = paramBaseChatItemLayout.getContext();
      localniz.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.destroyDrawingCache();
      localniz.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.setBackgroundDrawable(paramChatMessage.getResources().getDrawable(i));
      localniz.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.invalidate();
      localniz.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramView);
      localniz.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramOnLongClickAndTouchListener);
      localniz.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
      localniz.jdField_a_of_type_AndroidWidgetTextView.invalidate();
      if ((localMessageForDingdongSchedule.notificationType != 4) && (localMessageForDingdongSchedule.notificationType != 3)) {
        break label613;
      }
      localniz.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.setReplaceColor(Color.rgb(128, 128, 128));
      localniz.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.invalidate();
      localniz.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForDingdongSchedule.getSummaryData().title);
      localniz.jdField_d_of_type_AndroidWidgetTextView.setText(DingdongPluginHelper.a(localMessageForDingdongSchedule.getSummaryData().beginTime, localMessageForDingdongSchedule.getSummaryData().endTime, false));
      if (!TextUtils.isEmpty(localMessageForDingdongSchedule.getSummaryData().location)) {
        break label635;
      }
      localniz.e.setVisibility(8);
      i = 0;
      if (!TextUtils.isEmpty(localMessageForDingdongSchedule.getSummaryData().mark)) {
        break label689;
      }
      localniz.f.setVisibility(8);
      paramChatMessage = localniz.jdField_b_of_type_AndroidViewView;
      if (i == 0) {
        break label720;
      }
      j = 0;
      label489:
      paramChatMessage.setVisibility(j);
      paramChatMessage = localniz.jdField_c_of_type_AndroidViewView;
      if (i == 0) {
        break label726;
      }
      j = 0;
      label509:
      paramChatMessage.setVisibility(j);
      paramChatMessage = localniz.jdField_d_of_type_AndroidViewView;
      if (i == 0) {
        break label733;
      }
    }
    label613:
    label635:
    label689:
    label720:
    label726:
    label733:
    for (int i = 0;; i = 8)
    {
      paramChatMessage.setVisibility(i);
      switch (localMessageForDingdongSchedule.notificationType)
      {
      default: 
        return paramViewHolder;
        i = 2130837941;
        paramView.leftMargin = ((int)(this.a_ * 6.0F));
        paramView.rightMargin = 0;
        paramOnLongClickAndTouchListener.leftMargin = ((int)(24.0F * this.a_));
        break label260;
        localniz.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.setReplaceColor(Color.rgb(250, 165, 92));
        break label372;
        localniz.e.setVisibility(0);
        localniz.e.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131372417), new Object[] { localMessageForDingdongSchedule.getSummaryData().location }));
        i = 1;
        break label451;
        localniz.f.setVisibility(0);
        localniz.f.setText(localMessageForDingdongSchedule.getSummaryData().mark);
        i = 1;
        break label475;
        j = 4;
        break label489;
        j = 8;
        break label509;
      }
    }
    localniz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    return paramViewHolder;
    localniz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localniz.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131372414));
    return paramViewHolder;
    localniz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localniz.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131372415));
    return paramViewHolder;
    localniz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localniz.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131372415));
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new niz(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131372419);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131372420);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131305401: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  protected void a(View paramView) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.l = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131296317: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\DingdongScheduleItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */