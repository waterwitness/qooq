package com.tencent.proxyinner.channel;

import android.os.Bundle;

public class PluginMessageHandler
{
  private void onDownload(String paramString1, String paramString2) {}
  
  private void onLuanchVasPlugin(Bundle paramBundle) {}
  
  public boolean handlePluginMessage(String paramString, Bundle paramBundle)
  {
    if (paramString == "com.tencent.xplatform.started") {}
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\channel\PluginMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */