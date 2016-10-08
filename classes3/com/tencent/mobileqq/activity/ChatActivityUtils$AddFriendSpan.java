package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ChatActivityUtils$AddFriendSpan
  extends URLSpan
{
  int a;
  
  public ChatActivityUtils$AddFriendSpan(String paramString, int paramInt)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = -16776961;
    this.a = paramInt;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getContext();
    if (((paramView instanceof SplashActivity)) || ((paramView instanceof ChatActivity)))
    {
      paramView = (FragmentActivity)paramView;
      if ((paramView.getChatFragment().a() instanceof StrangerChatPie)) {
        ((StrangerChatPie)paramView.getChatFragment().a()).aC();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatActivityUtils$AddFriendSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */