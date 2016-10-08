package com.tencent.mobileqq.vas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public class ThemeChangeBroadcastReceiver
  extends BroadcastReceiver
{
  private QQAppInterface a;
  
  public ThemeChangeBroadcastReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ((MobileQQ)paramContext.getApplicationContext()).waitAppRuntime(null);
    if ("com.tencent.qplus.THEME_INVALIDATE".equals(paramIntent.getAction())) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\ThemeChangeBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */