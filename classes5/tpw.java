import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.rn.NRNReportUtil.NRNReportAction;
import com.tencent.mobileqq.nearby.rn.NearbyReactBaseActivity;
import java.util.List;

public class tpw
  implements Runnable
{
  public tpw(NearbyReactBaseActivity paramNearbyReactBaseActivity, NRNReportUtil.NRNReportAction paramNRNReportAction)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.a;
    if ((localList != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction != null)) {
      localList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */