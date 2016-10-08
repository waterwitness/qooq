package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ApolloJsPlugin$1
  implements Runnable
{
  ApolloJsPlugin$1(ApolloJsPlugin paramApolloJsPlugin, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.val$activity != null) && (!this.val$activity.isFinishing())) {
      this.val$activity.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ApolloJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */