package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import nlq;
import nlr;
import nls;
import nlt;
import nlu;

public class LongMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static final int h = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private static final int i = BaseChatItemLayout.l + BaseChatItemLayout.q;
  private static final int j = BaseChatItemLayout.m + BaseChatItemLayout.r;
  private static final int k = BaseChatItemLayout.n + BaseChatItemLayout.s;
  protected View.OnClickListener a;
  AnimationTextView.OnDoubleClick a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LongMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new nlt(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nlu(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public int a(MessageForLongMsg paramMessageForLongMsg)
  {
    if ((paramMessageForLongMsg != null) && (paramMessageForLongMsg.mSourceMsgInfo != null)) {
      return 2;
    }
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForLongMsg)paramChatMessage;
    int m = a(paramBaseChatItemLayout);
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if (paramView == null) {
      if (m == 1)
      {
        paramViewHolder = new AnimationTextView(localContext);
        paramViewHolder.setTextColor(localContext.getResources().getColorStateList(2131428272));
        paramViewHolder.setMaxWidth(BaseChatItemLayout.h);
        paramViewHolder.setSpannableFactory(QQText.a);
        paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
        paramViewHolder.setId(2131297486);
        localHolder.a = paramViewHolder;
      }
    }
    for (;;)
    {
      if ((m == 2) && (localHolder.b == null)) {
        paramViewHolder = a(localContext, localHolder);
      }
      for (;;)
      {
        localHolder.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        if (m == 2)
        {
          localHolder.b.setVisibility(0);
          ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHolder.b, paramBaseChatItemLayout.mSourceMsgInfo, paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.istroop, paramBaseChatItemLayout.uniseq);
          localHolder.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramChatMessage.senderuin)) && (!paramBaseChatItemLayout.mIsCutAtInfoLocal) && (paramBaseChatItemLayout.atInfoList != null) && (paramBaseChatItemLayout.atInfoList.size() > 0))
          {
            paramView = (MessageForText.AtTroopMemberInfo)paramBaseChatItemLayout.atInfoList.remove(0);
            if (paramBaseChatItemLayout.msg.length() > paramView.textLen + 1)
            {
              paramBaseChatItemLayout.msg = paramBaseChatItemLayout.msg.substring(paramView.textLen + 1);
              paramBaseChatItemLayout.sb = new QQText(paramBaseChatItemLayout.msg, 13, 32, paramBaseChatItemLayout);
            }
            paramBaseChatItemLayout.mIsCutAtInfoLocal = true;
          }
          label339:
          paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
          localHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
          localHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
          if (!android.text.TextUtils.isEmpty(paramBaseChatItemLayout.sb2)) {
            break label506;
          }
          localHolder.a.setText(paramBaseChatItemLayout.sb);
        }
        for (;;)
        {
          if ((localHolder.a instanceof AnimationTextView))
          {
            paramView = (AnimationTextView)localHolder.a;
            paramView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
            paramView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick = new nlq(this, paramChatMessage.isSend());
            paramView.setStrokeColor(false, 0);
          }
          if ((localHolder.b instanceof AnimationTextView)) {
            ((AnimationTextView)localHolder.b).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
          }
          return paramViewHolder;
          paramViewHolder = a(localContext, localHolder);
          break;
          if (localHolder.b == null) {
            break label339;
          }
          localHolder.b.setVisibility(8);
          break label339;
          label506:
          localHolder.a.setText(paramBaseChatItemLayout.sb2);
        }
      }
      paramViewHolder = paramView;
    }
  }
  
  public LinearLayout a(Context paramContext, LongMsgItemBuilder.Holder paramHolder)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = ReplyTextItemBuilder.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramHolder.b = ((TextView)localObject);
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131428272));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.h);
    ((AnimationTextView)localObject).setSpannableFactory(QQText.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131297486);
    localLinearLayout.addView((View)localObject);
    paramHolder.a = ((TextView)localObject);
    return localLinearLayout;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new LongMsgItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "说" + com.tencent.mobileqq.text.TextUtils.c(paramChatMessage.msg);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131305401: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131305411: 
      super.b(paramChatMessage);
      return;
    case 2131305407: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage));
      return;
    case 2131305409: 
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131297425: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    case 2131305417: 
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131299841: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131367889);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131367890);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new nlr(this, paramView), new nls(this)).show();
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
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131428275);
        if (paramViewHolder != null)
        {
          localHolder.a.setTextColor(paramViewHolder);
          if (localHolder.b != null) {
            localHolder.b.setTextColor(paramViewHolder);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label135;
        }
      }
      label135:
      for (paramViewHolder = paramView.getColorStateList(2131428274);; paramViewHolder = paramView.getColorStateList(2131428273))
      {
        localHolder.a.setLinkTextColor(paramViewHolder);
        if (localHolder.b != null)
        {
          localHolder.b.setLinkTextColor(paramViewHolder);
          ImmersiveUtils.a(localHolder.b, 0.5F);
        }
        return;
        paramViewHolder = paramView.getColorStateList(2131428272);
        break;
      }
    }
    if (paramBubbleInfo.d == 0)
    {
      localHolder.a.setTextColor(-16777216);
      if (localHolder.b != null) {
        localHolder.b.setTextColor(-16777216);
      }
      if (paramBubbleInfo.e != 0) {
        break label351;
      }
      paramViewHolder = paramView.getResources().getColorStateList(2131428273);
      localHolder.a.setLinkTextColor(paramViewHolder);
      if (localHolder.b != null) {
        localHolder.b.setLinkTextColor(paramViewHolder);
      }
    }
    for (;;)
    {
      if ((paramBubbleInfo.a) && ((localHolder.a instanceof AnimationTextView)))
      {
        ((AnimationTextView)localHolder.a).setStrokeColor(true, paramBubbleInfo.f);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "bubble has stroke, color = " + paramBubbleInfo.f);
        }
      }
      ImmersiveUtils.a(localHolder.b, 0.5F);
      return;
      localHolder.a.setTextColor(paramBubbleInfo.d);
      if (localHolder.b == null) {
        break;
      }
      localHolder.b.setTextColor(paramBubbleInfo.d);
      break;
      label351:
      localHolder.a.setLinkTextColor(paramBubbleInfo.e);
      if (localHolder.b != null) {
        localHolder.b.setLinkTextColor(paramBubbleInfo.e);
      }
    }
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    QfavBuilder.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localQQCustomMenu.a(2131305407, this.jdField_a_of_type_AndroidContentContext.getString(2131367994));
      localQQCustomMenu.a(2131305409, this.jdField_a_of_type_AndroidContentContext.getString(2131367998));
    }
    for (;;)
    {
      localQQCustomMenu.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
      if (paramView.istroop == 1)
      {
        if (AIOUtils.a(4) == 1) {
          localQQCustomMenu.a(2131305419, this.jdField_a_of_type_AndroidContentContext.getString(2131365195));
        }
        if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          a(paramView, localQQCustomMenu);
        }
      }
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131365886));
      }
      if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localQQCustomMenu.a(2131305417, this.jdField_a_of_type_AndroidContentContext.getString(2131370602));
      }
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131305407, "复制");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\LongMsgItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */