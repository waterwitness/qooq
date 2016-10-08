package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.StartupTracker;

public class ChatFragment$MyDispatchDrawListener
{
  public ChatFragment$MyDispatchDrawListener(ChatFragment paramChatFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((ChatFragment.b()) && (this.a.jdField_a_of_type_Boolean))
    {
      StartupTracker.b("AIO_Start_cost", null);
      StartupTracker.a("AIO_onDrawView", "AIO_SysMsgCost");
      ChatFragment.a(this.a);
      if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1) == 1008)
      {
        String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
        PAStartupTracker.a("pubAcc_aio_open", null, str);
        PAStartupTracker.a("pubAcc_structMsg_display", null, str);
      }
      ChatFragment.a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatFragment$MyDispatchDrawListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */