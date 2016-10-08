import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hbt
  implements SensorEventListener
{
  public hbt(SensorHelper paramSensorHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int k = 1;
    int m = 0;
    float f2 = paramSensorEvent.values[0];
    float f1 = 3.1F;
    if (this.a.b == null) {
      break label26;
    }
    label26:
    label108:
    label121:
    label179:
    label297:
    label303:
    label312:
    label321:
    label468:
    label472:
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        if (3.1F > this.a.b.getMaximumRange()) {
          f1 = this.a.b.getMaximumRange();
        }
        int i;
        boolean bool;
        if ((f2 >= 0.0D) && (f2 < f1) && (f2 < this.a.b.getMaximumRange()))
        {
          i = 1;
          paramSensorEvent = this.a;
          if (i != 0) {
            break label297;
          }
          bool = true;
          paramSensorEvent.g = bool;
          if ((i == 0) || (!this.a.i)) {
            break label321;
          }
          paramSensorEvent = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a;
          if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().H) {
            break label312;
          }
          if (paramSensorEvent == null) {
            break;
          }
          i = 0;
          if (i >= paramSensorEvent.length) {
            break label468;
          }
          j = m;
          if (!paramSensorEvent[i].equals("DEVICE_WIREDHEADSET")) {
            if (!paramSensorEvent[i].equals("DEVICE_BLUETOOTHHEADSET")) {
              break label303;
            }
          }
        }
        for (int j = m;; j = 1)
        {
          if ((j == 0) || (!this.a.e)) {
            break label472;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "setSensors pressHandFreeBtn");
          }
          if (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
            this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
          }
          this.a.jdField_a_of_type_Boolean = true;
          DataReport.n(this.a.jdField_a_of_type_ComTencentAvVideoController);
          return;
          i = 0;
          break label108;
          bool = false;
          break label121;
          i += 1;
          break label179;
          this.a.jdField_a_of_type_Boolean = false;
          return;
          if (!this.a.jdField_a_of_type_Boolean) {
            break;
          }
          if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {}
          for (paramSensorEvent = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a;; paramSensorEvent = null)
          {
            if (paramSensorEvent != null) {
              i = 0;
            }
            for (;;)
            {
              j = k;
              if (i < paramSensorEvent.length)
              {
                if ((paramSensorEvent[i].equals("DEVICE_WIREDHEADSET")) || (paramSensorEvent[i].equals("DEVICE_BLUETOOTHHEADSET"))) {
                  j = 0;
                }
              }
              else
              {
                if ((j != 0) && (this.a.e))
                {
                  if (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
                    this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
                  }
                  DataReport.n(this.a.jdField_a_of_type_ComTencentAvVideoController);
                }
                this.a.jdField_a_of_type_Boolean = false;
                return;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */