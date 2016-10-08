package com.tencent.av.ui;

import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gxx;
import gxy;
import java.lang.ref.WeakReference;

public class PstnCallbackWaitingUi
{
  static final String jdField_a_of_type_JavaLangString = "PstnCallbackWaitingUi";
  static final String b = "03162412023";
  public Handler a;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener;
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  public VideoController a;
  public VideoAppInterface a;
  BaseCallbackUI jdField_a_of_type_ComTencentAvUiBaseCallbackUI;
  public Runnable a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public PstnCallbackWaitingUi(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_JavaLangRunnable = new gxx(this);
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new gxy(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramAVActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)paramAVActivity.getSystemService("phone"));
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 32);
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI = new BaseCallbackUI(paramAVActivity, 1002);
  }
  
  public void a() {}
  
  public void b()
  {
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    if ((this.jdField_a_of_type_JavaLangRunnable == null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI != null) {
      this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a.setVisibility(0);
    }
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165194, 1, null);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a();
    }
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\PstnCallbackWaitingUi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */