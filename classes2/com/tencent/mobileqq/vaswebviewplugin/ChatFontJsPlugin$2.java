package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

class ChatFontJsPlugin$2
  implements DialogInterface.OnClickListener
{
  ChatFontJsPlugin$2(ChatFontJsPlugin paramChatFontJsPlugin, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.val$result.put("selectbutton", 0);
      this.val$result.put("isUse", 0);
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ChatFontJsPlugin$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */