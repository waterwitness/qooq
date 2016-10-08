package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiHelper;

public class ReportQQWifiInfo
  extends AsyncStep
{
  public ReportQQWifiInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReportQQWifiInfo", 2, "dostep");
    }
    if ((QQWiFiHelper.a(this.a.b.getApplication())) || (QQWiFiHelper.b(this.a.b.getApplication())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReportQQWifiInfo", 2, "start report");
      }
      QQWiFiHelper.a(this.a.b, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReportQQWifiInfo", 2, "return ok");
      }
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(this.a.b.a(), 0);
      int i = localSharedPreferences.getInt("showQQWiFiNotifyCount", 0);
      if (i > 0)
      {
        ReportController.b(this.a.b, "CliOper", "", "", "QQWIFI", "showQQWiFiNotifyCount", 0, 0, "" + i, "", "", "");
        localSharedPreferences.edit().putInt("showQQWiFiNotifyCount", 0).commit();
      }
      i = localSharedPreferences.getInt("QQWiFiShowRedTouch", 0);
      if (i != 0)
      {
        ReportController.b(this.a.b, "CliOper", "", "", "QQWIFI", "QQWiFiShowRedTouch", 0, 0, "" + i, "", "", "");
        localSharedPreferences.edit().putInt("QQWiFiShowRedTouch", 0).commit();
      }
      i = localSharedPreferences.getInt("showQQWiFiAvailExtend", 0);
      if (i > 0)
      {
        ReportController.b(this.a.b, "CliOper", "", "", "QQWIFI", "showQQWiFiAvailExtend", 0, 0, "" + i, "", "", "");
        localSharedPreferences.edit().putInt("showQQWiFiAvailExtend", 0).commit();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.i("ReportQQWifiInfo", 2, "do not need report");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\ReportQQWifiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */