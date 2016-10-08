package com.dataline.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RouterAdvanceActivity$NotifyReceiver
  extends BroadcastReceiver
{
  public RouterAdvanceActivity$NotifyReceiver(RouterAdvanceActivity paramRouterAdvanceActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst"))
    {
      int i = paramIntent.getExtras().getInt("deviceoprstcode");
      paramContext = new Message();
      paramContext.what = 1;
      paramContext.arg1 = i;
      this.a.a.sendMessage(paramContext);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\RouterAdvanceActivity$NotifyReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */