package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import mqq.app.MobileQQ;

class d
  implements IBinder.DeathRecipient
{
  d(PluginInterface paramPluginInterface, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
    this.a.unlinkToDeath(this, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */