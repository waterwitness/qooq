package com.tencent.device.msg.activities;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class DeviceShareAgentActivity
  extends AppActivity
  implements Observer
{
  public static int a;
  public static String a;
  private static String b;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = "DeviceShareAgentActivity";
    jdField_a_of_type_JavaLangString = "agent_type";
  }
  
  private void a()
  {
    String str;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("jumpPublicDevice", false)) {
      str = "com.tencent.device.activities.DeviceSquareActivity";
    }
    for (;;)
    {
      SmartDevicePluginLoader.a().a(this, super.getAppRuntime(), super.getAppRuntime().getAccount(), this.jdField_a_of_type_AndroidContentIntent, str, 0, null, SmartDevicePluginProxyActivity.class);
      return;
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("public_device", 0) != 0)
      {
        str = "com.tencent.device.activities.DeviceScanActivity";
        this.jdField_a_of_type_AndroidContentIntent.putExtra("nickname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("bitmap", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2, false));
      }
      else
      {
        str = "com.tencent.device.activities.DeviceShareConfirmActivity";
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = super.getIntent();
    if (jdField_a_of_type_Int == this.jdField_a_of_type_AndroidContentIntent.getIntExtra(jdField_a_of_type_JavaLangString, -1))
    {
      if (!QZoneShareManager.a((AppInterface)super.getAppRuntime(), this, this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("data"), null)) {
        QRUtils.a(1, 2131369679);
      }
      super.finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uinname", ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")));
    if (SmartDevicePluginLoader.a().a((QQAppInterface)super.getAppRuntime()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "start SmartDevicePlugin to goshare");
      }
      a();
      super.finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "download install SmartDevicePlugin");
    }
    SmartDevicePluginLoader.a().addObserver(this);
    SmartDevicePluginLoader.a().a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SmartDevicePluginLoader.a().deleteObserver(this);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Integer)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "deviceshare : plugin install finished with code " + paramObservable);
    }
    if (paramObservable.intValue() == 0) {
      a();
    }
    for (;;)
    {
      super.finish();
      return;
      ToastUtil.a().a(super.getString(2131362441));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\msg\activities\DeviceShareAgentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */