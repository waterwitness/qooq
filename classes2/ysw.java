import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.ipc.ISmartDeviceService.Stub;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import mqq.app.MobileQQ;

public class ysw
  implements ServiceConnection
{
  public ysw(SmartDeviceIPCHost paramSmartDeviceIPCHost)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService = ISmartDeviceService.Stub.a(paramIBinder);
    this.a.b();
    QLog.d("SmartDeviceIPCHost", 1, "plugin service connected");
    SmartDeviceReport.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Host", 0, 1, 0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(this.a.jdField_a_of_type_AndroidContentServiceConnection);
      this.a.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService = null;
      this.a.jdField_a_of_type_Boolean = false;
      QLog.d("SmartDeviceIPCHost", 1, "plugin service disconnected");
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */