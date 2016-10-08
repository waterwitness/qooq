import android.os.Handler;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hbe
  implements Runnable
{
  public hbe(PhoneStatusMonitor paramPhoneStatusMonitor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable run");
    }
    if ((this.a.jdField_a_of_type_AndroidContentContext != null) && (!PhoneStatusTools.e(this.a.jdField_a_of_type_AndroidContentContext)) && (this.a.jdField_a_of_type_AndroidOsHandler != null)) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new hbf(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\hbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */