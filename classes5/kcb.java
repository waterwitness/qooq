import android.bluetooth.BluetoothAdapter;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kcb
  implements Runnable
{
  public kcb(QFindBLEScanMgr paramQFindBLEScanMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_Boolean = false;
    }
    try
    {
      if (this.a.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "call native mBluetoothAdapter.stopLeScan with cb=" + this.a.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback + ", mScanning=" + this.a.jdField_a_of_type_Boolean);
        }
        this.a.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.a.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */