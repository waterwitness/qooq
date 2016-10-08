package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
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
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForText;
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
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.concurrent.ConcurrentHashMap;
import nqk;
import nql;
import nqm;
import nqn;
import nqo;

public class TextItemBuilder
  extends BaseBubbleBuilder
{
  public static final int j = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected static final int k = BaseChatItemLayout.l + BaseChatItemLayout.q;
  public static final int l = BaseChatItemLayout.m + BaseChatItemLayout.r;
  public static final int m = BaseChatItemLayout.n + BaseChatItemLayout.s;
  protected AnimationTextView.OnDoubleClick a;
  protected View.OnClickListener b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new nqk(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new nql(this);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int i1 = paramString.length();
    int i = 0;
    if (i < i1)
    {
      int n = i;
      if ('\024' == paramString.charAt(i))
      {
        n = i;
        if (i + 1 < i1)
        {
          n = i;
          if ('ÿ' == paramString.charAt(i + 1))
          {
            n = i;
            if (i + 2 < i1)
            {
              if (!paramBoolean) {
                break label116;
              }
              if (paramString.charAt(i + 2) == '\024') {
                paramString.setCharAt(i + 2, 'ý');
              }
            }
          }
        }
      }
      for (;;)
      {
        n = i + 4;
        i = n + 1;
        break;
        label116:
        if (paramString.charAt(i + 2) == 'ý') {
          paramString.setCharAt(i + 2, '\024');
        }
      }
    }
    return paramString.toString();
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramViewHolder;
    paramBaseChatItemLayout = paramView;
    if (paramView == null)
    {
      paramBaseChatItemLayout = new ETTextView(localContext);
      paramBaseChatItemLayout.setTextColor(localContext.getResources().getColorStateList(2131428272));
      paramBaseChatItemLayout.setLinkTextColor(localContext.getResources().getColorStateList(2131428271));
      paramBaseChatItemLayout.setSpannableFactory(QQText.a);
      paramBaseChatItemLayout.setMaxWidth(BaseChatItemLayout.h);
      paramBaseChatItemLayout.setMovementMethod(LinkMovementMethod.getInstance());
      paramBaseChatItemLayout.setId(2131297486);
      localHolder.d = paramBaseChatItemLayout;
    }
    ((ETTextView)localHolder.d).setFont(0, paramChatMessage.uniseq);
    localHolder.d.setTypeface(null);
    ((ETTextView)localHolder.d).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    ((ETTextView)localHolder.d).setStrokeColor(false, 0);
    if (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramViewHolder = ((ETTextView)localHolder.d).a();
      if (paramViewHolder != null) {
        paramViewHolder.a = (paramChatMessage.uniseq + 1L);
      }
    }
    localHolder.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int n = BaseChatItemLayout.r;
    int i = BaseChatItemLayout.s;
    if (paramChatMessage.isSend())
    {
      n = BaseChatItemLayout.s;
      i = BaseChatItemLayout.r;
    }
    localHolder.d.setPadding(n, BaseChatItemLayout.p, i, BaseChatItemLayout.q);
    if ((paramChatMessage instanceof MessageForText))
    {
      paramViewHolder = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == 63528) {
        if (paramChatMessage.isSend())
        {
          localHolder.d.setText(localContext.getString(2131370363));
          paramViewHolder = "";
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!paramChatMessage.isread)) {
        AioVipKeywordHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramViewHolder, localContext, paramChatMessage.isSend());
      }
      localHolder.d.setOnTouchListener(paramOnLongClickAndTouchListener);
      localHolder.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localHolder.d.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if ((localHolder.d instanceof AnimationTextView))
      {
        paramViewHolder = (AnimationTextView)localHolder.d;
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick = new nqm(this, paramChatMessage.isSend());
      }
      return paramBaseChatItemLayout;
      localHolder.d.setText(localContext.getString(2131370362));
      paramViewHolder = "";
      continue;
      if (!android.text.TextUtils.isEmpty(paramViewHolder.sb))
      {
        if (!android.text.TextUtils.isEmpty(paramViewHolder.sb2))
        {
          localHolder.d.setText(paramViewHolder.sb2);
          label470:
          if (jdField_b_of_type_Boolean)
          {
            if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramChatMessage.uniseq)) == null) {
              break label544;
            }
            localHolder.d.setContentDescription((CharSequence)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramChatMessage.uniseq)));
          }
        }
        for (;;)
        {
          paramViewHolder = paramViewHolder.sb.toString();
          break;
          localHolder.d.setText(paramViewHolder.sb);
          break label470;
          label544:
          paramView = com.tencent.mobileqq.text.TextUtils.c(paramChatMessage.msg);
          a(paramChatMessage, paramView);
          localHolder.d.setContentDescription(paramView);
        }
      }
      localHolder.d.setText("");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "textitem text.sb is null" + paramChatMessage.msgtype);
      }
      paramViewHolder = "";
      continue;
      localHolder.d.setText(paramChatMessage.msg);
      paramViewHolder = paramChatMessage.msg;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TextItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText)) {
      return "说" + com.tencent.mobileqq.text.TextUtils.c(paramChatMessage.msg);
    }
    return "说" + paramChatMessage.msg;
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
      do
      {
        do
        {
          return;
          ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
          return;
        } while (paramChatMessage.msg == null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
        try
        {
          ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage.msg);
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramContext.toString());
      return;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      paramContext = (MessageForText)paramChatMessage;
      if (paramContext.sb != null) {}
      for (paramContext = paramContext.sb.toString();; paramContext = paramContext.msg)
      {
        localBundle.putString("forward_text", paramContext);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        paramContext.putExtra("direct_send_if_dataline_forward", true);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
        return;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
      c(paramChatMessage);
      return;
      super.b(paramChatMessage);
      return;
      super.a(paramChatMessage);
      return;
    } while ((c()) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
    ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().g(paramChatMessage);
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
      paramView = (MessageForText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131367889);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131367890);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new nqn(this, paramView), new nqo(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(m, j, l, k);
      return;
    }
    paramView.setPadding(l, j, m, k);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    Object localObject;
    if ((paramChatMessage instanceof MessageForLongTextMsg))
    {
      localObject = (MessageForLongTextMsg)paramChatMessage;
      if ((!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("2")) && (!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {}
    }
    label134:
    label164:
    label301:
    label315:
    for (;;)
    {
      return;
      localObject = (TextItemBuilder.Holder)paramViewHolder;
      if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramViewHolder = paramView.getColorStateList(2131428275);
          ((TextItemBuilder.Holder)localObject).d.setTextColor(paramViewHolder);
          if (!paramChatMessage.isSend()) {
            break label134;
          }
        }
        for (paramViewHolder = paramView.getColorStateList(2131428274);; paramViewHolder = paramView.getColorStateList(2131428273))
        {
          ((TextItemBuilder.Holder)localObject).d.setLinkTextColor(paramViewHolder);
          return;
          paramViewHolder = paramView.getColorStateList(2131428272);
          break;
        }
      }
      if (paramBubbleInfo.d == 0)
      {
        ((TextItemBuilder.Holder)localObject).d.setTextColor(-16777216);
        if (paramBubbleInfo.e != 0) {
          break label301;
        }
        ((TextItemBuilder.Holder)localObject).d.setLinkTextColor(paramView.getResources().getColorStateList(2131428273));
      }
      for (;;)
      {
        if ((!paramBubbleInfo.a) || (!(((TextItemBuilder.Holder)localObject).d instanceof ETTextView))) {
          break label315;
        }
        ((ETTextView)((TextItemBuilder.Holder)localObject).d).setShadowLayer(3.0F, 0.0F, 0.0F, paramBubbleInfo.f);
        ((ETTextView)((TextItemBuilder.Holder)localObject).d).setStrokeColor(true, paramBubbleInfo.f);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "bubble has stroke, color = " + paramBubbleInfo.f);
        return;
        ((TextItemBuilder.Holder)localObject).d.setTextColor(paramBubbleInfo.d);
        break label164;
        ((TextItemBuilder.Holder)localObject).d.setLinkTextColor(paramBubbleInfo.e);
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    Object localObject;
    if ((paramChatMessage instanceof MessageForLongTextMsg))
    {
      localObject = (MessageForLongTextMsg)paramChatMessage;
      if ((!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("2")) && (!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {}
    }
    label44:
    do
    {
      do
      {
        do
        {
          break label44;
          do
          {
            return;
          } while (AIOUtils.h);
          localObject = (TextItemBuilder.Holder)paramViewHolder;
        } while (!(((TextItemBuilder.Holder)localObject).d instanceof ETTextView));
        paramViewHolder = ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(paramChatMessage);
        localObject = (ETTextView)((TextItemBuilder.Holder)localObject).d;
        if (paramViewHolder == null) {
          break;
        }
        ((ETTextView)localObject).setFont(new ETFont(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramViewHolder.b, paramViewHolder.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateTextFont  fontId = " + paramViewHolder.jdField_a_of_type_Int + "fontType = " + paramViewHolder.b + "typeface = " + paramViewHolder.jdField_a_of_type_AndroidGraphicsTypeface);
      return;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "updateTextFont fontInfo = null");
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131305407, "复制");
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localQQCustomMenu.a(2131305409, this.jdField_a_of_type_AndroidContentContext.getString(2131367998));
    }
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
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    QfavBuilder.a(null, paramChatMessage.msg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
    if (android.text.TextUtils.isEmpty(paramChatMessage.msg)) {}
    label174:
    for (;;)
    {
      return;
      paramChatMessage = new StringBuilder(paramChatMessage.msg);
      int i = 0;
      for (;;)
      {
        if (i >= paramChatMessage.length()) {
          break label174;
        }
        if ((paramChatMessage.codePointAt(i) == 20) && (i < paramChatMessage.length() - 1) && (paramChatMessage.charAt(i + 1) == 'ÿ'))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "report save small emoticon amount");
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\TextItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */