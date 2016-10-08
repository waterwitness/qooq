package com.tencent.proxyinner.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class RemoteMessageSender
{
  Context mContext;
  
  public RemoteMessageSender(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void sendMessage(Intent paramIntent)
  {
    this.mContext.sendBroadcast(paramIntent);
  }
  
  public void sendMessage(String paramString, Bundle paramBundle)
  {
    paramString = new Intent(paramString);
    paramString.putExtras(paramBundle);
    sendMessage(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\channel\RemoteMessageSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */