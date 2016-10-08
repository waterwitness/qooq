package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ThemeJsPlugin$3
  extends QQCustomDialog
{
  ThemeJsPlugin$3(ThemeJsPlugin paramThemeJsPlugin, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "back button clicked");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 2);
      localJSONObject.put("message", "user cancel download theme in not wifi network");
      this.this$0.callJs(this.val$callbackId, new String[] { localJSONObject.toString() });
      this.this$0.reportTheme(null, 0, this.val$id, 0L, "VipThemeMallDowned", "Cancel", "200", 153, ThemeReporter.t, 10, this.val$version, "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      super.onBackPressed();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeJsPlugin$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */