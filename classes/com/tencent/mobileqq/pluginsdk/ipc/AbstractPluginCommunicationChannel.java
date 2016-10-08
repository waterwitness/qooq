package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.RemoteException;

public abstract class AbstractPluginCommunicationChannel
  extends PluginCommunicationChannel.Stub
{
  public Bundle transfer(String paramString, Bundle paramBundle)
    throws RemoteException
  {
    return null;
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
    throws RemoteException
  {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\ipc\AbstractPluginCommunicationChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */