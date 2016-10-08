package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

class ChatFontJsPlugin$4
  implements DialogInterface.OnCancelListener
{
  ChatFontJsPlugin$4(ChatFontJsPlugin paramChatFontJsPlugin, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      this.val$result.put("isUse", 0);
      this.val$result.put("selectbutton", -1);
      this.this$0.callJs(this.val$callbackId, new String[] { this.val$result.toString() });
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
      this.this$0.callJs(this.val$callbackId, new String[] { paramDialogInterface.getMessage() });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ChatFontJsPlugin$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */