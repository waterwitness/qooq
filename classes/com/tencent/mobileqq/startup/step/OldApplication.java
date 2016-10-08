package com.tencent.mobileqq.startup.step;

import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.utils.SoLoadReportImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import cooperation.plugin.PluginAdapterImpl;
import mqq.app.Foreground;
import mqq.os.MqqHandler;

public class OldApplication
  extends Step
{
  protected boolean a()
  {
    mqq.app.MainService.isDebugVersion = false;
    mqq.app.MainService.isGrayVersion = false;
    if (BaseApplicationImpl.i == 1)
    {
      long l = SystemClock.uptimeMillis();
      BaseApplicationImpl.jdField_a_of_type_Long = l;
      BaseApplicationImpl.b = l;
      BaseApplicationImpl.c = BaseApplicationImpl.jdField_a_of_type_Long;
      BaseApplicationImpl.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
      IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
    }
    for (;;)
    {
      BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a();
      SoLoadUtilNew.setReport(new SoLoadReportImpl());
      TimeFormatterUtils.a();
      BaseApplicationImpl.appnewmsgicon = 2130838719;
      BaseApplicationImpl.appnewavmsgicon = 2130839140;
      BaseApplicationImpl.qqlaunchicon = 2130838592;
      BaseApplicationImpl.qqWifiLayout = 2130904512;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131302993;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131302996;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131302997;
      BaseApplicationImpl.qqWifiSettingViewId = 2131298005;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131302998;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131302995;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131302994;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130841613;
      BaseApplicationImpl.qqWifiNoSignal = 2130841614;
      BaseApplicationImpl.qqWifiUserful = 2130841619;
      BaseApplicationImpl.qqWifiSettings = 2130841618;
      BaseApplicationImpl.qqWifiOperation = 2130841612;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130841617;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130841616;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130841615;
      BaseApplicationImpl.qqwifinotifydivide = 2131427534;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131165190;
      BaseApplicationImpl.devlockQuickloginIcon = 2130840319;
      Foreground.init(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, ThreadManager.b(), BaseApplicationImpl.processName);
      try
      {
        Class.forName("android.os.AsyncTask");
        if (BaseApplicationImpl.i == 1)
        {
          return true;
          if (BaseApplicationImpl.i == 4) {
            continue;
          }
          IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\OldApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */