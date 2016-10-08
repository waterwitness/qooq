import com.tencent.mobileqq.dating.DateEventManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rcv
  implements Runnable
{
  public rcv(DateEventManager paramDateEventManager, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      DateEventManager.a(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager, null, DateEventManager.a(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */