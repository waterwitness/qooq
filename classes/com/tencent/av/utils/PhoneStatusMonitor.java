package com.tencent.av.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hbe;
import hbg;
import hbi;

public class PhoneStatusMonitor
{
  static final String jdField_a_of_type_JavaLangString = "PhoneStatusMonitor";
  public Context a;
  public Handler a;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener;
  public PhoneStatusMonitor.PhoneStatusListener a;
  hbg jdField_a_of_type_Hbg;
  public Runnable a;
  public boolean a;
  
  public PhoneStatusMonitor(Context paramContext, PhoneStatusMonitor.PhoneStatusListener paramPhoneStatusListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaLangRunnable = new hbe(this);
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Begin");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = paramPhoneStatusListener;
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new hbi(this);
    this.jdField_a_of_type_Hbg = new hbg(this);
    PhoneStatusTools.a(paramContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 32);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Step1,time=" + (SystemClock.elapsedRealtime() - l));
    }
    paramPhoneStatusListener = new IntentFilter();
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_EXT");
    paramPhoneStatusListener.addAction("android.intent.action.NEW_OUTGOING_CALL");
    paramContext.registerReceiver(this.jdField_a_of_type_Hbg, paramPhoneStatusListener);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor End,time=" + (SystemClock.elapsedRealtime() - l));
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void finalize()
  {
    PhoneStatusTools.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Hbg);
    this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = null;
    this.jdField_a_of_type_Hbg = null;
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    super.finalize();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\av\utils\PhoneStatusMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */