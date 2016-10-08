import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.SensorHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hbs
  implements SensorEventListener
{
  float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean;
  float b;
  float c;
  
  public hbs(SensorHelper paramSensorHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1;
    float f2;
    float f3;
    int i;
    int k;
    int j;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      f1 = paramSensorEvent.values[0];
      f2 = paramSensorEvent.values[1];
      f3 = paramSensorEvent.values[2];
      if (this.jdField_a_of_type_Boolean) {
        break label455;
      }
      if ((Math.abs(this.jdField_a_of_type_Float - f1) <= 1.5D) && (Math.abs(this.b - f2) <= 1.5D) && (Math.abs(this.c - f3) <= 2.0F)) {
        break label338;
      }
      i = 1;
      if ((Math.abs(this.jdField_a_of_type_Float - f1) >= 0.5D) || (Math.abs(this.b - f2) >= 0.5D) || (Math.abs(this.c - f3) >= 0.5D)) {
        break label344;
      }
      k = 1;
      j = i;
      i = k;
    }
    for (;;)
    {
      label155:
      if (j != 0)
      {
        if ((this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a != null) && (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a.a() != null) && ((this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a.a().f == 3) || (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a.a().K))) {
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.d(true);
        }
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.h = false;
        label232:
        if (Math.abs(this.jdField_a_of_type_Float - f1) <= 0.5D) {
          break label411;
        }
        i = 1;
        label252:
        if (Math.abs(this.b - f2) <= 0.5D) {
          break label417;
        }
        j = 1;
        label272:
        if (Math.abs(this.c - f3) <= 0.5D) {
          break label423;
        }
        k = 1;
        label293:
        if ((i == 0) && (j == 0) && (k == 0)) {
          break label429;
        }
      }
      for (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.i = true;; this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.i = false) {
        label338:
        label344:
        label411:
        label417:
        label423:
        label429:
        do
        {
          this.jdField_a_of_type_Float = f1;
          this.b = f2;
          this.c = f3;
          this.jdField_a_of_type_Boolean = false;
          return;
          i = 0;
          break;
          j = i;
          i = 0;
          break label155;
          if ((i == 0) || (!this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.g)) {
            break label232;
          }
          if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c)
          {
            if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a == null) {
              break label232;
            }
            this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.d(false);
            break label232;
          }
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.h = true;
          break label232;
          i = 0;
          break label252;
          j = 0;
          break label272;
          k = 0;
          break label293;
        } while ((i != 0) || (j != 0) || (k != 0));
      }
      label455:
      i = 0;
      j = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */