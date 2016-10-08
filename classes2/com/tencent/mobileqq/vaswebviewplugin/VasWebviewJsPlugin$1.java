package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class VasWebviewJsPlugin$1
  extends Client.onRemoteRespObserver
{
  VasWebviewJsPlugin$1(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBindedToClient()
  {
    this.this$0.onBindedToClient();
  }
  
  public void onDisconnectWithService()
  {
    this.this$0.onDisconnectWithService();
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    this.this$0.onPushMsg(paramBundle);
  }
  
  public void onResponse(Bundle paramBundle)
  {
    this.this$0.onResponse(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasWebviewJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */