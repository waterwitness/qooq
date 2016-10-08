package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class BubbleUiPlugin$1
  implements Runnable
{
  BubbleUiPlugin$1(BubbleUiPlugin paramBubbleUiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("optype", "Bubble");
    localBundle.putString("opname", "Clk_bubble_setting");
    localBundle = DataFactory.a("reportActionCount", "", this.this$0.mOnRemoteResp.key, localBundle);
    WebIPCOperator.a().a(localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\BubbleUiPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */