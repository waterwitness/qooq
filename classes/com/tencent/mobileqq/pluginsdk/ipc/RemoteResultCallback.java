package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import mqq.app.MobileQQ;

public abstract class RemoteResultCallback
  extends RemoteCallback.Stub
{
  public abstract void onCallback(Bundle paramBundle);
  
  public final void onRemoteCallback(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    onCallback(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\ipc\RemoteResultCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */