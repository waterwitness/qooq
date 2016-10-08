package com.tencent.mobileqq.app;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ShakeListener
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private float jdField_b_of_type_Float;
  protected int b;
  private long jdField_b_of_type_Long;
  private float jdField_c_of_type_Float;
  private long jdField_c_of_type_Long;
  private float jdField_d_of_type_Float;
  private long jdField_d_of_type_Long;
  private float e;
  
  public ShakeListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 100;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {}
  
  public void b()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.e = 0.0F;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1;
    float f2;
    float f3;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      f1 = paramSensorEvent.values[0];
      f2 = paramSensorEvent.values[1];
      f3 = paramSensorEvent.values[2];
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      float f4 = (float)(this.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long > 100L)
      {
        this.jdField_c_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
        if ((this.jdField_a_of_type_Float != 0.0F) || (this.jdField_b_of_type_Float != 0.0F) || (this.jdField_c_of_type_Float != 0.0F)) {
          break label228;
        }
        this.jdField_d_of_type_Long = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      this.e += this.jdField_d_of_type_Float;
      if (this.jdField_a_of_type_Int > 10)
      {
        b();
        this.jdField_a_of_type_Int = 0;
      }
      a(f1, f2, f3, (int)this.e);
      if ((this.e > this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Int >= 3))
      {
        a();
        this.jdField_a_of_type_Int = 0;
        b();
      }
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f3;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      return;
      label228:
      this.jdField_d_of_type_Float = (Math.abs(f1 - this.jdField_a_of_type_Float) + Math.abs(f2 - this.jdField_b_of_type_Float) + Math.abs(f3 - this.jdField_c_of_type_Float));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ShakeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */