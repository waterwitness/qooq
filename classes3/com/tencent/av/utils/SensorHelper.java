package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.av.VideoController;
import com.tencent.av.service.UtilsServiceForAV;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hbs;
import hbt;
import hbu;
import mqq.util.WeakReference;

public class SensorHelper
{
  Sensor jdField_a_of_type_AndroidHardwareSensor;
  SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener;
  SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  public VideoController a;
  public TraeHelper a;
  hbu jdField_a_of_type_Hbu;
  public String a;
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  public Sensor b;
  SensorEventListener jdField_b_of_type_AndroidHardwareSensorEventListener;
  boolean jdField_b_of_type_Boolean;
  public boolean c;
  boolean d;
  public boolean e;
  boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  
  public SensorHelper(Activity paramActivity, VideoController paramVideoController, TraeHelper paramTraeHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "SensorHelper";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = null;
    this.jdField_a_of_type_AndroidHardwareSensor = null;
    this.jdField_b_of_type_AndroidHardwareSensorEventListener = null;
    this.jdField_b_of_type_AndroidHardwareSensor = null;
    this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Hbu = null;
    this.c = true;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = true;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = paramTraeHelper;
    a();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      Context localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((localContext != null) && (this.jdField_a_of_type_AndroidHardwareSensorManager == null)) {
        this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)localContext.getSystemService("sensor"));
      }
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
        this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
      }
      if (this.jdField_b_of_type_AndroidHardwareSensor == null) {
        this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
      }
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorEventListener == null) {
      this.jdField_a_of_type_AndroidHardwareSensorEventListener = new hbs(this);
    }
    if (this.jdField_b_of_type_AndroidHardwareSensorEventListener == null) {
      this.jdField_b_of_type_AndroidHardwareSensorEventListener = new hbt(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startSensor " + paramBoolean);
    }
    if ((this.jdField_a_of_type_AndroidHardwareSensorEventListener == null) || (this.jdField_b_of_type_AndroidHardwareSensorEventListener == null)) {}
    IntentFilter localIntentFilter;
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, 3);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_b_of_type_AndroidHardwareSensorEventListener, this.jdField_b_of_type_AndroidHardwareSensor, 3);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      if (this.jdField_a_of_type_Hbu == null) {
        this.jdField_a_of_type_Hbu = new hbu(this);
      }
    } while ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (this.jdField_a_of_type_Hbu == null));
    ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).registerReceiver(this.jdField_a_of_type_Hbu, localIntentFilter);
    return;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_b_of_type_AndroidHardwareSensorEventListener);
      d(false);
      b(false);
      b(false);
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (this.jdField_a_of_type_Hbu != null)) {
        ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_Hbu);
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  boolean a()
  {
    String str1 = Build.MODEL;
    String str2 = Build.MANUFACTURER;
    return ((str2.equalsIgnoreCase("samsung")) && (str1.equalsIgnoreCase("GT-I9200"))) || ((str2.equalsIgnoreCase("samsung")) && (str1.equalsIgnoreCase("GT-I8262D"))) || ((str2.equalsIgnoreCase("samsung")) && (str1.equalsIgnoreCase("SM-N9008")));
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.d = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      this.e = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (paramBoolean != this.f)
        {
          boolean bool = this.d;
          if ((bool) || (!paramBoolean)) {}
        }
        else
        {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "toggleProximityWakeLock: " + paramBoolean);
        }
        if ((a()) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null)) {
          continue;
        }
        Intent localIntent1 = new Intent(this.jdField_a_of_type_ComTencentAvVideoController.a(), UtilsServiceForAV.class);
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().startService(localIntent1);
          this.f = true;
          continue;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().stopService(localIntent2);
      }
      finally {}
      this.f = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\SensorHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */