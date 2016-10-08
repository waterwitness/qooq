import com.tencent.av.VideoController;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gez
  implements Runnable
{
  public gez(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = new gfm(this.a);
    this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor = new PhoneStatusMonitor(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */