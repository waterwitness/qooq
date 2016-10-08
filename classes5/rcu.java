import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.LinkedList;

public class rcu
  implements Runnable
{
  public rcu(CarrierHelper paramCarrierHelper, LinkedList paramLinkedList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper)) || (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (5 == localInteger.intValue()) {
        ReportController.b(CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper), "CliOper", "", "", "0X80052A4", "0X80052A4", CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper), 0, "", "", "", "");
      } else if ((CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper) == 2) || (CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper) == 1)) {
        ReportController.b(CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper), "CliOper", "", "", "0X80050D0", "0X80050D0", CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper), 0, String.valueOf(localInteger), "", "", "");
      }
    }
    CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */