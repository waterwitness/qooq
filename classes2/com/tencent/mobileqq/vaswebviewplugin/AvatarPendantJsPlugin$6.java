package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnDismissListener;
import org.json.JSONException;
import org.json.JSONObject;

class AvatarPendantJsPlugin$6
  implements ActionSheet.OnDismissListener
{
  AvatarPendantJsPlugin$6(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 2);
      this.this$0.callJs(this.val$callbackId + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarPendantJsPlugin", 2, "changeFace cancel failed: " + localJSONException.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\AvatarPendantJsPlugin$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */