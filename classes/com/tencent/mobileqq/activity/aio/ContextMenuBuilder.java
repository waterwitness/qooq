package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public abstract interface ContextMenuBuilder
{
  public abstract void a(int paramInt, Context paramContext, ChatMessage paramChatMessage);
  
  public abstract QQCustomMenuItem[] a(View paramView);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\ContextMenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */