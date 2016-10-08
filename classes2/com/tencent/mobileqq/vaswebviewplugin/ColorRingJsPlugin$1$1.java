package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

class ColorRingJsPlugin$1$1
  implements Runnable
{
  ColorRingJsPlugin$1$1(ColorRingJsPlugin.1 param1, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.this$1.this$0.callJs(this.this$1.val$callbackId, new String[] { this.val$result.toString() });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ColorRingJsPlugin$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */