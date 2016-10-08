import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.struct.AdData;

public class poy
  implements Runnable
{
  public poy(PeopleAroundAdapter paramPeopleAroundAdapter, int paramInt, AdData paramAdData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AdData.reportTValue(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqStructAdData.ad_source, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\poy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */