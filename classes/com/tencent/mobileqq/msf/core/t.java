package com.tencent.mobileqq.msf.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class t
  implements SensorEventListener
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null) || (paramSensorEvent.values.length <= 0) || (paramSensorEvent.values[0] == 0.0F) || (paramSensorEvent.values[0] > o.T)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramSensorEvent.values[0] >= o.X) {
            break;
          }
          o.R += 1;
        } while (o.R <= 2);
        o.Y = o.X - o.W + o.Y;
        o.X = (int)paramSensorEvent.values[0];
        o.W = 1;
        o.H = (int)paramSensorEvent.values[0];
        QLog.i("health_manager", 1, "step counter exception reset: init = " + o.W + ",total = " + o.X + ",offset = " + o.Y);
        o.a(false, null, null);
        o.R = 0;
        o.I = System.currentTimeMillis();
        return;
        o.R = 0;
        if ((o.H == 0) || (paramSensorEvent.values[0] - o.H <= o.U)) {
          break;
        }
        o.S += 1;
      } while (o.S <= 4);
      if (o.X - o.W > 0) {}
      for (int i = o.X - o.W;; i = 0)
      {
        o.Y = i + o.Y;
        o.W = (int)paramSensorEvent.values[0] - 5;
        o.X = (int)paramSensorEvent.values[0];
        o.H = (int)paramSensorEvent.values[0];
        o.ae.set(true);
        QLog.i("health_manager", 1, "Jump CallBack reset init = " + o.W + ",total = " + o.X + ",offset = " + o.Y);
        o.a(false, null, null);
        o.S = 0;
        o.I = System.currentTimeMillis();
        return;
      }
      o.S = 0;
      if ((paramSensorEvent.values[0] - o.H > o.U) && (o.H == 0) && (o.W != 0))
      {
        QLog.i("health_manager", 1, "msf step counter restart!");
        if (o.X == 0) {}
        for (i = o.W;; i = o.X)
        {
          o.H = i;
          return;
        }
      }
      o.H = (int)paramSensorEvent.values[0];
    } while (System.currentTimeMillis() - o.I < 1200000L);
    o.I = System.currentTimeMillis();
    o.X = o.H;
    o.a(true, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */