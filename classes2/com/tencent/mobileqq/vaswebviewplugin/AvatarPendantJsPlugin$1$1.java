package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

class AvatarPendantJsPlugin$1$1
  implements Runnable
{
  AvatarPendantJsPlugin$1$1(AvatarPendantJsPlugin.1 param1, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.this$1.this$0.callJs(this.this$1.val$callbackId + "(" + this.val$result.toString() + ");");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\AvatarPendantJsPlugin$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */