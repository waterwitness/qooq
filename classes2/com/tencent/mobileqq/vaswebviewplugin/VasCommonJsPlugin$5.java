package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class VasCommonJsPlugin$5
  implements DialogInterface.OnKeyListener
{
  VasCommonJsPlugin$5(VasCommonJsPlugin paramVasCommonJsPlugin, QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, JsBridgeListener paramJsBridgeListener)
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
        paramDialogInterface.put("message", " press");
        this.val$listener.a(paramDialogInterface);
        return true;
      }
      catch (Exception paramDialogInterface)
      {
        for (;;)
        {
          this.val$listener.a("Exception:" + paramDialogInterface.getMessage());
          paramDialogInterface.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasCommonJsPlugin$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */