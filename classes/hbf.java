import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class hbf
  implements Runnable
{
  hbf(hbe paramhbe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable run end  mIsCalling: " + this.a.a.jdField_a_of_type_Boolean);
    }
    this.a.a.jdField_a_of_type_Boolean = false;
    if (this.a.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener != null) {
      this.a.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\hbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */