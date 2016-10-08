import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jjl
  implements SensorEventListener
{
  private WeakReference a;
  
  public jjl(ScannerView paramScannerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramScannerView);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    ScannerView localScannerView = (ScannerView)this.a.get();
    if (localScannerView != null) {
      localScannerView.a(paramSensorEvent);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(ScannerView.a, 2, "onSensorChanged but mRef got null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */