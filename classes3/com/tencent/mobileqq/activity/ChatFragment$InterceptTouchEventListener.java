package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ChatFragment$InterceptTouchEventListener
{
  public ChatFragment$InterceptTouchEventListener(ChatFragment paramChatFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      return this.a.a.a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatFragment$InterceptTouchEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */