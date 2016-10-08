package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;

public class InitDPC
  extends Step
{
  protected boolean a()
  {
    String str = WebAccelerateHelper.getInstance().getTBSDpcParam();
    if (str.charAt(0) != '1') {
      QbSdk.reset(BaseApplicationImpl.getContext());
    }
    if ((!BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("isTbsEnabled", true)) || (str.charAt(2) != '1'))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs force system webview");
      }
      QbSdk.forceSysWebView();
      WebpSoLoader.a(true);
    }
    while ((Build.VERSION.SDK_INT >= 17) || (QbSdk.getTbsVersion(BaseApplicationImpl.getContext()) <= 0)) {
      return true;
    }
    WebpSoLoader.a(false);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\startup\step\InitDPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */