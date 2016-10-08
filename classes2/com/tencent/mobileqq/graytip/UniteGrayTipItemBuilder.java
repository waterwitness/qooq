package com.tencent.mobileqq.graytip;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class UniteGrayTipItemBuilder
  extends AbstractChatItemBuilder
{
  public UniteGrayTipItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    UniteGrayTipItemBuilder.Holder localHolder = (UniteGrayTipItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903199, null);
      localHolder.b = ((TextView)paramView.findViewById(2131297668));
      Object localObject = localHolder.b.getLayoutParams();
      paramViewHolder = paramView;
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        paramViewHolder = paramView;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != BaseChatItemLayout.A)
        {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = BaseChatItemLayout.A;
          paramViewHolder = paramView;
        }
      }
    }
    localHolder.b.setLineSpacing(0.0F, 1.0F);
    localHolder.b.setIncludeFontPadding(true);
    localHolder.b.setMovementMethod(null);
    localHolder.b.setTextColor(paramViewHolder.getResources().getColorStateList(2131427368));
    localHolder.b.setGravity(19);
    if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      localHolder.b.setText(paramMessageRecord.msg);
      return paramViewHolder;
    }
    paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
    if ((paramMessageRecord.tipParam != null) && (paramMessageRecord.tipParam.a != null))
    {
      localHolder.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
      localHolder.b.setClickable(true);
      localHolder.b.setFocusable(true);
      localHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
      return paramViewHolder;
    }
    localHolder.b.setText(paramMessageRecord.msg);
    localHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new UniteGrayTipItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\graytip\UniteGrayTipItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */