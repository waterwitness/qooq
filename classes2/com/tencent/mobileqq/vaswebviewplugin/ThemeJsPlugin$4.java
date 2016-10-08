package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ThemeJsPlugin$4
  implements DialogInterface.OnClickListener
{
  ThemeJsPlugin$4(ThemeJsPlugin paramThemeJsPlugin, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "not wifi network cancel download");
    }
    try
    {
      paramDialogInterface = new JSONObject();
      paramDialogInterface.put("result", 2);
      paramDialogInterface.put("message", "user cancel download theme in not wifi network");
      this.this$0.callJs(this.val$callbackId, new String[] { paramDialogInterface.toString() });
      this.this$0.reportTheme(null, 0, this.val$id, 0L, "VipThemeMallDowned", "Cancel", "200", 153, ThemeReporter.t, 10, this.val$version, "");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeJsPlugin$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */