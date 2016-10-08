import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class lwb
  implements Runnable
{
  public lwb(NearbyActivity paramNearbyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b.a(this.a.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.a.b.a(this.a.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = ((FreshNewsManager)this.a.b.getManager(211));
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$NotifyListener);
    this.a.b.c();
    NearbyHandler localNearbyHandler = (NearbyHandler)this.a.b.a(3);
    localNearbyHandler.a(this.a.b.a());
    localNearbyHandler.b(2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lwb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */