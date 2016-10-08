package com.tencent.mobileqq.vashealth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import wfh;
import wfi;

public class StepAlarmReceiver
  extends BroadcastReceiver
{
  public static final String a = "StepAlarmReceiver_action_report";
  public static final String b = "StepAlarmReceiver_long_time_report";
  public static String c;
  private static final String d = "StepAlarmReceiver";
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  public StepAlarmReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 7200000L;
    this.jdField_b_of_type_Long = 600000L;
    this.jdField_a_of_type_Int = 1000;
    this.jdField_b_of_type_Int = 200;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (SensorManager)paramContext.getSystemService("sensor");
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      do
      {
        return;
      } while (paramContext.getDefaultSensor(19) == null);
      if (paramIntent.getAction().equals("StepAlarmReceiver_action_report"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("StepAlarmReceiver", 2, "StepAlarmReceiver_action_report!");
        }
        ThreadManager.a(new wfh(this), 5, null, true);
        return;
      }
    } while (!paramIntent.getAction().equals("StepAlarmReceiver_long_time_report"));
    if (QLog.isColorLevel()) {
      QLog.i("StepAlarmReceiver", 2, "StepAlarmReceiver_long_time_report!");
    }
    ThreadManager.a(new wfi(this), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vashealth\StepAlarmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */