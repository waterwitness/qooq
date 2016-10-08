package com.tencent.mobileqq.vashealth;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import wfj;

public class StepServiceAsync
  extends AsyncStep
{
  static AlarmManager jdField_a_of_type_AndroidAppAlarmManager;
  static PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  public static final long c = 86399000L;
  private static final String c = "StepServiceAsync";
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  
  public StepServiceAsync()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new wfj(this);
  }
  
  public static void c()
  {
    if ((jdField_a_of_type_AndroidAppAlarmManager != null) && (jdField_a_of_type_AndroidAppPendingIntent != null))
    {
      jdField_a_of_type_AndroidAppAlarmManager.cancel(jdField_a_of_type_AndroidAppPendingIntent);
      jdField_a_of_type_AndroidAppAlarmManager = null;
      jdField_a_of_type_AndroidAppPendingIntent = null;
    }
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StepServiceAsync", 2, "StepServiceAsync call!");
    }
    if (Build.VERSION.SDK_INT < 19) {
      return super.a();
    }
    Object localObject1 = BaseApplicationImpl.a().getApplicationContext();
    if (((SensorManager)((Context)localObject1).getSystemService("sensor")).getDefaultSensor(19) == null)
    {
      QLog.i("StepServiceAsync", 1, "step counter unsupported model.");
      return super.a();
    }
    Object localObject2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.health_ban.name(), "");
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (Integer.parseInt((String)localObject2) == 0))
    {
      localObject1 = new NewIntent((Context)localObject1, StepCounterServlert.class);
      ((NewIntent)localObject1).putExtra("msf_cmd_type", "cmd_health_switch");
      ((NewIntent)localObject1).putExtra("isOpen", false);
      BaseApplicationImpl.a().a().startServlet((NewIntent)localObject1);
      QLog.e("StepServiceAsync", 1, "step counter found current model banned!");
      return super.a();
    }
    localObject2 = new NewIntent((Context)localObject1, StepCounterServlert.class);
    ((NewIntent)localObject2).putExtra("msf_cmd_type", "cmd_refresh_steps");
    ((NewIntent)localObject2).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    BaseApplicationImpl.a().a().startServlet((NewIntent)localObject2);
    localObject2 = new StepAlarmReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("StepAlarmReceiver_action_report");
    localIntentFilter.addAction("StepAlarmReceiver_long_time_report");
    ((Context)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
    localObject2 = new Intent("StepAlarmReceiver_action_report");
    if (jdField_a_of_type_AndroidAppPendingIntent == null) {
      jdField_a_of_type_AndroidAppPendingIntent = PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 0);
    }
    if (jdField_a_of_type_AndroidAppAlarmManager == null) {
      jdField_a_of_type_AndroidAppAlarmManager = (AlarmManager)((Context)localObject1).getSystemService("alarm");
    }
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(11, 20);
    ((Calendar)localObject1).set(12, 20);
    ((Calendar)localObject1).set(13, 0);
    int i = new Random().nextInt(3600) + 1;
    if (QLog.isColorLevel()) {
      QLog.i("StepAlarmReceiver", 2, "random int = " + i);
    }
    long l = ((Calendar)localObject1).getTimeInMillis();
    l = i * 1000 + l;
    if (System.currentTimeMillis() - l < 0L) {
      jdField_a_of_type_AndroidAppAlarmManager.set(1, l, jdField_a_of_type_AndroidAppPendingIntent);
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vashealth\StepServiceAsync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */