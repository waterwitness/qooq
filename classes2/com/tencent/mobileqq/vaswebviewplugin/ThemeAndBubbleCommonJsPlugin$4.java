package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import org.json.JSONObject;

class ThemeAndBubbleCommonJsPlugin$4
  implements DialogInterface.OnKeyListener
{
  ThemeAndBubbleCommonJsPlugin$4(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin, QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.val$treeBtnDialog.isShowing()))
    {
      this.val$treeBtnDialog.dismiss();
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("result", -1);
        paramDialogInterface.put("message", "home back pressed");
        this.this$0.callJs(this.val$callbackId + "(" + paramDialogInterface.toString() + ");");
        return true;
      }
      catch (Exception paramDialogInterface)
      {
        for (;;)
        {
          this.this$0.callJsOnError(this.val$callbackId, paramDialogInterface.getMessage());
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeAndBubbleCommonJsPlugin$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */