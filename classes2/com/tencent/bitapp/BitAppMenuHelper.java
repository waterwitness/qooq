package com.tencent.bitapp;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class BitAppMenuHelper
{
  public BitAppMenuHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(int paramInt, Context paramContext, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityFacade.b(paramContext, paramQQAppInterface, paramChatMessage);
  }
  
  public static QQCustomMenuItem[] a(Context paramContext, View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131305401, paramContext.getString(2131367892));
    return paramView.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMenuHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */