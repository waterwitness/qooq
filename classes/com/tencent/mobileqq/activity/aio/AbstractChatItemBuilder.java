package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class AbstractChatItemBuilder
  implements ChatItemBuilder
{
  public Context a;
  protected BaseAdapter a;
  public SessionInfo a;
  public QQAppInterface a;
  
  public AbstractChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramView = new LinearLayout((Context)localObject);
      ((LinearLayout)paramView).setOrientation(1);
      paramViewGroup = a();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Int = paramInt1;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.mNeedTimeStamp) {
        break label439;
      }
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        TextView localTextView = new TextView((Context)localObject);
        paramInt1 = AIOUtils.a(14.0F, ((Context)localObject).getResources());
        localTextView.setTextSize(2, 11.0F);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a != null) {
          localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
        }
        localTextView.setPadding(paramInt1, 0, paramInt1, 0);
        localTextView.setGravity(17);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        localLayoutParams.topMargin = ((Context)localObject).getResources().getDimensionPixelOffset(2131493049);
        localLayoutParams.bottomMargin = ((Context)localObject).getResources().getDimensionPixelOffset(2131493050);
        ((ViewGroup)paramView).addView(localTextView, 0, localLayoutParams);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = localTextView;
        localTextView.setTag(Long.valueOf(0L));
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramChatMessage.time)
      {
        localObject = TimeFormatterUtils.a((Context)localObject, 3, paramChatMessage.time * 1000L);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      label281:
      paramChatMessage = a(paramChatMessage, paramViewGroup, paramViewGroup.jdField_a_of_type_AndroidViewView, (LinearLayout)paramView, paramOnLongClickAndTouchListener);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != paramChatMessage)
      {
        if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
          ((ViewGroup)paramView).removeView(paramViewGroup.jdField_a_of_type_AndroidViewView);
        }
        if (paramChatMessage.getLayoutParams() != null) {
          break label460;
        }
        ((ViewGroup)paramView).addView(paramChatMessage, -1, -2);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramChatMessage;
      paramChatMessage = paramView;
      do
      {
        return paramChatMessage;
        try
        {
          paramViewGroup = (AbstractChatItemBuilder.ViewHolder)paramView.getTag();
        }
        catch (ClassCastException paramViewGroup)
        {
          paramChatMessage = paramView;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "AbstractChatItemBuilder getview  e" + paramViewGroup + "position=" + paramInt1 + "size=" + this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount());
      return paramView;
      label439:
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetTextView == null) {
        break label281;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label281;
      label460:
      ((ViewGroup)paramView).addView(paramChatMessage);
    }
  }
  
  protected abstract View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  protected abstract AbstractChatItemBuilder.ViewHolder a();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\AbstractChatItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */