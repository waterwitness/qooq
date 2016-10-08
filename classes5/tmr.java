import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class tmr
  implements Runnable
{
  public tmr(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app, "CliOper", "", "", NearbyProfileDisplayPanel.b[(this.jdField_a_of_type_Int - 1)], NearbyProfileDisplayPanel.b[(this.jdField_a_of_type_Int - 1)], 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app, "dc00898", "", "", "0X800698A", "0X800698A", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */