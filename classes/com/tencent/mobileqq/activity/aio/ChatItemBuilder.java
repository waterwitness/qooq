package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract interface ChatItemBuilder
  extends ContextMenuBuilder
{
  public static final String a = ChatItemBuilder.class.getSimpleName();
  public static final boolean b;
  public static final boolean c = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = AppSetting.j;
  }
  
  public abstract View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\ChatItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */