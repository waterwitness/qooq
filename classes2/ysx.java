import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import java.util.ArrayList;

public class ysx
  implements Runnable
{
  public ysx(SmartDeviceIPCHost paramSmartDeviceIPCHost, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a.add(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */