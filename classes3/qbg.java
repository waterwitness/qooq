import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;

public class qbg
  implements Runnable
{
  public qbg(NearbyFlowerManager paramNearbyFlowerManager, NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController$OnCleanAnimationListener = this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController$OnCleanAnimationListener;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */