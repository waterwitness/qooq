import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qvb
  implements Runnable
{
  public qvb(BusinessCardEditActivity paramBusinessCardEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.d(this.a.k);
    if (this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
      this.a.runOnUiThread(new qvc(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */