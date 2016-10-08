package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class h
  extends BroadcastReceiver
{
  h(PluginProxyActivity paramPluginProxyActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((PluginProxyActivity.mGestureLockEnable) && (this.a.mStopFlag == 0) && (this.a.isPatternLockOpened())) {
      this.a.startUnlockActivity(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */