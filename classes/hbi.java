import android.telephony.PhoneStateListener;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hbi
  extends PhoneStateListener
{
  public hbi(PhoneStatusMonitor paramPhoneStatusMonitor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged CALL_STATE_IDLE  mIsCalling:  " + this.a.jdField_a_of_type_Boolean);
      }
      if (this.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable mIsCalling: " + this.a.jdField_a_of_type_Boolean);
        }
        ThreadManager.a(this.a.jdField_a_of_type_JavaLangRunnable, 8, null, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged CALL_STATE_RINGING or CALL_STATE_OFFHOOK");
        }
        if (!this.a.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_Boolean = true;
          if (this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener != null) {
            this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(true);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\hbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */