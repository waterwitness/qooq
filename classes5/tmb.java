import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.util.ProfilePerformanceReport;

public class tmb
  implements OnDrawCompleteListener
{
  public tmb(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.b;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.b()))
    {
      if (!localProfilePerformanceReport.b(1)) {
        localProfilePerformanceReport.b(1);
      }
      if ((!localProfilePerformanceReport.b(8)) && (localProfilePerformanceReport.b(5))) {
        localProfilePerformanceReport.b(8);
      }
      if ((!localProfilePerformanceReport.b(9)) && (localProfilePerformanceReport.b(6))) {
        localProfilePerformanceReport.b(9);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */