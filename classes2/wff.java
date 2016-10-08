import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;

public class wff
  implements SensorEventListener
{
  public wff(HealthStepCounterPlugin paramHealthStepCounterPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    this.a.g = ("Current step data:" + String.valueOf(paramSensorEvent.values[0]));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */