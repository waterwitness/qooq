package com.tencent.biz.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GamePartyPlugin$GamePartyBroadcastReceiver
  extends BroadcastReceiver
{
  public GamePartyPlugin$GamePartyBroadcastReceiver(GamePartyPlugin paramGamePartyPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.gameparty.notify"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("teamId");
      this.a.callJs("getTeamInfo", new String[] { "'" + paramContext + "'", "'" + paramIntent + "'" });
    }
    while (!paramContext.equals("android.intent.action.gameparty.refresh")) {
      return;
    }
    paramContext = paramIntent.getStringExtra("uin");
    long l = paramIntent.getLongExtra("teamId", 0L);
    this.a.callJs("refreshAudioStatus", new String[] { "'" + paramContext + "'", "'" + l + "'" });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\GamePartyPlugin$GamePartyBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */