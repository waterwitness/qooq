package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class b
  implements RemoteCommand.OnInvokeFinishLinstener
{
  b(PluginCommunicationHandler.PluginCommunicationChannelImpl.a parama, PluginCommunicationHandler.PluginCommunicationChannelImpl paramPluginCommunicationChannelImpl) {}
  
  public void onInvokeFinish(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      PluginCommunicationHandler.PluginCommunicationChannelImpl.a.a(this.b).onRemoteCallback(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("plugin_tag", 2, "tranferAsync ", paramBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\ipc\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */