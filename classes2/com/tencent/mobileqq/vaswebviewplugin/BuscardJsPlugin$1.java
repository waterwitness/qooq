package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class BuscardJsPlugin$1
  extends ResultReceiver
{
  BuscardJsPlugin$1(BuscardJsPlugin paramBuscardJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    this.this$0.handleReceiveResult(paramInt, paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\BuscardJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */