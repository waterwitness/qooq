import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.rn.NRNReportUtil;
import com.tencent.mobileqq.nearby.rn.NRNReportUtil.NRNReportAction;
import com.tencent.mobileqq.nearby.rn.NearbyReactBaseActivity;
import java.util.List;

public class tpt
  implements Runnable
{
  public tpt(NearbyReactBaseActivity paramNearbyReactBaseActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.g(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.h("onPageToShow");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.d;
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.d = null;
    if (localObject != null)
    {
      ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Long = Math.abs(localObject.jdField_a_of_type_ArrayOfLong[6] - ((NRNReportUtil.NRNReportAction)localObject).b);
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.a.add(localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.a;
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.a = null;
    if (localObject != null) {
      NRNReportUtil.a((List)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */