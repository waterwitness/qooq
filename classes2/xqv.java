import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.List;

class xqv
  implements Runnable
{
  xqv(xqu paramxqu)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectedDevices();
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + ((List)localObject).size() + " _profile:" + this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
      }
      int i = 0;
      while (i < ((List)localObject).size())
      {
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)((List)localObject).get(i);
        int j = this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectionState(localBluetoothDevice);
        if (j == 2) {
          this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(localBluetoothDevice.getName());
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "   " + i + " " + localBluetoothDevice.getName() + " ConnectionState:" + j);
        }
        i += 1;
      }
    }
    if (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager != null)
    {
      localObject = null;
      if (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager != null) {
        localObject = this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
      }
    }
    else
    {
      return;
    }
    if ((this.a.a()) && (((String)localObject).indexOf("Gear") == -1))
    {
      this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", true);
      this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", true);
      return;
    }
    this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */