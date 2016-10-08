package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class StartSmartDevice
  extends AsyncStep
{
  public StartSmartDevice()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.a().a()).a(51);
    QLog.i("smartdevice", 1, "start device when device bind flag:" + localSmartDeviceProxyMgr.a());
    if (localSmartDeviceProxyMgr.a()) {
      localSmartDeviceProxyMgr.a(true);
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\StartSmartDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */