import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.NearbyFlowerManager.NearbyFlowerListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;

public class qbe
  implements Runnable
{
  public qbe(NearbyFlowerManager paramNearbyFlowerManager, NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager.a.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */