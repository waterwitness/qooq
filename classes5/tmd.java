import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.util.ProfilePerformanceReport;

public class tmd
  extends Handler
{
  public tmd(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1001: 
    case 101: 
    case 100: 
      do
      {
        do
        {
          return;
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a();
          return;
          this.a.a();
          ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.b;
          if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.b())) {
            localProfilePerformanceReport.b(5);
          }
        } while (paramMessage.obj == null);
        paramMessage = (NearbyPeopleCard)paramMessage.obj;
        this.a.jdField_a_of_type_Boolean = true;
        NearbyPeopleProfileActivity.a(this.a, paramMessage, true, false);
        return;
      } while (NearbyPeopleProfileActivity.a(this.a) == null);
      NearbyPeopleProfileActivity.a(this.a).b();
      return;
    case 102: 
      NearbyPeopleProfileActivity.a(this.a).a(paramMessage.arg1, paramMessage.arg2);
      return;
    case 202: 
      NearbyPeopleProfileActivity.a(this.a).c(true);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(203, 1500L);
      return;
    case 203: 
      NearbyPeopleProfileActivity.a(this.a).c(false);
      return;
    case 204: 
      this.a.a(this.a.getString(2131371605));
      return;
    case 207: 
      this.a.a("正在加载...");
      return;
    }
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */