import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.ProfilePerformanceReport;

public class lll
  implements OnDrawCompleteListener
{
  public lll(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.a;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.b()))
    {
      if (!localProfilePerformanceReport.b(1)) {
        localProfilePerformanceReport.b(1);
      }
      if ((!localProfilePerformanceReport.b(8)) && (localProfilePerformanceReport.b(5)) && (localProfilePerformanceReport.b(7))) {
        localProfilePerformanceReport.b(8);
      }
      if ((!localProfilePerformanceReport.b(9)) && (localProfilePerformanceReport.b(6)) && (localProfilePerformanceReport.b(7))) {
        localProfilePerformanceReport.b(9);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */