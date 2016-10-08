import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.ble.QFindGattManager;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.device.qfind.BluetoothLeService.LocalBinder;
import com.tencent.device.qfind.PeerInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class jwa
  implements ServiceConnection
{
  public jwa(QFindGattManager paramQFindGattManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QFindGattManager.a(this.a, ((BluetoothLeService.LocalBinder)paramIBinder).a());
    if ((!QFindGattManager.a(this.a).a()) && (QLog.isColorLevel())) {
      QLog.e("DeviceBLE2", 2, "Unable to initialize Bluetooth");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE2", 2, "ServiceConnection onServiceConnected ");
    }
    if (!QFindGattManager.a(this.a).isEmpty())
    {
      this.a.a = ((PeerInfo)QFindGattManager.a(this.a).get(0));
      QFindGattManager.a(this.a).remove(0);
      QFindGattManager.a(this.a).a(this.a.a.a, this.a.a.b);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QFindGattManager.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */