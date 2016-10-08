package com.tencent.biz.game;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SensorAPIJavaScript$QQSensorEventListener
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public SensorAPIJavaScript$QQSensorEventListener(SensorAPIJavaScript paramSensorAPIJavaScript, byte paramByte, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (this.jdField_a_of_type_Byte)
    {
    default: 
      return;
    case 0: 
      f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1), String.valueOf(f2), String.valueOf(f3) });
      return;
    case 1: 
      f1 = paramSensorEvent.values[0];
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1) });
      return;
    }
    float f1 = paramSensorEvent.values[0];
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\game\SensorAPIJavaScript$QQSensorEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */