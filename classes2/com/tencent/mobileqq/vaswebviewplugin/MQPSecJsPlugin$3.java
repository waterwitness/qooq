package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

class MQPSecJsPlugin$3
  implements Runnable
{
  MQPSecJsPlugin$3(MQPSecJsPlugin paramMQPSecJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((MQPSecJsPlugin.access$100(this.this$0) != null) && (MQPSecJsPlugin.access$100(this.this$0).isShowing()))
      {
        MQPSecJsPlugin.access$100(this.this$0).dismiss();
        MQPSecJsPlugin.access$100(this.this$0).cancel();
      }
      MQPSecJsPlugin.access$102(this.this$0, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\MQPSecJsPlugin$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */