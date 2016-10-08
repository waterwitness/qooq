import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ghr
  implements Runnable
{
  public ghr(AVNotifyCenter paramAVNotifyCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor = new PhoneStatusMonitor(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ghr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */