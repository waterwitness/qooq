package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class BubbleUiPlugin$2
  extends Client.onRemoteRespObserver
{
  BubbleUiPlugin$2(BubbleUiPlugin paramBubbleUiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBindedToClient()
  {
    if (this.this$0.isHomePageWatingBind)
    {
      BubbleUiPlugin.access$000(this.this$0);
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "onResume -> onBindedToClient:loadurl");
      }
      this.this$0.isHomePageWatingBind = false;
    }
  }
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\BubbleUiPlugin$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */