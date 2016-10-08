package mqq.observer;

import android.os.Bundle;
import mqq.app.Constants.Action;
import protocol.KQQConfig.GetResourceRespV2;

public class ServerConfigObserver
  implements BusinessObserver, Constants.Action
{
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2) {}
  
  public void onGetServerTime(boolean paramBoolean, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    onGetPluginConfig(paramBoolean, paramBundle.getInt("iPluginType"), (GetResourceRespV2)paramBundle.getSerializable("jce"));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\observer\ServerConfigObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */