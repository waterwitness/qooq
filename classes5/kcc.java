import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class kcc
  implements BluetoothAdapter.LeScanCallback
{
  public kcc(QFindBLEScanMgr paramQFindBLEScanMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.a.a != null) {
      this.a.a.post(new kcd(this, paramBluetoothDevice, paramArrayOfByte));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */