package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;
import qdt;
import qdu;

public class PushBroadcastReceiver
  extends QQBroadcastReceiver
{
  public PushBroadcastReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.notify.background")) {
      ThreadManager.a(new qdt(this, paramIntent, paramQQAppInterface), 10, null, false);
    }
    for (;;)
    {
      if ((paramIntent.getAction().equals("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION")) || (paramIntent.getAction().equals("com.tencent.mobileqq.IPADONLINE_CLICK_NOTIFICATION"))) {
        ((MessageHandler)paramQQAppInterface.a(0)).a(BaseApplication.getContext(), paramIntent);
      }
      return;
      if (paramIntent.getAction().equals("tencent.notify.foreground")) {
        ThreadManager.a(new qdu(this, paramQQAppInterface), 10, null, false);
      }
    }
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (((paramIntent.getExtras() == null) || (paramIntent.getExtras().getString("selfuin") != null)) || ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)))) {
      a((QQAppInterface)paramAppRuntime, paramIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\PushBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */