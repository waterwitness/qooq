import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;

public class veo
  implements Runnable
{
  public veo(NearbyTroopsActivity paramNearbyTroopsActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.j);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.j == 0)
    {
      NearbyTroopsBaseView localNearbyTroopsBaseView = NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.j);
      if ((localNearbyTroopsBaseView != null) && ((localNearbyTroopsBaseView instanceof NearbyTroopsView))) {
        ((NearbyTroopsView)localNearbyTroopsBaseView).setHasHotTroopRedDot(this.jdField_a_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.stopTitleProgress();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\veo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */