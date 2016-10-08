import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.mobileqq.utils.QQLSSensor.ProximitySensorChangeListener;
import com.tencent.qphone.base.util.QLog;

public class wcw
  implements SensorEventListener
{
  public wcw(QQLSSensor paramQQLSSensor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + paramSensorEvent.values[0]);
    }
    if (QQLSSensor.a(this.a) == null) {}
    do
    {
      return;
      if (AIOUtils.b())
      {
        this.a.a = false;
        return;
      }
      if (paramSensorEvent.values[0] < QQLSSensor.a(this.a)) {
        QQLSSensor.a(this.a, true);
      }
      for (;;)
      {
        paramSensorEvent = Build.MODEL;
        if (!AIOUtils.a()) {
          break;
        }
        if (QQLSSensor.a(this.a).hasMessages(1)) {
          QQLSSensor.a(this.a).removeMessages(1);
        }
        QQLSSensor.a(this.a).sendMessageDelayed(QQLSSensor.a(this.a).obtainMessage(1), 150L);
        return;
        QQLSSensor.a(this.a, false);
      }
      if ((paramSensorEvent.equalsIgnoreCase("mi 3c")) || (paramSensorEvent.equalsIgnoreCase("K-Touch W619")) || (paramSensorEvent.equalsIgnoreCase("mi 3w")))
      {
        if (QQLSSensor.a(this.a).hasMessages(1)) {
          QQLSSensor.a(this.a).removeMessages(1);
        }
        QQLSSensor.a(this.a).sendMessageDelayed(QQLSSensor.a(this.a).obtainMessage(1), 250L);
        return;
      }
    } while (QQLSSensor.a(this.a) == null);
    QQLSSensor.a(this.a).a(QQLSSensor.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */