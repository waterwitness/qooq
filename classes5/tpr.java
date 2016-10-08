import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.rn.NearbyReactBaseActivity;

public class tpr
  implements Runnable
{
  public tpr(NearbyReactBaseActivity paramNearbyReactBaseActivity, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.invokeDefaultOnBackPressed();
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.overridePendingTransition(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */