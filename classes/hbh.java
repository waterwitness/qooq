import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hbh
  implements Runnable
{
  hbh(hbg paramhbg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = PhoneStatusTools.e(this.a.a.jdField_a_of_type_AndroidContentContext);
    if ((this.a.a.jdField_a_of_type_Boolean) && (!bool))
    {
      this.a.a.jdField_a_of_type_Boolean = false;
      if (this.a.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener != null) {
        this.a.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(false);
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.a.a.jdField_a_of_type_Boolean) || (!bool));
      this.a.a.jdField_a_of_type_Boolean = true;
    } while (this.a.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener == null);
    this.a.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\hbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */