package com.tencent.mobileqq.msf.sdk.utils;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class c
  implements Runnable
{
  c(MonitorSocketStat paramMonitorSocketStat) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.MonitorSocket", 2, "start to get status of Process");
    }
    if (MsfSdkUtils.isTopActivity(BaseApplication.getContext()))
    {
      if (MonitorSocketStat.isScreenOff)
      {
        MonitorSocketStat.STATUS = 4;
        return;
      }
      MonitorSocketStat.STATUS = 1;
      return;
    }
    if (MonitorSocketStat.isScreenOff)
    {
      MonitorSocketStat.STATUS = 2;
      return;
    }
    if ((!MsfSdkUtils.isTopActivity(BaseApplication.getContext())) && (!MonitorSocketStat.isScreenOff))
    {
      MonitorSocketStat.STATUS = 3;
      return;
    }
    MonitorSocketStat.STATUS = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */